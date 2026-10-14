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
 * <p>baseCorrelation complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="baseCorrelation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Terms" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DetachmentPoints" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SettlementDays" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Calendar" type="{}calendar"/>
 *         &lt;element name="BusinessDayConvention" type="{}businessDayConvention"/>
 *         &lt;element name="DayCounter" type="{}dayCounter"/>
 *         &lt;element name="Extrapolate" type="{}bool" minOccurs="0"/>
 *         &lt;element name="QuoteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="Rule" type="{}dateRule" minOccurs="0"/>
 *         &lt;element name="AdjustForLosses" type="{}bool" minOccurs="0"/>
 *         &lt;element name="IndexTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndexSpread" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CalibrateConstituentsToIndexSpread" type="{}bool" minOccurs="0"/>
 *         &lt;element name="UseAssumedRecovery" type="{}bool" minOccurs="0"/>
 *         &lt;element name="RecoveryGrid" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Grid" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="seniority" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RecoveryProbabilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Probabilities" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="seniority" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="QuoteTypes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="QuoteType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
@XmlType(name = "baseCorrelation", propOrder = {

})
public class BaseCorrelation {

    @XmlElement(name = "CurveId", required = true)
    protected String curveId;
    @XmlElement(name = "CurveDescription", required = true)
    protected String curveDescription;
    @XmlElement(name = "Terms", required = true)
    protected String terms;
    @XmlElement(name = "DetachmentPoints", required = true)
    protected String detachmentPoints;
    @XmlElement(name = "SettlementDays")
    protected float settlementDays;
    @XmlElement(name = "Calendar", required = true)
    protected String calendar;
    @XmlElement(name = "BusinessDayConvention", required = true)
    protected String businessDayConvention;
    @XmlElement(name = "DayCounter", required = true)
    protected String dayCounter;
    @XmlElement(name = "Extrapolate")
    protected String extrapolate;
    @XmlElement(name = "QuoteName")
    protected String quoteName;
    @XmlElement(name = "StartDate")
    protected String startDate;
    @XmlElement(name = "Rule")
    protected String rule;
    @XmlElement(name = "AdjustForLosses")
    protected String adjustForLosses;
    @XmlElement(name = "IndexTerm")
    protected String indexTerm;
    @XmlElement(name = "IndexSpread")
    protected String indexSpread;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "CalibrateConstituentsToIndexSpread")
    protected String calibrateConstituentsToIndexSpread;
    @XmlElement(name = "UseAssumedRecovery")
    protected String useAssumedRecovery;
    @XmlElement(name = "RecoveryGrid")
    protected BaseCorrelation.RecoveryGrid recoveryGrid;
    @XmlElement(name = "RecoveryProbabilities")
    protected BaseCorrelation.RecoveryProbabilities recoveryProbabilities;
    @XmlElement(name = "QuoteTypes")
    protected BaseCorrelation.QuoteTypes quoteTypes;

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
     *     {@link String }
     *     
     */
    public String getTerms() {
        return terms;
    }

    /**
     * terms 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerms(String value) {
        this.terms = value;
    }

    /**
     * detachmentPoints 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetachmentPoints() {
        return detachmentPoints;
    }

    /**
     * detachmentPoints 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetachmentPoints(String value) {
        this.detachmentPoints = value;
    }

    /**
     * settlementDays 속성의 값을 가져옵니다.
     * 
     */
    public float getSettlementDays() {
        return settlementDays;
    }

    /**
     * settlementDays 속성의 값을 설정합니다.
     * 
     */
    public void setSettlementDays(float value) {
        this.settlementDays = value;
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
     * businessDayConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessDayConvention() {
        return businessDayConvention;
    }

    /**
     * businessDayConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessDayConvention(String value) {
        this.businessDayConvention = value;
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
     * extrapolate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtrapolate() {
        return extrapolate;
    }

    /**
     * extrapolate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtrapolate(String value) {
        this.extrapolate = value;
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
     * adjustForLosses 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdjustForLosses() {
        return adjustForLosses;
    }

    /**
     * adjustForLosses 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdjustForLosses(String value) {
        this.adjustForLosses = value;
    }

    /**
     * indexTerm 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexTerm() {
        return indexTerm;
    }

    /**
     * indexTerm 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexTerm(String value) {
        this.indexTerm = value;
    }

    /**
     * indexSpread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexSpread() {
        return indexSpread;
    }

    /**
     * indexSpread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexSpread(String value) {
        this.indexSpread = value;
    }

    /**
     * currency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * currency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * calibrateConstituentsToIndexSpread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalibrateConstituentsToIndexSpread() {
        return calibrateConstituentsToIndexSpread;
    }

    /**
     * calibrateConstituentsToIndexSpread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalibrateConstituentsToIndexSpread(String value) {
        this.calibrateConstituentsToIndexSpread = value;
    }

    /**
     * useAssumedRecovery 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseAssumedRecovery() {
        return useAssumedRecovery;
    }

    /**
     * useAssumedRecovery 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseAssumedRecovery(String value) {
        this.useAssumedRecovery = value;
    }

    /**
     * recoveryGrid 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BaseCorrelation.RecoveryGrid }
     *     
     */
    public BaseCorrelation.RecoveryGrid getRecoveryGrid() {
        return recoveryGrid;
    }

    /**
     * recoveryGrid 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseCorrelation.RecoveryGrid }
     *     
     */
    public void setRecoveryGrid(BaseCorrelation.RecoveryGrid value) {
        this.recoveryGrid = value;
    }

    /**
     * recoveryProbabilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BaseCorrelation.RecoveryProbabilities }
     *     
     */
    public BaseCorrelation.RecoveryProbabilities getRecoveryProbabilities() {
        return recoveryProbabilities;
    }

    /**
     * recoveryProbabilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseCorrelation.RecoveryProbabilities }
     *     
     */
    public void setRecoveryProbabilities(BaseCorrelation.RecoveryProbabilities value) {
        this.recoveryProbabilities = value;
    }

    /**
     * quoteTypes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BaseCorrelation.QuoteTypes }
     *     
     */
    public BaseCorrelation.QuoteTypes getQuoteTypes() {
        return quoteTypes;
    }

    /**
     * quoteTypes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseCorrelation.QuoteTypes }
     *     
     */
    public void setQuoteTypes(BaseCorrelation.QuoteTypes value) {
        this.quoteTypes = value;
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
     *         &lt;element name="QuoteType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "quoteType"
    })
    public static class QuoteTypes {

        @XmlElement(name = "QuoteType", required = true)
        protected List<String> quoteType;

        /**
         * Gets the value of the quoteType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the quoteType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getQuoteType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getQuoteType() {
            if (quoteType == null) {
                quoteType = new ArrayList<String>();
            }
            return this.quoteType;
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
     *         &lt;element name="Grid" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="seniority" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "grid"
    })
    public static class RecoveryGrid {

        @XmlElement(name = "Grid", required = true)
        protected List<BaseCorrelation.RecoveryGrid.Grid> grid;

        /**
         * Gets the value of the grid property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the grid property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGrid().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BaseCorrelation.RecoveryGrid.Grid }
         * 
         * 
         */
        public List<BaseCorrelation.RecoveryGrid.Grid> getGrid() {
            if (grid == null) {
                grid = new ArrayList<BaseCorrelation.RecoveryGrid.Grid>();
            }
            return this.grid;
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
         *       &lt;attribute name="seniority" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class Grid {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "seniority", required = true)
            protected String seniority;

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
             * seniority 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSeniority() {
                return seniority;
            }

            /**
             * seniority 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSeniority(String value) {
                this.seniority = value;
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
     *         &lt;element name="Probabilities" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="seniority" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "probabilities"
    })
    public static class RecoveryProbabilities {

        @XmlElement(name = "Probabilities", required = true)
        protected List<BaseCorrelation.RecoveryProbabilities.Probabilities> probabilities;

        /**
         * Gets the value of the probabilities property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the probabilities property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProbabilities().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BaseCorrelation.RecoveryProbabilities.Probabilities }
         * 
         * 
         */
        public List<BaseCorrelation.RecoveryProbabilities.Probabilities> getProbabilities() {
            if (probabilities == null) {
                probabilities = new ArrayList<BaseCorrelation.RecoveryProbabilities.Probabilities>();
            }
            return this.probabilities;
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
         *       &lt;attribute name="seniority" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class Probabilities {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "seniority", required = true)
            protected String seniority;

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
             * seniority 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSeniority() {
                return seniority;
            }

            /**
             * seniority 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSeniority(String value) {
                this.seniority = value;
            }

        }

    }

}
