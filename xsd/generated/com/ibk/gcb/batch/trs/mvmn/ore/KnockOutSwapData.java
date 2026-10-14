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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>knockOutSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="knockOutSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BarrierData" type="{}barrierData"/>
 *         &lt;element name="BarrierStartDate" type="{}date"/>
 *         &lt;element name="LegData" type="{}legData" maxOccurs="2" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "knockOutSwapData", propOrder = {
    "barrierData",
    "barrierStartDate",
    "legData"
})
public class KnockOutSwapData {

    @XmlElement(name = "BarrierData", required = true)
    protected BarrierData barrierData;
    @XmlElement(name = "BarrierStartDate", required = true)
    protected String barrierStartDate;
    @XmlElement(name = "LegData", required = true)
    protected List<LegData> legData;

    /**
     * barrierData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BarrierData }
     *     
     */
    public BarrierData getBarrierData() {
        return barrierData;
    }

    /**
     * barrierData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BarrierData }
     *     
     */
    public void setBarrierData(BarrierData value) {
        this.barrierData = value;
    }

    /**
     * barrierStartDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarrierStartDate() {
        return barrierStartDate;
    }

    /**
     * barrierStartDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarrierStartDate(String value) {
        this.barrierStartDate = value;
    }

    /**
     * Gets the value of the legData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LegData }
     * 
     * 
     */
    public List<LegData> getLegData() {
        if (legData == null) {
            legData = new ArrayList<LegData>();
        }
        return this.legData;
    }

}
