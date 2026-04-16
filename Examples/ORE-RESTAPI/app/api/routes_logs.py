import logging

from fastapi import APIRouter, Depends
from fastapi.responses import PlainTextResponse
from sqlalchemy.orm import Session

from app.database import get_db
from app.schemas.job import ErrorResponse
from app.services.job_service import JobNotFoundError, JobService
from app.services.storage_service import storage_service

logger = logging.getLogger(__name__)
router = APIRouter()


@router.get(
    "/jobs/{job_id}/logs",
    response_class=PlainTextResponse,
    responses={404: {"model": ErrorResponse}},
)
async def get_logs(
    job_id: str,
    db: Session = Depends(get_db),
):
    """Get ORE execution logs for a job."""
    # Verify job exists
    service = JobService(db)
    service.get_job(job_id)

    log_content = storage_service.read_log(job_id)
    return PlainTextResponse(content=log_content, media_type="text/plain")
