import logging

from fastapi import APIRouter, Depends
from sqlalchemy.orm import Session

from app.database import get_db
from app.schemas.job import (
    ErrorResponse,
    JobCreateRequest,
    JobCreateResponse,
    JobResponse,
    JobResultResponse,
)
from app.services.job_service import JobNotFoundError, JobService

logger = logging.getLogger(__name__)
router = APIRouter()


@router.post(
    "/jobs",
    response_model=JobCreateResponse,
    status_code=201,
    responses={400: {"model": ErrorResponse}, 500: {"model": ErrorResponse}},
)
async def create_job(
    request: JobCreateRequest,
    db: Session = Depends(get_db),
):
    """Create a new ORE calculation job."""
    service = JobService(db)
    return service.create_job(request)


@router.get(
    "/jobs/{job_id}",
    response_model=JobResponse,
    responses={404: {"model": ErrorResponse}},
)
async def get_job_status(
    job_id: str,
    db: Session = Depends(get_db),
):
    """Get job status and progress."""
    service = JobService(db)
    return service.get_job(job_id)


@router.get(
    "/jobs/{job_id}/result",
    response_model=JobResultResponse,
    responses={404: {"model": ErrorResponse}},
)
async def get_job_result(
    job_id: str,
    db: Session = Depends(get_db),
):
    """Get job result with summary and output file list."""
    service = JobService(db)
    return service.get_job_result(job_id)


@router.post(
    "/jobs/{job_id}/cancel",
    response_model=JobResponse,
    responses={404: {"model": ErrorResponse}, 409: {"model": ErrorResponse}},
)
async def cancel_job(
    job_id: str,
    db: Session = Depends(get_db),
):
    """Cancel a queued job."""
    service = JobService(db)
    return service.cancel_job(job_id)
