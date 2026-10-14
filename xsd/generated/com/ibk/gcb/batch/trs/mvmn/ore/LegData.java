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
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>legData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="legData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Payer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LegType" type="{}legType"/>
 *         &lt;element name="Currency" type="{}extendedCurrencyCode" minOccurs="0"/>
 *         &lt;element name="PaymentConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="PaymentLag" type="{}paymentLag" minOccurs="0"/>
 *         &lt;element name="NotionalPaymentLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="PaymentCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="Amortizations" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AmortizationData" type="{}amortizationData" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Notionals" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="Notional" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                           &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="FXReset" type="{}fxreset" minOccurs="0"/>
 *                   &lt;element name="Exchanges" type="{}exchanges" minOccurs="0"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ScheduleData" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="PaymentDates" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PaymentDate" type="{}date" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Indexings" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FromAssetLeg" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="Indexing" type="{}indexingData" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LastPeriodDayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element ref="{}legDataType" minOccurs="0"/>
 *         &lt;element name="StrictNotionalDates" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PaymentSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="SettlementData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
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
@XmlType(name = "legData", propOrder = {

})
public class LegData {

    @XmlElement(name = "Payer")
    protected boolean payer;
    @XmlElement(name = "LegType", required = true)
    @XmlSchemaType(name = "string")
    protected LegType legType;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "PaymentConvention")
    protected String paymentConvention;
    @XmlElement(name = "PaymentLag")
    protected String paymentLag;
    @XmlElement(name = "NotionalPaymentLag")
    protected BigInteger notionalPaymentLag;
    @XmlElement(name = "PaymentCalendar")
    protected String paymentCalendar;
    @XmlElement(name = "DayCounter")
    protected String dayCounter;
    @XmlElement(name = "Amortizations")
    protected LegData.Amortizations amortizations;
    @XmlElement(name = "Notionals")
    protected LegData.Notionals notionals;
    @XmlElement(name = "ScheduleData")
    protected ScheduleData scheduleData;
    @XmlElement(name = "PaymentDates")
    protected LegData.PaymentDates paymentDates;
    @XmlElement(name = "Indexings")
    protected LegData.Indexings indexings;
    @XmlElement(name = "LastPeriodDayCounter")
    protected String lastPeriodDayCounter;
    @XmlElementRef(name = "legDataType", type = JAXBElement.class, required = false)
    protected JAXBElement<?> legDataType;
    @XmlElement(name = "StrictNotionalDates")
    protected Boolean strictNotionalDates;
    @XmlElement(name = "PaymentSchedule")
    protected ScheduleData paymentSchedule;
    @XmlElement(name = "SettlementData")
    protected LegData.SettlementData settlementData;

    /**
     * payer 속성의 값을 가져옵니다.
     * 
     */
    public boolean isPayer() {
        return payer;
    }

    /**
     * payer 속성의 값을 설정합니다.
     * 
     */
    public void setPayer(boolean value) {
        this.payer = value;
    }

    /**
     * legType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LegType }
     *     
     */
    public LegType getLegType() {
        return legType;
    }

    /**
     * legType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LegType }
     *     
     */
    public void setLegType(LegType value) {
        this.legType = value;
    }

    /**
     * currency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * currency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * paymentConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentConvention() {
        return paymentConvention;
    }

    /**
     * paymentConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentConvention(String value) {
        this.paymentConvention = value;
    }

    /**
     * paymentLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentLag() {
        return paymentLag;
    }

    /**
     * paymentLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentLag(String value) {
        this.paymentLag = value;
    }

    /**
     * notionalPaymentLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNotionalPaymentLag() {
        return notionalPaymentLag;
    }

    /**
     * notionalPaymentLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNotionalPaymentLag(BigInteger value) {
        this.notionalPaymentLag = value;
    }

    /**
     * paymentCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentCalendar() {
        return paymentCalendar;
    }

    /**
     * paymentCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentCalendar(String value) {
        this.paymentCalendar = value;
    }

    /**
     * dayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayCounter() {
        return dayCounter;
    }

    /**
     * dayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayCounter(String value) {
        this.dayCounter = value;
    }

    /**
     * amortizations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LegData.Amortizations }
     *     
     */
    public LegData.Amortizations getAmortizations() {
        return amortizations;
    }

    /**
     * amortizations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LegData.Amortizations }
     *     
     */
    public void setAmortizations(LegData.Amortizations value) {
        this.amortizations = value;
    }

    /**
     * notionals 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LegData.Notionals }
     *     
     */
    public LegData.Notionals getNotionals() {
        return notionals;
    }

    /**
     * notionals 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LegData.Notionals }
     *     
     */
    public void setNotionals(LegData.Notionals value) {
        this.notionals = value;
    }

    /**
     * scheduleData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getScheduleData() {
        return scheduleData;
    }

    /**
     * scheduleData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setScheduleData(ScheduleData value) {
        this.scheduleData = value;
    }

    /**
     * paymentDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LegData.PaymentDates }
     *     
     */
    public LegData.PaymentDates getPaymentDates() {
        return paymentDates;
    }

    /**
     * paymentDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LegData.PaymentDates }
     *     
     */
    public void setPaymentDates(LegData.PaymentDates value) {
        this.paymentDates = value;
    }

    /**
     * indexings 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LegData.Indexings }
     *     
     */
    public LegData.Indexings getIndexings() {
        return indexings;
    }

    /**
     * indexings 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LegData.Indexings }
     *     
     */
    public void setIndexings(LegData.Indexings value) {
        this.indexings = value;
    }

    /**
     * lastPeriodDayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastPeriodDayCounter() {
        return lastPeriodDayCounter;
    }

    /**
     * lastPeriodDayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastPeriodDayCounter(String value) {
        this.lastPeriodDayCounter = value;
    }

    /**
     * legDataType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FloatingLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CommodityFixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CashflowData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DigitalCMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link FormulaBasedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DurationAdjustedCMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link YYLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMSSpreadLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CPILegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link ZeroCouponFixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link EquityLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link FixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CommodityFloatingLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMBLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link EquityMarginLegData }{@code >}
     *     
     */
    public JAXBElement<?> getLegDataType() {
        return legDataType;
    }

    /**
     * legDataType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FloatingLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CommodityFixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CashflowData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DigitalCMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link FormulaBasedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DurationAdjustedCMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link YYLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMSSpreadLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CPILegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link ZeroCouponFixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link EquityLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link FixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CommodityFloatingLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMBLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link EquityMarginLegData }{@code >}
     *     
     */
    public void setLegDataType(JAXBElement<?> value) {
        this.legDataType = value;
    }

    /**
     * strictNotionalDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStrictNotionalDates() {
        return strictNotionalDates;
    }

    /**
     * strictNotionalDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStrictNotionalDates(Boolean value) {
        this.strictNotionalDates = value;
    }

    /**
     * paymentSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getPaymentSchedule() {
        return paymentSchedule;
    }

    /**
     * paymentSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setPaymentSchedule(ScheduleData value) {
        this.paymentSchedule = value;
    }

    /**
     * settlementData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LegData.SettlementData }
     *     
     */
    public LegData.SettlementData getSettlementData() {
        return settlementData;
    }

    /**
     * settlementData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LegData.SettlementData }
     *     
     */
    public void setSettlementData(LegData.SettlementData value) {
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
     *         &lt;element name="AmortizationData" type="{}amortizationData" maxOccurs="unbounded" minOccurs="0"/>
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
        "amortizationData"
    })
    public static class Amortizations {

        @XmlElement(name = "AmortizationData")
        protected List<AmortizationData> amortizationData;

        /**
         * Gets the value of the amortizationData property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the amortizationData property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAmortizationData().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AmortizationData }
         * 
         * 
         */
        public List<AmortizationData> getAmortizationData() {
            if (amortizationData == null) {
                amortizationData = new ArrayList<AmortizationData>();
            }
            return this.amortizationData;
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
     *         &lt;element name="FromAssetLeg" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="Indexing" type="{}indexingData" maxOccurs="unbounded" minOccurs="0"/>
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
        "fromAssetLeg",
        "indexing"
    })
    public static class Indexings {

        @XmlElement(name = "FromAssetLeg")
        protected Boolean fromAssetLeg;
        @XmlElement(name = "Indexing")
        protected List<IndexingData> indexing;

        /**
         * fromAssetLeg 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFromAssetLeg() {
            return fromAssetLeg;
        }

        /**
         * fromAssetLeg 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFromAssetLeg(Boolean value) {
            this.fromAssetLeg = value;
        }

        /**
         * Gets the value of the indexing property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the indexing property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIndexing().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IndexingData }
         * 
         * 
         */
        public List<IndexingData> getIndexing() {
            if (indexing == null) {
                indexing = new ArrayList<IndexingData>();
            }
            return this.indexing;
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
     *       &lt;choice maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="Notional" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                 &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="FXReset" type="{}fxreset" minOccurs="0"/>
     *         &lt;element name="Exchanges" type="{}exchanges" minOccurs="0"/>
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
        "notionalOrFXResetOrExchanges"
    })
    public static class Notionals {

        @XmlElements({
            @XmlElement(name = "Notional", type = LegData.Notionals.Notional.class),
            @XmlElement(name = "FXReset", type = Fxreset.class),
            @XmlElement(name = "Exchanges", type = Exchanges.class)
        })
        protected List<Object> notionalOrFXResetOrExchanges;

        /**
         * Gets the value of the notionalOrFXResetOrExchanges property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the notionalOrFXResetOrExchanges property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNotionalOrFXResetOrExchanges().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LegData.Notionals.Notional }
         * {@link Fxreset }
         * {@link Exchanges }
         * 
         * 
         */
        public List<Object> getNotionalOrFXResetOrExchanges() {
            if (notionalOrFXResetOrExchanges == null) {
                notionalOrFXResetOrExchanges = new ArrayList<Object>();
            }
            return this.notionalOrFXResetOrExchanges;
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
        public static class Notional {

            @XmlValue
            protected float value;
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
     *       &lt;sequence>
     *         &lt;element name="PaymentDate" type="{}date" maxOccurs="unbounded"/>
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
        "paymentDate"
    })
    public static class PaymentDates {

        @XmlElement(name = "PaymentDate", required = true)
        protected List<String> paymentDate;

        /**
         * Gets the value of the paymentDate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the paymentDate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPaymentDate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getPaymentDate() {
            if (paymentDate == null) {
                paymentDate = new ArrayList<String>();
            }
            return this.paymentDate;
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

        @XmlElement(name = "FXIndex", required = true)
        protected String fxIndex;
        @XmlElement(name = "FixingDate")
        protected String fixingDate;

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
