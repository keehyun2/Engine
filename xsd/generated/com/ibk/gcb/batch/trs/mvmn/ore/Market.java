//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2026.10.14 시간 12:18:30 PM KST 
//


package com.ibk.gcb.batch.trs.mvmn.ore;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>market complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="market">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="BaseCurrency" type="{}currencyCode"/>
 *         &lt;element name="Currencies">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="YieldCurves">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Configuration" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Tenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Interpolation" type="{}ycInterpolation" minOccurs="0"/>
 *                             &lt;element name="Extrapolation" type="{}ycExtrapolation" minOccurs="0"/>
 *                             &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
 *                           &lt;/all>
 *                           &lt;attribute name="curve" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FxRates" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="CurrencyPairs" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CurrencyPair" type="{}currencyPair" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Indices" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Index" type="{}indexNameType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SwapIndices" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SwapIndex" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ForwardingIndex" type="{}indexNameType" minOccurs="0"/>
 *                             &lt;element name="DiscountingIndex" type="{}indexNameType"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DefaultCurves" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Names">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Tenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SimulateSurvivalProbabilities" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="SimulateRecoveryRates" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="DayCounters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DayCounter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Calendars" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Calendar" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Extrapolation" type="{}defaultCurveExtrapolation" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Equities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="SimulateEquityForecastCurve" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="SimulateDividendYield" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="Names">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DividendTenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SwaptionVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
 *                   &lt;element name="Keys" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Currencies" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Expiries">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Terms">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SimulateATMOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="StrikeSpreads" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DayCounters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DayCounter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="YieldVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
 *                   &lt;element name="Names">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Terms" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SimulateATMOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="Cube" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="StrikeSpreads" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DayCounters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DayCounter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CapFloorVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
 *                   &lt;element name="Keys" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Currencies" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Expiries" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Strikes" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DayCounters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DayCounter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="AdjustOptionletPillars" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="UseCapAtm" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CDSVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
 *                   &lt;element name="Names">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FxVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="ReactionToTimeDecay" type="{}timeDecayType" minOccurs="0"/>
 *                   &lt;element name="CurrencyPairs" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CurrencyPair" type="{}currencyPair" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Expiries" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SimulateATMOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="Surface" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="Moneyness" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="StandardDeviations" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DayCounters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DayCounter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EquityVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
 *                   &lt;element name="Names">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Expiries" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SimulateATMOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="Surface" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Moneyness" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="StandardDeviations" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DayCounters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DayCounter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BenchmarkCurves" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BenchmarkCurve" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Currency" type="{}currencyCode"/>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Securities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="Names" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CPRs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="Names" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CpiIndices" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ZeroInflationIndexCurves" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Names">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Tenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DayCounters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DayCounter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="YYInflationIndexCurves" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Names">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Tenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DayCounters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DayCounter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CPICapFloorVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
 *                   &lt;element name="Names">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="YYCapFloorVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
 *                   &lt;element name="Names">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Commodities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="Names">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Tenors" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DayCounters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DayCounter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CommodityVolatilities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="SimulateATMOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
 *                   &lt;element name="Names">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;all>
 *                                       &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Moneyness" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                     &lt;/all>
 *                                     &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DayCounter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AggregationScenarioDataCurrencies" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AggregationScenarioDataIndices" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Index" type="{}indexNameType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AggregationScenarioDataCreditStates" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NumberOfFactors" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AggregationScenarioDataSurvivalWeights" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BaseCorrelations" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Simulate" type="{}bool" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="IndexNames">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IndexName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Terms" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="DetachmentPoints" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="DayCounters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DayCounter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Correlations" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
 *                   &lt;element name="Pairs">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Pair" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CreditStates" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NumberOfFactors" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CurveAlgebra" type="{}curveAlgebra" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "market", propOrder = {

})
public class Market {

