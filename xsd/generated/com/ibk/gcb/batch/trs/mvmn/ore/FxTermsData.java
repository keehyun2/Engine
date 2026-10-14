//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>fxTermsData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="fxTermsData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="FXIndexFixingDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FXIndexCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApplyFXIndexFixingDays" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fxTermsData", propOrder = {
    "fxIndex",
    "fxIndexFixingDays",
    "fxIndexCalendar",
    "applyFXIndexFixingDays"
})
public class FxTermsData {

    @XmlElement(name = "FXIndex", required = true)
    protected List<String> fxIndex;
    @XmlElement(name = "FXIndexFixingDays")
    protected BigInteger fxIndexFixingDays;
    @XmlElement(name = "FXIndexCalendar")
    protected String fxIndexCalendar;
    @XmlElement(name = "ApplyFXIndexFixingDays")
    protected Boolean applyFXIndexFixingDays;

    /**
     * Gets the value of the fxIndex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fxIndex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFXIndex().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFXIndex() {
        if (fxIndex == null) {
            fxIndex = new ArrayList<String>();
        }
        return this.fxIndex;
    }

    /**
     * fxIndexFixingDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFXIndexFixingDays() {
        return fxIndexFixingDays;
    }

    /**
     * fxIndexFixingDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFXIndexFixingDays(BigInteger value) {
        this.fxIndexFixingDays = value;
    }

    /**
     * fxIndexCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFXIndexCalendar() {
        return fxIndexCalendar;
    }

    /**
     * fxIndexCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXIndexCalendar(String value) {
        this.fxIndexCalendar = value;
    }

    /**
     * applyFXIndexFixingDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isApplyFXIndexFixingDays() {
        return applyFXIndexFixingDays;
    }

    /**
     * applyFXIndexFixingDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setApplyFXIndexFixingDays(Boolean value) {
        this.applyFXIndexFixingDays = value;
    }

}
