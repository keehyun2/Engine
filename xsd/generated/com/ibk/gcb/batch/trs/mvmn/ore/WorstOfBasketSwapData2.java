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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>worstOfBasketSwapData2 complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="worstOfBasketSwapData2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{}longShort"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="InitialFixedRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="InitialFixedPayDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="Underlyings" type="{}underlyings"/>
 *         &lt;element name="InitialPrices">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="InitialPrice" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="KnockInPayDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="FloatingPeriodSchedule" type="{}scheduleData"/>
 *         &lt;element name="FloatingFixingSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="FixedDeterminationSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="FloatingPayDates" type="{}scheduleData"/>
 *         &lt;element name="FixedPayDates" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="KnockOutDeterminationSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="FixedAccrualSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="KnockOutLevels">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="KnockOutLevel" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BermudanKnockIn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FixedTriggerLevels">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FixedTriggerLevel" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="KnockInLevel" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="KnockInDeterminationSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="FixedRate" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="AccumulatingFixedCoupons" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AccruingFixedCoupons" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FloatingIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FloatingSpread" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="FloatingLookback" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FloatingRateCutoff" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FloatingDayCountFraction" type="{}dayCounter"/>
 *         &lt;element name="IsAveraged" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeSpread" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "worstOfBasketSwapData2", propOrder = {

})
public class WorstOfBasketSwapData2 {

