//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>lgm complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="lgm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Currency" type="{}currencyCode" minOccurs="0"/>
 *         &lt;element name="CalibrationType" type="{}calibrationTypeType"/>
 *         &lt;element name="Volatility">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Calibrate" type="{}bool"/>
 *                   &lt;element name="VolatilityType" type="{}volatilityTypeType"/>
 *                   &lt;element name="ParamType" type="{}paramTypeType"/>
 *                   &lt;element name="TimeGrid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="InitialValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Reversion">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Calibrate" type="{}bool"/>
 *                   &lt;element name="ReversionType" type="{}reversionTypeType"/>
 *                   &lt;element name="ParamType" type="{}paramTypeType"/>
 *                   &lt;element name="TimeGrid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="InitialValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CalibrationSwaptions" minOccurs="0">
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
 *         &lt;element name="CalibrationCapFloors" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="CapFloor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CalibrationBaskets" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CalibrationBasket" type="{}calibrationBasket" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ParameterTransformation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="ShiftHorizon" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="Scaling" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FloatSpreadMapping" type="{}floatSpreadMappingType" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="ccy" type="{}currencyCodeWithDefault" />
 *       &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lgm", propOrder = {

})
public class Lgm {

    @XmlElement(name = "Currency")
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "CalibrationType", required = true)
    @XmlSchemaType(name = "string")
    protected CalibrationTypeType calibrationType;
    @XmlElement(name = "Volatility", required = true)
    protected Lgm.Volatility volatility;
    @XmlElement(name = "Reversion", required = true)
    protected Lgm.Reversion reversion;
    @XmlElement(name = "CalibrationSwaptions")
    protected Lgm.CalibrationSwaptions calibrationSwaptions;
    @XmlElement(name = "CalibrationCapFloors")
    protected Lgm.CalibrationCapFloors calibrationCapFloors;
    @XmlElement(name = "CalibrationBaskets")
    protected Lgm.CalibrationBaskets calibrationBaskets;
    @XmlElement(name = "ParameterTransformation", required = true)
    protected Lgm.ParameterTransformation parameterTransformation;
    @XmlElement(name = "FloatSpreadMapping")
    @XmlSchemaType(name = "string")
    protected FloatSpreadMappingType floatSpreadMapping;
    @XmlAttribute(name = "ccy")
    protected String ccy;
    @XmlAttribute(name = "index")
    protected String index;
    @XmlAttribute(name = "key")
    protected String key;

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
     * volatility 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Lgm.Volatility }
     *     
     */
    public Lgm.Volatility getVolatility() {
        return volatility;
    }

    /**
     * volatility 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Lgm.Volatility }
     *     
     */
    public void setVolatility(Lgm.Volatility value) {
        this.volatility = value;
    }

    /**
     * reversion 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Lgm.Reversion }
     *     
     */
    public Lgm.Reversion getReversion() {
        return reversion;
    }

    /**
     * reversion 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Lgm.Reversion }
     *     
     */
    public void setReversion(Lgm.Reversion value) {
        this.reversion = value;
    }

    /**
     * calibrationSwaptions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Lgm.CalibrationSwaptions }
     *     
     */
    public Lgm.CalibrationSwaptions getCalibrationSwaptions() {
        return calibrationSwaptions;
    }

    /**
     * calibrationSwaptions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Lgm.CalibrationSwaptions }
     *     
     */
    public void setCalibrationSwaptions(Lgm.CalibrationSwaptions value) {
        this.calibrationSwaptions = value;
    }

    /**
     * calibrationCapFloors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Lgm.CalibrationCapFloors }
     *     
     */
    public Lgm.CalibrationCapFloors getCalibrationCapFloors() {
        return calibrationCapFloors;
    }

    /**
     * calibrationCapFloors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Lgm.CalibrationCapFloors }
     *     
     */
    public void setCalibrationCapFloors(Lgm.CalibrationCapFloors value) {
        this.calibrationCapFloors = value;
    }

    /**
     * calibrationBaskets 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Lgm.CalibrationBaskets }
     *     
     */
    public Lgm.CalibrationBaskets getCalibrationBaskets() {
        return calibrationBaskets;
    }

    /**
     * calibrationBaskets 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Lgm.CalibrationBaskets }
     *     
     */
    public void setCalibrationBaskets(Lgm.CalibrationBaskets value) {
        this.calibrationBaskets = value;
    }

    /**
     * parameterTransformation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Lgm.ParameterTransformation }
     *     
     */
    public Lgm.ParameterTransformation getParameterTransformation() {
        return parameterTransformation;
    }

    /**
     * parameterTransformation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Lgm.ParameterTransformation }
     *     
     */
    public void setParameterTransformation(Lgm.ParameterTransformation value) {
        this.parameterTransformation = value;
    }

    /**
     * floatSpreadMapping 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FloatSpreadMappingType }
     *     
     */
    public FloatSpreadMappingType getFloatSpreadMapping() {
        return floatSpreadMapping;
    }

    /**
     * floatSpreadMapping 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FloatSpreadMappingType }
     *     
     */
    public void setFloatSpreadMapping(FloatSpreadMappingType value) {
        this.floatSpreadMapping = value;
    }

    /**
     * ccy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcy() {
        return ccy;
    }

    /**
     * ccy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcy(String value) {
        this.ccy = value;
    }

    /**
     * index 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndex() {
        return index;
    }

    /**
     * index 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndex(String value) {
        this.index = value;
    }

    /**
     * key 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * key 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
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
     *       &lt;sequence>
     *         &lt;element name="CalibrationBasket" type="{}calibrationBasket" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "calibrationBasket"
    })
    public static class CalibrationBaskets {

        @XmlElement(name = "CalibrationBasket", required = true)
        protected List<CalibrationBasket> calibrationBasket;

        /**
         * Gets the value of the calibrationBasket property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the calibrationBasket property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCalibrationBasket().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CalibrationBasket }
         * 
         * 
         */
        public List<CalibrationBasket> getCalibrationBasket() {
            if (calibrationBasket == null) {
                calibrationBasket = new ArrayList<CalibrationBasket>();
            }
            return this.calibrationBasket;
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
     *         &lt;element name="CapFloor" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    public static class CalibrationCapFloors {

        @XmlElement(name = "CapFloor", required = true)
        protected String capFloor;
        @XmlElement(name = "Expiries", required = true)
        protected String expiries;
        @XmlElement(name = "Strikes", required = true)
        protected String strikes;

        /**
         * capFloor 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCapFloor() {
            return capFloor;
        }

        /**
         * capFloor 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCapFloor(String value) {
            this.capFloor = value;
        }

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
    public static class CalibrationSwaptions {

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
     *         &lt;element name="ShiftHorizon" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="Scaling" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
    public static class ParameterTransformation {

        @XmlElement(name = "ShiftHorizon")
        protected float shiftHorizon;
        @XmlElement(name = "Scaling")
        protected float scaling;

        /**
         * shiftHorizon 속성의 값을 가져옵니다.
         * 
         */
        public float getShiftHorizon() {
            return shiftHorizon;
        }

        /**
         * shiftHorizon 속성의 값을 설정합니다.
         * 
         */
        public void setShiftHorizon(float value) {
            this.shiftHorizon = value;
        }

        /**
         * scaling 속성의 값을 가져옵니다.
         * 
         */
        public float getScaling() {
            return scaling;
        }

        /**
         * scaling 속성의 값을 설정합니다.
         * 
         */
        public void setScaling(float value) {
            this.scaling = value;
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
     *         &lt;element name="ReversionType" type="{}reversionTypeType"/>
     *         &lt;element name="ParamType" type="{}paramTypeType"/>
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
    public static class Reversion {

        @XmlElement(name = "Calibrate", required = true)
        protected String calibrate;
        @XmlElement(name = "ReversionType", required = true)
        @XmlSchemaType(name = "string")
        protected ReversionTypeType reversionType;
        @XmlElement(name = "ParamType", required = true)
        @XmlSchemaType(name = "string")
        protected ParamTypeType paramType;
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
         * reversionType 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ReversionTypeType }
         *     
         */
        public ReversionTypeType getReversionType() {
            return reversionType;
        }

        /**
         * reversionType 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ReversionTypeType }
         *     
         */
        public void setReversionType(ReversionTypeType value) {
            this.reversionType = value;
        }

        /**
         * paramType 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ParamTypeType }
         *     
         */
        public ParamTypeType getParamType() {
            return paramType;
        }

        /**
         * paramType 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ParamTypeType }
         *     
         */
        public void setParamType(ParamTypeType value) {
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
     *         &lt;element name="VolatilityType" type="{}volatilityTypeType"/>
     *         &lt;element name="ParamType" type="{}paramTypeType"/>
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
    public static class Volatility {

        @XmlElement(name = "Calibrate", required = true)
        protected String calibrate;
        @XmlElement(name = "VolatilityType", required = true)
        @XmlSchemaType(name = "string")
        protected VolatilityTypeType volatilityType;
        @XmlElement(name = "ParamType", required = true)
        @XmlSchemaType(name = "string")
        protected ParamTypeType paramType;
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
         * volatilityType 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link VolatilityTypeType }
         *     
         */
        public VolatilityTypeType getVolatilityType() {
            return volatilityType;
        }

        /**
         * volatilityType 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link VolatilityTypeType }
         *     
         */
        public void setVolatilityType(VolatilityTypeType value) {
            this.volatilityType = value;
        }

        /**
         * paramType 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ParamTypeType }
         *     
         */
        public ParamTypeType getParamType() {
            return paramType;
        }

        /**
         * paramType 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ParamTypeType }
         *     
         */
        public void setParamType(ParamTypeType value) {
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
