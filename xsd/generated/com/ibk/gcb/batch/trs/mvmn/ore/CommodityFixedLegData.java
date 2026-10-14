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
 * <p>anonymous complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Quantities" type="{}quantitiesType" minOccurs="0"/>
 *         &lt;element name="Prices" type="{}pricesType"/>
 *         &lt;element name="CommodityPayRelativeTo" type="{}commodityPayRelativeToType" minOccurs="0"/>
 *         &lt;element name="Tag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
public class CommodityFixedLegData {

    @XmlElement(name = "Quantities")
    protected QuantitiesType quantities;
    @XmlElement(name = "Prices", required = true)
    protected PricesType prices;
    @XmlElement(name = "CommodityPayRelativeTo")
    @XmlSchemaType(name = "string")
    protected CommodityPayRelativeToType commodityPayRelativeTo;
    @XmlElement(name = "Tag")
    protected String tag;

    /**
     * quantities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link QuantitiesType }
     *     
     */
    public QuantitiesType getQuantities() {
        return quantities;
    }

    /**
     * quantities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantitiesType }
     *     
     */
    public void setQuantities(QuantitiesType value) {
        this.quantities = value;
    }

    /**
     * prices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PricesType }
     *     
     */
    public PricesType getPrices() {
        return prices;
    }

    /**
     * prices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PricesType }
     *     
     */
    public void setPrices(PricesType value) {
        this.prices = value;
    }

    /**
     * commodityPayRelativeTo 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityPayRelativeToType }
     *     
     */
    public CommodityPayRelativeToType getCommodityPayRelativeTo() {
        return commodityPayRelativeTo;
    }

    /**
     * commodityPayRelativeTo 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityPayRelativeToType }
     *     
     */
    public void setCommodityPayRelativeTo(CommodityPayRelativeToType value) {
        this.commodityPayRelativeTo = value;
    }

    /**
     * tag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag() {
        return tag;
    }

    /**
     * tag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag(String value) {
        this.tag = value;
    }

}
