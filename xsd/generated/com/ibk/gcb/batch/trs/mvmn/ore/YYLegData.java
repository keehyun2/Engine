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
 * <p>anonymous complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FixingDays" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="ObservationLag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Gearings" type="{}gearings" minOccurs="0"/>
 *         &lt;element name="Spreads" type="{}spreads" minOccurs="0"/>
 *         &lt;element name="Caps" type="{}caps" minOccurs="0"/>
 *         &lt;element name="Floors" type="{}floors" minOccurs="0"/>
 *         &lt;element name="NakedOption" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AddInflationNotional" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IrregularYoY" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
public class YYLegData {

    @XmlElement(name = "Index", required = true)
    protected String index;
    @XmlElement(name = "FixingDays", required = true)
    protected BigInteger fixingDays;
    @XmlElement(name = "ObservationLag", required = true)
    protected String observationLag;
    @XmlElement(name = "Gearings")
    protected Gearings gearings;
    @XmlElement(name = "Spreads")
    protected Spreads spreads;
    @XmlElement(name = "Caps")
    protected Caps caps;
    @XmlElement(name = "Floors")
    protected Floors floors;
    @XmlElement(name = "NakedOption")
    protected Boolean nakedOption;
    @XmlElement(name = "AddInflationNotional")
    protected Boolean addInflationNotional;
    @XmlElement(name = "IrregularYoY")
    protected Boolean irregularYoY;

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
     * addInflationNotional 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAddInflationNotional() {
        return addInflationNotional;
    }

    /**
     * addInflationNotional 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAddInflationNotional(Boolean value) {
        this.addInflationNotional = value;
    }

    /**
     * irregularYoY 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIrregularYoY() {
        return irregularYoY;
    }

    /**
     * irregularYoY 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIrregularYoY(Boolean value) {
        this.irregularYoY = value;
    }

}
