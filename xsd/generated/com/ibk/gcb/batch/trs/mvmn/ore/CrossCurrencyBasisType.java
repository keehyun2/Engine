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
 * <p>crossCurrencyBasisType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="crossCurrencyBasisType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SettlementDays" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="SettlementCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RollConvention" type="{}businessDayConvention"/>
 *         &lt;element name="FlatIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SpreadIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EOM" type="{}bool" minOccurs="0"/>
 *         &lt;element name="IsResettable" type="{}bool" minOccurs="0"/>
 *         &lt;element name="FlatIndexIsResettable" type="{}bool" minOccurs="0"/>
 *         &lt;element name="FlatTenor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpreadTenor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpreadPaymentLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FlatPaymentLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="SpreadIncludeSpread" type="{}bool" minOccurs="0"/>
 *         &lt;element name="SpreadLookback" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpreadFixingDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="SpreadRateCutoff" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="SpreadIsAveraged" type="{}bool" minOccurs="0"/>
 *         &lt;element name="FlatIncludeSpread" type="{}bool" minOccurs="0"/>
 *         &lt;element name="FlatLookback" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FlatFixingDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FlatRateCutoff" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FlatIsAveraged" type="{}bool" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crossCurrencyBasisType", propOrder = {

})
public class CrossCurrencyBasisType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "SettlementDays", required = true)
    protected BigInteger settlementDays;
    @XmlElement(name = "SettlementCalendar")
    protected String settlementCalendar;
    @XmlElement(name = "RollConvention", required = true)
    protected String rollConvention;
    @XmlElement(name = "FlatIndex", required = true)
    protected String flatIndex;
    @XmlElement(name = "SpreadIndex", required = true)
    protected String spreadIndex;
    @XmlElement(name = "EOM")
    protected String eom;
    @XmlElement(name = "IsResettable")
    protected String isResettable;
    @XmlElement(name = "FlatIndexIsResettable")
    protected String flatIndexIsResettable;
    @XmlElement(name = "FlatTenor")
    protected String flatTenor;
    @XmlElement(name = "SpreadTenor")
    protected String spreadTenor;
    @XmlElement(name = "SpreadPaymentLag")
    protected BigInteger spreadPaymentLag;
    @XmlElement(name = "FlatPaymentLag")
    protected BigInteger flatPaymentLag;
    @XmlElement(name = "SpreadIncludeSpread")
    protected String spreadIncludeSpread;
    @XmlElement(name = "SpreadLookback")
    protected String spreadLookback;
    @XmlElement(name = "SpreadFixingDays")
    protected BigInteger spreadFixingDays;
    @XmlElement(name = "SpreadRateCutoff")
    protected BigInteger spreadRateCutoff;
    @XmlElement(name = "SpreadIsAveraged")
    protected String spreadIsAveraged;
    @XmlElement(name = "FlatIncludeSpread")
    protected String flatIncludeSpread;
    @XmlElement(name = "FlatLookback")
    protected String flatLookback;
    @XmlElement(name = "FlatFixingDays")
    protected BigInteger flatFixingDays;
    @XmlElement(name = "FlatRateCutoff")
    protected BigInteger flatRateCutoff;
    @XmlElement(name = "FlatIsAveraged")
    protected String flatIsAveraged;

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
     * settlementDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSettlementDays() {
        return settlementDays;
    }

    /**
     * settlementDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSettlementDays(BigInteger value) {
        this.settlementDays = value;
    }

    /**
     * settlementCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementCalendar() {
        return settlementCalendar;
    }

    /**
     * settlementCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementCalendar(String value) {
        this.settlementCalendar = value;
    }

    /**
     * rollConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRollConvention() {
        return rollConvention;
    }

    /**
     * rollConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRollConvention(String value) {
        this.rollConvention = value;
    }

    /**
     * flatIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlatIndex() {
        return flatIndex;
    }

    /**
     * flatIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlatIndex(String value) {
        this.flatIndex = value;
    }

    /**
     * spreadIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpreadIndex() {
        return spreadIndex;
    }

    /**
     * spreadIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpreadIndex(String value) {
        this.spreadIndex = value;
    }

    /**
     * eom 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEOM() {
        return eom;
    }

    /**
     * eom 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEOM(String value) {
        this.eom = value;
    }

    /**
     * isResettable 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsResettable() {
        return isResettable;
    }

    /**
     * isResettable 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsResettable(String value) {
        this.isResettable = value;
    }

    /**
     * flatIndexIsResettable 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlatIndexIsResettable() {
        return flatIndexIsResettable;
    }

    /**
     * flatIndexIsResettable 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlatIndexIsResettable(String value) {
        this.flatIndexIsResettable = value;
    }

    /**
     * flatTenor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlatTenor() {
        return flatTenor;
    }

    /**
     * flatTenor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlatTenor(String value) {
        this.flatTenor = value;
    }

    /**
     * spreadTenor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpreadTenor() {
        return spreadTenor;
    }

    /**
     * spreadTenor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpreadTenor(String value) {
        this.spreadTenor = value;
    }

    /**
     * spreadPaymentLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpreadPaymentLag() {
        return spreadPaymentLag;
    }

    /**
     * spreadPaymentLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpreadPaymentLag(BigInteger value) {
        this.spreadPaymentLag = value;
    }

    /**
     * flatPaymentLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFlatPaymentLag() {
        return flatPaymentLag;
    }

    /**
     * flatPaymentLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFlatPaymentLag(BigInteger value) {
        this.flatPaymentLag = value;
    }

    /**
     * spreadIncludeSpread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpreadIncludeSpread() {
        return spreadIncludeSpread;
    }

    /**
     * spreadIncludeSpread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpreadIncludeSpread(String value) {
        this.spreadIncludeSpread = value;
    }

    /**
     * spreadLookback 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpreadLookback() {
        return spreadLookback;
    }

    /**
     * spreadLookback 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpreadLookback(String value) {
        this.spreadLookback = value;
    }

    /**
     * spreadFixingDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpreadFixingDays() {
        return spreadFixingDays;
    }

    /**
     * spreadFixingDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpreadFixingDays(BigInteger value) {
        this.spreadFixingDays = value;
    }

    /**
     * spreadRateCutoff 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpreadRateCutoff() {
        return spreadRateCutoff;
    }

    /**
     * spreadRateCutoff 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpreadRateCutoff(BigInteger value) {
        this.spreadRateCutoff = value;
    }

    /**
     * spreadIsAveraged 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpreadIsAveraged() {
        return spreadIsAveraged;
    }

    /**
     * spreadIsAveraged 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpreadIsAveraged(String value) {
        this.spreadIsAveraged = value;
    }

    /**
     * flatIncludeSpread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlatIncludeSpread() {
        return flatIncludeSpread;
    }

    /**
     * flatIncludeSpread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlatIncludeSpread(String value) {
        this.flatIncludeSpread = value;
    }

    /**
     * flatLookback 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlatLookback() {
        return flatLookback;
    }

    /**
     * flatLookback 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlatLookback(String value) {
        this.flatLookback = value;
    }

    /**
     * flatFixingDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFlatFixingDays() {
        return flatFixingDays;
    }

    /**
     * flatFixingDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFlatFixingDays(BigInteger value) {
        this.flatFixingDays = value;
    }

    /**
     * flatRateCutoff 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFlatRateCutoff() {
        return flatRateCutoff;
    }

    /**
     * flatRateCutoff 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFlatRateCutoff(BigInteger value) {
        this.flatRateCutoff = value;
    }

    /**
     * flatIsAveraged 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlatIsAveraged() {
        return flatIsAveraged;
    }

    /**
     * flatIsAveraged 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlatIsAveraged(String value) {
        this.flatIsAveraged = value;
    }

}
