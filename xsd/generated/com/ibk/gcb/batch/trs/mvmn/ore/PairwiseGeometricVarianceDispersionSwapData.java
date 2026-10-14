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
 * <p>pairwiseGeometricVarianceDispersionSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="pairwiseGeometricVarianceDispersionSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="PairCount" type="{}stFreeStyleNumber"/>
 *         &lt;element name="BasketCount" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Notionals" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Underlyings" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="StrikesVS" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="StrikesBVS" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="BasketWeights" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="VarianceWeights" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Lag" type="{}stFreeStyleNumber"/>
 *         &lt;element name="CapAmountMultiplier" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Cap" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Floor" type="{}stFreeStyleNumber"/>
 *         &lt;element name="DividendAdjustment" type="{}stFreeStyleBool"/>
 *         &lt;element name="ValuationSchedule" type="{}stFreeStyleEventSchedule"/>
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
@XmlType(name = "pairwiseGeometricVarianceDispersionSwapData", propOrder = {

})
public class PairwiseGeometricVarianceDispersionSwapData {

    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "PairCount", required = true)
    protected StFreeStyleNumber pairCount;
    @XmlElement(name = "BasketCount", required = true)
    protected StFreeStyleNumber basketCount;
    @XmlElement(name = "Notionals", required = true)
    protected StFreeStyleNumberVector notionals;
    @XmlElement(name = "Underlyings", required = true)
    protected StFreeStyleIndexVector underlyings;
    @XmlElement(name = "StrikesVS", required = true)
    protected StFreeStyleNumberVector strikesVS;
    @XmlElement(name = "StrikesBVS", required = true)
    protected StFreeStyleNumberVector strikesBVS;
    @XmlElement(name = "BasketWeights", required = true)
    protected StFreeStyleNumberVector basketWeights;
    @XmlElement(name = "VarianceWeights", required = true)
    protected StFreeStyleNumberVector varianceWeights;
    @XmlElement(name = "Lag", required = true)
    protected StFreeStyleNumber lag;
    @XmlElement(name = "CapAmountMultiplier", required = true)
    protected StFreeStyleNumber capAmountMultiplier;
    @XmlElement(name = "Cap", required = true)
    protected StFreeStyleNumber cap;
    @XmlElement(name = "Floor", required = true)
    protected StFreeStyleNumber floor;
    @XmlElement(name = "DividendAdjustment", required = true)
    protected StFreeStyleBool dividendAdjustment;
    @XmlElement(name = "ValuationSchedule", required = true)
    protected StFreeStyleEventSchedule valuationSchedule;
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
     * pairCount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getPairCount() {
        return pairCount;
    }

    /**
     * pairCount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setPairCount(StFreeStyleNumber value) {
        this.pairCount = value;
    }

    /**
     * basketCount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getBasketCount() {
        return basketCount;
    }

    /**
     * basketCount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setBasketCount(StFreeStyleNumber value) {
        this.basketCount = value;
    }

    /**
     * notionals 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getNotionals() {
        return notionals;
    }

    /**
     * notionals 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setNotionals(StFreeStyleNumberVector value) {
        this.notionals = value;
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
     * strikesVS 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getStrikesVS() {
        return strikesVS;
    }

    /**
     * strikesVS 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setStrikesVS(StFreeStyleNumberVector value) {
        this.strikesVS = value;
    }

    /**
     * strikesBVS 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getStrikesBVS() {
        return strikesBVS;
    }

    /**
     * strikesBVS 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setStrikesBVS(StFreeStyleNumberVector value) {
        this.strikesBVS = value;
    }

    /**
     * basketWeights 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getBasketWeights() {
        return basketWeights;
    }

    /**
     * basketWeights 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setBasketWeights(StFreeStyleNumberVector value) {
        this.basketWeights = value;
    }

    /**
     * varianceWeights 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getVarianceWeights() {
        return varianceWeights;
    }

    /**
     * varianceWeights 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setVarianceWeights(StFreeStyleNumberVector value) {
        this.varianceWeights = value;
    }

    /**
     * lag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getLag() {
        return lag;
    }

    /**
     * lag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setLag(StFreeStyleNumber value) {
        this.lag = value;
    }

    /**
     * capAmountMultiplier 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getCapAmountMultiplier() {
        return capAmountMultiplier;
    }

    /**
     * capAmountMultiplier 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setCapAmountMultiplier(StFreeStyleNumber value) {
        this.capAmountMultiplier = value;
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
     * dividendAdjustment 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getDividendAdjustment() {
        return dividendAdjustment;
    }

    /**
     * dividendAdjustment 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setDividendAdjustment(StFreeStyleBool value) {
        this.dividendAdjustment = value;
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
