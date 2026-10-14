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
 * <p>sensitivityanalysis complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="sensitivityanalysis">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ParConversionExcludes" type="{}parExcludes" minOccurs="0"/>
 *         &lt;element name="ParSensiRemoveFixing" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ParConversionMatrixRegularisation" type="{}parConversionMatrixRegularisation" minOccurs="0"/>
 *         &lt;element name="ParConversion" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DiscountCurves" type="{}discountcurves"/>
 *         &lt;element name="IndexCurves" type="{}indexcurves" minOccurs="0"/>
 *         &lt;element name="YieldCurves" type="{}yieldcurves" minOccurs="0"/>
 *         &lt;element name="FxSpots" type="{}fxspots" minOccurs="0"/>
 *         &lt;element name="FxVolatilities" type="{}fxvolatilities" minOccurs="0"/>
 *         &lt;element name="SwaptionVolatilities" type="{}swaptionvolatilities" minOccurs="0"/>
 *         &lt;element name="YieldVolatilities" type="{}yieldvolatilities" minOccurs="0"/>
 *         &lt;element name="CapFloorVolatilities" type="{}capfloorvolatilities" minOccurs="0"/>
 *         &lt;element name="CDSVolatilities" type="{}cdsvolatilities" minOccurs="0"/>
 *         &lt;element name="CreditCurves" type="{}creditcurves" minOccurs="0"/>
 *         &lt;element name="EquitySpots" type="{}equityspots" minOccurs="0"/>
 *         &lt;element name="EquityVolatilities" type="{}equityvolatilities" minOccurs="0"/>
 *         &lt;element name="ZeroInflationIndexCurves" type="{}zeroinflationindexcurves" minOccurs="0"/>
 *         &lt;element name="YYInflationIndexCurves" type="{}yyinflationindexcurves" minOccurs="0"/>
 *         &lt;element name="CPICapFloorVolatilities" type="{}cpicapfloorvolatilities" minOccurs="0"/>
 *         &lt;element name="YYCapFloorVolatilities" type="{}yycapfloorvolatilities" minOccurs="0"/>
 *         &lt;element name="DividendYieldCurves" type="{}dividendyields" minOccurs="0"/>
 *         &lt;element name="BaseCorrelations" type="{}basecorrelations" minOccurs="0"/>
 *         &lt;element name="SecuritySpreads" type="{}securityspreads" minOccurs="0"/>
 *         &lt;element name="CommodityCurves" type="{}commodityCurves" minOccurs="0"/>
 *         &lt;element name="CommodityVolatilities" type="{}commodityvolatilities" minOccurs="0"/>
 *         &lt;element name="Correlations" type="{}correlationcurves" minOccurs="0"/>
 *         &lt;element name="CrossGammaFilter" type="{}crossgammafilter" minOccurs="0"/>
 *         &lt;element name="ComputeGamma" type="{}bool" minOccurs="0"/>
 *         &lt;element name="UseSpreadedTermStructures" type="{}bool" minOccurs="0"/>
 *         &lt;element name="TwoSidedDeltaKeyTypes" type="{}setRiskFactorKeyTypes" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sensitivityanalysis", propOrder = {

})
public class Sensitivityanalysis {

