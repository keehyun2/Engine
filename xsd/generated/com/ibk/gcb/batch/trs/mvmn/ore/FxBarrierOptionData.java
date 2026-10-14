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
 * <p>fxBarrierOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="fxBarrierOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OptionData" type="{}optionData" maxOccurs="unbounded"/>
 *         &lt;element name="BarrierData" type="{}barrierData" maxOccurs="unbounded"/>
 *         &lt;element name="StartDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="Calendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FXIndexDailyLows" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FXIndexDailyHighs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BoughtCurrency" type="{}currencyCode"/>
 *         &lt;element name="BoughtAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="SoldCurrency" type="{}currencyCode"/>
 *         &lt;element name="SoldAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fxBarrierOptionData", propOrder = {
    "optionData",
    "barrierData",
    "startDate",
    "calendar",
    "fxIndex",
    "fxIndexDailyLows",
    "fxIndexDailyHighs",
    "boughtCurrency",
    "boughtAmount",
    "soldCurrency",
    "soldAmount"
})
public class FxBarrierOptionData {

    @XmlElement(name = "OptionData", required = true)
    protected List<OptionData> optionData;
    @XmlElement(name = "BarrierData", required = true)
    protected List<BarrierData> barrierData;
    @XmlElement(name = "StartDate")
    protected String startDate;
    @XmlElement(name = "Calendar")
    protected String calendar;
    @XmlElement(name = "FXIndex")
    protected String fxIndex;
    @XmlElement(name = "FXIndexDailyLows")
    protected String fxIndexDailyLows;
    @XmlElement(name = "FXIndexDailyHighs")
    protected String fxIndexDailyHighs;
    @XmlElement(name = "BoughtCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode boughtCurrency;
    @XmlElement(name = "BoughtAmount")
    protected float boughtAmount;
    @XmlElement(name = "SoldCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode soldCurrency;
    @XmlElement(name = "SoldAmount")
    protected float soldAmount;

    /**
     * Gets the value of the optionData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the optionData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptionData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionData }
     * 
     * 
     */
    public List<OptionData> getOptionData() {
        if (optionData == null) {
            optionData = new ArrayList<OptionData>();
        }
        return this.optionData;
    }

    /**
     * Gets the value of the barrierData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the barrierData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBarrierData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BarrierData }
     * 
     * 
     */
    public List<BarrierData> getBarrierData() {
        if (barrierData == null) {
            barrierData = new ArrayList<BarrierData>();
        }
        return this.barrierData;
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
     * calendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalendar() {
        return calendar;
    }

    /**
     * calendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalendar(String value) {
        this.calendar = value;
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
     * fxIndexDailyLows 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFXIndexDailyLows() {
        return fxIndexDailyLows;
    }

    /**
     * fxIndexDailyLows 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXIndexDailyLows(String value) {
        this.fxIndexDailyLows = value;
    }

    /**
     * fxIndexDailyHighs 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFXIndexDailyHighs() {
        return fxIndexDailyHighs;
    }

    /**
     * fxIndexDailyHighs 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXIndexDailyHighs(String value) {
        this.fxIndexDailyHighs = value;
    }

    /**
     * boughtCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getBoughtCurrency() {
        return boughtCurrency;
    }

    /**
     * boughtCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setBoughtCurrency(CurrencyCode value) {
        this.boughtCurrency = value;
    }

    /**
     * boughtAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getBoughtAmount() {
        return boughtAmount;
    }

    /**
     * boughtAmount 속성의 값을 설정합니다.
     * 
     */
    public void setBoughtAmount(float value) {
        this.boughtAmount = value;
    }

    /**
     * soldCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getSoldCurrency() {
        return soldCurrency;
    }

    /**
     * soldCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setSoldCurrency(CurrencyCode value) {
        this.soldCurrency = value;
    }

    /**
     * soldAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getSoldAmount() {
        return soldAmount;
    }

    /**
     * soldAmount 속성의 값을 설정합니다.
     * 
     */
    public void setSoldAmount(float value) {
        this.soldAmount = value;
    }

}
