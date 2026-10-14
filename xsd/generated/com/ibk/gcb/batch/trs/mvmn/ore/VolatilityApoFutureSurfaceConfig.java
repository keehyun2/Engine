//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>volatilityApoFutureSurfaceConfig complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="volatilityApoFutureSurfaceConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="QuoteType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VolatilityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MoneynessLevels" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VolatilityId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PriceCurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FutureConventions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TimeInterpolation" type="{}interpolationMethodType"/>
 *         &lt;element name="StrikeInterpolation" type="{}interpolationMethodType"/>
 *         &lt;element name="Extrapolation" type="{}bool"/>
 *         &lt;element name="TimeExtrapolation" type="{}extrapolationType"/>
 *         &lt;element name="TimeExtrapolationVariance" type="{}bool" minOccurs="0"/>
 *         &lt;element name="StrikeExtrapolation" type="{}extrapolationType"/>
 *         &lt;element name="MaxTenor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Beta" type="{}non-negative-decimal" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "volatilityApoFutureSurfaceConfig", propOrder = {

})
public class VolatilityApoFutureSurfaceConfig {

    @XmlElement(name = "QuoteType")
    protected String quoteType;
    @XmlElement(name = "VolatilityType")
    protected String volatilityType;
    @XmlElement(name = "MoneynessLevels", required = true)
    protected String moneynessLevels;
    @XmlElement(name = "VolatilityId", required = true)
    protected String volatilityId;
    @XmlElement(name = "PriceCurveId", required = true)
    protected String priceCurveId;
    @XmlElement(name = "FutureConventions", required = true)
    protected String futureConventions;
    @XmlElement(name = "TimeInterpolation", required = true)
    @XmlSchemaType(name = "string")
    protected InterpolationMethodType timeInterpolation;
    @XmlElement(name = "StrikeInterpolation", required = true)
    @XmlSchemaType(name = "string")
    protected InterpolationMethodType strikeInterpolation;
    @XmlElement(name = "Extrapolation", required = true)
    protected String extrapolation;
    @XmlElement(name = "TimeExtrapolation", required = true)
    @XmlSchemaType(name = "string")
    protected ExtrapolationType timeExtrapolation;
    @XmlElement(name = "TimeExtrapolationVariance")
    protected String timeExtrapolationVariance;
    @XmlElement(name = "StrikeExtrapolation", required = true)
    @XmlSchemaType(name = "string")
    protected ExtrapolationType strikeExtrapolation;
    @XmlElement(name = "MaxTenor")
    protected String maxTenor;
    @XmlElement(name = "Beta")
    protected BigDecimal beta;
    @XmlAttribute(name = "priority")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger priority;

    /**
     * quoteType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuoteType() {
        return quoteType;
    }

    /**
     * quoteType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuoteType(String value) {
        this.quoteType = value;
    }

    /**
     * volatilityType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVolatilityType() {
        return volatilityType;
    }

    /**
     * volatilityType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolatilityType(String value) {
        this.volatilityType = value;
    }

    /**
     * moneynessLevels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoneynessLevels() {
        return moneynessLevels;
    }

    /**
     * moneynessLevels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoneynessLevels(String value) {
        this.moneynessLevels = value;
    }

    /**
     * volatilityId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVolatilityId() {
        return volatilityId;
    }

    /**
     * volatilityId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolatilityId(String value) {
        this.volatilityId = value;
    }

    /**
     * priceCurveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceCurveId() {
        return priceCurveId;
    }

    /**
     * priceCurveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceCurveId(String value) {
        this.priceCurveId = value;
    }

    /**
     * futureConventions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFutureConventions() {
        return futureConventions;
    }

    /**
     * futureConventions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFutureConventions(String value) {
        this.futureConventions = value;
    }

    /**
     * timeInterpolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link InterpolationMethodType }
     *     
     */
    public InterpolationMethodType getTimeInterpolation() {
        return timeInterpolation;
    }

    /**
     * timeInterpolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link InterpolationMethodType }
     *     
     */
    public void setTimeInterpolation(InterpolationMethodType value) {
        this.timeInterpolation = value;
    }

    /**
     * strikeInterpolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link InterpolationMethodType }
     *     
     */
    public InterpolationMethodType getStrikeInterpolation() {
        return strikeInterpolation;
    }

    /**
     * strikeInterpolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link InterpolationMethodType }
     *     
     */
    public void setStrikeInterpolation(InterpolationMethodType value) {
        this.strikeInterpolation = value;
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
     * timeExtrapolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ExtrapolationType }
     *     
     */
    public ExtrapolationType getTimeExtrapolation() {
        return timeExtrapolation;
    }

    /**
     * timeExtrapolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtrapolationType }
     *     
     */
    public void setTimeExtrapolation(ExtrapolationType value) {
        this.timeExtrapolation = value;
    }

    /**
     * timeExtrapolationVariance 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeExtrapolationVariance() {
        return timeExtrapolationVariance;
    }

    /**
     * timeExtrapolationVariance 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeExtrapolationVariance(String value) {
        this.timeExtrapolationVariance = value;
    }

    /**
     * strikeExtrapolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ExtrapolationType }
     *     
     */
    public ExtrapolationType getStrikeExtrapolation() {
        return strikeExtrapolation;
    }

    /**
     * strikeExtrapolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtrapolationType }
     *     
     */
    public void setStrikeExtrapolation(ExtrapolationType value) {
        this.strikeExtrapolation = value;
    }

    /**
     * maxTenor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxTenor() {
        return maxTenor;
    }

    /**
     * maxTenor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxTenor(String value) {
        this.maxTenor = value;
    }

    /**
     * beta 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBeta() {
        return beta;
    }

    /**
     * beta 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBeta(BigDecimal value) {
        this.beta = value;
    }

    /**
     * priority 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPriority() {
        return priority;
    }

    /**
     * priority 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPriority(BigInteger value) {
        this.priority = value;
    }

}
