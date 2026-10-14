//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>scheduleData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="scheduleData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="Rules">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="StartDate" type="{}date"/>
 *                   &lt;element name="EndDate" type="{}date" minOccurs="0"/>
 *                   &lt;element name="AdjustEndDateToPreviousMonthEnd" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="Tenor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *                   &lt;element name="Convention" type="{}businessDayConvention"/>
 *                   &lt;element name="TermConvention" type="{}businessDayConvention" minOccurs="0"/>
 *                   &lt;element name="Rule" type="{}dateRule" minOccurs="0"/>
 *                   &lt;element name="EndOfMonth" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="EndOfMonthConvention" type="{}businessDayConvention" minOccurs="0"/>
 *                   &lt;element name="FirstDate" type="{}date" minOccurs="0"/>
 *                   &lt;element name="LastDate" type="{}date" minOccurs="0"/>
 *                   &lt;element name="RemoveFirstDate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="RemoveLastDate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Dates">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *                   &lt;element name="Convention" type="{}businessDayConvention" minOccurs="0"/>
 *                   &lt;element name="Tenor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EndOfMonth" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="IncludeDuplicateDates" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="Dates">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Date" type="{}date" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{}DerivedScheduleGroup"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scheduleData", propOrder = {
    "rulesOrDatesOrDerivedScheduleGroup"
})
public class ScheduleData {

