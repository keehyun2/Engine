//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>capFloorVolatility complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="capFloorVolatility">
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
 *                             &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="RateComputationPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *                             &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="RateComputationPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ONCapSettlementDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ScalingFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="VolatilityType" type="{}volatilityType" minOccurs="0"/>
 *         &lt;element name="OutputVolatilityType" type="{}volatilityType" minOccurs="0"/>
 *         &lt;element name="ModelShift" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="OutputShift" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Extrapolation" type="{}extrapolationType" minOccurs="0"/>
 *         &lt;element name="InterpolationMethod" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Bilinear"/>
 *               &lt;enumeration value="BicubicSpline"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IncludeAtm" type="{}bool" minOccurs="0"/>
 *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="BusinessDayConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="Tenors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OptionalQuotes" type="{}bool" minOccurs="0"/>
 *         &lt;element name="IborIndex" type="{}indexNameType" minOccurs="0"/>
 *         &lt;element name="Index" type="{}indexNameType" minOccurs="0"/>
 *         &lt;element name="RateComputationPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ONCapSettlementDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="DiscountCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AtmTenors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlementDays" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="InterpolateOn" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="TermVolatilities"/>
 *               &lt;enumeration value="OptionletVolatilities"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TimeInterpolation" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Linear"/>
 *               &lt;enumeration value="LinearFlat"/>
 *               &lt;enumeration value="BackwardFlat"/>
 *               &lt;enumeration value="Cubic"/>
 *               &lt;enumeration value="CubicFlat"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="StrikeInterpolation" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Linear"/>
 *               &lt;enumeration value="LinearFlat"/>
 *               &lt;enumeration value="Cubic"/>
 *               &lt;enumeration value="Hagan2002Lognormal"/>
 *               &lt;enumeration value="Hagan2002Normal"/>
 *               &lt;enumeration value="Hagan2002NormalZeroBeta"/>
 *               &lt;enumeration value="Antonov2015FreeBoundaryNormal"/>
 *               &lt;enumeration value="KienitzLawsonSwaynePde"/>
 *               &lt;enumeration value="FlochKennedy"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ParametricSmileConfiguration" type="{}parametricSmileConfig" minOccurs="0"/>
 *         &lt;element name="InputType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="TermVolatilities"/>
 *               &lt;enumeration value="OptionletVolatilities"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="QuoteIncludesIndexName" type="{}bool" minOccurs="0"/>
 *         &lt;element name="BootstrapConfig" type="{}bootstrapConfigType" minOccurs="0"/>
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
@XmlType(name = "capFloorVolatility", propOrder = {

})
public class CapFloorVolatility {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "ProxyConfig")
    protected CapFloorVolatility.ProxyConfig proxyConfig;
    @XmlElement(name = "VolatilityType")
    @XmlSchemaType(name = "string")
    protected VolatilityType volatilityType;
    @XmlElement(name = "OutputVolatilityType")
    @XmlSchemaType(name = "string")
    protected VolatilityType outputVolatilityType;
    @XmlElement(name = "ModelShift")
    protected Float modelShift;
    @XmlElement(name = "OutputShift")
    protected Float outputShift;
    @XmlElement(name = "Extrapolation")
    @XmlSchemaType(name = "string")
    protected ExtrapolationType extrapolation;
    @XmlElement(name = "InterpolationMethod")
    protected String interpolationMethod;
    @XmlElement(name = "IncludeAtm")
    protected String includeAtm;
    @XmlElement(name = "DayCounter")
    protected String dayCounter;
    @XmlElement(name = "Calendar")
    protected String calendar;
    @XmlElement(name = "BusinessDayConvention")
    protected String businessDayConvention;
    @XmlElement(name = "Tenors")
    protected String tenors;
    @XmlElement(name = "Strikes")
    protected String strikes;
    @XmlElement(name = "OptionalQuotes")
    protected String optionalQuotes;
    @XmlElement(name = "IborIndex")
    protected String iborIndex;
    @XmlElement(name = "Index")
    protected String index;
    @XmlElement(name = "RateComputationPeriod")
    protected String rateComputationPeriod;
    @XmlElement(name = "ONCapSettlementDays")
    protected BigInteger onCapSettlementDays;
    @XmlElement(name = "DiscountCurve")
    protected String discountCurve;
    @XmlElement(name = "AtmTenors")
    protected String atmTenors;
    @XmlElement(name = "SettlementDays")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger settlementDays;
    @XmlElement(name = "InterpolateOn")
    protected String interpolateOn;
    @XmlElement(name = "TimeInterpolation")
    protected String timeInterpolation;
    @XmlElement(name = "StrikeInterpolation")
    protected String strikeInterpolation;
    @XmlElement(name = "ParametricSmileConfiguration")
    protected ParametricSmileConfig parametricSmileConfiguration;
    @XmlElement(name = "InputType")
    protected String inputType;
    @XmlElement(name = "QuoteIncludesIndexName")
    protected String quoteIncludesIndexName;
    @XmlElement(name = "BootstrapConfig")
    protected BootstrapConfigType bootstrapConfig;
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
     *     {@link CapFloorVolatility.ProxyConfig }
     *     
     */
    public CapFloorVolatility.ProxyConfig getProxyConfig() {
        return proxyConfig;
    }

    /**
     * proxyConfig 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CapFloorVolatility.ProxyConfig }
     *     
     */
    public void setProxyConfig(CapFloorVolatility.ProxyConfig value) {
        this.proxyConfig = value;
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
     * outputVolatilityType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VolatilityType }
     *     
     */
    public VolatilityType getOutputVolatilityType() {
        return outputVolatilityType;
    }

    /**
     * outputVolatilityType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolatilityType }
     *     
     */
    public void setOutputVolatilityType(VolatilityType value) {
        this.outputVolatilityType = value;
    }

    /**
     * modelShift 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getModelShift() {
        return modelShift;
    }

    /**
     * modelShift 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setModelShift(Float value) {
        this.modelShift = value;
    }

    /**
     * outputShift 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getOutputShift() {
        return outputShift;
    }

    /**
     * outputShift 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setOutputShift(Float value) {
        this.outputShift = value;
    }

    /**
     * extrapolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ExtrapolationType }
     *     
     */
    public ExtrapolationType getExtrapolation() {
        return extrapolation;
    }

    /**
     * extrapolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtrapolationType }
     *     
     */
    public void setExtrapolation(ExtrapolationType value) {
        this.extrapolation = value;
    }

    /**
     * interpolationMethod 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterpolationMethod() {
        return interpolationMethod;
    }

    /**
     * interpolationMethod 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterpolationMethod(String value) {
        this.interpolationMethod = value;
    }

    /**
     * includeAtm 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncludeAtm() {
        return includeAtm;
    }

    /**
     * includeAtm 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncludeAtm(String value) {
        this.includeAtm = value;
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
     * tenors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenors() {
        return tenors;
    }

    /**
     * tenors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenors(String value) {
        this.tenors = value;
    }

    /**
     * strikes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrikes() {
        return strikes;
    }

    /**
     * strikes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrikes(String value) {
        this.strikes = value;
    }

    /**
     * optionalQuotes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionalQuotes() {
        return optionalQuotes;
    }

    /**
     * optionalQuotes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionalQuotes(String value) {
        this.optionalQuotes = value;
    }

    /**
     * iborIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIborIndex() {
        return iborIndex;
    }

    /**
     * iborIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIborIndex(String value) {
        this.iborIndex = value;
    }

    /**
     * index 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndex() {
        return index;
    }

    /**
     * index 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndex(String value) {
        this.index = value;
    }

    /**
     * rateComputationPeriod 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateComputationPeriod() {
        return rateComputationPeriod;
    }

    /**
     * rateComputationPeriod 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateComputationPeriod(String value) {
        this.rateComputationPeriod = value;
    }

    /**
     * onCapSettlementDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getONCapSettlementDays() {
        return onCapSettlementDays;
    }

    /**
     * onCapSettlementDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setONCapSettlementDays(BigInteger value) {
        this.onCapSettlementDays = value;
    }

    /**
     * discountCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountCurve() {
        return discountCurve;
    }

    /**
     * discountCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountCurve(String value) {
        this.discountCurve = value;
    }

    /**
     * atmTenors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAtmTenors() {
        return atmTenors;
    }

    /**
     * atmTenors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAtmTenors(String value) {
        this.atmTenors = value;
    }

    /**
     * settlementDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSettlementDays() {
        return settlementDays;
    }

    /**
     * settlementDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSettlementDays(BigInteger value) {
        this.settlementDays = value;
    }

    /**
     * interpolateOn 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterpolateOn() {
        return interpolateOn;
    }

    /**
     * interpolateOn 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterpolateOn(String value) {
        this.interpolateOn = value;
    }

    /**
     * timeInterpolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeInterpolation() {
        return timeInterpolation;
    }

    /**
     * timeInterpolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeInterpolation(String value) {
        this.timeInterpolation = value;
    }

    /**
     * strikeInterpolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrikeInterpolation() {
        return strikeInterpolation;
    }

    /**
     * strikeInterpolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrikeInterpolation(String value) {
        this.strikeInterpolation = value;
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
     * inputType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputType() {
        return inputType;
    }

    /**
     * inputType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputType(String value) {
        this.inputType = value;
    }

    /**
     * quoteIncludesIndexName 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuoteIncludesIndexName() {
        return quoteIncludesIndexName;
    }

    /**
     * quoteIncludesIndexName 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuoteIncludesIndexName(String value) {
        this.quoteIncludesIndexName = value;
    }

    /**
     * bootstrapConfig 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BootstrapConfigType }
     *     
     */
    public BootstrapConfigType getBootstrapConfig() {
        return bootstrapConfig;
    }

    /**
     * bootstrapConfig 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BootstrapConfigType }
     *     
     */
    public void setBootstrapConfig(BootstrapConfigType value) {
        this.bootstrapConfig = value;
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
     *                   &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="RateComputationPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
     *                   &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="RateComputationPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ONCapSettlementDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ScalingFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        protected CapFloorVolatility.ProxyConfig.Source source;
        @XmlElement(name = "Target", required = true)
        protected CapFloorVolatility.ProxyConfig.Target target;
        @XmlElement(name = "ScalingFactor")
        protected Double scalingFactor;

        /**
         * source 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link CapFloorVolatility.ProxyConfig.Source }
         *     
         */
        public CapFloorVolatility.ProxyConfig.Source getSource() {
            return source;
        }

        /**
         * source 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link CapFloorVolatility.ProxyConfig.Source }
         *     
         */
        public void setSource(CapFloorVolatility.ProxyConfig.Source value) {
            this.source = value;
        }

        /**
         * target 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link CapFloorVolatility.ProxyConfig.Target }
         *     
         */
        public CapFloorVolatility.ProxyConfig.Target getTarget() {
            return target;
        }

        /**
         * target 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link CapFloorVolatility.ProxyConfig.Target }
         *     
         */
        public void setTarget(CapFloorVolatility.ProxyConfig.Target value) {
            this.target = value;
        }

        /**
         * scalingFactor 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getScalingFactor() {
            return scalingFactor;
        }

        /**
         * scalingFactor 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setScalingFactor(Double value) {
            this.scalingFactor = value;
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
         *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="RateComputationPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            @XmlElement(name = "Index", required = true)
            protected String index;
            @XmlElement(name = "RateComputationPeriod")
            protected String rateComputationPeriod;

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
             * index 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIndex() {
                return index;
            }

            /**
             * index 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIndex(String value) {
                this.index = value;
            }

            /**
             * rateComputationPeriod 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRateComputationPeriod() {
                return rateComputationPeriod;
            }

            /**
             * rateComputationPeriod 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRateComputationPeriod(String value) {
                this.rateComputationPeriod = value;
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
         *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="RateComputationPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ONCapSettlementDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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

            @XmlElement(name = "Index", required = true)
            protected String index;
            @XmlElement(name = "RateComputationPeriod")
            protected String rateComputationPeriod;
            @XmlElement(name = "ONCapSettlementDays")
            protected BigInteger onCapSettlementDays;

            /**
             * index 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIndex() {
                return index;
            }

            /**
             * index 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIndex(String value) {
                this.index = value;
            }

            /**
             * rateComputationPeriod 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRateComputationPeriod() {
                return rateComputationPeriod;
            }

            /**
             * rateComputationPeriod 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRateComputationPeriod(String value) {
                this.rateComputationPeriod = value;
            }

            /**
             * onCapSettlementDays 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getONCapSettlementDays() {
                return onCapSettlementDays;
            }

            /**
             * onCapSettlementDays 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setONCapSettlementDays(BigInteger value) {
                this.onCapSettlementDays = value;
            }

        }

    }

}
