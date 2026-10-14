//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>forwardBondData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="forwardBondData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="BondData" type="{}bondData"/>
 *         &lt;element name="SettlementData" type="{}settlementData"/>
 *         &lt;element name="PremiumData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LongInForward" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="KnockOut" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "forwardBondData", propOrder = {

})
public class ForwardBondData {

    @XmlElement(name = "BondData", required = true)
    protected BondData bondData;
    @XmlElement(name = "SettlementData", required = true)
    protected SettlementData settlementData;
    @XmlElement(name = "PremiumData")
    protected ForwardBondData.PremiumData premiumData;
    @XmlElement(name = "LongInForward", required = true)
    protected String longInForward;
    @XmlElement(name = "KnockOut")
    protected Boolean knockOut;

    /**
     * bondData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BondData }
     *     
     */
    public BondData getBondData() {
        return bondData;
    }

    /**
     * bondData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BondData }
     *     
     */
    public void setBondData(BondData value) {
        this.bondData = value;
    }

    /**
     * settlementData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SettlementData }
     *     
     */
    public SettlementData getSettlementData() {
        return settlementData;
    }

    /**
     * settlementData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementData }
     *     
     */
    public void setSettlementData(SettlementData value) {
        this.settlementData = value;
    }

    /**
     * premiumData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ForwardBondData.PremiumData }
     *     
     */
    public ForwardBondData.PremiumData getPremiumData() {
        return premiumData;
    }

    /**
     * premiumData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ForwardBondData.PremiumData }
     *     
     */
    public void setPremiumData(ForwardBondData.PremiumData value) {
        this.premiumData = value;
    }

    /**
     * longInForward 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongInForward() {
        return longInForward;
    }

    /**
     * longInForward 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongInForward(String value) {
        this.longInForward = value;
    }

    /**
     * knockOut 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isKnockOut() {
        return knockOut;
    }

    /**
     * knockOut 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setKnockOut(Boolean value) {
        this.knockOut = value;
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
     *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    public static class PremiumData {

        @XmlElement(name = "Amount", required = true)
        protected String amount;
        @XmlElement(name = "Date", required = true)
        protected String date;

        /**
         * amount 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAmount() {
            return amount;
        }

        /**
         * amount 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAmount(String value) {
            this.amount = value;
        }

        /**
         * date 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDate() {
            return date;
        }

        /**
         * date 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDate(String value) {
            this.date = value;
        }

    }

}