    @XmlElement(name = "BaseCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyCode baseCurrency;
    @XmlElement(name = "Currencies", required = true)
    protected Market.Currencies currencies;
    @XmlElement(name = "YieldCurves", required = true)
    protected Market.YieldCurves yieldCurves;
    @XmlElement(name = "FxRates")
    protected Market.FxRates fxRates;
    @XmlElement(name = "Indices")
    protected Market.Indices indices;
    @XmlElement(name = "SwapIndices")
    protected Market.SwapIndices swapIndices;
    @XmlElement(name = "DefaultCurves")
    protected Market.DefaultCurves defaultCurves;
    @XmlElement(name = "Equities")
    protected Market.Equities equities;
    @XmlElement(name = "SwaptionVolatilities")
    protected Market.SwaptionVolatilities swaptionVolatilities;
    @XmlElement(name = "YieldVolatilities")
    protected Market.YieldVolatilities yieldVolatilities;
    @XmlElement(name = "CapFloorVolatilities")
    protected Market.CapFloorVolatilities capFloorVolatilities;
    @XmlElement(name = "CDSVolatilities")
    protected Market.CDSVolatilities cdsVolatilities;
    @XmlElement(name = "FxVolatilities")
    protected Market.FxVolatilities fxVolatilities;
    @XmlElement(name = "EquityVolatilities")
    protected Market.EquityVolatilities equityVolatilities;
    @XmlElement(name = "BenchmarkCurves")
    protected Market.BenchmarkCurves benchmarkCurves;
    @XmlElement(name = "Securities")
    protected Market.Securities securities;
    @XmlElement(name = "CPRs")
    protected Market.CPRs cpRs;
    @XmlElement(name = "CpiIndices")
    protected Market.CpiIndices cpiIndices;
    @XmlElement(name = "ZeroInflationIndexCurves")
    protected Market.ZeroInflationIndexCurves zeroInflationIndexCurves;
    @XmlElement(name = "YYInflationIndexCurves")
    protected Market.YYInflationIndexCurves yyInflationIndexCurves;
    @XmlElement(name = "CPICapFloorVolatilities")
    protected Market.CPICapFloorVolatilities cpiCapFloorVolatilities;
    @XmlElement(name = "YYCapFloorVolatilities")
    protected Market.YYCapFloorVolatilities yyCapFloorVolatilities;
    @XmlElement(name = "Commodities")
    protected Market.Commodities commodities;
    @XmlElement(name = "CommodityVolatilities")
    protected Market.CommodityVolatilities commodityVolatilities;
    @XmlElement(name = "AggregationScenarioDataCurrencies")
    protected Market.AggregationScenarioDataCurrencies aggregationScenarioDataCurrencies;
    @XmlElement(name = "AggregationScenarioDataIndices")
    protected Market.AggregationScenarioDataIndices aggregationScenarioDataIndices;
    @XmlElement(name = "AggregationScenarioDataCreditStates")
    protected Market.AggregationScenarioDataCreditStates aggregationScenarioDataCreditStates;
    @XmlElement(name = "AggregationScenarioDataSurvivalWeights")
    protected Market.AggregationScenarioDataSurvivalWeights aggregationScenarioDataSurvivalWeights;
    @XmlElement(name = "BaseCorrelations")
    protected Market.BaseCorrelations baseCorrelations;
    @XmlElement(name = "Correlations")
    protected Market.Correlations correlations;
    @XmlElement(name = "CreditStates")
    protected Market.CreditStates creditStates;
    @XmlElement(name = "CurveAlgebra")
    protected CurveAlgebra curveAlgebra;

    /**
     * baseCurrency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getBaseCurrency() {
        return baseCurrency;
    }

    /**
     * baseCurrency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setBaseCurrency(CurrencyCode value) {
        this.baseCurrency = value;
    }

    /**
     * currencies 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.Currencies }
     *     
     */
    public Market.Currencies getCurrencies() {
        return currencies;
    }

    /**
     * currencies 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.Currencies }
     *     
     */
    public void setCurrencies(Market.Currencies value) {
        this.currencies = value;
    }

    /**
     * yieldCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.YieldCurves }
     *     
     */
    public Market.YieldCurves getYieldCurves() {
        return yieldCurves;
    }

    /**
     * yieldCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.YieldCurves }
     *     
     */
    public void setYieldCurves(Market.YieldCurves value) {
        this.yieldCurves = value;
    }

    /**
     * fxRates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.FxRates }
     *     
     */
    public Market.FxRates getFxRates() {
        return fxRates;
    }

    /**
     * fxRates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.FxRates }
     *     
     */
    public void setFxRates(Market.FxRates value) {
        this.fxRates = value;
    }

    /**
     * indices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.Indices }
     *     
     */
    public Market.Indices getIndices() {
        return indices;
    }

    /**
     * indices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.Indices }
     *     
     */
    public void setIndices(Market.Indices value) {
        this.indices = value;
    }

    /**
     * swapIndices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.SwapIndices }
     *     
     */
    public Market.SwapIndices getSwapIndices() {
        return swapIndices;
    }

    /**
     * swapIndices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.SwapIndices }
     *     
     */
    public void setSwapIndices(Market.SwapIndices value) {
        this.swapIndices = value;
    }

    /**
     * defaultCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.DefaultCurves }
     *     
     */
    public Market.DefaultCurves getDefaultCurves() {
        return defaultCurves;
    }

    /**
     * defaultCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.DefaultCurves }
     *     
     */
    public void setDefaultCurves(Market.DefaultCurves value) {
        this.defaultCurves = value;
    }

    /**
     * equities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.Equities }
     *     
     */
    public Market.Equities getEquities() {
        return equities;
    }

    /**
     * equities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.Equities }
     *     
     */
    public void setEquities(Market.Equities value) {
        this.equities = value;
    }

    /**
     * swaptionVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.SwaptionVolatilities }
     *     
     */
    public Market.SwaptionVolatilities getSwaptionVolatilities() {
        return swaptionVolatilities;
    }

    /**
     * swaptionVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.SwaptionVolatilities }
     *     
     */
    public void setSwaptionVolatilities(Market.SwaptionVolatilities value) {
        this.swaptionVolatilities = value;
    }

    /**
     * yieldVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.YieldVolatilities }
     *     
     */
    public Market.YieldVolatilities getYieldVolatilities() {
        return yieldVolatilities;
    }

    /**
     * yieldVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.YieldVolatilities }
     *     
     */
    public void setYieldVolatilities(Market.YieldVolatilities value) {
        this.yieldVolatilities = value;
    }

    /**
     * capFloorVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.CapFloorVolatilities }
     *     
     */
    public Market.CapFloorVolatilities getCapFloorVolatilities() {
        return capFloorVolatilities;
    }

    /**
     * capFloorVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.CapFloorVolatilities }
     *     
     */
    public void setCapFloorVolatilities(Market.CapFloorVolatilities value) {
        this.capFloorVolatilities = value;
    }

    /**
     * cdsVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.CDSVolatilities }
     *     
     */
    public Market.CDSVolatilities getCDSVolatilities() {
        return cdsVolatilities;
    }

    /**
     * cdsVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.CDSVolatilities }
     *     
     */
    public void setCDSVolatilities(Market.CDSVolatilities value) {
        this.cdsVolatilities = value;
    }

    /**
     * fxVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.FxVolatilities }
     *     
     */
    public Market.FxVolatilities getFxVolatilities() {
        return fxVolatilities;
    }

    /**
     * fxVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.FxVolatilities }
     *     
     */
    public void setFxVolatilities(Market.FxVolatilities value) {
        this.fxVolatilities = value;
    }

    /**
     * equityVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.EquityVolatilities }
     *     
     */
    public Market.EquityVolatilities getEquityVolatilities() {
        return equityVolatilities;
    }

    /**
     * equityVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.EquityVolatilities }
     *     
     */
    public void setEquityVolatilities(Market.EquityVolatilities value) {
        this.equityVolatilities = value;
    }

    /**
     * benchmarkCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.BenchmarkCurves }
     *     
     */
    public Market.BenchmarkCurves getBenchmarkCurves() {
        return benchmarkCurves;
    }

    /**
     * benchmarkCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.BenchmarkCurves }
     *     
     */
    public void setBenchmarkCurves(Market.BenchmarkCurves value) {
        this.benchmarkCurves = value;
    }

    /**
     * securities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.Securities }
     *     
     */
    public Market.Securities getSecurities() {
        return securities;
    }

    /**
     * securities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.Securities }
     *     
     */
    public void setSecurities(Market.Securities value) {
        this.securities = value;
    }

    /**
     * cpRs 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.CPRs }
     *     
     */
    public Market.CPRs getCPRs() {
        return cpRs;
    }

    /**
     * cpRs 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.CPRs }
     *     
     */
    public void setCPRs(Market.CPRs value) {
        this.cpRs = value;
    }

    /**
     * cpiIndices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.CpiIndices }
     *     
     */
    public Market.CpiIndices getCpiIndices() {
        return cpiIndices;
    }

    /**
     * cpiIndices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.CpiIndices }
     *     
     */
    public void setCpiIndices(Market.CpiIndices value) {
        this.cpiIndices = value;
    }

    /**
     * zeroInflationIndexCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.ZeroInflationIndexCurves }
     *     
     */
    public Market.ZeroInflationIndexCurves getZeroInflationIndexCurves() {
        return zeroInflationIndexCurves;
    }

    /**
     * zeroInflationIndexCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.ZeroInflationIndexCurves }
     *     
     */
    public void setZeroInflationIndexCurves(Market.ZeroInflationIndexCurves value) {
        this.zeroInflationIndexCurves = value;
    }

    /**
     * yyInflationIndexCurves 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.YYInflationIndexCurves }
     *     
     */
    public Market.YYInflationIndexCurves getYYInflationIndexCurves() {
        return yyInflationIndexCurves;
    }

    /**
     * yyInflationIndexCurves 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.YYInflationIndexCurves }
     *     
     */
    public void setYYInflationIndexCurves(Market.YYInflationIndexCurves value) {
        this.yyInflationIndexCurves = value;
    }

    /**
     * cpiCapFloorVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.CPICapFloorVolatilities }
     *     
     */
    public Market.CPICapFloorVolatilities getCPICapFloorVolatilities() {
        return cpiCapFloorVolatilities;
    }

    /**
     * cpiCapFloorVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.CPICapFloorVolatilities }
     *     
     */
    public void setCPICapFloorVolatilities(Market.CPICapFloorVolatilities value) {
        this.cpiCapFloorVolatilities = value;
    }

    /**
     * yyCapFloorVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.YYCapFloorVolatilities }
     *     
     */
    public Market.YYCapFloorVolatilities getYYCapFloorVolatilities() {
        return yyCapFloorVolatilities;
    }

    /**
     * yyCapFloorVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.YYCapFloorVolatilities }
     *     
     */
    public void setYYCapFloorVolatilities(Market.YYCapFloorVolatilities value) {
        this.yyCapFloorVolatilities = value;
    }

    /**
     * commodities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.Commodities }
     *     
     */
    public Market.Commodities getCommodities() {
        return commodities;
    }

    /**
     * commodities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.Commodities }
     *     
     */
    public void setCommodities(Market.Commodities value) {
        this.commodities = value;
    }

    /**
     * commodityVolatilities 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.CommodityVolatilities }
     *     
     */
    public Market.CommodityVolatilities getCommodityVolatilities() {
        return commodityVolatilities;
    }

    /**
     * commodityVolatilities 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.CommodityVolatilities }
     *     
     */
    public void setCommodityVolatilities(Market.CommodityVolatilities value) {
        this.commodityVolatilities = value;
    }

    /**
     * aggregationScenarioDataCurrencies 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.AggregationScenarioDataCurrencies }
     *     
     */
    public Market.AggregationScenarioDataCurrencies getAggregationScenarioDataCurrencies() {
        return aggregationScenarioDataCurrencies;
    }

    /**
     * aggregationScenarioDataCurrencies 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.AggregationScenarioDataCurrencies }
     *     
     */
    public void setAggregationScenarioDataCurrencies(Market.AggregationScenarioDataCurrencies value) {
        this.aggregationScenarioDataCurrencies = value;
    }

    /**
     * aggregationScenarioDataIndices 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.AggregationScenarioDataIndices }
     *     
     */
    public Market.AggregationScenarioDataIndices getAggregationScenarioDataIndices() {
        return aggregationScenarioDataIndices;
    }

    /**
     * aggregationScenarioDataIndices 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.AggregationScenarioDataIndices }
     *     
     */
    public void setAggregationScenarioDataIndices(Market.AggregationScenarioDataIndices value) {
        this.aggregationScenarioDataIndices = value;
    }

    /**
     * aggregationScenarioDataCreditStates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.AggregationScenarioDataCreditStates }
     *     
     */
    public Market.AggregationScenarioDataCreditStates getAggregationScenarioDataCreditStates() {
        return aggregationScenarioDataCreditStates;
    }

    /**
     * aggregationScenarioDataCreditStates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.AggregationScenarioDataCreditStates }
     *     
     */
    public void setAggregationScenarioDataCreditStates(Market.AggregationScenarioDataCreditStates value) {
        this.aggregationScenarioDataCreditStates = value;
    }

    /**
     * aggregationScenarioDataSurvivalWeights 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.AggregationScenarioDataSurvivalWeights }
     *     
     */
    public Market.AggregationScenarioDataSurvivalWeights getAggregationScenarioDataSurvivalWeights() {
        return aggregationScenarioDataSurvivalWeights;
    }

    /**
     * aggregationScenarioDataSurvivalWeights 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.AggregationScenarioDataSurvivalWeights }
     *     
     */
    public void setAggregationScenarioDataSurvivalWeights(Market.AggregationScenarioDataSurvivalWeights value) {
        this.aggregationScenarioDataSurvivalWeights = value;
    }

    /**
     * baseCorrelations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.BaseCorrelations }
     *     
     */
    public Market.BaseCorrelations getBaseCorrelations() {
        return baseCorrelations;
    }

    /**
     * baseCorrelations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.BaseCorrelations }
     *     
     */
    public void setBaseCorrelations(Market.BaseCorrelations value) {
        this.baseCorrelations = value;
    }

    /**
     * correlations 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.Correlations }
     *     
     */
    public Market.Correlations getCorrelations() {
        return correlations;
    }

    /**
     * correlations 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.Correlations }
     *     
     */
    public void setCorrelations(Market.Correlations value) {
        this.correlations = value;
    }

    /**
     * creditStates 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Market.CreditStates }
     *     
     */
    public Market.CreditStates getCreditStates() {
        return creditStates;
    }

    /**
     * creditStates 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Market.CreditStates }
     *     
     */
    public void setCreditStates(Market.CreditStates value) {
        this.creditStates = value;
    }

    /**
     * curveAlgebra 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurveAlgebra }
     *     
     */
    public CurveAlgebra getCurveAlgebra() {
        return curveAlgebra;
    }

    /**
     * curveAlgebra 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurveAlgebra }
     *     
     */
    public void setCurveAlgebra(CurveAlgebra value) {
        this.curveAlgebra = value;
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
     *       &lt;sequence>
     *         &lt;element name="NumberOfFactors" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "numberOfFactors"
    })
    public static class AggregationScenarioDataCreditStates {

        @XmlElement(name = "NumberOfFactors", required = true)
        protected BigInteger numberOfFactors;

        /**
         * numberOfFactors 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNumberOfFactors() {
            return numberOfFactors;
        }

        /**
         * numberOfFactors 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNumberOfFactors(BigInteger value) {
            this.numberOfFactors = value;
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
     *       &lt;sequence>
     *         &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "currency"
    })
    public static class AggregationScenarioDataCurrencies {

        @XmlElement(name = "Currency")
        @XmlSchemaType(name = "string")
        protected List<CurrencyCode> currency;

        /**
         * Gets the value of the currency property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the currency property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCurrency().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CurrencyCode }
         * 
         * 
         */
        public List<CurrencyCode> getCurrency() {
            if (currency == null) {
                currency = new ArrayList<CurrencyCode>();
            }
            return this.currency;
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
     *       &lt;sequence>
     *         &lt;element name="Index" type="{}indexNameType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "index"
    })
    public static class AggregationScenarioDataIndices {

        @XmlElement(name = "Index")
        protected List<String> index;

        /**
         * Gets the value of the index property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the index property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIndex().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getIndex() {
            if (index == null) {
                index = new ArrayList<String>();
            }
            return this.index;
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
     *       &lt;sequence>
     *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name"
    })
    public static class AggregationScenarioDataSurvivalWeights {

        @XmlElement(name = "Name", required = true)
        protected List<String> name;

        /**
         * Gets the value of the name property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the name property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getName() {
            if (name == null) {
                name = new ArrayList<String>();
            }
            return this.name;
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
     *       &lt;sequence>
     *         &lt;element name="Simulate" type="{}bool" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="IndexNames">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IndexName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Terms" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="DetachmentPoints" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="DayCounters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DayCounter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulate",
        "indexNames",
        "terms",
        "detachmentPoints",
        "dayCounters"
    })
    public static class BaseCorrelations {

        @XmlElement(name = "Simulate")
        protected List<String> simulate;
        @XmlElement(name = "IndexNames", required = true)
        protected Market.BaseCorrelations.IndexNames indexNames;
        @XmlElement(name = "Terms")
        protected List<String> terms;
        @XmlElement(name = "DetachmentPoints")
        protected List<String> detachmentPoints;
        @XmlElement(name = "DayCounters")
        protected Market.BaseCorrelations.DayCounters dayCounters;

        /**
         * Gets the value of the simulate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the simulate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSimulate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSimulate() {
            if (simulate == null) {
                simulate = new ArrayList<String>();
            }
            return this.simulate;
        }

        /**
         * indexNames 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.BaseCorrelations.IndexNames }
         *     
         */
        public Market.BaseCorrelations.IndexNames getIndexNames() {
            return indexNames;
        }

        /**
         * indexNames 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.BaseCorrelations.IndexNames }
         *     
         */
        public void setIndexNames(Market.BaseCorrelations.IndexNames value) {
            this.indexNames = value;
        }

