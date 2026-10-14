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
 * <p>indexCreditDefaultSwapOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="indexCreditDefaultSwapOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="KnockOut" type="{}bool" minOccurs="0"/>
 *         &lt;element name="IndexTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StrikeType" type="{}cdsOptionstrikeType" minOccurs="0"/>
 *         &lt;element name="TradeDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="FrontEndProtectionStartDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="OptionData" type="{}optionData"/>
 *         &lt;element name="IndexCreditDefaultSwapData" type="{}indexCreditDefaultSwapData"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "indexCreditDefaultSwapOptionData", propOrder = {

})
public class IndexCreditDefaultSwapOptionData {

    @XmlElement(name = "Strike")
    protected Float strike;
    @XmlElement(name = "KnockOut")
    protected String knockOut;
    @XmlElement(name = "IndexTerm")
    protected String indexTerm;
    @XmlElement(name = "StrikeType")
    @XmlSchemaType(name = "string")
    protected CdsOptionstrikeType strikeType;
    @XmlElement(name = "TradeDate")
    protected String tradeDate;
    @XmlElement(name = "FrontEndProtectionStartDate")
    protected String frontEndProtectionStartDate;
    @XmlElement(name = "OptionData", required = true)
    protected OptionData optionData;
    @XmlElement(name = "IndexCreditDefaultSwapData", required = true)
    protected IndexCreditDefaultSwapData indexCreditDefaultSwapData;

    /**
     * strike 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getStrike() {
        return strike;
    }

    /**
     * strike 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setStrike(Float value) {
        this.strike = value;
    }

    /**
     * knockOut 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKnockOut() {
        return knockOut;
    }

    /**
     * knockOut 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKnockOut(String value) {
        this.knockOut = value;
    }

    /**
     * indexTerm 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexTerm() {
        return indexTerm;
    }

    /**
     * indexTerm 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexTerm(String value) {
        this.indexTerm = value;
    }

    /**
     * strikeType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CdsOptionstrikeType }
     *     
     */
    public CdsOptionstrikeType getStrikeType() {
        return strikeType;
    }

    /**
     * strikeType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CdsOptionstrikeType }
     *     
     */
    public void setStrikeType(CdsOptionstrikeType value) {
        this.strikeType = value;
    }

    /**
     * tradeDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeDate() {
        return tradeDate;
    }

    /**
     * tradeDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeDate(String value) {
        this.tradeDate = value;
    }

    /**
     * frontEndProtectionStartDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrontEndProtectionStartDate() {
        return frontEndProtectionStartDate;
    }

    /**
     * frontEndProtectionStartDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrontEndProtectionStartDate(String value) {
        this.frontEndProtectionStartDate = value;
    }

    /**
     * optionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OptionData }
     *     
     */
    public OptionData getOptionData() {
        return optionData;
    }

    /**
     * optionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionData }
     *     
     */
    public void setOptionData(OptionData value) {
        this.optionData = value;
    }

    /**
     * indexCreditDefaultSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link IndexCreditDefaultSwapData }
     *     
     */
    public IndexCreditDefaultSwapData getIndexCreditDefaultSwapData() {
        return indexCreditDefaultSwapData;
    }

    /**
     * indexCreditDefaultSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link IndexCreditDefaultSwapData }
     *     
     */
    public void setIndexCreditDefaultSwapData(IndexCreditDefaultSwapData value) {
        this.indexCreditDefaultSwapData = value;
    }

}
