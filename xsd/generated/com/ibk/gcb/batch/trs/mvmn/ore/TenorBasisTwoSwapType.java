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
 * <p>tenorBasisTwoSwapType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="tenorBasisTwoSwapType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LongFixedFrequency" type="{}frequencyType"/>
 *         &lt;element name="LongFixedConvention" type="{}businessDayConvention"/>
 *         &lt;element name="LongFixedDayCounter" type="{}dayCounter"/>
 *         &lt;element name="LongIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShortFixedFrequency" type="{}frequencyType"/>
 *         &lt;element name="ShortFixedConvention" type="{}businessDayConvention"/>
 *         &lt;element name="ShortFixedDayCounter" type="{}dayCounter"/>
 *         &lt;element name="ShortIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LongMinusShort" type="{}bool" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tenorBasisTwoSwapType", propOrder = {

})
public class TenorBasisTwoSwapType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Calendar", required = true)
    protected String calendar;
    @XmlElement(name = "LongFixedFrequency", required = true)
    @XmlSchemaType(name = "string")
    protected FrequencyType longFixedFrequency;
    @XmlElement(name = "LongFixedConvention", required = true)
    protected String longFixedConvention;
    @XmlElement(name = "LongFixedDayCounter", required = true)
    protected String longFixedDayCounter;
    @XmlElement(name = "LongIndex", required = true)
    protected String longIndex;
    @XmlElement(name = "ShortFixedFrequency", required = true)
    @XmlSchemaType(name = "string")
    protected FrequencyType shortFixedFrequency;
    @XmlElement(name = "ShortFixedConvention", required = true)
    protected String shortFixedConvention;
    @XmlElement(name = "ShortFixedDayCounter", required = true)
    protected String shortFixedDayCounter;
    @XmlElement(name = "ShortIndex", required = true)
    protected String shortIndex;
    @XmlElement(name = "LongMinusShort")
    protected String longMinusShort;

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
     * calendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalendar() {
        return calendar;
    }

    /**
     * calendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalendar(String value) {
        this.calendar = value;
    }

    /**
     * longFixedFrequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyType }
     *     
     */
    public FrequencyType getLongFixedFrequency() {
        return longFixedFrequency;
    }

    /**
     * longFixedFrequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyType }
     *     
     */
    public void setLongFixedFrequency(FrequencyType value) {
        this.longFixedFrequency = value;
    }

    /**
     * longFixedConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongFixedConvention() {
        return longFixedConvention;
    }

    /**
     * longFixedConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongFixedConvention(String value) {
        this.longFixedConvention = value;
    }

    /**
     * longFixedDayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongFixedDayCounter() {
        return longFixedDayCounter;
    }

    /**
     * longFixedDayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongFixedDayCounter(String value) {
        this.longFixedDayCounter = value;
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
     * shortFixedFrequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyType }
     *     
     */
    public FrequencyType getShortFixedFrequency() {
        return shortFixedFrequency;
    }

    /**
     * shortFixedFrequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyType }
     *     
     */
    public void setShortFixedFrequency(FrequencyType value) {
        this.shortFixedFrequency = value;
    }

    /**
     * shortFixedConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortFixedConvention() {
        return shortFixedConvention;
    }

    /**
     * shortFixedConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortFixedConvention(String value) {
        this.shortFixedConvention = value;
    }

    /**
     * shortFixedDayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortFixedDayCounter() {
        return shortFixedDayCounter;
    }

    /**
     * shortFixedDayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortFixedDayCounter(String value) {
        this.shortFixedDayCounter = value;
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
     * longMinusShort 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongMinusShort() {
        return longMinusShort;
    }

    /**
     * longMinusShort 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongMinusShort(String value) {
        this.longMinusShort = value;
    }

}
