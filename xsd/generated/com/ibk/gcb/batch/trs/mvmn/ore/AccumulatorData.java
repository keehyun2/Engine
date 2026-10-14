//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>accumulatorData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="accumulatorData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="FixingAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="DailyFixingAmount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Underlying" type="{}underlying"/>
 *         &lt;element name="OptionData" type="{}optionData"/>
 *         &lt;element name="StartDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="ObservationDates" type="{}scheduleData"/>
 *         &lt;element name="PricingDates" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="SettlementDates" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="SettlementLag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlementCalendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="SettlementConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="NakedOption" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="KnockOutSettlementAtPeriodEnd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="KnockOutFixingAtKOSettlement" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FxIndex" type="{}underlying" minOccurs="0"/>
 *         &lt;element name="RangeBounds">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RangeBound" type="{}rangeBound" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Barriers" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BarrierData" type="{}barrierData" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accumulatorData", propOrder = {

})
public class AccumulatorData {

    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "FixingAmount")
    protected float fixingAmount;
    @XmlElement(name = "DailyFixingAmount")
    protected Boolean dailyFixingAmount;
    @XmlElement(name = "Strike")
    protected Float strike;
    @XmlElement(name = "Underlying", required = true)
    protected Underlying underlying;
    @XmlElement(name = "OptionData", required = true)
    protected OptionData optionData;
    @XmlElement(name = "StartDate")
    protected String startDate;
    @XmlElement(name = "ObservationDates", required = true)
    protected ScheduleData observationDates;
    @XmlElement(name = "PricingDates")
    protected ScheduleData pricingDates;
    @XmlElement(name = "SettlementDates")
    protected ScheduleData settlementDates;
    @XmlElement(name = "SettlementLag")
    protected String settlementLag;
    @XmlElement(name = "SettlementCalendar")
    protected String settlementCalendar;
    @XmlElement(name = "SettlementConvention")
    protected String settlementConvention;
    @XmlElement(name = "NakedOption")
    protected Boolean nakedOption;
    @XmlElement(name = "KnockOutSettlementAtPeriodEnd")
    protected Boolean knockOutSettlementAtPeriodEnd;
    @XmlElement(name = "KnockOutFixingAtKOSettlement")
    protected Boolean knockOutFixingAtKOSettlement;
    @XmlElement(name = "FxIndex")
    protected Underlying fxIndex;
    @XmlElement(name = "RangeBounds", required = true)
    protected AccumulatorData.RangeBounds rangeBounds;
    @XmlElement(name = "Barriers")
    protected AccumulatorData.Barriers barriers;

    /**
     * currency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getCurrency() {
        return currency;
    }

    /**
     * currency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setCurrency(CurrencyCode value) {
        this.currency = value;
    }

    /**
     * fixingAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getFixingAmount() {
        return fixingAmount;
    }

    /**
     * fixingAmount 속성의 값을 설정합니다.
     * 
     */
    public void setFixingAmount(float value) {
        this.fixingAmount = value;
    }

    /**
     * dailyFixingAmount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDailyFixingAmount() {
        return dailyFixingAmount;
    }

    /**
     * dailyFixingAmount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDailyFixingAmount(Boolean value) {
        this.dailyFixingAmount = value;
    }

    /**
     * strike 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getStrike() {
        return strike;
    }

    /**
     * strike 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setStrike(Float value) {
        this.strike = value;
    }

    /**
     * underlying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getUnderlying() {
        return underlying;
    }

    /**
     * underlying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setUnderlying(Underlying value) {
        this.underlying = value;
    }

    /**
     * optionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OptionData }
     *     
     */
    public OptionData getOptionData() {
        return optionData;
    }

    /**
     * optionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionData }
     *     
     */
    public void setOptionData(OptionData value) {
        this.optionData = value;
    }

    /**
     * startDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * startDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * observationDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getObservationDates() {
        return observationDates;
    }

    /**
     * observationDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setObservationDates(ScheduleData value) {
        this.observationDates = value;
    }

    /**
     * pricingDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getPricingDates() {
        return pricingDates;
    }

    /**
     * pricingDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setPricingDates(ScheduleData value) {
        this.pricingDates = value;
    }

    /**
     * settlementDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getSettlementDates() {
        return settlementDates;
    }

    /**
     * settlementDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setSettlementDates(ScheduleData value) {
        this.settlementDates = value;
    }

    /**
     * settlementLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementLag() {
        return settlementLag;
    }

    /**
     * settlementLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementLag(String value) {
        this.settlementLag = value;
    }

    /**
     * settlementCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementCalendar() {
        return settlementCalendar;
    }

    /**
     * settlementCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementCalendar(String value) {
        this.settlementCalendar = value;
    }

    /**
     * settlementConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementConvention() {
        return settlementConvention;
    }

    /**
     * settlementConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementConvention(String value) {
        this.settlementConvention = value;
    }

    /**
     * nakedOption 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNakedOption() {
        return nakedOption;
    }

    /**
     * nakedOption 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNakedOption(Boolean value) {
        this.nakedOption = value;
    }

    /**
     * knockOutSettlementAtPeriodEnd 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isKnockOutSettlementAtPeriodEnd() {
        return knockOutSettlementAtPeriodEnd;
    }

    /**
     * knockOutSettlementAtPeriodEnd 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setKnockOutSettlementAtPeriodEnd(Boolean value) {
        this.knockOutSettlementAtPeriodEnd = value;
    }

    /**
     * knockOutFixingAtKOSettlement 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isKnockOutFixingAtKOSettlement() {
        return knockOutFixingAtKOSettlement;
    }

    /**
     * knockOutFixingAtKOSettlement 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setKnockOutFixingAtKOSettlement(Boolean value) {
        this.knockOutFixingAtKOSettlement = value;
    }

    /**
     * fxIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getFxIndex() {
        return fxIndex;
    }

    /**
     * fxIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setFxIndex(Underlying value) {
        this.fxIndex = value;
    }

    /**
     * rangeBounds 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AccumulatorData.RangeBounds }
     *     
     */
    public AccumulatorData.RangeBounds getRangeBounds() {
        return rangeBounds;
    }

    /**
     * rangeBounds 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AccumulatorData.RangeBounds }
     *     
     */
    public void setRangeBounds(AccumulatorData.RangeBounds value) {
        this.rangeBounds = value;
    }

    /**
     * barriers 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AccumulatorData.Barriers }
     *     
     */
    public AccumulatorData.Barriers getBarriers() {
        return barriers;
    }

    /**
     * barriers 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AccumulatorData.Barriers }
     *     
     */
    public void setBarriers(AccumulatorData.Barriers value) {
        this.barriers = value;
    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BarrierData" type="{}barrierData" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "barrierData"
    })
    public static class Barriers {

        @XmlElement(name = "BarrierData", required = true)
        protected List<BarrierData> barrierData;

        /**
         * Gets the value of the barrierData property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the barrierData property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBarrierData().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BarrierData }
         * 
         * 
         */
        public List<BarrierData> getBarrierData() {
            if (barrierData == null) {
                barrierData = new ArrayList<BarrierData>();
            }
            return this.barrierData;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="RangeBound" type="{}rangeBound" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rangeBound"
    })
    public static class RangeBounds {

        @XmlElement(name = "RangeBound", required = true)
        protected List<RangeBound> rangeBound;

        /**
         * Gets the value of the rangeBound property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rangeBound property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRangeBound().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RangeBound }
         * 
         * 
         */
        public List<RangeBound> getRangeBound() {
            if (rangeBound == null) {
                rangeBound = new ArrayList<RangeBound>();
            }
            return this.rangeBound;
        }

    }

}
