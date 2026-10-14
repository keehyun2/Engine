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
 * <p>swaptionVolatility complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="swaptionVolatility">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProxyConfig" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Source">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ShortSwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="SwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Target">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="ShortSwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="SwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *         &lt;element name="Dimension" type="{}dimensionType" minOccurs="0"/>
 *         &lt;element name="VolatilityType" type="{}volatilityType" minOccurs="0"/>
 *         &lt;element name="Interpolation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ParametricSmileConfiguration" type="{}parametricSmileConfig" minOccurs="0"/>
 *         &lt;element name="Extrapolation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OutputVolatilityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ModelShift" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OutputShift" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="BusinessDayConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="OptionTenors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SwapTenors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShortSwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SmileOptionTenors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SmileSwapTenors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SmileSpreads" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QuoteTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "swaptionVolatility", propOrder = {

})
public class SwaptionVolatility {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "ProxyConfig")
    protected SwaptionVolatility.ProxyConfig proxyConfig;
    @XmlElement(name = "Dimension")
    @XmlSchemaType(name = "string")
    protected DimensionType dimension;
    @XmlElement(name = "VolatilityType")
    @XmlSchemaType(name = "string")
    protected VolatilityType volatilityType;
    @XmlElement(name = "Interpolation")
    protected String interpolation;
    @XmlElement(name = "ParametricSmileConfiguration")
    protected ParametricSmileConfig parametricSmileConfiguration;
    @XmlElement(name = "Extrapolation")
    protected String extrapolation;
    @XmlElement(name = "OutputVolatilityType")
    protected String outputVolatilityType;
    @XmlElement(name = "ModelShift")
    protected String modelShift;
    @XmlElement(name = "OutputShift")
    protected String outputShift;
    @XmlElement(name = "DayCounter")
    protected String dayCounter;
    @XmlElement(name = "Calendar")
    protected String calendar;
    @XmlElement(name = "BusinessDayConvention")
    protected String businessDayConvention;
    @XmlElement(name = "OptionTenors")
    protected String optionTenors;
    @XmlElement(name = "SwapTenors")
    protected String swapTenors;
    @XmlElement(name = "ShortSwapIndexBase")
    protected String shortSwapIndexBase;
    @XmlElement(name = "SwapIndexBase")
    protected String swapIndexBase;
    @XmlElement(name = "SmileOptionTenors")
    protected String smileOptionTenors;
    @XmlElement(name = "SmileSwapTenors")
    protected String smileSwapTenors;
    @XmlElement(name = "SmileSpreads")
    protected String smileSpreads;
    @XmlElement(name = "QuoteTag")
    protected String quoteTag;
    @XmlElement(name = "Report")
    protected ReportConfiguration report;

    /**
     * curveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurveId() {
        return curveId;
    }

    /**
     * curveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurveId(String value) {
        this.curveId = value;
    }

    /**
     * curveDescription 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurveDescription() {
        return curveDescription;
    }

    /**
     * curveDescription 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurveDescription(String value) {
        this.curveDescription = value;
    }

    /**
     * proxyConfig 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SwaptionVolatility.ProxyConfig }
     *     
     */
    public SwaptionVolatility.ProxyConfig getProxyConfig() {
        return proxyConfig;
    }

    /**
     * proxyConfig 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SwaptionVolatility.ProxyConfig }
     *     
     */
    public void setProxyConfig(SwaptionVolatility.ProxyConfig value) {
        this.proxyConfig = value;
    }

    /**
     * dimension 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DimensionType }
     *     
     */
    public DimensionType getDimension() {
        return dimension;
    }

    /**
     * dimension 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DimensionType }
     *     
     */
    public void setDimension(DimensionType value) {
        this.dimension = value;
    }

    /**
     * volatilityType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VolatilityType }
     *     
     */
    public VolatilityType getVolatilityType() {
        return volatilityType;
    }

    /**
     * volatilityType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolatilityType }
     *     
     */
    public void setVolatilityType(VolatilityType value) {
        this.volatilityType = value;
    }

    /**
     * interpolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterpolation() {
        return interpolation;
    }

    /**
     * interpolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterpolation(String value) {
        this.interpolation = value;
    }

    /**
     * parametricSmileConfiguration 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ParametricSmileConfig }
     *     
     */
    public ParametricSmileConfig getParametricSmileConfiguration() {
        return parametricSmileConfiguration;
    }

    /**
     * parametricSmileConfiguration 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametricSmileConfig }
     *     
     */
    public void setParametricSmileConfiguration(ParametricSmileConfig value) {
        this.parametricSmileConfiguration = value;
    }

    /**
     * extrapolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtrapolation() {
        return extrapolation;
    }

    /**
     * extrapolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtrapolation(String value) {
        this.extrapolation = value;
    }

    /**
     * outputVolatilityType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputVolatilityType() {
        return outputVolatilityType;
    }

    /**
     * outputVolatilityType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputVolatilityType(String value) {
        this.outputVolatilityType = value;
    }

    /**
     * modelShift 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelShift() {
        return modelShift;
    }

    /**
     * modelShift 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelShift(String value) {
        this.modelShift = value;
    }

    /**
     * outputShift 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputShift() {
        return outputShift;
    }

    /**
     * outputShift 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputShift(String value) {
        this.outputShift = value;
    }

    /**
     * dayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayCounter() {
        return dayCounter;
    }

    /**
     * dayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayCounter(String value) {
        this.dayCounter = value;
    }

    /**
     * calendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalendar() {
        return calendar;
    }

    /**
     * calendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalendar(String value) {
        this.calendar = value;
    }

    /**
     * businessDayConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessDayConvention() {
        return businessDayConvention;
    }

    /**
     * businessDayConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessDayConvention(String value) {
        this.businessDayConvention = value;
    }

    /**
     * optionTenors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionTenors() {
        return optionTenors;
    }

    /**
     * optionTenors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionTenors(String value) {
        this.optionTenors = value;
    }

    /**
     * swapTenors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwapTenors() {
        return swapTenors;
    }

    /**
     * swapTenors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwapTenors(String value) {
        this.swapTenors = value;
    }

    /**
     * shortSwapIndexBase 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortSwapIndexBase() {
        return shortSwapIndexBase;
    }

    /**
     * shortSwapIndexBase 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortSwapIndexBase(String value) {
        this.shortSwapIndexBase = value;
    }

    /**
     * swapIndexBase 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwapIndexBase() {
        return swapIndexBase;
    }

    /**
     * swapIndexBase 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwapIndexBase(String value) {
        this.swapIndexBase = value;
    }

    /**
     * smileOptionTenors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmileOptionTenors() {
        return smileOptionTenors;
    }

    /**
     * smileOptionTenors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmileOptionTenors(String value) {
        this.smileOptionTenors = value;
    }

    /**
     * smileSwapTenors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmileSwapTenors() {
        return smileSwapTenors;
    }

    /**
     * smileSwapTenors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmileSwapTenors(String value) {
        this.smileSwapTenors = value;
    }

    /**
     * smileSpreads 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmileSpreads() {
        return smileSpreads;
    }

    /**
     * smileSpreads 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmileSpreads(String value) {
        this.smileSpreads = value;
    }

    /**
     * quoteTag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuoteTag() {
        return quoteTag;
    }

    /**
     * quoteTag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuoteTag(String value) {
        this.quoteTag = value;
    }

    /**
     * report 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ReportConfiguration }
     *     
     */
    public ReportConfiguration getReport() {
        return report;
    }

    /**
     * report 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportConfiguration }
     *     
     */
    public void setReport(ReportConfiguration value) {
        this.report = value;
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
     *         &lt;element name="Source">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ShortSwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="SwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Target">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="ShortSwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="SwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    public static class ProxyConfig {

        @XmlElement(name = "Source", required = true)
        protected SwaptionVolatility.ProxyConfig.Source source;
        @XmlElement(name = "Target", required = true)
        protected SwaptionVolatility.ProxyConfig.Target target;

        /**
         * source 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link SwaptionVolatility.ProxyConfig.Source }
         *     
         */
        public SwaptionVolatility.ProxyConfig.Source getSource() {
            return source;
        }

        /**
         * source 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link SwaptionVolatility.ProxyConfig.Source }
         *     
         */
        public void setSource(SwaptionVolatility.ProxyConfig.Source value) {
            this.source = value;
        }

        /**
         * target 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link SwaptionVolatility.ProxyConfig.Target }
         *     
         */
        public SwaptionVolatility.ProxyConfig.Target getTarget() {
            return target;
        }

        /**
         * target 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link SwaptionVolatility.ProxyConfig.Target }
         *     
         */
        public void setTarget(SwaptionVolatility.ProxyConfig.Target value) {
            this.target = value;
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
         *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ShortSwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="SwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        public static class Source {

            @XmlElement(name = "CurveId", required = true)
            protected String curveId;
            @XmlElement(name = "ShortSwapIndexBase", required = true)
            protected String shortSwapIndexBase;
            @XmlElement(name = "SwapIndexBase", required = true)
            protected String swapIndexBase;

            /**
             * curveId 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCurveId() {
                return curveId;
            }

            /**
             * curveId 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCurveId(String value) {
                this.curveId = value;
            }

            /**
             * shortSwapIndexBase 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getShortSwapIndexBase() {
                return shortSwapIndexBase;
            }

            /**
             * shortSwapIndexBase 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setShortSwapIndexBase(String value) {
                this.shortSwapIndexBase = value;
            }

            /**
             * swapIndexBase 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSwapIndexBase() {
                return swapIndexBase;
            }

            /**
             * swapIndexBase 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSwapIndexBase(String value) {
                this.swapIndexBase = value;
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
         *         &lt;element name="ShortSwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="SwapIndexBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        public static class Target {

            @XmlElement(name = "ShortSwapIndexBase", required = true)
            protected String shortSwapIndexBase;
            @XmlElement(name = "SwapIndexBase", required = true)
            protected String swapIndexBase;

            /**
             * shortSwapIndexBase 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getShortSwapIndexBase() {
                return shortSwapIndexBase;
            }

            /**
             * shortSwapIndexBase 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setShortSwapIndexBase(String value) {
                this.shortSwapIndexBase = value;
            }

            /**
             * swapIndexBase 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSwapIndexBase() {
                return swapIndexBase;
            }

            /**
             * swapIndexBase 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSwapIndexBase(String value) {
                this.swapIndexBase = value;
            }

        }

    }

}
