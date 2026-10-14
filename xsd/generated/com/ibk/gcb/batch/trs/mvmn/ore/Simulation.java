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
 * <p>simulation complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="simulation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Parameters" type="{}parameters" minOccurs="0"/>
 *         &lt;element name="CrossAssetModel" type="{}crossAssetModel" minOccurs="0"/>
 *         &lt;element name="Market" type="{}market" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simulation", propOrder = {

})
public class Simulation {

    @XmlElement(name = "Parameters")
    protected Parameters parameters;
    @XmlElement(name = "CrossAssetModel")
    protected CrossAssetModel crossAssetModel;
    @XmlElement(name = "Market")
    protected Market market;

    /**
     * parameters 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Parameters }
     *     
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * parameters 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Parameters }
     *     
     */
    public void setParameters(Parameters value) {
        this.parameters = value;
    }

    /**
     * crossAssetModel 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetModel }
     *     
     */
    public CrossAssetModel getCrossAssetModel() {
        return crossAssetModel;
    }

    /**
     * crossAssetModel 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetModel }
     *     
     */
    public void setCrossAssetModel(CrossAssetModel value) {
        this.crossAssetModel = value;
    }

    /**
     * market 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market }
     *     
     */
    public Market getMarket() {
        return market;
    }

    /**
     * market 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market }
     *     
     */
    public void setMarket(Market value) {
        this.market = value;
    }

}
