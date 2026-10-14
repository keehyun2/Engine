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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cbMandatoryConversionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="cbMandatoryConversionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Date" type="{}date"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PepsData" type="{}cbPepsData"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cbMandatoryConversionData", propOrder = {

})
public class CbMandatoryConversionData {

    @XmlElement(name = "Date", required = true)
    protected String date;
    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "PepsData", required = true)
    protected CbPepsData pepsData;

    /**
     * date 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * date 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * type 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * type 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * pepsData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbPepsData }
     *     
     */
    public CbPepsData getPepsData() {
        return pepsData;
    }

    /**
     * pepsData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbPepsData }
     *     
     */
    public void setPepsData(CbPepsData value) {
        this.pepsData = value;
    }

}
