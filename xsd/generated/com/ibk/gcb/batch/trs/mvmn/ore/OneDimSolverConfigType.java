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
 * <p>oneDimSolverConfigType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="oneDimSolverConfigType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MaxEvaluations" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="InitialGuess" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Accuracy" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;choice>
 *           &lt;element name="MinMax" type="{}minMaxType"/>
 *           &lt;element name="Step" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;/choice>
 *         &lt;element name="LowerBound" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="UpperBound" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oneDimSolverConfigType", propOrder = {
    "maxEvaluations",
    "initialGuess",
    "accuracy",
    "minMax",
    "step",
    "lowerBound",
    "upperBound"
})
public class OneDimSolverConfigType {

    @XmlElement(name = "MaxEvaluations", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maxEvaluations;
    @XmlElement(name = "InitialGuess")
    protected double initialGuess;
    @XmlElement(name = "Accuracy")
    protected double accuracy;
    @XmlElement(name = "MinMax")
    protected MinMaxType minMax;
    @XmlElement(name = "Step")
    protected Double step;
    @XmlElement(name = "LowerBound")
    protected Double lowerBound;
    @XmlElement(name = "UpperBound")
    protected Double upperBound;

    /**
     * maxEvaluations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxEvaluations() {
        return maxEvaluations;
    }

    /**
     * maxEvaluations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxEvaluations(BigInteger value) {
        this.maxEvaluations = value;
    }

    /**
     * initialGuess 속성의 값을 가져옵니다.
     * 
     */
    public double getInitialGuess() {
        return initialGuess;
    }

    /**
     * initialGuess 속성의 값을 설정합니다.
     * 
     */
    public void setInitialGuess(double value) {
        this.initialGuess = value;
    }

    /**
     * accuracy 속성의 값을 가져옵니다.
     * 
     */
    public double getAccuracy() {
        return accuracy;
    }

    /**
     * accuracy 속성의 값을 설정합니다.
     * 
     */
    public void setAccuracy(double value) {
        this.accuracy = value;
    }

    /**
     * minMax 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MinMaxType }
     *     
     */
    public MinMaxType getMinMax() {
        return minMax;
    }

    /**
     * minMax 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MinMaxType }
     *     
     */
    public void setMinMax(MinMaxType value) {
        this.minMax = value;
    }

    /**
     * step 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getStep() {
        return step;
    }

    /**
     * step 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setStep(Double value) {
        this.step = value;
    }

    /**
     * lowerBound 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLowerBound() {
        return lowerBound;
    }

    /**
     * lowerBound 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLowerBound(Double value) {
        this.lowerBound = value;
    }

    /**
     * upperBound 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getUpperBound() {
        return upperBound;
    }

    /**
     * upperBound 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setUpperBound(Double value) {
        this.upperBound = value;
    }

}
