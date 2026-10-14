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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>legData_capfloor complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="legData_capfloor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Payer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LegType" type="{}legType"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="DayCounter" type="{}dayCounter"/>
 *         &lt;element name="PaymentConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="PaymentLag" type="{}paymentLag" minOccurs="0"/>
 *         &lt;element name="PaymentCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notionals">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Notional" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                           &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                     &lt;element name="FXReset" type="{}fxreset" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="Exchanges" type="{}exchanges" minOccurs="0"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ScheduleData" type="{}scheduleData"/>
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
 *         &lt;element ref="{}legDataType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "legData_capfloor", propOrder = {

})
public class LegDataCapfloor {

    @XmlElement(name = "Payer")
    protected Boolean payer;
    @XmlElement(name = "LegType", required = true)
    @XmlSchemaType(name = "string")
    protected LegType legType;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "DayCounter", required = true)
    protected String dayCounter;
    @XmlElement(name = "PaymentConvention")
    protected String paymentConvention;
    @XmlElement(name = "PaymentLag")
    protected String paymentLag;
    @XmlElement(name = "PaymentCalendar")
    protected String paymentCalendar;
    @XmlElement(name = "Notionals", required = true)
    protected LegDataCapfloor.Notionals notionals;
    @XmlElement(name = "ScheduleData", required = true)
    protected ScheduleData scheduleData;
    @XmlElement(name = "PaymentDates")
    protected LegDataCapfloor.PaymentDates paymentDates;
    @XmlElementRef(name = "legDataType", type = JAXBElement.class)
    protected JAXBElement<?> legDataType;

    /**
     * payer 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPayer() {
        return payer;
    }

    /**
     * payer 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPayer(Boolean value) {
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
     * notionals 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LegDataCapfloor.Notionals }
     *     
     */
    public LegDataCapfloor.Notionals getNotionals() {
        return notionals;
    }

    /**
     * notionals 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LegDataCapfloor.Notionals }
     *     
     */
    public void setNotionals(LegDataCapfloor.Notionals value) {
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
     *     {@link LegDataCapfloor.PaymentDates }
     *     
     */
    public LegDataCapfloor.PaymentDates getPaymentDates() {
        return paymentDates;
    }

    /**
     * paymentDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LegDataCapfloor.PaymentDates }
     *     
     */
    public void setPaymentDates(LegDataCapfloor.PaymentDates value) {
        this.paymentDates = value;
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
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Notional" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                 &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;choice maxOccurs="unbounded" minOccurs="0">
     *           &lt;element name="FXReset" type="{}fxreset" maxOccurs="unbounded" minOccurs="0"/>
     *           &lt;element name="Exchanges" type="{}exchanges" minOccurs="0"/>
     *         &lt;/choice>
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
        "notional",
        "fxResetOrExchanges"
    })
    public static class Notionals {

        @XmlElement(name = "Notional", required = true)
        protected List<LegDataCapfloor.Notionals.Notional> notional;
        @XmlElements({
            @XmlElement(name = "FXReset", type = Fxreset.class),
            @XmlElement(name = "Exchanges", type = Exchanges.class)
        })
        protected List<Object> fxResetOrExchanges;

        /**
         * Gets the value of the notional property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the notional property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNotional().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LegDataCapfloor.Notionals.Notional }
         * 
         * 
         */
        public List<LegDataCapfloor.Notionals.Notional> getNotional() {
            if (notional == null) {
                notional = new ArrayList<LegDataCapfloor.Notionals.Notional>();
            }
            return this.notional;
        }

        /**
         * Gets the value of the fxResetOrExchanges property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fxResetOrExchanges property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFXResetOrExchanges().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Fxreset }
         * {@link Exchanges }
         * 
         * 
         */
        public List<Object> getFXResetOrExchanges() {
            if (fxResetOrExchanges == null) {
                fxResetOrExchanges = new ArrayList<Object>();
            }
            return this.fxResetOrExchanges;
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

}
