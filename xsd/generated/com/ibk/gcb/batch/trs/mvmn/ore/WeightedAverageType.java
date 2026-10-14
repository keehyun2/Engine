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
 * <p>weightedAverageType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="weightedAverageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferenceCurve1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferenceCurve2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Weight1" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Weight2" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "weightedAverageType", propOrder = {
    "type",
    "referenceCurve1",
    "referenceCurve2",
    "weight1",
    "weight2"
})
public class WeightedAverageType {

    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "ReferenceCurve1", required = true)
    protected String referenceCurve1;
    @XmlElement(name = "ReferenceCurve2", required = true)
    protected String referenceCurve2;
    @XmlElement(name = "Weight1")
    protected float weight1;
    @XmlElement(name = "Weight2")
    protected float weight2;

    /**
     * type 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * type 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * referenceCurve1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceCurve1() {
        return referenceCurve1;
    }

    /**
     * referenceCurve1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceCurve1(String value) {
        this.referenceCurve1 = value;
    }

    /**
     * referenceCurve2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceCurve2() {
        return referenceCurve2;
    }

    /**
     * referenceCurve2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceCurve2(String value) {
        this.referenceCurve2 = value;
    }

    /**
     * weight1 속성의 값을 가져옵니다.
     * 
     */
    public float getWeight1() {
        return weight1;
    }

    /**
     * weight1 속성의 값을 설정합니다.
     * 
     */
    public void setWeight1(float value) {
        this.weight1 = value;
    }

    /**
     * weight2 속성의 값을 가져옵니다.
     * 
     */
    public float getWeight2() {
        return weight2;
    }

    /**
     * weight2 속성의 값을 설정합니다.
     * 
     */
    public void setWeight2(float value) {
        this.weight2 = value;
    }

}
