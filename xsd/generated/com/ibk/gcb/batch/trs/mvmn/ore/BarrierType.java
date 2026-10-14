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
 * <p>barrierType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="barrierType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UpAndOut"/>
 *     &lt;enumeration value="UpAndIn"/>
 *     &lt;enumeration value="DownAndOut"/>
 *     &lt;enumeration value="DownAndIn"/>
 *     &lt;enumeration value="KnockIn"/>
 *     &lt;enumeration value="KnockOut"/>
 *     &lt;enumeration value="CumulatedProfitCap"/>
 *     &lt;enumeration value="CumulatedProfitCapPoints"/>
 *     &lt;enumeration value="FixingCap"/>
 *     &lt;enumeration value="FixingFloor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "barrierType")
@XmlEnum
public enum BarrierType {

    @XmlEnumValue("UpAndOut")
    UP_AND_OUT("UpAndOut"),
    @XmlEnumValue("UpAndIn")
    UP_AND_IN("UpAndIn"),
    @XmlEnumValue("DownAndOut")
    DOWN_AND_OUT("DownAndOut"),
    @XmlEnumValue("DownAndIn")
    DOWN_AND_IN("DownAndIn"),
    @XmlEnumValue("KnockIn")
    KNOCK_IN("KnockIn"),
    @XmlEnumValue("KnockOut")
    KNOCK_OUT("KnockOut"),
    @XmlEnumValue("CumulatedProfitCap")
    CUMULATED_PROFIT_CAP("CumulatedProfitCap"),
    @XmlEnumValue("CumulatedProfitCapPoints")
    CUMULATED_PROFIT_CAP_POINTS("CumulatedProfitCapPoints"),
    @XmlEnumValue("FixingCap")
    FIXING_CAP("FixingCap"),
    @XmlEnumValue("FixingFloor")
    FIXING_FLOOR("FixingFloor");
    private final String value;

    BarrierType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BarrierType fromValue(String v) {
        for (BarrierType c: BarrierType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
