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
 * <p>assetLinkedCliquetOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="assetLinkedCliquetOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Nominal" type="{}stFreeStyleNumber"/>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="PayCurrency" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="ValuationDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="PaymentDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="Underlyings" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="FXConversions" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="Weights" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="LinkedUnderlying" type="{}stFreeStyleIndex"/>
 *         &lt;element name="PayStrike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="RecStrike" type="{}stFreeStyleNumber"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assetLinkedCliquetOptionData", propOrder = {

})
public class AssetLinkedCliquetOptionData {

    @XmlElement(name = "Nominal", required = true)
    protected StFreeStyleNumber nominal;
    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "PayCurrency", required = true)
    protected StFreeStyleCurrency payCurrency;
    @XmlElement(name = "ValuationDates", required = true)
    protected StFreeStyleEventSchedule valuationDates;
    @XmlElement(name = "PaymentDates", required = true)
    protected StFreeStyleEventSchedule paymentDates;
    @XmlElement(name = "Underlyings", required = true)
    protected StFreeStyleIndexVector underlyings;
    @XmlElement(name = "FXConversions", required = true)
    protected StFreeStyleIndexVector fxConversions;
    @XmlElement(name = "Weights", required = true)
    protected StFreeStyleNumberVector weights;
    @XmlElement(name = "LinkedUnderlying", required = true)
    protected StFreeStyleIndex linkedUnderlying;
    @XmlElement(name = "PayStrike", required = true)
    protected StFreeStyleNumber payStrike;
    @XmlElement(name = "RecStrike", required = true)
    protected StFreeStyleNumber recStrike;

    /**
     * nominal 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getNominal() {
        return nominal;
    }

    /**
     * nominal 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setNominal(StFreeStyleNumber value) {
        this.nominal = value;
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
     * valuationDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getValuationDates() {
        return valuationDates;
    }

    /**
     * valuationDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setValuationDates(StFreeStyleEventSchedule value) {
        this.valuationDates = value;
    }

    /**
     * paymentDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getPaymentDates() {
        return paymentDates;
    }

    /**
     * paymentDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setPaymentDates(StFreeStyleEventSchedule value) {
        this.paymentDates = value;
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
     * fxConversions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndexVector }
     *     
     */
    public StFreeStyleIndexVector getFXConversions() {
        return fxConversions;
    }

    /**
     * fxConversions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndexVector }
     *     
     */
    public void setFXConversions(StFreeStyleIndexVector value) {
        this.fxConversions = value;
    }

    /**
     * weights 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getWeights() {
        return weights;
    }

    /**
     * weights 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setWeights(StFreeStyleNumberVector value) {
        this.weights = value;
    }

    /**
     * linkedUnderlying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public StFreeStyleIndex getLinkedUnderlying() {
        return linkedUnderlying;
    }

    /**
     * linkedUnderlying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public void setLinkedUnderlying(StFreeStyleIndex value) {
        this.linkedUnderlying = value;
    }

    /**
     * payStrike 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getPayStrike() {
        return payStrike;
    }

    /**
     * payStrike 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setPayStrike(StFreeStyleNumber value) {
        this.payStrike = value;
    }

    /**
     * recStrike 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getRecStrike() {
        return recStrike;
    }

    /**
     * recStrike 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setRecStrike(StFreeStyleNumber value) {
        this.recStrike = value;
    }

}
