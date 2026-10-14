//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ReturnType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}underlyingTypes"/>
 *         &lt;element name="InitialPrice" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="InitialPriceCurrency" type="{}extendedCurrencyCode" minOccurs="0"/>
 *         &lt;element name="DividendFactor" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="NotionalReset" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ValuationSchedule" type="{}scheduleData" minOccurs="0"/>
 *         &lt;element name="FixingDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FXTerms" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="EquityCurrency" type="{}extendedCurrencyCode" minOccurs="0"/>
 *                   &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FXIndexFixingDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="FXIndexCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
public class EquityLegData {

    @XmlElement(name = "Quantity")
    protected Float quantity;
    @XmlElement(name = "ReturnType", required = true)
    protected String returnType;
    @XmlElementRef(name = "underlyingTypes", type = JAXBElement.class)
    protected JAXBElement<?> underlyingTypes;
    @XmlElement(name = "InitialPrice")
    protected Float initialPrice;
    @XmlElement(name = "InitialPriceCurrency")
    protected String initialPriceCurrency;
    @XmlElement(name = "DividendFactor")
    protected Float dividendFactor;
    @XmlElement(name = "NotionalReset")
    protected Boolean notionalReset;
    @XmlElement(name = "ValuationSchedule")
    protected ScheduleData valuationSchedule;
    @XmlElement(name = "FixingDays")
    protected BigInteger fixingDays;
    @XmlElement(name = "FXTerms")
    protected EquityLegData.FXTerms fxTerms;

    /**
     * quantity 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getQuantity() {
        return quantity;
    }

    /**
     * quantity 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setQuantity(Float value) {
        this.quantity = value;
    }

    /**
     * returnType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnType() {
        return returnType;
    }

    /**
     * returnType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnType(String value) {
        this.returnType = value;
    }

    /**
     * underlyingTypes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlying }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlyings }{@code >}
     *     
     */
    public JAXBElement<?> getUnderlyingTypes() {
        return underlyingTypes;
    }

    /**
     * underlyingTypes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlying }{@code >}
     *     {@link JAXBElement }{@code <}{@link Underlyings }{@code >}
     *     
     */
    public void setUnderlyingTypes(JAXBElement<?> value) {
        this.underlyingTypes = value;
    }

    /**
     * initialPrice 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getInitialPrice() {
        return initialPrice;
    }

    /**
     * initialPrice 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setInitialPrice(Float value) {
        this.initialPrice = value;
    }

    /**
     * initialPriceCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialPriceCurrency() {
        return initialPriceCurrency;
    }

    /**
     * initialPriceCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialPriceCurrency(String value) {
        this.initialPriceCurrency = value;
    }

    /**
     * dividendFactor 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDividendFactor() {
        return dividendFactor;
    }

    /**
     * dividendFactor 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setDividendFactor(Float value) {
        this.dividendFactor = value;
    }

    /**
     * notionalReset 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotionalReset() {
        return notionalReset;
    }

    /**
     * notionalReset 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotionalReset(Boolean value) {
        this.notionalReset = value;
    }

    /**
     * valuationSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleData }
     *     
     */
    public ScheduleData getValuationSchedule() {
        return valuationSchedule;
    }

    /**
     * valuationSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleData }
     *     
     */
    public void setValuationSchedule(ScheduleData value) {
        this.valuationSchedule = value;
    }

    /**
     * fixingDays 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFixingDays() {
        return fixingDays;
    }

    /**
     * fixingDays 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFixingDays(BigInteger value) {
        this.fixingDays = value;
    }

    /**
     * fxTerms 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link EquityLegData.FXTerms }
     *     
     */
    public EquityLegData.FXTerms getFXTerms() {
        return fxTerms;
    }

    /**
     * fxTerms 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link EquityLegData.FXTerms }
     *     
     */
    public void setFXTerms(EquityLegData.FXTerms value) {
        this.fxTerms = value;
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
     *       &lt;all>
     *         &lt;element name="EquityCurrency" type="{}extendedCurrencyCode" minOccurs="0"/>
     *         &lt;element name="FXIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FXIndexFixingDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="FXIndexCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class FXTerms {

        @XmlElement(name = "EquityCurrency")
        protected String equityCurrency;
        @XmlElement(name = "FXIndex")
        protected String fxIndex;
        @XmlElement(name = "FXIndexFixingDays")
        protected BigInteger fxIndexFixingDays;
        @XmlElement(name = "FXIndexCalendar")
        protected String fxIndexCalendar;

        /**
         * equityCurrency 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEquityCurrency() {
            return equityCurrency;
        }

        /**
         * equityCurrency 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEquityCurrency(String value) {
            this.equityCurrency = value;
        }

        /**
         * fxIndex 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFXIndex() {
            return fxIndex;
        }

        /**
         * fxIndex 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFXIndex(String value) {
            this.fxIndex = value;
        }

        /**
         * fxIndexFixingDays 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getFXIndexFixingDays() {
            return fxIndexFixingDays;
        }

        /**
         * fxIndexFixingDays 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setFXIndexFixingDays(BigInteger value) {
            this.fxIndexFixingDays = value;
        }

        /**
         * fxIndexCalendar 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFXIndexCalendar() {
            return fxIndexCalendar;
        }

        /**
         * fxIndexCalendar 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFXIndexCalendar(String value) {
            this.fxIndexCalendar = value;
        }

    }

}
