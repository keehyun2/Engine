from fastapi import APIRouter

from app.api.routes_files import router as files_router
from app.api.routes_jobs import router as jobs_router
from app.api.routes_logs import router as logs_router

api_router = APIRouter()
api_router.include_router(jobs_router, tags=["jobs"])
api_router.include_router(files_router, tags=["files"])
api_router.include_router(logs_router, tags=["logs"])
