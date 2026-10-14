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
 * <p>anonymous complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ReferenceEntityId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tier" type="{}cdsTierType"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="DocClause" type="{}cdsDocClauseType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
public class ReferenceInformation {

    @XmlElement(name = "ReferenceEntityId", required = true)
    protected String referenceEntityId;
    @XmlElement(name = "Tier", required = true)
    @XmlSchemaType(name = "string")
    protected CdsTierType tier;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "DocClause")
    @XmlSchemaType(name = "string")
    protected CdsDocClauseType docClause;

    /**
     * referenceEntityId 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceEntityId() {
        return referenceEntityId;
    }

    /**
     * referenceEntityId 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceEntityId(String value) {
        this.referenceEntityId = value;
    }

    /**
     * tier 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CdsTierType }
     *     
     */
    public CdsTierType getTier() {
        return tier;
    }

    /**
     * tier 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CdsTierType }
     *     
     */
    public void setTier(CdsTierType value) {
        this.tier = value;
    }

    /**
     * currency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getCurrency() {
        return currency;
    }

    /**
     * currency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setCurrency(CurrencyCode value) {
        this.currency = value;
    }

    /**
     * docClause 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CdsDocClauseType }
     *     
     */
    public CdsDocClauseType getDocClause() {
        return docClause;
    }

    /**
     * docClause 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CdsDocClauseType }
     *     
     */
    public void setDocClause(CdsDocClauseType value) {
        this.docClause = value;
    }

}
