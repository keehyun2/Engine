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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>risk complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="risk">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Market" type="{}bool"/>
 *         &lt;element name="Credit" type="{}bool"/>
 *         &lt;element name="ZeroMarketPnl" type="{}bool"/>
 *         &lt;element name="Evaluation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DoubleDefault" type="{}bool"/>
 *         &lt;element name="Seed" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Paths" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="CreditMode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LoanExposureMode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "risk", propOrder = {

})
public class Risk {

    @XmlElement(name = "Market", required = true)
    protected String market;
    @XmlElement(name = "Credit", required = true)
    protected String credit;
    @XmlElement(name = "ZeroMarketPnl", required = true)
    protected String zeroMarketPnl;
    @XmlElement(name = "Evaluation", required = true)
    protected String evaluation;
    @XmlElement(name = "DoubleDefault", required = true)
    protected String doubleDefault;
    @XmlElement(name = "Seed", required = true)
    protected BigInteger seed;
    @XmlElement(name = "Paths", required = true)
    protected BigInteger paths;
    @XmlElement(name = "CreditMode", required = true)
    protected String creditMode;
    @XmlElement(name = "LoanExposureMode", required = true)
    protected String loanExposureMode;

    /**
     * market 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarket() {
        return market;
    }

    /**
     * market 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarket(String value) {
        this.market = value;
    }

    /**
     * credit 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCredit() {
        return credit;
    }

    /**
     * credit 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCredit(String value) {
        this.credit = value;
    }

    /**
     * zeroMarketPnl 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZeroMarketPnl() {
        return zeroMarketPnl;
    }

    /**
     * zeroMarketPnl 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZeroMarketPnl(String value) {
        this.zeroMarketPnl = value;
    }

    /**
     * evaluation 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvaluation() {
        return evaluation;
    }

    /**
     * evaluation 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvaluation(String value) {
        this.evaluation = value;
    }

    /**
     * doubleDefault 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoubleDefault() {
        return doubleDefault;
    }

    /**
     * doubleDefault 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoubleDefault(String value) {
        this.doubleDefault = value;
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
     * paths 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPaths() {
        return paths;
    }

    /**
     * paths 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPaths(BigInteger value) {
        this.paths = value;
    }

    /**
     * creditMode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditMode() {
        return creditMode;
    }

    /**
     * creditMode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditMode(String value) {
        this.creditMode = value;
    }

    /**
     * loanExposureMode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanExposureMode() {
        return loanExposureMode;
    }

    /**
     * loanExposureMode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanExposureMode(String value) {
        this.loanExposureMode = value;
    }

}