    @XmlElement(name = "LongShort", required = true)
    @XmlSchemaType(name = "string")
    protected LongShort longShort;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "Quantity")
    protected float quantity;
    @XmlElement(name = "InitialFixedRate")
    protected Float initialFixedRate;
    @XmlElement(name = "InitialFixedPayDate")
    protected String initialFixedPayDate;
    @XmlElement(name = "Underlyings", required = true)
    protected Underlyings underlyings;
    @XmlElement(name = "InitialPrices", required = true)
    protected WorstOfBasketSwapData2 .InitialPrices initialPrices;
    @XmlElement(name = "KnockInPayDate")
    protected String knockInPayDate;
    @XmlElement(name = "FloatingPeriodSchedule", required = true)
    protected ScheduleData floatingPeriodSchedule;
    @XmlElement(name = "FloatingFixingSchedule")
    protected ScheduleData floatingFixingSchedule;
    @XmlElement(name = "FixedDeterminationSchedule")
    protected ScheduleData fixedDeterminationSchedule;
    @XmlElement(name = "FloatingPayDates", required = true)
    protected ScheduleData floatingPayDates;
    @XmlElement(name = "FixedPayDates")
    protected ScheduleData fixedPayDates;
    @XmlElement(name = "KnockOutDeterminationSchedule")
    protected ScheduleData knockOutDeterminationSchedule;
    @XmlElement(name = "FixedAccrualSchedule")
    protected ScheduleData fixedAccrualSchedule;
    @XmlElement(name = "KnockOutLevels", required = true)
    protected WorstOfBasketSwapData2 .KnockOutLevels knockOutLevels;
    @XmlElement(name = "BermudanKnockIn")
    protected Boolean bermudanKnockIn;
    @XmlElement(name = "FixedTriggerLevels", required = true)
    protected WorstOfBasketSwapData2 .FixedTriggerLevels fixedTriggerLevels;
    @XmlElement(name = "KnockInLevel")
    protected Float knockInLevel;
    @XmlElement(name = "KnockInDeterminationSchedule")
    protected ScheduleData knockInDeterminationSchedule;
    @XmlElement(name = "FixedRate")
    protected float fixedRate;
    @XmlElement(name = "AccumulatingFixedCoupons")
    protected Boolean accumulatingFixedCoupons;
    @XmlElement(name = "AccruingFixedCoupons")
    protected Boolean accruingFixedCoupons;
    @XmlElement(name = "FloatingIndex", required = true)
    protected String floatingIndex;
    @XmlElement(name = "FloatingSpread")
    protected Float floatingSpread;
    @XmlElement(name = "FloatingLookback")
    protected String floatingLookback;
    @XmlElement(name = "FloatingRateCutoff")
    protected String floatingRateCutoff;
    @XmlElement(name = "FloatingDayCountFraction", required = true)
    protected String floatingDayCountFraction;
    @XmlElement(name = "IsAveraged")
    protected Boolean isAveraged;
    @XmlElement(name = "IncludeSpread")
    protected Boolean includeSpread;
    @XmlElement(name = "Strike")
    protected Float strike;

    /**
     * longShort 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LongShort }
     *     
     */
    public LongShort getLongShort() {
        return longShort;
    }

    /**
     * longShort 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LongShort }
     *     
     */
    public void setLongShort(LongShort value) {
        this.longShort = value;
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
     * initialFixedRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getInitialFixedRate() {
        return initialFixedRate;
    }

    /**
     * initialFixedRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setInitialFixedRate(Float value) {
        this.initialFixedRate = value;
    }

    /**
     * initialFixedPayDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialFixedPayDate() {
        return initialFixedPayDate;
    }

    /**
     * initialFixedPayDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialFixedPayDate(String value) {
        this.initialFixedPayDate = value;
    }

    /**
     * underlyings 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlyings }
     *     
     */
    public Underlyings getUnderlyings() {
        return underlyings;
    }

    /**
     * underlyings 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlyings }
     *     
     */
    public void setUnderlyings(Underlyings value) {
        this.underlyings = value;
    }

    /**
     * initialPrices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstOfBasketSwapData2 .InitialPrices }
     *     
     */
    public WorstOfBasketSwapData2 .InitialPrices getInitialPrices() {
        return initialPrices;
    }

    /**
     * initialPrices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstOfBasketSwapData2 .InitialPrices }
     *     
     */
    public void setInitialPrices(WorstOfBasketSwapData2 .InitialPrices value) {
        this.initialPrices = value;
    }

    /**
     * knockInPayDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKnockInPayDate() {
        return knockInPayDate;
    }

    /**
     * knockInPayDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKnockInPayDate(String value) {
        this.knockInPayDate = value;
    }

    /**
     * floatingPeriodSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getFloatingPeriodSchedule() {
        return floatingPeriodSchedule;
    }

    /**
     * floatingPeriodSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setFloatingPeriodSchedule(ScheduleData value) {
        this.floatingPeriodSchedule = value;
    }

    /**
     * floatingFixingSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getFloatingFixingSchedule() {
        return floatingFixingSchedule;
    }

    /**
     * floatingFixingSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setFloatingFixingSchedule(ScheduleData value) {
        this.floatingFixingSchedule = value;
    }

    /**
     * fixedDeterminationSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getFixedDeterminationSchedule() {
        return fixedDeterminationSchedule;
    }

    /**
     * fixedDeterminationSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setFixedDeterminationSchedule(ScheduleData value) {
        this.fixedDeterminationSchedule = value;
    }

    /**
     * floatingPayDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getFloatingPayDates() {
        return floatingPayDates;
    }

    /**
     * floatingPayDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setFloatingPayDates(ScheduleData value) {
        this.floatingPayDates = value;
    }

    /**
     * fixedPayDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getFixedPayDates() {
        return fixedPayDates;
    }

    /**
     * fixedPayDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setFixedPayDates(ScheduleData value) {
        this.fixedPayDates = value;
    }

    /**
     * knockOutDeterminationSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getKnockOutDeterminationSchedule() {
        return knockOutDeterminationSchedule;
    }

    /**
     * knockOutDeterminationSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setKnockOutDeterminationSchedule(ScheduleData value) {
        this.knockOutDeterminationSchedule = value;
    }

    /**
     * fixedAccrualSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getFixedAccrualSchedule() {
        return fixedAccrualSchedule;
    }

    /**
     * fixedAccrualSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setFixedAccrualSchedule(ScheduleData value) {
        this.fixedAccrualSchedule = value;
    }

    /**
     * knockOutLevels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstOfBasketSwapData2 .KnockOutLevels }
     *     
     */
    public WorstOfBasketSwapData2 .KnockOutLevels getKnockOutLevels() {
        return knockOutLevels;
    }

    /**
     * knockOutLevels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstOfBasketSwapData2 .KnockOutLevels }
     *     
     */
    public void setKnockOutLevels(WorstOfBasketSwapData2 .KnockOutLevels value) {
        this.knockOutLevels = value;
    }

    /**
     * bermudanKnockIn 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBermudanKnockIn() {
        return bermudanKnockIn;
    }

    /**
     * bermudanKnockIn 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBermudanKnockIn(Boolean value) {
        this.bermudanKnockIn = value;
    }

    /**
     * fixedTriggerLevels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link WorstOfBasketSwapData2 .FixedTriggerLevels }
     *     
     */
    public WorstOfBasketSwapData2 .FixedTriggerLevels getFixedTriggerLevels() {
        return fixedTriggerLevels;
    }

    /**
     * fixedTriggerLevels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link WorstOfBasketSwapData2 .FixedTriggerLevels }
     *     
     */
    public void setFixedTriggerLevels(WorstOfBasketSwapData2 .FixedTriggerLevels value) {
        this.fixedTriggerLevels = value;
    }

    /**
     * knockInLevel 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getKnockInLevel() {
        return knockInLevel;
    }

    /**
     * knockInLevel 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setKnockInLevel(Float value) {
        this.knockInLevel = value;
    }

    /**
     * knockInDeterminationSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getKnockInDeterminationSchedule() {
        return knockInDeterminationSchedule;
    }

    /**
     * knockInDeterminationSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setKnockInDeterminationSchedule(ScheduleData value) {
        this.knockInDeterminationSchedule = value;
    }

    /**
     * fixedRate 속성의 값을 가져옵니다.
     * 
     */
    public float getFixedRate() {
        return fixedRate;
    }

    /**
     * fixedRate 속성의 값을 설정합니다.
     * 
     */
    public void setFixedRate(float value) {
        this.fixedRate = value;
    }

    /**
     * accumulatingFixedCoupons 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAccumulatingFixedCoupons() {
        return accumulatingFixedCoupons;
    }

    /**
     * accumulatingFixedCoupons 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAccumulatingFixedCoupons(Boolean value) {
        this.accumulatingFixedCoupons = value;
    }

    /**
     * accruingFixedCoupons 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAccruingFixedCoupons() {
        return accruingFixedCoupons;
    }

    /**
     * accruingFixedCoupons 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAccruingFixedCoupons(Boolean value) {
        this.accruingFixedCoupons = value;
    }

    /**
     * floatingIndex 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloatingIndex() {
        return floatingIndex;
    }

    /**
     * floatingIndex 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloatingIndex(String value) {
        this.floatingIndex = value;
    }

    /**
     * floatingSpread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFloatingSpread() {
        return floatingSpread;
    }

    /**
     * floatingSpread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFloatingSpread(Float value) {
        this.floatingSpread = value;
    }

    /**
     * floatingLookback 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloatingLookback() {
        return floatingLookback;
    }

    /**
     * floatingLookback 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloatingLookback(String value) {
        this.floatingLookback = value;
    }

    /**
     * floatingRateCutoff 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloatingRateCutoff() {
        return floatingRateCutoff;
    }

    /**
     * floatingRateCutoff 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloatingRateCutoff(String value) {
        this.floatingRateCutoff = value;
    }

    /**
     * floatingDayCountFraction 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloatingDayCountFraction() {
        return floatingDayCountFraction;
    }

    /**
     * floatingDayCountFraction 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloatingDayCountFraction(String value) {
        this.floatingDayCountFraction = value;
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
     * includeSpread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSpread() {
        return includeSpread;
    }

    /**
     * includeSpread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSpread(Boolean value) {
        this.includeSpread = value;
    }

    /**
     * strike 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getStrike() {
        return strike;
    }

    /**
     * strike 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setStrike(Float value) {
        this.strike = value;
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
     *         &lt;element name="FixedTriggerLevel" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
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
        "fixedTriggerLevel"
    })
    public static class FixedTriggerLevels {

        @XmlElement(name = "FixedTriggerLevel", type = Float.class)
        protected List<Float> fixedTriggerLevel;

        /**
         * Gets the value of the fixedTriggerLevel property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fixedTriggerLevel property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFixedTriggerLevel().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Float }
         * 
         * 
         */
        public List<Float> getFixedTriggerLevel() {
            if (fixedTriggerLevel == null) {
                fixedTriggerLevel = new ArrayList<Float>();
            }
            return this.fixedTriggerLevel;
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
     *         &lt;element name="InitialPrice" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
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
        "initialPrice"
    })
    public static class InitialPrices {

        @XmlElement(name = "InitialPrice", type = Float.class)
        protected List<Float> initialPrice;

        /**
         * Gets the value of the initialPrice property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the initialPrice property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInitialPrice().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Float }
         * 
         * 
         */
        public List<Float> getInitialPrice() {
            if (initialPrice == null) {
                initialPrice = new ArrayList<Float>();
            }
            return this.initialPrice;
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
     *         &lt;element name="KnockOutLevel" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
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
        "knockOutLevel"
    })
    public static class KnockOutLevels {

        @XmlElement(name = "KnockOutLevel", type = Float.class)
        protected List<Float> knockOutLevel;

        /**
         * Gets the value of the knockOutLevel property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the knockOutLevel property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getKnockOutLevel().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Float }
         * 
         * 
         */
        public List<Float> getKnockOutLevel() {
            if (knockOutLevel == null) {
                knockOutLevel = new ArrayList<Float>();
            }
            return this.knockOutLevel;
        }

    }

}
