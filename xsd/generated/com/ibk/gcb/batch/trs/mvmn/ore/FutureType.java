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
 * <p>futureType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="futureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateGenerationRule" type="{}futureDateGenerationRule" minOccurs="0"/>
 *         &lt;element name="OvernightIndexFutureNettingType" type="{}overnightIndexFutureNettingType" minOccurs="0"/>
 *         &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "futureType", propOrder = {

})
public class FutureType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Index", required = true)
    protected String index;
    @XmlElement(name = "DateGenerationRule")
    @XmlSchemaType(name = "string")
    protected FutureDateGenerationRule dateGenerationRule;
    @XmlElement(name = "OvernightIndexFutureNettingType")
    @XmlSchemaType(name = "string")
    protected OvernightIndexFutureNettingType overnightIndexFutureNettingType;
    @XmlElement(name = "Calendar")
    protected String calendar;

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
     * dateGenerationRule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FutureDateGenerationRule }
     *     
     */
    public FutureDateGenerationRule getDateGenerationRule() {
        return dateGenerationRule;
    }

    /**
     * dateGenerationRule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FutureDateGenerationRule }
     *     
     */
    public void setDateGenerationRule(FutureDateGenerationRule value) {
        this.dateGenerationRule = value;
    }

    /**
     * overnightIndexFutureNettingType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OvernightIndexFutureNettingType }
     *     
     */
    public OvernightIndexFutureNettingType getOvernightIndexFutureNettingType() {
        return overnightIndexFutureNettingType;
    }

    /**
     * overnightIndexFutureNettingType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OvernightIndexFutureNettingType }
     *     
     */
    public void setOvernightIndexFutureNettingType(OvernightIndexFutureNettingType value) {
        this.overnightIndexFutureNettingType = value;
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

}
