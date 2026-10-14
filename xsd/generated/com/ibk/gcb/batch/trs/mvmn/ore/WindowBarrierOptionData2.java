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
 * <p>windowBarrierOptionData2 complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="windowBarrierOptionData2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="FixingAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element ref="{}strikeGroup"/>
 *         &lt;element name="Underlying" type="{}underlying"/>
 *         &lt;element name="OptionData" type="{}optionData"/>
 *         &lt;element name="StartDate" type="{}date"/>
 *         &lt;element name="EndDate" type="{}date"/>
 *         &lt;element name="BarrierData" type="{}barrierData"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "windowBarrierOptionData2", propOrder = {

})
public class WindowBarrierOptionData2 {

    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "FixingAmount")
    protected float fixingAmount;
    @XmlElementRef(name = "strikeGroup", type = JAXBElement.class)
    protected JAXBElement<?> strikeGroup;
    @XmlElement(name = "Underlying", required = true)
    protected Underlying underlying;
    @XmlElement(name = "OptionData", required = true)
    protected OptionData optionData;
    @XmlElement(name = "StartDate", required = true)
    protected String startDate;
    @XmlElement(name = "EndDate", required = true)
    protected String endDate;
    @XmlElement(name = "BarrierData", required = true)
    protected BarrierData barrierData;

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
     * fixingAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getFixingAmount() {
        return fixingAmount;
    }

    /**
     * fixingAmount 속성의 값을 설정합니다.
     * 
     */
    public void setFixingAmount(float value) {
        this.fixingAmount = value;
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
     * underlying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getUnderlying() {
        return underlying;
    }

    /**
     * underlying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setUnderlying(Underlying value) {
        this.underlying = value;
    }

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

}
