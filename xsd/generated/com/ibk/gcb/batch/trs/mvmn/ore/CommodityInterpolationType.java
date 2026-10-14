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
 * <p>commodityInterpolationType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="commodityInterpolationType">
 *   &lt;restriction base="{}interpolationMethodType">
 *     &lt;enumeration value="Linear"/>
 *     &lt;enumeration value="LogLinear"/>
 *     &lt;enumeration value="Cubic"/>
 *     &lt;enumeration value="Hermite"/>
 *     &lt;enumeration value="LinearFlat"/>
 *     &lt;enumeration value="LogLinearFlat"/>
 *     &lt;enumeration value="CubicFlat"/>
 *     &lt;enumeration value="HermiteFlat"/>
 *     &lt;enumeration value="BackwardFlat"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "commodityInterpolationType")
@XmlEnum(InterpolationMethodType.class)
public enum CommodityInterpolationType {

    @XmlEnumValue("Linear")
    LINEAR(InterpolationMethodType.LINEAR),
    @XmlEnumValue("LogLinear")
    LOG_LINEAR(InterpolationMethodType.LOG_LINEAR),
    @XmlEnumValue("Cubic")
    CUBIC(InterpolationMethodType.CUBIC),
    @XmlEnumValue("Hermite")
    HERMITE(InterpolationMethodType.HERMITE),
    @XmlEnumValue("LinearFlat")
    LINEAR_FLAT(InterpolationMethodType.LINEAR_FLAT),
    @XmlEnumValue("LogLinearFlat")
    LOG_LINEAR_FLAT(InterpolationMethodType.LOG_LINEAR_FLAT),
    @XmlEnumValue("CubicFlat")
    CUBIC_FLAT(InterpolationMethodType.CUBIC_FLAT),
    @XmlEnumValue("HermiteFlat")
    HERMITE_FLAT(InterpolationMethodType.HERMITE_FLAT),
    @XmlEnumValue("BackwardFlat")
    BACKWARD_FLAT(InterpolationMethodType.BACKWARD_FLAT);
    private final InterpolationMethodType value;

    CommodityInterpolationType(InterpolationMethodType v) {
        value = v;
    }

    public InterpolationMethodType value() {
        return value;
    }

    public static CommodityInterpolationType fromValue(InterpolationMethodType v) {
        for (CommodityInterpolationType c: CommodityInterpolationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
