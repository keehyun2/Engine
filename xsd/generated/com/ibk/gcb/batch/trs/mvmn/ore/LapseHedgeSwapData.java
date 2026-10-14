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
 * <p>lapseHedgeSwapData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="lapseHedgeSwapData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Payer" type="{}stFreeStyleBool"/>
 *         &lt;element name="Notional" type="{}stFreeStyleNumber"/>
 *         &lt;element name="LapseHedgePercentage" type="{}stFreeStyleNumber"/>
 *         &lt;element name="deltaN" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="SettlementCurrency" type="{}stFreeStyleCurrency"/>
 *         &lt;element name="Paydaycounter" type="{}stFreeStyleDayCounter"/>
 *         &lt;element name="IRS" type="{}stFreeStyleNumber"/>
 *         &lt;element name="IRSSpread" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Tau" type="{}stFreeStyleNumber"/>
 *         &lt;element name="Fee" type="{}stFreeStyleNumber"/>
 *         &lt;element name="IMS" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="PHFV" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="Penalty" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="ExitPrice" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="ExitFee" type="{}stFreeStyleNumberVector"/>
 *         &lt;element name="InitialExchangeFee" type="{}stFreeStyleNumber"/>
 *         &lt;element name="InitialExchangeDate" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="ValuationDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="PaymentDates" type="{}stFreeStyleEventSchedule"/>
 *         &lt;element name="ExerciseDates" type="{}stFreeStyleEventSchedule"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lapseHedgeSwapData", propOrder = {

})
public class LapseHedgeSwapData {

    @XmlElement(name = "Payer", required = true)
    protected StFreeStyleBool payer;
    @XmlElement(name = "Notional", required = true)
    protected StFreeStyleNumber notional;
    @XmlElement(name = "LapseHedgePercentage", required = true)
    protected StFreeStyleNumber lapseHedgePercentage;
    @XmlElement(required = true)
    protected StFreeStyleNumberVector deltaN;
    @XmlElement(name = "SettlementCurrency", required = true)
    protected StFreeStyleCurrency settlementCurrency;
    @XmlElement(name = "Paydaycounter", required = true)
    protected StFreeStyleDayCounter paydaycounter;
    @XmlElement(name = "IRS", required = true)
    protected StFreeStyleNumber irs;
    @XmlElement(name = "IRSSpread", required = true)
    protected StFreeStyleNumber irsSpread;
    @XmlElement(name = "Tau", required = true)
    protected StFreeStyleNumber tau;
    @XmlElement(name = "Fee", required = true)
    protected StFreeStyleNumber fee;
    @XmlElement(name = "IMS", required = true)
    protected StFreeStyleNumberVector ims;
    @XmlElement(name = "PHFV", required = true)
    protected StFreeStyleNumberVector phfv;
    @XmlElement(name = "Penalty", required = true)
    protected StFreeStyleNumberVector penalty;
    @XmlElement(name = "ExitPrice", required = true)
    protected StFreeStyleNumberVector exitPrice;
    @XmlElement(name = "ExitFee", required = true)
    protected StFreeStyleNumberVector exitFee;
    @XmlElement(name = "InitialExchangeFee", required = true)
    protected StFreeStyleNumber initialExchangeFee;
    @XmlElement(name = "InitialExchangeDate", required = true)
    protected StFreeStyleEventSchedule initialExchangeDate;
    @XmlElement(name = "ValuationDates", required = true)
    protected StFreeStyleEventSchedule valuationDates;
    @XmlElement(name = "PaymentDates", required = true)
    protected StFreeStyleEventSchedule paymentDates;
    @XmlElement(name = "ExerciseDates", required = true)
    protected StFreeStyleEventSchedule exerciseDates;

    /**
     * payer 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleBool }
     *     
     */
    public StFreeStyleBool getPayer() {
        return payer;
    }

    /**
     * payer 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleBool }
     *     
     */
    public void setPayer(StFreeStyleBool value) {
        this.payer = value;
    }

