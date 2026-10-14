//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>fxDigitalOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="fxDigitalOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OptionData" type="{}optionData" maxOccurs="unbounded"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="PayoffCurrency" type="{}currencyCode" minOccurs="0"/>
 *         &lt;element name="PayoffAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="ForeignCurrency" type="{}currencyCode"/>
 *         &lt;element name="DomesticCurrency" type="{}currencyCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fxDigitalOptionData", propOrder = {
    "optionData",
    "strike",
    "payoffCurrency",
    "payoffAmount",
    "foreignCurrency",
    "domesticCurrency"
})
public class FxDigitalOptionData {

    @XmlElement(name = "OptionData", required = true)
    protected List<OptionData> optionData;
    @XmlElement(name = "Strike")
    protected float strike;
    @XmlElement(name = "PayoffCurrency")
    @XmlSchemaType(name = "string")
    protected CurrencyCode payoffCurrency;
    @XmlElement(name = "PayoffAmount")
    protected float payoffAmount;
    @XmlElement(name = "ForeignCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode foreignCurrency;
    @XmlElement(name = "DomesticCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode domesticCurrency;

    /**
     * Gets the value of the optionData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the optionData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptionData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionData }
     * 
     * 
     */
    public List<OptionData> getOptionData() {
        if (optionData == null) {
            optionData = new ArrayList<OptionData>();
        }
        return this.optionData;
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
     * payoffCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getPayoffCurrency() {
        return payoffCurrency;
    }

    /**
     * payoffCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setPayoffCurrency(CurrencyCode value) {
        this.payoffCurrency = value;
    }

    /**
     * payoffAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getPayoffAmount() {
        return payoffAmount;
    }

    /**
     * payoffAmount 속성의 값을 설정합니다.
     * 
     */
    public void setPayoffAmount(float value) {
        this.payoffAmount = value;
    }

    /**
     * foreignCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getForeignCurrency() {
        return foreignCurrency;
    }

    /**
     * foreignCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setForeignCurrency(CurrencyCode value) {
        this.foreignCurrency = value;
    }

    /**
     * domesticCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getDomesticCurrency() {
        return domesticCurrency;
    }

    /**
     * domesticCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setDomesticCurrency(CurrencyCode value) {
        this.domesticCurrency = value;
    }

}
