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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>defaultCurve complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="defaultCurve">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="Configurations" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Configuration" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Type" type="{}defaultCurveType"/>
 *                             &lt;element name="DiscountCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DayCounter" type="{}dayCounter"/>
 *                             &lt;element name="RecoveryRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="StartDate" type="{}date" minOccurs="0"/>
 *                             &lt;element name="Quotes" type="{}quoteType" minOccurs="0"/>
 *                             &lt;element name="BenchmarkCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ReinterpretedYieldCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SourceCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Pillars" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SpotLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element name="SourceCurves" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="SourceCurve" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="SwitchDates" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="SwitchDate" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="InitialState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="States" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *                             &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Extrapolation" type="{}bool" minOccurs="0"/>
 *                             &lt;element name="RunningSpread" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                             &lt;element name="IndexTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ImplyDefaultFromMarket" type="{}bool" minOccurs="0"/>
 *                             &lt;element name="BootstrapConfig" type="{}bootstrapConfigType" minOccurs="0"/>
 *                             &lt;element name="AllowNegativeRates" type="{}bool" minOccurs="0"/>
 *                           &lt;/all>
 *                           &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Type" type="{}defaultCurveType" minOccurs="0"/>
 *         &lt;element name="DiscountCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="RecoveryRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="Quotes" type="{}quoteType" minOccurs="0"/>
 *         &lt;element name="BenchmarkCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pillars" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpotLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="SourceCurves" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SourceCurve" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SwitchDates" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SwitchDate" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Extrapolation" type="{}bool" minOccurs="0"/>
 *         &lt;element name="RunningSpread" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IndexTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ImplyDefaultFromMarket" type="{}bool" minOccurs="0"/>
 *         &lt;element name="BootstrapConfig" type="{}bootstrapConfigType" minOccurs="0"/>
 *         &lt;element name="AllowNegativeRates" type="{}bool" minOccurs="0"/>
 *         &lt;element name="InitialState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="States" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "defaultCurve", propOrder = {

})
public class DefaultCurve {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "Configurations")
    protected DefaultCurve.Configurations configurations;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected DefaultCurveType type;
    @XmlElement(name = "DiscountCurve")
    protected String discountCurve;
    @XmlElement(name = "DayCounter")
    protected String dayCounter;
    @XmlElement(name = "RecoveryRate")
    protected String recoveryRate;
    @XmlElement(name = "StartDate")
    protected String startDate;
    @XmlElement(name = "Quotes")
    protected QuoteType quotes;
    @XmlElement(name = "BenchmarkCurve")
    protected String benchmarkCurve;
    @XmlElement(name = "SourceCurve")
    protected String sourceCurve;
    @XmlElement(name = "Pillars")
    protected String pillars;
    @XmlElement(name = "SpotLag")
    protected BigInteger spotLag;
    @XmlElement(name = "SourceCurves")
    protected DefaultCurve.SourceCurves sourceCurves;
    @XmlElement(name = "SwitchDates")
    protected DefaultCurve.SwitchDates switchDates;
    @XmlElement(name = "Calendar")
    protected String calendar;
    @XmlElement(name = "Conventions")
    protected String conventions;
    @XmlElement(name = "Extrapolation")
    protected String extrapolation;
    @XmlElement(name = "RunningSpread")
    protected BigDecimal runningSpread;
    @XmlElement(name = "IndexTerm")
    protected String indexTerm;
    @XmlElement(name = "ImplyDefaultFromMarket")
    protected String implyDefaultFromMarket;
    @XmlElement(name = "BootstrapConfig")
    protected BootstrapConfigType bootstrapConfig;
    @XmlElement(name = "AllowNegativeRates")
    protected String allowNegativeRates;
    @XmlElement(name = "InitialState")
    protected String initialState;
    @XmlElement(name = "States")
    protected String states;

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
     * configurations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DefaultCurve.Configurations }
     *     
     */
    public DefaultCurve.Configurations getConfigurations() {
        return configurations;
    }

    /**
     * configurations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultCurve.Configurations }
     *     
     */
    public void setConfigurations(DefaultCurve.Configurations value) {
        this.configurations = value;
    }

    /**
     * type 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DefaultCurveType }
     *     
     */
    public DefaultCurveType getType() {
        return type;
    }

    /**
     * type 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultCurveType }
     *     
     */
    public void setType(DefaultCurveType value) {
        this.type = value;
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
     * recoveryRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecoveryRate() {
        return recoveryRate;
    }

    /**
     * recoveryRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecoveryRate(String value) {
        this.recoveryRate = value;
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

    /**
     * quotes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link QuoteType }
     *     
     */
    public QuoteType getQuotes() {
        return quotes;
    }

    /**
     * quotes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link QuoteType }
     *     
     */
    public void setQuotes(QuoteType value) {
        this.quotes = value;
    }

    /**
     * benchmarkCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenchmarkCurve() {
        return benchmarkCurve;
    }

    /**
     * benchmarkCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenchmarkCurve(String value) {
        this.benchmarkCurve = value;
    }

    /**
     * sourceCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceCurve() {
        return sourceCurve;
    }

    /**
     * sourceCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceCurve(String value) {
        this.sourceCurve = value;
    }

    /**
     * pillars 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPillars() {
        return pillars;
    }

    /**
     * pillars 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPillars(String value) {
        this.pillars = value;
    }

    /**
     * spotLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpotLag() {
        return spotLag;
    }

    /**
     * spotLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpotLag(BigInteger value) {
        this.spotLag = value;
    }

    /**
     * sourceCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DefaultCurve.SourceCurves }
     *     
     */
    public DefaultCurve.SourceCurves getSourceCurves() {
        return sourceCurves;
    }

    /**
     * sourceCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultCurve.SourceCurves }
     *     
     */
    public void setSourceCurves(DefaultCurve.SourceCurves value) {
        this.sourceCurves = value;
    }

    /**
     * switchDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DefaultCurve.SwitchDates }
     *     
     */
    public DefaultCurve.SwitchDates getSwitchDates() {
        return switchDates;
    }

    /**
     * switchDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultCurve.SwitchDates }
     *     
     */
    public void setSwitchDates(DefaultCurve.SwitchDates value) {
        this.switchDates = value;
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
     * conventions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConventions() {
        return conventions;
    }

    /**
     * conventions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConventions(String value) {
        this.conventions = value;
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
     * runningSpread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRunningSpread() {
        return runningSpread;
    }

    /**
     * runningSpread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRunningSpread(BigDecimal value) {
        this.runningSpread = value;
    }

    /**
     * indexTerm 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexTerm() {
        return indexTerm;
    }

    /**
     * indexTerm 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexTerm(String value) {
        this.indexTerm = value;
    }

    /**
     * implyDefaultFromMarket 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImplyDefaultFromMarket() {
        return implyDefaultFromMarket;
    }

    /**
     * implyDefaultFromMarket 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImplyDefaultFromMarket(String value) {
        this.implyDefaultFromMarket = value;
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
     * allowNegativeRates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowNegativeRates() {
        return allowNegativeRates;
    }

    /**
     * allowNegativeRates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowNegativeRates(String value) {
        this.allowNegativeRates = value;
    }

    /**
     * initialState 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialState() {
        return initialState;
    }

    /**
     * initialState 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialState(String value) {
        this.initialState = value;
    }

    /**
     * states 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStates() {
        return states;
    }

    /**
     * states 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStates(String value) {
        this.states = value;
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
     *         &lt;element name="Configuration" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Type" type="{}defaultCurveType"/>
     *                   &lt;element name="DiscountCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DayCounter" type="{}dayCounter"/>
     *                   &lt;element name="RecoveryRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="StartDate" type="{}date" minOccurs="0"/>
     *                   &lt;element name="Quotes" type="{}quoteType" minOccurs="0"/>
     *                   &lt;element name="BenchmarkCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ReinterpretedYieldCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SourceCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Pillars" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SpotLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element name="SourceCurves" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="SourceCurve" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="SwitchDates" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="SwitchDate" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="InitialState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="States" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
     *                   &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Extrapolation" type="{}bool" minOccurs="0"/>
     *                   &lt;element name="RunningSpread" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *                   &lt;element name="IndexTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ImplyDefaultFromMarket" type="{}bool" minOccurs="0"/>
     *                   &lt;element name="BootstrapConfig" type="{}bootstrapConfigType" minOccurs="0"/>
     *                   &lt;element name="AllowNegativeRates" type="{}bool" minOccurs="0"/>
     *                 &lt;/all>
     *                 &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
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
        "configuration"
    })
    public static class Configurations {

        @XmlElement(name = "Configuration")
        protected List<DefaultCurve.Configurations.Configuration> configuration;

        /**
         * Gets the value of the configuration property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the configuration property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConfiguration().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DefaultCurve.Configurations.Configuration }
         * 
         * 
         */
        public List<DefaultCurve.Configurations.Configuration> getConfiguration() {
            if (configuration == null) {
                configuration = new ArrayList<DefaultCurve.Configurations.Configuration>();
            }
            return this.configuration;
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
         *         &lt;element name="Type" type="{}defaultCurveType"/>
         *         &lt;element name="DiscountCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DayCounter" type="{}dayCounter"/>
         *         &lt;element name="RecoveryRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="StartDate" type="{}date" minOccurs="0"/>
         *         &lt;element name="Quotes" type="{}quoteType" minOccurs="0"/>
         *         &lt;element name="BenchmarkCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ReinterpretedYieldCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SourceCurve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Pillars" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SpotLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element name="SourceCurves" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="SourceCurve" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="SwitchDates" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="SwitchDate" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="InitialState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="States" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
         *         &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Extrapolation" type="{}bool" minOccurs="0"/>
         *         &lt;element name="RunningSpread" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
         *         &lt;element name="IndexTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ImplyDefaultFromMarket" type="{}bool" minOccurs="0"/>
         *         &lt;element name="BootstrapConfig" type="{}bootstrapConfigType" minOccurs="0"/>
         *         &lt;element name="AllowNegativeRates" type="{}bool" minOccurs="0"/>
         *       &lt;/all>
         *       &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
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
        public static class Configuration {

            @XmlElement(name = "Type", required = true)
            @XmlSchemaType(name = "string")
            protected DefaultCurveType type;
            @XmlElement(name = "DiscountCurve")
            protected String discountCurve;
            @XmlElement(name = "DayCounter", required = true)
            protected String dayCounter;
            @XmlElement(name = "RecoveryRate")
            protected String recoveryRate;
            @XmlElement(name = "StartDate")
            protected String startDate;
            @XmlElement(name = "Quotes")
            protected QuoteType quotes;
            @XmlElement(name = "BenchmarkCurve")
            protected String benchmarkCurve;
            @XmlElement(name = "ReinterpretedYieldCurve")
            protected String reinterpretedYieldCurve;
            @XmlElement(name = "SourceCurve")
            protected String sourceCurve;
            @XmlElement(name = "Pillars")
            protected String pillars;
            @XmlElement(name = "SpotLag")
            protected BigInteger spotLag;
            @XmlElement(name = "SourceCurves")
            protected DefaultCurve.Configurations.Configuration.SourceCurves sourceCurves;
            @XmlElement(name = "SwitchDates")
            protected DefaultCurve.Configurations.Configuration.SwitchDates switchDates;
            @XmlElement(name = "InitialState")
            protected String initialState;
            @XmlElement(name = "States")
            protected String states;
            @XmlElement(name = "Calendar")
            protected String calendar;
            @XmlElement(name = "Conventions")
            protected String conventions;
            @XmlElement(name = "Extrapolation")
            protected String extrapolation;
            @XmlElement(name = "RunningSpread")
            protected BigDecimal runningSpread;
            @XmlElement(name = "IndexTerm")
            protected String indexTerm;
            @XmlElement(name = "ImplyDefaultFromMarket")
            protected String implyDefaultFromMarket;
            @XmlElement(name = "BootstrapConfig")
            protected BootstrapConfigType bootstrapConfig;
            @XmlElement(name = "AllowNegativeRates")
            protected String allowNegativeRates;
            @XmlAttribute(name = "priority")
            @XmlSchemaType(name = "nonNegativeInteger")
            protected BigInteger priority;

            /**
             * type 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link DefaultCurveType }
             *     
             */
            public DefaultCurveType getType() {
                return type;
            }

            /**
             * type 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link DefaultCurveType }
             *     
             */
            public void setType(DefaultCurveType value) {
                this.type = value;
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
             * recoveryRate 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRecoveryRate() {
                return recoveryRate;
            }

            /**
             * recoveryRate 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRecoveryRate(String value) {
                this.recoveryRate = value;
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

            /**
             * quotes 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link QuoteType }
             *     
             */
            public QuoteType getQuotes() {
                return quotes;
            }

            /**
             * quotes 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link QuoteType }
             *     
             */
            public void setQuotes(QuoteType value) {
                this.quotes = value;
            }

            /**
             * benchmarkCurve 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBenchmarkCurve() {
                return benchmarkCurve;
            }

            /**
             * benchmarkCurve 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBenchmarkCurve(String value) {
                this.benchmarkCurve = value;
            }

            /**
             * reinterpretedYieldCurve 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReinterpretedYieldCurve() {
                return reinterpretedYieldCurve;
            }

            /**
             * reinterpretedYieldCurve 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReinterpretedYieldCurve(String value) {
                this.reinterpretedYieldCurve = value;
            }

            /**
             * sourceCurve 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSourceCurve() {
                return sourceCurve;
            }

            /**
             * sourceCurve 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSourceCurve(String value) {
                this.sourceCurve = value;
            }

            /**
             * pillars 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPillars() {
                return pillars;
            }

            /**
             * pillars 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPillars(String value) {
                this.pillars = value;
            }

            /**
             * spotLag 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getSpotLag() {
                return spotLag;
            }

            /**
             * spotLag 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setSpotLag(BigInteger value) {
                this.spotLag = value;
            }

            /**
             * sourceCurves 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link DefaultCurve.Configurations.Configuration.SourceCurves }
             *     
             */
            public DefaultCurve.Configurations.Configuration.SourceCurves getSourceCurves() {
                return sourceCurves;
            }

            /**
             * sourceCurves 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link DefaultCurve.Configurations.Configuration.SourceCurves }
             *     
             */
            public void setSourceCurves(DefaultCurve.Configurations.Configuration.SourceCurves value) {
                this.sourceCurves = value;
            }

            /**
             * switchDates 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link DefaultCurve.Configurations.Configuration.SwitchDates }
             *     
             */
            public DefaultCurve.Configurations.Configuration.SwitchDates getSwitchDates() {
                return switchDates;
            }

            /**
             * switchDates 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link DefaultCurve.Configurations.Configuration.SwitchDates }
             *     
             */
            public void setSwitchDates(DefaultCurve.Configurations.Configuration.SwitchDates value) {
                this.switchDates = value;
            }

            /**
             * initialState 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInitialState() {
                return initialState;
            }

            /**
             * initialState 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInitialState(String value) {
                this.initialState = value;
            }

            /**
             * states 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStates() {
                return states;
            }

            /**
             * states 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStates(String value) {
                this.states = value;
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
             * conventions 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getConventions() {
                return conventions;
            }

            /**
             * conventions 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setConventions(String value) {
                this.conventions = value;
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
             * runningSpread 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getRunningSpread() {
                return runningSpread;
            }

            /**
             * runningSpread 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setRunningSpread(BigDecimal value) {
                this.runningSpread = value;
            }

            /**
             * indexTerm 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIndexTerm() {
                return indexTerm;
            }

            /**
             * indexTerm 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIndexTerm(String value) {
                this.indexTerm = value;
            }

            /**
             * implyDefaultFromMarket 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getImplyDefaultFromMarket() {
                return implyDefaultFromMarket;
            }

            /**
             * implyDefaultFromMarket 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setImplyDefaultFromMarket(String value) {
                this.implyDefaultFromMarket = value;
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
             * allowNegativeRates 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAllowNegativeRates() {
                return allowNegativeRates;
            }

            /**
             * allowNegativeRates 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAllowNegativeRates(String value) {
                this.allowNegativeRates = value;
            }

            /**
             * priority 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getPriority() {
                return priority;
            }

            /**
             * priority 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setPriority(BigInteger value) {
                this.priority = value;
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
             *         &lt;element name="SourceCurve" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
                "sourceCurve"
            })
            public static class SourceCurves {

                @XmlElement(name = "SourceCurve")
                protected List<String> sourceCurve;

                /**
                 * Gets the value of the sourceCurve property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the sourceCurve property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getSourceCurve().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * 
                 * 
                 */
                public List<String> getSourceCurve() {
                    if (sourceCurve == null) {
                        sourceCurve = new ArrayList<String>();
                    }
                    return this.sourceCurve;
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
             *         &lt;element name="SwitchDate" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
                "switchDate"
            })
            public static class SwitchDates {

                @XmlElement(name = "SwitchDate")
                protected List<String> switchDate;

                /**
                 * Gets the value of the switchDate property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the switchDate property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getSwitchDate().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * 
                 * 
                 */
                public List<String> getSwitchDate() {
                    if (switchDate == null) {
                        switchDate = new ArrayList<String>();
                    }
                    return this.switchDate;
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
     *         &lt;element name="SourceCurve" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "sourceCurve"
    })
    public static class SourceCurves {

        @XmlElement(name = "SourceCurve")
        protected List<String> sourceCurve;

        /**
         * Gets the value of the sourceCurve property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sourceCurve property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSourceCurve().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSourceCurve() {
            if (sourceCurve == null) {
                sourceCurve = new ArrayList<String>();
            }
            return this.sourceCurve;
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
     *         &lt;element name="SwitchDate" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "switchDate"
    })
    public static class SwitchDates {

        @XmlElement(name = "SwitchDate")
        protected List<String> switchDate;

        /**
         * Gets the value of the switchDate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the switchDate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSwitchDate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSwitchDate() {
            if (switchDate == null) {
                switchDate = new ArrayList<String>();
            }
            return this.switchDate;
        }

    }

}
