//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>configurationType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="configurationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="YieldCurvesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiscountingCurvesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndexForwardingCurvesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SwapIndexCurvesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZeroInflationIndexCurvesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZeroInflationCapFloorVolatilitiesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="YYInflationIndexCurvesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FxSpotsId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BaseCorrelationsId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FxVolatilitiesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SwaptionVolatilitiesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="YieldVolatilitiesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CapFloorVolatilitiesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CDSVolatilitiesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultCurvesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="YYInflationCapFloorVolatilitiesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EquityCurvesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EquityVolatilitiesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecuritiesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommodityCurvesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommodityVolatilitiesId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CorrelationsId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "configurationType", propOrder = {

})
public class ConfigurationType {

    @XmlElement(name = "YieldCurvesId")
    protected String yieldCurvesId;
    @XmlElement(name = "DiscountingCurvesId")
    protected String discountingCurvesId;
    @XmlElement(name = "IndexForwardingCurvesId")
    protected String indexForwardingCurvesId;
    @XmlElement(name = "SwapIndexCurvesId")
    protected String swapIndexCurvesId;
    @XmlElement(name = "ZeroInflationIndexCurvesId")
    protected String zeroInflationIndexCurvesId;
    @XmlElement(name = "ZeroInflationCapFloorVolatilitiesId")
    protected String zeroInflationCapFloorVolatilitiesId;
    @XmlElement(name = "YYInflationIndexCurvesId")
    protected String yyInflationIndexCurvesId;
    @XmlElement(name = "FxSpotsId")
    protected String fxSpotsId;
    @XmlElement(name = "BaseCorrelationsId")
    protected String baseCorrelationsId;
    @XmlElement(name = "FxVolatilitiesId")
    protected String fxVolatilitiesId;
    @XmlElement(name = "SwaptionVolatilitiesId")
    protected String swaptionVolatilitiesId;
    @XmlElement(name = "YieldVolatilitiesId")
    protected String yieldVolatilitiesId;
    @XmlElement(name = "CapFloorVolatilitiesId")
    protected String capFloorVolatilitiesId;
    @XmlElement(name = "CDSVolatilitiesId")
    protected String cdsVolatilitiesId;
    @XmlElement(name = "DefaultCurvesId")
    protected String defaultCurvesId;
    @XmlElement(name = "YYInflationCapFloorVolatilitiesId")
    protected String yyInflationCapFloorVolatilitiesId;
    @XmlElement(name = "EquityCurvesId")
    protected String equityCurvesId;
    @XmlElement(name = "EquityVolatilitiesId")
    protected String equityVolatilitiesId;
    @XmlElement(name = "SecuritiesId")
    protected String securitiesId;
    @XmlElement(name = "CommodityCurvesId")
    protected String commodityCurvesId;
    @XmlElement(name = "CommodityVolatilitiesId")
    protected String commodityVolatilitiesId;
    @XmlElement(name = "CorrelationsId")
    protected String correlationsId;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * yieldCurvesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYieldCurvesId() {
        return yieldCurvesId;
    }

