//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>cbConversionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="cbConversionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ScheduleData" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="Styles" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Style" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ConversionRatios" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ConversionRatio" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                           &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FixedAmountConversion" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Amounts">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Amount" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                                     &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ContingentConversion" type="{}cbContingentConversionData" minOccurs="0"/>
 *         &lt;element name="MandatoryConversion" type="{}cbMandatoryConversionData" minOccurs="0"/>
 *         &lt;element name="ConversionResets" type="{}cbConversionResetData" minOccurs="0"/>
 *         &lt;element name="Underlying" type="{}underlying" minOccurs="0"/>
 *         &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FXIndexCalendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="FXIndexFixingDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Exchangeable" type="{}cbExchangeableData" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cbConversionData", propOrder = {

})
public class CbConversionData {

    @XmlElement(name = "ScheduleData")
    protected ScheduleData scheduleData;
    @XmlElement(name = "Styles")
    protected CbConversionData.Styles styles;
    @XmlElement(name = "ConversionRatios")
    protected CbConversionData.ConversionRatios conversionRatios;
    @XmlElement(name = "FixedAmountConversion")
    protected CbConversionData.FixedAmountConversion fixedAmountConversion;
    @XmlElement(name = "ContingentConversion")
    protected CbContingentConversionData contingentConversion;
    @XmlElement(name = "MandatoryConversion")
    protected CbMandatoryConversionData mandatoryConversion;
    @XmlElement(name = "ConversionResets")
    protected CbConversionResetData conversionResets;
    @XmlElement(name = "Underlying")
    protected Underlying underlying;
    @XmlElement(name = "FXIndex")
    protected String fxIndex;
    @XmlElement(name = "FXIndexCalendar")
    protected String fxIndexCalendar;
    @XmlElement(name = "FXIndexFixingDays")
    protected BigInteger fxIndexFixingDays;
    @XmlElement(name = "Exchangeable")
    protected CbExchangeableData exchangeable;

    /**
     * scheduleData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getScheduleData() {
        return scheduleData;
    }

    /**
     * scheduleData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setScheduleData(ScheduleData value) {
        this.scheduleData = value;
    }

    /**
     * styles 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbConversionData.Styles }
     *     
     */
    public CbConversionData.Styles getStyles() {
        return styles;
    }

    /**
     * styles 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbConversionData.Styles }
     *     
     */
    public void setStyles(CbConversionData.Styles value) {
        this.styles = value;
    }

    /**
     * conversionRatios 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbConversionData.ConversionRatios }
     *     
     */
    public CbConversionData.ConversionRatios getConversionRatios() {
        return conversionRatios;
    }

    /**
     * conversionRatios 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbConversionData.ConversionRatios }
     *     
     */
    public void setConversionRatios(CbConversionData.ConversionRatios value) {
        this.conversionRatios = value;
    }

    /**
     * fixedAmountConversion 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbConversionData.FixedAmountConversion }
     *     
     */
    public CbConversionData.FixedAmountConversion getFixedAmountConversion() {
        return fixedAmountConversion;
    }

    /**
     * fixedAmountConversion 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbConversionData.FixedAmountConversion }
     *     
     */
    public void setFixedAmountConversion(CbConversionData.FixedAmountConversion value) {
        this.fixedAmountConversion = value;
    }

    /**
     * contingentConversion 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbContingentConversionData }
     *     
     */
    public CbContingentConversionData getContingentConversion() {
        return contingentConversion;
    }

    /**
     * contingentConversion 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbContingentConversionData }
     *     
     */
    public void setContingentConversion(CbContingentConversionData value) {
        this.contingentConversion = value;
    }

    /**
     * mandatoryConversion 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbMandatoryConversionData }
     *     
     */
    public CbMandatoryConversionData getMandatoryConversion() {
        return mandatoryConversion;
    }

    /**
     * mandatoryConversion 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbMandatoryConversionData }
     *     
     */
    public void setMandatoryConversion(CbMandatoryConversionData value) {
        this.mandatoryConversion = value;
    }

    /**
     * conversionResets 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbConversionResetData }
     *     
     */
    public CbConversionResetData getConversionResets() {
        return conversionResets;
    }

