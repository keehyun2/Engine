//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>nettingsetdefinitions complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="nettingsetdefinitions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NettingSet" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element ref="{}nettingSetGroup"/>
 *                   &lt;element name="ActiveCSAFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="CSADetails" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Bilateral" type="{}csaType" minOccurs="0"/>
 *                             &lt;element name="CSACurrency" type="{}currencyCode" minOccurs="0"/>
 *                             &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ThresholdPay" type="{}non-negative-decimal" minOccurs="0"/>
 *                             &lt;element name="ThresholdReceive" type="{}non-negative-decimal" minOccurs="0"/>
 *                             &lt;element name="MinimumTransferAmountPay" type="{}non-negative-decimal" minOccurs="0"/>
 *                             &lt;element name="MinimumTransferAmountReceive" type="{}non-negative-decimal" minOccurs="0"/>
 *                             &lt;element name="IndependentAmount" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;all>
 *                                       &lt;element name="IndependentAmountHeld" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                       &lt;element name="IndependentAmountType" type="{}independentAmountType"/>
 *                                     &lt;/all>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="MarginingFrequency" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;all>
 *                                       &lt;element name="CallFrequency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="PostFrequency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/all>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="MarginPeriodOfRisk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CollateralCompoundingSpreadReceive" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                             &lt;element name="CollateralCompoundingSpreadPay" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                             &lt;element name="EligibleCollaterals" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;all>
 *                                       &lt;element name="Currencies">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/all>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="ApplyInitialMargin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                             &lt;element name="InitialMarginType" type="{}csaType" minOccurs="0"/>
 *                             &lt;element name="CalculateIMAmount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                             &lt;element name="CalculateVMAmount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                             &lt;element name="NonExemptIMRegulations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="RiskWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
@XmlType(name = "nettingsetdefinitions", propOrder = {
    "nettingSet"
})
public class Nettingsetdefinitions {

    @XmlElement(name = "NettingSet")
    protected List<Nettingsetdefinitions.NettingSet> nettingSet;

