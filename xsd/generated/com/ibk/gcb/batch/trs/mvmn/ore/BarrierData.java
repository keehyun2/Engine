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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>barrierData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="barrierData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Type" type="{}barrierType"/>
 *         &lt;element name="StrictComparison" type="{}barrierCompare" minOccurs="0"/>
 *         &lt;element name="Style" type="{}barrierStyle" minOccurs="0"/>
 *         &lt;element name="Levels">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Level" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Rebate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="RebateCurrency" type="{}currencyCode" minOccurs="0"/>
 *         &lt;element name="RebatePayTime" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="atHit"/>
 *               &lt;enumeration value="atExpiry"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OverrideTriggered" type="{}bool" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "barrierData", propOrder = {

})
public class BarrierData {

    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected BarrierType type;
    @XmlElement(name = "StrictComparison")
    protected String strictComparison;
    @XmlElement(name = "Style")
    @XmlSchemaType(name = "string")
    protected BarrierStyle style;
    @XmlElement(name = "Levels", required = true)
    protected BarrierData.Levels levels;
    @XmlElement(name = "Rebate")
    protected Float rebate;
    @XmlElement(name = "RebateCurrency")
    @XmlSchemaType(name = "string")
    protected CurrencyCode rebateCurrency;
    @XmlElement(name = "RebatePayTime")
    protected String rebatePayTime;
    @XmlElement(name = "OverrideTriggered")
    protected String overrideTriggered;

    /**
     * type 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BarrierType }
     *     
     */
    public BarrierType getType() {
        return type;
    }

    /**
     * type 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BarrierType }
     *     
     */
    public void setType(BarrierType value) {
        this.type = value;
    }

    /**
     * strictComparison 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrictComparison() {
        return strictComparison;
    }

    /**
     * strictComparison 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrictComparison(String value) {
        this.strictComparison = value;
    }

    /**
     * style 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BarrierStyle }
     *     
     */
    public BarrierStyle getStyle() {
        return style;
    }

    /**
     * style 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BarrierStyle }
     *     
     */
    public void setStyle(BarrierStyle value) {
        this.style = value;
    }

    /**
     * levels 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BarrierData.Levels }
     *     
     */
    public BarrierData.Levels getLevels() {
        return levels;
    }

    /**
     * levels 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BarrierData.Levels }
     *     
     */
    public void setLevels(BarrierData.Levels value) {
        this.levels = value;
    }

    /**
     * rebate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRebate() {
        return rebate;
    }

    /**
     * rebate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRebate(Float value) {
        this.rebate = value;
    }

    /**
     * rebateCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getRebateCurrency() {
        return rebateCurrency;
    }

    /**
     * rebateCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setRebateCurrency(CurrencyCode value) {
        this.rebateCurrency = value;
    }

    /**
     * rebatePayTime 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRebatePayTime() {
        return rebatePayTime;
    }

    /**
     * rebatePayTime 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRebatePayTime(String value) {
        this.rebatePayTime = value;
    }

    /**
     * overrideTriggered 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverrideTriggered() {
        return overrideTriggered;
    }

    /**
     * overrideTriggered 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverrideTriggered(String value) {
        this.overrideTriggered = value;
    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Level" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "level"
    })
    public static class Levels {

        @XmlElement(name = "Level", type = Float.class)
        protected List<Float> level;

        /**
         * Gets the value of the level property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the level property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLevel().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Float }
         * 
         * 
         */
        public List<Float> getLevel() {
            if (level == null) {
                level = new ArrayList<Float>();
            }
            return this.level;
        }

    }

}
