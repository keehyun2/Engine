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
 * <p>rainbowCallSpreadBarrierOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="rainbowCallSpreadBarrierOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Expiry" type="{}stFreeStyleEvent"/>
 *         &lt;element name="Settlement" type="{}stFreeStyleEvent"/>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="Notional" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Underlyings" type="{}stFreeStyleIndexVector"/>
 *         &lt;element name="InitialPrices" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Weights" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Strike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Floor" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Cap" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Gearing" type="{}stFreeStyleNumber"/>
 *         &lt;element name="BermudanBarrier" type="{}stFreeStyleBool"/>
 *         &lt;element name="BarrierLevel" type="{}stFreeStyleNumber"/>
 *         &lt;element name="BarrierSchedule" type="{}stFreeStyleEventSchedule"/>
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
@XmlType(name = "rainbowCallSpreadBarrierOptionData", propOrder = {

})
public class RainbowCallSpreadBarrierOptionData {

    @XmlElement(name = "Expiry", required = true)
    protected StFreeStyleEvent expiry;
    @XmlElement(name = "Settlement", required = true)
    protected StFreeStyleEvent settlement;
    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "Notional", required = true)
    protected StFreeStyleNumber notional;
    @XmlElement(name = "Underlyings", required = true)
    protected StFreeStyleIndexVector underlyings;
    @XmlElement(name = "InitialPrices", required = true)
    protected StFreeStyleNumberVector initialPrices;
    @XmlElement(name = "Weights", required = true)
    protected StFreeStyleNumberVector weights;
    @XmlElement(name = "Strike", required = true)
    protected StFreeStyleNumber strike;
    @XmlElement(name = "Floor", required = true)
    protected StFreeStyleNumber floor;
    @XmlElement(name = "Cap", required = true)
    protected StFreeStyleNumber cap;
    @XmlElement(name = "Gearing", required = true)
    protected StFreeStyleNumber gearing;
    @XmlElement(name = "BermudanBarrier", required = true)
    protected StFreeStyleBool bermudanBarrier;
    @XmlElement(name = "BarrierLevel", required = true)
    protected StFreeStyleNumber barrierLevel;
    @XmlElement(name = "BarrierSchedule", required = true)
    protected StFreeStyleEventSchedule barrierSchedule;
    @XmlElement(name = "PayCcy", required = true)
    protected StFreeStyleCurrency payCcy;

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
     * initialPrices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getInitialPrices() {
        return initialPrices;
    }

    /**
     * initialPrices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setInitialPrices(StFreeStyleNumberVector value) {
        this.initialPrices = value;
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
     * bermudanBarrier 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getBermudanBarrier() {
        return bermudanBarrier;
    }

    /**
     * bermudanBarrier 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setBermudanBarrier(StFreeStyleBool value) {
        this.bermudanBarrier = value;
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
     * barrierSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getBarrierSchedule() {
        return barrierSchedule;
    }

    /**
     * barrierSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setBarrierSchedule(StFreeStyleEventSchedule value) {
        this.barrierSchedule = value;
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
