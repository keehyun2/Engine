import logging
from contextlib import asynccontextmanager

from fastapi import FastAPI, Request
from fastapi.responses import JSONResponse

from app.api.router import api_router
from app.config import resolve_ore_path
from app.database import init_db
from app.services.job_service import JobNotFoundError

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(name)s: %(message)s",
)
logger = logging.getLogger(__name__)


@asynccontextmanager
async def lifespan(app: FastAPI):
    """Startup/shutdown lifecycle."""
    logger.info("Initializing database...")
    init_db()

    logger.info("Resolving ORE executable...")
    try:
        ore_path = resolve_ore_path()
        logger.info("ORE executable found: %s", ore_path)
    except FileNotFoundError as e:
        logger.warning("ORE executable not found: %s", e)

    logger.info("ORE REST API server started (DEV_MODE=true)")
    yield
    logger.info("ORE REST API server shutting down")


def create_app() -> FastAPI:
    """Create and configure the FastAPI application."""
    app = FastAPI(
        title="ORE REST API",
        description="REST API for Open Source Risk Engine (ORE)",
        version="1.0.0",
        lifespan=lifespan,
    )

    app.include_router(api_router)

    # Custom exception handlers
    @app.exception_handler(JobNotFoundError)
    async def job_not_found_handler(request: Request, exc: JobNotFoundError):
        return JSONResponse(
            status_code=404,
            content={"error": {"code": "JOB_NOT_FOUND", "message": str(exc)}},
        )

    @app.exception_handler(FileNotFoundError)
    async def file_not_found_handler(request: Request, exc: FileNotFoundError):
        return JSONResponse(
            status_code=404,
            content={"error": {"code": "FILE_NOT_FOUND", "message": str(exc)}},
        )

    @app.exception_handler(ValueError)
    async def value_error_handler(request: Request, exc: ValueError):
        return JSONResponse(
            status_code=400,
            content={"error": {"code": "INVALID_REQUEST", "message": str(exc)}},
        )

    return app


app = create_app()
