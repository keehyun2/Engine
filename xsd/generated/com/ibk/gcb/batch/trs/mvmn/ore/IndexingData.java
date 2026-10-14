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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>indexingData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="indexingData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndexFixingDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="IndexFixingCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dirty" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Relative" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ConditionalOnSurvival" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="InitialFixing" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="InitialNotionalFixing" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ValuationSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="FixingDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FixingCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FixingConvention" type="{}businessDayConvention" minOccurs="0"/>
 *         &lt;element name="IsInArrears" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "indexingData", propOrder = {

})
public class IndexingData {

    @XmlElement(name = "Quantity")
    protected Float quantity;
    @XmlElement(name = "Index")
    protected String index;
    @XmlElement(name = "IndexFixingDays")
    protected BigInteger indexFixingDays;
    @XmlElement(name = "IndexFixingCalendar")
    protected String indexFixingCalendar;
    @XmlElement(name = "Dirty")
    protected Boolean dirty;
    @XmlElement(name = "Relative")
    protected Boolean relative;
    @XmlElement(name = "ConditionalOnSurvival")
    protected Boolean conditionalOnSurvival;
    @XmlElement(name = "InitialFixing")
    protected Float initialFixing;
    @XmlElement(name = "InitialNotionalFixing")
    protected Float initialNotionalFixing;
    @XmlElement(name = "ValuationSchedule")
    protected ScheduleData valuationSchedule;
    @XmlElement(name = "FixingDays")
    protected BigInteger fixingDays;
    @XmlElement(name = "FixingCalendar")
    protected String fixingCalendar;
    @XmlElement(name = "FixingConvention")
    protected String fixingConvention;
    @XmlElement(name = "IsInArrears")
    protected Boolean isInArrears;

    /**
     * quantity 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getQuantity() {
        return quantity;
    }

    /**
     * quantity 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setQuantity(Float value) {
        this.quantity = value;
    }

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
     * indexFixingDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIndexFixingDays() {
        return indexFixingDays;
    }

    /**
     * indexFixingDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIndexFixingDays(BigInteger value) {
        this.indexFixingDays = value;
    }

    /**
     * indexFixingCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexFixingCalendar() {
        return indexFixingCalendar;
    }

    /**
     * indexFixingCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexFixingCalendar(String value) {
        this.indexFixingCalendar = value;
    }

    /**
     * dirty 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDirty() {
        return dirty;
    }

    /**
     * dirty 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDirty(Boolean value) {
        this.dirty = value;
    }

    /**
     * relative 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRelative() {
        return relative;
    }

    /**
     * relative 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRelative(Boolean value) {
        this.relative = value;
    }

    /**
     * conditionalOnSurvival 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConditionalOnSurvival() {
        return conditionalOnSurvival;
    }

    /**
     * conditionalOnSurvival 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConditionalOnSurvival(Boolean value) {
        this.conditionalOnSurvival = value;
    }

    /**
     * initialFixing 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getInitialFixing() {
        return initialFixing;
    }

    /**
     * initialFixing 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setInitialFixing(Float value) {
        this.initialFixing = value;
    }

    /**
     * initialNotionalFixing 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getInitialNotionalFixing() {
        return initialNotionalFixing;
    }

    /**
     * initialNotionalFixing 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setInitialNotionalFixing(Float value) {
        this.initialNotionalFixing = value;
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
     * fixingCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixingCalendar() {
        return fixingCalendar;
    }

    /**
     * fixingCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixingCalendar(String value) {
        this.fixingCalendar = value;
    }

    /**
     * fixingConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixingConvention() {
        return fixingConvention;
    }

    /**
     * fixingConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixingConvention(String value) {
        this.fixingConvention = value;
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

}
