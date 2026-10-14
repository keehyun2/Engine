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
 * <p>bestEntryOptionData2 complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="bestEntryOptionData2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{}longShort"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="Notional" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Multiplier" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Cap" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="TriggerLevel" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="ResetMinimum" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Premium" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="ExpiryDate" type="{}date"/>
 *         &lt;element name="StrikeDate" type="{}date"/>
 *         &lt;element name="PremiumDate" type="{}date"/>
 *         &lt;element name="SettlementDate" type="{}date"/>
 *         &lt;element name="StrikeObservationDates" type="{}scheduleData"/>
 *         &lt;element name="Underlying" type="{}underlying"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bestEntryOptionData2", propOrder = {

})
public class BestEntryOptionData2 {

    @XmlElement(name = "LongShort", required = true)
    @XmlSchemaType(name = "string")
    protected LongShort longShort;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "Notional")
    protected float notional;
    @XmlElement(name = "Multiplier")
    protected float multiplier;
    @XmlElement(name = "Cap")
    protected float cap;
    @XmlElement(name = "Strike")
    protected float strike;
    @XmlElement(name = "TriggerLevel")
    protected float triggerLevel;
    @XmlElement(name = "ResetMinimum")
    protected float resetMinimum;
    @XmlElement(name = "Premium")
    protected float premium;
    @XmlElement(name = "ExpiryDate", required = true)
    protected String expiryDate;
    @XmlElement(name = "StrikeDate", required = true)
    protected String strikeDate;
    @XmlElement(name = "PremiumDate", required = true)
    protected String premiumDate;
    @XmlElement(name = "SettlementDate", required = true)
    protected String settlementDate;
    @XmlElement(name = "StrikeObservationDates", required = true)
    protected ScheduleData strikeObservationDates;
    @XmlElement(name = "Underlying", required = true)
    protected Underlying underlying;

    /**
     * longShort 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LongShort }
     *     
     */
    public LongShort getLongShort() {
        return longShort;
    }

    /**
     * longShort 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LongShort }
     *     
     */
    public void setLongShort(LongShort value) {
        this.longShort = value;
    }

    /**
     * currency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getCurrency() {
        return currency;
    }

    /**
     * currency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setCurrency(CurrencyCode value) {
        this.currency = value;
    }

    /**
     * notional 속성의 값을 가져옵니다.
     * 
     */
    public float getNotional() {
        return notional;
    }

    /**
     * notional 속성의 값을 설정합니다.
     * 
     */
    public void setNotional(float value) {
        this.notional = value;
    }

    /**
     * multiplier 속성의 값을 가져옵니다.
     * 
     */
    public float getMultiplier() {
        return multiplier;
    }

    /**
     * multiplier 속성의 값을 설정합니다.
     * 
     */
    public void setMultiplier(float value) {
        this.multiplier = value;
    }

    /**
     * cap 속성의 값을 가져옵니다.
     * 
     */
    public float getCap() {
        return cap;
    }

    /**
     * cap 속성의 값을 설정합니다.
     * 
     */
    public void setCap(float value) {
        this.cap = value;
    }

    /**
     * strike 속성의 값을 가져옵니다.
     * 
     */
    public float getStrike() {
        return strike;
    }

    /**
     * strike 속성의 값을 설정합니다.
     * 
     */
    public void setStrike(float value) {
        this.strike = value;
    }

    /**
     * triggerLevel 속성의 값을 가져옵니다.
     * 
     */
    public float getTriggerLevel() {
        return triggerLevel;
    }

    /**
     * triggerLevel 속성의 값을 설정합니다.
     * 
     */
    public void setTriggerLevel(float value) {
        this.triggerLevel = value;
    }

    /**
     * resetMinimum 속성의 값을 가져옵니다.
     * 
     */
    public float getResetMinimum() {
        return resetMinimum;
    }

    /**
     * resetMinimum 속성의 값을 설정합니다.
     * 
     */
    public void setResetMinimum(float value) {
        this.resetMinimum = value;
    }

    /**
     * premium 속성의 값을 가져옵니다.
     * 
     */
    public float getPremium() {
        return premium;
    }

    /**
     * premium 속성의 값을 설정합니다.
     * 
     */
    public void setPremium(float value) {
        this.premium = value;
    }

    /**
     * expiryDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * expiryDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * strikeDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrikeDate() {
        return strikeDate;
    }

    /**
     * strikeDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrikeDate(String value) {
        this.strikeDate = value;
    }

    /**
     * premiumDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiumDate() {
        return premiumDate;
    }

    /**
     * premiumDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiumDate(String value) {
        this.premiumDate = value;
    }

    /**
     * settlementDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementDate() {
        return settlementDate;
    }

    /**
     * settlementDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementDate(String value) {
        this.settlementDate = value;
    }

    /**
     * strikeObservationDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getStrikeObservationDates() {
        return strikeObservationDates;
    }

    /**
     * strikeObservationDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setStrikeObservationDates(ScheduleData value) {
        this.strikeObservationDates = value;
    }

    /**
     * underlying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getUnderlying() {
        return underlying;
    }

    /**
     * underlying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setUnderlying(Underlying value) {
        this.underlying = value;
    }

}
