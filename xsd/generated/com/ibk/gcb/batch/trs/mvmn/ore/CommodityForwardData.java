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
 * <p>commodityForwardData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="commodityForwardData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Position" type="{}longShort"/>
 *         &lt;element name="Maturity" type="{}date"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="IsFuturePrice" type="{}bool" minOccurs="0"/>
 *         &lt;element name="FutureExpiryDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="FutureExpiryOffset" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FutureExpiryOffsetCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhysicallySettled" type="{}bool" minOccurs="0"/>
 *         &lt;element name="PaymentDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="SettlementData" type="{}commForwardSettlementData" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commodityForwardData", propOrder = {

})
public class CommodityForwardData {

    @XmlElement(name = "Position", required = true)
    @XmlSchemaType(name = "string")
    protected LongShort position;
    @XmlElement(name = "Maturity", required = true)
    protected String maturity;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "Strike")
    protected float strike;
    @XmlElement(name = "Quantity")
    protected float quantity;
    @XmlElement(name = "IsFuturePrice")
    protected String isFuturePrice;
    @XmlElement(name = "FutureExpiryDate")
    protected String futureExpiryDate;
    @XmlElement(name = "FutureExpiryOffset")
    protected String futureExpiryOffset;
    @XmlElement(name = "FutureExpiryOffsetCalendar")
    protected String futureExpiryOffsetCalendar;
    @XmlElement(name = "PhysicallySettled")
    protected String physicallySettled;
    @XmlElement(name = "PaymentDate")
    protected String paymentDate;
    @XmlElement(name = "SettlementData")
    protected CommForwardSettlementData settlementData;

    /**
     * position 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LongShort }
     *     
     */
    public LongShort getPosition() {
        return position;
    }

    /**
     * position 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LongShort }
     *     
     */
    public void setPosition(LongShort value) {
        this.position = value;
    }

    /**
     * maturity 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaturity() {
        return maturity;
    }

    /**
     * maturity 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaturity(String value) {
        this.maturity = value;
    }

    /**
     * name 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * name 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * strike 속성의 값을 가져옵니다.
     * 
     */
    public float getStrike() {
        return strike;
    }

    /**
     * strike 속성의 값을 설정합니다.
     * 
     */
    public void setStrike(float value) {
        this.strike = value;
    }

    /**
     * quantity 속성의 값을 가져옵니다.
     * 
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     * quantity 속성의 값을 설정합니다.
     * 
     */
    public void setQuantity(float value) {
        this.quantity = value;
    }

    /**
     * isFuturePrice 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsFuturePrice() {
        return isFuturePrice;
    }

    /**
     * isFuturePrice 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsFuturePrice(String value) {
        this.isFuturePrice = value;
    }

    /**
     * futureExpiryDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFutureExpiryDate() {
        return futureExpiryDate;
    }

    /**
     * futureExpiryDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFutureExpiryDate(String value) {
        this.futureExpiryDate = value;
    }

    /**
     * futureExpiryOffset 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFutureExpiryOffset() {
        return futureExpiryOffset;
    }

    /**
     * futureExpiryOffset 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFutureExpiryOffset(String value) {
        this.futureExpiryOffset = value;
    }

    /**
     * futureExpiryOffsetCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFutureExpiryOffsetCalendar() {
        return futureExpiryOffsetCalendar;
    }

    /**
     * futureExpiryOffsetCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFutureExpiryOffsetCalendar(String value) {
        this.futureExpiryOffsetCalendar = value;
    }

    /**
     * physicallySettled 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhysicallySettled() {
        return physicallySettled;
    }

    /**
     * physicallySettled 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhysicallySettled(String value) {
        this.physicallySettled = value;
    }

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
     * settlementData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommForwardSettlementData }
     *     
     */
    public CommForwardSettlementData getSettlementData() {
        return settlementData;
    }

    /**
     * settlementData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommForwardSettlementData }
     *     
     */
    public void setSettlementData(CommForwardSettlementData value) {
        this.settlementData = value;
    }

}
