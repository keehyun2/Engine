//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>commodityFutureType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="commodityFutureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AnchorDay" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="NthWeekday" type="{}nthWeekdayType"/>
 *                   &lt;element name="DayOfMonth" type="{}dayOfMonth"/>
 *                   &lt;element name="CalendarDaysBefore" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                   &lt;element name="LastWeekday" type="{}weekdayType"/>
 *                   &lt;element name="WeeklyDayOfTheWeek" type="{}weekdayType"/>
 *                   &lt;element name="BusinessDaysAfter" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ContractFrequency" type="{}frequencyType"/>
 *         &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ExpiryCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpiryMonthLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="OneContractMonth" type="{}monthType" minOccurs="0"/>
 *         &lt;element name="OffsetDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="BusinessDayConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="AdjustBeforeOffset" type="{}bool" minOccurs="0"/>
 *         &lt;element name="IsAveraging" type="{}bool" minOccurs="0"/>
 *         &lt;element name="ProhibitedExpiries" type="{}prohibitedExpiriesType" minOccurs="0"/>
 *         &lt;element name="ValidContractMonths" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Month" type="{}monthType" maxOccurs="12"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OptionExpiryMonthLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="OptionContractFrequency" type="{}frequencyType" minOccurs="0"/>
 *         &lt;element name="OptionExpiryOffset" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="OptionCalendarDaysBefore" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="OptionMinBusinessDaysBefore" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="OptionExpiryDay" type="{}dayOfMonth" minOccurs="0"/>
 *         &lt;element name="OptionNthWeekday" type="{}nthWeekdayType" minOccurs="0"/>
 *         &lt;element name="OptionExpiryLastWeekdayOfMonth" type="{}weekdayType" minOccurs="0"/>
 *         &lt;element name="OptionExpiryWeeklyDayOfTheWeek" type="{}weekdayType" minOccurs="0"/>
 *         &lt;element name="OptionBusinessDayConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="FutureContinuationMappings" type="{}continuationMappingsType" minOccurs="0"/>
 *         &lt;element name="OptionContinuationMappings" type="{}continuationMappingsType" minOccurs="0"/>
 *         &lt;element name="AveragingData" type="{}averagingDataType" minOccurs="0"/>
 *         &lt;element name="HoursPerDay" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="OffPeakPowerIndexData" type="{}offPeakPowerIndexDataType" minOccurs="0"/>
 *         &lt;element name="IndexName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SavingsTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BalanceOfTheMonth" type="{}bool" minOccurs="0"/>
 *         &lt;element name="BalanceOfTheMonthPricingCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OptionUnderlyingFutureConvention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commodityFutureType", propOrder = {

})
public class CommodityFutureType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "AnchorDay")
    protected CommodityFutureType.AnchorDay anchorDay;
    @XmlElement(name = "ContractFrequency", required = true)
    @XmlSchemaType(name = "string")
    protected FrequencyType contractFrequency;
    @XmlElement(name = "Calendar", required = true)
    protected String calendar;
    @XmlElement(name = "ExpiryCalendar")
    protected String expiryCalendar;
    @XmlElement(name = "ExpiryMonthLag")
    protected BigInteger expiryMonthLag;
    @XmlElement(name = "OneContractMonth")
    @XmlSchemaType(name = "string")
    protected MonthType oneContractMonth;
    @XmlElement(name = "OffsetDays")
    protected BigInteger offsetDays;
    @XmlElement(name = "BusinessDayConvention")
    protected String businessDayConvention;
    @XmlElement(name = "AdjustBeforeOffset")
    protected String adjustBeforeOffset;
    @XmlElement(name = "IsAveraging")
    protected String isAveraging;
    @XmlElement(name = "ProhibitedExpiries")
    protected ProhibitedExpiriesType prohibitedExpiries;
    @XmlElement(name = "ValidContractMonths")
    protected CommodityFutureType.ValidContractMonths validContractMonths;
    @XmlElement(name = "OptionExpiryMonthLag")
    protected BigInteger optionExpiryMonthLag;
    @XmlElement(name = "OptionContractFrequency")
    @XmlSchemaType(name = "string")
    protected FrequencyType optionContractFrequency;
    @XmlElement(name = "OptionExpiryOffset")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger optionExpiryOffset;
    @XmlElement(name = "OptionCalendarDaysBefore")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger optionCalendarDaysBefore;
    @XmlElement(name = "OptionMinBusinessDaysBefore")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger optionMinBusinessDaysBefore;
    @XmlElement(name = "OptionExpiryDay")
    @XmlSchemaType(name = "integer")
    protected Integer optionExpiryDay;
    @XmlElement(name = "OptionNthWeekday")
    protected NthWeekdayType optionNthWeekday;
    @XmlElement(name = "OptionExpiryLastWeekdayOfMonth")
    @XmlSchemaType(name = "string")
    protected WeekdayType optionExpiryLastWeekdayOfMonth;
    @XmlElement(name = "OptionExpiryWeeklyDayOfTheWeek")
    @XmlSchemaType(name = "string")
    protected WeekdayType optionExpiryWeeklyDayOfTheWeek;
    @XmlElement(name = "OptionBusinessDayConvention")
    protected String optionBusinessDayConvention;
    @XmlElement(name = "FutureContinuationMappings")
    protected ContinuationMappingsType futureContinuationMappings;
    @XmlElement(name = "OptionContinuationMappings")
    protected ContinuationMappingsType optionContinuationMappings;
    @XmlElement(name = "AveragingData")
    protected AveragingDataType averagingData;
    @XmlElement(name = "HoursPerDay")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger hoursPerDay;
    @XmlElement(name = "OffPeakPowerIndexData")
    protected OffPeakPowerIndexDataType offPeakPowerIndexData;
    @XmlElement(name = "IndexName")
    protected String indexName;
    @XmlElement(name = "SavingsTime")
    protected String savingsTime;
    @XmlElement(name = "BalanceOfTheMonth")
    protected String balanceOfTheMonth;
    @XmlElement(name = "BalanceOfTheMonthPricingCalendar")
    protected String balanceOfTheMonthPricingCalendar;
    @XmlElement(name = "OptionUnderlyingFutureConvention")
    protected String optionUnderlyingFutureConvention;

    /**
     * id 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * id 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * anchorDay 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityFutureType.AnchorDay }
     *     
     */
    public CommodityFutureType.AnchorDay getAnchorDay() {
        return anchorDay;
    }

    /**
     * anchorDay 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityFutureType.AnchorDay }
     *     
     */
    public void setAnchorDay(CommodityFutureType.AnchorDay value) {
        this.anchorDay = value;
    }

    /**
     * contractFrequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyType }
     *     
     */
    public FrequencyType getContractFrequency() {
        return contractFrequency;
    }

    /**
     * contractFrequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyType }
     *     
     */
    public void setContractFrequency(FrequencyType value) {
        this.contractFrequency = value;
    }

    /**
     * calendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalendar() {
        return calendar;
    }

    /**
     * calendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalendar(String value) {
        this.calendar = value;
    }

    /**
     * expiryCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryCalendar() {
        return expiryCalendar;
    }

    /**
     * expiryCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryCalendar(String value) {
        this.expiryCalendar = value;
    }

    /**
     * expiryMonthLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getExpiryMonthLag() {
        return expiryMonthLag;
    }

    /**
     * expiryMonthLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setExpiryMonthLag(BigInteger value) {
        this.expiryMonthLag = value;
    }

    /**
     * oneContractMonth 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MonthType }
     *     
     */
    public MonthType getOneContractMonth() {
        return oneContractMonth;
    }

    /**
     * oneContractMonth 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MonthType }
     *     
     */
    public void setOneContractMonth(MonthType value) {
        this.oneContractMonth = value;
    }

    /**
     * offsetDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOffsetDays() {
        return offsetDays;
    }

    /**
     * offsetDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOffsetDays(BigInteger value) {
        this.offsetDays = value;
    }

    /**
     * businessDayConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessDayConvention() {
        return businessDayConvention;
    }

    /**
     * businessDayConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessDayConvention(String value) {
        this.businessDayConvention = value;
    }

    /**
     * adjustBeforeOffset 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdjustBeforeOffset() {
        return adjustBeforeOffset;
    }

    /**
     * adjustBeforeOffset 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdjustBeforeOffset(String value) {
        this.adjustBeforeOffset = value;
    }

    /**
     * isAveraging 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsAveraging() {
        return isAveraging;
    }

    /**
     * isAveraging 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAveraging(String value) {
        this.isAveraging = value;
    }

    /**
     * prohibitedExpiries 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ProhibitedExpiriesType }
     *     
     */
    public ProhibitedExpiriesType getProhibitedExpiries() {
        return prohibitedExpiries;
    }

    /**
     * prohibitedExpiries 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ProhibitedExpiriesType }
     *     
     */
    public void setProhibitedExpiries(ProhibitedExpiriesType value) {
        this.prohibitedExpiries = value;
    }

    /**
     * validContractMonths 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityFutureType.ValidContractMonths }
     *     
     */
    public CommodityFutureType.ValidContractMonths getValidContractMonths() {
        return validContractMonths;
    }

    /**
     * validContractMonths 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityFutureType.ValidContractMonths }
     *     
     */
    public void setValidContractMonths(CommodityFutureType.ValidContractMonths value) {
        this.validContractMonths = value;
    }

    /**
     * optionExpiryMonthLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOptionExpiryMonthLag() {
        return optionExpiryMonthLag;
    }

    /**
     * optionExpiryMonthLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOptionExpiryMonthLag(BigInteger value) {
        this.optionExpiryMonthLag = value;
    }

    /**
     * optionContractFrequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyType }
     *     
     */
    public FrequencyType getOptionContractFrequency() {
        return optionContractFrequency;
    }

    /**
     * optionContractFrequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyType }
     *     
     */
    public void setOptionContractFrequency(FrequencyType value) {
        this.optionContractFrequency = value;
    }

    /**
     * optionExpiryOffset 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOptionExpiryOffset() {
        return optionExpiryOffset;
    }

    /**
     * optionExpiryOffset 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOptionExpiryOffset(BigInteger value) {
        this.optionExpiryOffset = value;
    }

    /**
     * optionCalendarDaysBefore 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOptionCalendarDaysBefore() {
        return optionCalendarDaysBefore;
    }

    /**
     * optionCalendarDaysBefore 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOptionCalendarDaysBefore(BigInteger value) {
        this.optionCalendarDaysBefore = value;
    }

    /**
     * optionMinBusinessDaysBefore 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOptionMinBusinessDaysBefore() {
        return optionMinBusinessDaysBefore;
    }

    /**
     * optionMinBusinessDaysBefore 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOptionMinBusinessDaysBefore(BigInteger value) {
        this.optionMinBusinessDaysBefore = value;
    }

    /**
     * optionExpiryDay 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOptionExpiryDay() {
        return optionExpiryDay;
    }

    /**
     * optionExpiryDay 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOptionExpiryDay(Integer value) {
        this.optionExpiryDay = value;
    }

    /**
     * optionNthWeekday 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link NthWeekdayType }
     *     
     */
    public NthWeekdayType getOptionNthWeekday() {
        return optionNthWeekday;
    }

    /**
     * optionNthWeekday 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link NthWeekdayType }
     *     
     */
    public void setOptionNthWeekday(NthWeekdayType value) {
        this.optionNthWeekday = value;
    }

    /**
     * optionExpiryLastWeekdayOfMonth 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WeekdayType }
     *     
     */
    public WeekdayType getOptionExpiryLastWeekdayOfMonth() {
        return optionExpiryLastWeekdayOfMonth;
    }

    /**
     * optionExpiryLastWeekdayOfMonth 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WeekdayType }
     *     
     */
    public void setOptionExpiryLastWeekdayOfMonth(WeekdayType value) {
        this.optionExpiryLastWeekdayOfMonth = value;
    }

    /**
     * optionExpiryWeeklyDayOfTheWeek 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WeekdayType }
     *     
     */
    public WeekdayType getOptionExpiryWeeklyDayOfTheWeek() {
        return optionExpiryWeeklyDayOfTheWeek;
    }

    /**
     * optionExpiryWeeklyDayOfTheWeek 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WeekdayType }
     *     
     */
    public void setOptionExpiryWeeklyDayOfTheWeek(WeekdayType value) {
        this.optionExpiryWeeklyDayOfTheWeek = value;
    }

    /**
     * optionBusinessDayConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionBusinessDayConvention() {
        return optionBusinessDayConvention;
    }

    /**
     * optionBusinessDayConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionBusinessDayConvention(String value) {
        this.optionBusinessDayConvention = value;
    }

    /**
     * futureContinuationMappings 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ContinuationMappingsType }
     *     
     */
    public ContinuationMappingsType getFutureContinuationMappings() {
        return futureContinuationMappings;
    }

    /**
     * futureContinuationMappings 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ContinuationMappingsType }
     *     
     */
    public void setFutureContinuationMappings(ContinuationMappingsType value) {
        this.futureContinuationMappings = value;
    }

    /**
     * optionContinuationMappings 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ContinuationMappingsType }
     *     
     */
    public ContinuationMappingsType getOptionContinuationMappings() {
        return optionContinuationMappings;
    }

    /**
     * optionContinuationMappings 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ContinuationMappingsType }
     *     
     */
    public void setOptionContinuationMappings(ContinuationMappingsType value) {
        this.optionContinuationMappings = value;
    }

    /**
     * averagingData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AveragingDataType }
     *     
     */
    public AveragingDataType getAveragingData() {
        return averagingData;
    }

    /**
     * averagingData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AveragingDataType }
     *     
     */
    public void setAveragingData(AveragingDataType value) {
        this.averagingData = value;
    }

    /**
     * hoursPerDay 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHoursPerDay() {
        return hoursPerDay;
    }

    /**
     * hoursPerDay 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHoursPerDay(BigInteger value) {
        this.hoursPerDay = value;
    }

    /**
     * offPeakPowerIndexData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OffPeakPowerIndexDataType }
     *     
     */
    public OffPeakPowerIndexDataType getOffPeakPowerIndexData() {
        return offPeakPowerIndexData;
    }

    /**
     * offPeakPowerIndexData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OffPeakPowerIndexDataType }
     *     
     */
    public void setOffPeakPowerIndexData(OffPeakPowerIndexDataType value) {
        this.offPeakPowerIndexData = value;
    }

    /**
     * indexName 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexName() {
        return indexName;
    }

    /**
     * indexName 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexName(String value) {
        this.indexName = value;
    }

    /**
     * savingsTime 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSavingsTime() {
        return savingsTime;
    }

    /**
     * savingsTime 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSavingsTime(String value) {
        this.savingsTime = value;
    }

    /**
     * balanceOfTheMonth 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceOfTheMonth() {
        return balanceOfTheMonth;
    }

    /**
     * balanceOfTheMonth 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceOfTheMonth(String value) {
        this.balanceOfTheMonth = value;
    }

    /**
     * balanceOfTheMonthPricingCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceOfTheMonthPricingCalendar() {
        return balanceOfTheMonthPricingCalendar;
    }

    /**
     * balanceOfTheMonthPricingCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceOfTheMonthPricingCalendar(String value) {
        this.balanceOfTheMonthPricingCalendar = value;
    }

    /**
     * optionUnderlyingFutureConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionUnderlyingFutureConvention() {
        return optionUnderlyingFutureConvention;
    }

    /**
     * optionUnderlyingFutureConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionUnderlyingFutureConvention(String value) {
        this.optionUnderlyingFutureConvention = value;
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
     *       &lt;choice>
     *         &lt;element name="NthWeekday" type="{}nthWeekdayType"/>
     *         &lt;element name="DayOfMonth" type="{}dayOfMonth"/>
     *         &lt;element name="CalendarDaysBefore" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *         &lt;element name="LastWeekday" type="{}weekdayType"/>
     *         &lt;element name="WeeklyDayOfTheWeek" type="{}weekdayType"/>
     *         &lt;element name="BusinessDaysAfter" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nthWeekday",
        "dayOfMonth",
        "calendarDaysBefore",
        "lastWeekday",
        "weeklyDayOfTheWeek",
        "businessDaysAfter"
    })
    public static class AnchorDay {

        @XmlElement(name = "NthWeekday")
        protected NthWeekdayType nthWeekday;
        @XmlElement(name = "DayOfMonth")
        @XmlSchemaType(name = "integer")
        protected Integer dayOfMonth;
        @XmlElement(name = "CalendarDaysBefore")
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger calendarDaysBefore;
        @XmlElement(name = "LastWeekday")
        @XmlSchemaType(name = "string")
        protected WeekdayType lastWeekday;
        @XmlElement(name = "WeeklyDayOfTheWeek")
        @XmlSchemaType(name = "string")
        protected WeekdayType weeklyDayOfTheWeek;
        @XmlElement(name = "BusinessDaysAfter")
        protected BigInteger businessDaysAfter;

        /**
         * nthWeekday 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link NthWeekdayType }
         *     
         */
        public NthWeekdayType getNthWeekday() {
            return nthWeekday;
        }

        /**
         * nthWeekday 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link NthWeekdayType }
         *     
         */
        public void setNthWeekday(NthWeekdayType value) {
            this.nthWeekday = value;
        }

        /**
         * dayOfMonth 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getDayOfMonth() {
            return dayOfMonth;
        }

        /**
         * dayOfMonth 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setDayOfMonth(Integer value) {
            this.dayOfMonth = value;
        }

        /**
         * calendarDaysBefore 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getCalendarDaysBefore() {
            return calendarDaysBefore;
        }

        /**
         * calendarDaysBefore 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setCalendarDaysBefore(BigInteger value) {
            this.calendarDaysBefore = value;
        }

        /**
         * lastWeekday 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link WeekdayType }
         *     
         */
        public WeekdayType getLastWeekday() {
            return lastWeekday;
        }

        /**
         * lastWeekday 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link WeekdayType }
         *     
         */
        public void setLastWeekday(WeekdayType value) {
            this.lastWeekday = value;
        }

        /**
         * weeklyDayOfTheWeek 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link WeekdayType }
         *     
         */
        public WeekdayType getWeeklyDayOfTheWeek() {
            return weeklyDayOfTheWeek;
        }

        /**
         * weeklyDayOfTheWeek 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link WeekdayType }
         *     
         */
        public void setWeeklyDayOfTheWeek(WeekdayType value) {
            this.weeklyDayOfTheWeek = value;
        }

        /**
         * businessDaysAfter 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBusinessDaysAfter() {
            return businessDaysAfter;
        }

        /**
         * businessDaysAfter 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBusinessDaysAfter(BigInteger value) {
            this.businessDaysAfter = value;
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
     *         &lt;element name="Month" type="{}monthType" maxOccurs="12"/>
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
        "month"
    })
    public static class ValidContractMonths {

        @XmlElement(name = "Month", required = true)
        @XmlSchemaType(name = "string")
        protected List<MonthType> month;

        /**
         * Gets the value of the month property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the month property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMonth().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MonthType }
         * 
         * 
         */
        public List<MonthType> getMonth() {
            if (month == null) {
                month = new ArrayList<MonthType>();
            }
            return this.month;
        }

    }

}
