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
 * <p>volatilityConfig complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="volatilityConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Constant" type="{}constantVolatilityConfig" minOccurs="0"/>
 *         &lt;element name="Curve" type="{}volatilityCurveConfig" minOccurs="0"/>
 *         &lt;element name="StrikeSurface" type="{}volatilityStrikeSurfaceConfig" minOccurs="0"/>
 *         &lt;element name="MoneynessSurface" type="{}volatilityMoneynessSurfaceConfig" minOccurs="0"/>
 *         &lt;element name="DeltaSurface" type="{}volatilityDeltaSurfaceConfig" minOccurs="0"/>
 *         &lt;element name="ApoFutureSurface" type="{}volatilityApoFutureSurfaceConfig" minOccurs="0"/>
 *         &lt;element name="ProxySurface" type="{}proxySurface" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "volatilityConfig", propOrder = {

})
public class VolatilityConfig {

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

}
