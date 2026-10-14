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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>crossAssetModel complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="crossAssetModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="DomesticCcy" type="{}currencyCode"/>
 *         &lt;element name="Currencies">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Equities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Equity" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InflationIndices" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="InflationIndex" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CreditNames" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CreditName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Commodities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Commodity" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BootstrapTolerance" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Measure" type="{}measureType" minOccurs="0"/>
 *         &lt;element name="Discretization" type="{}discretizationType" minOccurs="0"/>
 *         &lt;element name="SalvagingAlgorithm" type="{}salvagingAlgoType" minOccurs="0"/>
 *         &lt;element name="IntegrationPolicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PiecewiseIntegration" type="{}bool" minOccurs="0"/>
 *         &lt;element name="InterestRateModels">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;sequence>
 *                     &lt;element name="LGM" type="{}lgm" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                   &lt;sequence>
 *                     &lt;element name="HWModel" type="{}hw" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ForeignExchangeModels" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CrossCcyLGM" type="{}crossCurrencyLGM" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EquityModels" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CrossAssetLGM" type="{}crossAssetLGM" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InflationIndexModels" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                     &lt;element name="LGM" type="{}lgm"/>
 *                     &lt;element name="JarrowYildirim" type="{}jarrowYildrim"/>
 *                     &lt;element name="DodgsonKainth" type="{}dodgsonKainth"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CreditModels" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                     &lt;element name="LGM" type="{}crlgm"/>
 *                     &lt;element name="CIR" type="{}cir"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CommodityModels" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CommoditySchwartz" type="{}commoditySchwartz" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CreditStates" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NumberOfFactors" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InstantaneousCorrelations" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Correlation" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;>correlationValue">
 *                           &lt;attribute name="factor1" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="factor2" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="index1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="index2" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "crossAssetModel", propOrder = {

})
public class CrossAssetModel {

