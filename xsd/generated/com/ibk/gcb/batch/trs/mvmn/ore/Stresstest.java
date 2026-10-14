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
 * <p>stresstest complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="stresstest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ParShifts" type="{}stresstestparshifts" minOccurs="0"/>
 *         &lt;element name="DiscountCurves" type="{}discountcurves" minOccurs="0"/>
 *         &lt;element name="IndexCurves" type="{}indexcurves" minOccurs="0"/>
 *         &lt;element name="YieldCurves" type="{}yieldcurves" minOccurs="0"/>
 *         &lt;element name="FxSpots" type="{}fxspots" minOccurs="0"/>
 *         &lt;element name="FxVolatilities" type="{}stressfxvolatilities" minOccurs="0"/>
 *         &lt;element name="SwaptionVolatilities" type="{}swaptionvolatilities" minOccurs="0"/>
 *         &lt;element name="CapFloorVolatilities" type="{}stresscapfloorvolatilities" minOccurs="0"/>
 *         &lt;element name="EquitySpots" type="{}equityspots" minOccurs="0"/>
 *         &lt;element name="EquityVolatilities" type="{}equityvolatilities" minOccurs="0"/>
 *         &lt;element name="CommodityCurves" type="{}stresscommoditycurves" minOccurs="0"/>
 *         &lt;element name="CommodityVolatilities" type="{}stresscommodityvolatilities" minOccurs="0"/>
 *         &lt;element name="SecuritySpreads" type="{}securityspreads" minOccurs="0"/>
 *         &lt;element name="RecoveryRates" type="{}recoveryrates" minOccurs="0"/>
 *         &lt;element name="SurvivalProbabilities" type="{}survivalprobabilities" minOccurs="0"/>
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
@XmlType(name = "stresstest", propOrder = {

})
public class Stresstest {

    @XmlElement(name = "ParShifts")
    protected Stresstestparshifts parShifts;
    @XmlElement(name = "DiscountCurves")
    protected Discountcurves discountCurves;
    @XmlElement(name = "IndexCurves")
    protected Indexcurves indexCurves;
    @XmlElement(name = "YieldCurves")
    protected SensitivityYieldCurves yieldCurves;
    @XmlElement(name = "FxSpots")
    protected SensitivityFxSpots fxSpots;
    @XmlElement(name = "FxVolatilities")
    protected Stressfxvolatilities fxVolatilities;
    @XmlElement(name = "SwaptionVolatilities")
    protected SensitivitySwaptionVolatilities swaptionVolatilities;
    @XmlElement(name = "CapFloorVolatilities")
    protected Stresscapfloorvolatilities capFloorVolatilities;
    @XmlElement(name = "EquitySpots")
    protected Equityspots equitySpots;
    @XmlElement(name = "EquityVolatilities")
    protected SensitivityEquityVolatilities equityVolatilities;
    @XmlElement(name = "CommodityCurves")
    protected Stresscommoditycurves commodityCurves;
    @XmlElement(name = "CommodityVolatilities")
    protected Stresscommodityvolatilities commodityVolatilities;
    @XmlElement(name = "SecuritySpreads")
    protected Securityspreads securitySpreads;
    @XmlElement(name = "RecoveryRates")
    protected Recoveryrates recoveryRates;
    @XmlElement(name = "SurvivalProbabilities")
    protected Survivalprobabilities survivalProbabilities;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * parShifts 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Stresstestparshifts }
     *     
     */
    public Stresstestparshifts getParShifts() {
        return parShifts;
    }

    /**
     * parShifts 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Stresstestparshifts }
     *     
     */
    public void setParShifts(Stresstestparshifts value) {
        this.parShifts = value;
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
     *     {@link Stressfxvolatilities }
     *     
     */
    public Stressfxvolatilities getFxVolatilities() {
        return fxVolatilities;
    }

    /**
     * fxVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Stressfxvolatilities }
     *     
     */
    public void setFxVolatilities(Stressfxvolatilities value) {
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
     * capFloorVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Stresscapfloorvolatilities }
     *     
     */
    public Stresscapfloorvolatilities getCapFloorVolatilities() {
        return capFloorVolatilities;
    }

    /**
     * capFloorVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Stresscapfloorvolatilities }
     *     
     */
    public void setCapFloorVolatilities(Stresscapfloorvolatilities value) {
        this.capFloorVolatilities = value;
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
     * commodityCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Stresscommoditycurves }
     *     
     */
    public Stresscommoditycurves getCommodityCurves() {
        return commodityCurves;
    }

    /**
     * commodityCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Stresscommoditycurves }
     *     
     */
    public void setCommodityCurves(Stresscommoditycurves value) {
        this.commodityCurves = value;
    }

    /**
     * commodityVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Stresscommodityvolatilities }
     *     
     */
    public Stresscommodityvolatilities getCommodityVolatilities() {
        return commodityVolatilities;
    }

    /**
     * commodityVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Stresscommodityvolatilities }
     *     
     */
    public void setCommodityVolatilities(Stresscommodityvolatilities value) {
        this.commodityVolatilities = value;
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
     * recoveryRates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Recoveryrates }
     *     
     */
    public Recoveryrates getRecoveryRates() {
        return recoveryRates;
    }

    /**
     * recoveryRates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Recoveryrates }
     *     
     */
    public void setRecoveryRates(Recoveryrates value) {
        this.recoveryRates = value;
    }

    /**
     * survivalProbabilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Survivalprobabilities }
     *     
     */
    public Survivalprobabilities getSurvivalProbabilities() {
        return survivalProbabilities;
    }

    /**
     * survivalProbabilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Survivalprobabilities }
     *     
     */
    public void setSurvivalProbabilities(Survivalprobabilities value) {
        this.survivalProbabilities = value;
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
