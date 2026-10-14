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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>tarfData2 complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="tarfData2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="FixingAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="TargetAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="TargetPoints" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Strikes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Strike" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                           &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Underlying" type="{}underlying"/>
 *         &lt;element name="ScheduleData" type="{}scheduleData"/>
 *         &lt;element name="SettlementLag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlementCalendar" type="{}calendar" minOccurs="0"/>
 *         &lt;element name="SettlementConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="OptionData" type="{}optionData"/>
 *         &lt;element name="RangeBounds" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RangeBound" type="{}rangeBound" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RangeBoundSet" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RangeBounds" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="RangeBound" type="{}rangeBound" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Barriers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BarrierData" type="{}barrierData" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tarfData2", propOrder = {

})
public class TarfData2 {

    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "FixingAmount")
    protected float fixingAmount;
    @XmlElement(name = "TargetAmount")
    protected Float targetAmount;
    @XmlElement(name = "TargetPoints")
    protected Float targetPoints;
    @XmlElement(name = "Strike")
    protected Float strike;
    @XmlElement(name = "Strikes")
    protected TarfData2 .Strikes strikes;
    @XmlElement(name = "Underlying", required = true)
    protected Underlying underlying;
    @XmlElement(name = "ScheduleData", required = true)
    protected ScheduleData scheduleData;
    @XmlElement(name = "SettlementLag")
    protected String settlementLag;
    @XmlElement(name = "SettlementCalendar")
    protected String settlementCalendar;
    @XmlElement(name = "SettlementConvention")
    protected String settlementConvention;
    @XmlElement(name = "OptionData", required = true)
    protected OptionData optionData;
    @XmlElement(name = "RangeBounds")
    protected TarfData2 .RangeBounds rangeBounds;
    @XmlElement(name = "RangeBoundSet")
    protected TarfData2 .RangeBoundSet rangeBoundSet;
    @XmlElement(name = "Barriers", required = true)
    protected TarfData2 .Barriers barriers;

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
     * fixingAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getFixingAmount() {
        return fixingAmount;
    }

    /**
     * fixingAmount 속성의 값을 설정합니다.
     * 
     */
    public void setFixingAmount(float value) {
        this.fixingAmount = value;
    }

    /**
     * targetAmount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTargetAmount() {
        return targetAmount;
    }

    /**
     * targetAmount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTargetAmount(Float value) {
        this.targetAmount = value;
    }

    /**
     * targetPoints 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTargetPoints() {
        return targetPoints;
    }

    /**
     * targetPoints 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTargetPoints(Float value) {
        this.targetPoints = value;
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
     * strikes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TarfData2 .Strikes }
     *     
     */
    public TarfData2 .Strikes getStrikes() {
        return strikes;
    }

    /**
     * strikes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TarfData2 .Strikes }
     *     
     */
    public void setStrikes(TarfData2 .Strikes value) {
        this.strikes = value;
    }

    /**
     * underlying 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getUnderlying() {
        return underlying;
    }

    /**
     * underlying 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setUnderlying(Underlying value) {
        this.underlying = value;
    }

    /**
     * scheduleData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getScheduleData() {
        return scheduleData;
    }

    /**
     * scheduleData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setScheduleData(ScheduleData value) {
        this.scheduleData = value;
    }

    /**
     * settlementLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementLag() {
        return settlementLag;
    }

    /**
     * settlementLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementLag(String value) {
        this.settlementLag = value;
    }

    /**
     * settlementCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementCalendar() {
        return settlementCalendar;
    }

    /**
     * settlementCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementCalendar(String value) {
        this.settlementCalendar = value;
    }

    /**
     * settlementConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementConvention() {
        return settlementConvention;
    }

    /**
     * settlementConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementConvention(String value) {
        this.settlementConvention = value;
    }

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
     * rangeBounds 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TarfData2 .RangeBounds }
     *     
     */
    public TarfData2 .RangeBounds getRangeBounds() {
        return rangeBounds;
    }

    /**
     * rangeBounds 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TarfData2 .RangeBounds }
     *     
     */
    public void setRangeBounds(TarfData2 .RangeBounds value) {
        this.rangeBounds = value;
    }

    /**
     * rangeBoundSet 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TarfData2 .RangeBoundSet }
     *     
     */
    public TarfData2 .RangeBoundSet getRangeBoundSet() {
        return rangeBoundSet;
    }

    /**
     * rangeBoundSet 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TarfData2 .RangeBoundSet }
     *     
     */
    public void setRangeBoundSet(TarfData2 .RangeBoundSet value) {
        this.rangeBoundSet = value;
    }

    /**
     * barriers 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TarfData2 .Barriers }
     *     
     */
    public TarfData2 .Barriers getBarriers() {
        return barriers;
    }

    /**
     * barriers 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TarfData2 .Barriers }
     *     
     */
    public void setBarriers(TarfData2 .Barriers value) {
        this.barriers = value;
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
     *         &lt;element name="BarrierData" type="{}barrierData" maxOccurs="unbounded"/>
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
        "barrierData"
    })
    public static class Barriers {

        @XmlElement(name = "BarrierData", required = true)
        protected List<BarrierData> barrierData;

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
     *         &lt;element name="RangeBounds" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="RangeBound" type="{}rangeBound" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "rangeBounds"
    })
    public static class RangeBoundSet {

        @XmlElement(name = "RangeBounds")
        protected List<TarfData2 .RangeBoundSet.RangeBounds> rangeBounds;

        /**
         * Gets the value of the rangeBounds property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rangeBounds property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRangeBounds().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TarfData2 .RangeBoundSet.RangeBounds }
         * 
         * 
         */
        public List<TarfData2 .RangeBoundSet.RangeBounds> getRangeBounds() {
            if (rangeBounds == null) {
                rangeBounds = new ArrayList<TarfData2 .RangeBoundSet.RangeBounds>();
            }
            return this.rangeBounds;
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
         *         &lt;element name="RangeBound" type="{}rangeBound" maxOccurs="unbounded"/>
         *       &lt;/sequence>
         *       &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "rangeBound"
        })
        public static class RangeBounds {

            @XmlElement(name = "RangeBound", required = true)
            protected List<RangeBound> rangeBound;
            @XmlAttribute(name = "startDate")
            protected String startDate;

            /**
             * Gets the value of the rangeBound property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the rangeBound property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRangeBound().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link RangeBound }
             * 
             * 
             */
            public List<RangeBound> getRangeBound() {
                if (rangeBound == null) {
                    rangeBound = new ArrayList<RangeBound>();
                }
                return this.rangeBound;
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
     *         &lt;element name="RangeBound" type="{}rangeBound" maxOccurs="unbounded"/>
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
        "rangeBound"
    })
    public static class RangeBounds {

        @XmlElement(name = "RangeBound", required = true)
        protected List<RangeBound> rangeBound;

        /**
         * Gets the value of the rangeBound property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rangeBound property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRangeBound().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RangeBound }
         * 
         * 
         */
        public List<RangeBound> getRangeBound() {
            if (rangeBound == null) {
                rangeBound = new ArrayList<RangeBound>();
            }
            return this.rangeBound;
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
     *         &lt;element name="Strike" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                 &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "strike"
    })
    public static class Strikes {

        @XmlElement(name = "Strike")
        protected List<TarfData2 .Strikes.Strike> strike;

        /**
         * Gets the value of the strike property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the strike property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStrike().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TarfData2 .Strikes.Strike }
         * 
         * 
         */
        public List<TarfData2 .Strikes.Strike> getStrike() {
            if (strike == null) {
                strike = new ArrayList<TarfData2 .Strikes.Strike>();
            }
            return this.strike;
        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *       &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Strike {

            @XmlValue
            protected float value;
            @XmlAttribute(name = "startDate")
            protected String startDate;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             */
            public float getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             */
            public void setValue(float value) {
                this.value = value;
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

        }

    }

}
