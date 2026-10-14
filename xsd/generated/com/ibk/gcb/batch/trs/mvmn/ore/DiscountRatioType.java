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
 * <p>discountRatioType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="discountRatioType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Type" type="{}discountRatioTypeType"/>
 *         &lt;element name="PillarChoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="MinDistance" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BaseCurve" type="{}discountRatioCurveElement"/>
 *         &lt;element name="NumeratorCurve" type="{}discountRatioCurveElement"/>
 *         &lt;element name="DenominatorCurve" type="{}discountRatioCurveElement"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "discountRatioType", propOrder = {

})
public class DiscountRatioType {

    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected DiscountRatioTypeType type;
    @XmlElement(name = "PillarChoice")
    protected String pillarChoice;
    @XmlElement(name = "Priority")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger priority;
    @XmlElement(name = "MinDistance")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger minDistance;
    @XmlElement(name = "Conventions")
    protected String conventions;
    @XmlElement(name = "BaseCurve", required = true)
    protected DiscountRatioCurveElement baseCurve;
    @XmlElement(name = "NumeratorCurve", required = true)
    protected DiscountRatioCurveElement numeratorCurve;
    @XmlElement(name = "DenominatorCurve", required = true)
    protected DiscountRatioCurveElement denominatorCurve;

    /**
     * type 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DiscountRatioTypeType }
     *     
     */
    public DiscountRatioTypeType getType() {
        return type;
    }

    /**
     * type 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscountRatioTypeType }
     *     
     */
    public void setType(DiscountRatioTypeType value) {
        this.type = value;
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
     * baseCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DiscountRatioCurveElement }
     *     
     */
    public DiscountRatioCurveElement getBaseCurve() {
        return baseCurve;
    }

    /**
     * baseCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscountRatioCurveElement }
     *     
     */
    public void setBaseCurve(DiscountRatioCurveElement value) {
        this.baseCurve = value;
    }

    /**
     * numeratorCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DiscountRatioCurveElement }
     *     
     */
    public DiscountRatioCurveElement getNumeratorCurve() {
        return numeratorCurve;
    }

    /**
     * numeratorCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscountRatioCurveElement }
     *     
     */
    public void setNumeratorCurve(DiscountRatioCurveElement value) {
        this.numeratorCurve = value;
    }

    /**
     * denominatorCurve 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DiscountRatioCurveElement }
     *     
     */
    public DiscountRatioCurveElement getDenominatorCurve() {
        return denominatorCurve;
    }

    /**
     * denominatorCurve 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscountRatioCurveElement }
     *     
     */
    public void setDenominatorCurve(DiscountRatioCurveElement value) {
        this.denominatorCurve = value;
    }

}
