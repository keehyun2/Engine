//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>optionPaymentData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="optionPaymentData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Dates">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Date" type="{}date" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Rules">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Lag" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                   &lt;element name="Calendar" type="{}calendar"/>
 *                   &lt;element name="Convention" type="{}businessDayConvention"/>
 *                   &lt;element name="RelativeTo" type="{}optionPayRelativeTo" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "optionPaymentData", propOrder = {
    "dates",
    "rules"
})
public class OptionPaymentData {

    @XmlElement(name = "Dates")
    protected OptionPaymentData.Dates dates;
    @XmlElement(name = "Rules")
    protected OptionPaymentData.Rules rules;

    /**
     * dates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OptionPaymentData.Dates }
     *     
     */
    public OptionPaymentData.Dates getDates() {
        return dates;
    }

    /**
     * dates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionPaymentData.Dates }
     *     
     */
    public void setDates(OptionPaymentData.Dates value) {
        this.dates = value;
    }

    /**
     * rules 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OptionPaymentData.Rules }
     *     
     */
    public OptionPaymentData.Rules getRules() {
        return rules;
    }

    /**
     * rules 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionPaymentData.Rules }
     *     
     */
    public void setRules(OptionPaymentData.Rules value) {
        this.rules = value;
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
     *         &lt;element name="Date" type="{}date" maxOccurs="unbounded"/>
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
        "date"
    })
    public static class Dates {

        @XmlElement(name = "Date", required = true)
        protected List<String> date;

        /**
         * Gets the value of the date property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the date property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDate() {
            if (date == null) {
                date = new ArrayList<String>();
            }
            return this.date;
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
     *       &lt;all>
     *         &lt;element name="Lag" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *         &lt;element name="Calendar" type="{}calendar"/>
     *         &lt;element name="Convention" type="{}businessDayConvention"/>
     *         &lt;element name="RelativeTo" type="{}optionPayRelativeTo" minOccurs="0"/>
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
    public static class Rules {

        @XmlElement(name = "Lag", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger lag;
        @XmlElement(name = "Calendar", required = true)
        protected String calendar;
        @XmlElement(name = "Convention", required = true)
        protected String convention;
        @XmlElement(name = "RelativeTo")
        @XmlSchemaType(name = "string")
        protected OptionPayRelativeTo relativeTo;

        /**
         * lag 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getLag() {
            return lag;
        }

        /**
         * lag 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setLag(BigInteger value) {
            this.lag = value;
        }

        /**
         * calendar 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCalendar() {
            return calendar;
        }

        /**
         * calendar 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCalendar(String value) {
            this.calendar = value;
        }

        /**
         * convention 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConvention() {
            return convention;
        }

        /**
         * convention 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConvention(String value) {
            this.convention = value;
        }

        /**
         * relativeTo 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link OptionPayRelativeTo }
         *     
         */
        public OptionPayRelativeTo getRelativeTo() {
            return relativeTo;
        }

        /**
         * relativeTo 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link OptionPayRelativeTo }
         *     
         */
        public void setRelativeTo(OptionPayRelativeTo value) {
            this.relativeTo = value;
        }

    }

}
