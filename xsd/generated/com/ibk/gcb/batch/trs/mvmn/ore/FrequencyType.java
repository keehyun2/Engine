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
 * <p>frequencyType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="frequencyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Z"/>
 *     &lt;enumeration value="Once"/>
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="Annual"/>
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="Semiannual"/>
 *     &lt;enumeration value="Q"/>
 *     &lt;enumeration value="Quarterly"/>
 *     &lt;enumeration value="B"/>
 *     &lt;enumeration value="Bimonthly"/>
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="Monthly"/>
 *     &lt;enumeration value="L"/>
 *     &lt;enumeration value="Lunarmonth"/>
 *     &lt;enumeration value="W"/>
 *     &lt;enumeration value="Weekly"/>
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="Daily"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "frequencyType")
@XmlEnum
public enum FrequencyType {

    Z("Z"),
    @XmlEnumValue("Once")
    ONCE("Once"),
    A("A"),
    @XmlEnumValue("Annual")
    ANNUAL("Annual"),
    S("S"),
    @XmlEnumValue("Semiannual")
    SEMIANNUAL("Semiannual"),
    Q("Q"),
    @XmlEnumValue("Quarterly")
    QUARTERLY("Quarterly"),
    B("B"),
    @XmlEnumValue("Bimonthly")
    BIMONTHLY("Bimonthly"),
    M("M"),
    @XmlEnumValue("Monthly")
    MONTHLY("Monthly"),
    L("L"),
    @XmlEnumValue("Lunarmonth")
    LUNARMONTH("Lunarmonth"),
    W("W"),
    @XmlEnumValue("Weekly")
    WEEKLY("Weekly"),
    D("D"),
    @XmlEnumValue("Daily")
    DAILY("Daily");
    private final String value;

    FrequencyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FrequencyType fromValue(String v) {
        for (FrequencyType c: FrequencyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
