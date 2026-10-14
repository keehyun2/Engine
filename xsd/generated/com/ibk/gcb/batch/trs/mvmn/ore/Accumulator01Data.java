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
 * <p>accumulator01Data complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="accumulator01Data">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Strike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="FixingAmount" type="{}stFreeStyleNumber"/>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="Underlying" type="{}stFreeStyleIndex"/>
 *         &lt;element name="PayCcy" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="StartDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="FixingDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="SettlementDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="RangeUpperBounds" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="RangeLowerBounds" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="RangeLeverages" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="KnockOutLevel" type="{}stFreeStyleNumber"/>
 *         &lt;element name="KnockOutType" type="{}stFreeStyleBarrierType"/>
 *         &lt;element name="AmericanKO" type="{}stFreeStyleBool"/>
 *         &lt;element name="GuaranteedFixings" type="{}stFreeStyleNumber"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accumulator01Data", propOrder = {

})
public class Accumulator01Data {

    @XmlElement(name = "Strike", required = true)
    protected StFreeStyleNumber strike;
    @XmlElement(name = "FixingAmount", required = true)
    protected StFreeStyleNumber fixingAmount;
    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "Underlying", required = true)
    protected StFreeStyleIndex underlying;
    @XmlElement(name = "PayCcy", required = true)
    protected StFreeStyleCurrency payCcy;
    @XmlElement(name = "StartDate", required = true)
    protected StFreeStyleEvent startDate;
    @XmlElement(name = "FixingDates", required = true)
    protected StFreeStyleEventSchedule fixingDates;
    @XmlElement(name = "SettlementDates", required = true)
    protected StFreeStyleEventSchedule settlementDates;
    @XmlElement(name = "RangeUpperBounds", required = true)
    protected StFreeStyleNumberVector rangeUpperBounds;
    @XmlElement(name = "RangeLowerBounds", required = true)
    protected StFreeStyleNumberVector rangeLowerBounds;
    @XmlElement(name = "RangeLeverages", required = true)
    protected StFreeStyleNumberVector rangeLeverages;
    @XmlElement(name = "KnockOutLevel", required = true)
    protected StFreeStyleNumber knockOutLevel;
    @XmlElement(name = "KnockOutType", required = true)
    protected StFreeStyleBarrierType knockOutType;
    @XmlElement(name = "AmericanKO", required = true)
    protected StFreeStyleBool americanKO;
    @XmlElement(name = "GuaranteedFixings", required = true)
    protected StFreeStyleNumber guaranteedFixings;

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
     * fixingAmount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getFixingAmount() {
        return fixingAmount;
    }

    /**
     * fixingAmount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setFixingAmount(StFreeStyleNumber value) {
        this.fixingAmount = value;
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
     * fixingDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getFixingDates() {
        return fixingDates;
    }

    /**
     * fixingDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setFixingDates(StFreeStyleEventSchedule value) {
        this.fixingDates = value;
    }

    /**
     * settlementDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getSettlementDates() {
        return settlementDates;
    }

    /**
     * settlementDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setSettlementDates(StFreeStyleEventSchedule value) {
        this.settlementDates = value;
    }

    /**
     * rangeUpperBounds 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getRangeUpperBounds() {
        return rangeUpperBounds;
    }

    /**
     * rangeUpperBounds 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setRangeUpperBounds(StFreeStyleNumberVector value) {
        this.rangeUpperBounds = value;
    }

    /**
     * rangeLowerBounds 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getRangeLowerBounds() {
        return rangeLowerBounds;
    }

    /**
     * rangeLowerBounds 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setRangeLowerBounds(StFreeStyleNumberVector value) {
        this.rangeLowerBounds = value;
    }

    /**
     * rangeLeverages 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getRangeLeverages() {
        return rangeLeverages;
    }

    /**
     * rangeLeverages 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setRangeLeverages(StFreeStyleNumberVector value) {
        this.rangeLeverages = value;
    }

    /**
     * knockOutLevel 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getKnockOutLevel() {
        return knockOutLevel;
    }

    /**
     * knockOutLevel 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setKnockOutLevel(StFreeStyleNumber value) {
        this.knockOutLevel = value;
    }

    /**
     * knockOutType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBarrierType }
     *     
     */
    public StFreeStyleBarrierType getKnockOutType() {
        return knockOutType;
    }

    /**
     * knockOutType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBarrierType }
     *     
     */
    public void setKnockOutType(StFreeStyleBarrierType value) {
        this.knockOutType = value;
    }

    /**
     * americanKO 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getAmericanKO() {
        return americanKO;
    }

    /**
     * americanKO 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setAmericanKO(StFreeStyleBool value) {
        this.americanKO = value;
    }

    /**
     * guaranteedFixings 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getGuaranteedFixings() {
        return guaranteedFixings;
    }

    /**
     * guaranteedFixings 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setGuaranteedFixings(StFreeStyleNumber value) {
        this.guaranteedFixings = value;
    }

}
