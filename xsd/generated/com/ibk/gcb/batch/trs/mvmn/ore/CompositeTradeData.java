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
 * <p>compositeTradeData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="compositeTradeData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="NotionalCalculation" type="{}notionalCalculation" minOccurs="0"/>
 *         &lt;element name="NotionalOverride" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="PortfolioBasket" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BasketName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndexQuantity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Components" type="{}compositeTradeComponents" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compositeTradeData", propOrder = {

})
public class CompositeTradeData {

    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "NotionalCalculation")
    protected String notionalCalculation;
    @XmlElement(name = "NotionalOverride")
    protected Float notionalOverride;
    @XmlElement(name = "PortfolioBasket")
    protected Boolean portfolioBasket;
    @XmlElement(name = "BasketName")
    protected String basketName;
    @XmlElement(name = "IndexQuantity")
    protected Double indexQuantity;
    @XmlElement(name = "Components")
    protected CompositeTradeComponents components;

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
     * notionalCalculation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotionalCalculation() {
        return notionalCalculation;
    }

    /**
     * notionalCalculation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotionalCalculation(String value) {
        this.notionalCalculation = value;
    }

    /**
     * notionalOverride 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNotionalOverride() {
        return notionalOverride;
    }

    /**
     * notionalOverride 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNotionalOverride(Float value) {
        this.notionalOverride = value;
    }

    /**
     * portfolioBasket 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPortfolioBasket() {
        return portfolioBasket;
    }

    /**
     * portfolioBasket 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPortfolioBasket(Boolean value) {
        this.portfolioBasket = value;
    }

    /**
     * basketName 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasketName() {
        return basketName;
    }

    /**
     * basketName 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasketName(String value) {
        this.basketName = value;
    }

    /**
     * indexQuantity 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIndexQuantity() {
        return indexQuantity;
    }

    /**
     * indexQuantity 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIndexQuantity(Double value) {
        this.indexQuantity = value;
    }

    /**
     * components 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CompositeTradeComponents }
     *     
     */
    public CompositeTradeComponents getComponents() {
        return components;
    }

    /**
     * components 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CompositeTradeComponents }
     *     
     */
    public void setComponents(CompositeTradeComponents value) {
        this.components = value;
    }

}
