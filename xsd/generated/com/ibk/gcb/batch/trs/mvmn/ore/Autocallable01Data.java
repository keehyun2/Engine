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
 * <p>autocallable01Data complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="autocallable01Data">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="NotionalAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="DeterminationLevel" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="TriggerLevel" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Underlying" type="{}underlying"/>
 *         &lt;element name="Position" type="{}longShort"/>
 *         &lt;element name="PayCcy" type="{}currencyCode"/>
 *         &lt;element name="FixingDates">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="ScheduleData" type="{}scheduleData"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SettlementDates">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="ScheduleData" type="{}scheduleData"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AccumulationFactors">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Factor" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Cap" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autocallable01Data", propOrder = {

})
public class Autocallable01Data {

    @XmlElement(name = "NotionalAmount")
    protected float notionalAmount;
    @XmlElement(name = "DeterminationLevel")
    protected float determinationLevel;
    @XmlElement(name = "TriggerLevel")
    protected float triggerLevel;
    @XmlElement(name = "Underlying", required = true)
    protected Underlying underlying;
    @XmlElement(name = "Position", required = true)
    @XmlSchemaType(name = "string")
    protected LongShort position;
    @XmlElement(name = "PayCcy", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode payCcy;
    @XmlElement(name = "FixingDates", required = true)
    protected Autocallable01Data.FixingDates fixingDates;
    @XmlElement(name = "SettlementDates", required = true)
    protected Autocallable01Data.SettlementDates settlementDates;
    @XmlElement(name = "AccumulationFactors", required = true)
    protected Autocallable01Data.AccumulationFactors accumulationFactors;
    @XmlElement(name = "Cap")
    protected float cap;

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
     * determinationLevel 속성의 값을 가져옵니다.
     * 
     */
    public float getDeterminationLevel() {
        return determinationLevel;
    }

    /**
     * determinationLevel 속성의 값을 설정합니다.
     * 
     */
    public void setDeterminationLevel(float value) {
        this.determinationLevel = value;
    }

    /**
     * triggerLevel 속성의 값을 가져옵니다.
     * 
     */
    public float getTriggerLevel() {
        return triggerLevel;
    }

    /**
     * triggerLevel 속성의 값을 설정합니다.
     * 
     */
    public void setTriggerLevel(float value) {
        this.triggerLevel = value;
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
     * fixingDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Autocallable01Data.FixingDates }
     *     
     */
    public Autocallable01Data.FixingDates getFixingDates() {
        return fixingDates;
    }

    /**
     * fixingDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Autocallable01Data.FixingDates }
     *     
     */
    public void setFixingDates(Autocallable01Data.FixingDates value) {
        this.fixingDates = value;
    }

    /**
     * settlementDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Autocallable01Data.SettlementDates }
     *     
     */
    public Autocallable01Data.SettlementDates getSettlementDates() {
        return settlementDates;
    }

    /**
     * settlementDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Autocallable01Data.SettlementDates }
     *     
     */
    public void setSettlementDates(Autocallable01Data.SettlementDates value) {
        this.settlementDates = value;
    }

    /**
     * accumulationFactors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Autocallable01Data.AccumulationFactors }
     *     
     */
    public Autocallable01Data.AccumulationFactors getAccumulationFactors() {
        return accumulationFactors;
    }

    /**
     * accumulationFactors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Autocallable01Data.AccumulationFactors }
     *     
     */
    public void setAccumulationFactors(Autocallable01Data.AccumulationFactors value) {
        this.accumulationFactors = value;
    }

    /**
     * cap 속성의 값을 가져옵니다.
     * 
     */
    public float getCap() {
        return cap;
    }

    /**
     * cap 속성의 값을 설정합니다.
     * 
     */
    public void setCap(float value) {
        this.cap = value;
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
     *         &lt;element name="Factor" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
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
        "factor"
    })
    public static class AccumulationFactors {

        @XmlElement(name = "Factor", type = Float.class)
        protected List<Float> factor;

        /**
         * Gets the value of the factor property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the factor property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFactor().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Float }
         * 
         * 
         */
        public List<Float> getFactor() {
            if (factor == null) {
                factor = new ArrayList<Float>();
            }
            return this.factor;
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
     *       &lt;all>
     *         &lt;element name="ScheduleData" type="{}scheduleData"/>
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
    public static class FixingDates {

        @XmlElement(name = "ScheduleData", required = true)
        protected ScheduleData scheduleData;

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
     *         &lt;element name="ScheduleData" type="{}scheduleData"/>
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
    public static class SettlementDates {

        @XmlElement(name = "ScheduleData", required = true)
        protected ScheduleData scheduleData;

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

    }

}
