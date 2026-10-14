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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>equityReferenceDatum complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="equityReferenceDatum">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EquityId" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="EquityName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="ScalingFactor" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="ExchangeCode" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="IsIndex" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="EquityStartDate" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="ProxyIdentifier" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="SimmBucket" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="CrifQualifier" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="ProxyVolatilityId" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "equityReferenceDatum", propOrder = {
    "equityId",
    "equityName",
    "currency",
    "scalingFactor",
    "exchangeCode",
    "isIndex",
    "equityStartDate",
    "proxyIdentifier",
    "simmBucket",
    "crifQualifier",
    "proxyVolatilityId"
})
public class EquityReferenceDatum {

    @XmlElement(name = "EquityId")
    protected Object equityId;
    @XmlElement(name = "EquityName")
    protected Object equityName;
    @XmlElement(name = "Currency", required = true)
    protected Object currency;
    @XmlElement(name = "ScalingFactor")
    protected Object scalingFactor;
    @XmlElement(name = "ExchangeCode", required = true)
    protected Object exchangeCode;
    @XmlElement(name = "IsIndex", required = true)
    protected Object isIndex;
    @XmlElement(name = "EquityStartDate", required = true)
    protected Object equityStartDate;
    @XmlElement(name = "ProxyIdentifier", required = true)
    protected Object proxyIdentifier;
    @XmlElement(name = "SimmBucket", required = true)
    protected Object simmBucket;
    @XmlElement(name = "CrifQualifier", required = true)
    protected Object crifQualifier;
    @XmlElement(name = "ProxyVolatilityId", required = true)
    protected Object proxyVolatilityId;

    /**
     * equityId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getEquityId() {
        return equityId;
    }

    /**
     * equityId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setEquityId(Object value) {
        this.equityId = value;
    }

    /**
     * equityName 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getEquityName() {
        return equityName;
    }

    /**
     * equityName 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setEquityName(Object value) {
        this.equityName = value;
    }

    /**
     * currency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCurrency() {
        return currency;
    }

    /**
     * currency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCurrency(Object value) {
        this.currency = value;
    }

    /**
     * scalingFactor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getScalingFactor() {
        return scalingFactor;
    }

    /**
     * scalingFactor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setScalingFactor(Object value) {
        this.scalingFactor = value;
    }

    /**
     * exchangeCode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getExchangeCode() {
        return exchangeCode;
    }

    /**
     * exchangeCode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setExchangeCode(Object value) {
        this.exchangeCode = value;
    }

    /**
     * isIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getIsIndex() {
        return isIndex;
    }

    /**
     * isIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setIsIndex(Object value) {
        this.isIndex = value;
    }

    /**
     * equityStartDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getEquityStartDate() {
        return equityStartDate;
    }

    /**
     * equityStartDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setEquityStartDate(Object value) {
        this.equityStartDate = value;
    }

    /**
     * proxyIdentifier 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getProxyIdentifier() {
        return proxyIdentifier;
    }

    /**
     * proxyIdentifier 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setProxyIdentifier(Object value) {
        this.proxyIdentifier = value;
    }

    /**
     * simmBucket 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSimmBucket() {
        return simmBucket;
    }

    /**
     * simmBucket 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSimmBucket(Object value) {
        this.simmBucket = value;
    }

    /**
     * crifQualifier 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCrifQualifier() {
        return crifQualifier;
    }

    /**
     * crifQualifier 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCrifQualifier(Object value) {
        this.crifQualifier = value;
    }

    /**
     * proxyVolatilityId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getProxyVolatilityId() {
        return proxyVolatilityId;
    }

    /**
     * proxyVolatilityId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setProxyVolatilityId(Object value) {
        this.proxyVolatilityId = value;
    }

}
