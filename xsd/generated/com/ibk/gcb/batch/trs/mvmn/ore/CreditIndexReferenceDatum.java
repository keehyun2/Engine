//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>creditIndexReferenceDatum complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="creditIndexReferenceDatum">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IndexFamily" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="IndexSubFamily" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="Underlying" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Weight" type="{}weightType"/>
 *                   &lt;element name="PriorWeight" type="{}weightType" minOccurs="0"/>
 *                   &lt;element name="RecoveryRate" type="{}recoveryRate" minOccurs="0"/>
 *                   &lt;element name="AuctionDate" type="{}date" minOccurs="0"/>
 *                   &lt;element name="AuctionSettlementDate" type="{}date" minOccurs="0"/>
 *                   &lt;element name="DefaultDate" type="{}date" minOccurs="0"/>
 *                   &lt;element name="EventDeterminationDate" type="{}date" minOccurs="0"/>
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
@XmlType(name = "creditIndexReferenceDatum", propOrder = {
    "indexFamily",
    "indexSubFamily",
    "underlying"
})
public class CreditIndexReferenceDatum {

    @XmlElement(name = "IndexFamily")
    protected Object indexFamily;
    @XmlElement(name = "IndexSubFamily")
    protected Object indexSubFamily;
    @XmlElement(name = "Underlying")
    protected List<CreditIndexReferenceDatum.Underlying> underlying;

    /**
     * indexFamily 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getIndexFamily() {
        return indexFamily;
    }

    /**
     * indexFamily 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setIndexFamily(Object value) {
        this.indexFamily = value;
    }

    /**
     * indexSubFamily 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getIndexSubFamily() {
        return indexSubFamily;
    }

    /**
     * indexSubFamily 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setIndexSubFamily(Object value) {
        this.indexSubFamily = value;
    }

    /**
     * Gets the value of the underlying property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the underlying property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnderlying().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditIndexReferenceDatum.Underlying }
     * 
     * 
     */
    public List<CreditIndexReferenceDatum.Underlying> getUnderlying() {
        if (underlying == null) {
            underlying = new ArrayList<CreditIndexReferenceDatum.Underlying>();
        }
        return this.underlying;
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
     *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Weight" type="{}weightType"/>
     *         &lt;element name="PriorWeight" type="{}weightType" minOccurs="0"/>
     *         &lt;element name="RecoveryRate" type="{}recoveryRate" minOccurs="0"/>
     *         &lt;element name="AuctionDate" type="{}date" minOccurs="0"/>
     *         &lt;element name="AuctionSettlementDate" type="{}date" minOccurs="0"/>
     *         &lt;element name="DefaultDate" type="{}date" minOccurs="0"/>
     *         &lt;element name="EventDeterminationDate" type="{}date" minOccurs="0"/>
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
    public static class Underlying {

        @XmlElement(name = "Name", required = true)
        protected String name;
        @XmlElement(name = "Weight", required = true)
        protected BigDecimal weight;
        @XmlElement(name = "PriorWeight")
        protected BigDecimal priorWeight;
        @XmlElement(name = "RecoveryRate")
        protected BigDecimal recoveryRate;
        @XmlElement(name = "AuctionDate")
        protected String auctionDate;
        @XmlElement(name = "AuctionSettlementDate")
        protected String auctionSettlementDate;
        @XmlElement(name = "DefaultDate")
        protected String defaultDate;
        @XmlElement(name = "EventDeterminationDate")
        protected String eventDeterminationDate;

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
         * weight 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getWeight() {
            return weight;
        }

        /**
         * weight 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setWeight(BigDecimal value) {
            this.weight = value;
        }

        /**
         * priorWeight 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPriorWeight() {
            return priorWeight;
        }

        /**
         * priorWeight 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPriorWeight(BigDecimal value) {
            this.priorWeight = value;
        }

        /**
         * recoveryRate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getRecoveryRate() {
            return recoveryRate;
        }

        /**
         * recoveryRate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setRecoveryRate(BigDecimal value) {
            this.recoveryRate = value;
        }

        /**
         * auctionDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAuctionDate() {
            return auctionDate;
        }

        /**
         * auctionDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAuctionDate(String value) {
            this.auctionDate = value;
        }

        /**
         * auctionSettlementDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAuctionSettlementDate() {
            return auctionSettlementDate;
        }

        /**
         * auctionSettlementDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAuctionSettlementDate(String value) {
            this.auctionSettlementDate = value;
        }

        /**
         * defaultDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDefaultDate() {
            return defaultDate;
        }

        /**
         * defaultDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDefaultDate(String value) {
            this.defaultDate = value;
        }

        /**
         * eventDeterminationDate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEventDeterminationDate() {
            return eventDeterminationDate;
        }

        /**
         * eventDeterminationDate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEventDeterminationDate(String value) {
            this.eventDeterminationDate = value;
        }

    }

}
