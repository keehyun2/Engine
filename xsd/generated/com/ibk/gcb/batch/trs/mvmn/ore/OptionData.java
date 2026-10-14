//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>optionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="optionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OptionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayoffType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayoffType2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Style" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoticePeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoticeCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoticeConvention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MidCouponExercise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Settlement" type="{}settlementType" minOccurs="0"/>
 *         &lt;element name="SettlementMethod" type="{}settlementMethod" minOccurs="0"/>
 *         &lt;element name="PayOffAtExpiry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PremiumAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PremiumCurrency" type="{}premiumCurrencyCode" minOccurs="0"/>
 *         &lt;element name="PremiumPayDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Premiums" type="{}premiumData" minOccurs="0"/>
 *         &lt;element name="ExercisePrices" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExerciseFees" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ExerciseFee" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ExerciseFeeSettlementPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExerciseFeeSettlementCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExerciseFeeSettlementConvention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}exerciseDatesGroup" minOccurs="0"/>
 *         &lt;element name="AutomaticExercise" type="{}bool" minOccurs="0"/>
 *         &lt;element name="ExerciseData" type="{}optionExerciseData" minOccurs="0"/>
 *         &lt;element name="PaymentData" type="{}optionPaymentData" minOccurs="0"/>
 *         &lt;element name="SettlementData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="PayCurrency" type="{}currencyCode"/>
 *                   &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="FixingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/all>
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
@XmlType(name = "optionData", propOrder = {

})
public class OptionData {

    @XmlElement(name = "LongShort", required = true)
    protected String longShort;
    @XmlElement(name = "OptionType")
    protected String optionType;
    @XmlElement(name = "PayoffType")
    protected String payoffType;
    @XmlElement(name = "PayoffType2")
    protected String payoffType2;
    @XmlElement(name = "Style")
    protected String style;
    @XmlElement(name = "NoticePeriod")
    protected String noticePeriod;
    @XmlElement(name = "NoticeCalendar")
    protected String noticeCalendar;
    @XmlElement(name = "NoticeConvention")
    protected String noticeConvention;
    @XmlElement(name = "MidCouponExercise")
    protected String midCouponExercise;
    @XmlElement(name = "Settlement")
    @XmlSchemaType(name = "string")
    protected SettlementType settlement;
    @XmlElement(name = "SettlementMethod")
    @XmlSchemaType(name = "string")
    protected SettlementMethod settlementMethod;
    @XmlElement(name = "PayOffAtExpiry")
    protected String payOffAtExpiry;
    @XmlElement(name = "PremiumAmount")
    protected String premiumAmount;
    @XmlElement(name = "PremiumCurrency")
    protected String premiumCurrency;
    @XmlElement(name = "PremiumPayDate")
    protected String premiumPayDate;
    @XmlElement(name = "Premiums")
    protected PremiumData premiums;
    @XmlElement(name = "ExercisePrices")
    protected String exercisePrices;
    @XmlElement(name = "ExerciseFees")
    protected OptionData.ExerciseFees exerciseFees;
    @XmlElement(name = "ExerciseFeeSettlementPeriod")
    protected String exerciseFeeSettlementPeriod;
    @XmlElement(name = "ExerciseFeeSettlementCalendar")
    protected String exerciseFeeSettlementCalendar;
    @XmlElement(name = "ExerciseFeeSettlementConvention")
    protected String exerciseFeeSettlementConvention;
    @XmlElementRef(name = "exerciseDatesGroup", type = JAXBElement.class, required = false)
    protected JAXBElement<?> exerciseDatesGroup;
    @XmlElement(name = "AutomaticExercise")
    protected String automaticExercise;
    @XmlElement(name = "ExerciseData")
    protected OptionExerciseData exerciseData;
    @XmlElement(name = "PaymentData")
    protected OptionPaymentData paymentData;
    @XmlElement(name = "SettlementData")
    protected OptionData.SettlementData settlementData;

