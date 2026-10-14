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
 * <p>performanceOption01Data complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="performanceOption01Data">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="NotionalAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="ParticipationRate" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="ValuationDate" type="{}date"/>
 *         &lt;element name="SettlementDate" type="{}date"/>
 *         &lt;element name="Underlyings" type="{}underlyings"/>
 *         &lt;element name="StrikePrices">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StrikePrice" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="StrikeIncluded" type="{}bool" minOccurs="0"/>
 *         &lt;element name="Position" type="{}longShort"/>
 *         &lt;element name="PayCcy" type="{}currencyCode"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "performanceOption01Data", propOrder = {

})
public class PerformanceOption01Data {

    @XmlElement(name = "NotionalAmount")
    protected float notionalAmount;
    @XmlElement(name = "ParticipationRate")
    protected float participationRate;
    @XmlElement(name = "ValuationDate", required = true)
    protected String valuationDate;
    @XmlElement(name = "SettlementDate", required = true)
    protected String settlementDate;
    @XmlElement(name = "Underlyings", required = true)
    protected Underlyings underlyings;
    @XmlElement(name = "StrikePrices", required = true)
    protected PerformanceOption01Data.StrikePrices strikePrices;
    @XmlElement(name = "Strike")
    protected float strike;
    @XmlElement(name = "StrikeIncluded")
    protected String strikeIncluded;
    @XmlElement(name = "Position", required = true)
    @XmlSchemaType(name = "string")
    protected LongShort position;
    @XmlElement(name = "PayCcy", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode payCcy;

    /**
     * notionalAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getNotionalAmount() {
        return notionalAmount;
    }

    /**
     * notionalAmount 속성의 값을 설정합니다.
     * 
     */
    public void setNotionalAmount(float value) {
        this.notionalAmount = value;
    }

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
     * valuationDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValuationDate() {
        return valuationDate;
    }

    /**
     * valuationDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValuationDate(String value) {
        this.valuationDate = value;
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
     * strikePrices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PerformanceOption01Data.StrikePrices }
     *     
     */
    public PerformanceOption01Data.StrikePrices getStrikePrices() {
        return strikePrices;
    }

    /**
     * strikePrices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PerformanceOption01Data.StrikePrices }
     *     
     */
    public void setStrikePrices(PerformanceOption01Data.StrikePrices value) {
        this.strikePrices = value;
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
     * strikeIncluded 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrikeIncluded() {
        return strikeIncluded;
    }

    /**
     * strikeIncluded 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrikeIncluded(String value) {
        this.strikeIncluded = value;
    }

    /**
     * position 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LongShort }
     *     
     */
    public LongShort getPosition() {
        return position;
    }

    /**
     * position 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LongShort }
     *     
     */
    public void setPosition(LongShort value) {
        this.position = value;
    }

    /**
     * payCcy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getPayCcy() {
        return payCcy;
    }

    /**
     * payCcy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setPayCcy(CurrencyCode value) {
        this.payCcy = value;
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
     *         &lt;element name="StrikePrice" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
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
        "strikePrice"
    })
    public static class StrikePrices {

        @XmlElement(name = "StrikePrice", type = Float.class)
        protected List<Float> strikePrice;

        /**
         * Gets the value of the strikePrice property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the strikePrice property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStrikePrice().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Float }
         * 
         * 
         */
        public List<Float> getStrikePrice() {
            if (strikePrice == null) {
                strikePrice = new ArrayList<Float>();
            }
            return this.strikePrice;
        }

    }

}
