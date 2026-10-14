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
 * <p>varianceSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="varianceSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="StartDate" type="{}date"/>
 *         &lt;element name="EndDate" type="{}date"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element ref="{}underlyingTypes"/>
 *         &lt;element name="LongShort" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Notional" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Calendar" type="{}calendar"/>
 *         &lt;element name="MomentType" type="{}momentType" minOccurs="0"/>
 *         &lt;element name="AddPastDividends" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "varianceSwapData", propOrder = {

})
public class VarianceSwapData {

    @XmlElement(name = "StartDate", required = true)
    protected String startDate;
    @XmlElement(name = "EndDate", required = true)
    protected String endDate;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElementRef(name = "underlyingTypes", type = JAXBElement.class)
    protected JAXBElement<?> underlyingTypes;
    @XmlElement(name = "LongShort", required = true)
    protected String longShort;
    @XmlElement(name = "Strike")
    protected float strike;
    @XmlElement(name = "Notional")
    protected float notional;
    @XmlElement(name = "Calendar", required = true)
    protected String calendar;
    @XmlElement(name = "MomentType")
    @XmlSchemaType(name = "string")
    protected MomentType momentType;
    @XmlElement(name = "AddPastDividends")
    protected Boolean addPastDividends;

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
     * endDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * endDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
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
     * longShort 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongShort() {
        return longShort;
    }

    /**
     * longShort 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongShort(String value) {
        this.longShort = value;
    }

    /**
     * strike 속성의 값을 가져옵니다.
     * 
     */
    public float getStrike() {
        return strike;
    }

    /**
     * strike 속성의 값을 설정합니다.
     * 
     */
    public void setStrike(float value) {
        this.strike = value;
    }

    /**
     * notional 속성의 값을 가져옵니다.
     * 
     */
    public float getNotional() {
        return notional;
    }

    /**
     * notional 속성의 값을 설정합니다.
     * 
     */
    public void setNotional(float value) {
        this.notional = value;
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
     * momentType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MomentType }
     *     
     */
    public MomentType getMomentType() {
        return momentType;
    }

    /**
     * momentType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MomentType }
     *     
     */
    public void setMomentType(MomentType value) {
        this.momentType = value;
    }

    /**
     * addPastDividends 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAddPastDividends() {
        return addPastDividends;
    }

    /**
     * addPastDividends 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAddPastDividends(Boolean value) {
        this.addPastDividends = value;
    }

}
