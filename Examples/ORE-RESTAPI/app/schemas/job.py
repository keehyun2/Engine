from datetime import datetime
from typing import Optional

from pydantic import BaseModel, Field


# --- Request Schemas ---


class OREInputs(BaseModel):
    asOfDate: str = Field(..., description="Valuation date (YYYY-MM-DD)")
    baseCurrency: str = Field(default="EUR", description="Base currency")
    portfolio: Optional[dict] = Field(
        default=None, description="Portfolio trade definitions"
    )
    portfolioFile: Optional[str] = Field(
        default=None, description="Portfolio XML file content"
    )
    marketData: Optional[str] = Field(
        default=None, description="Market data TXT content"
    )
    fixingData: Optional[str] = Field(
        default=None, description="Fixing data TXT content"
    )
    curveConfig: Optional[str] = Field(
        default=None, description="Curve config XML content"
    )
    conventions: Optional[str] = Field(
        default=None, description="Conventions XML content"
    )
    marketConfig: Optional[str] = Field(
        default=None, description="Today's market config XML content"
    )
    pricingEngines: Optional[str] = Field(
        default=None, description="Pricing engines XML content"
    )
    simulationConfig: Optional[str] = Field(
        default=None, description="Simulation config XML content"
    )
    nettingSets: Optional[str] = Field(
        default=None, description="Netting set definitions XML content"
    )
    parameters: Optional[dict] = Field(
        default=None, description="Additional parameters to override template defaults"
    )


class JobCreateRequest(BaseModel):
    jobType: str = Field(
        ..., description="Job type: npv, xva, stress, sensitivity, cashflow, curves"
    )
    template: str = Field(
        ..., description="Template name: pricing-basic, xva-standard, stress-ir-up, stress-ir-down"
    )
    inputs: OREInputs


# --- Response Schemas ---


class JobCreateResponse(BaseModel):
    jobId: str
    status: str


class JobResponse(BaseModel):
    jobId: str
    status: str
    progress: int
    template: str
    jobType: str
    createdAt: datetime
    updatedAt: datetime


class JobResultResponse(BaseModel):
    jobId: str
    status: str
    summary: Optional[dict] = None
    files: list[str] = []


class ErrorDetail(BaseModel):
    code: str
    message: str


class ErrorResponse(BaseModel):
    error: ErrorDetail
