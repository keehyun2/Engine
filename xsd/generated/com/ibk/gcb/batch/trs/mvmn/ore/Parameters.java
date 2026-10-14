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
 * <p>parameters complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="parameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Grid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *         &lt;element name="Sequence" type="{}sequenceType"/>
 *         &lt;element name="Scenario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Discretization" type="{}discretizationType" minOccurs="0"/>
 *         &lt;element name="Seed" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Samples" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="Ordering" type="{}SobolBrownianGeneratorOrdering" minOccurs="0"/>
 *         &lt;element name="DirectionIntegers" type="{}SobolRsgDirectionIntegers" minOccurs="0"/>
 *         &lt;element name="CloseOutLag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MporMode" type="{}mporMode" minOccurs="0"/>
 *         &lt;element name="TimeStepsPerYear" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parameters", propOrder = {

})
public class Parameters {

    @XmlElement(name = "Grid", required = true)
    protected String grid;
    @XmlElement(name = "Calendar", required = true)
    protected String calendar;
    @XmlElement(name = "DayCounter")
    protected String dayCounter;
    @XmlElement(name = "Sequence", required = true)
    @XmlSchemaType(name = "string")
    protected SequenceType sequence;
    @XmlElement(name = "Scenario")
    protected String scenario;
    @XmlElement(name = "Discretization")
    @XmlSchemaType(name = "string")
    protected DiscretizationType discretization;
    @XmlElement(name = "Seed", required = true)
    protected BigInteger seed;
    @XmlElement(name = "Samples", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger samples;
    @XmlElement(name = "Ordering")
    @XmlSchemaType(name = "string")
    protected SobolBrownianGeneratorOrdering ordering;
    @XmlElement(name = "DirectionIntegers")
    @XmlSchemaType(name = "string")
    protected SobolRsgDirectionIntegers directionIntegers;
    @XmlElement(name = "CloseOutLag")
    protected String closeOutLag;
    @XmlElement(name = "MporMode")
    @XmlSchemaType(name = "string")
    protected MporMode mporMode;
    @XmlElement(name = "TimeStepsPerYear")
    protected BigInteger timeStepsPerYear;

    /**
     * grid 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrid() {
        return grid;
    }

    /**
     * grid 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrid(String value) {
        this.grid = value;
    }

    /**
     * calendar 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalendar() {
        return calendar;
    }

    /**
     * calendar 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalendar(String value) {
        this.calendar = value;
    }

    /**
     * dayCounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayCounter() {
        return dayCounter;
    }

    /**
     * dayCounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayCounter(String value) {
        this.dayCounter = value;
    }

    /**
     * sequence 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SequenceType }
     *     
     */
    public SequenceType getSequence() {
        return sequence;
    }

    /**
     * sequence 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceType }
     *     
     */
    public void setSequence(SequenceType value) {
        this.sequence = value;
    }

    /**
     * scenario 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScenario() {
        return scenario;
    }

    /**
     * scenario 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScenario(String value) {
        this.scenario = value;
    }

    /**
     * discretization 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DiscretizationType }
     *     
     */
    public DiscretizationType getDiscretization() {
        return discretization;
    }

    /**
     * discretization 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscretizationType }
     *     
     */
    public void setDiscretization(DiscretizationType value) {
        this.discretization = value;
    }

    /**
     * seed 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSeed() {
        return seed;
    }

    /**
     * seed 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSeed(BigInteger value) {
        this.seed = value;
    }

    /**
     * samples 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSamples() {
        return samples;
    }

    /**
     * samples 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSamples(BigInteger value) {
        this.samples = value;
    }

    /**
     * ordering 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SobolBrownianGeneratorOrdering }
     *     
     */
    public SobolBrownianGeneratorOrdering getOrdering() {
        return ordering;
    }

    /**
     * ordering 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SobolBrownianGeneratorOrdering }
     *     
     */
    public void setOrdering(SobolBrownianGeneratorOrdering value) {
        this.ordering = value;
    }

    /**
     * directionIntegers 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SobolRsgDirectionIntegers }
     *     
     */
    public SobolRsgDirectionIntegers getDirectionIntegers() {
        return directionIntegers;
    }

    /**
     * directionIntegers 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SobolRsgDirectionIntegers }
     *     
     */
    public void setDirectionIntegers(SobolRsgDirectionIntegers value) {
        this.directionIntegers = value;
    }

    /**
     * closeOutLag 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCloseOutLag() {
        return closeOutLag;
    }

    /**
     * closeOutLag 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCloseOutLag(String value) {
        this.closeOutLag = value;
    }

    /**
     * mporMode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MporMode }
     *     
     */
    public MporMode getMporMode() {
        return mporMode;
    }

    /**
     * mporMode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MporMode }
     *     
     */
    public void setMporMode(MporMode value) {
        this.mporMode = value;
    }

    /**
     * timeStepsPerYear 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimeStepsPerYear() {
        return timeStepsPerYear;
    }

    /**
     * timeStepsPerYear 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimeStepsPerYear(BigInteger value) {
        this.timeStepsPerYear = value;
    }

}
