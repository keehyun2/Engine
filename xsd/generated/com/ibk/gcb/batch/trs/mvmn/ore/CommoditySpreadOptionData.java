//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>commoditySpreadOptionData complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="commoditySpreadOptionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LegData" type="{}legData" maxOccurs="2" minOccurs="2"/>
 *         &lt;element name="OptionData" type="{}optionData"/>
 *         &lt;element name="SpreadStrike" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="OptionStripPaymentDates" type="{}commoditySpreadOptionStripPaymentData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commoditySpreadOptionData", propOrder = {
    "legData",
    "optionData",
    "spreadStrike",
    "optionStripPaymentDates"
})
public class CommoditySpreadOptionData {

    @XmlElement(name = "LegData", required = true)
    protected List<LegData> legData;
    @XmlElement(name = "OptionData", required = true)
    protected OptionData optionData;
    @XmlElement(name = "SpreadStrike")
    protected double spreadStrike;
    @XmlElement(name = "OptionStripPaymentDates")
    protected CommoditySpreadOptionStripPaymentData optionStripPaymentDates;

    /**
     * Gets the value of the legData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LegData }
     * 
     * 
     */
    public List<LegData> getLegData() {
        if (legData == null) {
            legData = new ArrayList<LegData>();
        }
        return this.legData;
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
     * spreadStrike 속성의 값을 가져옵니다.
     * 
     */
    public double getSpreadStrike() {
        return spreadStrike;
    }

    /**
     * spreadStrike 속성의 값을 설정합니다.
     * 
     */
    public void setSpreadStrike(double value) {
        this.spreadStrike = value;
    }

    /**
     * optionStripPaymentDates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CommoditySpreadOptionStripPaymentData }
     *     
     */
    public CommoditySpreadOptionStripPaymentData getOptionStripPaymentDates() {
        return optionStripPaymentDates;
    }

    /**
     * optionStripPaymentDates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CommoditySpreadOptionStripPaymentData }
     *     
     */
    public void setOptionStripPaymentDates(CommoditySpreadOptionStripPaymentData value) {
        this.optionStripPaymentDates = value;
    }

}
