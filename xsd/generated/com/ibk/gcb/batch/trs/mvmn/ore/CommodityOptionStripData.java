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
 * <p>commodityOptionStripData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="commodityOptionStripData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="LegData" type="{}legData"/>
 *         &lt;element name="Calls" type="{}callsPutsType" minOccurs="0"/>
 *         &lt;element name="Puts" type="{}callsPutsType" minOccurs="0"/>
 *         &lt;element name="PremiumAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PremiumCurrency" type="{}premiumCurrencyCode" minOccurs="0"/>
 *         &lt;element name="PremiumPayDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Premiums" type="{}premiumData" minOccurs="0"/>
 *         &lt;element name="Style" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Settlement" type="{}settlementType" minOccurs="0"/>
 *         &lt;element name="IsDigital" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PayoffPerUnit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commodityOptionStripData", propOrder = {

})
public class CommodityOptionStripData {

    @XmlElement(name = "LegData", required = true)
    protected LegData legData;
    @XmlElement(name = "Calls")
    protected CallsPutsType calls;
    @XmlElement(name = "Puts")
    protected CallsPutsType puts;
    @XmlElement(name = "PremiumAmount")
    protected String premiumAmount;
    @XmlElement(name = "PremiumCurrency")
    protected String premiumCurrency;
    @XmlElement(name = "PremiumPayDate")
    protected String premiumPayDate;
    @XmlElement(name = "Premiums")
    protected PremiumData premiums;
    @XmlElement(name = "Style")
    protected String style;
    @XmlElement(name = "Settlement")
    @XmlSchemaType(name = "string")
    protected SettlementType settlement;
    @XmlElement(name = "IsDigital")
    protected Boolean isDigital;
    @XmlElement(name = "PayoffPerUnit")
    protected Double payoffPerUnit;

    /**
     * legData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LegData }
     *     
     */
    public LegData getLegData() {
        return legData;
    }

    /**
     * legData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LegData }
     *     
     */
    public void setLegData(LegData value) {
        this.legData = value;
    }

    /**
     * calls 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CallsPutsType }
     *     
     */
    public CallsPutsType getCalls() {
        return calls;
    }

    /**
     * calls 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CallsPutsType }
     *     
     */
    public void setCalls(CallsPutsType value) {
        this.calls = value;
    }

    /**
     * puts 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CallsPutsType }
     *     
     */
    public CallsPutsType getPuts() {
        return puts;
    }

    /**
     * puts 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CallsPutsType }
     *     
     */
    public void setPuts(CallsPutsType value) {
        this.puts = value;
    }

    /**
     * premiumAmount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiumAmount() {
        return premiumAmount;
    }

    /**
     * premiumAmount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiumAmount(String value) {
        this.premiumAmount = value;
    }

    /**
     * premiumCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiumCurrency() {
        return premiumCurrency;
    }

    /**
     * premiumCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiumCurrency(String value) {
        this.premiumCurrency = value;
    }

    /**
     * premiumPayDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiumPayDate() {
        return premiumPayDate;
    }

    /**
     * premiumPayDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiumPayDate(String value) {
        this.premiumPayDate = value;
    }

    /**
     * premiums 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PremiumData }
     *     
     */
    public PremiumData getPremiums() {
        return premiums;
    }

    /**
     * premiums 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PremiumData }
     *     
     */
    public void setPremiums(PremiumData value) {
        this.premiums = value;
    }

    /**
     * style 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * style 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }

    /**
     * settlement 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SettlementType }
     *     
     */
    public SettlementType getSettlement() {
        return settlement;
    }

    /**
     * settlement 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementType }
     *     
     */
    public void setSettlement(SettlementType value) {
        this.settlement = value;
    }

    /**
     * isDigital 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDigital() {
        return isDigital;
    }

    /**
     * isDigital 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDigital(Boolean value) {
        this.isDigital = value;
    }

    /**
     * payoffPerUnit 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPayoffPerUnit() {
        return payoffPerUnit;
    }

    /**
     * payoffPerUnit 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPayoffPerUnit(Double value) {
        this.payoffPerUnit = value;
    }

}