    @XmlElement(name = "DomesticCcy", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode domesticCcy;
    @XmlElement(name = "Currencies", required = true)
    protected CrossAssetModel.Currencies currencies;
    @XmlElement(name = "Equities")
    protected CrossAssetModel.Equities equities;
    @XmlElement(name = "InflationIndices")
    protected CrossAssetModel.InflationIndices inflationIndices;
    @XmlElement(name = "CreditNames")
    protected CrossAssetModel.CreditNames creditNames;
    @XmlElement(name = "Commodities")
    protected CrossAssetModel.Commodities commodities;
    @XmlElement(name = "BootstrapTolerance")
    protected float bootstrapTolerance;
    @XmlElement(name = "Measure")
    protected String measure;
    @XmlElement(name = "Discretization")
    @XmlSchemaType(name = "string")
    protected DiscretizationType discretization;
    @XmlElement(name = "SalvagingAlgorithm")
    @XmlSchemaType(name = "string")
    protected SalvagingAlgoType salvagingAlgorithm;
    @XmlElement(name = "IntegrationPolicy")
    protected String integrationPolicy;
    @XmlElement(name = "PiecewiseIntegration")
    protected String piecewiseIntegration;
    @XmlElement(name = "InterestRateModels", required = true)
    protected CrossAssetModel.InterestRateModels interestRateModels;
    @XmlElement(name = "ForeignExchangeModels")
    protected CrossAssetModel.ForeignExchangeModels foreignExchangeModels;
    @XmlElement(name = "EquityModels")
    protected CrossAssetModel.EquityModels equityModels;
    @XmlElement(name = "InflationIndexModels")
    protected CrossAssetModel.InflationIndexModels inflationIndexModels;
    @XmlElement(name = "CreditModels")
    protected CrossAssetModel.CreditModels creditModels;
    @XmlElement(name = "CommodityModels")
    protected CrossAssetModel.CommodityModels commodityModels;
    @XmlElement(name = "CreditStates")
    protected CrossAssetModel.CreditStates creditStates;
    @XmlElement(name = "InstantaneousCorrelations")
    protected CrossAssetModel.InstantaneousCorrelations instantaneousCorrelations;

    /**
     * domesticCcy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getDomesticCcy() {
        return domesticCcy;
    }

    /**
     * domesticCcy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setDomesticCcy(CurrencyCode value) {
        this.domesticCcy = value;
    }

    /**
     * currencies 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.Currencies }
     *     
     */
    public CrossAssetModel.Currencies getCurrencies() {
        return currencies;
    }

    /**
     * currencies 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.Currencies }
     *     
     */
    public void setCurrencies(CrossAssetModel.Currencies value) {
        this.currencies = value;
    }

    /**
     * equities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.Equities }
     *     
     */
    public CrossAssetModel.Equities getEquities() {
        return equities;
    }

    /**
     * equities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.Equities }
     *     
     */
    public void setEquities(CrossAssetModel.Equities value) {
        this.equities = value;
    }

    /**
     * inflationIndices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.InflationIndices }
     *     
     */
    public CrossAssetModel.InflationIndices getInflationIndices() {
        return inflationIndices;
    }

    /**
     * inflationIndices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.InflationIndices }
     *     
     */
    public void setInflationIndices(CrossAssetModel.InflationIndices value) {
        this.inflationIndices = value;
    }

    /**
     * creditNames 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.CreditNames }
     *     
     */
    public CrossAssetModel.CreditNames getCreditNames() {
        return creditNames;
    }

    /**
     * creditNames 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.CreditNames }
     *     
     */
    public void setCreditNames(CrossAssetModel.CreditNames value) {
        this.creditNames = value;
    }

    /**
     * commodities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.Commodities }
     *     
     */
    public CrossAssetModel.Commodities getCommodities() {
        return commodities;
    }

    /**
     * commodities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.Commodities }
     *     
     */
    public void setCommodities(CrossAssetModel.Commodities value) {
        this.commodities = value;
    }

    /**
     * bootstrapTolerance 속성의 값을 가져옵니다.
     * 
     */
    public float getBootstrapTolerance() {
        return bootstrapTolerance;
    }

    /**
     * bootstrapTolerance 속성의 값을 설정합니다.
     * 
     */
    public void setBootstrapTolerance(float value) {
        this.bootstrapTolerance = value;
    }

    /**
     * measure 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasure() {
        return measure;
    }

    /**
     * measure 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasure(String value) {
        this.measure = value;
    }

    /**
     * discretization 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DiscretizationType }
     *     
     */
    public DiscretizationType getDiscretization() {
        return discretization;
    }

    /**
     * discretization 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscretizationType }
     *     
     */
    public void setDiscretization(DiscretizationType value) {
        this.discretization = value;
    }

    /**
     * salvagingAlgorithm 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SalvagingAlgoType }
     *     
     */
    public SalvagingAlgoType getSalvagingAlgorithm() {
        return salvagingAlgorithm;
    }

    /**
     * salvagingAlgorithm 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SalvagingAlgoType }
     *     
     */
    public void setSalvagingAlgorithm(SalvagingAlgoType value) {
        this.salvagingAlgorithm = value;
    }

    /**
     * integrationPolicy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntegrationPolicy() {
        return integrationPolicy;
    }

    /**
     * integrationPolicy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntegrationPolicy(String value) {
        this.integrationPolicy = value;
    }

    /**
     * piecewiseIntegration 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPiecewiseIntegration() {
        return piecewiseIntegration;
    }

    /**
     * piecewiseIntegration 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPiecewiseIntegration(String value) {
        this.piecewiseIntegration = value;
    }

    /**
     * interestRateModels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.InterestRateModels }
     *     
     */
    public CrossAssetModel.InterestRateModels getInterestRateModels() {
        return interestRateModels;
    }

    /**
     * interestRateModels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.InterestRateModels }
     *     
     */
    public void setInterestRateModels(CrossAssetModel.InterestRateModels value) {
        this.interestRateModels = value;
    }

    /**
     * foreignExchangeModels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.ForeignExchangeModels }
     *     
     */
    public CrossAssetModel.ForeignExchangeModels getForeignExchangeModels() {
        return foreignExchangeModels;
    }

    /**
     * foreignExchangeModels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.ForeignExchangeModels }
     *     
     */
    public void setForeignExchangeModels(CrossAssetModel.ForeignExchangeModels value) {
        this.foreignExchangeModels = value;
    }

    /**
     * equityModels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.EquityModels }
     *     
     */
    public CrossAssetModel.EquityModels getEquityModels() {
        return equityModels;
    }

    /**
     * equityModels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.EquityModels }
     *     
     */
    public void setEquityModels(CrossAssetModel.EquityModels value) {
        this.equityModels = value;
    }

    /**
     * inflationIndexModels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.InflationIndexModels }
     *     
     */
    public CrossAssetModel.InflationIndexModels getInflationIndexModels() {
        return inflationIndexModels;
    }

    /**
     * inflationIndexModels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.InflationIndexModels }
     *     
     */
    public void setInflationIndexModels(CrossAssetModel.InflationIndexModels value) {
        this.inflationIndexModels = value;
    }

    /**
     * creditModels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.CreditModels }
     *     
     */
    public CrossAssetModel.CreditModels getCreditModels() {
        return creditModels;
    }

    /**
     * creditModels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.CreditModels }
     *     
     */
    public void setCreditModels(CrossAssetModel.CreditModels value) {
        this.creditModels = value;
    }

    /**
     * commodityModels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.CommodityModels }
     *     
     */
    public CrossAssetModel.CommodityModels getCommodityModels() {
        return commodityModels;
    }

    /**
     * commodityModels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.CommodityModels }
     *     
     */
    public void setCommodityModels(CrossAssetModel.CommodityModels value) {
        this.commodityModels = value;
    }

    /**
     * creditStates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.CreditStates }
     *     
     */
    public CrossAssetModel.CreditStates getCreditStates() {
        return creditStates;
    }

    /**
     * creditStates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.CreditStates }
     *     
     */
    public void setCreditStates(CrossAssetModel.CreditStates value) {
        this.creditStates = value;
    }

    /**
     * instantaneousCorrelations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel.InstantaneousCorrelations }
     *     
     */
    public CrossAssetModel.InstantaneousCorrelations getInstantaneousCorrelations() {
        return instantaneousCorrelations;
    }

    /**
     * instantaneousCorrelations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel.InstantaneousCorrelations }
     *     
     */
    public void setInstantaneousCorrelations(CrossAssetModel.InstantaneousCorrelations value) {
        this.instantaneousCorrelations = value;
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
     *         &lt;element name="Commodity" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "commodity"
    })
    public static class Commodities {

