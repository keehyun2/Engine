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
 * <p>flooredAverageCPIZCIISData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="flooredAverageCPIZCIISData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Notional" type="{}stFreeStyleNumber"/>
 *         &lt;element name="PayCurrency" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="FixedDayCounter" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="FixedRate" type="{}stFreeStyleNumber"/>
 *         &lt;element name="FixedLegSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="PayFixLeg" type="{}stFreeStyleBool"/>
 *         &lt;element name="FloatDayCounter" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="CPIIndex" type="{}stFreeStyleIndex"/>
 *         &lt;element name="FloatLegSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="Floor" type="{}stFreeStyleNumber"/>
 *         &lt;element name="BaseCPI" type="{}stFreeStyleNumber"/>
 *         &lt;element name="ObservationSchedule" type="{}stFreeStyleEventSchedule"/>
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
@XmlType(name = "flooredAverageCPIZCIISData", propOrder = {

})
public class FlooredAverageCPIZCIISData {

    @XmlElement(name = "Notional", required = true)
    protected StFreeStyleNumber notional;
    @XmlElement(name = "PayCurrency", required = true)
    protected StFreeStyleCurrency payCurrency;
    @XmlElement(name = "FixedDayCounter", required = true)
    protected StFreeStyleDayCounter fixedDayCounter;
    @XmlElement(name = "FixedRate", required = true)
    protected StFreeStyleNumber fixedRate;
    @XmlElement(name = "FixedLegSchedule", required = true)
    protected StFreeStyleEventSchedule fixedLegSchedule;
    @XmlElement(name = "PayFixLeg", required = true)
    protected StFreeStyleBool payFixLeg;
    @XmlElement(name = "FloatDayCounter", required = true)
    protected StFreeStyleDayCounter floatDayCounter;
    @XmlElement(name = "CPIIndex", required = true)
    protected StFreeStyleIndex cpiIndex;
    @XmlElement(name = "FloatLegSchedule", required = true)
    protected StFreeStyleEventSchedule floatLegSchedule;
    @XmlElement(name = "Floor", required = true)
    protected StFreeStyleNumber floor;
    @XmlElement(name = "BaseCPI", required = true)
    protected StFreeStyleNumber baseCPI;
    @XmlElement(name = "ObservationSchedule", required = true)
    protected StFreeStyleEventSchedule observationSchedule;
    @XmlElement(name = "FixingSchedule", required = true)
    protected StFreeStyleEventSchedule fixingSchedule;

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
     * fixedDayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public StFreeStyleDayCounter getFixedDayCounter() {
        return fixedDayCounter;
    }

    /**
     * fixedDayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public void setFixedDayCounter(StFreeStyleDayCounter value) {
        this.fixedDayCounter = value;
    }

    /**
     * fixedRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getFixedRate() {
        return fixedRate;
    }

    /**
     * fixedRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setFixedRate(StFreeStyleNumber value) {
        this.fixedRate = value;
    }

    /**
     * fixedLegSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getFixedLegSchedule() {
        return fixedLegSchedule;
    }

    /**
     * fixedLegSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setFixedLegSchedule(StFreeStyleEventSchedule value) {
        this.fixedLegSchedule = value;
    }

    /**
     * payFixLeg 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getPayFixLeg() {
        return payFixLeg;
    }

    /**
     * payFixLeg 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setPayFixLeg(StFreeStyleBool value) {
        this.payFixLeg = value;
    }

    /**
     * floatDayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public StFreeStyleDayCounter getFloatDayCounter() {
        return floatDayCounter;
    }

    /**
     * floatDayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public void setFloatDayCounter(StFreeStyleDayCounter value) {
        this.floatDayCounter = value;
    }

    /**
     * cpiIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public StFreeStyleIndex getCPIIndex() {
        return cpiIndex;
    }

    /**
     * cpiIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public void setCPIIndex(StFreeStyleIndex value) {
        this.cpiIndex = value;
    }

    /**
     * floatLegSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getFloatLegSchedule() {
        return floatLegSchedule;
    }

    /**
     * floatLegSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setFloatLegSchedule(StFreeStyleEventSchedule value) {
        this.floatLegSchedule = value;
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
     * baseCPI 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getBaseCPI() {
        return baseCPI;
    }

    /**
     * baseCPI 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setBaseCPI(StFreeStyleNumber value) {
        this.baseCPI = value;
    }

    /**
     * observationSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getObservationSchedule() {
        return observationSchedule;
    }

    /**
     * observationSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setObservationSchedule(StFreeStyleEventSchedule value) {
        this.observationSchedule = value;
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
