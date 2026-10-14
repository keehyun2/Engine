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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="StrikePrice" type="{}strikePriceData"/>
 *         &lt;element name="StrikeYield" type="{}strikeYieldData"/>
 *         &lt;sequence>
 *           &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *           &lt;element name="Currency" type="{}extendedCurrencyCode" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "strikePrice",
    "strikeYield",
    "value",
    "currency"
})
public class StrikeData {

    @XmlElement(name = "StrikePrice")
    protected StrikePriceData strikePrice;
    @XmlElement(name = "StrikeYield")
    protected StrikeYieldData strikeYield;
    @XmlElement(name = "Value")
    protected Float value;
    @XmlElement(name = "Currency")
    protected String currency;

    /**
     * strikePrice 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StrikePriceData }
     *     
     */
    public StrikePriceData getStrikePrice() {
        return strikePrice;
    }

    /**
     * strikePrice 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StrikePriceData }
     *     
     */
    public void setStrikePrice(StrikePriceData value) {
        this.strikePrice = value;
    }

    /**
     * strikeYield 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StrikeYieldData }
     *     
     */
    public StrikeYieldData getStrikeYield() {
        return strikeYield;
    }

    /**
     * strikeYield 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StrikeYieldData }
     *     
     */
    public void setStrikeYield(StrikeYieldData value) {
        this.strikeYield = value;
    }

    /**
     * value 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getValue() {
        return value;
    }

    /**
     * value 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setValue(Float value) {
        this.value = value;
    }

    /**
     * currency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * currency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
