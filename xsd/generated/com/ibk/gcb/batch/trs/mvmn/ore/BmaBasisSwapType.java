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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bmaBasisSwapType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="bmaBasisSwapType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BMAIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BMAPaymentCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BMAPaymentConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="BMAPaymentLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="IndexPaymentCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndexPaymentConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="IndexPaymentLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="IndexSettlementDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="IndexPaymentPeriod" type="{}period" minOccurs="0"/>
 *         &lt;element name="OvernightLockoutDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bmaBasisSwapType", propOrder = {

})
public class BmaBasisSwapType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Index", required = true)
    protected String index;
    @XmlElement(name = "BMAIndex", required = true)
    protected String bmaIndex;
    @XmlElement(name = "BMAPaymentCalendar")
    protected String bmaPaymentCalendar;
    @XmlElement(name = "BMAPaymentConvention")
    protected String bmaPaymentConvention;
    @XmlElement(name = "BMAPaymentLag")
    protected BigInteger bmaPaymentLag;
    @XmlElement(name = "IndexPaymentCalendar")
    protected String indexPaymentCalendar;
    @XmlElement(name = "IndexPaymentConvention")
    protected String indexPaymentConvention;
    @XmlElement(name = "IndexPaymentLag")
    protected BigInteger indexPaymentLag;
    @XmlElement(name = "IndexSettlementDays")
    protected BigInteger indexSettlementDays;
    @XmlElement(name = "IndexPaymentPeriod")
    protected String indexPaymentPeriod;
    @XmlElement(name = "OvernightLockoutDays")
    protected BigInteger overnightLockoutDays;

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
     * index 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndex() {
        return index;
    }

    /**
     * index 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndex(String value) {
        this.index = value;
    }

    /**
     * bmaIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBMAIndex() {
        return bmaIndex;
    }

    /**
     * bmaIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBMAIndex(String value) {
        this.bmaIndex = value;
    }

    /**
     * bmaPaymentCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBMAPaymentCalendar() {
        return bmaPaymentCalendar;
    }

    /**
     * bmaPaymentCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBMAPaymentCalendar(String value) {
        this.bmaPaymentCalendar = value;
    }

    /**
     * bmaPaymentConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBMAPaymentConvention() {
        return bmaPaymentConvention;
    }

    /**
     * bmaPaymentConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBMAPaymentConvention(String value) {
        this.bmaPaymentConvention = value;
    }

    /**
     * bmaPaymentLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBMAPaymentLag() {
        return bmaPaymentLag;
    }

    /**
     * bmaPaymentLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBMAPaymentLag(BigInteger value) {
        this.bmaPaymentLag = value;
    }

    /**
     * indexPaymentCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexPaymentCalendar() {
        return indexPaymentCalendar;
    }

    /**
     * indexPaymentCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexPaymentCalendar(String value) {
        this.indexPaymentCalendar = value;
    }

    /**
     * indexPaymentConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexPaymentConvention() {
        return indexPaymentConvention;
    }

    /**
     * indexPaymentConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexPaymentConvention(String value) {
        this.indexPaymentConvention = value;
    }

    /**
     * indexPaymentLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIndexPaymentLag() {
        return indexPaymentLag;
    }

    /**
     * indexPaymentLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIndexPaymentLag(BigInteger value) {
        this.indexPaymentLag = value;
    }

    /**
     * indexSettlementDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIndexSettlementDays() {
        return indexSettlementDays;
    }

    /**
     * indexSettlementDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIndexSettlementDays(BigInteger value) {
        this.indexSettlementDays = value;
    }

    /**
     * indexPaymentPeriod 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexPaymentPeriod() {
        return indexPaymentPeriod;
    }

    /**
     * indexPaymentPeriod 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexPaymentPeriod(String value) {
        this.indexPaymentPeriod = value;
    }

    /**
     * overnightLockoutDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOvernightLockoutDays() {
        return overnightLockoutDays;
    }

    /**
     * overnightLockoutDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOvernightLockoutDays(BigInteger value) {
        this.overnightLockoutDays = value;
    }

}
