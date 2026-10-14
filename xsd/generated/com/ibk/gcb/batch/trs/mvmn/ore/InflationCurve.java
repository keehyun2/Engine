//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>inflationCurve complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="inflationCurve">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NominalTermStructure" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type" type="{}inflationType"/>
 *         &lt;element name="Quotes" type="{}quoteType" minOccurs="0"/>
 *         &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Segments" type="{}inflSegmentsType" minOccurs="0"/>
 *         &lt;element name="Extrapolation" type="{}bool" minOccurs="0"/>
 *         &lt;element name="Calendar" type="{}calendar"/>
 *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="Lag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Frequency" type="{}frequencyType"/>
 *         &lt;element name="BaseRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tolerance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Seasonality" type="{}seasonalityType" minOccurs="0"/>
 *         &lt;element name="UseLastFixingDate" type="{}bool" minOccurs="0"/>
 *         &lt;element name="InterpolationVariable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InterpolationMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inflationCurve", propOrder = {

})
public class InflationCurve {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "NominalTermStructure", required = true)
    protected String nominalTermStructure;
    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected InflationType type;
    @XmlElement(name = "Quotes")
    protected QuoteType quotes;
    @XmlElement(name = "Conventions")
    protected String conventions;
    @XmlElement(name = "Segments")
    protected InflSegmentsType segments;
    @XmlElement(name = "Extrapolation")
    protected String extrapolation;
    @XmlElement(name = "Calendar", required = true)
    protected String calendar;
    @XmlElement(name = "DayCounter")
    protected String dayCounter;
    @XmlElement(name = "Lag", required = true)
    protected String lag;
    @XmlElement(name = "Frequency", required = true)
    @XmlSchemaType(name = "string")
    protected FrequencyType frequency;
    @XmlElement(name = "BaseRate")
    protected String baseRate;
    @XmlElement(name = "Tolerance")
    protected Double tolerance;
    @XmlElement(name = "Seasonality")
    protected SeasonalityType seasonality;
    @XmlElement(name = "UseLastFixingDate")
    protected String useLastFixingDate;
    @XmlElement(name = "InterpolationVariable")
    protected String interpolationVariable;
    @XmlElement(name = "InterpolationMethod")
    protected String interpolationMethod;

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
     * nominalTermStructure 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNominalTermStructure() {
        return nominalTermStructure;
    }

    /**
     * nominalTermStructure 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNominalTermStructure(String value) {
        this.nominalTermStructure = value;
    }

    /**
     * type 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link InflationType }
     *     
     */
    public InflationType getType() {
        return type;
    }

    /**
     * type 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link InflationType }
     *     
     */
    public void setType(InflationType value) {
        this.type = value;
    }

    /**
     * quotes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link QuoteType }
     *     
     */
    public QuoteType getQuotes() {
        return quotes;
    }

    /**
     * quotes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link QuoteType }
     *     
     */
    public void setQuotes(QuoteType value) {
        this.quotes = value;
    }

    /**
     * conventions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConventions() {
        return conventions;
    }

    /**
     * conventions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConventions(String value) {
        this.conventions = value;
    }

    /**
     * segments 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link InflSegmentsType }
     *     
     */
    public InflSegmentsType getSegments() {
        return segments;
    }

    /**
     * segments 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link InflSegmentsType }
     *     
     */
    public void setSegments(InflSegmentsType value) {
        this.segments = value;
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
     * dayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayCounter() {
        return dayCounter;
    }

    /**
     * dayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayCounter(String value) {
        this.dayCounter = value;
    }

    /**
     * lag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLag() {
        return lag;
    }

    /**
     * lag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLag(String value) {
        this.lag = value;
    }

    /**
     * frequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyType }
     *     
     */
    public FrequencyType getFrequency() {
        return frequency;
    }

    /**
     * frequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyType }
     *     
     */
    public void setFrequency(FrequencyType value) {
        this.frequency = value;
    }

    /**
     * baseRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseRate() {
        return baseRate;
    }

    /**
     * baseRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseRate(String value) {
        this.baseRate = value;
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
     * seasonality 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SeasonalityType }
     *     
     */
    public SeasonalityType getSeasonality() {
        return seasonality;
    }

    /**
     * seasonality 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SeasonalityType }
     *     
     */
    public void setSeasonality(SeasonalityType value) {
        this.seasonality = value;
    }

    /**
     * useLastFixingDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseLastFixingDate() {
        return useLastFixingDate;
    }

    /**
     * useLastFixingDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseLastFixingDate(String value) {
        this.useLastFixingDate = value;
    }

    /**
     * interpolationVariable 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterpolationVariable() {
        return interpolationVariable;
    }

    /**
     * interpolationVariable 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterpolationVariable(String value) {
        this.interpolationVariable = value;
    }

    /**
     * interpolationMethod 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterpolationMethod() {
        return interpolationMethod;
    }

    /**
     * interpolationMethod 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterpolationMethod(String value) {
        this.interpolationMethod = value;
    }

}
