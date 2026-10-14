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
 * <p>premiumData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="premiumData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Premium" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="Currency" type="{}extendedCurrencyCode"/>
 *                   &lt;element name="PayDate" type="{}date"/>
 *                   &lt;element name="SettlementData" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="PayCurrency" type="{}currencyCode"/>
 *                             &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="FixingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "premiumData", propOrder = {
    "premium"
})
public class PremiumData {

    @XmlElement(name = "Premium")
    protected List<PremiumData.Premium> premium;

    /**
     * Gets the value of the premium property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the premium property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPremium().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PremiumData.Premium }
     * 
     * 
     */
    public List<PremiumData.Premium> getPremium() {
        if (premium == null) {
            premium = new ArrayList<PremiumData.Premium>();
        }
        return this.premium;
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
     *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="Currency" type="{}extendedCurrencyCode"/>
     *         &lt;element name="PayDate" type="{}date"/>
     *         &lt;element name="SettlementData" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="PayCurrency" type="{}currencyCode"/>
     *                   &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="FixingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
    public static class Premium {

        @XmlElement(name = "Amount")
        protected float amount;
        @XmlElement(name = "Currency", required = true)
        protected String currency;
        @XmlElement(name = "PayDate", required = true)
        protected String payDate;
        @XmlElement(name = "SettlementData")
        protected PremiumData.Premium.SettlementData settlementData;

        /**
         * amount 속성의 값을 가져옵니다.
         * 
         */
        public float getAmount() {
            return amount;
        }

        /**
         * amount 속성의 값을 설정합니다.
         * 
         */
        public void setAmount(float value) {
            this.amount = value;
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

        /**
         * payDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPayDate() {
            return payDate;
        }

        /**
         * payDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPayDate(String value) {
            this.payDate = value;
        }

        /**
         * settlementData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link PremiumData.Premium.SettlementData }
         *     
         */
        public PremiumData.Premium.SettlementData getSettlementData() {
            return settlementData;
        }

        /**
         * settlementData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link PremiumData.Premium.SettlementData }
         *     
         */
        public void setSettlementData(PremiumData.Premium.SettlementData value) {
            this.settlementData = value;
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
         *         &lt;element name="PayCurrency" type="{}currencyCode"/>
         *         &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="FixingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        public static class SettlementData {

            @XmlElement(name = "PayCurrency", required = true)
            @XmlSchemaType(name = "string")
            protected CurrencyCode payCurrency;
            @XmlElement(name = "FXIndex", required = true)
            protected String fxIndex;
            @XmlElement(name = "FixingDate")
            protected String fixingDate;

            /**
             * payCurrency 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link CurrencyCode }
             *     
             */
            public CurrencyCode getPayCurrency() {
                return payCurrency;
            }

            /**
             * payCurrency 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link CurrencyCode }
             *     
             */
            public void setPayCurrency(CurrencyCode value) {
                this.payCurrency = value;
            }

            /**
             * fxIndex 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFXIndex() {
                return fxIndex;
            }

            /**
             * fxIndex 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFXIndex(String value) {
                this.fxIndex = value;
            }

            /**
             * fixingDate 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFixingDate() {
                return fixingDate;
            }

            /**
             * fixingDate 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFixingDate(String value) {
                this.fixingDate = value;
            }

        }

    }

}
