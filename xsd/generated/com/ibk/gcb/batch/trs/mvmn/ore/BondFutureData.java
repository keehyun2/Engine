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
 * <p>bondFutureData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="bondFutureData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ContractName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ContractNotional" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LongShort" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{}currencyCode" minOccurs="0"/>
 *         &lt;element name="ContractMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeliverableGrade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FairPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Settlement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlementDirty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RootDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpiryBasis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlementBasis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpiryLag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlementLag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastTradingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastDeliveryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeliveryBasket" type="{}deliveryBasket" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bondFutureData", propOrder = {

})
public class BondFutureData {

    @XmlElement(name = "ContractName", required = true)
    protected String contractName;
    @XmlElement(name = "ContractNotional", required = true)
    protected String contractNotional;
    @XmlElement(name = "LongShort", required = true)
    protected String longShort;
    @XmlElement(name = "Currency")
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "ContractMonth")
    protected String contractMonth;
    @XmlElement(name = "DeliverableGrade")
    protected String deliverableGrade;
    @XmlElement(name = "FairPrice")
    protected String fairPrice;
    @XmlElement(name = "Settlement")
    protected String settlement;
    @XmlElement(name = "SettlementDirty")
    protected String settlementDirty;
    @XmlElement(name = "RootDate")
    protected String rootDate;
    @XmlElement(name = "ExpiryBasis")
    protected String expiryBasis;
    @XmlElement(name = "SettlementBasis")
    protected String settlementBasis;
    @XmlElement(name = "ExpiryLag")
    protected String expiryLag;
    @XmlElement(name = "SettlementLag")
    protected String settlementLag;
    @XmlElement(name = "LastTradingDate")
    protected String lastTradingDate;
    @XmlElement(name = "LastDeliveryDate")
    protected String lastDeliveryDate;
    @XmlElement(name = "DeliveryBasket")
    protected DeliveryBasket deliveryBasket;

    /**
     * contractName 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * contractName 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractName(String value) {
        this.contractName = value;
    }

    /**
     * contractNotional 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractNotional() {
        return contractNotional;
    }

    /**
     * contractNotional 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractNotional(String value) {
        this.contractNotional = value;
    }

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
     * contractMonth 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractMonth() {
        return contractMonth;
    }

    /**
     * contractMonth 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractMonth(String value) {
        this.contractMonth = value;
    }

    /**
     * deliverableGrade 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliverableGrade() {
        return deliverableGrade;
    }

    /**
     * deliverableGrade 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliverableGrade(String value) {
        this.deliverableGrade = value;
    }

    /**
     * fairPrice 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFairPrice() {
        return fairPrice;
    }

    /**
     * fairPrice 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFairPrice(String value) {
        this.fairPrice = value;
    }

    /**
     * settlement 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlement() {
        return settlement;
    }

    /**
     * settlement 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlement(String value) {
        this.settlement = value;
    }

    /**
     * settlementDirty 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementDirty() {
        return settlementDirty;
    }

    /**
     * settlementDirty 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementDirty(String value) {
        this.settlementDirty = value;
    }

    /**
     * rootDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootDate() {
        return rootDate;
    }

    /**
     * rootDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootDate(String value) {
        this.rootDate = value;
    }

    /**
     * expiryBasis 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryBasis() {
        return expiryBasis;
    }

    /**
     * expiryBasis 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryBasis(String value) {
        this.expiryBasis = value;
    }

    /**
     * settlementBasis 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementBasis() {
        return settlementBasis;
    }

    /**
     * settlementBasis 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementBasis(String value) {
        this.settlementBasis = value;
    }

    /**
     * expiryLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryLag() {
        return expiryLag;
    }

    /**
     * expiryLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryLag(String value) {
        this.expiryLag = value;
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
     * lastTradingDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastTradingDate() {
        return lastTradingDate;
    }

    /**
     * lastTradingDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastTradingDate(String value) {
        this.lastTradingDate = value;
    }

    /**
     * lastDeliveryDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastDeliveryDate() {
        return lastDeliveryDate;
    }

    /**
     * lastDeliveryDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastDeliveryDate(String value) {
        this.lastDeliveryDate = value;
    }

    /**
     * deliveryBasket 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryBasket }
     *     
     */
    public DeliveryBasket getDeliveryBasket() {
        return deliveryBasket;
    }

    /**
     * deliveryBasket 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryBasket }
     *     
     */
    public void setDeliveryBasket(DeliveryBasket value) {
        this.deliveryBasket = value;
    }

}
