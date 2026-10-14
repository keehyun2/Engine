//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cdsVolatility complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="cdsVolatility">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Terms" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Term" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Curve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;choice>
 *           &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="Constant" type="{}constantVolatilityConfig"/>
 *           &lt;element name="Curve" type="{}volatilityCurveConfig"/>
 *           &lt;element name="StrikeSurface" type="{}volatilityStrikeSurfaceConfig"/>
 *           &lt;element name="ProxySurface" type="{}proxySurface"/>
 *         &lt;/choice>
 *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="StrikeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QuoteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StrikeFactor" type="{}positiveDecimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cdsVolatility", propOrder = {
    "curveId",
    "curveDescription",
    "terms",
    "expiries",
    "constant",
    "curve",
    "strikeSurface",
    "proxySurface",
    "dayCounter",
    "calendar",
    "strikeType",
    "quoteName",
    "strikeFactor"
})
public class CdsVolatility {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "Terms")
    protected CdsVolatility.Terms terms;
    @XmlElement(name = "Expiries")
    protected String expiries;
    @XmlElement(name = "Constant")
    protected ConstantVolatilityConfig constant;
    @XmlElement(name = "Curve")
    protected VolatilityCurveConfig curve;
    @XmlElement(name = "StrikeSurface")
    protected VolatilityStrikeSurfaceConfig strikeSurface;
    @XmlElement(name = "ProxySurface")
    protected ProxySurface proxySurface;
    @XmlElement(name = "DayCounter")
    protected String dayCounter;
    @XmlElement(name = "Calendar")
    protected String calendar;
    @XmlElement(name = "StrikeType")
    protected String strikeType;
    @XmlElement(name = "QuoteName")
    protected String quoteName;
    @XmlElement(name = "StrikeFactor")
    protected BigDecimal strikeFactor;

    /**
     * curveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurveId() {
        return curveId;
    }

    /**
     * curveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurveId(String value) {
        this.curveId = value;
    }

    /**
     * curveDescription 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurveDescription() {
        return curveDescription;
    }

    /**
     * curveDescription 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurveDescription(String value) {
        this.curveDescription = value;
    }

    /**
     * terms 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CdsVolatility.Terms }
     *     
     */
    public CdsVolatility.Terms getTerms() {
        return terms;
    }

    /**
     * terms 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CdsVolatility.Terms }
     *     
     */
    public void setTerms(CdsVolatility.Terms value) {
        this.terms = value;
    }

    /**
     * expiries 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiries() {
        return expiries;
    }

    /**
     * expiries 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiries(String value) {
        this.expiries = value;
    }

    /**
     * constant 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ConstantVolatilityConfig }
     *     
     */
    public ConstantVolatilityConfig getConstant() {
        return constant;
    }

    /**
     * constant 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstantVolatilityConfig }
     *     
     */
    public void setConstant(ConstantVolatilityConfig value) {
        this.constant = value;
    }

    /**
     * curve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VolatilityCurveConfig }
     *     
     */
    public VolatilityCurveConfig getCurve() {
        return curve;
    }

    /**
     * curve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolatilityCurveConfig }
     *     
     */
    public void setCurve(VolatilityCurveConfig value) {
        this.curve = value;
    }

    /**
     * strikeSurface 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link VolatilityStrikeSurfaceConfig }
     *     
     */
    public VolatilityStrikeSurfaceConfig getStrikeSurface() {
        return strikeSurface;
    }

    /**
     * strikeSurface 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link VolatilityStrikeSurfaceConfig }
     *     
     */
    public void setStrikeSurface(VolatilityStrikeSurfaceConfig value) {
        this.strikeSurface = value;
    }

    /**
     * proxySurface 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ProxySurface }
     *     
     */
    public ProxySurface getProxySurface() {
        return proxySurface;
    }

    /**
     * proxySurface 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ProxySurface }
     *     
     */
    public void setProxySurface(ProxySurface value) {
        this.proxySurface = value;
    }

    /**
     * dayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayCounter() {
        return dayCounter;
    }

    /**
     * dayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayCounter(String value) {
        this.dayCounter = value;
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
     * strikeType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrikeType() {
        return strikeType;
    }

    /**
     * strikeType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrikeType(String value) {
        this.strikeType = value;
    }

    /**
     * quoteName 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuoteName() {
        return quoteName;
    }

    /**
     * quoteName 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuoteName(String value) {
        this.quoteName = value;
    }

    /**
     * strikeFactor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStrikeFactor() {
        return strikeFactor;
    }

    /**
     * strikeFactor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStrikeFactor(BigDecimal value) {
        this.strikeFactor = value;
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
     *         &lt;element name="Term" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Label" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Curve" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "term"
    })
    public static class Terms {

        @XmlElement(name = "Term", required = true)
        protected List<CdsVolatility.Terms.Term> term;

        /**
         * Gets the value of the term property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the term property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTerm().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CdsVolatility.Terms.Term }
         * 
         * 
         */
        public List<CdsVolatility.Terms.Term> getTerm() {
            if (term == null) {
                term = new ArrayList<CdsVolatility.Terms.Term>();
            }
            return this.term;
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
         *         &lt;element name="Label" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Curve" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        public static class Term {

            @XmlElement(name = "Label", required = true)
            protected String label;
            @XmlElement(name = "Curve", required = true)
            protected String curve;

            /**
             * label 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLabel() {
                return label;
            }

            /**
             * label 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLabel(String value) {
                this.label = value;
            }

            /**
             * curve 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCurve() {
                return curve;
            }

            /**
             * curve 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCurve(String value) {
                this.curve = value;
            }

        }

    }

}