    /**
     * longShort 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongShort() {
        return longShort;
    }

    /**
     * longShort 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongShort(String value) {
        this.longShort = value;
    }

    /**
     * optionType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionType() {
        return optionType;
    }

    /**
     * optionType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionType(String value) {
        this.optionType = value;
    }

    /**
     * payoffType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayoffType() {
        return payoffType;
    }

    /**
     * payoffType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayoffType(String value) {
        this.payoffType = value;
    }

    /**
     * payoffType2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayoffType2() {
        return payoffType2;
    }

    /**
     * payoffType2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayoffType2(String value) {
        this.payoffType2 = value;
    }

    /**
     * style 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * style 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }

    /**
     * noticePeriod 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoticePeriod() {
        return noticePeriod;
    }

    /**
     * noticePeriod 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoticePeriod(String value) {
        this.noticePeriod = value;
    }

    /**
     * noticeCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoticeCalendar() {
        return noticeCalendar;
    }

    /**
     * noticeCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoticeCalendar(String value) {
        this.noticeCalendar = value;
    }

    /**
     * noticeConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoticeConvention() {
        return noticeConvention;
    }

    /**
     * noticeConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoticeConvention(String value) {
        this.noticeConvention = value;
    }

    /**
     * midCouponExercise 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMidCouponExercise() {
        return midCouponExercise;
    }

    /**
     * midCouponExercise 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMidCouponExercise(String value) {
        this.midCouponExercise = value;
    }

    /**
     * settlement 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SettlementType }
     *     
     */
    public SettlementType getSettlement() {
        return settlement;
    }

    /**
     * settlement 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementType }
     *     
     */
    public void setSettlement(SettlementType value) {
        this.settlement = value;
    }

    /**
     * settlementMethod 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SettlementMethod }
     *     
     */
    public SettlementMethod getSettlementMethod() {
        return settlementMethod;
    }

    /**
     * settlementMethod 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementMethod }
     *     
     */
    public void setSettlementMethod(SettlementMethod value) {
        this.settlementMethod = value;
    }

    /**
     * payOffAtExpiry 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayOffAtExpiry() {
        return payOffAtExpiry;
    }

    /**
     * payOffAtExpiry 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayOffAtExpiry(String value) {
        this.payOffAtExpiry = value;
    }

    /**
     * premiumAmount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiumAmount() {
        return premiumAmount;
    }

    /**
     * premiumAmount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiumAmount(String value) {
        this.premiumAmount = value;
    }

    /**
     * premiumCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiumCurrency() {
        return premiumCurrency;
    }

    /**
     * premiumCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiumCurrency(String value) {
        this.premiumCurrency = value;
    }

    /**
     * premiumPayDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiumPayDate() {
        return premiumPayDate;
    }

    /**
     * premiumPayDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiumPayDate(String value) {
        this.premiumPayDate = value;
    }

    /**
     * premiums 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PremiumData }
     *     
     */
    public PremiumData getPremiums() {
        return premiums;
    }

    /**
     * premiums 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PremiumData }
     *     
     */
    public void setPremiums(PremiumData value) {
        this.premiums = value;
    }

    /**
     * exercisePrices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExercisePrices() {
        return exercisePrices;
    }

    /**
     * exercisePrices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExercisePrices(String value) {
        this.exercisePrices = value;
    }

    /**
     * exerciseFees 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OptionData.ExerciseFees }
     *     
     */
    public OptionData.ExerciseFees getExerciseFees() {
        return exerciseFees;
    }

    /**
     * exerciseFees 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionData.ExerciseFees }
     *     
     */
    public void setExerciseFees(OptionData.ExerciseFees value) {
        this.exerciseFees = value;
    }

