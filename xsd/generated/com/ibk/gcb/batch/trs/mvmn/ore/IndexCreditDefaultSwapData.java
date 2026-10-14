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
 * <p>indexCreditDefaultSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="indexCreditDefaultSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="IssuerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditCurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SettlesAccrual" type="{}bool" minOccurs="0"/>
 *         &lt;element name="RebatesAccrual" type="{}bool" minOccurs="0"/>
 *         &lt;element name="PaysAtDefaultTime" type="{}bool" minOccurs="0"/>
 *         &lt;element name="ProtectionPaymentTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProtectionStart" type="{}date" minOccurs="0"/>
 *         &lt;element name="UpfrontDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="UpfrontFee" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="LegData" type="{}legData"/>
 *         &lt;element name="TradeDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="CashSettlementDays" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="BasketData" type="{}basketData" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "indexCreditDefaultSwapData", propOrder = {

})
public class IndexCreditDefaultSwapData {

    @XmlElement(name = "IssuerId")
    protected String issuerId;
    @XmlElement(name = "CreditCurveId", required = true)
    protected String creditCurveId;
    @XmlElement(name = "SettlesAccrual")
    protected String settlesAccrual;
    @XmlElement(name = "RebatesAccrual")
    protected String rebatesAccrual;
    @XmlElement(name = "PaysAtDefaultTime")
    protected String paysAtDefaultTime;
    @XmlElement(name = "ProtectionPaymentTime")
    protected String protectionPaymentTime;
    @XmlElement(name = "ProtectionStart")
    protected String protectionStart;
    @XmlElement(name = "UpfrontDate")
    protected String upfrontDate;
    @XmlElement(name = "UpfrontFee")
    protected Float upfrontFee;
    @XmlElement(name = "LegData", required = true)
    protected LegData legData;
    @XmlElement(name = "TradeDate")
    protected String tradeDate;
    @XmlElement(name = "CashSettlementDays")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cashSettlementDays;
    @XmlElement(name = "BasketData")
    protected BasketData basketData;

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
     * creditCurveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCurveId() {
        return creditCurveId;
    }

    /**
     * creditCurveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCurveId(String value) {
        this.creditCurveId = value;
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
     * rebatesAccrual 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRebatesAccrual() {
        return rebatesAccrual;
    }

    /**
     * rebatesAccrual 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRebatesAccrual(String value) {
        this.rebatesAccrual = value;
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
     * protectionPaymentTime 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtectionPaymentTime() {
        return protectionPaymentTime;
    }

    /**
     * protectionPaymentTime 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtectionPaymentTime(String value) {
        this.protectionPaymentTime = value;
    }

    /**
     * protectionStart 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtectionStart() {
        return protectionStart;
    }

    /**
     * protectionStart 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtectionStart(String value) {
        this.protectionStart = value;
    }

    /**
     * upfrontDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpfrontDate() {
        return upfrontDate;
    }

    /**
     * upfrontDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpfrontDate(String value) {
        this.upfrontDate = value;
    }

    /**
     * upfrontFee 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getUpfrontFee() {
        return upfrontFee;
    }

    /**
     * upfrontFee 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setUpfrontFee(Float value) {
        this.upfrontFee = value;
    }

    /**
     * legData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LegData }
     *     
     */
    public LegData getLegData() {
        return legData;
    }

    /**
     * legData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LegData }
     *     
     */
    public void setLegData(LegData value) {
        this.legData = value;
    }

    /**
     * tradeDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeDate() {
        return tradeDate;
    }

    /**
     * tradeDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeDate(String value) {
        this.tradeDate = value;
    }

    /**
     * cashSettlementDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCashSettlementDays() {
        return cashSettlementDays;
    }

    /**
     * cashSettlementDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCashSettlementDays(BigInteger value) {
        this.cashSettlementDays = value;
    }

    /**
     * basketData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BasketData }
     *     
     */
    public BasketData getBasketData() {
        return basketData;
    }

    /**
     * basketData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketData }
     *     
     */
    public void setBasketData(BasketData value) {
        this.basketData = value;
    }

}
