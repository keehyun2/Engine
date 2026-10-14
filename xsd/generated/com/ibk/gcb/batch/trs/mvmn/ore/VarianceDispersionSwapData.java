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
 * <p>varianceDispersionSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="varianceDispersionSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="Underlyings1" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="Weights1" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Strikes1" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Spreads1" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Notionals1" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Caps1" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Floors1" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Underlyings2" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="Weights2" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Strikes2" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Spreads2" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Notionals2" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Caps2" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Floors2" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="DividendAdjustment" type="{}stFreeStyleBool"/>
 *         &lt;element name="ValuationSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="SettlementDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="PayCcy" type="{}stFreeStyleCurrency"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "varianceDispersionSwapData", propOrder = {

})
public class VarianceDispersionSwapData {

    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "Underlyings1", required = true)
    protected StFreeStyleIndexVector underlyings1;
    @XmlElement(name = "Weights1", required = true)
    protected StFreeStyleNumberVector weights1;
    @XmlElement(name = "Strikes1", required = true)
    protected StFreeStyleNumberVector strikes1;
    @XmlElement(name = "Spreads1", required = true)
    protected StFreeStyleNumberVector spreads1;
    @XmlElement(name = "Notionals1", required = true)
    protected StFreeStyleNumberVector notionals1;
    @XmlElement(name = "Caps1", required = true)
    protected StFreeStyleNumberVector caps1;
    @XmlElement(name = "Floors1", required = true)
    protected StFreeStyleNumberVector floors1;
    @XmlElement(name = "Underlyings2", required = true)
    protected StFreeStyleIndexVector underlyings2;
    @XmlElement(name = "Weights2", required = true)
    protected StFreeStyleNumberVector weights2;
    @XmlElement(name = "Strikes2", required = true)
    protected StFreeStyleNumberVector strikes2;
    @XmlElement(name = "Spreads2", required = true)
    protected StFreeStyleNumberVector spreads2;
    @XmlElement(name = "Notionals2", required = true)
    protected StFreeStyleNumberVector notionals2;
    @XmlElement(name = "Caps2", required = true)
    protected StFreeStyleNumberVector caps2;
    @XmlElement(name = "Floors2", required = true)
    protected StFreeStyleNumberVector floors2;
    @XmlElement(name = "DividendAdjustment", required = true)
    protected StFreeStyleBool dividendAdjustment;
    @XmlElement(name = "ValuationSchedule", required = true)
    protected StFreeStyleEventSchedule valuationSchedule;
    @XmlElement(name = "SettlementDate", required = true)
    protected StFreeStyleEvent settlementDate;
    @XmlElement(name = "PayCcy", required = true)
    protected StFreeStyleCurrency payCcy;

    /**
     * longShort 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleLongShort }
     *     
     */
    public StFreeStyleLongShort getLongShort() {
        return longShort;
    }

    /**
     * longShort 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleLongShort }
     *     
     */
    public void setLongShort(StFreeStyleLongShort value) {
        this.longShort = value;
    }

    /**
     * underlyings1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndexVector }
     *     
     */
    public StFreeStyleIndexVector getUnderlyings1() {
        return underlyings1;
    }

    /**
     * underlyings1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndexVector }
     *     
     */
    public void setUnderlyings1(StFreeStyleIndexVector value) {
        this.underlyings1 = value;
    }

    /**
     * weights1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getWeights1() {
        return weights1;
    }

    /**
     * weights1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setWeights1(StFreeStyleNumberVector value) {
        this.weights1 = value;
    }

    /**
     * strikes1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getStrikes1() {
        return strikes1;
    }

    /**
     * strikes1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setStrikes1(StFreeStyleNumberVector value) {
        this.strikes1 = value;
    }

    /**
     * spreads1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getSpreads1() {
        return spreads1;
    }

    /**
     * spreads1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setSpreads1(StFreeStyleNumberVector value) {
        this.spreads1 = value;
    }

    /**
     * notionals1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getNotionals1() {
        return notionals1;
    }

    /**
     * notionals1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setNotionals1(StFreeStyleNumberVector value) {
        this.notionals1 = value;
    }

    /**
     * caps1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getCaps1() {
        return caps1;
    }

    /**
     * caps1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setCaps1(StFreeStyleNumberVector value) {
        this.caps1 = value;
    }

    /**
     * floors1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getFloors1() {
        return floors1;
    }

    /**
     * floors1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setFloors1(StFreeStyleNumberVector value) {
        this.floors1 = value;
    }

    /**
     * underlyings2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndexVector }
     *     
     */
    public StFreeStyleIndexVector getUnderlyings2() {
        return underlyings2;
    }

    /**
     * underlyings2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndexVector }
     *     
     */
    public void setUnderlyings2(StFreeStyleIndexVector value) {
        this.underlyings2 = value;
    }

    /**
     * weights2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getWeights2() {
        return weights2;
    }

    /**
     * weights2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setWeights2(StFreeStyleNumberVector value) {
        this.weights2 = value;
    }

    /**
     * strikes2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getStrikes2() {
        return strikes2;
    }

    /**
     * strikes2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setStrikes2(StFreeStyleNumberVector value) {
        this.strikes2 = value;
    }

    /**
     * spreads2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getSpreads2() {
        return spreads2;
    }

    /**
     * spreads2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setSpreads2(StFreeStyleNumberVector value) {
        this.spreads2 = value;
    }

    /**
     * notionals2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getNotionals2() {
        return notionals2;
    }

    /**
     * notionals2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setNotionals2(StFreeStyleNumberVector value) {
        this.notionals2 = value;
    }

    /**
     * caps2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getCaps2() {
        return caps2;
    }

    /**
     * caps2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setCaps2(StFreeStyleNumberVector value) {
        this.caps2 = value;
    }

    /**
     * floors2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getFloors2() {
        return floors2;
    }

    /**
     * floors2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setFloors2(StFreeStyleNumberVector value) {
        this.floors2 = value;
    }

    /**
     * dividendAdjustment 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getDividendAdjustment() {
        return dividendAdjustment;
    }

    /**
     * dividendAdjustment 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setDividendAdjustment(StFreeStyleBool value) {
        this.dividendAdjustment = value;
    }

    /**
     * valuationSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getValuationSchedule() {
        return valuationSchedule;
    }

    /**
     * valuationSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setValuationSchedule(StFreeStyleEventSchedule value) {
        this.valuationSchedule = value;
    }

    /**
     * settlementDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getSettlementDate() {
        return settlementDate;
    }

    /**
     * settlementDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setSettlementDate(StFreeStyleEvent value) {
        this.settlementDate = value;
    }

    /**
     * payCcy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public StFreeStyleCurrency getPayCcy() {
        return payCcy;
    }

    /**
     * payCcy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public void setPayCcy(StFreeStyleCurrency value) {
        this.payCcy = value;
    }

}
