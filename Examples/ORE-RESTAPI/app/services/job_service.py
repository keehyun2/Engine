import json
import logging
from typing import Optional

from sqlalchemy.orm import Session

from app.config import settings
from app.models.job import Job
from app.schemas.job import (
    JobCreateRequest,
    JobCreateResponse,
    JobResponse,
    JobResultResponse,
    OREInputs,
)
from app.services.storage_service import storage_service
from app.services.template_service import template_service

logger = logging.getLogger(__name__)


class JobNotFoundError(Exception):
    pass


class JobService:
    """Business logic for ORE job management."""

    def __init__(self, db: Session):
        self.db = db

    def create_job(self, request: JobCreateRequest) -> JobCreateResponse:
        """Create and enqueue a new ORE job."""
        # Validate template exists
        available = template_service.list_templates()
        if request.template not in available:
            raise ValueError(
                f"Template '{request.template}' not found. Available: {available}"
            )

        # Create job record
        job = Job(
            job_type=request.jobType,
            template=request.template,
            status="queued",
            progress=0,
            request_json=request.model_dump_json(),
        )
        self.db.add(job)
        self.db.commit()
        self.db.refresh(job)

        job_id = job.id
        logger.info("Created job %s (type=%s, template=%s)", job_id, request.jobType, request.template)

        try:
            # Create directories
            input_dir, output_dir = storage_service.create_job_dirs(job_id)

            # Render ORE input files
            template_service.render_job_inputs(
                template_name=request.template,
                inputs=request.inputs,
                job_input_dir=input_dir,
                job_output_dir=output_dir,
            )

            # Enqueue or run synchronously
            if settings.DEV_MODE:
                logger.info("DEV_MODE: running job %s synchronously", job_id)
                from app.workers.ore_worker import execute_ore_job

                execute_ore_job(job_id)
            else:
                self._enqueue_job(job_id)

        except Exception as e:
            # Mark job as failed if setup fails
            job.status = "failed"
            job.error_message = str(e)[:2000]
            self.db.commit()
            raise

        return JobCreateResponse(jobId=job.id, status=job.status)

    def get_job(self, job_id: str) -> JobResponse:
        """Get job status."""
        job = self._find_job(job_id)
        return JobResponse(
            jobId=job.id,
            status=job.status,
            progress=job.progress,
            template=job.template,
            jobType=job.job_type,
            createdAt=job.created_at,
            updatedAt=job.updated_at,
        )

    def get_job_result(self, job_id: str) -> JobResultResponse:
        """Get job result with summary and file list."""
        job = self._find_job(job_id)

        summary = None
        files = []

        if job.result_json:
            try:
                result = json.loads(job.result_json)
                summary = result.get("summary")
                files = result.get("files", [])
            except json.JSONDecodeError:
                logger.warning("Invalid result_json for job %s", job_id)

        if job.status == "completed" and not files:
            files = storage_service.get_output_files(job_id)

        return JobResultResponse(
            jobId=job.id,
            status=job.status,
            summary=summary,
            files=files,
        )

    def cancel_job(self, job_id: str) -> JobResponse:
        """Cancel a queued job."""
        job = self._find_job(job_id)
        if job.status not in ("queued",):
            raise ValueError(f"Cannot cancel job with status '{job.status}'")
        job.status = "cancelled"
        self.db.commit()
        self.db.refresh(job)
        return JobResponse(
            jobId=job.id,
            status=job.status,
            progress=job.progress,
            template=job.template,
            jobType=job.job_type,
            createdAt=job.created_at,
            updatedAt=job.updated_at,
        )

    def _find_job(self, job_id: str) -> Job:
        """Find a job or raise JobNotFoundError."""
        job = self.db.query(Job).filter(Job.id == job_id).first()
        if not job:
            raise JobNotFoundError(f"Job not found: {job_id}")
        return job

    def _enqueue_job(self, job_id: str) -> None:
        """Enqueue job to RQ."""
        import redis
        from rq import Queue

        conn = redis.from_url(settings.REDIS_URL)
        q = Queue("ore_jobs", connection=conn)
        from app.workers.ore_worker import execute_ore_job

        q.enqueue(execute_ore_job, job_id)
        logger.info("Enqueued job %s to RQ", job_id)
