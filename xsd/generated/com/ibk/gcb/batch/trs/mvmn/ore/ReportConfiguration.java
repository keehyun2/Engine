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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>reportConfiguration complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="reportConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ReportOnDeltaGrid" type="{}bool" minOccurs="0"/>
 *         &lt;element name="ReportOnMoneynessGrid" type="{}bool" minOccurs="0"/>
 *         &lt;element name="ReportOnStrikeGrid" type="{}bool" minOccurs="0"/>
 *         &lt;element name="ReportOnStrikeSpreadGrid" type="{}bool" minOccurs="0"/>
 *         &lt;element name="Deltas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Moneyness" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StrikeSpreads" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PillarDates" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnderlyingTenors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContinuationExpiry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reportConfiguration", propOrder = {

})
public class ReportConfiguration {

    @XmlElement(name = "ReportOnDeltaGrid")
    protected String reportOnDeltaGrid;
    @XmlElement(name = "ReportOnMoneynessGrid")
    protected String reportOnMoneynessGrid;
    @XmlElement(name = "ReportOnStrikeGrid")
    protected String reportOnStrikeGrid;
    @XmlElement(name = "ReportOnStrikeSpreadGrid")
    protected String reportOnStrikeSpreadGrid;
    @XmlElement(name = "Deltas")
    protected String deltas;
    @XmlElement(name = "Moneyness")
    protected String moneyness;
    @XmlElement(name = "Strikes")
    protected String strikes;
    @XmlElement(name = "StrikeSpreads")
    protected String strikeSpreads;
    @XmlElement(name = "Expiries")
    protected String expiries;
    @XmlElement(name = "PillarDates")
    protected String pillarDates;
    @XmlElement(name = "UnderlyingTenors")
    protected String underlyingTenors;
    @XmlElement(name = "ContinuationExpiry")
    protected String continuationExpiry;

    /**
     * reportOnDeltaGrid 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportOnDeltaGrid() {
        return reportOnDeltaGrid;
    }

    /**
     * reportOnDeltaGrid 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportOnDeltaGrid(String value) {
        this.reportOnDeltaGrid = value;
    }

    /**
     * reportOnMoneynessGrid 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportOnMoneynessGrid() {
        return reportOnMoneynessGrid;
    }

    /**
     * reportOnMoneynessGrid 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportOnMoneynessGrid(String value) {
        this.reportOnMoneynessGrid = value;
    }

    /**
     * reportOnStrikeGrid 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportOnStrikeGrid() {
        return reportOnStrikeGrid;
    }

    /**
     * reportOnStrikeGrid 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportOnStrikeGrid(String value) {
        this.reportOnStrikeGrid = value;
    }

    /**
     * reportOnStrikeSpreadGrid 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportOnStrikeSpreadGrid() {
        return reportOnStrikeSpreadGrid;
    }

    /**
     * reportOnStrikeSpreadGrid 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportOnStrikeSpreadGrid(String value) {
        this.reportOnStrikeSpreadGrid = value;
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
     * moneyness 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoneyness() {
        return moneyness;
    }

    /**
     * moneyness 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoneyness(String value) {
        this.moneyness = value;
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
     * strikeSpreads 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrikeSpreads() {
        return strikeSpreads;
    }

    /**
     * strikeSpreads 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrikeSpreads(String value) {
        this.strikeSpreads = value;
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
     * pillarDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPillarDates() {
        return pillarDates;
    }

    /**
     * pillarDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPillarDates(String value) {
        this.pillarDates = value;
    }

    /**
     * underlyingTenors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnderlyingTenors() {
        return underlyingTenors;
    }

    /**
     * underlyingTenors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnderlyingTenors(String value) {
        this.underlyingTenors = value;
    }

    /**
     * continuationExpiry 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContinuationExpiry() {
        return continuationExpiry;
    }

    /**
     * continuationExpiry 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContinuationExpiry(String value) {
        this.continuationExpiry = value;
    }

}
