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
 * <p>ascotData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="ascotData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ConvertibleBondData" type="{}convertibleBondData"/>
 *         &lt;element name="OptionData" type="{}optionData"/>
 *         &lt;element name="ReferenceSwapData" type="{}fundingData"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ascotData", propOrder = {

})
public class AscotData {

    @XmlElement(name = "ConvertibleBondData", required = true)
    protected ConvertibleBondData convertibleBondData;
    @XmlElement(name = "OptionData", required = true)
    protected OptionData optionData;
    @XmlElement(name = "ReferenceSwapData", required = true)
    protected FundingData referenceSwapData;

    /**
     * convertibleBondData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ConvertibleBondData }
     *     
     */
    public ConvertibleBondData getConvertibleBondData() {
        return convertibleBondData;
    }

    /**
     * convertibleBondData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ConvertibleBondData }
     *     
     */
    public void setConvertibleBondData(ConvertibleBondData value) {
        this.convertibleBondData = value;
    }

    /**
     * optionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OptionData }
     *     
     */
    public OptionData getOptionData() {
        return optionData;
    }

    /**
     * optionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionData }
     *     
     */
    public void setOptionData(OptionData value) {
        this.optionData = value;
    }

    /**
     * referenceSwapData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FundingData }
     *     
     */
    public FundingData getReferenceSwapData() {
        return referenceSwapData;
    }

    /**
     * referenceSwapData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FundingData }
     *     
     */
    public void setReferenceSwapData(FundingData value) {
        this.referenceSwapData = value;
    }

}
