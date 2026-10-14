//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>fxType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="fxType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SpotDays" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="SourceCurrency" type="{}currencyCode"/>
 *         &lt;element name="TargetCurrency" type="{}currencyCode"/>
 *         &lt;element name="PointsFactor" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="AdvanceCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpotRelative" type="{}bool" minOccurs="0"/>
 *         &lt;element name="EOM" type="{}bool" minOccurs="0"/>
 *         &lt;element name="Convention" type="{}businessDayConvention" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fxType", propOrder = {

})
public class FxType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "SpotDays", required = true)
    protected BigInteger spotDays;
    @XmlElement(name = "SourceCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode sourceCurrency;
    @XmlElement(name = "TargetCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode targetCurrency;
    @XmlElement(name = "PointsFactor", required = true)
    protected BigDecimal pointsFactor;
    @XmlElement(name = "AdvanceCalendar")
    protected String advanceCalendar;
    @XmlElement(name = "SpotRelative")
    protected String spotRelative;
    @XmlElement(name = "EOM")
    protected String eom;
    @XmlElement(name = "Convention")
    protected String convention;

    /**
     * id 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * id 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * spotDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpotDays() {
        return spotDays;
    }

    /**
     * spotDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpotDays(BigInteger value) {
        this.spotDays = value;
    }

    /**
     * sourceCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getSourceCurrency() {
        return sourceCurrency;
    }

    /**
     * sourceCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setSourceCurrency(CurrencyCode value) {
        this.sourceCurrency = value;
    }

    /**
     * targetCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getTargetCurrency() {
        return targetCurrency;
    }

    /**
     * targetCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setTargetCurrency(CurrencyCode value) {
        this.targetCurrency = value;
    }

    /**
     * pointsFactor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPointsFactor() {
        return pointsFactor;
    }

    /**
     * pointsFactor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPointsFactor(BigDecimal value) {
        this.pointsFactor = value;
    }

    /**
     * advanceCalendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvanceCalendar() {
        return advanceCalendar;
    }

    /**
     * advanceCalendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvanceCalendar(String value) {
        this.advanceCalendar = value;
    }

    /**
     * spotRelative 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpotRelative() {
        return spotRelative;
    }

    /**
     * spotRelative 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpotRelative(String value) {
        this.spotRelative = value;
    }

    /**
     * eom 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEOM() {
        return eom;
    }

    /**
     * eom 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEOM(String value) {
        this.eom = value;
    }

    /**
     * convention 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConvention() {
        return convention;
    }

    /**
     * convention 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConvention(String value) {
        this.convention = value;
    }

}
