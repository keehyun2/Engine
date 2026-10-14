//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>nameData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="nameData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="IssuerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Qualifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}creditCurveIdType"/>
 *         &lt;element name="Notional" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Currency" type="{}currencyCode" minOccurs="0"/>
 *         &lt;element name="PriorNotional" type="{}non-negative-decimal" minOccurs="0"/>
 *         &lt;element name="PriorWeight" type="{}non-negative-decimal" minOccurs="0"/>
 *         &lt;element name="RecoveryRate" type="{}recoveryRate" minOccurs="0"/>
 *         &lt;element name="AuctionDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="AuctionSettlementDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="DefaultDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="EventDeterminationDate" type="{}date" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nameData", propOrder = {

})
public class NameData {

    @XmlElement(name = "IssuerId", required = true)
    protected String issuerId;
    @XmlElement(name = "Qualifier")
    protected String qualifier;
    @XmlElementRef(name = "creditCurveIdType", type = JAXBElement.class)
    protected JAXBElement<?> creditCurveIdType;
    @XmlElement(name = "Notional")
    protected Float notional;
    @XmlElement(name = "Weight")
    protected Float weight;
    @XmlElement(name = "Currency")
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "PriorNotional")
    protected BigDecimal priorNotional;
    @XmlElement(name = "PriorWeight")
    protected BigDecimal priorWeight;
    @XmlElement(name = "RecoveryRate")
    protected BigDecimal recoveryRate;
    @XmlElement(name = "AuctionDate")
    protected String auctionDate;
    @XmlElement(name = "AuctionSettlementDate")
    protected String auctionSettlementDate;
    @XmlElement(name = "DefaultDate")
    protected String defaultDate;
    @XmlElement(name = "EventDeterminationDate")
    protected String eventDeterminationDate;

    /**
     * issuerId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerId() {
        return issuerId;
    }

    /**
     * issuerId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerId(String value) {
        this.issuerId = value;
    }

    /**
     * qualifier 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualifier() {
        return qualifier;
    }

    /**
     * qualifier 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualifier(String value) {
        this.qualifier = value;
    }

    /**
     * creditCurveIdType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ReferenceInformation }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getCreditCurveIdType() {
        return creditCurveIdType;
    }

    /**
     * creditCurveIdType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ReferenceInformation }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setCreditCurveIdType(JAXBElement<?> value) {
        this.creditCurveIdType = value;
    }

    /**
     * notional 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNotional() {
        return notional;
    }

    /**
     * notional 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNotional(Float value) {
        this.notional = value;
    }

    /**
     * weight 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * weight 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWeight(Float value) {
        this.weight = value;
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
     * priorNotional 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPriorNotional() {
        return priorNotional;
    }

    /**
     * priorNotional 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPriorNotional(BigDecimal value) {
        this.priorNotional = value;
    }

    /**
     * priorWeight 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPriorWeight() {
        return priorWeight;
    }

    /**
     * priorWeight 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPriorWeight(BigDecimal value) {
        this.priorWeight = value;
    }

    /**
     * recoveryRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRecoveryRate() {
        return recoveryRate;
    }

    /**
     * recoveryRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRecoveryRate(BigDecimal value) {
        this.recoveryRate = value;
    }

    /**
     * auctionDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionDate() {
        return auctionDate;
    }

    /**
     * auctionDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionDate(String value) {
        this.auctionDate = value;
    }

    /**
     * auctionSettlementDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionSettlementDate() {
        return auctionSettlementDate;
    }

    /**
     * auctionSettlementDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionSettlementDate(String value) {
        this.auctionSettlementDate = value;
    }

    /**
     * defaultDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultDate() {
        return defaultDate;
    }

    /**
     * defaultDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultDate(String value) {
        this.defaultDate = value;
    }

    /**
     * eventDeterminationDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventDeterminationDate() {
        return eventDeterminationDate;
    }

    /**
     * eventDeterminationDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventDeterminationDate(String value) {
        this.eventDeterminationDate = value;
    }

}
