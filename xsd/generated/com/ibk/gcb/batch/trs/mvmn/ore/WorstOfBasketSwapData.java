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
 * <p>worstOfBasketSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="worstOfBasketSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="Quantity" type="{}stFreeStyleNumber"/>
 *         &lt;element name="InitialFixedRate" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Underlyings" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="InitialPrices" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="DeterminationDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="SettlementDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="KnockOutLevels" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="CouponTriggerLevels" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="KnockInLevel" type="{}stFreeStyleNumber"/>
 *         &lt;element name="CouponRate" type="{}stFreeStyleNumber"/>
 *         &lt;element name="AccumulatingCoupons" type="{}stFreeStyleBool"/>
 *         &lt;element name="FloatingIndex" type="{}stFreeStyleIndex"/>
 *         &lt;element name="FloatingSpread" type="{}stFreeStyleNumber"/>
 *         &lt;element name="FloatingDayCountFraction" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="FixingSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="Strike" type="{}stFreeStyleNumber"/>
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
@XmlType(name = "worstOfBasketSwapData", propOrder = {

})
public class WorstOfBasketSwapData {

    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "Quantity", required = true)
    protected StFreeStyleNumber quantity;
    @XmlElement(name = "InitialFixedRate", required = true)
    protected StFreeStyleNumber initialFixedRate;
    @XmlElement(name = "Underlyings", required = true)
    protected StFreeStyleIndexVector underlyings;
    @XmlElement(name = "InitialPrices", required = true)
    protected StFreeStyleNumberVector initialPrices;
    @XmlElement(name = "DeterminationDates", required = true)
    protected StFreeStyleEventSchedule determinationDates;
    @XmlElement(name = "SettlementDates", required = true)
    protected StFreeStyleEventSchedule settlementDates;
    @XmlElement(name = "KnockOutLevels", required = true)
    protected StFreeStyleNumberVector knockOutLevels;
    @XmlElement(name = "CouponTriggerLevels", required = true)
    protected StFreeStyleNumberVector couponTriggerLevels;
    @XmlElement(name = "KnockInLevel", required = true)
    protected StFreeStyleNumber knockInLevel;
    @XmlElement(name = "CouponRate", required = true)
    protected StFreeStyleNumber couponRate;
    @XmlElement(name = "AccumulatingCoupons", required = true)
    protected StFreeStyleBool accumulatingCoupons;
    @XmlElement(name = "FloatingIndex", required = true)
    protected StFreeStyleIndex floatingIndex;
    @XmlElement(name = "FloatingSpread", required = true)
    protected StFreeStyleNumber floatingSpread;
    @XmlElement(name = "FloatingDayCountFraction", required = true)
    protected StFreeStyleDayCounter floatingDayCountFraction;
    @XmlElement(name = "FixingSchedule", required = true)
    protected StFreeStyleEventSchedule fixingSchedule;
    @XmlElement(name = "Strike", required = true)
    protected StFreeStyleNumber strike;
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
     * quantity 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getQuantity() {
        return quantity;
    }

    /**
     * quantity 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setQuantity(StFreeStyleNumber value) {
        this.quantity = value;
    }

    /**
     * initialFixedRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getInitialFixedRate() {
        return initialFixedRate;
    }

    /**
     * initialFixedRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setInitialFixedRate(StFreeStyleNumber value) {
        this.initialFixedRate = value;
    }

    /**
     * underlyings 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndexVector }
     *     
     */
    public StFreeStyleIndexVector getUnderlyings() {
        return underlyings;
    }

    /**
     * underlyings 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndexVector }
     *     
     */
    public void setUnderlyings(StFreeStyleIndexVector value) {
        this.underlyings = value;
    }

    /**
     * initialPrices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getInitialPrices() {
        return initialPrices;
    }

    /**
     * initialPrices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setInitialPrices(StFreeStyleNumberVector value) {
        this.initialPrices = value;
    }

    /**
     * determinationDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getDeterminationDates() {
        return determinationDates;
    }

    /**
     * determinationDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setDeterminationDates(StFreeStyleEventSchedule value) {
        this.determinationDates = value;
    }

    /**
     * settlementDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getSettlementDates() {
        return settlementDates;
    }

    /**
     * settlementDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setSettlementDates(StFreeStyleEventSchedule value) {
        this.settlementDates = value;
    }

    /**
     * knockOutLevels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getKnockOutLevels() {
        return knockOutLevels;
    }

    /**
     * knockOutLevels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setKnockOutLevels(StFreeStyleNumberVector value) {
        this.knockOutLevels = value;
    }

    /**
     * couponTriggerLevels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getCouponTriggerLevels() {
        return couponTriggerLevels;
    }

    /**
     * couponTriggerLevels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setCouponTriggerLevels(StFreeStyleNumberVector value) {
        this.couponTriggerLevels = value;
    }

    /**
     * knockInLevel 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getKnockInLevel() {
        return knockInLevel;
    }

    /**
     * knockInLevel 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setKnockInLevel(StFreeStyleNumber value) {
        this.knockInLevel = value;
    }

    /**
     * couponRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getCouponRate() {
        return couponRate;
    }

    /**
     * couponRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setCouponRate(StFreeStyleNumber value) {
        this.couponRate = value;
    }

    /**
     * accumulatingCoupons 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getAccumulatingCoupons() {
        return accumulatingCoupons;
    }

    /**
     * accumulatingCoupons 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setAccumulatingCoupons(StFreeStyleBool value) {
        this.accumulatingCoupons = value;
    }

    /**
     * floatingIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public StFreeStyleIndex getFloatingIndex() {
        return floatingIndex;
    }

    /**
     * floatingIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public void setFloatingIndex(StFreeStyleIndex value) {
        this.floatingIndex = value;
    }

    /**
     * floatingSpread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getFloatingSpread() {
        return floatingSpread;
    }

    /**
     * floatingSpread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setFloatingSpread(StFreeStyleNumber value) {
        this.floatingSpread = value;
    }

    /**
     * floatingDayCountFraction 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public StFreeStyleDayCounter getFloatingDayCountFraction() {
        return floatingDayCountFraction;
    }

    /**
     * floatingDayCountFraction 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public void setFloatingDayCountFraction(StFreeStyleDayCounter value) {
        this.floatingDayCountFraction = value;
    }

    /**
     * fixingSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getFixingSchedule() {
        return fixingSchedule;
    }

    /**
     * fixingSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setFixingSchedule(StFreeStyleEventSchedule value) {
        this.fixingSchedule = value;
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
