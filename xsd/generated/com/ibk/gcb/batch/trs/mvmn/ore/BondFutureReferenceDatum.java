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
 * <p>bondFutureReferenceDatum complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="bondFutureReferenceDatum">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Currency" type="{}currencyCode" minOccurs="0"/>
 *         &lt;element name="DeliveryBasket" type="{}deliveryBasket" minOccurs="0"/>
 *         &lt;element name="DeliverableGrade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastTradingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastDeliveryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Settlement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DirtyQuotation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContractMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RootDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpiryBasis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlementBasis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpiryLag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlementLag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bondFutureReferenceDatum", propOrder = {

})
public class BondFutureReferenceDatum {

    @XmlElement(name = "Currency")
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "DeliveryBasket")
    protected DeliveryBasket deliveryBasket;
    @XmlElement(name = "DeliverableGrade")
    protected String deliverableGrade;
    @XmlElement(name = "LastTradingDate")
    protected String lastTradingDate;
    @XmlElement(name = "LastDeliveryDate")
    protected String lastDeliveryDate;
    @XmlElement(name = "Settlement")
    protected String settlement;
    @XmlElement(name = "DirtyQuotation")
    protected String dirtyQuotation;
    @XmlElement(name = "ContractMonth")
    protected String contractMonth;
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
     * dirtyQuotation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirtyQuotation() {
        return dirtyQuotation;
    }

    /**
     * dirtyQuotation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirtyQuotation(String value) {
        this.dirtyQuotation = value;
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

}
