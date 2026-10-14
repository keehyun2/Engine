//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>stressfxvolatility complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="stressfxvolatility">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShiftType" type="{}shiftTypeEntry" maxOccurs="unbounded"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="Shifts" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *             &lt;element name="ShiftExpiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="WeightedShifts">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                     &lt;all>
 *                       &lt;element name="WeightingSchema" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                       &lt;element name="Shift" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                       &lt;element name="Tenor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                       &lt;element name="ShiftWeights" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                       &lt;element name="WeightTenors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                     &lt;/all>
 *                   &lt;/restriction>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="ccypair" use="required" type="{}currencyPair" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stressfxvolatility", propOrder = {
    "shiftType",
    "shifts",
    "shiftExpiries",
    "weightedShifts"
})
public class Stressfxvolatility {

    @XmlElement(name = "ShiftType", required = true)
    protected List<ShiftTypeEntry> shiftType;
    @XmlElement(name = "Shifts")
    protected String shifts;
    @XmlElement(name = "ShiftExpiries")
    protected String shiftExpiries;
    @XmlElement(name = "WeightedShifts")
    protected Stressfxvolatility.WeightedShifts weightedShifts;
    @XmlAttribute(name = "ccypair", required = true)
    protected String ccypair;

    /**
     * Gets the value of the shiftType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shiftType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShiftType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShiftTypeEntry }
     * 
     * 
     */
    public List<ShiftTypeEntry> getShiftType() {
        if (shiftType == null) {
            shiftType = new ArrayList<ShiftTypeEntry>();
        }
        return this.shiftType;
    }

    /**
     * shifts 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShifts() {
        return shifts;
    }

    /**
     * shifts 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShifts(String value) {
        this.shifts = value;
    }

    /**
     * shiftExpiries 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShiftExpiries() {
        return shiftExpiries;
    }

    /**
     * shiftExpiries 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShiftExpiries(String value) {
        this.shiftExpiries = value;
    }

    /**
     * weightedShifts 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Stressfxvolatility.WeightedShifts }
     *     
     */
    public Stressfxvolatility.WeightedShifts getWeightedShifts() {
        return weightedShifts;
    }

    /**
     * weightedShifts 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Stressfxvolatility.WeightedShifts }
     *     
     */
    public void setWeightedShifts(Stressfxvolatility.WeightedShifts value) {
        this.weightedShifts = value;
    }

    /**
     * ccypair 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcypair() {
        return ccypair;
    }

    /**
     * ccypair 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcypair(String value) {
        this.ccypair = value;
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
     *       &lt;all>
     *         &lt;element name="WeightingSchema" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Shift" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Tenor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ShiftWeights" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="WeightTenors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class WeightedShifts {

        @XmlElement(name = "WeightingSchema", required = true)
        protected String weightingSchema;
        @XmlElement(name = "Shift", required = true)
        protected String shift;
        @XmlElement(name = "Tenor", required = true)
        protected String tenor;
        @XmlElement(name = "ShiftWeights")
        protected String shiftWeights;
        @XmlElement(name = "WeightTenors")
        protected String weightTenors;

        /**
         * weightingSchema 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWeightingSchema() {
            return weightingSchema;
        }

        /**
         * weightingSchema 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWeightingSchema(String value) {
            this.weightingSchema = value;
        }

        /**
         * shift 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getShift() {
            return shift;
        }

        /**
         * shift 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setShift(String value) {
            this.shift = value;
        }

        /**
         * tenor 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTenor() {
            return tenor;
        }

        /**
         * tenor 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTenor(String value) {
            this.tenor = value;
        }

        /**
         * shiftWeights 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getShiftWeights() {
            return shiftWeights;
        }

        /**
         * shiftWeights 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setShiftWeights(String value) {
            this.shiftWeights = value;
        }

        /**
         * weightTenors 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWeightTenors() {
            return weightTenors;
        }

        /**
         * weightTenors 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWeightTenors(String value) {
            this.weightTenors = value;
        }

    }

}
