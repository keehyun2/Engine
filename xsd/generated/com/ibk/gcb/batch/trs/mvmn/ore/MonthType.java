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
 * <p>monthType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="monthType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Jan"/>
 *     &lt;enumeration value="Feb"/>
 *     &lt;enumeration value="Mar"/>
 *     &lt;enumeration value="Apr"/>
 *     &lt;enumeration value="May"/>
 *     &lt;enumeration value="Jun"/>
 *     &lt;enumeration value="Jul"/>
 *     &lt;enumeration value="Aug"/>
 *     &lt;enumeration value="Sep"/>
 *     &lt;enumeration value="Oct"/>
 *     &lt;enumeration value="Nov"/>
 *     &lt;enumeration value="Dec"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "monthType")
@XmlEnum
public enum MonthType {

    @XmlEnumValue("Jan")
    JAN("Jan"),
    @XmlEnumValue("Feb")
    FEB("Feb"),
    @XmlEnumValue("Mar")
    MAR("Mar"),
    @XmlEnumValue("Apr")
    APR("Apr"),
    @XmlEnumValue("May")
    MAY("May"),
    @XmlEnumValue("Jun")
    JUN("Jun"),
    @XmlEnumValue("Jul")
    JUL("Jul"),
    @XmlEnumValue("Aug")
    AUG("Aug"),
    @XmlEnumValue("Sep")
    SEP("Sep"),
    @XmlEnumValue("Oct")
    OCT("Oct"),
    @XmlEnumValue("Nov")
    NOV("Nov"),
    @XmlEnumValue("Dec")
    DEC("Dec");
    private final String value;

    MonthType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MonthType fromValue(String v) {
        for (MonthType c: MonthType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
