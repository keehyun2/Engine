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
 * <p>reversionParameter complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="reversionParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ReversionType" type="{}reversionTypeType"/>
 *         &lt;element name="Calibrate" type="{}bool"/>
 *         &lt;element name="ParamType" type="{}paramTypeType"/>
 *         &lt;element name="TimeGrid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InitialValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reversionParameter", propOrder = {

})
public class ReversionParameter {

    @XmlElement(name = "ReversionType", required = true)
    @XmlSchemaType(name = "string")
    protected ReversionTypeType reversionType;
    @XmlElement(name = "Calibrate", required = true)
    protected String calibrate;
    @XmlElement(name = "ParamType", required = true)
    @XmlSchemaType(name = "string")
    protected ParamTypeType paramType;
    @XmlElement(name = "TimeGrid")
    protected String timeGrid;
    @XmlElement(name = "InitialValue", required = true)
    protected String initialValue;

    /**
     * reversionType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ReversionTypeType }
     *     
     */
    public ReversionTypeType getReversionType() {
        return reversionType;
    }

    /**
     * reversionType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ReversionTypeType }
     *     
     */
    public void setReversionType(ReversionTypeType value) {
        this.reversionType = value;
    }

    /**
     * calibrate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalibrate() {
        return calibrate;
    }

    /**
     * calibrate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalibrate(String value) {
        this.calibrate = value;
    }

    /**
     * paramType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ParamTypeType }
     *     
     */
    public ParamTypeType getParamType() {
        return paramType;
    }

    /**
     * paramType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamTypeType }
     *     
     */
    public void setParamType(ParamTypeType value) {
        this.paramType = value;
    }

    /**
     * timeGrid 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeGrid() {
        return timeGrid;
    }

    /**
     * timeGrid 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeGrid(String value) {
        this.timeGrid = value;
    }

    /**
     * initialValue 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialValue() {
        return initialValue;
    }

    /**
     * initialValue 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialValue(String value) {
        this.initialValue = value;
    }

}
