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
 * <p>conventions complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="conventions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="Zero" type="{}zeroType"/>
 *         &lt;element name="CDS" type="{}cdsConventionsType"/>
 *         &lt;element name="Deposit" type="{}depositType"/>
 *         &lt;element name="Future" type="{}futureType"/>
 *         &lt;element name="FRA" type="{}fraType"/>
 *         &lt;element name="OIS" type="{}oisType"/>
 *         &lt;element name="Swap" type="{}swapType"/>
 *         &lt;element name="AverageOIS" type="{}averageOISType"/>
 *         &lt;element name="TenorBasisSwap" type="{}tenorBasisSwapType"/>
 *         &lt;element name="TenorBasisTwoSwap" type="{}tenorBasisTwoSwapType"/>
 *         &lt;element name="BMABasisSwap" type="{}bmaBasisSwapType"/>
 *         &lt;element name="FX" type="{}fxType"/>
 *         &lt;element name="CrossCurrencyBasis" type="{}crossCurrencyBasisType"/>
 *         &lt;element name="CrossCurrencyFixFloat" type="{}crossCurrencyFixFloatType"/>
 *         &lt;element name="IborIndex" type="{}iborIndexType"/>
 *         &lt;element name="OvernightIndex" type="{}overnightIndexType"/>
 *         &lt;element name="SwapIndex" type="{}swapIndexType"/>
 *         &lt;element name="InflationSwap" type="{}inflationswapType"/>
 *         &lt;element name="CmsSpreadOption" type="{}cmsSpreadOptionType"/>
 *         &lt;element name="CommodityForward" type="{}commodityForwardType"/>
 *         &lt;element name="CommodityFuture" type="{}commodityFutureType"/>
 *         &lt;element name="FxOption" type="{}fxOption"/>
 *         &lt;element name="FxOptionTimeWeighting" type="{}fxOptionTimeWeighting"/>
 *         &lt;element name="ZeroInflationIndex" type="{}zeroInflationIndexType"/>
 *         &lt;element name="BondYield" type="{}bondYield"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conventions", propOrder = {
    "zeroOrCDSOrDeposit"
})
public class Conventions {

    @XmlElements({
        @XmlElement(name = "Zero", type = ZeroType.class),
        @XmlElement(name = "CDS", type = CdsConventionsType.class),
        @XmlElement(name = "Deposit", type = DepositType.class),
        @XmlElement(name = "Future", type = FutureType.class),
        @XmlElement(name = "FRA", type = FraType.class),
        @XmlElement(name = "OIS", type = OisType.class),
        @XmlElement(name = "Swap", type = SwapType.class),
        @XmlElement(name = "AverageOIS", type = AverageOISType.class),
        @XmlElement(name = "TenorBasisSwap", type = TenorBasisSwapType.class),
        @XmlElement(name = "TenorBasisTwoSwap", type = TenorBasisTwoSwapType.class),
        @XmlElement(name = "BMABasisSwap", type = BmaBasisSwapType.class),
        @XmlElement(name = "FX", type = FxType.class),
        @XmlElement(name = "CrossCurrencyBasis", type = CrossCurrencyBasisType.class),
        @XmlElement(name = "CrossCurrencyFixFloat", type = CrossCurrencyFixFloatType.class),
        @XmlElement(name = "IborIndex", type = IborIndexType.class),
        @XmlElement(name = "OvernightIndex", type = OvernightIndexType.class),
        @XmlElement(name = "SwapIndex", type = SwapIndexType.class),
        @XmlElement(name = "InflationSwap", type = InflationswapType.class),
        @XmlElement(name = "CmsSpreadOption", type = CmsSpreadOptionType.class),
        @XmlElement(name = "CommodityForward", type = CommodityForwardType.class),
        @XmlElement(name = "CommodityFuture", type = CommodityFutureType.class),
        @XmlElement(name = "FxOption", type = FxOption.class),
        @XmlElement(name = "FxOptionTimeWeighting", type = FxOptionTimeWeighting.class),
        @XmlElement(name = "ZeroInflationIndex", type = ZeroInflationIndexType.class),
        @XmlElement(name = "BondYield", type = BondYield.class)
    })
    protected List<Object> zeroOrCDSOrDeposit;

    /**
     * Gets the value of the zeroOrCDSOrDeposit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zeroOrCDSOrDeposit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZeroOrCDSOrDeposit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZeroType }
     * {@link CdsConventionsType }
     * {@link DepositType }
     * {@link FutureType }
     * {@link FraType }
     * {@link OisType }
     * {@link SwapType }
     * {@link AverageOISType }
     * {@link TenorBasisSwapType }
     * {@link TenorBasisTwoSwapType }
     * {@link BmaBasisSwapType }
     * {@link FxType }
     * {@link CrossCurrencyBasisType }
     * {@link CrossCurrencyFixFloatType }
     * {@link IborIndexType }
     * {@link OvernightIndexType }
     * {@link SwapIndexType }
     * {@link InflationswapType }
     * {@link CmsSpreadOptionType }
     * {@link CommodityForwardType }
     * {@link CommodityFutureType }
     * {@link FxOption }
     * {@link FxOptionTimeWeighting }
     * {@link ZeroInflationIndexType }
     * {@link BondYield }
     * 
     * 
     */
    public List<Object> getZeroOrCDSOrDeposit() {
        if (zeroOrCDSOrDeposit == null) {
            zeroOrCDSOrDeposit = new ArrayList<Object>();
        }
        return this.zeroOrCDSOrDeposit;
    }

}
