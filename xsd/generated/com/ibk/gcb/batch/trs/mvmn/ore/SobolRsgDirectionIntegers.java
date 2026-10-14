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
 * <p>SobolRsgDirectionIntegers에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="SobolRsgDirectionIntegers">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unit"/>
 *     &lt;enumeration value="Jaeckel"/>
 *     &lt;enumeration value="SobolLevitan"/>
 *     &lt;enumeration value="SobolLevitanLemieux"/>
 *     &lt;enumeration value="JoeKuoD5"/>
 *     &lt;enumeration value="JoeKuoD6"/>
 *     &lt;enumeration value="JoeKuoD7"/>
 *     &lt;enumeration value="Kuo"/>
 *     &lt;enumeration value="Kuo2"/>
 *     &lt;enumeration value="Kuo3"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SobolRsgDirectionIntegers")
@XmlEnum
public enum SobolRsgDirectionIntegers {

    @XmlEnumValue("Unit")
    UNIT("Unit"),
    @XmlEnumValue("Jaeckel")
    JAECKEL("Jaeckel"),
    @XmlEnumValue("SobolLevitan")
    SOBOL_LEVITAN("SobolLevitan"),
    @XmlEnumValue("SobolLevitanLemieux")
    SOBOL_LEVITAN_LEMIEUX("SobolLevitanLemieux"),
    @XmlEnumValue("JoeKuoD5")
    JOE_KUO_D_5("JoeKuoD5"),
    @XmlEnumValue("JoeKuoD6")
    JOE_KUO_D_6("JoeKuoD6"),
    @XmlEnumValue("JoeKuoD7")
    JOE_KUO_D_7("JoeKuoD7"),
    @XmlEnumValue("Kuo")
    KUO("Kuo"),
    @XmlEnumValue("Kuo2")
    KUO_2("Kuo2"),
    @XmlEnumValue("Kuo3")
    KUO_3("Kuo3");
    private final String value;

    SobolRsgDirectionIntegers(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SobolRsgDirectionIntegers fromValue(String v) {
        for (SobolRsgDirectionIntegers c: SobolRsgDirectionIntegers.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