    /**
     * Gets the value of the nettingSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nettingSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNettingSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Nettingsetdefinitions.NettingSet }
     * 
     * 
     */
    public List<Nettingsetdefinitions.NettingSet> getNettingSet() {
        if (nettingSet == null) {
            nettingSet = new ArrayList<Nettingsetdefinitions.NettingSet>();
        }
        return this.nettingSet;
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
     *         &lt;element ref="{}nettingSetGroup"/>
     *         &lt;element name="ActiveCSAFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="CSADetails" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Bilateral" type="{}csaType" minOccurs="0"/>
     *                   &lt;element name="CSACurrency" type="{}currencyCode" minOccurs="0"/>
     *                   &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ThresholdPay" type="{}non-negative-decimal" minOccurs="0"/>
     *                   &lt;element name="ThresholdReceive" type="{}non-negative-decimal" minOccurs="0"/>
     *                   &lt;element name="MinimumTransferAmountPay" type="{}non-negative-decimal" minOccurs="0"/>
     *                   &lt;element name="MinimumTransferAmountReceive" type="{}non-negative-decimal" minOccurs="0"/>
     *                   &lt;element name="IndependentAmount" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;all>
     *                             &lt;element name="IndependentAmountHeld" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                             &lt;element name="IndependentAmountType" type="{}independentAmountType"/>
     *                           &lt;/all>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="MarginingFrequency" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;all>
     *                             &lt;element name="CallFrequency" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="PostFrequency" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/all>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="MarginPeriodOfRisk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CollateralCompoundingSpreadReceive" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *                   &lt;element name="CollateralCompoundingSpreadPay" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *                   &lt;element name="EligibleCollaterals" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;all>
     *                             &lt;element name="Currencies">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/all>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="ApplyInitialMargin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                   &lt;element name="InitialMarginType" type="{}csaType" minOccurs="0"/>
     *                   &lt;element name="CalculateIMAmount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                   &lt;element name="CalculateVMAmount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                   &lt;element name="NonExemptIMRegulations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="RiskWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
    public static class NettingSet {

        @XmlElementRef(name = "nettingSetGroup", type = JAXBElement.class)
        protected JAXBElement<?> nettingSetGroup;
        @XmlElement(name = "ActiveCSAFlag")
        protected Boolean activeCSAFlag;
        @XmlElement(name = "CSADetails")
        protected Nettingsetdefinitions.NettingSet.CSADetails csaDetails;
        @XmlElement(name = "RiskWeight")
        protected BigDecimal riskWeight;

        /**
         * nettingSetGroup 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link NettingSetDetails }{@code >}
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     {@link JAXBElement }{@code <}{@link Object }{@code >}
         *     
         */
        public JAXBElement<?> getNettingSetGroup() {
            return nettingSetGroup;
        }

        /**
         * nettingSetGroup 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link NettingSetDetails }{@code >}
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     {@link JAXBElement }{@code <}{@link Object }{@code >}
         *     
         */
        public void setNettingSetGroup(JAXBElement<?> value) {
            this.nettingSetGroup = value;
        }

        /**
         * activeCSAFlag 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isActiveCSAFlag() {
            return activeCSAFlag;
        }

        /**
         * activeCSAFlag 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setActiveCSAFlag(Boolean value) {
            this.activeCSAFlag = value;
        }

        /**
         * csaDetails 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Nettingsetdefinitions.NettingSet.CSADetails }
         *     
         */
        public Nettingsetdefinitions.NettingSet.CSADetails getCSADetails() {
            return csaDetails;
        }

        /**
         * csaDetails 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Nettingsetdefinitions.NettingSet.CSADetails }
         *     
         */
        public void setCSADetails(Nettingsetdefinitions.NettingSet.CSADetails value) {
            this.csaDetails = value;
        }

        /**
         * riskWeight 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getRiskWeight() {
            return riskWeight;
        }

        /**
         * riskWeight 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setRiskWeight(BigDecimal value) {
            this.riskWeight = value;
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
         *         &lt;element name="Bilateral" type="{}csaType" minOccurs="0"/>
         *         &lt;element name="CSACurrency" type="{}currencyCode" minOccurs="0"/>
         *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ThresholdPay" type="{}non-negative-decimal" minOccurs="0"/>
         *         &lt;element name="ThresholdReceive" type="{}non-negative-decimal" minOccurs="0"/>
         *         &lt;element name="MinimumTransferAmountPay" type="{}non-negative-decimal" minOccurs="0"/>
         *         &lt;element name="MinimumTransferAmountReceive" type="{}non-negative-decimal" minOccurs="0"/>
         *         &lt;element name="IndependentAmount" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;all>
         *                   &lt;element name="IndependentAmountHeld" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *                   &lt;element name="IndependentAmountType" type="{}independentAmountType"/>
         *                 &lt;/all>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="MarginingFrequency" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;all>
         *                   &lt;element name="CallFrequency" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="PostFrequency" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/all>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="MarginPeriodOfRisk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CollateralCompoundingSpreadReceive" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
         *         &lt;element name="CollateralCompoundingSpreadPay" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
         *         &lt;element name="EligibleCollaterals" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;all>
         *                   &lt;element name="Currencies">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
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
         *         &lt;element name="ApplyInitialMargin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *         &lt;element name="InitialMarginType" type="{}csaType" minOccurs="0"/>
         *         &lt;element name="CalculateIMAmount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *         &lt;element name="CalculateVMAmount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *         &lt;element name="NonExemptIMRegulations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "content"
        })
        public static class CSADetails {

            @XmlElementRefs({
                @XmlElementRef(name = "CalculateVMAmount", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "Index", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "EligibleCollaterals", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "ApplyInitialMargin", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "ThresholdReceive", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "NonExemptIMRegulations", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "MarginPeriodOfRisk", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "CollateralCompoundingSpreadReceive", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "CSACurrency", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "InitialMarginType", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "Bilateral", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "MinimumTransferAmountPay", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "CollateralCompoundingSpreadPay", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "ThresholdPay", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "MarginingFrequency", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "MinimumTransferAmountReceive", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "IndependentAmount", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "CalculateIMAmount", type = JAXBElement.class, required = false)
            })
            @XmlMixed
            protected List<Serializable> content;

            /**
             * Gets the value of the content property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the content property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
             * {@link String }
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals }{@code >}
             * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
             * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             * {@link JAXBElement }{@code <}{@link CurrencyCode }{@code >}
             * {@link JAXBElement }{@code <}{@link CsaType }{@code >}
             * {@link JAXBElement }{@code <}{@link CsaType }{@code >}
             * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             * {@link JAXBElement }{@code <}{@link Nettingsetdefinitions.NettingSet.CSADetails.MarginingFrequency }{@code >}
             * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             * {@link JAXBElement }{@code <}{@link Nettingsetdefinitions.NettingSet.CSADetails.IndependentAmount }{@code >}
             * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
             * 
             * 
             */
            public List<Serializable> getContent() {
                if (content == null) {
                    content = new ArrayList<Serializable>();
                }
                return this.content;
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
             *         &lt;element name="Currencies">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
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
            public static class EligibleCollaterals {

                @XmlElement(name = "Currencies", required = true)
                protected Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals.Currencies currencies;

                /**
                 * currencies 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals.Currencies }
                 *     
                 */
                public Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals.Currencies getCurrencies() {
                    return currencies;
                }

                /**
                 * currencies 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals.Currencies }
                 *     
                 */
                public void setCurrencies(Nettingsetdefinitions.NettingSet.CSADetails.EligibleCollaterals.Currencies value) {
                    this.currencies = value;
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
                 *         &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
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
                    "currency"
                })
                public static class Currencies {

                    @XmlElement(name = "Currency")
                    @XmlSchemaType(name = "string")
                    protected List<CurrencyCode> currency;

                    /**
                     * Gets the value of the currency property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the currency property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getCurrency().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link CurrencyCode }
                     * 
                     * 
                     */
                    public List<CurrencyCode> getCurrency() {
                        if (currency == null) {
                            currency = new ArrayList<CurrencyCode>();
                        }
                        return this.currency;
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
             *         &lt;element name="IndependentAmountHeld" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
             *         &lt;element name="IndependentAmountType" type="{}independentAmountType"/>
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
            public static class IndependentAmount {

                @XmlElement(name = "IndependentAmountHeld", required = true)
                protected BigDecimal independentAmountHeld;
                @XmlElement(name = "IndependentAmountType", required = true)
                @XmlSchemaType(name = "string")
                protected IndependentAmountType independentAmountType;

                /**
                 * independentAmountHeld 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getIndependentAmountHeld() {
                    return independentAmountHeld;
                }

                /**
                 * independentAmountHeld 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setIndependentAmountHeld(BigDecimal value) {
                    this.independentAmountHeld = value;
                }

                /**
                 * independentAmountType 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link IndependentAmountType }
                 *     
                 */
                public IndependentAmountType getIndependentAmountType() {
                    return independentAmountType;
                }

                /**
                 * independentAmountType 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link IndependentAmountType }
                 *     
                 */
                public void setIndependentAmountType(IndependentAmountType value) {
                    this.independentAmountType = value;
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
             *         &lt;element name="CallFrequency" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="PostFrequency" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            public static class MarginingFrequency {

                @XmlElement(name = "CallFrequency", required = true)
                protected String callFrequency;
                @XmlElement(name = "PostFrequency", required = true)
                protected String postFrequency;

                /**
                 * callFrequency 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCallFrequency() {
                    return callFrequency;
                }

                /**
                 * callFrequency 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCallFrequency(String value) {
                    this.callFrequency = value;
                }

                /**
                 * postFrequency 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPostFrequency() {
                    return postFrequency;
                }

                /**
                 * postFrequency 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPostFrequency(String value) {
                    this.postFrequency = value;
                }

            }

        }

    }

}
