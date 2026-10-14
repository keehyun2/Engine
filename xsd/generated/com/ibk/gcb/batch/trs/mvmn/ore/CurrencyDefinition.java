//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>currencyDefinition complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="currencyDefinition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ISOCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MinorUnitCodes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumericCode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Symbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FractionSymbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FractionsPerUnit" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="RoundingType" type="{}roundingType"/>
 *         &lt;element name="RoundingPrecision" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="CurrencyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "currencyDefinition", propOrder = {

})
public class CurrencyDefinition {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "ISOCode", required = true)
    protected String isoCode;
    @XmlElement(name = "MinorUnitCodes")
    protected String minorUnitCodes;
    @XmlElement(name = "NumericCode")
    protected BigInteger numericCode;
    @XmlElement(name = "Symbol", required = true)
    protected String symbol;
    @XmlElement(name = "FractionSymbol", required = true)
    protected String fractionSymbol;
    @XmlElement(name = "FractionsPerUnit", required = true)
    protected BigInteger fractionsPerUnit;
    @XmlElement(name = "RoundingType", required = true)
    @XmlSchemaType(name = "string")
    protected RoundingType roundingType;
    @XmlElement(name = "RoundingPrecision", required = true)
    protected BigInteger roundingPrecision;
    @XmlElement(name = "CurrencyType")
    protected String currencyType;

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
     * isoCode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCode() {
        return isoCode;
    }

    /**
     * isoCode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCode(String value) {
        this.isoCode = value;
    }

    /**
     * minorUnitCodes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinorUnitCodes() {
        return minorUnitCodes;
    }

    /**
     * minorUnitCodes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinorUnitCodes(String value) {
        this.minorUnitCodes = value;
    }

    /**
     * numericCode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumericCode() {
        return numericCode;
    }

    /**
     * numericCode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumericCode(BigInteger value) {
        this.numericCode = value;
    }

    /**
     * symbol 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * symbol 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbol(String value) {
        this.symbol = value;
    }

    /**
     * fractionSymbol 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFractionSymbol() {
        return fractionSymbol;
    }

    /**
     * fractionSymbol 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFractionSymbol(String value) {
        this.fractionSymbol = value;
    }

    /**
     * fractionsPerUnit 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFractionsPerUnit() {
        return fractionsPerUnit;
    }

    /**
     * fractionsPerUnit 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFractionsPerUnit(BigInteger value) {
        this.fractionsPerUnit = value;
    }

    /**
     * roundingType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RoundingType }
     *     
     */
    public RoundingType getRoundingType() {
        return roundingType;
    }

    /**
     * roundingType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RoundingType }
     *     
     */
    public void setRoundingType(RoundingType value) {
        this.roundingType = value;
    }

    /**
     * roundingPrecision 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRoundingPrecision() {
        return roundingPrecision;
    }

    /**
     * roundingPrecision 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRoundingPrecision(BigInteger value) {
        this.roundingPrecision = value;
    }

    /**
     * currencyType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * currencyType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyType(String value) {
        this.currencyType = value;
    }

}
