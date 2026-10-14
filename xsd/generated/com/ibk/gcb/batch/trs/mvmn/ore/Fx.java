//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>fx complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="fx">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RiskWeights">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice maxOccurs="unbounded">
 *                   &lt;element name="Delta">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Weight" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
 *                                     &lt;attribute name="label1" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="label2" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Vega">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                           &lt;/all>
 *                           &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="HistoricalVolatilityRatio" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
 *                           &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Inflation">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
 *                           &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="XCcyBasis">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
 *                           &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="CurrencyLists" type="{}currencyLists"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Correlations">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="IntraBucket">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Correlation" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
 *                                     &lt;attribute name="bucket" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="label1" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="label2" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Volatility" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ConcentrationThresholds" type="{}irfxConcentrationThresholds"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fx", propOrder = {
    "riskWeights",
    "correlations",
    "concentrationThresholds"
})
public class Fx {

    @XmlElement(name = "RiskWeights", required = true)
    protected Fx.RiskWeights riskWeights;
    @XmlElement(name = "Correlations", required = true)
    protected Fx.Correlations correlations;
    @XmlElement(name = "ConcentrationThresholds", required = true)
    protected IrfxConcentrationThresholds concentrationThresholds;

    /**
     * riskWeights 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Fx.RiskWeights }
     *     
     */
    public Fx.RiskWeights getRiskWeights() {
        return riskWeights;
    }

    /**
     * riskWeights 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Fx.RiskWeights }
     *     
     */
    public void setRiskWeights(Fx.RiskWeights value) {
        this.riskWeights = value;
    }

    /**
     * correlations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Fx.Correlations }
     *     
     */
    public Fx.Correlations getCorrelations() {
        return correlations;
    }

    /**
     * correlations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Fx.Correlations }
     *     
     */
    public void setCorrelations(Fx.Correlations value) {
        this.correlations = value;
    }

    /**
     * concentrationThresholds 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link IrfxConcentrationThresholds }
     *     
     */
    public IrfxConcentrationThresholds getConcentrationThresholds() {
        return concentrationThresholds;
    }

