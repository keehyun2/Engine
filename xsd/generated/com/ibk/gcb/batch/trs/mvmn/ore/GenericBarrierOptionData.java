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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>genericBarrierOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="genericBarrierOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="PayCurrency" type="{}currencyCode"/>
 *         &lt;element ref="{}underlyingTypes"/>
 *         &lt;element name="OptionData" type="{}optionData"/>
 *         &lt;element name="SettlementDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="SettlementLag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlementCalendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="SettlementConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Barriers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ScheduleData" type="{}scheduleData" minOccurs="0"/>
 *                   &lt;element name="StartDate" type="{}date" minOccurs="0"/>
 *                   &lt;element name="EndDate" type="{}date" minOccurs="0"/>
 *                   &lt;element name="BarrierData" type="{}barrierData" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="KikoType" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="KoAlways"/>
 *                         &lt;enumeration value="KoBeforeKi"/>
 *                         &lt;enumeration value="KoAfterKi"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TransatlanticBarrier" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BarrierData" type="{}barrierData" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "genericBarrierOptionData", propOrder = {

})
public class GenericBarrierOptionData {

    @XmlElement(name = "PayCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode payCurrency;
    @XmlElementRef(name = "underlyingTypes", type = JAXBElement.class)
    protected JAXBElement<?> underlyingTypes;
    @XmlElement(name = "OptionData", required = true)
    protected OptionData optionData;
    @XmlElement(name = "SettlementDate")
    protected String settlementDate;
    @XmlElement(name = "SettlementLag")
    protected String settlementLag;
    @XmlElement(name = "SettlementCalendar")
    protected String settlementCalendar;
    @XmlElement(name = "SettlementConvention")
    protected String settlementConvention;
    @XmlElement(name = "Quantity")
    protected Float quantity;
    @XmlElement(name = "Strike")
    protected Float strike;
    @XmlElement(name = "Amount")
    protected Float amount;
    @XmlElement(name = "Barriers", required = true)
    protected GenericBarrierOptionData.Barriers barriers;
    @XmlElement(name = "TransatlanticBarrier")
    protected GenericBarrierOptionData.TransatlanticBarrier transatlanticBarrier;

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
     * underlyingTypes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlying }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlyings }{@code >}
     *     
     */
    public JAXBElement<?> getUnderlyingTypes() {
        return underlyingTypes;
    }

    /**
     * underlyingTypes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlying }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlyings }{@code >}
     *     
     */
    public void setUnderlyingTypes(JAXBElement<?> value) {
        this.underlyingTypes = value;
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
     * settlementDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementDate() {
        return settlementDate;
    }

    /**
     * settlementDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementDate(String value) {
        this.settlementDate = value;
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
     * quantity 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getQuantity() {
        return quantity;
    }

    /**
     * quantity 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setQuantity(Float value) {
        this.quantity = value;
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
     * amount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getAmount() {
        return amount;
    }

    /**
     * amount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setAmount(Float value) {
        this.amount = value;
    }

    /**
     * barriers 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GenericBarrierOptionData.Barriers }
     *     
     */
    public GenericBarrierOptionData.Barriers getBarriers() {
        return barriers;
    }

    /**
     * barriers 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericBarrierOptionData.Barriers }
     *     
     */
    public void setBarriers(GenericBarrierOptionData.Barriers value) {
        this.barriers = value;
    }

    /**
     * transatlanticBarrier 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GenericBarrierOptionData.TransatlanticBarrier }
     *     
     */
    public GenericBarrierOptionData.TransatlanticBarrier getTransatlanticBarrier() {
        return transatlanticBarrier;
    }

    /**
     * transatlanticBarrier 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericBarrierOptionData.TransatlanticBarrier }
     *     
     */
    public void setTransatlanticBarrier(GenericBarrierOptionData.TransatlanticBarrier value) {
        this.transatlanticBarrier = value;
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
     *         &lt;element name="ScheduleData" type="{}scheduleData" minOccurs="0"/>
     *         &lt;element name="StartDate" type="{}date" minOccurs="0"/>
     *         &lt;element name="EndDate" type="{}date" minOccurs="0"/>
     *         &lt;element name="BarrierData" type="{}barrierData" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="KikoType" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="KoAlways"/>
     *               &lt;enumeration value="KoBeforeKi"/>
     *               &lt;enumeration value="KoAfterKi"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
        "scheduleData",
        "startDate",
        "endDate",
        "barrierData",
        "kikoType"
    })
    public static class Barriers {

        @XmlElement(name = "ScheduleData")
        protected ScheduleData scheduleData;
        @XmlElement(name = "StartDate")
        protected String startDate;
        @XmlElement(name = "EndDate")
        protected String endDate;
        @XmlElement(name = "BarrierData")
        protected List<BarrierData> barrierData;
        @XmlElement(name = "KikoType")
        protected String kikoType;

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
         * endDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEndDate() {
            return endDate;
        }

        /**
         * endDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEndDate(String value) {
            this.endDate = value;
        }

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

        /**
         * kikoType 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKikoType() {
            return kikoType;
        }

        /**
         * kikoType 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKikoType(String value) {
            this.kikoType = value;
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
     *         &lt;element name="BarrierData" type="{}barrierData" maxOccurs="unbounded" minOccurs="0"/>
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
    public static class TransatlanticBarrier {

        @XmlElement(name = "BarrierData")
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

}
