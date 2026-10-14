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
 * <p>pairwiseVarianceSwapData1 complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="pairwiseVarianceSwapData1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="Underlyings" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="UnderlyingStrikes" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="UnderlyingNotionals" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="BasketNotional" type="{}stFreeStyleNumber"/>
 *         &lt;element name="BasketStrike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="ValuationSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="LaggedValuationSchedule" type="{}stFreeStyleEventSchedule" minOccurs="0"/>
 *         &lt;element name="AccrualLag" type="{}stFreeStyleNumber" minOccurs="0"/>
 *         &lt;element name="PayoffLimit" type="{}stFreeStyleNumber" minOccurs="0"/>
 *         &lt;element name="Cap" type="{}stFreeStyleNumber" minOccurs="0"/>
 *         &lt;element name="Floor" type="{}stFreeStyleNumber" minOccurs="0"/>
 *         &lt;element name="SettlementDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="PayCcy" type="{}stFreeStyleCurrency"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pairwiseVarianceSwapData1", propOrder = {

})
public class PairwiseVarianceSwapData1 {

    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "Underlyings", required = true)
    protected StFreeStyleIndexVector underlyings;
    @XmlElement(name = "UnderlyingStrikes", required = true)
    protected StFreeStyleNumberVector underlyingStrikes;
    @XmlElement(name = "UnderlyingNotionals", required = true)
    protected StFreeStyleNumberVector underlyingNotionals;
    @XmlElement(name = "BasketNotional", required = true)
    protected StFreeStyleNumber basketNotional;
    @XmlElement(name = "BasketStrike", required = true)
    protected StFreeStyleNumber basketStrike;
    @XmlElement(name = "ValuationSchedule", required = true)
    protected StFreeStyleEventSchedule valuationSchedule;
    @XmlElement(name = "LaggedValuationSchedule")
    protected StFreeStyleEventSchedule laggedValuationSchedule;
    @XmlElement(name = "AccrualLag")
    protected StFreeStyleNumber accrualLag;
    @XmlElement(name = "PayoffLimit")
    protected StFreeStyleNumber payoffLimit;
    @XmlElement(name = "Cap")
    protected StFreeStyleNumber cap;
    @XmlElement(name = "Floor")
    protected StFreeStyleNumber floor;
    @XmlElement(name = "SettlementDate", required = true)
    protected StFreeStyleEvent settlementDate;
    @XmlElement(name = "PayCcy", required = true)
    protected StFreeStyleCurrency payCcy;

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
     * underlyingStrikes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getUnderlyingStrikes() {
        return underlyingStrikes;
    }

    /**
     * underlyingStrikes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setUnderlyingStrikes(StFreeStyleNumberVector value) {
        this.underlyingStrikes = value;
    }

    /**
     * underlyingNotionals 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getUnderlyingNotionals() {
        return underlyingNotionals;
    }

    /**
     * underlyingNotionals 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setUnderlyingNotionals(StFreeStyleNumberVector value) {
        this.underlyingNotionals = value;
    }

    /**
     * basketNotional 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getBasketNotional() {
        return basketNotional;
    }

    /**
     * basketNotional 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setBasketNotional(StFreeStyleNumber value) {
        this.basketNotional = value;
    }

    /**
     * basketStrike 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getBasketStrike() {
        return basketStrike;
    }

    /**
     * basketStrike 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setBasketStrike(StFreeStyleNumber value) {
        this.basketStrike = value;
    }

    /**
     * valuationSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getValuationSchedule() {
        return valuationSchedule;
    }

    /**
     * valuationSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setValuationSchedule(StFreeStyleEventSchedule value) {
        this.valuationSchedule = value;
    }

    /**
     * laggedValuationSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getLaggedValuationSchedule() {
        return laggedValuationSchedule;
    }

    /**
     * laggedValuationSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setLaggedValuationSchedule(StFreeStyleEventSchedule value) {
        this.laggedValuationSchedule = value;
    }

    /**
     * accrualLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getAccrualLag() {
        return accrualLag;
    }

    /**
     * accrualLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setAccrualLag(StFreeStyleNumber value) {
        this.accrualLag = value;
    }

    /**
     * payoffLimit 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getPayoffLimit() {
        return payoffLimit;
    }

    /**
     * payoffLimit 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setPayoffLimit(StFreeStyleNumber value) {
        this.payoffLimit = value;
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
     * floor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getFloor() {
        return floor;
    }

    /**
     * floor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setFloor(StFreeStyleNumber value) {
        this.floor = value;
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

}
