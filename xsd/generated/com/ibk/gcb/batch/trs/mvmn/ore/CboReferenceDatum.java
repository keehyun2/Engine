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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cboReferenceDatum complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="cboReferenceDatum">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="DayCounter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentConvention" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="ReinvestmentEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SeniorFee" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="FeeDayCounter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubordinatedFee" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="EquityKicker" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="BondBasketData" type="{}cboBondBasketData"/>
 *         &lt;element name="CBOTranches" type="{}cbotranches"/>
 *         &lt;element name="ScheduleData" type="{}scheduleData"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cboReferenceDatum", propOrder = {

})
public class CboReferenceDatum {

    @XmlElement(name = "DayCounter", required = true)
    protected String dayCounter;
    @XmlElement(name = "PaymentConvention", required = true)
    protected String paymentConvention;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "ReinvestmentEndDate")
    protected String reinvestmentEndDate;
    @XmlElement(name = "SeniorFee")
    protected float seniorFee;
    @XmlElement(name = "FeeDayCounter", required = true)
    protected String feeDayCounter;
    @XmlElement(name = "SubordinatedFee")
    protected float subordinatedFee;
    @XmlElement(name = "EquityKicker")
    protected float equityKicker;
    @XmlElement(name = "BondBasketData", required = true)
    protected CboBondBasketData bondBasketData;
    @XmlElement(name = "CBOTranches", required = true)
    protected Cbotranches cboTranches;
    @XmlElement(name = "ScheduleData", required = true)
    protected ScheduleData scheduleData;

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
     * reinvestmentEndDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReinvestmentEndDate() {
        return reinvestmentEndDate;
    }

    /**
     * reinvestmentEndDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReinvestmentEndDate(String value) {
        this.reinvestmentEndDate = value;
    }

    /**
     * seniorFee 속성의 값을 가져옵니다.
     * 
     */
    public float getSeniorFee() {
        return seniorFee;
    }

    /**
     * seniorFee 속성의 값을 설정합니다.
     * 
     */
    public void setSeniorFee(float value) {
        this.seniorFee = value;
    }

    /**
     * feeDayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeDayCounter() {
        return feeDayCounter;
    }

    /**
     * feeDayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeDayCounter(String value) {
        this.feeDayCounter = value;
    }

    /**
     * subordinatedFee 속성의 값을 가져옵니다.
     * 
     */
    public float getSubordinatedFee() {
        return subordinatedFee;
    }

    /**
     * subordinatedFee 속성의 값을 설정합니다.
     * 
     */
    public void setSubordinatedFee(float value) {
        this.subordinatedFee = value;
    }

    /**
     * equityKicker 속성의 값을 가져옵니다.
     * 
     */
    public float getEquityKicker() {
        return equityKicker;
    }

    /**
     * equityKicker 속성의 값을 설정합니다.
     * 
     */
    public void setEquityKicker(float value) {
        this.equityKicker = value;
    }

    /**
     * bondBasketData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CboBondBasketData }
     *     
     */
    public CboBondBasketData getBondBasketData() {
        return bondBasketData;
    }

    /**
     * bondBasketData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CboBondBasketData }
     *     
     */
    public void setBondBasketData(CboBondBasketData value) {
        this.bondBasketData = value;
    }

    /**
     * cboTranches 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Cbotranches }
     *     
     */
    public Cbotranches getCBOTranches() {
        return cboTranches;
    }

    /**
     * cboTranches 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Cbotranches }
     *     
     */
    public void setCBOTranches(Cbotranches value) {
        this.cboTranches = value;
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

}
