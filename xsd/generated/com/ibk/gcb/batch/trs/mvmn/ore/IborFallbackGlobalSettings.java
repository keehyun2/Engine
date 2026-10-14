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
 * <p>iborFallbackGlobalSettings complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="iborFallbackGlobalSettings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="EnableIborFallbacks" type="{}bool"/>
 *         &lt;element name="UseRfrCurveInTodaysMarket" type="{}bool"/>
 *         &lt;element name="UseRfrCurveInSimulationMarket" type="{}bool"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iborFallbackGlobalSettings", propOrder = {

})
public class IborFallbackGlobalSettings {

    @XmlElement(name = "EnableIborFallbacks", required = true)
    protected String enableIborFallbacks;
    @XmlElement(name = "UseRfrCurveInTodaysMarket", required = true)
    protected String useRfrCurveInTodaysMarket;
    @XmlElement(name = "UseRfrCurveInSimulationMarket", required = true)
    protected String useRfrCurveInSimulationMarket;

    /**
     * enableIborFallbacks 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnableIborFallbacks() {
        return enableIborFallbacks;
    }

    /**
     * enableIborFallbacks 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableIborFallbacks(String value) {
        this.enableIborFallbacks = value;
    }

    /**
     * useRfrCurveInTodaysMarket 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseRfrCurveInTodaysMarket() {
        return useRfrCurveInTodaysMarket;
    }

    /**
     * useRfrCurveInTodaysMarket 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseRfrCurveInTodaysMarket(String value) {
        this.useRfrCurveInTodaysMarket = value;
    }

    /**
     * useRfrCurveInSimulationMarket 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseRfrCurveInSimulationMarket() {
        return useRfrCurveInSimulationMarket;
    }

    /**
     * useRfrCurveInSimulationMarket 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseRfrCurveInSimulationMarket(String value) {
        this.useRfrCurveInSimulationMarket = value;
    }

}