    /**
     * concentrationThresholds 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link IrfxConcentrationThresholds }
     *     
     */
    public void setConcentrationThresholds(IrfxConcentrationThresholds value) {
        this.concentrationThresholds = value;
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
     *         &lt;element name="IntraBucket">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Correlation" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
     *                           &lt;attribute name="bucket" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="label1" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="label2" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Volatility" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
    public static class Correlations {

        @XmlElement(name = "IntraBucket", required = true)
        protected Fx.Correlations.IntraBucket intraBucket;
        @XmlElement(name = "Volatility", required = true)
        protected BigDecimal volatility;

        /**
         * intraBucket 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Fx.Correlations.IntraBucket }
         *     
         */
        public Fx.Correlations.IntraBucket getIntraBucket() {
            return intraBucket;
        }

        /**
         * intraBucket 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Fx.Correlations.IntraBucket }
         *     
         */
        public void setIntraBucket(Fx.Correlations.IntraBucket value) {
            this.intraBucket = value;
        }

        /**
         * volatility 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getVolatility() {
            return volatility;
        }

        /**
         * volatility 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setVolatility(BigDecimal value) {
            this.volatility = value;
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
         *         &lt;element name="Correlation" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
         *                 &lt;attribute name="bucket" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="label1" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="label2" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
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
            "correlation"
        })
        public static class IntraBucket {

            @XmlElement(name = "Correlation", required = true)
            protected List<Fx.Correlations.IntraBucket.Correlation> correlation;

            /**
             * Gets the value of the correlation property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the correlation property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCorrelation().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Fx.Correlations.IntraBucket.Correlation }
             * 
             * 
             */
            public List<Fx.Correlations.IntraBucket.Correlation> getCorrelation() {
                if (correlation == null) {
                    correlation = new ArrayList<Fx.Correlations.IntraBucket.Correlation>();
                }
                return this.correlation;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
             *       &lt;attribute name="bucket" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="label1" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="label2" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Correlation {

                @XmlValue
                protected BigDecimal value;
                @XmlAttribute(name = "bucket", required = true)
                protected BigInteger bucket;
                @XmlAttribute(name = "label1", required = true)
                protected BigInteger label1;
                @XmlAttribute(name = "label2", required = true)
                protected BigInteger label2;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValue(BigDecimal value) {
                    this.value = value;
                }

                /**
                 * bucket 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getBucket() {
                    return bucket;
                }

                /**
                 * bucket 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setBucket(BigInteger value) {
                    this.bucket = value;
                }

                /**
                 * label1 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getLabel1() {
                    return label1;
                }

                /**
                 * label1 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setLabel1(BigInteger value) {
                    this.label1 = value;
                }

                /**
                 * label2 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getLabel2() {
                    return label2;
                }

                /**
                 * label2 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setLabel2(BigInteger value) {
                    this.label2 = value;
                }

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
     *       &lt;choice maxOccurs="unbounded">
     *         &lt;element name="Delta">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Weight" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
     *                           &lt;attribute name="label1" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="label2" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Vega">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/all>
     *                 &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="HistoricalVolatilityRatio" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
     *                 &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Inflation">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
     *                 &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="XCcyBasis">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
     *                 &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="CurrencyLists" type="{}currencyLists"/>
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
        "deltaOrVegaOrHistoricalVolatilityRatio"
    })
    public static class RiskWeights {

        @XmlElements({
            @XmlElement(name = "Delta", type = Fx.RiskWeights.Delta.class),
            @XmlElement(name = "Vega", type = Fx.RiskWeights.Vega.class),
            @XmlElement(name = "HistoricalVolatilityRatio", type = Fx.RiskWeights.HistoricalVolatilityRatio.class),
            @XmlElement(name = "Inflation", type = Fx.RiskWeights.Inflation.class),
            @XmlElement(name = "XCcyBasis", type = Fx.RiskWeights.XCcyBasis.class),
            @XmlElement(name = "CurrencyLists", type = CurrencyLists.class)
        })
        protected List<Object> deltaOrVegaOrHistoricalVolatilityRatio;

        /**
         * Gets the value of the deltaOrVegaOrHistoricalVolatilityRatio property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the deltaOrVegaOrHistoricalVolatilityRatio property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDeltaOrVegaOrHistoricalVolatilityRatio().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Fx.RiskWeights.Delta }
         * {@link Fx.RiskWeights.Vega }
         * {@link Fx.RiskWeights.HistoricalVolatilityRatio }
         * {@link Fx.RiskWeights.Inflation }
         * {@link Fx.RiskWeights.XCcyBasis }
         * {@link CurrencyLists }
         * 
         * 
         */
        public List<Object> getDeltaOrVegaOrHistoricalVolatilityRatio() {
            if (deltaOrVegaOrHistoricalVolatilityRatio == null) {
                deltaOrVegaOrHistoricalVolatilityRatio = new ArrayList<Object>();
            }
            return this.deltaOrVegaOrHistoricalVolatilityRatio;
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
         *         &lt;element name="Weight" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
         *                 &lt;attribute name="label1" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="label2" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "weight"
        })
        public static class Delta {

            @XmlElement(name = "Weight", required = true)
            protected List<Fx.RiskWeights.Delta.Weight> weight;
            @XmlAttribute(name = "mporDays")
            protected BigInteger mporDays;

            /**
             * Gets the value of the weight property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the weight property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getWeight().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Fx.RiskWeights.Delta.Weight }
             * 
             * 
             */
            public List<Fx.RiskWeights.Delta.Weight> getWeight() {
                if (weight == null) {
                    weight = new ArrayList<Fx.RiskWeights.Delta.Weight>();
                }
                return this.weight;
            }

            /**
             * mporDays 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMporDays() {
                return mporDays;
            }

            /**
             * mporDays 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMporDays(BigInteger value) {
                this.mporDays = value;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
             *       &lt;attribute name="label1" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="label2" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Weight {

                @XmlValue
                protected BigDecimal value;
                @XmlAttribute(name = "label1", required = true)
                protected BigInteger label1;
                @XmlAttribute(name = "label2", required = true)
                protected BigInteger label2;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValue(BigDecimal value) {
                    this.value = value;
                }

                /**
                 * label1 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getLabel1() {
                    return label1;
                }

                /**
                 * label1 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setLabel1(BigInteger value) {
                    this.label1 = value;
                }

                /**
                 * label2 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getLabel2() {
                    return label2;
                }

                /**
                 * label2 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setLabel2(BigInteger value) {
                    this.label2 = value;
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
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
         *       &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class HistoricalVolatilityRatio {

            @XmlValue
            protected BigDecimal value;
            @XmlAttribute(name = "mporDays")
            protected BigInteger mporDays;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValue(BigDecimal value) {
                this.value = value;
            }

            /**
             * mporDays 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMporDays() {
                return mporDays;
            }

            /**
             * mporDays 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMporDays(BigInteger value) {
                this.mporDays = value;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
         *       &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Inflation {

            @XmlValue
            protected BigDecimal value;
            @XmlAttribute(name = "mporDays")
            protected BigInteger mporDays;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValue(BigDecimal value) {
                this.value = value;
            }

            /**
             * mporDays 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMporDays() {
                return mporDays;
            }

            /**
             * mporDays 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMporDays(BigInteger value) {
                this.mporDays = value;
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
         *       &lt;all>
         *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/all>
         *       &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
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
        public static class Vega {

            @XmlElement(name = "Weight", required = true)
            protected BigDecimal weight;
            @XmlAttribute(name = "mporDays")
            protected BigInteger mporDays;

            /**
             * weight 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getWeight() {
                return weight;
            }

            /**
             * weight 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setWeight(BigDecimal value) {
                this.weight = value;
            }

            /**
             * mporDays 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMporDays() {
                return mporDays;
            }

            /**
             * mporDays 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMporDays(BigInteger value) {
                this.mporDays = value;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
         *       &lt;attribute name="mporDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class XCcyBasis {

            @XmlValue
            protected BigDecimal value;
            @XmlAttribute(name = "mporDays")
            protected BigInteger mporDays;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValue(BigDecimal value) {
                this.value = value;
            }

            /**
             * mporDays 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMporDays() {
                return mporDays;
            }

            /**
             * mporDays 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMporDays(BigInteger value) {
                this.mporDays = value;
            }

        }

    }

}