    @XmlElement(name = "ParConversionExcludes")
    protected ParExcludes parConversionExcludes;
    @XmlElement(name = "ParSensiRemoveFixing")
    protected String parSensiRemoveFixing;
    @XmlElement(name = "ParConversionMatrixRegularisation")
    @XmlSchemaType(name = "string")
    protected ParConversionMatrixRegularisation parConversionMatrixRegularisation;
    @XmlElement(name = "ParConversion")
    protected Boolean parConversion;
    @XmlElement(name = "DiscountCurves", required = true)
    protected Discountcurves discountCurves;
    @XmlElement(name = "IndexCurves")
    protected Indexcurves indexCurves;
    @XmlElement(name = "YieldCurves")
    protected SensitivityYieldCurves yieldCurves;
    @XmlElement(name = "FxSpots")
    protected SensitivityFxSpots fxSpots;
    @XmlElement(name = "FxVolatilities")
    protected SensitivityFxVolatilities fxVolatilities;
    @XmlElement(name = "SwaptionVolatilities")
    protected SensitivitySwaptionVolatilities swaptionVolatilities;
    @XmlElement(name = "YieldVolatilities")
    protected SensitivityYieldVolatilities yieldVolatilities;
    @XmlElement(name = "CapFloorVolatilities")
    protected SensitivityCapFloorVolatilities capFloorVolatilities;
    @XmlElement(name = "CDSVolatilities")
    protected SensitivityCdsVolatilities cdsVolatilities;
    @XmlElement(name = "CreditCurves")
    protected Creditcurves creditCurves;
    @XmlElement(name = "EquitySpots")
    protected Equityspots equitySpots;
    @XmlElement(name = "EquityVolatilities")
    protected SensitivityEquityVolatilities equityVolatilities;
    @XmlElement(name = "ZeroInflationIndexCurves")
    protected Zeroinflationindexcurves zeroInflationIndexCurves;
    @XmlElement(name = "YYInflationIndexCurves")
    protected Yyinflationindexcurves yyInflationIndexCurves;
    @XmlElement(name = "CPICapFloorVolatilities")
    protected Cpicapfloorvolatilities cpiCapFloorVolatilities;
    @XmlElement(name = "YYCapFloorVolatilities")
    protected Yycapfloorvolatilities yyCapFloorVolatilities;
    @XmlElement(name = "DividendYieldCurves")
    protected Dividendyields dividendYieldCurves;
    @XmlElement(name = "BaseCorrelations")
    protected SensitivityBaseCorrelations baseCorrelations;
    @XmlElement(name = "SecuritySpreads")
    protected Securityspreads securitySpreads;
    @XmlElement(name = "CommodityCurves")
    protected CommodityCurves commodityCurves;
    @XmlElement(name = "CommodityVolatilities")
    protected SensitivityCommodityVolatilities commodityVolatilities;
    @XmlElement(name = "Correlations")
    protected Correlationcurves correlations;
    @XmlElement(name = "CrossGammaFilter")
    protected Crossgammafilter crossGammaFilter;
    @XmlElement(name = "ComputeGamma")
    protected String computeGamma;
    @XmlElement(name = "UseSpreadedTermStructures")
    protected String useSpreadedTermStructures;
    @XmlElement(name = "TwoSidedDeltaKeyTypes")
    protected SetRiskFactorKeyTypes twoSidedDeltaKeyTypes;

    /**
     * parConversionExcludes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ParExcludes }
     *     
     */
    public ParExcludes getParConversionExcludes() {
        return parConversionExcludes;
    }

    /**
     * parConversionExcludes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ParExcludes }
     *     
     */
    public void setParConversionExcludes(ParExcludes value) {
        this.parConversionExcludes = value;
    }

    /**
     * parSensiRemoveFixing 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParSensiRemoveFixing() {
        return parSensiRemoveFixing;
    }

    /**
     * parSensiRemoveFixing 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParSensiRemoveFixing(String value) {
        this.parSensiRemoveFixing = value;
    }

    /**
     * parConversionMatrixRegularisation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ParConversionMatrixRegularisation }
     *     
     */
    public ParConversionMatrixRegularisation getParConversionMatrixRegularisation() {
        return parConversionMatrixRegularisation;
    }

    /**
     * parConversionMatrixRegularisation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ParConversionMatrixRegularisation }
     *     
     */
    public void setParConversionMatrixRegularisation(ParConversionMatrixRegularisation value) {
        this.parConversionMatrixRegularisation = value;
    }

    /**
     * parConversion 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isParConversion() {
        return parConversion;
    }

    /**
     * parConversion 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setParConversion(Boolean value) {
        this.parConversion = value;
    }

    /**
     * discountCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Discountcurves }
     *     
     */
    public Discountcurves getDiscountCurves() {
        return discountCurves;
    }

    /**
     * discountCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Discountcurves }
     *     
     */
    public void setDiscountCurves(Discountcurves value) {
        this.discountCurves = value;
    }

    /**
     * indexCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Indexcurves }
     *     
     */
    public Indexcurves getIndexCurves() {
        return indexCurves;
    }

    /**
     * indexCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Indexcurves }
     *     
     */
    public void setIndexCurves(Indexcurves value) {
        this.indexCurves = value;
    }

    /**
     * yieldCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SensitivityYieldCurves }
     *     
     */
    public SensitivityYieldCurves getYieldCurves() {
        return yieldCurves;
    }

