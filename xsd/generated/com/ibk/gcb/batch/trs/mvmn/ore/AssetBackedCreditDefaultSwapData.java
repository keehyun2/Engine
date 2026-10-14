//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>assetBackedCreditDefaultSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="assetBackedCreditDefaultSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="BondData" type="{}bondData"/>
 *         &lt;element name="ProtectionSide" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Notional" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="PremiumRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="PremiumDayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="PremiumData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="LegType" type="{}legType"/>
 *                   &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *                   &lt;element ref="{}legDataType"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ProtectionStart" type="{}date" minOccurs="0"/>
 *         &lt;element name="ProtectionEnd" type="{}date" minOccurs="0"/>
 *         &lt;element name="SettlesAccrual" type="{}bool" minOccurs="0"/>
 *         &lt;element name="PaysAtDefaultTime" type="{}bool" minOccurs="0"/>
 *         &lt;element name="ProtectionPaymentTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UpfrontDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="UpfrontFee" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="FixedRecoveryRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="TradeDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="CashSettlementDays" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="FullFirstCoupon" type="{}bool" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assetBackedCreditDefaultSwapData", propOrder = {

})
public class AssetBackedCreditDefaultSwapData {

    @XmlElement(name = "BondData", required = true)
    protected BondData bondData;
    @XmlElement(name = "ProtectionSide", required = true)
    protected String protectionSide;
    @XmlElement(name = "Notional")
    protected float notional;
    @XmlElement(name = "PremiumRate")
    protected Float premiumRate;
    @XmlElement(name = "PremiumDayCounter")
    protected String premiumDayCounter;
    @XmlElement(name = "PremiumData")
    protected AssetBackedCreditDefaultSwapData.PremiumData premiumData;
    @XmlElement(name = "ProtectionStart")
    protected String protectionStart;
    @XmlElement(name = "ProtectionEnd")
    protected String protectionEnd;
    @XmlElement(name = "SettlesAccrual")
    protected String settlesAccrual;
    @XmlElement(name = "PaysAtDefaultTime")
    protected String paysAtDefaultTime;
    @XmlElement(name = "ProtectionPaymentTime")
    protected String protectionPaymentTime;
    @XmlElement(name = "UpfrontDate")
    protected String upfrontDate;
    @XmlElement(name = "UpfrontFee")
    protected Float upfrontFee;
    @XmlElement(name = "FixedRecoveryRate")
    protected Float fixedRecoveryRate;
    @XmlElement(name = "TradeDate")
    protected String tradeDate;
    @XmlElement(name = "CashSettlementDays")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cashSettlementDays;
    @XmlElement(name = "FullFirstCoupon")
    protected String fullFirstCoupon;

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
     * protectionSide 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtectionSide() {
        return protectionSide;
    }

    /**
     * protectionSide 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtectionSide(String value) {
        this.protectionSide = value;
    }

    /**
     * notional 속성의 값을 가져옵니다.
     * 
     */
    public float getNotional() {
        return notional;
    }

    /**
     * notional 속성의 값을 설정합니다.
     * 
     */
    public void setNotional(float value) {
        this.notional = value;
    }

    /**
     * premiumRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPremiumRate() {
        return premiumRate;
    }

    /**
     * premiumRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPremiumRate(Float value) {
        this.premiumRate = value;
    }

    /**
     * premiumDayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiumDayCounter() {
        return premiumDayCounter;
    }

    /**
     * premiumDayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiumDayCounter(String value) {
        this.premiumDayCounter = value;
    }

    /**
     * premiumData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AssetBackedCreditDefaultSwapData.PremiumData }
     *     
     */
    public AssetBackedCreditDefaultSwapData.PremiumData getPremiumData() {
        return premiumData;
    }

    /**
     * premiumData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetBackedCreditDefaultSwapData.PremiumData }
     *     
     */
    public void setPremiumData(AssetBackedCreditDefaultSwapData.PremiumData value) {
        this.premiumData = value;
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
     * paysAtDefaultTime 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaysAtDefaultTime() {
        return paysAtDefaultTime;
    }

    /**
     * paysAtDefaultTime 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaysAtDefaultTime(String value) {
        this.paysAtDefaultTime = value;
    }

    /**
     * protectionPaymentTime 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtectionPaymentTime() {
        return protectionPaymentTime;
    }

    /**
     * protectionPaymentTime 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtectionPaymentTime(String value) {
        this.protectionPaymentTime = value;
    }

    /**
     * upfrontDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpfrontDate() {
        return upfrontDate;
    }

    /**
     * upfrontDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpfrontDate(String value) {
        this.upfrontDate = value;
    }

    /**
     * upfrontFee 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getUpfrontFee() {
        return upfrontFee;
    }

    /**
     * upfrontFee 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setUpfrontFee(Float value) {
        this.upfrontFee = value;
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
     * tradeDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeDate() {
        return tradeDate;
    }

    /**
     * tradeDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeDate(String value) {
        this.tradeDate = value;
    }

    /**
     * cashSettlementDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCashSettlementDays() {
        return cashSettlementDays;
    }

    /**
     * cashSettlementDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCashSettlementDays(BigInteger value) {
        this.cashSettlementDays = value;
    }

    /**
     * fullFirstCoupon 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullFirstCoupon() {
        return fullFirstCoupon;
    }

    /**
     * fullFirstCoupon 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullFirstCoupon(String value) {
        this.fullFirstCoupon = value;
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
     *         &lt;element name="LegType" type="{}legType"/>
     *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
     *         &lt;element ref="{}legDataType"/>
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

        @XmlElement(name = "LegType", required = true)
        @XmlSchemaType(name = "string")
        protected LegType legType;
        @XmlElement(name = "DayCounter")
        protected String dayCounter;
        @XmlElementRef(name = "legDataType", type = JAXBElement.class)
        protected JAXBElement<?> legDataType;

        /**
         * legType 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link LegType }
         *     
         */
        public LegType getLegType() {
            return legType;
        }

        /**
         * legType 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link LegType }
         *     
         */
        public void setLegType(LegType value) {
            this.legType = value;
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
         * legDataType 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link FloatingLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CommodityFixedLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CashflowData }{@code >}
         *     {@link JAXBElement }{@code <}{@link DigitalCMSLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link Object }{@code >}
         *     {@link JAXBElement }{@code <}{@link FormulaBasedLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link DurationAdjustedCMSLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link YYLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CMSSpreadLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CPILegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link ZeroCouponFixedLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link EquityLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link FixedLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CommodityFloatingLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CMSLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CMBLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link EquityMarginLegData }{@code >}
         *     
         */
        public JAXBElement<?> getLegDataType() {
            return legDataType;
        }

        /**
         * legDataType 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link FloatingLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CommodityFixedLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CashflowData }{@code >}
         *     {@link JAXBElement }{@code <}{@link DigitalCMSLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link Object }{@code >}
         *     {@link JAXBElement }{@code <}{@link FormulaBasedLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link DurationAdjustedCMSLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link YYLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CMSSpreadLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CPILegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link ZeroCouponFixedLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link EquityLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link FixedLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CommodityFloatingLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CMSLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link CMBLegData }{@code >}
         *     {@link JAXBElement }{@code <}{@link EquityMarginLegData }{@code >}
         *     
         */
        public void setLegDataType(JAXBElement<?> value) {
            this.legDataType = value;
        }

    }

}
