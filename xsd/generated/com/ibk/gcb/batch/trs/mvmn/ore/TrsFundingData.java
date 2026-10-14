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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>trsFundingData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="trsFundingData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="FundingResetGracePeriod" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="NotionalType" type="{}trsNotionalType"/>
 *         &lt;element name="LegData" type="{}legData"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trsFundingData", propOrder = {
    "fundingResetGracePeriodOrNotionalTypeOrLegData"
})
public class TrsFundingData {

    @XmlElements({
        @XmlElement(name = "FundingResetGracePeriod", type = BigInteger.class),
        @XmlElement(name = "NotionalType", type = TrsNotionalType.class),
        @XmlElement(name = "LegData", type = LegData.class)
    })
    protected List<Object> fundingResetGracePeriodOrNotionalTypeOrLegData;

    /**
     * Gets the value of the fundingResetGracePeriodOrNotionalTypeOrLegData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fundingResetGracePeriodOrNotionalTypeOrLegData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFundingResetGracePeriodOrNotionalTypeOrLegData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * {@link TrsNotionalType }
     * {@link LegData }
     * 
     * 
     */
    public List<Object> getFundingResetGracePeriodOrNotionalTypeOrLegData() {
        if (fundingResetGracePeriodOrNotionalTypeOrLegData == null) {
            fundingResetGracePeriodOrNotionalTypeOrLegData = new ArrayList<Object>();
        }
        return this.fundingResetGracePeriodOrNotionalTypeOrLegData;
    }

}