        @XmlElement(name = "Commodity")
        protected List<String> commodity;

        /**
         * Gets the value of the commodity property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the commodity property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCommodity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCommodity() {
            if (commodity == null) {
                commodity = new ArrayList<String>();
            }
            return this.commodity;
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
     *         &lt;element name="CommoditySchwartz" type="{}commoditySchwartz" maxOccurs="unbounded" minOccurs="0"/>
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
        "commoditySchwartz"
    })
    public static class CommodityModels {

        @XmlElement(name = "CommoditySchwartz")
        protected List<CommoditySchwartz> commoditySchwartz;

        /**
         * Gets the value of the commoditySchwartz property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the commoditySchwartz property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCommoditySchwartz().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CommoditySchwartz }
         * 
         * 
         */
        public List<CommoditySchwartz> getCommoditySchwartz() {
            if (commoditySchwartz == null) {
                commoditySchwartz = new ArrayList<CommoditySchwartz>();
            }
            return this.commoditySchwartz;
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
     *         &lt;choice maxOccurs="unbounded" minOccurs="0">
     *           &lt;element name="LGM" type="{}crlgm"/>
     *           &lt;element name="CIR" type="{}cir"/>
     *         &lt;/choice>
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
        "lgmOrCIR"
    })
    public static class CreditModels {

        @XmlElements({
            @XmlElement(name = "LGM", type = Crlgm.class),
            @XmlElement(name = "CIR", type = Cir.class)
        })
        protected List<Object> lgmOrCIR;

