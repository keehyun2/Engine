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
 * <p>ore complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="ore">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Setup" type="{}parameterListType"/>
 *         &lt;element name="Logging" type="{}parameterListType" minOccurs="0"/>
 *         &lt;element name="Markets" type="{}parameterListType" minOccurs="0"/>
 *         &lt;element name="Analytics" type="{}analyticsType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ore", propOrder = {

})
public class Ore {

    @XmlElement(name = "Setup", required = true)
    protected ParameterListType setup;
    @XmlElement(name = "Logging")
    protected ParameterListType logging;
    @XmlElement(name = "Markets")
    protected ParameterListType markets;
    @XmlElement(name = "Analytics", required = true)
    protected AnalyticsType analytics;

    /**
     * setup 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ParameterListType }
     *     
     */
    public ParameterListType getSetup() {
        return setup;
    }

    /**
     * setup 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterListType }
     *     
     */
    public void setSetup(ParameterListType value) {
        this.setup = value;
    }

    /**
     * logging 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ParameterListType }
     *     
     */
    public ParameterListType getLogging() {
        return logging;
    }

    /**
     * logging 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterListType }
     *     
     */
    public void setLogging(ParameterListType value) {
        this.logging = value;
    }

    /**
     * markets 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ParameterListType }
     *     
     */
    public ParameterListType getMarkets() {
        return markets;
    }

    /**
     * markets 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterListType }
     *     
     */
    public void setMarkets(ParameterListType value) {
        this.markets = value;
    }

    /**
     * analytics 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AnalyticsType }
     *     
     */
    public AnalyticsType getAnalytics() {
        return analytics;
    }

    /**
     * analytics 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AnalyticsType }
     *     
     */
    public void setAnalytics(AnalyticsType value) {
        this.analytics = value;
    }

}
