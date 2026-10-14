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
 * <p>creditsimulation complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="creditsimulation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="TransitionMatrices" type="{}transitionmatrices"/>
 *         &lt;element name="Entities" type="{}entities"/>
 *         &lt;element name="NettingSetIds" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Risk" type="{}risk"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditsimulation", propOrder = {

})
public class Creditsimulation {

    @XmlElement(name = "TransitionMatrices", required = true)
    protected Transitionmatrices transitionMatrices;
    @XmlElement(name = "Entities", required = true)
    protected Entities entities;
    @XmlElement(name = "NettingSetIds", required = true)
    protected String nettingSetIds;
    @XmlElement(name = "Risk", required = true)
    protected Risk risk;

    /**
     * transitionMatrices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Transitionmatrices }
     *     
     */
    public Transitionmatrices getTransitionMatrices() {
        return transitionMatrices;
    }

    /**
     * transitionMatrices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Transitionmatrices }
     *     
     */
    public void setTransitionMatrices(Transitionmatrices value) {
        this.transitionMatrices = value;
    }

    /**
     * entities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Entities }
     *     
     */
    public Entities getEntities() {
        return entities;
    }

    /**
     * entities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Entities }
     *     
     */
    public void setEntities(Entities value) {
        this.entities = value;
    }

    /**
     * nettingSetIds 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNettingSetIds() {
        return nettingSetIds;
    }

    /**
     * nettingSetIds 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNettingSetIds(String value) {
        this.nettingSetIds = value;
    }

    /**
     * risk 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Risk }
     *     
     */
    public Risk getRisk() {
        return risk;
    }

    /**
     * risk 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Risk }
     *     
     */
    public void setRisk(Risk value) {
        this.risk = value;
    }

}
