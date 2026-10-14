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
 * <p>irregularYYIISData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="irregularYYIISData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Notional" type="{}stFreeStyleNumber"/>
 *         &lt;element name="PayCurrency" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="IborLegDayCounter" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="IborSpread" type="{}stFreeStyleNumber"/>
 *         &lt;element name="IborIndex" type="{}stFreeStyleIndex"/>
 *         &lt;element name="PayIborLeg" type="{}stFreeStyleBool"/>
 *         &lt;element name="IborLegSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="IborLegFixingSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="InflationLeg1_DayCounter" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="InflationLeg1_CPI" type="{}stFreeStyleIndex"/>
 *         &lt;element name="InflationLeg1_Schedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="InflationLeg1_FixingSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="InflationLeg1_Gearing" type="{}stFreeStyleNumber"/>
 *         &lt;element name="InflationLeg1_Floor" type="{}stFreeStyleNumber"/>
 *         &lt;element name="InflationLeg1_InitialCPI" type="{}stFreeStyleNumber"/>
 *         &lt;element name="InflationLeg1_SubtractNotional" type="{}stFreeStyleBool"/>
 *         &lt;element name="InflationLeg2_DayCounter" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="InflationLeg2_CPI" type="{}stFreeStyleIndex"/>
 *         &lt;element name="InflationLeg2_Schedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="InflationLeg2_FixingSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="InflationLeg2_Gearing" type="{}stFreeStyleNumber"/>
 *         &lt;element name="InflationLeg2_Floor" type="{}stFreeStyleNumber"/>
 *         &lt;element name="InflationLeg2_InitialCPI" type="{}stFreeStyleNumber"/>
 *         &lt;element name="InflationLeg2_SubtractNotional" type="{}stFreeStyleBool"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "irregularYYIISData", propOrder = {

})
public class IrregularYYIISData {

    @XmlElement(name = "Notional", required = true)
    protected StFreeStyleNumber notional;
    @XmlElement(name = "PayCurrency", required = true)
    protected StFreeStyleCurrency payCurrency;
    @XmlElement(name = "IborLegDayCounter", required = true)
    protected StFreeStyleDayCounter iborLegDayCounter;
    @XmlElement(name = "IborSpread", required = true)
    protected StFreeStyleNumber iborSpread;
    @XmlElement(name = "IborIndex", required = true)
    protected StFreeStyleIndex iborIndex;
    @XmlElement(name = "PayIborLeg", required = true)
    protected StFreeStyleBool payIborLeg;
    @XmlElement(name = "IborLegSchedule", required = true)
    protected StFreeStyleEventSchedule iborLegSchedule;
    @XmlElement(name = "IborLegFixingSchedule", required = true)
    protected StFreeStyleEventSchedule iborLegFixingSchedule;
    @XmlElement(name = "InflationLeg1_DayCounter", required = true)
    protected StFreeStyleDayCounter inflationLeg1DayCounter;
    @XmlElement(name = "InflationLeg1_CPI", required = true)
    protected StFreeStyleIndex inflationLeg1CPI;
    @XmlElement(name = "InflationLeg1_Schedule", required = true)
    protected StFreeStyleEventSchedule inflationLeg1Schedule;
    @XmlElement(name = "InflationLeg1_FixingSchedule", required = true)
    protected StFreeStyleEventSchedule inflationLeg1FixingSchedule;
    @XmlElement(name = "InflationLeg1_Gearing", required = true)
    protected StFreeStyleNumber inflationLeg1Gearing;
    @XmlElement(name = "InflationLeg1_Floor", required = true)
    protected StFreeStyleNumber inflationLeg1Floor;
    @XmlElement(name = "InflationLeg1_InitialCPI", required = true)
    protected StFreeStyleNumber inflationLeg1InitialCPI;
    @XmlElement(name = "InflationLeg1_SubtractNotional", required = true)
    protected StFreeStyleBool inflationLeg1SubtractNotional;
    @XmlElement(name = "InflationLeg2_DayCounter", required = true)
    protected StFreeStyleDayCounter inflationLeg2DayCounter;
    @XmlElement(name = "InflationLeg2_CPI", required = true)
    protected StFreeStyleIndex inflationLeg2CPI;
    @XmlElement(name = "InflationLeg2_Schedule", required = true)
    protected StFreeStyleEventSchedule inflationLeg2Schedule;
    @XmlElement(name = "InflationLeg2_FixingSchedule", required = true)
    protected StFreeStyleEventSchedule inflationLeg2FixingSchedule;
    @XmlElement(name = "InflationLeg2_Gearing", required = true)
    protected StFreeStyleNumber inflationLeg2Gearing;
    @XmlElement(name = "InflationLeg2_Floor", required = true)
    protected StFreeStyleNumber inflationLeg2Floor;
    @XmlElement(name = "InflationLeg2_InitialCPI", required = true)
    protected StFreeStyleNumber inflationLeg2InitialCPI;
    @XmlElement(name = "InflationLeg2_SubtractNotional", required = true)
    protected StFreeStyleBool inflationLeg2SubtractNotional;

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
     * iborLegDayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public StFreeStyleDayCounter getIborLegDayCounter() {
        return iborLegDayCounter;
    }

