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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>basketVarianceSwapData2 complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="basketVarianceSwapData2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LongShort" type="{}longShort"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Notional" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Underlyings" type="{}underlyings"/>
 *         &lt;element name="ValuationSchedule" type="{}scheduleData"/>
 *         &lt;element name="SquaredPayoff" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Cap" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Floor" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="SettlementDate" type="{}date"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "basketVarianceSwapData2", propOrder = {

})
public class BasketVarianceSwapData2 {

    @XmlElement(name = "LongShort", required = true)
    @XmlSchemaType(name = "string")
    protected LongShort longShort;
    @XmlElement(name = "Strike")
    protected float strike;
    @XmlElement(name = "Notional")
    protected float notional;
    @XmlElement(name = "Underlyings", required = true)
    protected Underlyings underlyings;
    @XmlElement(name = "ValuationSchedule", required = true)
    protected ScheduleData valuationSchedule;
    @XmlElement(name = "SquaredPayoff")
    protected boolean squaredPayoff;
    @XmlElement(name = "Cap")
    protected Float cap;
    @XmlElement(name = "Floor")
    protected Float floor;
    @XmlElement(name = "SettlementDate", required = true)
    protected String settlementDate;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;

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
     * valuationSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getValuationSchedule() {
        return valuationSchedule;
    }

    /**
     * valuationSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setValuationSchedule(ScheduleData value) {
        this.valuationSchedule = value;
    }

    /**
     * squaredPayoff 속성의 값을 가져옵니다.
     * 
     */
    public boolean isSquaredPayoff() {
        return squaredPayoff;
    }

    /**
     * squaredPayoff 속성의 값을 설정합니다.
     * 
     */
    public void setSquaredPayoff(boolean value) {
        this.squaredPayoff = value;
    }

    /**
     * cap 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCap() {
        return cap;
    }

    /**
     * cap 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCap(Float value) {
        this.cap = value;
    }

    /**
     * floor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFloor() {
        return floor;
    }

    /**
     * floor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFloor(Float value) {
        this.floor = value;
    }

    /**
     * settlementDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementDate() {
        return settlementDate;
    }

    /**
     * settlementDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementDate(String value) {
        this.settlementDate = value;
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

}
