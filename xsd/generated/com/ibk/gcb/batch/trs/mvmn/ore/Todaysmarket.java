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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>todaysmarket complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="todaysmarket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Configuration" type="{}configurationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="YieldCurves" type="{}yieldCurvesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DiscountingCurves" type="{}discountCurvesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IndexForwardingCurves" type="{}indexForwardingCurvesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SwapIndexCurves" type="{}swapIndexCurvesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZeroInflationIndexCurves" type="{}zeroInflationIndexCurvesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="YYInflationIndexCurves" type="{}yyInflationIndexCurvesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FxSpots" type="{}fxSpotsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FxVolatilities" type="{}fxVolatilitiesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SwaptionVolatilities" type="{}swaptionVolatilitiesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="YieldVolatilities" type="{}yieldVolatilitiesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CapFloorVolatilities" type="{}capFloorVolatilitiesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CDSVolatilities" type="{}cdsVolatilitiesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DefaultCurves" type="{}defaultCurvesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="YYInflationCapFloorVolatilities" type="{}yyInflationCapFloorVolatilitiesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZeroInflationCapFloorVolatilities" type="{}zeroInflationCapFloorVolatilitiesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EquityCurves" type="{}equityCurvesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EquityVolatilities" type="{}equityVolatilitiesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Securities" type="{}securitiesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BaseCorrelations" type="{}baseCorrelationsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CommodityCurves" type="{}commodityCurvesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CommodityVolatilities" type="{}commodityVolatilitiesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Correlations" type="{}correlationsType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "todaysmarket", propOrder = {
    "configuration",
    "yieldCurves",
    "discountingCurves",
    "indexForwardingCurves",
    "swapIndexCurves",
    "zeroInflationIndexCurves",
    "yyInflationIndexCurves",
    "fxSpots",
    "fxVolatilities",
    "swaptionVolatilities",
    "yieldVolatilities",
    "capFloorVolatilities",
    "cdsVolatilities",
    "defaultCurves",
    "yyInflationCapFloorVolatilities",
    "zeroInflationCapFloorVolatilities",
    "equityCurves",
    "equityVolatilities",
    "securities",
    "baseCorrelations",
    "commodityCurves",
    "commodityVolatilities",
    "correlations"
})
public class Todaysmarket {

    @XmlElement(name = "Configuration")
    protected List<ConfigurationType> configuration;
    @XmlElement(name = "YieldCurves")
    protected List<YieldCurvesType> yieldCurves;
    @XmlElement(name = "DiscountingCurves")
    protected List<DiscountCurvesType> discountingCurves;
    @XmlElement(name = "IndexForwardingCurves")
    protected List<IndexForwardingCurvesType> indexForwardingCurves;
    @XmlElement(name = "SwapIndexCurves")
    protected List<SwapIndexCurvesType> swapIndexCurves;
    @XmlElement(name = "ZeroInflationIndexCurves")
    protected List<ZeroInflationIndexCurvesType> zeroInflationIndexCurves;
    @XmlElement(name = "YYInflationIndexCurves")
    protected List<YyInflationIndexCurvesType> yyInflationIndexCurves;
    @XmlElement(name = "FxSpots")
    protected List<FxSpotsType> fxSpots;
    @XmlElement(name = "FxVolatilities")
    protected List<FxVolatilitiesType> fxVolatilities;
    @XmlElement(name = "SwaptionVolatilities")
    protected List<SwaptionVolatilitiesType> swaptionVolatilities;
    @XmlElement(name = "YieldVolatilities")
    protected List<YieldVolatilitiesType> yieldVolatilities;
    @XmlElement(name = "CapFloorVolatilities")
    protected List<CapFloorVolatilitiesType> capFloorVolatilities;
    @XmlElement(name = "CDSVolatilities")
    protected List<CdsVolatilitiesType> cdsVolatilities;
    @XmlElement(name = "DefaultCurves")
    protected List<DefaultCurvesType> defaultCurves;
    @XmlElement(name = "YYInflationCapFloorVolatilities")
    protected List<YyInflationCapFloorVolatilitiesType> yyInflationCapFloorVolatilities;
    @XmlElement(name = "ZeroInflationCapFloorVolatilities")
    protected List<ZeroInflationCapFloorVolatilitiesType> zeroInflationCapFloorVolatilities;
    @XmlElement(name = "EquityCurves")
    protected List<EquityCurvesType> equityCurves;
    @XmlElement(name = "EquityVolatilities")
    protected List<EquityVolatilitiesType> equityVolatilities;
    @XmlElement(name = "Securities")
    protected List<SecuritiesType> securities;
    @XmlElement(name = "BaseCorrelations")
    protected List<BaseCorrelationsType> baseCorrelations;
    @XmlElement(name = "CommodityCurves")
    protected List<CommodityCurvesType> commodityCurves;
    @XmlElement(name = "CommodityVolatilities")
    protected List<CommodityVolatilitiesType> commodityVolatilities;
    @XmlElement(name = "Correlations")
    protected List<CorrelationsType> correlations;

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
     * {@link ConfigurationType }
     * 
     * 
     */
    public List<ConfigurationType> getConfiguration() {
        if (configuration == null) {
            configuration = new ArrayList<ConfigurationType>();
        }
        return this.configuration;
    }

