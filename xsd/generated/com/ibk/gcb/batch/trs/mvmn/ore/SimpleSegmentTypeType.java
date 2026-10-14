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
 * <p>simpleSegmentTypeType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="simpleSegmentTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Deposit"/>
 *     &lt;enumeration value="FRA"/>
 *     &lt;enumeration value="Future"/>
 *     &lt;enumeration value="OIS"/>
 *     &lt;enumeration value="Swap"/>
 *     &lt;enumeration value="BMA Basis Swap"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "simpleSegmentTypeType")
@XmlEnum
public enum SimpleSegmentTypeType {

    @XmlEnumValue("Deposit")
    DEPOSIT("Deposit"),
    FRA("FRA"),
    @XmlEnumValue("Future")
    FUTURE("Future"),
    OIS("OIS"),
    @XmlEnumValue("Swap")
    SWAP("Swap"),
    @XmlEnumValue("BMA Basis Swap")
    BMA_BASIS_SWAP("BMA Basis Swap");
    private final String value;

    SimpleSegmentTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SimpleSegmentTypeType fromValue(String v) {
        for (SimpleSegmentTypeType c: SimpleSegmentTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
