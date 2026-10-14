//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>calibrationConfiguration complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="calibrationConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RmseTolerance" type="{}positiveDecimal" minOccurs="0"/>
 *         &lt;element name="MaxIterations" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="Constraints" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BoundaryConstraint" type="{}boundaryConstraint" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "calibrationConfiguration", propOrder = {
    "rmseTolerance",
    "maxIterations",
    "constraints"
})
public class CalibrationConfiguration {

    @XmlElement(name = "RmseTolerance")
    protected BigDecimal rmseTolerance;
    @XmlElement(name = "MaxIterations")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maxIterations;
    @XmlElement(name = "Constraints")
    protected CalibrationConfiguration.Constraints constraints;

    /**
     * rmseTolerance 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRmseTolerance() {
        return rmseTolerance;
    }

    /**
     * rmseTolerance 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRmseTolerance(BigDecimal value) {
        this.rmseTolerance = value;
    }

    /**
     * maxIterations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxIterations() {
        return maxIterations;
    }

    /**
     * maxIterations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxIterations(BigInteger value) {
        this.maxIterations = value;
    }

    /**
     * constraints 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CalibrationConfiguration.Constraints }
     *     
     */
    public CalibrationConfiguration.Constraints getConstraints() {
        return constraints;
    }

    /**
     * constraints 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CalibrationConfiguration.Constraints }
     *     
     */
    public void setConstraints(CalibrationConfiguration.Constraints value) {
        this.constraints = value;
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
     *         &lt;element name="BoundaryConstraint" type="{}boundaryConstraint" maxOccurs="unbounded" minOccurs="0"/>
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
        "boundaryConstraint"
    })
    public static class Constraints {

        @XmlElement(name = "BoundaryConstraint")
        protected List<BoundaryConstraint> boundaryConstraint;

        /**
         * Gets the value of the boundaryConstraint property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the boundaryConstraint property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBoundaryConstraint().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BoundaryConstraint }
         * 
         * 
         */
        public List<BoundaryConstraint> getBoundaryConstraint() {
            if (boundaryConstraint == null) {
                boundaryConstraint = new ArrayList<BoundaryConstraint>();
            }
            return this.boundaryConstraint;
        }

    }

}
