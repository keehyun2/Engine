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
 * <p>strikeResettableOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="strikeResettableOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="OptionType" type="{}stFreeStyleOptionType"/>
 *         &lt;element name="Currency" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="Strike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="ResetStrike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Quantity" type="{}stFreeStyleNumber"/>
 *         &lt;element name="TriggerType" type="{}stFreeStyleNumber"/>
 *         &lt;element name="TriggerPrice" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Underlying" type="{}stFreeStyleIndex"/>
 *         &lt;element name="ExpiryDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="SettlementDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="ObservationDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="Premium" type="{}stFreeStyleNumber"/>
 *         &lt;element name="PremiumDate" type="{}stFreeStyleEvent"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "strikeResettableOptionData", propOrder = {

})
public class StrikeResettableOptionData {

    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "OptionType", required = true)
    protected StFreeStyleOptionType optionType;
    @XmlElement(name = "Currency", required = true)
    protected StFreeStyleCurrency currency;
    @XmlElement(name = "Strike", required = true)
    protected StFreeStyleNumber strike;
    @XmlElement(name = "ResetStrike", required = true)
    protected StFreeStyleNumber resetStrike;
    @XmlElement(name = "Quantity", required = true)
    protected StFreeStyleNumber quantity;
    @XmlElement(name = "TriggerType", required = true)
    protected StFreeStyleNumber triggerType;
    @XmlElement(name = "TriggerPrice", required = true)
    protected StFreeStyleNumber triggerPrice;
    @XmlElement(name = "Underlying", required = true)
    protected StFreeStyleIndex underlying;
    @XmlElement(name = "ExpiryDate", required = true)
    protected StFreeStyleEvent expiryDate;
    @XmlElement(name = "SettlementDate", required = true)
    protected StFreeStyleEvent settlementDate;
    @XmlElement(name = "ObservationDates", required = true)
    protected StFreeStyleEventSchedule observationDates;
    @XmlElement(name = "Premium", required = true)
    protected StFreeStyleNumber premium;
    @XmlElement(name = "PremiumDate", required = true)
    protected StFreeStyleEvent premiumDate;

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
     * optionType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleOptionType }
     *     
     */
    public StFreeStyleOptionType getOptionType() {
        return optionType;
    }

    /**
     * optionType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleOptionType }
     *     
     */
    public void setOptionType(StFreeStyleOptionType value) {
        this.optionType = value;
    }

    /**
     * currency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public StFreeStyleCurrency getCurrency() {
        return currency;
    }

    /**
     * currency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public void setCurrency(StFreeStyleCurrency value) {
        this.currency = value;
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
     * resetStrike 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getResetStrike() {
        return resetStrike;
    }

    /**
     * resetStrike 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setResetStrike(StFreeStyleNumber value) {
        this.resetStrike = value;
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
     * triggerType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getTriggerType() {
        return triggerType;
    }

    /**
     * triggerType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setTriggerType(StFreeStyleNumber value) {
        this.triggerType = value;
    }

    /**
     * triggerPrice 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getTriggerPrice() {
        return triggerPrice;
    }

    /**
     * triggerPrice 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setTriggerPrice(StFreeStyleNumber value) {
        this.triggerPrice = value;
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
     * expiryDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getExpiryDate() {
        return expiryDate;
    }

    /**
     * expiryDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setExpiryDate(StFreeStyleEvent value) {
        this.expiryDate = value;
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
     * observationDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getObservationDates() {
        return observationDates;
    }

    /**
     * observationDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setObservationDates(StFreeStyleEventSchedule value) {
        this.observationDates = value;
    }

    /**
     * premium 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getPremium() {
        return premium;
    }

    /**
     * premium 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setPremium(StFreeStyleNumber value) {
        this.premium = value;
    }

    /**
     * premiumDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getPremiumDate() {
        return premiumDate;
    }

    /**
     * premiumDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setPremiumDate(StFreeStyleEvent value) {
        this.premiumDate = value;
    }

}
