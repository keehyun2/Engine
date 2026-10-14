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
 * <p>cdsConventionsType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="cdsConventionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SettlementDays" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Frequency" type="{}frequencyType"/>
 *         &lt;element name="PaymentConvention" type="{}businessDayConvention"/>
 *         &lt;element name="Rule" type="{}dateRule"/>
 *         &lt;element name="DayCounter" type="{}dayCounter"/>
 *         &lt;element name="UpfrontSettlementDays" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="SettlesAccrual" type="{}bool"/>
 *         &lt;element name="PaysAtDefaultTime" type="{}bool"/>
 *         &lt;element name="LastPeriodDayCounter" type="{}dayCounter" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cdsConventionsType", propOrder = {

})
public class CdsConventionsType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "SettlementDays", required = true)
    protected BigInteger settlementDays;
    @XmlElement(name = "Calendar", required = true)
    protected String calendar;
    @XmlElement(name = "Frequency", required = true)
    @XmlSchemaType(name = "string")
    protected FrequencyType frequency;
    @XmlElement(name = "PaymentConvention", required = true)
    protected String paymentConvention;
    @XmlElement(name = "Rule", required = true)
    protected String rule;
    @XmlElement(name = "DayCounter", required = true)
    protected String dayCounter;
    @XmlElement(name = "UpfrontSettlementDays")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger upfrontSettlementDays;
    @XmlElement(name = "SettlesAccrual", required = true)
    protected String settlesAccrual;
    @XmlElement(name = "PaysAtDefaultTime", required = true)
    protected String paysAtDefaultTime;
    @XmlElement(name = "LastPeriodDayCounter")
    protected String lastPeriodDayCounter;

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
     * settlementDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSettlementDays() {
        return settlementDays;
    }

    /**
     * settlementDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSettlementDays(BigInteger value) {
        this.settlementDays = value;
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
     * frequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyType }
     *     
     */
    public FrequencyType getFrequency() {
        return frequency;
    }

    /**
     * frequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyType }
     *     
     */
    public void setFrequency(FrequencyType value) {
        this.frequency = value;
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
     * upfrontSettlementDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUpfrontSettlementDays() {
        return upfrontSettlementDays;
    }

    /**
     * upfrontSettlementDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUpfrontSettlementDays(BigInteger value) {
        this.upfrontSettlementDays = value;
    }

    /**
     * settlesAccrual 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlesAccrual() {
        return settlesAccrual;
    }

    /**
     * settlesAccrual 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlesAccrual(String value) {
        this.settlesAccrual = value;
    }

    /**
     * paysAtDefaultTime 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaysAtDefaultTime() {
        return paysAtDefaultTime;
    }

    /**
     * paysAtDefaultTime 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaysAtDefaultTime(String value) {
        this.paysAtDefaultTime = value;
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

}
