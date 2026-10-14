//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PriceType" type="{}priceType"/>
 *         &lt;element name="Quantities" type="{}quantitiesType"/>
 *         &lt;element name="CommodityQuantityFrequency" type="{}commodityQuantityFrequencyType" minOccurs="0"/>
 *         &lt;element name="CommodityPayRelativeTo" type="{}commodityPayRelativeToType" minOccurs="0"/>
 *         &lt;element name="Spreads" type="{}spreads" minOccurs="0"/>
 *         &lt;element name="Gearings" type="{}gearings" minOccurs="0"/>
 *         &lt;element name="PricingDateRule" type="{}pricingDateRuleType" minOccurs="0"/>
 *         &lt;element name="PricingCalendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="PricingLag" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="PricingDates" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PricingDate" type="{}date" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IsAveraged" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsInArrears" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FutureMonthOffset" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="DeliveryRollDays" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="DailyExpiryOffset" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="IncludePeriodEnd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ExcludePeriodStart" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HoursPerDay" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="UseBusinessDays" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UnrealisedQuantity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LastNDays" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="Tag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AvgPricePrecision" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
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
public class CommodityFloatingLegData {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "PriceType", required = true)
    @XmlSchemaType(name = "string")
    protected PriceType priceType;
    @XmlElement(name = "Quantities", required = true)
    protected QuantitiesType quantities;
    @XmlElement(name = "CommodityQuantityFrequency")
    @XmlSchemaType(name = "string")
    protected CommodityQuantityFrequencyType commodityQuantityFrequency;
    @XmlElement(name = "CommodityPayRelativeTo")
    @XmlSchemaType(name = "string")
    protected CommodityPayRelativeToType commodityPayRelativeTo;
    @XmlElement(name = "Spreads")
    protected Spreads spreads;
    @XmlElement(name = "Gearings")
    protected Gearings gearings;
    @XmlElement(name = "PricingDateRule")
    @XmlSchemaType(name = "string")
    protected PricingDateRuleType pricingDateRule;
    @XmlElement(name = "PricingCalendar")
    protected String pricingCalendar;
    @XmlElement(name = "PricingLag")
    protected BigInteger pricingLag;
    @XmlElement(name = "PricingDates")
    protected CommodityFloatingLegData.PricingDates pricingDates;
    @XmlElement(name = "IsAveraged")
    protected Boolean isAveraged;
    @XmlElement(name = "IsInArrears")
    protected Boolean isInArrears;
    @XmlElement(name = "FutureMonthOffset")
    protected BigInteger futureMonthOffset;
    @XmlElement(name = "DeliveryRollDays")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger deliveryRollDays;
    @XmlElement(name = "DailyExpiryOffset")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger dailyExpiryOffset;
    @XmlElement(name = "IncludePeriodEnd")
    protected Boolean includePeriodEnd;
    @XmlElement(name = "ExcludePeriodStart")
    protected Boolean excludePeriodStart;
    @XmlElement(name = "HoursPerDay")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger hoursPerDay;
    @XmlElement(name = "UseBusinessDays")
    protected Boolean useBusinessDays;
    @XmlElement(name = "UnrealisedQuantity")
    protected Boolean unrealisedQuantity;
    @XmlElement(name = "LastNDays")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger lastNDays;
    @XmlElement(name = "Tag")
    protected String tag;
    @XmlElement(name = "FXIndex")
    protected String fxIndex;
    @XmlElement(name = "AvgPricePrecision")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger avgPricePrecision;

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
     * quantities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link QuantitiesType }
     *     
     */
    public QuantitiesType getQuantities() {
        return quantities;
    }

    /**
     * quantities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantitiesType }
     *     
     */
    public void setQuantities(QuantitiesType value) {
        this.quantities = value;
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
     * spreads 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Spreads }
     *     
     */
    public Spreads getSpreads() {
        return spreads;
    }

    /**
     * spreads 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Spreads }
     *     
     */
    public void setSpreads(Spreads value) {
        this.spreads = value;
    }

    /**
     * gearings 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Gearings }
     *     
     */
    public Gearings getGearings() {
        return gearings;
    }

    /**
     * gearings 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Gearings }
     *     
     */
    public void setGearings(Gearings value) {
        this.gearings = value;
    }

    /**
     * pricingDateRule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PricingDateRuleType }
     *     
     */
    public PricingDateRuleType getPricingDateRule() {
        return pricingDateRule;
    }

    /**
     * pricingDateRule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PricingDateRuleType }
     *     
     */
    public void setPricingDateRule(PricingDateRuleType value) {
        this.pricingDateRule = value;
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
     * pricingLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPricingLag() {
        return pricingLag;
    }

    /**
     * pricingLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPricingLag(BigInteger value) {
        this.pricingLag = value;
    }

    /**
     * pricingDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommodityFloatingLegData.PricingDates }
     *     
     */
    public CommodityFloatingLegData.PricingDates getPricingDates() {
        return pricingDates;
    }

    /**
     * pricingDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityFloatingLegData.PricingDates }
     *     
     */
    public void setPricingDates(CommodityFloatingLegData.PricingDates value) {
        this.pricingDates = value;
    }

    /**
     * isAveraged 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAveraged() {
        return isAveraged;
    }

    /**
     * isAveraged 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAveraged(Boolean value) {
        this.isAveraged = value;
    }

    /**
     * isInArrears 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsInArrears() {
        return isInArrears;
    }

    /**
     * isInArrears 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsInArrears(Boolean value) {
        this.isInArrears = value;
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
     * dailyExpiryOffset 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDailyExpiryOffset() {
        return dailyExpiryOffset;
    }

    /**
     * dailyExpiryOffset 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDailyExpiryOffset(BigInteger value) {
        this.dailyExpiryOffset = value;
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
     * excludePeriodStart 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExcludePeriodStart() {
        return excludePeriodStart;
    }

    /**
     * excludePeriodStart 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExcludePeriodStart(Boolean value) {
        this.excludePeriodStart = value;
    }

    /**
     * hoursPerDay 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHoursPerDay() {
        return hoursPerDay;
    }

    /**
     * hoursPerDay 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHoursPerDay(BigInteger value) {
        this.hoursPerDay = value;
    }

    /**
     * useBusinessDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseBusinessDays() {
        return useBusinessDays;
    }

    /**
     * useBusinessDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseBusinessDays(Boolean value) {
        this.useBusinessDays = value;
    }

    /**
     * unrealisedQuantity 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUnrealisedQuantity() {
        return unrealisedQuantity;
    }

    /**
     * unrealisedQuantity 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUnrealisedQuantity(Boolean value) {
        this.unrealisedQuantity = value;
    }

    /**
     * lastNDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLastNDays() {
        return lastNDays;
    }

    /**
     * lastNDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLastNDays(BigInteger value) {
        this.lastNDays = value;
    }

    /**
     * tag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag() {
        return tag;
    }

    /**
     * tag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag(String value) {
        this.tag = value;
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

    /**
     * avgPricePrecision 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAvgPricePrecision() {
        return avgPricePrecision;
    }

    /**
     * avgPricePrecision 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAvgPricePrecision(BigInteger value) {
        this.avgPricePrecision = value;
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
     *         &lt;element name="PricingDate" type="{}date" maxOccurs="unbounded"/>
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
        "pricingDate"
    })
    public static class PricingDates {

        @XmlElement(name = "PricingDate", required = true)
        protected List<String> pricingDate;

        /**
         * Gets the value of the pricingDate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the pricingDate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPricingDate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getPricingDate() {
            if (pricingDate == null) {
                pricingDate = new ArrayList<String>();
            }
            return this.pricingDate;
        }

    }

}
