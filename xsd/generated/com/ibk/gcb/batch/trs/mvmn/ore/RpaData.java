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
 * <p>rpaData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="rpaData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ParticipationRate" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="ProtectionStart" type="{}date"/>
 *         &lt;element name="ProtectionEnd" type="{}date"/>
 *         &lt;element name="CreditCurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IssuerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlesAccrual" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FixedRecoveryRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ProtectionFee">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LegData" type="{}legData" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Underlying">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;sequence>
 *                     &lt;element name="OptionData" type="{}optionData" minOccurs="0"/>
 *                     &lt;element name="NakedOption" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                     &lt;element name="LegData" type="{}legData" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                   &lt;element name="TreasuryLockData" type="{}tlockData"/>
 *                 &lt;/choice>
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
@XmlType(name = "rpaData", propOrder = {

})
public class RpaData {

    @XmlElement(name = "ParticipationRate")
    protected float participationRate;
    @XmlElement(name = "ProtectionStart", required = true)
    protected String protectionStart;
    @XmlElement(name = "ProtectionEnd", required = true)
    protected String protectionEnd;
    @XmlElement(name = "CreditCurveId", required = true)
    protected String creditCurveId;
    @XmlElement(name = "IssuerId")
    protected String issuerId;
    @XmlElement(name = "SettlesAccrual")
    protected Boolean settlesAccrual;
    @XmlElement(name = "FixedRecoveryRate")
    protected Float fixedRecoveryRate;
    @XmlElement(name = "ProtectionFee", required = true)
    protected RpaData.ProtectionFee protectionFee;
    @XmlElement(name = "Underlying", required = true)
    protected RpaData.Underlying underlying;

    /**
     * participationRate 속성의 값을 가져옵니다.
     * 
     */
    public float getParticipationRate() {
        return participationRate;
    }

    /**
     * participationRate 속성의 값을 설정합니다.
     * 
     */
    public void setParticipationRate(float value) {
        this.participationRate = value;
    }

    /**
     * protectionStart 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtectionStart() {
        return protectionStart;
    }

    /**
     * protectionStart 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtectionStart(String value) {
        this.protectionStart = value;
    }

    /**
     * protectionEnd 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtectionEnd() {
        return protectionEnd;
    }

    /**
     * protectionEnd 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtectionEnd(String value) {
        this.protectionEnd = value;
    }

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
     * issuerId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerId() {
        return issuerId;
    }

    /**
     * issuerId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerId(String value) {
        this.issuerId = value;
    }

    /**
     * settlesAccrual 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSettlesAccrual() {
        return settlesAccrual;
    }

    /**
     * settlesAccrual 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSettlesAccrual(Boolean value) {
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
     * protectionFee 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RpaData.ProtectionFee }
     *     
     */
    public RpaData.ProtectionFee getProtectionFee() {
        return protectionFee;
    }

    /**
     * protectionFee 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RpaData.ProtectionFee }
     *     
     */
    public void setProtectionFee(RpaData.ProtectionFee value) {
        this.protectionFee = value;
    }

    /**
     * underlying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RpaData.Underlying }
     *     
     */
    public RpaData.Underlying getUnderlying() {
        return underlying;
    }

    /**
     * underlying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RpaData.Underlying }
     *     
     */
    public void setUnderlying(RpaData.Underlying value) {
        this.underlying = value;
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
     *         &lt;element name="LegData" type="{}legData" maxOccurs="unbounded"/>
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
    public static class ProtectionFee {

        @XmlElement(name = "LegData", required = true)
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
     *       &lt;choice>
     *         &lt;sequence>
     *           &lt;element name="OptionData" type="{}optionData" minOccurs="0"/>
     *           &lt;element name="NakedOption" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *           &lt;element name="LegData" type="{}legData" maxOccurs="unbounded"/>
     *         &lt;/sequence>
     *         &lt;element name="TreasuryLockData" type="{}tlockData"/>
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
        "optionData",
        "nakedOption",
        "legData",
        "treasuryLockData"
    })
    public static class Underlying {

        @XmlElement(name = "OptionData")
        protected OptionData optionData;
        @XmlElement(name = "NakedOption")
        protected Boolean nakedOption;
        @XmlElement(name = "LegData")
        protected List<LegData> legData;
        @XmlElement(name = "TreasuryLockData")
        protected TlockData treasuryLockData;

        /**
         * optionData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link OptionData }
         *     
         */
        public OptionData getOptionData() {
            return optionData;
        }

        /**
         * optionData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link OptionData }
         *     
         */
        public void setOptionData(OptionData value) {
            this.optionData = value;
        }

        /**
         * nakedOption 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNakedOption() {
            return nakedOption;
        }

        /**
         * nakedOption 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNakedOption(Boolean value) {
            this.nakedOption = value;
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
         * treasuryLockData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link TlockData }
         *     
         */
        public TlockData getTreasuryLockData() {
            return treasuryLockData;
        }

        /**
         * treasuryLockData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link TlockData }
         *     
         */
        public void setTreasuryLockData(TlockData value) {
            this.treasuryLockData = value;
        }

    }

}