        /**
         * Gets the value of the lgmOrCIR property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the lgmOrCIR property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLGMOrCIR().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Crlgm }
         * {@link Cir }
         * 
         * 
         */
        public List<Object> getLGMOrCIR() {
            if (lgmOrCIR == null) {
                lgmOrCIR = new ArrayList<Object>();
            }
            return this.lgmOrCIR;
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
     *         &lt;element name="CreditName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "creditName"
    })
    public static class CreditNames {

        @XmlElement(name = "CreditName")
        protected List<String> creditName;

        /**
         * Gets the value of the creditName property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the creditName property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCreditName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCreditName() {
            if (creditName == null) {
                creditName = new ArrayList<String>();
            }
            return this.creditName;
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
     *         &lt;element name="NumberOfFactors" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
        "numberOfFactors"
    })
    public static class CreditStates {

        @XmlElement(name = "NumberOfFactors", required = true)
        protected BigInteger numberOfFactors;

        /**
         * numberOfFactors 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNumberOfFactors() {
            return numberOfFactors;
        }

        /**
         * numberOfFactors 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNumberOfFactors(BigInteger value) {
            this.numberOfFactors = value;
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
     *         &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded"/>
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
        "currency"
    })
    public static class Currencies {

        @XmlElement(name = "Currency", required = true)
        @XmlSchemaType(name = "string")
        protected List<CurrencyCode> currency;

        /**
         * Gets the value of the currency property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the currency property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCurrency().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CurrencyCode }
         * 
         * 
         */
        public List<CurrencyCode> getCurrency() {
            if (currency == null) {
                currency = new ArrayList<CurrencyCode>();
            }
            return this.currency;
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
     *         &lt;element name="Equity" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "equity"
    })
    public static class Equities {

        @XmlElement(name = "Equity")
        protected List<String> equity;

        /**
         * Gets the value of the equity property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the equity property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEquity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getEquity() {
            if (equity == null) {
                equity = new ArrayList<String>();
            }
            return this.equity;
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
     *         &lt;element name="CrossAssetLGM" type="{}crossAssetLGM" maxOccurs="unbounded" minOccurs="0"/>
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
        "crossAssetLGM"
    })
    public static class EquityModels {

        @XmlElement(name = "CrossAssetLGM")
        protected List<CrossAssetLGM> crossAssetLGM;

        /**
         * Gets the value of the crossAssetLGM property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the crossAssetLGM property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCrossAssetLGM().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CrossAssetLGM }
         * 
         * 
         */
        public List<CrossAssetLGM> getCrossAssetLGM() {
            if (crossAssetLGM == null) {
                crossAssetLGM = new ArrayList<CrossAssetLGM>();
            }
            return this.crossAssetLGM;
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
     *         &lt;element name="CrossCcyLGM" type="{}crossCurrencyLGM" maxOccurs="unbounded" minOccurs="0"/>
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
        "crossCcyLGM"
    })
    public static class ForeignExchangeModels {

        @XmlElement(name = "CrossCcyLGM")
        protected List<CrossCurrencyLGM> crossCcyLGM;

        /**
         * Gets the value of the crossCcyLGM property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the crossCcyLGM property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCrossCcyLGM().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CrossCurrencyLGM }
         * 
         * 
         */
        public List<CrossCurrencyLGM> getCrossCcyLGM() {
            if (crossCcyLGM == null) {
                crossCcyLGM = new ArrayList<CrossCurrencyLGM>();
            }
            return this.crossCcyLGM;
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
     *         &lt;choice maxOccurs="unbounded" minOccurs="0">
     *           &lt;element name="LGM" type="{}lgm"/>
     *           &lt;element name="JarrowYildirim" type="{}jarrowYildrim"/>
     *           &lt;element name="DodgsonKainth" type="{}dodgsonKainth"/>
     *         &lt;/choice>
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
        "lgmOrJarrowYildirimOrDodgsonKainth"
    })
    public static class InflationIndexModels {

        @XmlElements({
            @XmlElement(name = "LGM", type = Lgm.class),
            @XmlElement(name = "JarrowYildirim", type = JarrowYildrim.class),
            @XmlElement(name = "DodgsonKainth", type = DodgsonKainth.class)
        })
        protected List<Object> lgmOrJarrowYildirimOrDodgsonKainth;

