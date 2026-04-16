import json
import logging
import subprocess
from pathlib import Path

from app.config import settings
from app.database import SessionLocal
from app.services.result_parser import ResultParser
from app.services.storage_service import StorageService

logger = logging.getLogger(__name__)


def execute_ore_job(job_id: str) -> None:
    """Execute an ORE job as a subprocess.

    This function is designed to be called by RQ worker or synchronously.
    """
    db = SessionLocal()
    storage = StorageService()
    parser = ResultParser()

    try:
        from app.models.job import Job

        job = db.query(Job).filter(Job.id == job_id).first()
        if not job:
            logger.error("Job %s not found", job_id)
            return

        # Update status to running
        job.status = "running"
        job.progress = 10
        db.commit()

        input_dir = storage.get_job_input_dir(job_id)
        output_dir = storage.get_job_output_dir(job_id)
        ore_exe = str(_resolve_ore_exe())

        ore_xml_path = input_dir / "ore.xml"
        if not ore_xml_path.exists():
            raise FileNotFoundError(f"ore.xml not found in {input_dir}")

        logger.info("Starting ORE execution for job %s", job_id)

        # Execute ORE subprocess
        result = subprocess.run(
            [ore_exe, "ore.xml"],
            cwd=str(input_dir),
            capture_output=True,
            text=True,
            timeout=settings.ORE_TIMEOUT_SECONDS,
        )

        # Capture log output
        log_content = result.stdout
        if result.stderr:
            log_content += "\n" + result.stderr

        # Save log to output directory
        log_path = output_dir / "log.txt"
        log_path.parent.mkdir(parents=True, exist_ok=True)
        log_path.write_text(log_content, encoding="utf-8")

        # Check exit code
        if result.returncode != 0:
            error_msg = log_content.strip() or f"ORE exited with code {result.returncode}"
            job.status = "failed"
            job.error_message = error_msg[-2000:]  # Truncate long errors
            job.progress = 0
            logger.error("ORE execution failed for job %s: %s", job_id, error_msg[:200])
            db.commit()
            return

        # Parse results
        summary = parser.parse_summary(output_dir, job.job_type)
        output_files = storage.get_output_files(job_id)

        job.status = "completed"
        job.progress = 100
        job.result_json = json.dumps({
            "summary": summary,
            "files": output_files,
        })
        logger.info("Job %s completed. Output files: %s", job_id, output_files)
        db.commit()

    except subprocess.TimeoutExpired:
        _fail_job(db, job_id, f"ORE execution timed out after {settings.ORE_TIMEOUT_SECONDS}s")
        logger.error("ORE execution timed out for job %s", job_id)

    except Exception as e:
        _fail_job(db, job_id, str(e))
        logger.exception("Unexpected error executing job %s", job_id)

    finally:
        db.close()


def _resolve_ore_exe() -> Path:
    """Resolve the ORE executable path."""
    from app.config import resolve_ore_path
    return resolve_ore_path()


def _fail_job(db, job_id: str, error_message: str) -> None:
    """Mark a job as failed."""
    from app.models.job import Job

    job = db.query(Job).filter(Job.id == job_id).first()
    if job:
        job.status = "failed"
        job.error_message = error_message[-2000:]
        job.progress = 0
        db.commit()
