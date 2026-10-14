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
 * <p>cir complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="cir">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Currency" type="{}currencyCode" minOccurs="0"/>
 *         &lt;element name="CalibrationType" type="{}calibrationTypeType"/>
 *         &lt;element name="CalibrationStrategy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartValue" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="ReversionValue" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="LongTermValue" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Volatility" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="RelaxedFeller" type="{}bool"/>
 *         &lt;element name="FellerFactor" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Tolerance" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="CalibrationCdsOptions">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Terms" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cir", propOrder = {
    "currency",
    "calibrationType",
    "calibrationStrategy",
    "startValue",
    "reversionValue",
    "longTermValue",
    "volatility",
    "relaxedFeller",
    "fellerFactor",
    "tolerance",
    "calibrationCdsOptions"
})
public class Cir {

    @XmlElement(name = "Currency")
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "CalibrationType", required = true)
    @XmlSchemaType(name = "string")
    protected CalibrationTypeType calibrationType;
    @XmlElement(name = "CalibrationStrategy", required = true)
    protected String calibrationStrategy;
    @XmlElement(name = "StartValue")
    protected float startValue;
    @XmlElement(name = "ReversionValue")
    protected float reversionValue;
    @XmlElement(name = "LongTermValue")
    protected float longTermValue;
    @XmlElement(name = "Volatility")
    protected float volatility;
    @XmlElement(name = "RelaxedFeller", required = true)
    protected String relaxedFeller;
    @XmlElement(name = "FellerFactor")
    protected float fellerFactor;
    @XmlElement(name = "Tolerance")
    protected float tolerance;
    @XmlElement(name = "CalibrationCdsOptions", required = true)
    protected Cir.CalibrationCdsOptions calibrationCdsOptions;

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
     * calibrationType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CalibrationTypeType }
     *     
     */
    public CalibrationTypeType getCalibrationType() {
        return calibrationType;
    }

    /**
     * calibrationType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CalibrationTypeType }
     *     
     */
    public void setCalibrationType(CalibrationTypeType value) {
        this.calibrationType = value;
    }

    /**
     * calibrationStrategy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalibrationStrategy() {
        return calibrationStrategy;
    }

    /**
     * calibrationStrategy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalibrationStrategy(String value) {
        this.calibrationStrategy = value;
    }

    /**
     * startValue 속성의 값을 가져옵니다.
     * 
     */
    public float getStartValue() {
        return startValue;
    }

    /**
     * startValue 속성의 값을 설정합니다.
     * 
     */
    public void setStartValue(float value) {
        this.startValue = value;
    }

    /**
     * reversionValue 속성의 값을 가져옵니다.
     * 
     */
    public float getReversionValue() {
        return reversionValue;
    }

    /**
     * reversionValue 속성의 값을 설정합니다.
     * 
     */
    public void setReversionValue(float value) {
        this.reversionValue = value;
    }

    /**
     * longTermValue 속성의 값을 가져옵니다.
     * 
     */
    public float getLongTermValue() {
        return longTermValue;
    }

    /**
     * longTermValue 속성의 값을 설정합니다.
     * 
     */
    public void setLongTermValue(float value) {
        this.longTermValue = value;
    }

    /**
     * volatility 속성의 값을 가져옵니다.
     * 
     */
    public float getVolatility() {
        return volatility;
    }

    /**
     * volatility 속성의 값을 설정합니다.
     * 
     */
    public void setVolatility(float value) {
        this.volatility = value;
    }

    /**
     * relaxedFeller 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelaxedFeller() {
        return relaxedFeller;
    }

    /**
     * relaxedFeller 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelaxedFeller(String value) {
        this.relaxedFeller = value;
    }

    /**
     * fellerFactor 속성의 값을 가져옵니다.
     * 
     */
    public float getFellerFactor() {
        return fellerFactor;
    }

    /**
     * fellerFactor 속성의 값을 설정합니다.
     * 
     */
    public void setFellerFactor(float value) {
        this.fellerFactor = value;
    }

    /**
     * tolerance 속성의 값을 가져옵니다.
     * 
     */
    public float getTolerance() {
        return tolerance;
    }

    /**
     * tolerance 속성의 값을 설정합니다.
     * 
     */
    public void setTolerance(float value) {
        this.tolerance = value;
    }

    /**
     * calibrationCdsOptions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Cir.CalibrationCdsOptions }
     *     
     */
    public Cir.CalibrationCdsOptions getCalibrationCdsOptions() {
        return calibrationCdsOptions;
    }

    /**
     * calibrationCdsOptions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Cir.CalibrationCdsOptions }
     *     
     */
    public void setCalibrationCdsOptions(Cir.CalibrationCdsOptions value) {
        this.calibrationCdsOptions = value;
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
     *         &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Terms" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    public static class CalibrationCdsOptions {

        @XmlElement(name = "Expiries", required = true)
        protected String expiries;
        @XmlElement(name = "Terms", required = true)
        protected String terms;
        @XmlElement(name = "Strikes", required = true)
        protected String strikes;

        /**
         * expiries 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExpiries() {
            return expiries;
        }

        /**
         * expiries 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExpiries(String value) {
            this.expiries = value;
        }

        /**
         * terms 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTerms() {
            return terms;
        }

        /**
         * terms 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTerms(String value) {
            this.terms = value;
        }

        /**
         * strikes 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStrikes() {
            return strikes;
        }

        /**
         * strikes 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStrikes(String value) {
            this.strikes = value;
        }

    }

}
