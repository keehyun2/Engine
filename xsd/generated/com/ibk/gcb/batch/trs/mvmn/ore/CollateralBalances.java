//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>collateralBalances complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="collateralBalances">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CollateralBalance" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element ref="{}nettingSetGroup"/>
 *                   &lt;element name="Currency" type="{}currencyCode" minOccurs="0"/>
 *                   &lt;element name="InitialMargin" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="VariationMargin" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collateralBalances", propOrder = {
    "collateralBalance"
})
public class CollateralBalances {

    @XmlElement(name = "CollateralBalance")
    protected List<CollateralBalances.CollateralBalance> collateralBalance;

    /**
     * Gets the value of the collateralBalance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the collateralBalance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCollateralBalance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CollateralBalances.CollateralBalance }
     * 
     * 
     */
    public List<CollateralBalances.CollateralBalance> getCollateralBalance() {
        if (collateralBalance == null) {
            collateralBalance = new ArrayList<CollateralBalances.CollateralBalance>();
        }
        return this.collateralBalance;
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
     *       &lt;all>
     *         &lt;element ref="{}nettingSetGroup"/>
     *         &lt;element name="Currency" type="{}currencyCode" minOccurs="0"/>
     *         &lt;element name="InitialMargin" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="VariationMargin" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
    public static class CollateralBalance {

        @XmlElementRef(name = "nettingSetGroup", type = JAXBElement.class)
        protected JAXBElement<?> nettingSetGroup;
        @XmlElement(name = "Currency")
        @XmlSchemaType(name = "string")
        protected CurrencyCode currency;
        @XmlElement(name = "InitialMargin")
        protected BigDecimal initialMargin;
        @XmlElement(name = "VariationMargin")
        protected BigDecimal variationMargin;

        /**
         * nettingSetGroup 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link NettingSetDetails }{@code >}
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     {@link JAXBElement }{@code <}{@link Object }{@code >}
         *     
         */
        public JAXBElement<?> getNettingSetGroup() {
            return nettingSetGroup;
        }

        /**
         * nettingSetGroup 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link NettingSetDetails }{@code >}
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     {@link JAXBElement }{@code <}{@link Object }{@code >}
         *     
         */
        public void setNettingSetGroup(JAXBElement<?> value) {
            this.nettingSetGroup = value;
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
         * initialMargin 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getInitialMargin() {
            return initialMargin;
        }

        /**
         * initialMargin 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setInitialMargin(BigDecimal value) {
            this.initialMargin = value;
        }

        /**
         * variationMargin 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getVariationMargin() {
            return variationMargin;
        }

        /**
         * variationMargin 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setVariationMargin(BigDecimal value) {
            this.variationMargin = value;
        }

    }

}
