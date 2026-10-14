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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>curveconfiguration complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="curveconfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ReportConfiguration" type="{}globalReportConfiguration" minOccurs="0"/>
 *         &lt;element name="FXSpots" type="{}fxSpots" minOccurs="0"/>
 *         &lt;element name="FXVolatilities" type="{}fxVolatilities" minOccurs="0"/>
 *         &lt;element name="SwaptionVolatilities" type="{}swaptionVolatilities" minOccurs="0"/>
 *         &lt;element name="YieldVolatilities" type="{}yieldVolatilities" minOccurs="0"/>
 *         &lt;element name="CapFloorVolatilities" type="{}capFloorVolatilities" minOccurs="0"/>
 *         &lt;element name="CDSVolatilities" type="{}cdsVolatilities" minOccurs="0"/>
 *         &lt;element name="DefaultCurves" type="{}defaultCurves" minOccurs="0"/>
 *         &lt;element name="YieldCurves" type="{}yieldCurves" minOccurs="0"/>
 *         &lt;element name="InflationCurves" type="{}inflationCurves" minOccurs="0"/>
 *         &lt;element name="InflationCapFloorVolatilities" type="{}inflationCapFloorVolatlities" minOccurs="0"/>
 *         &lt;element name="EquityCurves" type="{}equityCurves" minOccurs="0"/>
 *         &lt;element name="EquityVolatilities" type="{}equityVolatilities" minOccurs="0"/>
 *         &lt;element name="Securities" type="{}securities" minOccurs="0"/>
 *         &lt;element name="BaseCorrelations" type="{}baseCorrelations" minOccurs="0"/>
 *         &lt;element name="CommodityCurves" type="{}simCommodityCurves" minOccurs="0"/>
 *         &lt;element name="CommodityVolatilities" type="{}commodityVolatilities" minOccurs="0"/>
 *         &lt;element name="Correlations" type="{}correlations" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "curveconfiguration", propOrder = {

})
public class Curveconfiguration {

    @XmlElement(name = "ReportConfiguration")
    protected GlobalReportConfiguration reportConfiguration;
    @XmlElement(name = "FXSpots")
    protected FxSpots fxSpots;
    @XmlElement(name = "FXVolatilities")
    protected FxVolatilities fxVolatilities;
    @XmlElement(name = "SwaptionVolatilities")
    protected SwaptionVolatilities swaptionVolatilities;
    @XmlElement(name = "YieldVolatilities")
    protected YieldVolatilities yieldVolatilities;
    @XmlElement(name = "CapFloorVolatilities")
    protected CapFloorVolatilities capFloorVolatilities;
    @XmlElement(name = "CDSVolatilities")
    protected CdsVolatilities cdsVolatilities;
    @XmlElement(name = "DefaultCurves")
    protected DefaultCurves defaultCurves;
    @XmlElement(name = "YieldCurves")
    protected YieldCurves yieldCurves;
    @XmlElement(name = "InflationCurves")
    protected InflationCurves inflationCurves;
    @XmlElement(name = "InflationCapFloorVolatilities")
    protected InflationCapFloorVolatlities inflationCapFloorVolatilities;
    @XmlElement(name = "EquityCurves")
    protected EquityCurves equityCurves;
    @XmlElement(name = "EquityVolatilities")
    protected EquityVolatilities equityVolatilities;
    @XmlElement(name = "Securities")
    protected Securities securities;
    @XmlElement(name = "BaseCorrelations")
    protected BaseCorrelations baseCorrelations;
    @XmlElement(name = "CommodityCurves")
    protected SimCommodityCurves commodityCurves;
    @XmlElement(name = "CommodityVolatilities")
    protected CommodityVolatilities commodityVolatilities;
    @XmlElement(name = "Correlations")
    protected Correlations correlations;

    /**
     * reportConfiguration 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GlobalReportConfiguration }
     *     
     */
    public GlobalReportConfiguration getReportConfiguration() {
        return reportConfiguration;
    }

    /**
     * reportConfiguration 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalReportConfiguration }
     *     
     */
    public void setReportConfiguration(GlobalReportConfiguration value) {
        this.reportConfiguration = value;
    }

    /**
     * fxSpots 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxSpots }
     *     
     */
    public FxSpots getFXSpots() {
        return fxSpots;
    }

    /**
     * fxSpots 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxSpots }
     *     
     */
    public void setFXSpots(FxSpots value) {
        this.fxSpots = value;
    }

    /**
     * fxVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxVolatilities }
     *     
     */
    public FxVolatilities getFXVolatilities() {
        return fxVolatilities;
    }

    /**
     * fxVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxVolatilities }
     *     
     */
    public void setFXVolatilities(FxVolatilities value) {
        this.fxVolatilities = value;
    }

    /**
     * swaptionVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SwaptionVolatilities }
     *     
     */
    public SwaptionVolatilities getSwaptionVolatilities() {
        return swaptionVolatilities;
    }

