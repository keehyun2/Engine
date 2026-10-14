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
 * <p>equityCurve complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="equityCurve">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{}extendedCurrencyCode"/>
 *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="ForecastingCurve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type" type="{}equityType"/>
 *         &lt;element name="ExerciseStyle" type="{}exerciseStyle" minOccurs="0"/>
 *         &lt;element name="SpotQuote" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Quotes" type="{}quoteType" minOccurs="0"/>
 *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="DividendInterpolation" type="{}dividendInterpolation" minOccurs="0"/>
 *         &lt;element name="DividendExtrapolation" type="{}bool" minOccurs="0"/>
 *         &lt;element name="Extrapolation" type="{}bool" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "equityCurve", propOrder = {

})
public class EquityCurve {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "Currency", required = true)
    protected String currency;
    @XmlElement(name = "Calendar")
    protected String calendar;
    @XmlElement(name = "ForecastingCurve", required = true)
    protected String forecastingCurve;
    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected EquityType type;
    @XmlElement(name = "ExerciseStyle")
    @XmlSchemaType(name = "string")
    protected ExerciseStyle exerciseStyle;
    @XmlElement(name = "SpotQuote", required = true)
    protected String spotQuote;
    @XmlElement(name = "Quotes")
    protected QuoteType quotes;
    @XmlElement(name = "DayCounter")
    protected String dayCounter;
    @XmlElement(name = "DividendInterpolation")
    protected DividendInterpolation dividendInterpolation;
    @XmlElement(name = "DividendExtrapolation")
    protected String dividendExtrapolation;
    @XmlElement(name = "Extrapolation")
    protected String extrapolation;

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
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * currency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
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
     * forecastingCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForecastingCurve() {
        return forecastingCurve;
    }

    /**
     * forecastingCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForecastingCurve(String value) {
        this.forecastingCurve = value;
    }

    /**
     * type 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EquityType }
     *     
     */
    public EquityType getType() {
        return type;
    }

    /**
     * type 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EquityType }
     *     
     */
    public void setType(EquityType value) {
        this.type = value;
    }

    /**
     * exerciseStyle 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ExerciseStyle }
     *     
     */
    public ExerciseStyle getExerciseStyle() {
        return exerciseStyle;
    }

    /**
     * exerciseStyle 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ExerciseStyle }
     *     
     */
    public void setExerciseStyle(ExerciseStyle value) {
        this.exerciseStyle = value;
    }

    /**
     * spotQuote 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpotQuote() {
        return spotQuote;
    }

    /**
     * spotQuote 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpotQuote(String value) {
        this.spotQuote = value;
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
     * dividendInterpolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DividendInterpolation }
     *     
     */
    public DividendInterpolation getDividendInterpolation() {
        return dividendInterpolation;
    }

    /**
     * dividendInterpolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DividendInterpolation }
     *     
     */
    public void setDividendInterpolation(DividendInterpolation value) {
        this.dividendInterpolation = value;
    }

    /**
     * dividendExtrapolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDividendExtrapolation() {
        return dividendExtrapolation;
    }

    /**
     * dividendExtrapolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDividendExtrapolation(String value) {
        this.dividendExtrapolation = value;
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

}
