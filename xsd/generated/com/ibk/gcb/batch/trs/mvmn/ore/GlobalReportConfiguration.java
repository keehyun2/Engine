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
 * <p>globalReportConfiguration complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="globalReportConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="FXVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EquityVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CommodityVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IRSwaptionVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IRCapFloorVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="YieldCurves" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Report" type="{}yieldCurveReport" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InflationCapFloorVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "globalReportConfiguration", propOrder = {

})
public class GlobalReportConfiguration {

    @XmlElement(name = "FXVolatilities")
    protected GlobalReportConfiguration.FXVolatilities fxVolatilities;
    @XmlElement(name = "EquityVolatilities")
    protected GlobalReportConfiguration.EquityVolatilities equityVolatilities;
    @XmlElement(name = "CommodityVolatilities")
    protected GlobalReportConfiguration.CommodityVolatilities commodityVolatilities;
    @XmlElement(name = "IRSwaptionVolatilities")
    protected GlobalReportConfiguration.IRSwaptionVolatilities irSwaptionVolatilities;
    @XmlElement(name = "IRCapFloorVolatilities")
    protected GlobalReportConfiguration.IRCapFloorVolatilities irCapFloorVolatilities;
    @XmlElement(name = "YieldCurves")
    protected GlobalReportConfiguration.YieldCurves yieldCurves;
    @XmlElement(name = "InflationCapFloorVolatilities")
    protected GlobalReportConfiguration.InflationCapFloorVolatilities inflationCapFloorVolatilities;

    /**
     * fxVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GlobalReportConfiguration.FXVolatilities }
     *     
     */
    public GlobalReportConfiguration.FXVolatilities getFXVolatilities() {
        return fxVolatilities;
    }

    /**
     * fxVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalReportConfiguration.FXVolatilities }
     *     
     */
    public void setFXVolatilities(GlobalReportConfiguration.FXVolatilities value) {
        this.fxVolatilities = value;
    }

    /**
     * equityVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GlobalReportConfiguration.EquityVolatilities }
     *     
     */
    public GlobalReportConfiguration.EquityVolatilities getEquityVolatilities() {
        return equityVolatilities;
    }

    /**
     * equityVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalReportConfiguration.EquityVolatilities }
     *     
     */
    public void setEquityVolatilities(GlobalReportConfiguration.EquityVolatilities value) {
        this.equityVolatilities = value;
    }

    /**
     * commodityVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GlobalReportConfiguration.CommodityVolatilities }
     *     
     */
    public GlobalReportConfiguration.CommodityVolatilities getCommodityVolatilities() {
        return commodityVolatilities;
    }

    /**
     * commodityVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalReportConfiguration.CommodityVolatilities }
     *     
     */
    public void setCommodityVolatilities(GlobalReportConfiguration.CommodityVolatilities value) {
        this.commodityVolatilities = value;
    }

    /**
     * irSwaptionVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GlobalReportConfiguration.IRSwaptionVolatilities }
     *     
     */
    public GlobalReportConfiguration.IRSwaptionVolatilities getIRSwaptionVolatilities() {
        return irSwaptionVolatilities;
    }

    /**
     * irSwaptionVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalReportConfiguration.IRSwaptionVolatilities }
     *     
     */
    public void setIRSwaptionVolatilities(GlobalReportConfiguration.IRSwaptionVolatilities value) {
        this.irSwaptionVolatilities = value;
    }

    /**
     * irCapFloorVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GlobalReportConfiguration.IRCapFloorVolatilities }
     *     
     */
    public GlobalReportConfiguration.IRCapFloorVolatilities getIRCapFloorVolatilities() {
        return irCapFloorVolatilities;
    }

    /**
     * irCapFloorVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalReportConfiguration.IRCapFloorVolatilities }
     *     
     */
    public void setIRCapFloorVolatilities(GlobalReportConfiguration.IRCapFloorVolatilities value) {
        this.irCapFloorVolatilities = value;
    }

    /**
     * yieldCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GlobalReportConfiguration.YieldCurves }
     *     
     */
    public GlobalReportConfiguration.YieldCurves getYieldCurves() {
        return yieldCurves;
    }

    /**
     * yieldCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalReportConfiguration.YieldCurves }
     *     
     */
    public void setYieldCurves(GlobalReportConfiguration.YieldCurves value) {
        this.yieldCurves = value;
    }

    /**
     * inflationCapFloorVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GlobalReportConfiguration.InflationCapFloorVolatilities }
     *     
     */
    public GlobalReportConfiguration.InflationCapFloorVolatilities getInflationCapFloorVolatilities() {
        return inflationCapFloorVolatilities;
    }

    /**
     * inflationCapFloorVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalReportConfiguration.InflationCapFloorVolatilities }
     *     
     */
    public void setInflationCapFloorVolatilities(GlobalReportConfiguration.InflationCapFloorVolatilities value) {
        this.inflationCapFloorVolatilities = value;
    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class CommodityVolatilities {

        @XmlElement(name = "Report")
        protected ReportConfiguration report;

        /**
         * report 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ReportConfiguration }
         *     
         */
        public ReportConfiguration getReport() {
            return report;
        }

        /**
         * report 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ReportConfiguration }
         *     
         */
        public void setReport(ReportConfiguration value) {
            this.report = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class EquityVolatilities {

        @XmlElement(name = "Report")
        protected ReportConfiguration report;

        /**
         * report 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ReportConfiguration }
         *     
         */
        public ReportConfiguration getReport() {
            return report;
        }

        /**
         * report 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ReportConfiguration }
         *     
         */
        public void setReport(ReportConfiguration value) {
            this.report = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class FXVolatilities {

        @XmlElement(name = "Report")
        protected ReportConfiguration report;

        /**
         * report 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ReportConfiguration }
         *     
         */
        public ReportConfiguration getReport() {
            return report;
        }

        /**
         * report 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ReportConfiguration }
         *     
         */
        public void setReport(ReportConfiguration value) {
            this.report = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class IRCapFloorVolatilities {

        @XmlElement(name = "Report")
        protected ReportConfiguration report;

        /**
         * report 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ReportConfiguration }
         *     
         */
        public ReportConfiguration getReport() {
            return report;
        }

        /**
         * report 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ReportConfiguration }
         *     
         */
        public void setReport(ReportConfiguration value) {
            this.report = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class IRSwaptionVolatilities {

        @XmlElement(name = "Report")
        protected ReportConfiguration report;

        /**
         * report 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ReportConfiguration }
         *     
         */
        public ReportConfiguration getReport() {
            return report;
        }

        /**
         * report 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ReportConfiguration }
         *     
         */
        public void setReport(ReportConfiguration value) {
            this.report = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="Report" type="{}reportConfiguration" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class InflationCapFloorVolatilities {

        @XmlElement(name = "Report")
        protected ReportConfiguration report;

        /**
         * report 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link ReportConfiguration }
         *     
         */
        public ReportConfiguration getReport() {
            return report;
        }

        /**
         * report 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link ReportConfiguration }
         *     
         */
        public void setReport(ReportConfiguration value) {
            this.report = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="Report" type="{}yieldCurveReport" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class YieldCurves {

        @XmlElement(name = "Report")
        protected YieldCurveReport report;

        /**
         * report 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link YieldCurveReport }
         *     
         */
        public YieldCurveReport getReport() {
            return report;
        }

        /**
         * report 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link YieldCurveReport }
         *     
         */
        public void setReport(YieldCurveReport value) {
            this.report = value;
        }

    }

}
