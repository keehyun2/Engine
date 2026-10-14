//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>eqBarrierOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="eqBarrierOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="OptionData" type="{}optionData"/>
 *         &lt;element name="BarrierData" type="{}barrierData"/>
 *         &lt;element name="StartDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="EQIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}underlyingTypes"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element ref="{}strikeGroup"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eqBarrierOptionData", propOrder = {

})
public class EqBarrierOptionData {

    @XmlElement(name = "OptionData", required = true)
    protected OptionData optionData;
    @XmlElement(name = "BarrierData", required = true)
    protected BarrierData barrierData;
    @XmlElement(name = "StartDate")
    protected String startDate;
    @XmlElement(name = "Calendar")
    protected String calendar;
    @XmlElement(name = "EQIndex")
    protected String eqIndex;
    @XmlElementRef(name = "underlyingTypes", type = JAXBElement.class)
    protected JAXBElement<?> underlyingTypes;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElementRef(name = "strikeGroup", type = JAXBElement.class)
    protected JAXBElement<?> strikeGroup;
    @XmlElement(name = "Quantity")
    protected float quantity;

    /**
     * optionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OptionData }
     *     
     */
    public OptionData getOptionData() {
        return optionData;
    }

    /**
     * optionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionData }
     *     
     */
    public void setOptionData(OptionData value) {
        this.optionData = value;
    }

    /**
     * barrierData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BarrierData }
     *     
     */
    public BarrierData getBarrierData() {
        return barrierData;
    }

    /**
     * barrierData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BarrierData }
     *     
     */
    public void setBarrierData(BarrierData value) {
        this.barrierData = value;
    }

    /**
     * startDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * startDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
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
     * eqIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEQIndex() {
        return eqIndex;
    }

    /**
     * eqIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEQIndex(String value) {
        this.eqIndex = value;
    }

    /**
     * underlyingTypes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlying }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlyings }{@code >}
     *     
     */
    public JAXBElement<?> getUnderlyingTypes() {
        return underlyingTypes;
    }

    /**
     * underlyingTypes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlying }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlyings }{@code >}
     *     
     */
    public void setUnderlyingTypes(JAXBElement<?> value) {
        this.underlyingTypes = value;
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
     * strikeGroup 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StrikeData }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<?> getStrikeGroup() {
        return strikeGroup;
    }

    /**
     * strikeGroup 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StrikeData }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStrikeGroup(JAXBElement<?> value) {
        this.strikeGroup = value;
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

}
