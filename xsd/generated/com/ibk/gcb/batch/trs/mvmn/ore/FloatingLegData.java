//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
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
 *         &lt;element name="Index" type="{}indexNameType"/>
 *         &lt;element name="IsInArrears" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LastRecentPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastRecentPeriodCalendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="FixingDays" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="Lookback" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RateCutoff" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="IsAveraged" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HasSubPeriods" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeSpread" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsNotResettingXCCY" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Spreads" type="{}spreads" minOccurs="0"/>
 *         &lt;element name="Caps" type="{}caps" minOccurs="0"/>
 *         &lt;element name="Floors" type="{}floors" minOccurs="0"/>
 *         &lt;element name="Gearings" type="{}gearings" minOccurs="0"/>
 *         &lt;element name="NakedOption" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LocalCapFloor" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FixingSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="ResetSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="HistoricalFixings" type="{}tradeLevelFixings" minOccurs="0"/>
 *         &lt;element name="FrontStubInterpolation" type="{}stubInterpolation" minOccurs="0"/>
 *         &lt;element name="BackStubInterpolation" type="{}stubInterpolation" minOccurs="0"/>
 *         &lt;element name="StubUseOriginalCurve" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
public class FloatingLegData {

    @XmlElement(name = "Index", required = true)
    protected String index;
    @XmlElement(name = "IsInArrears")
    protected Boolean isInArrears;
    @XmlElement(name = "LastRecentPeriod")
    protected String lastRecentPeriod;
    @XmlElement(name = "LastRecentPeriodCalendar")
    protected String lastRecentPeriodCalendar;
    @XmlElement(name = "FixingDays")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger fixingDays;
    @XmlElement(name = "Lookback")
    protected String lookback;
    @XmlElement(name = "RateCutoff")
    protected BigInteger rateCutoff;
    @XmlElement(name = "IsAveraged")
    protected Boolean isAveraged;
    @XmlElement(name = "HasSubPeriods")
    protected Boolean hasSubPeriods;
    @XmlElement(name = "IncludeSpread")
    protected Boolean includeSpread;
    @XmlElement(name = "IsNotResettingXCCY")
    protected Boolean isNotResettingXCCY;
    @XmlElement(name = "Spreads")
    protected Spreads spreads;
    @XmlElement(name = "Caps")
    protected Caps caps;
    @XmlElement(name = "Floors")
    protected Floors floors;
    @XmlElement(name = "Gearings")
    protected Gearings gearings;
    @XmlElement(name = "NakedOption")
    protected Boolean nakedOption;
    @XmlElement(name = "LocalCapFloor")
    protected Boolean localCapFloor;
    @XmlElement(name = "FixingSchedule")
    protected ScheduleData fixingSchedule;
    @XmlElement(name = "ResetSchedule")
    protected ScheduleData resetSchedule;
    @XmlElement(name = "HistoricalFixings")
    protected TradeLevelFixings historicalFixings;
    @XmlElement(name = "FrontStubInterpolation")
    protected StubInterpolation frontStubInterpolation;
    @XmlElement(name = "BackStubInterpolation")
    protected StubInterpolation backStubInterpolation;
    @XmlElement(name = "StubUseOriginalCurve")
    protected Boolean stubUseOriginalCurve;

    /**
     * index 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndex() {
        return index;
    }

    /**
     * index 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndex(String value) {
        this.index = value;
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
     * lastRecentPeriod 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastRecentPeriod() {
        return lastRecentPeriod;
    }

    /**
     * lastRecentPeriod 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastRecentPeriod(String value) {
        this.lastRecentPeriod = value;
    }

    /**
     * lastRecentPeriodCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastRecentPeriodCalendar() {
        return lastRecentPeriodCalendar;
    }

    /**
     * lastRecentPeriodCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastRecentPeriodCalendar(String value) {
        this.lastRecentPeriodCalendar = value;
    }

    /**
     * fixingDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFixingDays() {
        return fixingDays;
    }

    /**
     * fixingDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFixingDays(BigInteger value) {
        this.fixingDays = value;
    }

    /**
     * lookback 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLookback() {
        return lookback;
    }

    /**
     * lookback 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLookback(String value) {
        this.lookback = value;
    }

    /**
     * rateCutoff 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRateCutoff() {
        return rateCutoff;
    }

    /**
     * rateCutoff 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRateCutoff(BigInteger value) {
        this.rateCutoff = value;
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
     * hasSubPeriods 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasSubPeriods() {
        return hasSubPeriods;
    }

    /**
     * hasSubPeriods 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasSubPeriods(Boolean value) {
        this.hasSubPeriods = value;
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
     * isNotResettingXCCY 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsNotResettingXCCY() {
        return isNotResettingXCCY;
    }

    /**
     * isNotResettingXCCY 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNotResettingXCCY(Boolean value) {
        this.isNotResettingXCCY = value;
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
     * caps 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Caps }
     *     
     */
    public Caps getCaps() {
        return caps;
    }

    /**
     * caps 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Caps }
     *     
     */
    public void setCaps(Caps value) {
        this.caps = value;
    }

    /**
     * floors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Floors }
     *     
     */
    public Floors getFloors() {
        return floors;
    }

    /**
     * floors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Floors }
     *     
     */
    public void setFloors(Floors value) {
        this.floors = value;
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
     * localCapFloor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLocalCapFloor() {
        return localCapFloor;
    }

    /**
     * localCapFloor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLocalCapFloor(Boolean value) {
        this.localCapFloor = value;
    }

    /**
     * fixingSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getFixingSchedule() {
        return fixingSchedule;
    }

    /**
     * fixingSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setFixingSchedule(ScheduleData value) {
        this.fixingSchedule = value;
    }

    /**
     * resetSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getResetSchedule() {
        return resetSchedule;
    }

    /**
     * resetSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setResetSchedule(ScheduleData value) {
        this.resetSchedule = value;
    }

    /**
     * historicalFixings 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TradeLevelFixings }
     *     
     */
    public TradeLevelFixings getHistoricalFixings() {
        return historicalFixings;
    }

    /**
     * historicalFixings 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeLevelFixings }
     *     
     */
    public void setHistoricalFixings(TradeLevelFixings value) {
        this.historicalFixings = value;
    }

    /**
     * frontStubInterpolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StubInterpolation }
     *     
     */
    public StubInterpolation getFrontStubInterpolation() {
        return frontStubInterpolation;
    }

    /**
     * frontStubInterpolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StubInterpolation }
     *     
     */
    public void setFrontStubInterpolation(StubInterpolation value) {
        this.frontStubInterpolation = value;
    }

    /**
     * backStubInterpolation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StubInterpolation }
     *     
     */
    public StubInterpolation getBackStubInterpolation() {
        return backStubInterpolation;
    }

    /**
     * backStubInterpolation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StubInterpolation }
     *     
     */
    public void setBackStubInterpolation(StubInterpolation value) {
        this.backStubInterpolation = value;
    }

    /**
     * stubUseOriginalCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStubUseOriginalCurve() {
        return stubUseOriginalCurve;
    }

    /**
     * stubUseOriginalCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStubUseOriginalCurve(Boolean value) {
        this.stubUseOriginalCurve = value;
    }

}
