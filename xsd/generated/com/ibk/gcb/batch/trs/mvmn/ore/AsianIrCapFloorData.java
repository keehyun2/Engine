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
 * <p>asianIrCapFloorData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="asianIrCapFloorData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="NotionalAmount" type="{}stFreeStyleNumber"/>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="Underlying" type="{}stFreeStyleIndex"/>
 *         &lt;element name="FixingLagDc" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="MinFixingLag" type="{}stFreeStyleNumber"/>
 *         &lt;element name="MaxFixingLag" type="{}stFreeStyleNumber"/>
 *         &lt;element name="OptionType" type="{}stFreeStyleOptionType"/>
 *         &lt;element name="Strike" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Gearing" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Spread" type="{}stFreeStyleNumber"/>
 *         &lt;element name="DayCountFraction" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="FixedAmount" type="{}stFreeStyleNumber"/>
 *         &lt;element name="FixedAmountPayDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="PayCcy" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="AccrualSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="FixingSchedule" type="{}stFreeStyleEventSchedule"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "asianIrCapFloorData", propOrder = {

})
public class AsianIrCapFloorData {

    @XmlElement(name = "NotionalAmount", required = true)
    protected StFreeStyleNumber notionalAmount;
    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "Underlying", required = true)
    protected StFreeStyleIndex underlying;
    @XmlElement(name = "FixingLagDc", required = true)
    protected StFreeStyleDayCounter fixingLagDc;
    @XmlElement(name = "MinFixingLag", required = true)
    protected StFreeStyleNumber minFixingLag;
    @XmlElement(name = "MaxFixingLag", required = true)
    protected StFreeStyleNumber maxFixingLag;
    @XmlElement(name = "OptionType", required = true)
    protected StFreeStyleOptionType optionType;
    @XmlElement(name = "Strike", required = true)
    protected StFreeStyleNumber strike;
    @XmlElement(name = "Gearing", required = true)
    protected StFreeStyleNumber gearing;
    @XmlElement(name = "Spread", required = true)
    protected StFreeStyleNumber spread;
    @XmlElement(name = "DayCountFraction", required = true)
    protected StFreeStyleDayCounter dayCountFraction;
    @XmlElement(name = "FixedAmount", required = true)
    protected StFreeStyleNumber fixedAmount;
    @XmlElement(name = "FixedAmountPayDate", required = true)
    protected StFreeStyleEvent fixedAmountPayDate;
    @XmlElement(name = "PayCcy", required = true)
    protected StFreeStyleCurrency payCcy;
    @XmlElement(name = "AccrualSchedule", required = true)
    protected StFreeStyleEventSchedule accrualSchedule;
    @XmlElement(name = "FixingSchedule", required = true)
    protected StFreeStyleEventSchedule fixingSchedule;

    /**
     * notionalAmount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getNotionalAmount() {
        return notionalAmount;
    }

    /**
     * notionalAmount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setNotionalAmount(StFreeStyleNumber value) {
        this.notionalAmount = value;
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
     * fixingLagDc 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public StFreeStyleDayCounter getFixingLagDc() {
        return fixingLagDc;
    }

    /**
     * fixingLagDc 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public void setFixingLagDc(StFreeStyleDayCounter value) {
        this.fixingLagDc = value;
    }

    /**
     * minFixingLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getMinFixingLag() {
        return minFixingLag;
    }

    /**
     * minFixingLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setMinFixingLag(StFreeStyleNumber value) {
        this.minFixingLag = value;
    }

    /**
     * maxFixingLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getMaxFixingLag() {
        return maxFixingLag;
    }

    /**
     * maxFixingLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setMaxFixingLag(StFreeStyleNumber value) {
        this.maxFixingLag = value;
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
     * fixedAmount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getFixedAmount() {
        return fixedAmount;
    }

    /**
     * fixedAmount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setFixedAmount(StFreeStyleNumber value) {
        this.fixedAmount = value;
    }

    /**
     * fixedAmountPayDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getFixedAmountPayDate() {
        return fixedAmountPayDate;
    }

    /**
     * fixedAmountPayDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setFixedAmountPayDate(StFreeStyleEvent value) {
        this.fixedAmountPayDate = value;
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
     * accrualSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getAccrualSchedule() {
        return accrualSchedule;
    }

    /**
     * accrualSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setAccrualSchedule(StFreeStyleEventSchedule value) {
        this.accrualSchedule = value;
    }

    /**
     * fixingSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getFixingSchedule() {
        return fixingSchedule;
    }

    /**
     * fixingSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setFixingSchedule(StFreeStyleEventSchedule value) {
        this.fixingSchedule = value;
    }

}
