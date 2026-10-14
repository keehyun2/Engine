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
 * <p>kikoCorridorVarianceSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="kikoCorridorVarianceSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="Strike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Notional" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Underlying" type="{}stFreeStyleIndex"/>
 *         &lt;element name="ValuationSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="CorridorUpperBarrierLevel" type="{}stFreeStyleNumber"/>
 *         &lt;element name="CorridorLowerBarrierLevel" type="{}stFreeStyleNumber"/>
 *         &lt;element name="KIKOBarrierType" type="{}stFreeStyleBarrierType"/>
 *         &lt;element name="KIKOBarrierLevel" type="{}stFreeStyleNumber"/>
 *         &lt;element name="CountBothObservations" type="{}stFreeStyleBool"/>
 *         &lt;element name="AccrualAdjustment" type="{}stFreeStyleBool"/>
 *         &lt;element name="Cap" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Floor" type="{}stFreeStyleNumber"/>
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
@XmlType(name = "kikoCorridorVarianceSwapData", propOrder = {

})
public class KikoCorridorVarianceSwapData {

    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "Strike", required = true)
    protected StFreeStyleNumber strike;
    @XmlElement(name = "Notional", required = true)
    protected StFreeStyleNumber notional;
    @XmlElement(name = "Underlying", required = true)
    protected StFreeStyleIndex underlying;
    @XmlElement(name = "ValuationSchedule", required = true)
    protected StFreeStyleEventSchedule valuationSchedule;
    @XmlElement(name = "CorridorUpperBarrierLevel", required = true)
    protected StFreeStyleNumber corridorUpperBarrierLevel;
    @XmlElement(name = "CorridorLowerBarrierLevel", required = true)
    protected StFreeStyleNumber corridorLowerBarrierLevel;
    @XmlElement(name = "KIKOBarrierType", required = true)
    protected StFreeStyleBarrierType kikoBarrierType;
    @XmlElement(name = "KIKOBarrierLevel", required = true)
    protected StFreeStyleNumber kikoBarrierLevel;
    @XmlElement(name = "CountBothObservations", required = true)
    protected StFreeStyleBool countBothObservations;
    @XmlElement(name = "AccrualAdjustment", required = true)
    protected StFreeStyleBool accrualAdjustment;
    @XmlElement(name = "Cap", required = true)
    protected StFreeStyleNumber cap;
    @XmlElement(name = "Floor", required = true)
    protected StFreeStyleNumber floor;
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
     * strike 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getStrike() {
        return strike;
    }

    /**
     * strike 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setStrike(StFreeStyleNumber value) {
        this.strike = value;
    }

    /**
     * notional 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getNotional() {
        return notional;
    }

    /**
     * notional 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setNotional(StFreeStyleNumber value) {
        this.notional = value;
    }

    /**
     * underlying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public StFreeStyleIndex getUnderlying() {
        return underlying;
    }

    /**
     * underlying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public void setUnderlying(StFreeStyleIndex value) {
        this.underlying = value;
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
     * corridorUpperBarrierLevel 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getCorridorUpperBarrierLevel() {
        return corridorUpperBarrierLevel;
    }

    /**
     * corridorUpperBarrierLevel 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setCorridorUpperBarrierLevel(StFreeStyleNumber value) {
        this.corridorUpperBarrierLevel = value;
    }

    /**
     * corridorLowerBarrierLevel 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getCorridorLowerBarrierLevel() {
        return corridorLowerBarrierLevel;
    }

    /**
     * corridorLowerBarrierLevel 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setCorridorLowerBarrierLevel(StFreeStyleNumber value) {
        this.corridorLowerBarrierLevel = value;
    }

    /**
     * kikoBarrierType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBarrierType }
     *     
     */
    public StFreeStyleBarrierType getKIKOBarrierType() {
        return kikoBarrierType;
    }

    /**
     * kikoBarrierType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBarrierType }
     *     
     */
    public void setKIKOBarrierType(StFreeStyleBarrierType value) {
        this.kikoBarrierType = value;
    }

    /**
     * kikoBarrierLevel 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getKIKOBarrierLevel() {
        return kikoBarrierLevel;
    }

    /**
     * kikoBarrierLevel 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setKIKOBarrierLevel(StFreeStyleNumber value) {
        this.kikoBarrierLevel = value;
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
     * cap 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getCap() {
        return cap;
    }

    /**
     * cap 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setCap(StFreeStyleNumber value) {
        this.cap = value;
    }

    /**
     * floor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getFloor() {
        return floor;
    }

    /**
     * floor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setFloor(StFreeStyleNumber value) {
        this.floor = value;
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
