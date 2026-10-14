//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cliquetOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="cliquetOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element ref="{}underlyingTypes"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="Notional" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="LongShort" type="{}longShort"/>
 *         &lt;element name="OptionType" type="{}optionType"/>
 *         &lt;element name="Moneyness" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="LocalCap" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="LocalFloor" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="GlobalCap" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="GlobalFloor" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ScheduleData" type="{}scheduleData"/>
 *         &lt;element name="SettlementDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Premium" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="PremiumPaymentDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="PremiumCurrency" type="{}currencyCode" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cliquetOptionData", propOrder = {

})
public class CliquetOptionData {

    @XmlElementRef(name = "underlyingTypes", type = JAXBElement.class)
    protected JAXBElement<?> underlyingTypes;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "Notional")
    protected float notional;
    @XmlElement(name = "LongShort", required = true)
    @XmlSchemaType(name = "string")
    protected LongShort longShort;
    @XmlElement(name = "OptionType", required = true)
    @XmlSchemaType(name = "string")
    protected OptionType optionType;
    @XmlElement(name = "Moneyness")
    protected float moneyness;
    @XmlElement(name = "LocalCap")
    protected Float localCap;
    @XmlElement(name = "LocalFloor")
    protected Float localFloor;
    @XmlElement(name = "GlobalCap")
    protected Float globalCap;
    @XmlElement(name = "GlobalFloor")
    protected Float globalFloor;
    @XmlElement(name = "ScheduleData", required = true)
    protected ScheduleData scheduleData;
    @XmlElement(name = "SettlementDays")
    protected BigInteger settlementDays;
    @XmlElement(name = "Premium")
    protected Float premium;
    @XmlElement(name = "PremiumPaymentDate")
    protected String premiumPaymentDate;
    @XmlElement(name = "PremiumCurrency")
    @XmlSchemaType(name = "string")
    protected CurrencyCode premiumCurrency;

    /**
     * underlyingTypes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlying }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlyings }{@code >}
     *     
     */
    public JAXBElement<?> getUnderlyingTypes() {
        return underlyingTypes;
    }

    /**
     * underlyingTypes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlying }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlyings }{@code >}
     *     
     */
    public void setUnderlyingTypes(JAXBElement<?> value) {
        this.underlyingTypes = value;
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
     * optionType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OptionType }
     *     
     */
    public OptionType getOptionType() {
        return optionType;
    }

    /**
     * optionType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionType }
     *     
     */
    public void setOptionType(OptionType value) {
        this.optionType = value;
    }

    /**
     * moneyness 속성의 값을 가져옵니다.
     * 
     */
    public float getMoneyness() {
        return moneyness;
    }

    /**
     * moneyness 속성의 값을 설정합니다.
     * 
     */
    public void setMoneyness(float value) {
        this.moneyness = value;
    }

    /**
     * localCap 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getLocalCap() {
        return localCap;
    }

    /**
     * localCap 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setLocalCap(Float value) {
        this.localCap = value;
    }

    /**
     * localFloor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getLocalFloor() {
        return localFloor;
    }

    /**
     * localFloor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setLocalFloor(Float value) {
        this.localFloor = value;
    }

    /**
     * globalCap 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getGlobalCap() {
        return globalCap;
    }

    /**
     * globalCap 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setGlobalCap(Float value) {
        this.globalCap = value;
    }

    /**
     * globalFloor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getGlobalFloor() {
        return globalFloor;
    }

    /**
     * globalFloor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setGlobalFloor(Float value) {
        this.globalFloor = value;
    }

    /**
     * scheduleData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getScheduleData() {
        return scheduleData;
    }

    /**
     * scheduleData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setScheduleData(ScheduleData value) {
        this.scheduleData = value;
    }

    /**
     * settlementDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSettlementDays() {
        return settlementDays;
    }

    /**
     * settlementDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSettlementDays(BigInteger value) {
        this.settlementDays = value;
    }

    /**
     * premium 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPremium() {
        return premium;
    }

    /**
     * premium 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPremium(Float value) {
        this.premium = value;
    }

    /**
     * premiumPaymentDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiumPaymentDate() {
        return premiumPaymentDate;
    }

    /**
     * premiumPaymentDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiumPaymentDate(String value) {
        this.premiumPaymentDate = value;
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

}
