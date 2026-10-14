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
 * <p>calibrationBasket complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="calibrationBasket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="CpiCapFloor" type="{}calibrationCpiCapFloor" maxOccurs="unbounded"/>
 *         &lt;element name="YoYCapFloor" type="{}calibrationYoYCapFloor" maxOccurs="unbounded"/>
 *         &lt;element name="YoYSwap" type="{}calibrationYoYSwap" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *       &lt;attribute name="parameter" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calibrationBasket", propOrder = {
    "cpiCapFloor",
    "yoYCapFloor",
    "yoYSwap"
})
public class CalibrationBasket {

    @XmlElement(name = "CpiCapFloor")
    protected List<CalibrationCpiCapFloor> cpiCapFloor;
    @XmlElement(name = "YoYCapFloor")
    protected List<CalibrationYoYCapFloor> yoYCapFloor;
    @XmlElement(name = "YoYSwap")
    protected List<CalibrationYoYSwap> yoYSwap;
    @XmlAttribute(name = "parameter")
    protected String parameter;

    /**
     * Gets the value of the cpiCapFloor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cpiCapFloor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCpiCapFloor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalibrationCpiCapFloor }
     * 
     * 
     */
    public List<CalibrationCpiCapFloor> getCpiCapFloor() {
        if (cpiCapFloor == null) {
            cpiCapFloor = new ArrayList<CalibrationCpiCapFloor>();
        }
        return this.cpiCapFloor;
    }

    /**
     * Gets the value of the yoYCapFloor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the yoYCapFloor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getYoYCapFloor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalibrationYoYCapFloor }
     * 
     * 
     */
    public List<CalibrationYoYCapFloor> getYoYCapFloor() {
        if (yoYCapFloor == null) {
            yoYCapFloor = new ArrayList<CalibrationYoYCapFloor>();
        }
        return this.yoYCapFloor;
    }

    /**
     * Gets the value of the yoYSwap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the yoYSwap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getYoYSwap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalibrationYoYSwap }
     * 
     * 
     */
    public List<CalibrationYoYSwap> getYoYSwap() {
        if (yoYSwap == null) {
            yoYSwap = new ArrayList<CalibrationYoYSwap>();
        }
        return this.yoYSwap;
    }

    /**
     * parameter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * parameter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameter(String value) {
        this.parameter = value;
    }

}
