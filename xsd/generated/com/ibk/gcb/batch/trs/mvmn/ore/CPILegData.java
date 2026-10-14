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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>anonymous complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Rates">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Rate" maxOccurs="unbounded">
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
 *         &lt;element name="BaseCPI" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="ObservationLag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Interpolation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Interpolated" type="{}bool" minOccurs="0"/>
 *         &lt;element name="SubtractInflationNotional" type="{}bool"/>
 *         &lt;element name="Caps" type="{}caps" minOccurs="0"/>
 *         &lt;element name="Floors" type="{}floors" minOccurs="0"/>
 *         &lt;element name="FinalFlowCap" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="FinalFlowFloor" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="NakedOption" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SubtractInflationNotionalAllCoupons" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "indexOrRatesOrBaseCPI"
})
public class CPILegData {

    @XmlElementRefs({
        @XmlElementRef(name = "Index", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Rates", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SubtractInflationNotionalAllCoupons", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SubtractInflationNotional", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Interpolated", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ObservationLag", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FinalFlowCap", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NakedOption", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StartDate", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Interpolation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Caps", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BaseCPI", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FinalFlowFloor", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Floors", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> indexOrRatesOrBaseCPI;

    /**
     * Gets the value of the indexOrRatesOrBaseCPI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the indexOrRatesOrBaseCPI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndexOrRatesOrBaseCPI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link CPILegData.Rates }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Float }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Caps }{@code >}
     * {@link JAXBElement }{@code <}{@link Float }{@code >}
     * {@link JAXBElement }{@code <}{@link Float }{@code >}
     * {@link JAXBElement }{@code <}{@link Floors }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getIndexOrRatesOrBaseCPI() {
        if (indexOrRatesOrBaseCPI == null) {
            indexOrRatesOrBaseCPI = new ArrayList<JAXBElement<?>>();
        }
        return this.indexOrRatesOrBaseCPI;
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
     *         &lt;element name="Rate" maxOccurs="unbounded">
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
        "rate"
    })
    public static class Rates {

        @XmlElement(name = "Rate", required = true)
        protected List<CPILegData.Rates.Rate> rate;

        /**
         * Gets the value of the rate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CPILegData.Rates.Rate }
         * 
         * 
         */
        public List<CPILegData.Rates.Rate> getRate() {
            if (rate == null) {
                rate = new ArrayList<CPILegData.Rates.Rate>();
            }
            return this.rate;
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
        public static class Rate {

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

}
