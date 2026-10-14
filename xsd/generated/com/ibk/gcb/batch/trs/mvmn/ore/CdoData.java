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
 * <p>cdoData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="cdoData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Qualifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProtectionStart" type="{}date"/>
 *         &lt;element name="UpfrontDate" type="{}date" minOccurs="0"/>
 *         &lt;element name="UpfrontFee" type="{}emptyFloat" minOccurs="0"/>
 *         &lt;element name="SettlesAccrual" type="{}bool" minOccurs="0"/>
 *         &lt;element name="RebatesAccrual" type="{}bool" minOccurs="0"/>
 *         &lt;element name="PaysAtDefaultTime" type="{}bool" minOccurs="0"/>
 *         &lt;element name="ProtectionPaymentTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FixedRecoveryRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="AttachmentPoint" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="DetachmentPoint" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="LegData" type="{}legData"/>
 *         &lt;element name="BasketData" type="{}basketData" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cdoData", propOrder = {

})
public class CdoData {

    @XmlElement(name = "Qualifier", required = true)
    protected String qualifier;
    @XmlElement(name = "ProtectionStart", required = true)
    protected String protectionStart;
    @XmlElement(name = "UpfrontDate")
    protected String upfrontDate;
    @XmlElement(name = "UpfrontFee")
    protected String upfrontFee;
    @XmlElement(name = "SettlesAccrual")
    protected String settlesAccrual;
    @XmlElement(name = "RebatesAccrual")
    protected String rebatesAccrual;
    @XmlElement(name = "PaysAtDefaultTime")
    protected String paysAtDefaultTime;
    @XmlElement(name = "ProtectionPaymentTime")
    protected String protectionPaymentTime;
    @XmlElement(name = "FixedRecoveryRate")
    protected Float fixedRecoveryRate;
    @XmlElement(name = "AttachmentPoint")
    protected float attachmentPoint;
    @XmlElement(name = "DetachmentPoint")
    protected float detachmentPoint;
    @XmlElement(name = "LegData", required = true)
    protected LegData legData;
    @XmlElement(name = "BasketData")
    protected BasketData basketData;

    /**
     * qualifier 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualifier() {
        return qualifier;
    }

    /**
     * qualifier 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualifier(String value) {
        this.qualifier = value;
    }

    /**
     * protectionStart 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtectionStart() {
        return protectionStart;
    }

    /**
     * protectionStart 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtectionStart(String value) {
        this.protectionStart = value;
    }

    /**
     * upfrontDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpfrontDate() {
        return upfrontDate;
    }

    /**
     * upfrontDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpfrontDate(String value) {
        this.upfrontDate = value;
    }

    /**
     * upfrontFee 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpfrontFee() {
        return upfrontFee;
    }

    /**
     * upfrontFee 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpfrontFee(String value) {
        this.upfrontFee = value;
    }

    /**
     * settlesAccrual 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlesAccrual() {
        return settlesAccrual;
    }

    /**
     * settlesAccrual 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlesAccrual(String value) {
        this.settlesAccrual = value;
    }

    /**
     * rebatesAccrual 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRebatesAccrual() {
        return rebatesAccrual;
    }

    /**
     * rebatesAccrual 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRebatesAccrual(String value) {
        this.rebatesAccrual = value;
    }

    /**
     * paysAtDefaultTime 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaysAtDefaultTime() {
        return paysAtDefaultTime;
    }

    /**
     * paysAtDefaultTime 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaysAtDefaultTime(String value) {
        this.paysAtDefaultTime = value;
    }

    /**
     * protectionPaymentTime 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtectionPaymentTime() {
        return protectionPaymentTime;
    }

    /**
     * protectionPaymentTime 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtectionPaymentTime(String value) {
        this.protectionPaymentTime = value;
    }

    /**
     * fixedRecoveryRate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFixedRecoveryRate() {
        return fixedRecoveryRate;
    }

    /**
     * fixedRecoveryRate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFixedRecoveryRate(Float value) {
        this.fixedRecoveryRate = value;
    }

    /**
     * attachmentPoint 속성의 값을 가져옵니다.
     * 
     */
    public float getAttachmentPoint() {
        return attachmentPoint;
    }

    /**
     * attachmentPoint 속성의 값을 설정합니다.
     * 
     */
    public void setAttachmentPoint(float value) {
        this.attachmentPoint = value;
    }

    /**
     * detachmentPoint 속성의 값을 가져옵니다.
     * 
     */
    public float getDetachmentPoint() {
        return detachmentPoint;
    }

    /**
     * detachmentPoint 속성의 값을 설정합니다.
     * 
     */
    public void setDetachmentPoint(float value) {
        this.detachmentPoint = value;
    }

    /**
     * legData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LegData }
     *     
     */
    public LegData getLegData() {
        return legData;
    }

    /**
     * legData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LegData }
     *     
     */
    public void setLegData(LegData value) {
        this.legData = value;
    }

    /**
     * basketData 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BasketData }
     *     
     */
    public BasketData getBasketData() {
        return basketData;
    }

    /**
     * basketData 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketData }
     *     
     */
    public void setBasketData(BasketData value) {
        this.basketData = value;
    }

}
