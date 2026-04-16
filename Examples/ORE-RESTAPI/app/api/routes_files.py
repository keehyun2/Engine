import logging

from fastapi import APIRouter, Depends
from fastapi.responses import FileResponse
from sqlalchemy.orm import Session

from app.database import get_db
from app.schemas.job import ErrorResponse
from app.services.job_service import JobNotFoundError, JobService
from app.services.storage_service import storage_service

logger = logging.getLogger(__name__)
router = APIRouter()


@router.get(
    "/jobs/{job_id}/files/{filename}",
    responses={
        200: {"content": {"application/octet-stream": {}}},
        404: {"model": ErrorResponse},
    },
)
async def download_file(
    job_id: str,
    filename: str,
    db: Session = Depends(get_db),
):
    """Download an output file from a completed job."""
    # Verify job exists
    service = JobService(db)
    service.get_job(job_id)

    try:
        file_path = storage_service.get_file_path(job_id, filename)
    except ValueError as e:
        from fastapi import HTTPException
        raise HTTPException(status_code=400, detail={"error": {"code": "PATH_TRAVERSAL", "message": str(e)}})
    except FileNotFoundError as e:
        from fastapi import HTTPException
        raise HTTPException(status_code=404, detail={"error": {"code": "FILE_NOT_FOUND", "message": str(e)}})

    # Determine media type
    media_type = "text/csv" if filename.endswith(".csv") else "application/octet-stream"
    if filename.endswith(".txt") or filename.endswith(".log"):
        media_type = "text/plain"

    return FileResponse(
        path=str(file_path),
        filename=filename,
        media_type=media_type,
    )
