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
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import org.w3c.dom.Element;


/**
 * <p>simmCalibration complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="simmCalibration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="VersionNames">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AdditionalFields" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InterestRate" type="{}interestRate"/>
 *         &lt;element name="CreditQualifying" type="{}creditQualifying"/>
 *         &lt;element name="CreditNonQualifying" type="{}creditNonQualifying"/>
 *         &lt;element name="Equity" type="{}equity"/>
 *         &lt;element name="Commodity" type="{}commodity"/>
 *         &lt;element name="FX" type="{}fx"/>
 *         &lt;element name="RiskClassCorrelations">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Correlation" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
 *                           &lt;attribute name="label1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="label2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simmCalibration", propOrder = {

})
public class SimmCalibration {

    @XmlElement(name = "VersionNames", required = true)
    protected SimmCalibration.VersionNames versionNames;
    @XmlElement(name = "AdditionalFields")
    protected SimmCalibration.AdditionalFields additionalFields;
    @XmlElement(name = "InterestRate", required = true)
    protected InterestRate interestRate;
    @XmlElement(name = "CreditQualifying", required = true)
    protected CreditQualifying creditQualifying;
    @XmlElement(name = "CreditNonQualifying", required = true)
    protected CreditNonQualifying creditNonQualifying;
    @XmlElement(name = "Equity", required = true)
    protected Equity equity;
    @XmlElement(name = "Commodity", required = true)
    protected Commodity commodity;
    @XmlElement(name = "FX", required = true)
    protected Fx fx;
    @XmlElement(name = "RiskClassCorrelations", required = true)
    protected SimmCalibration.RiskClassCorrelations riskClassCorrelations;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * versionNames 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SimmCalibration.VersionNames }
     *     
     */
    public SimmCalibration.VersionNames getVersionNames() {
        return versionNames;
    }

    /**
     * versionNames 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SimmCalibration.VersionNames }
     *     
     */
    public void setVersionNames(SimmCalibration.VersionNames value) {
        this.versionNames = value;
    }

    /**
     * additionalFields 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SimmCalibration.AdditionalFields }
     *     
     */
    public SimmCalibration.AdditionalFields getAdditionalFields() {
        return additionalFields;
    }

    /**
     * additionalFields 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SimmCalibration.AdditionalFields }
     *     
     */
    public void setAdditionalFields(SimmCalibration.AdditionalFields value) {
        this.additionalFields = value;
    }

    /**
     * interestRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link InterestRate }
     *     
     */
    public InterestRate getInterestRate() {
        return interestRate;
    }

    /**
     * interestRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link InterestRate }
     *     
     */
    public void setInterestRate(InterestRate value) {
        this.interestRate = value;
    }

    /**
     * creditQualifying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CreditQualifying }
     *     
     */
    public CreditQualifying getCreditQualifying() {
        return creditQualifying;
    }

    /**
     * creditQualifying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditQualifying }
     *     
     */
    public void setCreditQualifying(CreditQualifying value) {
        this.creditQualifying = value;
    }

    /**
     * creditNonQualifying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CreditNonQualifying }
     *     
     */
    public CreditNonQualifying getCreditNonQualifying() {
        return creditNonQualifying;
    }

    /**
     * creditNonQualifying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditNonQualifying }
     *     
     */
    public void setCreditNonQualifying(CreditNonQualifying value) {
        this.creditNonQualifying = value;
    }

    /**
     * equity 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Equity }
     *     
     */
    public Equity getEquity() {
        return equity;
    }

    /**
     * equity 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Equity }
     *     
     */
    public void setEquity(Equity value) {
        this.equity = value;
    }

    /**
     * commodity 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Commodity }
     *     
     */
    public Commodity getCommodity() {
        return commodity;
    }

    /**
     * commodity 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Commodity }
     *     
     */
    public void setCommodity(Commodity value) {
        this.commodity = value;
    }

    /**
     * fx 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Fx }
     *     
     */
    public Fx getFX() {
        return fx;
    }

    /**
     * fx 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Fx }
     *     
     */
    public void setFX(Fx value) {
        this.fx = value;
    }

    /**
     * riskClassCorrelations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SimmCalibration.RiskClassCorrelations }
     *     
     */
    public SimmCalibration.RiskClassCorrelations getRiskClassCorrelations() {
        return riskClassCorrelations;
    }

    /**
     * riskClassCorrelations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SimmCalibration.RiskClassCorrelations }
     *     
     */
    public void setRiskClassCorrelations(SimmCalibration.RiskClassCorrelations value) {
        this.riskClassCorrelations = value;
    }

    /**
     * id 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * id 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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
     *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
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
        "any"
    })
    public static class AdditionalFields {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * {@link Element }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
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
     *         &lt;element name="Correlation" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
     *                 &lt;attribute name="label1" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="label2" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "correlation"
    })
    public static class RiskClassCorrelations {

        @XmlElement(name = "Correlation", required = true)
        protected List<SimmCalibration.RiskClassCorrelations.Correlation> correlation;

        /**
         * Gets the value of the correlation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the correlation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCorrelation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SimmCalibration.RiskClassCorrelations.Correlation }
         * 
         * 
         */
        public List<SimmCalibration.RiskClassCorrelations.Correlation> getCorrelation() {
            if (correlation == null) {
                correlation = new ArrayList<SimmCalibration.RiskClassCorrelations.Correlation>();
            }
            return this.correlation;
        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
         *       &lt;attribute name="label1" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="label2" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class Correlation {

            @XmlValue
            protected BigDecimal value;
            @XmlAttribute(name = "label1")
            protected String label1;
            @XmlAttribute(name = "label2")
            protected String label2;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValue(BigDecimal value) {
                this.value = value;
            }

            /**
             * label1 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLabel1() {
                return label1;
            }

            /**
             * label1 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLabel1(String value) {
                this.label1 = value;
            }

            /**
             * label2 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLabel2() {
                return label2;
            }

            /**
             * label2 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLabel2(String value) {
                this.label2 = value;
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
     *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "name"
    })
    public static class VersionNames {

        @XmlElement(name = "Name", required = true)
        protected List<String> name;

        /**
         * Gets the value of the name property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the name property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getName() {
            if (name == null) {
                name = new ArrayList<String>();
            }
            return this.name;
        }

    }

}