        /**
         * Gets the value of the terms property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the terms property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTerms().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getTerms() {
            if (terms == null) {
                terms = new ArrayList<String>();
            }
            return this.terms;
        }

        /**
         * Gets the value of the detachmentPoints property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the detachmentPoints property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDetachmentPoints().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDetachmentPoints() {
            if (detachmentPoints == null) {
                detachmentPoints = new ArrayList<String>();
            }
            return this.detachmentPoints;
        }

        /**
         * dayCounters 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.BaseCorrelations.DayCounters }
         *     
         */
        public Market.BaseCorrelations.DayCounters getDayCounters() {
            return dayCounters;
        }

        /**
         * dayCounters 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.BaseCorrelations.DayCounters }
         *     
         */
        public void setDayCounters(Market.BaseCorrelations.DayCounters value) {
            this.dayCounters = value;
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
         *       &lt;sequence>
         *         &lt;element name="DayCounter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dayCounter"
        })
        public static class DayCounters {

            @XmlElement(name = "DayCounter", required = true)
            protected List<Market.BaseCorrelations.DayCounters.DayCounter> dayCounter;

            /**
             * Gets the value of the dayCounter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dayCounter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDayCounter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.BaseCorrelations.DayCounters.DayCounter }
             * 
             * 
             */
            public List<Market.BaseCorrelations.DayCounters.DayCounter> getDayCounter() {
                if (dayCounter == null) {
                    dayCounter = new ArrayList<Market.BaseCorrelations.DayCounters.DayCounter>();
                }
                return this.dayCounter;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class DayCounter {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * name 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * name 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

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
         *       &lt;sequence>
         *         &lt;element name="IndexName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "indexName"
        })
        public static class IndexNames {

            @XmlElement(name = "IndexName")
            protected List<String> indexName;

            /**
             * Gets the value of the indexName property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the indexName property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getIndexName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getIndexName() {
                if (indexName == null) {
                    indexName = new ArrayList<String>();
                }
                return this.indexName;
            }

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
     *       &lt;sequence>
     *         &lt;element name="BenchmarkCurve" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Currency" type="{}currencyCode"/>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "benchmarkCurve"
    })
    public static class BenchmarkCurves {

        @XmlElement(name = "BenchmarkCurve")
        protected List<Market.BenchmarkCurves.BenchmarkCurve> benchmarkCurve;

        /**
         * Gets the value of the benchmarkCurve property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the benchmarkCurve property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBenchmarkCurve().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.BenchmarkCurves.BenchmarkCurve }
         * 
         * 
         */
        public List<Market.BenchmarkCurves.BenchmarkCurve> getBenchmarkCurve() {
            if (benchmarkCurve == null) {
                benchmarkCurve = new ArrayList<Market.BenchmarkCurves.BenchmarkCurve>();
            }
            return this.benchmarkCurve;
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
         *         &lt;element name="Currency" type="{}currencyCode"/>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        public static class BenchmarkCurve {

            @XmlElement(name = "Currency", required = true)
            @XmlSchemaType(name = "string")
            protected CurrencyCode currency;
            @XmlElement(name = "Name", required = true)
            protected String name;

            /**
             * currency 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link CurrencyCode }
             *     
             */
            public CurrencyCode getCurrency() {
                return currency;
            }

            /**
             * currency 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link CurrencyCode }
             *     
             */
            public void setCurrency(CurrencyCode value) {
                this.currency = value;
            }

            /**
             * name 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * name 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
     *         &lt;element name="Names">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulate",
        "reactionToTimeDecay",
        "names",
        "expiries",
        "smileDynamics"
    })
    public static class CDSVolatilities {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "ReactionToTimeDecay", required = true)
        @XmlSchemaType(name = "string")
        protected TimeDecayType reactionToTimeDecay;
        @XmlElement(name = "Names", required = true)
        protected Market.CDSVolatilities.Names names;
        @XmlElement(name = "Expiries", required = true)
        protected String expiries;
        @XmlElement(name = "SmileDynamics")
        protected List<Market.CDSVolatilities.SmileDynamics> smileDynamics;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * reactionToTimeDecay 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link TimeDecayType }
         *     
         */
        public TimeDecayType getReactionToTimeDecay() {
            return reactionToTimeDecay;
        }

        /**
         * reactionToTimeDecay 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link TimeDecayType }
         *     
         */
        public void setReactionToTimeDecay(TimeDecayType value) {
            this.reactionToTimeDecay = value;
        }

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.CDSVolatilities.Names }
         *     
         */
        public Market.CDSVolatilities.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.CDSVolatilities.Names }
         *     
         */
        public void setNames(Market.CDSVolatilities.Names value) {
            this.names = value;
        }

        /**
         * expiries 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExpiries() {
            return expiries;
        }

        /**
         * expiries 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExpiries(String value) {
            this.expiries = value;
        }

        /**
         * Gets the value of the smileDynamics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the smileDynamics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSmileDynamics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.CDSVolatilities.SmileDynamics }
         * 
         * 
         */
        public List<Market.CDSVolatilities.SmileDynamics> getSmileDynamics() {
            if (smileDynamics == null) {
                smileDynamics = new ArrayList<Market.CDSVolatilities.SmileDynamics>();
            }
            return this.smileDynamics;
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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SmileDynamics {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
     *         &lt;element name="Names">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulate",
        "reactionToTimeDecay",
        "names",
        "expiries",
        "strikes",
        "smileDynamics"
    })
    public static class CPICapFloorVolatilities {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "ReactionToTimeDecay", required = true)
        @XmlSchemaType(name = "string")
        protected TimeDecayType reactionToTimeDecay;
        @XmlElement(name = "Names", required = true)
        protected Market.CPICapFloorVolatilities.Names names;
        @XmlElement(name = "Expiries", required = true)
        protected String expiries;
        @XmlElement(name = "Strikes", required = true)
        protected String strikes;
        @XmlElement(name = "SmileDynamics")
        protected List<Market.CPICapFloorVolatilities.SmileDynamics> smileDynamics;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * reactionToTimeDecay 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link TimeDecayType }
         *     
         */
        public TimeDecayType getReactionToTimeDecay() {
            return reactionToTimeDecay;
        }

