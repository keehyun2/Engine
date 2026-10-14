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
 * <p>interpolationMethodType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="interpolationMethodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Linear"/>
 *     &lt;enumeration value="Flat"/>
 *     &lt;enumeration value="LogLinear"/>
 *     &lt;enumeration value="NaturalCubic"/>
 *     &lt;enumeration value="FinancialCubic"/>
 *     &lt;enumeration value="Cubic"/>
 *     &lt;enumeration value="Hermite"/>
 *     &lt;enumeration value="Quadratic"/>
 *     &lt;enumeration value="LogQuadratic"/>
 *     &lt;enumeration value="LogNaturalCubic"/>
 *     &lt;enumeration value="LogFinancialCubic"/>
 *     &lt;enumeration value="LogCubicSpline"/>
 *     &lt;enumeration value="MonotonicLogCubicSpline"/>
 *     &lt;enumeration value="CubicSpline"/>
 *     &lt;enumeration value="LinearFlat"/>
 *     &lt;enumeration value="LogLinearFlat"/>
 *     &lt;enumeration value="CubicFlat"/>
 *     &lt;enumeration value="HermiteFlat"/>
 *     &lt;enumeration value="ConvexMonotone"/>
 *     &lt;enumeration value="DefaultLogMixedLinearCubic"/>
 *     &lt;enumeration value="MonotonicLogMixedLinearCubic"/>
 *     &lt;enumeration value="KrugerLogMixedLinearCubic"/>
 *     &lt;enumeration value="LogMixedLinearCubicNaturalSpline"/>
 *     &lt;enumeration value="ExponentialSplines"/>
 *     &lt;enumeration value="NelsonSiegel"/>
 *     &lt;enumeration value="Svensson"/>
 *     &lt;enumeration value="BackwardFlat"/>
 *     &lt;enumeration value="ForwardFlat"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "interpolationMethodType")
@XmlEnum
public enum InterpolationMethodType {

    @XmlEnumValue("Linear")
    LINEAR("Linear"),
    @XmlEnumValue("Flat")
    FLAT("Flat"),
    @XmlEnumValue("LogLinear")
    LOG_LINEAR("LogLinear"),
    @XmlEnumValue("NaturalCubic")
    NATURAL_CUBIC("NaturalCubic"),
    @XmlEnumValue("FinancialCubic")
    FINANCIAL_CUBIC("FinancialCubic"),
    @XmlEnumValue("Cubic")
    CUBIC("Cubic"),
    @XmlEnumValue("Hermite")
    HERMITE("Hermite"),
    @XmlEnumValue("Quadratic")
    QUADRATIC("Quadratic"),
    @XmlEnumValue("LogQuadratic")
    LOG_QUADRATIC("LogQuadratic"),
    @XmlEnumValue("LogNaturalCubic")
    LOG_NATURAL_CUBIC("LogNaturalCubic"),
    @XmlEnumValue("LogFinancialCubic")
    LOG_FINANCIAL_CUBIC("LogFinancialCubic"),
    @XmlEnumValue("LogCubicSpline")
    LOG_CUBIC_SPLINE("LogCubicSpline"),
    @XmlEnumValue("MonotonicLogCubicSpline")
    MONOTONIC_LOG_CUBIC_SPLINE("MonotonicLogCubicSpline"),
    @XmlEnumValue("CubicSpline")
    CUBIC_SPLINE("CubicSpline"),
    @XmlEnumValue("LinearFlat")
    LINEAR_FLAT("LinearFlat"),
    @XmlEnumValue("LogLinearFlat")
    LOG_LINEAR_FLAT("LogLinearFlat"),
    @XmlEnumValue("CubicFlat")
    CUBIC_FLAT("CubicFlat"),
    @XmlEnumValue("HermiteFlat")
    HERMITE_FLAT("HermiteFlat"),
    @XmlEnumValue("ConvexMonotone")
    CONVEX_MONOTONE("ConvexMonotone"),
    @XmlEnumValue("DefaultLogMixedLinearCubic")
    DEFAULT_LOG_MIXED_LINEAR_CUBIC("DefaultLogMixedLinearCubic"),
    @XmlEnumValue("MonotonicLogMixedLinearCubic")
    MONOTONIC_LOG_MIXED_LINEAR_CUBIC("MonotonicLogMixedLinearCubic"),
    @XmlEnumValue("KrugerLogMixedLinearCubic")
    KRUGER_LOG_MIXED_LINEAR_CUBIC("KrugerLogMixedLinearCubic"),
    @XmlEnumValue("LogMixedLinearCubicNaturalSpline")
    LOG_MIXED_LINEAR_CUBIC_NATURAL_SPLINE("LogMixedLinearCubicNaturalSpline"),
    @XmlEnumValue("ExponentialSplines")
    EXPONENTIAL_SPLINES("ExponentialSplines"),
    @XmlEnumValue("NelsonSiegel")
    NELSON_SIEGEL("NelsonSiegel"),
    @XmlEnumValue("Svensson")
    SVENSSON("Svensson"),
    @XmlEnumValue("BackwardFlat")
    BACKWARD_FLAT("BackwardFlat"),
    @XmlEnumValue("ForwardFlat")
    FORWARD_FLAT("ForwardFlat");
    private final String value;

    InterpolationMethodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InterpolationMethodType fromValue(String v) {
        for (InterpolationMethodType c: InterpolationMethodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
