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
 * <p>bestEntryOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="bestEntryOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="Strike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Notional" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Multiplier" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Cap" type="{}stFreeStyleNumber"/>
 *         &lt;element name="TriggerLevel" type="{}stFreeStyleNumber"/>
 *         &lt;element name="ResetMinimum" type="{}stFreeStyleNumber"/>
 *         &lt;element name="SettlementDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="PremiumDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="ExpiryDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="StrikeDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="Premium" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Underlying" type="{}stFreeStyleIndex"/>
 *         &lt;element name="StrikeObservationDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="Currency" type="{}stFreeStyleCurrency"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bestEntryOptionData", propOrder = {

})
public class BestEntryOptionData {

    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "Strike", required = true)
    protected StFreeStyleNumber strike;
    @XmlElement(name = "Notional", required = true)
    protected StFreeStyleNumber notional;
    @XmlElement(name = "Multiplier", required = true)
    protected StFreeStyleNumber multiplier;
    @XmlElement(name = "Cap", required = true)
    protected StFreeStyleNumber cap;
    @XmlElement(name = "TriggerLevel", required = true)
    protected StFreeStyleNumber triggerLevel;
    @XmlElement(name = "ResetMinimum", required = true)
    protected StFreeStyleNumber resetMinimum;
    @XmlElement(name = "SettlementDate", required = true)
    protected StFreeStyleEvent settlementDate;
    @XmlElement(name = "PremiumDate", required = true)
    protected StFreeStyleEvent premiumDate;
    @XmlElement(name = "ExpiryDate", required = true)
    protected StFreeStyleEvent expiryDate;
    @XmlElement(name = "StrikeDate", required = true)
    protected StFreeStyleEvent strikeDate;
    @XmlElement(name = "Premium", required = true)
    protected StFreeStyleNumber premium;
    @XmlElement(name = "Underlying", required = true)
    protected StFreeStyleIndex underlying;
    @XmlElement(name = "StrikeObservationDates", required = true)
    protected StFreeStyleEventSchedule strikeObservationDates;
    @XmlElement(name = "Currency", required = true)
    protected StFreeStyleCurrency currency;

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
     * multiplier 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getMultiplier() {
        return multiplier;
    }

    /**
     * multiplier 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setMultiplier(StFreeStyleNumber value) {
        this.multiplier = value;
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
     * triggerLevel 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getTriggerLevel() {
        return triggerLevel;
    }

    /**
     * triggerLevel 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setTriggerLevel(StFreeStyleNumber value) {
        this.triggerLevel = value;
    }

    /**
     * resetMinimum 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getResetMinimum() {
        return resetMinimum;
    }

    /**
     * resetMinimum 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setResetMinimum(StFreeStyleNumber value) {
        this.resetMinimum = value;
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
     * strikeDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getStrikeDate() {
        return strikeDate;
    }

    /**
     * strikeDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setStrikeDate(StFreeStyleEvent value) {
        this.strikeDate = value;
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
     * strikeObservationDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getStrikeObservationDates() {
        return strikeObservationDates;
    }

    /**
     * strikeObservationDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setStrikeObservationDates(StFreeStyleEventSchedule value) {
        this.strikeObservationDates = value;
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

}
