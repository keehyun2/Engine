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
 * <p>eqOutperformanceOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="eqOutperformanceOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="OptionData" type="{}optionData"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="Notional" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Underlying1" type="{}underlying"/>
 *         &lt;element name="Underlying2" type="{}underlying"/>
 *         &lt;element name="InitialPrice1" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="InitialPrice2" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="StrikeReturn" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="KnockInPrice" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="KnockOutPrice" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="InitialPriceCurrency1" type="{}currencyCode" minOccurs="0"/>
 *         &lt;element name="InitialPriceFXTerms1" type="{}fxTermsData" minOccurs="0"/>
 *         &lt;element name="InitialPriceCurrency2" type="{}currencyCode" minOccurs="0"/>
 *         &lt;element name="InitialPriceFXTerms2" type="{}fxTermsData" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eqOutperformanceOptionData", propOrder = {

})
public class EqOutperformanceOptionData {

    @XmlElement(name = "OptionData", required = true)
    protected OptionData optionData;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "Notional")
    protected float notional;
    @XmlElement(name = "Underlying1", required = true)
    protected Underlying underlying1;
    @XmlElement(name = "Underlying2", required = true)
    protected Underlying underlying2;
    @XmlElement(name = "InitialPrice1")
    protected float initialPrice1;
    @XmlElement(name = "InitialPrice2")
    protected float initialPrice2;
    @XmlElement(name = "StrikeReturn")
    protected float strikeReturn;
    @XmlElement(name = "KnockInPrice")
    protected Float knockInPrice;
    @XmlElement(name = "KnockOutPrice")
    protected Float knockOutPrice;
    @XmlElement(name = "InitialPriceCurrency1")
    @XmlSchemaType(name = "string")
    protected CurrencyCode initialPriceCurrency1;
    @XmlElement(name = "InitialPriceFXTerms1")
    protected FxTermsData initialPriceFXTerms1;
    @XmlElement(name = "InitialPriceCurrency2")
    @XmlSchemaType(name = "string")
    protected CurrencyCode initialPriceCurrency2;
    @XmlElement(name = "InitialPriceFXTerms2")
    protected FxTermsData initialPriceFXTerms2;

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
     * underlying1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getUnderlying1() {
        return underlying1;
    }

    /**
     * underlying1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setUnderlying1(Underlying value) {
        this.underlying1 = value;
    }

    /**
     * underlying2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getUnderlying2() {
        return underlying2;
    }

    /**
     * underlying2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setUnderlying2(Underlying value) {
        this.underlying2 = value;
    }

    /**
     * initialPrice1 속성의 값을 가져옵니다.
     * 
     */
    public float getInitialPrice1() {
        return initialPrice1;
    }

    /**
     * initialPrice1 속성의 값을 설정합니다.
     * 
     */
    public void setInitialPrice1(float value) {
        this.initialPrice1 = value;
    }

    /**
     * initialPrice2 속성의 값을 가져옵니다.
     * 
     */
    public float getInitialPrice2() {
        return initialPrice2;
    }

    /**
     * initialPrice2 속성의 값을 설정합니다.
     * 
     */
    public void setInitialPrice2(float value) {
        this.initialPrice2 = value;
    }

    /**
     * strikeReturn 속성의 값을 가져옵니다.
     * 
     */
    public float getStrikeReturn() {
        return strikeReturn;
    }

    /**
     * strikeReturn 속성의 값을 설정합니다.
     * 
     */
    public void setStrikeReturn(float value) {
        this.strikeReturn = value;
    }

    /**
     * knockInPrice 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getKnockInPrice() {
        return knockInPrice;
    }

    /**
     * knockInPrice 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setKnockInPrice(Float value) {
        this.knockInPrice = value;
    }

    /**
     * knockOutPrice 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getKnockOutPrice() {
        return knockOutPrice;
    }

    /**
     * knockOutPrice 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setKnockOutPrice(Float value) {
        this.knockOutPrice = value;
    }

    /**
     * initialPriceCurrency1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getInitialPriceCurrency1() {
        return initialPriceCurrency1;
    }

    /**
     * initialPriceCurrency1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setInitialPriceCurrency1(CurrencyCode value) {
        this.initialPriceCurrency1 = value;
    }

    /**
     * initialPriceFXTerms1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxTermsData }
     *     
     */
    public FxTermsData getInitialPriceFXTerms1() {
        return initialPriceFXTerms1;
    }

    /**
     * initialPriceFXTerms1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxTermsData }
     *     
     */
    public void setInitialPriceFXTerms1(FxTermsData value) {
        this.initialPriceFXTerms1 = value;
    }

    /**
     * initialPriceCurrency2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getInitialPriceCurrency2() {
        return initialPriceCurrency2;
    }

    /**
     * initialPriceCurrency2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setInitialPriceCurrency2(CurrencyCode value) {
        this.initialPriceCurrency2 = value;
    }

    /**
     * initialPriceFXTerms2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxTermsData }
     *     
     */
    public FxTermsData getInitialPriceFXTerms2() {
        return initialPriceFXTerms2;
    }

    /**
     * initialPriceFXTerms2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxTermsData }
     *     
     */
    public void setInitialPriceFXTerms2(FxTermsData value) {
        this.initialPriceFXTerms2 = value;
    }

}
