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
 * <p>convertibleBondData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="convertibleBondData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="BondData" type="{}bondData"/>
 *         &lt;element name="CallData" type="{}cbCallData" minOccurs="0"/>
 *         &lt;element name="PutData" type="{}cbCallData" minOccurs="0"/>
 *         &lt;element name="ConversionData" type="{}cbConversionData" minOccurs="0"/>
 *         &lt;element name="DividendProtectionData" type="{}cbDividendProtectionData" minOccurs="0"/>
 *         &lt;element name="Detachable" type="{}bool" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "convertibleBondData", propOrder = {

})
public class ConvertibleBondData {

    @XmlElement(name = "BondData", required = true)
    protected BondData bondData;
    @XmlElement(name = "CallData")
    protected CbCallData callData;
    @XmlElement(name = "PutData")
    protected CbCallData putData;
    @XmlElement(name = "ConversionData")
    protected CbConversionData conversionData;
    @XmlElement(name = "DividendProtectionData")
    protected CbDividendProtectionData dividendProtectionData;
    @XmlElement(name = "Detachable")
    protected String detachable;

    /**
     * bondData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BondData }
     *     
     */
    public BondData getBondData() {
        return bondData;
    }

    /**
     * bondData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BondData }
     *     
     */
    public void setBondData(BondData value) {
        this.bondData = value;
    }

    /**
     * callData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbCallData }
     *     
     */
    public CbCallData getCallData() {
        return callData;
    }

    /**
     * callData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbCallData }
     *     
     */
    public void setCallData(CbCallData value) {
        this.callData = value;
    }

    /**
     * putData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbCallData }
     *     
     */
    public CbCallData getPutData() {
        return putData;
    }

    /**
     * putData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbCallData }
     *     
     */
    public void setPutData(CbCallData value) {
        this.putData = value;
    }

    /**
     * conversionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbConversionData }
     *     
     */
    public CbConversionData getConversionData() {
        return conversionData;
    }

    /**
     * conversionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbConversionData }
     *     
     */
    public void setConversionData(CbConversionData value) {
        this.conversionData = value;
    }

    /**
     * dividendProtectionData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CbDividendProtectionData }
     *     
     */
    public CbDividendProtectionData getDividendProtectionData() {
        return dividendProtectionData;
    }

    /**
     * dividendProtectionData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CbDividendProtectionData }
     *     
     */
    public void setDividendProtectionData(CbDividendProtectionData value) {
        this.dividendProtectionData = value;
    }

    /**
     * detachable 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetachable() {
        return detachable;
    }

    /**
     * detachable 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetachable(String value) {
        this.detachable = value;
    }

}
