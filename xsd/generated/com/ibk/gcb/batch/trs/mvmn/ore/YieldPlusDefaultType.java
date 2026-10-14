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
 * <p>yieldPlusDefaultType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="yieldPlusDefaultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferenceCurve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DefaultCurves">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DefaultCurve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Weights">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
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
@XmlType(name = "yieldPlusDefaultType", propOrder = {
    "type",
    "referenceCurve",
    "defaultCurves",
    "weights"
})
public class YieldPlusDefaultType {

    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "ReferenceCurve", required = true)
    protected String referenceCurve;
    @XmlElement(name = "DefaultCurves", required = true)
    protected YieldPlusDefaultType.DefaultCurves defaultCurves;
    @XmlElement(name = "Weights", required = true)
    protected YieldPlusDefaultType.Weights weights;

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
     * referenceCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceCurve() {
        return referenceCurve;
    }

    /**
     * referenceCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceCurve(String value) {
        this.referenceCurve = value;
    }

    /**
     * defaultCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link YieldPlusDefaultType.DefaultCurves }
     *     
     */
    public YieldPlusDefaultType.DefaultCurves getDefaultCurves() {
        return defaultCurves;
    }

    /**
     * defaultCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link YieldPlusDefaultType.DefaultCurves }
     *     
     */
    public void setDefaultCurves(YieldPlusDefaultType.DefaultCurves value) {
        this.defaultCurves = value;
    }

    /**
     * weights 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link YieldPlusDefaultType.Weights }
     *     
     */
    public YieldPlusDefaultType.Weights getWeights() {
        return weights;
    }

    /**
     * weights 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link YieldPlusDefaultType.Weights }
     *     
     */
    public void setWeights(YieldPlusDefaultType.Weights value) {
        this.weights = value;
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
     *         &lt;element name="DefaultCurve" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "defaultCurve"
    })
    public static class DefaultCurves {

        @XmlElement(name = "DefaultCurve", required = true)
        protected String defaultCurve;

        /**
         * defaultCurve 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDefaultCurve() {
            return defaultCurve;
        }

        /**
         * defaultCurve 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDefaultCurve(String value) {
            this.defaultCurve = value;
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
     *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
        "weight"
    })
    public static class Weights {

        @XmlElement(name = "Weight")
        protected float weight;

        /**
         * weight 속성의 값을 가져옵니다.
         * 
         */
        public float getWeight() {
            return weight;
        }

        /**
         * weight 속성의 값을 설정합니다.
         * 
         */
        public void setWeight(float value) {
            this.weight = value;
        }

    }

}
