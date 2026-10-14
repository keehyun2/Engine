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
 * <p>zeroType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="zeroType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TenorBased" type="{}bool"/>
 *         &lt;element name="DayCounter" type="{}dayCounter"/>
 *         &lt;element name="Compounding" type="{}compounding" minOccurs="0"/>
 *         &lt;element name="CompoundingFrequency" type="{}frequencyType" minOccurs="0"/>
 *         &lt;element name="TenorCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpotLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="SpotCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RollConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="EOM" type="{}bool" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zeroType", propOrder = {

})
public class ZeroType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "TenorBased", required = true)
    protected String tenorBased;
    @XmlElement(name = "DayCounter", required = true)
    protected String dayCounter;
    @XmlElement(name = "Compounding")
    protected String compounding;
    @XmlElement(name = "CompoundingFrequency")
    @XmlSchemaType(name = "string")
    protected FrequencyType compoundingFrequency;
    @XmlElement(name = "TenorCalendar")
    protected String tenorCalendar;
    @XmlElement(name = "SpotLag")
    protected BigInteger spotLag;
    @XmlElement(name = "SpotCalendar")
    protected String spotCalendar;
    @XmlElement(name = "RollConvention")
    protected String rollConvention;
    @XmlElement(name = "EOM")
    protected String eom;

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
     * tenorBased 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenorBased() {
        return tenorBased;
    }

    /**
     * tenorBased 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenorBased(String value) {
        this.tenorBased = value;
    }

    /**
     * dayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayCounter() {
        return dayCounter;
    }

    /**
     * dayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayCounter(String value) {
        this.dayCounter = value;
    }

    /**
     * compounding 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompounding() {
        return compounding;
    }

    /**
     * compounding 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompounding(String value) {
        this.compounding = value;
    }

    /**
     * compoundingFrequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyType }
     *     
     */
    public FrequencyType getCompoundingFrequency() {
        return compoundingFrequency;
    }

    /**
     * compoundingFrequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyType }
     *     
     */
    public void setCompoundingFrequency(FrequencyType value) {
        this.compoundingFrequency = value;
    }

    /**
     * tenorCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenorCalendar() {
        return tenorCalendar;
    }

    /**
     * tenorCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenorCalendar(String value) {
        this.tenorCalendar = value;
    }

    /**
     * spotLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpotLag() {
        return spotLag;
    }

    /**
     * spotLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpotLag(BigInteger value) {
        this.spotLag = value;
    }

    /**
     * spotCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpotCalendar() {
        return spotCalendar;
    }

    /**
     * spotCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpotCalendar(String value) {
        this.spotCalendar = value;
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

}