    /**
     * exerciseFeeSettlementPeriod 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExerciseFeeSettlementPeriod() {
        return exerciseFeeSettlementPeriod;
    }

    /**
     * exerciseFeeSettlementPeriod 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExerciseFeeSettlementPeriod(String value) {
        this.exerciseFeeSettlementPeriod = value;
    }

    /**
     * exerciseFeeSettlementCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExerciseFeeSettlementCalendar() {
        return exerciseFeeSettlementCalendar;
    }

    /**
     * exerciseFeeSettlementCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExerciseFeeSettlementCalendar(String value) {
        this.exerciseFeeSettlementCalendar = value;
    }

    /**
     * exerciseFeeSettlementConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExerciseFeeSettlementConvention() {
        return exerciseFeeSettlementConvention;
    }

    /**
     * exerciseFeeSettlementConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExerciseFeeSettlementConvention(String value) {
        this.exerciseFeeSettlementConvention = value;
    }

    /**
     * exerciseDatesGroup 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ScheduleData }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExerciseDates }{@code >}
     *     
     */
    public JAXBElement<?> getExerciseDatesGroup() {
        return exerciseDatesGroup;
    }

    /**
     * exerciseDatesGroup 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ScheduleData }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExerciseDates }{@code >}
     *     
     */
    public void setExerciseDatesGroup(JAXBElement<?> value) {
        this.exerciseDatesGroup = value;
    }

    /**
     * automaticExercise 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutomaticExercise() {
        return automaticExercise;
    }

    /**
     * automaticExercise 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutomaticExercise(String value) {
        this.automaticExercise = value;
    }

    /**
     * exerciseData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OptionExerciseData }
     *     
     */
    public OptionExerciseData getExerciseData() {
        return exerciseData;
    }

    /**
     * exerciseData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionExerciseData }
     *     
     */
    public void setExerciseData(OptionExerciseData value) {
        this.exerciseData = value;
    }

    /**
     * paymentData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OptionPaymentData }
     *     
     */
    public OptionPaymentData getPaymentData() {
        return paymentData;
    }

    /**
     * paymentData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionPaymentData }
     *     
     */
    public void setPaymentData(OptionPaymentData value) {
        this.paymentData = value;
    }

    /**
     * settlementData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OptionData.SettlementData }
     *     
     */
    public OptionData.SettlementData getSettlementData() {
        return settlementData;
    }

    /**
     * settlementData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionData.SettlementData }
     *     
     */
    public void setSettlementData(OptionData.SettlementData value) {
        this.settlementData = value;
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
     *         &lt;element name="ExerciseFee" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "exerciseFee"
    })
    public static class ExerciseFees {

        @XmlElement(name = "ExerciseFee")
        protected List<OptionData.ExerciseFees.ExerciseFee> exerciseFee;

        /**
         * Gets the value of the exerciseFee property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the exerciseFee property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExerciseFee().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OptionData.ExerciseFees.ExerciseFee }
         * 
         * 
         */
        public List<OptionData.ExerciseFees.ExerciseFee> getExerciseFee() {
            if (exerciseFee == null) {
                exerciseFee = new ArrayList<OptionData.ExerciseFees.ExerciseFee>();
            }
            return this.exerciseFee;
        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class ExerciseFee {

            @XmlValue
            protected float value;
            @XmlAttribute(name = "type")
            protected String type;
            @XmlAttribute(name = "startDate")
            protected String startDate;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             */
            public float getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             */
            public void setValue(float value) {
                this.value = value;
            }

            /**
             * type 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * type 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
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
     *       &lt;all>
     *         &lt;element name="PayCurrency" type="{}currencyCode"/>
     *         &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="FixingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class SettlementData {

        @XmlElement(name = "PayCurrency", required = true)
        @XmlSchemaType(name = "string")
        protected CurrencyCode payCurrency;
        @XmlElement(name = "FXIndex", required = true)
        protected String fxIndex;
        @XmlElement(name = "FixingDate")
        protected String fixingDate;

        /**
         * payCurrency 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link CurrencyCode }
         *     
         */
        public CurrencyCode getPayCurrency() {
            return payCurrency;
        }

        /**
         * payCurrency 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link CurrencyCode }
         *     
         */
        public void setPayCurrency(CurrencyCode value) {
            this.payCurrency = value;
        }

        /**
         * fxIndex 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFXIndex() {
            return fxIndex;
        }

        /**
         * fxIndex 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFXIndex(String value) {
            this.fxIndex = value;
        }

        /**
         * fixingDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFixingDate() {
            return fixingDate;
        }

        /**
         * fixingDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFixingDate(String value) {
            this.fixingDate = value;
        }

    }

}
