import os
import platform
import shutil
from pathlib import Path
from pydantic_settings import BaseSettings


class Settings(BaseSettings):
    # ORE executable
    ORE_PATH: str = ""
    ORE_TIMEOUT_SECONDS: int = 600

    # Database
    DATABASE_URL: str = "sqlite:///./ore_api.db"

    # Redis
    REDIS_URL: str = "redis://localhost:6379/0"

    # Paths
    JOBS_BASE_DIR: str = str(Path(__file__).parent.parent / "jobs")
    TEMPLATES_DIR: str = str(Path(__file__).parent.parent / "templates")

    # Shared input files from Examples/Input/
    SHARED_INPUT_DIR: str = str(Path(__file__).parent.parent.parent / "Input")

    # Development mode (sync execution, no Redis needed)
    DEV_MODE: bool = True

    model_config = {"env_prefix": "ORE_", "env_file": ".env", "extra": "ignore"}


settings = Settings()


def resolve_ore_path() -> Path:
    """Resolve ORE executable path from config or auto-detect."""
    # 1. Explicit path from config
    if settings.ORE_PATH and os.path.isfile(settings.ORE_PATH):
        return Path(settings.ORE_PATH)

    # 2. Check environment variable directly
    env_path = os.environ.get("ORE_PATH", "")
    if env_path and os.path.isfile(env_path):
        return Path(env_path)

    # 3. Check system PATH
    ore_name = "ore.exe" if os.name == "nt" else "ore"
    found = shutil.which(ore_name)
    if found:
        return Path(found)

    # 4. Auto-detect relative to Engine root
    engine_root = Path(__file__).parent.parent.parent.parent
    search_paths = _get_search_paths(engine_root)
    for p in search_paths:
        if p.exists():
            return p

    raise FileNotFoundError(
        f"ORE executable not found. Set ORE_PATH environment variable or place ore.exe in PATH. "
        f"Searched: {[str(p) for p in search_paths]}"
    )


def _get_search_paths(engine_root: Path) -> list[Path]:
    """Get platform-specific search paths for ORE executable."""
    exe = "ore.exe" if os.name == "nt" else "ore"
    paths = []

    if os.name == "nt":
        if platform.machine().endswith("64"):
            paths.extend([
                engine_root / "App" / "bin" / "x64" / "Release" / exe,
                engine_root / "build" / "App" / exe,
                engine_root / "build" / "ore" / "App" / exe,
                engine_root / "build" / "ore" / "App" / "RelWithDebInfo" / exe,
                engine_root / "build" / "App" / "Release" / exe,
            ])
        else:
            paths.extend([
                engine_root / "App" / "bin" / "Win32" / "Release" / exe,
                engine_root / "build" / "App" / exe,
            ])
    else:
        paths.extend([
            engine_root / "App" / "build" / "ore",
            engine_root / "build" / "App" / "ore",
            engine_root / "App" / "ore",
            engine_root / "build" / "ore" / "App" / "ore",
        ])

    return paths
