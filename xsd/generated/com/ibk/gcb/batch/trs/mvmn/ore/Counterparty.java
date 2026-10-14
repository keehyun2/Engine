//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>counterparty complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="counterparty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CounterpartyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClearingCounterparty" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CreditQuality" type="{}creditQualityType" minOccurs="0"/>
 *         &lt;element name="BaCvaRiskWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SaCcrRiskWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SaCvaRiskBucket" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "counterparty", propOrder = {

})
public class Counterparty {

    @XmlElement(name = "CounterpartyId", required = true)
    protected String counterpartyId;
    @XmlElement(name = "ClearingCounterparty")
    protected Boolean clearingCounterparty;
    @XmlElement(name = "CreditQuality")
    @XmlSchemaType(name = "string")
    protected CreditQualityType creditQuality;
    @XmlElement(name = "BaCvaRiskWeight")
    protected BigDecimal baCvaRiskWeight;
    @XmlElement(name = "SaCcrRiskWeight")
    protected BigDecimal saCcrRiskWeight;
    @XmlElement(name = "SaCvaRiskBucket")
    protected BigDecimal saCvaRiskBucket;

    /**
     * counterpartyId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounterpartyId() {
        return counterpartyId;
    }

    /**
     * counterpartyId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounterpartyId(String value) {
        this.counterpartyId = value;
    }

    /**
     * clearingCounterparty 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isClearingCounterparty() {
        return clearingCounterparty;
    }

    /**
     * clearingCounterparty 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setClearingCounterparty(Boolean value) {
        this.clearingCounterparty = value;
    }

    /**
     * creditQuality 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CreditQualityType }
     *     
     */
    public CreditQualityType getCreditQuality() {
        return creditQuality;
    }

    /**
     * creditQuality 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditQualityType }
     *     
     */
    public void setCreditQuality(CreditQualityType value) {
        this.creditQuality = value;
    }

    /**
     * baCvaRiskWeight 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBaCvaRiskWeight() {
        return baCvaRiskWeight;
    }

    /**
     * baCvaRiskWeight 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBaCvaRiskWeight(BigDecimal value) {
        this.baCvaRiskWeight = value;
    }

    /**
     * saCcrRiskWeight 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSaCcrRiskWeight() {
        return saCcrRiskWeight;
    }

    /**
     * saCcrRiskWeight 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSaCcrRiskWeight(BigDecimal value) {
        this.saCcrRiskWeight = value;
    }

    /**
     * saCvaRiskBucket 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSaCvaRiskBucket() {
        return saCvaRiskBucket;
    }

    /**
     * saCvaRiskBucket 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSaCvaRiskBucket(BigDecimal value) {
        this.saCvaRiskBucket = value;
    }

}
