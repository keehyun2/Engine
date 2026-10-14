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
 * <p>fxOptionTimeWeighting complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="fxOptionTimeWeighting">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WeekdayWeights">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Monday" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="Tuesday" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="Wednesday" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="Thursday" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="Friday" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="Saturday" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="Sunday" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TradingCenters" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TradingCenter">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
 *         &lt;element name="Events" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Event">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Date" type="{}date"/>
 *                             &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fxOptionTimeWeighting", propOrder = {

})
public class FxOptionTimeWeighting {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "WeekdayWeights", required = true)
    protected FxOptionTimeWeighting.WeekdayWeights weekdayWeights;
    @XmlElement(name = "TradingCenters")
    protected FxOptionTimeWeighting.TradingCenters tradingCenters;
    @XmlElement(name = "Events")
    protected FxOptionTimeWeighting.Events events;

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

    /**
     * weekdayWeights 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxOptionTimeWeighting.WeekdayWeights }
     *     
     */
    public FxOptionTimeWeighting.WeekdayWeights getWeekdayWeights() {
        return weekdayWeights;
    }

    /**
     * weekdayWeights 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxOptionTimeWeighting.WeekdayWeights }
     *     
     */
    public void setWeekdayWeights(FxOptionTimeWeighting.WeekdayWeights value) {
        this.weekdayWeights = value;
    }

    /**
     * tradingCenters 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxOptionTimeWeighting.TradingCenters }
     *     
     */
    public FxOptionTimeWeighting.TradingCenters getTradingCenters() {
        return tradingCenters;
    }

    /**
     * tradingCenters 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxOptionTimeWeighting.TradingCenters }
     *     
     */
    public void setTradingCenters(FxOptionTimeWeighting.TradingCenters value) {
        this.tradingCenters = value;
    }

    /**
     * events 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FxOptionTimeWeighting.Events }
     *     
     */
    public FxOptionTimeWeighting.Events getEvents() {
        return events;
    }

    /**
     * events 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FxOptionTimeWeighting.Events }
     *     
     */
    public void setEvents(FxOptionTimeWeighting.Events value) {
        this.events = value;
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
     *         &lt;element name="Event">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Date" type="{}date"/>
     *                   &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
        "event"
    })
    public static class Events {

        @XmlElement(name = "Event", required = true)
        protected FxOptionTimeWeighting.Events.Event event;

        /**
         * event 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link FxOptionTimeWeighting.Events.Event }
         *     
         */
        public FxOptionTimeWeighting.Events.Event getEvent() {
            return event;
        }

        /**
         * event 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link FxOptionTimeWeighting.Events.Event }
         *     
         */
        public void setEvent(FxOptionTimeWeighting.Events.Event value) {
            this.event = value;
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
         *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Date" type="{}date"/>
         *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
        public static class Event {

            @XmlElement(name = "Description", required = true)
            protected String description;
            @XmlElement(name = "Date", required = true)
            protected String date;
            @XmlElement(name = "Weight")
            protected float weight;

            /**
             * description 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescription() {
                return description;
            }

            /**
             * description 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescription(String value) {
                this.description = value;
            }

            /**
             * date 속성의 값을 가져옵니다.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDate() {
                return date;
            }

            /**
             * date 속성의 값을 설정합니다.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDate(String value) {
                this.date = value;
            }

            /**
             * weight 속성의 값을 가져옵니다.
             * 
             */
            public float getWeight() {
                return weight;
            }

            /**
             * weight 속성의 값을 설정합니다.
             * 
             */
            public void setWeight(float value) {
                this.weight = value;
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
     *         &lt;element name="TradingCenter">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
        "tradingCenter"
    })
    public static class TradingCenters {

        @XmlElement(name = "TradingCenter", required = true)
        protected FxOptionTimeWeighting.TradingCenters.TradingCenter tradingCenter;

        /**
         * tradingCenter 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link FxOptionTimeWeighting.TradingCenters.TradingCenter }
         *     
         */
        public FxOptionTimeWeighting.TradingCenters.TradingCenter getTradingCenter() {
            return tradingCenter;
        }

        /**
         * tradingCenter 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link FxOptionTimeWeighting.TradingCenters.TradingCenter }
         *     
         */
        public void setTradingCenter(FxOptionTimeWeighting.TradingCenters.TradingCenter value) {
            this.tradingCenter = value;
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
         *         &lt;element name="Calendar" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
        public static class TradingCenter {

            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "Calendar", required = true)
            protected String calendar;
            @XmlElement(name = "Weight")
            protected float weight;

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
             * weight 속성의 값을 가져옵니다.
             * 
             */
            public float getWeight() {
                return weight;
            }

            /**
             * weight 속성의 값을 설정합니다.
             * 
             */
            public void setWeight(float value) {
                this.weight = value;
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
     *         &lt;element name="Monday" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="Tuesday" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="Wednesday" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="Thursday" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="Friday" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="Saturday" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="Sunday" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
        "monday",
        "tuesday",
        "wednesday",
        "thursday",
        "friday",
        "saturday",
        "sunday"
    })
    public static class WeekdayWeights {

        @XmlElement(name = "Monday")
        protected float monday;
        @XmlElement(name = "Tuesday")
        protected float tuesday;
        @XmlElement(name = "Wednesday")
        protected float wednesday;
        @XmlElement(name = "Thursday")
        protected float thursday;
        @XmlElement(name = "Friday")
        protected float friday;
        @XmlElement(name = "Saturday")
        protected float saturday;
        @XmlElement(name = "Sunday")
        protected float sunday;

        /**
         * monday 속성의 값을 가져옵니다.
         * 
         */
        public float getMonday() {
            return monday;
        }

        /**
         * monday 속성의 값을 설정합니다.
         * 
         */
        public void setMonday(float value) {
            this.monday = value;
        }

        /**
         * tuesday 속성의 값을 가져옵니다.
         * 
         */
        public float getTuesday() {
            return tuesday;
        }

        /**
         * tuesday 속성의 값을 설정합니다.
         * 
         */
        public void setTuesday(float value) {
            this.tuesday = value;
        }

        /**
         * wednesday 속성의 값을 가져옵니다.
         * 
         */
        public float getWednesday() {
            return wednesday;
        }

        /**
         * wednesday 속성의 값을 설정합니다.
         * 
         */
        public void setWednesday(float value) {
            this.wednesday = value;
        }

        /**
         * thursday 속성의 값을 가져옵니다.
         * 
         */
        public float getThursday() {
            return thursday;
        }

        /**
         * thursday 속성의 값을 설정합니다.
         * 
         */
        public void setThursday(float value) {
            this.thursday = value;
        }

        /**
         * friday 속성의 값을 가져옵니다.
         * 
         */
        public float getFriday() {
            return friday;
        }

        /**
         * friday 속성의 값을 설정합니다.
         * 
         */
        public void setFriday(float value) {
            this.friday = value;
        }

        /**
         * saturday 속성의 값을 가져옵니다.
         * 
         */
        public float getSaturday() {
            return saturday;
        }

        /**
         * saturday 속성의 값을 설정합니다.
         * 
         */
        public void setSaturday(float value) {
            this.saturday = value;
        }

        /**
         * sunday 속성의 값을 가져옵니다.
         * 
         */
        public float getSunday() {
            return sunday;
        }

        /**
         * sunday 속성의 값을 설정합니다.
         * 
         */
        public void setSunday(float value) {
            this.sunday = value;
        }

    }

}
