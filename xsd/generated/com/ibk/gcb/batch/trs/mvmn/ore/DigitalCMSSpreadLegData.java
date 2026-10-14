//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="CMSSpreadLegData">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Index1" type="{}indexNameType"/>
 *                   &lt;element name="Index2" type="{}indexNameType"/>
 *                   &lt;element name="IsInArrears" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="FixingDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="Spreads" type="{}spreads" minOccurs="0"/>
 *                   &lt;element name="Caps" type="{}caps" minOccurs="0"/>
 *                   &lt;element name="Floors" type="{}floors" minOccurs="0"/>
 *                   &lt;element name="Gearings" type="{}gearings" minOccurs="0"/>
 *                   &lt;element name="NakedOption" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CallPosition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IsCallATMIncluded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CallStrikes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CallPayoffs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Payoff" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PutPosition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IsPutATMIncluded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PutStrikes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PutPayoffs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Payoff" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cmsSpreadLegDataOrCallPositionOrIsCallATMIncluded"
})
public class DigitalCMSSpreadLegData {

    @XmlElementRefs({
        @XmlElementRef(name = "CallPayoffs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PutPayoffs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IsCallATMIncluded", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CallStrikes", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IsPutATMIncluded", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CMSSpreadLegData", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PutStrikes", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CallPosition", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PutPosition", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> cmsSpreadLegDataOrCallPositionOrIsCallATMIncluded;

    /**
     * Gets the value of the cmsSpreadLegDataOrCallPositionOrIsCallATMIncluded property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cmsSpreadLegDataOrCallPositionOrIsCallATMIncluded property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCMSSpreadLegDataOrCallPositionOrIsCallATMIncluded().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData.CallPayoffs }{@code >}
     * {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData.PutPayoffs }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData.CallStrikes }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData.CMSSpreadLegData }{@code >}
     * {@link JAXBElement }{@code <}{@link DigitalCMSSpreadLegData.PutStrikes }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getCMSSpreadLegDataOrCallPositionOrIsCallATMIncluded() {
        if (cmsSpreadLegDataOrCallPositionOrIsCallATMIncluded == null) {
            cmsSpreadLegDataOrCallPositionOrIsCallATMIncluded = new ArrayList<JAXBElement<?>>();
        }
        return this.cmsSpreadLegDataOrCallPositionOrIsCallATMIncluded;
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
     *         &lt;element name="Index1" type="{}indexNameType"/>
     *         &lt;element name="Index2" type="{}indexNameType"/>
     *         &lt;element name="IsInArrears" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="FixingDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="Spreads" type="{}spreads" minOccurs="0"/>
     *         &lt;element name="Caps" type="{}caps" minOccurs="0"/>
     *         &lt;element name="Floors" type="{}floors" minOccurs="0"/>
     *         &lt;element name="Gearings" type="{}gearings" minOccurs="0"/>
     *         &lt;element name="NakedOption" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    public static class CMSSpreadLegData {

        @XmlElement(name = "Index1", required = true)
        protected String index1;
        @XmlElement(name = "Index2", required = true)
        protected String index2;
        @XmlElement(name = "IsInArrears")
        protected Boolean isInArrears;
        @XmlElement(name = "FixingDays")
        protected BigInteger fixingDays;
        @XmlElement(name = "Spreads")
        protected Spreads spreads;
        @XmlElement(name = "Caps")
        protected Caps caps;
        @XmlElement(name = "Floors")
        protected Floors floors;
        @XmlElement(name = "Gearings")
        protected Gearings gearings;
        @XmlElement(name = "NakedOption")
        protected Boolean nakedOption;

        /**
         * index1 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndex1() {
            return index1;
        }

        /**
         * index1 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndex1(String value) {
            this.index1 = value;
        }

        /**
         * index2 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndex2() {
            return index2;
        }

        /**
         * index2 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndex2(String value) {
            this.index2 = value;
        }

        /**
         * isInArrears 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsInArrears() {
            return isInArrears;
        }

        /**
         * isInArrears 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsInArrears(Boolean value) {
            this.isInArrears = value;
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
         * spreads 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Spreads }
         *     
         */
        public Spreads getSpreads() {
            return spreads;
        }

        /**
         * spreads 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Spreads }
         *     
         */
        public void setSpreads(Spreads value) {
            this.spreads = value;
        }

        /**
         * caps 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Caps }
         *     
         */
        public Caps getCaps() {
            return caps;
        }

        /**
         * caps 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Caps }
         *     
         */
        public void setCaps(Caps value) {
            this.caps = value;
        }

        /**
         * floors 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Floors }
         *     
         */
        public Floors getFloors() {
            return floors;
        }

        /**
         * floors 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Floors }
         *     
         */
        public void setFloors(Floors value) {
            this.floors = value;
        }

        /**
         * gearings 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Gearings }
         *     
         */
        public Gearings getGearings() {
            return gearings;
        }

        /**
         * gearings 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Gearings }
         *     
         */
        public void setGearings(Gearings value) {
            this.gearings = value;
        }

        /**
         * nakedOption 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNakedOption() {
            return nakedOption;
        }

        /**
         * nakedOption 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNakedOption(Boolean value) {
            this.nakedOption = value;
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
     *         &lt;element name="Payoff" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
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
        "payoff"
    })
    public static class CallPayoffs {

        @XmlElement(name = "Payoff", type = Float.class)
        protected List<Float> payoff;

        /**
         * Gets the value of the payoff property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the payoff property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPayoff().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Float }
         * 
         * 
         */
        public List<Float> getPayoff() {
            if (payoff == null) {
                payoff = new ArrayList<Float>();
            }
            return this.payoff;
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
     *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
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
        "strike"
    })
    public static class CallStrikes {

        @XmlElement(name = "Strike", type = Float.class)
        protected List<Float> strike;

        /**
         * Gets the value of the strike property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the strike property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStrike().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Float }
         * 
         * 
         */
        public List<Float> getStrike() {
            if (strike == null) {
                strike = new ArrayList<Float>();
            }
            return this.strike;
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
     *         &lt;element name="Payoff" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
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
        "payoff"
    })
    public static class PutPayoffs {

        @XmlElement(name = "Payoff", type = Float.class)
        protected List<Float> payoff;

        /**
         * Gets the value of the payoff property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the payoff property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPayoff().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Float }
         * 
         * 
         */
        public List<Float> getPayoff() {
            if (payoff == null) {
                payoff = new ArrayList<Float>();
            }
            return this.payoff;
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
     *         &lt;element name="Strike" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded"/>
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
        "strike"
    })
    public static class PutStrikes {

        @XmlElement(name = "Strike", type = Float.class)
        protected List<Float> strike;

        /**
         * Gets the value of the strike property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the strike property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStrike().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Float }
         * 
         * 
         */
        public List<Float> getStrike() {
            if (strike == null) {
                strike = new ArrayList<Float>();
            }
            return this.strike;
        }

    }

}
