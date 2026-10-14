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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *       &lt;sequence>
 *         &lt;element name="Configuration" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mporDays" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ObservationThresholds">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ObservationCount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="AmberLimit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="RedLimit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
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
@XmlType(name = "", propOrder = {
    "configuration"
})
@XmlRootElement(name = "BaselTrafficLightConfig")
public class BaselTrafficLightConfig {

    @XmlElement(name = "Configuration", required = true)
    protected List<BaselTrafficLightConfig.Configuration> configuration;

    /**
     * Gets the value of the configuration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the configuration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfiguration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BaselTrafficLightConfig.Configuration }
     * 
     * 
     */
    public List<BaselTrafficLightConfig.Configuration> getConfiguration() {
        if (configuration == null) {
            configuration = new ArrayList<BaselTrafficLightConfig.Configuration>();
        }
        return this.configuration;
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
     *         &lt;element name="mporDays" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ObservationThresholds">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ObservationCount" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="AmberLimit" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="RedLimit" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
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
    @XmlType(name = "", propOrder = {
        "mporDays",
        "observationThresholds"
    })
    public static class Configuration {

        @XmlElement(required = true)
        protected String mporDays;
        @XmlElement(name = "ObservationThresholds", required = true)
        protected BaselTrafficLightConfig.Configuration.ObservationThresholds observationThresholds;

        /**
         * mporDays 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMporDays() {
            return mporDays;
        }

        /**
         * mporDays 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMporDays(String value) {
            this.mporDays = value;
        }

        /**
         * observationThresholds 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BaselTrafficLightConfig.Configuration.ObservationThresholds }
         *     
         */
        public BaselTrafficLightConfig.Configuration.ObservationThresholds getObservationThresholds() {
            return observationThresholds;
        }

        /**
         * observationThresholds 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BaselTrafficLightConfig.Configuration.ObservationThresholds }
         *     
         */
        public void setObservationThresholds(BaselTrafficLightConfig.Configuration.ObservationThresholds value) {
            this.observationThresholds = value;
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
         *         &lt;element name="ObservationCount" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="AmberLimit" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="RedLimit" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "observationCount",
            "amberLimit",
            "redLimit"
        })
        public static class ObservationThresholds {

            @XmlElement(name = "ObservationCount", required = true)
            protected String observationCount;
            @XmlElement(name = "AmberLimit", required = true)
            protected String amberLimit;
            @XmlElement(name = "RedLimit", required = true)
            protected String redLimit;

            /**
             * observationCount 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getObservationCount() {
                return observationCount;
            }

            /**
             * observationCount 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setObservationCount(String value) {
                this.observationCount = value;
            }

            /**
             * amberLimit 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAmberLimit() {
                return amberLimit;
            }

            /**
             * amberLimit 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAmberLimit(String value) {
                this.amberLimit = value;
            }

            /**
             * redLimit 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRedLimit() {
                return redLimit;
            }

            /**
             * redLimit 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRedLimit(String value) {
                this.redLimit = value;
            }

        }

    }

}
