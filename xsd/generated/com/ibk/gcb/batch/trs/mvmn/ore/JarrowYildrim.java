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
 * <p>jarrowYildrim complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="jarrowYildrim">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;element name="CalibrationType" type="{}calibrationTypeType"/>
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
 *         &lt;element name="RealRate">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Volatility" type="{}volatilityParameter"/>
 *                   &lt;element name="Reversion" type="{}reversionParameter"/>
 *                   &lt;element name="ParameterTransformation" type="{}lgmReversionTransformation"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Index">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Volatility" type="{}volatilityParameter"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CalibrationConfiguration" type="{}calibrationConfiguration" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jarrowYildrim", propOrder = {

})
public class JarrowYildrim {

    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode currency;
    @XmlElement(name = "CalibrationType", required = true)
    @XmlSchemaType(name = "string")
    protected CalibrationTypeType calibrationType;
    @XmlElement(name = "CalibrationBaskets")
    protected JarrowYildrim.CalibrationBaskets calibrationBaskets;
    @XmlElement(name = "RealRate", required = true)
    protected JarrowYildrim.RealRate realRate;
    @XmlElement(name = "Index", required = true)
    protected JarrowYildrim.Index index;
    @XmlElement(name = "CalibrationConfiguration")
    protected CalibrationConfiguration calibrationConfiguration;
    @XmlAttribute(name = "index")
    protected String indexName;

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
     * calibrationBaskets 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JarrowYildrim.CalibrationBaskets }
     *     
     */
    public JarrowYildrim.CalibrationBaskets getCalibrationBaskets() {
        return calibrationBaskets;
    }

    /**
     * calibrationBaskets 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JarrowYildrim.CalibrationBaskets }
     *     
     */
    public void setCalibrationBaskets(JarrowYildrim.CalibrationBaskets value) {
        this.calibrationBaskets = value;
    }

    /**
     * realRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JarrowYildrim.RealRate }
     *     
     */
    public JarrowYildrim.RealRate getRealRate() {
        return realRate;
    }

    /**
     * realRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JarrowYildrim.RealRate }
     *     
     */
    public void setRealRate(JarrowYildrim.RealRate value) {
        this.realRate = value;
    }

    /**
     * index 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JarrowYildrim.Index }
     *     
     */
    public JarrowYildrim.Index getIndex() {
        return index;
    }

    /**
     * index 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JarrowYildrim.Index }
     *     
     */
    public void setIndex(JarrowYildrim.Index value) {
        this.index = value;
    }

    /**
     * calibrationConfiguration 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CalibrationConfiguration }
     *     
     */
    public CalibrationConfiguration getCalibrationConfiguration() {
        return calibrationConfiguration;
    }

    /**
     * calibrationConfiguration 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CalibrationConfiguration }
     *     
     */
    public void setCalibrationConfiguration(CalibrationConfiguration value) {
        this.calibrationConfiguration = value;
    }

    /**
     * indexName 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexName() {
        return indexName;
    }

    /**
     * indexName 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexName(String value) {
        this.indexName = value;
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
     *       &lt;sequence>
     *         &lt;element name="Volatility" type="{}volatilityParameter"/>
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
        "volatility"
    })
    public static class Index {

        @XmlElement(name = "Volatility", required = true)
        protected VolatilityParameter volatility;

        /**
         * volatility 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link VolatilityParameter }
         *     
         */
        public VolatilityParameter getVolatility() {
            return volatility;
        }

        /**
         * volatility 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link VolatilityParameter }
         *     
         */
        public void setVolatility(VolatilityParameter value) {
            this.volatility = value;
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
     *       &lt;sequence>
     *         &lt;element name="Volatility" type="{}volatilityParameter"/>
     *         &lt;element name="Reversion" type="{}reversionParameter"/>
     *         &lt;element name="ParameterTransformation" type="{}lgmReversionTransformation"/>
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
        "volatility",
        "reversion",
        "parameterTransformation"
    })
    public static class RealRate {

        @XmlElement(name = "Volatility", required = true)
        protected VolatilityParameter volatility;
        @XmlElement(name = "Reversion", required = true)
        protected ReversionParameter reversion;
        @XmlElement(name = "ParameterTransformation", required = true)
        protected LgmReversionTransformation parameterTransformation;

        /**
         * volatility 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link VolatilityParameter }
         *     
         */
        public VolatilityParameter getVolatility() {
            return volatility;
        }

        /**
         * volatility 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link VolatilityParameter }
         *     
         */
        public void setVolatility(VolatilityParameter value) {
            this.volatility = value;
        }

        /**
         * reversion 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ReversionParameter }
         *     
         */
        public ReversionParameter getReversion() {
            return reversion;
        }

        /**
         * reversion 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ReversionParameter }
         *     
         */
        public void setReversion(ReversionParameter value) {
            this.reversion = value;
        }

        /**
         * parameterTransformation 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link LgmReversionTransformation }
         *     
         */
        public LgmReversionTransformation getParameterTransformation() {
            return parameterTransformation;
        }

        /**
         * parameterTransformation 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link LgmReversionTransformation }
         *     
         */
        public void setParameterTransformation(LgmReversionTransformation value) {
            this.parameterTransformation = value;
        }

    }

}
