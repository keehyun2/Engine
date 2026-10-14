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
 * <p>genericBarrierOptionDataRaw complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="genericBarrierOptionDataRaw">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="PayoffType" type="{}stFreeStyleNumber"/>
 *         &lt;element name="TransatlanticBarrierType" type="{}stFreeStyleBarrierTypeVector"/>
 *         &lt;element name="TransatlanticBarrierLevel" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="TransatlanticBarrierRebate" type="{}stFreeStyleNumber"/>
 *         &lt;element name="TransatlanticBarrierRebateCurrency" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="TransatlanticBarrierStrictComparison" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="PutCall" type="{}stFreeStyleOptionType"/>
 *         &lt;element name="Quantity" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Strike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Amount" type="{}stFreeStyleNumber"/>
 *         &lt;element name="PayCurrency" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="ExpiryDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="SettlementDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="Underlyings" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="BarrierMonitoringDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="BarrierTypes" type="{}stFreeStyleBarrierTypeVector"/>
 *         &lt;element name="BarrierLevels" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="BarrierRebates" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="BarrierStrictComparison" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="BarrierRebateCurrencies" type="{}stFreeStyleCurrencyVector"/>
 *         &lt;element name="BarrierRebatePayTimes" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="BarrierRebate" type="{}stFreeStyleNumber"/>
 *         &lt;element name="BarrierRebateCurrency" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="KikoType" type="{}stFreeStyleNumber"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "genericBarrierOptionDataRaw", propOrder = {

})
public class GenericBarrierOptionDataRaw {

