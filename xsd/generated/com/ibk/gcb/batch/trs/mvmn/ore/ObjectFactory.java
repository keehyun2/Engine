//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ibk.gcb.batch.trs.mvmn.ore package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Conventions_QNAME = new QName("", "Conventions");
    private final static QName _NettingSetId_QNAME = new QName("", "NettingSetId");
    private final static QName _Derived_QNAME = new QName("", "Derived");
    private final static QName _ReferenceInformation_QNAME = new QName("", "ReferenceInformation");
    private final static QName _YYLegData_QNAME = new QName("", "YYLegData");
    private final static QName _NettingSetDefinitions_QNAME = new QName("", "NettingSetDefinitions");
    private final static QName _Name_QNAME = new QName("", "Name");
    private final static QName _TodaysMarket_QNAME = new QName("", "TodaysMarket");
    private final static QName _Trade_QNAME = new QName("", "Trade");
    private final static QName _EquityMarginLegData_QNAME = new QName("", "EquityMarginLegData");
    private final static QName _CrossAssetModel_QNAME = new QName("", "CrossAssetModel");
    private final static QName _CollateralBalances_QNAME = new QName("", "CollateralBalances");
    private final static QName _Currency_QNAME = new QName("", "Currency");
    private final static QName _NettingSetGroup_QNAME = new QName("", "nettingSetGroup");
    private final static QName _LevelData_QNAME = new QName("", "LevelData");
    private final static QName _CurrencyConfig_QNAME = new QName("", "CurrencyConfig");
    private final static QName _CMSLegData_QNAME = new QName("", "CMSLegData");
    private final static QName _FixedLegData_QNAME = new QName("", "FixedLegData");
    private final static QName _DigitalCMSSpreadLegData_QNAME = new QName("", "DigitalCMSSpreadLegData");
    private final static QName _CalendarAdjustments_QNAME = new QName("", "CalendarAdjustments");
    private final static QName _CashflowData_QNAME = new QName("", "CashflowData");
    private final static QName _Underlyings_QNAME = new QName("", "Underlyings");
    private final static QName _Underlying_QNAME = new QName("", "Underlying");
    private final static QName _Level_QNAME = new QName("", "Level");
    private final static QName _StressTesting_QNAME = new QName("", "StressTesting");
    private final static QName _FloatingLegData_QNAME = new QName("", "FloatingLegData");
    private final static QName _DerivedScheduleGroup_QNAME = new QName("", "DerivedScheduleGroup");
    private final static QName _SubTradeGroup_QNAME = new QName("", "subTradeGroup");
    private final static QName _CreditCurveId_QNAME = new QName("", "CreditCurveId");
    private final static QName _CommodityFloatingLegData_QNAME = new QName("", "CommodityFloatingLegData");
    private final static QName _ORE_QNAME = new QName("", "ORE");
    private final static QName _CMSSpreadLegData_QNAME = new QName("", "CMSSpreadLegData");
    private final static QName _LegDataType_QNAME = new QName("", "legDataType");
    private final static QName _DigitalCMSLegData_QNAME = new QName("", "DigitalCMSLegData");
    private final static QName _StrikeData_QNAME = new QName("", "StrikeData");
    private final static QName _ExerciseDatesGroup_QNAME = new QName("", "exerciseDatesGroup");
    private final static QName _CurveConfiguration_QNAME = new QName("", "CurveConfiguration");
    private final static QName _CommodityFixedLegData_QNAME = new QName("", "CommodityFixedLegData");
    private final static QName _CounterpartyInformation_QNAME = new QName("", "CounterpartyInformation");
    private final static QName _CreditCurveIdType_QNAME = new QName("", "creditCurveIdType");
    private final static QName _PricingEngines_QNAME = new QName("", "PricingEngines");
    private final static QName _SensitivityAnalysis_QNAME = new QName("", "SensitivityAnalysis");
    private final static QName _LevelGroup_QNAME = new QName("", "levelGroup");
    private final static QName _CreditSimulation_QNAME = new QName("", "CreditSimulation");
    private final static QName _ExerciseDates_QNAME = new QName("", "ExerciseDates");
    private final static QName _StrikeGroup_QNAME = new QName("", "strikeGroup");
    private final static QName _Portfolio_QNAME = new QName("", "Portfolio");
    private final static QName _Strike_QNAME = new QName("", "Strike");
    private final static QName _DerivedSchedule_QNAME = new QName("", "DerivedSchedule");
    private final static QName _ExerciseSchedule_QNAME = new QName("", "ExerciseSchedule");
    private final static QName _SubTrade_QNAME = new QName("", "SubTrade");
    private final static QName _NettingSetDetails_QNAME = new QName("", "NettingSetDetails");
    private final static QName _CPILegData_QNAME = new QName("", "CPILegData");
    private final static QName _Simulation_QNAME = new QName("", "Simulation");
    private final static QName _UnderlyingTypes_QNAME = new QName("", "underlyingTypes");
    private final static QName _ZeroCouponFixedLegData_QNAME = new QName("", "ZeroCouponFixedLegData");
    private final static QName _FormulaBasedLegData_QNAME = new QName("", "FormulaBasedLegData");
    private final static QName _CMBLegData_QNAME = new QName("", "CMBLegData");
    private final static QName _EquityLegData_QNAME = new QName("", "EquityLegData");
    private final static QName _DurationAdjustedCMSLegData_QNAME = new QName("", "DurationAdjustedCMSLegData");
    private final static QName _SwaptionDataOptionData_QNAME = new QName("", "OptionData");
    private final static QName _SwaptionDataLegData_QNAME = new QName("", "LegData");
    private final static QName _SimCommodityCurveInterpolationMethod_QNAME = new QName("", "InterpolationMethod");
    private final static QName _SimCommodityCurvePriceSegments_QNAME = new QName("", "PriceSegments");
    private final static QName _SimCommodityCurveBootstrapConfig_QNAME = new QName("", "BootstrapConfig");
    private final static QName _SimCommodityCurveQuotes_QNAME = new QName("", "Quotes");
    private final static QName _SimCommodityCurveBasisConfiguration_QNAME = new QName("", "BasisConfiguration");
    private final static QName _SimCommodityCurveBaseYieldCurve_QNAME = new QName("", "BaseYieldCurve");
    private final static QName _SimCommodityCurveCurveId_QNAME = new QName("", "CurveId");
    private final static QName _SimCommodityCurveDayCounter_QNAME = new QName("", "DayCounter");
    private final static QName _SimCommodityCurveExtrapolation_QNAME = new QName("", "Extrapolation");
    private final static QName _SimCommodityCurveBasePriceCurve_QNAME = new QName("", "BasePriceCurve");
    private final static QName _SimCommodityCurveCurveDescription_QNAME = new QName("", "CurveDescription");
    private final static QName _SimCommodityCurveYieldCurve_QNAME = new QName("", "YieldCurve");
    private final static QName _SimCommodityCurveSpotQuote_QNAME = new QName("", "SpotQuote");
    private final static QName _CPILegDataFinalFlowCap_QNAME = new QName("", "FinalFlowCap");
    private final static QName _CPILegDataRates_QNAME = new QName("", "Rates");
    private final static QName _CPILegDataSubtractInflationNotionalAllCoupons_QNAME = new QName("", "SubtractInflationNotionalAllCoupons");
    private final static QName _CPILegDataObservationLag_QNAME = new QName("", "ObservationLag");
    private final static QName _CPILegDataIndex_QNAME = new QName("", "Index");
    private final static QName _CPILegDataFinalFlowFloor_QNAME = new QName("", "FinalFlowFloor");
    private final static QName _CPILegDataBaseCPI_QNAME = new QName("", "BaseCPI");
    private final static QName _CPILegDataStartDate_QNAME = new QName("", "StartDate");
    private final static QName _CPILegDataInterpolation_QNAME = new QName("", "Interpolation");
    private final static QName _CPILegDataSubtractInflationNotional_QNAME = new QName("", "SubtractInflationNotional");
    private final static QName _CPILegDataInterpolated_QNAME = new QName("", "Interpolated");
    private final static QName _CPILegDataCaps_QNAME = new QName("", "Caps");
    private final static QName _CPILegDataFloors_QNAME = new QName("", "Floors");
    private final static QName _CPILegDataNakedOption_QNAME = new QName("", "NakedOption");
    private final static QName _ScheduleDataDates_QNAME = new QName("", "Dates");
    private final static QName _ScheduleDataRules_QNAME = new QName("", "Rules");
    private final static QName _DigitalCMSSpreadLegDataPutStrikes_QNAME = new QName("", "PutStrikes");
    private final static QName _DigitalCMSSpreadLegDataIsPutATMIncluded_QNAME = new QName("", "IsPutATMIncluded");
    private final static QName _DigitalCMSSpreadLegDataPutPayoffs_QNAME = new QName("", "PutPayoffs");
    private final static QName _DigitalCMSSpreadLegDataCallStrikes_QNAME = new QName("", "CallStrikes");
    private final static QName _DigitalCMSSpreadLegDataCallPosition_QNAME = new QName("", "CallPosition");
    private final static QName _DigitalCMSSpreadLegDataCallPayoffs_QNAME = new QName("", "CallPayoffs");
    private final static QName _DigitalCMSSpreadLegDataIsCallATMIncluded_QNAME = new QName("", "IsCallATMIncluded");
    private final static QName _DigitalCMSSpreadLegDataPutPosition_QNAME = new QName("", "PutPosition");
    private final static QName _TrsUnderlyingDataPortfolioIndexTradeData_QNAME = new QName("", "PortfolioIndexTradeData");
    private final static QName _TrsUnderlyingDataDerivative_QNAME = new QName("", "Derivative");
    private final static QName _ZeroCouponFixedLegDataCompounding_QNAME = new QName("", "Compounding");
    private final static QName _ZeroCouponFixedLegDataSubtractNotional_QNAME = new QName("", "SubtractNotional");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsNonExemptIMRegulations_QNAME = new QName("", "NonExemptIMRegulations");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsCalculateVMAmount_QNAME = new QName("", "CalculateVMAmount");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsCalculateIMAmount_QNAME = new QName("", "CalculateIMAmount");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsBilateral_QNAME = new QName("", "Bilateral");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsThresholdReceive_QNAME = new QName("", "ThresholdReceive");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsApplyInitialMargin_QNAME = new QName("", "ApplyInitialMargin");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsMinimumTransferAmountPay_QNAME = new QName("", "MinimumTransferAmountPay");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsCSACurrency_QNAME = new QName("", "CSACurrency");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsMarginPeriodOfRisk_QNAME = new QName("", "MarginPeriodOfRisk");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsIndependentAmount_QNAME = new QName("", "IndependentAmount");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsMinimumTransferAmountReceive_QNAME = new QName("", "MinimumTransferAmountReceive");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsInitialMarginType_QNAME = new QName("", "InitialMarginType");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsCollateralCompoundingSpreadPay_QNAME = new QName("", "CollateralCompoundingSpreadPay");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsMarginingFrequency_QNAME = new QName("", "MarginingFrequency");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsCollateralCompoundingSpreadReceive_QNAME = new QName("", "CollateralCompoundingSpreadReceive");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsThresholdPay_QNAME = new QName("", "ThresholdPay");
    private final static QName _NettingsetdefinitionsNettingSetCSADetailsEligibleCollaterals_QNAME = new QName("", "EligibleCollaterals");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ibk.gcb.batch.trs.mvmn.ore
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BaselTrafficLightConfig }
     * 
     */
    public BaselTrafficLightConfig createBaselTrafficLightConfig() {
        return new BaselTrafficLightConfig();
    }

    /**
     * Create an instance of {@link ScriptLibrary }
     * 
     */
    public ScriptLibrary createScriptLibrary() {
        return new ScriptLibrary();
    }

    /**
     * Create an instance of {@link ReferenceData }
     * 
     */
    public ReferenceData createReferenceData() {
        return new ReferenceData();
    }

    /**
     * Create an instance of {@link CapFloorData }
     * 
     */
    public CapFloorData createCapFloorData() {
        return new CapFloorData();
    }

    /**
     * Create an instance of {@link CapFloorData.Floors }
     * 
     */
    public CapFloorData.Floors createCapFloorDataFloors() {
        return new CapFloorData.Floors();
    }

    /**
     * Create an instance of {@link CapFloorData.Caps }
     * 
     */
    public CapFloorData.Caps createCapFloorDataCaps() {
        return new CapFloorData.Caps();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation createBaseCorrelation() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryProbabilities }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryProbabilities createBaseCorrelationRecoveryProbabilities() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryProbabilities();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryGrid }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryGrid createBaseCorrelationRecoveryGrid() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryGrid();
    }

    /**
     * Create an instance of {@link CrossAssetLGM }
     * 
     */
    public CrossAssetLGM createCrossAssetLGM() {
        return new CrossAssetLGM();
    }

    /**
     * Create an instance of {@link BondRepoData }
     * 
     */
    public BondRepoData createBondRepoData() {
        return new BondRepoData();
    }

    /**
     * Create an instance of {@link PortfolioBasketReferenceDatum }
     * 
     */
    public PortfolioBasketReferenceDatum createPortfolioBasketReferenceDatum() {
        return new PortfolioBasketReferenceDatum();
    }

    /**
     * Create an instance of {@link PortfolioBasketReferenceDatum.Components }
     * 
     */
    public PortfolioBasketReferenceDatum.Components createPortfolioBasketReferenceDatumComponents() {
        return new PortfolioBasketReferenceDatum.Components();
    }

    /**
     * Create an instance of {@link ScriptedTradeData }
     * 
     */
    public ScriptedTradeData createScriptedTradeData() {
        return new ScriptedTradeData();
    }

    /**
     * Create an instance of {@link ScriptedTradeData.Data }
     * 
     */
    public ScriptedTradeData.Data createScriptedTradeDataData() {
        return new ScriptedTradeData.Data();
    }

    /**
     * Create an instance of {@link ScriptedTradeData.Data.Daycounter }
     * 
     */
    public ScriptedTradeData.Data.Daycounter createScriptedTradeDataDataDaycounter() {
        return new ScriptedTradeData.Data.Daycounter();
    }

    /**
     * Create an instance of {@link ScriptedTradeData.Data.Event }
     * 
     */
    public ScriptedTradeData.Data.Event createScriptedTradeDataDataEvent() {
        return new ScriptedTradeData.Data.Event();
    }

    /**
     * Create an instance of {@link ScriptedTradeData.Data.Index }
     * 
     */
    public ScriptedTradeData.Data.Index createScriptedTradeDataDataIndex() {
        return new ScriptedTradeData.Data.Index();
    }

    /**
     * Create an instance of {@link ScriptedTradeData.Data.Currency }
     * 
     */
    public ScriptedTradeData.Data.Currency createScriptedTradeDataDataCurrency() {
        return new ScriptedTradeData.Data.Currency();
    }

    /**
     * Create an instance of {@link ScriptedTradeData.Data.Number }
     * 
     */
    public ScriptedTradeData.Data.Number createScriptedTradeDataDataNumber() {
        return new ScriptedTradeData.Data.Number();
    }

    /**
     * Create an instance of {@link YieldVolatilitiesType }
     * 
     */
    public YieldVolatilitiesType createYieldVolatilitiesType() {
        return new YieldVolatilitiesType();
    }

    /**
     * Create an instance of {@link DodgsonKainth }
     * 
     */
    public DodgsonKainth createDodgsonKainth() {
        return new DodgsonKainth();
    }

    /**
     * Create an instance of {@link CbDividendProtectionData }
     * 
     */
    public CbDividendProtectionData createCbDividendProtectionData() {
        return new CbDividendProtectionData();
    }

    /**
     * Create an instance of {@link CbDividendProtectionData.Thresholds }
     * 
     */
    public CbDividendProtectionData.Thresholds createCbDividendProtectionDataThresholds() {
        return new CbDividendProtectionData.Thresholds();
    }

    /**
     * Create an instance of {@link CbDividendProtectionData.DividendTypes }
     * 
     */
    public CbDividendProtectionData.DividendTypes createCbDividendProtectionDataDividendTypes() {
        return new CbDividendProtectionData.DividendTypes();
    }

    /**
     * Create an instance of {@link CbDividendProtectionData.AdjustmentStyles }
     * 
     */
    public CbDividendProtectionData.AdjustmentStyles createCbDividendProtectionDataAdjustmentStyles() {
        return new CbDividendProtectionData.AdjustmentStyles();
    }

    /**
     * Create an instance of {@link EquityCurvesType }
     * 
     */
    public EquityCurvesType createEquityCurvesType() {
        return new EquityCurvesType();
    }

    /**
     * Create an instance of {@link Market }
     * 
     */
    public Market createMarket() {
        return new Market();
    }

    /**
     * Create an instance of {@link Market.Correlations }
     * 
     */
    public Market.Correlations createMarketCorrelations() {
        return new Market.Correlations();
    }

    /**
     * Create an instance of {@link Market.BaseCorrelations }
     * 
     */
    public Market.BaseCorrelations createMarketBaseCorrelations() {
        return new Market.BaseCorrelations();
    }

    /**
     * Create an instance of {@link Market.BaseCorrelations.DayCounters }
     * 
     */
    public Market.BaseCorrelations.DayCounters createMarketBaseCorrelationsDayCounters() {
        return new Market.BaseCorrelations.DayCounters();
    }

    /**
     * Create an instance of {@link Market.CommodityVolatilities }
     * 
     */
    public Market.CommodityVolatilities createMarketCommodityVolatilities() {
        return new Market.CommodityVolatilities();
    }

    /**
     * Create an instance of {@link Market.CommodityVolatilities.Names }
     * 
     */
    public Market.CommodityVolatilities.Names createMarketCommodityVolatilitiesNames() {
        return new Market.CommodityVolatilities.Names();
    }

    /**
     * Create an instance of {@link Market.Commodities }
     * 
     */
    public Market.Commodities createMarketCommodities() {
        return new Market.Commodities();
    }

    /**
     * Create an instance of {@link Market.Commodities.DayCounters }
     * 
     */
    public Market.Commodities.DayCounters createMarketCommoditiesDayCounters() {
        return new Market.Commodities.DayCounters();
    }

    /**
     * Create an instance of {@link Market.YYCapFloorVolatilities }
     * 
     */
    public Market.YYCapFloorVolatilities createMarketYYCapFloorVolatilities() {
        return new Market.YYCapFloorVolatilities();
    }

    /**
     * Create an instance of {@link Market.CPICapFloorVolatilities }
     * 
     */
    public Market.CPICapFloorVolatilities createMarketCPICapFloorVolatilities() {
        return new Market.CPICapFloorVolatilities();
    }

    /**
     * Create an instance of {@link Market.YYInflationIndexCurves }
     * 
     */
    public Market.YYInflationIndexCurves createMarketYYInflationIndexCurves() {
        return new Market.YYInflationIndexCurves();
    }

    /**
     * Create an instance of {@link Market.YYInflationIndexCurves.DayCounters }
     * 
     */
    public Market.YYInflationIndexCurves.DayCounters createMarketYYInflationIndexCurvesDayCounters() {
        return new Market.YYInflationIndexCurves.DayCounters();
    }

    /**
     * Create an instance of {@link Market.ZeroInflationIndexCurves }
     * 
     */
    public Market.ZeroInflationIndexCurves createMarketZeroInflationIndexCurves() {
        return new Market.ZeroInflationIndexCurves();
    }

    /**
     * Create an instance of {@link Market.ZeroInflationIndexCurves.DayCounters }
     * 
     */
    public Market.ZeroInflationIndexCurves.DayCounters createMarketZeroInflationIndexCurvesDayCounters() {
        return new Market.ZeroInflationIndexCurves.DayCounters();
    }

    /**
     * Create an instance of {@link Market.CPRs }
     * 
     */
    public Market.CPRs createMarketCPRs() {
        return new Market.CPRs();
    }

    /**
     * Create an instance of {@link Market.Securities }
     * 
     */
    public Market.Securities createMarketSecurities() {
        return new Market.Securities();
    }

    /**
     * Create an instance of {@link Market.BenchmarkCurves }
     * 
     */
    public Market.BenchmarkCurves createMarketBenchmarkCurves() {
        return new Market.BenchmarkCurves();
    }

    /**
     * Create an instance of {@link Market.EquityVolatilities }
     * 
     */
    public Market.EquityVolatilities createMarketEquityVolatilities() {
        return new Market.EquityVolatilities();
    }

    /**
     * Create an instance of {@link Market.EquityVolatilities.DayCounters }
     * 
     */
    public Market.EquityVolatilities.DayCounters createMarketEquityVolatilitiesDayCounters() {
        return new Market.EquityVolatilities.DayCounters();
    }

    /**
     * Create an instance of {@link Market.EquityVolatilities.Surface }
     * 
     */
    public Market.EquityVolatilities.Surface createMarketEquityVolatilitiesSurface() {
        return new Market.EquityVolatilities.Surface();
    }

    /**
     * Create an instance of {@link Market.FxVolatilities }
     * 
     */
    public Market.FxVolatilities createMarketFxVolatilities() {
        return new Market.FxVolatilities();
    }

    /**
     * Create an instance of {@link Market.FxVolatilities.DayCounters }
     * 
     */
    public Market.FxVolatilities.DayCounters createMarketFxVolatilitiesDayCounters() {
        return new Market.FxVolatilities.DayCounters();
    }

    /**
     * Create an instance of {@link Market.FxVolatilities.Surface }
     * 
     */
    public Market.FxVolatilities.Surface createMarketFxVolatilitiesSurface() {
        return new Market.FxVolatilities.Surface();
    }

    /**
     * Create an instance of {@link Market.CDSVolatilities }
     * 
     */
    public Market.CDSVolatilities createMarketCDSVolatilities() {
        return new Market.CDSVolatilities();
    }

    /**
     * Create an instance of {@link Market.CapFloorVolatilities }
     * 
     */
    public Market.CapFloorVolatilities createMarketCapFloorVolatilities() {
        return new Market.CapFloorVolatilities();
    }

    /**
     * Create an instance of {@link Market.CapFloorVolatilities.DayCounters }
     * 
     */
    public Market.CapFloorVolatilities.DayCounters createMarketCapFloorVolatilitiesDayCounters() {
        return new Market.CapFloorVolatilities.DayCounters();
    }

    /**
     * Create an instance of {@link Market.YieldVolatilities }
     * 
     */
    public Market.YieldVolatilities createMarketYieldVolatilities() {
        return new Market.YieldVolatilities();
    }

    /**
     * Create an instance of {@link Market.YieldVolatilities.DayCounters }
     * 
     */
    public Market.YieldVolatilities.DayCounters createMarketYieldVolatilitiesDayCounters() {
        return new Market.YieldVolatilities.DayCounters();
    }

    /**
     * Create an instance of {@link Market.SwaptionVolatilities }
     * 
     */
    public Market.SwaptionVolatilities createMarketSwaptionVolatilities() {
        return new Market.SwaptionVolatilities();
    }

    /**
     * Create an instance of {@link Market.SwaptionVolatilities.DayCounters }
     * 
     */
    public Market.SwaptionVolatilities.DayCounters createMarketSwaptionVolatilitiesDayCounters() {
        return new Market.SwaptionVolatilities.DayCounters();
    }

    /**
     * Create an instance of {@link Market.Equities }
     * 
     */
    public Market.Equities createMarketEquities() {
        return new Market.Equities();
    }

    /**
     * Create an instance of {@link Market.DefaultCurves }
     * 
     */
    public Market.DefaultCurves createMarketDefaultCurves() {
        return new Market.DefaultCurves();
    }

    /**
     * Create an instance of {@link Market.DefaultCurves.Calendars }
     * 
     */
    public Market.DefaultCurves.Calendars createMarketDefaultCurvesCalendars() {
        return new Market.DefaultCurves.Calendars();
    }

    /**
     * Create an instance of {@link Market.DefaultCurves.DayCounters }
     * 
     */
    public Market.DefaultCurves.DayCounters createMarketDefaultCurvesDayCounters() {
        return new Market.DefaultCurves.DayCounters();
    }

    /**
     * Create an instance of {@link Market.SwapIndices }
     * 
     */
    public Market.SwapIndices createMarketSwapIndices() {
        return new Market.SwapIndices();
    }

    /**
     * Create an instance of {@link Market.FxRates }
     * 
     */
    public Market.FxRates createMarketFxRates() {
        return new Market.FxRates();
    }

    /**
     * Create an instance of {@link Market.YieldCurves }
     * 
     */
    public Market.YieldCurves createMarketYieldCurves() {
        return new Market.YieldCurves();
    }

    /**
     * Create an instance of {@link CommodityCurvesType }
     * 
     */
    public CommodityCurvesType createCommodityCurvesType() {
        return new CommodityCurvesType();
    }

    /**
     * Create an instance of {@link Stresscapfloorvolatility }
     * 
     */
    public Stresscapfloorvolatility createStresscapfloorvolatility() {
        return new Stresscapfloorvolatility();
    }

    /**
     * Create an instance of {@link Stresscapfloorvolatility.Shifts }
     * 
     */
    public Stresscapfloorvolatility.Shifts createStresscapfloorvolatilityShifts() {
        return new Stresscapfloorvolatility.Shifts();
    }

    /**
     * Create an instance of {@link IndexReferenceDatum }
     * 
     */
    public IndexReferenceDatum createIndexReferenceDatum() {
        return new IndexReferenceDatum();
    }

    /**
     * Create an instance of {@link PricesType }
     * 
     */
    public PricesType createPricesType() {
        return new PricesType();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility createSwaptionVolatility() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility.ProxyConfig }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility.ProxyConfig createSwaptionVolatilityProxyConfig() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility.ProxyConfig();
    }

    /**
     * Create an instance of {@link JarrowYildrim }
     * 
     */
    public JarrowYildrim createJarrowYildrim() {
        return new JarrowYildrim();
    }

    /**
     * Create an instance of {@link FxSpotsType }
     * 
     */
    public FxSpotsType createFxSpotsType() {
        return new FxSpotsType();
    }

    /**
     * Create an instance of {@link AccumulatorData }
     * 
     */
    public AccumulatorData createAccumulatorData() {
        return new AccumulatorData();
    }

    /**
     * Create an instance of {@link CreditIndexReferenceDatum }
     * 
     */
    public CreditIndexReferenceDatum createCreditIndexReferenceDatum() {
        return new CreditIndexReferenceDatum();
    }

    /**
     * Create an instance of {@link TrsUnderlyingData }
     * 
     */
    public TrsUnderlyingData createTrsUnderlyingData() {
        return new TrsUnderlyingData();
    }

    /**
     * Create an instance of {@link QuantitiesType }
     * 
     */
    public QuantitiesType createQuantitiesType() {
        return new QuantitiesType();
    }

    /**
     * Create an instance of {@link FlexiSwapData }
     * 
     */
    public FlexiSwapData createFlexiSwapData() {
        return new FlexiSwapData();
    }

    /**
     * Create an instance of {@link FlexiSwapData.Prepayment }
     * 
     */
    public FlexiSwapData.Prepayment createFlexiSwapDataPrepayment() {
        return new FlexiSwapData.Prepayment();
    }

    /**
     * Create an instance of {@link FlexiSwapData.Prepayment.PrepaymentOptions }
     * 
     */
    public FlexiSwapData.Prepayment.PrepaymentOptions createFlexiSwapDataPrepaymentPrepaymentOptions() {
        return new FlexiSwapData.Prepayment.PrepaymentOptions();
    }

    /**
     * Create an instance of {@link FlexiSwapData.LowerNotionalBounds }
     * 
     */
    public FlexiSwapData.LowerNotionalBounds createFlexiSwapDataLowerNotionalBounds() {
        return new FlexiSwapData.LowerNotionalBounds();
    }

    /**
     * Create an instance of {@link Parconversion }
     * 
     */
    public Parconversion createParconversion() {
        return new Parconversion();
    }

    /**
     * Create an instance of {@link Parconversion.Conventions }
     * 
     */
    public Parconversion.Conventions createParconversionConventions() {
        return new Parconversion.Conventions();
    }

    /**
     * Create an instance of {@link TarfData2 }
     * 
     */
    public TarfData2 createTarfData2() {
        return new TarfData2();
    }

    /**
     * Create an instance of {@link TarfData2 .RangeBoundSet }
     * 
     */
    public TarfData2 .RangeBoundSet createTarfData2RangeBoundSet() {
        return new TarfData2 .RangeBoundSet();
    }

    /**
     * Create an instance of {@link TarfData2 .Strikes }
     * 
     */
    public TarfData2 .Strikes createTarfData2Strikes() {
        return new TarfData2 .Strikes();
    }

    /**
     * Create an instance of {@link RpaData }
     * 
     */
    public RpaData createRpaData() {
        return new RpaData();
    }

    /**
     * Create an instance of {@link SensitivityYieldVolatility }
     * 
     */
    public SensitivityYieldVolatility createSensitivityYieldVolatility() {
        return new SensitivityYieldVolatility();
    }

    /**
     * Create an instance of {@link SensitivityYieldVolatility.Shifts }
     * 
     */
    public SensitivityYieldVolatility.Shifts createSensitivityYieldVolatilityShifts() {
        return new SensitivityYieldVolatility.Shifts();
    }

    /**
     * Create an instance of {@link CreditNonQualifying }
     * 
     */
    public CreditNonQualifying createCreditNonQualifying() {
        return new CreditNonQualifying();
    }

    /**
     * Create an instance of {@link CreditNonQualifying.Correlations }
     * 
     */
    public CreditNonQualifying.Correlations createCreditNonQualifyingCorrelations() {
        return new CreditNonQualifying.Correlations();
    }

    /**
     * Create an instance of {@link CreditNonQualifying.Correlations.InterBucket }
     * 
     */
    public CreditNonQualifying.Correlations.InterBucket createCreditNonQualifyingCorrelationsInterBucket() {
        return new CreditNonQualifying.Correlations.InterBucket();
    }

    /**
     * Create an instance of {@link CreditNonQualifying.Correlations.IntraBucket }
     * 
     */
    public CreditNonQualifying.Correlations.IntraBucket createCreditNonQualifyingCorrelationsIntraBucket() {
        return new CreditNonQualifying.Correlations.IntraBucket();
    }

    /**
     * Create an instance of {@link CreditNonQualifying.RiskWeights }
     * 
     */
    public CreditNonQualifying.RiskWeights createCreditNonQualifyingRiskWeights() {
        return new CreditNonQualifying.RiskWeights();
    }

    /**
     * Create an instance of {@link CreditNonQualifying.RiskWeights.Delta }
     * 
     */
    public CreditNonQualifying.RiskWeights.Delta createCreditNonQualifyingRiskWeightsDelta() {
        return new CreditNonQualifying.RiskWeights.Delta();
    }

    /**
     * Create an instance of {@link ForwardBondData }
     * 
     */
    public ForwardBondData createForwardBondData() {
        return new ForwardBondData();
    }

    /**
     * Create an instance of {@link CurrencyHedgedIndexReferenceDatum }
     * 
     */
    public CurrencyHedgedIndexReferenceDatum createCurrencyHedgedIndexReferenceDatum() {
        return new CurrencyHedgedIndexReferenceDatum();
    }

    /**
     * Create an instance of {@link CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate }
     * 
     */
    public CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate createCurrencyHedgedIndexReferenceDatumIndexWeightsAtLastRebalancingDate() {
        return new CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate();
    }

    /**
     * Create an instance of {@link CurrencyHedgedIndexReferenceDatum.FxIndexes }
     * 
     */
    public CurrencyHedgedIndexReferenceDatum.FxIndexes createCurrencyHedgedIndexReferenceDatumFxIndexes() {
        return new CurrencyHedgedIndexReferenceDatum.FxIndexes();
    }

    /**
     * Create an instance of {@link CurrencyLists }
     * 
     */
    public CurrencyLists createCurrencyLists() {
        return new CurrencyLists();
    }

    /**
     * Create an instance of {@link Autocallable01Data }
     * 
     */
    public Autocallable01Data createAutocallable01Data() {
        return new Autocallable01Data();
    }

    /**
     * Create an instance of {@link WorstOfBasketSwapData2 }
     * 
     */
    public WorstOfBasketSwapData2 createWorstOfBasketSwapData2() {
        return new WorstOfBasketSwapData2();
    }

    /**
     * Create an instance of {@link SecuritiesType }
     * 
     */
    public SecuritiesType createSecuritiesType() {
        return new SecuritiesType();
    }

    /**
     * Create an instance of {@link ParameterListType }
     * 
     */
    public ParameterListType createParameterListType() {
        return new ParameterListType();
    }

    /**
     * Create an instance of {@link CalibrationConfiguration }
     * 
     */
    public CalibrationConfiguration createCalibrationConfiguration() {
        return new CalibrationConfiguration();
    }

    /**
     * Create an instance of {@link FxVolatilitiesType }
     * 
     */
    public FxVolatilitiesType createFxVolatilitiesType() {
        return new FxVolatilitiesType();
    }

    /**
     * Create an instance of {@link LegDataCapfloor }
     * 
     */
    public LegDataCapfloor createLegDataCapfloor() {
        return new LegDataCapfloor();
    }

    /**
     * Create an instance of {@link LegDataCapfloor.Notionals }
     * 
     */
    public LegDataCapfloor.Notionals createLegDataCapfloorNotionals() {
        return new LegDataCapfloor.Notionals();
    }

    /**
     * Create an instance of {@link OptionPaymentData }
     * 
     */
    public OptionPaymentData createOptionPaymentData() {
        return new OptionPaymentData();
    }

    /**
     * Create an instance of {@link SwapIndexCurvesType }
     * 
     */
    public SwapIndexCurvesType createSwapIndexCurvesType() {
        return new SwapIndexCurvesType();
    }

    /**
     * Create an instance of {@link GenericBarrierOptionData }
     * 
     */
    public GenericBarrierOptionData createGenericBarrierOptionData() {
        return new GenericBarrierOptionData();
    }

    /**
     * Create an instance of {@link CrossCurrencyLGM }
     * 
     */
    public CrossCurrencyLGM createCrossCurrencyLGM() {
        return new CrossCurrencyLGM();
    }

    /**
     * Create an instance of {@link SwaptionVolatilitiesType }
     * 
     */
    public SwaptionVolatilitiesType createSwaptionVolatilitiesType() {
        return new SwaptionVolatilitiesType();
    }

    /**
     * Create an instance of {@link DefaultCurvesType }
     * 
     */
    public DefaultCurvesType createDefaultCurvesType() {
        return new DefaultCurvesType();
    }

    /**
     * Create an instance of {@link Lgm }
     * 
     */
    public Lgm createLgm() {
        return new Lgm();
    }

    /**
     * Create an instance of {@link YieldCurvesType }
     * 
     */
    public YieldCurvesType createYieldCurvesType() {
        return new YieldCurvesType();
    }

    /**
     * Create an instance of {@link IndexForwardingCurvesType }
     * 
     */
    public IndexForwardingCurvesType createIndexForwardingCurvesType() {
        return new IndexForwardingCurvesType();
    }

    /**
     * Create an instance of {@link Envelope }
     * 
     */
    public Envelope createEnvelope() {
        return new Envelope();
    }

    /**
     * Create an instance of {@link FittedBondType }
     * 
     */
    public FittedBondType createFittedBondType() {
        return new FittedBondType();
    }

    /**
     * Create an instance of {@link FittedBondType.IborIndexCurves }
     * 
     */
    public FittedBondType.IborIndexCurves createFittedBondTypeIborIndexCurves() {
        return new FittedBondType.IborIndexCurves();
    }

    /**
     * Create an instance of {@link Crlgm }
     * 
     */
    public Crlgm createCrlgm() {
        return new Crlgm();
    }

    /**
     * Create an instance of {@link StFreeStyleEventScheduleBase }
     * 
     */
    public StFreeStyleEventScheduleBase createStFreeStyleEventScheduleBase() {
        return new StFreeStyleEventScheduleBase();
    }

    /**
     * Create an instance of {@link FxKIKOBarrierOptionData }
     * 
     */
    public FxKIKOBarrierOptionData createFxKIKOBarrierOptionData() {
        return new FxKIKOBarrierOptionData();
    }

    /**
     * Create an instance of {@link CreditQualifying }
     * 
     */
    public CreditQualifying createCreditQualifying() {
        return new CreditQualifying();
    }

    /**
     * Create an instance of {@link CreditQualifying.Correlations }
     * 
     */
    public CreditQualifying.Correlations createCreditQualifyingCorrelations() {
        return new CreditQualifying.Correlations();
    }

    /**
     * Create an instance of {@link CreditQualifying.Correlations.InterBucket }
     * 
     */
    public CreditQualifying.Correlations.InterBucket createCreditQualifyingCorrelationsInterBucket() {
        return new CreditQualifying.Correlations.InterBucket();
    }

    /**
     * Create an instance of {@link CreditQualifying.Correlations.IntraBucket }
     * 
     */
    public CreditQualifying.Correlations.IntraBucket createCreditQualifyingCorrelationsIntraBucket() {
        return new CreditQualifying.Correlations.IntraBucket();
    }

    /**
     * Create an instance of {@link CreditQualifying.RiskWeights }
     * 
     */
    public CreditQualifying.RiskWeights createCreditQualifyingRiskWeights() {
        return new CreditQualifying.RiskWeights();
    }

    /**
     * Create an instance of {@link CreditQualifying.RiskWeights.Delta }
     * 
     */
    public CreditQualifying.RiskWeights.Delta createCreditQualifyingRiskWeightsDelta() {
        return new CreditQualifying.RiskWeights.Delta();
    }

    /**
     * Create an instance of {@link YyInflationIndexCurvesType }
     * 
     */
    public YyInflationIndexCurvesType createYyInflationIndexCurvesType() {
        return new YyInflationIndexCurvesType();
    }

    /**
     * Create an instance of {@link Tranche }
     * 
     */
    public Tranche createTranche() {
        return new Tranche();
    }

    /**
     * Create an instance of {@link Tranche.Notionals }
     * 
     */
    public Tranche.Notionals createTrancheNotionals() {
        return new Tranche.Notionals();
    }

    /**
     * Create an instance of {@link TradeLevelFixings }
     * 
     */
    public TradeLevelFixings createTradeLevelFixings() {
        return new TradeLevelFixings();
    }

    /**
     * Create an instance of {@link EquityVolatilitiesType }
     * 
     */
    public EquityVolatilitiesType createEquityVolatilitiesType() {
        return new EquityVolatilitiesType();
    }

    /**
     * Create an instance of {@link CreditLinkedSwapData }
     * 
     */
    public CreditLinkedSwapData createCreditLinkedSwapData() {
        return new CreditLinkedSwapData();
    }

    /**
     * Create an instance of {@link GlobalReportConfiguration }
     * 
     */
    public GlobalReportConfiguration createGlobalReportConfiguration() {
        return new GlobalReportConfiguration();
    }

    /**
     * Create an instance of {@link EqForwardSettlementData }
     * 
     */
    public EqForwardSettlementData createEqForwardSettlementData() {
        return new EqForwardSettlementData();
    }

    /**
     * Create an instance of {@link CbConversionResetData }
     * 
     */
    public CbConversionResetData createCbConversionResetData() {
        return new CbConversionResetData();
    }

    /**
     * Create an instance of {@link CbConversionResetData.GlobalFloors }
     * 
     */
    public CbConversionResetData.GlobalFloors createCbConversionResetDataGlobalFloors() {
        return new CbConversionResetData.GlobalFloors();
    }

    /**
     * Create an instance of {@link CbConversionResetData.Floors }
     * 
     */
    public CbConversionResetData.Floors createCbConversionResetDataFloors() {
        return new CbConversionResetData.Floors();
    }

    /**
     * Create an instance of {@link CbConversionResetData.Gearings }
     * 
     */
    public CbConversionResetData.Gearings createCbConversionResetDataGearings() {
        return new CbConversionResetData.Gearings();
    }

    /**
     * Create an instance of {@link CbConversionResetData.Thresholds }
     * 
     */
    public CbConversionResetData.Thresholds createCbConversionResetDataThresholds() {
        return new CbConversionResetData.Thresholds();
    }

    /**
     * Create an instance of {@link CbConversionResetData.References }
     * 
     */
    public CbConversionResetData.References createCbConversionResetDataReferences() {
        return new CbConversionResetData.References();
    }

    /**
     * Create an instance of {@link CompositeQuoteType }
     * 
     */
    public CompositeQuoteType createCompositeQuoteType() {
        return new CompositeQuoteType();
    }

    /**
     * Create an instance of {@link OreScript }
     * 
     */
    public OreScript createOreScript() {
        return new OreScript();
    }

    /**
     * Create an instance of {@link OreScript.AmcCg }
     * 
     */
    public OreScript.AmcCg createOreScriptAmcCg() {
        return new OreScript.AmcCg();
    }

    /**
     * Create an instance of {@link OreScript.ConditionalExpectation }
     * 
     */
    public OreScript.ConditionalExpectation createOreScriptConditionalExpectation() {
        return new OreScript.ConditionalExpectation();
    }

    /**
     * Create an instance of {@link OreScript.NewSchedules }
     * 
     */
    public OreScript.NewSchedules createOreScriptNewSchedules() {
        return new OreScript.NewSchedules();
    }

    /**
     * Create an instance of {@link OreScript.NewSchedules.NewSchedule }
     * 
     */
    public OreScript.NewSchedules.NewSchedule createOreScriptNewSchedulesNewSchedule() {
        return new OreScript.NewSchedules.NewSchedule();
    }

    /**
     * Create an instance of {@link OreScript.CalibrationSpec }
     * 
     */
    public OreScript.CalibrationSpec createOreScriptCalibrationSpec() {
        return new OreScript.CalibrationSpec();
    }

    /**
     * Create an instance of {@link OreScript.CalibrationSpec.Calibration }
     * 
     */
    public OreScript.CalibrationSpec.Calibration createOreScriptCalibrationSpecCalibration() {
        return new OreScript.CalibrationSpec.Calibration();
    }

    /**
     * Create an instance of {@link OreScript.PricingEngineConfigOverwrite }
     * 
     */
    public OreScript.PricingEngineConfigOverwrite createOreScriptPricingEngineConfigOverwrite() {
        return new OreScript.PricingEngineConfigOverwrite();
    }

    /**
     * Create an instance of {@link OreScript.PricingEngineConfigOverwrite.EngineParameters }
     * 
     */
    public OreScript.PricingEngineConfigOverwrite.EngineParameters createOreScriptPricingEngineConfigOverwriteEngineParameters() {
        return new OreScript.PricingEngineConfigOverwrite.EngineParameters();
    }

    /**
     * Create an instance of {@link OreScript.PricingEngineConfigOverwrite.ModelParameters }
     * 
     */
    public OreScript.PricingEngineConfigOverwrite.ModelParameters createOreScriptPricingEngineConfigOverwriteModelParameters() {
        return new OreScript.PricingEngineConfigOverwrite.ModelParameters();
    }

    /**
     * Create an instance of {@link OreScript.Results }
     * 
     */
    public OreScript.Results createOreScriptResults() {
        return new OreScript.Results();
    }

    /**
     * Create an instance of {@link LegData }
     * 
     */
    public LegData createLegData() {
        return new LegData();
    }

    /**
     * Create an instance of {@link LegData.Notionals }
     * 
     */
    public LegData.Notionals createLegDataNotionals() {
        return new LegData.Notionals();
    }

    /**
     * Create an instance of {@link CommodityVolatilitiesType }
     * 
     */
    public CommodityVolatilitiesType createCommodityVolatilitiesType() {
        return new CommodityVolatilitiesType();
    }

    /**
     * Create an instance of {@link PerformanceOption01Data }
     * 
     */
    public PerformanceOption01Data createPerformanceOption01Data() {
        return new PerformanceOption01Data();
    }

    /**
     * Create an instance of {@link ZeroInflationCapFloorVolatilitiesType }
     * 
     */
    public ZeroInflationCapFloorVolatilitiesType createZeroInflationCapFloorVolatilitiesType() {
        return new ZeroInflationCapFloorVolatilitiesType();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Transitionmatrix }
     * 
     */
    public Transitionmatrix createTransitionmatrix() {
        return new Transitionmatrix();
    }

    /**
     * Create an instance of {@link InterestRate }
     * 
     */
    public InterestRate createInterestRate() {
        return new InterestRate();
    }

    /**
     * Create an instance of {@link InterestRate.Correlations }
     * 
     */
    public InterestRate.Correlations createInterestRateCorrelations() {
        return new InterestRate.Correlations();
    }

    /**
     * Create an instance of {@link InterestRate.Correlations.IntraBucket }
     * 
     */
    public InterestRate.Correlations.IntraBucket createInterestRateCorrelationsIntraBucket() {
        return new InterestRate.Correlations.IntraBucket();
    }

    /**
     * Create an instance of {@link InterestRate.RiskWeights }
     * 
     */
    public InterestRate.RiskWeights createInterestRateRiskWeights() {
        return new InterestRate.RiskWeights();
    }

    /**
     * Create an instance of {@link InterestRate.RiskWeights.Delta }
     * 
     */
    public InterestRate.RiskWeights.Delta createInterestRateRiskWeightsDelta() {
        return new InterestRate.RiskWeights.Delta();
    }

    /**
     * Create an instance of {@link BarrierData }
     * 
     */
    public BarrierData createBarrierData() {
        return new BarrierData();
    }

    /**
     * Create an instance of {@link CallableBondCallData }
     * 
     */
    public CallableBondCallData createCallableBondCallData() {
        return new CallableBondCallData();
    }

    /**
     * Create an instance of {@link CallableBondCallData.IncludeAccruals }
     * 
     */
    public CallableBondCallData.IncludeAccruals createCallableBondCallDataIncludeAccruals() {
        return new CallableBondCallData.IncludeAccruals();
    }

    /**
     * Create an instance of {@link CallableBondCallData.PriceTypes }
     * 
     */
    public CallableBondCallData.PriceTypes createCallableBondCallDataPriceTypes() {
        return new CallableBondCallData.PriceTypes();
    }

    /**
     * Create an instance of {@link CallableBondCallData.Prices }
     * 
     */
    public CallableBondCallData.Prices createCallableBondCallDataPrices() {
        return new CallableBondCallData.Prices();
    }

    /**
     * Create an instance of {@link CallableBondCallData.Styles }
     * 
     */
    public CallableBondCallData.Styles createCallableBondCallDataStyles() {
        return new CallableBondCallData.Styles();
    }

    /**
     * Create an instance of {@link CounterPartyCorrelations }
     * 
     */
    public CounterPartyCorrelations createCounterPartyCorrelations() {
        return new CounterPartyCorrelations();
    }

    /**
     * Create an instance of {@link TrsReturnData }
     * 
     */
    public TrsReturnData createTrsReturnData() {
        return new TrsReturnData();
    }

    /**
     * Create an instance of {@link BondYieldShiftedType }
     * 
     */
    public BondYieldShiftedType createBondYieldShiftedType() {
        return new BondYieldShiftedType();
    }

    /**
     * Create an instance of {@link BondYieldShiftedType.IborIndexCurves }
     * 
     */
    public BondYieldShiftedType.IborIndexCurves createBondYieldShiftedTypeIborIndexCurves() {
        return new BondYieldShiftedType.IborIndexCurves();
    }

    /**
     * Create an instance of {@link CommodityFutureType }
     * 
     */
    public CommodityFutureType createCommodityFutureType() {
        return new CommodityFutureType();
    }

    /**
     * Create an instance of {@link DiscountCurvesType }
     * 
     */
    public DiscountCurvesType createDiscountCurvesType() {
        return new DiscountCurvesType();
    }

    /**
     * Create an instance of {@link YieldPlusDefaultType }
     * 
     */
    public YieldPlusDefaultType createYieldPlusDefaultType() {
        return new YieldPlusDefaultType();
    }

    /**
     * Create an instance of {@link Hw }
     * 
     */
    public Hw createHw() {
        return new Hw();
    }

    /**
     * Create an instance of {@link Hw.Reversion }
     * 
     */
    public Hw.Reversion createHwReversion() {
        return new Hw.Reversion();
    }

    /**
     * Create an instance of {@link Hw.Volatility }
     * 
     */
    public Hw.Volatility createHwVolatility() {
        return new Hw.Volatility();
    }

    /**
     * Create an instance of {@link Hw.Volatility.InitialValue }
     * 
     */
    public Hw.Volatility.InitialValue createHwVolatilityInitialValue() {
        return new Hw.Volatility.InitialValue();
    }

    /**
     * Create an instance of {@link AssetBackedCreditDefaultSwapData }
     * 
     */
    public AssetBackedCreditDefaultSwapData createAssetBackedCreditDefaultSwapData() {
        return new AssetBackedCreditDefaultSwapData();
    }

    /**
     * Create an instance of {@link YyInflationCapFloorVolatilitiesType }
     * 
     */
    public YyInflationCapFloorVolatilitiesType createYyInflationCapFloorVolatilitiesType() {
        return new YyInflationCapFloorVolatilitiesType();
    }

    /**
     * Create an instance of {@link Fx }
     * 
     */
    public Fx createFx() {
        return new Fx();
    }

    /**
     * Create an instance of {@link Fx.Correlations }
     * 
     */
    public Fx.Correlations createFxCorrelations() {
        return new Fx.Correlations();
    }

    /**
     * Create an instance of {@link Fx.Correlations.IntraBucket }
     * 
     */
    public Fx.Correlations.IntraBucket createFxCorrelationsIntraBucket() {
        return new Fx.Correlations.IntraBucket();
    }

    /**
     * Create an instance of {@link Fx.RiskWeights }
     * 
     */
    public Fx.RiskWeights createFxRiskWeights() {
        return new Fx.RiskWeights();
    }

    /**
     * Create an instance of {@link Fx.RiskWeights.Delta }
     * 
     */
    public Fx.RiskWeights.Delta createFxRiskWeightsDelta() {
        return new Fx.RiskWeights.Delta();
    }

    /**
     * Create an instance of {@link Cir }
     * 
     */
    public Cir createCir() {
        return new Cir();
    }

    /**
     * Create an instance of {@link ZeroInflationIndexCurvesType }
     * 
     */
    public ZeroInflationIndexCurvesType createZeroInflationIndexCurvesType() {
        return new ZeroInflationIndexCurvesType();
    }

    /**
     * Create an instance of {@link CbConversionData }
     * 
     */
    public CbConversionData createCbConversionData() {
        return new CbConversionData();
    }

    /**
     * Create an instance of {@link CbConversionData.FixedAmountConversion }
     * 
     */
    public CbConversionData.FixedAmountConversion createCbConversionDataFixedAmountConversion() {
        return new CbConversionData.FixedAmountConversion();
    }

    /**
     * Create an instance of {@link CbConversionData.FixedAmountConversion.Amounts }
     * 
     */
    public CbConversionData.FixedAmountConversion.Amounts createCbConversionDataFixedAmountConversionAmounts() {
        return new CbConversionData.FixedAmountConversion.Amounts();
    }

    /**
     * Create an instance of {@link CbConversionData.ConversionRatios }
     * 
     */
    public CbConversionData.ConversionRatios createCbConversionDataConversionRatios() {
        return new CbConversionData.ConversionRatios();
    }

    /**
     * Create an instance of {@link CbConversionData.Styles }
     * 
     */
    public CbConversionData.Styles createCbConversionDataStyles() {
        return new CbConversionData.Styles();
    }

    /**
     * Create an instance of {@link CdsVolatility }
     * 
     */
    public CdsVolatility createCdsVolatility() {
        return new CdsVolatility();
    }

    /**
     * Create an instance of {@link CdsVolatility.Terms }
     * 
     */
    public CdsVolatility.Terms createCdsVolatilityTerms() {
        return new CdsVolatility.Terms();
    }

    /**
     * Create an instance of {@link BaseCorrelationsType }
     * 
     */
    public BaseCorrelationsType createBaseCorrelationsType() {
        return new BaseCorrelationsType();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve createDefaultCurve() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations createDefaultCurveConfigurations() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations.Configuration }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations.Configuration createDefaultCurveConfigurationsConfiguration() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations.Configuration();
    }

    /**
     * Create an instance of {@link FxOptionTimeWeighting }
     * 
     */
    public FxOptionTimeWeighting createFxOptionTimeWeighting() {
        return new FxOptionTimeWeighting();
    }

    /**
     * Create an instance of {@link FxOptionTimeWeighting.Events }
     * 
     */
    public FxOptionTimeWeighting.Events createFxOptionTimeWeightingEvents() {
        return new FxOptionTimeWeighting.Events();
    }

    /**
     * Create an instance of {@link FxOptionTimeWeighting.TradingCenters }
     * 
     */
    public FxOptionTimeWeighting.TradingCenters createFxOptionTimeWeightingTradingCenters() {
        return new FxOptionTimeWeighting.TradingCenters();
    }

    /**
     * Create an instance of {@link ConcentrationThresholds }
     * 
     */
    public ConcentrationThresholds createConcentrationThresholds() {
        return new ConcentrationThresholds();
    }

    /**
     * Create an instance of {@link ConcentrationThresholds.Vega }
     * 
     */
    public ConcentrationThresholds.Vega createConcentrationThresholdsVega() {
        return new ConcentrationThresholds.Vega();
    }

    /**
     * Create an instance of {@link ConcentrationThresholds.Delta }
     * 
     */
    public ConcentrationThresholds.Delta createConcentrationThresholdsDelta() {
        return new ConcentrationThresholds.Delta();
    }

    /**
     * Create an instance of {@link CbCallData }
     * 
     */
    public CbCallData createCbCallData() {
        return new CbCallData();
    }

    /**
     * Create an instance of {@link CbCallData.MakeWhole }
     * 
     */
    public CbCallData.MakeWhole createCbCallDataMakeWhole() {
        return new CbCallData.MakeWhole();
    }

    /**
     * Create an instance of {@link CbCallData.MakeWhole.ConversionRatioIncrease }
     * 
     */
    public CbCallData.MakeWhole.ConversionRatioIncrease createCbCallDataMakeWholeConversionRatioIncrease() {
        return new CbCallData.MakeWhole.ConversionRatioIncrease();
    }

    /**
     * Create an instance of {@link CbCallData.MakeWhole.ConversionRatioIncrease.CrIncreases }
     * 
     */
    public CbCallData.MakeWhole.ConversionRatioIncrease.CrIncreases createCbCallDataMakeWholeConversionRatioIncreaseCrIncreases() {
        return new CbCallData.MakeWhole.ConversionRatioIncrease.CrIncreases();
    }

    /**
     * Create an instance of {@link CbCallData.NOfMTriggers }
     * 
     */
    public CbCallData.NOfMTriggers createCbCallDataNOfMTriggers() {
        return new CbCallData.NOfMTriggers();
    }

    /**
     * Create an instance of {@link CbCallData.TriggerRatios }
     * 
     */
    public CbCallData.TriggerRatios createCbCallDataTriggerRatios() {
        return new CbCallData.TriggerRatios();
    }

    /**
     * Create an instance of {@link CbCallData.Soft }
     * 
     */
    public CbCallData.Soft createCbCallDataSoft() {
        return new CbCallData.Soft();
    }

    /**
     * Create an instance of {@link CbCallData.IncludeAccruals }
     * 
     */
    public CbCallData.IncludeAccruals createCbCallDataIncludeAccruals() {
        return new CbCallData.IncludeAccruals();
    }

    /**
     * Create an instance of {@link CbCallData.PriceTypes }
     * 
     */
    public CbCallData.PriceTypes createCbCallDataPriceTypes() {
        return new CbCallData.PriceTypes();
    }

    /**
     * Create an instance of {@link CbCallData.Prices }
     * 
     */
    public CbCallData.Prices createCbCallDataPrices() {
        return new CbCallData.Prices();
    }

    /**
     * Create an instance of {@link CbCallData.Styles }
     * 
     */
    public CbCallData.Styles createCbCallDataStyles() {
        return new CbCallData.Styles();
    }

    /**
     * Create an instance of {@link CdsVolatilitiesType }
     * 
     */
    public CdsVolatilitiesType createCdsVolatilitiesType() {
        return new CdsVolatilitiesType();
    }

    /**
     * Create an instance of {@link CorrelationsType }
     * 
     */
    public CorrelationsType createCorrelationsType() {
        return new CorrelationsType();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.PremiumData }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.PremiumData createPremiumData() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.PremiumData();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.PremiumData.Premium }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.PremiumData.Premium createPremiumDataPremium() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.PremiumData.Premium();
    }

    /**
     * Create an instance of {@link SensitivitySwaptionVolatility }
     * 
     */
    public SensitivitySwaptionVolatility createSensitivitySwaptionVolatility() {
        return new SensitivitySwaptionVolatility();
    }

    /**
     * Create an instance of {@link SensitivitySwaptionVolatility.Shifts }
     * 
     */
    public SensitivitySwaptionVolatility.Shifts createSensitivitySwaptionVolatilityShifts() {
        return new SensitivitySwaptionVolatility.Shifts();
    }

    /**
     * Create an instance of {@link ProhibitedExpiriesType }
     * 
     */
    public ProhibitedExpiriesType createProhibitedExpiriesType() {
        return new ProhibitedExpiriesType();
    }

    /**
     * Create an instance of {@link ProhibitedExpiriesType.Dates }
     * 
     */
    public ProhibitedExpiriesType.Dates createProhibitedExpiriesTypeDates() {
        return new ProhibitedExpiriesType.Dates();
    }

    /**
     * Create an instance of {@link OptionData }
     * 
     */
    public OptionData createOptionData() {
        return new OptionData();
    }

    /**
     * Create an instance of {@link OptionData.ExerciseFees }
     * 
     */
    public OptionData.ExerciseFees createOptionDataExerciseFees() {
        return new OptionData.ExerciseFees();
    }

    /**
     * Create an instance of {@link CbContingentConversionData }
     * 
     */
    public CbContingentConversionData createCbContingentConversionData() {
        return new CbContingentConversionData();
    }

    /**
     * Create an instance of {@link CbContingentConversionData.Barriers }
     * 
     */
    public CbContingentConversionData.Barriers createCbContingentConversionDataBarriers() {
        return new CbContingentConversionData.Barriers();
    }

    /**
     * Create an instance of {@link CbContingentConversionData.Observations }
     * 
     */
    public CbContingentConversionData.Observations createCbContingentConversionDataObservations() {
        return new CbContingentConversionData.Observations();
    }

    /**
     * Create an instance of {@link TotalReturnData }
     * 
     */
    public TotalReturnData createTotalReturnData() {
        return new TotalReturnData();
    }

    /**
     * Create an instance of {@link QuoteType }
     * 
     */
    public QuoteType createQuoteType() {
        return new QuoteType();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility createCapFloorVolatility() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility.ProxyConfig }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility.ProxyConfig createCapFloorVolatilityProxyConfig() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility.ProxyConfig();
    }

    /**
     * Create an instance of {@link Commodity }
     * 
     */
    public Commodity createCommodity() {
        return new Commodity();
    }

    /**
     * Create an instance of {@link Commodity.Correlations }
     * 
     */
    public Commodity.Correlations createCommodityCorrelations() {
        return new Commodity.Correlations();
    }

    /**
     * Create an instance of {@link Commodity.Correlations.InterBucket }
     * 
     */
    public Commodity.Correlations.InterBucket createCommodityCorrelationsInterBucket() {
        return new Commodity.Correlations.InterBucket();
    }

    /**
     * Create an instance of {@link Commodity.Correlations.IntraBucket }
     * 
     */
    public Commodity.Correlations.IntraBucket createCommodityCorrelationsIntraBucket() {
        return new Commodity.Correlations.IntraBucket();
    }

    /**
     * Create an instance of {@link Commodity.RiskWeights }
     * 
     */
    public Commodity.RiskWeights createCommodityRiskWeights() {
        return new Commodity.RiskWeights();
    }

    /**
     * Create an instance of {@link Commodity.RiskWeights.Delta }
     * 
     */
    public Commodity.RiskWeights.Delta createCommodityRiskWeightsDelta() {
        return new Commodity.RiskWeights.Delta();
    }

    /**
     * Create an instance of {@link AnalyticsType }
     * 
     */
    public AnalyticsType createAnalyticsType() {
        return new AnalyticsType();
    }

    /**
     * Create an instance of {@link FxForwardSettlementData }
     * 
     */
    public FxForwardSettlementData createFxForwardSettlementData() {
        return new FxForwardSettlementData();
    }

    /**
     * Create an instance of {@link CurveAlgebraCurveOperation }
     * 
     */
    public CurveAlgebraCurveOperation createCurveAlgebraCurveOperation() {
        return new CurveAlgebraCurveOperation();
    }

    /**
     * Create an instance of {@link CapFloorVolatilitiesType }
     * 
     */
    public CapFloorVolatilitiesType createCapFloorVolatilitiesType() {
        return new CapFloorVolatilitiesType();
    }

    /**
     * Create an instance of {@link Equity }
     * 
     */
    public Equity createEquity() {
        return new Equity();
    }

    /**
     * Create an instance of {@link Equity.Correlations }
     * 
     */
    public Equity.Correlations createEquityCorrelations() {
        return new Equity.Correlations();
    }

    /**
     * Create an instance of {@link Equity.Correlations.InterBucket }
     * 
     */
    public Equity.Correlations.InterBucket createEquityCorrelationsInterBucket() {
        return new Equity.Correlations.InterBucket();
    }

    /**
     * Create an instance of {@link Equity.Correlations.IntraBucket }
     * 
     */
    public Equity.Correlations.IntraBucket createEquityCorrelationsIntraBucket() {
        return new Equity.Correlations.IntraBucket();
    }

    /**
     * Create an instance of {@link Equity.RiskWeights }
     * 
     */
    public Equity.RiskWeights createEquityRiskWeights() {
        return new Equity.RiskWeights();
    }

    /**
     * Create an instance of {@link Equity.RiskWeights.Vega }
     * 
     */
    public Equity.RiskWeights.Vega createEquityRiskWeightsVega() {
        return new Equity.RiskWeights.Vega();
    }

    /**
     * Create an instance of {@link Equity.RiskWeights.Delta }
     * 
     */
    public Equity.RiskWeights.Delta createEquityRiskWeightsDelta() {
        return new Equity.RiskWeights.Delta();
    }

    /**
     * Create an instance of {@link CommoditySchwartz }
     * 
     */
    public CommoditySchwartz createCommoditySchwartz() {
        return new CommoditySchwartz();
    }

    /**
     * Create an instance of {@link Stressfxvolatility }
     * 
     */
    public Stressfxvolatility createStressfxvolatility() {
        return new Stressfxvolatility();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.EquityLegData }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.EquityLegData createEquityLegData() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.EquityLegData();
    }

    /**
     * Create an instance of {@link SimmCalibration }
     * 
     */
    public SimmCalibration createSimmCalibration() {
        return new SimmCalibration();
    }

    /**
     * Create an instance of {@link SimmCalibration.RiskClassCorrelations }
     * 
     */
    public SimmCalibration.RiskClassCorrelations createSimmCalibrationRiskClassCorrelations() {
        return new SimmCalibration.RiskClassCorrelations();
    }

    /**
     * Create an instance of {@link ZeroCouponFixedLegData }
     * 
     */
    public ZeroCouponFixedLegData createZeroCouponFixedLegData() {
        return new ZeroCouponFixedLegData();
    }

    /**
     * Create an instance of {@link ZeroCouponFixedLegData.Rates }
     * 
     */
    public ZeroCouponFixedLegData.Rates createZeroCouponFixedLegDataRates() {
        return new ZeroCouponFixedLegData.Rates();
    }

    /**
     * Create an instance of {@link CPILegData }
     * 
     */
    public CPILegData createCPILegData() {
        return new CPILegData();
    }

    /**
     * Create an instance of {@link CPILegData.Rates }
     * 
     */
    public CPILegData.Rates createCPILegDataRates() {
        return new CPILegData.Rates();
    }

    /**
     * Create an instance of {@link ScheduleData }
     * 
     */
    public ScheduleData createScheduleData() {
        return new ScheduleData();
    }

    /**
     * Create an instance of {@link ScheduleData.Dates }
     * 
     */
    public ScheduleData.Dates createScheduleDataDates() {
        return new ScheduleData.Dates();
    }

    /**
     * Create an instance of {@link BaselTrafficLightConfig.Configuration }
     * 
     */
    public BaselTrafficLightConfig.Configuration createBaselTrafficLightConfigConfiguration() {
        return new BaselTrafficLightConfig.Configuration();
    }

    /**
     * Create an instance of {@link DigitalCMSLegData }
     * 
     */
    public DigitalCMSLegData createDigitalCMSLegData() {
        return new DigitalCMSLegData();
    }

    /**
     * Create an instance of {@link CommodityFloatingLegData }
     * 
     */
    public CommodityFloatingLegData createCommodityFloatingLegData() {
        return new CommodityFloatingLegData();
    }

    /**
     * Create an instance of {@link CashflowData }
     * 
     */
    public CashflowData createCashflowData() {
        return new CashflowData();
    }

    /**
     * Create an instance of {@link CashflowData.Cashflow }
     * 
     */
    public CashflowData.Cashflow createCashflowDataCashflow() {
        return new CashflowData.Cashflow();
    }

    /**
     * Create an instance of {@link DigitalCMSSpreadLegData }
     * 
     */
    public DigitalCMSSpreadLegData createDigitalCMSSpreadLegData() {
        return new DigitalCMSSpreadLegData();
    }

    /**
     * Create an instance of {@link FixedLegData }
     * 
     */
    public FixedLegData createFixedLegData() {
        return new FixedLegData();
    }

    /**
     * Create an instance of {@link FixedLegData.Rates }
     * 
     */
    public FixedLegData.Rates createFixedLegDataRates() {
        return new FixedLegData.Rates();
    }

    /**
     * Create an instance of {@link CollateralBalances }
     * 
     */
    public CollateralBalances createCollateralBalances() {
        return new CollateralBalances();
    }

    /**
     * Create an instance of {@link CrossAssetModel }
     * 
     */
    public CrossAssetModel createCrossAssetModel() {
        return new CrossAssetModel();
    }

    /**
     * Create an instance of {@link CrossAssetModel.InstantaneousCorrelations }
     * 
     */
    public CrossAssetModel.InstantaneousCorrelations createCrossAssetModelInstantaneousCorrelations() {
        return new CrossAssetModel.InstantaneousCorrelations();
    }

    /**
     * Create an instance of {@link EquityMarginLegData }
     * 
     */
    public EquityMarginLegData createEquityMarginLegData() {
        return new EquityMarginLegData();
    }

    /**
     * Create an instance of {@link EquityMarginLegData.EquityLegData }
     * 
     */
    public EquityMarginLegData.EquityLegData createEquityMarginLegDataEquityLegData() {
        return new EquityMarginLegData.EquityLegData();
    }

    /**
     * Create an instance of {@link EquityMarginLegData.Rates }
     * 
     */
    public EquityMarginLegData.Rates createEquityMarginLegDataRates() {
        return new EquityMarginLegData.Rates();
    }

    /**
     * Create an instance of {@link Nettingsetdefinitions }
     * 
     */
    public Nettingsetdefinitions createNettingsetdefinitions() {
        return new Nettingsetdefinitions();
    }

    /**
     * Create an instance of {@link Nettingsetdefinitions.NettingSet }
     * 
     */
    public Nettingsetdefinitions.NettingSet createNettingsetdefinitionsNettingSet() {
        return new Nettingsetdefinitions.NettingSet();
    }

    /**
     * Create an instance of {@link Nettingsetdefinitions.NettingSet.CSADetails }
     * 
     */
    public Nettingsetdefinitions.NettingSet.CSADetails createNettingsetdefinitionsNettingSetCSADetails() {
        return new Nettingsetdefinitions.NettingSet.CSADetails();
    }

    /**
     * Create an instance of {@link Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals }
     * 
     */
    public Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals createNettingsetdefinitionsNettingSetCSADetailsEligibleCollaterals() {
        return new Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Conventions }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Conventions createConventions() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Conventions();
    }

    /**
     * Create an instance of {@link DerivedScheduleType }
     * 
     */
    public DerivedScheduleType createDerivedScheduleType() {
        return new DerivedScheduleType();
    }

    /**
     * Create an instance of {@link ReferenceInformation }
     * 
     */
    public ReferenceInformation createReferenceInformation() {
        return new ReferenceInformation();
    }

    /**
     * Create an instance of {@link YYLegData }
     * 
     */
    public YYLegData createYYLegData() {
        return new YYLegData();
    }

    /**
     * Create an instance of {@link IborFallbackConfig }
     * 
     */
    public IborFallbackConfig createIborFallbackConfig() {
        return new IborFallbackConfig();
    }

    /**
     * Create an instance of {@link IborFallbackGlobalSettings }
     * 
     */
    public IborFallbackGlobalSettings createIborFallbackGlobalSettings() {
        return new IborFallbackGlobalSettings();
    }

    /**
     * Create an instance of {@link IborFallbackFallbacks }
     * 
     */
    public IborFallbackFallbacks createIborFallbackFallbacks() {
        return new IborFallbackFallbacks();
    }

    /**
     * Create an instance of {@link Todaysmarket }
     * 
     */
    public Todaysmarket createTodaysmarket() {
        return new Todaysmarket();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Trade }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Trade createTrade() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Trade();
    }

    /**
     * Create an instance of {@link CurrencyDefinition }
     * 
     */
    public CurrencyDefinition createCurrencyDefinition() {
        return new CurrencyDefinition();
    }

    /**
     * Create an instance of {@link LevelData }
     * 
     */
    public LevelData createLevelData() {
        return new LevelData();
    }

    /**
     * Create an instance of {@link CurrencyConfig }
     * 
     */
    public CurrencyConfig createCurrencyConfig() {
        return new CurrencyConfig();
    }

    /**
     * Create an instance of {@link ReturnConfiguration }
     * 
     */
    public ReturnConfiguration createReturnConfiguration() {
        return new ReturnConfiguration();
    }

    /**
     * Create an instance of {@link ReturnType }
     * 
     */
    public ReturnType createReturnType() {
        return new ReturnType();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.CMSLegData }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.CMSLegData createCMSLegData() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.CMSLegData();
    }

    /**
     * Create an instance of {@link Calendaradjustment }
     * 
     */
    public Calendaradjustment createCalendaradjustment() {
        return new Calendaradjustment();
    }

    /**
     * Create an instance of {@link Underlyings }
     * 
     */
    public Underlyings createUnderlyings() {
        return new Underlyings();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Underlying }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Underlying createUnderlying() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Underlying();
    }

    /**
     * Create an instance of {@link Stresstesting }
     * 
     */
    public Stresstesting createStresstesting() {
        return new Stresstesting();
    }

    /**
     * Create an instance of {@link FloatingLegData }
     * 
     */
    public FloatingLegData createFloatingLegData() {
        return new FloatingLegData();
    }

    /**
     * Create an instance of {@link Ore }
     * 
     */
    public Ore createOre() {
        return new Ore();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.CMSSpreadLegData }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.CMSSpreadLegData createCMSSpreadLegData() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.CMSSpreadLegData();
    }

    /**
     * Create an instance of {@link StrikeData }
     * 
     */
    public StrikeData createStrikeData() {
        return new StrikeData();
    }

    /**
     * Create an instance of {@link Curveconfiguration }
     * 
     */
    public Curveconfiguration createCurveconfiguration() {
        return new Curveconfiguration();
    }

    /**
     * Create an instance of {@link CommodityFixedLegData }
     * 
     */
    public CommodityFixedLegData createCommodityFixedLegData() {
        return new CommodityFixedLegData();
    }

    /**
     * Create an instance of {@link CounterpartyInformation }
     * 
     */
    public CounterpartyInformation createCounterpartyInformation() {
        return new CounterpartyInformation();
    }

    /**
     * Create an instance of {@link Pricingengines }
     * 
     */
    public Pricingengines createPricingengines() {
        return new Pricingengines();
    }

    /**
     * Create an instance of {@link Sensitivityanalysis }
     * 
     */
    public Sensitivityanalysis createSensitivityanalysis() {
        return new Sensitivityanalysis();
    }

    /**
     * Create an instance of {@link Creditsimulation }
     * 
     */
    public Creditsimulation createCreditsimulation() {
        return new Creditsimulation();
    }

    /**
     * Create an instance of {@link ExerciseDates }
     * 
     */
    public ExerciseDates createExerciseDates() {
        return new ExerciseDates();
    }

    /**
     * Create an instance of {@link Portfolio }
     * 
     */
    public Portfolio createPortfolio() {
        return new Portfolio();
    }

    /**
     * Create an instance of {@link ScriptLibrary.Script }
     * 
     */
    public ScriptLibrary.Script createScriptLibraryScript() {
        return new ScriptLibrary.Script();
    }

    /**
     * Create an instance of {@link SubTrade }
     * 
     */
    public SubTrade createSubTrade() {
        return new SubTrade();
    }

    /**
     * Create an instance of {@link ReferenceData.ReferenceDatum }
     * 
     */
    public ReferenceData.ReferenceDatum createReferenceDataReferenceDatum() {
        return new ReferenceData.ReferenceDatum();
    }

    /**
     * Create an instance of {@link NettingSetDetails }
     * 
     */
    public NettingSetDetails createNettingSetDetails() {
        return new NettingSetDetails();
    }

    /**
     * Create an instance of {@link Simulation }
     * 
     */
    public Simulation createSimulation() {
        return new Simulation();
    }

    /**
     * Create an instance of {@link FormulaBasedLegData }
     * 
     */
    public FormulaBasedLegData createFormulaBasedLegData() {
        return new FormulaBasedLegData();
    }

    /**
     * Create an instance of {@link SIMMCalibrationData }
     * 
     */
    public SIMMCalibrationData createSIMMCalibrationData() {
        return new SIMMCalibrationData();
    }

    /**
     * Create an instance of {@link CMBLegData }
     * 
     */
    public CMBLegData createCMBLegData() {
        return new CMBLegData();
    }

    /**
     * Create an instance of {@link DurationAdjustedCMSLegData }
     * 
     */
    public DurationAdjustedCMSLegData createDurationAdjustedCMSLegData() {
        return new DurationAdjustedCMSLegData();
    }

    /**
     * Create an instance of {@link Discountcurve }
     * 
     */
    public Discountcurve createDiscountcurve() {
        return new Discountcurve();
    }

    /**
     * Create an instance of {@link FxBarrierOptionData }
     * 
     */
    public FxBarrierOptionData createFxBarrierOptionData() {
        return new FxBarrierOptionData();
    }

    /**
     * Create an instance of {@link EuropeanRainbowCallSpreadOptionData }
     * 
     */
    public EuropeanRainbowCallSpreadOptionData createEuropeanRainbowCallSpreadOptionData() {
        return new EuropeanRainbowCallSpreadOptionData();
    }

    /**
     * Create an instance of {@link ParametricSmileConfigParameter }
     * 
     */
    public ParametricSmileConfigParameter createParametricSmileConfigParameter() {
        return new ParametricSmileConfigParameter();
    }

    /**
     * Create an instance of {@link SensitivityFxSpot }
     * 
     */
    public SensitivityFxSpot createSensitivityFxSpot() {
        return new SensitivityFxSpot();
    }

    /**
     * Create an instance of {@link CorridorVarianceDispersionSwapData }
     * 
     */
    public CorridorVarianceDispersionSwapData createCorridorVarianceDispersionSwapData() {
        return new CorridorVarianceDispersionSwapData();
    }

    /**
     * Create an instance of {@link ConvertibleBondData }
     * 
     */
    public ConvertibleBondData createConvertibleBondData() {
        return new ConvertibleBondData();
    }

    /**
     * Create an instance of {@link StubInterpolation }
     * 
     */
    public StubInterpolation createStubInterpolation() {
        return new StubInterpolation();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.FxSpot }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.FxSpot createFxSpot() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.FxSpot();
    }

    /**
     * Create an instance of {@link WorstOfAssetOrCashRainbowOptionData }
     * 
     */
    public WorstOfAssetOrCashRainbowOptionData createWorstOfAssetOrCashRainbowOptionData() {
        return new WorstOfAssetOrCashRainbowOptionData();
    }

    /**
     * Create an instance of {@link StFreeStyleOptionType }
     * 
     */
    public StFreeStyleOptionType createStFreeStyleOptionType() {
        return new StFreeStyleOptionType();
    }

    /**
     * Create an instance of {@link IndexCreditDefaultSwapData }
     * 
     */
    public IndexCreditDefaultSwapData createIndexCreditDefaultSwapData() {
        return new IndexCreditDefaultSwapData();
    }

    /**
     * Create an instance of {@link AverageOISType }
     * 
     */
    public AverageOISType createAverageOISType() {
        return new AverageOISType();
    }

    /**
     * Create an instance of {@link WorstOfBasketSwapData }
     * 
     */
    public WorstOfBasketSwapData createWorstOfBasketSwapData() {
        return new WorstOfBasketSwapData();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Correlation }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Correlation createCorrelation() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Correlation();
    }

    /**
     * Create an instance of {@link FxDigitalBarrierOptionData }
     * 
     */
    public FxDigitalBarrierOptionData createFxDigitalBarrierOptionData() {
        return new FxDigitalBarrierOptionData();
    }

    /**
     * Create an instance of {@link DiscountRatioCurveElement }
     * 
     */
    public DiscountRatioCurveElement createDiscountRatioCurveElement() {
        return new DiscountRatioCurveElement();
    }

    /**
     * Create an instance of {@link CommodityRevenueOptionData }
     * 
     */
    public CommodityRevenueOptionData createCommodityRevenueOptionData() {
        return new CommodityRevenueOptionData();
    }

    /**
     * Create an instance of {@link TradeActions }
     * 
     */
    public TradeActions createTradeActions() {
        return new TradeActions();
    }

    /**
     * Create an instance of {@link BondData }
     * 
     */
    public BondData createBondData() {
        return new BondData();
    }

    /**
     * Create an instance of {@link SwapIndexType }
     * 
     */
    public SwapIndexType createSwapIndexType() {
        return new SwapIndexType();
    }

    /**
     * Create an instance of {@link IndexedCorridorVarianceSwapData }
     * 
     */
    public IndexedCorridorVarianceSwapData createIndexedCorridorVarianceSwapData() {
        return new IndexedCorridorVarianceSwapData();
    }

    /**
     * Create an instance of {@link Spreads }
     * 
     */
    public Spreads createSpreads() {
        return new Spreads();
    }

    /**
     * Create an instance of {@link ParametricSmileConfig }
     * 
     */
    public ParametricSmileConfig createParametricSmileConfig() {
        return new ParametricSmileConfig();
    }

    /**
     * Create an instance of {@link ArcOptionData }
     * 
     */
    public ArcOptionData createArcOptionData() {
        return new ArcOptionData();
    }

    /**
     * Create an instance of {@link SimpleSegmentType }
     * 
     */
    public SimpleSegmentType createSimpleSegmentType() {
        return new SimpleSegmentType();
    }

    /**
     * Create an instance of {@link VarianceOptionData }
     * 
     */
    public VarianceOptionData createVarianceOptionData() {
        return new VarianceOptionData();
    }

    /**
     * Create an instance of {@link CorridorVarianceSwapData }
     * 
     */
    public CorridorVarianceSwapData createCorridorVarianceSwapData() {
        return new CorridorVarianceSwapData();
    }

    /**
     * Create an instance of {@link SensitivityEquityVolatility }
     * 
     */
    public SensitivityEquityVolatility createSensitivityEquityVolatility() {
        return new SensitivityEquityVolatility();
    }

    /**
     * Create an instance of {@link CommoditySwapData }
     * 
     */
    public CommoditySwapData createCommoditySwapData() {
        return new CommoditySwapData();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.YieldCurves }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.YieldCurves createYieldCurves() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.YieldCurves();
    }

    /**
     * Create an instance of {@link Yyinflationindexcurves }
     * 
     */
    public Yyinflationindexcurves createYyinflationindexcurves() {
        return new Yyinflationindexcurves();
    }

    /**
     * Create an instance of {@link RangeBound }
     * 
     */
    public RangeBound createRangeBound() {
        return new RangeBound();
    }

    /**
     * Create an instance of {@link CashPositionData }
     * 
     */
    public CashPositionData createCashPositionData() {
        return new CashPositionData();
    }

    /**
     * Create an instance of {@link StFreeStyleBarrierTypeVectorBase }
     * 
     */
    public StFreeStyleBarrierTypeVectorBase createStFreeStyleBarrierTypeVectorBase() {
        return new StFreeStyleBarrierTypeVectorBase();
    }

    /**
     * Create an instance of {@link AsianIrCapFloorData }
     * 
     */
    public AsianIrCapFloorData createAsianIrCapFloorData() {
        return new AsianIrCapFloorData();
    }

    /**
     * Create an instance of {@link MinRainbowOptionData }
     * 
     */
    public MinRainbowOptionData createMinRainbowOptionData() {
        return new MinRainbowOptionData();
    }

    /**
     * Create an instance of {@link Securityspread }
     * 
     */
    public Securityspread createSecurityspread() {
        return new Securityspread();
    }

    /**
     * Create an instance of {@link Accumulator01Data }
     * 
     */
    public Accumulator01Data createAccumulator01Data() {
        return new Accumulator01Data();
    }

    /**
     * Create an instance of {@link LapseHedgeSwapData }
     * 
     */
    public LapseHedgeSwapData createLapseHedgeSwapData() {
        return new LapseHedgeSwapData();
    }

    /**
     * Create an instance of {@link Discountcurves }
     * 
     */
    public Discountcurves createDiscountcurves() {
        return new Discountcurves();
    }

    /**
     * Create an instance of {@link WorstPerformanceRainbowOption07Data }
     * 
     */
    public WorstPerformanceRainbowOption07Data createWorstPerformanceRainbowOption07Data() {
        return new WorstPerformanceRainbowOption07Data();
    }

    /**
     * Create an instance of {@link KnockOutSwapData }
     * 
     */
    public KnockOutSwapData createKnockOutSwapData() {
        return new KnockOutSwapData();
    }

    /**
     * Create an instance of {@link ParExcludes }
     * 
     */
    public ParExcludes createParExcludes() {
        return new ParExcludes();
    }

    /**
     * Create an instance of {@link DoubleDigitalOptionData }
     * 
     */
    public DoubleDigitalOptionData createDoubleDigitalOptionData() {
        return new DoubleDigitalOptionData();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Gearings }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Gearings createGearings() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Gearings();
    }

    /**
     * Create an instance of {@link StrikePriceData }
     * 
     */
    public StrikePriceData createStrikePriceData() {
        return new StrikePriceData();
    }

    /**
     * Create an instance of {@link IrfxConcentrationThresholds }
     * 
     */
    public IrfxConcentrationThresholds createIrfxConcentrationThresholds() {
        return new IrfxConcentrationThresholds();
    }

    /**
     * Create an instance of {@link FxAverageForwardData }
     * 
     */
    public FxAverageForwardData createFxAverageForwardData() {
        return new FxAverageForwardData();
    }

    /**
     * Create an instance of {@link ParametricSmileConfigCalibration }
     * 
     */
    public ParametricSmileConfigCalibration createParametricSmileConfigCalibration() {
        return new ParametricSmileConfigCalibration();
    }

    /**
     * Create an instance of {@link FxOptionData }
     * 
     */
    public FxOptionData createFxOptionData() {
        return new FxOptionData();
    }

    /**
     * Create an instance of {@link CallableBondData }
     * 
     */
    public CallableBondData createCallableBondData() {
        return new CallableBondData();
    }

    /**
     * Create an instance of {@link BestEntryOptionData }
     * 
     */
    public BestEntryOptionData createBestEntryOptionData() {
        return new BestEntryOptionData();
    }

    /**
     * Create an instance of {@link CorrelationSwapData }
     * 
     */
    public CorrelationSwapData createCorrelationSwapData() {
        return new CorrelationSwapData();
    }

    /**
     * Create an instance of {@link SensitivityEquityVolatilities }
     * 
     */
    public SensitivityEquityVolatilities createSensitivityEquityVolatilities() {
        return new SensitivityEquityVolatilities();
    }

    /**
     * Create an instance of {@link SensitivityBaseCorrelation }
     * 
     */
    public SensitivityBaseCorrelation createSensitivityBaseCorrelation() {
        return new SensitivityBaseCorrelation();
    }

    /**
     * Create an instance of {@link CallsPutsType }
     * 
     */
    public CallsPutsType createCallsPutsType() {
        return new CallsPutsType();
    }

    /**
     * Create an instance of {@link EqTouchOptionData }
     * 
     */
    public EqTouchOptionData createEqTouchOptionData() {
        return new EqTouchOptionData();
    }

    /**
     * Create an instance of {@link CalibrationYoYCapFloor }
     * 
     */
    public CalibrationYoYCapFloor createCalibrationYoYCapFloor() {
        return new CalibrationYoYCapFloor();
    }

    /**
     * Create an instance of {@link CboBondBasketData }
     * 
     */
    public CboBondBasketData createCboBondBasketData() {
        return new CboBondBasketData();
    }

    /**
     * Create an instance of {@link EquityPositionData }
     * 
     */
    public EquityPositionData createEquityPositionData() {
        return new EquityPositionData();
    }

    /**
     * Create an instance of {@link Newcalendar }
     * 
     */
    public Newcalendar createNewcalendar() {
        return new Newcalendar();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.YieldVolatility }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.YieldVolatility createYieldVolatility() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.YieldVolatility();
    }

    /**
     * Create an instance of {@link FxSpots }
     * 
     */
    public FxSpots createFxSpots() {
        return new FxSpots();
    }

    /**
     * Create an instance of {@link VolatilityApoFutureSurfaceConfig }
     * 
     */
    public VolatilityApoFutureSurfaceConfig createVolatilityApoFutureSurfaceConfig() {
        return new VolatilityApoFutureSurfaceConfig();
    }

    /**
     * Create an instance of {@link StFreeStyleLongShortVectorBase }
     * 
     */
    public StFreeStyleLongShortVectorBase createStFreeStyleLongShortVectorBase() {
        return new StFreeStyleLongShortVectorBase();
    }

    /**
     * Create an instance of {@link EqOutperformanceOptionData }
     * 
     */
    public EqOutperformanceOptionData createEqOutperformanceOptionData() {
        return new EqOutperformanceOptionData();
    }

    /**
     * Create an instance of {@link InflationCapFloorVolatility }
     * 
     */
    public InflationCapFloorVolatility createInflationCapFloorVolatility() {
        return new InflationCapFloorVolatility();
    }

    /**
     * Create an instance of {@link OffPeakDailyType }
     * 
     */
    public OffPeakDailyType createOffPeakDailyType() {
        return new OffPeakDailyType();
    }

    /**
     * Create an instance of {@link GammaSwapData }
     * 
     */
    public GammaSwapData createGammaSwapData() {
        return new GammaSwapData();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Strikes }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Strikes createStrikes() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Strikes();
    }

    /**
     * Create an instance of {@link Stresscommodityvolatility }
     * 
     */
    public Stresscommodityvolatility createStresscommodityvolatility() {
        return new Stresscommodityvolatility();
    }

    /**
     * Create an instance of {@link CboReferenceDatum }
     * 
     */
    public CboReferenceDatum createCboReferenceDatum() {
        return new CboReferenceDatum();
    }

    /**
     * Create an instance of {@link InlfSegmentType }
     * 
     */
    public InlfSegmentType createInlfSegmentType() {
        return new InlfSegmentType();
    }

    /**
     * Create an instance of {@link WeightedAverageType }
     * 
     */
    public WeightedAverageType createWeightedAverageType() {
        return new WeightedAverageType();
    }

    /**
     * Create an instance of {@link FxSwapData }
     * 
     */
    public FxSwapData createFxSwapData() {
        return new FxSwapData();
    }

    /**
     * Create an instance of {@link Stresscommodityvolatilities }
     * 
     */
    public Stresscommodityvolatilities createStresscommodityvolatilities() {
        return new Stresscommodityvolatilities();
    }

    /**
     * Create an instance of {@link MultiLegOptionData }
     * 
     */
    public MultiLegOptionData createMultiLegOptionData() {
        return new MultiLegOptionData();
    }

    /**
     * Create an instance of {@link BondReferenceDatum }
     * 
     */
    public BondReferenceDatum createBondReferenceDatum() {
        return new BondReferenceDatum();
    }

    /**
     * Create an instance of {@link StFreeStyleNumber }
     * 
     */
    public StFreeStyleNumber createStFreeStyleNumber() {
        return new StFreeStyleNumber();
    }

    /**
     * Create an instance of {@link Yyinflationindexcurve }
     * 
     */
    public Yyinflationindexcurve createYyinflationindexcurve() {
        return new Yyinflationindexcurve();
    }

    /**
     * Create an instance of {@link SensitivitySwaptionVolatilities }
     * 
     */
    public SensitivitySwaptionVolatilities createSensitivitySwaptionVolatilities() {
        return new SensitivitySwaptionVolatilities();
    }

    /**
     * Create an instance of {@link MaxRainbowOptionData }
     * 
     */
    public MaxRainbowOptionData createMaxRainbowOptionData() {
        return new MaxRainbowOptionData();
    }

    /**
     * Create an instance of {@link SensitivityCapFloorVolatility }
     * 
     */
    public SensitivityCapFloorVolatility createSensitivityCapFloorVolatility() {
        return new SensitivityCapFloorVolatility();
    }

    /**
     * Create an instance of {@link CommodityDigitalAveragePriceOptionData }
     * 
     */
    public CommodityDigitalAveragePriceOptionData createCommodityDigitalAveragePriceOptionData() {
        return new CommodityDigitalAveragePriceOptionData();
    }

    /**
     * Create an instance of {@link VolatilityDeltaSurfaceConfig }
     * 
     */
    public VolatilityDeltaSurfaceConfig createVolatilityDeltaSurfaceConfig() {
        return new VolatilityDeltaSurfaceConfig();
    }

    /**
     * Create an instance of {@link StFreeStyleBoolVector }
     * 
     */
    public StFreeStyleBoolVector createStFreeStyleBoolVector() {
        return new StFreeStyleBoolVector();
    }

    /**
     * Create an instance of {@link StFreeStyleCurrencyVector }
     * 
     */
    public StFreeStyleCurrencyVector createStFreeStyleCurrencyVector() {
        return new StFreeStyleCurrencyVector();
    }

    /**
     * Create an instance of {@link LongShortsType }
     * 
     */
    public LongShortsType createLongShortsType() {
        return new LongShortsType();
    }

    /**
     * Create an instance of {@link StFreeStyleNumberVectorBase }
     * 
     */
    public StFreeStyleNumberVectorBase createStFreeStyleNumberVectorBase() {
        return new StFreeStyleNumberVectorBase();
    }

    /**
     * Create an instance of {@link VolatilityCurveConfig }
     * 
     */
    public VolatilityCurveConfig createVolatilityCurveConfig() {
        return new VolatilityCurveConfig();
    }

    /**
     * Create an instance of {@link ReversionParameter }
     * 
     */
    public ReversionParameter createReversionParameter() {
        return new ReversionParameter();
    }

    /**
     * Create an instance of {@link ShiftSchemeEntry }
     * 
     */
    public ShiftSchemeEntry createShiftSchemeEntry() {
        return new ShiftSchemeEntry();
    }

    /**
     * Create an instance of {@link FxDigitalOptionData }
     * 
     */
    public FxDigitalOptionData createFxDigitalOptionData() {
        return new FxDigitalOptionData();
    }

    /**
     * Create an instance of {@link Yycapfloorvolatilities }
     * 
     */
    public Yycapfloorvolatilities createYycapfloorvolatilities() {
        return new Yycapfloorvolatilities();
    }

    /**
     * Create an instance of {@link Equityspot }
     * 
     */
    public Equityspot createEquityspot() {
        return new Equityspot();
    }

    /**
     * Create an instance of {@link CdoData }
     * 
     */
    public CdoData createCdoData() {
        return new CdoData();
    }

    /**
     * Create an instance of {@link StFreeStyleLongShortVector }
     * 
     */
    public StFreeStyleLongShortVector createStFreeStyleLongShortVector() {
        return new StFreeStyleLongShortVector();
    }

    /**
     * Create an instance of {@link Cbodata }
     * 
     */
    public Cbodata createCbodata() {
        return new Cbodata();
    }

    /**
     * Create an instance of {@link CreditDefaultSwapOptionData }
     * 
     */
    public CreditDefaultSwapOptionData createCreditDefaultSwapOptionData() {
        return new CreditDefaultSwapOptionData();
    }

    /**
     * Create an instance of {@link StrikeResettableOptionData2 }
     * 
     */
    public StrikeResettableOptionData2 createStrikeResettableOptionData2() {
        return new StrikeResettableOptionData2();
    }

    /**
     * Create an instance of {@link SensitivityFxSpots }
     * 
     */
    public SensitivityFxSpots createSensitivityFxSpots() {
        return new SensitivityFxSpots();
    }

    /**
     * Create an instance of {@link TradeAction }
     * 
     */
    public TradeAction createTradeAction() {
        return new TradeAction();
    }

    /**
     * Create an instance of {@link BestEntryOptionData2 }
     * 
     */
    public BestEntryOptionData2 createBestEntryOptionData2() {
        return new BestEntryOptionData2();
    }

    /**
     * Create an instance of {@link OvernightIndexType }
     * 
     */
    public OvernightIndexType createOvernightIndexType() {
        return new OvernightIndexType();
    }

    /**
     * Create an instance of {@link TarfData }
     * 
     */
    public TarfData createTarfData() {
        return new TarfData();
    }

    /**
     * Create an instance of {@link StrikeResettableOptionData }
     * 
     */
    public StrikeResettableOptionData createStrikeResettableOptionData() {
        return new StrikeResettableOptionData();
    }

    /**
     * Create an instance of {@link StFreeStyleCurrency }
     * 
     */
    public StFreeStyleCurrency createStFreeStyleCurrency() {
        return new StFreeStyleCurrency();
    }

    /**
     * Create an instance of {@link CommForwardSettlementData }
     * 
     */
    public CommForwardSettlementData createCommForwardSettlementData() {
        return new CommForwardSettlementData();
    }

    /**
     * Create an instance of {@link Tranches }
     * 
     */
    public Tranches createTranches() {
        return new Tranches();
    }

    /**
     * Create an instance of {@link CalibrationBasket }
     * 
     */
    public CalibrationBasket createCalibrationBasket() {
        return new CalibrationBasket();
    }

    /**
     * Create an instance of {@link CommodityForwardType }
     * 
     */
    public CommodityForwardType createCommodityForwardType() {
        return new CommodityForwardType();
    }

    /**
     * Create an instance of {@link VanillaBasketOptionData }
     * 
     */
    public VanillaBasketOptionData createVanillaBasketOptionData() {
        return new VanillaBasketOptionData();
    }

    /**
     * Create an instance of {@link WorstPerformanceRainbowOption06Data }
     * 
     */
    public WorstPerformanceRainbowOption06Data createWorstPerformanceRainbowOption06Data() {
        return new WorstPerformanceRainbowOption06Data();
    }

    /**
     * Create an instance of {@link ShiftSizeEntry }
     * 
     */
    public ShiftSizeEntry createShiftSizeEntry() {
        return new ShiftSizeEntry();
    }

    /**
     * Create an instance of {@link Correlationcurve }
     * 
     */
    public Correlationcurve createCorrelationcurve() {
        return new Correlationcurve();
    }

    /**
     * Create an instance of {@link PairwiseGeometricVarianceDispersionSwapData }
     * 
     */
    public PairwiseGeometricVarianceDispersionSwapData createPairwiseGeometricVarianceDispersionSwapData() {
        return new PairwiseGeometricVarianceDispersionSwapData();
    }

    /**
     * Create an instance of {@link LadderLockInOptionData }
     * 
     */
    public LadderLockInOptionData createLadderLockInOptionData() {
        return new LadderLockInOptionData();
    }

    /**
     * Create an instance of {@link Zeroinflationindexcurves }
     * 
     */
    public Zeroinflationindexcurves createZeroinflationindexcurves() {
        return new Zeroinflationindexcurves();
    }

    /**
     * Create an instance of {@link IborIndexType }
     * 
     */
    public IborIndexType createIborIndexType() {
        return new IborIndexType();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.FxVolatilities }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.FxVolatilities createFxVolatilities() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.FxVolatilities();
    }

    /**
     * Create an instance of {@link CboInvestment }
     * 
     */
    public CboInvestment createCboInvestment() {
        return new CboInvestment();
    }

    /**
     * Create an instance of {@link CommodityDigitalOptionData }
     * 
     */
    public CommodityDigitalOptionData createCommodityDigitalOptionData() {
        return new CommodityDigitalOptionData();
    }

    /**
     * Create an instance of {@link CalibrationCpiCapFloor }
     * 
     */
    public CalibrationCpiCapFloor createCalibrationCpiCapFloor() {
        return new CalibrationCpiCapFloor();
    }

    /**
     * Create an instance of {@link Fxreset }
     * 
     */
    public Fxreset createFxreset() {
        return new Fxreset();
    }

    /**
     * Create an instance of {@link SensitivityCommodityVolatility }
     * 
     */
    public SensitivityCommodityVolatility createSensitivityCommodityVolatility() {
        return new SensitivityCommodityVolatility();
    }

    /**
     * Create an instance of {@link FloatingStrikeForwardStartingOptionData }
     * 
     */
    public FloatingStrikeForwardStartingOptionData createFloatingStrikeForwardStartingOptionData() {
        return new FloatingStrikeForwardStartingOptionData();
    }

    /**
     * Create an instance of {@link CbPepsData }
     * 
     */
    public CbPepsData createCbPepsData() {
        return new CbPepsData();
    }

    /**
     * Create an instance of {@link Cpicapfloorvolatilities }
     * 
     */
    public Cpicapfloorvolatilities createCpicapfloorvolatilities() {
        return new Cpicapfloorvolatilities();
    }

    /**
     * Create an instance of {@link MovingMaxYYIISData }
     * 
     */
    public MovingMaxYYIISData createMovingMaxYYIISData() {
        return new MovingMaxYYIISData();
    }

    /**
     * Create an instance of {@link SingleUnderlyingAsianOptionData }
     * 
     */
    public SingleUnderlyingAsianOptionData createSingleUnderlyingAsianOptionData() {
        return new SingleUnderlyingAsianOptionData();
    }

    /**
     * Create an instance of {@link YieldCurveReport }
     * 
     */
    public YieldCurveReport createYieldCurveReport() {
        return new YieldCurveReport();
    }

    /**
     * Create an instance of {@link GlobalParameters }
     * 
     */
    public GlobalParameters createGlobalParameters() {
        return new GlobalParameters();
    }

    /**
     * Create an instance of {@link TotalReturnSwapData }
     * 
     */
    public TotalReturnSwapData createTotalReturnSwapData() {
        return new TotalReturnSwapData();
    }

    /**
     * Create an instance of {@link Dividendyield }
     * 
     */
    public Dividendyield createDividendyield() {
        return new Dividendyield();
    }

    /**
     * Create an instance of {@link StFreeStyleIndexVectorBase }
     * 
     */
    public StFreeStyleIndexVectorBase createStFreeStyleIndexVectorBase() {
        return new StFreeStyleIndexVectorBase();
    }

    /**
     * Create an instance of {@link CurveAlgebraCurve }
     * 
     */
    public CurveAlgebraCurve createCurveAlgebraCurve() {
        return new CurveAlgebraCurve();
    }

    /**
     * Create an instance of {@link LPISwapData }
     * 
     */
    public LPISwapData createLPISwapData() {
        return new LPISwapData();
    }

    /**
     * Create an instance of {@link TenorBasisTwoSwapType }
     * 
     */
    public TenorBasisTwoSwapType createTenorBasisTwoSwapType() {
        return new TenorBasisTwoSwapType();
    }

    /**
     * Create an instance of {@link Cpicapfloorvolatility }
     * 
     */
    public Cpicapfloorvolatility createCpicapfloorvolatility() {
        return new Cpicapfloorvolatility();
    }

    /**
     * Create an instance of {@link CliquetOptionData }
     * 
     */
    public CliquetOptionData createCliquetOptionData() {
        return new CliquetOptionData();
    }

    /**
     * Create an instance of {@link ZeroInflationIndexType }
     * 
     */
    public ZeroInflationIndexType createZeroInflationIndexType() {
        return new ZeroInflationIndexType();
    }

    /**
     * Create an instance of {@link Entities }
     * 
     */
    public Entities createEntities() {
        return new Entities();
    }

    /**
     * Create an instance of {@link NameData }
     * 
     */
    public NameData createNameData() {
        return new NameData();
    }

    /**
     * Create an instance of {@link ForwardStartingSwaptionData }
     * 
     */
    public ForwardStartingSwaptionData createForwardStartingSwaptionData() {
        return new ForwardStartingSwaptionData();
    }

    /**
     * Create an instance of {@link Entity }
     * 
     */
    public Entity createEntity() {
        return new Entity();
    }

    /**
     * Create an instance of {@link ForwardRateAgreementData }
     * 
     */
    public ForwardRateAgreementData createForwardRateAgreementData() {
        return new ForwardRateAgreementData();
    }

    /**
     * Create an instance of {@link IborFallbackFallback }
     * 
     */
    public IborFallbackFallback createIborFallbackFallback() {
        return new IborFallbackFallback();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Dates }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Dates createDates() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Dates();
    }

    /**
     * Create an instance of {@link VolatilityParameter }
     * 
     */
    public VolatilityParameter createVolatilityParameter() {
        return new VolatilityParameter();
    }

    /**
     * Create an instance of {@link OffPeakPowerIndexDataType }
     * 
     */
    public OffPeakPowerIndexDataType createOffPeakPowerIndexDataType() {
        return new OffPeakPowerIndexDataType();
    }

    /**
     * Create an instance of {@link SensitivityYieldCurve }
     * 
     */
    public SensitivityYieldCurve createSensitivityYieldCurve() {
        return new SensitivityYieldCurve();
    }

    /**
     * Create an instance of {@link CommodityOptionStripData }
     * 
     */
    public CommodityOptionStripData createCommodityOptionStripData() {
        return new CommodityOptionStripData();
    }

    /**
     * Create an instance of {@link SensitivityCommodityVolatilities }
     * 
     */
    public SensitivityCommodityVolatilities createSensitivityCommodityVolatilities() {
        return new SensitivityCommodityVolatilities();
    }

    /**
     * Create an instance of {@link CallableBondReferenceDatum }
     * 
     */
    public CallableBondReferenceDatum createCallableBondReferenceDatum() {
        return new CallableBondReferenceDatum();
    }

    /**
     * Create an instance of {@link CompositeTradeData }
     * 
     */
    public CompositeTradeData createCompositeTradeData() {
        return new CompositeTradeData();
    }

    /**
     * Create an instance of {@link CommodityOptionData }
     * 
     */
    public CommodityOptionData createCommodityOptionData() {
        return new CommodityOptionData();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelations }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelations createBaseCorrelations() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelations();
    }

    /**
     * Create an instance of {@link CommoditySpreadOptionData }
     * 
     */
    public CommoditySpreadOptionData createCommoditySpreadOptionData() {
        return new CommoditySpreadOptionData();
    }

    /**
     * Create an instance of {@link WindowBarrierOptionData }
     * 
     */
    public WindowBarrierOptionData createWindowBarrierOptionData() {
        return new WindowBarrierOptionData();
    }

    /**
     * Create an instance of {@link WorstPerformanceRainbowOption05Data }
     * 
     */
    public WorstPerformanceRainbowOption05Data createWorstPerformanceRainbowOption05Data() {
        return new WorstPerformanceRainbowOption05Data();
    }

    /**
     * Create an instance of {@link EquityOptionData }
     * 
     */
    public EquityOptionData createEquityOptionData() {
        return new EquityOptionData();
    }

    /**
     * Create an instance of {@link CallableSwapData }
     * 
     */
    public CallableSwapData createCallableSwapData() {
        return new CallableSwapData();
    }

    /**
     * Create an instance of {@link CommodityBasisConfig }
     * 
     */
    public CommodityBasisConfig createCommodityBasisConfig() {
        return new CommodityBasisConfig();
    }

    /**
     * Create an instance of {@link CommodityForwardData }
     * 
     */
    public CommodityForwardData createCommodityForwardData() {
        return new CommodityForwardData();
    }

    /**
     * Create an instance of {@link FlooredAverageCPIZCIISData }
     * 
     */
    public FlooredAverageCPIZCIISData createFlooredAverageCPIZCIISData() {
        return new FlooredAverageCPIZCIISData();
    }

    /**
     * Create an instance of {@link DiscountRatioType }
     * 
     */
    public DiscountRatioType createDiscountRatioType() {
        return new DiscountRatioType();
    }

    /**
     * Create an instance of {@link Zeroinflationindexcurve }
     * 
     */
    public Zeroinflationindexcurve createZeroinflationindexcurve() {
        return new Zeroinflationindexcurve();
    }

    /**
     * Create an instance of {@link FundingData }
     * 
     */
    public FundingData createFundingData() {
        return new FundingData();
    }

    /**
     * Create an instance of {@link EquityReferenceDatum }
     * 
     */
    public EquityReferenceDatum createEquityReferenceDatum() {
        return new EquityReferenceDatum();
    }

    /**
     * Create an instance of {@link BoundaryConstraint }
     * 
     */
    public BoundaryConstraint createBoundaryConstraint() {
        return new BoundaryConstraint();
    }

    /**
     * Create an instance of {@link CommodityCurves }
     * 
     */
    public CommodityCurves createCommodityCurves() {
        return new CommodityCurves();
    }

    /**
     * Create an instance of {@link EquityOptionPositionData }
     * 
     */
    public EquityOptionPositionData createEquityOptionPositionData() {
        return new EquityOptionPositionData();
    }

    /**
     * Create an instance of {@link Survivalprobability }
     * 
     */
    public Survivalprobability createSurvivalprobability() {
        return new Survivalprobability();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurves }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurves createDefaultCurves() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurves();
    }

    /**
     * Create an instance of {@link OisType }
     * 
     */
    public OisType createOisType() {
        return new OisType();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Floors }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Floors createFloors() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Floors();
    }

    /**
     * Create an instance of {@link CurveAlgebra }
     * 
     */
    public CurveAlgebra createCurveAlgebra() {
        return new CurveAlgebra();
    }

    /**
     * Create an instance of {@link BasketData }
     * 
     */
    public BasketData createBasketData() {
        return new BasketData();
    }

    /**
     * Create an instance of {@link IndexCreditDefaultSwapOptionData }
     * 
     */
    public IndexCreditDefaultSwapOptionData createIndexCreditDefaultSwapOptionData() {
        return new IndexCreditDefaultSwapOptionData();
    }

    /**
     * Create an instance of {@link Counterparties }
     * 
     */
    public Counterparties createCounterparties() {
        return new Counterparties();
    }

    /**
     * Create an instance of {@link BondFutureReferenceDatum }
     * 
     */
    public BondFutureReferenceDatum createBondFutureReferenceDatum() {
        return new BondFutureReferenceDatum();
    }

    /**
     * Create an instance of {@link OneDimSolverConfigType }
     * 
     */
    public OneDimSolverConfigType createOneDimSolverConfigType() {
        return new OneDimSolverConfigType();
    }

    /**
     * Create an instance of {@link ExtendedAccumulatorData }
     * 
     */
    public ExtendedAccumulatorData createExtendedAccumulatorData() {
        return new ExtendedAccumulatorData();
    }

    /**
     * Create an instance of {@link EquityForwardData }
     * 
     */
    public EquityForwardData createEquityForwardData() {
        return new EquityForwardData();
    }

    /**
     * Create an instance of {@link RainbowCallSpreadBarrierOptionData }
     * 
     */
    public RainbowCallSpreadBarrierOptionData createRainbowCallSpreadBarrierOptionData() {
        return new RainbowCallSpreadBarrierOptionData();
    }

    /**
     * Create an instance of {@link Accumulator02Data }
     * 
     */
    public Accumulator02Data createAccumulator02Data() {
        return new Accumulator02Data();
    }

    /**
     * Create an instance of {@link DeliveryBasket }
     * 
     */
    public DeliveryBasket createDeliveryBasket() {
        return new DeliveryBasket();
    }

    /**
     * Create an instance of {@link AscotData }
     * 
     */
    public AscotData createAscotData() {
        return new AscotData();
    }

    /**
     * Create an instance of {@link EqBarrierOptionData }
     * 
     */
    public EqBarrierOptionData createEqBarrierOptionData() {
        return new EqBarrierOptionData();
    }

    /**
     * Create an instance of {@link BondYield }
     * 
     */
    public BondYield createBondYield() {
        return new BondYield();
    }

    /**
     * Create an instance of {@link StFreeStyleNumberVector }
     * 
     */
    public StFreeStyleNumberVector createStFreeStyleNumberVector() {
        return new StFreeStyleNumberVector();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.CommodityCurve }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.CommodityCurve createCommodityCurve() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.CommodityCurve();
    }

    /**
     * Create an instance of {@link CommoditySwaptionData }
     * 
     */
    public CommoditySwaptionData createCommoditySwaptionData() {
        return new CommoditySwaptionData();
    }

    /**
     * Create an instance of {@link StrikeYieldData }
     * 
     */
    public StrikeYieldData createStrikeYieldData() {
        return new StrikeYieldData();
    }

    /**
     * Create an instance of {@link Stresstestparshifts }
     * 
     */
    public Stresstestparshifts createStresstestparshifts() {
        return new Stresstestparshifts();
    }

    /**
     * Create an instance of {@link Cbotranche }
     * 
     */
    public Cbotranche createCbotranche() {
        return new Cbotranche();
    }

    /**
     * Create an instance of {@link EqDigitalOptionData }
     * 
     */
    public EqDigitalOptionData createEqDigitalOptionData() {
        return new EqDigitalOptionData();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Securities }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Securities createSecurities() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Securities();
    }

    /**
     * Create an instance of {@link SegmentsType }
     * 
     */
    public SegmentsType createSegmentsType() {
        return new SegmentsType();
    }

    /**
     * Create an instance of {@link ConditionalVarianceSwap01Data }
     * 
     */
    public ConditionalVarianceSwap01Data createConditionalVarianceSwap01Data() {
        return new ConditionalVarianceSwap01Data();
    }

    /**
     * Create an instance of {@link StFreeStyleEventSchedule }
     * 
     */
    public StFreeStyleEventSchedule createStFreeStyleEventSchedule() {
        return new StFreeStyleEventSchedule();
    }

    /**
     * Create an instance of {@link PairwiseVarianceSwapData1 }
     * 
     */
    public PairwiseVarianceSwapData1 createPairwiseVarianceSwapData1() {
        return new PairwiseVarianceSwapData1();
    }

    /**
     * Create an instance of {@link PairwiseVarianceSwapData2 }
     * 
     */
    public PairwiseVarianceSwapData2 createPairwiseVarianceSwapData2() {
        return new PairwiseVarianceSwapData2();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.CommodityVolatility }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.CommodityVolatility createCommodityVolatility() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.CommodityVolatility();
    }

    /**
     * Create an instance of {@link CompositeTradeComponents }
     * 
     */
    public CompositeTradeComponents createCompositeTradeComponents() {
        return new CompositeTradeComponents();
    }

    /**
     * Create an instance of {@link Exchanges }
     * 
     */
    public Exchanges createExchanges() {
        return new Exchanges();
    }

    /**
     * Create an instance of {@link BmaBasisSwapType }
     * 
     */
    public BmaBasisSwapType createBmaBasisSwapType() {
        return new BmaBasisSwapType();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Correlations }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Correlations createCorrelations() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Correlations();
    }

    /**
     * Create an instance of {@link FraType }
     * 
     */
    public FraType createFraType() {
        return new FraType();
    }

    /**
     * Create an instance of {@link NthWeekdayType }
     * 
     */
    public NthWeekdayType createNthWeekdayType() {
        return new NthWeekdayType();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.SettlementData }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.SettlementData createSettlementData() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.SettlementData();
    }

    /**
     * Create an instance of {@link InflSegmentsType }
     * 
     */
    public InflSegmentsType createInflSegmentsType() {
        return new InflSegmentsType();
    }

    /**
     * Create an instance of {@link VolatilityStrikeSurfaceConfig }
     * 
     */
    public VolatilityStrikeSurfaceConfig createVolatilityStrikeSurfaceConfig() {
        return new VolatilityStrikeSurfaceConfig();
    }

    /**
     * Create an instance of {@link ConvertibleBondReferenceDatum }
     * 
     */
    public ConvertibleBondReferenceDatum createConvertibleBondReferenceDatum() {
        return new ConvertibleBondReferenceDatum();
    }

    /**
     * Create an instance of {@link CboStructure }
     * 
     */
    public CboStructure createCboStructure() {
        return new CboStructure();
    }

    /**
     * Create an instance of {@link BestOfAirbagData }
     * 
     */
    public BestOfAirbagData createBestOfAirbagData() {
        return new BestOfAirbagData();
    }

    /**
     * Create an instance of {@link DirectSegmentType }
     * 
     */
    public DirectSegmentType createDirectSegmentType() {
        return new DirectSegmentType();
    }

    /**
     * Create an instance of {@link StFreeStyleEvent }
     * 
     */
    public StFreeStyleEvent createStFreeStyleEvent() {
        return new StFreeStyleEvent();
    }

    /**
     * Create an instance of {@link KikoVarianceSwapData }
     * 
     */
    public KikoVarianceSwapData createKikoVarianceSwapData() {
        return new KikoVarianceSwapData();
    }

    /**
     * Create an instance of {@link BondTRSData }
     * 
     */
    public BondTRSData createBondTRSData() {
        return new BondTRSData();
    }

    /**
     * Create an instance of {@link KoCorridorVarianceDispersionSwapData }
     * 
     */
    public KoCorridorVarianceDispersionSwapData createKoCorridorVarianceDispersionSwapData() {
        return new KoCorridorVarianceDispersionSwapData();
    }

    /**
     * Create an instance of {@link TrsFundingData }
     * 
     */
    public TrsFundingData createTrsFundingData() {
        return new TrsFundingData();
    }

    /**
     * Create an instance of {@link FactorType }
     * 
     */
    public FactorType createFactorType() {
        return new FactorType();
    }

    /**
     * Create an instance of {@link WorstPerformanceRainbowOption04Data }
     * 
     */
    public WorstPerformanceRainbowOption04Data createWorstPerformanceRainbowOption04Data() {
        return new WorstPerformanceRainbowOption04Data();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.YieldVolatilities }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.YieldVolatilities createYieldVolatilities() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.YieldVolatilities();
    }

    /**
     * Create an instance of {@link CrossCurrencyFixFloatType }
     * 
     */
    public CrossCurrencyFixFloatType createCrossCurrencyFixFloatType() {
        return new CrossCurrencyFixFloatType();
    }

    /**
     * Create an instance of {@link AoisSegmentType }
     * 
     */
    public AoisSegmentType createAoisSegmentType() {
        return new AoisSegmentType();
    }

    /**
     * Create an instance of {@link SimCommodityCurve }
     * 
     */
    public SimCommodityCurve createSimCommodityCurve() {
        return new SimCommodityCurve();
    }

    /**
     * Create an instance of {@link SwapType }
     * 
     */
    public SwapType createSwapType() {
        return new SwapType();
    }

    /**
     * Create an instance of {@link Stresscommoditycurve }
     * 
     */
    public Stresscommoditycurve createStresscommoditycurve() {
        return new Stresscommoditycurve();
    }

    /**
     * Create an instance of {@link AverageStrikeBasketOptionData }
     * 
     */
    public AverageStrikeBasketOptionData createAverageStrikeBasketOptionData() {
        return new AverageStrikeBasketOptionData();
    }

    /**
     * Create an instance of {@link Securityspreads }
     * 
     */
    public Securityspreads createSecurityspreads() {
        return new Securityspreads();
    }

    /**
     * Create an instance of {@link AsianBasketOptionData }
     * 
     */
    public AsianBasketOptionData createAsianBasketOptionData() {
        return new AsianBasketOptionData();
    }

    /**
     * Create an instance of {@link Stresscommoditycurves }
     * 
     */
    public Stresscommoditycurves createStresscommoditycurves() {
        return new Stresscommoditycurves();
    }

    /**
     * Create an instance of {@link SensitivityYieldCurves }
     * 
     */
    public SensitivityYieldCurves createSensitivityYieldCurves() {
        return new SensitivityYieldCurves();
    }

    /**
     * Create an instance of {@link LookbackPutBasketOptionData }
     * 
     */
    public LookbackPutBasketOptionData createLookbackPutBasketOptionData() {
        return new LookbackPutBasketOptionData();
    }

    /**
     * Create an instance of {@link Crossgammafilter }
     * 
     */
    public Crossgammafilter createCrossgammafilter() {
        return new Crossgammafilter();
    }

    /**
     * Create an instance of {@link Equityspots }
     * 
     */
    public Equityspots createEquityspots() {
        return new Equityspots();
    }

    /**
     * Create an instance of {@link Recoveryrate }
     * 
     */
    public Recoveryrate createRecoveryrate() {
        return new Recoveryrate();
    }

    /**
     * Create an instance of {@link StFreeStyleOptionTypeVectorBase }
     * 
     */
    public StFreeStyleOptionTypeVectorBase createStFreeStyleOptionTypeVectorBase() {
        return new StFreeStyleOptionTypeVectorBase();
    }

    /**
     * Create an instance of {@link VolBarrierOptionData }
     * 
     */
    public VolBarrierOptionData createVolBarrierOptionData() {
        return new VolBarrierOptionData();
    }

    /**
     * Create an instance of {@link LookbackCallBasketOptionData }
     * 
     */
    public LookbackCallBasketOptionData createLookbackCallBasketOptionData() {
        return new LookbackCallBasketOptionData();
    }

    /**
     * Create an instance of {@link VolatilityConfig }
     * 
     */
    public VolatilityConfig createVolatilityConfig() {
        return new VolatilityConfig();
    }

    /**
     * Create an instance of {@link StFreeStyleCurrencyVectorBase }
     * 
     */
    public StFreeStyleCurrencyVectorBase createStFreeStyleCurrencyVectorBase() {
        return new StFreeStyleCurrencyVectorBase();
    }

    /**
     * Create an instance of {@link OptionExerciseData }
     * 
     */
    public OptionExerciseData createOptionExerciseData() {
        return new OptionExerciseData();
    }

    /**
     * Create an instance of {@link AsianRainbowCallSpreadOptionData }
     * 
     */
    public AsianRainbowCallSpreadOptionData createAsianRainbowCallSpreadOptionData() {
        return new AsianRainbowCallSpreadOptionData();
    }

    /**
     * Create an instance of {@link AmortizationData }
     * 
     */
    public AmortizationData createAmortizationData() {
        return new AmortizationData();
    }

    /**
     * Create an instance of {@link FxForwardData }
     * 
     */
    public FxForwardData createFxForwardData() {
        return new FxForwardData();
    }

    /**
     * Create an instance of {@link SensitivityCdsVolatilities }
     * 
     */
    public SensitivityCdsVolatilities createSensitivityCdsVolatilities() {
        return new SensitivityCdsVolatilities();
    }

    /**
     * Create an instance of {@link Parameters }
     * 
     */
    public Parameters createParameters() {
        return new Parameters();
    }

    /**
     * Create an instance of {@link CbMandatoryConversionData }
     * 
     */
    public CbMandatoryConversionData createCbMandatoryConversionData() {
        return new CbMandatoryConversionData();
    }

    /**
     * Create an instance of {@link BasketVarianceSwapData2 }
     * 
     */
    public BasketVarianceSwapData2 createBasketVarianceSwapData2() {
        return new BasketVarianceSwapData2();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatilities }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatilities createSwaptionVolatilities() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatilities();
    }

    /**
     * Create an instance of {@link Yycapfloorvolatility }
     * 
     */
    public Yycapfloorvolatility createYycapfloorvolatility() {
        return new Yycapfloorvolatility();
    }

    /**
     * Create an instance of {@link EquityFutureOptionData }
     * 
     */
    public EquityFutureOptionData createEquityFutureOptionData() {
        return new EquityFutureOptionData();
    }

    /**
     * Create an instance of {@link WorstPerformanceRainbowOption03Data }
     * 
     */
    public WorstPerformanceRainbowOption03Data createWorstPerformanceRainbowOption03Data() {
        return new WorstPerformanceRainbowOption03Data();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.EquityVolatilities }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.EquityVolatilities createEquityVolatilities() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.EquityVolatilities();
    }

    /**
     * Create an instance of {@link InflationCurve }
     * 
     */
    public InflationCurve createInflationCurve() {
        return new InflationCurve();
    }

    /**
     * Create an instance of {@link CrossCurrencySegmentType }
     * 
     */
    public CrossCurrencySegmentType createCrossCurrencySegmentType() {
        return new CrossCurrencySegmentType();
    }

    /**
     * Create an instance of {@link BondBasketData }
     * 
     */
    public BondBasketData createBondBasketData() {
        return new BondBasketData();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Caps }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Caps createCaps() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Caps();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.EquityCurve }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.EquityCurve createEquityCurve() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.EquityCurve();
    }

    /**
     * Create an instance of {@link AveragingDataType }
     * 
     */
    public AveragingDataType createAveragingDataType() {
        return new AveragingDataType();
    }

    /**
     * Create an instance of {@link FixedStrikeForwardStartingOptionData }
     * 
     */
    public FixedStrikeForwardStartingOptionData createFixedStrikeForwardStartingOptionData() {
        return new FixedStrikeForwardStartingOptionData();
    }

    /**
     * Create an instance of {@link InflationCurves }
     * 
     */
    public InflationCurves createInflationCurves() {
        return new InflationCurves();
    }

    /**
     * Create an instance of {@link ContinuationMappingsType }
     * 
     */
    public ContinuationMappingsType createContinuationMappingsType() {
        return new ContinuationMappingsType();
    }

    /**
     * Create an instance of {@link IndexingData }
     * 
     */
    public IndexingData createIndexingData() {
        return new IndexingData();
    }

    /**
     * Create an instance of {@link VolatilityMoneynessSurfaceConfig }
     * 
     */
    public VolatilityMoneynessSurfaceConfig createVolatilityMoneynessSurfaceConfig() {
        return new VolatilityMoneynessSurfaceConfig();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.ReferenceDatum }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.ReferenceDatum createReferenceDatum() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.ReferenceDatum();
    }

    /**
     * Create an instance of {@link Survivalprobabilities }
     * 
     */
    public Survivalprobabilities createSurvivalprobabilities() {
        return new Survivalprobabilities();
    }

    /**
     * Create an instance of {@link BasketOptionData }
     * 
     */
    public BasketOptionData createBasketOptionData() {
        return new BasketOptionData();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatilities }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatilities createCapFloorVolatilities() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatilities();
    }

    /**
     * Create an instance of {@link BondOptionData }
     * 
     */
    public BondOptionData createBondOptionData() {
        return new BondOptionData();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.FxVolatility }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.FxVolatility createFxVolatility() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.FxVolatility();
    }

    /**
     * Create an instance of {@link CmsSpreadOptionType }
     * 
     */
    public CmsSpreadOptionType createCmsSpreadOptionType() {
        return new CmsSpreadOptionType();
    }

    /**
     * Create an instance of {@link LgmReversionTransformation }
     * 
     */
    public LgmReversionTransformation createLgmReversionTransformation() {
        return new LgmReversionTransformation();
    }

    /**
     * Create an instance of {@link ZeroType }
     * 
     */
    public ZeroType createZeroType() {
        return new ZeroType();
    }

    /**
     * Create an instance of {@link Risk }
     * 
     */
    public Risk createRisk() {
        return new Risk();
    }

    /**
     * Create an instance of {@link ParametricSmileConfigParameters }
     * 
     */
    public ParametricSmileConfigParameters createParametricSmileConfigParameters() {
        return new ParametricSmileConfigParameters();
    }

    /**
     * Create an instance of {@link DepositType }
     * 
     */
    public DepositType createDepositType() {
        return new DepositType();
    }

    /**
     * Create an instance of {@link IrregularYYIISData }
     * 
     */
    public IrregularYYIISData createIrregularYYIISData() {
        return new IrregularYYIISData();
    }

    /**
     * Create an instance of {@link TenorBasisSegmentType }
     * 
     */
    public TenorBasisSegmentType createTenorBasisSegmentType() {
        return new TenorBasisSegmentType();
    }

    /**
     * Create an instance of {@link BondFutureData }
     * 
     */
    public BondFutureData createBondFutureData() {
        return new BondFutureData();
    }

    /**
     * Create an instance of {@link EquityCurves }
     * 
     */
    public EquityCurves createEquityCurves() {
        return new EquityCurves();
    }

    /**
     * Create an instance of {@link CdsVolatilities }
     * 
     */
    public CdsVolatilities createCdsVolatilities() {
        return new CdsVolatilities();
    }

    /**
     * Create an instance of {@link SetRiskFactorKeyTypes }
     * 
     */
    public SetRiskFactorKeyTypes createSetRiskFactorKeyTypes() {
        return new SetRiskFactorKeyTypes();
    }

    /**
     * Create an instance of {@link SimCommodityCurves }
     * 
     */
    public SimCommodityCurves createSimCommodityCurves() {
        return new SimCommodityCurves();
    }

    /**
     * Create an instance of {@link StFreeStyleBarrierType }
     * 
     */
    public StFreeStyleBarrierType createStFreeStyleBarrierType() {
        return new StFreeStyleBarrierType();
    }

    /**
     * Create an instance of {@link Transitionmatrices }
     * 
     */
    public Transitionmatrices createTransitionmatrices() {
        return new Transitionmatrices();
    }

    /**
     * Create an instance of {@link InflationswapType }
     * 
     */
    public InflationswapType createInflationswapType() {
        return new InflationswapType();
    }

    /**
     * Create an instance of {@link Creditcurves }
     * 
     */
    public Creditcurves createCreditcurves() {
        return new Creditcurves();
    }

    /**
     * Create an instance of {@link SwapData }
     * 
     */
    public SwapData createSwapData() {
        return new SwapData();
    }

    /**
     * Create an instance of {@link TlockData }
     * 
     */
    public TlockData createTlockData() {
        return new TlockData();
    }

    /**
     * Create an instance of {@link StFreeStyleOptionTypeVector }
     * 
     */
    public StFreeStyleOptionTypeVector createStFreeStyleOptionTypeVector() {
        return new StFreeStyleOptionTypeVector();
    }

    /**
     * Create an instance of {@link ReportConfiguration }
     * 
     */
    public ReportConfiguration createReportConfiguration() {
        return new ReportConfiguration();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.YieldCurve }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.YieldCurve createYieldCurve() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.YieldCurve();
    }

    /**
     * Create an instance of {@link SensitivityFxVolatilities }
     * 
     */
    public SensitivityFxVolatilities createSensitivityFxVolatilities() {
        return new SensitivityFxVolatilities();
    }

    /**
     * Create an instance of {@link TrsAdditionalCashflowData }
     * 
     */
    public TrsAdditionalCashflowData createTrsAdditionalCashflowData() {
        return new TrsAdditionalCashflowData();
    }

    /**
     * Create an instance of {@link StFreeStyleDayCounter }
     * 
     */
    public StFreeStyleDayCounter createStFreeStyleDayCounter() {
        return new StFreeStyleDayCounter();
    }

    /**
     * Create an instance of {@link ContinuationMappingType }
     * 
     */
    public ContinuationMappingType createContinuationMappingType() {
        return new ContinuationMappingType();
    }

    /**
     * Create an instance of {@link FxOption }
     * 
     */
    public FxOption createFxOption() {
        return new FxOption();
    }

    /**
     * Create an instance of {@link BgSwapData }
     * 
     */
    public BgSwapData createBgSwapData() {
        return new BgSwapData();
    }

    /**
     * Create an instance of {@link ForwardVolatilityAgreementData }
     * 
     */
    public ForwardVolatilityAgreementData createForwardVolatilityAgreementData() {
        return new ForwardVolatilityAgreementData();
    }

    /**
     * Create an instance of {@link RainbowOptionData }
     * 
     */
    public RainbowOptionData createRainbowOptionData() {
        return new RainbowOptionData();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.EquityVolatility }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.EquityVolatility createEquityVolatility() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.EquityVolatility();
    }

    /**
     * Create an instance of {@link Correlationcurves }
     * 
     */
    public Correlationcurves createCorrelationcurves() {
        return new Correlationcurves();
    }

    /**
     * Create an instance of {@link DualEuroBinaryOptionDoubleKOData }
     * 
     */
    public DualEuroBinaryOptionDoubleKOData createDualEuroBinaryOptionDoubleKOData() {
        return new DualEuroBinaryOptionDoubleKOData();
    }

    /**
     * Create an instance of {@link BasketVarianceSwapData }
     * 
     */
    public BasketVarianceSwapData createBasketVarianceSwapData() {
        return new BasketVarianceSwapData();
    }

    /**
     * Create an instance of {@link ConfigurationType }
     * 
     */
    public ConfigurationType createConfigurationType() {
        return new ConfigurationType();
    }

    /**
     * Create an instance of {@link VarianceDispersionSwapData }
     * 
     */
    public VarianceDispersionSwapData createVarianceDispersionSwapData() {
        return new VarianceDispersionSwapData();
    }

    /**
     * Create an instance of {@link CalibrationYoYSwap }
     * 
     */
    public CalibrationYoYSwap createCalibrationYoYSwap() {
        return new CalibrationYoYSwap();
    }

    /**
     * Create an instance of {@link StFreeStyleIndexVector }
     * 
     */
    public StFreeStyleIndexVector createStFreeStyleIndexVector() {
        return new StFreeStyleIndexVector();
    }

    /**
     * Create an instance of {@link Stressfxvolatilities }
     * 
     */
    public Stressfxvolatilities createStressfxvolatilities() {
        return new Stressfxvolatilities();
    }

    /**
     * Create an instance of {@link FxTouchOptionData }
     * 
     */
    public FxTouchOptionData createFxTouchOptionData() {
        return new FxTouchOptionData();
    }

    /**
     * Create an instance of {@link CommodityAveragePriceOptionData }
     * 
     */
    public CommodityAveragePriceOptionData createCommodityAveragePriceOptionData() {
        return new CommodityAveragePriceOptionData();
    }

    /**
     * Create an instance of {@link StFreeStyleBoolVectorBase }
     * 
     */
    public StFreeStyleBoolVectorBase createStFreeStyleBoolVectorBase() {
        return new StFreeStyleBoolVectorBase();
    }

    /**
     * Create an instance of {@link StFreeStyleBool }
     * 
     */
    public StFreeStyleBool createStFreeStyleBool() {
        return new StFreeStyleBool();
    }

    /**
     * Create an instance of {@link SensitivityCapFloorVolatilities }
     * 
     */
    public SensitivityCapFloorVolatilities createSensitivityCapFloorVolatilities() {
        return new SensitivityCapFloorVolatilities();
    }

    /**
     * Create an instance of {@link ConstantMaturityVolatilitySwapData }
     * 
     */
    public ConstantMaturityVolatilitySwapData createConstantMaturityVolatilitySwapData() {
        return new ConstantMaturityVolatilitySwapData();
    }

    /**
     * Create an instance of {@link CommoditySpreadOptionStripPaymentData }
     * 
     */
    public CommoditySpreadOptionStripPaymentData createCommoditySpreadOptionStripPaymentData() {
        return new CommoditySpreadOptionStripPaymentData();
    }

    /**
     * Create an instance of {@link WorstPerformanceRainbowOption02Data }
     * 
     */
    public WorstPerformanceRainbowOption02Data createWorstPerformanceRainbowOption02Data() {
        return new WorstPerformanceRainbowOption02Data();
    }

    /**
     * Create an instance of {@link StFreeStyleBarrierTypeVector }
     * 
     */
    public StFreeStyleBarrierTypeVector createStFreeStyleBarrierTypeVector() {
        return new StFreeStyleBarrierTypeVector();
    }

    /**
     * Create an instance of {@link ConditionalVarianceSwap02Data }
     * 
     */
    public ConditionalVarianceSwap02Data createConditionalVarianceSwap02Data() {
        return new ConditionalVarianceSwap02Data();
    }

    /**
     * Create an instance of {@link ConstantVolatilityConfig }
     * 
     */
    public ConstantVolatilityConfig createConstantVolatilityConfig() {
        return new ConstantVolatilityConfig();
    }

    /**
     * Create an instance of {@link Recoveryrates }
     * 
     */
    public Recoveryrates createRecoveryrates() {
        return new Recoveryrates();
    }

    /**
     * Create an instance of {@link PriceSegmentsType }
     * 
     */
    public PriceSegmentsType createPriceSegmentsType() {
        return new PriceSegmentsType();
    }

    /**
     * Create an instance of {@link CommodityPositionData }
     * 
     */
    public CommodityPositionData createCommodityPositionData() {
        return new CommodityPositionData();
    }

    /**
     * Create an instance of {@link FutureType }
     * 
     */
    public FutureType createFutureType() {
        return new FutureType();
    }

    /**
     * Create an instance of {@link StFreeStyleDayCounterVector }
     * 
     */
    public StFreeStyleDayCounterVector createStFreeStyleDayCounterVector() {
        return new StFreeStyleDayCounterVector();
    }

    /**
     * Create an instance of {@link GenericBarrierOptionDataRaw }
     * 
     */
    public GenericBarrierOptionDataRaw createGenericBarrierOptionDataRaw() {
        return new GenericBarrierOptionDataRaw();
    }

    /**
     * Create an instance of {@link KikoCorridorVarianceSwapData }
     * 
     */
    public KikoCorridorVarianceSwapData createKikoCorridorVarianceSwapData() {
        return new KikoCorridorVarianceSwapData();
    }

    /**
     * Create an instance of {@link Indexcurve }
     * 
     */
    public Indexcurve createIndexcurve() {
        return new Indexcurve();
    }

    /**
     * Create an instance of {@link SwaptionData }
     * 
     */
    public SwaptionData createSwaptionData() {
        return new SwaptionData();
    }

    /**
     * Create an instance of {@link SeasonalityType }
     * 
     */
    public SeasonalityType createSeasonalityType() {
        return new SeasonalityType();
    }

    /**
     * Create an instance of {@link AssetLinkedCliquetOptionData }
     * 
     */
    public AssetLinkedCliquetOptionData createAssetLinkedCliquetOptionData() {
        return new AssetLinkedCliquetOptionData();
    }

    /**
     * Create an instance of {@link Stresstest }
     * 
     */
    public Stresstest createStresstest() {
        return new Stresstest();
    }

    /**
     * Create an instance of {@link ZeroSpreadType }
     * 
     */
    public ZeroSpreadType createZeroSpreadType() {
        return new ZeroSpreadType();
    }

    /**
     * Create an instance of {@link TenorBasisSwapType }
     * 
     */
    public TenorBasisSwapType createTenorBasisSwapType() {
        return new TenorBasisSwapType();
    }

    /**
     * Create an instance of {@link Stresscapfloorvolatilities }
     * 
     */
    public Stresscapfloorvolatilities createStresscapfloorvolatilities() {
        return new Stresscapfloorvolatilities();
    }

    /**
     * Create an instance of {@link MinMaxType }
     * 
     */
    public MinMaxType createMinMaxType() {
        return new MinMaxType();
    }

    /**
     * Create an instance of {@link EquityOptionUnderlyingData }
     * 
     */
    public EquityOptionUnderlyingData createEquityOptionUnderlyingData() {
        return new EquityOptionUnderlyingData();
    }

    /**
     * Create an instance of {@link SensitivityCdsVolatility }
     * 
     */
    public SensitivityCdsVolatility createSensitivityCdsVolatility() {
        return new SensitivityCdsVolatility();
    }

    /**
     * Create an instance of {@link DividendInterpolation }
     * 
     */
    public DividendInterpolation createDividendInterpolation() {
        return new DividendInterpolation();
    }

    /**
     * Create an instance of {@link SensitivityYieldVolatilities }
     * 
     */
    public SensitivityYieldVolatilities createSensitivityYieldVolatilities() {
        return new SensitivityYieldVolatilities();
    }

    /**
     * Create an instance of {@link Creditcurve }
     * 
     */
    public Creditcurve createCreditcurve() {
        return new Creditcurve();
    }

    /**
     * Create an instance of {@link DualEuroBinaryOptionData }
     * 
     */
    public DualEuroBinaryOptionData createDualEuroBinaryOptionData() {
        return new DualEuroBinaryOptionData();
    }

    /**
     * Create an instance of {@link FloatWithAttribute }
     * 
     */
    public FloatWithAttribute createFloatWithAttribute() {
        return new FloatWithAttribute();
    }

    /**
     * Create an instance of {@link WindowBarrierOptionData2 }
     * 
     */
    public WindowBarrierOptionData2 createWindowBarrierOptionData2() {
        return new WindowBarrierOptionData2();
    }

    /**
     * Create an instance of {@link CrossCurrencyBasisType }
     * 
     */
    public CrossCurrencyBasisType createCrossCurrencyBasisType() {
        return new CrossCurrencyBasisType();
    }

    /**
     * Create an instance of {@link CmsCapFloorBarrierData }
     * 
     */
    public CmsCapFloorBarrierData createCmsCapFloorBarrierData() {
        return new CmsCapFloorBarrierData();
    }

    /**
     * Create an instance of {@link BootstrapConfigType }
     * 
     */
    public BootstrapConfigType createBootstrapConfigType() {
        return new BootstrapConfigType();
    }

    /**
     * Create an instance of {@link FxTermsData }
     * 
     */
    public FxTermsData createFxTermsData() {
        return new FxTermsData();
    }

    /**
     * Create an instance of {@link IborFallbackType }
     * 
     */
    public IborFallbackType createIborFallbackType() {
        return new IborFallbackType();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Security }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Security createSecurity() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Security();
    }

    /**
     * Create an instance of {@link CdsConventionsType }
     * 
     */
    public CdsConventionsType createCdsConventionsType() {
        return new CdsConventionsType();
    }

    /**
     * Create an instance of {@link Dividendyields }
     * 
     */
    public Dividendyields createDividendyields() {
        return new Dividendyields();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.Parameter }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.Parameter createParameter() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.Parameter();
    }

    /**
     * Create an instance of {@link PriceSegmentType }
     * 
     */
    public PriceSegmentType createPriceSegmentType() {
        return new PriceSegmentType();
    }

    /**
     * Create an instance of {@link Indexcurves }
     * 
     */
    public Indexcurves createIndexcurves() {
        return new Indexcurves();
    }

    /**
     * Create an instance of {@link StFreeStyleIndex }
     * 
     */
    public StFreeStyleIndex createStFreeStyleIndex() {
        return new StFreeStyleIndex();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.CommodityVolatilities }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.CommodityVolatilities createCommodityVolatilities() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.CommodityVolatilities();
    }

    /**
     * Create an instance of {@link StFreeStyleLongShort }
     * 
     */
    public StFreeStyleLongShort createStFreeStyleLongShort() {
        return new StFreeStyleLongShort();
    }

    /**
     * Create an instance of {@link VarianceSwapData }
     * 
     */
    public VarianceSwapData createVarianceSwapData() {
        return new VarianceSwapData();
    }

    /**
     * Create an instance of {@link SensitivityFxVolatility }
     * 
     */
    public SensitivityFxVolatility createSensitivityFxVolatility() {
        return new SensitivityFxVolatility();
    }

    /**
     * Create an instance of {@link CreditDefaultSwapData }
     * 
     */
    public CreditDefaultSwapData createCreditDefaultSwapData() {
        return new CreditDefaultSwapData();
    }

    /**
     * Create an instance of {@link Cbotranches }
     * 
     */
    public Cbotranches createCbotranches() {
        return new Cbotranches();
    }

    /**
     * Create an instance of {@link InflationCapFloorVolatlities }
     * 
     */
    public InflationCapFloorVolatlities createInflationCapFloorVolatlities() {
        return new InflationCapFloorVolatlities();
    }

    /**
     * Create an instance of {@link ShiftTypeEntry }
     * 
     */
    public ShiftTypeEntry createShiftTypeEntry() {
        return new ShiftTypeEntry();
    }

    /**
     * Create an instance of {@link CbExchangeableData }
     * 
     */
    public CbExchangeableData createCbExchangeableData() {
        return new CbExchangeableData();
    }

    /**
     * Create an instance of {@link EuropeanOptionBarrierData }
     * 
     */
    public EuropeanOptionBarrierData createEuropeanOptionBarrierData() {
        return new EuropeanOptionBarrierData();
    }

    /**
     * Create an instance of {@link SensitivityBaseCorrelations }
     * 
     */
    public SensitivityBaseCorrelations createSensitivityBaseCorrelations() {
        return new SensitivityBaseCorrelations();
    }

    /**
     * Create an instance of {@link WorstPerformanceRainbowOption01Data }
     * 
     */
    public WorstPerformanceRainbowOption01Data createWorstPerformanceRainbowOption01Data() {
        return new WorstPerformanceRainbowOption01Data();
    }

    /**
     * Create an instance of {@link ProxySurface }
     * 
     */
    public ProxySurface createProxySurface() {
        return new ProxySurface();
    }

    /**
     * Create an instance of {@link AuctionSettlementInformation }
     * 
     */
    public AuctionSettlementInformation createAuctionSettlementInformation() {
        return new AuctionSettlementInformation();
    }

    /**
     * Create an instance of {@link StFreeStyleDayCounterVectorBase }
     * 
     */
    public StFreeStyleDayCounterVectorBase createStFreeStyleDayCounterVectorBase() {
        return new StFreeStyleDayCounterVectorBase();
    }

    /**
     * Create an instance of {@link Counterparty }
     * 
     */
    public Counterparty createCounterparty() {
        return new Counterparty();
    }

    /**
     * Create an instance of {@link BestOfAssetOrCashRainbowOptionData }
     * 
     */
    public BestOfAssetOrCashRainbowOptionData createBestOfAssetOrCashRainbowOptionData() {
        return new BestOfAssetOrCashRainbowOptionData();
    }

    /**
     * Create an instance of {@link FxType }
     * 
     */
    public FxType createFxType() {
        return new FxType();
    }

    /**
     * Create an instance of {@link CapFloorData.Floors.Floor }
     * 
     */
    public CapFloorData.Floors.Floor createCapFloorDataFloorsFloor() {
        return new CapFloorData.Floors.Floor();
    }

    /**
     * Create an instance of {@link CapFloorData.Caps.Cap }
     * 
     */
    public CapFloorData.Caps.Cap createCapFloorDataCapsCap() {
        return new CapFloorData.Caps.Cap();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.QuoteTypes }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.QuoteTypes createBaseCorrelationQuoteTypes() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.QuoteTypes();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryProbabilities.Probabilities }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryProbabilities.Probabilities createBaseCorrelationRecoveryProbabilitiesProbabilities() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryProbabilities.Probabilities();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryGrid.Grid }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryGrid.Grid createBaseCorrelationRecoveryGridGrid() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.BaseCorrelation.RecoveryGrid.Grid();
    }

    /**
     * Create an instance of {@link CrossAssetLGM.Sigma }
     * 
     */
    public CrossAssetLGM.Sigma createCrossAssetLGMSigma() {
        return new CrossAssetLGM.Sigma();
    }

    /**
     * Create an instance of {@link CrossAssetLGM.CalibrationOptions }
     * 
     */
    public CrossAssetLGM.CalibrationOptions createCrossAssetLGMCalibrationOptions() {
        return new CrossAssetLGM.CalibrationOptions();
    }

    /**
     * Create an instance of {@link BondRepoData.RepoData }
     * 
     */
    public BondRepoData.RepoData createBondRepoDataRepoData() {
        return new BondRepoData.RepoData();
    }

    /**
     * Create an instance of {@link PortfolioBasketReferenceDatum.Components.Trade }
     * 
     */
    public PortfolioBasketReferenceDatum.Components.Trade createPortfolioBasketReferenceDatumComponentsTrade() {
        return new PortfolioBasketReferenceDatum.Components.Trade();
    }

    /**
     * Create an instance of {@link ScriptedTradeData.Data.Daycounter.Values }
     * 
     */
    public ScriptedTradeData.Data.Daycounter.Values createScriptedTradeDataDataDaycounterValues() {
        return new ScriptedTradeData.Data.Daycounter.Values();
    }

    /**
     * Create an instance of {@link ScriptedTradeData.Data.Event.DerivedSchedule }
     * 
     */
    public ScriptedTradeData.Data.Event.DerivedSchedule createScriptedTradeDataDataEventDerivedSchedule() {
        return new ScriptedTradeData.Data.Event.DerivedSchedule();
    }

    /**
     * Create an instance of {@link ScriptedTradeData.Data.Index.Values }
     * 
     */
    public ScriptedTradeData.Data.Index.Values createScriptedTradeDataDataIndexValues() {
        return new ScriptedTradeData.Data.Index.Values();
    }

    /**
     * Create an instance of {@link ScriptedTradeData.Data.Currency.Values }
     * 
     */
    public ScriptedTradeData.Data.Currency.Values createScriptedTradeDataDataCurrencyValues() {
        return new ScriptedTradeData.Data.Currency.Values();
    }

    /**
     * Create an instance of {@link ScriptedTradeData.Data.Number.Values }
     * 
     */
    public ScriptedTradeData.Data.Number.Values createScriptedTradeDataDataNumberValues() {
        return new ScriptedTradeData.Data.Number.Values();
    }

    /**
     * Create an instance of {@link YieldVolatilitiesType.YieldVolatility }
     * 
     */
    public YieldVolatilitiesType.YieldVolatility createYieldVolatilitiesTypeYieldVolatility() {
        return new YieldVolatilitiesType.YieldVolatility();
    }

    /**
     * Create an instance of {@link DodgsonKainth.CalibrationBaskets }
     * 
     */
    public DodgsonKainth.CalibrationBaskets createDodgsonKainthCalibrationBaskets() {
        return new DodgsonKainth.CalibrationBaskets();
    }

    /**
     * Create an instance of {@link DodgsonKainth.Reversion }
     * 
     */
    public DodgsonKainth.Reversion createDodgsonKainthReversion() {
        return new DodgsonKainth.Reversion();
    }

    /**
     * Create an instance of {@link DodgsonKainth.Volatility }
     * 
     */
    public DodgsonKainth.Volatility createDodgsonKainthVolatility() {
        return new DodgsonKainth.Volatility();
    }

    /**
     * Create an instance of {@link DodgsonKainth.ParameterTransformation }
     * 
     */
    public DodgsonKainth.ParameterTransformation createDodgsonKainthParameterTransformation() {
        return new DodgsonKainth.ParameterTransformation();
    }

    /**
     * Create an instance of {@link CbDividendProtectionData.Thresholds.Threshold }
     * 
     */
    public CbDividendProtectionData.Thresholds.Threshold createCbDividendProtectionDataThresholdsThreshold() {
        return new CbDividendProtectionData.Thresholds.Threshold();
    }

    /**
     * Create an instance of {@link CbDividendProtectionData.DividendTypes.DividendType }
     * 
     */
    public CbDividendProtectionData.DividendTypes.DividendType createCbDividendProtectionDataDividendTypesDividendType() {
        return new CbDividendProtectionData.DividendTypes.DividendType();
    }

    /**
     * Create an instance of {@link CbDividendProtectionData.AdjustmentStyles.AdjustmentStyle }
     * 
     */
    public CbDividendProtectionData.AdjustmentStyles.AdjustmentStyle createCbDividendProtectionDataAdjustmentStylesAdjustmentStyle() {
        return new CbDividendProtectionData.AdjustmentStyles.AdjustmentStyle();
    }

    /**
     * Create an instance of {@link EquityCurvesType.EquityCurve }
     * 
     */
    public EquityCurvesType.EquityCurve createEquityCurvesTypeEquityCurve() {
        return new EquityCurvesType.EquityCurve();
    }

    /**
     * Create an instance of {@link Market.Currencies }
     * 
     */
    public Market.Currencies createMarketCurrencies() {
        return new Market.Currencies();
    }

    /**
     * Create an instance of {@link Market.Indices }
     * 
     */
    public Market.Indices createMarketIndices() {
        return new Market.Indices();
    }

    /**
     * Create an instance of {@link Market.CpiIndices }
     * 
     */
    public Market.CpiIndices createMarketCpiIndices() {
        return new Market.CpiIndices();
    }

    /**
     * Create an instance of {@link Market.AggregationScenarioDataCurrencies }
     * 
     */
    public Market.AggregationScenarioDataCurrencies createMarketAggregationScenarioDataCurrencies() {
        return new Market.AggregationScenarioDataCurrencies();
    }

    /**
     * Create an instance of {@link Market.AggregationScenarioDataIndices }
     * 
     */
    public Market.AggregationScenarioDataIndices createMarketAggregationScenarioDataIndices() {
        return new Market.AggregationScenarioDataIndices();
    }

    /**
     * Create an instance of {@link Market.AggregationScenarioDataCreditStates }
     * 
     */
    public Market.AggregationScenarioDataCreditStates createMarketAggregationScenarioDataCreditStates() {
        return new Market.AggregationScenarioDataCreditStates();
    }

    /**
     * Create an instance of {@link Market.AggregationScenarioDataSurvivalWeights }
     * 
     */
    public Market.AggregationScenarioDataSurvivalWeights createMarketAggregationScenarioDataSurvivalWeights() {
        return new Market.AggregationScenarioDataSurvivalWeights();
    }

    /**
     * Create an instance of {@link Market.CreditStates }
     * 
     */
    public Market.CreditStates createMarketCreditStates() {
        return new Market.CreditStates();
    }

    /**
     * Create an instance of {@link Market.Correlations.Pairs }
     * 
     */
    public Market.Correlations.Pairs createMarketCorrelationsPairs() {
        return new Market.Correlations.Pairs();
    }

    /**
     * Create an instance of {@link Market.BaseCorrelations.IndexNames }
     * 
     */
    public Market.BaseCorrelations.IndexNames createMarketBaseCorrelationsIndexNames() {
        return new Market.BaseCorrelations.IndexNames();
    }

    /**
     * Create an instance of {@link Market.BaseCorrelations.DayCounters.DayCounter }
     * 
     */
    public Market.BaseCorrelations.DayCounters.DayCounter createMarketBaseCorrelationsDayCountersDayCounter() {
        return new Market.BaseCorrelations.DayCounters.DayCounter();
    }

    /**
     * Create an instance of {@link Market.CommodityVolatilities.SmileDynamics }
     * 
     */
    public Market.CommodityVolatilities.SmileDynamics createMarketCommodityVolatilitiesSmileDynamics() {
        return new Market.CommodityVolatilities.SmileDynamics();
    }

    /**
     * Create an instance of {@link Market.CommodityVolatilities.Names.Name }
     * 
     */
    public Market.CommodityVolatilities.Names.Name createMarketCommodityVolatilitiesNamesName() {
        return new Market.CommodityVolatilities.Names.Name();
    }

    /**
     * Create an instance of {@link Market.Commodities.Names }
     * 
     */
    public Market.Commodities.Names createMarketCommoditiesNames() {
        return new Market.Commodities.Names();
    }

    /**
     * Create an instance of {@link Market.Commodities.Tenors }
     * 
     */
    public Market.Commodities.Tenors createMarketCommoditiesTenors() {
        return new Market.Commodities.Tenors();
    }

    /**
     * Create an instance of {@link Market.Commodities.DayCounters.DayCounter }
     * 
     */
    public Market.Commodities.DayCounters.DayCounter createMarketCommoditiesDayCountersDayCounter() {
        return new Market.Commodities.DayCounters.DayCounter();
    }

    /**
     * Create an instance of {@link Market.YYCapFloorVolatilities.Names }
     * 
     */
    public Market.YYCapFloorVolatilities.Names createMarketYYCapFloorVolatilitiesNames() {
        return new Market.YYCapFloorVolatilities.Names();
    }

    /**
     * Create an instance of {@link Market.YYCapFloorVolatilities.SmileDynamics }
     * 
     */
    public Market.YYCapFloorVolatilities.SmileDynamics createMarketYYCapFloorVolatilitiesSmileDynamics() {
        return new Market.YYCapFloorVolatilities.SmileDynamics();
    }

    /**
     * Create an instance of {@link Market.CPICapFloorVolatilities.Names }
     * 
     */
    public Market.CPICapFloorVolatilities.Names createMarketCPICapFloorVolatilitiesNames() {
        return new Market.CPICapFloorVolatilities.Names();
    }

    /**
     * Create an instance of {@link Market.CPICapFloorVolatilities.SmileDynamics }
     * 
     */
    public Market.CPICapFloorVolatilities.SmileDynamics createMarketCPICapFloorVolatilitiesSmileDynamics() {
        return new Market.CPICapFloorVolatilities.SmileDynamics();
    }

    /**
     * Create an instance of {@link Market.YYInflationIndexCurves.Names }
     * 
     */
    public Market.YYInflationIndexCurves.Names createMarketYYInflationIndexCurvesNames() {
        return new Market.YYInflationIndexCurves.Names();
    }

    /**
     * Create an instance of {@link Market.YYInflationIndexCurves.DayCounters.DayCounter }
     * 
     */
    public Market.YYInflationIndexCurves.DayCounters.DayCounter createMarketYYInflationIndexCurvesDayCountersDayCounter() {
        return new Market.YYInflationIndexCurves.DayCounters.DayCounter();
    }

    /**
     * Create an instance of {@link Market.ZeroInflationIndexCurves.Names }
     * 
     */
    public Market.ZeroInflationIndexCurves.Names createMarketZeroInflationIndexCurvesNames() {
        return new Market.ZeroInflationIndexCurves.Names();
    }

    /**
     * Create an instance of {@link Market.ZeroInflationIndexCurves.DayCounters.DayCounter }
     * 
     */
    public Market.ZeroInflationIndexCurves.DayCounters.DayCounter createMarketZeroInflationIndexCurvesDayCountersDayCounter() {
        return new Market.ZeroInflationIndexCurves.DayCounters.DayCounter();
    }

    /**
     * Create an instance of {@link Market.CPRs.Names }
     * 
     */
    public Market.CPRs.Names createMarketCPRsNames() {
        return new Market.CPRs.Names();
    }

    /**
     * Create an instance of {@link Market.Securities.Names }
     * 
     */
    public Market.Securities.Names createMarketSecuritiesNames() {
        return new Market.Securities.Names();
    }

    /**
     * Create an instance of {@link Market.BenchmarkCurves.BenchmarkCurve }
     * 
     */
    public Market.BenchmarkCurves.BenchmarkCurve createMarketBenchmarkCurvesBenchmarkCurve() {
        return new Market.BenchmarkCurves.BenchmarkCurve();
    }

    /**
     * Create an instance of {@link Market.EquityVolatilities.Names }
     * 
     */
    public Market.EquityVolatilities.Names createMarketEquityVolatilitiesNames() {
        return new Market.EquityVolatilities.Names();
    }

    /**
     * Create an instance of {@link Market.EquityVolatilities.Expiries }
     * 
     */
    public Market.EquityVolatilities.Expiries createMarketEquityVolatilitiesExpiries() {
        return new Market.EquityVolatilities.Expiries();
    }

    /**
     * Create an instance of {@link Market.EquityVolatilities.SmileDynamics }
     * 
     */
    public Market.EquityVolatilities.SmileDynamics createMarketEquityVolatilitiesSmileDynamics() {
        return new Market.EquityVolatilities.SmileDynamics();
    }

    /**
     * Create an instance of {@link Market.EquityVolatilities.DayCounters.DayCounter }
     * 
     */
    public Market.EquityVolatilities.DayCounters.DayCounter createMarketEquityVolatilitiesDayCountersDayCounter() {
        return new Market.EquityVolatilities.DayCounters.DayCounter();
    }

    /**
     * Create an instance of {@link Market.EquityVolatilities.Surface.Moneyness }
     * 
     */
    public Market.EquityVolatilities.Surface.Moneyness createMarketEquityVolatilitiesSurfaceMoneyness() {
        return new Market.EquityVolatilities.Surface.Moneyness();
    }

    /**
     * Create an instance of {@link Market.EquityVolatilities.Surface.StandardDeviations }
     * 
     */
    public Market.EquityVolatilities.Surface.StandardDeviations createMarketEquityVolatilitiesSurfaceStandardDeviations() {
        return new Market.EquityVolatilities.Surface.StandardDeviations();
    }

    /**
     * Create an instance of {@link Market.FxVolatilities.CurrencyPairs }
     * 
     */
    public Market.FxVolatilities.CurrencyPairs createMarketFxVolatilitiesCurrencyPairs() {
        return new Market.FxVolatilities.CurrencyPairs();
    }

    /**
     * Create an instance of {@link Market.FxVolatilities.Expiries }
     * 
     */
    public Market.FxVolatilities.Expiries createMarketFxVolatilitiesExpiries() {
        return new Market.FxVolatilities.Expiries();
    }

    /**
     * Create an instance of {@link Market.FxVolatilities.SmileDynamics }
     * 
     */
    public Market.FxVolatilities.SmileDynamics createMarketFxVolatilitiesSmileDynamics() {
        return new Market.FxVolatilities.SmileDynamics();
    }

    /**
     * Create an instance of {@link Market.FxVolatilities.DayCounters.DayCounter }
     * 
     */
    public Market.FxVolatilities.DayCounters.DayCounter createMarketFxVolatilitiesDayCountersDayCounter() {
        return new Market.FxVolatilities.DayCounters.DayCounter();
    }

    /**
     * Create an instance of {@link Market.FxVolatilities.Surface.Moneyness }
     * 
     */
    public Market.FxVolatilities.Surface.Moneyness createMarketFxVolatilitiesSurfaceMoneyness() {
        return new Market.FxVolatilities.Surface.Moneyness();
    }

    /**
     * Create an instance of {@link Market.FxVolatilities.Surface.StandardDeviations }
     * 
     */
    public Market.FxVolatilities.Surface.StandardDeviations createMarketFxVolatilitiesSurfaceStandardDeviations() {
        return new Market.FxVolatilities.Surface.StandardDeviations();
    }

    /**
     * Create an instance of {@link Market.CDSVolatilities.Names }
     * 
     */
    public Market.CDSVolatilities.Names createMarketCDSVolatilitiesNames() {
        return new Market.CDSVolatilities.Names();
    }

    /**
     * Create an instance of {@link Market.CDSVolatilities.SmileDynamics }
     * 
     */
    public Market.CDSVolatilities.SmileDynamics createMarketCDSVolatilitiesSmileDynamics() {
        return new Market.CDSVolatilities.SmileDynamics();
    }

    /**
     * Create an instance of {@link Market.CapFloorVolatilities.Keys }
     * 
     */
    public Market.CapFloorVolatilities.Keys createMarketCapFloorVolatilitiesKeys() {
        return new Market.CapFloorVolatilities.Keys();
    }

    /**
     * Create an instance of {@link Market.CapFloorVolatilities.Currencies }
     * 
     */
    public Market.CapFloorVolatilities.Currencies createMarketCapFloorVolatilitiesCurrencies() {
        return new Market.CapFloorVolatilities.Currencies();
    }

    /**
     * Create an instance of {@link Market.CapFloorVolatilities.Expiries }
     * 
     */
    public Market.CapFloorVolatilities.Expiries createMarketCapFloorVolatilitiesExpiries() {
        return new Market.CapFloorVolatilities.Expiries();
    }

    /**
     * Create an instance of {@link Market.CapFloorVolatilities.Strikes }
     * 
     */
    public Market.CapFloorVolatilities.Strikes createMarketCapFloorVolatilitiesStrikes() {
        return new Market.CapFloorVolatilities.Strikes();
    }

    /**
     * Create an instance of {@link Market.CapFloorVolatilities.SmileDynamics }
     * 
     */
    public Market.CapFloorVolatilities.SmileDynamics createMarketCapFloorVolatilitiesSmileDynamics() {
        return new Market.CapFloorVolatilities.SmileDynamics();
    }

    /**
     * Create an instance of {@link Market.CapFloorVolatilities.DayCounters.DayCounter }
     * 
     */
    public Market.CapFloorVolatilities.DayCounters.DayCounter createMarketCapFloorVolatilitiesDayCountersDayCounter() {
        return new Market.CapFloorVolatilities.DayCounters.DayCounter();
    }

    /**
     * Create an instance of {@link Market.YieldVolatilities.Names }
     * 
     */
    public Market.YieldVolatilities.Names createMarketYieldVolatilitiesNames() {
        return new Market.YieldVolatilities.Names();
    }

    /**
     * Create an instance of {@link Market.YieldVolatilities.Cube }
     * 
     */
    public Market.YieldVolatilities.Cube createMarketYieldVolatilitiesCube() {
        return new Market.YieldVolatilities.Cube();
    }

    /**
     * Create an instance of {@link Market.YieldVolatilities.SmileDynamics }
     * 
     */
    public Market.YieldVolatilities.SmileDynamics createMarketYieldVolatilitiesSmileDynamics() {
        return new Market.YieldVolatilities.SmileDynamics();
    }

    /**
     * Create an instance of {@link Market.YieldVolatilities.DayCounters.DayCounter }
     * 
     */
    public Market.YieldVolatilities.DayCounters.DayCounter createMarketYieldVolatilitiesDayCountersDayCounter() {
        return new Market.YieldVolatilities.DayCounters.DayCounter();
    }

    /**
     * Create an instance of {@link Market.SwaptionVolatilities.Keys }
     * 
     */
    public Market.SwaptionVolatilities.Keys createMarketSwaptionVolatilitiesKeys() {
        return new Market.SwaptionVolatilities.Keys();
    }

    /**
     * Create an instance of {@link Market.SwaptionVolatilities.Currencies }
     * 
     */
    public Market.SwaptionVolatilities.Currencies createMarketSwaptionVolatilitiesCurrencies() {
        return new Market.SwaptionVolatilities.Currencies();
    }

    /**
     * Create an instance of {@link Market.SwaptionVolatilities.Expiries }
     * 
     */
    public Market.SwaptionVolatilities.Expiries createMarketSwaptionVolatilitiesExpiries() {
        return new Market.SwaptionVolatilities.Expiries();
    }

    /**
     * Create an instance of {@link Market.SwaptionVolatilities.Terms }
     * 
     */
    public Market.SwaptionVolatilities.Terms createMarketSwaptionVolatilitiesTerms() {
        return new Market.SwaptionVolatilities.Terms();
    }

    /**
     * Create an instance of {@link Market.SwaptionVolatilities.StrikeSpreads }
     * 
     */
    public Market.SwaptionVolatilities.StrikeSpreads createMarketSwaptionVolatilitiesStrikeSpreads() {
        return new Market.SwaptionVolatilities.StrikeSpreads();
    }

    /**
     * Create an instance of {@link Market.SwaptionVolatilities.SmileDynamics }
     * 
     */
    public Market.SwaptionVolatilities.SmileDynamics createMarketSwaptionVolatilitiesSmileDynamics() {
        return new Market.SwaptionVolatilities.SmileDynamics();
    }

    /**
     * Create an instance of {@link Market.SwaptionVolatilities.DayCounters.DayCounter }
     * 
     */
    public Market.SwaptionVolatilities.DayCounters.DayCounter createMarketSwaptionVolatilitiesDayCountersDayCounter() {
        return new Market.SwaptionVolatilities.DayCounters.DayCounter();
    }

    /**
     * Create an instance of {@link Market.Equities.Names }
     * 
     */
    public Market.Equities.Names createMarketEquitiesNames() {
        return new Market.Equities.Names();
    }

    /**
     * Create an instance of {@link Market.DefaultCurves.Names }
     * 
     */
    public Market.DefaultCurves.Names createMarketDefaultCurvesNames() {
        return new Market.DefaultCurves.Names();
    }

    /**
     * Create an instance of {@link Market.DefaultCurves.Calendars.Calendar }
     * 
     */
    public Market.DefaultCurves.Calendars.Calendar createMarketDefaultCurvesCalendarsCalendar() {
        return new Market.DefaultCurves.Calendars.Calendar();
    }

    /**
     * Create an instance of {@link Market.DefaultCurves.DayCounters.DayCounter }
     * 
     */
    public Market.DefaultCurves.DayCounters.DayCounter createMarketDefaultCurvesDayCountersDayCounter() {
        return new Market.DefaultCurves.DayCounters.DayCounter();
    }

    /**
     * Create an instance of {@link Market.SwapIndices.SwapIndex }
     * 
     */
    public Market.SwapIndices.SwapIndex createMarketSwapIndicesSwapIndex() {
        return new Market.SwapIndices.SwapIndex();
    }

    /**
     * Create an instance of {@link Market.FxRates.CurrencyPairs }
     * 
     */
    public Market.FxRates.CurrencyPairs createMarketFxRatesCurrencyPairs() {
        return new Market.FxRates.CurrencyPairs();
    }

    /**
     * Create an instance of {@link Market.YieldCurves.Configuration }
     * 
     */
    public Market.YieldCurves.Configuration createMarketYieldCurvesConfiguration() {
        return new Market.YieldCurves.Configuration();
    }

    /**
     * Create an instance of {@link CommodityCurvesType.CommodityCurve }
     * 
     */
    public CommodityCurvesType.CommodityCurve createCommodityCurvesTypeCommodityCurve() {
        return new CommodityCurvesType.CommodityCurve();
    }

    /**
     * Create an instance of {@link Stresscapfloorvolatility.Shifts.Shift }
     * 
     */
    public Stresscapfloorvolatility.Shifts.Shift createStresscapfloorvolatilityShiftsShift() {
        return new Stresscapfloorvolatility.Shifts.Shift();
    }

    /**
     * Create an instance of {@link IndexReferenceDatum.Underlying }
     * 
     */
    public IndexReferenceDatum.Underlying createIndexReferenceDatumUnderlying() {
        return new IndexReferenceDatum.Underlying();
    }

    /**
     * Create an instance of {@link PricesType.Price }
     * 
     */
    public PricesType.Price createPricesTypePrice() {
        return new PricesType.Price();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility.ProxyConfig.Source }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility.ProxyConfig.Source createSwaptionVolatilityProxyConfigSource() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility.ProxyConfig.Source();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility.ProxyConfig.Target }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility.ProxyConfig.Target createSwaptionVolatilityProxyConfigTarget() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.SwaptionVolatility.ProxyConfig.Target();
    }

    /**
     * Create an instance of {@link JarrowYildrim.CalibrationBaskets }
     * 
     */
    public JarrowYildrim.CalibrationBaskets createJarrowYildrimCalibrationBaskets() {
        return new JarrowYildrim.CalibrationBaskets();
    }

    /**
     * Create an instance of {@link JarrowYildrim.RealRate }
     * 
     */
    public JarrowYildrim.RealRate createJarrowYildrimRealRate() {
        return new JarrowYildrim.RealRate();
    }

    /**
     * Create an instance of {@link JarrowYildrim.Index }
     * 
     */
    public JarrowYildrim.Index createJarrowYildrimIndex() {
        return new JarrowYildrim.Index();
    }

    /**
     * Create an instance of {@link FxSpotsType.FxSpot }
     * 
     */
    public FxSpotsType.FxSpot createFxSpotsTypeFxSpot() {
        return new FxSpotsType.FxSpot();
    }

    /**
     * Create an instance of {@link AccumulatorData.RangeBounds }
     * 
     */
    public AccumulatorData.RangeBounds createAccumulatorDataRangeBounds() {
        return new AccumulatorData.RangeBounds();
    }

    /**
     * Create an instance of {@link AccumulatorData.Barriers }
     * 
     */
    public AccumulatorData.Barriers createAccumulatorDataBarriers() {
        return new AccumulatorData.Barriers();
    }

    /**
     * Create an instance of {@link CreditIndexReferenceDatum.Underlying }
     * 
     */
    public CreditIndexReferenceDatum.Underlying createCreditIndexReferenceDatumUnderlying() {
        return new CreditIndexReferenceDatum.Underlying();
    }

    /**
     * Create an instance of {@link TrsUnderlyingData.Derivative }
     * 
     */
    public TrsUnderlyingData.Derivative createTrsUnderlyingDataDerivative() {
        return new TrsUnderlyingData.Derivative();
    }

    /**
     * Create an instance of {@link TrsUnderlyingData.PortfolioIndexTradeData }
     * 
     */
    public TrsUnderlyingData.PortfolioIndexTradeData createTrsUnderlyingDataPortfolioIndexTradeData() {
        return new TrsUnderlyingData.PortfolioIndexTradeData();
    }

    /**
     * Create an instance of {@link QuantitiesType.Quantity }
     * 
     */
    public QuantitiesType.Quantity createQuantitiesTypeQuantity() {
        return new QuantitiesType.Quantity();
    }

    /**
     * Create an instance of {@link FlexiSwapData.Prepayment.PrepaymentOptions.PrepaymentOption }
     * 
     */
    public FlexiSwapData.Prepayment.PrepaymentOptions.PrepaymentOption createFlexiSwapDataPrepaymentPrepaymentOptionsPrepaymentOption() {
        return new FlexiSwapData.Prepayment.PrepaymentOptions.PrepaymentOption();
    }

    /**
     * Create an instance of {@link FlexiSwapData.LowerNotionalBounds.Notional }
     * 
     */
    public FlexiSwapData.LowerNotionalBounds.Notional createFlexiSwapDataLowerNotionalBoundsNotional() {
        return new FlexiSwapData.LowerNotionalBounds.Notional();
    }

    /**
     * Create an instance of {@link Parconversion.Conventions.Convention }
     * 
     */
    public Parconversion.Conventions.Convention createParconversionConventionsConvention() {
        return new Parconversion.Conventions.Convention();
    }

    /**
     * Create an instance of {@link TarfData2 .RangeBounds }
     * 
     */
    public TarfData2 .RangeBounds createTarfData2RangeBounds() {
        return new TarfData2 .RangeBounds();
    }

    /**
     * Create an instance of {@link TarfData2 .Barriers }
     * 
     */
    public TarfData2 .Barriers createTarfData2Barriers() {
        return new TarfData2 .Barriers();
    }

    /**
     * Create an instance of {@link TarfData2 .RangeBoundSet.RangeBounds }
     * 
     */
    public TarfData2 .RangeBoundSet.RangeBounds createTarfData2RangeBoundSetRangeBounds() {
        return new TarfData2 .RangeBoundSet.RangeBounds();
    }

    /**
     * Create an instance of {@link TarfData2 .Strikes.Strike }
     * 
     */
    public TarfData2 .Strikes.Strike createTarfData2StrikesStrike() {
        return new TarfData2 .Strikes.Strike();
    }

    /**
     * Create an instance of {@link RpaData.ProtectionFee }
     * 
     */
    public RpaData.ProtectionFee createRpaDataProtectionFee() {
        return new RpaData.ProtectionFee();
    }

    /**
     * Create an instance of {@link RpaData.Underlying }
     * 
     */
    public RpaData.Underlying createRpaDataUnderlying() {
        return new RpaData.Underlying();
    }

    /**
     * Create an instance of {@link SensitivityYieldVolatility.Shifts.Shift }
     * 
     */
    public SensitivityYieldVolatility.Shifts.Shift createSensitivityYieldVolatilityShiftsShift() {
        return new SensitivityYieldVolatility.Shifts.Shift();
    }

    /**
     * Create an instance of {@link CreditNonQualifying.Correlations.InterBucket.Correlation }
     * 
     */
    public CreditNonQualifying.Correlations.InterBucket.Correlation createCreditNonQualifyingCorrelationsInterBucketCorrelation() {
        return new CreditNonQualifying.Correlations.InterBucket.Correlation();
    }

    /**
     * Create an instance of {@link CreditNonQualifying.Correlations.IntraBucket.Correlation }
     * 
     */
    public CreditNonQualifying.Correlations.IntraBucket.Correlation createCreditNonQualifyingCorrelationsIntraBucketCorrelation() {
        return new CreditNonQualifying.Correlations.IntraBucket.Correlation();
    }

    /**
     * Create an instance of {@link CreditNonQualifying.RiskWeights.Vega }
     * 
     */
    public CreditNonQualifying.RiskWeights.Vega createCreditNonQualifyingRiskWeightsVega() {
        return new CreditNonQualifying.RiskWeights.Vega();
    }

    /**
     * Create an instance of {@link CreditNonQualifying.RiskWeights.Delta.Weight }
     * 
     */
    public CreditNonQualifying.RiskWeights.Delta.Weight createCreditNonQualifyingRiskWeightsDeltaWeight() {
        return new CreditNonQualifying.RiskWeights.Delta.Weight();
    }

    /**
     * Create an instance of {@link ForwardBondData.PremiumData }
     * 
     */
    public ForwardBondData.PremiumData createForwardBondDataPremiumData() {
        return new ForwardBondData.PremiumData();
    }

    /**
     * Create an instance of {@link CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate.Underlying }
     * 
     */
    public CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate.Underlying createCurrencyHedgedIndexReferenceDatumIndexWeightsAtLastRebalancingDateUnderlying() {
        return new CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate.Underlying();
    }

    /**
     * Create an instance of {@link CurrencyHedgedIndexReferenceDatum.FxIndexes.FxIndex }
     * 
     */
    public CurrencyHedgedIndexReferenceDatum.FxIndexes.FxIndex createCurrencyHedgedIndexReferenceDatumFxIndexesFxIndex() {
        return new CurrencyHedgedIndexReferenceDatum.FxIndexes.FxIndex();
    }

    /**
     * Create an instance of {@link CurrencyLists.Currency }
     * 
     */
    public CurrencyLists.Currency createCurrencyListsCurrency() {
        return new CurrencyLists.Currency();
    }

    /**
     * Create an instance of {@link Autocallable01Data.FixingDates }
     * 
     */
    public Autocallable01Data.FixingDates createAutocallable01DataFixingDates() {
        return new Autocallable01Data.FixingDates();
    }

    /**
     * Create an instance of {@link Autocallable01Data.SettlementDates }
     * 
     */
    public Autocallable01Data.SettlementDates createAutocallable01DataSettlementDates() {
        return new Autocallable01Data.SettlementDates();
    }

    /**
     * Create an instance of {@link Autocallable01Data.AccumulationFactors }
     * 
     */
    public Autocallable01Data.AccumulationFactors createAutocallable01DataAccumulationFactors() {
        return new Autocallable01Data.AccumulationFactors();
    }

    /**
     * Create an instance of {@link WorstOfBasketSwapData2 .InitialPrices }
     * 
     */
    public WorstOfBasketSwapData2 .InitialPrices createWorstOfBasketSwapData2InitialPrices() {
        return new WorstOfBasketSwapData2 .InitialPrices();
    }

    /**
     * Create an instance of {@link WorstOfBasketSwapData2 .KnockOutLevels }
     * 
     */
    public WorstOfBasketSwapData2 .KnockOutLevels createWorstOfBasketSwapData2KnockOutLevels() {
        return new WorstOfBasketSwapData2 .KnockOutLevels();
    }

    /**
     * Create an instance of {@link WorstOfBasketSwapData2 .FixedTriggerLevels }
     * 
     */
    public WorstOfBasketSwapData2 .FixedTriggerLevels createWorstOfBasketSwapData2FixedTriggerLevels() {
        return new WorstOfBasketSwapData2 .FixedTriggerLevels();
    }

    /**
     * Create an instance of {@link SecuritiesType.Security }
     * 
     */
    public SecuritiesType.Security createSecuritiesTypeSecurity() {
        return new SecuritiesType.Security();
    }

    /**
     * Create an instance of {@link ParameterListType.Parameter }
     * 
     */
    public ParameterListType.Parameter createParameterListTypeParameter() {
        return new ParameterListType.Parameter();
    }

    /**
     * Create an instance of {@link CalibrationConfiguration.Constraints }
     * 
     */
    public CalibrationConfiguration.Constraints createCalibrationConfigurationConstraints() {
        return new CalibrationConfiguration.Constraints();
    }

    /**
     * Create an instance of {@link FxVolatilitiesType.FxVolatility }
     * 
     */
    public FxVolatilitiesType.FxVolatility createFxVolatilitiesTypeFxVolatility() {
        return new FxVolatilitiesType.FxVolatility();
    }

    /**
     * Create an instance of {@link LegDataCapfloor.PaymentDates }
     * 
     */
    public LegDataCapfloor.PaymentDates createLegDataCapfloorPaymentDates() {
        return new LegDataCapfloor.PaymentDates();
    }

    /**
     * Create an instance of {@link LegDataCapfloor.Notionals.Notional }
     * 
     */
    public LegDataCapfloor.Notionals.Notional createLegDataCapfloorNotionalsNotional() {
        return new LegDataCapfloor.Notionals.Notional();
    }

    /**
     * Create an instance of {@link OptionPaymentData.Dates }
     * 
     */
    public OptionPaymentData.Dates createOptionPaymentDataDates() {
        return new OptionPaymentData.Dates();
    }

    /**
     * Create an instance of {@link OptionPaymentData.Rules }
     * 
     */
    public OptionPaymentData.Rules createOptionPaymentDataRules() {
        return new OptionPaymentData.Rules();
    }

    /**
     * Create an instance of {@link SwapIndexCurvesType.SwapIndex }
     * 
     */
    public SwapIndexCurvesType.SwapIndex createSwapIndexCurvesTypeSwapIndex() {
        return new SwapIndexCurvesType.SwapIndex();
    }

    /**
     * Create an instance of {@link GenericBarrierOptionData.Barriers }
     * 
     */
    public GenericBarrierOptionData.Barriers createGenericBarrierOptionDataBarriers() {
        return new GenericBarrierOptionData.Barriers();
    }

    /**
     * Create an instance of {@link GenericBarrierOptionData.TransatlanticBarrier }
     * 
     */
    public GenericBarrierOptionData.TransatlanticBarrier createGenericBarrierOptionDataTransatlanticBarrier() {
        return new GenericBarrierOptionData.TransatlanticBarrier();
    }

    /**
     * Create an instance of {@link CrossCurrencyLGM.Sigma }
     * 
     */
    public CrossCurrencyLGM.Sigma createCrossCurrencyLGMSigma() {
        return new CrossCurrencyLGM.Sigma();
    }

    /**
     * Create an instance of {@link CrossCurrencyLGM.CalibrationOptions }
     * 
     */
    public CrossCurrencyLGM.CalibrationOptions createCrossCurrencyLGMCalibrationOptions() {
        return new CrossCurrencyLGM.CalibrationOptions();
    }

    /**
     * Create an instance of {@link SwaptionVolatilitiesType.SwaptionVolatility }
     * 
     */
    public SwaptionVolatilitiesType.SwaptionVolatility createSwaptionVolatilitiesTypeSwaptionVolatility() {
        return new SwaptionVolatilitiesType.SwaptionVolatility();
    }

    /**
     * Create an instance of {@link DefaultCurvesType.DefaultCurve }
     * 
     */
    public DefaultCurvesType.DefaultCurve createDefaultCurvesTypeDefaultCurve() {
        return new DefaultCurvesType.DefaultCurve();
    }

    /**
     * Create an instance of {@link Lgm.Volatility }
     * 
     */
    public Lgm.Volatility createLgmVolatility() {
        return new Lgm.Volatility();
    }

    /**
     * Create an instance of {@link Lgm.Reversion }
     * 
     */
    public Lgm.Reversion createLgmReversion() {
        return new Lgm.Reversion();
    }

    /**
     * Create an instance of {@link Lgm.CalibrationSwaptions }
     * 
     */
    public Lgm.CalibrationSwaptions createLgmCalibrationSwaptions() {
        return new Lgm.CalibrationSwaptions();
    }

    /**
     * Create an instance of {@link Lgm.CalibrationCapFloors }
     * 
     */
    public Lgm.CalibrationCapFloors createLgmCalibrationCapFloors() {
        return new Lgm.CalibrationCapFloors();
    }

    /**
     * Create an instance of {@link Lgm.CalibrationBaskets }
     * 
     */
    public Lgm.CalibrationBaskets createLgmCalibrationBaskets() {
        return new Lgm.CalibrationBaskets();
    }

    /**
     * Create an instance of {@link Lgm.ParameterTransformation }
     * 
     */
    public Lgm.ParameterTransformation createLgmParameterTransformation() {
        return new Lgm.ParameterTransformation();
    }

    /**
     * Create an instance of {@link YieldCurvesType.YieldCurve }
     * 
     */
    public YieldCurvesType.YieldCurve createYieldCurvesTypeYieldCurve() {
        return new YieldCurvesType.YieldCurve();
    }

    /**
     * Create an instance of {@link IndexForwardingCurvesType.Index }
     * 
     */
    public IndexForwardingCurvesType.Index createIndexForwardingCurvesTypeIndex() {
        return new IndexForwardingCurvesType.Index();
    }

    /**
     * Create an instance of {@link Envelope.PortfolioIds }
     * 
     */
    public Envelope.PortfolioIds createEnvelopePortfolioIds() {
        return new Envelope.PortfolioIds();
    }

    /**
     * Create an instance of {@link Envelope.AdditionalFields }
     * 
     */
    public Envelope.AdditionalFields createEnvelopeAdditionalFields() {
        return new Envelope.AdditionalFields();
    }

    /**
     * Create an instance of {@link FittedBondType.IborIndexCurves.IborIndexCurve }
     * 
     */
    public FittedBondType.IborIndexCurves.IborIndexCurve createFittedBondTypeIborIndexCurvesIborIndexCurve() {
        return new FittedBondType.IborIndexCurves.IborIndexCurve();
    }

    /**
     * Create an instance of {@link Crlgm.Volatility }
     * 
     */
    public Crlgm.Volatility createCrlgmVolatility() {
        return new Crlgm.Volatility();
    }

    /**
     * Create an instance of {@link Crlgm.Reversion }
     * 
     */
    public Crlgm.Reversion createCrlgmReversion() {
        return new Crlgm.Reversion();
    }

    /**
     * Create an instance of {@link Crlgm.CalibrationCdsOptions }
     * 
     */
    public Crlgm.CalibrationCdsOptions createCrlgmCalibrationCdsOptions() {
        return new Crlgm.CalibrationCdsOptions();
    }

    /**
     * Create an instance of {@link Crlgm.ParameterTransformation }
     * 
     */
    public Crlgm.ParameterTransformation createCrlgmParameterTransformation() {
        return new Crlgm.ParameterTransformation();
    }

    /**
     * Create an instance of {@link StFreeStyleEventScheduleBase.DerivedSchedule }
     * 
     */
    public StFreeStyleEventScheduleBase.DerivedSchedule createStFreeStyleEventScheduleBaseDerivedSchedule() {
        return new StFreeStyleEventScheduleBase.DerivedSchedule();
    }

    /**
     * Create an instance of {@link FxKIKOBarrierOptionData.Barriers }
     * 
     */
    public FxKIKOBarrierOptionData.Barriers createFxKIKOBarrierOptionDataBarriers() {
        return new FxKIKOBarrierOptionData.Barriers();
    }

    /**
     * Create an instance of {@link CreditQualifying.Correlations.InterBucket.Correlation }
     * 
     */
    public CreditQualifying.Correlations.InterBucket.Correlation createCreditQualifyingCorrelationsInterBucketCorrelation() {
        return new CreditQualifying.Correlations.InterBucket.Correlation();
    }

    /**
     * Create an instance of {@link CreditQualifying.Correlations.IntraBucket.Correlation }
     * 
     */
    public CreditQualifying.Correlations.IntraBucket.Correlation createCreditQualifyingCorrelationsIntraBucketCorrelation() {
        return new CreditQualifying.Correlations.IntraBucket.Correlation();
    }

    /**
     * Create an instance of {@link CreditQualifying.RiskWeights.Vega }
     * 
     */
    public CreditQualifying.RiskWeights.Vega createCreditQualifyingRiskWeightsVega() {
        return new CreditQualifying.RiskWeights.Vega();
    }

    /**
     * Create an instance of {@link CreditQualifying.RiskWeights.BaseCorrelation }
     * 
     */
    public CreditQualifying.RiskWeights.BaseCorrelation createCreditQualifyingRiskWeightsBaseCorrelation() {
        return new CreditQualifying.RiskWeights.BaseCorrelation();
    }

    /**
     * Create an instance of {@link CreditQualifying.RiskWeights.Delta.Weight }
     * 
     */
    public CreditQualifying.RiskWeights.Delta.Weight createCreditQualifyingRiskWeightsDeltaWeight() {
        return new CreditQualifying.RiskWeights.Delta.Weight();
    }

    /**
     * Create an instance of {@link YyInflationIndexCurvesType.YYInflationIndexCurve }
     * 
     */
    public YyInflationIndexCurvesType.YYInflationIndexCurve createYyInflationIndexCurvesTypeYYInflationIndexCurve() {
        return new YyInflationIndexCurvesType.YYInflationIndexCurve();
    }

    /**
     * Create an instance of {@link Tranche.Notionals.Notional }
     * 
     */
    public Tranche.Notionals.Notional createTrancheNotionalsNotional() {
        return new Tranche.Notionals.Notional();
    }

    /**
     * Create an instance of {@link TradeLevelFixings.Fixing }
     * 
     */
    public TradeLevelFixings.Fixing createTradeLevelFixingsFixing() {
        return new TradeLevelFixings.Fixing();
    }

    /**
     * Create an instance of {@link EquityVolatilitiesType.EquityVolatility }
     * 
     */
    public EquityVolatilitiesType.EquityVolatility createEquityVolatilitiesTypeEquityVolatility() {
        return new EquityVolatilitiesType.EquityVolatility();
    }

    /**
     * Create an instance of {@link CreditLinkedSwapData.IndependentPayments }
     * 
     */
    public CreditLinkedSwapData.IndependentPayments createCreditLinkedSwapDataIndependentPayments() {
        return new CreditLinkedSwapData.IndependentPayments();
    }

    /**
     * Create an instance of {@link CreditLinkedSwapData.ContingentPayments }
     * 
     */
    public CreditLinkedSwapData.ContingentPayments createCreditLinkedSwapDataContingentPayments() {
        return new CreditLinkedSwapData.ContingentPayments();
    }

    /**
     * Create an instance of {@link CreditLinkedSwapData.DefaultPayments }
     * 
     */
    public CreditLinkedSwapData.DefaultPayments createCreditLinkedSwapDataDefaultPayments() {
        return new CreditLinkedSwapData.DefaultPayments();
    }

    /**
     * Create an instance of {@link CreditLinkedSwapData.RecoveryPayments }
     * 
     */
    public CreditLinkedSwapData.RecoveryPayments createCreditLinkedSwapDataRecoveryPayments() {
        return new CreditLinkedSwapData.RecoveryPayments();
    }

    /**
     * Create an instance of {@link GlobalReportConfiguration.FXVolatilities }
     * 
     */
    public GlobalReportConfiguration.FXVolatilities createGlobalReportConfigurationFXVolatilities() {
        return new GlobalReportConfiguration.FXVolatilities();
    }

    /**
     * Create an instance of {@link GlobalReportConfiguration.EquityVolatilities }
     * 
     */
    public GlobalReportConfiguration.EquityVolatilities createGlobalReportConfigurationEquityVolatilities() {
        return new GlobalReportConfiguration.EquityVolatilities();
    }

    /**
     * Create an instance of {@link GlobalReportConfiguration.CommodityVolatilities }
     * 
     */
    public GlobalReportConfiguration.CommodityVolatilities createGlobalReportConfigurationCommodityVolatilities() {
        return new GlobalReportConfiguration.CommodityVolatilities();
    }

    /**
     * Create an instance of {@link GlobalReportConfiguration.IRSwaptionVolatilities }
     * 
     */
    public GlobalReportConfiguration.IRSwaptionVolatilities createGlobalReportConfigurationIRSwaptionVolatilities() {
        return new GlobalReportConfiguration.IRSwaptionVolatilities();
    }

    /**
     * Create an instance of {@link GlobalReportConfiguration.IRCapFloorVolatilities }
     * 
     */
    public GlobalReportConfiguration.IRCapFloorVolatilities createGlobalReportConfigurationIRCapFloorVolatilities() {
        return new GlobalReportConfiguration.IRCapFloorVolatilities();
    }

    /**
     * Create an instance of {@link GlobalReportConfiguration.YieldCurves }
     * 
     */
    public GlobalReportConfiguration.YieldCurves createGlobalReportConfigurationYieldCurves() {
        return new GlobalReportConfiguration.YieldCurves();
    }

    /**
     * Create an instance of {@link GlobalReportConfiguration.InflationCapFloorVolatilities }
     * 
     */
    public GlobalReportConfiguration.InflationCapFloorVolatilities createGlobalReportConfigurationInflationCapFloorVolatilities() {
        return new GlobalReportConfiguration.InflationCapFloorVolatilities();
    }

    /**
     * Create an instance of {@link EqForwardSettlementData.Rules }
     * 
     */
    public EqForwardSettlementData.Rules createEqForwardSettlementDataRules() {
        return new EqForwardSettlementData.Rules();
    }

    /**
     * Create an instance of {@link CbConversionResetData.GlobalFloors.GloobalFloor }
     * 
     */
    public CbConversionResetData.GlobalFloors.GloobalFloor createCbConversionResetDataGlobalFloorsGloobalFloor() {
        return new CbConversionResetData.GlobalFloors.GloobalFloor();
    }

    /**
     * Create an instance of {@link CbConversionResetData.Floors.Floor }
     * 
     */
    public CbConversionResetData.Floors.Floor createCbConversionResetDataFloorsFloor() {
        return new CbConversionResetData.Floors.Floor();
    }

    /**
     * Create an instance of {@link CbConversionResetData.Gearings.Gearing }
     * 
     */
    public CbConversionResetData.Gearings.Gearing createCbConversionResetDataGearingsGearing() {
        return new CbConversionResetData.Gearings.Gearing();
    }

    /**
     * Create an instance of {@link CbConversionResetData.Thresholds.Threshold }
     * 
     */
    public CbConversionResetData.Thresholds.Threshold createCbConversionResetDataThresholdsThreshold() {
        return new CbConversionResetData.Thresholds.Threshold();
    }

    /**
     * Create an instance of {@link CbConversionResetData.References.Reference }
     * 
     */
    public CbConversionResetData.References.Reference createCbConversionResetDataReferencesReference() {
        return new CbConversionResetData.References.Reference();
    }

    /**
     * Create an instance of {@link CompositeQuoteType.CompositeQuote }
     * 
     */
    public CompositeQuoteType.CompositeQuote createCompositeQuoteTypeCompositeQuote() {
        return new CompositeQuoteType.CompositeQuote();
    }

    /**
     * Create an instance of {@link OreScript.ScheduleCoarsening }
     * 
     */
    public OreScript.ScheduleCoarsening createOreScriptScheduleCoarsening() {
        return new OreScript.ScheduleCoarsening();
    }

    /**
     * Create an instance of {@link OreScript.StickyCloseOutStates }
     * 
     */
    public OreScript.StickyCloseOutStates createOreScriptStickyCloseOutStates() {
        return new OreScript.StickyCloseOutStates();
    }

    /**
     * Create an instance of {@link OreScript.AmcCg.Components }
     * 
     */
    public OreScript.AmcCg.Components createOreScriptAmcCgComponents() {
        return new OreScript.AmcCg.Components();
    }

    /**
     * Create an instance of {@link OreScript.AmcCg.Target }
     * 
     */
    public OreScript.AmcCg.Target createOreScriptAmcCgTarget() {
        return new OreScript.AmcCg.Target();
    }

    /**
     * Create an instance of {@link OreScript.ConditionalExpectation.ModelStates }
     * 
     */
    public OreScript.ConditionalExpectation.ModelStates createOreScriptConditionalExpectationModelStates() {
        return new OreScript.ConditionalExpectation.ModelStates();
    }

    /**
     * Create an instance of {@link OreScript.NewSchedules.NewSchedule.Schedules }
     * 
     */
    public OreScript.NewSchedules.NewSchedule.Schedules createOreScriptNewSchedulesNewScheduleSchedules() {
        return new OreScript.NewSchedules.NewSchedule.Schedules();
    }

    /**
     * Create an instance of {@link OreScript.CalibrationSpec.Calibration.Strikes }
     * 
     */
    public OreScript.CalibrationSpec.Calibration.Strikes createOreScriptCalibrationSpecCalibrationStrikes() {
        return new OreScript.CalibrationSpec.Calibration.Strikes();
    }

    /**
     * Create an instance of {@link OreScript.PricingEngineConfigOverwrite.EngineParameters.Parameter }
     * 
     */
    public OreScript.PricingEngineConfigOverwrite.EngineParameters.Parameter createOreScriptPricingEngineConfigOverwriteEngineParametersParameter() {
        return new OreScript.PricingEngineConfigOverwrite.EngineParameters.Parameter();
    }

    /**
     * Create an instance of {@link OreScript.PricingEngineConfigOverwrite.ModelParameters.Parameter }
     * 
     */
    public OreScript.PricingEngineConfigOverwrite.ModelParameters.Parameter createOreScriptPricingEngineConfigOverwriteModelParametersParameter() {
        return new OreScript.PricingEngineConfigOverwrite.ModelParameters.Parameter();
    }

    /**
     * Create an instance of {@link OreScript.Results.Result }
     * 
     */
    public OreScript.Results.Result createOreScriptResultsResult() {
        return new OreScript.Results.Result();
    }

    /**
     * Create an instance of {@link LegData.Amortizations }
     * 
     */
    public LegData.Amortizations createLegDataAmortizations() {
        return new LegData.Amortizations();
    }

    /**
     * Create an instance of {@link LegData.PaymentDates }
     * 
     */
    public LegData.PaymentDates createLegDataPaymentDates() {
        return new LegData.PaymentDates();
    }

    /**
     * Create an instance of {@link LegData.Indexings }
     * 
     */
    public LegData.Indexings createLegDataIndexings() {
        return new LegData.Indexings();
    }

    /**
     * Create an instance of {@link LegData.SettlementData }
     * 
     */
    public LegData.SettlementData createLegDataSettlementData() {
        return new LegData.SettlementData();
    }

    /**
     * Create an instance of {@link LegData.Notionals.Notional }
     * 
     */
    public LegData.Notionals.Notional createLegDataNotionalsNotional() {
        return new LegData.Notionals.Notional();
    }

    /**
     * Create an instance of {@link CommodityVolatilitiesType.CommodityVolatility }
     * 
     */
    public CommodityVolatilitiesType.CommodityVolatility createCommodityVolatilitiesTypeCommodityVolatility() {
        return new CommodityVolatilitiesType.CommodityVolatility();
    }

    /**
     * Create an instance of {@link PerformanceOption01Data.StrikePrices }
     * 
     */
    public PerformanceOption01Data.StrikePrices createPerformanceOption01DataStrikePrices() {
        return new PerformanceOption01Data.StrikePrices();
    }

    /**
     * Create an instance of {@link ZeroInflationCapFloorVolatilitiesType.ZeroInflationCapFloorVolatility }
     * 
     */
    public ZeroInflationCapFloorVolatilitiesType.ZeroInflationCapFloorVolatility createZeroInflationCapFloorVolatilitiesTypeZeroInflationCapFloorVolatility() {
        return new ZeroInflationCapFloorVolatilitiesType.ZeroInflationCapFloorVolatility();
    }

    /**
     * Create an instance of {@link Product.ModelParameters }
     * 
     */
    public Product.ModelParameters createProductModelParameters() {
        return new Product.ModelParameters();
    }

    /**
     * Create an instance of {@link Product.EngineParameters }
     * 
     */
    public Product.EngineParameters createProductEngineParameters() {
        return new Product.EngineParameters();
    }

    /**
     * Create an instance of {@link Transitionmatrix.Data }
     * 
     */
    public Transitionmatrix.Data createTransitionmatrixData() {
        return new Transitionmatrix.Data();
    }

    /**
     * Create an instance of {@link InterestRate.Correlations.IntraBucket.Correlation }
     * 
     */
    public InterestRate.Correlations.IntraBucket.Correlation createInterestRateCorrelationsIntraBucketCorrelation() {
        return new InterestRate.Correlations.IntraBucket.Correlation();
    }

    /**
     * Create an instance of {@link InterestRate.RiskWeights.Vega }
     * 
     */
    public InterestRate.RiskWeights.Vega createInterestRateRiskWeightsVega() {
        return new InterestRate.RiskWeights.Vega();
    }

    /**
     * Create an instance of {@link InterestRate.RiskWeights.HistoricalVolatilityRatio }
     * 
     */
    public InterestRate.RiskWeights.HistoricalVolatilityRatio createInterestRateRiskWeightsHistoricalVolatilityRatio() {
        return new InterestRate.RiskWeights.HistoricalVolatilityRatio();
    }

    /**
     * Create an instance of {@link InterestRate.RiskWeights.Inflation }
     * 
     */
    public InterestRate.RiskWeights.Inflation createInterestRateRiskWeightsInflation() {
        return new InterestRate.RiskWeights.Inflation();
    }

    /**
     * Create an instance of {@link InterestRate.RiskWeights.XCcyBasis }
     * 
     */
    public InterestRate.RiskWeights.XCcyBasis createInterestRateRiskWeightsXCcyBasis() {
        return new InterestRate.RiskWeights.XCcyBasis();
    }

    /**
     * Create an instance of {@link InterestRate.RiskWeights.Delta.Weight }
     * 
     */
    public InterestRate.RiskWeights.Delta.Weight createInterestRateRiskWeightsDeltaWeight() {
        return new InterestRate.RiskWeights.Delta.Weight();
    }

    /**
     * Create an instance of {@link BarrierData.Levels }
     * 
     */
    public BarrierData.Levels createBarrierDataLevels() {
        return new BarrierData.Levels();
    }

    /**
     * Create an instance of {@link CallableBondCallData.IncludeAccruals.IncludeAccrual }
     * 
     */
    public CallableBondCallData.IncludeAccruals.IncludeAccrual createCallableBondCallDataIncludeAccrualsIncludeAccrual() {
        return new CallableBondCallData.IncludeAccruals.IncludeAccrual();
    }

    /**
     * Create an instance of {@link CallableBondCallData.PriceTypes.PriceType }
     * 
     */
    public CallableBondCallData.PriceTypes.PriceType createCallableBondCallDataPriceTypesPriceType() {
        return new CallableBondCallData.PriceTypes.PriceType();
    }

    /**
     * Create an instance of {@link CallableBondCallData.Prices.Price }
     * 
     */
    public CallableBondCallData.Prices.Price createCallableBondCallDataPricesPrice() {
        return new CallableBondCallData.Prices.Price();
    }

    /**
     * Create an instance of {@link CallableBondCallData.Styles.Style }
     * 
     */
    public CallableBondCallData.Styles.Style createCallableBondCallDataStylesStyle() {
        return new CallableBondCallData.Styles.Style();
    }

    /**
     * Create an instance of {@link CounterPartyCorrelations.Correlation }
     * 
     */
    public CounterPartyCorrelations.Correlation createCounterPartyCorrelationsCorrelation() {
        return new CounterPartyCorrelations.Correlation();
    }

    /**
     * Create an instance of {@link TrsReturnData.PaymentDates }
     * 
     */
    public TrsReturnData.PaymentDates createTrsReturnDataPaymentDates() {
        return new TrsReturnData.PaymentDates();
    }

    /**
     * Create an instance of {@link BondYieldShiftedType.IborIndexCurves.IborIndexCurve }
     * 
     */
    public BondYieldShiftedType.IborIndexCurves.IborIndexCurve createBondYieldShiftedTypeIborIndexCurvesIborIndexCurve() {
        return new BondYieldShiftedType.IborIndexCurves.IborIndexCurve();
    }

    /**
     * Create an instance of {@link CommodityFutureType.AnchorDay }
     * 
     */
    public CommodityFutureType.AnchorDay createCommodityFutureTypeAnchorDay() {
        return new CommodityFutureType.AnchorDay();
    }

    /**
     * Create an instance of {@link CommodityFutureType.ValidContractMonths }
     * 
     */
    public CommodityFutureType.ValidContractMonths createCommodityFutureTypeValidContractMonths() {
        return new CommodityFutureType.ValidContractMonths();
    }

    /**
     * Create an instance of {@link DiscountCurvesType.DiscountingCurve }
     * 
     */
    public DiscountCurvesType.DiscountingCurve createDiscountCurvesTypeDiscountingCurve() {
        return new DiscountCurvesType.DiscountingCurve();
    }

    /**
     * Create an instance of {@link YieldPlusDefaultType.DefaultCurves }
     * 
     */
    public YieldPlusDefaultType.DefaultCurves createYieldPlusDefaultTypeDefaultCurves() {
        return new YieldPlusDefaultType.DefaultCurves();
    }

    /**
     * Create an instance of {@link YieldPlusDefaultType.Weights }
     * 
     */
    public YieldPlusDefaultType.Weights createYieldPlusDefaultTypeWeights() {
        return new YieldPlusDefaultType.Weights();
    }

    /**
     * Create an instance of {@link Hw.PCALoadings }
     * 
     */
    public Hw.PCALoadings createHwPCALoadings() {
        return new Hw.PCALoadings();
    }

    /**
     * Create an instance of {@link Hw.CalibrationSwaptions }
     * 
     */
    public Hw.CalibrationSwaptions createHwCalibrationSwaptions() {
        return new Hw.CalibrationSwaptions();
    }

    /**
     * Create an instance of {@link Hw.Reversion.InitialValue }
     * 
     */
    public Hw.Reversion.InitialValue createHwReversionInitialValue() {
        return new Hw.Reversion.InitialValue();
    }

    /**
     * Create an instance of {@link Hw.Volatility.InitialValue.Sigma }
     * 
     */
    public Hw.Volatility.InitialValue.Sigma createHwVolatilityInitialValueSigma() {
        return new Hw.Volatility.InitialValue.Sigma();
    }

    /**
     * Create an instance of {@link AssetBackedCreditDefaultSwapData.PremiumData }
     * 
     */
    public AssetBackedCreditDefaultSwapData.PremiumData createAssetBackedCreditDefaultSwapDataPremiumData() {
        return new AssetBackedCreditDefaultSwapData.PremiumData();
    }

    /**
     * Create an instance of {@link YyInflationCapFloorVolatilitiesType.YYInflationCapFloorVolatility }
     * 
     */
    public YyInflationCapFloorVolatilitiesType.YYInflationCapFloorVolatility createYyInflationCapFloorVolatilitiesTypeYYInflationCapFloorVolatility() {
        return new YyInflationCapFloorVolatilitiesType.YYInflationCapFloorVolatility();
    }

    /**
     * Create an instance of {@link Fx.Correlations.IntraBucket.Correlation }
     * 
     */
    public Fx.Correlations.IntraBucket.Correlation createFxCorrelationsIntraBucketCorrelation() {
        return new Fx.Correlations.IntraBucket.Correlation();
    }

    /**
     * Create an instance of {@link Fx.RiskWeights.Vega }
     * 
     */
    public Fx.RiskWeights.Vega createFxRiskWeightsVega() {
        return new Fx.RiskWeights.Vega();
    }

    /**
     * Create an instance of {@link Fx.RiskWeights.HistoricalVolatilityRatio }
     * 
     */
    public Fx.RiskWeights.HistoricalVolatilityRatio createFxRiskWeightsHistoricalVolatilityRatio() {
        return new Fx.RiskWeights.HistoricalVolatilityRatio();
    }

    /**
     * Create an instance of {@link Fx.RiskWeights.Inflation }
     * 
     */
    public Fx.RiskWeights.Inflation createFxRiskWeightsInflation() {
        return new Fx.RiskWeights.Inflation();
    }

    /**
     * Create an instance of {@link Fx.RiskWeights.XCcyBasis }
     * 
     */
    public Fx.RiskWeights.XCcyBasis createFxRiskWeightsXCcyBasis() {
        return new Fx.RiskWeights.XCcyBasis();
    }

    /**
     * Create an instance of {@link Fx.RiskWeights.Delta.Weight }
     * 
     */
    public Fx.RiskWeights.Delta.Weight createFxRiskWeightsDeltaWeight() {
        return new Fx.RiskWeights.Delta.Weight();
    }

    /**
     * Create an instance of {@link Cir.CalibrationCdsOptions }
     * 
     */
    public Cir.CalibrationCdsOptions createCirCalibrationCdsOptions() {
        return new Cir.CalibrationCdsOptions();
    }

    /**
     * Create an instance of {@link ZeroInflationIndexCurvesType.ZeroInflationIndexCurve }
     * 
     */
    public ZeroInflationIndexCurvesType.ZeroInflationIndexCurve createZeroInflationIndexCurvesTypeZeroInflationIndexCurve() {
        return new ZeroInflationIndexCurvesType.ZeroInflationIndexCurve();
    }

    /**
     * Create an instance of {@link CbConversionData.FixedAmountConversion.Amounts.Amount }
     * 
     */
    public CbConversionData.FixedAmountConversion.Amounts.Amount createCbConversionDataFixedAmountConversionAmountsAmount() {
        return new CbConversionData.FixedAmountConversion.Amounts.Amount();
    }

    /**
     * Create an instance of {@link CbConversionData.ConversionRatios.ConversionRatio }
     * 
     */
    public CbConversionData.ConversionRatios.ConversionRatio createCbConversionDataConversionRatiosConversionRatio() {
        return new CbConversionData.ConversionRatios.ConversionRatio();
    }

    /**
     * Create an instance of {@link CbConversionData.Styles.Style }
     * 
     */
    public CbConversionData.Styles.Style createCbConversionDataStylesStyle() {
        return new CbConversionData.Styles.Style();
    }

    /**
     * Create an instance of {@link CdsVolatility.Terms.Term }
     * 
     */
    public CdsVolatility.Terms.Term createCdsVolatilityTermsTerm() {
        return new CdsVolatility.Terms.Term();
    }

    /**
     * Create an instance of {@link BaseCorrelationsType.BaseCorrelation }
     * 
     */
    public BaseCorrelationsType.BaseCorrelation createBaseCorrelationsTypeBaseCorrelation() {
        return new BaseCorrelationsType.BaseCorrelation();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.SourceCurves }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.SourceCurves createDefaultCurveSourceCurves() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.SourceCurves();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.SwitchDates }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.SwitchDates createDefaultCurveSwitchDates() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.SwitchDates();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations.Configuration.SourceCurves }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations.Configuration.SourceCurves createDefaultCurveConfigurationsConfigurationSourceCurves() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations.Configuration.SourceCurves();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations.Configuration.SwitchDates }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations.Configuration.SwitchDates createDefaultCurveConfigurationsConfigurationSwitchDates() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.DefaultCurve.Configurations.Configuration.SwitchDates();
    }

    /**
     * Create an instance of {@link FxOptionTimeWeighting.WeekdayWeights }
     * 
     */
    public FxOptionTimeWeighting.WeekdayWeights createFxOptionTimeWeightingWeekdayWeights() {
        return new FxOptionTimeWeighting.WeekdayWeights();
    }

    /**
     * Create an instance of {@link FxOptionTimeWeighting.Events.Event }
     * 
     */
    public FxOptionTimeWeighting.Events.Event createFxOptionTimeWeightingEventsEvent() {
        return new FxOptionTimeWeighting.Events.Event();
    }

    /**
     * Create an instance of {@link FxOptionTimeWeighting.TradingCenters.TradingCenter }
     * 
     */
    public FxOptionTimeWeighting.TradingCenters.TradingCenter createFxOptionTimeWeightingTradingCentersTradingCenter() {
        return new FxOptionTimeWeighting.TradingCenters.TradingCenter();
    }

    /**
     * Create an instance of {@link ConcentrationThresholds.Vega.Threshold }
     * 
     */
    public ConcentrationThresholds.Vega.Threshold createConcentrationThresholdsVegaThreshold() {
        return new ConcentrationThresholds.Vega.Threshold();
    }

    /**
     * Create an instance of {@link ConcentrationThresholds.Delta.Threshold }
     * 
     */
    public ConcentrationThresholds.Delta.Threshold createConcentrationThresholdsDeltaThreshold() {
        return new ConcentrationThresholds.Delta.Threshold();
    }

    /**
     * Create an instance of {@link CbCallData.MakeWhole.ConversionRatioIncrease.CrIncreases.CrIncrease }
     * 
     */
    public CbCallData.MakeWhole.ConversionRatioIncrease.CrIncreases.CrIncrease createCbCallDataMakeWholeConversionRatioIncreaseCrIncreasesCrIncrease() {
        return new CbCallData.MakeWhole.ConversionRatioIncrease.CrIncreases.CrIncrease();
    }

    /**
     * Create an instance of {@link CbCallData.NOfMTriggers.NOfMTrigger }
     * 
     */
    public CbCallData.NOfMTriggers.NOfMTrigger createCbCallDataNOfMTriggersNOfMTrigger() {
        return new CbCallData.NOfMTriggers.NOfMTrigger();
    }

    /**
     * Create an instance of {@link CbCallData.TriggerRatios.TriggerRatio }
     * 
     */
    public CbCallData.TriggerRatios.TriggerRatio createCbCallDataTriggerRatiosTriggerRatio() {
        return new CbCallData.TriggerRatios.TriggerRatio();
    }

    /**
     * Create an instance of {@link CbCallData.Soft.SoftEntry }
     * 
     */
    public CbCallData.Soft.SoftEntry createCbCallDataSoftSoftEntry() {
        return new CbCallData.Soft.SoftEntry();
    }

    /**
     * Create an instance of {@link CbCallData.IncludeAccruals.IncludeAccrual }
     * 
     */
    public CbCallData.IncludeAccruals.IncludeAccrual createCbCallDataIncludeAccrualsIncludeAccrual() {
        return new CbCallData.IncludeAccruals.IncludeAccrual();
    }

    /**
     * Create an instance of {@link CbCallData.PriceTypes.PriceType }
     * 
     */
    public CbCallData.PriceTypes.PriceType createCbCallDataPriceTypesPriceType() {
        return new CbCallData.PriceTypes.PriceType();
    }

    /**
     * Create an instance of {@link CbCallData.Prices.Price }
     * 
     */
    public CbCallData.Prices.Price createCbCallDataPricesPrice() {
        return new CbCallData.Prices.Price();
    }

    /**
     * Create an instance of {@link CbCallData.Styles.Style }
     * 
     */
    public CbCallData.Styles.Style createCbCallDataStylesStyle() {
        return new CbCallData.Styles.Style();
    }

    /**
     * Create an instance of {@link CdsVolatilitiesType.CDSVolatility }
     * 
     */
    public CdsVolatilitiesType.CDSVolatility createCdsVolatilitiesTypeCDSVolatility() {
        return new CdsVolatilitiesType.CDSVolatility();
    }

    /**
     * Create an instance of {@link CorrelationsType.Correlation }
     * 
     */
    public CorrelationsType.Correlation createCorrelationsTypeCorrelation() {
        return new CorrelationsType.Correlation();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.PremiumData.Premium.SettlementData }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.PremiumData.Premium.SettlementData createPremiumDataPremiumSettlementData() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.PremiumData.Premium.SettlementData();
    }

    /**
     * Create an instance of {@link SensitivitySwaptionVolatility.Shifts.Shift }
     * 
     */
    public SensitivitySwaptionVolatility.Shifts.Shift createSensitivitySwaptionVolatilityShiftsShift() {
        return new SensitivitySwaptionVolatility.Shifts.Shift();
    }

    /**
     * Create an instance of {@link ProhibitedExpiriesType.Dates.Date }
     * 
     */
    public ProhibitedExpiriesType.Dates.Date createProhibitedExpiriesTypeDatesDate() {
        return new ProhibitedExpiriesType.Dates.Date();
    }

    /**
     * Create an instance of {@link OptionData.SettlementData }
     * 
     */
    public OptionData.SettlementData createOptionDataSettlementData() {
        return new OptionData.SettlementData();
    }

    /**
     * Create an instance of {@link OptionData.ExerciseFees.ExerciseFee }
     * 
     */
    public OptionData.ExerciseFees.ExerciseFee createOptionDataExerciseFeesExerciseFee() {
        return new OptionData.ExerciseFees.ExerciseFee();
    }

    /**
     * Create an instance of {@link CbContingentConversionData.Barriers.Barrier }
     * 
     */
    public CbContingentConversionData.Barriers.Barrier createCbContingentConversionDataBarriersBarrier() {
        return new CbContingentConversionData.Barriers.Barrier();
    }

    /**
     * Create an instance of {@link CbContingentConversionData.Observations.Observation }
     * 
     */
    public CbContingentConversionData.Observations.Observation createCbContingentConversionDataObservationsObservation() {
        return new CbContingentConversionData.Observations.Observation();
    }

    /**
     * Create an instance of {@link TotalReturnData.PaymentDates }
     * 
     */
    public TotalReturnData.PaymentDates createTotalReturnDataPaymentDates() {
        return new TotalReturnData.PaymentDates();
    }

    /**
     * Create an instance of {@link QuoteType.Quote }
     * 
     */
    public QuoteType.Quote createQuoteTypeQuote() {
        return new QuoteType.Quote();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility.ProxyConfig.Source }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility.ProxyConfig.Source createCapFloorVolatilityProxyConfigSource() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility.ProxyConfig.Source();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility.ProxyConfig.Target }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility.ProxyConfig.Target createCapFloorVolatilityProxyConfigTarget() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.CapFloorVolatility.ProxyConfig.Target();
    }

    /**
     * Create an instance of {@link Commodity.Correlations.InterBucket.Correlation }
     * 
     */
    public Commodity.Correlations.InterBucket.Correlation createCommodityCorrelationsInterBucketCorrelation() {
        return new Commodity.Correlations.InterBucket.Correlation();
    }

    /**
     * Create an instance of {@link Commodity.Correlations.IntraBucket.Correlation }
     * 
     */
    public Commodity.Correlations.IntraBucket.Correlation createCommodityCorrelationsIntraBucketCorrelation() {
        return new Commodity.Correlations.IntraBucket.Correlation();
    }

    /**
     * Create an instance of {@link Commodity.RiskWeights.Vega }
     * 
     */
    public Commodity.RiskWeights.Vega createCommodityRiskWeightsVega() {
        return new Commodity.RiskWeights.Vega();
    }

    /**
     * Create an instance of {@link Commodity.RiskWeights.HistoricalVolatilityRatio }
     * 
     */
    public Commodity.RiskWeights.HistoricalVolatilityRatio createCommodityRiskWeightsHistoricalVolatilityRatio() {
        return new Commodity.RiskWeights.HistoricalVolatilityRatio();
    }

    /**
     * Create an instance of {@link Commodity.RiskWeights.Delta.Weight }
     * 
     */
    public Commodity.RiskWeights.Delta.Weight createCommodityRiskWeightsDeltaWeight() {
        return new Commodity.RiskWeights.Delta.Weight();
    }

    /**
     * Create an instance of {@link AnalyticsType.Analytic }
     * 
     */
    public AnalyticsType.Analytic createAnalyticsTypeAnalytic() {
        return new AnalyticsType.Analytic();
    }

    /**
     * Create an instance of {@link FxForwardSettlementData.Rules }
     * 
     */
    public FxForwardSettlementData.Rules createFxForwardSettlementDataRules() {
        return new FxForwardSettlementData.Rules();
    }

    /**
     * Create an instance of {@link CurveAlgebraCurveOperation.Arguments }
     * 
     */
    public CurveAlgebraCurveOperation.Arguments createCurveAlgebraCurveOperationArguments() {
        return new CurveAlgebraCurveOperation.Arguments();
    }

    /**
     * Create an instance of {@link CapFloorVolatilitiesType.CapFloorVolatility }
     * 
     */
    public CapFloorVolatilitiesType.CapFloorVolatility createCapFloorVolatilitiesTypeCapFloorVolatility() {
        return new CapFloorVolatilitiesType.CapFloorVolatility();
    }

    /**
     * Create an instance of {@link Equity.Correlations.InterBucket.Correlation }
     * 
     */
    public Equity.Correlations.InterBucket.Correlation createEquityCorrelationsInterBucketCorrelation() {
        return new Equity.Correlations.InterBucket.Correlation();
    }

    /**
     * Create an instance of {@link Equity.Correlations.IntraBucket.Correlation }
     * 
     */
    public Equity.Correlations.IntraBucket.Correlation createEquityCorrelationsIntraBucketCorrelation() {
        return new Equity.Correlations.IntraBucket.Correlation();
    }

    /**
     * Create an instance of {@link Equity.RiskWeights.HistoricalVolatilityRatio }
     * 
     */
    public Equity.RiskWeights.HistoricalVolatilityRatio createEquityRiskWeightsHistoricalVolatilityRatio() {
        return new Equity.RiskWeights.HistoricalVolatilityRatio();
    }

    /**
     * Create an instance of {@link Equity.RiskWeights.Vega.Weight }
     * 
     */
    public Equity.RiskWeights.Vega.Weight createEquityRiskWeightsVegaWeight() {
        return new Equity.RiskWeights.Vega.Weight();
    }

    /**
     * Create an instance of {@link Equity.RiskWeights.Delta.Weight }
     * 
     */
    public Equity.RiskWeights.Delta.Weight createEquityRiskWeightsDeltaWeight() {
        return new Equity.RiskWeights.Delta.Weight();
    }

    /**
     * Create an instance of {@link CommoditySchwartz.Sigma }
     * 
     */
    public CommoditySchwartz.Sigma createCommoditySchwartzSigma() {
        return new CommoditySchwartz.Sigma();
    }

    /**
     * Create an instance of {@link CommoditySchwartz.Kappa }
     * 
     */
    public CommoditySchwartz.Kappa createCommoditySchwartzKappa() {
        return new CommoditySchwartz.Kappa();
    }

    /**
     * Create an instance of {@link CommoditySchwartz.Seasonality }
     * 
     */
    public CommoditySchwartz.Seasonality createCommoditySchwartzSeasonality() {
        return new CommoditySchwartz.Seasonality();
    }

    /**
     * Create an instance of {@link CommoditySchwartz.CalibrationOptions }
     * 
     */
    public CommoditySchwartz.CalibrationOptions createCommoditySchwartzCalibrationOptions() {
        return new CommoditySchwartz.CalibrationOptions();
    }

    /**
     * Create an instance of {@link Stressfxvolatility.WeightedShifts }
     * 
     */
    public Stressfxvolatility.WeightedShifts createStressfxvolatilityWeightedShifts() {
        return new Stressfxvolatility.WeightedShifts();
    }

    /**
     * Create an instance of {@link com.ibk.gcb.batch.trs.mvmn.ore.EquityLegData.FXTerms }
     * 
     */
    public com.ibk.gcb.batch.trs.mvmn.ore.EquityLegData.FXTerms createEquityLegDataFXTerms() {
        return new com.ibk.gcb.batch.trs.mvmn.ore.EquityLegData.FXTerms();
    }

    /**
     * Create an instance of {@link SimmCalibration.VersionNames }
     * 
     */
    public SimmCalibration.VersionNames createSimmCalibrationVersionNames() {
        return new SimmCalibration.VersionNames();
    }

    /**
     * Create an instance of {@link SimmCalibration.AdditionalFields }
     * 
     */
    public SimmCalibration.AdditionalFields createSimmCalibrationAdditionalFields() {
        return new SimmCalibration.AdditionalFields();
    }

    /**
     * Create an instance of {@link SimmCalibration.RiskClassCorrelations.Correlation }
     * 
     */
    public SimmCalibration.RiskClassCorrelations.Correlation createSimmCalibrationRiskClassCorrelationsCorrelation() {
        return new SimmCalibration.RiskClassCorrelations.Correlation();
    }

    /**
     * Create an instance of {@link ZeroCouponFixedLegData.Rates.Rate }
     * 
     */
    public ZeroCouponFixedLegData.Rates.Rate createZeroCouponFixedLegDataRatesRate() {
        return new ZeroCouponFixedLegData.Rates.Rate();
    }

    /**
     * Create an instance of {@link CPILegData.Rates.Rate }
     * 
     */
    public CPILegData.Rates.Rate createCPILegDataRatesRate() {
        return new CPILegData.Rates.Rate();
    }

    /**
     * Create an instance of {@link ScheduleData.Rules }
     * 
     */
    public ScheduleData.Rules createScheduleDataRules() {
        return new ScheduleData.Rules();
    }

    /**
     * Create an instance of {@link ScheduleData.Dates.ScheduleDates }
     * 
     */
    public ScheduleData.Dates.ScheduleDates createScheduleDataDatesScheduleDates() {
        return new ScheduleData.Dates.ScheduleDates();
    }

    /**
     * Create an instance of {@link BaselTrafficLightConfig.Configuration.ObservationThresholds }
     * 
     */
    public BaselTrafficLightConfig.Configuration.ObservationThresholds createBaselTrafficLightConfigConfigurationObservationThresholds() {
        return new BaselTrafficLightConfig.Configuration.ObservationThresholds();
    }

    /**
     * Create an instance of {@link DigitalCMSLegData.CMSLegData }
     * 
     */
    public DigitalCMSLegData.CMSLegData createDigitalCMSLegDataCMSLegData() {
        return new DigitalCMSLegData.CMSLegData();
    }

    /**
     * Create an instance of {@link DigitalCMSLegData.CallStrikes }
     * 
     */
    public DigitalCMSLegData.CallStrikes createDigitalCMSLegDataCallStrikes() {
        return new DigitalCMSLegData.CallStrikes();
    }

    /**
     * Create an instance of {@link DigitalCMSLegData.CallPayoffs }
     * 
     */
    public DigitalCMSLegData.CallPayoffs createDigitalCMSLegDataCallPayoffs() {
        return new DigitalCMSLegData.CallPayoffs();
    }

    /**
     * Create an instance of {@link DigitalCMSLegData.PutStrikes }
     * 
     */
    public DigitalCMSLegData.PutStrikes createDigitalCMSLegDataPutStrikes() {
        return new DigitalCMSLegData.PutStrikes();
    }

    /**
     * Create an instance of {@link DigitalCMSLegData.PutPayoffs }
     * 
     */
    public DigitalCMSLegData.PutPayoffs createDigitalCMSLegDataPutPayoffs() {
        return new DigitalCMSLegData.PutPayoffs();
    }

    /**
     * Create an instance of {@link CommodityFloatingLegData.PricingDates }
     * 
     */
    public CommodityFloatingLegData.PricingDates createCommodityFloatingLegDataPricingDates() {
        return new CommodityFloatingLegData.PricingDates();
    }

    /**
     * Create an instance of {@link CashflowData.Cashflow.Amount }
     * 
     */
    public CashflowData.Cashflow.Amount createCashflowDataCashflowAmount() {
        return new CashflowData.Cashflow.Amount();
    }

    /**
     * Create an instance of {@link DigitalCMSSpreadLegData.CMSSpreadLegData }
     * 
     */
    public DigitalCMSSpreadLegData.CMSSpreadLegData createDigitalCMSSpreadLegDataCMSSpreadLegData() {
        return new DigitalCMSSpreadLegData.CMSSpreadLegData();
    }

    /**
     * Create an instance of {@link DigitalCMSSpreadLegData.CallStrikes }
     * 
     */
    public DigitalCMSSpreadLegData.CallStrikes createDigitalCMSSpreadLegDataCallStrikes() {
        return new DigitalCMSSpreadLegData.CallStrikes();
    }

    /**
     * Create an instance of {@link DigitalCMSSpreadLegData.CallPayoffs }
     * 
     */
    public DigitalCMSSpreadLegData.CallPayoffs createDigitalCMSSpreadLegDataCallPayoffs() {
        return new DigitalCMSSpreadLegData.CallPayoffs();
    }

    /**
     * Create an instance of {@link DigitalCMSSpreadLegData.PutStrikes }
     * 
     */
    public DigitalCMSSpreadLegData.PutStrikes createDigitalCMSSpreadLegDataPutStrikes() {
        return new DigitalCMSSpreadLegData.PutStrikes();
    }

    /**
     * Create an instance of {@link DigitalCMSSpreadLegData.PutPayoffs }
     * 
     */
    public DigitalCMSSpreadLegData.PutPayoffs createDigitalCMSSpreadLegDataPutPayoffs() {
        return new DigitalCMSSpreadLegData.PutPayoffs();
    }

    /**
     * Create an instance of {@link FixedLegData.Rates.Rate }
     * 
     */
    public FixedLegData.Rates.Rate createFixedLegDataRatesRate() {
        return new FixedLegData.Rates.Rate();
    }

    /**
     * Create an instance of {@link CollateralBalances.CollateralBalance }
     * 
     */
    public CollateralBalances.CollateralBalance createCollateralBalancesCollateralBalance() {
        return new CollateralBalances.CollateralBalance();
    }

    /**
     * Create an instance of {@link CrossAssetModel.Currencies }
     * 
     */
    public CrossAssetModel.Currencies createCrossAssetModelCurrencies() {
        return new CrossAssetModel.Currencies();
    }

    /**
     * Create an instance of {@link CrossAssetModel.Equities }
     * 
     */
    public CrossAssetModel.Equities createCrossAssetModelEquities() {
        return new CrossAssetModel.Equities();
    }

    /**
     * Create an instance of {@link CrossAssetModel.InflationIndices }
     * 
     */
    public CrossAssetModel.InflationIndices createCrossAssetModelInflationIndices() {
        return new CrossAssetModel.InflationIndices();
    }

    /**
     * Create an instance of {@link CrossAssetModel.CreditNames }
     * 
     */
    public CrossAssetModel.CreditNames createCrossAssetModelCreditNames() {
        return new CrossAssetModel.CreditNames();
    }

    /**
     * Create an instance of {@link CrossAssetModel.Commodities }
     * 
     */
    public CrossAssetModel.Commodities createCrossAssetModelCommodities() {
        return new CrossAssetModel.Commodities();
    }

    /**
     * Create an instance of {@link CrossAssetModel.InterestRateModels }
     * 
     */
    public CrossAssetModel.InterestRateModels createCrossAssetModelInterestRateModels() {
        return new CrossAssetModel.InterestRateModels();
    }

    /**
     * Create an instance of {@link CrossAssetModel.ForeignExchangeModels }
     * 
     */
    public CrossAssetModel.ForeignExchangeModels createCrossAssetModelForeignExchangeModels() {
        return new CrossAssetModel.ForeignExchangeModels();
    }

    /**
     * Create an instance of {@link CrossAssetModel.EquityModels }
     * 
     */
    public CrossAssetModel.EquityModels createCrossAssetModelEquityModels() {
        return new CrossAssetModel.EquityModels();
    }

    /**
     * Create an instance of {@link CrossAssetModel.InflationIndexModels }
     * 
     */
    public CrossAssetModel.InflationIndexModels createCrossAssetModelInflationIndexModels() {
        return new CrossAssetModel.InflationIndexModels();
    }

    /**
     * Create an instance of {@link CrossAssetModel.CreditModels }
     * 
     */
    public CrossAssetModel.CreditModels createCrossAssetModelCreditModels() {
        return new CrossAssetModel.CreditModels();
    }

    /**
     * Create an instance of {@link CrossAssetModel.CommodityModels }
     * 
     */
    public CrossAssetModel.CommodityModels createCrossAssetModelCommodityModels() {
        return new CrossAssetModel.CommodityModels();
    }

    /**
     * Create an instance of {@link CrossAssetModel.CreditStates }
     * 
     */
    public CrossAssetModel.CreditStates createCrossAssetModelCreditStates() {
        return new CrossAssetModel.CreditStates();
    }

    /**
     * Create an instance of {@link CrossAssetModel.InstantaneousCorrelations.Correlation }
     * 
     */
    public CrossAssetModel.InstantaneousCorrelations.Correlation createCrossAssetModelInstantaneousCorrelationsCorrelation() {
        return new CrossAssetModel.InstantaneousCorrelations.Correlation();
    }

    /**
     * Create an instance of {@link EquityMarginLegData.EquityLegData.FXTerms }
     * 
     */
    public EquityMarginLegData.EquityLegData.FXTerms createEquityMarginLegDataEquityLegDataFXTerms() {
        return new EquityMarginLegData.EquityLegData.FXTerms();
    }

    /**
     * Create an instance of {@link EquityMarginLegData.Rates.Rate }
     * 
     */
    public EquityMarginLegData.Rates.Rate createEquityMarginLegDataRatesRate() {
        return new EquityMarginLegData.Rates.Rate();
    }

    /**
     * Create an instance of {@link Nettingsetdefinitions.NettingSet.CSADetails.IndependentAmount }
     * 
     */
    public Nettingsetdefinitions.NettingSet.CSADetails.IndependentAmount createNettingsetdefinitionsNettingSetCSADetailsIndependentAmount() {
        return new Nettingsetdefinitions.NettingSet.CSADetails.IndependentAmount();
    }

    /**
     * Create an instance of {@link Nettingsetdefinitions.NettingSet.CSADetails.MarginingFrequency }
     * 
     */
    public Nettingsetdefinitions.NettingSet.CSADetails.MarginingFrequency createNettingsetdefinitionsNettingSetCSADetailsMarginingFrequency() {
        return new Nettingsetdefinitions.NettingSet.CSADetails.MarginingFrequency();
    }

    /**
     * Create an instance of {@link Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals.Currencies }
     * 
     */
    public Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals.Currencies createNettingsetdefinitionsNettingSetCSADetailsEligibleCollateralsCurrencies() {
        return new Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals.Currencies();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.ibk.gcb.batch.trs.mvmn.ore.Conventions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Conventions")
    public JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.Conventions> createConventions(com.ibk.gcb.batch.trs.mvmn.ore.Conventions value) {
        return new JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.Conventions>(_Conventions_QNAME, com.ibk.gcb.batch.trs.mvmn.ore.Conventions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NettingSetId", substitutionHeadNamespace = "", substitutionHeadName = "nettingSetGroup")
    public JAXBElement<String> createNettingSetId(String value) {
        return new JAXBElement<String>(_NettingSetId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DerivedScheduleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Derived", substitutionHeadNamespace = "", substitutionHeadName = "DerivedScheduleGroup")
    public JAXBElement<DerivedScheduleType> createDerived(DerivedScheduleType value) {
        return new JAXBElement<DerivedScheduleType>(_Derived_QNAME, DerivedScheduleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ReferenceInformation", substitutionHeadNamespace = "", substitutionHeadName = "creditCurveIdType")
    public JAXBElement<ReferenceInformation> createReferenceInformation(ReferenceInformation value) {
        return new JAXBElement<ReferenceInformation>(_ReferenceInformation_QNAME, ReferenceInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YYLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "YYLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<YYLegData> createYYLegData(YYLegData value) {
        return new JAXBElement<YYLegData>(_YYLegData_QNAME, YYLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Nettingsetdefinitions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NettingSetDefinitions")
    public JAXBElement<Nettingsetdefinitions> createNettingSetDefinitions(Nettingsetdefinitions value) {
        return new JAXBElement<Nettingsetdefinitions>(_NettingSetDefinitions_QNAME, Nettingsetdefinitions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Name", substitutionHeadNamespace = "", substitutionHeadName = "underlyingTypes")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Todaysmarket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TodaysMarket")
    public JAXBElement<Todaysmarket> createTodaysMarket(Todaysmarket value) {
        return new JAXBElement<Todaysmarket>(_TodaysMarket_QNAME, Todaysmarket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.ibk.gcb.batch.trs.mvmn.ore.Trade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Trade", substitutionHeadNamespace = "", substitutionHeadName = "subTradeGroup")
    public JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.Trade> createTrade(com.ibk.gcb.batch.trs.mvmn.ore.Trade value) {
        return new JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.Trade>(_Trade_QNAME, com.ibk.gcb.batch.trs.mvmn.ore.Trade.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EquityMarginLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EquityMarginLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<EquityMarginLegData> createEquityMarginLegData(EquityMarginLegData value) {
        return new JAXBElement<EquityMarginLegData>(_EquityMarginLegData_QNAME, EquityMarginLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrossAssetModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CrossAssetModel")
    public JAXBElement<CrossAssetModel> createCrossAssetModel(CrossAssetModel value) {
        return new JAXBElement<CrossAssetModel>(_CrossAssetModel_QNAME, CrossAssetModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CollateralBalances }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CollateralBalances")
    public JAXBElement<CollateralBalances> createCollateralBalances(CollateralBalances value) {
        return new JAXBElement<CollateralBalances>(_CollateralBalances_QNAME, CollateralBalances.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyDefinition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Currency")
    public JAXBElement<CurrencyDefinition> createCurrency(CurrencyDefinition value) {
        return new JAXBElement<CurrencyDefinition>(_Currency_QNAME, CurrencyDefinition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nettingSetGroup")
    public JAXBElement<Object> createNettingSetGroup(Object value) {
        return new JAXBElement<Object>(_NettingSetGroup_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LevelData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LevelData", substitutionHeadNamespace = "", substitutionHeadName = "levelGroup")
    public JAXBElement<LevelData> createLevelData(LevelData value) {
        return new JAXBElement<LevelData>(_LevelData_QNAME, LevelData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyConfig }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CurrencyConfig")
    public JAXBElement<CurrencyConfig> createCurrencyConfig(CurrencyConfig value) {
        return new JAXBElement<CurrencyConfig>(_CurrencyConfig_QNAME, CurrencyConfig.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.ibk.gcb.batch.trs.mvmn.ore.CMSLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CMSLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.CMSLegData> createCMSLegData(com.ibk.gcb.batch.trs.mvmn.ore.CMSLegData value) {
        return new JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.CMSLegData>(_CMSLegData_QNAME, com.ibk.gcb.batch.trs.mvmn.ore.CMSLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FixedLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FixedLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<FixedLegData> createFixedLegData(FixedLegData value) {
        return new JAXBElement<FixedLegData>(_FixedLegData_QNAME, FixedLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DigitalCMSSpreadLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<DigitalCMSSpreadLegData> createDigitalCMSSpreadLegData(DigitalCMSSpreadLegData value) {
        return new JAXBElement<DigitalCMSSpreadLegData>(_DigitalCMSSpreadLegData_QNAME, DigitalCMSSpreadLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Calendaradjustment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CalendarAdjustments")
    public JAXBElement<Calendaradjustment> createCalendarAdjustments(Calendaradjustment value) {
        return new JAXBElement<Calendaradjustment>(_CalendarAdjustments_QNAME, Calendaradjustment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CashflowData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CashflowData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<CashflowData> createCashflowData(CashflowData value) {
        return new JAXBElement<CashflowData>(_CashflowData_QNAME, CashflowData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Underlyings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Underlyings", substitutionHeadNamespace = "", substitutionHeadName = "underlyingTypes")
    public JAXBElement<Underlyings> createUnderlyings(Underlyings value) {
        return new JAXBElement<Underlyings>(_Underlyings_QNAME, Underlyings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.ibk.gcb.batch.trs.mvmn.ore.Underlying }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Underlying", substitutionHeadNamespace = "", substitutionHeadName = "underlyingTypes")
    public JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.Underlying> createUnderlying(com.ibk.gcb.batch.trs.mvmn.ore.Underlying value) {
        return new JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.Underlying>(_Underlying_QNAME, com.ibk.gcb.batch.trs.mvmn.ore.Underlying.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Level", substitutionHeadNamespace = "", substitutionHeadName = "levelGroup")
    public JAXBElement<Float> createLevel(Float value) {
        return new JAXBElement<Float>(_Level_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Stresstesting }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "StressTesting")
    public JAXBElement<Stresstesting> createStressTesting(Stresstesting value) {
        return new JAXBElement<Stresstesting>(_StressTesting_QNAME, Stresstesting.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FloatingLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FloatingLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<FloatingLegData> createFloatingLegData(FloatingLegData value) {
        return new JAXBElement<FloatingLegData>(_FloatingLegData_QNAME, FloatingLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DerivedScheduleGroup")
    public JAXBElement<Object> createDerivedScheduleGroup(Object value) {
        return new JAXBElement<Object>(_DerivedScheduleGroup_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "subTradeGroup")
    public JAXBElement<Object> createSubTradeGroup(Object value) {
        return new JAXBElement<Object>(_SubTradeGroup_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CreditCurveId", substitutionHeadNamespace = "", substitutionHeadName = "creditCurveIdType")
    public JAXBElement<String> createCreditCurveId(String value) {
        return new JAXBElement<String>(_CreditCurveId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommodityFloatingLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CommodityFloatingLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<CommodityFloatingLegData> createCommodityFloatingLegData(CommodityFloatingLegData value) {
        return new JAXBElement<CommodityFloatingLegData>(_CommodityFloatingLegData_QNAME, CommodityFloatingLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ore }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ORE")
    public JAXBElement<Ore> createORE(Ore value) {
        return new JAXBElement<Ore>(_ORE_QNAME, Ore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.ibk.gcb.batch.trs.mvmn.ore.CMSSpreadLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CMSSpreadLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.CMSSpreadLegData> createCMSSpreadLegData(com.ibk.gcb.batch.trs.mvmn.ore.CMSSpreadLegData value) {
        return new JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.CMSSpreadLegData>(_CMSSpreadLegData_QNAME, com.ibk.gcb.batch.trs.mvmn.ore.CMSSpreadLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "legDataType")
    public JAXBElement<Object> createLegDataType(Object value) {
        return new JAXBElement<Object>(_LegDataType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DigitalCMSLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<DigitalCMSLegData> createDigitalCMSLegData(DigitalCMSLegData value) {
        return new JAXBElement<DigitalCMSLegData>(_DigitalCMSLegData_QNAME, DigitalCMSLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StrikeData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "StrikeData", substitutionHeadNamespace = "", substitutionHeadName = "strikeGroup")
    public JAXBElement<StrikeData> createStrikeData(StrikeData value) {
        return new JAXBElement<StrikeData>(_StrikeData_QNAME, StrikeData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "exerciseDatesGroup")
    public JAXBElement<Object> createExerciseDatesGroup(Object value) {
        return new JAXBElement<Object>(_ExerciseDatesGroup_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Curveconfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CurveConfiguration")
    public JAXBElement<Curveconfiguration> createCurveConfiguration(Curveconfiguration value) {
        return new JAXBElement<Curveconfiguration>(_CurveConfiguration_QNAME, Curveconfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommodityFixedLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CommodityFixedLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<CommodityFixedLegData> createCommodityFixedLegData(CommodityFixedLegData value) {
        return new JAXBElement<CommodityFixedLegData>(_CommodityFixedLegData_QNAME, CommodityFixedLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CounterpartyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CounterpartyInformation")
    public JAXBElement<CounterpartyInformation> createCounterpartyInformation(CounterpartyInformation value) {
        return new JAXBElement<CounterpartyInformation>(_CounterpartyInformation_QNAME, CounterpartyInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "creditCurveIdType")
    public JAXBElement<Object> createCreditCurveIdType(Object value) {
        return new JAXBElement<Object>(_CreditCurveIdType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pricingengines }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PricingEngines")
    public JAXBElement<Pricingengines> createPricingEngines(Pricingengines value) {
        return new JAXBElement<Pricingengines>(_PricingEngines_QNAME, Pricingengines.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sensitivityanalysis }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SensitivityAnalysis")
    public JAXBElement<Sensitivityanalysis> createSensitivityAnalysis(Sensitivityanalysis value) {
        return new JAXBElement<Sensitivityanalysis>(_SensitivityAnalysis_QNAME, Sensitivityanalysis.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "levelGroup")
    public JAXBElement<Object> createLevelGroup(Object value) {
        return new JAXBElement<Object>(_LevelGroup_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Creditsimulation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CreditSimulation")
    public JAXBElement<Creditsimulation> createCreditSimulation(Creditsimulation value) {
        return new JAXBElement<Creditsimulation>(_CreditSimulation_QNAME, Creditsimulation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExerciseDates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ExerciseDates", substitutionHeadNamespace = "", substitutionHeadName = "exerciseDatesGroup")
    public JAXBElement<ExerciseDates> createExerciseDates(ExerciseDates value) {
        return new JAXBElement<ExerciseDates>(_ExerciseDates_QNAME, ExerciseDates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "strikeGroup")
    public JAXBElement<Object> createStrikeGroup(Object value) {
        return new JAXBElement<Object>(_StrikeGroup_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Portfolio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Portfolio")
    public JAXBElement<Portfolio> createPortfolio(Portfolio value) {
        return new JAXBElement<Portfolio>(_Portfolio_QNAME, Portfolio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Strike", substitutionHeadNamespace = "", substitutionHeadName = "strikeGroup")
    public JAXBElement<String> createStrike(String value) {
        return new JAXBElement<String>(_Strike_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DerivedScheduleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DerivedSchedule", substitutionHeadNamespace = "", substitutionHeadName = "DerivedScheduleGroup")
    public JAXBElement<DerivedScheduleType> createDerivedSchedule(DerivedScheduleType value) {
        return new JAXBElement<DerivedScheduleType>(_DerivedSchedule_QNAME, DerivedScheduleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScheduleData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ExerciseSchedule", substitutionHeadNamespace = "", substitutionHeadName = "exerciseDatesGroup")
    public JAXBElement<ScheduleData> createExerciseSchedule(ScheduleData value) {
        return new JAXBElement<ScheduleData>(_ExerciseSchedule_QNAME, ScheduleData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubTrade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SubTrade", substitutionHeadNamespace = "", substitutionHeadName = "subTradeGroup")
    public JAXBElement<SubTrade> createSubTrade(SubTrade value) {
        return new JAXBElement<SubTrade>(_SubTrade_QNAME, SubTrade.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NettingSetDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NettingSetDetails", substitutionHeadNamespace = "", substitutionHeadName = "nettingSetGroup")
    public JAXBElement<NettingSetDetails> createNettingSetDetails(NettingSetDetails value) {
        return new JAXBElement<NettingSetDetails>(_NettingSetDetails_QNAME, NettingSetDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CPILegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CPILegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<CPILegData> createCPILegData(CPILegData value) {
        return new JAXBElement<CPILegData>(_CPILegData_QNAME, CPILegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Simulation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Simulation")
    public JAXBElement<Simulation> createSimulation(Simulation value) {
        return new JAXBElement<Simulation>(_Simulation_QNAME, Simulation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "underlyingTypes")
    public JAXBElement<Object> createUnderlyingTypes(Object value) {
        return new JAXBElement<Object>(_UnderlyingTypes_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZeroCouponFixedLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ZeroCouponFixedLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<ZeroCouponFixedLegData> createZeroCouponFixedLegData(ZeroCouponFixedLegData value) {
        return new JAXBElement<ZeroCouponFixedLegData>(_ZeroCouponFixedLegData_QNAME, ZeroCouponFixedLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FormulaBasedLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FormulaBasedLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<FormulaBasedLegData> createFormulaBasedLegData(FormulaBasedLegData value) {
        return new JAXBElement<FormulaBasedLegData>(_FormulaBasedLegData_QNAME, FormulaBasedLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CMBLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CMBLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<CMBLegData> createCMBLegData(CMBLegData value) {
        return new JAXBElement<CMBLegData>(_CMBLegData_QNAME, CMBLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.ibk.gcb.batch.trs.mvmn.ore.EquityLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EquityLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.EquityLegData> createEquityLegData(com.ibk.gcb.batch.trs.mvmn.ore.EquityLegData value) {
        return new JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.EquityLegData>(_EquityLegData_QNAME, com.ibk.gcb.batch.trs.mvmn.ore.EquityLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DurationAdjustedCMSLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DurationAdjustedCMSLegData", substitutionHeadNamespace = "", substitutionHeadName = "legDataType")
    public JAXBElement<DurationAdjustedCMSLegData> createDurationAdjustedCMSLegData(DurationAdjustedCMSLegData value) {
        return new JAXBElement<DurationAdjustedCMSLegData>(_DurationAdjustedCMSLegData_QNAME, DurationAdjustedCMSLegData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OptionData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OptionData", scope = SwaptionData.class)
    public JAXBElement<OptionData> createSwaptionDataOptionData(OptionData value) {
        return new JAXBElement<OptionData>(_SwaptionDataOptionData_QNAME, OptionData.class, SwaptionData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LegData", scope = SwaptionData.class)
    public JAXBElement<LegData> createSwaptionDataLegData(LegData value) {
        return new JAXBElement<LegData>(_SwaptionDataLegData_QNAME, LegData.class, SwaptionData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommodityInterpolationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "InterpolationMethod", scope = SimCommodityCurve.class)
    public JAXBElement<CommodityInterpolationType> createSimCommodityCurveInterpolationMethod(CommodityInterpolationType value) {
        return new JAXBElement<CommodityInterpolationType>(_SimCommodityCurveInterpolationMethod_QNAME, CommodityInterpolationType.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Conventions", scope = SimCommodityCurve.class)
    public JAXBElement<String> createSimCommodityCurveConventions(String value) {
        return new JAXBElement<String>(_Conventions_QNAME, String.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PriceSegmentsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PriceSegments", scope = SimCommodityCurve.class)
    public JAXBElement<PriceSegmentsType> createSimCommodityCurvePriceSegments(PriceSegmentsType value) {
        return new JAXBElement<PriceSegmentsType>(_SimCommodityCurvePriceSegments_QNAME, PriceSegmentsType.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BootstrapConfigType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BootstrapConfig", scope = SimCommodityCurve.class)
    public JAXBElement<BootstrapConfigType> createSimCommodityCurveBootstrapConfig(BootstrapConfigType value) {
        return new JAXBElement<BootstrapConfigType>(_SimCommodityCurveBootstrapConfig_QNAME, BootstrapConfigType.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuoteType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Quotes", scope = SimCommodityCurve.class)
    public JAXBElement<QuoteType> createSimCommodityCurveQuotes(QuoteType value) {
        return new JAXBElement<QuoteType>(_SimCommodityCurveQuotes_QNAME, QuoteType.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommodityBasisConfig }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BasisConfiguration", scope = SimCommodityCurve.class)
    public JAXBElement<CommodityBasisConfig> createSimCommodityCurveBasisConfiguration(CommodityBasisConfig value) {
        return new JAXBElement<CommodityBasisConfig>(_SimCommodityCurveBasisConfiguration_QNAME, CommodityBasisConfig.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BaseYieldCurve", scope = SimCommodityCurve.class)
    public JAXBElement<String> createSimCommodityCurveBaseYieldCurve(String value) {
        return new JAXBElement<String>(_SimCommodityCurveBaseYieldCurve_QNAME, String.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CurveId", scope = SimCommodityCurve.class)
    public JAXBElement<String> createSimCommodityCurveCurveId(String value) {
        return new JAXBElement<String>(_SimCommodityCurveCurveId_QNAME, String.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DayCounter", scope = SimCommodityCurve.class)
    public JAXBElement<String> createSimCommodityCurveDayCounter(String value) {
        return new JAXBElement<String>(_SimCommodityCurveDayCounter_QNAME, String.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Extrapolation", scope = SimCommodityCurve.class)
    public JAXBElement<String> createSimCommodityCurveExtrapolation(String value) {
        return new JAXBElement<String>(_SimCommodityCurveExtrapolation_QNAME, String.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Currency", scope = SimCommodityCurve.class)
    public JAXBElement<CurrencyCode> createSimCommodityCurveCurrency(CurrencyCode value) {
        return new JAXBElement<CurrencyCode>(_Currency_QNAME, CurrencyCode.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BasePriceCurve", scope = SimCommodityCurve.class)
    public JAXBElement<String> createSimCommodityCurveBasePriceCurve(String value) {
        return new JAXBElement<String>(_SimCommodityCurveBasePriceCurve_QNAME, String.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CurveDescription", scope = SimCommodityCurve.class)
    public JAXBElement<String> createSimCommodityCurveCurveDescription(String value) {
        return new JAXBElement<String>(_SimCommodityCurveCurveDescription_QNAME, String.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "YieldCurve", scope = SimCommodityCurve.class)
    public JAXBElement<String> createSimCommodityCurveYieldCurve(String value) {
        return new JAXBElement<String>(_SimCommodityCurveYieldCurve_QNAME, String.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SpotQuote", scope = SimCommodityCurve.class)
    public JAXBElement<String> createSimCommodityCurveSpotQuote(String value) {
        return new JAXBElement<String>(_SimCommodityCurveSpotQuote_QNAME, String.class, SimCommodityCurve.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FinalFlowCap", scope = CPILegData.class)
    public JAXBElement<Float> createCPILegDataFinalFlowCap(Float value) {
        return new JAXBElement<Float>(_CPILegDataFinalFlowCap_QNAME, Float.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CPILegData.Rates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Rates", scope = CPILegData.class)
    public JAXBElement<CPILegData.Rates> createCPILegDataRates(CPILegData.Rates value) {
        return new JAXBElement<CPILegData.Rates>(_CPILegDataRates_QNAME, CPILegData.Rates.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SubtractInflationNotionalAllCoupons", scope = CPILegData.class)
    public JAXBElement<Boolean> createCPILegDataSubtractInflationNotionalAllCoupons(Boolean value) {
        return new JAXBElement<Boolean>(_CPILegDataSubtractInflationNotionalAllCoupons_QNAME, Boolean.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ObservationLag", scope = CPILegData.class)
    public JAXBElement<String> createCPILegDataObservationLag(String value) {
        return new JAXBElement<String>(_CPILegDataObservationLag_QNAME, String.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Index", scope = CPILegData.class)
    public JAXBElement<String> createCPILegDataIndex(String value) {
        return new JAXBElement<String>(_CPILegDataIndex_QNAME, String.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FinalFlowFloor", scope = CPILegData.class)
    public JAXBElement<Float> createCPILegDataFinalFlowFloor(Float value) {
        return new JAXBElement<Float>(_CPILegDataFinalFlowFloor_QNAME, Float.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BaseCPI", scope = CPILegData.class)
    public JAXBElement<Float> createCPILegDataBaseCPI(Float value) {
        return new JAXBElement<Float>(_CPILegDataBaseCPI_QNAME, Float.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "StartDate", scope = CPILegData.class)
    public JAXBElement<String> createCPILegDataStartDate(String value) {
        return new JAXBElement<String>(_CPILegDataStartDate_QNAME, String.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Interpolation", scope = CPILegData.class)
    public JAXBElement<String> createCPILegDataInterpolation(String value) {
        return new JAXBElement<String>(_CPILegDataInterpolation_QNAME, String.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SubtractInflationNotional", scope = CPILegData.class)
    public JAXBElement<String> createCPILegDataSubtractInflationNotional(String value) {
        return new JAXBElement<String>(_CPILegDataSubtractInflationNotional_QNAME, String.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Interpolated", scope = CPILegData.class)
    public JAXBElement<String> createCPILegDataInterpolated(String value) {
        return new JAXBElement<String>(_CPILegDataInterpolated_QNAME, String.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.ibk.gcb.batch.trs.mvmn.ore.Caps }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Caps", scope = CPILegData.class)
    public JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.Caps> createCPILegDataCaps(com.ibk.gcb.batch.trs.mvmn.ore.Caps value) {
        return new JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.Caps>(_CPILegDataCaps_QNAME, com.ibk.gcb.batch.trs.mvmn.ore.Caps.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.ibk.gcb.batch.trs.mvmn.ore.Floors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Floors", scope = CPILegData.class)
    public JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.Floors> createCPILegDataFloors(com.ibk.gcb.batch.trs.mvmn.ore.Floors value) {
        return new JAXBElement<com.ibk.gcb.batch.trs.mvmn.ore.Floors>(_CPILegDataFloors_QNAME, com.ibk.gcb.batch.trs.mvmn.ore.Floors.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NakedOption", scope = CPILegData.class)
    public JAXBElement<Boolean> createCPILegDataNakedOption(Boolean value) {
        return new JAXBElement<Boolean>(_CPILegDataNakedOption_QNAME, Boolean.class, CPILegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScheduleData.Dates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Dates", scope = ScheduleData.class)
    public JAXBElement<ScheduleData.Dates> createScheduleDataDates(ScheduleData.Dates value) {
        return new JAXBElement<ScheduleData.Dates>(_ScheduleDataDates_QNAME, ScheduleData.Dates.class, ScheduleData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScheduleData.Rules }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Rules", scope = ScheduleData.class)
    public JAXBElement<ScheduleData.Rules> createScheduleDataRules(ScheduleData.Rules value) {
        return new JAXBElement<ScheduleData.Rules>(_ScheduleDataRules_QNAME, ScheduleData.Rules.class, ScheduleData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData.PutStrikes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PutStrikes", scope = DigitalCMSSpreadLegData.class)
    public JAXBElement<DigitalCMSSpreadLegData.PutStrikes> createDigitalCMSSpreadLegDataPutStrikes(DigitalCMSSpreadLegData.PutStrikes value) {
        return new JAXBElement<DigitalCMSSpreadLegData.PutStrikes>(_DigitalCMSSpreadLegDataPutStrikes_QNAME, DigitalCMSSpreadLegData.PutStrikes.class, DigitalCMSSpreadLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IsPutATMIncluded", scope = DigitalCMSSpreadLegData.class)
    public JAXBElement<Boolean> createDigitalCMSSpreadLegDataIsPutATMIncluded(Boolean value) {
        return new JAXBElement<Boolean>(_DigitalCMSSpreadLegDataIsPutATMIncluded_QNAME, Boolean.class, DigitalCMSSpreadLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData.PutPayoffs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PutPayoffs", scope = DigitalCMSSpreadLegData.class)
    public JAXBElement<DigitalCMSSpreadLegData.PutPayoffs> createDigitalCMSSpreadLegDataPutPayoffs(DigitalCMSSpreadLegData.PutPayoffs value) {
        return new JAXBElement<DigitalCMSSpreadLegData.PutPayoffs>(_DigitalCMSSpreadLegDataPutPayoffs_QNAME, DigitalCMSSpreadLegData.PutPayoffs.class, DigitalCMSSpreadLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData.CMSSpreadLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CMSSpreadLegData", scope = DigitalCMSSpreadLegData.class)
    public JAXBElement<DigitalCMSSpreadLegData.CMSSpreadLegData> createDigitalCMSSpreadLegDataCMSSpreadLegData(DigitalCMSSpreadLegData.CMSSpreadLegData value) {
        return new JAXBElement<DigitalCMSSpreadLegData.CMSSpreadLegData>(_CMSSpreadLegData_QNAME, DigitalCMSSpreadLegData.CMSSpreadLegData.class, DigitalCMSSpreadLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData.CallStrikes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CallStrikes", scope = DigitalCMSSpreadLegData.class)
    public JAXBElement<DigitalCMSSpreadLegData.CallStrikes> createDigitalCMSSpreadLegDataCallStrikes(DigitalCMSSpreadLegData.CallStrikes value) {
        return new JAXBElement<DigitalCMSSpreadLegData.CallStrikes>(_DigitalCMSSpreadLegDataCallStrikes_QNAME, DigitalCMSSpreadLegData.CallStrikes.class, DigitalCMSSpreadLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CallPosition", scope = DigitalCMSSpreadLegData.class)
    public JAXBElement<String> createDigitalCMSSpreadLegDataCallPosition(String value) {
        return new JAXBElement<String>(_DigitalCMSSpreadLegDataCallPosition_QNAME, String.class, DigitalCMSSpreadLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData.CallPayoffs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CallPayoffs", scope = DigitalCMSSpreadLegData.class)
    public JAXBElement<DigitalCMSSpreadLegData.CallPayoffs> createDigitalCMSSpreadLegDataCallPayoffs(DigitalCMSSpreadLegData.CallPayoffs value) {
        return new JAXBElement<DigitalCMSSpreadLegData.CallPayoffs>(_DigitalCMSSpreadLegDataCallPayoffs_QNAME, DigitalCMSSpreadLegData.CallPayoffs.class, DigitalCMSSpreadLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IsCallATMIncluded", scope = DigitalCMSSpreadLegData.class)
    public JAXBElement<Boolean> createDigitalCMSSpreadLegDataIsCallATMIncluded(Boolean value) {
        return new JAXBElement<Boolean>(_DigitalCMSSpreadLegDataIsCallATMIncluded_QNAME, Boolean.class, DigitalCMSSpreadLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PutPosition", scope = DigitalCMSSpreadLegData.class)
    public JAXBElement<String> createDigitalCMSSpreadLegDataPutPosition(String value) {
        return new JAXBElement<String>(_DigitalCMSSpreadLegDataPutPosition_QNAME, String.class, DigitalCMSSpreadLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OptionData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OptionData", scope = CallableSwapData.class)
    public JAXBElement<OptionData> createCallableSwapDataOptionData(OptionData value) {
        return new JAXBElement<OptionData>(_SwaptionDataOptionData_QNAME, OptionData.class, CallableSwapData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LegData", scope = CallableSwapData.class)
    public JAXBElement<LegData> createCallableSwapDataLegData(LegData value) {
        return new JAXBElement<LegData>(_SwaptionDataLegData_QNAME, LegData.class, CallableSwapData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSLegData.CMSLegData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CMSLegData", scope = DigitalCMSLegData.class)
    public JAXBElement<DigitalCMSLegData.CMSLegData> createDigitalCMSLegDataCMSLegData(DigitalCMSLegData.CMSLegData value) {
        return new JAXBElement<DigitalCMSLegData.CMSLegData>(_CMSLegData_QNAME, DigitalCMSLegData.CMSLegData.class, DigitalCMSLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSLegData.PutStrikes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PutStrikes", scope = DigitalCMSLegData.class)
    public JAXBElement<DigitalCMSLegData.PutStrikes> createDigitalCMSLegDataPutStrikes(DigitalCMSLegData.PutStrikes value) {
        return new JAXBElement<DigitalCMSLegData.PutStrikes>(_DigitalCMSSpreadLegDataPutStrikes_QNAME, DigitalCMSLegData.PutStrikes.class, DigitalCMSLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IsPutATMIncluded", scope = DigitalCMSLegData.class)
    public JAXBElement<Boolean> createDigitalCMSLegDataIsPutATMIncluded(Boolean value) {
        return new JAXBElement<Boolean>(_DigitalCMSSpreadLegDataIsPutATMIncluded_QNAME, Boolean.class, DigitalCMSLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSLegData.PutPayoffs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PutPayoffs", scope = DigitalCMSLegData.class)
    public JAXBElement<DigitalCMSLegData.PutPayoffs> createDigitalCMSLegDataPutPayoffs(DigitalCMSLegData.PutPayoffs value) {
        return new JAXBElement<DigitalCMSLegData.PutPayoffs>(_DigitalCMSSpreadLegDataPutPayoffs_QNAME, DigitalCMSLegData.PutPayoffs.class, DigitalCMSLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSLegData.CallStrikes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CallStrikes", scope = DigitalCMSLegData.class)
    public JAXBElement<DigitalCMSLegData.CallStrikes> createDigitalCMSLegDataCallStrikes(DigitalCMSLegData.CallStrikes value) {
        return new JAXBElement<DigitalCMSLegData.CallStrikes>(_DigitalCMSSpreadLegDataCallStrikes_QNAME, DigitalCMSLegData.CallStrikes.class, DigitalCMSLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CallPosition", scope = DigitalCMSLegData.class)
    public JAXBElement<String> createDigitalCMSLegDataCallPosition(String value) {
        return new JAXBElement<String>(_DigitalCMSSpreadLegDataCallPosition_QNAME, String.class, DigitalCMSLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCMSLegData.CallPayoffs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CallPayoffs", scope = DigitalCMSLegData.class)
    public JAXBElement<DigitalCMSLegData.CallPayoffs> createDigitalCMSLegDataCallPayoffs(DigitalCMSLegData.CallPayoffs value) {
        return new JAXBElement<DigitalCMSLegData.CallPayoffs>(_DigitalCMSSpreadLegDataCallPayoffs_QNAME, DigitalCMSLegData.CallPayoffs.class, DigitalCMSLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IsCallATMIncluded", scope = DigitalCMSLegData.class)
    public JAXBElement<Boolean> createDigitalCMSLegDataIsCallATMIncluded(Boolean value) {
        return new JAXBElement<Boolean>(_DigitalCMSSpreadLegDataIsCallATMIncluded_QNAME, Boolean.class, DigitalCMSLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PutPosition", scope = DigitalCMSLegData.class)
    public JAXBElement<String> createDigitalCMSLegDataPutPosition(String value) {
        return new JAXBElement<String>(_DigitalCMSSpreadLegDataPutPosition_QNAME, String.class, DigitalCMSLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrsUnderlyingData.PortfolioIndexTradeData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PortfolioIndexTradeData", scope = TrsUnderlyingData.class)
    public JAXBElement<TrsUnderlyingData.PortfolioIndexTradeData> createTrsUnderlyingDataPortfolioIndexTradeData(TrsUnderlyingData.PortfolioIndexTradeData value) {
        return new JAXBElement<TrsUnderlyingData.PortfolioIndexTradeData>(_TrsUnderlyingDataPortfolioIndexTradeData_QNAME, TrsUnderlyingData.PortfolioIndexTradeData.class, TrsUnderlyingData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrsUnderlyingData.Derivative }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Derivative", scope = TrsUnderlyingData.class)
    public JAXBElement<TrsUnderlyingData.Derivative> createTrsUnderlyingDataDerivative(TrsUnderlyingData.Derivative value) {
        return new JAXBElement<TrsUnderlyingData.Derivative>(_TrsUnderlyingDataDerivative_QNAME, TrsUnderlyingData.Derivative.class, TrsUnderlyingData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZeroCouponFixedLegData.Rates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Rates", scope = ZeroCouponFixedLegData.class)
    public JAXBElement<ZeroCouponFixedLegData.Rates> createZeroCouponFixedLegDataRates(ZeroCouponFixedLegData.Rates value) {
        return new JAXBElement<ZeroCouponFixedLegData.Rates>(_CPILegDataRates_QNAME, ZeroCouponFixedLegData.Rates.class, ZeroCouponFixedLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Compounding", scope = ZeroCouponFixedLegData.class)
    public JAXBElement<String> createZeroCouponFixedLegDataCompounding(String value) {
        return new JAXBElement<String>(_ZeroCouponFixedLegDataCompounding_QNAME, String.class, ZeroCouponFixedLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SubtractNotional", scope = ZeroCouponFixedLegData.class)
    public JAXBElement<String> createZeroCouponFixedLegDataSubtractNotional(String value) {
        return new JAXBElement<String>(_ZeroCouponFixedLegDataSubtractNotional_QNAME, String.class, ZeroCouponFixedLegData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NonExemptIMRegulations", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<String> createNettingsetdefinitionsNettingSetCSADetailsNonExemptIMRegulations(String value) {
        return new JAXBElement<String>(_NettingsetdefinitionsNettingSetCSADetailsNonExemptIMRegulations_QNAME, String.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CalculateVMAmount", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<Boolean> createNettingsetdefinitionsNettingSetCSADetailsCalculateVMAmount(Boolean value) {
        return new JAXBElement<Boolean>(_NettingsetdefinitionsNettingSetCSADetailsCalculateVMAmount_QNAME, Boolean.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CalculateIMAmount", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<Boolean> createNettingsetdefinitionsNettingSetCSADetailsCalculateIMAmount(Boolean value) {
        return new JAXBElement<Boolean>(_NettingsetdefinitionsNettingSetCSADetailsCalculateIMAmount_QNAME, Boolean.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CsaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Bilateral", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<CsaType> createNettingsetdefinitionsNettingSetCSADetailsBilateral(CsaType value) {
        return new JAXBElement<CsaType>(_NettingsetdefinitionsNettingSetCSADetailsBilateral_QNAME, CsaType.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Index", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<String> createNettingsetdefinitionsNettingSetCSADetailsIndex(String value) {
        return new JAXBElement<String>(_CPILegDataIndex_QNAME, String.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ThresholdReceive", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<BigDecimal> createNettingsetdefinitionsNettingSetCSADetailsThresholdReceive(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_NettingsetdefinitionsNettingSetCSADetailsThresholdReceive_QNAME, BigDecimal.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ApplyInitialMargin", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<Boolean> createNettingsetdefinitionsNettingSetCSADetailsApplyInitialMargin(Boolean value) {
        return new JAXBElement<Boolean>(_NettingsetdefinitionsNettingSetCSADetailsApplyInitialMargin_QNAME, Boolean.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MinimumTransferAmountPay", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<BigDecimal> createNettingsetdefinitionsNettingSetCSADetailsMinimumTransferAmountPay(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_NettingsetdefinitionsNettingSetCSADetailsMinimumTransferAmountPay_QNAME, BigDecimal.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CSACurrency", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<CurrencyCode> createNettingsetdefinitionsNettingSetCSADetailsCSACurrency(CurrencyCode value) {
        return new JAXBElement<CurrencyCode>(_NettingsetdefinitionsNettingSetCSADetailsCSACurrency_QNAME, CurrencyCode.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MarginPeriodOfRisk", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<String> createNettingsetdefinitionsNettingSetCSADetailsMarginPeriodOfRisk(String value) {
        return new JAXBElement<String>(_NettingsetdefinitionsNettingSetCSADetailsMarginPeriodOfRisk_QNAME, String.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Nettingsetdefinitions.NettingSet.CSADetails.IndependentAmount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IndependentAmount", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<Nettingsetdefinitions.NettingSet.CSADetails.IndependentAmount> createNettingsetdefinitionsNettingSetCSADetailsIndependentAmount(Nettingsetdefinitions.NettingSet.CSADetails.IndependentAmount value) {
        return new JAXBElement<Nettingsetdefinitions.NettingSet.CSADetails.IndependentAmount>(_NettingsetdefinitionsNettingSetCSADetailsIndependentAmount_QNAME, Nettingsetdefinitions.NettingSet.CSADetails.IndependentAmount.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MinimumTransferAmountReceive", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<BigDecimal> createNettingsetdefinitionsNettingSetCSADetailsMinimumTransferAmountReceive(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_NettingsetdefinitionsNettingSetCSADetailsMinimumTransferAmountReceive_QNAME, BigDecimal.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CsaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "InitialMarginType", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<CsaType> createNettingsetdefinitionsNettingSetCSADetailsInitialMarginType(CsaType value) {
        return new JAXBElement<CsaType>(_NettingsetdefinitionsNettingSetCSADetailsInitialMarginType_QNAME, CsaType.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CollateralCompoundingSpreadPay", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<BigDecimal> createNettingsetdefinitionsNettingSetCSADetailsCollateralCompoundingSpreadPay(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_NettingsetdefinitionsNettingSetCSADetailsCollateralCompoundingSpreadPay_QNAME, BigDecimal.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Nettingsetdefinitions.NettingSet.CSADetails.MarginingFrequency }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MarginingFrequency", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<Nettingsetdefinitions.NettingSet.CSADetails.MarginingFrequency> createNettingsetdefinitionsNettingSetCSADetailsMarginingFrequency(Nettingsetdefinitions.NettingSet.CSADetails.MarginingFrequency value) {
        return new JAXBElement<Nettingsetdefinitions.NettingSet.CSADetails.MarginingFrequency>(_NettingsetdefinitionsNettingSetCSADetailsMarginingFrequency_QNAME, Nettingsetdefinitions.NettingSet.CSADetails.MarginingFrequency.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CollateralCompoundingSpreadReceive", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<BigDecimal> createNettingsetdefinitionsNettingSetCSADetailsCollateralCompoundingSpreadReceive(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_NettingsetdefinitionsNettingSetCSADetailsCollateralCompoundingSpreadReceive_QNAME, BigDecimal.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ThresholdPay", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<BigDecimal> createNettingsetdefinitionsNettingSetCSADetailsThresholdPay(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_NettingsetdefinitionsNettingSetCSADetailsThresholdPay_QNAME, BigDecimal.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EligibleCollaterals", scope = Nettingsetdefinitions.NettingSet.CSADetails.class)
    public JAXBElement<Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals> createNettingsetdefinitionsNettingSetCSADetailsEligibleCollaterals(Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals value) {
        return new JAXBElement<Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals>(_NettingsetdefinitionsNettingSetCSADetailsEligibleCollaterals_QNAME, Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals.class, Nettingsetdefinitions.NettingSet.CSADetails.class, value);
    }

}
