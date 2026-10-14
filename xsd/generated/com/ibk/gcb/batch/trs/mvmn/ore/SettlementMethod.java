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
 * <p>settlementMethod에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="settlementMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PhysicalOTC"/>
 *     &lt;enumeration value="PhysicalCleared"/>
 *     &lt;enumeration value="CollateralizedCashPrice"/>
 *     &lt;enumeration value="ParYieldCurve"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "settlementMethod")
@XmlEnum
public enum SettlementMethod {

    @XmlEnumValue("PhysicalOTC")
    PHYSICAL_OTC("PhysicalOTC"),
    @XmlEnumValue("PhysicalCleared")
    PHYSICAL_CLEARED("PhysicalCleared"),
    @XmlEnumValue("CollateralizedCashPrice")
    COLLATERALIZED_CASH_PRICE("CollateralizedCashPrice"),
    @XmlEnumValue("ParYieldCurve")
    PAR_YIELD_CURVE("ParYieldCurve");
    private final String value;

    SettlementMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SettlementMethod fromValue(String v) {
        for (SettlementMethod c: SettlementMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
