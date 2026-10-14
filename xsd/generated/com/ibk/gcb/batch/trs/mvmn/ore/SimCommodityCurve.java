//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>simCommodityCurve complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="simCommodityCurve">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CurveId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurveDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{}currencyCode"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="BasePriceCurve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *             &lt;element name="BaseYieldCurve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *             &lt;element name="YieldCurve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="SpotQuote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *             &lt;element name="Quotes" type="{}quoteType"/>
 *             &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *             &lt;element name="InterpolationMethod" type="{}commodityInterpolationType" minOccurs="0"/>
 *             &lt;element name="Conventions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="BasisConfiguration" type="{}commodityBasisConfig"/>
 *           &lt;sequence>
 *             &lt;element name="PriceSegments" type="{}priceSegmentsType"/>
 *             &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *             &lt;element name="InterpolationMethod" type="{}commodityInterpolationType" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="Extrapolation" type="{}bool" minOccurs="0"/>
 *         &lt;element name="BootstrapConfig" type="{}bootstrapConfigType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simCommodityCurve", propOrder = {
    "content"
})
public class SimCommodityCurve {

    @XmlElementRefs({
        @XmlElementRef(name = "BasisConfiguration", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PriceSegments", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YieldCurve", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Currency", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SpotQuote", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BasePriceCurve", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "InterpolationMethod", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BaseYieldCurve", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Quotes", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Extrapolation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DayCounter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BootstrapConfig", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CurveId", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Conventions", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CurveDescription", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * 나머지 콘텐츠 모델을 가져옵니다. 
     * 
     * <p>
     * 다음 원인으로 인해 이 "catch-all" 속성을 가져오고 있습니다.
     * 필드 이름 "DayCounter"이(가) 스키마의 다른 두 부분에 사용되었습니다. 참조: 
     * file:/C:/Users/ibk/dev/Engine/xsd/curveconfig.xsd의 901행
     * file:/C:/Users/ibk/dev/Engine/xsd/curveconfig.xsd의 894행
     * <p>
     * 이 속성을 제거하려면 다음 선언 중 하나에 
     * 속성 사용자 정의를 적용하여 이름을 변경하십시오. 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CommodityBasisConfig }{@code >}
     * {@link JAXBElement }{@code <}{@link PriceSegmentsType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link CurrencyCode }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link CommodityInterpolationType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link QuoteType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BootstrapConfigType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<?>>();
        }
        return this.content;
    }

}