    /**
     * conversionResets 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbConversionResetData }
     *     
     */
    public void setConversionResets(CbConversionResetData value) {
        this.conversionResets = value;
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
     * fxIndexCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFXIndexCalendar() {
        return fxIndexCalendar;
    }

    /**
     * fxIndexCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXIndexCalendar(String value) {
        this.fxIndexCalendar = value;
    }

    /**
     * fxIndexFixingDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFXIndexFixingDays() {
        return fxIndexFixingDays;
    }

    /**
     * fxIndexFixingDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFXIndexFixingDays(BigInteger value) {
        this.fxIndexFixingDays = value;
    }

    /**
     * exchangeable 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbExchangeableData }
     *     
     */
    public CbExchangeableData getExchangeable() {
        return exchangeable;
    }

    /**
     * exchangeable 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbExchangeableData }
     *     
     */
    public void setExchangeable(CbExchangeableData value) {
        this.exchangeable = value;
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
     *         &lt;element name="ConversionRatio" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                 &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "conversionRatio"
    })
    public static class ConversionRatios {

        @XmlElement(name = "ConversionRatio")
        protected List<CbConversionData.ConversionRatios.ConversionRatio> conversionRatio;

        /**
         * Gets the value of the conversionRatio property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the conversionRatio property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConversionRatio().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CbConversionData.ConversionRatios.ConversionRatio }
         * 
         * 
         */
        public List<CbConversionData.ConversionRatios.ConversionRatio> getConversionRatio() {
            if (conversionRatio == null) {
                conversionRatio = new ArrayList<CbConversionData.ConversionRatios.ConversionRatio>();
            }
            return this.conversionRatio;
        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *       &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class ConversionRatio {

            @XmlValue
            protected float value;
            @XmlAttribute(name = "startDate")
            protected String startDate;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             */
            public float getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             */
            public void setValue(float value) {
                this.value = value;
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
     *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Amounts">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Amount" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                           &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
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
    public static class FixedAmountConversion {

        @XmlElement(name = "Currency", required = true)
        protected String currency;
        @XmlElement(name = "Amounts", required = true)
        protected CbConversionData.FixedAmountConversion.Amounts amounts;

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
         * amounts 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link CbConversionData.FixedAmountConversion.Amounts }
         *     
         */
        public CbConversionData.FixedAmountConversion.Amounts getAmounts() {
            return amounts;
        }

        /**
         * amounts 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link CbConversionData.FixedAmountConversion.Amounts }
         *     
         */
        public void setAmounts(CbConversionData.FixedAmountConversion.Amounts value) {
            this.amounts = value;
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
         *         &lt;element name="Amount" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *                 &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            "amount"
        })
        public static class Amounts {

            @XmlElement(name = "Amount", required = true)
            protected List<CbConversionData.FixedAmountConversion.Amounts.Amount> amount;

            /**
             * Gets the value of the amount property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the amount property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAmount().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link CbConversionData.FixedAmountConversion.Amounts.Amount }
             * 
             * 
             */
            public List<CbConversionData.FixedAmountConversion.Amounts.Amount> getAmount() {
                if (amount == null) {
                    amount = new ArrayList<CbConversionData.FixedAmountConversion.Amounts.Amount>();
                }
                return this.amount;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
             *       &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            public static class Amount {

                @XmlValue
                protected float value;
                @XmlAttribute(name = "startDate")
                protected String startDate;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 */
                public float getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 */
                public void setValue(float value) {
                    this.value = value;
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
     *         &lt;element name="Style" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "style"
    })
    public static class Styles {

        @XmlElement(name = "Style")
        protected List<CbConversionData.Styles.Style> style;

        /**
         * Gets the value of the style property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the style property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStyle().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CbConversionData.Styles.Style }
         * 
         * 
         */
        public List<CbConversionData.Styles.Style> getStyle() {
            if (style == null) {
                style = new ArrayList<CbConversionData.Styles.Style>();
            }
            return this.style;
        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class Style {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "startDate")
            protected String startDate;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
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

        }

    }

}
