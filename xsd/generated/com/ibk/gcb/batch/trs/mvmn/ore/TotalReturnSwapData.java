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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>totalReturnSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="totalReturnSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="UnderlyingData" type="{}trsUnderlyingData"/>
 *         &lt;element name="ReturnData" type="{}trsReturnData"/>
 *         &lt;element name="FundingData" type="{}trsFundingData" minOccurs="0"/>
 *         &lt;element name="AdditionalCashflowData" type="{}trsAdditionalCashflowData" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "totalReturnSwapData", propOrder = {

})
public class TotalReturnSwapData {

    @XmlElement(name = "UnderlyingData", required = true)
    protected TrsUnderlyingData underlyingData;
    @XmlElement(name = "ReturnData", required = true)
    protected TrsReturnData returnData;
    @XmlElement(name = "FundingData")
    protected TrsFundingData fundingData;
    @XmlElement(name = "AdditionalCashflowData")
    protected TrsAdditionalCashflowData additionalCashflowData;

    /**
     * underlyingData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TrsUnderlyingData }
     *     
     */
    public TrsUnderlyingData getUnderlyingData() {
        return underlyingData;
    }

    /**
     * underlyingData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TrsUnderlyingData }
     *     
     */
    public void setUnderlyingData(TrsUnderlyingData value) {
        this.underlyingData = value;
    }

    /**
     * returnData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TrsReturnData }
     *     
     */
    public TrsReturnData getReturnData() {
        return returnData;
    }

    /**
     * returnData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TrsReturnData }
     *     
     */
    public void setReturnData(TrsReturnData value) {
        this.returnData = value;
    }

    /**
     * fundingData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TrsFundingData }
     *     
     */
    public TrsFundingData getFundingData() {
        return fundingData;
    }

    /**
     * fundingData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TrsFundingData }
     *     
     */
    public void setFundingData(TrsFundingData value) {
        this.fundingData = value;
    }

    /**
     * additionalCashflowData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TrsAdditionalCashflowData }
     *     
     */
    public TrsAdditionalCashflowData getAdditionalCashflowData() {
        return additionalCashflowData;
    }

    /**
     * additionalCashflowData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TrsAdditionalCashflowData }
     *     
     */
    public void setAdditionalCashflowData(TrsAdditionalCashflowData value) {
        this.additionalCashflowData = value;
    }

}
