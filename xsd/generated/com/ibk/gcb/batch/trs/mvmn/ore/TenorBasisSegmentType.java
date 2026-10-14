//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>tenorBasisSegmentType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="tenorBasisSegmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Type" type="{}tenorBasisSegmentTypeType"/>
 *         &lt;element name="Quotes" type="{}quoteType"/>
 *         &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PillarChoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="MinDistance" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="ProjectionCurvePay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProjectionCurveReceive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProjectionCurveLong" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProjectionCurveShort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tenorBasisSegmentType", propOrder = {

})
public class TenorBasisSegmentType {

    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected TenorBasisSegmentTypeType type;
    @XmlElement(name = "Quotes", required = true)
    protected QuoteType quotes;
    @XmlElement(name = "Conventions", required = true)
    protected String conventions;
    @XmlElement(name = "PillarChoice")
    protected String pillarChoice;
    @XmlElement(name = "Priority")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger priority;
    @XmlElement(name = "MinDistance")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger minDistance;
    @XmlElement(name = "ProjectionCurvePay")
    protected String projectionCurvePay;
    @XmlElement(name = "ProjectionCurveReceive")
    protected String projectionCurveReceive;
    @XmlElement(name = "ProjectionCurveLong")
    protected String projectionCurveLong;
    @XmlElement(name = "ProjectionCurveShort")
    protected String projectionCurveShort;

    /**
     * type 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TenorBasisSegmentTypeType }
     *     
     */
    public TenorBasisSegmentTypeType getType() {
        return type;
    }

    /**
     * type 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TenorBasisSegmentTypeType }
     *     
     */
    public void setType(TenorBasisSegmentTypeType value) {
        this.type = value;
    }

    /**
     * quotes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link QuoteType }
     *     
     */
    public QuoteType getQuotes() {
        return quotes;
    }

    /**
     * quotes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link QuoteType }
     *     
     */
    public void setQuotes(QuoteType value) {
        this.quotes = value;
    }

    /**
     * conventions 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConventions() {
        return conventions;
    }

    /**
     * conventions 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConventions(String value) {
        this.conventions = value;
    }

    /**
     * pillarChoice 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPillarChoice() {
        return pillarChoice;
    }

    /**
     * pillarChoice 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPillarChoice(String value) {
        this.pillarChoice = value;
    }

    /**
     * priority 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPriority() {
        return priority;
    }

    /**
     * priority 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPriority(BigInteger value) {
        this.priority = value;
    }

    /**
     * minDistance 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinDistance() {
        return minDistance;
    }

    /**
     * minDistance 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinDistance(BigInteger value) {
        this.minDistance = value;
    }

    /**
     * projectionCurvePay 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectionCurvePay() {
        return projectionCurvePay;
    }

    /**
     * projectionCurvePay 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectionCurvePay(String value) {
        this.projectionCurvePay = value;
    }

    /**
     * projectionCurveReceive 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectionCurveReceive() {
        return projectionCurveReceive;
    }

    /**
     * projectionCurveReceive 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectionCurveReceive(String value) {
        this.projectionCurveReceive = value;
    }

    /**
     * projectionCurveLong 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectionCurveLong() {
        return projectionCurveLong;
    }

    /**
     * projectionCurveLong 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectionCurveLong(String value) {
        this.projectionCurveLong = value;
    }

    /**
     * projectionCurveShort 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectionCurveShort() {
        return projectionCurveShort;
    }

    /**
     * projectionCurveShort 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectionCurveShort(String value) {
        this.projectionCurveShort = value;
    }

}
