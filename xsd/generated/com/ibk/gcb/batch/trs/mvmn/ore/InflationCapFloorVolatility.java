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
 * <p>inflationCapFloorVolatility complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="inflationCapFloorVolatility">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type" type="{}inflationType"/>
 *         &lt;element name="QuoteType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VolatilityType" type="{}volatilityType"/>
 *         &lt;element name="Extrapolation" type="{}bool"/>
 *         &lt;element name="Tenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SettlementDays" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="CapStrikes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FloorStrikes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Calendar" type="{}calendar"/>
 *         &lt;element name="DayCounter" type="{}dayCounter"/>
 *         &lt;element name="BusinessDayConvention" type="{}businessDayConvention"/>
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IndexCurve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IndexInterpolated" type="{}bool" minOccurs="0"/>
 *         &lt;element name="ObservationLag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="YieldTermStructure" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="QuoteIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UseLastFixingDate" type="{}bool" minOccurs="0"/>
 *         &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
 *         &lt;element name="BootstrapConfig" type="{}bootstrapConfigType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inflationCapFloorVolatility", propOrder = {

})
public class InflationCapFloorVolatility {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected InflationType type;
    @XmlElement(name = "QuoteType", required = true)
    protected String quoteType;
    @XmlElement(name = "VolatilityType", required = true)
    @XmlSchemaType(name = "string")
    protected VolatilityType volatilityType;
    @XmlElement(name = "Extrapolation", required = true)
    protected String extrapolation;
    @XmlElement(name = "Tenors", required = true)
    protected String tenors;
    @XmlElement(name = "SettlementDays")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger settlementDays;
    @XmlElement(name = "CapStrikes")
    protected String capStrikes;
    @XmlElement(name = "FloorStrikes")
    protected String floorStrikes;
    @XmlElement(name = "Strikes")
    protected String strikes;
    @XmlElement(name = "Calendar", required = true)
    protected String calendar;
    @XmlElement(name = "DayCounter", required = true)
    protected String dayCounter;
    @XmlElement(name = "BusinessDayConvention", required = true)
    protected String businessDayConvention;
    @XmlElement(name = "Index", required = true)
    protected String index;
    @XmlElement(name = "IndexCurve", required = true)
    protected String indexCurve;
    @XmlElement(name = "IndexInterpolated")
    protected String indexInterpolated;
    @XmlElement(name = "ObservationLag", required = true)
    protected String observationLag;
    @XmlElement(name = "YieldTermStructure", required = true)
    protected String yieldTermStructure;
    @XmlElement(name = "QuoteIndex")
    protected String quoteIndex;
    @XmlElement(name = "Conventions")
    protected String conventions;
    @XmlElement(name = "UseLastFixingDate")
    protected String useLastFixingDate;
    @XmlElement(name = "Report")
    protected ReportConfiguration report;
    @XmlElement(name = "BootstrapConfig")
    protected BootstrapConfigType bootstrapConfig;

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
     *     {@link VolatilityType }
     *     
     */
    public VolatilityType getVolatilityType() {
        return volatilityType;
    }

    /**
     * volatilityType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolatilityType }
     *     
     */
    public void setVolatilityType(VolatilityType value) {
        this.volatilityType = value;
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
     * tenors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenors() {
        return tenors;
    }

    /**
     * tenors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenors(String value) {
        this.tenors = value;
    }

    /**
     * settlementDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSettlementDays() {
        return settlementDays;
    }

    /**
     * settlementDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSettlementDays(BigInteger value) {
        this.settlementDays = value;
    }

    /**
     * capStrikes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapStrikes() {
        return capStrikes;
    }

    /**
     * capStrikes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapStrikes(String value) {
        this.capStrikes = value;
    }

    /**
     * floorStrikes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloorStrikes() {
        return floorStrikes;
    }

    /**
     * floorStrikes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloorStrikes(String value) {
        this.floorStrikes = value;
    }

    /**
     * strikes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrikes() {
        return strikes;
    }

    /**
     * strikes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrikes(String value) {
        this.strikes = value;
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
     * businessDayConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessDayConvention() {
        return businessDayConvention;
    }

    /**
     * businessDayConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessDayConvention(String value) {
        this.businessDayConvention = value;
    }

    /**
     * index 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndex() {
        return index;
    }

    /**
     * index 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndex(String value) {
        this.index = value;
    }

    /**
     * indexCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexCurve() {
        return indexCurve;
    }

    /**
     * indexCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexCurve(String value) {
        this.indexCurve = value;
    }

    /**
     * indexInterpolated 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexInterpolated() {
        return indexInterpolated;
    }

    /**
     * indexInterpolated 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexInterpolated(String value) {
        this.indexInterpolated = value;
    }

    /**
     * observationLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservationLag() {
        return observationLag;
    }

    /**
     * observationLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservationLag(String value) {
        this.observationLag = value;
    }

    /**
     * yieldTermStructure 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYieldTermStructure() {
        return yieldTermStructure;
    }

    /**
     * yieldTermStructure 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYieldTermStructure(String value) {
        this.yieldTermStructure = value;
    }

    /**
     * quoteIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuoteIndex() {
        return quoteIndex;
    }

    /**
     * quoteIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuoteIndex(String value) {
        this.quoteIndex = value;
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
     * report 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ReportConfiguration }
     *     
     */
    public ReportConfiguration getReport() {
        return report;
    }

    /**
     * report 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportConfiguration }
     *     
     */
    public void setReport(ReportConfiguration value) {
        this.report = value;
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

}
