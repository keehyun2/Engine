//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>yieldCurve complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="yieldCurve">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="DiscountCurve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Segments" type="{}segmentsType"/>
 *         &lt;element name="InterpolationVariable" type="{}interpolationVariableType" minOccurs="0"/>
 *         &lt;element name="InterpolationMethod" type="{}interpolationMethodType" minOccurs="0"/>
 *         &lt;element name="MixedInterpolationCutoff" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="YieldCurveDayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="Tolerance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Extrapolation" type="{}bool" minOccurs="0"/>
 *         &lt;element name="ExtrapolationMethod" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="ContinuousForward"/>
 *               &lt;enumeration value="DiscreteForward"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ExcludeT0FromInterpolation" type="{}bool" minOccurs="0"/>
 *         &lt;element name="BootstrapConfig" type="{}bootstrapConfigType" minOccurs="0"/>
 *         &lt;element name="Report" type="{}yieldCurveReport" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "yieldCurve", propOrder = {

})
public class YieldCurve {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "DiscountCurve", required = true)
    protected String discountCurve;
    @XmlElement(name = "Segments", required = true)
    protected SegmentsType segments;
    @XmlElement(name = "InterpolationVariable")
    @XmlSchemaType(name = "string")
    protected InterpolationVariableType interpolationVariable;
    @XmlElement(name = "InterpolationMethod")
    @XmlSchemaType(name = "string")
    protected InterpolationMethodType interpolationMethod;
    @XmlElement(name = "MixedInterpolationCutoff")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger mixedInterpolationCutoff;
    @XmlElement(name = "YieldCurveDayCounter")
    protected String yieldCurveDayCounter;
    @XmlElement(name = "Tolerance")
    protected Double tolerance;
    @XmlElement(name = "Extrapolation")
    protected String extrapolation;
    @XmlElement(name = "ExtrapolationMethod")
    protected String extrapolationMethod;
    @XmlElement(name = "ExcludeT0FromInterpolation")
    protected String excludeT0FromInterpolation;
    @XmlElement(name = "BootstrapConfig")
    protected BootstrapConfigType bootstrapConfig;
    @XmlElement(name = "Report")
    protected YieldCurveReport report;

    /**
     * curveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurveId() {
        return curveId;
    }

    /**
     * curveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurveId(String value) {
        this.curveId = value;
    }

    /**
     * curveDescription 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurveDescription() {
        return curveDescription;
    }

    /**
     * curveDescription 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurveDescription(String value) {
        this.curveDescription = value;
    }

    /**
     * currency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getCurrency() {
        return currency;
    }

    /**
     * currency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setCurrency(CurrencyCode value) {
        this.currency = value;
    }

    /**
     * discountCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountCurve() {
        return discountCurve;
    }

    /**
     * discountCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountCurve(String value) {
        this.discountCurve = value;
    }

    /**
     * segments 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SegmentsType }
     *     
     */
    public SegmentsType getSegments() {
        return segments;
    }

    /**
     * segments 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SegmentsType }
     *     
     */
    public void setSegments(SegmentsType value) {
        this.segments = value;
    }

    /**
     * interpolationVariable 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link InterpolationVariableType }
     *     
     */
    public InterpolationVariableType getInterpolationVariable() {
        return interpolationVariable;
    }

    /**
     * interpolationVariable 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link InterpolationVariableType }
     *     
     */
    public void setInterpolationVariable(InterpolationVariableType value) {
        this.interpolationVariable = value;
    }

    /**
     * interpolationMethod 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link InterpolationMethodType }
     *     
     */
    public InterpolationMethodType getInterpolationMethod() {
        return interpolationMethod;
    }

    /**
     * interpolationMethod 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link InterpolationMethodType }
     *     
     */
    public void setInterpolationMethod(InterpolationMethodType value) {
        this.interpolationMethod = value;
    }

    /**
     * mixedInterpolationCutoff 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMixedInterpolationCutoff() {
        return mixedInterpolationCutoff;
    }

    /**
     * mixedInterpolationCutoff 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMixedInterpolationCutoff(BigInteger value) {
        this.mixedInterpolationCutoff = value;
    }

    /**
     * yieldCurveDayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYieldCurveDayCounter() {
        return yieldCurveDayCounter;
    }

    /**
     * yieldCurveDayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYieldCurveDayCounter(String value) {
        this.yieldCurveDayCounter = value;
    }

    /**
     * tolerance 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTolerance() {
        return tolerance;
    }

    /**
     * tolerance 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTolerance(Double value) {
        this.tolerance = value;
    }

    /**
     * extrapolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtrapolation() {
        return extrapolation;
    }

    /**
     * extrapolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtrapolation(String value) {
        this.extrapolation = value;
    }

    /**
     * extrapolationMethod 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtrapolationMethod() {
        return extrapolationMethod;
    }

    /**
     * extrapolationMethod 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtrapolationMethod(String value) {
        this.extrapolationMethod = value;
    }

    /**
     * excludeT0FromInterpolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExcludeT0FromInterpolation() {
        return excludeT0FromInterpolation;
    }

    /**
     * excludeT0FromInterpolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExcludeT0FromInterpolation(String value) {
        this.excludeT0FromInterpolation = value;
    }

    /**
     * bootstrapConfig 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BootstrapConfigType }
     *     
     */
    public BootstrapConfigType getBootstrapConfig() {
        return bootstrapConfig;
    }

    /**
     * bootstrapConfig 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BootstrapConfigType }
     *     
     */
    public void setBootstrapConfig(BootstrapConfigType value) {
        this.bootstrapConfig = value;
    }

    /**
     * report 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link YieldCurveReport }
     *     
     */
    public YieldCurveReport getReport() {
        return report;
    }

    /**
     * report 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link YieldCurveReport }
     *     
     */
    public void setReport(YieldCurveReport value) {
        this.report = value;
    }

}