    /**
     * yieldCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivityYieldCurves }
     *     
     */
    public void setYieldCurves(SensitivityYieldCurves value) {
        this.yieldCurves = value;
    }

    /**
     * fxSpots 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SensitivityFxSpots }
     *     
     */
    public SensitivityFxSpots getFxSpots() {
        return fxSpots;
    }

    /**
     * fxSpots 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivityFxSpots }
     *     
     */
    public void setFxSpots(SensitivityFxSpots value) {
        this.fxSpots = value;
    }

    /**
     * fxVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SensitivityFxVolatilities }
     *     
     */
    public SensitivityFxVolatilities getFxVolatilities() {
        return fxVolatilities;
    }

    /**
     * fxVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivityFxVolatilities }
     *     
     */
    public void setFxVolatilities(SensitivityFxVolatilities value) {
        this.fxVolatilities = value;
    }

    /**
     * swaptionVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SensitivitySwaptionVolatilities }
     *     
     */
    public SensitivitySwaptionVolatilities getSwaptionVolatilities() {
        return swaptionVolatilities;
    }

    /**
     * swaptionVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivitySwaptionVolatilities }
     *     
     */
    public void setSwaptionVolatilities(SensitivitySwaptionVolatilities value) {
        this.swaptionVolatilities = value;
    }

    /**
     * yieldVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SensitivityYieldVolatilities }
     *     
     */
    public SensitivityYieldVolatilities getYieldVolatilities() {
        return yieldVolatilities;
    }

    /**
     * yieldVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivityYieldVolatilities }
     *     
     */
    public void setYieldVolatilities(SensitivityYieldVolatilities value) {
        this.yieldVolatilities = value;
    }

    /**
     * capFloorVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SensitivityCapFloorVolatilities }
     *     
     */
    public SensitivityCapFloorVolatilities getCapFloorVolatilities() {
        return capFloorVolatilities;
    }

    /**
     * capFloorVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivityCapFloorVolatilities }
     *     
     */
    public void setCapFloorVolatilities(SensitivityCapFloorVolatilities value) {
        this.capFloorVolatilities = value;
    }

    /**
     * cdsVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SensitivityCdsVolatilities }
     *     
     */
    public SensitivityCdsVolatilities getCDSVolatilities() {
        return cdsVolatilities;
    }

    /**
     * cdsVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivityCdsVolatilities }
     *     
     */
    public void setCDSVolatilities(SensitivityCdsVolatilities value) {
        this.cdsVolatilities = value;
    }

    /**
     * creditCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Creditcurves }
     *     
     */
    public Creditcurves getCreditCurves() {
        return creditCurves;
    }

    /**
     * creditCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Creditcurves }
     *     
     */
    public void setCreditCurves(Creditcurves value) {
        this.creditCurves = value;
    }

    /**
     * equitySpots 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Equityspots }
     *     
     */
    public Equityspots getEquitySpots() {
        return equitySpots;
    }

    /**
     * equitySpots 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Equityspots }
     *     
     */
    public void setEquitySpots(Equityspots value) {
        this.equitySpots = value;
    }

    /**
     * equityVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SensitivityEquityVolatilities }
     *     
     */
    public SensitivityEquityVolatilities getEquityVolatilities() {
        return equityVolatilities;
    }

    /**
     * equityVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivityEquityVolatilities }
     *     
     */
    public void setEquityVolatilities(SensitivityEquityVolatilities value) {
        this.equityVolatilities = value;
    }

    /**
     * zeroInflationIndexCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Zeroinflationindexcurves }
     *     
     */
    public Zeroinflationindexcurves getZeroInflationIndexCurves() {
        return zeroInflationIndexCurves;
    }

    /**
     * zeroInflationIndexCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Zeroinflationindexcurves }
     *     
     */
    public void setZeroInflationIndexCurves(Zeroinflationindexcurves value) {
        this.zeroInflationIndexCurves = value;
    }

    /**
     * yyInflationIndexCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Yyinflationindexcurves }
     *     
     */
    public Yyinflationindexcurves getYYInflationIndexCurves() {
        return yyInflationIndexCurves;
    }

    /**
     * yyInflationIndexCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Yyinflationindexcurves }
     *     
     */
    public void setYYInflationIndexCurves(Yyinflationindexcurves value) {
        this.yyInflationIndexCurves = value;
    }

