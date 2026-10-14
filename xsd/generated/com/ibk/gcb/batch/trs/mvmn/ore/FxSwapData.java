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
 * <p>fxSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="fxSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="NearDate" type="{}date"/>
 *         &lt;element name="NearBoughtCurrency" type="{}currencyCode"/>
 *         &lt;element name="NearBoughtAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="NearSoldCurrency" type="{}currencyCode"/>
 *         &lt;element name="NearSoldAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="FarDate" type="{}date"/>
 *         &lt;element name="FarBoughtAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="FarSoldAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Settlement" type="{}settlementType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fxSwapData", propOrder = {

})
public class FxSwapData {

    @XmlElement(name = "NearDate", required = true)
    protected String nearDate;
    @XmlElement(name = "NearBoughtCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode nearBoughtCurrency;
    @XmlElement(name = "NearBoughtAmount")
    protected float nearBoughtAmount;
    @XmlElement(name = "NearSoldCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode nearSoldCurrency;
    @XmlElement(name = "NearSoldAmount")
    protected float nearSoldAmount;
    @XmlElement(name = "FarDate", required = true)
    protected String farDate;
    @XmlElement(name = "FarBoughtAmount")
    protected float farBoughtAmount;
    @XmlElement(name = "FarSoldAmount")
    protected float farSoldAmount;
    @XmlElement(name = "Settlement")
    @XmlSchemaType(name = "string")
    protected SettlementType settlement;

    /**
     * nearDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNearDate() {
        return nearDate;
    }

    /**
     * nearDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNearDate(String value) {
        this.nearDate = value;
    }

    /**
     * nearBoughtCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getNearBoughtCurrency() {
        return nearBoughtCurrency;
    }

    /**
     * nearBoughtCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setNearBoughtCurrency(CurrencyCode value) {
        this.nearBoughtCurrency = value;
    }

    /**
     * nearBoughtAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getNearBoughtAmount() {
        return nearBoughtAmount;
    }

    /**
     * nearBoughtAmount 속성의 값을 설정합니다.
     * 
     */
    public void setNearBoughtAmount(float value) {
        this.nearBoughtAmount = value;
    }

    /**
     * nearSoldCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getNearSoldCurrency() {
        return nearSoldCurrency;
    }

    /**
     * nearSoldCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setNearSoldCurrency(CurrencyCode value) {
        this.nearSoldCurrency = value;
    }

    /**
     * nearSoldAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getNearSoldAmount() {
        return nearSoldAmount;
    }

    /**
     * nearSoldAmount 속성의 값을 설정합니다.
     * 
     */
    public void setNearSoldAmount(float value) {
        this.nearSoldAmount = value;
    }

    /**
     * farDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFarDate() {
        return farDate;
    }

    /**
     * farDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFarDate(String value) {
        this.farDate = value;
    }

    /**
     * farBoughtAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getFarBoughtAmount() {
        return farBoughtAmount;
    }

    /**
     * farBoughtAmount 속성의 값을 설정합니다.
     * 
     */
    public void setFarBoughtAmount(float value) {
        this.farBoughtAmount = value;
    }

    /**
     * farSoldAmount 속성의 값을 가져옵니다.
     * 
     */
    public float getFarSoldAmount() {
        return farSoldAmount;
    }

    /**
     * farSoldAmount 속성의 값을 설정합니다.
     * 
     */
    public void setFarSoldAmount(float value) {
        this.farSoldAmount = value;
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

}