    @XmlElement(name = "PayoffType", required = true)
    protected StFreeStyleNumber payoffType;
    @XmlElement(name = "TransatlanticBarrierType", required = true)
    protected StFreeStyleBarrierTypeVector transatlanticBarrierType;
    @XmlElement(name = "TransatlanticBarrierLevel", required = true)
    protected StFreeStyleNumberVector transatlanticBarrierLevel;
    @XmlElement(name = "TransatlanticBarrierRebate", required = true)
    protected StFreeStyleNumber transatlanticBarrierRebate;
    @XmlElement(name = "TransatlanticBarrierRebateCurrency", required = true)
    protected StFreeStyleCurrency transatlanticBarrierRebateCurrency;
    @XmlElement(name = "TransatlanticBarrierStrictComparison", required = true)
    protected StFreeStyleNumberVector transatlanticBarrierStrictComparison;
    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "PutCall", required = true)
    protected StFreeStyleOptionType putCall;
    @XmlElement(name = "Quantity", required = true)
    protected StFreeStyleNumber quantity;
    @XmlElement(name = "Strike", required = true)
    protected StFreeStyleNumber strike;
    @XmlElement(name = "Amount", required = true)
    protected StFreeStyleNumber amount;
    @XmlElement(name = "PayCurrency", required = true)
    protected StFreeStyleCurrency payCurrency;
    @XmlElement(name = "ExpiryDate", required = true)
    protected StFreeStyleEvent expiryDate;
    @XmlElement(name = "SettlementDate", required = true)
    protected StFreeStyleEvent settlementDate;
    @XmlElement(name = "Underlyings", required = true)
    protected StFreeStyleIndexVector underlyings;
    @XmlElement(name = "BarrierMonitoringDates", required = true)
    protected StFreeStyleEventSchedule barrierMonitoringDates;
    @XmlElement(name = "BarrierTypes", required = true)
    protected StFreeStyleBarrierTypeVector barrierTypes;
    @XmlElement(name = "BarrierLevels", required = true)
    protected StFreeStyleNumberVector barrierLevels;
    @XmlElement(name = "BarrierRebates", required = true)
    protected StFreeStyleNumberVector barrierRebates;
    @XmlElement(name = "BarrierStrictComparison", required = true)
    protected StFreeStyleNumberVector barrierStrictComparison;
    @XmlElement(name = "BarrierRebateCurrencies", required = true)
    protected StFreeStyleCurrencyVector barrierRebateCurrencies;
    @XmlElement(name = "BarrierRebatePayTimes", required = true)
    protected StFreeStyleNumberVector barrierRebatePayTimes;
    @XmlElement(name = "BarrierRebate", required = true)
    protected StFreeStyleNumber barrierRebate;
    @XmlElement(name = "BarrierRebateCurrency", required = true)
    protected StFreeStyleCurrency barrierRebateCurrency;
    @XmlElement(name = "KikoType", required = true)
    protected StFreeStyleNumber kikoType;

    /**
     * payoffType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getPayoffType() {
        return payoffType;
    }

    /**
     * payoffType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setPayoffType(StFreeStyleNumber value) {
        this.payoffType = value;
    }

    /**
     * transatlanticBarrierType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBarrierTypeVector }
     *     
     */
    public StFreeStyleBarrierTypeVector getTransatlanticBarrierType() {
        return transatlanticBarrierType;
    }

    /**
     * transatlanticBarrierType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBarrierTypeVector }
     *     
     */
    public void setTransatlanticBarrierType(StFreeStyleBarrierTypeVector value) {
        this.transatlanticBarrierType = value;
    }

    /**
     * transatlanticBarrierLevel 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getTransatlanticBarrierLevel() {
        return transatlanticBarrierLevel;
    }

    /**
     * transatlanticBarrierLevel 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setTransatlanticBarrierLevel(StFreeStyleNumberVector value) {
        this.transatlanticBarrierLevel = value;
    }

    /**
     * transatlanticBarrierRebate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getTransatlanticBarrierRebate() {
        return transatlanticBarrierRebate;
    }

    /**
     * transatlanticBarrierRebate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setTransatlanticBarrierRebate(StFreeStyleNumber value) {
        this.transatlanticBarrierRebate = value;
    }

    /**
     * transatlanticBarrierRebateCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public StFreeStyleCurrency getTransatlanticBarrierRebateCurrency() {
        return transatlanticBarrierRebateCurrency;
    }

    /**
     * transatlanticBarrierRebateCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public void setTransatlanticBarrierRebateCurrency(StFreeStyleCurrency value) {
        this.transatlanticBarrierRebateCurrency = value;
    }

    /**
     * transatlanticBarrierStrictComparison 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getTransatlanticBarrierStrictComparison() {
        return transatlanticBarrierStrictComparison;
    }

    /**
     * transatlanticBarrierStrictComparison 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setTransatlanticBarrierStrictComparison(StFreeStyleNumberVector value) {
        this.transatlanticBarrierStrictComparison = value;
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
     * amount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getAmount() {
        return amount;
    }

    /**
     * amount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setAmount(StFreeStyleNumber value) {
        this.amount = value;
    }

    /**
     * payCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public StFreeStyleCurrency getPayCurrency() {
        return payCurrency;
    }

    /**
     * payCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public void setPayCurrency(StFreeStyleCurrency value) {
        this.payCurrency = value;
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
     * barrierMonitoringDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getBarrierMonitoringDates() {
        return barrierMonitoringDates;
    }

    /**
     * barrierMonitoringDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setBarrierMonitoringDates(StFreeStyleEventSchedule value) {
        this.barrierMonitoringDates = value;
    }

    /**
     * barrierTypes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBarrierTypeVector }
     *     
     */
    public StFreeStyleBarrierTypeVector getBarrierTypes() {
        return barrierTypes;
    }

    /**
     * barrierTypes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBarrierTypeVector }
     *     
     */
    public void setBarrierTypes(StFreeStyleBarrierTypeVector value) {
        this.barrierTypes = value;
    }

    /**
     * barrierLevels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getBarrierLevels() {
        return barrierLevels;
    }

    /**
     * barrierLevels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setBarrierLevels(StFreeStyleNumberVector value) {
        this.barrierLevels = value;
    }

    /**
     * barrierRebates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getBarrierRebates() {
        return barrierRebates;
    }

    /**
     * barrierRebates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setBarrierRebates(StFreeStyleNumberVector value) {
        this.barrierRebates = value;
    }

    /**
     * barrierStrictComparison 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getBarrierStrictComparison() {
        return barrierStrictComparison;
    }

    /**
     * barrierStrictComparison 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setBarrierStrictComparison(StFreeStyleNumberVector value) {
        this.barrierStrictComparison = value;
    }

    /**
     * barrierRebateCurrencies 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleCurrencyVector }
     *     
     */
    public StFreeStyleCurrencyVector getBarrierRebateCurrencies() {
        return barrierRebateCurrencies;
    }

    /**
     * barrierRebateCurrencies 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleCurrencyVector }
     *     
     */
    public void setBarrierRebateCurrencies(StFreeStyleCurrencyVector value) {
        this.barrierRebateCurrencies = value;
    }

    /**
     * barrierRebatePayTimes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getBarrierRebatePayTimes() {
        return barrierRebatePayTimes;
    }

    /**
     * barrierRebatePayTimes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setBarrierRebatePayTimes(StFreeStyleNumberVector value) {
        this.barrierRebatePayTimes = value;
    }

    /**
     * barrierRebate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getBarrierRebate() {
        return barrierRebate;
    }

    /**
     * barrierRebate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setBarrierRebate(StFreeStyleNumber value) {
        this.barrierRebate = value;
    }

    /**
     * barrierRebateCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public StFreeStyleCurrency getBarrierRebateCurrency() {
        return barrierRebateCurrency;
    }

    /**
     * barrierRebateCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public void setBarrierRebateCurrency(StFreeStyleCurrency value) {
        this.barrierRebateCurrency = value;
    }

    /**
     * kikoType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getKikoType() {
        return kikoType;
    }

    /**
     * kikoType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setKikoType(StFreeStyleNumber value) {
        this.kikoType = value;
    }

}
