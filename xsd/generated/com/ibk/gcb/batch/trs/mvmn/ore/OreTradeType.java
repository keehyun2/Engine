//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>oreTradeType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="oreTradeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CompositeTrade"/>
 *     &lt;enumeration value="ConvertibleBond"/>
 *     &lt;enumeration value="CallableBond"/>
 *     &lt;enumeration value="Ascot"/>
 *     &lt;enumeration value="TotalReturnSwap"/>
 *     &lt;enumeration value="ContractForDifference"/>
 *     &lt;enumeration value="CBO"/>
 *     &lt;enumeration value="EquityPosition"/>
 *     &lt;enumeration value="EquityOptionPosition"/>
 *     &lt;enumeration value="BondPosition"/>
 *     &lt;enumeration value="MultiLegOption"/>
 *     &lt;enumeration value="IndexCreditDefaultSwap"/>
 *     &lt;enumeration value="IndexCreditDefaultSwapOption"/>
 *     &lt;enumeration value="SyntheticCDO"/>
 *     &lt;enumeration value="BondOption"/>
 *     &lt;enumeration value="BondTRS"/>
 *     &lt;enumeration value="BondRepo"/>
 *     &lt;enumeration value="CreditLinkedSwap"/>
 *     &lt;enumeration value="CrossCurrencySwap"/>
 *     &lt;enumeration value="InflationSwap"/>
 *     &lt;enumeration value="Swap"/>
 *     &lt;enumeration value="Swaption"/>
 *     &lt;enumeration value="ForwardRateAgreement"/>
 *     &lt;enumeration value="FxAverageForward"/>
 *     &lt;enumeration value="FxForward"/>
 *     &lt;enumeration value="FxOption"/>
 *     &lt;enumeration value="FxAsianOption"/>
 *     &lt;enumeration value="FxBarrierOption"/>
 *     &lt;enumeration value="FxDoubleBarrierOption"/>
 *     &lt;enumeration value="FxSwap"/>
 *     &lt;enumeration value="FxDigitalOption"/>
 *     &lt;enumeration value="FxEuropeanBarrierOption"/>
 *     &lt;enumeration value="FxKIKOBarrierOption"/>
 *     &lt;enumeration value="FxTouchOption"/>
 *     &lt;enumeration value="FxDoubleTouchOption"/>
 *     &lt;enumeration value="FxDigitalBarrierOption"/>
 *     &lt;enumeration value="FxVarianceSwap"/>
 *     &lt;enumeration value="CapFloor"/>
 *     &lt;enumeration value="EquityOption"/>
 *     &lt;enumeration value="EquityFutureOption"/>
 *     &lt;enumeration value="EquityAsianOption"/>
 *     &lt;enumeration value="EquityBarrierOption"/>
 *     &lt;enumeration value="EquityDoubleBarrierOption"/>
 *     &lt;enumeration value="EquityEuropeanBarrierOption"/>
 *     &lt;enumeration value="EquityTouchOption"/>
 *     &lt;enumeration value="EquityDoubleTouchOption"/>
 *     &lt;enumeration value="EquityDigitalOption"/>
 *     &lt;enumeration value="EquityForward"/>
 *     &lt;enumeration value="EquitySwap"/>
 *     &lt;enumeration value="EquityVarianceSwap"/>
 *     &lt;enumeration value="EquityCliquetOption"/>
 *     &lt;enumeration value="CommodityForward"/>
 *     &lt;enumeration value="CommodityOption"/>
 *     &lt;enumeration value="CommodityDigitalAveragePriceOption"/>
 *     &lt;enumeration value="CommodityDigitalOption"/>
 *     &lt;enumeration value="CommodityAsianOption"/>
 *     &lt;enumeration value="CommoditySwap"/>
 *     &lt;enumeration value="CommoditySwaption"/>
 *     &lt;enumeration value="CommoditySpreadOption"/>
 *     &lt;enumeration value="CommodityAveragePriceOption"/>
 *     &lt;enumeration value="CommodityOptionStrip"/>
 *     &lt;enumeration value="CommodityPosition"/>
 *     &lt;enumeration value="CommodityVarianceSwap"/>
 *     &lt;enumeration value="Bond"/>
 *     &lt;enumeration value="ForwardBond"/>
 *     &lt;enumeration value="BondFuture"/>
 *     &lt;enumeration value="CreditDefaultSwap"/>
 *     &lt;enumeration value="CreditDefaultSwapOption"/>
 *     &lt;enumeration value="Failed"/>
 *     &lt;enumeration value="FlexiSwap"/>
 *     &lt;enumeration value="BalanceGuaranteedSwap"/>
 *     &lt;enumeration value="CallableSwap"/>
 *     &lt;enumeration value="EquityOutperformanceOption"/>
 *     &lt;enumeration value="EquityPairwiseVarianceSwap"/>
 *     &lt;enumeration value="FxPairwiseVarianceSwap"/>
 *     &lt;enumeration value="CommodityPairwiseVarianceSwap"/>
 *     &lt;enumeration value="ScriptedTrade"/>
 *     &lt;enumeration value="EquityBasketVarianceSwap"/>
 *     &lt;enumeration value="FxBasketVarianceSwap"/>
 *     &lt;enumeration value="CommodityBasketVarianceSwap"/>
 *     &lt;enumeration value="RiskParticipationAgreement"/>
 *     &lt;enumeration value="Autocallable_01"/>
 *     &lt;enumeration value="DoubleDigitalOption"/>
 *     &lt;enumeration value="EuropeanOptionBarrier"/>
 *     &lt;enumeration value="PerformanceOption_01"/>
 *     &lt;enumeration value="FxTaRF"/>
 *     &lt;enumeration value="EquityTaRF"/>
 *     &lt;enumeration value="CommodityTaRF"/>
 *     &lt;enumeration value="FxWorstOfBasketSwap"/>
 *     &lt;enumeration value="EquityWorstOfBasketSwap"/>
 *     &lt;enumeration value="CommodityWorstOfBasketSwap"/>
 *     &lt;enumeration value="EquityBestEntryOption"/>
 *     &lt;enumeration value="FxBestEntryOption"/>
 *     &lt;enumeration value="CommodityBestEntryOption"/>
 *     &lt;enumeration value="FxAccumulator"/>
 *     &lt;enumeration value="EquityAccumulator"/>
 *     &lt;enumeration value="CommodityAccumulator"/>
 *     &lt;enumeration value="FxWindowBarrierOption"/>
 *     &lt;enumeration value="EquityWindowBarrierOption"/>
 *     &lt;enumeration value="CommodityWindowBarrierOption"/>
 *     &lt;enumeration value="FxGenericBarrierOption"/>
 *     &lt;enumeration value="EquityGenericBarrierOption"/>
 *     &lt;enumeration value="CommodityGenericBarrierOption"/>
 *     &lt;enumeration value="FxBasketOption"/>
 *     &lt;enumeration value="EquityBasketOption"/>
 *     &lt;enumeration value="CommodityBasketOption"/>
 *     &lt;enumeration value="FxRainbowOption"/>
 *     &lt;enumeration value="EquityRainbowOption"/>
 *     &lt;enumeration value="CommodityRainbowOption"/>
 *     &lt;enumeration value="KnockOutSwap"/>
 *     &lt;enumeration value="CashPosition"/>
 *     &lt;enumeration value="CommodityStrikeResettableOption"/>
 *     &lt;enumeration value="FxStrikeResettableOption"/>
 *     &lt;enumeration value="EquityStrikeResettableOption"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "oreTradeType")
