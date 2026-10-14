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
 * <p>trsReturnData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="trsReturnData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Payer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="ScheduleData" type="{}scheduleData"/>
 *         &lt;element name="ObservationLag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ObservationConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="ObservationCalendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="PaymentLag" type="{}paymentLag" minOccurs="0"/>
 *         &lt;element name="PaymentConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="PaymentCalendar" type="{}calendar" minOccurs="0"/>
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
 *         &lt;element name="InitialPrice" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="InitialPriceCurrency" type="{}extendedCurrencyCode" minOccurs="0"/>
 *         &lt;element name="FXTerms" type="{}fxTermsData" minOccurs="0"/>
 *         &lt;element name="PayUnderlyingCashFlowsImmediately" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trsReturnData", propOrder = {

})
public class TrsReturnData {

    @XmlElement(name = "Payer")
    protected boolean payer;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "ScheduleData", required = true)
    protected ScheduleData scheduleData;
    @XmlElement(name = "ObservationLag")
    protected String observationLag;
    @XmlElement(name = "ObservationConvention")
    protected String observationConvention;
    @XmlElement(name = "ObservationCalendar")
    protected String observationCalendar;
    @XmlElement(name = "PaymentLag")
    protected String paymentLag;
    @XmlElement(name = "PaymentConvention")
    protected String paymentConvention;
    @XmlElement(name = "PaymentCalendar")
    protected String paymentCalendar;
    @XmlElement(name = "PaymentDates")
    protected TrsReturnData.PaymentDates paymentDates;
    @XmlElement(name = "InitialPrice")
    protected Float initialPrice;
    @XmlElement(name = "InitialPriceCurrency")
    protected String initialPriceCurrency;
    @XmlElement(name = "FXTerms")
    protected FxTermsData fxTerms;
    @XmlElement(name = "PayUnderlyingCashFlowsImmediately")
    protected Boolean payUnderlyingCashFlowsImmediately;

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
     * observationLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservationLag() {
        return observationLag;
    }

    /**
     * observationLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservationLag(String value) {
        this.observationLag = value;
    }

    /**
     * observationConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservationConvention() {
        return observationConvention;
    }

    /**
     * observationConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservationConvention(String value) {
        this.observationConvention = value;
    }

    /**
     * observationCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservationCalendar() {
        return observationCalendar;
    }

    /**
     * observationCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservationCalendar(String value) {
        this.observationCalendar = value;
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
     * paymentDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TrsReturnData.PaymentDates }
     *     
     */
    public TrsReturnData.PaymentDates getPaymentDates() {
        return paymentDates;
    }

    /**
     * paymentDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TrsReturnData.PaymentDates }
     *     
     */
    public void setPaymentDates(TrsReturnData.PaymentDates value) {
        this.paymentDates = value;
    }

    /**
     * initialPrice 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getInitialPrice() {
        return initialPrice;
    }

    /**
     * initialPrice 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setInitialPrice(Float value) {
        this.initialPrice = value;
    }

    /**
     * initialPriceCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialPriceCurrency() {
        return initialPriceCurrency;
    }

    /**
     * initialPriceCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialPriceCurrency(String value) {
        this.initialPriceCurrency = value;
    }

    /**
     * fxTerms 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxTermsData }
     *     
     */
    public FxTermsData getFXTerms() {
        return fxTerms;
    }

    /**
     * fxTerms 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxTermsData }
     *     
     */
    public void setFXTerms(FxTermsData value) {
        this.fxTerms = value;
    }

    /**
     * payUnderlyingCashFlowsImmediately 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPayUnderlyingCashFlowsImmediately() {
        return payUnderlyingCashFlowsImmediately;
    }

    /**
     * payUnderlyingCashFlowsImmediately 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPayUnderlyingCashFlowsImmediately(Boolean value) {
        this.payUnderlyingCashFlowsImmediately = value;
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
