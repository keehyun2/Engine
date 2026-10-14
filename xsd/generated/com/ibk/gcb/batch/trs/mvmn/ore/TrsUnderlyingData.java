//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>trsUnderlyingData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="trsUnderlyingData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="Derivative">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                     &lt;element ref="{}subTradeGroup"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element ref="{}subTradeGroup"/>
 *           &lt;element name="PortfolioIndexTradeData" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="BasketName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                     &lt;element name="IndexQuantity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trsUnderlyingData", propOrder = {
    "derivativeOrSubTradeGroupOrPortfolioIndexTradeData"
})
public class TrsUnderlyingData {

    @XmlElementRefs({
        @XmlElementRef(name = "subTradeGroup", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PortfolioIndexTradeData", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Derivative", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> derivativeOrSubTradeGroupOrPortfolioIndexTradeData;

    /**
     * Gets the value of the derivativeOrSubTradeGroupOrPortfolioIndexTradeData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the derivativeOrSubTradeGroupOrPortfolioIndexTradeData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDerivativeOrSubTradeGroupOrPortfolioIndexTradeData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link SubTrade }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link TrsUnderlyingData.PortfolioIndexTradeData }{@code >}
     * {@link JAXBElement }{@code <}{@link TrsUnderlyingData.Derivative }{@code >}
     * {@link JAXBElement }{@code <}{@link Trade }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getDerivativeOrSubTradeGroupOrPortfolioIndexTradeData() {
        if (derivativeOrSubTradeGroupOrPortfolioIndexTradeData == null) {
            derivativeOrSubTradeGroupOrPortfolioIndexTradeData = new ArrayList<JAXBElement<?>>();
        }
        return this.derivativeOrSubTradeGroupOrPortfolioIndexTradeData;
    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element ref="{}subTradeGroup"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "id",
        "subTradeGroup"
    })
    public static class Derivative {

        @XmlElement(name = "Id", required = true)
        protected String id;
        @XmlElementRef(name = "subTradeGroup", type = JAXBElement.class)
        protected JAXBElement<?> subTradeGroup;

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
         * subTradeGroup 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link SubTrade }{@code >}
         *     {@link JAXBElement }{@code <}{@link Trade }{@code >}
         *     {@link JAXBElement }{@code <}{@link Object }{@code >}
         *     
         */
        public JAXBElement<?> getSubTradeGroup() {
            return subTradeGroup;
        }

        /**
         * subTradeGroup 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link SubTrade }{@code >}
         *     {@link JAXBElement }{@code <}{@link Trade }{@code >}
         *     {@link JAXBElement }{@code <}{@link Object }{@code >}
         *     
         */
        public void setSubTradeGroup(JAXBElement<?> value) {
            this.subTradeGroup = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BasketName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="IndexQuantity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "basketName",
        "indexQuantity"
    })
    public static class PortfolioIndexTradeData {

        @XmlElement(name = "BasketName", required = true)
        protected String basketName;
        @XmlElement(name = "IndexQuantity")
        protected String indexQuantity;

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
         *     {@link String }
         *     
         */
        public String getIndexQuantity() {
            return indexQuantity;
        }

        /**
         * indexQuantity 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndexQuantity(String value) {
            this.indexQuantity = value;
        }

    }

}