    @XmlElementRefs({
        @XmlElementRef(name = "Dates", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Rules", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DerivedScheduleGroup", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rulesOrDatesOrDerivedScheduleGroup;

    /**
     * Gets the value of the rulesOrDatesOrDerivedScheduleGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rulesOrDatesOrDerivedScheduleGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRulesOrDatesOrDerivedScheduleGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link DerivedScheduleType }{@code >}
     * {@link JAXBElement }{@code <}{@link ScheduleData.Dates }{@code >}
     * {@link JAXBElement }{@code <}{@link DerivedScheduleType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link ScheduleData.Rules }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getRulesOrDatesOrDerivedScheduleGroup() {
        if (rulesOrDatesOrDerivedScheduleGroup == null) {
            rulesOrDatesOrDerivedScheduleGroup = new ArrayList<JAXBElement<?>>();
        }
        return this.rulesOrDatesOrDerivedScheduleGroup;
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
     *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
     *         &lt;element name="Convention" type="{}businessDayConvention" minOccurs="0"/>
     *         &lt;element name="Tenor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="EndOfMonth" type="{}bool" minOccurs="0"/>
     *         &lt;element name="IncludeDuplicateDates" type="{}bool" minOccurs="0"/>
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
    public static class Dates {

        @XmlElement(name = "Calendar")
        protected String calendar;
        @XmlElement(name = "Convention")
        protected String convention;
        @XmlElement(name = "Tenor")
        protected String tenor;
        @XmlElement(name = "EndOfMonth")
        protected String endOfMonth;
        @XmlElement(name = "IncludeDuplicateDates")
        protected String includeDuplicateDates;
        @XmlElement(name = "Dates", required = true)
        protected ScheduleData.Dates.ScheduleDates dates;

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
         * endOfMonth 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEndOfMonth() {
            return endOfMonth;
        }

        /**
         * endOfMonth 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEndOfMonth(String value) {
            this.endOfMonth = value;
        }

        /**
         * includeDuplicateDates 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIncludeDuplicateDates() {
            return includeDuplicateDates;
        }

        /**
         * includeDuplicateDates 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIncludeDuplicateDates(String value) {
            this.includeDuplicateDates = value;
        }

        /**
         * dates 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ScheduleData.Dates.ScheduleDates }
         *     
         */
        public ScheduleData.Dates.ScheduleDates getDates() {
            return dates;
        }

        /**
         * dates 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ScheduleData.Dates.ScheduleDates }
         *     
         */
        public void setDates(ScheduleData.Dates.ScheduleDates value) {
            this.dates = value;
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
        public static class ScheduleDates {

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
     *         &lt;element name="StartDate" type="{}date"/>
     *         &lt;element name="EndDate" type="{}date" minOccurs="0"/>
     *         &lt;element name="AdjustEndDateToPreviousMonthEnd" type="{}bool" minOccurs="0"/>
     *         &lt;element name="Tenor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
     *         &lt;element name="Convention" type="{}businessDayConvention"/>
     *         &lt;element name="TermConvention" type="{}businessDayConvention" minOccurs="0"/>
     *         &lt;element name="Rule" type="{}dateRule" minOccurs="0"/>
     *         &lt;element name="EndOfMonth" type="{}bool" minOccurs="0"/>
     *         &lt;element name="EndOfMonthConvention" type="{}businessDayConvention" minOccurs="0"/>
     *         &lt;element name="FirstDate" type="{}date" minOccurs="0"/>
     *         &lt;element name="LastDate" type="{}date" minOccurs="0"/>
     *         &lt;element name="RemoveFirstDate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="RemoveLastDate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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

        @XmlElement(name = "StartDate", required = true)
        protected String startDate;
        @XmlElement(name = "EndDate")
        protected String endDate;
        @XmlElement(name = "AdjustEndDateToPreviousMonthEnd")
        protected String adjustEndDateToPreviousMonthEnd;
        @XmlElement(name = "Tenor", required = true)
        protected String tenor;
        @XmlElement(name = "Calendar")
        protected String calendar;
        @XmlElement(name = "Convention", required = true)
        protected String convention;
        @XmlElement(name = "TermConvention")
        protected String termConvention;
        @XmlElement(name = "Rule")
        protected String rule;
        @XmlElement(name = "EndOfMonth")
        protected String endOfMonth;
        @XmlElement(name = "EndOfMonthConvention")
        protected String endOfMonthConvention;
        @XmlElement(name = "FirstDate")
        protected String firstDate;
        @XmlElement(name = "LastDate")
        protected String lastDate;
        @XmlElement(name = "RemoveFirstDate")
        protected Boolean removeFirstDate;
        @XmlElement(name = "RemoveLastDate")
        protected Boolean removeLastDate;

        /**
         * startDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStartDate() {
            return startDate;
        }

        /**
         * startDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStartDate(String value) {
            this.startDate = value;
        }

        /**
         * endDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEndDate() {
            return endDate;
        }

        /**
         * endDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEndDate(String value) {
            this.endDate = value;
        }

        /**
         * adjustEndDateToPreviousMonthEnd 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdjustEndDateToPreviousMonthEnd() {
            return adjustEndDateToPreviousMonthEnd;
        }

        /**
         * adjustEndDateToPreviousMonthEnd 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdjustEndDateToPreviousMonthEnd(String value) {
            this.adjustEndDateToPreviousMonthEnd = value;
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
         * termConvention 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTermConvention() {
            return termConvention;
        }

        /**
         * termConvention 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTermConvention(String value) {
            this.termConvention = value;
        }

        /**
         * rule 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRule() {
            return rule;
        }

        /**
         * rule 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRule(String value) {
            this.rule = value;
        }

        /**
         * endOfMonth 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEndOfMonth() {
            return endOfMonth;
        }

        /**
         * endOfMonth 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEndOfMonth(String value) {
            this.endOfMonth = value;
        }

        /**
         * endOfMonthConvention 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEndOfMonthConvention() {
            return endOfMonthConvention;
        }

        /**
         * endOfMonthConvention 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEndOfMonthConvention(String value) {
            this.endOfMonthConvention = value;
        }

        /**
         * firstDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFirstDate() {
            return firstDate;
        }

        /**
         * firstDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFirstDate(String value) {
            this.firstDate = value;
        }

        /**
         * lastDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastDate() {
            return lastDate;
        }

        /**
         * lastDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastDate(String value) {
            this.lastDate = value;
        }

        /**
         * removeFirstDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isRemoveFirstDate() {
            return removeFirstDate;
        }

        /**
         * removeFirstDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setRemoveFirstDate(Boolean value) {
            this.removeFirstDate = value;
        }

        /**
         * removeLastDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isRemoveLastDate() {
            return removeLastDate;
        }

        /**
         * removeLastDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setRemoveLastDate(Boolean value) {
            this.removeLastDate = value;
        }

    }

}