    /**
     * notional 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getNotional() {
        return notional;
    }

    /**
     * notional 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setNotional(StFreeStyleNumber value) {
        this.notional = value;
    }

    /**
     * lapseHedgePercentage 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getLapseHedgePercentage() {
        return lapseHedgePercentage;
    }

    /**
     * lapseHedgePercentage 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setLapseHedgePercentage(StFreeStyleNumber value) {
        this.lapseHedgePercentage = value;
    }

    /**
     * deltaN 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getDeltaN() {
        return deltaN;
    }

    /**
     * deltaN 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setDeltaN(StFreeStyleNumberVector value) {
        this.deltaN = value;
    }

    /**
     * settlementCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public StFreeStyleCurrency getSettlementCurrency() {
        return settlementCurrency;
    }

    /**
     * settlementCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleCurrency }
     *     
     */
    public void setSettlementCurrency(StFreeStyleCurrency value) {
        this.settlementCurrency = value;
    }

    /**
     * paydaycounter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public StFreeStyleDayCounter getPaydaycounter() {
        return paydaycounter;
    }

    /**
     * paydaycounter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleDayCounter }
     *     
     */
    public void setPaydaycounter(StFreeStyleDayCounter value) {
        this.paydaycounter = value;
    }

    /**
     * irs 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getIRS() {
        return irs;
    }

    /**
     * irs 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setIRS(StFreeStyleNumber value) {
        this.irs = value;
    }

    /**
     * irsSpread 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getIRSSpread() {
        return irsSpread;
    }

    /**
     * irsSpread 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setIRSSpread(StFreeStyleNumber value) {
        this.irsSpread = value;
    }

    /**
     * tau 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getTau() {
        return tau;
    }

    /**
     * tau 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setTau(StFreeStyleNumber value) {
        this.tau = value;
    }

    /**
     * fee 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getFee() {
        return fee;
    }

    /**
     * fee 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setFee(StFreeStyleNumber value) {
        this.fee = value;
    }

    /**
     * ims 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getIMS() {
        return ims;
    }

    /**
     * ims 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setIMS(StFreeStyleNumberVector value) {
        this.ims = value;
    }

    /**
     * phfv 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getPHFV() {
        return phfv;
    }

    /**
     * phfv 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setPHFV(StFreeStyleNumberVector value) {
        this.phfv = value;
    }

    /**
     * penalty 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getPenalty() {
        return penalty;
    }

    /**
     * penalty 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setPenalty(StFreeStyleNumberVector value) {
        this.penalty = value;
    }

    /**
     * exitPrice 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getExitPrice() {
        return exitPrice;
    }

    /**
     * exitPrice 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setExitPrice(StFreeStyleNumberVector value) {
        this.exitPrice = value;
    }

    /**
     * exitFee 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public StFreeStyleNumberVector getExitFee() {
        return exitFee;
    }

    /**
     * exitFee 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumberVector }
     *     
     */
    public void setExitFee(StFreeStyleNumberVector value) {
        this.exitFee = value;
    }

    /**
     * initialExchangeFee 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public StFreeStyleNumber getInitialExchangeFee() {
        return initialExchangeFee;
    }

    /**
     * initialExchangeFee 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleNumber }
     *     
     */
    public void setInitialExchangeFee(StFreeStyleNumber value) {
        this.initialExchangeFee = value;
    }

    /**
     * initialExchangeDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getInitialExchangeDate() {
        return initialExchangeDate;
    }

    /**
     * initialExchangeDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setInitialExchangeDate(StFreeStyleEventSchedule value) {
        this.initialExchangeDate = value;
    }

    /**
     * valuationDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getValuationDates() {
        return valuationDates;
    }

    /**
     * valuationDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setValuationDates(StFreeStyleEventSchedule value) {
        this.valuationDates = value;
    }

    /**
     * paymentDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getPaymentDates() {
        return paymentDates;
    }

    /**
     * paymentDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setPaymentDates(StFreeStyleEventSchedule value) {
        this.paymentDates = value;
    }

    /**
     * exerciseDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public StFreeStyleEventSchedule getExerciseDates() {
        return exerciseDates;
    }

    /**
     * exerciseDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StFreeStyleEventSchedule }
     *     
     */
    public void setExerciseDates(StFreeStyleEventSchedule value) {
        this.exerciseDates = value;
    }

}
