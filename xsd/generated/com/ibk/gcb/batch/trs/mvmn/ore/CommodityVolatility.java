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
 * <p>commodityVolatility complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="commodityVolatility">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;choice>
 *           &lt;element name="VolatilityConfig" type="{}volatilityConfig" minOccurs="0"/>
 *           &lt;choice minOccurs="0">
 *             &lt;element name="Constant" type="{}constantVolatilityConfig"/>
 *             &lt;element name="Curve" type="{}volatilityCurveConfig"/>
 *             &lt;element name="StrikeSurface" type="{}volatilityStrikeSurfaceConfig"/>
 *             &lt;element name="MoneynessSurface" type="{}volatilityMoneynessSurfaceConfig"/>
 *             &lt;element name="DeltaSurface" type="{}volatilityDeltaSurfaceConfig"/>
 *             &lt;element name="ApoFutureSurface" type="{}volatilityApoFutureSurfaceConfig"/>
 *             &lt;element name="ProxySurface" type="{}proxySurface"/>
 *           &lt;/choice>
 *         &lt;/choice>
 *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="FutureConventions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OptionExpiryRollDays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PriceCurveId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="YieldCurveId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QuoteSuffix" type="{}commVolQuoteSuffix" minOccurs="0"/>
 *         &lt;element name="OneDimSolverConfig" type="{}oneDimSolverConfigType" minOccurs="0"/>
 *         &lt;element name="PreferOutOfTheMoney" type="{}bool" minOccurs="0"/>
 *         &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commodityVolatility", propOrder = {
    "curveId",
    "curveDescription",
    "currency",
    "volatilityConfig",
    "constant",
    "curve",
    "strikeSurface",
    "moneynessSurface",
    "deltaSurface",
    "apoFutureSurface",
    "proxySurface",
    "dayCounter",
    "calendar",
    "futureConventions",
    "optionExpiryRollDays",
    "priceCurveId",
    "yieldCurveId",
    "quoteSuffix",
    "oneDimSolverConfig",
    "preferOutOfTheMoney",
    "report"
})
public class CommodityVolatility {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "VolatilityConfig")
    protected VolatilityConfig volatilityConfig;
    @XmlElement(name = "Constant")
    protected ConstantVolatilityConfig constant;
    @XmlElement(name = "Curve")
    protected VolatilityCurveConfig curve;
    @XmlElement(name = "StrikeSurface")
    protected VolatilityStrikeSurfaceConfig strikeSurface;
    @XmlElement(name = "MoneynessSurface")
    protected VolatilityMoneynessSurfaceConfig moneynessSurface;
    @XmlElement(name = "DeltaSurface")
    protected VolatilityDeltaSurfaceConfig deltaSurface;
    @XmlElement(name = "ApoFutureSurface")
    protected VolatilityApoFutureSurfaceConfig apoFutureSurface;
    @XmlElement(name = "ProxySurface")
    protected ProxySurface proxySurface;
    @XmlElement(name = "DayCounter")
    protected String dayCounter;
    @XmlElement(name = "Calendar")
    protected String calendar;
    @XmlElement(name = "FutureConventions")
    protected String futureConventions;
    @XmlElement(name = "OptionExpiryRollDays")
    protected String optionExpiryRollDays;
    @XmlElement(name = "PriceCurveId")
    protected String priceCurveId;
    @XmlElement(name = "YieldCurveId")
    protected String yieldCurveId;
    @XmlElement(name = "QuoteSuffix")
    @XmlSchemaType(name = "string")
    protected CommVolQuoteSuffix quoteSuffix;
    @XmlElement(name = "OneDimSolverConfig")
    protected OneDimSolverConfigType oneDimSolverConfig;
    @XmlElement(name = "PreferOutOfTheMoney")
    protected String preferOutOfTheMoney;
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
     * volatilityConfig 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VolatilityConfig }
     *     
     */
    public VolatilityConfig getVolatilityConfig() {
        return volatilityConfig;
    }

    /**
     * volatilityConfig 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolatilityConfig }
     *     
     */
    public void setVolatilityConfig(VolatilityConfig value) {
        this.volatilityConfig = value;
    }

    /**
     * constant 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ConstantVolatilityConfig }
     *     
     */
    public ConstantVolatilityConfig getConstant() {
        return constant;
    }

    /**
     * constant 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstantVolatilityConfig }
     *     
     */
    public void setConstant(ConstantVolatilityConfig value) {
        this.constant = value;
    }

    /**
     * curve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VolatilityCurveConfig }
     *     
     */
    public VolatilityCurveConfig getCurve() {
        return curve;
    }

    /**
     * curve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolatilityCurveConfig }
     *     
     */
    public void setCurve(VolatilityCurveConfig value) {
        this.curve = value;
    }

    /**
     * strikeSurface 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VolatilityStrikeSurfaceConfig }
     *     
     */
    public VolatilityStrikeSurfaceConfig getStrikeSurface() {
        return strikeSurface;
    }

    /**
     * strikeSurface 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolatilityStrikeSurfaceConfig }
     *     
     */
    public void setStrikeSurface(VolatilityStrikeSurfaceConfig value) {
        this.strikeSurface = value;
    }

    /**
     * moneynessSurface 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VolatilityMoneynessSurfaceConfig }
     *     
     */
    public VolatilityMoneynessSurfaceConfig getMoneynessSurface() {
        return moneynessSurface;
    }

    /**
     * moneynessSurface 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolatilityMoneynessSurfaceConfig }
     *     
     */
    public void setMoneynessSurface(VolatilityMoneynessSurfaceConfig value) {
        this.moneynessSurface = value;
    }

    /**
     * deltaSurface 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VolatilityDeltaSurfaceConfig }
     *     
     */
    public VolatilityDeltaSurfaceConfig getDeltaSurface() {
        return deltaSurface;
    }

    /**
     * deltaSurface 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolatilityDeltaSurfaceConfig }
     *     
     */
    public void setDeltaSurface(VolatilityDeltaSurfaceConfig value) {
        this.deltaSurface = value;
    }

    /**
     * apoFutureSurface 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VolatilityApoFutureSurfaceConfig }
     *     
     */
    public VolatilityApoFutureSurfaceConfig getApoFutureSurface() {
        return apoFutureSurface;
    }

    /**
     * apoFutureSurface 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolatilityApoFutureSurfaceConfig }
     *     
     */
    public void setApoFutureSurface(VolatilityApoFutureSurfaceConfig value) {
        this.apoFutureSurface = value;
    }

    /**
     * proxySurface 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ProxySurface }
     *     
     */
    public ProxySurface getProxySurface() {
        return proxySurface;
    }

    /**
     * proxySurface 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ProxySurface }
     *     
     */
    public void setProxySurface(ProxySurface value) {
        this.proxySurface = value;
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
     * futureConventions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFutureConventions() {
        return futureConventions;
    }

    /**
     * futureConventions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFutureConventions(String value) {
        this.futureConventions = value;
    }

    /**
     * optionExpiryRollDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionExpiryRollDays() {
        return optionExpiryRollDays;
    }

    /**
     * optionExpiryRollDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionExpiryRollDays(String value) {
        this.optionExpiryRollDays = value;
    }

    /**
     * priceCurveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceCurveId() {
        return priceCurveId;
    }

    /**
     * priceCurveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceCurveId(String value) {
        this.priceCurveId = value;
    }

    /**
     * yieldCurveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYieldCurveId() {
        return yieldCurveId;
    }

    /**
     * yieldCurveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYieldCurveId(String value) {
        this.yieldCurveId = value;
    }

    /**
     * quoteSuffix 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommVolQuoteSuffix }
     *     
     */
    public CommVolQuoteSuffix getQuoteSuffix() {
        return quoteSuffix;
    }

    /**
     * quoteSuffix 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommVolQuoteSuffix }
     *     
     */
    public void setQuoteSuffix(CommVolQuoteSuffix value) {
        this.quoteSuffix = value;
    }

    /**
     * oneDimSolverConfig 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OneDimSolverConfigType }
     *     
     */
    public OneDimSolverConfigType getOneDimSolverConfig() {
        return oneDimSolverConfig;
    }

    /**
     * oneDimSolverConfig 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OneDimSolverConfigType }
     *     
     */
    public void setOneDimSolverConfig(OneDimSolverConfigType value) {
        this.oneDimSolverConfig = value;
    }

    /**
     * preferOutOfTheMoney 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferOutOfTheMoney() {
        return preferOutOfTheMoney;
    }

    /**
     * preferOutOfTheMoney 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferOutOfTheMoney(String value) {
        this.preferOutOfTheMoney = value;
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

}
