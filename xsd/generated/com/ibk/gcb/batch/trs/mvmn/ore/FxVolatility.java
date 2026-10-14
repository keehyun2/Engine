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
 * <p>fxVolatility complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="fxVolatility">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Dimension" type="{}dimensionType"/>
 *         &lt;element name="SmileType" type="{}smileType" minOccurs="0"/>
 *         &lt;element name="SmileInterpolation" type="{}fxVolInterpolation" minOccurs="0"/>
 *         &lt;element name="Deltas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SmileDelta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FXSpotID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FXForeignCurveID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FXDomesticCurveID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="FXIndexTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BaseVolatility1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BaseVolatility2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
 *         &lt;element name="SmileExtrapolation" type="{}extrapolationType" minOccurs="0"/>
 *         &lt;element name="TimeInterpolation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeWeighting" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ButterflyErrorTolerance" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fxVolatility", propOrder = {

})
public class FxVolatility {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "Dimension", required = true)
    @XmlSchemaType(name = "string")
    protected DimensionType dimension;
    @XmlElement(name = "SmileType")
    @XmlSchemaType(name = "string")
    protected SmileType smileType;
    @XmlElement(name = "SmileInterpolation")
    protected String smileInterpolation;
    @XmlElement(name = "Deltas")
    protected String deltas;
    @XmlElement(name = "SmileDelta")
    protected String smileDelta;
    @XmlElement(name = "Conventions")
    protected String conventions;
    @XmlElement(name = "Expiries")
    protected String expiries;
    @XmlElement(name = "FXSpotID")
    protected String fxSpotID;
    @XmlElement(name = "FXForeignCurveID")
    protected String fxForeignCurveID;
    @XmlElement(name = "FXDomesticCurveID")
    protected String fxDomesticCurveID;
    @XmlElement(name = "Calendar")
    protected String calendar;
    @XmlElement(name = "DayCounter")
    protected String dayCounter;
    @XmlElement(name = "FXIndexTag")
    protected String fxIndexTag;
    @XmlElement(name = "BaseVolatility1")
    protected String baseVolatility1;
    @XmlElement(name = "BaseVolatility2")
    protected String baseVolatility2;
    @XmlElement(name = "Report")
    protected ReportConfiguration report;
    @XmlElement(name = "SmileExtrapolation")
    @XmlSchemaType(name = "string")
    protected ExtrapolationType smileExtrapolation;
    @XmlElement(name = "TimeInterpolation")
    protected String timeInterpolation;
    @XmlElement(name = "TimeWeighting")
    protected String timeWeighting;
    @XmlElement(name = "ButterflyErrorTolerance")
    protected Float butterflyErrorTolerance;

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
     * dimension 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DimensionType }
     *     
     */
    public DimensionType getDimension() {
        return dimension;
    }

    /**
     * dimension 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DimensionType }
     *     
     */
    public void setDimension(DimensionType value) {
        this.dimension = value;
    }

    /**
     * smileType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SmileType }
     *     
     */
    public SmileType getSmileType() {
        return smileType;
    }

    /**
     * smileType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SmileType }
     *     
     */
    public void setSmileType(SmileType value) {
        this.smileType = value;
    }

    /**
     * smileInterpolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmileInterpolation() {
        return smileInterpolation;
    }

    /**
     * smileInterpolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmileInterpolation(String value) {
        this.smileInterpolation = value;
    }

    /**
     * deltas 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeltas() {
        return deltas;
    }

    /**
     * deltas 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeltas(String value) {
        this.deltas = value;
    }

    /**
     * smileDelta 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmileDelta() {
        return smileDelta;
    }

    /**
     * smileDelta 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmileDelta(String value) {
        this.smileDelta = value;
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
     * fxSpotID 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFXSpotID() {
        return fxSpotID;
    }

    /**
     * fxSpotID 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXSpotID(String value) {
        this.fxSpotID = value;
    }

    /**
     * fxForeignCurveID 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFXForeignCurveID() {
        return fxForeignCurveID;
    }

    /**
     * fxForeignCurveID 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXForeignCurveID(String value) {
        this.fxForeignCurveID = value;
    }

    /**
     * fxDomesticCurveID 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFXDomesticCurveID() {
        return fxDomesticCurveID;
    }

    /**
     * fxDomesticCurveID 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXDomesticCurveID(String value) {
        this.fxDomesticCurveID = value;
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
     * fxIndexTag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFXIndexTag() {
        return fxIndexTag;
    }

    /**
     * fxIndexTag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXIndexTag(String value) {
        this.fxIndexTag = value;
    }

    /**
     * baseVolatility1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseVolatility1() {
        return baseVolatility1;
    }

    /**
     * baseVolatility1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseVolatility1(String value) {
        this.baseVolatility1 = value;
    }

    /**
     * baseVolatility2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseVolatility2() {
        return baseVolatility2;
    }

    /**
     * baseVolatility2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseVolatility2(String value) {
        this.baseVolatility2 = value;
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
     * smileExtrapolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ExtrapolationType }
     *     
     */
    public ExtrapolationType getSmileExtrapolation() {
        return smileExtrapolation;
    }

    /**
     * smileExtrapolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtrapolationType }
     *     
     */
    public void setSmileExtrapolation(ExtrapolationType value) {
        this.smileExtrapolation = value;
    }

    /**
     * timeInterpolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeInterpolation() {
        return timeInterpolation;
    }

    /**
     * timeInterpolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeInterpolation(String value) {
        this.timeInterpolation = value;
    }

    /**
     * timeWeighting 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeWeighting() {
        return timeWeighting;
    }

    /**
     * timeWeighting 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeWeighting(String value) {
        this.timeWeighting = value;
    }

    /**
     * butterflyErrorTolerance 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getButterflyErrorTolerance() {
        return butterflyErrorTolerance;
    }

    /**
     * butterflyErrorTolerance 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setButterflyErrorTolerance(Float value) {
        this.butterflyErrorTolerance = value;
    }

}
