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
 * <p>cmsCapFloorBarrierData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="cmsCapFloorBarrierData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Notional" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Strike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="PremiumAmount" type="{}stFreeStyleNumber"/>
 *         &lt;element name="PremiumCurrency" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="PremiumDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="OptionExpiry" type="{}stFreeStyleEvent"/>
 *         &lt;element name="Quantity" type="{}stFreeStyleNumber"/>
 *         &lt;element name="OptionType" type="{}stFreeStyleOptionType"/>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="CMSUnderlyings" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="Gearing" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Spread" type="{}stFreeStyleNumber"/>
 *         &lt;element name="BarrierUnderlying" type="{}stFreeStyleIndex"/>
 *         &lt;element name="BarrierLevel" type="{}stFreeStyleNumber"/>
 *         &lt;element name="BarrierType" type="{}stFreeStyleBarrierType"/>
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
@XmlType(name = "cmsCapFloorBarrierData", propOrder = {

})
public class CmsCapFloorBarrierData {

    @XmlElement(name = "Notional", required = true)
    protected StFreeStyleNumber notional;
    @XmlElement(name = "Strike", required = true)
    protected StFreeStyleNumber strike;
    @XmlElement(name = "PremiumAmount", required = true)
    protected StFreeStyleNumber premiumAmount;
    @XmlElement(name = "PremiumCurrency", required = true)
    protected StFreeStyleCurrency premiumCurrency;
    @XmlElement(name = "PremiumDate", required = true)
    protected StFreeStyleEvent premiumDate;
    @XmlElement(name = "OptionExpiry", required = true)
    protected StFreeStyleEvent optionExpiry;
    @XmlElement(name = "Quantity", required = true)
    protected StFreeStyleNumber quantity;
    @XmlElement(name = "OptionType", required = true)
    protected StFreeStyleOptionType optionType;
    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "CMSUnderlyings", required = true)
    protected StFreeStyleIndexVector cmsUnderlyings;
    @XmlElement(name = "Gearing", required = true)
    protected StFreeStyleNumber gearing;
    @XmlElement(name = "Spread", required = true)
    protected StFreeStyleNumber spread;
    @XmlElement(name = "BarrierUnderlying", required = true)
    protected StFreeStyleIndex barrierUnderlying;
    @XmlElement(name = "BarrierLevel", required = true)
    protected StFreeStyleNumber barrierLevel;
    @XmlElement(name = "BarrierType", required = true)
    protected StFreeStyleBarrierType barrierType;
    @XmlElement(name = "SettlementDate", required = true)
    protected StFreeStyleEvent settlementDate;
    @XmlElement(name = "SettlementCurrency", required = true)
    protected StFreeStyleCurrency settlementCurrency;

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
     * premiumAmount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getPremiumAmount() {
        return premiumAmount;
    }

    /**
     * premiumAmount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setPremiumAmount(StFreeStyleNumber value) {
        this.premiumAmount = value;
    }

    /**
     * premiumCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public StFreeStyleCurrency getPremiumCurrency() {
        return premiumCurrency;
    }

    /**
     * premiumCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public void setPremiumCurrency(StFreeStyleCurrency value) {
        this.premiumCurrency = value;
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
     * cmsUnderlyings 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndexVector }
     *     
     */
    public StFreeStyleIndexVector getCMSUnderlyings() {
        return cmsUnderlyings;
    }

    /**
     * cmsUnderlyings 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndexVector }
     *     
     */
    public void setCMSUnderlyings(StFreeStyleIndexVector value) {
        this.cmsUnderlyings = value;
    }

    /**
     * gearing 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getGearing() {
        return gearing;
    }

    /**
     * gearing 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setGearing(StFreeStyleNumber value) {
        this.gearing = value;
    }

    /**
     * spread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getSpread() {
        return spread;
    }

    /**
     * spread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setSpread(StFreeStyleNumber value) {
        this.spread = value;
    }

    /**
     * barrierUnderlying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public StFreeStyleIndex getBarrierUnderlying() {
        return barrierUnderlying;
    }

    /**
     * barrierUnderlying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public void setBarrierUnderlying(StFreeStyleIndex value) {
        this.barrierUnderlying = value;
    }

    /**
     * barrierLevel 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getBarrierLevel() {
        return barrierLevel;
    }

    /**
     * barrierLevel 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setBarrierLevel(StFreeStyleNumber value) {
        this.barrierLevel = value;
    }

    /**
     * barrierType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBarrierType }
     *     
     */
    public StFreeStyleBarrierType getBarrierType() {
        return barrierType;
    }

    /**
     * barrierType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBarrierType }
     *     
     */
    public void setBarrierType(StFreeStyleBarrierType value) {
        this.barrierType = value;
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
