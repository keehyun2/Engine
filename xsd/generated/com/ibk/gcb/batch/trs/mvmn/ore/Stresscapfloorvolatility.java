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
 * <p>stresscapfloorvolatility complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="stresscapfloorvolatility">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShiftType" type="{}shiftTypeEntry" maxOccurs="unbounded"/>
 *         &lt;element name="Shifts">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Shift" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="tenor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ShiftExpiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShiftStrikes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Index" type="{}indexNameType" minOccurs="0"/>
 *         &lt;element name="IsRelative" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
@XmlType(name = "stresscapfloorvolatility", propOrder = {
    "shiftType",
    "shifts",
    "shiftExpiries",
    "shiftStrikes",
    "index",
    "isRelative"
})
public class Stresscapfloorvolatility {

    @XmlElement(name = "ShiftType", required = true)
    protected List<ShiftTypeEntry> shiftType;
    @XmlElement(name = "Shifts", required = true)
    protected Stresscapfloorvolatility.Shifts shifts;
    @XmlElement(name = "ShiftExpiries", required = true)
    protected String shiftExpiries;
    @XmlElement(name = "ShiftStrikes")
    protected String shiftStrikes;
    @XmlElement(name = "Index")
    protected String index;
    @XmlElement(name = "IsRelative")
    protected Boolean isRelative;
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
     * shifts 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Stresscapfloorvolatility.Shifts }
     *     
     */
    public Stresscapfloorvolatility.Shifts getShifts() {
        return shifts;
    }

    /**
     * shifts 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Stresscapfloorvolatility.Shifts }
     *     
     */
    public void setShifts(Stresscapfloorvolatility.Shifts value) {
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
     * index 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndex() {
        return index;
    }

    /**
     * index 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndex(String value) {
        this.index = value;
    }

    /**
     * isRelative 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRelative() {
        return isRelative;
    }

    /**
     * isRelative 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRelative(Boolean value) {
        this.isRelative = value;
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
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="tenor" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        protected List<Stresscapfloorvolatility.Shifts.Shift> shift;

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
         * {@link Stresscapfloorvolatility.Shifts.Shift }
         * 
         * 
         */
        public List<Stresscapfloorvolatility.Shifts.Shift> getShift() {
            if (shift == null) {
                shift = new ArrayList<Stresscapfloorvolatility.Shifts.Shift>();
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
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="tenor" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            protected String value;
            @XmlAttribute(name = "tenor")
            protected String tenor;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
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

        }

    }

}
