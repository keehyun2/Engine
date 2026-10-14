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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>volatilityMoneynessSurfaceConfig complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="volatilityMoneynessSurfaceConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="QuoteType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VolatilityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExerciseType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MoneynessType" type="{}strikeMoneynessType"/>
 *         &lt;element name="MoneynessLevels" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TimeInterpolation" type="{}interpolationMethodType"/>
 *         &lt;element name="StrikeInterpolation" type="{}interpolationMethodType"/>
 *         &lt;element name="Extrapolation" type="{}bool"/>
 *         &lt;element name="TimeExtrapolation" type="{}extrapolationType"/>
 *         &lt;element name="TimeExtrapolationVariance" type="{}bool" minOccurs="0"/>
 *         &lt;element name="StrikeExtrapolation" type="{}extrapolationType"/>
 *         &lt;element name="FuturePriceCorrection" type="{}bool" minOccurs="0"/>
 *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
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
@XmlType(name = "volatilityMoneynessSurfaceConfig", propOrder = {

})
public class VolatilityMoneynessSurfaceConfig {

    @XmlElement(name = "QuoteType")
    protected String quoteType;
    @XmlElement(name = "VolatilityType")
    protected String volatilityType;
    @XmlElement(name = "ExerciseType")
    protected String exerciseType;
    @XmlElement(name = "MoneynessType", required = true)
    @XmlSchemaType(name = "string")
    protected StrikeMoneynessType moneynessType;
    @XmlElement(name = "MoneynessLevels", required = true)
    protected String moneynessLevels;
    @XmlElement(name = "Expiries", required = true)
    protected String expiries;
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
    @XmlElement(name = "FuturePriceCorrection")
    protected String futurePriceCorrection;
    @XmlElement(name = "Calendar")
    protected String calendar;
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
     * exerciseType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExerciseType() {
        return exerciseType;
    }

    /**
     * exerciseType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExerciseType(String value) {
        this.exerciseType = value;
    }

    /**
     * moneynessType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StrikeMoneynessType }
     *     
     */
    public StrikeMoneynessType getMoneynessType() {
        return moneynessType;
    }

    /**
     * moneynessType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StrikeMoneynessType }
     *     
     */
    public void setMoneynessType(StrikeMoneynessType value) {
        this.moneynessType = value;
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
     * expiries 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiries() {
        return expiries;
    }

    /**
     * expiries 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiries(String value) {
        this.expiries = value;
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
     * futurePriceCorrection 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuturePriceCorrection() {
        return futurePriceCorrection;
    }

    /**
     * futurePriceCorrection 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuturePriceCorrection(String value) {
        this.futurePriceCorrection = value;
    }

    /**
     * calendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalendar() {
        return calendar;
    }

    /**
     * calendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalendar(String value) {
        this.calendar = value;
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
