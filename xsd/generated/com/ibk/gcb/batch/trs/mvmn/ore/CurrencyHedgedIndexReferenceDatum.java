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
 * <p>currencyHedgedIndexReferenceDatum complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="currencyHedgedIndexReferenceDatum">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnderlyingIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HedgeCurrency" type="{}currencyCode"/>
 *         &lt;element name="RebalancingStrategy" type="{}CurrencyHedgedIndexRebalancingStrategy"/>
 *         &lt;element name="ReferenceDateOffset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HedgeAdjustment" type="{}CurrencyHedgedIndexRehedgingStrategy"/>
 *         &lt;element name="HedgeCalendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FxIndexes" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FxIndex" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="IndexName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IndexWeightsAtLastRebalancingDate" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Underlying" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
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
@XmlType(name = "currencyHedgedIndexReferenceDatum", propOrder = {
    "underlyingIndex",
    "hedgeCurrency",
    "rebalancingStrategy",
    "referenceDateOffset",
    "hedgeAdjustment",
    "hedgeCalendar",
    "fxIndexes",
    "indexWeightsAtLastRebalancingDate"
})
public class CurrencyHedgedIndexReferenceDatum {

    @XmlElement(name = "UnderlyingIndex", required = true)
    protected String underlyingIndex;
    @XmlElement(name = "HedgeCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode hedgeCurrency;
    @XmlElement(name = "RebalancingStrategy", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyHedgedIndexRebalancingStrategy rebalancingStrategy;
    @XmlElement(name = "ReferenceDateOffset", required = true)
    protected String referenceDateOffset;
    @XmlElement(name = "HedgeAdjustment", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyHedgedIndexRehedgingStrategy hedgeAdjustment;
    @XmlElement(name = "HedgeCalendar", required = true)
    protected String hedgeCalendar;
    @XmlElement(name = "FxIndexes", required = true)
    protected List<CurrencyHedgedIndexReferenceDatum.FxIndexes> fxIndexes;
    @XmlElement(name = "IndexWeightsAtLastRebalancingDate")
    protected List<CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate> indexWeightsAtLastRebalancingDate;

    /**
     * underlyingIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnderlyingIndex() {
        return underlyingIndex;
    }

    /**
     * underlyingIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnderlyingIndex(String value) {
        this.underlyingIndex = value;
    }

    /**
     * hedgeCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getHedgeCurrency() {
        return hedgeCurrency;
    }

    /**
     * hedgeCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setHedgeCurrency(CurrencyCode value) {
        this.hedgeCurrency = value;
    }

    /**
     * rebalancingStrategy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyHedgedIndexRebalancingStrategy }
     *     
     */
    public CurrencyHedgedIndexRebalancingStrategy getRebalancingStrategy() {
        return rebalancingStrategy;
    }

    /**
     * rebalancingStrategy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyHedgedIndexRebalancingStrategy }
     *     
     */
    public void setRebalancingStrategy(CurrencyHedgedIndexRebalancingStrategy value) {
        this.rebalancingStrategy = value;
    }

    /**
     * referenceDateOffset 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceDateOffset() {
        return referenceDateOffset;
    }

    /**
     * referenceDateOffset 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceDateOffset(String value) {
        this.referenceDateOffset = value;
    }

    /**
     * hedgeAdjustment 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyHedgedIndexRehedgingStrategy }
     *     
     */
    public CurrencyHedgedIndexRehedgingStrategy getHedgeAdjustment() {
        return hedgeAdjustment;
    }

    /**
     * hedgeAdjustment 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyHedgedIndexRehedgingStrategy }
     *     
     */
    public void setHedgeAdjustment(CurrencyHedgedIndexRehedgingStrategy value) {
        this.hedgeAdjustment = value;
    }

    /**
     * hedgeCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHedgeCalendar() {
        return hedgeCalendar;
    }

    /**
     * hedgeCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHedgeCalendar(String value) {
        this.hedgeCalendar = value;
    }

    /**
     * Gets the value of the fxIndexes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fxIndexes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFxIndexes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrencyHedgedIndexReferenceDatum.FxIndexes }
     * 
     * 
     */
    public List<CurrencyHedgedIndexReferenceDatum.FxIndexes> getFxIndexes() {
        if (fxIndexes == null) {
            fxIndexes = new ArrayList<CurrencyHedgedIndexReferenceDatum.FxIndexes>();
        }
        return this.fxIndexes;
    }

    /**
     * Gets the value of the indexWeightsAtLastRebalancingDate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the indexWeightsAtLastRebalancingDate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndexWeightsAtLastRebalancingDate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate }
     * 
     * 
     */
    public List<CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate> getIndexWeightsAtLastRebalancingDate() {
        if (indexWeightsAtLastRebalancingDate == null) {
            indexWeightsAtLastRebalancingDate = new ArrayList<CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate>();
        }
        return this.indexWeightsAtLastRebalancingDate;
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
     *         &lt;element name="FxIndex" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="IndexName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    @XmlType(name = "", propOrder = {
        "fxIndex"
    })
    public static class FxIndexes {

        @XmlElement(name = "FxIndex")
        protected List<CurrencyHedgedIndexReferenceDatum.FxIndexes.FxIndex> fxIndex;

        /**
         * Gets the value of the fxIndex property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fxIndex property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFxIndex().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CurrencyHedgedIndexReferenceDatum.FxIndexes.FxIndex }
         * 
         * 
         */
        public List<CurrencyHedgedIndexReferenceDatum.FxIndexes.FxIndex> getFxIndex() {
            if (fxIndex == null) {
                fxIndex = new ArrayList<CurrencyHedgedIndexReferenceDatum.FxIndexes.FxIndex>();
            }
            return this.fxIndex;
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
         *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="IndexName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        public static class FxIndex {

            @XmlElement(name = "Currency", required = true)
            protected String currency;
            @XmlElement(name = "IndexName", required = true)
            protected String indexName;

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
             * indexName 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIndexName() {
                return indexName;
            }

            /**
             * indexName 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIndexName(String value) {
                this.indexName = value;
            }

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
     *         &lt;element name="Underlying" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
    @XmlType(name = "", propOrder = {
        "underlying"
    })
    public static class IndexWeightsAtLastRebalancingDate {

        @XmlElement(name = "Underlying")
        protected List<CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate.Underlying> underlying;

        /**
         * Gets the value of the underlying property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the underlying property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUnderlying().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate.Underlying }
         * 
         * 
         */
        public List<CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate.Underlying> getUnderlying() {
            if (underlying == null) {
                underlying = new ArrayList<CurrencyHedgedIndexReferenceDatum.IndexWeightsAtLastRebalancingDate.Underlying>();
            }
            return this.underlying;
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
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
        public static class Underlying {

            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "Weight")
            protected float weight;

            /**
             * name 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * name 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * weight 속성의 값을 가져옵니다.
             * 
             */
            public float getWeight() {
                return weight;
            }

            /**
             * weight 속성의 값을 설정합니다.
             * 
             */
            public void setWeight(float value) {
                this.weight = value;
            }

        }

    }

}
