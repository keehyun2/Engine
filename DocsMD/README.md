# ORE Documentation (Markdown)

This directory contains the ORE (Open Source Risk Engine) User Guide documentation converted from LaTeX to Markdown format.

## Converted Documents

### 1. [userguide.md](userguide.md) (646 KB)
The complete ORE User Guide including:
- Introduction to ORE
- Installation and build instructions
- ORE configuration parameters
- Trade components documentation
- Market data, fixing data, and dividend data formats

### 2. [products.md](products.md) (592 KB)
Complete Product Catalogue covering:
- All supported trade types (130+ products)
- Pricing methods and models
- Trade data specifications
- Trade components reference

### 3. [methods.md](methods.md) (231 KB)
Methodology documentation including:
- Market risk methodology
- Simulation techniques
- XVA (Valuation Adjustments)
- Capital calculations (SA-CCR, CVA, SMRC)

## Conversion Details

- **Source**: LaTeX files in `Docs/UserGuide/`
- **Tool**: pandoc 3.1.3
- **Date**: 2026-05-17
- **Method**: Section-by-section conversion with combination

## Notes

- Mathematical formulas are preserved in LaTeX syntax (use MathJax/KaTeX for rendering)
- Code blocks use XML syntax highlighting where applicable
- Some complex LaTeX tables may render as HTML tables
- Images and figures are referenced from original paths

## Original Documentation

For the latest LaTeX source files, see `Docs/UserGuide/` in the ORE repository.
