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
 * <p>fixedStrikeForwardStartingOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="fixedStrikeForwardStartingOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ForwardDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="PremiumDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="OptionExpiry" type="{}stFreeStyleEvent"/>
 *         &lt;element name="DayCountFraction" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="Underlying" type="{}stFreeStyleIndex"/>
 *         &lt;element name="UnderlyingDrift" type="{}stFreeStyleNumber"/>
 *         &lt;element name="DiscountRate" type="{}stFreeStyleNumber"/>
 *         &lt;element name="ImpliedVolatility" type="{}stFreeStyleNumber"/>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="PutCall" type="{}stFreeStyleOptionType"/>
 *         &lt;element name="Strike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Quantity" type="{}stFreeStyleNumber"/>
 *         &lt;element name="SettlementDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="SettlementCurrency" type="{}stFreeStyleCurrency"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fixedStrikeForwardStartingOptionData", propOrder = {

})
public class FixedStrikeForwardStartingOptionData {

    @XmlElement(name = "ForwardDate", required = true)
    protected StFreeStyleEvent forwardDate;
    @XmlElement(name = "PremiumDate", required = true)
    protected StFreeStyleEvent premiumDate;
    @XmlElement(name = "OptionExpiry", required = true)
    protected StFreeStyleEvent optionExpiry;
    @XmlElement(name = "DayCountFraction", required = true)
    protected StFreeStyleDayCounter dayCountFraction;
    @XmlElement(name = "Underlying", required = true)
    protected StFreeStyleIndex underlying;
    @XmlElement(name = "UnderlyingDrift", required = true)
    protected StFreeStyleNumber underlyingDrift;
    @XmlElement(name = "DiscountRate", required = true)
    protected StFreeStyleNumber discountRate;
    @XmlElement(name = "ImpliedVolatility", required = true)
    protected StFreeStyleNumber impliedVolatility;
    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "PutCall", required = true)
    protected StFreeStyleOptionType putCall;
    @XmlElement(name = "Strike", required = true)
    protected StFreeStyleNumber strike;
    @XmlElement(name = "Quantity", required = true)
    protected StFreeStyleNumber quantity;
    @XmlElement(name = "SettlementDate", required = true)
    protected StFreeStyleEvent settlementDate;
    @XmlElement(name = "SettlementCurrency", required = true)
    protected StFreeStyleCurrency settlementCurrency;

    /**
     * forwardDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getForwardDate() {
        return forwardDate;
    }

    /**
     * forwardDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setForwardDate(StFreeStyleEvent value) {
        this.forwardDate = value;
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
     * optionExpiry 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getOptionExpiry() {
        return optionExpiry;
    }

    /**
     * optionExpiry 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setOptionExpiry(StFreeStyleEvent value) {
        this.optionExpiry = value;
    }

    /**
     * dayCountFraction 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public StFreeStyleDayCounter getDayCountFraction() {
        return dayCountFraction;
    }

    /**
     * dayCountFraction 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public void setDayCountFraction(StFreeStyleDayCounter value) {
        this.dayCountFraction = value;
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
     * underlyingDrift 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getUnderlyingDrift() {
        return underlyingDrift;
    }

    /**
     * underlyingDrift 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setUnderlyingDrift(StFreeStyleNumber value) {
        this.underlyingDrift = value;
    }

    /**
     * discountRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getDiscountRate() {
        return discountRate;
    }

    /**
     * discountRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setDiscountRate(StFreeStyleNumber value) {
        this.discountRate = value;
    }

    /**
     * impliedVolatility 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getImpliedVolatility() {
        return impliedVolatility;
    }

    /**
     * impliedVolatility 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setImpliedVolatility(StFreeStyleNumber value) {
        this.impliedVolatility = value;
    }

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
     * putCall 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleOptionType }
     *     
     */
    public StFreeStyleOptionType getPutCall() {
        return putCall;
    }

    /**
     * putCall 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleOptionType }
     *     
     */
    public void setPutCall(StFreeStyleOptionType value) {
        this.putCall = value;
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
     * settlementCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public StFreeStyleCurrency getSettlementCurrency() {
        return settlementCurrency;
    }

    /**
     * settlementCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public void setSettlementCurrency(StFreeStyleCurrency value) {
        this.settlementCurrency = value;
    }

}
