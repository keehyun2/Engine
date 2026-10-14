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
 * <p>bondReferenceDatum complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="bondReferenceDatum">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IssuerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreditCurveId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferenceCurveId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IncomeCurveId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VolatilityCurveId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlementDays" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IssueDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PriceQuoteMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PriceQuoteBaseValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LegData" type="{}legData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SubType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PriceType" type="{}bondPriceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bondReferenceDatum", propOrder = {
    "issuerId",
    "creditCurveId",
    "creditGroup",
    "referenceCurveId",
    "incomeCurveId",
    "volatilityCurveId",
    "settlementDays",
    "calendar",
    "issueDate",
    "priceQuoteMethod",
    "priceQuoteBaseValue",
    "legData",
    "subType",
    "priceType"
})
public class BondReferenceDatum {

    @XmlElement(name = "IssuerId", required = true)
    protected String issuerId;
    @XmlElement(name = "CreditCurveId")
    protected String creditCurveId;
    @XmlElement(name = "CreditGroup")
    protected String creditGroup;
    @XmlElement(name = "ReferenceCurveId")
    protected String referenceCurveId;
    @XmlElement(name = "IncomeCurveId")
    protected String incomeCurveId;
    @XmlElement(name = "VolatilityCurveId")
    protected String volatilityCurveId;
    @XmlElement(name = "SettlementDays", required = true)
    protected String settlementDays;
    @XmlElement(name = "Calendar", required = true)
    protected String calendar;
    @XmlElement(name = "IssueDate", required = true)
    protected String issueDate;
    @XmlElement(name = "PriceQuoteMethod")
    protected String priceQuoteMethod;
    @XmlElement(name = "PriceQuoteBaseValue")
    protected String priceQuoteBaseValue;
    @XmlElement(name = "LegData")
    protected List<LegData> legData;
    @XmlElement(name = "SubType")
    protected String subType;
    @XmlElement(name = "PriceType")
    @XmlSchemaType(name = "string")
    protected BondPriceType priceType;

    /**
     * issuerId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerId() {
        return issuerId;
    }

    /**
     * issuerId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerId(String value) {
        this.issuerId = value;
    }

    /**
     * creditCurveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCurveId() {
        return creditCurveId;
    }

    /**
     * creditCurveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCurveId(String value) {
        this.creditCurveId = value;
    }

    /**
     * creditGroup 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditGroup() {
        return creditGroup;
    }

    /**
     * creditGroup 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditGroup(String value) {
        this.creditGroup = value;
    }

    /**
     * referenceCurveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceCurveId() {
        return referenceCurveId;
    }

    /**
     * referenceCurveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceCurveId(String value) {
        this.referenceCurveId = value;
    }

    /**
     * incomeCurveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeCurveId() {
        return incomeCurveId;
    }

    /**
     * incomeCurveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeCurveId(String value) {
        this.incomeCurveId = value;
    }

    /**
     * volatilityCurveId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVolatilityCurveId() {
        return volatilityCurveId;
    }

    /**
     * volatilityCurveId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolatilityCurveId(String value) {
        this.volatilityCurveId = value;
    }

    /**
     * settlementDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementDays() {
        return settlementDays;
    }

    /**
     * settlementDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementDays(String value) {
        this.settlementDays = value;
    }

    /**
     * calendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalendar() {
        return calendar;
    }

    /**
     * calendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalendar(String value) {
        this.calendar = value;
    }

    /**
     * issueDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * issueDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueDate(String value) {
        this.issueDate = value;
    }

    /**
     * priceQuoteMethod 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceQuoteMethod() {
        return priceQuoteMethod;
    }

    /**
     * priceQuoteMethod 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceQuoteMethod(String value) {
        this.priceQuoteMethod = value;
    }

    /**
     * priceQuoteBaseValue 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceQuoteBaseValue() {
        return priceQuoteBaseValue;
    }

    /**
     * priceQuoteBaseValue 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceQuoteBaseValue(String value) {
        this.priceQuoteBaseValue = value;
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

    /**
     * subType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubType() {
        return subType;
    }

    /**
     * subType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubType(String value) {
        this.subType = value;
    }

    /**
     * priceType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BondPriceType }
     *     
     */
    public BondPriceType getPriceType() {
        return priceType;
    }

    /**
     * priceType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BondPriceType }
     *     
     */
    public void setPriceType(BondPriceType value) {
        this.priceType = value;
    }

}
