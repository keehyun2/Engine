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
 * <p>creditDefaultSwapOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="creditDefaultSwapOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="OptionData" type="{}optionData"/>
 *         &lt;element name="CreditDefaultSwapData" type="{}creditDefaultSwapData"/>
 *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="StrikeType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Spread"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="KnockOut" type="{}bool" minOccurs="0"/>
 *         &lt;element name="Term" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuctionSettlementInformation" type="{}auctionSettlementInformation" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditDefaultSwapOptionData", propOrder = {

})
public class CreditDefaultSwapOptionData {

    @XmlElement(name = "OptionData", required = true)
    protected OptionData optionData;
    @XmlElement(name = "CreditDefaultSwapData", required = true)
    protected CreditDefaultSwapData creditDefaultSwapData;
    @XmlElement(name = "Strike")
    protected Float strike;
    @XmlElement(name = "StrikeType")
    protected String strikeType;
    @XmlElement(name = "KnockOut")
    protected String knockOut;
    @XmlElement(name = "Term")
    protected String term;
    @XmlElement(name = "AuctionSettlementInformation")
    protected AuctionSettlementInformation auctionSettlementInformation;

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
     * creditDefaultSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CreditDefaultSwapData }
     *     
     */
    public CreditDefaultSwapData getCreditDefaultSwapData() {
        return creditDefaultSwapData;
    }

    /**
     * creditDefaultSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditDefaultSwapData }
     *     
     */
    public void setCreditDefaultSwapData(CreditDefaultSwapData value) {
        this.creditDefaultSwapData = value;
    }

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
     * strikeType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrikeType() {
        return strikeType;
    }

    /**
     * strikeType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrikeType(String value) {
        this.strikeType = value;
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
     * term 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerm() {
        return term;
    }

    /**
     * term 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerm(String value) {
        this.term = value;
    }

    /**
     * auctionSettlementInformation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AuctionSettlementInformation }
     *     
     */
    public AuctionSettlementInformation getAuctionSettlementInformation() {
        return auctionSettlementInformation;
    }

    /**
     * auctionSettlementInformation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionSettlementInformation }
     *     
     */
    public void setAuctionSettlementInformation(AuctionSettlementInformation value) {
        this.auctionSettlementInformation = value;
    }

}
