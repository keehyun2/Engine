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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>doubleDigitalOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="doubleDigitalOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Expiry" type="{}date"/>
 *         &lt;element name="Settlement" type="{}date"/>
 *         &lt;element name="BinaryPayout" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="BinaryLevel1" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="BinaryLevel2" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="BinaryLevelUpper1" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="BinaryLevelUpper2" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Type1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Position" type="{}longShort"/>
 *         &lt;element name="Underlying1" type="{}underlying" minOccurs="0"/>
 *         &lt;element name="Underlying2" type="{}underlying" minOccurs="0"/>
 *         &lt;element name="Underlying3" type="{}underlying" minOccurs="0"/>
 *         &lt;element name="Underlying4" type="{}underlying" minOccurs="0"/>
 *         &lt;element name="Name1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayCcy" type="{}currencyCode"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doubleDigitalOptionData", propOrder = {

})
public class DoubleDigitalOptionData {

    @XmlElement(name = "Expiry", required = true)
    protected String expiry;
    @XmlElement(name = "Settlement", required = true)
    protected String settlement;
    @XmlElement(name = "BinaryPayout")
    protected float binaryPayout;
    @XmlElement(name = "BinaryLevel1")
    protected float binaryLevel1;
    @XmlElement(name = "BinaryLevel2")
    protected float binaryLevel2;
    @XmlElement(name = "BinaryLevelUpper1")
    protected Float binaryLevelUpper1;
    @XmlElement(name = "BinaryLevelUpper2")
    protected Float binaryLevelUpper2;
    @XmlElement(name = "Type1", required = true)
    protected String type1;
    @XmlElement(name = "Type2", required = true)
    protected String type2;
    @XmlElement(name = "Position", required = true)
    @XmlSchemaType(name = "string")
    protected LongShort position;
    @XmlElement(name = "Underlying1")
    protected Underlying underlying1;
    @XmlElement(name = "Underlying2")
    protected Underlying underlying2;
    @XmlElement(name = "Underlying3")
    protected Underlying underlying3;
    @XmlElement(name = "Underlying4")
    protected Underlying underlying4;
    @XmlElement(name = "Name1")
    protected String name1;
    @XmlElement(name = "Name2")
    protected String name2;
    @XmlElement(name = "PayCcy", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode payCcy;

    /**
     * expiry 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiry() {
        return expiry;
    }

    /**
     * expiry 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiry(String value) {
        this.expiry = value;
    }

    /**
     * settlement 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlement() {
        return settlement;
    }

    /**
     * settlement 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlement(String value) {
        this.settlement = value;
    }

    /**
     * binaryPayout 속성의 값을 가져옵니다.
     * 
     */
    public float getBinaryPayout() {
        return binaryPayout;
    }

    /**
     * binaryPayout 속성의 값을 설정합니다.
     * 
     */
    public void setBinaryPayout(float value) {
        this.binaryPayout = value;
    }

    /**
     * binaryLevel1 속성의 값을 가져옵니다.
     * 
     */
    public float getBinaryLevel1() {
        return binaryLevel1;
    }

    /**
     * binaryLevel1 속성의 값을 설정합니다.
     * 
     */
    public void setBinaryLevel1(float value) {
        this.binaryLevel1 = value;
    }

    /**
     * binaryLevel2 속성의 값을 가져옵니다.
     * 
     */
    public float getBinaryLevel2() {
        return binaryLevel2;
    }

    /**
     * binaryLevel2 속성의 값을 설정합니다.
     * 
     */
    public void setBinaryLevel2(float value) {
        this.binaryLevel2 = value;
    }

    /**
     * binaryLevelUpper1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBinaryLevelUpper1() {
        return binaryLevelUpper1;
    }

    /**
     * binaryLevelUpper1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBinaryLevelUpper1(Float value) {
        this.binaryLevelUpper1 = value;
    }

    /**
     * binaryLevelUpper2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBinaryLevelUpper2() {
        return binaryLevelUpper2;
    }

    /**
     * binaryLevelUpper2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBinaryLevelUpper2(Float value) {
        this.binaryLevelUpper2 = value;
    }

    /**
     * type1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType1() {
        return type1;
    }

    /**
     * type1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType1(String value) {
        this.type1 = value;
    }

    /**
     * type2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType2() {
        return type2;
    }

    /**
     * type2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType2(String value) {
        this.type2 = value;
    }

    /**
     * position 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LongShort }
     *     
     */
    public LongShort getPosition() {
        return position;
    }

    /**
     * position 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LongShort }
     *     
     */
    public void setPosition(LongShort value) {
        this.position = value;
    }

    /**
     * underlying1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getUnderlying1() {
        return underlying1;
    }

    /**
     * underlying1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setUnderlying1(Underlying value) {
        this.underlying1 = value;
    }

    /**
     * underlying2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getUnderlying2() {
        return underlying2;
    }

    /**
     * underlying2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setUnderlying2(Underlying value) {
        this.underlying2 = value;
    }

    /**
     * underlying3 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getUnderlying3() {
        return underlying3;
    }

    /**
     * underlying3 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setUnderlying3(Underlying value) {
        this.underlying3 = value;
    }

    /**
     * underlying4 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Underlying }
     *     
     */
    public Underlying getUnderlying4() {
        return underlying4;
    }

    /**
     * underlying4 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Underlying }
     *     
     */
    public void setUnderlying4(Underlying value) {
        this.underlying4 = value;
    }

    /**
     * name1 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName1() {
        return name1;
    }

    /**
     * name1 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName1(String value) {
        this.name1 = value;
    }

    /**
     * name2 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName2() {
        return name2;
    }

    /**
     * name2 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName2(String value) {
        this.name2 = value;
    }

    /**
     * payCcy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getPayCcy() {
        return payCcy;
    }

    /**
     * payCcy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setPayCcy(CurrencyCode value) {
        this.payCcy = value;
    }

}
