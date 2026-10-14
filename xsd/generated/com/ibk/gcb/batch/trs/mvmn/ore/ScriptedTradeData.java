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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>scriptedTradeData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="scriptedTradeData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element name="ScriptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *           &lt;element name="ProductTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *           &lt;element name="Script" type="{}ore_script" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="Data">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                     &lt;element name="Number">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                               &lt;choice>
 *                                 &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                 &lt;element name="Values">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;sequence>
 *                                           &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
 *                                         &lt;/sequence>
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/choice>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="Currency">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                               &lt;choice>
 *                                 &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                 &lt;element name="Values">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;sequence>
 *                                           &lt;element name="Value" type="{}currencyCode" maxOccurs="unbounded"/>
 *                                         &lt;/sequence>
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/choice>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="Index">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                               &lt;choice>
 *                                 &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                 &lt;element name="Values">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;sequence>
 *                                           &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                         &lt;/sequence>
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/choice>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="Event">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                               &lt;choice>
 *                                 &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                 &lt;element name="ScheduleData" type="{}scheduleData"/>
 *                                 &lt;element name="DerivedSchedule">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;all>
 *                                           &lt;element name="BaseSchedule" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                           &lt;element name="Shift" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                           &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                           &lt;element name="Convention" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                         &lt;/all>
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/choice>
 *                               &lt;element name="ApplyCoarsening" type="{}bool" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="Daycounter">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                               &lt;choice>
 *                                 &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                 &lt;element name="Values">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;sequence>
 *                                           &lt;element name="Value" type="{}dayCounter" maxOccurs="unbounded"/>
 *                                         &lt;/sequence>
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/choice>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/choice>
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
@XmlType(name = "scriptedTradeData", propOrder = {
    "scriptName",
    "productTag",
    "script",
    "data"
})
public class ScriptedTradeData {

    @XmlElement(name = "ScriptName")
    protected String scriptName;
    @XmlElement(name = "ProductTag")
    protected String productTag;
    @XmlElement(name = "Script")
    protected OreScript script;
    @XmlElement(name = "Data", required = true)
    protected ScriptedTradeData.Data data;

    /**
     * scriptName 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScriptName() {
        return scriptName;
    }

    /**
     * scriptName 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScriptName(String value) {
        this.scriptName = value;
    }

    /**
     * productTag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductTag() {
        return productTag;
    }

    /**
     * productTag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductTag(String value) {
        this.productTag = value;
    }

    /**
     * script 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OreScript }
     *     
     */
    public OreScript getScript() {
        return script;
    }

    /**
     * script 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OreScript }
     *     
     */
    public void setScript(OreScript value) {
        this.script = value;
    }

    /**
     * data 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScriptedTradeData.Data }
     *     
     */
    public ScriptedTradeData.Data getData() {
        return data;
    }