        /**
         * Gets the value of the lgmOrJarrowYildirimOrDodgsonKainth property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the lgmOrJarrowYildirimOrDodgsonKainth property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLGMOrJarrowYildirimOrDodgsonKainth().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Lgm }
         * {@link JarrowYildrim }
         * {@link DodgsonKainth }
         * 
         * 
         */
        public List<Object> getLGMOrJarrowYildirimOrDodgsonKainth() {
            if (lgmOrJarrowYildirimOrDodgsonKainth == null) {
                lgmOrJarrowYildirimOrDodgsonKainth = new ArrayList<Object>();
            }
            return this.lgmOrJarrowYildirimOrDodgsonKainth;
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
     *         &lt;element name="InflationIndex" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inflationIndex"
    })
    public static class InflationIndices {

        @XmlElement(name = "InflationIndex")
        protected List<String> inflationIndex;

        /**
         * Gets the value of the inflationIndex property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inflationIndex property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInflationIndex().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getInflationIndex() {
            if (inflationIndex == null) {
                inflationIndex = new ArrayList<String>();
            }
            return this.inflationIndex;
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
     *         &lt;element name="Correlation" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;>correlationValue">
     *                 &lt;attribute name="factor1" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="factor2" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="index1" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="index2" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    public static class InstantaneousCorrelations {

        @XmlElement(name = "Correlation")
        protected List<CrossAssetModel.InstantaneousCorrelations.Correlation> correlation;

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
         * {@link CrossAssetModel.InstantaneousCorrelations.Correlation }
         * 
         * 
         */
        public List<CrossAssetModel.InstantaneousCorrelations.Correlation> getCorrelation() {
            if (correlation == null) {
                correlation = new ArrayList<CrossAssetModel.InstantaneousCorrelations.Correlation>();
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
         *     &lt;extension base="&lt;>correlationValue">
         *       &lt;attribute name="factor1" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="factor2" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="index1" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="index2" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            protected double value;
            @XmlAttribute(name = "factor1", required = true)
            protected String factor1;
            @XmlAttribute(name = "factor2", required = true)
            protected String factor2;
            @XmlAttribute(name = "index1")
            protected String index1;
            @XmlAttribute(name = "index2")
            protected String index2;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             */
            public double getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             */
            public void setValue(double value) {
                this.value = value;
            }

            /**
             * factor1 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFactor1() {
                return factor1;
            }

            /**
             * factor1 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFactor1(String value) {
                this.factor1 = value;
            }

            /**
             * factor2 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFactor2() {
                return factor2;
            }

            /**
             * factor2 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFactor2(String value) {
                this.factor2 = value;
            }

            /**
             * index1 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIndex1() {
                return index1;
            }

            /**
             * index1 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIndex1(String value) {
                this.index1 = value;
            }

            /**
             * index2 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIndex2() {
                return index2;
            }

            /**
             * index2 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIndex2(String value) {
                this.index2 = value;
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
     *       &lt;choice>
     *         &lt;sequence>
     *           &lt;element name="LGM" type="{}lgm" maxOccurs="unbounded"/>
     *         &lt;/sequence>
     *         &lt;sequence>
     *           &lt;element name="HWModel" type="{}hw" maxOccurs="unbounded"/>
     *         &lt;/sequence>
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
        "lgm",
        "hwModel"
    })
    public static class InterestRateModels {

        @XmlElement(name = "LGM")
        protected List<Lgm> lgm;
        @XmlElement(name = "HWModel")
        protected List<Hw> hwModel;

        /**
         * Gets the value of the lgm property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the lgm property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLGM().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Lgm }
         * 
         * 
         */
        public List<Lgm> getLGM() {
            if (lgm == null) {
                lgm = new ArrayList<Lgm>();
            }
            return this.lgm;
        }

        /**
         * Gets the value of the hwModel property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the hwModel property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHWModel().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Hw }
         * 
         * 
         */
        public List<Hw> getHWModel() {
            if (hwModel == null) {
                hwModel = new ArrayList<Hw>();
            }
            return this.hwModel;
        }

    }

}
