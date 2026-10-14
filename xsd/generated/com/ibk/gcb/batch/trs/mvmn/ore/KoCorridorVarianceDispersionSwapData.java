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
 * <p>koCorridorVarianceDispersionSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="koCorridorVarianceDispersionSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="Weights" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Underlyings1" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="Strikes1" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Spreads1" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Notionals1" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Caps1" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Floors1" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Underlyings2" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="Strikes2" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Spreads2" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Notionals2" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Caps2" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Floors2" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="CorridorUpperBarrierLevels" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="CorridorLowerBarrierLevels" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="KOUpperBarrierLevels" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="KOLowerBarrierLevels" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="CountBothObservations" type="{}stFreeStyleBool"/>
 *         &lt;element name="AccrualAdjustment" type="{}stFreeStyleBool"/>
 *         &lt;element name="DividendAdjustment" type="{}stFreeStyleBool"/>
 *         &lt;element name="KnockOutSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="VarianceAccrualStartDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="SettlementSchedule" type="{}stFreeStyleEventSchedule"/>
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
@XmlType(name = "koCorridorVarianceDispersionSwapData", propOrder = {

})
public class KoCorridorVarianceDispersionSwapData {

    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "Weights", required = true)
    protected StFreeStyleNumberVector weights;
    @XmlElement(name = "Underlyings1", required = true)
    protected StFreeStyleIndexVector underlyings1;
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
    @XmlElement(name = "CorridorUpperBarrierLevels", required = true)
    protected StFreeStyleNumberVector corridorUpperBarrierLevels;
    @XmlElement(name = "CorridorLowerBarrierLevels", required = true)
    protected StFreeStyleNumberVector corridorLowerBarrierLevels;
    @XmlElement(name = "KOUpperBarrierLevels", required = true)
    protected StFreeStyleNumberVector koUpperBarrierLevels;
    @XmlElement(name = "KOLowerBarrierLevels", required = true)
    protected StFreeStyleNumberVector koLowerBarrierLevels;
    @XmlElement(name = "CountBothObservations", required = true)
    protected StFreeStyleBool countBothObservations;
    @XmlElement(name = "AccrualAdjustment", required = true)
    protected StFreeStyleBool accrualAdjustment;
    @XmlElement(name = "DividendAdjustment", required = true)
    protected StFreeStyleBool dividendAdjustment;
    @XmlElement(name = "KnockOutSchedule", required = true)
    protected StFreeStyleEventSchedule knockOutSchedule;
    @XmlElement(name = "VarianceAccrualStartDate", required = true)
    protected StFreeStyleEvent varianceAccrualStartDate;
    @XmlElement(name = "SettlementSchedule", required = true)
    protected StFreeStyleEventSchedule settlementSchedule;
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
     * weights 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getWeights() {
        return weights;
    }

    /**
     * weights 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setWeights(StFreeStyleNumberVector value) {
        this.weights = value;
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
     * corridorUpperBarrierLevels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getCorridorUpperBarrierLevels() {
        return corridorUpperBarrierLevels;
    }

    /**
     * corridorUpperBarrierLevels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setCorridorUpperBarrierLevels(StFreeStyleNumberVector value) {
        this.corridorUpperBarrierLevels = value;
    }

    /**
     * corridorLowerBarrierLevels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getCorridorLowerBarrierLevels() {
        return corridorLowerBarrierLevels;
    }

    /**
     * corridorLowerBarrierLevels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setCorridorLowerBarrierLevels(StFreeStyleNumberVector value) {
        this.corridorLowerBarrierLevels = value;
    }

    /**
     * koUpperBarrierLevels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getKOUpperBarrierLevels() {
        return koUpperBarrierLevels;
    }

    /**
     * koUpperBarrierLevels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setKOUpperBarrierLevels(StFreeStyleNumberVector value) {
        this.koUpperBarrierLevels = value;
    }

    /**
     * koLowerBarrierLevels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getKOLowerBarrierLevels() {
        return koLowerBarrierLevels;
    }

    /**
     * koLowerBarrierLevels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setKOLowerBarrierLevels(StFreeStyleNumberVector value) {
        this.koLowerBarrierLevels = value;
    }

    /**
     * countBothObservations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getCountBothObservations() {
        return countBothObservations;
    }

    /**
     * countBothObservations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setCountBothObservations(StFreeStyleBool value) {
        this.countBothObservations = value;
    }

    /**
     * accrualAdjustment 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getAccrualAdjustment() {
        return accrualAdjustment;
    }

    /**
     * accrualAdjustment 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setAccrualAdjustment(StFreeStyleBool value) {
        this.accrualAdjustment = value;
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
     * knockOutSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getKnockOutSchedule() {
        return knockOutSchedule;
    }

    /**
     * knockOutSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setKnockOutSchedule(StFreeStyleEventSchedule value) {
        this.knockOutSchedule = value;
    }

    /**
     * varianceAccrualStartDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getVarianceAccrualStartDate() {
        return varianceAccrualStartDate;
    }

    /**
     * varianceAccrualStartDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setVarianceAccrualStartDate(StFreeStyleEvent value) {
        this.varianceAccrualStartDate = value;
    }

    /**
     * settlementSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getSettlementSchedule() {
        return settlementSchedule;
    }

    /**
     * settlementSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setSettlementSchedule(StFreeStyleEventSchedule value) {
        this.settlementSchedule = value;
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
