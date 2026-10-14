//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>crossAssetLGM complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="crossAssetLGM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="CalibrationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Sigma">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Calibrate" type="{}bool"/>
 *                   &lt;element name="ParamType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TimeGrid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="InitialValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CalibrationOptions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crossAssetLGM", propOrder = {

})
public class CrossAssetLGM {

    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "CalibrationType", required = true)
    protected String calibrationType;
    @XmlElement(name = "Sigma", required = true)
    protected CrossAssetLGM.Sigma sigma;
    @XmlElement(name = "CalibrationOptions")
    protected CrossAssetLGM.CalibrationOptions calibrationOptions;
    @XmlAttribute(name = "name", required = true)
    protected String name;

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
     *     {@link String }
     *     
     */
    public String getCalibrationType() {
        return calibrationType;
    }

    /**
     * calibrationType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalibrationType(String value) {
        this.calibrationType = value;
    }

    /**
     * sigma 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetLGM.Sigma }
     *     
     */
    public CrossAssetLGM.Sigma getSigma() {
        return sigma;
    }

    /**
     * sigma 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetLGM.Sigma }
     *     
     */
    public void setSigma(CrossAssetLGM.Sigma value) {
        this.sigma = value;
    }

    /**
     * calibrationOptions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CrossAssetLGM.CalibrationOptions }
     *     
     */
    public CrossAssetLGM.CalibrationOptions getCalibrationOptions() {
        return calibrationOptions;
    }

    /**
     * calibrationOptions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossAssetLGM.CalibrationOptions }
     *     
     */
    public void setCalibrationOptions(CrossAssetLGM.CalibrationOptions value) {
        this.calibrationOptions = value;
    }

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
    public static class CalibrationOptions {

        @XmlElement(name = "Expiries", required = true)
        protected String expiries;
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
     *         &lt;element name="Calibrate" type="{}bool"/>
     *         &lt;element name="ParamType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="TimeGrid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="InitialValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    public static class Sigma {

        @XmlElement(name = "Calibrate", required = true)
        protected String calibrate;
        @XmlElement(name = "ParamType", required = true)
        protected String paramType;
        @XmlElement(name = "TimeGrid", required = true)
        protected String timeGrid;
        @XmlElement(name = "InitialValue", required = true)
        protected String initialValue;

        /**
         * calibrate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCalibrate() {
            return calibrate;
        }

        /**
         * calibrate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCalibrate(String value) {
            this.calibrate = value;
        }

        /**
         * paramType 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getParamType() {
            return paramType;
        }

        /**
         * paramType 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setParamType(String value) {
            this.paramType = value;
        }

        /**
         * timeGrid 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTimeGrid() {
            return timeGrid;
        }

        /**
         * timeGrid 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTimeGrid(String value) {
            this.timeGrid = value;
        }

        /**
         * initialValue 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInitialValue() {
            return initialValue;
        }

        /**
         * initialValue 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInitialValue(String value) {
            this.initialValue = value;
        }

    }

}