    /**
     * swaptionVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SwaptionVolatilities }
     *     
     */
    public void setSwaptionVolatilities(SwaptionVolatilities value) {
        this.swaptionVolatilities = value;
    }

    /**
     * yieldVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link YieldVolatilities }
     *     
     */
    public YieldVolatilities getYieldVolatilities() {
        return yieldVolatilities;
    }

    /**
     * yieldVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link YieldVolatilities }
     *     
     */
    public void setYieldVolatilities(YieldVolatilities value) {
        this.yieldVolatilities = value;
    }

    /**
     * capFloorVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CapFloorVolatilities }
     *     
     */
    public CapFloorVolatilities getCapFloorVolatilities() {
        return capFloorVolatilities;
    }

    /**
     * capFloorVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CapFloorVolatilities }
     *     
     */
    public void setCapFloorVolatilities(CapFloorVolatilities value) {
        this.capFloorVolatilities = value;
    }

    /**
     * cdsVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CdsVolatilities }
     *     
     */
    public CdsVolatilities getCDSVolatilities() {
        return cdsVolatilities;
    }

    /**
     * cdsVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CdsVolatilities }
     *     
     */
    public void setCDSVolatilities(CdsVolatilities value) {
        this.cdsVolatilities = value;
    }

    /**
     * defaultCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DefaultCurves }
     *     
     */
    public DefaultCurves getDefaultCurves() {
        return defaultCurves;
    }

    /**
     * defaultCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultCurves }
     *     
     */
    public void setDefaultCurves(DefaultCurves value) {
        this.defaultCurves = value;
    }

    /**
     * yieldCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link YieldCurves }
     *     
     */
    public YieldCurves getYieldCurves() {
        return yieldCurves;
    }

    /**
     * yieldCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link YieldCurves }
     *     
     */
    public void setYieldCurves(YieldCurves value) {
        this.yieldCurves = value;
    }

    /**
     * inflationCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link InflationCurves }
     *     
     */
    public InflationCurves getInflationCurves() {
        return inflationCurves;
    }

    /**
     * inflationCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link InflationCurves }
     *     
     */
    public void setInflationCurves(InflationCurves value) {
        this.inflationCurves = value;
    }

    /**
     * inflationCapFloorVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link InflationCapFloorVolatlities }
     *     
     */
    public InflationCapFloorVolatlities getInflationCapFloorVolatilities() {
        return inflationCapFloorVolatilities;
    }

    /**
     * inflationCapFloorVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link InflationCapFloorVolatlities }
     *     
     */
    public void setInflationCapFloorVolatilities(InflationCapFloorVolatlities value) {
        this.inflationCapFloorVolatilities = value;
    }

    /**
     * equityCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EquityCurves }
     *     
     */
    public EquityCurves getEquityCurves() {
        return equityCurves;
    }

    /**
     * equityCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EquityCurves }
     *     
     */
    public void setEquityCurves(EquityCurves value) {
        this.equityCurves = value;
    }

    /**
     * equityVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EquityVolatilities }
     *     
     */
    public EquityVolatilities getEquityVolatilities() {
        return equityVolatilities;
    }

    /**
     * equityVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EquityVolatilities }
     *     
     */
    public void setEquityVolatilities(EquityVolatilities value) {
        this.equityVolatilities = value;
    }

    /**
     * securities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Securities }
     *     
     */
    public Securities getSecurities() {
        return securities;
    }

    /**
     * securities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Securities }
     *     
     */
    public void setSecurities(Securities value) {
        this.securities = value;
    }

    /**
     * baseCorrelations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BaseCorrelations }
     *     
     */
    public BaseCorrelations getBaseCorrelations() {
        return baseCorrelations;
    }

    /**
     * baseCorrelations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseCorrelations }
     *     
     */
    public void setBaseCorrelations(BaseCorrelations value) {
        this.baseCorrelations = value;
    }

    /**
     * commodityCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SimCommodityCurves }
     *     
     */
    public SimCommodityCurves getCommodityCurves() {
        return commodityCurves;
    }

    /**
     * commodityCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SimCommodityCurves }
     *     
     */
    public void setCommodityCurves(SimCommodityCurves value) {
        this.commodityCurves = value;
    }

    /**
     * commodityVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityVolatilities }
     *     
     */
    public CommodityVolatilities getCommodityVolatilities() {
        return commodityVolatilities;
    }

    /**
     * commodityVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityVolatilities }
     *     
     */
    public void setCommodityVolatilities(CommodityVolatilities value) {
        this.commodityVolatilities = value;
    }

    /**
     * correlations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Correlations }
     *     
     */
    public Correlations getCorrelations() {
        return correlations;
    }

    /**
     * correlations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Correlations }
     *     
     */
    public void setCorrelations(Correlations value) {
        this.correlations = value;
    }

}
