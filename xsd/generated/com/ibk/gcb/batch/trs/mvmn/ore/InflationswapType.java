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
 * <p>inflationswapType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="inflationswapType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FixCalendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FixConvention" type="{}businessDayConvention"/>
 *         &lt;element name="DayCounter" type="{}dayCounter"/>
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Interpolated" type="{}bool"/>
 *         &lt;element name="ObservationLag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AdjustInflationObservationDates" type="{}bool"/>
 *         &lt;element name="InflationCalendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InflationConvention" type="{}businessDayConvention"/>
 *         &lt;element name="PublicationRoll" type="{}publicationRoll" minOccurs="0"/>
 *         &lt;element name="PublicationSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="StartDelay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartDelayConvention" type="{}businessDayConvention" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inflationswapType", propOrder = {

})
public class InflationswapType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "FixCalendar", required = true)
    protected String fixCalendar;
    @XmlElement(name = "FixConvention", required = true)
    protected String fixConvention;
    @XmlElement(name = "DayCounter", required = true)
    protected String dayCounter;
    @XmlElement(name = "Index", required = true)
    protected String index;
    @XmlElement(name = "Interpolated", required = true)
    protected String interpolated;
    @XmlElement(name = "ObservationLag", required = true)
    protected String observationLag;
    @XmlElement(name = "AdjustInflationObservationDates", required = true)
    protected String adjustInflationObservationDates;
    @XmlElement(name = "InflationCalendar", required = true)
    protected String inflationCalendar;
    @XmlElement(name = "InflationConvention", required = true)
    protected String inflationConvention;
    @XmlElement(name = "PublicationRoll")
    @XmlSchemaType(name = "string")
    protected PublicationRoll publicationRoll;
    @XmlElement(name = "PublicationSchedule")
    protected ScheduleData publicationSchedule;
    @XmlElement(name = "StartDelay")
    protected String startDelay;
    @XmlElement(name = "StartDelayConvention")
    protected String startDelayConvention;

    /**
     * id 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * id 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * fixCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixCalendar() {
        return fixCalendar;
    }

    /**
     * fixCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixCalendar(String value) {
        this.fixCalendar = value;
    }

    /**
     * fixConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixConvention() {
        return fixConvention;
    }

    /**
     * fixConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixConvention(String value) {
        this.fixConvention = value;
    }

    /**
     * dayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayCounter() {
        return dayCounter;
    }

    /**
     * dayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayCounter(String value) {
        this.dayCounter = value;
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
     * interpolated 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterpolated() {
        return interpolated;
    }

    /**
     * interpolated 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterpolated(String value) {
        this.interpolated = value;
    }

    /**
     * observationLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservationLag() {
        return observationLag;
    }

    /**
     * observationLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservationLag(String value) {
        this.observationLag = value;
    }

    /**
     * adjustInflationObservationDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdjustInflationObservationDates() {
        return adjustInflationObservationDates;
    }

    /**
     * adjustInflationObservationDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdjustInflationObservationDates(String value) {
        this.adjustInflationObservationDates = value;
    }

    /**
     * inflationCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInflationCalendar() {
        return inflationCalendar;
    }

    /**
     * inflationCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInflationCalendar(String value) {
        this.inflationCalendar = value;
    }

    /**
     * inflationConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInflationConvention() {
        return inflationConvention;
    }

    /**
     * inflationConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInflationConvention(String value) {
        this.inflationConvention = value;
    }

    /**
     * publicationRoll 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PublicationRoll }
     *     
     */
    public PublicationRoll getPublicationRoll() {
        return publicationRoll;
    }

    /**
     * publicationRoll 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicationRoll }
     *     
     */
    public void setPublicationRoll(PublicationRoll value) {
        this.publicationRoll = value;
    }

    /**
     * publicationSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getPublicationSchedule() {
        return publicationSchedule;
    }

    /**
     * publicationSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setPublicationSchedule(ScheduleData value) {
        this.publicationSchedule = value;
    }

    /**
     * startDelay 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDelay() {
        return startDelay;
    }

    /**
     * startDelay 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDelay(String value) {
        this.startDelay = value;
    }

    /**
     * startDelayConvention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDelayConvention() {
        return startDelayConvention;
    }

    /**
     * startDelayConvention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDelayConvention(String value) {
        this.startDelayConvention = value;
    }

}
