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
 * <p>europeanOptionBarrierData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="europeanOptionBarrierData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="PutCall" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LongShort" type="{}longShort"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="PremiumAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="PremiumCurrency" type="{}currencyCode"/>
 *         &lt;element name="PremiumDate" type="{}date"/>
 *         &lt;element name="Premiums" type="{}premiumData" minOccurs="0"/>
 *         &lt;element name="OptionExpiry" type="{}date"/>
 *         &lt;element name="OptionUnderlying" type="{}underlying"/>
 *         &lt;element name="BarrierUnderlying" type="{}underlying"/>
 *         &lt;element name="BarrierLevel" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="BarrierType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BarrierStyle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BarrierSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="SettlementDate" type="{}date"/>
 *         &lt;element name="PayCcy" type="{}currencyCode"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "europeanOptionBarrierData", propOrder = {

})
public class EuropeanOptionBarrierData {

    @XmlElement(name = "Quantity")
    protected float quantity;
    @XmlElement(name = "PutCall", required = true)
    protected String putCall;
    @XmlElement(name = "LongShort", required = true)
    @XmlSchemaType(name = "string")
    protected LongShort longShort;
    @XmlElement(name = "Strike")
    protected float strike;
    @XmlElement(name = "PremiumAmount")
    protected float premiumAmount;
    @XmlElement(name = "PremiumCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode premiumCurrency;
    @XmlElement(name = "PremiumDate", required = true)
    protected String premiumDate;
    @XmlElement(name = "Premiums")
    protected PremiumData premiums;
    @XmlElement(name = "OptionExpiry", required = true)
    protected String optionExpiry;
    @XmlElement(name = "OptionUnderlying", required = true)
    protected Underlying optionUnderlying;
    @XmlElement(name = "BarrierUnderlying", required = true)
    protected Underlying barrierUnderlying;
    @XmlElement(name = "BarrierLevel")
    protected float barrierLevel;
    @XmlElement(name = "BarrierType", required = true)
    protected String barrierType;
    @XmlElement(name = "BarrierStyle", required = true)
    protected String barrierStyle;
    @XmlElement(name = "BarrierSchedule")
    protected ScheduleData barrierSchedule;
    @XmlElement(name = "SettlementDate", required = true)
    protected String settlementDate;
    @XmlElement(name = "PayCcy", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode payCcy;

    /**
     * quantity 속성의 값을 가져옵니다.
     * 
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     * quantity 속성의 값을 설정합니다.
     * 
     */
    public void setQuantity(float value) {
        this.quantity = value;
    }

    /**
     * putCall 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPutCall() {
        return putCall;
    }

    /**
     * putCall 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPutCall(String value) {
        this.putCall = value;
    }

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
     * premiumAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getPremiumAmount() {
        return premiumAmount;
    }

    /**
     * premiumAmount 속성의 값을 설정합니다.
     * 
     */
    public void setPremiumAmount(float value) {
        this.premiumAmount = value;
    }

    /**
     * premiumCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getPremiumCurrency() {
        return premiumCurrency;
    }

    /**
     * premiumCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setPremiumCurrency(CurrencyCode value) {
        this.premiumCurrency = value;
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
     * premiums 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PremiumData }
     *     
     */
    public PremiumData getPremiums() {
        return premiums;
    }

    /**
     * premiums 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PremiumData }
     *     
     */
    public void setPremiums(PremiumData value) {
        this.premiums = value;
    }

    /**
     * optionExpiry 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionExpiry() {
        return optionExpiry;
    }

    /**
     * optionExpiry 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionExpiry(String value) {
        this.optionExpiry = value;
    }

    /**
     * optionUnderlying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getOptionUnderlying() {
        return optionUnderlying;
    }

    /**
     * optionUnderlying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setOptionUnderlying(Underlying value) {
        this.optionUnderlying = value;
    }

    /**
     * barrierUnderlying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getBarrierUnderlying() {
        return barrierUnderlying;
    }

    /**
     * barrierUnderlying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setBarrierUnderlying(Underlying value) {
        this.barrierUnderlying = value;
    }

    /**
     * barrierLevel 속성의 값을 가져옵니다.
     * 
     */
    public float getBarrierLevel() {
        return barrierLevel;
    }

    /**
     * barrierLevel 속성의 값을 설정합니다.
     * 
     */
    public void setBarrierLevel(float value) {
        this.barrierLevel = value;
    }

    /**
     * barrierType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarrierType() {
        return barrierType;
    }

    /**
     * barrierType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarrierType(String value) {
        this.barrierType = value;
    }

    /**
     * barrierStyle 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarrierStyle() {
        return barrierStyle;
    }

    /**
     * barrierStyle 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarrierStyle(String value) {
        this.barrierStyle = value;
    }

    /**
     * barrierSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getBarrierSchedule() {
        return barrierSchedule;
    }

    /**
     * barrierSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setBarrierSchedule(ScheduleData value) {
        this.barrierSchedule = value;
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
     * payCcy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getPayCcy() {
        return payCcy;
    }

    /**
     * payCcy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setPayCcy(CurrencyCode value) {
        this.payCcy = value;
    }

}
