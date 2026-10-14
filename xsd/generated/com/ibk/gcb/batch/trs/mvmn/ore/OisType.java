//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>oisType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="oisType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SpotLag" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FixedDayCounter" type="{}dayCounter"/>
 *         &lt;element name="FixedCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="EOM" type="{}bool" minOccurs="0"/>
 *         &lt;element name="FixedFrequency" type="{}frequencyType" minOccurs="0"/>
 *         &lt;element name="FixedConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="FixedPaymentConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="Rule" type="{}dateRule" minOccurs="0"/>
 *         &lt;element name="PaymentCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RateCutoff" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oisType", propOrder = {

})
public class OisType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "SpotLag", required = true)
    protected BigInteger spotLag;
    @XmlElement(name = "Index", required = true)
    protected String index;
    @XmlElement(name = "FixedDayCounter", required = true)
    protected String fixedDayCounter;
    @XmlElement(name = "FixedCalendar")
    protected String fixedCalendar;
    @XmlElement(name = "PaymentLag")
    protected BigInteger paymentLag;
    @XmlElement(name = "EOM")
    protected String eom;
    @XmlElement(name = "FixedFrequency")
    @XmlSchemaType(name = "string")
    protected FrequencyType fixedFrequency;
    @XmlElement(name = "FixedConvention")
    protected String fixedConvention;
    @XmlElement(name = "FixedPaymentConvention")
    protected String fixedPaymentConvention;
    @XmlElement(name = "Rule")
    protected String rule;
    @XmlElement(name = "PaymentCalendar")
    protected String paymentCalendar;
    @XmlElement(name = "RateCutoff")
    protected BigInteger rateCutoff;

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
     * spotLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpotLag() {
        return spotLag;
    }

    /**
     * spotLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpotLag(BigInteger value) {
        this.spotLag = value;
    }

    /**
     * index 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndex() {
        return index;
    }

    /**
     * index 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndex(String value) {
        this.index = value;
    }

    /**
     * fixedDayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixedDayCounter() {
        return fixedDayCounter;
    }

    /**
     * fixedDayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixedDayCounter(String value) {
        this.fixedDayCounter = value;
    }

    /**
     * fixedCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixedCalendar() {
        return fixedCalendar;
    }

    /**
     * fixedCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixedCalendar(String value) {
        this.fixedCalendar = value;
    }

    /**
     * paymentLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPaymentLag() {
        return paymentLag;
    }

    /**
     * paymentLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPaymentLag(BigInteger value) {
        this.paymentLag = value;
    }

    /**
     * eom 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEOM() {
        return eom;
    }

    /**
     * eom 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEOM(String value) {
        this.eom = value;
    }

    /**
     * fixedFrequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyType }
     *     
     */
    public FrequencyType getFixedFrequency() {
        return fixedFrequency;
    }

    /**
     * fixedFrequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyType }
     *     
     */
    public void setFixedFrequency(FrequencyType value) {
        this.fixedFrequency = value;
    }

    /**
     * fixedConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixedConvention() {
        return fixedConvention;
    }

    /**
     * fixedConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixedConvention(String value) {
        this.fixedConvention = value;
    }

    /**
     * fixedPaymentConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixedPaymentConvention() {
        return fixedPaymentConvention;
    }

    /**
     * fixedPaymentConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixedPaymentConvention(String value) {
        this.fixedPaymentConvention = value;
    }

    /**
     * rule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRule() {
        return rule;
    }

    /**
     * rule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRule(String value) {
        this.rule = value;
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
     * rateCutoff 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRateCutoff() {
        return rateCutoff;
    }

    /**
     * rateCutoff 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRateCutoff(BigInteger value) {
        this.rateCutoff = value;
    }

}
