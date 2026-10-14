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
 * <p>equityVolatility complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="equityVolatility">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EquityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Currency" type="{}extendedCurrencyCode"/>
 *         &lt;element name="Dimension" type="{}dimensionType" minOccurs="0"/>
 *         &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="TimeExtrapolation" type="{}extrapolationType" minOccurs="0"/>
 *         &lt;element name="StrikeExtrapolation" type="{}extrapolationType" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="VolatilityConfig" type="{}volatilityConfig" minOccurs="0"/>
 *           &lt;choice minOccurs="0">
 *             &lt;element name="Constant" type="{}constantVolatilityConfig"/>
 *             &lt;element name="Curve" type="{}volatilityCurveConfig"/>
 *             &lt;element name="StrikeSurface" type="{}volatilityStrikeSurfaceConfig"/>
 *             &lt;element name="MoneynessSurface" type="{}volatilityMoneynessSurfaceConfig"/>
 *             &lt;element name="DeltaSurface" type="{}volatilityDeltaSurfaceConfig"/>
 *             &lt;element name="ProxySurface" type="{}proxySurface"/>
 *           &lt;/choice>
 *         &lt;/choice>
 *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
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
@XmlType(name = "equityVolatility", propOrder = {
    "curveId",
    "curveDescription",
    "equityId",
    "currency",
    "dimension",
    "expiries",
    "strikes",
    "dayCounter",
    "timeExtrapolation",
    "strikeExtrapolation",
    "volatilityConfig",
    "constant",
    "curve",
    "strikeSurface",
    "moneynessSurface",
    "deltaSurface",
    "proxySurface",
    "calendar",
    "oneDimSolverConfig",
    "preferOutOfTheMoney",
    "report"
})
public class EquityVolatility {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "EquityId")
    protected String equityId;
    @XmlElement(name = "Currency", required = true)
    protected String currency;
    @XmlElement(name = "Dimension")
    @XmlSchemaType(name = "string")
    protected DimensionType dimension;
    @XmlElement(name = "Expiries")
    protected String expiries;
    @XmlElement(name = "Strikes")
    protected String strikes;
    @XmlElement(name = "DayCounter")
    protected String dayCounter;
    @XmlElement(name = "TimeExtrapolation")
    @XmlSchemaType(name = "string")
    protected ExtrapolationType timeExtrapolation;
    @XmlElement(name = "StrikeExtrapolation")
    @XmlSchemaType(name = "string")
    protected ExtrapolationType strikeExtrapolation;
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
    @XmlElement(name = "ProxySurface")
    protected ProxySurface proxySurface;
    @XmlElement(name = "Calendar")
    protected String calendar;
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
     * equityId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquityId() {
        return equityId;
    }

    /**
     * equityId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquityId(String value) {
        this.equityId = value;
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
     * expiries 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiries() {
        return expiries;
    }

    /**
     * expiries 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiries(String value) {
        this.expiries = value;
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
     * timeExtrapolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ExtrapolationType }
     *     
     */
    public ExtrapolationType getTimeExtrapolation() {
        return timeExtrapolation;
    }

    /**
     * timeExtrapolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtrapolationType }
     *     
     */
    public void setTimeExtrapolation(ExtrapolationType value) {
        this.timeExtrapolation = value;
    }

    /**
     * strikeExtrapolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ExtrapolationType }
     *     
     */
    public ExtrapolationType getStrikeExtrapolation() {
        return strikeExtrapolation;
    }

    /**
     * strikeExtrapolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtrapolationType }
     *     
     */
    public void setStrikeExtrapolation(ExtrapolationType value) {
        this.strikeExtrapolation = value;
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