    /**
     * data 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScriptedTradeData.Data }
     *     
     */
    public void setData(ScriptedTradeData.Data value) {
        this.data = value;
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
     *         &lt;choice maxOccurs="unbounded" minOccurs="0">
     *           &lt;element name="Number">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                     &lt;choice>
     *                       &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                       &lt;element name="Values">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                               &lt;sequence>
     *                                 &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
     *                               &lt;/sequence>
     *                             &lt;/restriction>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                     &lt;/choice>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="Currency">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                     &lt;choice>
     *                       &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                       &lt;element name="Values">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                               &lt;sequence>
     *                                 &lt;element name="Value" type="{}currencyCode" maxOccurs="unbounded"/>
     *                               &lt;/sequence>
     *                             &lt;/restriction>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                     &lt;/choice>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="Index">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                     &lt;choice>
     *                       &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                       &lt;element name="Values">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                               &lt;sequence>
     *                                 &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *                               &lt;/sequence>
     *                             &lt;/restriction>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                     &lt;/choice>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="Event">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                     &lt;choice>
     *                       &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                       &lt;element name="ScheduleData" type="{}scheduleData"/>
     *                       &lt;element name="DerivedSchedule">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                               &lt;all>
     *                                 &lt;element name="BaseSchedule" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                 &lt;element name="Shift" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                 &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                 &lt;element name="Convention" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                               &lt;/all>
     *                             &lt;/restriction>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                     &lt;/choice>
     *                     &lt;element name="ApplyCoarsening" type="{}bool" minOccurs="0"/>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="Daycounter">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                     &lt;choice>
     *                       &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                       &lt;element name="Values">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                               &lt;sequence>
     *                                 &lt;element name="Value" type="{}dayCounter" maxOccurs="unbounded"/>
     *                               &lt;/sequence>
     *                             &lt;/restriction>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                     &lt;/choice>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *         &lt;/choice>
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
        "numberOrCurrencyOrIndex"
    })
    public static class Data {

        @XmlElements({
            @XmlElement(name = "Number", type = ScriptedTradeData.Data.Number.class),
            @XmlElement(name = "Currency", type = ScriptedTradeData.Data.Currency.class),
            @XmlElement(name = "Index", type = ScriptedTradeData.Data.Index.class),
            @XmlElement(name = "Event", type = ScriptedTradeData.Data.Event.class),
            @XmlElement(name = "Daycounter", type = ScriptedTradeData.Data.Daycounter.class)
        })
        protected List<Object> numberOrCurrencyOrIndex;

        /**
         * Gets the value of the numberOrCurrencyOrIndex property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the numberOrCurrencyOrIndex property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNumberOrCurrencyOrIndex().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ScriptedTradeData.Data.Number }
         * {@link ScriptedTradeData.Data.Currency }
         * {@link ScriptedTradeData.Data.Index }
         * {@link ScriptedTradeData.Data.Event }
         * {@link ScriptedTradeData.Data.Daycounter }
         * 
         * 
         */
        public List<Object> getNumberOrCurrencyOrIndex() {
            if (numberOrCurrencyOrIndex == null) {
                numberOrCurrencyOrIndex = new ArrayList<Object>();
            }
            return this.numberOrCurrencyOrIndex;
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
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;choice>
         *           &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *           &lt;element name="Values">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;sequence>
         *                     &lt;element name="Value" type="{}currencyCode" maxOccurs="unbounded"/>
         *                   &lt;/sequence>
         *                 &lt;/restriction>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *         &lt;/choice>
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
            "name",
            "value",
            "values"
        })
        public static class Currency {

            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "Value")
            protected Object value;
            @XmlElement(name = "Values")
            protected ScriptedTradeData.Data.Currency.Values values;

            /**
             * name 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * name 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setValue(Object value) {
                this.value = value;
            }

            /**
             * values 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link ScriptedTradeData.Data.Currency.Values }
             *     
             */
            public ScriptedTradeData.Data.Currency.Values getValues() {
                return values;
            }

            /**
             * values 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link ScriptedTradeData.Data.Currency.Values }
             *     
             */
            public void setValues(ScriptedTradeData.Data.Currency.Values value) {
                this.values = value;
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
             *         &lt;element name="Value" type="{}currencyCode" maxOccurs="unbounded"/>
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
                "value"
            })
            public static class Values {

                @XmlElement(name = "Value", required = true)
                @XmlSchemaType(name = "string")
                protected List<CurrencyCode> value;

                /**
                 * Gets the value of the value property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the value property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getValue().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link CurrencyCode }
                 * 
                 * 
                 */
                public List<CurrencyCode> getValue() {
                    if (value == null) {
                        value = new ArrayList<CurrencyCode>();
                    }
                    return this.value;
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
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;choice>
         *           &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *           &lt;element name="Values">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;sequence>
         *                     &lt;element name="Value" type="{}dayCounter" maxOccurs="unbounded"/>
         *                   &lt;/sequence>
         *                 &lt;/restriction>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *         &lt;/choice>
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
            "name",
            "value",
            "values"
        })
        public static class Daycounter {

            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "Value")
            protected Object value;
            @XmlElement(name = "Values")
            protected ScriptedTradeData.Data.Daycounter.Values values;

            /**
             * name 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * name 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setValue(Object value) {
                this.value = value;
            }

            /**
             * values 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link ScriptedTradeData.Data.Daycounter.Values }
             *     
             */
            public ScriptedTradeData.Data.Daycounter.Values getValues() {
                return values;
            }

            /**
             * values 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link ScriptedTradeData.Data.Daycounter.Values }
             *     
             */
            public void setValues(ScriptedTradeData.Data.Daycounter.Values value) {
                this.values = value;
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
             *         &lt;element name="Value" type="{}dayCounter" maxOccurs="unbounded"/>
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
                "value"
            })
            public static class Values {

                @XmlElement(name = "Value", required = true)
                protected List<String> value;

                /**
                 * Gets the value of the value property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the value property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getValue().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * 
                 * 
                 */
                public List<String> getValue() {
                    if (value == null) {
                        value = new ArrayList<String>();
                    }
                    return this.value;
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
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;choice>
         *           &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *           &lt;element name="ScheduleData" type="{}scheduleData"/>
         *           &lt;element name="DerivedSchedule">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;all>
         *                     &lt;element name="BaseSchedule" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                     &lt;element name="Shift" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                     &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                     &lt;element name="Convention" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;/all>
         *                 &lt;/restriction>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *         &lt;/choice>
         *         &lt;element name="ApplyCoarsening" type="{}bool" minOccurs="0"/>
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
            "name",
            "value",
            "scheduleData",
            "derivedSchedule",
            "applyCoarsening"
        })
        public static class Event {

            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "Value")
            protected Object value;
            @XmlElement(name = "ScheduleData")
            protected ScheduleData scheduleData;
            @XmlElement(name = "DerivedSchedule")
            protected ScriptedTradeData.Data.Event.DerivedSchedule derivedSchedule;
            @XmlElement(name = "ApplyCoarsening")
            protected String applyCoarsening;

            /**
             * name 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * name 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setValue(Object value) {
                this.value = value;
            }

            /**
             * scheduleData 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link ScheduleData }
             *     
             */
            public ScheduleData getScheduleData() {
                return scheduleData;
            }

            /**
             * scheduleData 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link ScheduleData }
             *     
             */
            public void setScheduleData(ScheduleData value) {
                this.scheduleData = value;
            }

            /**
             * derivedSchedule 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link ScriptedTradeData.Data.Event.DerivedSchedule }
             *     
             */
            public ScriptedTradeData.Data.Event.DerivedSchedule getDerivedSchedule() {
                return derivedSchedule;
            }

            /**
             * derivedSchedule 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link ScriptedTradeData.Data.Event.DerivedSchedule }
             *     
             */
            public void setDerivedSchedule(ScriptedTradeData.Data.Event.DerivedSchedule value) {
                this.derivedSchedule = value;
            }

            /**
             * applyCoarsening 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getApplyCoarsening() {
                return applyCoarsening;
            }

            /**
             * applyCoarsening 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setApplyCoarsening(String value) {
                this.applyCoarsening = value;
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
             *         &lt;element name="BaseSchedule" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Shift" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Convention" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            public static class DerivedSchedule {

                @XmlElement(name = "BaseSchedule", required = true)
                protected String baseSchedule;
                @XmlElement(name = "Shift", required = true)
                protected String shift;
                @XmlElement(name = "Calendar", required = true)
                protected String calendar;
                @XmlElement(name = "Convention", required = true)
                protected String convention;

                /**
                 * baseSchedule 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBaseSchedule() {
                    return baseSchedule;
                }

                /**
                 * baseSchedule 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBaseSchedule(String value) {
                    this.baseSchedule = value;
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
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;choice>
         *           &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *           &lt;element name="Values">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;sequence>
         *                     &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
         *                   &lt;/sequence>
         *                 &lt;/restriction>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *         &lt;/choice>
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
            "name",
            "value",
            "values"
        })
        public static class Index {

            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "Value")
            protected Object value;
            @XmlElement(name = "Values")
            protected ScriptedTradeData.Data.Index.Values values;

            /**
             * name 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * name 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setValue(Object value) {
                this.value = value;
            }

            /**
             * values 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link ScriptedTradeData.Data.Index.Values }
             *     
             */
            public ScriptedTradeData.Data.Index.Values getValues() {
                return values;
            }

            /**
             * values 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link ScriptedTradeData.Data.Index.Values }
             *     
             */
            public void setValues(ScriptedTradeData.Data.Index.Values value) {
                this.values = value;
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
             *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
                "value"
            })
            public static class Values {

                @XmlElement(name = "Value", required = true)
                protected List<String> value;

                /**
                 * Gets the value of the value property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the value property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getValue().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * 
                 * 
                 */
                public List<String> getValue() {
                    if (value == null) {
                        value = new ArrayList<String>();
                    }
                    return this.value;
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
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;choice>
         *           &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *           &lt;element name="Values">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;sequence>
         *                     &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
         *                   &lt;/sequence>
         *                 &lt;/restriction>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *         &lt;/choice>
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
            "name",
            "value",
            "values"
        })
        public static class Number {

            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "Value")
            protected Object value;
            @XmlElement(name = "Values")
            protected ScriptedTradeData.Data.Number.Values values;

            /**
             * name 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * name 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setValue(Object value) {
                this.value = value;
            }

            /**
             * values 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link ScriptedTradeData.Data.Number.Values }
             *     
             */
            public ScriptedTradeData.Data.Number.Values getValues() {
                return values;
            }

            /**
             * values 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link ScriptedTradeData.Data.Number.Values }
             *     
             */
            public void setValues(ScriptedTradeData.Data.Number.Values value) {
                this.values = value;
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
             *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
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
                "value"
            })
            public static class Values {

                @XmlElement(name = "Value", type = Float.class)
                protected List<Float> value;

                /**
                 * Gets the value of the value property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the value property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getValue().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Float }
                 * 
                 * 
                 */
                public List<Float> getValue() {
                    if (value == null) {
                        value = new ArrayList<Float>();
                    }
                    return this.value;
                }

            }

        }

    }

}
