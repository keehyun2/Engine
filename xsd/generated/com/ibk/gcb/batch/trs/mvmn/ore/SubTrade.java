//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>subTrade complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="subTrade">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubTradeType" type="{}oreTradeType"/>
 *         &lt;element name="Envelope" type="{}envelope" minOccurs="0"/>
 *         &lt;element name="TradeActions" type="{}tradeActions" minOccurs="0"/>
 *         &lt;group ref="{}oreTradeData" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subTrade", propOrder = {
    "subTradeType",
    "envelope",
    "tradeActions",
    "crossCurrencySwapData",
    "inflationSwapData",
    "swapData",
    "equitySwapData",
    "callableSwapData",
    "arcOptionData",
    "swaptionData",
    "varianceSwapData",
    "equityVarianceSwapData",
    "fxVarianceSwapData",
    "commodityVarianceSwapData",
    "forwardRateAgreementData",
    "fxForwardData",
    "fxAverageForwardData",
    "fxOptionData",
    "fxBarrierOptionData",
    "fxDoubleBarrierOptionData",
    "fxDigitalOptionData",
    "fxEuropeanBarrierOptionData",
    "fxKIKOBarrierOptionData",
    "fxDigitalBarrierOptionData",
    "fxTouchOptionData",
    "fxDoubleTouchOptionData",
    "fxSwapData",
    "capFloorData",
    "equityFutureOptionData",
    "equityOptionData",
    "equityBarrierOptionData",
    "equityDoubleBarrierOptionData",
    "equityForwardData",
    "equityEuropeanBarrierOptionData",
    "equityDigitalOptionData",
    "equityDoubleTouchOptionData",
    "equityTouchOptionData",
    "equityCliquetOptionData",
    "bondData",
    "forwardBondData",
    "bondFutureData",
    "creditDefaultSwapData",
    "creditDefaultSwapOptionData",
    "commodityForwardData",
    "commodityOptionData",
    "commodityDigitalAveragePriceOptionData",
    "commodityDigitalOptionData",
    "commoditySpreadOptionData",
    "commoditySwapData",
    "commoditySwaptionData",
    "commodityAveragePriceOptionData",
    "commodityOptionStripData",
    "commodityPositionData",
    "equityAsianOptionData",
    "fxAsianOptionData",
    "commodityAsianOptionData",
    "bondOptionData",
    "bondRepoData",
    "bondTRSData",
    "cdoData",
    "creditLinkedSwapData",
    "indexCreditDefaultSwapData",
    "indexCreditDefaultSwapOptionData",
    "multiLegOptionData",
    "ascotData",
    "convertibleBondData",
    "callableBondData",
    "treasuryLockData",
    "riskParticipationAgreementData",
    "cboData",
    "bondBasketData",
    "equityPositionData",
    "equityOptionPositionData",
    "totalReturnSwapData",
    "contractForDifferenceData",
    "compositeTradeData",
    "pairwiseVarianceSwapData",
    "equityPairwiseVarianceSwapData",
    "fxPairwiseVarianceSwapData",
    "equityOutperformanceOptionData",
    "flexiSwapData",
    "balanceGuaranteedSwapData",
    "commodityRevenueOptionData",
    "basketVarianceSwapData",
    "equityBasketVarianceSwapData",
    "fxBasketVarianceSwapData",
    "commodityBasketVarianceSwapData",
    "extendedAccumulatorData",
    "varianceOptionData",
    "varianceDispersionSwapData",
    "kikoVarianceSwapData",
    "corridorVarianceSwapData",
    "indexedCorridorVarianceSwapData",
    "kikoCorridorVarianceSwapData",
    "corridorVarianceDispersionSwapData",
    "koCorridorVarianceDispersionSwapData",
    "pairwiseGeometricVarianceDispersionSwapData",
    "conditionalVarianceSwap01Data",
    "conditionalVarianceSwap02Data",
    "gammaSwapData",
    "bestEntryOptionData",
    "dualEuroBinaryOptionData",
    "dualEuroBinaryOptionDoubleKOData",
    "volatilityBarrierOptionData",
    "fxTaRFData",
    "equityTaRFData",
    "commodityTaRFData",
    "fxAccumulatorData",
    "equityAccumulatorData",
    "commodityAccumulatorData",
    "fxWindowBarrierOptionData",
    "equityWindowBarrierOptionData",
    "commodityWindowBarierOptionData",
    "equityBasketOptionData",
    "fxBasketOptionData",
    "commodityBasketOptionData",
    "fxGenericBarrierOptionData",
    "equityGenericBarrierOptionData",
    "commodityGenericBarrierOptionData",
    "equityRainbowOptionData",
    "fxRainbowOptionData",
    "commodityRainbowOptionData",
    "autocallable01Data",
    "doubleDigitalOptionData",
    "performanceOption01Data",
    "scriptedTradeData",
    "vanillaBasketOptionData",
    "asianBasketOptionData",
    "averageStrikeBasketOptionData",
    "lookbackCallBasketOptionData",
    "lookbackPutBasketOptionData",
    "bestOfAirbagData",
    "worstOfBasketSwapData",
    "fxWorstOfBasketSwapData",
    "equityWorstOfBasketSwapData",
    "commodityWorstOfBasketSwapData",
    "worstPerformanceRainbowOption01Data",
    "worstPerformanceRainbowOption02Data",
    "worstPerformanceRainbowOption03Data",
    "worstPerformanceRainbowOption04Data",
    "worstPerformanceRainbowOption05Data",
    "worstPerformanceRainbowOption06Data",
    "worstPerformanceRainbowOption07Data",
    "bestOfAssetOrCashRainbowOptionData",
    "worstOfAssetOrCashRainbowOptionData",
    "minRainbowOptionData",
    "maxRainbowOptionData",
    "windowBarrierOptionData",
    "accumulator01Data",
    "accumulator02Data",
    "equityBestEntryOptionData",
    "fxBestEntryOptionData",
    "commodityBestEntryOptionData",
    "taRFData",
    "europeanRainbowCallSpreadOptionData",
    "rainbowCallSpreadBarrierOptionData",
    "asianRainbowCallSpreadOptionData",
    "asianIrCapFloorData",
    "forwardVolatilityAgreementData",
    "correlationSwapData",
    "assetLinkedCliquetOptionData",
    "constantMaturityVolatilitySwapData",
    "cmsCapFloorBarrierData",
    "fixedStrikeForwardStartingOptionData",
    "floatingStrikeForwardStartingOptionData",
    "forwardStartingSwaptionData",
    "flooredAverageCPIZCIISData",
    "genericBarrierOptionData",
    "movingMaxYYIISData",
    "irregularYYIISData",
    "europeanOptionBarrierData",
    "ladderLockInOptionData",
    "lapseHedgeSwapData",
    "knockOutSwapData",
    "lpiSwapData",
    "cashPositionData",
    "strikeResettableOptionData",
    "equityStrikeResettableOptionData",
    "fxStrikeResettableOptionData",
    "commodityStrikeResettableOptionData"
})
public class SubTrade {

