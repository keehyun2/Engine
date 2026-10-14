//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>commodityAveragePriceOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="commodityAveragePriceOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="OptionData" type="{}optionData"/>
 *         &lt;element name="BarrierData" type="{}barrierData" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="PriceType" type="{}priceType"/>
 *         &lt;element name="StartDate" type="{}date"/>
 *         &lt;element name="EndDate" type="{}date"/>
 *         &lt;element name="PaymentCalendar" type="{}calendar"/>
 *         &lt;element name="PaymentLag" type="{}paymentLag"/>
 *         &lt;element name="PaymentConvention" type="{}businessDayConvention"/>
 *         &lt;element name="PricingCalendar" type="{}calendar"/>
 *         &lt;element name="PaymentDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="Gearing" type="{}positiveDecimal" minOccurs="0"/>
 *         &lt;element name="Spread" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="CommodityQuantityFrequency" type="{}commodityQuantityFrequencyType" minOccurs="0"/>
 *         &lt;element name="CommodityPayRelativeTo" type="{}commodityPayRelativeToType" minOccurs="0"/>
 *         &lt;element name="FutureMonthOffset" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="DeliveryRollDays" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="IncludePeriodEnd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commodityAveragePriceOptionData", propOrder = {

})
public class CommodityAveragePriceOptionData {

    @XmlElement(name = "OptionData", required = true)
    protected OptionData optionData;
    @XmlElement(name = "BarrierData")
    protected BarrierData barrierData;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "Quantity")
    protected float quantity;
    @XmlElement(name = "Strike")
    protected float strike;
    @XmlElement(name = "PriceType", required = true)
    @XmlSchemaType(name = "string")
    protected PriceType priceType;
    @XmlElement(name = "StartDate", required = true)
    protected String startDate;
    @XmlElement(name = "EndDate", required = true)
    protected String endDate;
    @XmlElement(name = "PaymentCalendar", required = true)
    protected String paymentCalendar;
    @XmlElement(name = "PaymentLag", required = true)
    protected String paymentLag;
    @XmlElement(name = "PaymentConvention", required = true)
    protected String paymentConvention;
    @XmlElement(name = "PricingCalendar", required = true)
    protected String pricingCalendar;
    @XmlElement(name = "PaymentDate")
    protected String paymentDate;
    @XmlElement(name = "Gearing")
    protected BigDecimal gearing;
    @XmlElement(name = "Spread")
    protected Float spread;
    @XmlElement(name = "CommodityQuantityFrequency")
    @XmlSchemaType(name = "string")
    protected CommodityQuantityFrequencyType commodityQuantityFrequency;
    @XmlElement(name = "CommodityPayRelativeTo")
    @XmlSchemaType(name = "string")
    protected CommodityPayRelativeToType commodityPayRelativeTo;
    @XmlElement(name = "FutureMonthOffset")
    protected BigInteger futureMonthOffset;
    @XmlElement(name = "DeliveryRollDays")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger deliveryRollDays;
    @XmlElement(name = "IncludePeriodEnd")
    protected Boolean includePeriodEnd;
    @XmlElement(name = "FXIndex")
    protected String fxIndex;

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
     * barrierData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BarrierData }
     *     
     */
    public BarrierData getBarrierData() {
        return barrierData;
    }

    /**
     * barrierData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BarrierData }
     *     
     */
    public void setBarrierData(BarrierData value) {
        this.barrierData = value;
    }

    /**
     * name 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * name 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * currency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getCurrency() {
        return currency;
    }

    /**
     * currency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setCurrency(CurrencyCode value) {
        this.currency = value;
    }

    /**
     * quantity 속성의 값을 가져옵니다.
     * 
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     * quantity 속성의 값을 설정합니다.
     * 
     */
    public void setQuantity(float value) {
        this.quantity = value;
    }

    /**
     * strike 속성의 값을 가져옵니다.
     * 
     */
    public float getStrike() {
        return strike;
    }

    /**
     * strike 속성의 값을 설정합니다.
     * 
     */
    public void setStrike(float value) {
        this.strike = value;
    }

    /**
     * priceType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PriceType }
     *     
     */
    public PriceType getPriceType() {
        return priceType;
    }

    /**
     * priceType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceType }
     *     
     */
    public void setPriceType(PriceType value) {
        this.priceType = value;
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
     * endDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * endDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * paymentCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentCalendar() {
        return paymentCalendar;
    }

    /**
     * paymentCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentCalendar(String value) {
        this.paymentCalendar = value;
    }

    /**
     * paymentLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentLag() {
        return paymentLag;
    }

    /**
     * paymentLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentLag(String value) {
        this.paymentLag = value;
    }

    /**
     * paymentConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentConvention() {
        return paymentConvention;
    }

    /**
     * paymentConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentConvention(String value) {
        this.paymentConvention = value;
    }

    /**
     * pricingCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricingCalendar() {
        return pricingCalendar;
    }

    /**
     * pricingCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricingCalendar(String value) {
        this.pricingCalendar = value;
    }

    /**
     * paymentDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * paymentDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDate(String value) {
        this.paymentDate = value;
    }

    /**
     * gearing 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGearing() {
        return gearing;
    }

    /**
     * gearing 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGearing(BigDecimal value) {
        this.gearing = value;
    }

    /**
     * spread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSpread() {
        return spread;
    }

    /**
     * spread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSpread(Float value) {
        this.spread = value;
    }

    /**
     * commodityQuantityFrequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityQuantityFrequencyType }
     *     
     */
    public CommodityQuantityFrequencyType getCommodityQuantityFrequency() {
        return commodityQuantityFrequency;
    }

    /**
     * commodityQuantityFrequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityQuantityFrequencyType }
     *     
     */
    public void setCommodityQuantityFrequency(CommodityQuantityFrequencyType value) {
        this.commodityQuantityFrequency = value;
    }

    /**
     * commodityPayRelativeTo 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityPayRelativeToType }
     *     
     */
    public CommodityPayRelativeToType getCommodityPayRelativeTo() {
        return commodityPayRelativeTo;
    }

    /**
     * commodityPayRelativeTo 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityPayRelativeToType }
     *     
     */
    public void setCommodityPayRelativeTo(CommodityPayRelativeToType value) {
        this.commodityPayRelativeTo = value;
    }

    /**
     * futureMonthOffset 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFutureMonthOffset() {
        return futureMonthOffset;
    }

    /**
     * futureMonthOffset 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFutureMonthOffset(BigInteger value) {
        this.futureMonthOffset = value;
    }

    /**
     * deliveryRollDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDeliveryRollDays() {
        return deliveryRollDays;
    }

    /**
     * deliveryRollDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDeliveryRollDays(BigInteger value) {
        this.deliveryRollDays = value;
    }

    /**
     * includePeriodEnd 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludePeriodEnd() {
        return includePeriodEnd;
    }

    /**
     * includePeriodEnd 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludePeriodEnd(Boolean value) {
        this.includePeriodEnd = value;
    }

    /**
     * fxIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFXIndex() {
        return fxIndex;
    }

    /**
     * fxIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXIndex(String value) {
        this.fxIndex = value;
    }

}