    /**
     * cpiCapFloorVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Cpicapfloorvolatilities }
     *     
     */
    public Cpicapfloorvolatilities getCPICapFloorVolatilities() {
        return cpiCapFloorVolatilities;
    }

    /**
     * cpiCapFloorVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Cpicapfloorvolatilities }
     *     
     */
    public void setCPICapFloorVolatilities(Cpicapfloorvolatilities value) {
        this.cpiCapFloorVolatilities = value;
    }

    /**
     * yyCapFloorVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Yycapfloorvolatilities }
     *     
     */
    public Yycapfloorvolatilities getYYCapFloorVolatilities() {
        return yyCapFloorVolatilities;
    }

    /**
     * yyCapFloorVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Yycapfloorvolatilities }
     *     
     */
    public void setYYCapFloorVolatilities(Yycapfloorvolatilities value) {
        this.yyCapFloorVolatilities = value;
    }

    /**
     * dividendYieldCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Dividendyields }
     *     
     */
    public Dividendyields getDividendYieldCurves() {
        return dividendYieldCurves;
    }

    /**
     * dividendYieldCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Dividendyields }
     *     
     */
    public void setDividendYieldCurves(Dividendyields value) {
        this.dividendYieldCurves = value;
    }

    /**
     * baseCorrelations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SensitivityBaseCorrelations }
     *     
     */
    public SensitivityBaseCorrelations getBaseCorrelations() {
        return baseCorrelations;
    }

    /**
     * baseCorrelations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivityBaseCorrelations }
     *     
     */
    public void setBaseCorrelations(SensitivityBaseCorrelations value) {
        this.baseCorrelations = value;
    }

    /**
     * securitySpreads 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Securityspreads }
     *     
     */
    public Securityspreads getSecuritySpreads() {
        return securitySpreads;
    }

    /**
     * securitySpreads 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Securityspreads }
     *     
     */
    public void setSecuritySpreads(Securityspreads value) {
        this.securitySpreads = value;
    }

    /**
     * commodityCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityCurves }
     *     
     */
    public CommodityCurves getCommodityCurves() {
        return commodityCurves;
    }

    /**
     * commodityCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityCurves }
     *     
     */
    public void setCommodityCurves(CommodityCurves value) {
        this.commodityCurves = value;
    }

    /**
     * commodityVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SensitivityCommodityVolatilities }
     *     
     */
    public SensitivityCommodityVolatilities getCommodityVolatilities() {
        return commodityVolatilities;
    }

    /**
     * commodityVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivityCommodityVolatilities }
     *     
     */
    public void setCommodityVolatilities(SensitivityCommodityVolatilities value) {
        this.commodityVolatilities = value;
    }

    /**
     * correlations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Correlationcurves }
     *     
     */
    public Correlationcurves getCorrelations() {
        return correlations;
    }

    /**
     * correlations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Correlationcurves }
     *     
     */
    public void setCorrelations(Correlationcurves value) {
        this.correlations = value;
    }

    /**
     * crossGammaFilter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Crossgammafilter }
     *     
     */
    public Crossgammafilter getCrossGammaFilter() {
        return crossGammaFilter;
    }

    /**
     * crossGammaFilter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Crossgammafilter }
     *     
     */
    public void setCrossGammaFilter(Crossgammafilter value) {
        this.crossGammaFilter = value;
    }

    /**
     * computeGamma 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComputeGamma() {
        return computeGamma;
    }

    /**
     * computeGamma 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComputeGamma(String value) {
        this.computeGamma = value;
    }

    /**
     * useSpreadedTermStructures 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseSpreadedTermStructures() {
        return useSpreadedTermStructures;
    }

    /**
     * useSpreadedTermStructures 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseSpreadedTermStructures(String value) {
        this.useSpreadedTermStructures = value;
    }

    /**
     * twoSidedDeltaKeyTypes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SetRiskFactorKeyTypes }
     *     
     */
    public SetRiskFactorKeyTypes getTwoSidedDeltaKeyTypes() {
        return twoSidedDeltaKeyTypes;
    }

    /**
     * twoSidedDeltaKeyTypes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SetRiskFactorKeyTypes }
     *     
     */
    public void setTwoSidedDeltaKeyTypes(SetRiskFactorKeyTypes value) {
        this.twoSidedDeltaKeyTypes = value;
    }

}