    /**
     * iborLegDayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public void setIborLegDayCounter(StFreeStyleDayCounter value) {
        this.iborLegDayCounter = value;
    }

    /**
     * iborSpread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getIborSpread() {
        return iborSpread;
    }

    /**
     * iborSpread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setIborSpread(StFreeStyleNumber value) {
        this.iborSpread = value;
    }

    /**
     * iborIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public StFreeStyleIndex getIborIndex() {
        return iborIndex;
    }

    /**
     * iborIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public void setIborIndex(StFreeStyleIndex value) {
        this.iborIndex = value;
    }

    /**
     * payIborLeg 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getPayIborLeg() {
        return payIborLeg;
    }

    /**
     * payIborLeg 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setPayIborLeg(StFreeStyleBool value) {
        this.payIborLeg = value;
    }

    /**
     * iborLegSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getIborLegSchedule() {
        return iborLegSchedule;
    }

    /**
     * iborLegSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setIborLegSchedule(StFreeStyleEventSchedule value) {
        this.iborLegSchedule = value;
    }

    /**
     * iborLegFixingSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getIborLegFixingSchedule() {
        return iborLegFixingSchedule;
    }

    /**
     * iborLegFixingSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setIborLegFixingSchedule(StFreeStyleEventSchedule value) {
        this.iborLegFixingSchedule = value;
    }

    /**
     * inflationLeg1DayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public StFreeStyleDayCounter getInflationLeg1DayCounter() {
        return inflationLeg1DayCounter;
    }

    /**
     * inflationLeg1DayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public void setInflationLeg1DayCounter(StFreeStyleDayCounter value) {
        this.inflationLeg1DayCounter = value;
    }

    /**
     * inflationLeg1CPI 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public StFreeStyleIndex getInflationLeg1CPI() {
        return inflationLeg1CPI;
    }

    /**
     * inflationLeg1CPI 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public void setInflationLeg1CPI(StFreeStyleIndex value) {
        this.inflationLeg1CPI = value;
    }

    /**
     * inflationLeg1Schedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getInflationLeg1Schedule() {
        return inflationLeg1Schedule;
    }

    /**
     * inflationLeg1Schedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setInflationLeg1Schedule(StFreeStyleEventSchedule value) {
        this.inflationLeg1Schedule = value;
    }

    /**
     * inflationLeg1FixingSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getInflationLeg1FixingSchedule() {
        return inflationLeg1FixingSchedule;
    }

    /**
     * inflationLeg1FixingSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setInflationLeg1FixingSchedule(StFreeStyleEventSchedule value) {
        this.inflationLeg1FixingSchedule = value;
    }

    /**
     * inflationLeg1Gearing 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getInflationLeg1Gearing() {
        return inflationLeg1Gearing;
    }

    /**
     * inflationLeg1Gearing 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setInflationLeg1Gearing(StFreeStyleNumber value) {
        this.inflationLeg1Gearing = value;
    }

    /**
     * inflationLeg1Floor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getInflationLeg1Floor() {
        return inflationLeg1Floor;
    }

    /**
     * inflationLeg1Floor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setInflationLeg1Floor(StFreeStyleNumber value) {
        this.inflationLeg1Floor = value;
    }

    /**
     * inflationLeg1InitialCPI 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getInflationLeg1InitialCPI() {
        return inflationLeg1InitialCPI;
    }

    /**
     * inflationLeg1InitialCPI 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setInflationLeg1InitialCPI(StFreeStyleNumber value) {
        this.inflationLeg1InitialCPI = value;
    }

    /**
     * inflationLeg1SubtractNotional 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getInflationLeg1SubtractNotional() {
        return inflationLeg1SubtractNotional;
    }

    /**
     * inflationLeg1SubtractNotional 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setInflationLeg1SubtractNotional(StFreeStyleBool value) {
        this.inflationLeg1SubtractNotional = value;
    }

    /**
     * inflationLeg2DayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public StFreeStyleDayCounter getInflationLeg2DayCounter() {
        return inflationLeg2DayCounter;
    }

    /**
     * inflationLeg2DayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public void setInflationLeg2DayCounter(StFreeStyleDayCounter value) {
        this.inflationLeg2DayCounter = value;
    }

    /**
     * inflationLeg2CPI 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public StFreeStyleIndex getInflationLeg2CPI() {
        return inflationLeg2CPI;
    }

    /**
     * inflationLeg2CPI 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public void setInflationLeg2CPI(StFreeStyleIndex value) {
        this.inflationLeg2CPI = value;
    }

    /**
     * inflationLeg2Schedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getInflationLeg2Schedule() {
        return inflationLeg2Schedule;
    }

    /**
     * inflationLeg2Schedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setInflationLeg2Schedule(StFreeStyleEventSchedule value) {
        this.inflationLeg2Schedule = value;
    }

    /**
     * inflationLeg2FixingSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getInflationLeg2FixingSchedule() {
        return inflationLeg2FixingSchedule;
    }

    /**
     * inflationLeg2FixingSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setInflationLeg2FixingSchedule(StFreeStyleEventSchedule value) {
        this.inflationLeg2FixingSchedule = value;
    }

    /**
     * inflationLeg2Gearing 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getInflationLeg2Gearing() {
        return inflationLeg2Gearing;
    }

    /**
     * inflationLeg2Gearing 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setInflationLeg2Gearing(StFreeStyleNumber value) {
        this.inflationLeg2Gearing = value;
    }

    /**
     * inflationLeg2Floor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getInflationLeg2Floor() {
        return inflationLeg2Floor;
    }

    /**
     * inflationLeg2Floor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setInflationLeg2Floor(StFreeStyleNumber value) {
        this.inflationLeg2Floor = value;
    }

    /**
     * inflationLeg2InitialCPI 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getInflationLeg2InitialCPI() {
        return inflationLeg2InitialCPI;
    }

    /**
     * inflationLeg2InitialCPI 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setInflationLeg2InitialCPI(StFreeStyleNumber value) {
        this.inflationLeg2InitialCPI = value;
    }

    /**
     * inflationLeg2SubtractNotional 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getInflationLeg2SubtractNotional() {
        return inflationLeg2SubtractNotional;
    }

    /**
     * inflationLeg2SubtractNotional 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setInflationLeg2SubtractNotional(StFreeStyleBool value) {
        this.inflationLeg2SubtractNotional = value;
    }

}