@XmlEnum
public enum OreTradeType {

    @XmlEnumValue("CompositeTrade")
    COMPOSITE_TRADE("CompositeTrade"),
    @XmlEnumValue("ConvertibleBond")
    CONVERTIBLE_BOND("ConvertibleBond"),
    @XmlEnumValue("CallableBond")
    CALLABLE_BOND("CallableBond"),
    @XmlEnumValue("Ascot")
    ASCOT("Ascot"),
    @XmlEnumValue("TotalReturnSwap")
    TOTAL_RETURN_SWAP("TotalReturnSwap"),
    @XmlEnumValue("ContractForDifference")
    CONTRACT_FOR_DIFFERENCE("ContractForDifference"),
    CBO("CBO"),
    @XmlEnumValue("EquityPosition")
    EQUITY_POSITION("EquityPosition"),
    @XmlEnumValue("EquityOptionPosition")
    EQUITY_OPTION_POSITION("EquityOptionPosition"),
    @XmlEnumValue("BondPosition")
    BOND_POSITION("BondPosition"),
    @XmlEnumValue("MultiLegOption")
    MULTI_LEG_OPTION("MultiLegOption"),
    @XmlEnumValue("IndexCreditDefaultSwap")
    INDEX_CREDIT_DEFAULT_SWAP("IndexCreditDefaultSwap"),
    @XmlEnumValue("IndexCreditDefaultSwapOption")
    INDEX_CREDIT_DEFAULT_SWAP_OPTION("IndexCreditDefaultSwapOption"),
    @XmlEnumValue("SyntheticCDO")
    SYNTHETIC_CDO("SyntheticCDO"),
    @XmlEnumValue("BondOption")
    BOND_OPTION("BondOption"),
    @XmlEnumValue("BondTRS")
    BOND_TRS("BondTRS"),
    @XmlEnumValue("BondRepo")
    BOND_REPO("BondRepo"),
    @XmlEnumValue("CreditLinkedSwap")
    CREDIT_LINKED_SWAP("CreditLinkedSwap"),
    @XmlEnumValue("CrossCurrencySwap")
    CROSS_CURRENCY_SWAP("CrossCurrencySwap"),
    @XmlEnumValue("InflationSwap")
    INFLATION_SWAP("InflationSwap"),
    @XmlEnumValue("Swap")
    SWAP("Swap"),
    @XmlEnumValue("Swaption")
    SWAPTION("Swaption"),
    @XmlEnumValue("ForwardRateAgreement")
    FORWARD_RATE_AGREEMENT("ForwardRateAgreement"),
    @XmlEnumValue("FxAverageForward")
    FX_AVERAGE_FORWARD("FxAverageForward"),
    @XmlEnumValue("FxForward")
    FX_FORWARD("FxForward"),
    @XmlEnumValue("FxOption")
    FX_OPTION("FxOption"),
    @XmlEnumValue("FxAsianOption")
    FX_ASIAN_OPTION("FxAsianOption"),
    @XmlEnumValue("FxBarrierOption")
    FX_BARRIER_OPTION("FxBarrierOption"),
    @XmlEnumValue("FxDoubleBarrierOption")
    FX_DOUBLE_BARRIER_OPTION("FxDoubleBarrierOption"),
    @XmlEnumValue("FxSwap")
    FX_SWAP("FxSwap"),
    @XmlEnumValue("FxDigitalOption")
    FX_DIGITAL_OPTION("FxDigitalOption"),
    @XmlEnumValue("FxEuropeanBarrierOption")
    FX_EUROPEAN_BARRIER_OPTION("FxEuropeanBarrierOption"),
    @XmlEnumValue("FxKIKOBarrierOption")
    FX_KIKO_BARRIER_OPTION("FxKIKOBarrierOption"),
    @XmlEnumValue("FxTouchOption")
    FX_TOUCH_OPTION("FxTouchOption"),
    @XmlEnumValue("FxDoubleTouchOption")
    FX_DOUBLE_TOUCH_OPTION("FxDoubleTouchOption"),
    @XmlEnumValue("FxDigitalBarrierOption")
    FX_DIGITAL_BARRIER_OPTION("FxDigitalBarrierOption"),
    @XmlEnumValue("FxVarianceSwap")
    FX_VARIANCE_SWAP("FxVarianceSwap"),
    @XmlEnumValue("CapFloor")
    CAP_FLOOR("CapFloor"),
    @XmlEnumValue("EquityOption")
    EQUITY_OPTION("EquityOption"),
    @XmlEnumValue("EquityFutureOption")
    EQUITY_FUTURE_OPTION("EquityFutureOption"),
    @XmlEnumValue("EquityAsianOption")
    EQUITY_ASIAN_OPTION("EquityAsianOption"),
    @XmlEnumValue("EquityBarrierOption")
    EQUITY_BARRIER_OPTION("EquityBarrierOption"),
    @XmlEnumValue("EquityDoubleBarrierOption")
    EQUITY_DOUBLE_BARRIER_OPTION("EquityDoubleBarrierOption"),
    @XmlEnumValue("EquityEuropeanBarrierOption")
    EQUITY_EUROPEAN_BARRIER_OPTION("EquityEuropeanBarrierOption"),
    @XmlEnumValue("EquityTouchOption")
    EQUITY_TOUCH_OPTION("EquityTouchOption"),
    @XmlEnumValue("EquityDoubleTouchOption")
    EQUITY_DOUBLE_TOUCH_OPTION("EquityDoubleTouchOption"),
    @XmlEnumValue("EquityDigitalOption")
    EQUITY_DIGITAL_OPTION("EquityDigitalOption"),
    @XmlEnumValue("EquityForward")
    EQUITY_FORWARD("EquityForward"),
    @XmlEnumValue("EquitySwap")
    EQUITY_SWAP("EquitySwap"),
    @XmlEnumValue("EquityVarianceSwap")
    EQUITY_VARIANCE_SWAP("EquityVarianceSwap"),
    @XmlEnumValue("EquityCliquetOption")
    EQUITY_CLIQUET_OPTION("EquityCliquetOption"),
    @XmlEnumValue("CommodityForward")
    COMMODITY_FORWARD("CommodityForward"),
    @XmlEnumValue("CommodityOption")
    COMMODITY_OPTION("CommodityOption"),
    @XmlEnumValue("CommodityDigitalAveragePriceOption")
    COMMODITY_DIGITAL_AVERAGE_PRICE_OPTION("CommodityDigitalAveragePriceOption"),
    @XmlEnumValue("CommodityDigitalOption")
    COMMODITY_DIGITAL_OPTION("CommodityDigitalOption"),
    @XmlEnumValue("CommodityAsianOption")
    COMMODITY_ASIAN_OPTION("CommodityAsianOption"),
    @XmlEnumValue("CommoditySwap")
    COMMODITY_SWAP("CommoditySwap"),
    @XmlEnumValue("CommoditySwaption")
    COMMODITY_SWAPTION("CommoditySwaption"),
    @XmlEnumValue("CommoditySpreadOption")
    COMMODITY_SPREAD_OPTION("CommoditySpreadOption"),
    @XmlEnumValue("CommodityAveragePriceOption")
    COMMODITY_AVERAGE_PRICE_OPTION("CommodityAveragePriceOption"),
    @XmlEnumValue("CommodityOptionStrip")
    COMMODITY_OPTION_STRIP("CommodityOptionStrip"),
    @XmlEnumValue("CommodityPosition")
    COMMODITY_POSITION("CommodityPosition"),
    @XmlEnumValue("CommodityVarianceSwap")
    COMMODITY_VARIANCE_SWAP("CommodityVarianceSwap"),
    @XmlEnumValue("Bond")
    BOND("Bond"),
    @XmlEnumValue("ForwardBond")
    FORWARD_BOND("ForwardBond"),
    @XmlEnumValue("BondFuture")
    BOND_FUTURE("BondFuture"),
    @XmlEnumValue("CreditDefaultSwap")
    CREDIT_DEFAULT_SWAP("CreditDefaultSwap"),
    @XmlEnumValue("CreditDefaultSwapOption")
    CREDIT_DEFAULT_SWAP_OPTION("CreditDefaultSwapOption"),
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("FlexiSwap")
    FLEXI_SWAP("FlexiSwap"),
    @XmlEnumValue("BalanceGuaranteedSwap")
    BALANCE_GUARANTEED_SWAP("BalanceGuaranteedSwap"),
    @XmlEnumValue("CallableSwap")
    CALLABLE_SWAP("CallableSwap"),
    @XmlEnumValue("EquityOutperformanceOption")
    EQUITY_OUTPERFORMANCE_OPTION("EquityOutperformanceOption"),
    @XmlEnumValue("EquityPairwiseVarianceSwap")
    EQUITY_PAIRWISE_VARIANCE_SWAP("EquityPairwiseVarianceSwap"),
    @XmlEnumValue("FxPairwiseVarianceSwap")
    FX_PAIRWISE_VARIANCE_SWAP("FxPairwiseVarianceSwap"),
    @XmlEnumValue("CommodityPairwiseVarianceSwap")
    COMMODITY_PAIRWISE_VARIANCE_SWAP("CommodityPairwiseVarianceSwap"),
    @XmlEnumValue("ScriptedTrade")
    SCRIPTED_TRADE("ScriptedTrade"),
    @XmlEnumValue("EquityBasketVarianceSwap")
    EQUITY_BASKET_VARIANCE_SWAP("EquityBasketVarianceSwap"),
    @XmlEnumValue("FxBasketVarianceSwap")
    FX_BASKET_VARIANCE_SWAP("FxBasketVarianceSwap"),
    @XmlEnumValue("CommodityBasketVarianceSwap")
    COMMODITY_BASKET_VARIANCE_SWAP("CommodityBasketVarianceSwap"),
    @XmlEnumValue("RiskParticipationAgreement")
    RISK_PARTICIPATION_AGREEMENT("RiskParticipationAgreement"),
    @XmlEnumValue("Autocallable_01")
    AUTOCALLABLE_01("Autocallable_01"),
    @XmlEnumValue("DoubleDigitalOption")
    DOUBLE_DIGITAL_OPTION("DoubleDigitalOption"),
    @XmlEnumValue("EuropeanOptionBarrier")
    EUROPEAN_OPTION_BARRIER("EuropeanOptionBarrier"),
    @XmlEnumValue("PerformanceOption_01")
    PERFORMANCE_OPTION_01("PerformanceOption_01"),
    @XmlEnumValue("FxTaRF")
    FX_TA_RF("FxTaRF"),
    @XmlEnumValue("EquityTaRF")
    EQUITY_TA_RF("EquityTaRF"),
    @XmlEnumValue("CommodityTaRF")
    COMMODITY_TA_RF("CommodityTaRF"),
    @XmlEnumValue("FxWorstOfBasketSwap")
    FX_WORST_OF_BASKET_SWAP("FxWorstOfBasketSwap"),
    @XmlEnumValue("EquityWorstOfBasketSwap")
    EQUITY_WORST_OF_BASKET_SWAP("EquityWorstOfBasketSwap"),
    @XmlEnumValue("CommodityWorstOfBasketSwap")
    COMMODITY_WORST_OF_BASKET_SWAP("CommodityWorstOfBasketSwap"),
    @XmlEnumValue("EquityBestEntryOption")
    EQUITY_BEST_ENTRY_OPTION("EquityBestEntryOption"),
    @XmlEnumValue("FxBestEntryOption")
    FX_BEST_ENTRY_OPTION("FxBestEntryOption"),
    @XmlEnumValue("CommodityBestEntryOption")
    COMMODITY_BEST_ENTRY_OPTION("CommodityBestEntryOption"),
    @XmlEnumValue("FxAccumulator")
    FX_ACCUMULATOR("FxAccumulator"),
    @XmlEnumValue("EquityAccumulator")
    EQUITY_ACCUMULATOR("EquityAccumulator"),
    @XmlEnumValue("CommodityAccumulator")
    COMMODITY_ACCUMULATOR("CommodityAccumulator"),
    @XmlEnumValue("FxWindowBarrierOption")
    FX_WINDOW_BARRIER_OPTION("FxWindowBarrierOption"),
    @XmlEnumValue("EquityWindowBarrierOption")
    EQUITY_WINDOW_BARRIER_OPTION("EquityWindowBarrierOption"),
    @XmlEnumValue("CommodityWindowBarrierOption")
    COMMODITY_WINDOW_BARRIER_OPTION("CommodityWindowBarrierOption"),
    @XmlEnumValue("FxGenericBarrierOption")
    FX_GENERIC_BARRIER_OPTION("FxGenericBarrierOption"),
    @XmlEnumValue("EquityGenericBarrierOption")
    EQUITY_GENERIC_BARRIER_OPTION("EquityGenericBarrierOption"),
    @XmlEnumValue("CommodityGenericBarrierOption")
    COMMODITY_GENERIC_BARRIER_OPTION("CommodityGenericBarrierOption"),
    @XmlEnumValue("FxBasketOption")
    FX_BASKET_OPTION("FxBasketOption"),
    @XmlEnumValue("EquityBasketOption")
    EQUITY_BASKET_OPTION("EquityBasketOption"),
    @XmlEnumValue("CommodityBasketOption")
    COMMODITY_BASKET_OPTION("CommodityBasketOption"),
    @XmlEnumValue("FxRainbowOption")
    FX_RAINBOW_OPTION("FxRainbowOption"),
    @XmlEnumValue("EquityRainbowOption")
    EQUITY_RAINBOW_OPTION("EquityRainbowOption"),
    @XmlEnumValue("CommodityRainbowOption")
    COMMODITY_RAINBOW_OPTION("CommodityRainbowOption"),
    @XmlEnumValue("KnockOutSwap")
    KNOCK_OUT_SWAP("KnockOutSwap"),
    @XmlEnumValue("CashPosition")
    CASH_POSITION("CashPosition"),
    @XmlEnumValue("CommodityStrikeResettableOption")
    COMMODITY_STRIKE_RESETTABLE_OPTION("CommodityStrikeResettableOption"),
    @XmlEnumValue("FxStrikeResettableOption")
    FX_STRIKE_RESETTABLE_OPTION("FxStrikeResettableOption"),
    @XmlEnumValue("EquityStrikeResettableOption")
    EQUITY_STRIKE_RESETTABLE_OPTION("EquityStrikeResettableOption");
    private final String value;

    OreTradeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OreTradeType fromValue(String v) {
        for (OreTradeType c: OreTradeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
