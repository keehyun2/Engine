//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cbotranche complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="cbotranche">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ICRatio" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="OCRatio" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Notional" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element ref="{}legDataType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cbotranche", propOrder = {

})
public class Cbotranche {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "ICRatio")
    protected float icRatio;
    @XmlElement(name = "OCRatio")
    protected float ocRatio;
    @XmlElement(name = "Notional")
    protected float notional;
    @XmlElementRef(name = "legDataType", type = JAXBElement.class)
    protected JAXBElement<?> legDataType;

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

    /**
     * icRatio 속성의 값을 가져옵니다.
     * 
     */
    public float getICRatio() {
        return icRatio;
    }

    /**
     * icRatio 속성의 값을 설정합니다.
     * 
     */
    public void setICRatio(float value) {
        this.icRatio = value;
    }

    /**
     * ocRatio 속성의 값을 가져옵니다.
     * 
     */
    public float getOCRatio() {
        return ocRatio;
    }

    /**
     * ocRatio 속성의 값을 설정합니다.
     * 
     */
    public void setOCRatio(float value) {
        this.ocRatio = value;
    }

    /**
     * notional 속성의 값을 가져옵니다.
     * 
     */
    public float getNotional() {
        return notional;
    }

    /**
     * notional 속성의 값을 설정합니다.
     * 
     */
    public void setNotional(float value) {
        this.notional = value;
    }

    /**
     * legDataType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FloatingLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CommodityFixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CashflowData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DigitalCMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link FormulaBasedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DurationAdjustedCMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link YYLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMSSpreadLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CPILegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link ZeroCouponFixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link EquityLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link FixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CommodityFloatingLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMBLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link EquityMarginLegData }{@code >}
     *     
     */
    public JAXBElement<?> getLegDataType() {
        return legDataType;
    }

    /**
     * legDataType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FloatingLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CommodityFixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CashflowData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DigitalCMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link FormulaBasedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DurationAdjustedCMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link YYLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMSSpreadLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CPILegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link ZeroCouponFixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link EquityLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link FixedLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CommodityFloatingLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMSLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link CMBLegData }{@code >}
     *     {@link JAXBElement }{@code <}{@link EquityMarginLegData }{@code >}
     *     
     */
    public void setLegDataType(JAXBElement<?> value) {
        this.legDataType = value;
    }

}
