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
 * <p>BondYieldShiftedType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="BondYieldShiftedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferenceCurve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Quotes" type="{}quoteType"/>
 *         &lt;element name="IborIndexCurves" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IborIndexCurve" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="iborIndex" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ExtrapolateFlat" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BondYieldShiftedType", propOrder = {

})
public class BondYieldShiftedType {

    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "ReferenceCurve", required = true)
    protected String referenceCurve;
    @XmlElement(name = "Quotes", required = true)
    protected QuoteType quotes;
    @XmlElement(name = "IborIndexCurves")
    protected BondYieldShiftedType.IborIndexCurves iborIndexCurves;
    @XmlElement(name = "Conventions", required = true)
    protected String conventions;
    @XmlElement(name = "ExtrapolateFlat")
    protected Boolean extrapolateFlat;

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
     * referenceCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceCurve() {
        return referenceCurve;
    }

    /**
     * referenceCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceCurve(String value) {
        this.referenceCurve = value;
    }

    /**
     * quotes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link QuoteType }
     *     
     */
    public QuoteType getQuotes() {
        return quotes;
    }

    /**
     * quotes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link QuoteType }
     *     
     */
    public void setQuotes(QuoteType value) {
        this.quotes = value;
    }

    /**
     * iborIndexCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BondYieldShiftedType.IborIndexCurves }
     *     
     */
    public BondYieldShiftedType.IborIndexCurves getIborIndexCurves() {
        return iborIndexCurves;
    }

    /**
     * iborIndexCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BondYieldShiftedType.IborIndexCurves }
     *     
     */
    public void setIborIndexCurves(BondYieldShiftedType.IborIndexCurves value) {
        this.iborIndexCurves = value;
    }

    /**
     * conventions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConventions() {
        return conventions;
    }

    /**
     * conventions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConventions(String value) {
        this.conventions = value;
    }

    /**
     * extrapolateFlat 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExtrapolateFlat() {
        return extrapolateFlat;
    }

    /**
     * extrapolateFlat 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExtrapolateFlat(Boolean value) {
        this.extrapolateFlat = value;
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
     *         &lt;element name="IborIndexCurve" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="iborIndex" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "iborIndexCurve"
    })
    public static class IborIndexCurves {

        @XmlElement(name = "IborIndexCurve")
        protected List<BondYieldShiftedType.IborIndexCurves.IborIndexCurve> iborIndexCurve;

        /**
         * Gets the value of the iborIndexCurve property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the iborIndexCurve property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIborIndexCurve().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BondYieldShiftedType.IborIndexCurves.IborIndexCurve }
         * 
         * 
         */
        public List<BondYieldShiftedType.IborIndexCurves.IborIndexCurve> getIborIndexCurve() {
            if (iborIndexCurve == null) {
                iborIndexCurve = new ArrayList<BondYieldShiftedType.IborIndexCurves.IborIndexCurve>();
            }
            return this.iborIndexCurve;
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
         *       &lt;attribute name="iborIndex" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class IborIndexCurve {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "iborIndex")
            protected String iborIndex;

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
             * iborIndex 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIborIndex() {
                return iborIndex;
            }

            /**
             * iborIndex 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIborIndex(String value) {
                this.iborIndex = value;
            }

        }

    }

}