        /**
         * reactionToTimeDecay 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link TimeDecayType }
         *     
         */
        public void setReactionToTimeDecay(TimeDecayType value) {
            this.reactionToTimeDecay = value;
        }

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.CPICapFloorVolatilities.Names }
         *     
         */
        public Market.CPICapFloorVolatilities.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.CPICapFloorVolatilities.Names }
         *     
         */
        public void setNames(Market.CPICapFloorVolatilities.Names value) {
            this.names = value;
        }

        /**
         * expiries 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExpiries() {
            return expiries;
        }

        /**
         * expiries 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExpiries(String value) {
            this.expiries = value;
        }

        /**
         * strikes 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStrikes() {
            return strikes;
        }

        /**
         * strikes 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStrikes(String value) {
            this.strikes = value;
        }

        /**
         * Gets the value of the smileDynamics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the smileDynamics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSmileDynamics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.CPICapFloorVolatilities.SmileDynamics }
         * 
         * 
         */
        public List<Market.CPICapFloorVolatilities.SmileDynamics> getSmileDynamics() {
            if (smileDynamics == null) {
                smileDynamics = new ArrayList<Market.CPICapFloorVolatilities.SmileDynamics>();
            }
            return this.smileDynamics;
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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SmileDynamics {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

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
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="Names" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
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
    @XmlType(name = "", propOrder = {

    })
    public static class CPRs {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "Names")
        protected Market.CPRs.Names names;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.CPRs.Names }
         *     
         */
        public Market.CPRs.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.CPRs.Names }
         *     
         */
        public void setNames(Market.CPRs.Names value) {
            this.names = value;
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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
     *         &lt;element name="Keys" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Currencies" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Expiries" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Strikes" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DayCounters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DayCounter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="AdjustOptionletPillars" type="{}bool" minOccurs="0"/>
     *         &lt;element name="UseCapAtm" type="{}bool" minOccurs="0"/>
     *         &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulate",
        "reactionToTimeDecay",
        "keys",
        "currencies",
        "expiries",
        "strikes",
        "dayCounters",
        "adjustOptionletPillars",
        "useCapAtm",
        "smileDynamics"
    })
    public static class CapFloorVolatilities {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "ReactionToTimeDecay", required = true)
        @XmlSchemaType(name = "string")
        protected TimeDecayType reactionToTimeDecay;
        @XmlElement(name = "Keys")
        protected Market.CapFloorVolatilities.Keys keys;
        @XmlElement(name = "Currencies")
        protected Market.CapFloorVolatilities.Currencies currencies;
        @XmlElement(name = "Expiries")
        protected List<Market.CapFloorVolatilities.Expiries> expiries;
        @XmlElement(name = "Strikes")
        protected List<Market.CapFloorVolatilities.Strikes> strikes;
        @XmlElement(name = "DayCounters")
        protected Market.CapFloorVolatilities.DayCounters dayCounters;
        @XmlElement(name = "AdjustOptionletPillars")
        protected String adjustOptionletPillars;
        @XmlElement(name = "UseCapAtm")
        protected String useCapAtm;
        @XmlElement(name = "SmileDynamics")
        protected List<Market.CapFloorVolatilities.SmileDynamics> smileDynamics;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * reactionToTimeDecay 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link TimeDecayType }
         *     
         */
        public TimeDecayType getReactionToTimeDecay() {
            return reactionToTimeDecay;
        }

        /**
         * reactionToTimeDecay 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link TimeDecayType }
         *     
         */
        public void setReactionToTimeDecay(TimeDecayType value) {
            this.reactionToTimeDecay = value;
        }

        /**
         * keys 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.CapFloorVolatilities.Keys }
         *     
         */
        public Market.CapFloorVolatilities.Keys getKeys() {
            return keys;
        }

        /**
         * keys 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.CapFloorVolatilities.Keys }
         *     
         */
        public void setKeys(Market.CapFloorVolatilities.Keys value) {
            this.keys = value;
        }

        /**
         * currencies 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.CapFloorVolatilities.Currencies }
         *     
         */
        public Market.CapFloorVolatilities.Currencies getCurrencies() {
            return currencies;
        }

        /**
         * currencies 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.CapFloorVolatilities.Currencies }
         *     
         */
        public void setCurrencies(Market.CapFloorVolatilities.Currencies value) {
            this.currencies = value;
        }

        /**
         * Gets the value of the expiries property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the expiries property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExpiries().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.CapFloorVolatilities.Expiries }
         * 
         * 
         */
        public List<Market.CapFloorVolatilities.Expiries> getExpiries() {
            if (expiries == null) {
                expiries = new ArrayList<Market.CapFloorVolatilities.Expiries>();
            }
            return this.expiries;
        }

        /**
         * Gets the value of the strikes property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the strikes property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStrikes().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.CapFloorVolatilities.Strikes }
         * 
         * 
         */
        public List<Market.CapFloorVolatilities.Strikes> getStrikes() {
            if (strikes == null) {
                strikes = new ArrayList<Market.CapFloorVolatilities.Strikes>();
            }
            return this.strikes;
        }

        /**
         * dayCounters 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.CapFloorVolatilities.DayCounters }
         *     
         */
        public Market.CapFloorVolatilities.DayCounters getDayCounters() {
            return dayCounters;
        }

        /**
         * dayCounters 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.CapFloorVolatilities.DayCounters }
         *     
         */
        public void setDayCounters(Market.CapFloorVolatilities.DayCounters value) {
            this.dayCounters = value;
        }

        /**
         * adjustOptionletPillars 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdjustOptionletPillars() {
            return adjustOptionletPillars;
        }

        /**
         * adjustOptionletPillars 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdjustOptionletPillars(String value) {
            this.adjustOptionletPillars = value;
        }

        /**
         * useCapAtm 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUseCapAtm() {
            return useCapAtm;
        }

        /**
         * useCapAtm 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUseCapAtm(String value) {
            this.useCapAtm = value;
        }

        /**
         * Gets the value of the smileDynamics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the smileDynamics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSmileDynamics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.CapFloorVolatilities.SmileDynamics }
         * 
         * 
         */
        public List<Market.CapFloorVolatilities.SmileDynamics> getSmileDynamics() {
            if (smileDynamics == null) {
                smileDynamics = new ArrayList<Market.CapFloorVolatilities.SmileDynamics>();
            }
            return this.smileDynamics;
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
         *       &lt;sequence>
         *         &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "currency"
        })
        public static class Currencies {

            @XmlElement(name = "Currency")
            @XmlSchemaType(name = "string")
            protected List<CurrencyCode> currency;

            /**
             * Gets the value of the currency property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the currency property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCurrency().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link CurrencyCode }
             * 
             * 
             */
            public List<CurrencyCode> getCurrency() {
                if (currency == null) {
                    currency = new ArrayList<CurrencyCode>();
                }
                return this.currency;
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
         *       &lt;sequence>
         *         &lt;element name="DayCounter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dayCounter"
        })
        public static class DayCounters {

            @XmlElement(name = "DayCounter", required = true)
            protected List<Market.CapFloorVolatilities.DayCounters.DayCounter> dayCounter;

            /**
             * Gets the value of the dayCounter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dayCounter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDayCounter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.CapFloorVolatilities.DayCounters.DayCounter }
             * 
             * 
             */
            public List<Market.CapFloorVolatilities.DayCounters.DayCounter> getDayCounter() {
                if (dayCounter == null) {
                    dayCounter = new ArrayList<Market.CapFloorVolatilities.DayCounters.DayCounter>();
                }
                return this.dayCounter;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class DayCounter {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "ccy")
                protected String ccy;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * ccy 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCcy() {
                    return ccy;
                }

                /**
                 * ccy 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCcy(String value) {
                    this.ccy = value;
                }

            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Expiries {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;
            @XmlAttribute(name = "ccy")
            protected String ccy;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * ccy 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCcy() {
                return ccy;
            }

            /**
             * ccy 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCcy(String value) {
                this.ccy = value;
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
         *       &lt;sequence>
         *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key"
        })
        public static class Keys {

            @XmlElement(name = "Key")
            protected List<String> key;

            /**
             * Gets the value of the key property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the key property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getKey().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getKey() {
                if (key == null) {
                    key = new ArrayList<String>();
                }
                return this.key;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SmileDynamics {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Strikes {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;
            @XmlAttribute(name = "ccy")
            protected String ccy;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * ccy 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCcy() {
                return ccy;
            }

            /**
             * ccy 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCcy(String value) {
                this.ccy = value;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="Names">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Tenors" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DayCounters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DayCounter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulate",
        "names",
        "tenors",
        "dayCounters"
    })
    public static class Commodities {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "Names", required = true)
        protected Market.Commodities.Names names;
        @XmlElement(name = "Tenors", required = true)
        protected List<Market.Commodities.Tenors> tenors;
        @XmlElement(name = "DayCounters")
        protected Market.Commodities.DayCounters dayCounters;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.Commodities.Names }
         *     
         */
        public Market.Commodities.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.Commodities.Names }
         *     
         */
        public void setNames(Market.Commodities.Names value) {
            this.names = value;
        }

        /**
         * Gets the value of the tenors property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tenors property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTenors().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.Commodities.Tenors }
         * 
         * 
         */
        public List<Market.Commodities.Tenors> getTenors() {
            if (tenors == null) {
                tenors = new ArrayList<Market.Commodities.Tenors>();
            }
            return this.tenors;
        }

        /**
         * dayCounters 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.Commodities.DayCounters }
         *     
         */
        public Market.Commodities.DayCounters getDayCounters() {
            return dayCounters;
        }

        /**
         * dayCounters 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.Commodities.DayCounters }
         *     
         */
        public void setDayCounters(Market.Commodities.DayCounters value) {
            this.dayCounters = value;
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
         *       &lt;sequence>
         *         &lt;element name="DayCounter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dayCounter"
        })
        public static class DayCounters {

            @XmlElement(name = "DayCounter", required = true)
            protected List<Market.Commodities.DayCounters.DayCounter> dayCounter;

            /**
             * Gets the value of the dayCounter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dayCounter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDayCounter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.Commodities.DayCounters.DayCounter }
             * 
             * 
             */
            public List<Market.Commodities.DayCounters.DayCounter> getDayCounter() {
                if (dayCounter == null) {
                    dayCounter = new ArrayList<Market.Commodities.DayCounters.DayCounter>();
                }
                return this.dayCounter;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class DayCounter {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * name 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * name 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Tenors {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "name")
            protected String name;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * name 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * name 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="SimulateATMOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
     *         &lt;element name="Names">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;all>
     *                             &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Moneyness" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                           &lt;/all>
     *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DayCounter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulate",
        "simulateATMOnly",
        "reactionToTimeDecay",
        "names",
        "dayCounter",
        "smileDynamics"
    })
    public static class CommodityVolatilities {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "SimulateATMOnly")
        protected Boolean simulateATMOnly;
        @XmlElement(name = "ReactionToTimeDecay", required = true)
        @XmlSchemaType(name = "string")
        protected TimeDecayType reactionToTimeDecay;
        @XmlElement(name = "Names", required = true)
        protected Market.CommodityVolatilities.Names names;
        @XmlElement(name = "DayCounter")
        protected String dayCounter;
        @XmlElement(name = "SmileDynamics")
        protected List<Market.CommodityVolatilities.SmileDynamics> smileDynamics;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * simulateATMOnly 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSimulateATMOnly() {
            return simulateATMOnly;
        }

        /**
         * simulateATMOnly 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSimulateATMOnly(Boolean value) {
            this.simulateATMOnly = value;
        }

        /**
         * reactionToTimeDecay 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link TimeDecayType }
         *     
         */
        public TimeDecayType getReactionToTimeDecay() {
            return reactionToTimeDecay;
        }

        /**
         * reactionToTimeDecay 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link TimeDecayType }
         *     
         */
        public void setReactionToTimeDecay(TimeDecayType value) {
            this.reactionToTimeDecay = value;
        }

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.CommodityVolatilities.Names }
         *     
         */
        public Market.CommodityVolatilities.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.CommodityVolatilities.Names }
         *     
         */
        public void setNames(Market.CommodityVolatilities.Names value) {
            this.names = value;
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
         * Gets the value of the smileDynamics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the smileDynamics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSmileDynamics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.CommodityVolatilities.SmileDynamics }
         * 
         * 
         */
        public List<Market.CommodityVolatilities.SmileDynamics> getSmileDynamics() {
            if (smileDynamics == null) {
                smileDynamics = new ArrayList<Market.CommodityVolatilities.SmileDynamics>();
            }
            return this.smileDynamics;
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
         *       &lt;sequence>
         *         &lt;element name="Name" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;all>
         *                   &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Moneyness" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                 &lt;/all>
         *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name", required = true)
            protected List<Market.CommodityVolatilities.Names.Name> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.CommodityVolatilities.Names.Name }
             * 
             * 
             */
            public List<Market.CommodityVolatilities.Names.Name> getName() {
                if (name == null) {
                    name = new ArrayList<Market.CommodityVolatilities.Names.Name>();
                }
                return this.name;
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
             *         &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Moneyness" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *       &lt;/all>
             *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            public static class Name {

                @XmlElement(name = "Expiries", required = true)
                protected String expiries;
                @XmlElement(name = "Moneyness")
                protected String moneyness;
                @XmlAttribute(name = "id")
                protected String id;

                /**
                 * expiries 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExpiries() {
                    return expiries;
                }

                /**
                 * expiries 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExpiries(String value) {
                    this.expiries = value;
                }

                /**
                 * moneyness 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMoneyness() {
                    return moneyness;
                }

                /**
                 * moneyness 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMoneyness(String value) {
                    this.moneyness = value;
                }

                /**
                 * id 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getId() {
                    return id;
                }

                /**
                 * id 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setId(String value) {
                    this.id = value;
                }

            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SmileDynamics {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

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
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="Pairs">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Pair" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    public static class Correlations {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "Pairs", required = true)
        protected Market.Correlations.Pairs pairs;
        @XmlElement(name = "Expiries", required = true)
        protected String expiries;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * pairs 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.Correlations.Pairs }
         *     
         */
        public Market.Correlations.Pairs getPairs() {
            return pairs;
        }

        /**
         * pairs 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.Correlations.Pairs }
         *     
         */
        public void setPairs(Market.Correlations.Pairs value) {
            this.pairs = value;
        }

        /**
         * expiries 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExpiries() {
            return expiries;
        }

        /**
         * expiries 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExpiries(String value) {
            this.expiries = value;
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
         *       &lt;sequence>
         *         &lt;element name="Pair" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "pair"
        })
        public static class Pairs {

            @XmlElement(name = "Pair")
            protected List<String> pair;

            /**
             * Gets the value of the pair property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the pair property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPair().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getPair() {
                if (pair == null) {
                    pair = new ArrayList<String>();
                }
                return this.pair;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "index"
    })
    public static class CpiIndices {

        @XmlElement(name = "Index")
        protected List<String> index;

        /**
         * Gets the value of the index property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the index property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIndex().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getIndex() {
            if (index == null) {
                index = new ArrayList<String>();
            }
            return this.index;
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
     *       &lt;sequence>
     *         &lt;element name="NumberOfFactors" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "numberOfFactors"
    })
    public static class CreditStates {

        @XmlElement(name = "NumberOfFactors", required = true)
        protected String numberOfFactors;

        /**
         * numberOfFactors 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumberOfFactors() {
            return numberOfFactors;
        }

        /**
         * numberOfFactors 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumberOfFactors(String value) {
            this.numberOfFactors = value;
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
     *       &lt;sequence>
     *         &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "currency"
    })
    public static class Currencies {

        @XmlElement(name = "Currency", required = true)
        @XmlSchemaType(name = "string")
        protected List<CurrencyCode> currency;

        /**
         * Gets the value of the currency property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the currency property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCurrency().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CurrencyCode }
         * 
         * 
         */
        public List<CurrencyCode> getCurrency() {
            if (currency == null) {
                currency = new ArrayList<CurrencyCode>();
            }
            return this.currency;
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
     *         &lt;element name="Names">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Tenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="SimulateSurvivalProbabilities" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="SimulateRecoveryRates" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="DayCounters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DayCounter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Calendars" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Calendar" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Extrapolation" type="{}defaultCurveExtrapolation" minOccurs="0"/>
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
    public static class DefaultCurves {

        @XmlElement(name = "Names", required = true)
        protected Market.DefaultCurves.Names names;
        @XmlElement(name = "Tenors", required = true)
        protected String tenors;
        @XmlElement(name = "SimulateSurvivalProbabilities")
        protected Boolean simulateSurvivalProbabilities;
        @XmlElement(name = "SimulateRecoveryRates")
        protected Boolean simulateRecoveryRates;
        @XmlElement(name = "DayCounters")
        protected Market.DefaultCurves.DayCounters dayCounters;
        @XmlElement(name = "Calendars")
        protected Market.DefaultCurves.Calendars calendars;
        @XmlElement(name = "Extrapolation")
        @XmlSchemaType(name = "string")
        protected DefaultCurveExtrapolation extrapolation;

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.DefaultCurves.Names }
         *     
         */
        public Market.DefaultCurves.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.DefaultCurves.Names }
         *     
         */
        public void setNames(Market.DefaultCurves.Names value) {
            this.names = value;
        }

        /**
         * tenors 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTenors() {
            return tenors;
        }

        /**
         * tenors 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTenors(String value) {
            this.tenors = value;
        }

        /**
         * simulateSurvivalProbabilities 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSimulateSurvivalProbabilities() {
            return simulateSurvivalProbabilities;
        }

        /**
         * simulateSurvivalProbabilities 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSimulateSurvivalProbabilities(Boolean value) {
            this.simulateSurvivalProbabilities = value;
        }

        /**
         * simulateRecoveryRates 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSimulateRecoveryRates() {
            return simulateRecoveryRates;
        }

        /**
         * simulateRecoveryRates 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSimulateRecoveryRates(Boolean value) {
            this.simulateRecoveryRates = value;
        }

        /**
         * dayCounters 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.DefaultCurves.DayCounters }
         *     
         */
        public Market.DefaultCurves.DayCounters getDayCounters() {
            return dayCounters;
        }

        /**
         * dayCounters 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.DefaultCurves.DayCounters }
         *     
         */
        public void setDayCounters(Market.DefaultCurves.DayCounters value) {
            this.dayCounters = value;
        }

        /**
         * calendars 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.DefaultCurves.Calendars }
         *     
         */
        public Market.DefaultCurves.Calendars getCalendars() {
            return calendars;
        }

        /**
         * calendars 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.DefaultCurves.Calendars }
         *     
         */
        public void setCalendars(Market.DefaultCurves.Calendars value) {
            this.calendars = value;
        }

        /**
         * extrapolation 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link DefaultCurveExtrapolation }
         *     
         */
        public DefaultCurveExtrapolation getExtrapolation() {
            return extrapolation;
        }

        /**
         * extrapolation 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link DefaultCurveExtrapolation }
         *     
         */
        public void setExtrapolation(DefaultCurveExtrapolation value) {
            this.extrapolation = value;
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
         *       &lt;sequence>
         *         &lt;element name="Calendar" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "calendar"
        })
        public static class Calendars {

            @XmlElement(name = "Calendar", required = true)
            protected List<Market.DefaultCurves.Calendars.Calendar> calendar;

            /**
             * Gets the value of the calendar property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the calendar property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCalendar().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.DefaultCurves.Calendars.Calendar }
             * 
             * 
             */
            public List<Market.DefaultCurves.Calendars.Calendar> getCalendar() {
                if (calendar == null) {
                    calendar = new ArrayList<Market.DefaultCurves.Calendars.Calendar>();
                }
                return this.calendar;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Calendar {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * name 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * name 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

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
         *       &lt;sequence>
         *         &lt;element name="DayCounter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dayCounter"
        })
        public static class DayCounters {

            @XmlElement(name = "DayCounter", required = true)
            protected List<Market.DefaultCurves.DayCounters.DayCounter> dayCounter;

            /**
             * Gets the value of the dayCounter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dayCounter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDayCounter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.DefaultCurves.DayCounters.DayCounter }
             * 
             * 
             */
            public List<Market.DefaultCurves.DayCounters.DayCounter> getDayCounter() {
                if (dayCounter == null) {
                    dayCounter = new ArrayList<Market.DefaultCurves.DayCounters.DayCounter>();
                }
                return this.dayCounter;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class DayCounter {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * name 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * name 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

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
     *         &lt;element name="SimulateEquityForecastCurve" type="{}bool" minOccurs="0"/>
     *         &lt;element name="SimulateDividendYield" type="{}bool" minOccurs="0"/>
     *         &lt;element name="Names">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DividendTenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    public static class Equities {

        @XmlElement(name = "SimulateEquityForecastCurve")
        protected String simulateEquityForecastCurve;
        @XmlElement(name = "SimulateDividendYield")
        protected String simulateDividendYield;
        @XmlElement(name = "Names", required = true)
        protected Market.Equities.Names names;
        @XmlElement(name = "DividendTenors", required = true)
        protected String dividendTenors;

        /**
         * simulateEquityForecastCurve 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulateEquityForecastCurve() {
            return simulateEquityForecastCurve;
        }

        /**
         * simulateEquityForecastCurve 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulateEquityForecastCurve(String value) {
            this.simulateEquityForecastCurve = value;
        }

        /**
         * simulateDividendYield 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulateDividendYield() {
            return simulateDividendYield;
        }

        /**
         * simulateDividendYield 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulateDividendYield(String value) {
            this.simulateDividendYield = value;
        }

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.Equities.Names }
         *     
         */
        public Market.Equities.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.Equities.Names }
         *     
         */
        public void setNames(Market.Equities.Names value) {
            this.names = value;
        }

        /**
         * dividendTenors 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDividendTenors() {
            return dividendTenors;
        }

        /**
         * dividendTenors 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDividendTenors(String value) {
            this.dividendTenors = value;
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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
     *         &lt;element name="Names">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Expiries" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SimulateATMOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="Surface" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Moneyness" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="StandardDeviations" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DayCounters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DayCounter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulate",
        "reactionToTimeDecay",
        "names",
        "expiries",
        "simulateATMOnly",
        "surface",
        "dayCounters",
        "smileDynamics"
    })
    public static class EquityVolatilities {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "ReactionToTimeDecay", required = true)
        @XmlSchemaType(name = "string")
        protected TimeDecayType reactionToTimeDecay;
        @XmlElement(name = "Names", required = true)
        protected Market.EquityVolatilities.Names names;
        @XmlElement(name = "Expiries")
        protected List<Market.EquityVolatilities.Expiries> expiries;
        @XmlElement(name = "SimulateATMOnly")
        protected Boolean simulateATMOnly;
        @XmlElement(name = "Surface")
        protected Market.EquityVolatilities.Surface surface;
        @XmlElement(name = "DayCounters")
        protected Market.EquityVolatilities.DayCounters dayCounters;
        @XmlElement(name = "SmileDynamics")
        protected List<Market.EquityVolatilities.SmileDynamics> smileDynamics;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * reactionToTimeDecay 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link TimeDecayType }
         *     
         */
        public TimeDecayType getReactionToTimeDecay() {
            return reactionToTimeDecay;
        }

        /**
         * reactionToTimeDecay 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link TimeDecayType }
         *     
         */
        public void setReactionToTimeDecay(TimeDecayType value) {
            this.reactionToTimeDecay = value;
        }

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.EquityVolatilities.Names }
         *     
         */
        public Market.EquityVolatilities.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.EquityVolatilities.Names }
         *     
         */
        public void setNames(Market.EquityVolatilities.Names value) {
            this.names = value;
        }

        /**
         * Gets the value of the expiries property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the expiries property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExpiries().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.EquityVolatilities.Expiries }
         * 
         * 
         */
        public List<Market.EquityVolatilities.Expiries> getExpiries() {
            if (expiries == null) {
                expiries = new ArrayList<Market.EquityVolatilities.Expiries>();
            }
            return this.expiries;
        }

        /**
         * simulateATMOnly 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSimulateATMOnly() {
            return simulateATMOnly;
        }

        /**
         * simulateATMOnly 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSimulateATMOnly(Boolean value) {
            this.simulateATMOnly = value;
        }

        /**
         * surface 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.EquityVolatilities.Surface }
         *     
         */
        public Market.EquityVolatilities.Surface getSurface() {
            return surface;
        }

        /**
         * surface 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.EquityVolatilities.Surface }
         *     
         */
        public void setSurface(Market.EquityVolatilities.Surface value) {
            this.surface = value;
        }

        /**
         * dayCounters 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.EquityVolatilities.DayCounters }
         *     
         */
        public Market.EquityVolatilities.DayCounters getDayCounters() {
            return dayCounters;
        }

        /**
         * dayCounters 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.EquityVolatilities.DayCounters }
         *     
         */
        public void setDayCounters(Market.EquityVolatilities.DayCounters value) {
            this.dayCounters = value;
        }

        /**
         * Gets the value of the smileDynamics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the smileDynamics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSmileDynamics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.EquityVolatilities.SmileDynamics }
         * 
         * 
         */
        public List<Market.EquityVolatilities.SmileDynamics> getSmileDynamics() {
            if (smileDynamics == null) {
                smileDynamics = new ArrayList<Market.EquityVolatilities.SmileDynamics>();
            }
            return this.smileDynamics;
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
         *       &lt;sequence>
         *         &lt;element name="DayCounter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dayCounter"
        })
        public static class DayCounters {

            @XmlElement(name = "DayCounter", required = true)
            protected List<Market.EquityVolatilities.DayCounters.DayCounter> dayCounter;

            /**
             * Gets the value of the dayCounter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dayCounter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDayCounter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.EquityVolatilities.DayCounters.DayCounter }
             * 
             * 
             */
            public List<Market.EquityVolatilities.DayCounters.DayCounter> getDayCounter() {
                if (dayCounter == null) {
                    dayCounter = new ArrayList<Market.EquityVolatilities.DayCounters.DayCounter>();
                }
                return this.dayCounter;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class DayCounter {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * name 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * name 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Expiries {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "name")
            protected String name;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * name 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * name 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SmileDynamics {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
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
         *       &lt;sequence>
         *         &lt;element name="Moneyness" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="StandardDeviations" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "moneyness",
            "standardDeviations"
        })
        public static class Surface {

            @XmlElement(name = "Moneyness")
            protected List<Market.EquityVolatilities.Surface.Moneyness> moneyness;
            @XmlElement(name = "StandardDeviations")
            protected List<Market.EquityVolatilities.Surface.StandardDeviations> standardDeviations;

            /**
             * Gets the value of the moneyness property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the moneyness property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getMoneyness().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.EquityVolatilities.Surface.Moneyness }
             * 
             * 
             */
            public List<Market.EquityVolatilities.Surface.Moneyness> getMoneyness() {
                if (moneyness == null) {
                    moneyness = new ArrayList<Market.EquityVolatilities.Surface.Moneyness>();
                }
                return this.moneyness;
            }

            /**
             * Gets the value of the standardDeviations property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the standardDeviations property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getStandardDeviations().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.EquityVolatilities.Surface.StandardDeviations }
             * 
             * 
             */
            public List<Market.EquityVolatilities.Surface.StandardDeviations> getStandardDeviations() {
                if (standardDeviations == null) {
                    standardDeviations = new ArrayList<Market.EquityVolatilities.Surface.StandardDeviations>();
                }
                return this.standardDeviations;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Moneyness {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * name 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * name 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class StandardDeviations {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * name 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * name 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

            }

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
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="CurrencyPairs" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CurrencyPair" type="{}currencyPair" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
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
    @XmlType(name = "", propOrder = {

    })
    public static class FxRates {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "CurrencyPairs")
        protected Market.FxRates.CurrencyPairs currencyPairs;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * currencyPairs 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.FxRates.CurrencyPairs }
         *     
         */
        public Market.FxRates.CurrencyPairs getCurrencyPairs() {
            return currencyPairs;
        }

        /**
         * currencyPairs 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.FxRates.CurrencyPairs }
         *     
         */
        public void setCurrencyPairs(Market.FxRates.CurrencyPairs value) {
            this.currencyPairs = value;
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
         *       &lt;sequence>
         *         &lt;element name="CurrencyPair" type="{}currencyPair" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "currencyPair"
        })
        public static class CurrencyPairs {

            @XmlElement(name = "CurrencyPair")
            protected List<String> currencyPair;

            /**
             * Gets the value of the currencyPair property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the currencyPair property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCurrencyPair().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getCurrencyPair() {
                if (currencyPair == null) {
                    currencyPair = new ArrayList<String>();
                }
                return this.currencyPair;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="ReactionToTimeDecay" type="{}timeDecayType" minOccurs="0"/>
     *         &lt;element name="CurrencyPairs" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CurrencyPair" type="{}currencyPair" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Expiries" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SimulateATMOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="Surface" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="Moneyness" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="StandardDeviations" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DayCounters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DayCounter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulate",
        "reactionToTimeDecay",
        "currencyPairs",
        "expiries",
        "simulateATMOnly",
        "surface",
        "dayCounters",
        "smileDynamics"
    })
    public static class FxVolatilities {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "ReactionToTimeDecay")
        @XmlSchemaType(name = "string")
        protected TimeDecayType reactionToTimeDecay;
        @XmlElement(name = "CurrencyPairs")
        protected Market.FxVolatilities.CurrencyPairs currencyPairs;
        @XmlElement(name = "Expiries")
        protected List<Market.FxVolatilities.Expiries> expiries;
        @XmlElement(name = "SimulateATMOnly")
        protected Boolean simulateATMOnly;
        @XmlElement(name = "Surface")
        protected Market.FxVolatilities.Surface surface;
        @XmlElement(name = "DayCounters")
        protected Market.FxVolatilities.DayCounters dayCounters;
        @XmlElement(name = "SmileDynamics")
        protected List<Market.FxVolatilities.SmileDynamics> smileDynamics;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * reactionToTimeDecay 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link TimeDecayType }
         *     
         */
        public TimeDecayType getReactionToTimeDecay() {
            return reactionToTimeDecay;
        }

        /**
         * reactionToTimeDecay 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link TimeDecayType }
         *     
         */
        public void setReactionToTimeDecay(TimeDecayType value) {
            this.reactionToTimeDecay = value;
        }

        /**
         * currencyPairs 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.FxVolatilities.CurrencyPairs }
         *     
         */
        public Market.FxVolatilities.CurrencyPairs getCurrencyPairs() {
            return currencyPairs;
        }

        /**
         * currencyPairs 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.FxVolatilities.CurrencyPairs }
         *     
         */
        public void setCurrencyPairs(Market.FxVolatilities.CurrencyPairs value) {
            this.currencyPairs = value;
        }

        /**
         * Gets the value of the expiries property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the expiries property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExpiries().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.FxVolatilities.Expiries }
         * 
         * 
         */
        public List<Market.FxVolatilities.Expiries> getExpiries() {
            if (expiries == null) {
                expiries = new ArrayList<Market.FxVolatilities.Expiries>();
            }
            return this.expiries;
        }

        /**
         * simulateATMOnly 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSimulateATMOnly() {
            return simulateATMOnly;
        }

        /**
         * simulateATMOnly 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSimulateATMOnly(Boolean value) {
            this.simulateATMOnly = value;
        }

        /**
         * surface 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.FxVolatilities.Surface }
         *     
         */
        public Market.FxVolatilities.Surface getSurface() {
            return surface;
        }

        /**
         * surface 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.FxVolatilities.Surface }
         *     
         */
        public void setSurface(Market.FxVolatilities.Surface value) {
            this.surface = value;
        }

        /**
         * dayCounters 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.FxVolatilities.DayCounters }
         *     
         */
        public Market.FxVolatilities.DayCounters getDayCounters() {
            return dayCounters;
        }

        /**
         * dayCounters 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.FxVolatilities.DayCounters }
         *     
         */
        public void setDayCounters(Market.FxVolatilities.DayCounters value) {
            this.dayCounters = value;
        }

        /**
         * Gets the value of the smileDynamics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the smileDynamics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSmileDynamics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.FxVolatilities.SmileDynamics }
         * 
         * 
         */
        public List<Market.FxVolatilities.SmileDynamics> getSmileDynamics() {
            if (smileDynamics == null) {
                smileDynamics = new ArrayList<Market.FxVolatilities.SmileDynamics>();
            }
            return this.smileDynamics;
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
         *       &lt;sequence>
         *         &lt;element name="CurrencyPair" type="{}currencyPair" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "currencyPair"
        })
        public static class CurrencyPairs {

            @XmlElement(name = "CurrencyPair")
            protected List<String> currencyPair;

            /**
             * Gets the value of the currencyPair property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the currencyPair property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCurrencyPair().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getCurrencyPair() {
                if (currencyPair == null) {
                    currencyPair = new ArrayList<String>();
                }
                return this.currencyPair;
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
         *       &lt;sequence>
         *         &lt;element name="DayCounter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dayCounter"
        })
        public static class DayCounters {

            @XmlElement(name = "DayCounter", required = true)
            protected List<Market.FxVolatilities.DayCounters.DayCounter> dayCounter;

            /**
             * Gets the value of the dayCounter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dayCounter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDayCounter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.FxVolatilities.DayCounters.DayCounter }
             * 
             * 
             */
            public List<Market.FxVolatilities.DayCounters.DayCounter> getDayCounter() {
                if (dayCounter == null) {
                    dayCounter = new ArrayList<Market.FxVolatilities.DayCounters.DayCounter>();
                }
                return this.dayCounter;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class DayCounter {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "ccyPair")
                protected String ccyPair;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * ccyPair 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCcyPair() {
                    return ccyPair;
                }

                /**
                 * ccyPair 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCcyPair(String value) {
                    this.ccyPair = value;
                }

            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Expiries {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "ccyPair")
            protected String ccyPair;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * ccyPair 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCcyPair() {
                return ccyPair;
            }

            /**
             * ccyPair 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCcyPair(String value) {
                this.ccyPair = value;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SmileDynamics {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
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
         *       &lt;choice>
         *         &lt;element name="Moneyness" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="StandardDeviations" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "moneyness",
            "standardDeviations"
        })
        public static class Surface {

            @XmlElement(name = "Moneyness")
            protected List<Market.FxVolatilities.Surface.Moneyness> moneyness;
            @XmlElement(name = "StandardDeviations")
            protected List<Market.FxVolatilities.Surface.StandardDeviations> standardDeviations;

            /**
             * Gets the value of the moneyness property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the moneyness property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getMoneyness().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.FxVolatilities.Surface.Moneyness }
             * 
             * 
             */
            public List<Market.FxVolatilities.Surface.Moneyness> getMoneyness() {
                if (moneyness == null) {
                    moneyness = new ArrayList<Market.FxVolatilities.Surface.Moneyness>();
                }
                return this.moneyness;
            }

            /**
             * Gets the value of the standardDeviations property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the standardDeviations property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getStandardDeviations().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.FxVolatilities.Surface.StandardDeviations }
             * 
             * 
             */
            public List<Market.FxVolatilities.Surface.StandardDeviations> getStandardDeviations() {
                if (standardDeviations == null) {
                    standardDeviations = new ArrayList<Market.FxVolatilities.Surface.StandardDeviations>();
                }
                return this.standardDeviations;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Moneyness {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "ccyPair")
                protected String ccyPair;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * ccyPair 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCcyPair() {
                    return ccyPair;
                }

                /**
                 * ccyPair 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCcyPair(String value) {
                    this.ccyPair = value;
                }

            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="ccyPair" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class StandardDeviations {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "ccyPair")
                protected String ccyPair;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * ccyPair 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCcyPair() {
                    return ccyPair;
                }

                /**
                 * ccyPair 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCcyPair(String value) {
                    this.ccyPair = value;
                }

            }

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
     *       &lt;sequence>
     *         &lt;element name="Index" type="{}indexNameType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "index"
    })
    public static class Indices {

        @XmlElement(name = "Index")
        protected List<String> index;

        /**
         * Gets the value of the index property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the index property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIndex().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getIndex() {
            if (index == null) {
                index = new ArrayList<String>();
            }
            return this.index;
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
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="Names" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
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
    @XmlType(name = "", propOrder = {

    })
    public static class Securities {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "Names")
        protected Market.Securities.Names names;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.Securities.Names }
         *     
         */
        public Market.Securities.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.Securities.Names }
         *     
         */
        public void setNames(Market.Securities.Names value) {
            this.names = value;
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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

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
     *       &lt;sequence>
     *         &lt;element name="SwapIndex" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ForwardingIndex" type="{}indexNameType" minOccurs="0"/>
     *                   &lt;element name="DiscountingIndex" type="{}indexNameType"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "swapIndex"
    })
    public static class SwapIndices {

        @XmlElement(name = "SwapIndex")
        protected List<Market.SwapIndices.SwapIndex> swapIndex;

        /**
         * Gets the value of the swapIndex property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the swapIndex property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSwapIndex().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.SwapIndices.SwapIndex }
         * 
         * 
         */
        public List<Market.SwapIndices.SwapIndex> getSwapIndex() {
            if (swapIndex == null) {
                swapIndex = new ArrayList<Market.SwapIndices.SwapIndex>();
            }
            return this.swapIndex;
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
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ForwardingIndex" type="{}indexNameType" minOccurs="0"/>
         *         &lt;element name="DiscountingIndex" type="{}indexNameType"/>
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
        public static class SwapIndex {

            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "ForwardingIndex")
            protected String forwardingIndex;
            @XmlElement(name = "DiscountingIndex", required = true)
            protected String discountingIndex;

            /**
             * name 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * name 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * forwardingIndex 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getForwardingIndex() {
                return forwardingIndex;
            }

            /**
             * forwardingIndex 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setForwardingIndex(String value) {
                this.forwardingIndex = value;
            }

            /**
             * discountingIndex 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDiscountingIndex() {
                return discountingIndex;
            }

            /**
             * discountingIndex 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDiscountingIndex(String value) {
                this.discountingIndex = value;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
     *         &lt;element name="Keys" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Currencies" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Expiries">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Terms">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SimulateATMOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="StrikeSpreads" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DayCounters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DayCounter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulate",
        "reactionToTimeDecay",
        "keys",
        "currencies",
        "expiries",
        "terms",
        "simulateATMOnly",
        "strikeSpreads",
        "dayCounters",
        "smileDynamics"
    })
    public static class SwaptionVolatilities {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "ReactionToTimeDecay", required = true)
        @XmlSchemaType(name = "string")
        protected TimeDecayType reactionToTimeDecay;
        @XmlElement(name = "Keys")
        protected Market.SwaptionVolatilities.Keys keys;
        @XmlElement(name = "Currencies")
        protected Market.SwaptionVolatilities.Currencies currencies;
        @XmlElement(name = "Expiries", required = true)
        protected Market.SwaptionVolatilities.Expiries expiries;
        @XmlElement(name = "Terms", required = true)
        protected Market.SwaptionVolatilities.Terms terms;
        @XmlElement(name = "SimulateATMOnly")
        protected Boolean simulateATMOnly;
        @XmlElement(name = "StrikeSpreads")
        protected List<Market.SwaptionVolatilities.StrikeSpreads> strikeSpreads;
        @XmlElement(name = "DayCounters")
        protected Market.SwaptionVolatilities.DayCounters dayCounters;
        @XmlElement(name = "SmileDynamics")
        protected List<Market.SwaptionVolatilities.SmileDynamics> smileDynamics;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * reactionToTimeDecay 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link TimeDecayType }
         *     
         */
        public TimeDecayType getReactionToTimeDecay() {
            return reactionToTimeDecay;
        }

        /**
         * reactionToTimeDecay 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link TimeDecayType }
         *     
         */
        public void setReactionToTimeDecay(TimeDecayType value) {
            this.reactionToTimeDecay = value;
        }

        /**
         * keys 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.SwaptionVolatilities.Keys }
         *     
         */
        public Market.SwaptionVolatilities.Keys getKeys() {
            return keys;
        }

        /**
         * keys 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.SwaptionVolatilities.Keys }
         *     
         */
        public void setKeys(Market.SwaptionVolatilities.Keys value) {
            this.keys = value;
        }

        /**
         * currencies 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.SwaptionVolatilities.Currencies }
         *     
         */
        public Market.SwaptionVolatilities.Currencies getCurrencies() {
            return currencies;
        }

        /**
         * currencies 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.SwaptionVolatilities.Currencies }
         *     
         */
        public void setCurrencies(Market.SwaptionVolatilities.Currencies value) {
            this.currencies = value;
        }

        /**
         * expiries 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.SwaptionVolatilities.Expiries }
         *     
         */
        public Market.SwaptionVolatilities.Expiries getExpiries() {
            return expiries;
        }

        /**
         * expiries 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.SwaptionVolatilities.Expiries }
         *     
         */
        public void setExpiries(Market.SwaptionVolatilities.Expiries value) {
            this.expiries = value;
        }

        /**
         * terms 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.SwaptionVolatilities.Terms }
         *     
         */
        public Market.SwaptionVolatilities.Terms getTerms() {
            return terms;
        }

        /**
         * terms 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.SwaptionVolatilities.Terms }
         *     
         */
        public void setTerms(Market.SwaptionVolatilities.Terms value) {
            this.terms = value;
        }

        /**
         * simulateATMOnly 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSimulateATMOnly() {
            return simulateATMOnly;
        }

        /**
         * simulateATMOnly 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSimulateATMOnly(Boolean value) {
            this.simulateATMOnly = value;
        }

        /**
         * Gets the value of the strikeSpreads property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the strikeSpreads property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStrikeSpreads().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.SwaptionVolatilities.StrikeSpreads }
         * 
         * 
         */
        public List<Market.SwaptionVolatilities.StrikeSpreads> getStrikeSpreads() {
            if (strikeSpreads == null) {
                strikeSpreads = new ArrayList<Market.SwaptionVolatilities.StrikeSpreads>();
            }
            return this.strikeSpreads;
        }

        /**
         * dayCounters 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.SwaptionVolatilities.DayCounters }
         *     
         */
        public Market.SwaptionVolatilities.DayCounters getDayCounters() {
            return dayCounters;
        }

        /**
         * dayCounters 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.SwaptionVolatilities.DayCounters }
         *     
         */
        public void setDayCounters(Market.SwaptionVolatilities.DayCounters value) {
            this.dayCounters = value;
        }

        /**
         * Gets the value of the smileDynamics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the smileDynamics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSmileDynamics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.SwaptionVolatilities.SmileDynamics }
         * 
         * 
         */
        public List<Market.SwaptionVolatilities.SmileDynamics> getSmileDynamics() {
            if (smileDynamics == null) {
                smileDynamics = new ArrayList<Market.SwaptionVolatilities.SmileDynamics>();
            }
            return this.smileDynamics;
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
         *       &lt;sequence>
         *         &lt;element name="Currency" type="{}currencyCode" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "currency"
        })
        public static class Currencies {

            @XmlElement(name = "Currency")
            @XmlSchemaType(name = "string")
            protected List<CurrencyCode> currency;

            /**
             * Gets the value of the currency property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the currency property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCurrency().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link CurrencyCode }
             * 
             * 
             */
            public List<CurrencyCode> getCurrency() {
                if (currency == null) {
                    currency = new ArrayList<CurrencyCode>();
                }
                return this.currency;
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
         *       &lt;sequence>
         *         &lt;element name="DayCounter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dayCounter"
        })
        public static class DayCounters {

            @XmlElement(name = "DayCounter", required = true)
            protected List<Market.SwaptionVolatilities.DayCounters.DayCounter> dayCounter;

            /**
             * Gets the value of the dayCounter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dayCounter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDayCounter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.SwaptionVolatilities.DayCounters.DayCounter }
             * 
             * 
             */
            public List<Market.SwaptionVolatilities.DayCounters.DayCounter> getDayCounter() {
                if (dayCounter == null) {
                    dayCounter = new ArrayList<Market.SwaptionVolatilities.DayCounters.DayCounter>();
                }
                return this.dayCounter;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class DayCounter {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "key")
                protected String key;
                @XmlAttribute(name = "ccy")
                protected String ccy;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * key 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getKey() {
                    return key;
                }

                /**
                 * key 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setKey(String value) {
                    this.key = value;
                }

                /**
                 * ccy 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCcy() {
                    return ccy;
                }

                /**
                 * ccy 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCcy(String value) {
                    this.ccy = value;
                }

            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Expiries {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;
            @XmlAttribute(name = "ccy")
            protected String ccy;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * ccy 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCcy() {
                return ccy;
            }

            /**
             * ccy 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCcy(String value) {
                this.ccy = value;
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
         *       &lt;sequence>
         *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key"
        })
        public static class Keys {

            @XmlElement(name = "Key")
            protected List<String> key;

            /**
             * Gets the value of the key property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the key property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getKey().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getKey() {
                if (key == null) {
                    key = new ArrayList<String>();
                }
                return this.key;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SmileDynamics {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class StrikeSpreads {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;
            @XmlAttribute(name = "ccy")
            protected String ccy;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * ccy 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCcy() {
                return ccy;
            }

            /**
             * ccy 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCcy(String value) {
                this.ccy = value;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Terms {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;
            @XmlAttribute(name = "ccy")
            protected String ccy;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * ccy 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCcy() {
                return ccy;
            }

            /**
             * ccy 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCcy(String value) {
                this.ccy = value;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
     *         &lt;element name="Names">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Strikes" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulate",
        "reactionToTimeDecay",
        "names",
        "expiries",
        "strikes",
        "smileDynamics"
    })
    public static class YYCapFloorVolatilities {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "ReactionToTimeDecay", required = true)
        @XmlSchemaType(name = "string")
        protected TimeDecayType reactionToTimeDecay;
        @XmlElement(name = "Names", required = true)
        protected Market.YYCapFloorVolatilities.Names names;
        @XmlElement(name = "Expiries", required = true)
        protected String expiries;
        @XmlElement(name = "Strikes", required = true)
        protected String strikes;
        @XmlElement(name = "SmileDynamics")
        protected List<Market.YYCapFloorVolatilities.SmileDynamics> smileDynamics;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * reactionToTimeDecay 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link TimeDecayType }
         *     
         */
        public TimeDecayType getReactionToTimeDecay() {
            return reactionToTimeDecay;
        }

        /**
         * reactionToTimeDecay 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link TimeDecayType }
         *     
         */
        public void setReactionToTimeDecay(TimeDecayType value) {
            this.reactionToTimeDecay = value;
        }

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.YYCapFloorVolatilities.Names }
         *     
         */
        public Market.YYCapFloorVolatilities.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.YYCapFloorVolatilities.Names }
         *     
         */
        public void setNames(Market.YYCapFloorVolatilities.Names value) {
            this.names = value;
        }

        /**
         * expiries 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExpiries() {
            return expiries;
        }

        /**
         * expiries 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExpiries(String value) {
            this.expiries = value;
        }

        /**
         * strikes 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStrikes() {
            return strikes;
        }

        /**
         * strikes 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStrikes(String value) {
            this.strikes = value;
        }

        /**
         * Gets the value of the smileDynamics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the smileDynamics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSmileDynamics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.YYCapFloorVolatilities.SmileDynamics }
         * 
         * 
         */
        public List<Market.YYCapFloorVolatilities.SmileDynamics> getSmileDynamics() {
            if (smileDynamics == null) {
                smileDynamics = new ArrayList<Market.YYCapFloorVolatilities.SmileDynamics>();
            }
            return this.smileDynamics;
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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SmileDynamics {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

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
     *         &lt;element name="Names">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Tenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DayCounters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DayCounter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
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
    @XmlType(name = "", propOrder = {

    })
    public static class YYInflationIndexCurves {

        @XmlElement(name = "Names", required = true)
        protected Market.YYInflationIndexCurves.Names names;
        @XmlElement(name = "Tenors", required = true)
        protected String tenors;
        @XmlElement(name = "DayCounters")
        protected Market.YYInflationIndexCurves.DayCounters dayCounters;

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.YYInflationIndexCurves.Names }
         *     
         */
        public Market.YYInflationIndexCurves.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.YYInflationIndexCurves.Names }
         *     
         */
        public void setNames(Market.YYInflationIndexCurves.Names value) {
            this.names = value;
        }

        /**
         * tenors 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTenors() {
            return tenors;
        }

        /**
         * tenors 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTenors(String value) {
            this.tenors = value;
        }

        /**
         * dayCounters 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.YYInflationIndexCurves.DayCounters }
         *     
         */
        public Market.YYInflationIndexCurves.DayCounters getDayCounters() {
            return dayCounters;
        }

        /**
         * dayCounters 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.YYInflationIndexCurves.DayCounters }
         *     
         */
        public void setDayCounters(Market.YYInflationIndexCurves.DayCounters value) {
            this.dayCounters = value;
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
         *       &lt;sequence>
         *         &lt;element name="DayCounter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dayCounter"
        })
        public static class DayCounters {

            @XmlElement(name = "DayCounter", required = true)
            protected List<Market.YYInflationIndexCurves.DayCounters.DayCounter> dayCounter;

            /**
             * Gets the value of the dayCounter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dayCounter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDayCounter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.YYInflationIndexCurves.DayCounters.DayCounter }
             * 
             * 
             */
            public List<Market.YYInflationIndexCurves.DayCounters.DayCounter> getDayCounter() {
                if (dayCounter == null) {
                    dayCounter = new ArrayList<Market.YYInflationIndexCurves.DayCounters.DayCounter>();
                }
                return this.dayCounter;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class DayCounter {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * name 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * name 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Configuration" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Tenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Interpolation" type="{}ycInterpolation" minOccurs="0"/>
     *                   &lt;element name="Extrapolation" type="{}ycExtrapolation" minOccurs="0"/>
     *                   &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
     *                 &lt;/all>
     *                 &lt;attribute name="curve" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "configuration"
    })
    public static class YieldCurves {

        @XmlElement(name = "Configuration")
        protected List<Market.YieldCurves.Configuration> configuration;

        /**
         * Gets the value of the configuration property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the configuration property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConfiguration().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.YieldCurves.Configuration }
         * 
         * 
         */
        public List<Market.YieldCurves.Configuration> getConfiguration() {
            if (configuration == null) {
                configuration = new ArrayList<Market.YieldCurves.Configuration>();
            }
            return this.configuration;
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
         *         &lt;element name="Tenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Interpolation" type="{}ycInterpolation" minOccurs="0"/>
         *         &lt;element name="Extrapolation" type="{}ycExtrapolation" minOccurs="0"/>
         *         &lt;element name="DayCounter" type="{}dayCounter" minOccurs="0"/>
         *       &lt;/all>
         *       &lt;attribute name="curve" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class Configuration {

            @XmlElement(name = "Tenors", required = true)
            protected String tenors;
            @XmlElement(name = "Interpolation")
            @XmlSchemaType(name = "string")
            protected YcInterpolation interpolation;
            @XmlElement(name = "Extrapolation")
            protected String extrapolation;
            @XmlElement(name = "DayCounter")
            protected String dayCounter;
            @XmlAttribute(name = "curve")
            protected String curve;

            /**
             * tenors 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTenors() {
                return tenors;
            }

            /**
             * tenors 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTenors(String value) {
                this.tenors = value;
            }

            /**
             * interpolation 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link YcInterpolation }
             *     
             */
            public YcInterpolation getInterpolation() {
                return interpolation;
            }

            /**
             * interpolation 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link YcInterpolation }
             *     
             */
            public void setInterpolation(YcInterpolation value) {
                this.interpolation = value;
            }

            /**
             * extrapolation 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExtrapolation() {
                return extrapolation;
            }

            /**
             * extrapolation 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExtrapolation(String value) {
                this.extrapolation = value;
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
             * curve 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCurve() {
                return curve;
            }

            /**
             * curve 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCurve(String value) {
                this.curve = value;
            }

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
     *       &lt;sequence>
     *         &lt;element name="Simulate" type="{}bool" minOccurs="0"/>
     *         &lt;element name="ReactionToTimeDecay" type="{}timeDecayType"/>
     *         &lt;element name="Names">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Expiries" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Terms" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="SimulateATMOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="Cube" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="StrikeSpreads" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DayCounters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DayCounter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SmileDynamics" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulate",
        "reactionToTimeDecay",
        "names",
        "expiries",
        "terms",
        "simulateATMOnly",
        "cube",
        "dayCounters",
        "smileDynamics"
    })
    public static class YieldVolatilities {

        @XmlElement(name = "Simulate")
        protected String simulate;
        @XmlElement(name = "ReactionToTimeDecay", required = true)
        @XmlSchemaType(name = "string")
        protected TimeDecayType reactionToTimeDecay;
        @XmlElement(name = "Names", required = true)
        protected Market.YieldVolatilities.Names names;
        @XmlElement(name = "Expiries", required = true)
        protected String expiries;
        @XmlElement(name = "Terms", required = true)
        protected String terms;
        @XmlElement(name = "SimulateATMOnly")
        protected Boolean simulateATMOnly;
        @XmlElement(name = "Cube")
        protected Market.YieldVolatilities.Cube cube;
        @XmlElement(name = "DayCounters")
        protected Market.YieldVolatilities.DayCounters dayCounters;
        @XmlElement(name = "SmileDynamics")
        protected List<Market.YieldVolatilities.SmileDynamics> smileDynamics;

        /**
         * simulate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulate() {
            return simulate;
        }

        /**
         * simulate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulate(String value) {
            this.simulate = value;
        }

        /**
         * reactionToTimeDecay 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link TimeDecayType }
         *     
         */
        public TimeDecayType getReactionToTimeDecay() {
            return reactionToTimeDecay;
        }

        /**
         * reactionToTimeDecay 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link TimeDecayType }
         *     
         */
        public void setReactionToTimeDecay(TimeDecayType value) {
            this.reactionToTimeDecay = value;
        }

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.YieldVolatilities.Names }
         *     
         */
        public Market.YieldVolatilities.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.YieldVolatilities.Names }
         *     
         */
        public void setNames(Market.YieldVolatilities.Names value) {
            this.names = value;
        }

        /**
         * expiries 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExpiries() {
            return expiries;
        }

        /**
         * expiries 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExpiries(String value) {
            this.expiries = value;
        }

        /**
         * terms 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTerms() {
            return terms;
        }

        /**
         * terms 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTerms(String value) {
            this.terms = value;
        }

        /**
         * simulateATMOnly 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSimulateATMOnly() {
            return simulateATMOnly;
        }

        /**
         * simulateATMOnly 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSimulateATMOnly(Boolean value) {
            this.simulateATMOnly = value;
        }

        /**
         * cube 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.YieldVolatilities.Cube }
         *     
         */
        public Market.YieldVolatilities.Cube getCube() {
            return cube;
        }

        /**
         * cube 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.YieldVolatilities.Cube }
         *     
         */
        public void setCube(Market.YieldVolatilities.Cube value) {
            this.cube = value;
        }

        /**
         * dayCounters 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.YieldVolatilities.DayCounters }
         *     
         */
        public Market.YieldVolatilities.DayCounters getDayCounters() {
            return dayCounters;
        }

        /**
         * dayCounters 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.YieldVolatilities.DayCounters }
         *     
         */
        public void setDayCounters(Market.YieldVolatilities.DayCounters value) {
            this.dayCounters = value;
        }

        /**
         * Gets the value of the smileDynamics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the smileDynamics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSmileDynamics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Market.YieldVolatilities.SmileDynamics }
         * 
         * 
         */
        public List<Market.YieldVolatilities.SmileDynamics> getSmileDynamics() {
            if (smileDynamics == null) {
                smileDynamics = new ArrayList<Market.YieldVolatilities.SmileDynamics>();
            }
            return this.smileDynamics;
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
         *         &lt;element name="StrikeSpreads" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        public static class Cube {

            @XmlElement(name = "StrikeSpreads")
            protected String strikeSpreads;

            /**
             * strikeSpreads 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStrikeSpreads() {
                return strikeSpreads;
            }

            /**
             * strikeSpreads 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStrikeSpreads(String value) {
                this.strikeSpreads = value;
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
         *       &lt;sequence>
         *         &lt;element name="DayCounter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dayCounter"
        })
        public static class DayCounters {

            @XmlElement(name = "DayCounter", required = true)
            protected List<Market.YieldVolatilities.DayCounters.DayCounter> dayCounter;

            /**
             * Gets the value of the dayCounter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dayCounter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDayCounter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.YieldVolatilities.DayCounters.DayCounter }
             * 
             * 
             */
            public List<Market.YieldVolatilities.DayCounters.DayCounter> getDayCounter() {
                if (dayCounter == null) {
                    dayCounter = new ArrayList<Market.YieldVolatilities.DayCounters.DayCounter>();
                }
                return this.dayCounter;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class DayCounter {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "ccy")
                protected String ccy;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * ccy 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCcy() {
                    return ccy;
                }

                /**
                 * ccy 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCcy(String value) {
                    this.ccy = value;
                }

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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SmileDynamics {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key")
            protected String key;

            /**
             * value 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * key 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * key 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

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
     *         &lt;element name="Names">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Tenors" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DayCounters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DayCounter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
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
    @XmlType(name = "", propOrder = {

    })
    public static class ZeroInflationIndexCurves {

        @XmlElement(name = "Names", required = true)
        protected Market.ZeroInflationIndexCurves.Names names;
        @XmlElement(name = "Tenors", required = true)
        protected String tenors;
        @XmlElement(name = "DayCounters")
        protected Market.ZeroInflationIndexCurves.DayCounters dayCounters;

        /**
         * names 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.ZeroInflationIndexCurves.Names }
         *     
         */
        public Market.ZeroInflationIndexCurves.Names getNames() {
            return names;
        }

        /**
         * names 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.ZeroInflationIndexCurves.Names }
         *     
         */
        public void setNames(Market.ZeroInflationIndexCurves.Names value) {
            this.names = value;
        }

        /**
         * tenors 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTenors() {
            return tenors;
        }

        /**
         * tenors 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTenors(String value) {
            this.tenors = value;
        }

        /**
         * dayCounters 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Market.ZeroInflationIndexCurves.DayCounters }
         *     
         */
        public Market.ZeroInflationIndexCurves.DayCounters getDayCounters() {
            return dayCounters;
        }

        /**
         * dayCounters 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Market.ZeroInflationIndexCurves.DayCounters }
         *     
         */
        public void setDayCounters(Market.ZeroInflationIndexCurves.DayCounters value) {
            this.dayCounters = value;
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
         *       &lt;sequence>
         *         &lt;element name="DayCounter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dayCounter"
        })
        public static class DayCounters {

            @XmlElement(name = "DayCounter", required = true)
            protected List<Market.ZeroInflationIndexCurves.DayCounters.DayCounter> dayCounter;

            /**
             * Gets the value of the dayCounter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dayCounter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDayCounter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Market.ZeroInflationIndexCurves.DayCounters.DayCounter }
             * 
             * 
             */
            public List<Market.ZeroInflationIndexCurves.DayCounters.DayCounter> getDayCounter() {
                if (dayCounter == null) {
                    dayCounter = new ArrayList<Market.ZeroInflationIndexCurves.DayCounters.DayCounter>();
                }
                return this.dayCounter;
            }


            /**
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class DayCounter {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * value 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * value 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * name 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * name 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

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
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Names {

            @XmlElement(name = "Name")
            protected List<String> name;

            /**
             * Gets the value of the name property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the name property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getName() {
                if (name == null) {
                    name = new ArrayList<String>();
                }
                return this.name;
            }

        }

    }

}
