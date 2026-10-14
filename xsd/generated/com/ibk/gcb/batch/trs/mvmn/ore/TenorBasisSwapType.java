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
 * <p>tenorBasisSwapType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="tenorBasisSwapType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PayIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayFrequency" type="{}period" minOccurs="0"/>
 *         &lt;element name="ReceiveIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiveFrequency" type="{}period" minOccurs="0"/>
 *         &lt;element name="SpreadOnRec" type="{}bool" minOccurs="0"/>
 *         &lt;element name="IncludeSpread" type="{}bool" minOccurs="0"/>
 *         &lt;element name="SubPeriodsCouponType" type="{}subPeriodsCouponType" minOccurs="0"/>
 *         &lt;element name="LongIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LongPayTenor" type="{}period" minOccurs="0"/>
 *         &lt;element name="ShortIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShortPayTenor" type="{}period" minOccurs="0"/>
 *         &lt;element name="SpreadOnShort" type="{}bool" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tenorBasisSwapType", propOrder = {

})
public class TenorBasisSwapType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "PayIndex")
    protected String payIndex;
    @XmlElement(name = "PayFrequency")
    protected String payFrequency;
    @XmlElement(name = "ReceiveIndex")
    protected String receiveIndex;
    @XmlElement(name = "ReceiveFrequency")
    protected String receiveFrequency;
    @XmlElement(name = "SpreadOnRec")
    protected String spreadOnRec;
    @XmlElement(name = "IncludeSpread")
    protected String includeSpread;
    @XmlElement(name = "SubPeriodsCouponType")
    @XmlSchemaType(name = "string")
    protected SubPeriodsCouponType subPeriodsCouponType;
    @XmlElement(name = "LongIndex")
    protected String longIndex;
    @XmlElement(name = "LongPayTenor")
    protected String longPayTenor;
    @XmlElement(name = "ShortIndex")
    protected String shortIndex;
    @XmlElement(name = "ShortPayTenor")
    protected String shortPayTenor;
    @XmlElement(name = "SpreadOnShort")
    protected String spreadOnShort;

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
     * payIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayIndex() {
        return payIndex;
    }

    /**
     * payIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayIndex(String value) {
        this.payIndex = value;
    }

    /**
     * payFrequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayFrequency() {
        return payFrequency;
    }

    /**
     * payFrequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayFrequency(String value) {
        this.payFrequency = value;
    }

    /**
     * receiveIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiveIndex() {
        return receiveIndex;
    }

    /**
     * receiveIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiveIndex(String value) {
        this.receiveIndex = value;
    }

    /**
     * receiveFrequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiveFrequency() {
        return receiveFrequency;
    }

    /**
     * receiveFrequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiveFrequency(String value) {
        this.receiveFrequency = value;
    }

    /**
     * spreadOnRec 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpreadOnRec() {
        return spreadOnRec;
    }

    /**
     * spreadOnRec 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpreadOnRec(String value) {
        this.spreadOnRec = value;
    }

    /**
     * includeSpread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncludeSpread() {
        return includeSpread;
    }

    /**
     * includeSpread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncludeSpread(String value) {
        this.includeSpread = value;
    }

    /**
     * subPeriodsCouponType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SubPeriodsCouponType }
     *     
     */
    public SubPeriodsCouponType getSubPeriodsCouponType() {
        return subPeriodsCouponType;
    }

    /**
     * subPeriodsCouponType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SubPeriodsCouponType }
     *     
     */
    public void setSubPeriodsCouponType(SubPeriodsCouponType value) {
        this.subPeriodsCouponType = value;
    }

    /**
     * longIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongIndex() {
        return longIndex;
    }

    /**
     * longIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongIndex(String value) {
        this.longIndex = value;
    }

    /**
     * longPayTenor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongPayTenor() {
        return longPayTenor;
    }

    /**
     * longPayTenor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongPayTenor(String value) {
        this.longPayTenor = value;
    }

    /**
     * shortIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortIndex() {
        return shortIndex;
    }

    /**
     * shortIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortIndex(String value) {
        this.shortIndex = value;
    }

    /**
     * shortPayTenor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortPayTenor() {
        return shortPayTenor;
    }

    /**
     * shortPayTenor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortPayTenor(String value) {
        this.shortPayTenor = value;
    }

    /**
     * spreadOnShort 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpreadOnShort() {
        return spreadOnShort;
    }

    /**
     * spreadOnShort 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpreadOnShort(String value) {
        this.spreadOnShort = value;
    }

}
