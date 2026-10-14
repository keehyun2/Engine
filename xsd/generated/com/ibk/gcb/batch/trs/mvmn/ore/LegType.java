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
 * <p>legType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="legType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fixed"/>
 *     &lt;enumeration value="Floating"/>
 *     &lt;enumeration value="CPI"/>
 *     &lt;enumeration value="YY"/>
 *     &lt;enumeration value="CMS"/>
 *     &lt;enumeration value="CMB"/>
 *     &lt;enumeration value="DigitalCMS"/>
 *     &lt;enumeration value="CMSSpread"/>
 *     &lt;enumeration value="DigitalCMSSpread"/>
 *     &lt;enumeration value="Cashflow"/>
 *     &lt;enumeration value="Equity"/>
 *     &lt;enumeration value="FormulaBased"/>
 *     &lt;enumeration value="ZeroCouponFixed"/>
 *     &lt;enumeration value="CommodityFixed"/>
 *     &lt;enumeration value="CommodityFloating"/>
 *     &lt;enumeration value="EquityMargin"/>
 *     &lt;enumeration value="DurationAdjustedCMS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "legType")
@XmlEnum
public enum LegType {

    @XmlEnumValue("Fixed")
    FIXED("Fixed"),
    @XmlEnumValue("Floating")
    FLOATING("Floating"),
    CPI("CPI"),
    YY("YY"),
    CMS("CMS"),
    CMB("CMB"),
    @XmlEnumValue("DigitalCMS")
    DIGITAL_CMS("DigitalCMS"),
    @XmlEnumValue("CMSSpread")
    CMS_SPREAD("CMSSpread"),
    @XmlEnumValue("DigitalCMSSpread")
    DIGITAL_CMS_SPREAD("DigitalCMSSpread"),
    @XmlEnumValue("Cashflow")
    CASHFLOW("Cashflow"),
    @XmlEnumValue("Equity")
    EQUITY("Equity"),
    @XmlEnumValue("FormulaBased")
    FORMULA_BASED("FormulaBased"),
    @XmlEnumValue("ZeroCouponFixed")
    ZERO_COUPON_FIXED("ZeroCouponFixed"),
    @XmlEnumValue("CommodityFixed")
    COMMODITY_FIXED("CommodityFixed"),
    @XmlEnumValue("CommodityFloating")
    COMMODITY_FLOATING("CommodityFloating"),
    @XmlEnumValue("EquityMargin")
    EQUITY_MARGIN("EquityMargin"),
    @XmlEnumValue("DurationAdjustedCMS")
    DURATION_ADJUSTED_CMS("DurationAdjustedCMS");
    private final String value;

    LegType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LegType fromValue(String v) {
        for (LegType c: LegType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
