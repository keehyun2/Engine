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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>creditLinkedSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="creditLinkedSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CreditCurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SettlesAccrual" type="{}bool" minOccurs="0"/>
 *         &lt;element name="FixedRecoveryRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="DefaultPaymentTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndependentPayments" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LegData" type="{}legData" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ContingentPayments" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LegData" type="{}legData" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DefaultPayments" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LegData" type="{}legData" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RecoveryPayments" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LegData" type="{}legData" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "creditLinkedSwapData", propOrder = {

})
public class CreditLinkedSwapData {

    @XmlElement(name = "CreditCurveId", required = true)
    protected String creditCurveId;
    @XmlElement(name = "SettlesAccrual")
    protected String settlesAccrual;
    @XmlElement(name = "FixedRecoveryRate")
    protected Float fixedRecoveryRate;
    @XmlElement(name = "DefaultPaymentTime")
    protected String defaultPaymentTime;
    @XmlElement(name = "IndependentPayments")
    protected CreditLinkedSwapData.IndependentPayments independentPayments;
    @XmlElement(name = "ContingentPayments")
    protected CreditLinkedSwapData.ContingentPayments contingentPayments;
    @XmlElement(name = "DefaultPayments")
    protected CreditLinkedSwapData.DefaultPayments defaultPayments;
    @XmlElement(name = "RecoveryPayments")
    protected CreditLinkedSwapData.RecoveryPayments recoveryPayments;

    /**
     * creditCurveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCurveId() {
        return creditCurveId;
    }

    /**
     * creditCurveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCurveId(String value) {
        this.creditCurveId = value;
    }

    /**
     * settlesAccrual 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlesAccrual() {
        return settlesAccrual;
    }

    /**
     * settlesAccrual 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlesAccrual(String value) {
        this.settlesAccrual = value;
    }

    /**
     * fixedRecoveryRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFixedRecoveryRate() {
        return fixedRecoveryRate;
    }

    /**
     * fixedRecoveryRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFixedRecoveryRate(Float value) {
        this.fixedRecoveryRate = value;
    }

    /**
     * defaultPaymentTime 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultPaymentTime() {
        return defaultPaymentTime;
    }

    /**
     * defaultPaymentTime 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultPaymentTime(String value) {
        this.defaultPaymentTime = value;
    }

    /**
     * independentPayments 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CreditLinkedSwapData.IndependentPayments }
     *     
     */
    public CreditLinkedSwapData.IndependentPayments getIndependentPayments() {
        return independentPayments;
    }

    /**
     * independentPayments 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditLinkedSwapData.IndependentPayments }
     *     
     */
    public void setIndependentPayments(CreditLinkedSwapData.IndependentPayments value) {
        this.independentPayments = value;
    }

    /**
     * contingentPayments 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CreditLinkedSwapData.ContingentPayments }
     *     
     */
    public CreditLinkedSwapData.ContingentPayments getContingentPayments() {
        return contingentPayments;
    }

    /**
     * contingentPayments 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditLinkedSwapData.ContingentPayments }
     *     
     */
    public void setContingentPayments(CreditLinkedSwapData.ContingentPayments value) {
        this.contingentPayments = value;
    }

    /**
     * defaultPayments 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CreditLinkedSwapData.DefaultPayments }
     *     
     */
    public CreditLinkedSwapData.DefaultPayments getDefaultPayments() {
        return defaultPayments;
    }

    /**
     * defaultPayments 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditLinkedSwapData.DefaultPayments }
     *     
     */
    public void setDefaultPayments(CreditLinkedSwapData.DefaultPayments value) {
        this.defaultPayments = value;
    }

    /**
     * recoveryPayments 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CreditLinkedSwapData.RecoveryPayments }
     *     
     */
    public CreditLinkedSwapData.RecoveryPayments getRecoveryPayments() {
        return recoveryPayments;
    }

    /**
     * recoveryPayments 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditLinkedSwapData.RecoveryPayments }
     *     
     */
    public void setRecoveryPayments(CreditLinkedSwapData.RecoveryPayments value) {
        this.recoveryPayments = value;
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
     *         &lt;element name="LegData" type="{}legData" maxOccurs="unbounded" minOccurs="0"/>
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
        "legData"
    })
    public static class ContingentPayments {

        @XmlElement(name = "LegData")
        protected List<LegData> legData;

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
     *         &lt;element name="LegData" type="{}legData" maxOccurs="unbounded" minOccurs="0"/>
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
        "legData"
    })
    public static class DefaultPayments {

        @XmlElement(name = "LegData")
        protected List<LegData> legData;

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
     *         &lt;element name="LegData" type="{}legData" maxOccurs="unbounded" minOccurs="0"/>
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
        "legData"
    })
    public static class IndependentPayments {

        @XmlElement(name = "LegData")
        protected List<LegData> legData;

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
     *         &lt;element name="LegData" type="{}legData" maxOccurs="unbounded" minOccurs="0"/>
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
        "legData"
    })
    public static class RecoveryPayments {

        @XmlElement(name = "LegData")
        protected List<LegData> legData;

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

    }

}