    /**
     * Gets the value of the yieldCurves property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the yieldCurves property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getYieldCurves().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link YieldCurvesType }
     * 
     * 
     */
    public List<YieldCurvesType> getYieldCurves() {
        if (yieldCurves == null) {
            yieldCurves = new ArrayList<YieldCurvesType>();
        }
        return this.yieldCurves;
    }

    /**
     * Gets the value of the discountingCurves property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the discountingCurves property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiscountingCurves().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiscountCurvesType }
     * 
     * 
     */
    public List<DiscountCurvesType> getDiscountingCurves() {
        if (discountingCurves == null) {
            discountingCurves = new ArrayList<DiscountCurvesType>();
        }
        return this.discountingCurves;
    }

    /**
     * Gets the value of the indexForwardingCurves property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the indexForwardingCurves property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndexForwardingCurves().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndexForwardingCurvesType }
     * 
     * 
     */
    public List<IndexForwardingCurvesType> getIndexForwardingCurves() {
        if (indexForwardingCurves == null) {
            indexForwardingCurves = new ArrayList<IndexForwardingCurvesType>();
        }
        return this.indexForwardingCurves;
    }

    /**
     * Gets the value of the swapIndexCurves property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the swapIndexCurves property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSwapIndexCurves().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SwapIndexCurvesType }
     * 
     * 
     */
    public List<SwapIndexCurvesType> getSwapIndexCurves() {
        if (swapIndexCurves == null) {
            swapIndexCurves = new ArrayList<SwapIndexCurvesType>();
        }
        return this.swapIndexCurves;
    }

    /**
     * Gets the value of the zeroInflationIndexCurves property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zeroInflationIndexCurves property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZeroInflationIndexCurves().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZeroInflationIndexCurvesType }
     * 
     * 
     */
    public List<ZeroInflationIndexCurvesType> getZeroInflationIndexCurves() {
        if (zeroInflationIndexCurves == null) {
            zeroInflationIndexCurves = new ArrayList<ZeroInflationIndexCurvesType>();
        }
        return this.zeroInflationIndexCurves;
    }

    /**
     * Gets the value of the yyInflationIndexCurves property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the yyInflationIndexCurves property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getYYInflationIndexCurves().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link YyInflationIndexCurvesType }
     * 
     * 
     */
    public List<YyInflationIndexCurvesType> getYYInflationIndexCurves() {
        if (yyInflationIndexCurves == null) {
            yyInflationIndexCurves = new ArrayList<YyInflationIndexCurvesType>();
        }
        return this.yyInflationIndexCurves;
    }

    /**
     * Gets the value of the fxSpots property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fxSpots property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFxSpots().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FxSpotsType }
     * 
     * 
     */
    public List<FxSpotsType> getFxSpots() {
        if (fxSpots == null) {
            fxSpots = new ArrayList<FxSpotsType>();
        }
        return this.fxSpots;
    }

    /**
     * Gets the value of the fxVolatilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fxVolatilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFxVolatilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FxVolatilitiesType }
     * 
     * 
     */
    public List<FxVolatilitiesType> getFxVolatilities() {
        if (fxVolatilities == null) {
            fxVolatilities = new ArrayList<FxVolatilitiesType>();
        }
        return this.fxVolatilities;
    }

    /**
     * Gets the value of the swaptionVolatilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the swaptionVolatilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSwaptionVolatilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SwaptionVolatilitiesType }
     * 
     * 
     */
    public List<SwaptionVolatilitiesType> getSwaptionVolatilities() {
        if (swaptionVolatilities == null) {
            swaptionVolatilities = new ArrayList<SwaptionVolatilitiesType>();
        }
        return this.swaptionVolatilities;
    }

    /**
     * Gets the value of the yieldVolatilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the yieldVolatilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getYieldVolatilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link YieldVolatilitiesType }
     * 
     * 
     */
    public List<YieldVolatilitiesType> getYieldVolatilities() {
        if (yieldVolatilities == null) {
            yieldVolatilities = new ArrayList<YieldVolatilitiesType>();
        }
        return this.yieldVolatilities;
    }