    /**
     * yieldCurvesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYieldCurvesId(String value) {
        this.yieldCurvesId = value;
    }

    /**
     * discountingCurvesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountingCurvesId() {
        return discountingCurvesId;
    }

    /**
     * discountingCurvesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountingCurvesId(String value) {
        this.discountingCurvesId = value;
    }

    /**
     * indexForwardingCurvesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexForwardingCurvesId() {
        return indexForwardingCurvesId;
    }

    /**
     * indexForwardingCurvesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexForwardingCurvesId(String value) {
        this.indexForwardingCurvesId = value;
    }

    /**
     * swapIndexCurvesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwapIndexCurvesId() {
        return swapIndexCurvesId;
    }

    /**
     * swapIndexCurvesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwapIndexCurvesId(String value) {
        this.swapIndexCurvesId = value;
    }

    /**
     * zeroInflationIndexCurvesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZeroInflationIndexCurvesId() {
        return zeroInflationIndexCurvesId;
    }

    /**
     * zeroInflationIndexCurvesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZeroInflationIndexCurvesId(String value) {
        this.zeroInflationIndexCurvesId = value;
    }

    /**
     * zeroInflationCapFloorVolatilitiesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZeroInflationCapFloorVolatilitiesId() {
        return zeroInflationCapFloorVolatilitiesId;
    }

    /**
     * zeroInflationCapFloorVolatilitiesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZeroInflationCapFloorVolatilitiesId(String value) {
        this.zeroInflationCapFloorVolatilitiesId = value;
    }

    /**
     * yyInflationIndexCurvesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYYInflationIndexCurvesId() {
        return yyInflationIndexCurvesId;
    }

    /**
     * yyInflationIndexCurvesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYYInflationIndexCurvesId(String value) {
        this.yyInflationIndexCurvesId = value;
    }

    /**
     * fxSpotsId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFxSpotsId() {
        return fxSpotsId;
    }

    /**
     * fxSpotsId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFxSpotsId(String value) {
        this.fxSpotsId = value;
    }

    /**
     * baseCorrelationsId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseCorrelationsId() {
        return baseCorrelationsId;
    }

    /**
     * baseCorrelationsId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseCorrelationsId(String value) {
        this.baseCorrelationsId = value;
    }

    /**
     * fxVolatilitiesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFxVolatilitiesId() {
        return fxVolatilitiesId;
    }

    /**
     * fxVolatilitiesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFxVolatilitiesId(String value) {
        this.fxVolatilitiesId = value;
    }

    /**
     * swaptionVolatilitiesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwaptionVolatilitiesId() {
        return swaptionVolatilitiesId;
    }

    /**
     * swaptionVolatilitiesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwaptionVolatilitiesId(String value) {
        this.swaptionVolatilitiesId = value;
    }

    /**
     * yieldVolatilitiesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYieldVolatilitiesId() {
        return yieldVolatilitiesId;
    }

    /**
     * yieldVolatilitiesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYieldVolatilitiesId(String value) {
        this.yieldVolatilitiesId = value;
    }

    /**
     * capFloorVolatilitiesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapFloorVolatilitiesId() {
        return capFloorVolatilitiesId;
    }

    /**
     * capFloorVolatilitiesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapFloorVolatilitiesId(String value) {
        this.capFloorVolatilitiesId = value;
    }

    /**
     * cdsVolatilitiesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDSVolatilitiesId() {
        return cdsVolatilitiesId;
    }

    /**
     * cdsVolatilitiesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDSVolatilitiesId(String value) {
        this.cdsVolatilitiesId = value;
    }

    /**
     * defaultCurvesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultCurvesId() {
        return defaultCurvesId;
    }

    /**
     * defaultCurvesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultCurvesId(String value) {
        this.defaultCurvesId = value;
    }

    /**
     * yyInflationCapFloorVolatilitiesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYYInflationCapFloorVolatilitiesId() {
        return yyInflationCapFloorVolatilitiesId;
    }

    /**
     * yyInflationCapFloorVolatilitiesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYYInflationCapFloorVolatilitiesId(String value) {
        this.yyInflationCapFloorVolatilitiesId = value;
    }

    /**
     * equityCurvesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquityCurvesId() {
        return equityCurvesId;
    }

    /**
     * equityCurvesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquityCurvesId(String value) {
        this.equityCurvesId = value;
    }

    /**
     * equityVolatilitiesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquityVolatilitiesId() {
        return equityVolatilitiesId;
    }

    /**
     * equityVolatilitiesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquityVolatilitiesId(String value) {
        this.equityVolatilitiesId = value;
    }

    /**
     * securitiesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecuritiesId() {
        return securitiesId;
    }

    /**
     * securitiesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecuritiesId(String value) {
        this.securitiesId = value;
    }

    /**
     * commodityCurvesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommodityCurvesId() {
        return commodityCurvesId;
    }

    /**
     * commodityCurvesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommodityCurvesId(String value) {
        this.commodityCurvesId = value;
    }

    /**
     * commodityVolatilitiesId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommodityVolatilitiesId() {
        return commodityVolatilitiesId;
    }

    /**
     * commodityVolatilitiesId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommodityVolatilitiesId(String value) {
        this.commodityVolatilitiesId = value;
    }

    /**
     * correlationsId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationsId() {
        return correlationsId;
    }

    /**
     * correlationsId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationsId(String value) {
        this.correlationsId = value;
    }

    /**
     * id 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * id 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
