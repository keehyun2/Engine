import csv
import logging
from pathlib import Path

logger = logging.getLogger(__name__)


class ResultParser:
    """Parse ORE CSV output files into structured summaries."""

    def parse_summary(self, output_dir: Path, job_type: str) -> dict:
        """Parse relevant output files based on job type into a summary dict."""
        summary: dict = {}

        if not output_dir.exists():
            return summary

        # Parse NPV if available
        npv_data = self._parse_npv(output_dir)
        if npv_data:
            summary["npv"] = npv_data

        # Parse cashflow if available
        flow_data = self._parse_flow_count(output_dir)
        if flow_data is not None:
            summary["cashflowRows"] = flow_data

        return summary

    def _parse_npv(self, output_dir: Path) -> dict | None:
        """Parse npv.csv into summary data."""
        npv_file = output_dir / "npv.csv"
        if not npv_file.exists():
            return None

        try:
            rows = self._read_csv(npv_file)
            if not rows:
                return None

            total_npv = 0.0
            trades = []
            for row in rows:
                # NPV CSV columns: TradeId, Portfolio, NPV, Currency, BaseCurrency, BaseNPV
                trade_id = row.get("TradeId", row.get("#TradeId", ""))
                npv_str = row.get("NPV", "0")
                base_npv_str = row.get("BaseNPV", "0")
                currency = row.get("Currency", "")
                base_currency = row.get("BaseCurrency", "")

                try:
                    base_npv = float(base_npv_str) if base_npv_str else 0.0
                except ValueError:
                    base_npv = 0.0

                total_npv += base_npv
                trades.append({
                    "tradeId": trade_id,
                    "npv": npv_str,
                    "currency": currency,
                    "baseCurrency": base_currency,
                    "baseNpv": base_npv,
                })

            return {"totalBaseNpv": round(total_npv, 2), "tradeCount": len(trades), "trades": trades}

        except Exception as e:
            logger.warning("Failed to parse npv.csv: %s", e)
            return None

    def _parse_flow_count(self, output_dir: Path) -> int | None:
        """Count rows in flow.csv."""
        flow_file = output_dir / "flows.csv"
        if not flow_file.exists():
            return None
        rows = self._read_csv(flow_file)
        return len(rows) if rows else 0

    def _read_csv(self, filepath: Path) -> list[dict[str, str]]:
        """Read a CSV file and return rows as dicts."""
        with open(filepath, "r", encoding="utf-8", errors="replace") as f:
            reader = csv.DictReader(f)
            return list(reader)
