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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>survivalprobability complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="survivalprobability">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShiftType" type="{}shiftTypeEntry" maxOccurs="unbounded"/>
 *         &lt;choice>
 *           &lt;element name="ShiftSize" type="{}shiftSizeEntry" maxOccurs="unbounded"/>
 *           &lt;element name="Shifts" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
 *         &lt;element name="ShiftScheme" type="{}shiftSchemeEntry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ShiftTenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ParConversion" type="{}parconversion" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "survivalprobability", propOrder = {
    "shiftType",
    "shiftSize",
    "shifts",
    "shiftScheme",
    "shiftTenors",
    "parConversion"
})
public class Survivalprobability {

    @XmlElement(name = "ShiftType", required = true)
    protected List<ShiftTypeEntry> shiftType;
    @XmlElement(name = "ShiftSize")
    protected List<ShiftSizeEntry> shiftSize;
    @XmlElement(name = "Shifts")
    protected String shifts;
    @XmlElement(name = "ShiftScheme")
    protected List<ShiftSchemeEntry> shiftScheme;
    @XmlElement(name = "ShiftTenors", required = true)
    protected String shiftTenors;
    @XmlElement(name = "ParConversion")
    protected Parconversion parConversion;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the shiftType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shiftType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShiftType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShiftTypeEntry }
     * 
     * 
     */
    public List<ShiftTypeEntry> getShiftType() {
        if (shiftType == null) {
            shiftType = new ArrayList<ShiftTypeEntry>();
        }
        return this.shiftType;
    }

    /**
     * Gets the value of the shiftSize property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shiftSize property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShiftSize().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShiftSizeEntry }
     * 
     * 
     */
    public List<ShiftSizeEntry> getShiftSize() {
        if (shiftSize == null) {
            shiftSize = new ArrayList<ShiftSizeEntry>();
        }
        return this.shiftSize;
    }

    /**
     * shifts 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShifts() {
        return shifts;
    }

    /**
     * shifts 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShifts(String value) {
        this.shifts = value;
    }

    /**
     * Gets the value of the shiftScheme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shiftScheme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShiftScheme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShiftSchemeEntry }
     * 
     * 
     */
    public List<ShiftSchemeEntry> getShiftScheme() {
        if (shiftScheme == null) {
            shiftScheme = new ArrayList<ShiftSchemeEntry>();
        }
        return this.shiftScheme;
    }

    /**
     * shiftTenors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShiftTenors() {
        return shiftTenors;
    }

    /**
     * shiftTenors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShiftTenors(String value) {
        this.shiftTenors = value;
    }

    /**
     * parConversion 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Parconversion }
     *     
     */
    public Parconversion getParConversion() {
        return parConversion;
    }

    /**
     * parConversion 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Parconversion }
     *     
     */
    public void setParConversion(Parconversion value) {
        this.parConversion = value;
    }

    /**
     * name 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * name 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
