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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>flexiSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="flexiSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LowerNotionalBounds" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Notional" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                           &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Prepayment" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NoticePeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="NoticeCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="NoticeConvention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;sequence>
 *                     &lt;element name="PrepaymentOptions" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="PrepaymentOption" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;all>
 *                                         &lt;element name="ExerciseDate" type="{}date"/>
 *                                         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                                       &lt;/all>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OptionLongShort" type="{}longShort"/>
 *         &lt;element name="LegData" type="{}legData" maxOccurs="2" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flexiSwapData", propOrder = {
    "lowerNotionalBounds",
    "prepayment",
    "optionLongShort",
    "legData"
})
public class FlexiSwapData {

    @XmlElement(name = "LowerNotionalBounds")
    protected FlexiSwapData.LowerNotionalBounds lowerNotionalBounds;
    @XmlElement(name = "Prepayment")
    protected FlexiSwapData.Prepayment prepayment;
    @XmlElement(name = "OptionLongShort", required = true)
    @XmlSchemaType(name = "string")
    protected LongShort optionLongShort;
    @XmlElement(name = "LegData", required = true)
    protected List<LegData> legData;

    /**
     * lowerNotionalBounds 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FlexiSwapData.LowerNotionalBounds }
     *     
     */
    public FlexiSwapData.LowerNotionalBounds getLowerNotionalBounds() {
        return lowerNotionalBounds;
    }

    /**
     * lowerNotionalBounds 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FlexiSwapData.LowerNotionalBounds }
     *     
     */
    public void setLowerNotionalBounds(FlexiSwapData.LowerNotionalBounds value) {
        this.lowerNotionalBounds = value;
    }

    /**
     * prepayment 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FlexiSwapData.Prepayment }
     *     
     */
    public FlexiSwapData.Prepayment getPrepayment() {
        return prepayment;
    }

    /**
     * prepayment 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FlexiSwapData.Prepayment }
     *     
     */
    public void setPrepayment(FlexiSwapData.Prepayment value) {
        this.prepayment = value;
    }

    /**
     * optionLongShort 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LongShort }
     *     
     */
    public LongShort getOptionLongShort() {
        return optionLongShort;
    }

    /**
     * optionLongShort 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LongShort }
     *     
     */
    public void setOptionLongShort(LongShort value) {
        this.optionLongShort = value;
    }

    /**
     * Gets the value of the legData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LegData }
     * 
     * 
     */
    public List<LegData> getLegData() {
        if (legData == null) {
            legData = new ArrayList<LegData>();
        }
        return this.legData;
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
     *         &lt;element name="Notional" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                 &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "notional"
    })
    public static class LowerNotionalBounds {

        @XmlElement(name = "Notional", required = true)
        protected List<FlexiSwapData.LowerNotionalBounds.Notional> notional;

        /**
         * Gets the value of the notional property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the notional property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNotional().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FlexiSwapData.LowerNotionalBounds.Notional }
         * 
         * 
         */
        public List<FlexiSwapData.LowerNotionalBounds.Notional> getNotional() {
            if (notional == null) {
                notional = new ArrayList<FlexiSwapData.LowerNotionalBounds.Notional>();
            }
            return this.notional;
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
         *       &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class Notional {

            @XmlValue
            protected float value;
            @XmlAttribute(name = "startDate")
            protected String startDate;

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
     *         &lt;element name="NoticePeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="NoticeCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="NoticeConvention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;sequence>
     *           &lt;element name="PrepaymentOptions" maxOccurs="unbounded" minOccurs="0">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="PrepaymentOption" maxOccurs="unbounded" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;all>
     *                               &lt;element name="ExerciseDate" type="{}date"/>
     *                               &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                               &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                             &lt;/all>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *         &lt;/sequence>
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
        "noticePeriod",
        "noticeCalendar",
        "noticeConvention",
        "prepaymentOptions"
    })
    public static class Prepayment {

        @XmlElement(name = "NoticePeriod")
        protected String noticePeriod;
        @XmlElement(name = "NoticeCalendar")
        protected String noticeCalendar;
        @XmlElement(name = "NoticeConvention")
        protected String noticeConvention;
        @XmlElement(name = "PrepaymentOptions")
        protected List<FlexiSwapData.Prepayment.PrepaymentOptions> prepaymentOptions;

        /**
         * noticePeriod 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNoticePeriod() {
            return noticePeriod;
        }

        /**
         * noticePeriod 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNoticePeriod(String value) {
            this.noticePeriod = value;
        }

        /**
         * noticeCalendar 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNoticeCalendar() {
            return noticeCalendar;
        }

        /**
         * noticeCalendar 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNoticeCalendar(String value) {
            this.noticeCalendar = value;
        }

        /**
         * noticeConvention 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNoticeConvention() {
            return noticeConvention;
        }

        /**
         * noticeConvention 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNoticeConvention(String value) {
            this.noticeConvention = value;
        }

        /**
         * Gets the value of the prepaymentOptions property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the prepaymentOptions property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPrepaymentOptions().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FlexiSwapData.Prepayment.PrepaymentOptions }
         * 
         * 
         */
        public List<FlexiSwapData.Prepayment.PrepaymentOptions> getPrepaymentOptions() {
            if (prepaymentOptions == null) {
                prepaymentOptions = new ArrayList<FlexiSwapData.Prepayment.PrepaymentOptions>();
            }
            return this.prepaymentOptions;
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
         *         &lt;element name="PrepaymentOption" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;all>
         *                   &lt;element name="ExerciseDate" type="{}date"/>
         *                   &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *                 &lt;/all>
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
        @XmlType(name = "", propOrder = {
            "prepaymentOption"
        })
        public static class PrepaymentOptions {

            @XmlElement(name = "PrepaymentOption")
            protected List<FlexiSwapData.Prepayment.PrepaymentOptions.PrepaymentOption> prepaymentOption;

            /**
             * Gets the value of the prepaymentOption property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the prepaymentOption property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPrepaymentOption().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link FlexiSwapData.Prepayment.PrepaymentOptions.PrepaymentOption }
             * 
             * 
             */
            public List<FlexiSwapData.Prepayment.PrepaymentOptions.PrepaymentOption> getPrepaymentOption() {
                if (prepaymentOption == null) {
                    prepaymentOption = new ArrayList<FlexiSwapData.Prepayment.PrepaymentOptions.PrepaymentOption>();
                }
                return this.prepaymentOption;
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
             *         &lt;element name="ExerciseDate" type="{}date"/>
             *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
            public static class PrepaymentOption {

                @XmlElement(name = "ExerciseDate", required = true)
                protected String exerciseDate;
                @XmlElement(name = "Type", required = true)
                protected String type;
                @XmlElement(name = "Value")
                protected float value;

                /**
                 * exerciseDate 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExerciseDate() {
                    return exerciseDate;
                }

                /**
                 * exerciseDate 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExerciseDate(String value) {
                    this.exerciseDate = value;
                }

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

            }

        }

    }

}
