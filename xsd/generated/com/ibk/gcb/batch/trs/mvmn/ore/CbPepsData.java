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
 * <p>cbPepsData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="cbPepsData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="UpperBarrier" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="LowerBarrier" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="UpperConversionRatio" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="LowerConversionRatio" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cbPepsData", propOrder = {

})
public class CbPepsData {

    @XmlElement(name = "UpperBarrier")
    protected float upperBarrier;
    @XmlElement(name = "LowerBarrier")
    protected float lowerBarrier;
    @XmlElement(name = "UpperConversionRatio")
    protected float upperConversionRatio;
    @XmlElement(name = "LowerConversionRatio")
    protected float lowerConversionRatio;

    /**
     * upperBarrier 속성의 값을 가져옵니다.
     * 
     */
    public float getUpperBarrier() {
        return upperBarrier;
    }

    /**
     * upperBarrier 속성의 값을 설정합니다.
     * 
     */
    public void setUpperBarrier(float value) {
        this.upperBarrier = value;
    }

    /**
     * lowerBarrier 속성의 값을 가져옵니다.
     * 
     */
    public float getLowerBarrier() {
        return lowerBarrier;
    }

    /**
     * lowerBarrier 속성의 값을 설정합니다.
     * 
     */
    public void setLowerBarrier(float value) {
        this.lowerBarrier = value;
    }

    /**
     * upperConversionRatio 속성의 값을 가져옵니다.
     * 
     */
    public float getUpperConversionRatio() {
        return upperConversionRatio;
    }

    /**
     * upperConversionRatio 속성의 값을 설정합니다.
     * 
     */
    public void setUpperConversionRatio(float value) {
        this.upperConversionRatio = value;
    }

    /**
     * lowerConversionRatio 속성의 값을 가져옵니다.
     * 
     */
    public float getLowerConversionRatio() {
        return lowerConversionRatio;
    }

    /**
     * lowerConversionRatio 속성의 값을 설정합니다.
     * 
     */
    public void setLowerConversionRatio(float value) {
        this.lowerConversionRatio = value;
    }

}
