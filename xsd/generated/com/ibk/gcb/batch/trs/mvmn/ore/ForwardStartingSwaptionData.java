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
 * <p>forwardStartingSwaptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="forwardStartingSwaptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="DeterminationDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="SwaptionType" type="{}stFreeStyleNumber"/>
 *         &lt;element name="PremiumDate" type="{}stFreeStyleEvent"/>
 *         &lt;element name="PremiumAmount" type="{}stFreeStyleNumber"/>
 *         &lt;element name="PremiumCurrency" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="OptionExpiry" type="{}stFreeStyleEvent"/>
 *         &lt;element name="Underlying" type="{}stFreeStyleIndex"/>
 *         &lt;element name="Notional" type="{}stFreeStyleNumber"/>
 *         &lt;element name="PayCcy" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="FixedDayCountFraction" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="FixedSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="FloatingDayCountFraction" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="FloatingSchedule" type="{}stFreeStyleEventSchedule"/>
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
@XmlType(name = "forwardStartingSwaptionData", propOrder = {

})
public class ForwardStartingSwaptionData {

    @XmlElement(name = "DeterminationDate", required = true)
    protected StFreeStyleEvent determinationDate;
    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "SwaptionType", required = true)
    protected StFreeStyleNumber swaptionType;
    @XmlElement(name = "PremiumDate", required = true)
    protected StFreeStyleEvent premiumDate;
    @XmlElement(name = "PremiumAmount", required = true)
    protected StFreeStyleNumber premiumAmount;
    @XmlElement(name = "PremiumCurrency", required = true)
    protected StFreeStyleCurrency premiumCurrency;
    @XmlElement(name = "OptionExpiry", required = true)
    protected StFreeStyleEvent optionExpiry;
    @XmlElement(name = "Underlying", required = true)
    protected StFreeStyleIndex underlying;
    @XmlElement(name = "Notional", required = true)
    protected StFreeStyleNumber notional;
    @XmlElement(name = "PayCcy", required = true)
    protected StFreeStyleCurrency payCcy;
    @XmlElement(name = "FixedDayCountFraction", required = true)
    protected StFreeStyleDayCounter fixedDayCountFraction;
    @XmlElement(name = "FixedSchedule", required = true)
    protected StFreeStyleEventSchedule fixedSchedule;
    @XmlElement(name = "FloatingDayCountFraction", required = true)
    protected StFreeStyleDayCounter floatingDayCountFraction;
    @XmlElement(name = "FloatingSchedule", required = true)
    protected StFreeStyleEventSchedule floatingSchedule;
    @XmlElement(name = "FixingSchedule", required = true)
    protected StFreeStyleEventSchedule fixingSchedule;

    /**
     * determinationDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public StFreeStyleEvent getDeterminationDate() {
        return determinationDate;
    }

    /**
     * determinationDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEvent }
     *     
     */
    public void setDeterminationDate(StFreeStyleEvent value) {
        this.determinationDate = value;
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
     * swaptionType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getSwaptionType() {
        return swaptionType;
    }

    /**
     * swaptionType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setSwaptionType(StFreeStyleNumber value) {
        this.swaptionType = value;
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
     * fixedDayCountFraction 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public StFreeStyleDayCounter getFixedDayCountFraction() {
        return fixedDayCountFraction;
    }

    /**
     * fixedDayCountFraction 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public void setFixedDayCountFraction(StFreeStyleDayCounter value) {
        this.fixedDayCountFraction = value;
    }

    /**
     * fixedSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getFixedSchedule() {
        return fixedSchedule;
    }

    /**
     * fixedSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setFixedSchedule(StFreeStyleEventSchedule value) {
        this.fixedSchedule = value;
    }

    /**
     * floatingDayCountFraction 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public StFreeStyleDayCounter getFloatingDayCountFraction() {
        return floatingDayCountFraction;
    }

    /**
     * floatingDayCountFraction 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public void setFloatingDayCountFraction(StFreeStyleDayCounter value) {
        this.floatingDayCountFraction = value;
    }

    /**
     * floatingSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getFloatingSchedule() {
        return floatingSchedule;
    }

    /**
     * floatingSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setFloatingSchedule(StFreeStyleEventSchedule value) {
        this.floatingSchedule = value;
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
