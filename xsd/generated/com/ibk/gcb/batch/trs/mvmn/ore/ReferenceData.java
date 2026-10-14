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
 *         &lt;element name="ReferenceDatum" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;group ref="{}referenceDataTypes"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="validFrom" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "referenceDatum"
})
@XmlRootElement(name = "ReferenceData")
public class ReferenceData {

    @XmlElement(name = "ReferenceDatum")
    protected List<ReferenceData.ReferenceDatum> referenceDatum;

    /**
     * Gets the value of the referenceDatum property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referenceDatum property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferenceDatum().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceData.ReferenceDatum }
     * 
     * 
     */
    public List<ReferenceData.ReferenceDatum> getReferenceDatum() {
        if (referenceDatum == null) {
            referenceDatum = new ArrayList<ReferenceData.ReferenceDatum>();
        }
        return this.referenceDatum;
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
     *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;group ref="{}referenceDataTypes"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="validFrom" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "type",
        "currencyHedgedEquityIndexReferenceData",
        "equityIndexReferenceData",
        "commodityIndexReferenceData",
        "creditIndexReferenceData",
        "bondReferenceData",
        "cboReferenceData",
        "bondFutureReferenceData",
        "convertibleBondReferenceData",
        "callableBondReferenceData",
        "bondBasketData",
        "creditReferenceData",
        "equityReferenceData",
        "portfolioBasketReferenceData"
    })
    public static class ReferenceDatum {

        @XmlElement(name = "Type", required = true)
        protected String type;
        @XmlElement(name = "CurrencyHedgedEquityIndexReferenceData")
        protected CurrencyHedgedIndexReferenceDatum currencyHedgedEquityIndexReferenceData;
        @XmlElement(name = "EquityIndexReferenceData")
        protected IndexReferenceDatum equityIndexReferenceData;
        @XmlElement(name = "CommodityIndexReferenceData")
        protected IndexReferenceDatum commodityIndexReferenceData;
        @XmlElement(name = "CreditIndexReferenceData")
        protected CreditIndexReferenceDatum creditIndexReferenceData;
        @XmlElement(name = "BondReferenceData")
        protected BondReferenceDatum bondReferenceData;
        @XmlElement(name = "CboReferenceData")
        protected CboReferenceDatum cboReferenceData;
        @XmlElement(name = "BondFutureReferenceData")
        protected BondFutureReferenceDatum bondFutureReferenceData;
        @XmlElement(name = "ConvertibleBondReferenceData")
        protected ConvertibleBondReferenceDatum convertibleBondReferenceData;
        @XmlElement(name = "CallableBondReferenceData")
        protected CallableBondReferenceDatum callableBondReferenceData;
        @XmlElement(name = "BondBasketData")
        protected BondBasketData bondBasketData;
        @XmlElement(name = "CreditReferenceData")
        protected com.ibk.gcb.batch.trs.mvmn.ore.ReferenceDatum creditReferenceData;
        @XmlElement(name = "EquityReferenceData")
        protected EquityReferenceDatum equityReferenceData;
        @XmlElement(name = "PortfolioBasketReferenceData")
        protected PortfolioBasketReferenceDatum portfolioBasketReferenceData;
        @XmlAttribute(name = "id", required = true)
        protected String id;
        @XmlAttribute(name = "validFrom")
        protected String validFrom;

        /**
         * type 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * type 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * currencyHedgedEquityIndexReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link CurrencyHedgedIndexReferenceDatum }
         *     
         */
        public CurrencyHedgedIndexReferenceDatum getCurrencyHedgedEquityIndexReferenceData() {
            return currencyHedgedEquityIndexReferenceData;
        }

        /**
         * currencyHedgedEquityIndexReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link CurrencyHedgedIndexReferenceDatum }
         *     
         */
        public void setCurrencyHedgedEquityIndexReferenceData(CurrencyHedgedIndexReferenceDatum value) {
            this.currencyHedgedEquityIndexReferenceData = value;
        }

        /**
         * equityIndexReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link IndexReferenceDatum }
         *     
         */
        public IndexReferenceDatum getEquityIndexReferenceData() {
            return equityIndexReferenceData;
        }

        /**
         * equityIndexReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link IndexReferenceDatum }
         *     
         */
        public void setEquityIndexReferenceData(IndexReferenceDatum value) {
            this.equityIndexReferenceData = value;
        }

        /**
         * commodityIndexReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link IndexReferenceDatum }
         *     
         */
        public IndexReferenceDatum getCommodityIndexReferenceData() {
            return commodityIndexReferenceData;
        }

        /**
         * commodityIndexReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link IndexReferenceDatum }
         *     
         */
        public void setCommodityIndexReferenceData(IndexReferenceDatum value) {
            this.commodityIndexReferenceData = value;
        }

        /**
         * creditIndexReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link CreditIndexReferenceDatum }
         *     
         */
        public CreditIndexReferenceDatum getCreditIndexReferenceData() {
            return creditIndexReferenceData;
        }

        /**
         * creditIndexReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link CreditIndexReferenceDatum }
         *     
         */
        public void setCreditIndexReferenceData(CreditIndexReferenceDatum value) {
            this.creditIndexReferenceData = value;
        }

        /**
         * bondReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BondReferenceDatum }
         *     
         */
        public BondReferenceDatum getBondReferenceData() {
            return bondReferenceData;
        }

        /**
         * bondReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BondReferenceDatum }
         *     
         */
        public void setBondReferenceData(BondReferenceDatum value) {
            this.bondReferenceData = value;
        }

        /**
         * cboReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link CboReferenceDatum }
         *     
         */
        public CboReferenceDatum getCboReferenceData() {
            return cboReferenceData;
        }

        /**
         * cboReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link CboReferenceDatum }
         *     
         */
        public void setCboReferenceData(CboReferenceDatum value) {
            this.cboReferenceData = value;
        }

        /**
         * bondFutureReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BondFutureReferenceDatum }
         *     
         */
        public BondFutureReferenceDatum getBondFutureReferenceData() {
            return bondFutureReferenceData;
        }

        /**
         * bondFutureReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BondFutureReferenceDatum }
         *     
         */
        public void setBondFutureReferenceData(BondFutureReferenceDatum value) {
            this.bondFutureReferenceData = value;
        }

        /**
         * convertibleBondReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ConvertibleBondReferenceDatum }
         *     
         */
        public ConvertibleBondReferenceDatum getConvertibleBondReferenceData() {
            return convertibleBondReferenceData;
        }

        /**
         * convertibleBondReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ConvertibleBondReferenceDatum }
         *     
         */
        public void setConvertibleBondReferenceData(ConvertibleBondReferenceDatum value) {
            this.convertibleBondReferenceData = value;
        }

        /**
         * callableBondReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link CallableBondReferenceDatum }
         *     
         */
        public CallableBondReferenceDatum getCallableBondReferenceData() {
            return callableBondReferenceData;
        }

        /**
         * callableBondReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link CallableBondReferenceDatum }
         *     
         */
        public void setCallableBondReferenceData(CallableBondReferenceDatum value) {
            this.callableBondReferenceData = value;
        }

        /**
         * bondBasketData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BondBasketData }
         *     
         */
        public BondBasketData getBondBasketData() {
            return bondBasketData;
        }

        /**
         * bondBasketData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BondBasketData }
         *     
         */
        public void setBondBasketData(BondBasketData value) {
            this.bondBasketData = value;
        }

        /**
         * creditReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link com.ibk.gcb.batch.trs.mvmn.ore.ReferenceDatum }
         *     
         */
        public com.ibk.gcb.batch.trs.mvmn.ore.ReferenceDatum getCreditReferenceData() {
            return creditReferenceData;
        }

        /**
         * creditReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link com.ibk.gcb.batch.trs.mvmn.ore.ReferenceDatum }
         *     
         */
        public void setCreditReferenceData(com.ibk.gcb.batch.trs.mvmn.ore.ReferenceDatum value) {
            this.creditReferenceData = value;
        }

        /**
         * equityReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link EquityReferenceDatum }
         *     
         */
        public EquityReferenceDatum getEquityReferenceData() {
            return equityReferenceData;
        }

        /**
         * equityReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link EquityReferenceDatum }
         *     
         */
        public void setEquityReferenceData(EquityReferenceDatum value) {
            this.equityReferenceData = value;
        }

        /**
         * portfolioBasketReferenceData 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link PortfolioBasketReferenceDatum }
         *     
         */
        public PortfolioBasketReferenceDatum getPortfolioBasketReferenceData() {
            return portfolioBasketReferenceData;
        }

        /**
         * portfolioBasketReferenceData 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link PortfolioBasketReferenceDatum }
         *     
         */
        public void setPortfolioBasketReferenceData(PortfolioBasketReferenceDatum value) {
            this.portfolioBasketReferenceData = value;
        }

        /**
         * id 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * id 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * validFrom 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValidFrom() {
            return validFrom;
        }

        /**
         * validFrom 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValidFrom(String value) {
            this.validFrom = value;
        }

    }

}
