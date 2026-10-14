//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bootstrapConfigType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="bootstrapConfigType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Accuracy" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="GlobalAccuracy" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DontThrow" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MaxAttempts" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="MaxFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="MinFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DontThrowSteps" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="Global" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SmoothnessLambda" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bootstrapConfigType", propOrder = {

})
public class BootstrapConfigType {

    @XmlElement(name = "Accuracy")
    protected Double accuracy;
    @XmlElement(name = "GlobalAccuracy")
    protected Double globalAccuracy;
    @XmlElement(name = "DontThrow")
    protected Boolean dontThrow;
    @XmlElement(name = "MaxAttempts")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maxAttempts;
    @XmlElement(name = "MaxFactor")
    protected Double maxFactor;
    @XmlElement(name = "MinFactor")
    protected Double minFactor;
    @XmlElement(name = "DontThrowSteps")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger dontThrowSteps;
    @XmlElement(name = "Global")
    protected Boolean global;
    @XmlElement(name = "SmoothnessLambda")
    protected Double smoothnessLambda;

    /**
     * accuracy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAccuracy() {
        return accuracy;
    }

    /**
     * accuracy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAccuracy(Double value) {
        this.accuracy = value;
    }

    /**
     * globalAccuracy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGlobalAccuracy() {
        return globalAccuracy;
    }

    /**
     * globalAccuracy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGlobalAccuracy(Double value) {
        this.globalAccuracy = value;
    }

    /**
     * dontThrow 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDontThrow() {
        return dontThrow;
    }

    /**
     * dontThrow 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDontThrow(Boolean value) {
        this.dontThrow = value;
    }

    /**
     * maxAttempts 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * maxAttempts 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxAttempts(BigInteger value) {
        this.maxAttempts = value;
    }

    /**
     * maxFactor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaxFactor() {
        return maxFactor;
    }

    /**
     * maxFactor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaxFactor(Double value) {
        this.maxFactor = value;
    }

    /**
     * minFactor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMinFactor() {
        return minFactor;
    }

    /**
     * minFactor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMinFactor(Double value) {
        this.minFactor = value;
    }

    /**
     * dontThrowSteps 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDontThrowSteps() {
        return dontThrowSteps;
    }

    /**
     * dontThrowSteps 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDontThrowSteps(BigInteger value) {
        this.dontThrowSteps = value;
    }

    /**
     * global 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGlobal() {
        return global;
    }

    /**
     * global 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGlobal(Boolean value) {
        this.global = value;
    }

    /**
     * smoothnessLambda 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSmoothnessLambda() {
        return smoothnessLambda;
    }

    /**
     * smoothnessLambda 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSmoothnessLambda(Double value) {
        this.smoothnessLambda = value;
    }

}
