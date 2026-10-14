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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>segmentsType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="segmentsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="Direct" type="{}directSegmentType"/>
 *         &lt;element name="Simple" type="{}simpleSegmentType"/>
 *         &lt;element name="AverageOIS" type="{}aoisSegmentType"/>
 *         &lt;element name="TenorBasis" type="{}tenorBasisSegmentType"/>
 *         &lt;element name="CrossCurrency" type="{}crossCurrencySegmentType"/>
 *         &lt;element name="ZeroSpread" type="{}zeroSpreadType"/>
 *         &lt;element name="DiscountRatio" type="{}discountRatioType"/>
 *         &lt;element name="FittedBond" type="{}fittedBondType"/>
 *         &lt;element name="BondYieldShifted" type="{}BondYieldShiftedType"/>
 *         &lt;element name="WeightedAverage" type="{}weightedAverageType"/>
 *         &lt;element name="YieldPlusDefault" type="{}yieldPlusDefaultType"/>
 *         &lt;element name="IborFallback" type="{}iborFallbackType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "segmentsType", propOrder = {
    "directOrSimpleOrAverageOIS"
})
public class SegmentsType {

    @XmlElements({
        @XmlElement(name = "Direct", type = DirectSegmentType.class),
        @XmlElement(name = "Simple", type = SimpleSegmentType.class),
        @XmlElement(name = "AverageOIS", type = AoisSegmentType.class),
        @XmlElement(name = "TenorBasis", type = TenorBasisSegmentType.class),
        @XmlElement(name = "CrossCurrency", type = CrossCurrencySegmentType.class),
        @XmlElement(name = "ZeroSpread", type = ZeroSpreadType.class),
        @XmlElement(name = "DiscountRatio", type = DiscountRatioType.class),
        @XmlElement(name = "FittedBond", type = FittedBondType.class),
        @XmlElement(name = "BondYieldShifted", type = BondYieldShiftedType.class),
        @XmlElement(name = "WeightedAverage", type = WeightedAverageType.class),
        @XmlElement(name = "YieldPlusDefault", type = YieldPlusDefaultType.class),
        @XmlElement(name = "IborFallback", type = IborFallbackType.class)
    })
    protected List<Object> directOrSimpleOrAverageOIS;

    /**
     * Gets the value of the directOrSimpleOrAverageOIS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directOrSimpleOrAverageOIS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectOrSimpleOrAverageOIS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DirectSegmentType }
     * {@link SimpleSegmentType }
     * {@link AoisSegmentType }
     * {@link TenorBasisSegmentType }
     * {@link CrossCurrencySegmentType }
     * {@link ZeroSpreadType }
     * {@link DiscountRatioType }
     * {@link FittedBondType }
     * {@link BondYieldShiftedType }
     * {@link WeightedAverageType }
     * {@link YieldPlusDefaultType }
     * {@link IborFallbackType }
     * 
     * 
     */
    public List<Object> getDirectOrSimpleOrAverageOIS() {
        if (directOrSimpleOrAverageOIS == null) {
            directOrSimpleOrAverageOIS = new ArrayList<Object>();
        }
        return this.directOrSimpleOrAverageOIS;
    }

}
