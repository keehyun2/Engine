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
 * <p>riskFactorKeyType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="riskFactorKeyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DiscountCurve"/>
 *     &lt;enumeration value="YieldCurve"/>
 *     &lt;enumeration value="IndexCurve"/>
 *     &lt;enumeration value="SwaptionVolatility"/>
 *     &lt;enumeration value="YieldVolatility"/>
 *     &lt;enumeration value="OptionletVolatility"/>
 *     &lt;enumeration value="FXSpot"/>
 *     &lt;enumeration value="FXVolatility"/>
 *     &lt;enumeration value="EquitySpot"/>
 *     &lt;enumeration value="EquityVolatility"/>
 *     &lt;enumeration value="DividendYield"/>
 *     &lt;enumeration value="SurvivalProbability"/>
 *     &lt;enumeration value="RecoveryRate"/>
 *     &lt;enumeration value="CDSVolatility"/>
 *     &lt;enumeration value="BaseCorrelation"/>
 *     &lt;enumeration value="CPIIndex"/>
 *     &lt;enumeration value="ZeroInflationCurve"/>
 *     &lt;enumeration value="YoYInflationCurve"/>
 *     &lt;enumeration value="YoYInflationCapFloorVolatility"/>
 *     &lt;enumeration value="ZeroInflationCapFloorVolatility"/>
 *     &lt;enumeration value="CommodityCurve"/>
 *     &lt;enumeration value="CommodityVolatility"/>
 *     &lt;enumeration value="SecuritySpread"/>
 *     &lt;enumeration value="Correlation"/>
 *     &lt;enumeration value="CPR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "riskFactorKeyType")
@XmlEnum
public enum RiskFactorKeyType {

    @XmlEnumValue("DiscountCurve")
    DISCOUNT_CURVE("DiscountCurve"),
    @XmlEnumValue("YieldCurve")
    YIELD_CURVE("YieldCurve"),
    @XmlEnumValue("IndexCurve")
    INDEX_CURVE("IndexCurve"),
    @XmlEnumValue("SwaptionVolatility")
    SWAPTION_VOLATILITY("SwaptionVolatility"),
    @XmlEnumValue("YieldVolatility")
    YIELD_VOLATILITY("YieldVolatility"),
    @XmlEnumValue("OptionletVolatility")
    OPTIONLET_VOLATILITY("OptionletVolatility"),
    @XmlEnumValue("FXSpot")
    FX_SPOT("FXSpot"),
    @XmlEnumValue("FXVolatility")
    FX_VOLATILITY("FXVolatility"),
    @XmlEnumValue("EquitySpot")
    EQUITY_SPOT("EquitySpot"),
    @XmlEnumValue("EquityVolatility")
    EQUITY_VOLATILITY("EquityVolatility"),
    @XmlEnumValue("DividendYield")
    DIVIDEND_YIELD("DividendYield"),
    @XmlEnumValue("SurvivalProbability")
    SURVIVAL_PROBABILITY("SurvivalProbability"),
    @XmlEnumValue("RecoveryRate")
    RECOVERY_RATE("RecoveryRate"),
    @XmlEnumValue("CDSVolatility")
    CDS_VOLATILITY("CDSVolatility"),
    @XmlEnumValue("BaseCorrelation")
    BASE_CORRELATION("BaseCorrelation"),
    @XmlEnumValue("CPIIndex")
    CPI_INDEX("CPIIndex"),
    @XmlEnumValue("ZeroInflationCurve")
    ZERO_INFLATION_CURVE("ZeroInflationCurve"),
    @XmlEnumValue("YoYInflationCurve")
    YO_Y_INFLATION_CURVE("YoYInflationCurve"),
    @XmlEnumValue("YoYInflationCapFloorVolatility")
    YO_Y_INFLATION_CAP_FLOOR_VOLATILITY("YoYInflationCapFloorVolatility"),
    @XmlEnumValue("ZeroInflationCapFloorVolatility")
    ZERO_INFLATION_CAP_FLOOR_VOLATILITY("ZeroInflationCapFloorVolatility"),
    @XmlEnumValue("CommodityCurve")
    COMMODITY_CURVE("CommodityCurve"),
    @XmlEnumValue("CommodityVolatility")
    COMMODITY_VOLATILITY("CommodityVolatility"),
    @XmlEnumValue("SecuritySpread")
    SECURITY_SPREAD("SecuritySpread"),
    @XmlEnumValue("Correlation")
    CORRELATION("Correlation"),
    CPR("CPR");
    private final String value;

    RiskFactorKeyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RiskFactorKeyType fromValue(String v) {
        for (RiskFactorKeyType c: RiskFactorKeyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
