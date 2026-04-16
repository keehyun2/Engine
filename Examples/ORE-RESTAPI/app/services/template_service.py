import logging
import os
from pathlib import Path
from typing import Any

import yaml
from jinja2 import Environment, FileSystemLoader

from app.config import settings
from app.schemas.job import OREInputs

logger = logging.getLogger(__name__)


class TemplateNotFoundError(Exception):
    pass


class TemplateService:
    """Renders ORE XML input files from Jinja2 templates and user inputs."""

    def __init__(self):
        self.templates_dir = Path(settings.TEMPLATES_DIR)
        self.shared_input_dir = Path(settings.SHARED_INPUT_DIR)
        self.jinja_env = Environment(
            loader=FileSystemLoader(str(self.templates_dir)),
            autoescape=False,
            keep_trailing_newline=True,
        )

    def render_job_inputs(
        self,
        template_name: str,
        inputs: OREInputs,
        job_input_dir: Path,
        job_output_dir: Path,
    ) -> Path:
        """Render all ORE input files for a job.

        Returns the path to the generated ore.xml.
        """
        # Validate template exists
        template_dir = self.templates_dir / template_name
        if not template_dir.exists():
            raise TemplateNotFoundError(f"Template not found: {template_name}")

        # Load defaults
        defaults = self._load_defaults(template_name)

        # Merge user inputs into defaults
        context = self._build_context(defaults, inputs, job_input_dir, job_output_dir)

        # Write user-provided supporting files
        self._write_user_files(inputs, job_input_dir)

        # Render ore.xml
        template = self.jinja_env.get_template(f"{template_name}/ore.xml.j2")
        ore_xml = template.render(**context)

        ore_xml_path = job_input_dir / "ore.xml"
        ore_xml_path.write_text(ore_xml, encoding="utf-8")
        logger.info("Rendered ore.xml for template '%s'", template_name)

        return ore_xml_path

    def _load_defaults(self, template_name: str) -> dict[str, Any]:
        """Load default values from templates/{name}/defaults.yml."""
        defaults_path = self.templates_dir / template_name / "defaults.yml"
        if defaults_path.exists():
            with open(defaults_path, "r", encoding="utf-8") as f:
                return yaml.safe_load(f) or {}
        return {}

    def _build_context(
        self,
        defaults: dict[str, Any],
        inputs: OREInputs,
        job_input_dir: Path,
        job_output_dir: Path,
    ) -> dict[str, Any]:
        """Build the Jinja2 template context from defaults + user inputs."""
        context: dict[str, Any] = {}

        # Determine file references first
        # Shared files use relative path from job input dir to Examples/Input/
        # Use os.path.relpath to handle cross-tree relative paths
        shared_prefix = os.path.relpath(
            str(self.shared_input_dir.resolve()),
            str(job_input_dir.resolve())
        ).replace("\\", "/")

        # Setup section
        setup = defaults.get("setup", {}).copy()
        setup["asofDate"] = inputs.asOfDate
        if inputs.baseCurrency:
            setup["baseCurrency"] = inputs.baseCurrency

        # Override shared file paths with computed relative paths
        # Only override if the value starts with "../../Input/" (from template defaults)
        shared_file_keys = [
            "marketDataFile", "fixingDataFile", "curveConfigFile",
            "conventionsFile", "marketConfigFile", "pricingEnginesFile"
        ]
        for key in shared_file_keys:
            if key in setup and setup[key].startswith("../../Input/"):
                filename = setup[key].replace("../../Input/", "")
                setup[key] = f"{shared_prefix}/{filename}"

        # Override setup params from user
        if inputs.parameters and "setup" in inputs.parameters:
            setup.update(inputs.parameters["setup"])
        context["setup"] = setup

        # Markets section
        markets = defaults.get("markets", {}).copy()
        if inputs.parameters and "markets" in inputs.parameters:
            markets.update(inputs.parameters["markets"])
        context["markets"] = markets

        # Analytics section
        analytics = defaults.get("analytics", {}).copy()
        if inputs.parameters and "analytics" in inputs.parameters:
            for key, val in inputs.parameters["analytics"].items():
                if key in analytics:
                    analytics[key].update(val)
                else:
                    analytics[key] = val
        context["analytics"] = analytics

        context["shared_input_dir"] = shared_prefix

        # User-provided files are in the job input directory (no prefix needed)
        context["job_input_dir"] = "."
        # Output is a sibling of input: jobs/{id}/output relative to jobs/{id}/input
        context["output_path"] = str(
            job_output_dir.resolve().relative_to(job_input_dir.resolve().parent)
        ).replace("\\", "/")

        return context

    def _write_user_files(self, inputs: OREInputs, job_input_dir: Path) -> None:
        """Write user-provided file contents to the job input directory."""
        file_map = {
            "portfolioFile": inputs.portfolioFile,
            "marketData": inputs.marketData,
            "fixingData": inputs.fixingData,
            "curveConfig": inputs.curveConfig,
            "conventions": inputs.conventions,
            "marketConfig": inputs.marketConfig,
            "pricingEngines": inputs.pricingEngines,
            "simulationConfig": inputs.simulationConfig,
            "nettingSets": inputs.nettingSets,
        }
        filenames = {
            "portfolioFile": "portfolio.xml",
            "marketData": "market.txt",
            "fixingData": "fixings.txt",
            "curveConfig": "curveconfig.xml",
            "conventions": "conventions.xml",
            "marketConfig": "todaysmarket.xml",
            "pricingEngines": "pricingengine.xml",
            "simulationConfig": "simulation.xml",
            "nettingSets": "netting.xml",
        }

        for key, content in file_map.items():
            if content:
                filepath = job_input_dir / filenames[key]
                filepath.write_text(content, encoding="utf-8")
                logger.info("Wrote user file: %s", filenames[key])

    def list_templates(self) -> list[str]:
        """List available template names."""
        if not self.templates_dir.exists():
            return []
        return [
            d.name
            for d in self.templates_dir.iterdir()
            if d.is_dir() and (d / "ore.xml.j2").exists()
        ]


template_service = TemplateService()
