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
 * <p>commodityRevenueOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="commodityRevenueOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="PutCall" type="{}stFreeStyleOptionType"/>
 *         &lt;element name="LongShort" type="{}stFreeStyleLongShort"/>
 *         &lt;element name="ObservationDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="ValuationDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="SettlementSchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="TrueUp" type="{}stFreeStyleNumber"/>
 *         &lt;element name="MonthlySchedule" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="MonthlyBaseloadCapacity" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="MonthlyDuctFiredCapacity" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="MonthlyBaseloadHeatRate" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="MonthlyDuctFiredHeatRate" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="VOM" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="HoursPerDay" type="{}stFreeStyleNumber"/>
 *         &lt;element name="GasIndex" type="{}stFreeStyleIndex"/>
 *         &lt;element name="EnergyIndex" type="{}stFreeStyleIndex"/>
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
@XmlType(name = "commodityRevenueOptionData", propOrder = {

})
public class CommodityRevenueOptionData {

    @XmlElement(name = "PutCall", required = true)
    protected StFreeStyleOptionType putCall;
    @XmlElement(name = "LongShort", required = true)
    protected StFreeStyleLongShort longShort;
    @XmlElement(name = "ObservationDates", required = true)
    protected StFreeStyleEventSchedule observationDates;
    @XmlElement(name = "ValuationDates", required = true)
    protected StFreeStyleEventSchedule valuationDates;
    @XmlElement(name = "SettlementSchedule", required = true)
    protected StFreeStyleEventSchedule settlementSchedule;
    @XmlElement(name = "TrueUp", required = true)
    protected StFreeStyleNumber trueUp;
    @XmlElement(name = "MonthlySchedule", required = true)
    protected StFreeStyleEventSchedule monthlySchedule;
    @XmlElement(name = "MonthlyBaseloadCapacity", required = true)
    protected StFreeStyleNumberVector monthlyBaseloadCapacity;
    @XmlElement(name = "MonthlyDuctFiredCapacity", required = true)
    protected StFreeStyleNumberVector monthlyDuctFiredCapacity;
    @XmlElement(name = "MonthlyBaseloadHeatRate", required = true)
    protected StFreeStyleNumberVector monthlyBaseloadHeatRate;
    @XmlElement(name = "MonthlyDuctFiredHeatRate", required = true)
    protected StFreeStyleNumberVector monthlyDuctFiredHeatRate;
    @XmlElement(name = "VOM", required = true)
    protected StFreeStyleNumberVector vom;
    @XmlElement(name = "HoursPerDay", required = true)
    protected StFreeStyleNumber hoursPerDay;
    @XmlElement(name = "GasIndex", required = true)
    protected StFreeStyleIndex gasIndex;
    @XmlElement(name = "EnergyIndex", required = true)
    protected StFreeStyleIndex energyIndex;
    @XmlElement(name = "PayCcy", required = true)
    protected StFreeStyleCurrency payCcy;

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
     * observationDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getObservationDates() {
        return observationDates;
    }

    /**
     * observationDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setObservationDates(StFreeStyleEventSchedule value) {
        this.observationDates = value;
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
     * settlementSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getSettlementSchedule() {
        return settlementSchedule;
    }

    /**
     * settlementSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setSettlementSchedule(StFreeStyleEventSchedule value) {
        this.settlementSchedule = value;
    }

    /**
     * trueUp 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getTrueUp() {
        return trueUp;
    }

    /**
     * trueUp 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setTrueUp(StFreeStyleNumber value) {
        this.trueUp = value;
    }

    /**
     * monthlySchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getMonthlySchedule() {
        return monthlySchedule;
    }

    /**
     * monthlySchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setMonthlySchedule(StFreeStyleEventSchedule value) {
        this.monthlySchedule = value;
    }

    /**
     * monthlyBaseloadCapacity 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getMonthlyBaseloadCapacity() {
        return monthlyBaseloadCapacity;
    }

    /**
     * monthlyBaseloadCapacity 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setMonthlyBaseloadCapacity(StFreeStyleNumberVector value) {
        this.monthlyBaseloadCapacity = value;
    }

    /**
     * monthlyDuctFiredCapacity 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getMonthlyDuctFiredCapacity() {
        return monthlyDuctFiredCapacity;
    }

    /**
     * monthlyDuctFiredCapacity 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setMonthlyDuctFiredCapacity(StFreeStyleNumberVector value) {
        this.monthlyDuctFiredCapacity = value;
    }

    /**
     * monthlyBaseloadHeatRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getMonthlyBaseloadHeatRate() {
        return monthlyBaseloadHeatRate;
    }

    /**
     * monthlyBaseloadHeatRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setMonthlyBaseloadHeatRate(StFreeStyleNumberVector value) {
        this.monthlyBaseloadHeatRate = value;
    }

    /**
     * monthlyDuctFiredHeatRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getMonthlyDuctFiredHeatRate() {
        return monthlyDuctFiredHeatRate;
    }

    /**
     * monthlyDuctFiredHeatRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setMonthlyDuctFiredHeatRate(StFreeStyleNumberVector value) {
        this.monthlyDuctFiredHeatRate = value;
    }

    /**
     * vom 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getVOM() {
        return vom;
    }

    /**
     * vom 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setVOM(StFreeStyleNumberVector value) {
        this.vom = value;
    }

    /**
     * hoursPerDay 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getHoursPerDay() {
        return hoursPerDay;
    }

    /**
     * hoursPerDay 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setHoursPerDay(StFreeStyleNumber value) {
        this.hoursPerDay = value;
    }

    /**
     * gasIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public StFreeStyleIndex getGasIndex() {
        return gasIndex;
    }

    /**
     * gasIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public void setGasIndex(StFreeStyleIndex value) {
        this.gasIndex = value;
    }

    /**
     * energyIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public StFreeStyleIndex getEnergyIndex() {
        return energyIndex;
    }

    /**
     * energyIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleIndex }
     *     
     */
    public void setEnergyIndex(StFreeStyleIndex value) {
        this.energyIndex = value;
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