    @XmlElement(name = "SubTradeType", required = true)
    @XmlSchemaType(name = "string")
    protected OreTradeType subTradeType;
    @XmlElement(name = "Envelope")
    protected Envelope envelope;
    @XmlElement(name = "TradeActions")
    protected TradeActions tradeActions;
    @XmlElement(name = "CrossCurrencySwapData")
    protected SwapData crossCurrencySwapData;
    @XmlElement(name = "InflationSwapData")
    protected SwapData inflationSwapData;
    @XmlElement(name = "SwapData")
    protected SwapData swapData;
    @XmlElement(name = "EquitySwapData")
    protected SwapData equitySwapData;
    @XmlElement(name = "CallableSwapData")
    protected CallableSwapData callableSwapData;
    @XmlElement(name = "ArcOptionData")
    protected ArcOptionData arcOptionData;
    @XmlElement(name = "SwaptionData")
    protected SwaptionData swaptionData;
    @XmlElement(name = "VarianceSwapData")
    protected VarianceSwapData varianceSwapData;
    @XmlElement(name = "EquityVarianceSwapData")
    protected VarianceSwapData equityVarianceSwapData;
    @XmlElement(name = "FxVarianceSwapData")
    protected VarianceSwapData fxVarianceSwapData;
    @XmlElement(name = "CommodityVarianceSwapData")
    protected VarianceSwapData commodityVarianceSwapData;
    @XmlElement(name = "ForwardRateAgreementData")
    protected ForwardRateAgreementData forwardRateAgreementData;
    @XmlElement(name = "FxForwardData")
    protected FxForwardData fxForwardData;
    @XmlElement(name = "FxAverageForwardData")
    protected FxAverageForwardData fxAverageForwardData;
    @XmlElement(name = "FxOptionData")
    protected FxOptionData fxOptionData;
    @XmlElement(name = "FxBarrierOptionData")
    protected FxBarrierOptionData fxBarrierOptionData;
    @XmlElement(name = "FxDoubleBarrierOptionData")
    protected FxBarrierOptionData fxDoubleBarrierOptionData;
    @XmlElement(name = "FxDigitalOptionData")
    protected FxDigitalOptionData fxDigitalOptionData;
    @XmlElement(name = "FxEuropeanBarrierOptionData")
    protected FxBarrierOptionData fxEuropeanBarrierOptionData;
    @XmlElement(name = "FxKIKOBarrierOptionData")
    protected FxKIKOBarrierOptionData fxKIKOBarrierOptionData;
    @XmlElement(name = "FxDigitalBarrierOptionData")
    protected FxDigitalBarrierOptionData fxDigitalBarrierOptionData;
    @XmlElement(name = "FxTouchOptionData")
    protected FxTouchOptionData fxTouchOptionData;
    @XmlElement(name = "FxDoubleTouchOptionData")
    protected FxTouchOptionData fxDoubleTouchOptionData;
    @XmlElement(name = "FxSwapData")
    protected FxSwapData fxSwapData;
    @XmlElement(name = "CapFloorData")
    protected CapFloorData capFloorData;
    @XmlElement(name = "EquityFutureOptionData")
    protected EquityFutureOptionData equityFutureOptionData;
    @XmlElement(name = "EquityOptionData")
    protected EquityOptionData equityOptionData;
    @XmlElement(name = "EquityBarrierOptionData")
    protected EqBarrierOptionData equityBarrierOptionData;
    @XmlElement(name = "EquityDoubleBarrierOptionData")
    protected EqBarrierOptionData equityDoubleBarrierOptionData;
    @XmlElement(name = "EquityForwardData")
    protected EquityForwardData equityForwardData;
    @XmlElement(name = "EquityEuropeanBarrierOptionData")
    protected EqBarrierOptionData equityEuropeanBarrierOptionData;
    @XmlElement(name = "EquityDigitalOptionData")
    protected EqDigitalOptionData equityDigitalOptionData;
    @XmlElement(name = "EquityDoubleTouchOptionData")
    protected EqTouchOptionData equityDoubleTouchOptionData;
    @XmlElement(name = "EquityTouchOptionData")
    protected EqTouchOptionData equityTouchOptionData;
    @XmlElement(name = "EquityCliquetOptionData")
    protected CliquetOptionData equityCliquetOptionData;
    @XmlElement(name = "BondData")
    protected BondData bondData;
    @XmlElement(name = "ForwardBondData")
    protected ForwardBondData forwardBondData;
    @XmlElement(name = "BondFutureData")
    protected BondFutureData bondFutureData;
    @XmlElement(name = "CreditDefaultSwapData")
    protected CreditDefaultSwapData creditDefaultSwapData;
    @XmlElement(name = "CreditDefaultSwapOptionData")
    protected CreditDefaultSwapOptionData creditDefaultSwapOptionData;
    @XmlElement(name = "CommodityForwardData")
    protected CommodityForwardData commodityForwardData;
    @XmlElement(name = "CommodityOptionData")
    protected CommodityOptionData commodityOptionData;
    @XmlElement(name = "CommodityDigitalAveragePriceOptionData")
    protected CommodityDigitalAveragePriceOptionData commodityDigitalAveragePriceOptionData;
    @XmlElement(name = "CommodityDigitalOptionData")
    protected CommodityDigitalOptionData commodityDigitalOptionData;
    @XmlElement(name = "CommoditySpreadOptionData")
    protected CommoditySpreadOptionData commoditySpreadOptionData;
    @XmlElement(name = "CommoditySwapData")
    protected CommoditySwapData commoditySwapData;
    @XmlElement(name = "CommoditySwaptionData")
    protected CommoditySwaptionData commoditySwaptionData;
    @XmlElement(name = "CommodityAveragePriceOptionData")
    protected CommodityAveragePriceOptionData commodityAveragePriceOptionData;
    @XmlElement(name = "CommodityOptionStripData")
    protected CommodityOptionStripData commodityOptionStripData;
    @XmlElement(name = "CommodityPositionData")
    protected CommodityPositionData commodityPositionData;
    @XmlElement(name = "EquityAsianOptionData")
    protected SingleUnderlyingAsianOptionData equityAsianOptionData;
    @XmlElement(name = "FxAsianOptionData")
    protected SingleUnderlyingAsianOptionData fxAsianOptionData;
    @XmlElement(name = "CommodityAsianOptionData")
    protected SingleUnderlyingAsianOptionData commodityAsianOptionData;
    @XmlElement(name = "BondOptionData")
    protected BondOptionData bondOptionData;
    @XmlElement(name = "BondRepoData")
    protected BondRepoData bondRepoData;
    @XmlElement(name = "BondTRSData")
    protected BondTRSData bondTRSData;
    @XmlElement(name = "CdoData")
    protected CdoData cdoData;
    @XmlElement(name = "CreditLinkedSwapData")
    protected CreditLinkedSwapData creditLinkedSwapData;
    @XmlElement(name = "IndexCreditDefaultSwapData")
    protected IndexCreditDefaultSwapData indexCreditDefaultSwapData;
    @XmlElement(name = "IndexCreditDefaultSwapOptionData")
    protected IndexCreditDefaultSwapOptionData indexCreditDefaultSwapOptionData;
    @XmlElement(name = "MultiLegOptionData")
    protected MultiLegOptionData multiLegOptionData;
    @XmlElement(name = "AscotData")
    protected AscotData ascotData;
    @XmlElement(name = "ConvertibleBondData")
    protected ConvertibleBondData convertibleBondData;
    @XmlElement(name = "CallableBondData")
    protected CallableBondData callableBondData;
    @XmlElement(name = "TreasuryLockData")
    protected TlockData treasuryLockData;
    @XmlElement(name = "RiskParticipationAgreementData")
    protected RpaData riskParticipationAgreementData;
    @XmlElement(name = "CBOData")
    protected Cbodata cboData;
    @XmlElement(name = "BondBasketData")
    protected BondBasketData bondBasketData;
    @XmlElement(name = "EquityPositionData")
    protected EquityPositionData equityPositionData;
    @XmlElement(name = "EquityOptionPositionData")
    protected EquityOptionPositionData equityOptionPositionData;
    @XmlElement(name = "TotalReturnSwapData")
    protected TotalReturnSwapData totalReturnSwapData;
    @XmlElement(name = "ContractForDifferenceData")
    protected TotalReturnSwapData contractForDifferenceData;
    @XmlElement(name = "CompositeTradeData")
    protected CompositeTradeData compositeTradeData;
    @XmlElement(name = "PairwiseVarianceSwapData")
    protected PairwiseVarianceSwapData1 pairwiseVarianceSwapData;
    @XmlElement(name = "EquityPairwiseVarianceSwapData")
    protected PairwiseVarianceSwapData2 equityPairwiseVarianceSwapData;
    @XmlElement(name = "FxPairwiseVarianceSwapData")
    protected PairwiseVarianceSwapData2 fxPairwiseVarianceSwapData;
    @XmlElement(name = "EquityOutperformanceOptionData")
    protected EqOutperformanceOptionData equityOutperformanceOptionData;
    @XmlElement(name = "FlexiSwapData")
    protected FlexiSwapData flexiSwapData;
    @XmlElement(name = "BalanceGuaranteedSwapData")
    protected BgSwapData balanceGuaranteedSwapData;
    @XmlElement(name = "CommodityRevenueOptionData")
    protected CommodityRevenueOptionData commodityRevenueOptionData;
    @XmlElement(name = "BasketVarianceSwapData")
    protected BasketVarianceSwapData basketVarianceSwapData;
    @XmlElement(name = "EquityBasketVarianceSwapData")
    protected BasketVarianceSwapData2 equityBasketVarianceSwapData;
    @XmlElement(name = "FxBasketVarianceSwapData")
    protected BasketVarianceSwapData2 fxBasketVarianceSwapData;
    @XmlElement(name = "CommodityBasketVarianceSwapData")
    protected BasketVarianceSwapData2 commodityBasketVarianceSwapData;
    @XmlElement(name = "ExtendedAccumulatorData")
    protected ExtendedAccumulatorData extendedAccumulatorData;
    @XmlElement(name = "VarianceOptionData")
    protected VarianceOptionData varianceOptionData;
    @XmlElement(name = "VarianceDispersionSwapData")
    protected VarianceDispersionSwapData varianceDispersionSwapData;
    @XmlElement(name = "KIKOVarianceSwapData")
    protected KikoVarianceSwapData kikoVarianceSwapData;
    @XmlElement(name = "CorridorVarianceSwapData")
    protected CorridorVarianceSwapData corridorVarianceSwapData;
    @XmlElement(name = "IndexedCorridorVarianceSwapData")
    protected IndexedCorridorVarianceSwapData indexedCorridorVarianceSwapData;
    @XmlElement(name = "KIKOCorridorVarianceSwapData")
    protected KikoCorridorVarianceSwapData kikoCorridorVarianceSwapData;
    @XmlElement(name = "CorridorVarianceDispersionSwapData")
    protected CorridorVarianceDispersionSwapData corridorVarianceDispersionSwapData;
    @XmlElement(name = "KOCorridorVarianceDispersionSwapData")
    protected KoCorridorVarianceDispersionSwapData koCorridorVarianceDispersionSwapData;
    @XmlElement(name = "PairwiseGeometricVarianceDispersionSwapData")
    protected PairwiseGeometricVarianceDispersionSwapData pairwiseGeometricVarianceDispersionSwapData;
    @XmlElement(name = "ConditionalVarianceSwap01Data")
    protected ConditionalVarianceSwap01Data conditionalVarianceSwap01Data;
    @XmlElement(name = "ConditionalVarianceSwap02Data")
    protected ConditionalVarianceSwap02Data conditionalVarianceSwap02Data;
    @XmlElement(name = "GammaSwapData")
    protected GammaSwapData gammaSwapData;
    @XmlElement(name = "BestEntryOptionData")
    protected BestEntryOptionData bestEntryOptionData;
    @XmlElement(name = "DualEuroBinaryOptionData")
    protected DualEuroBinaryOptionData dualEuroBinaryOptionData;
    @XmlElement(name = "DualEuroBinaryOptionDoubleKOData")
    protected DualEuroBinaryOptionDoubleKOData dualEuroBinaryOptionDoubleKOData;
    @XmlElement(name = "VolatilityBarrierOptionData")
    protected VolBarrierOptionData volatilityBarrierOptionData;
    @XmlElement(name = "FxTaRFData")
    protected TarfData2 fxTaRFData;
    @XmlElement(name = "EquityTaRFData")
    protected TarfData2 equityTaRFData;
    @XmlElement(name = "CommodityTaRFData")
    protected TarfData2 commodityTaRFData;
    @XmlElement(name = "FxAccumulatorData")
    protected AccumulatorData fxAccumulatorData;
    @XmlElement(name = "EquityAccumulatorData")
    protected AccumulatorData equityAccumulatorData;
    @XmlElement(name = "CommodityAccumulatorData")
    protected AccumulatorData commodityAccumulatorData;
    @XmlElement(name = "FxWindowBarrierOptionData")
    protected WindowBarrierOptionData2 fxWindowBarrierOptionData;
    @XmlElement(name = "EquityWindowBarrierOptionData")
    protected WindowBarrierOptionData2 equityWindowBarrierOptionData;
    @XmlElement(name = "CommodityWindowBarierOptionData")
    protected WindowBarrierOptionData2 commodityWindowBarierOptionData;
    @XmlElement(name = "EquityBasketOptionData")
    protected BasketOptionData equityBasketOptionData;
    @XmlElement(name = "FxBasketOptionData")
    protected BasketOptionData fxBasketOptionData;
    @XmlElement(name = "CommodityBasketOptionData")
    protected BasketOptionData commodityBasketOptionData;
    @XmlElement(name = "FxGenericBarrierOptionData")
    protected GenericBarrierOptionData fxGenericBarrierOptionData;
    @XmlElement(name = "EquityGenericBarrierOptionData")
    protected GenericBarrierOptionData equityGenericBarrierOptionData;
    @XmlElement(name = "CommodityGenericBarrierOptionData")
    protected GenericBarrierOptionData commodityGenericBarrierOptionData;
    @XmlElement(name = "EquityRainbowOptionData")
    protected RainbowOptionData equityRainbowOptionData;
    @XmlElement(name = "FxRainbowOptionData")
    protected RainbowOptionData fxRainbowOptionData;
    @XmlElement(name = "CommodityRainbowOptionData")
    protected RainbowOptionData commodityRainbowOptionData;
    @XmlElement(name = "Autocallable01Data")
    protected Autocallable01Data autocallable01Data;
    @XmlElement(name = "DoubleDigitalOptionData")
    protected DoubleDigitalOptionData doubleDigitalOptionData;
    @XmlElement(name = "PerformanceOption01Data")
    protected PerformanceOption01Data performanceOption01Data;
    @XmlElement(name = "ScriptedTradeData")
    protected ScriptedTradeData scriptedTradeData;
    @XmlElement(name = "VanillaBasketOptionData")
    protected VanillaBasketOptionData vanillaBasketOptionData;
    @XmlElement(name = "AsianBasketOptionData")
    protected AsianBasketOptionData asianBasketOptionData;
    @XmlElement(name = "AverageStrikeBasketOptionData")
    protected AverageStrikeBasketOptionData averageStrikeBasketOptionData;
    @XmlElement(name = "LookbackCallBasketOptionData")
    protected LookbackCallBasketOptionData lookbackCallBasketOptionData;
    @XmlElement(name = "LookbackPutBasketOptionData")
    protected LookbackPutBasketOptionData lookbackPutBasketOptionData;
    @XmlElement(name = "BestOfAirbagData")
    protected BestOfAirbagData bestOfAirbagData;
    @XmlElement(name = "WorstOfBasketSwapData")
    protected WorstOfBasketSwapData worstOfBasketSwapData;
    @XmlElement(name = "FxWorstOfBasketSwapData")
    protected WorstOfBasketSwapData2 fxWorstOfBasketSwapData;
    @XmlElement(name = "EquityWorstOfBasketSwapData")
    protected WorstOfBasketSwapData2 equityWorstOfBasketSwapData;
    @XmlElement(name = "CommodityWorstOfBasketSwapData")
    protected WorstOfBasketSwapData2 commodityWorstOfBasketSwapData;
    @XmlElement(name = "WorstPerformanceRainbowOption01Data")
    protected WorstPerformanceRainbowOption01Data worstPerformanceRainbowOption01Data;
    @XmlElement(name = "WorstPerformanceRainbowOption02Data")
    protected WorstPerformanceRainbowOption02Data worstPerformanceRainbowOption02Data;
    @XmlElement(name = "WorstPerformanceRainbowOption03Data")
    protected WorstPerformanceRainbowOption03Data worstPerformanceRainbowOption03Data;
    @XmlElement(name = "WorstPerformanceRainbowOption04Data")
    protected WorstPerformanceRainbowOption04Data worstPerformanceRainbowOption04Data;
    @XmlElement(name = "WorstPerformanceRainbowOption05Data")
    protected WorstPerformanceRainbowOption05Data worstPerformanceRainbowOption05Data;
    @XmlElement(name = "WorstPerformanceRainbowOption06Data")
    protected WorstPerformanceRainbowOption06Data worstPerformanceRainbowOption06Data;
    @XmlElement(name = "WorstPerformanceRainbowOption07Data")
    protected WorstPerformanceRainbowOption07Data worstPerformanceRainbowOption07Data;
    @XmlElement(name = "BestOfAssetOrCashRainbowOptionData")
    protected BestOfAssetOrCashRainbowOptionData bestOfAssetOrCashRainbowOptionData;
    @XmlElement(name = "WorstOfAssetOrCashRainbowOptionData")
    protected WorstOfAssetOrCashRainbowOptionData worstOfAssetOrCashRainbowOptionData;
    @XmlElement(name = "MinRainbowOptionData")
    protected MinRainbowOptionData minRainbowOptionData;
    @XmlElement(name = "MaxRainbowOptionData")
    protected MaxRainbowOptionData maxRainbowOptionData;
    @XmlElement(name = "WindowBarrierOptionData")
    protected WindowBarrierOptionData windowBarrierOptionData;
    @XmlElement(name = "Accumulator01Data")
    protected Accumulator01Data accumulator01Data;
    @XmlElement(name = "Accumulator02Data")
    protected Accumulator02Data accumulator02Data;
    @XmlElement(name = "EquityBestEntryOptionData")
    protected BestEntryOptionData2 equityBestEntryOptionData;
    @XmlElement(name = "FxBestEntryOptionData")
    protected BestEntryOptionData2 fxBestEntryOptionData;
    @XmlElement(name = "CommodityBestEntryOptionData")
    protected BestEntryOptionData2 commodityBestEntryOptionData;
    @XmlElement(name = "TaRFData")
    protected TarfData taRFData;
    @XmlElement(name = "EuropeanRainbowCallSpreadOptionData")
    protected EuropeanRainbowCallSpreadOptionData europeanRainbowCallSpreadOptionData;
    @XmlElement(name = "RainbowCallSpreadBarrierOptionData")
    protected RainbowCallSpreadBarrierOptionData rainbowCallSpreadBarrierOptionData;
    @XmlElement(name = "AsianRainbowCallSpreadOptionData")
    protected AsianRainbowCallSpreadOptionData asianRainbowCallSpreadOptionData;
    @XmlElement(name = "AsianIrCapFloorData")
    protected AsianIrCapFloorData asianIrCapFloorData;
    @XmlElement(name = "ForwardVolatilityAgreementData")
    protected ForwardVolatilityAgreementData forwardVolatilityAgreementData;
    @XmlElement(name = "CorrelationSwapData")
    protected CorrelationSwapData correlationSwapData;
    @XmlElement(name = "AssetLinkedCliquetOptionData")
    protected AssetLinkedCliquetOptionData assetLinkedCliquetOptionData;
    @XmlElement(name = "ConstantMaturityVolatilitySwapData")
    protected ConstantMaturityVolatilitySwapData constantMaturityVolatilitySwapData;
    @XmlElement(name = "CMSCapFloorBarrierData")
    protected CmsCapFloorBarrierData cmsCapFloorBarrierData;
    @XmlElement(name = "FixedStrikeForwardStartingOptionData")
    protected FixedStrikeForwardStartingOptionData fixedStrikeForwardStartingOptionData;
    @XmlElement(name = "FloatingStrikeForwardStartingOptionData")
    protected FloatingStrikeForwardStartingOptionData floatingStrikeForwardStartingOptionData;
    @XmlElement(name = "ForwardStartingSwaptionData")
    protected ForwardStartingSwaptionData forwardStartingSwaptionData;
    @XmlElement(name = "FlooredAverageCPIZCIISData")
    protected FlooredAverageCPIZCIISData flooredAverageCPIZCIISData;
    @XmlElement(name = "GenericBarrierOptionData")
    protected GenericBarrierOptionDataRaw genericBarrierOptionData;
    @XmlElement(name = "MovingMaxYYIISData")
    protected MovingMaxYYIISData movingMaxYYIISData;
    @XmlElement(name = "IrregularYYIISData")
    protected IrregularYYIISData irregularYYIISData;
    @XmlElement(name = "EuropeanOptionBarrierData")
    protected EuropeanOptionBarrierData europeanOptionBarrierData;
    @XmlElement(name = "LadderLockInOptionData")
    protected LadderLockInOptionData ladderLockInOptionData;
    @XmlElement(name = "LapseHedgeSwapData")
    protected LapseHedgeSwapData lapseHedgeSwapData;
    @XmlElement(name = "KnockOutSwapData")
    protected KnockOutSwapData knockOutSwapData;
    @XmlElement(name = "LPISwapData")
    protected LPISwapData lpiSwapData;
    @XmlElement(name = "CashPositionData")
    protected CashPositionData cashPositionData;
    @XmlElement(name = "StrikeResettableOptionData")
    protected StrikeResettableOptionData strikeResettableOptionData;
    @XmlElement(name = "EquityStrikeResettableOptionData")
    protected StrikeResettableOptionData2 equityStrikeResettableOptionData;
    @XmlElement(name = "FxStrikeResettableOptionData")
    protected StrikeResettableOptionData2 fxStrikeResettableOptionData;
    @XmlElement(name = "CommodityStrikeResettableOptionData")
    protected StrikeResettableOptionData2 commodityStrikeResettableOptionData;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * subTradeType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OreTradeType }
     *     
     */
    public OreTradeType getSubTradeType() {
        return subTradeType;
    }

    /**
     * subTradeType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OreTradeType }
     *     
     */
    public void setSubTradeType(OreTradeType value) {
        this.subTradeType = value;
    }

    /**
     * envelope 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Envelope }
     *     
     */
    public Envelope getEnvelope() {
        return envelope;
    }

    /**
     * envelope 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Envelope }
     *     
     */
    public void setEnvelope(Envelope value) {
        this.envelope = value;
    }

    /**
     * tradeActions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TradeActions }
     *     
     */
    public TradeActions getTradeActions() {
        return tradeActions;
    }

    /**
     * tradeActions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeActions }
     *     
     */
    public void setTradeActions(TradeActions value) {
        this.tradeActions = value;
    }

    /**
     * crossCurrencySwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SwapData }
     *     
     */
    public SwapData getCrossCurrencySwapData() {
        return crossCurrencySwapData;
    }

    /**
     * crossCurrencySwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SwapData }
     *     
     */
    public void setCrossCurrencySwapData(SwapData value) {
        this.crossCurrencySwapData = value;
    }

    /**
     * inflationSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SwapData }
     *     
     */
    public SwapData getInflationSwapData() {
        return inflationSwapData;
    }

    /**
     * inflationSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SwapData }
     *     
     */
    public void setInflationSwapData(SwapData value) {
        this.inflationSwapData = value;
    }

    /**
     * swapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SwapData }
     *     
     */
    public SwapData getSwapData() {
        return swapData;
    }

    /**
     * swapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SwapData }
     *     
     */
    public void setSwapData(SwapData value) {
        this.swapData = value;
    }

    /**
     * equitySwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SwapData }
     *     
     */
    public SwapData getEquitySwapData() {
        return equitySwapData;
    }

    /**
     * equitySwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SwapData }
     *     
     */
    public void setEquitySwapData(SwapData value) {
        this.equitySwapData = value;
    }

    /**
     * callableSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CallableSwapData }
     *     
     */
    public CallableSwapData getCallableSwapData() {
        return callableSwapData;
    }

    /**
     * callableSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CallableSwapData }
     *     
     */
    public void setCallableSwapData(CallableSwapData value) {
        this.callableSwapData = value;
    }

    /**
     * arcOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ArcOptionData }
     *     
     */
    public ArcOptionData getArcOptionData() {
        return arcOptionData;
    }

    /**
     * arcOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ArcOptionData }
     *     
     */
    public void setArcOptionData(ArcOptionData value) {
        this.arcOptionData = value;
    }

    /**
     * swaptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SwaptionData }
     *     
     */
    public SwaptionData getSwaptionData() {
        return swaptionData;
    }

    /**
     * swaptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SwaptionData }
     *     
     */
    public void setSwaptionData(SwaptionData value) {
        this.swaptionData = value;
    }

    /**
     * varianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VarianceSwapData }
     *     
     */
    public VarianceSwapData getVarianceSwapData() {
        return varianceSwapData;
    }

    /**
     * varianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VarianceSwapData }
     *     
     */
    public void setVarianceSwapData(VarianceSwapData value) {
        this.varianceSwapData = value;
    }

    /**
     * equityVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VarianceSwapData }
     *     
     */
    public VarianceSwapData getEquityVarianceSwapData() {
        return equityVarianceSwapData;
    }

    /**
     * equityVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VarianceSwapData }
     *     
     */
    public void setEquityVarianceSwapData(VarianceSwapData value) {
        this.equityVarianceSwapData = value;
    }

    /**
     * fxVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VarianceSwapData }
     *     
     */
    public VarianceSwapData getFxVarianceSwapData() {
        return fxVarianceSwapData;
    }

    /**
     * fxVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VarianceSwapData }
     *     
     */
    public void setFxVarianceSwapData(VarianceSwapData value) {
        this.fxVarianceSwapData = value;
    }

    /**
     * commodityVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VarianceSwapData }
     *     
     */
    public VarianceSwapData getCommodityVarianceSwapData() {
        return commodityVarianceSwapData;
    }

    /**
     * commodityVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VarianceSwapData }
     *     
     */
    public void setCommodityVarianceSwapData(VarianceSwapData value) {
        this.commodityVarianceSwapData = value;
    }

    /**
     * forwardRateAgreementData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ForwardRateAgreementData }
     *     
     */
    public ForwardRateAgreementData getForwardRateAgreementData() {
        return forwardRateAgreementData;
    }

    /**
     * forwardRateAgreementData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ForwardRateAgreementData }
     *     
     */
    public void setForwardRateAgreementData(ForwardRateAgreementData value) {
        this.forwardRateAgreementData = value;
    }

    /**
     * fxForwardData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxForwardData }
     *     
     */
    public FxForwardData getFxForwardData() {
        return fxForwardData;
    }

    /**
     * fxForwardData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxForwardData }
     *     
     */
    public void setFxForwardData(FxForwardData value) {
        this.fxForwardData = value;
    }

    /**
     * fxAverageForwardData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxAverageForwardData }
     *     
     */
    public FxAverageForwardData getFxAverageForwardData() {
        return fxAverageForwardData;
    }

    /**
     * fxAverageForwardData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxAverageForwardData }
     *     
     */
    public void setFxAverageForwardData(FxAverageForwardData value) {
        this.fxAverageForwardData = value;
    }

    /**
     * fxOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxOptionData }
     *     
     */
    public FxOptionData getFxOptionData() {
        return fxOptionData;
    }

    /**
     * fxOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxOptionData }
     *     
     */
    public void setFxOptionData(FxOptionData value) {
        this.fxOptionData = value;
    }

    /**
     * fxBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxBarrierOptionData }
     *     
     */
    public FxBarrierOptionData getFxBarrierOptionData() {
        return fxBarrierOptionData;
    }

    /**
     * fxBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxBarrierOptionData }
     *     
     */
    public void setFxBarrierOptionData(FxBarrierOptionData value) {
        this.fxBarrierOptionData = value;
    }

    /**
     * fxDoubleBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxBarrierOptionData }
     *     
     */
    public FxBarrierOptionData getFxDoubleBarrierOptionData() {
        return fxDoubleBarrierOptionData;
    }

    /**
     * fxDoubleBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxBarrierOptionData }
     *     
     */
    public void setFxDoubleBarrierOptionData(FxBarrierOptionData value) {
        this.fxDoubleBarrierOptionData = value;
    }

    /**
     * fxDigitalOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxDigitalOptionData }
     *     
     */
    public FxDigitalOptionData getFxDigitalOptionData() {
        return fxDigitalOptionData;
    }

    /**
     * fxDigitalOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxDigitalOptionData }
     *     
     */
    public void setFxDigitalOptionData(FxDigitalOptionData value) {
        this.fxDigitalOptionData = value;
    }

    /**
     * fxEuropeanBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxBarrierOptionData }
     *     
     */
    public FxBarrierOptionData getFxEuropeanBarrierOptionData() {
        return fxEuropeanBarrierOptionData;
    }

    /**
     * fxEuropeanBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxBarrierOptionData }
     *     
     */
    public void setFxEuropeanBarrierOptionData(FxBarrierOptionData value) {
        this.fxEuropeanBarrierOptionData = value;
    }

    /**
     * fxKIKOBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxKIKOBarrierOptionData }
     *     
     */
    public FxKIKOBarrierOptionData getFxKIKOBarrierOptionData() {
        return fxKIKOBarrierOptionData;
    }

    /**
     * fxKIKOBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxKIKOBarrierOptionData }
     *     
     */
    public void setFxKIKOBarrierOptionData(FxKIKOBarrierOptionData value) {
        this.fxKIKOBarrierOptionData = value;
    }

    /**
     * fxDigitalBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxDigitalBarrierOptionData }
     *     
     */
    public FxDigitalBarrierOptionData getFxDigitalBarrierOptionData() {
        return fxDigitalBarrierOptionData;
    }

    /**
     * fxDigitalBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxDigitalBarrierOptionData }
     *     
     */
    public void setFxDigitalBarrierOptionData(FxDigitalBarrierOptionData value) {
        this.fxDigitalBarrierOptionData = value;
    }

    /**
     * fxTouchOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxTouchOptionData }
     *     
     */
    public FxTouchOptionData getFxTouchOptionData() {
        return fxTouchOptionData;
    }

    /**
     * fxTouchOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxTouchOptionData }
     *     
     */
    public void setFxTouchOptionData(FxTouchOptionData value) {
        this.fxTouchOptionData = value;
    }

    /**
     * fxDoubleTouchOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxTouchOptionData }
     *     
     */
    public FxTouchOptionData getFxDoubleTouchOptionData() {
        return fxDoubleTouchOptionData;
    }

    /**
     * fxDoubleTouchOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxTouchOptionData }
     *     
     */
    public void setFxDoubleTouchOptionData(FxTouchOptionData value) {
        this.fxDoubleTouchOptionData = value;
    }

    /**
     * fxSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxSwapData }
     *     
     */
    public FxSwapData getFxSwapData() {
        return fxSwapData;
    }

    /**
     * fxSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxSwapData }
     *     
     */
    public void setFxSwapData(FxSwapData value) {
        this.fxSwapData = value;
    }

    /**
     * capFloorData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CapFloorData }
     *     
     */
    public CapFloorData getCapFloorData() {
        return capFloorData;
    }

    /**
     * capFloorData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CapFloorData }
     *     
     */
    public void setCapFloorData(CapFloorData value) {
        this.capFloorData = value;
    }

    /**
     * equityFutureOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EquityFutureOptionData }
     *     
     */
    public EquityFutureOptionData getEquityFutureOptionData() {
        return equityFutureOptionData;
    }

    /**
     * equityFutureOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EquityFutureOptionData }
     *     
     */
    public void setEquityFutureOptionData(EquityFutureOptionData value) {
        this.equityFutureOptionData = value;
    }

    /**
     * equityOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EquityOptionData }
     *     
     */
    public EquityOptionData getEquityOptionData() {
        return equityOptionData;
    }

    /**
     * equityOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EquityOptionData }
     *     
     */
    public void setEquityOptionData(EquityOptionData value) {
        this.equityOptionData = value;
    }

    /**
     * equityBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EqBarrierOptionData }
     *     
     */
    public EqBarrierOptionData getEquityBarrierOptionData() {
        return equityBarrierOptionData;
    }

    /**
     * equityBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EqBarrierOptionData }
     *     
     */
    public void setEquityBarrierOptionData(EqBarrierOptionData value) {
        this.equityBarrierOptionData = value;
    }

    /**
     * equityDoubleBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EqBarrierOptionData }
     *     
     */
    public EqBarrierOptionData getEquityDoubleBarrierOptionData() {
        return equityDoubleBarrierOptionData;
    }

    /**
     * equityDoubleBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EqBarrierOptionData }
     *     
     */
    public void setEquityDoubleBarrierOptionData(EqBarrierOptionData value) {
        this.equityDoubleBarrierOptionData = value;
    }

    /**
     * equityForwardData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EquityForwardData }
     *     
     */
    public EquityForwardData getEquityForwardData() {
        return equityForwardData;
    }

    /**
     * equityForwardData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EquityForwardData }
     *     
     */
    public void setEquityForwardData(EquityForwardData value) {
        this.equityForwardData = value;
    }

    /**
     * equityEuropeanBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EqBarrierOptionData }
     *     
     */
    public EqBarrierOptionData getEquityEuropeanBarrierOptionData() {
        return equityEuropeanBarrierOptionData;
    }

    /**
     * equityEuropeanBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EqBarrierOptionData }
     *     
     */
    public void setEquityEuropeanBarrierOptionData(EqBarrierOptionData value) {
        this.equityEuropeanBarrierOptionData = value;
    }

    /**
     * equityDigitalOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EqDigitalOptionData }
     *     
     */
    public EqDigitalOptionData getEquityDigitalOptionData() {
        return equityDigitalOptionData;
    }

    /**
     * equityDigitalOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EqDigitalOptionData }
     *     
     */
    public void setEquityDigitalOptionData(EqDigitalOptionData value) {
        this.equityDigitalOptionData = value;
    }

    /**
     * equityDoubleTouchOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EqTouchOptionData }
     *     
     */
    public EqTouchOptionData getEquityDoubleTouchOptionData() {
        return equityDoubleTouchOptionData;
    }

    /**
     * equityDoubleTouchOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EqTouchOptionData }
     *     
     */
    public void setEquityDoubleTouchOptionData(EqTouchOptionData value) {
        this.equityDoubleTouchOptionData = value;
    }

    /**
     * equityTouchOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EqTouchOptionData }
     *     
     */
    public EqTouchOptionData getEquityTouchOptionData() {
        return equityTouchOptionData;
    }

    /**
     * equityTouchOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EqTouchOptionData }
     *     
     */
    public void setEquityTouchOptionData(EqTouchOptionData value) {
        this.equityTouchOptionData = value;
    }

    /**
     * equityCliquetOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CliquetOptionData }
     *     
     */
    public CliquetOptionData getEquityCliquetOptionData() {
        return equityCliquetOptionData;
    }

    /**
     * equityCliquetOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CliquetOptionData }
     *     
     */
    public void setEquityCliquetOptionData(CliquetOptionData value) {
        this.equityCliquetOptionData = value;
    }

    /**
     * bondData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BondData }
     *     
     */
    public BondData getBondData() {
        return bondData;
    }

    /**
     * bondData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BondData }
     *     
     */
    public void setBondData(BondData value) {
        this.bondData = value;
    }

    /**
     * forwardBondData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ForwardBondData }
     *     
     */
    public ForwardBondData getForwardBondData() {
        return forwardBondData;
    }

    /**
     * forwardBondData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ForwardBondData }
     *     
     */
    public void setForwardBondData(ForwardBondData value) {
        this.forwardBondData = value;
    }

    /**
     * bondFutureData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BondFutureData }
     *     
     */
    public BondFutureData getBondFutureData() {
        return bondFutureData;
    }

    /**
     * bondFutureData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BondFutureData }
     *     
     */
    public void setBondFutureData(BondFutureData value) {
        this.bondFutureData = value;
    }

    /**
     * creditDefaultSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CreditDefaultSwapData }
     *     
     */
    public CreditDefaultSwapData getCreditDefaultSwapData() {
        return creditDefaultSwapData;
    }

    /**
     * creditDefaultSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditDefaultSwapData }
     *     
     */
    public void setCreditDefaultSwapData(CreditDefaultSwapData value) {
        this.creditDefaultSwapData = value;
    }

    /**
     * creditDefaultSwapOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CreditDefaultSwapOptionData }
     *     
     */
    public CreditDefaultSwapOptionData getCreditDefaultSwapOptionData() {
        return creditDefaultSwapOptionData;
    }

    /**
     * creditDefaultSwapOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditDefaultSwapOptionData }
     *     
     */
    public void setCreditDefaultSwapOptionData(CreditDefaultSwapOptionData value) {
        this.creditDefaultSwapOptionData = value;
    }

    /**
     * commodityForwardData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityForwardData }
     *     
     */
    public CommodityForwardData getCommodityForwardData() {
        return commodityForwardData;
    }

    /**
     * commodityForwardData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityForwardData }
     *     
     */
    public void setCommodityForwardData(CommodityForwardData value) {
        this.commodityForwardData = value;
    }

    /**
     * commodityOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityOptionData }
     *     
     */
    public CommodityOptionData getCommodityOptionData() {
        return commodityOptionData;
    }

    /**
     * commodityOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityOptionData }
     *     
     */
    public void setCommodityOptionData(CommodityOptionData value) {
        this.commodityOptionData = value;
    }

    /**
     * commodityDigitalAveragePriceOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityDigitalAveragePriceOptionData }
     *     
     */
    public CommodityDigitalAveragePriceOptionData getCommodityDigitalAveragePriceOptionData() {
        return commodityDigitalAveragePriceOptionData;
    }

    /**
     * commodityDigitalAveragePriceOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityDigitalAveragePriceOptionData }
     *     
     */
    public void setCommodityDigitalAveragePriceOptionData(CommodityDigitalAveragePriceOptionData value) {
        this.commodityDigitalAveragePriceOptionData = value;
    }

    /**
     * commodityDigitalOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityDigitalOptionData }
     *     
     */
    public CommodityDigitalOptionData getCommodityDigitalOptionData() {
        return commodityDigitalOptionData;
    }

    /**
     * commodityDigitalOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityDigitalOptionData }
     *     
     */
    public void setCommodityDigitalOptionData(CommodityDigitalOptionData value) {
        this.commodityDigitalOptionData = value;
    }

    /**
     * commoditySpreadOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommoditySpreadOptionData }
     *     
     */
    public CommoditySpreadOptionData getCommoditySpreadOptionData() {
        return commoditySpreadOptionData;
    }

    /**
     * commoditySpreadOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommoditySpreadOptionData }
     *     
     */
    public void setCommoditySpreadOptionData(CommoditySpreadOptionData value) {
        this.commoditySpreadOptionData = value;
    }

    /**
     * commoditySwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommoditySwapData }
     *     
     */
    public CommoditySwapData getCommoditySwapData() {
        return commoditySwapData;
    }

    /**
     * commoditySwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommoditySwapData }
     *     
     */
    public void setCommoditySwapData(CommoditySwapData value) {
        this.commoditySwapData = value;
    }

    /**
     * commoditySwaptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommoditySwaptionData }
     *     
     */
    public CommoditySwaptionData getCommoditySwaptionData() {
        return commoditySwaptionData;
    }

    /**
     * commoditySwaptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommoditySwaptionData }
     *     
     */
    public void setCommoditySwaptionData(CommoditySwaptionData value) {
        this.commoditySwaptionData = value;
    }

    /**
     * commodityAveragePriceOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityAveragePriceOptionData }
     *     
     */
    public CommodityAveragePriceOptionData getCommodityAveragePriceOptionData() {
        return commodityAveragePriceOptionData;
    }

    /**
     * commodityAveragePriceOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityAveragePriceOptionData }
     *     
     */
    public void setCommodityAveragePriceOptionData(CommodityAveragePriceOptionData value) {
        this.commodityAveragePriceOptionData = value;
    }

    /**
     * commodityOptionStripData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityOptionStripData }
     *     
     */
    public CommodityOptionStripData getCommodityOptionStripData() {
        return commodityOptionStripData;
    }

    /**
     * commodityOptionStripData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityOptionStripData }
     *     
     */
    public void setCommodityOptionStripData(CommodityOptionStripData value) {
        this.commodityOptionStripData = value;
    }

    /**
     * commodityPositionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityPositionData }
     *     
     */
    public CommodityPositionData getCommodityPositionData() {
        return commodityPositionData;
    }

    /**
     * commodityPositionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityPositionData }
     *     
     */
    public void setCommodityPositionData(CommodityPositionData value) {
        this.commodityPositionData = value;
    }

    /**
     * equityAsianOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SingleUnderlyingAsianOptionData }
     *     
     */
    public SingleUnderlyingAsianOptionData getEquityAsianOptionData() {
        return equityAsianOptionData;
    }

    /**
     * equityAsianOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SingleUnderlyingAsianOptionData }
     *     
     */
    public void setEquityAsianOptionData(SingleUnderlyingAsianOptionData value) {
        this.equityAsianOptionData = value;
    }

    /**
     * fxAsianOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SingleUnderlyingAsianOptionData }
     *     
     */
    public SingleUnderlyingAsianOptionData getFxAsianOptionData() {
        return fxAsianOptionData;
    }

    /**
     * fxAsianOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SingleUnderlyingAsianOptionData }
     *     
     */
    public void setFxAsianOptionData(SingleUnderlyingAsianOptionData value) {
        this.fxAsianOptionData = value;
    }

    /**
     * commodityAsianOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SingleUnderlyingAsianOptionData }
     *     
     */
    public SingleUnderlyingAsianOptionData getCommodityAsianOptionData() {
        return commodityAsianOptionData;
    }

    /**
     * commodityAsianOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SingleUnderlyingAsianOptionData }
     *     
     */
    public void setCommodityAsianOptionData(SingleUnderlyingAsianOptionData value) {
        this.commodityAsianOptionData = value;
    }

    /**
     * bondOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BondOptionData }
     *     
     */
    public BondOptionData getBondOptionData() {
        return bondOptionData;
    }

    /**
     * bondOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BondOptionData }
     *     
     */
    public void setBondOptionData(BondOptionData value) {
        this.bondOptionData = value;
    }

    /**
     * bondRepoData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BondRepoData }
     *     
     */
    public BondRepoData getBondRepoData() {
        return bondRepoData;
    }

    /**
     * bondRepoData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BondRepoData }
     *     
     */
    public void setBondRepoData(BondRepoData value) {
        this.bondRepoData = value;
    }

    /**
     * bondTRSData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BondTRSData }
     *     
     */
    public BondTRSData getBondTRSData() {
        return bondTRSData;
    }

    /**
     * bondTRSData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BondTRSData }
     *     
     */
    public void setBondTRSData(BondTRSData value) {
        this.bondTRSData = value;
    }

    /**
     * cdoData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CdoData }
     *     
     */
    public CdoData getCdoData() {
        return cdoData;
    }

    /**
     * cdoData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CdoData }
     *     
     */
    public void setCdoData(CdoData value) {
        this.cdoData = value;
    }

    /**
     * creditLinkedSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CreditLinkedSwapData }
     *     
     */
    public CreditLinkedSwapData getCreditLinkedSwapData() {
        return creditLinkedSwapData;
    }

    /**
     * creditLinkedSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditLinkedSwapData }
     *     
     */
    public void setCreditLinkedSwapData(CreditLinkedSwapData value) {
        this.creditLinkedSwapData = value;
    }

    /**
     * indexCreditDefaultSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link IndexCreditDefaultSwapData }
     *     
     */
    public IndexCreditDefaultSwapData getIndexCreditDefaultSwapData() {
        return indexCreditDefaultSwapData;
    }

    /**
     * indexCreditDefaultSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link IndexCreditDefaultSwapData }
     *     
     */
    public void setIndexCreditDefaultSwapData(IndexCreditDefaultSwapData value) {
        this.indexCreditDefaultSwapData = value;
    }

    /**
     * indexCreditDefaultSwapOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link IndexCreditDefaultSwapOptionData }
     *     
     */
    public IndexCreditDefaultSwapOptionData getIndexCreditDefaultSwapOptionData() {
        return indexCreditDefaultSwapOptionData;
    }

    /**
     * indexCreditDefaultSwapOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link IndexCreditDefaultSwapOptionData }
     *     
     */
    public void setIndexCreditDefaultSwapOptionData(IndexCreditDefaultSwapOptionData value) {
        this.indexCreditDefaultSwapOptionData = value;
    }

    /**
     * multiLegOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MultiLegOptionData }
     *     
     */
    public MultiLegOptionData getMultiLegOptionData() {
        return multiLegOptionData;
    }

    /**
     * multiLegOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiLegOptionData }
     *     
     */
    public void setMultiLegOptionData(MultiLegOptionData value) {
        this.multiLegOptionData = value;
    }

    /**
     * ascotData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AscotData }
     *     
     */
    public AscotData getAscotData() {
        return ascotData;
    }

    /**
     * ascotData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AscotData }
     *     
     */
    public void setAscotData(AscotData value) {
        this.ascotData = value;
    }

    /**
     * convertibleBondData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ConvertibleBondData }
     *     
     */
    public ConvertibleBondData getConvertibleBondData() {
        return convertibleBondData;
    }

    /**
     * convertibleBondData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ConvertibleBondData }
     *     
     */
    public void setConvertibleBondData(ConvertibleBondData value) {
        this.convertibleBondData = value;
    }

    /**
     * callableBondData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CallableBondData }
     *     
     */
    public CallableBondData getCallableBondData() {
        return callableBondData;
    }

    /**
     * callableBondData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CallableBondData }
     *     
     */
    public void setCallableBondData(CallableBondData value) {
        this.callableBondData = value;
    }

    /**
     * treasuryLockData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TlockData }
     *     
     */
    public TlockData getTreasuryLockData() {
        return treasuryLockData;
    }

    /**
     * treasuryLockData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TlockData }
     *     
     */
    public void setTreasuryLockData(TlockData value) {
        this.treasuryLockData = value;
    }

    /**
     * riskParticipationAgreementData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RpaData }
     *     
     */
    public RpaData getRiskParticipationAgreementData() {
        return riskParticipationAgreementData;
    }

    /**
     * riskParticipationAgreementData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RpaData }
     *     
     */
    public void setRiskParticipationAgreementData(RpaData value) {
        this.riskParticipationAgreementData = value;
    }

    /**
     * cboData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Cbodata }
     *     
     */
    public Cbodata getCBOData() {
        return cboData;
    }

    /**
     * cboData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Cbodata }
     *     
     */
    public void setCBOData(Cbodata value) {
        this.cboData = value;
    }

    /**
     * bondBasketData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BondBasketData }
     *     
     */
    public BondBasketData getBondBasketData() {
        return bondBasketData;
    }

    /**
     * bondBasketData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BondBasketData }
     *     
     */
    public void setBondBasketData(BondBasketData value) {
        this.bondBasketData = value;
    }

    /**
     * equityPositionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EquityPositionData }
     *     
     */
    public EquityPositionData getEquityPositionData() {
        return equityPositionData;
    }

    /**
     * equityPositionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EquityPositionData }
     *     
     */
    public void setEquityPositionData(EquityPositionData value) {
        this.equityPositionData = value;
    }

    /**
     * equityOptionPositionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EquityOptionPositionData }
     *     
     */
    public EquityOptionPositionData getEquityOptionPositionData() {
        return equityOptionPositionData;
    }

    /**
     * equityOptionPositionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EquityOptionPositionData }
     *     
     */
    public void setEquityOptionPositionData(EquityOptionPositionData value) {
        this.equityOptionPositionData = value;
    }

    /**
     * totalReturnSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TotalReturnSwapData }
     *     
     */
    public TotalReturnSwapData getTotalReturnSwapData() {
        return totalReturnSwapData;
    }

    /**
     * totalReturnSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalReturnSwapData }
     *     
     */
    public void setTotalReturnSwapData(TotalReturnSwapData value) {
        this.totalReturnSwapData = value;
    }

    /**
     * contractForDifferenceData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TotalReturnSwapData }
     *     
     */
    public TotalReturnSwapData getContractForDifferenceData() {
        return contractForDifferenceData;
    }

    /**
     * contractForDifferenceData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalReturnSwapData }
     *     
     */
    public void setContractForDifferenceData(TotalReturnSwapData value) {
        this.contractForDifferenceData = value;
    }

    /**
     * compositeTradeData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CompositeTradeData }
     *     
     */
    public CompositeTradeData getCompositeTradeData() {
        return compositeTradeData;
    }

    /**
     * compositeTradeData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CompositeTradeData }
     *     
     */
    public void setCompositeTradeData(CompositeTradeData value) {
        this.compositeTradeData = value;
    }

    /**
     * pairwiseVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PairwiseVarianceSwapData1 }
     *     
     */
    public PairwiseVarianceSwapData1 getPairwiseVarianceSwapData() {
        return pairwiseVarianceSwapData;
    }

    /**
     * pairwiseVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PairwiseVarianceSwapData1 }
     *     
     */
    public void setPairwiseVarianceSwapData(PairwiseVarianceSwapData1 value) {
        this.pairwiseVarianceSwapData = value;
    }

    /**
     * equityPairwiseVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PairwiseVarianceSwapData2 }
     *     
     */
    public PairwiseVarianceSwapData2 getEquityPairwiseVarianceSwapData() {
        return equityPairwiseVarianceSwapData;
    }

    /**
     * equityPairwiseVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PairwiseVarianceSwapData2 }
     *     
     */
    public void setEquityPairwiseVarianceSwapData(PairwiseVarianceSwapData2 value) {
        this.equityPairwiseVarianceSwapData = value;
    }

    /**
     * fxPairwiseVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PairwiseVarianceSwapData2 }
     *     
     */
    public PairwiseVarianceSwapData2 getFxPairwiseVarianceSwapData() {
        return fxPairwiseVarianceSwapData;
    }

    /**
     * fxPairwiseVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PairwiseVarianceSwapData2 }
     *     
     */
    public void setFxPairwiseVarianceSwapData(PairwiseVarianceSwapData2 value) {
        this.fxPairwiseVarianceSwapData = value;
    }

    /**
     * equityOutperformanceOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EqOutperformanceOptionData }
     *     
     */
    public EqOutperformanceOptionData getEquityOutperformanceOptionData() {
        return equityOutperformanceOptionData;
    }

    /**
     * equityOutperformanceOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EqOutperformanceOptionData }
     *     
     */
    public void setEquityOutperformanceOptionData(EqOutperformanceOptionData value) {
        this.equityOutperformanceOptionData = value;
    }

    /**
     * flexiSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FlexiSwapData }
     *     
     */
    public FlexiSwapData getFlexiSwapData() {
        return flexiSwapData;
    }

    /**
     * flexiSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FlexiSwapData }
     *     
     */
    public void setFlexiSwapData(FlexiSwapData value) {
        this.flexiSwapData = value;
    }

    /**
     * balanceGuaranteedSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BgSwapData }
     *     
     */
    public BgSwapData getBalanceGuaranteedSwapData() {
        return balanceGuaranteedSwapData;
    }

    /**
     * balanceGuaranteedSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BgSwapData }
     *     
     */
    public void setBalanceGuaranteedSwapData(BgSwapData value) {
        this.balanceGuaranteedSwapData = value;
    }

    /**
     * commodityRevenueOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityRevenueOptionData }
     *     
     */
    public CommodityRevenueOptionData getCommodityRevenueOptionData() {
        return commodityRevenueOptionData;
    }

    /**
     * commodityRevenueOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityRevenueOptionData }
     *     
     */
    public void setCommodityRevenueOptionData(CommodityRevenueOptionData value) {
        this.commodityRevenueOptionData = value;
    }

    /**
     * basketVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BasketVarianceSwapData }
     *     
     */
    public BasketVarianceSwapData getBasketVarianceSwapData() {
        return basketVarianceSwapData;
    }

    /**
     * basketVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketVarianceSwapData }
     *     
     */
    public void setBasketVarianceSwapData(BasketVarianceSwapData value) {
        this.basketVarianceSwapData = value;
    }

    /**
     * equityBasketVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BasketVarianceSwapData2 }
     *     
     */
    public BasketVarianceSwapData2 getEquityBasketVarianceSwapData() {
        return equityBasketVarianceSwapData;
    }

    /**
     * equityBasketVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketVarianceSwapData2 }
     *     
     */
    public void setEquityBasketVarianceSwapData(BasketVarianceSwapData2 value) {
        this.equityBasketVarianceSwapData = value;
    }

    /**
     * fxBasketVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BasketVarianceSwapData2 }
     *     
     */
    public BasketVarianceSwapData2 getFxBasketVarianceSwapData() {
        return fxBasketVarianceSwapData;
    }

    /**
     * fxBasketVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketVarianceSwapData2 }
     *     
     */
    public void setFxBasketVarianceSwapData(BasketVarianceSwapData2 value) {
        this.fxBasketVarianceSwapData = value;
    }

    /**
     * commodityBasketVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BasketVarianceSwapData2 }
     *     
     */
    public BasketVarianceSwapData2 getCommodityBasketVarianceSwapData() {
        return commodityBasketVarianceSwapData;
    }

    /**
     * commodityBasketVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketVarianceSwapData2 }
     *     
     */
    public void setCommodityBasketVarianceSwapData(BasketVarianceSwapData2 value) {
        this.commodityBasketVarianceSwapData = value;
    }

    /**
     * extendedAccumulatorData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedAccumulatorData }
     *     
     */
    public ExtendedAccumulatorData getExtendedAccumulatorData() {
        return extendedAccumulatorData;
    }

    /**
     * extendedAccumulatorData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedAccumulatorData }
     *     
     */
    public void setExtendedAccumulatorData(ExtendedAccumulatorData value) {
        this.extendedAccumulatorData = value;
    }

    /**
     * varianceOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VarianceOptionData }
     *     
     */
    public VarianceOptionData getVarianceOptionData() {
        return varianceOptionData;
    }

    /**
     * varianceOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VarianceOptionData }
     *     
     */
    public void setVarianceOptionData(VarianceOptionData value) {
        this.varianceOptionData = value;
    }

    /**
     * varianceDispersionSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VarianceDispersionSwapData }
     *     
     */
    public VarianceDispersionSwapData getVarianceDispersionSwapData() {
        return varianceDispersionSwapData;
    }

    /**
     * varianceDispersionSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VarianceDispersionSwapData }
     *     
     */
    public void setVarianceDispersionSwapData(VarianceDispersionSwapData value) {
        this.varianceDispersionSwapData = value;
    }

    /**
     * kikoVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link KikoVarianceSwapData }
     *     
     */
    public KikoVarianceSwapData getKIKOVarianceSwapData() {
        return kikoVarianceSwapData;
    }

    /**
     * kikoVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link KikoVarianceSwapData }
     *     
     */
    public void setKIKOVarianceSwapData(KikoVarianceSwapData value) {
        this.kikoVarianceSwapData = value;
    }

    /**
     * corridorVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CorridorVarianceSwapData }
     *     
     */
    public CorridorVarianceSwapData getCorridorVarianceSwapData() {
        return corridorVarianceSwapData;
    }

    /**
     * corridorVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CorridorVarianceSwapData }
     *     
     */
    public void setCorridorVarianceSwapData(CorridorVarianceSwapData value) {
        this.corridorVarianceSwapData = value;
    }

    /**
     * indexedCorridorVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link IndexedCorridorVarianceSwapData }
     *     
     */
    public IndexedCorridorVarianceSwapData getIndexedCorridorVarianceSwapData() {
        return indexedCorridorVarianceSwapData;
    }

    /**
     * indexedCorridorVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link IndexedCorridorVarianceSwapData }
     *     
     */
    public void setIndexedCorridorVarianceSwapData(IndexedCorridorVarianceSwapData value) {
        this.indexedCorridorVarianceSwapData = value;
    }

    /**
     * kikoCorridorVarianceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link KikoCorridorVarianceSwapData }
     *     
     */
    public KikoCorridorVarianceSwapData getKIKOCorridorVarianceSwapData() {
        return kikoCorridorVarianceSwapData;
    }

    /**
     * kikoCorridorVarianceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link KikoCorridorVarianceSwapData }
     *     
     */
    public void setKIKOCorridorVarianceSwapData(KikoCorridorVarianceSwapData value) {
        this.kikoCorridorVarianceSwapData = value;
    }

    /**
     * corridorVarianceDispersionSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CorridorVarianceDispersionSwapData }
     *     
     */
    public CorridorVarianceDispersionSwapData getCorridorVarianceDispersionSwapData() {
        return corridorVarianceDispersionSwapData;
    }

    /**
     * corridorVarianceDispersionSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CorridorVarianceDispersionSwapData }
     *     
     */
    public void setCorridorVarianceDispersionSwapData(CorridorVarianceDispersionSwapData value) {
        this.corridorVarianceDispersionSwapData = value;
    }

    /**
     * koCorridorVarianceDispersionSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link KoCorridorVarianceDispersionSwapData }
     *     
     */
    public KoCorridorVarianceDispersionSwapData getKOCorridorVarianceDispersionSwapData() {
        return koCorridorVarianceDispersionSwapData;
    }

    /**
     * koCorridorVarianceDispersionSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link KoCorridorVarianceDispersionSwapData }
     *     
     */
    public void setKOCorridorVarianceDispersionSwapData(KoCorridorVarianceDispersionSwapData value) {
        this.koCorridorVarianceDispersionSwapData = value;
    }

    /**
     * pairwiseGeometricVarianceDispersionSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PairwiseGeometricVarianceDispersionSwapData }
     *     
     */
    public PairwiseGeometricVarianceDispersionSwapData getPairwiseGeometricVarianceDispersionSwapData() {
        return pairwiseGeometricVarianceDispersionSwapData;
    }

    /**
     * pairwiseGeometricVarianceDispersionSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PairwiseGeometricVarianceDispersionSwapData }
     *     
     */
    public void setPairwiseGeometricVarianceDispersionSwapData(PairwiseGeometricVarianceDispersionSwapData value) {
        this.pairwiseGeometricVarianceDispersionSwapData = value;
    }

    /**
     * conditionalVarianceSwap01Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ConditionalVarianceSwap01Data }
     *     
     */
    public ConditionalVarianceSwap01Data getConditionalVarianceSwap01Data() {
        return conditionalVarianceSwap01Data;
    }

    /**
     * conditionalVarianceSwap01Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionalVarianceSwap01Data }
     *     
     */
    public void setConditionalVarianceSwap01Data(ConditionalVarianceSwap01Data value) {
        this.conditionalVarianceSwap01Data = value;
    }

    /**
     * conditionalVarianceSwap02Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ConditionalVarianceSwap02Data }
     *     
     */
    public ConditionalVarianceSwap02Data getConditionalVarianceSwap02Data() {
        return conditionalVarianceSwap02Data;
    }

    /**
     * conditionalVarianceSwap02Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionalVarianceSwap02Data }
     *     
     */
    public void setConditionalVarianceSwap02Data(ConditionalVarianceSwap02Data value) {
        this.conditionalVarianceSwap02Data = value;
    }

    /**
     * gammaSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GammaSwapData }
     *     
     */
    public GammaSwapData getGammaSwapData() {
        return gammaSwapData;
    }

    /**
     * gammaSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GammaSwapData }
     *     
     */
    public void setGammaSwapData(GammaSwapData value) {
        this.gammaSwapData = value;
    }

    /**
     * bestEntryOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BestEntryOptionData }
     *     
     */
    public BestEntryOptionData getBestEntryOptionData() {
        return bestEntryOptionData;
    }

    /**
     * bestEntryOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BestEntryOptionData }
     *     
     */
    public void setBestEntryOptionData(BestEntryOptionData value) {
        this.bestEntryOptionData = value;
    }

    /**
     * dualEuroBinaryOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DualEuroBinaryOptionData }
     *     
     */
    public DualEuroBinaryOptionData getDualEuroBinaryOptionData() {
        return dualEuroBinaryOptionData;
    }

    /**
     * dualEuroBinaryOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DualEuroBinaryOptionData }
     *     
     */
    public void setDualEuroBinaryOptionData(DualEuroBinaryOptionData value) {
        this.dualEuroBinaryOptionData = value;
    }

    /**
     * dualEuroBinaryOptionDoubleKOData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DualEuroBinaryOptionDoubleKOData }
     *     
     */
    public DualEuroBinaryOptionDoubleKOData getDualEuroBinaryOptionDoubleKOData() {
        return dualEuroBinaryOptionDoubleKOData;
    }

    /**
     * dualEuroBinaryOptionDoubleKOData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DualEuroBinaryOptionDoubleKOData }
     *     
     */
    public void setDualEuroBinaryOptionDoubleKOData(DualEuroBinaryOptionDoubleKOData value) {
        this.dualEuroBinaryOptionDoubleKOData = value;
    }

    /**
     * volatilityBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VolBarrierOptionData }
     *     
     */
    public VolBarrierOptionData getVolatilityBarrierOptionData() {
        return volatilityBarrierOptionData;
    }

    /**
     * volatilityBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolBarrierOptionData }
     *     
     */
    public void setVolatilityBarrierOptionData(VolBarrierOptionData value) {
        this.volatilityBarrierOptionData = value;
    }

    /**
     * fxTaRFData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TarfData2 }
     *     
     */
    public TarfData2 getFxTaRFData() {
        return fxTaRFData;
    }

    /**
     * fxTaRFData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TarfData2 }
     *     
     */
    public void setFxTaRFData(TarfData2 value) {
        this.fxTaRFData = value;
    }

    /**
     * equityTaRFData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TarfData2 }
     *     
     */
    public TarfData2 getEquityTaRFData() {
        return equityTaRFData;
    }

    /**
     * equityTaRFData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TarfData2 }
     *     
     */
    public void setEquityTaRFData(TarfData2 value) {
        this.equityTaRFData = value;
    }

    /**
     * commodityTaRFData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TarfData2 }
     *     
     */
    public TarfData2 getCommodityTaRFData() {
        return commodityTaRFData;
    }

    /**
     * commodityTaRFData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TarfData2 }
     *     
     */
    public void setCommodityTaRFData(TarfData2 value) {
        this.commodityTaRFData = value;
    }

    /**
     * fxAccumulatorData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AccumulatorData }
     *     
     */
    public AccumulatorData getFxAccumulatorData() {
        return fxAccumulatorData;
    }

    /**
     * fxAccumulatorData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AccumulatorData }
     *     
     */
    public void setFxAccumulatorData(AccumulatorData value) {
        this.fxAccumulatorData = value;
    }

    /**
     * equityAccumulatorData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AccumulatorData }
     *     
     */
    public AccumulatorData getEquityAccumulatorData() {
        return equityAccumulatorData;
    }

    /**
     * equityAccumulatorData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AccumulatorData }
     *     
     */
    public void setEquityAccumulatorData(AccumulatorData value) {
        this.equityAccumulatorData = value;
    }

    /**
     * commodityAccumulatorData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AccumulatorData }
     *     
     */
    public AccumulatorData getCommodityAccumulatorData() {
        return commodityAccumulatorData;
    }

    /**
     * commodityAccumulatorData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AccumulatorData }
     *     
     */
    public void setCommodityAccumulatorData(AccumulatorData value) {
        this.commodityAccumulatorData = value;
    }

    /**
     * fxWindowBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WindowBarrierOptionData2 }
     *     
     */
    public WindowBarrierOptionData2 getFxWindowBarrierOptionData() {
        return fxWindowBarrierOptionData;
    }

    /**
     * fxWindowBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WindowBarrierOptionData2 }
     *     
     */
    public void setFxWindowBarrierOptionData(WindowBarrierOptionData2 value) {
        this.fxWindowBarrierOptionData = value;
    }

    /**
     * equityWindowBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WindowBarrierOptionData2 }
     *     
     */
    public WindowBarrierOptionData2 getEquityWindowBarrierOptionData() {
        return equityWindowBarrierOptionData;
    }

    /**
     * equityWindowBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WindowBarrierOptionData2 }
     *     
     */
    public void setEquityWindowBarrierOptionData(WindowBarrierOptionData2 value) {
        this.equityWindowBarrierOptionData = value;
    }

    /**
     * commodityWindowBarierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WindowBarrierOptionData2 }
     *     
     */
    public WindowBarrierOptionData2 getCommodityWindowBarierOptionData() {
        return commodityWindowBarierOptionData;
    }

    /**
     * commodityWindowBarierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WindowBarrierOptionData2 }
     *     
     */
    public void setCommodityWindowBarierOptionData(WindowBarrierOptionData2 value) {
        this.commodityWindowBarierOptionData = value;
    }

    /**
     * equityBasketOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BasketOptionData }
     *     
     */
    public BasketOptionData getEquityBasketOptionData() {
        return equityBasketOptionData;
    }

    /**
     * equityBasketOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketOptionData }
     *     
     */
    public void setEquityBasketOptionData(BasketOptionData value) {
        this.equityBasketOptionData = value;
    }

    /**
     * fxBasketOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BasketOptionData }
     *     
     */
    public BasketOptionData getFxBasketOptionData() {
        return fxBasketOptionData;
    }

    /**
     * fxBasketOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketOptionData }
     *     
     */
    public void setFxBasketOptionData(BasketOptionData value) {
        this.fxBasketOptionData = value;
    }

    /**
     * commodityBasketOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BasketOptionData }
     *     
     */
    public BasketOptionData getCommodityBasketOptionData() {
        return commodityBasketOptionData;
    }

    /**
     * commodityBasketOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketOptionData }
     *     
     */
    public void setCommodityBasketOptionData(BasketOptionData value) {
        this.commodityBasketOptionData = value;
    }

    /**
     * fxGenericBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GenericBarrierOptionData }
     *     
     */
    public GenericBarrierOptionData getFxGenericBarrierOptionData() {
        return fxGenericBarrierOptionData;
    }

    /**
     * fxGenericBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericBarrierOptionData }
     *     
     */
    public void setFxGenericBarrierOptionData(GenericBarrierOptionData value) {
        this.fxGenericBarrierOptionData = value;
    }

    /**
     * equityGenericBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GenericBarrierOptionData }
     *     
     */
    public GenericBarrierOptionData getEquityGenericBarrierOptionData() {
        return equityGenericBarrierOptionData;
    }

    /**
     * equityGenericBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericBarrierOptionData }
     *     
     */
    public void setEquityGenericBarrierOptionData(GenericBarrierOptionData value) {
        this.equityGenericBarrierOptionData = value;
    }

    /**
     * commodityGenericBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GenericBarrierOptionData }
     *     
     */
    public GenericBarrierOptionData getCommodityGenericBarrierOptionData() {
        return commodityGenericBarrierOptionData;
    }

    /**
     * commodityGenericBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericBarrierOptionData }
     *     
     */
    public void setCommodityGenericBarrierOptionData(GenericBarrierOptionData value) {
        this.commodityGenericBarrierOptionData = value;
    }

    /**
     * equityRainbowOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RainbowOptionData }
     *     
     */
    public RainbowOptionData getEquityRainbowOptionData() {
        return equityRainbowOptionData;
    }

    /**
     * equityRainbowOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RainbowOptionData }
     *     
     */
    public void setEquityRainbowOptionData(RainbowOptionData value) {
        this.equityRainbowOptionData = value;
    }

    /**
     * fxRainbowOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RainbowOptionData }
     *     
     */
    public RainbowOptionData getFxRainbowOptionData() {
        return fxRainbowOptionData;
    }

    /**
     * fxRainbowOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RainbowOptionData }
     *     
     */
    public void setFxRainbowOptionData(RainbowOptionData value) {
        this.fxRainbowOptionData = value;
    }

    /**
     * commodityRainbowOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RainbowOptionData }
     *     
     */
    public RainbowOptionData getCommodityRainbowOptionData() {
        return commodityRainbowOptionData;
    }

    /**
     * commodityRainbowOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RainbowOptionData }
     *     
     */
    public void setCommodityRainbowOptionData(RainbowOptionData value) {
        this.commodityRainbowOptionData = value;
    }

    /**
     * autocallable01Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Autocallable01Data }
     *     
     */
    public Autocallable01Data getAutocallable01Data() {
        return autocallable01Data;
    }

    /**
     * autocallable01Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Autocallable01Data }
     *     
     */
    public void setAutocallable01Data(Autocallable01Data value) {
        this.autocallable01Data = value;
    }

    /**
     * doubleDigitalOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DoubleDigitalOptionData }
     *     
     */
    public DoubleDigitalOptionData getDoubleDigitalOptionData() {
        return doubleDigitalOptionData;
    }

    /**
     * doubleDigitalOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DoubleDigitalOptionData }
     *     
     */
    public void setDoubleDigitalOptionData(DoubleDigitalOptionData value) {
        this.doubleDigitalOptionData = value;
    }

    /**
     * performanceOption01Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PerformanceOption01Data }
     *     
     */
    public PerformanceOption01Data getPerformanceOption01Data() {
        return performanceOption01Data;
    }

    /**
     * performanceOption01Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PerformanceOption01Data }
     *     
     */
    public void setPerformanceOption01Data(PerformanceOption01Data value) {
        this.performanceOption01Data = value;
    }

    /**
     * scriptedTradeData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScriptedTradeData }
     *     
     */
    public ScriptedTradeData getScriptedTradeData() {
        return scriptedTradeData;
    }

    /**
     * scriptedTradeData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScriptedTradeData }
     *     
     */
    public void setScriptedTradeData(ScriptedTradeData value) {
        this.scriptedTradeData = value;
    }

    /**
     * vanillaBasketOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VanillaBasketOptionData }
     *     
     */
    public VanillaBasketOptionData getVanillaBasketOptionData() {
        return vanillaBasketOptionData;
    }

    /**
     * vanillaBasketOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VanillaBasketOptionData }
     *     
     */
    public void setVanillaBasketOptionData(VanillaBasketOptionData value) {
        this.vanillaBasketOptionData = value;
    }

    /**
     * asianBasketOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AsianBasketOptionData }
     *     
     */
    public AsianBasketOptionData getAsianBasketOptionData() {
        return asianBasketOptionData;
    }

    /**
     * asianBasketOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AsianBasketOptionData }
     *     
     */
    public void setAsianBasketOptionData(AsianBasketOptionData value) {
        this.asianBasketOptionData = value;
    }

    /**
     * averageStrikeBasketOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AverageStrikeBasketOptionData }
     *     
     */
    public AverageStrikeBasketOptionData getAverageStrikeBasketOptionData() {
        return averageStrikeBasketOptionData;
    }

    /**
     * averageStrikeBasketOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AverageStrikeBasketOptionData }
     *     
     */
    public void setAverageStrikeBasketOptionData(AverageStrikeBasketOptionData value) {
        this.averageStrikeBasketOptionData = value;
    }

    /**
     * lookbackCallBasketOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LookbackCallBasketOptionData }
     *     
     */
    public LookbackCallBasketOptionData getLookbackCallBasketOptionData() {
        return lookbackCallBasketOptionData;
    }

    /**
     * lookbackCallBasketOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LookbackCallBasketOptionData }
     *     
     */
    public void setLookbackCallBasketOptionData(LookbackCallBasketOptionData value) {
        this.lookbackCallBasketOptionData = value;
    }

    /**
     * lookbackPutBasketOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LookbackPutBasketOptionData }
     *     
     */
    public LookbackPutBasketOptionData getLookbackPutBasketOptionData() {
        return lookbackPutBasketOptionData;
    }

    /**
     * lookbackPutBasketOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LookbackPutBasketOptionData }
     *     
     */
    public void setLookbackPutBasketOptionData(LookbackPutBasketOptionData value) {
        this.lookbackPutBasketOptionData = value;
    }

    /**
     * bestOfAirbagData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BestOfAirbagData }
     *     
     */
    public BestOfAirbagData getBestOfAirbagData() {
        return bestOfAirbagData;
    }

    /**
     * bestOfAirbagData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BestOfAirbagData }
     *     
     */
    public void setBestOfAirbagData(BestOfAirbagData value) {
        this.bestOfAirbagData = value;
    }

    /**
     * worstOfBasketSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstOfBasketSwapData }
     *     
     */
    public WorstOfBasketSwapData getWorstOfBasketSwapData() {
        return worstOfBasketSwapData;
    }

    /**
     * worstOfBasketSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstOfBasketSwapData }
     *     
     */
    public void setWorstOfBasketSwapData(WorstOfBasketSwapData value) {
        this.worstOfBasketSwapData = value;
    }

    /**
     * fxWorstOfBasketSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstOfBasketSwapData2 }
     *     
     */
    public WorstOfBasketSwapData2 getFxWorstOfBasketSwapData() {
        return fxWorstOfBasketSwapData;
    }

    /**
     * fxWorstOfBasketSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstOfBasketSwapData2 }
     *     
     */
    public void setFxWorstOfBasketSwapData(WorstOfBasketSwapData2 value) {
        this.fxWorstOfBasketSwapData = value;
    }

    /**
     * equityWorstOfBasketSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstOfBasketSwapData2 }
     *     
     */
    public WorstOfBasketSwapData2 getEquityWorstOfBasketSwapData() {
        return equityWorstOfBasketSwapData;
    }

    /**
     * equityWorstOfBasketSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstOfBasketSwapData2 }
     *     
     */
    public void setEquityWorstOfBasketSwapData(WorstOfBasketSwapData2 value) {
        this.equityWorstOfBasketSwapData = value;
    }

    /**
     * commodityWorstOfBasketSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstOfBasketSwapData2 }
     *     
     */
    public WorstOfBasketSwapData2 getCommodityWorstOfBasketSwapData() {
        return commodityWorstOfBasketSwapData;
    }

    /**
     * commodityWorstOfBasketSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstOfBasketSwapData2 }
     *     
     */
    public void setCommodityWorstOfBasketSwapData(WorstOfBasketSwapData2 value) {
        this.commodityWorstOfBasketSwapData = value;
    }

    /**
     * worstPerformanceRainbowOption01Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstPerformanceRainbowOption01Data }
     *     
     */
    public WorstPerformanceRainbowOption01Data getWorstPerformanceRainbowOption01Data() {
        return worstPerformanceRainbowOption01Data;
    }

    /**
     * worstPerformanceRainbowOption01Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstPerformanceRainbowOption01Data }
     *     
     */
    public void setWorstPerformanceRainbowOption01Data(WorstPerformanceRainbowOption01Data value) {
        this.worstPerformanceRainbowOption01Data = value;
    }

    /**
     * worstPerformanceRainbowOption02Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstPerformanceRainbowOption02Data }
     *     
     */
    public WorstPerformanceRainbowOption02Data getWorstPerformanceRainbowOption02Data() {
        return worstPerformanceRainbowOption02Data;
    }

    /**
     * worstPerformanceRainbowOption02Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstPerformanceRainbowOption02Data }
     *     
     */
    public void setWorstPerformanceRainbowOption02Data(WorstPerformanceRainbowOption02Data value) {
        this.worstPerformanceRainbowOption02Data = value;
    }

    /**
     * worstPerformanceRainbowOption03Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstPerformanceRainbowOption03Data }
     *     
     */
    public WorstPerformanceRainbowOption03Data getWorstPerformanceRainbowOption03Data() {
        return worstPerformanceRainbowOption03Data;
    }

    /**
     * worstPerformanceRainbowOption03Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstPerformanceRainbowOption03Data }
     *     
     */
    public void setWorstPerformanceRainbowOption03Data(WorstPerformanceRainbowOption03Data value) {
        this.worstPerformanceRainbowOption03Data = value;
    }

    /**
     * worstPerformanceRainbowOption04Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstPerformanceRainbowOption04Data }
     *     
     */
    public WorstPerformanceRainbowOption04Data getWorstPerformanceRainbowOption04Data() {
        return worstPerformanceRainbowOption04Data;
    }

    /**
     * worstPerformanceRainbowOption04Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstPerformanceRainbowOption04Data }
     *     
     */
    public void setWorstPerformanceRainbowOption04Data(WorstPerformanceRainbowOption04Data value) {
        this.worstPerformanceRainbowOption04Data = value;
    }

    /**
     * worstPerformanceRainbowOption05Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstPerformanceRainbowOption05Data }
     *     
     */
    public WorstPerformanceRainbowOption05Data getWorstPerformanceRainbowOption05Data() {
        return worstPerformanceRainbowOption05Data;
    }

    /**
     * worstPerformanceRainbowOption05Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstPerformanceRainbowOption05Data }
     *     
     */
    public void setWorstPerformanceRainbowOption05Data(WorstPerformanceRainbowOption05Data value) {
        this.worstPerformanceRainbowOption05Data = value;
    }

    /**
     * worstPerformanceRainbowOption06Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstPerformanceRainbowOption06Data }
     *     
     */
    public WorstPerformanceRainbowOption06Data getWorstPerformanceRainbowOption06Data() {
        return worstPerformanceRainbowOption06Data;
    }

    /**
     * worstPerformanceRainbowOption06Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstPerformanceRainbowOption06Data }
     *     
     */
    public void setWorstPerformanceRainbowOption06Data(WorstPerformanceRainbowOption06Data value) {
        this.worstPerformanceRainbowOption06Data = value;
    }

    /**
     * worstPerformanceRainbowOption07Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstPerformanceRainbowOption07Data }
     *     
     */
    public WorstPerformanceRainbowOption07Data getWorstPerformanceRainbowOption07Data() {
        return worstPerformanceRainbowOption07Data;
    }

    /**
     * worstPerformanceRainbowOption07Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstPerformanceRainbowOption07Data }
     *     
     */
    public void setWorstPerformanceRainbowOption07Data(WorstPerformanceRainbowOption07Data value) {
        this.worstPerformanceRainbowOption07Data = value;
    }

    /**
     * bestOfAssetOrCashRainbowOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BestOfAssetOrCashRainbowOptionData }
     *     
     */
    public BestOfAssetOrCashRainbowOptionData getBestOfAssetOrCashRainbowOptionData() {
        return bestOfAssetOrCashRainbowOptionData;
    }

    /**
     * bestOfAssetOrCashRainbowOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BestOfAssetOrCashRainbowOptionData }
     *     
     */
    public void setBestOfAssetOrCashRainbowOptionData(BestOfAssetOrCashRainbowOptionData value) {
        this.bestOfAssetOrCashRainbowOptionData = value;
    }

    /**
     * worstOfAssetOrCashRainbowOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstOfAssetOrCashRainbowOptionData }
     *     
     */
    public WorstOfAssetOrCashRainbowOptionData getWorstOfAssetOrCashRainbowOptionData() {
        return worstOfAssetOrCashRainbowOptionData;
    }

    /**
     * worstOfAssetOrCashRainbowOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstOfAssetOrCashRainbowOptionData }
     *     
     */
    public void setWorstOfAssetOrCashRainbowOptionData(WorstOfAssetOrCashRainbowOptionData value) {
        this.worstOfAssetOrCashRainbowOptionData = value;
    }

    /**
     * minRainbowOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MinRainbowOptionData }
     *     
     */
    public MinRainbowOptionData getMinRainbowOptionData() {
        return minRainbowOptionData;
    }

    /**
     * minRainbowOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MinRainbowOptionData }
     *     
     */
    public void setMinRainbowOptionData(MinRainbowOptionData value) {
        this.minRainbowOptionData = value;
    }

    /**
     * maxRainbowOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MaxRainbowOptionData }
     *     
     */
    public MaxRainbowOptionData getMaxRainbowOptionData() {
        return maxRainbowOptionData;
    }

    /**
     * maxRainbowOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MaxRainbowOptionData }
     *     
     */
    public void setMaxRainbowOptionData(MaxRainbowOptionData value) {
        this.maxRainbowOptionData = value;
    }

    /**
     * windowBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WindowBarrierOptionData }
     *     
     */
    public WindowBarrierOptionData getWindowBarrierOptionData() {
        return windowBarrierOptionData;
    }

    /**
     * windowBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WindowBarrierOptionData }
     *     
     */
    public void setWindowBarrierOptionData(WindowBarrierOptionData value) {
        this.windowBarrierOptionData = value;
    }

    /**
     * accumulator01Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Accumulator01Data }
     *     
     */
    public Accumulator01Data getAccumulator01Data() {
        return accumulator01Data;
    }

    /**
     * accumulator01Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Accumulator01Data }
     *     
     */
    public void setAccumulator01Data(Accumulator01Data value) {
        this.accumulator01Data = value;
    }

    /**
     * accumulator02Data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Accumulator02Data }
     *     
     */
    public Accumulator02Data getAccumulator02Data() {
        return accumulator02Data;
    }

    /**
     * accumulator02Data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Accumulator02Data }
     *     
     */
    public void setAccumulator02Data(Accumulator02Data value) {
        this.accumulator02Data = value;
    }

    /**
     * equityBestEntryOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BestEntryOptionData2 }
     *     
     */
    public BestEntryOptionData2 getEquityBestEntryOptionData() {
        return equityBestEntryOptionData;
    }

    /**
     * equityBestEntryOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BestEntryOptionData2 }
     *     
     */
    public void setEquityBestEntryOptionData(BestEntryOptionData2 value) {
        this.equityBestEntryOptionData = value;
    }

    /**
     * fxBestEntryOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BestEntryOptionData2 }
     *     
     */
    public BestEntryOptionData2 getFxBestEntryOptionData() {
        return fxBestEntryOptionData;
    }

    /**
     * fxBestEntryOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BestEntryOptionData2 }
     *     
     */
    public void setFxBestEntryOptionData(BestEntryOptionData2 value) {
        this.fxBestEntryOptionData = value;
    }

    /**
     * commodityBestEntryOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BestEntryOptionData2 }
     *     
     */
    public BestEntryOptionData2 getCommodityBestEntryOptionData() {
        return commodityBestEntryOptionData;
    }

    /**
     * commodityBestEntryOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BestEntryOptionData2 }
     *     
     */
    public void setCommodityBestEntryOptionData(BestEntryOptionData2 value) {
        this.commodityBestEntryOptionData = value;
    }

    /**
     * taRFData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TarfData }
     *     
     */
    public TarfData getTaRFData() {
        return taRFData;
    }

    /**
     * taRFData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TarfData }
     *     
     */
    public void setTaRFData(TarfData value) {
        this.taRFData = value;
    }

    /**
     * europeanRainbowCallSpreadOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EuropeanRainbowCallSpreadOptionData }
     *     
     */
    public EuropeanRainbowCallSpreadOptionData getEuropeanRainbowCallSpreadOptionData() {
        return europeanRainbowCallSpreadOptionData;
    }

    /**
     * europeanRainbowCallSpreadOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EuropeanRainbowCallSpreadOptionData }
     *     
     */
    public void setEuropeanRainbowCallSpreadOptionData(EuropeanRainbowCallSpreadOptionData value) {
        this.europeanRainbowCallSpreadOptionData = value;
    }

    /**
     * rainbowCallSpreadBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RainbowCallSpreadBarrierOptionData }
     *     
     */
    public RainbowCallSpreadBarrierOptionData getRainbowCallSpreadBarrierOptionData() {
        return rainbowCallSpreadBarrierOptionData;
    }

    /**
     * rainbowCallSpreadBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RainbowCallSpreadBarrierOptionData }
     *     
     */
    public void setRainbowCallSpreadBarrierOptionData(RainbowCallSpreadBarrierOptionData value) {
        this.rainbowCallSpreadBarrierOptionData = value;
    }

    /**
     * asianRainbowCallSpreadOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AsianRainbowCallSpreadOptionData }
     *     
     */
    public AsianRainbowCallSpreadOptionData getAsianRainbowCallSpreadOptionData() {
        return asianRainbowCallSpreadOptionData;
    }

    /**
     * asianRainbowCallSpreadOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AsianRainbowCallSpreadOptionData }
     *     
     */
    public void setAsianRainbowCallSpreadOptionData(AsianRainbowCallSpreadOptionData value) {
        this.asianRainbowCallSpreadOptionData = value;
    }

    /**
     * asianIrCapFloorData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AsianIrCapFloorData }
     *     
     */
    public AsianIrCapFloorData getAsianIrCapFloorData() {
        return asianIrCapFloorData;
    }

    /**
     * asianIrCapFloorData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AsianIrCapFloorData }
     *     
     */
    public void setAsianIrCapFloorData(AsianIrCapFloorData value) {
        this.asianIrCapFloorData = value;
    }

    /**
     * forwardVolatilityAgreementData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ForwardVolatilityAgreementData }
     *     
     */
    public ForwardVolatilityAgreementData getForwardVolatilityAgreementData() {
        return forwardVolatilityAgreementData;
    }

    /**
     * forwardVolatilityAgreementData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ForwardVolatilityAgreementData }
     *     
     */
    public void setForwardVolatilityAgreementData(ForwardVolatilityAgreementData value) {
        this.forwardVolatilityAgreementData = value;
    }

    /**
     * correlationSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CorrelationSwapData }
     *     
     */
    public CorrelationSwapData getCorrelationSwapData() {
        return correlationSwapData;
    }

    /**
     * correlationSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CorrelationSwapData }
     *     
     */
    public void setCorrelationSwapData(CorrelationSwapData value) {
        this.correlationSwapData = value;
    }

    /**
     * assetLinkedCliquetOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AssetLinkedCliquetOptionData }
     *     
     */
    public AssetLinkedCliquetOptionData getAssetLinkedCliquetOptionData() {
        return assetLinkedCliquetOptionData;
    }

    /**
     * assetLinkedCliquetOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetLinkedCliquetOptionData }
     *     
     */
    public void setAssetLinkedCliquetOptionData(AssetLinkedCliquetOptionData value) {
        this.assetLinkedCliquetOptionData = value;
    }

    /**
     * constantMaturityVolatilitySwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ConstantMaturityVolatilitySwapData }
     *     
     */
    public ConstantMaturityVolatilitySwapData getConstantMaturityVolatilitySwapData() {
        return constantMaturityVolatilitySwapData;
    }

    /**
     * constantMaturityVolatilitySwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstantMaturityVolatilitySwapData }
     *     
     */
    public void setConstantMaturityVolatilitySwapData(ConstantMaturityVolatilitySwapData value) {
        this.constantMaturityVolatilitySwapData = value;
    }

    /**
     * cmsCapFloorBarrierData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CmsCapFloorBarrierData }
     *     
     */
    public CmsCapFloorBarrierData getCMSCapFloorBarrierData() {
        return cmsCapFloorBarrierData;
    }

    /**
     * cmsCapFloorBarrierData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CmsCapFloorBarrierData }
     *     
     */
    public void setCMSCapFloorBarrierData(CmsCapFloorBarrierData value) {
        this.cmsCapFloorBarrierData = value;
    }

    /**
     * fixedStrikeForwardStartingOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FixedStrikeForwardStartingOptionData }
     *     
     */
    public FixedStrikeForwardStartingOptionData getFixedStrikeForwardStartingOptionData() {
        return fixedStrikeForwardStartingOptionData;
    }

    /**
     * fixedStrikeForwardStartingOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FixedStrikeForwardStartingOptionData }
     *     
     */
    public void setFixedStrikeForwardStartingOptionData(FixedStrikeForwardStartingOptionData value) {
        this.fixedStrikeForwardStartingOptionData = value;
    }

    /**
     * floatingStrikeForwardStartingOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FloatingStrikeForwardStartingOptionData }
     *     
     */
    public FloatingStrikeForwardStartingOptionData getFloatingStrikeForwardStartingOptionData() {
        return floatingStrikeForwardStartingOptionData;
    }

    /**
     * floatingStrikeForwardStartingOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FloatingStrikeForwardStartingOptionData }
     *     
     */
    public void setFloatingStrikeForwardStartingOptionData(FloatingStrikeForwardStartingOptionData value) {
        this.floatingStrikeForwardStartingOptionData = value;
    }

    /**
     * forwardStartingSwaptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ForwardStartingSwaptionData }
     *     
     */
    public ForwardStartingSwaptionData getForwardStartingSwaptionData() {
        return forwardStartingSwaptionData;
    }

    /**
     * forwardStartingSwaptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ForwardStartingSwaptionData }
     *     
     */
    public void setForwardStartingSwaptionData(ForwardStartingSwaptionData value) {
        this.forwardStartingSwaptionData = value;
    }

    /**
     * flooredAverageCPIZCIISData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FlooredAverageCPIZCIISData }
     *     
     */
    public FlooredAverageCPIZCIISData getFlooredAverageCPIZCIISData() {
        return flooredAverageCPIZCIISData;
    }

    /**
     * flooredAverageCPIZCIISData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FlooredAverageCPIZCIISData }
     *     
     */
    public void setFlooredAverageCPIZCIISData(FlooredAverageCPIZCIISData value) {
        this.flooredAverageCPIZCIISData = value;
    }

    /**
     * genericBarrierOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GenericBarrierOptionDataRaw }
     *     
     */
    public GenericBarrierOptionDataRaw getGenericBarrierOptionData() {
        return genericBarrierOptionData;
    }

    /**
     * genericBarrierOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericBarrierOptionDataRaw }
     *     
     */
    public void setGenericBarrierOptionData(GenericBarrierOptionDataRaw value) {
        this.genericBarrierOptionData = value;
    }

    /**
     * movingMaxYYIISData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MovingMaxYYIISData }
     *     
     */
    public MovingMaxYYIISData getMovingMaxYYIISData() {
        return movingMaxYYIISData;
    }

    /**
     * movingMaxYYIISData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MovingMaxYYIISData }
     *     
     */
    public void setMovingMaxYYIISData(MovingMaxYYIISData value) {
        this.movingMaxYYIISData = value;
    }

    /**
     * irregularYYIISData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link IrregularYYIISData }
     *     
     */
    public IrregularYYIISData getIrregularYYIISData() {
        return irregularYYIISData;
    }

    /**
     * irregularYYIISData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link IrregularYYIISData }
     *     
     */
    public void setIrregularYYIISData(IrregularYYIISData value) {
        this.irregularYYIISData = value;
    }

    /**
     * europeanOptionBarrierData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EuropeanOptionBarrierData }
     *     
     */
    public EuropeanOptionBarrierData getEuropeanOptionBarrierData() {
        return europeanOptionBarrierData;
    }

    /**
     * europeanOptionBarrierData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EuropeanOptionBarrierData }
     *     
     */
    public void setEuropeanOptionBarrierData(EuropeanOptionBarrierData value) {
        this.europeanOptionBarrierData = value;
    }

    /**
     * ladderLockInOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LadderLockInOptionData }
     *     
     */
    public LadderLockInOptionData getLadderLockInOptionData() {
        return ladderLockInOptionData;
    }

    /**
     * ladderLockInOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LadderLockInOptionData }
     *     
     */
    public void setLadderLockInOptionData(LadderLockInOptionData value) {
        this.ladderLockInOptionData = value;
    }

    /**
     * lapseHedgeSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LapseHedgeSwapData }
     *     
     */
    public LapseHedgeSwapData getLapseHedgeSwapData() {
        return lapseHedgeSwapData;
    }

    /**
     * lapseHedgeSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LapseHedgeSwapData }
     *     
     */
    public void setLapseHedgeSwapData(LapseHedgeSwapData value) {
        this.lapseHedgeSwapData = value;
    }

    /**
     * knockOutSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link KnockOutSwapData }
     *     
     */
    public KnockOutSwapData getKnockOutSwapData() {
        return knockOutSwapData;
    }

    /**
     * knockOutSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link KnockOutSwapData }
     *     
     */
    public void setKnockOutSwapData(KnockOutSwapData value) {
        this.knockOutSwapData = value;
    }

    /**
     * lpiSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LPISwapData }
     *     
     */
    public LPISwapData getLPISwapData() {
        return lpiSwapData;
    }

    /**
     * lpiSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LPISwapData }
     *     
     */
    public void setLPISwapData(LPISwapData value) {
        this.lpiSwapData = value;
    }

    /**
     * cashPositionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CashPositionData }
     *     
     */
    public CashPositionData getCashPositionData() {
        return cashPositionData;
    }

    /**
     * cashPositionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CashPositionData }
     *     
     */
    public void setCashPositionData(CashPositionData value) {
        this.cashPositionData = value;
    }

    /**
     * strikeResettableOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StrikeResettableOptionData }
     *     
     */
    public StrikeResettableOptionData getStrikeResettableOptionData() {
        return strikeResettableOptionData;
    }

    /**
     * strikeResettableOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StrikeResettableOptionData }
     *     
     */
    public void setStrikeResettableOptionData(StrikeResettableOptionData value) {
        this.strikeResettableOptionData = value;
    }

    /**
     * equityStrikeResettableOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StrikeResettableOptionData2 }
     *     
     */
    public StrikeResettableOptionData2 getEquityStrikeResettableOptionData() {
        return equityStrikeResettableOptionData;
    }

    /**
     * equityStrikeResettableOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StrikeResettableOptionData2 }
     *     
     */
    public void setEquityStrikeResettableOptionData(StrikeResettableOptionData2 value) {
        this.equityStrikeResettableOptionData = value;
    }

    /**
     * fxStrikeResettableOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StrikeResettableOptionData2 }
     *     
     */
    public StrikeResettableOptionData2 getFxStrikeResettableOptionData() {
        return fxStrikeResettableOptionData;
    }

    /**
     * fxStrikeResettableOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StrikeResettableOptionData2 }
     *     
     */
    public void setFxStrikeResettableOptionData(StrikeResettableOptionData2 value) {
        this.fxStrikeResettableOptionData = value;
    }

    /**
     * commodityStrikeResettableOptionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StrikeResettableOptionData2 }
     *     
     */
    public StrikeResettableOptionData2 getCommodityStrikeResettableOptionData() {
        return commodityStrikeResettableOptionData;
    }

    /**
     * commodityStrikeResettableOptionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StrikeResettableOptionData2 }
     *     
     */
    public void setCommodityStrikeResettableOptionData(StrikeResettableOptionData2 value) {
        this.commodityStrikeResettableOptionData = value;
    }

    /**
     * id 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * id 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
