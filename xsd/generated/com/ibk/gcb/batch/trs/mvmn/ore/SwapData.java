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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>swapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="swapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoundNettedFloatingLegs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NettingPrecision" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="Settlement" type="{}settlementType" minOccurs="0"/>
 *         &lt;element name="LegData" type="{}legData" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "swapData", propOrder = {
    "roundNettedFloatingLegs",
    "nettingPrecision",
    "settlement",
    "legData"
})
public class SwapData {

    @XmlElement(name = "RoundNettedFloatingLegs")
    protected Boolean roundNettedFloatingLegs;
    @XmlElement(name = "NettingPrecision")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger nettingPrecision;
    @XmlElement(name = "Settlement")
    @XmlSchemaType(name = "string")
    protected SettlementType settlement;
    @XmlElement(name = "LegData", required = true)
    protected List<LegData> legData;

    /**
     * roundNettedFloatingLegs 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRoundNettedFloatingLegs() {
        return roundNettedFloatingLegs;
    }

    /**
     * roundNettedFloatingLegs 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRoundNettedFloatingLegs(Boolean value) {
        this.roundNettedFloatingLegs = value;
    }

    /**
     * nettingPrecision 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNettingPrecision() {
        return nettingPrecision;
    }

    /**
     * nettingPrecision 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNettingPrecision(BigInteger value) {
        this.nettingPrecision = value;
    }

    /**
     * settlement 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SettlementType }
     *     
     */
    public SettlementType getSettlement() {
        return settlement;
    }

    /**
     * settlement 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementType }
     *     
     */
    public void setSettlement(SettlementType value) {
        this.settlement = value;
    }

    /**
     * Gets the value of the legData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LegData }
     * 
     * 
     */
    public List<LegData> getLegData() {
        if (legData == null) {
            legData = new ArrayList<LegData>();
        }
        return this.legData;
    }

}
