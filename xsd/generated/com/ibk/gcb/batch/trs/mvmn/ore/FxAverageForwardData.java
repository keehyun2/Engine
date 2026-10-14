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
 * <p>fxAverageForwardData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="fxAverageForwardData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="PaymentDate" type="{}date"/>
 *         &lt;element name="ObservationDates" type="{}scheduleData"/>
 *         &lt;element name="FixedPayer" type="{}bool"/>
 *         &lt;element name="ReferenceNotional" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="ReferenceCurrency" type="{}currencyCode"/>
 *         &lt;element name="SettlementNotional" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="SettlementCurrency" type="{}currencyCode"/>
 *         &lt;element name="Settlement" type="{}settlementType" minOccurs="0"/>
 *         &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fxAverageForwardData", propOrder = {

})
public class FxAverageForwardData {

    @XmlElement(name = "PaymentDate", required = true)
    protected String paymentDate;
    @XmlElement(name = "ObservationDates", required = true)
    protected ScheduleData observationDates;
    @XmlElement(name = "FixedPayer", required = true)
    protected String fixedPayer;
    @XmlElement(name = "ReferenceNotional")
    protected float referenceNotional;
    @XmlElement(name = "ReferenceCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode referenceCurrency;
    @XmlElement(name = "SettlementNotional")
    protected float settlementNotional;
    @XmlElement(name = "SettlementCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode settlementCurrency;
    @XmlElement(name = "Settlement")
    @XmlSchemaType(name = "string")
    protected SettlementType settlement;
    @XmlElement(name = "FXIndex", required = true)
    protected String fxIndex;

    /**
     * paymentDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * paymentDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDate(String value) {
        this.paymentDate = value;
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
     * fixedPayer 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixedPayer() {
        return fixedPayer;
    }

    /**
     * fixedPayer 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixedPayer(String value) {
        this.fixedPayer = value;
    }

    /**
     * referenceNotional 속성의 값을 가져옵니다.
     * 
     */
    public float getReferenceNotional() {
        return referenceNotional;
    }

    /**
     * referenceNotional 속성의 값을 설정합니다.
     * 
     */
    public void setReferenceNotional(float value) {
        this.referenceNotional = value;
    }

    /**
     * referenceCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getReferenceCurrency() {
        return referenceCurrency;
    }

    /**
     * referenceCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setReferenceCurrency(CurrencyCode value) {
        this.referenceCurrency = value;
    }

    /**
     * settlementNotional 속성의 값을 가져옵니다.
     * 
     */
    public float getSettlementNotional() {
        return settlementNotional;
    }

    /**
     * settlementNotional 속성의 값을 설정합니다.
     * 
     */
    public void setSettlementNotional(float value) {
        this.settlementNotional = value;
    }

    /**
     * settlementCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getSettlementCurrency() {
        return settlementCurrency;
    }

    /**
     * settlementCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setSettlementCurrency(CurrencyCode value) {
        this.settlementCurrency = value;
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

}
