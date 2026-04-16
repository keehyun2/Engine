import logging
from pathlib import Path

from app.config import settings

logger = logging.getLogger(__name__)


class StorageService:
    """Manages per-job directory structure and file access."""

    def __init__(self):
        self.jobs_base_dir = Path(settings.JOBS_BASE_DIR)

    def create_job_dirs(self, job_id: str) -> tuple[Path, Path]:
        """Create jobs/{job_id}/input and jobs/{job_id}/output directories."""
        input_dir = self.jobs_base_dir / job_id / "input"
        output_dir = self.jobs_base_dir / job_id / "output"
        input_dir.mkdir(parents=True, exist_ok=True)
        output_dir.mkdir(parents=True, exist_ok=True)
        logger.info("Created job directories: %s", job_id)
        return input_dir, output_dir

    def get_job_input_dir(self, job_id: str) -> Path:
        return self.jobs_base_dir / job_id / "input"

    def get_job_output_dir(self, job_id: str) -> Path:
        return self.jobs_base_dir / job_id / "output"

    def get_output_files(self, job_id: str) -> list[str]:
        """List all files in the output directory."""
        output_dir = self.get_job_output_dir(job_id)
        if not output_dir.exists():
            return []
        return [f.name for f in output_dir.iterdir() if f.is_file()]

    def get_file_path(self, job_id: str, filename: str) -> Path:
        """Get validated file path for a job output file.

        Raises ValueError if path traversal is detected.
        """
        self._validate_filename(filename)

        # Check input directory first, then output
        for base in ["output", "input"]:
            path = self.jobs_base_dir / job_id / base / filename
            resolved = path.resolve()
            job_dir = (self.jobs_base_dir / job_id / base).resolve()
            if not str(resolved).startswith(str(job_dir)):
                raise ValueError(f"Path traversal detected: {filename}")
            if path.exists():
                return path

        raise FileNotFoundError(f"File not found: {filename}")

    def read_log(self, job_id: str) -> str:
        """Read the ORE log file."""
        # Check output dir first, then input dir
        for base in ["output", "input"]:
            log_path = self.jobs_base_dir / job_id / base / "log.txt"
            if log_path.exists():
                return log_path.read_text(encoding="utf-8", errors="replace")
        return ""

    def _validate_filename(self, filename: str) -> None:
        """Prevent path traversal attacks."""
        if not filename:
            raise ValueError("Filename cannot be empty")
        if ".." in filename:
            raise ValueError(f"Path traversal detected: {filename}")
        if "/" in filename or "\\" in filename:
            raise ValueError(f"Invalid filename (contains path separator): {filename}")
        if Path(filename).is_absolute():
            raise ValueError(f"Absolute paths not allowed: {filename}")


storage_service = StorageService()
