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
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>swaptionvolatility complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="swaptionvolatility">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShiftType" type="{}shiftTypeEntry" maxOccurs="unbounded"/>
 *         &lt;choice>
 *           &lt;element name="ShiftSize" type="{}shiftSizeEntry" maxOccurs="unbounded"/>
 *           &lt;element name="Shifts">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Shift" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;simpleContent>
 *                           &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                             &lt;attribute name="expiry" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                             &lt;attribute name="term" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;/extension>
 *                         &lt;/simpleContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;element name="ShiftScheme" type="{}shiftSchemeEntry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ShiftExpiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShiftStrikes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShiftTerms" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ccy" type="{}currencyCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "swaptionvolatility", propOrder = {
    "shiftType",
    "shiftSize",
    "shifts",
    "shiftScheme",
    "shiftExpiries",
    "shiftStrikes",
    "shiftTerms"
})
public class SensitivitySwaptionVolatility {

    @XmlElement(name = "ShiftType", required = true)
    protected List<ShiftTypeEntry> shiftType;
    @XmlElement(name = "ShiftSize")
    protected List<ShiftSizeEntry> shiftSize;
    @XmlElement(name = "Shifts")
    protected SensitivitySwaptionVolatility.Shifts shifts;
    @XmlElement(name = "ShiftScheme")
    protected List<ShiftSchemeEntry> shiftScheme;
    @XmlElement(name = "ShiftExpiries", required = true)
    protected String shiftExpiries;
    @XmlElement(name = "ShiftStrikes")
    protected String shiftStrikes;
    @XmlElement(name = "ShiftTerms", required = true)
    protected String shiftTerms;
    @XmlAttribute(name = "key")
    protected String key;
    @XmlAttribute(name = "ccy")
    protected CurrencyCode ccy;

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
     * Gets the value of the shiftSize property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shiftSize property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShiftSize().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShiftSizeEntry }
     * 
     * 
     */
    public List<ShiftSizeEntry> getShiftSize() {
        if (shiftSize == null) {
            shiftSize = new ArrayList<ShiftSizeEntry>();
        }
        return this.shiftSize;
    }

    /**
     * shifts 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SensitivitySwaptionVolatility.Shifts }
     *     
     */
    public SensitivitySwaptionVolatility.Shifts getShifts() {
        return shifts;
    }

    /**
     * shifts 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivitySwaptionVolatility.Shifts }
     *     
     */
    public void setShifts(SensitivitySwaptionVolatility.Shifts value) {
        this.shifts = value;
    }

    /**
     * Gets the value of the shiftScheme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shiftScheme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShiftScheme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShiftSchemeEntry }
     * 
     * 
     */
    public List<ShiftSchemeEntry> getShiftScheme() {
        if (shiftScheme == null) {
            shiftScheme = new ArrayList<ShiftSchemeEntry>();
        }
        return this.shiftScheme;
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
     * shiftStrikes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShiftStrikes() {
        return shiftStrikes;
    }

    /**
     * shiftStrikes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShiftStrikes(String value) {
        this.shiftStrikes = value;
    }

    /**
     * shiftTerms 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShiftTerms() {
        return shiftTerms;
    }

    /**
     * shiftTerms 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShiftTerms(String value) {
        this.shiftTerms = value;
    }

    /**
     * key 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * key 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * ccy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getCcy() {
        return ccy;
    }

    /**
     * ccy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setCcy(CurrencyCode value) {
        this.ccy = value;
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
     *         &lt;element name="Shift" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                 &lt;attribute name="expiry" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="term" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
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
    @XmlType(name = "", propOrder = {
        "shift"
    })
    public static class Shifts {

        @XmlElement(name = "Shift")
        protected List<SensitivitySwaptionVolatility.Shifts.Shift> shift;

        /**
         * Gets the value of the shift property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the shift property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getShift().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SensitivitySwaptionVolatility.Shifts.Shift }
         * 
         * 
         */
        public List<SensitivitySwaptionVolatility.Shifts.Shift> getShift() {
            if (shift == null) {
                shift = new ArrayList<SensitivitySwaptionVolatility.Shifts.Shift>();
            }
            return this.shift;
        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *       &lt;attribute name="expiry" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="term" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Shift {

            @XmlValue
            protected float value;
            @XmlAttribute(name = "expiry")
            protected String expiry;
            @XmlAttribute(name = "term")
            protected String term;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             */
            public float getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             */
            public void setValue(float value) {
                this.value = value;
            }

            /**
             * expiry 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExpiry() {
                return expiry;
            }

            /**
             * expiry 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExpiry(String value) {
                this.expiry = value;
            }

            /**
             * term 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTerm() {
                return term;
            }

            /**
             * term 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTerm(String value) {
                this.term = value;
            }

        }

    }

}
