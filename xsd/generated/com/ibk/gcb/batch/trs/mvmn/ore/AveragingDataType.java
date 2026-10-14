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
 * <p>averagingDataType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="averagingDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CommodityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Period" type="{}averagingDataPeriodType"/>
 *         &lt;element name="PricingCalendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UseBusinessDays" type="{}bool" minOccurs="0"/>
 *         &lt;element name="DeliveryRollDays" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="FutureMonthOffset" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="DailyExpiryOffset" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "averagingDataType", propOrder = {

})
public class AveragingDataType {

    @XmlElement(name = "CommodityName", required = true)
    protected String commodityName;
    @XmlElement(name = "Period", required = true)
    @XmlSchemaType(name = "string")
    protected AveragingDataPeriodType period;
    @XmlElement(name = "PricingCalendar", required = true)
    protected String pricingCalendar;
    @XmlElement(name = "Conventions", required = true)
    protected String conventions;
    @XmlElement(name = "UseBusinessDays")
    protected String useBusinessDays;
    @XmlElement(name = "DeliveryRollDays")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger deliveryRollDays;
    @XmlElement(name = "FutureMonthOffset")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger futureMonthOffset;
    @XmlElement(name = "DailyExpiryOffset")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger dailyExpiryOffset;

    /**
     * commodityName 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * commodityName 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommodityName(String value) {
        this.commodityName = value;
    }

    /**
     * period 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AveragingDataPeriodType }
     *     
     */
    public AveragingDataPeriodType getPeriod() {
        return period;
    }

    /**
     * period 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AveragingDataPeriodType }
     *     
     */
    public void setPeriod(AveragingDataPeriodType value) {
        this.period = value;
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
     * conventions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConventions() {
        return conventions;
    }

    /**
     * conventions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConventions(String value) {
        this.conventions = value;
    }

    /**
     * useBusinessDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseBusinessDays() {
        return useBusinessDays;
    }

    /**
     * useBusinessDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseBusinessDays(String value) {
        this.useBusinessDays = value;
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

}
