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
 * <p>windowBarrierOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="windowBarrierOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Expiry" type="{}stFreeStyleEvent"/>
 *         &lt;element name="Settlement" type="{}stFreeStyleEvent"/>
 *         &lt;element name="StartDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="EndDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="Strike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="BarrierLevel" type="{}stFreeStyleNumber"/>
 *         &lt;element name="BarrierType" type="{}stFreeStyleBarrierType"/>
 *         &lt;element name="PutCall" type="{}stFreeStyleOptionType"/>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="Quantity" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Underlying" type="{}stFreeStyleIndex"/>
 *         &lt;element name="PayCcy" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="PremiumPayDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="PremiumAmount" type="{}stFreeStyleNumber"/>
 *         &lt;element name="PremiumCcy" type="{}stFreeStyleCurrency"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "windowBarrierOptionData", propOrder = {

})
public class WindowBarrierOptionData {

    @XmlElement(name = "Expiry", required = true)
    protected StFreeStyleEvent expiry;
    @XmlElement(name = "Settlement", required = true)
    protected StFreeStyleEvent settlement;
    @XmlElement(name = "StartDate", required = true)
    protected StFreeStyleEvent startDate;
    @XmlElement(name = "EndDate", required = true)
    protected StFreeStyleEvent endDate;
    @XmlElement(name = "Strike", required = true)
    protected StFreeStyleNumber strike;
    @XmlElement(name = "BarrierLevel", required = true)
    protected StFreeStyleNumber barrierLevel;
    @XmlElement(name = "BarrierType", required = true)
    protected StFreeStyleBarrierType barrierType;
    @XmlElement(name = "PutCall", required = true)
    protected StFreeStyleOptionType putCall;
    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "Quantity", required = true)
    protected StFreeStyleNumber quantity;
    @XmlElement(name = "Underlying", required = true)
    protected StFreeStyleIndex underlying;
    @XmlElement(name = "PayCcy", required = true)
    protected StFreeStyleCurrency payCcy;
    @XmlElement(name = "PremiumPayDate", required = true)
    protected StFreeStyleEvent premiumPayDate;
    @XmlElement(name = "PremiumAmount", required = true)
    protected StFreeStyleNumber premiumAmount;
    @XmlElement(name = "PremiumCcy", required = true)
    protected StFreeStyleCurrency premiumCcy;

    /**
     * expiry 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getExpiry() {
        return expiry;
    }

    /**
     * expiry 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setExpiry(StFreeStyleEvent value) {
        this.expiry = value;
    }

    /**
     * settlement 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getSettlement() {
        return settlement;
    }

    /**
     * settlement 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setSettlement(StFreeStyleEvent value) {
        this.settlement = value;
    }

    /**
     * startDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getStartDate() {
        return startDate;
    }

    /**
     * startDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setStartDate(StFreeStyleEvent value) {
        this.startDate = value;
    }

    /**
     * endDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getEndDate() {
        return endDate;
    }

    /**
     * endDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setEndDate(StFreeStyleEvent value) {
        this.endDate = value;
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

    /**
     * premiumPayDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getPremiumPayDate() {
        return premiumPayDate;
    }

    /**
     * premiumPayDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setPremiumPayDate(StFreeStyleEvent value) {
        this.premiumPayDate = value;
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
     * premiumCcy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public StFreeStyleCurrency getPremiumCcy() {
        return premiumCcy;
    }

    /**
     * premiumCcy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public void setPremiumCcy(StFreeStyleCurrency value) {
        this.premiumCcy = value;
    }

}