    /**
     * Gets the value of the capFloorVolatilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the capFloorVolatilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCapFloorVolatilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapFloorVolatilitiesType }
     * 
     * 
     */
    public List<CapFloorVolatilitiesType> getCapFloorVolatilities() {
        if (capFloorVolatilities == null) {
            capFloorVolatilities = new ArrayList<CapFloorVolatilitiesType>();
        }
        return this.capFloorVolatilities;
    }

    /**
     * Gets the value of the cdsVolatilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cdsVolatilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCDSVolatilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CdsVolatilitiesType }
     * 
     * 
     */
    public List<CdsVolatilitiesType> getCDSVolatilities() {
        if (cdsVolatilities == null) {
            cdsVolatilities = new ArrayList<CdsVolatilitiesType>();
        }
        return this.cdsVolatilities;
    }

    /**
     * Gets the value of the defaultCurves property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the defaultCurves property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDefaultCurves().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DefaultCurvesType }
     * 
     * 
     */
    public List<DefaultCurvesType> getDefaultCurves() {
        if (defaultCurves == null) {
            defaultCurves = new ArrayList<DefaultCurvesType>();
        }
        return this.defaultCurves;
    }

    /**
     * Gets the value of the yyInflationCapFloorVolatilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the yyInflationCapFloorVolatilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getYYInflationCapFloorVolatilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link YyInflationCapFloorVolatilitiesType }
     * 
     * 
     */
    public List<YyInflationCapFloorVolatilitiesType> getYYInflationCapFloorVolatilities() {
        if (yyInflationCapFloorVolatilities == null) {
            yyInflationCapFloorVolatilities = new ArrayList<YyInflationCapFloorVolatilitiesType>();
        }
        return this.yyInflationCapFloorVolatilities;
    }

    /**
     * Gets the value of the zeroInflationCapFloorVolatilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zeroInflationCapFloorVolatilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZeroInflationCapFloorVolatilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZeroInflationCapFloorVolatilitiesType }
     * 
     * 
     */
    public List<ZeroInflationCapFloorVolatilitiesType> getZeroInflationCapFloorVolatilities() {
        if (zeroInflationCapFloorVolatilities == null) {
            zeroInflationCapFloorVolatilities = new ArrayList<ZeroInflationCapFloorVolatilitiesType>();
        }
        return this.zeroInflationCapFloorVolatilities;
    }

    /**
     * Gets the value of the equityCurves property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the equityCurves property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquityCurves().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EquityCurvesType }
     * 
     * 
     */
    public List<EquityCurvesType> getEquityCurves() {
        if (equityCurves == null) {
            equityCurves = new ArrayList<EquityCurvesType>();
        }
        return this.equityCurves;
    }

    /**
     * Gets the value of the equityVolatilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the equityVolatilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquityVolatilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EquityVolatilitiesType }
     * 
     * 
     */
    public List<EquityVolatilitiesType> getEquityVolatilities() {
        if (equityVolatilities == null) {
            equityVolatilities = new ArrayList<EquityVolatilitiesType>();
        }
        return this.equityVolatilities;
    }

    /**
     * Gets the value of the securities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the securities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecurities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SecuritiesType }
     * 
     * 
     */
    public List<SecuritiesType> getSecurities() {
        if (securities == null) {
            securities = new ArrayList<SecuritiesType>();
        }
        return this.securities;
    }

    /**
     * Gets the value of the baseCorrelations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baseCorrelations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaseCorrelations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BaseCorrelationsType }
     * 
     * 
     */
    public List<BaseCorrelationsType> getBaseCorrelations() {
        if (baseCorrelations == null) {
            baseCorrelations = new ArrayList<BaseCorrelationsType>();
        }
        return this.baseCorrelations;
    }

    /**
     * Gets the value of the commodityCurves property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commodityCurves property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommodityCurves().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommodityCurvesType }
     * 
     * 
     */
    public List<CommodityCurvesType> getCommodityCurves() {
        if (commodityCurves == null) {
            commodityCurves = new ArrayList<CommodityCurvesType>();
        }
        return this.commodityCurves;
    }

    /**
     * Gets the value of the commodityVolatilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commodityVolatilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommodityVolatilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommodityVolatilitiesType }
     * 
     * 
     */
    public List<CommodityVolatilitiesType> getCommodityVolatilities() {
        if (commodityVolatilities == null) {
            commodityVolatilities = new ArrayList<CommodityVolatilitiesType>();
        }
        return this.commodityVolatilities;
    }

    /**
     * Gets the value of the correlations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the correlations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCorrelations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CorrelationsType }
     * 
     * 
     */
    public List<CorrelationsType> getCorrelations() {
        if (correlations == null) {
            correlations = new ArrayList<CorrelationsType>();
        }
        return this.correlations;
    }

}
