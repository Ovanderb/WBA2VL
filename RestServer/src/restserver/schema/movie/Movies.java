//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.10 at 05:33:46 PM MESZ 
//


package restserver.schema.movie;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import restserver.schema.movie.Movies.Movie;
import restserver.schema.movie.Movies.Movie.Actors;
import restserver.schema.movie.Movies.Movie.Actors.Actor;
import restserver.schema.movie.Movies.Movie.Genres;
import restserver.schema.movie.Movies.Movie.Genres.Genre;
import restserver.schema.movie.Movies.Movie.Stocks;
import restserver.schema.movie.Movies.Movie.Stocks.Stock;


/**
 * <p>Java class for movies element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="movies">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="movie" maxOccurs="unbounded" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="discription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                     &lt;element name="actors">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="actor" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="genres">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="genre" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="stocks">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="stock" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;attribute name="format" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                       &lt;attribute name="lent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                       &lt;attribute name="retour" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                   &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                   &lt;attribute name="delete" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                   &lt;attribute name="edit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                   &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                   &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                   &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                   &lt;attribute name="price" type="{http://www.w3.org/2001/XMLSchema}float" />
 *                   &lt;attribute name="regiseur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
 *         &lt;attribute name="add" type="{http://www.w3.org/2001/XMLSchema}string" />
 *         &lt;attribute name="cancel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *         &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "movie"
})
@XmlRootElement(name = "movies")
public class Movies {

    @XmlElement(required = true)
    protected List<Movie> movie;
    @XmlAttribute
    protected String add;
    @XmlAttribute
    protected String cancel;
    @XmlAttribute
    protected Integer id;

    /**
     * Gets the value of the movie property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the movie property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMovie().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Movie }
     * 
     * 
     */
    public List<Movie> getMovie() {
        if (movie == null) {
            movie = new ArrayList<Movie>();
        }
        return this.movie;
    }

    /**
     * Gets the value of the add property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdd() {
        return add;
    }

    /**
     * Sets the value of the add property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdd(String value) {
        this.add = value;
    }

    /**
     * Gets the value of the cancel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancel() {
        return cancel;
    }

    /**
     * Sets the value of the cancel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancel(String value) {
        this.cancel = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="discription" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="actors">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="actor" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="genres">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="genre" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="stocks">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="stock" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="format" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                           &lt;attribute name="lent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                           &lt;attribute name="retour" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="delete" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="edit" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="price" type="{http://www.w3.org/2001/XMLSchema}float" />
     *       &lt;attribute name="regiseur" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "discription",
        "actors",
        "genres",
        "stocks"
    })
    public static class Movie {

        @XmlElement(required = true)
        protected String discription;
        @XmlElement(required = true)
        protected Actors actors;
        @XmlElement(required = true)
        protected Genres genres;
        @XmlElement(required = true)
        protected Stocks stocks;
        @XmlAttribute
        protected String date;
        @XmlAttribute
        protected String delete;
        @XmlAttribute
        protected String edit;
        @XmlAttribute
        protected Integer id;
        @XmlAttribute
        protected Integer length;
        @XmlAttribute
        protected String name;
        @XmlAttribute
        protected Float price;
        @XmlAttribute
        protected String regiseur;

        /**
         * Gets the value of the discription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDiscription() {
            return discription;
        }

        /**
         * Sets the value of the discription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDiscription(String value) {
            this.discription = value;
        }

        /**
         * Gets the value of the actors property.
         * 
         * @return
         *     possible object is
         *     {@link Actors }
         *     
         */
        public Actors getActors() {
            return actors;
        }

        /**
         * Sets the value of the actors property.
         * 
         * @param value
         *     allowed object is
         *     {@link Actors }
         *     
         */
        public void setActors(Actors value) {
            this.actors = value;
        }

        /**
         * Gets the value of the genres property.
         * 
         * @return
         *     possible object is
         *     {@link Genres }
         *     
         */
        public Genres getGenres() {
            return genres;
        }

        /**
         * Sets the value of the genres property.
         * 
         * @param value
         *     allowed object is
         *     {@link Genres }
         *     
         */
        public void setGenres(Genres value) {
            this.genres = value;
        }

        /**
         * Gets the value of the stocks property.
         * 
         * @return
         *     possible object is
         *     {@link Stocks }
         *     
         */
        public Stocks getStocks() {
            return stocks;
        }

        /**
         * Sets the value of the stocks property.
         * 
         * @param value
         *     allowed object is
         *     {@link Stocks }
         *     
         */
        public void setStocks(Stocks value) {
            this.stocks = value;
        }

        /**
         * Gets the value of the date property.
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
         * Sets the value of the date property.
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
         * Gets the value of the delete property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDelete() {
            return delete;
        }

        /**
         * Sets the value of the delete property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDelete(String value) {
            this.delete = value;
        }

        /**
         * Gets the value of the edit property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEdit() {
            return edit;
        }

        /**
         * Sets the value of the edit property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEdit(String value) {
            this.edit = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setId(Integer value) {
            this.id = value;
        }

        /**
         * Gets the value of the length property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getLength() {
            return length;
        }

        /**
         * Sets the value of the length property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setLength(Integer value) {
            this.length = value;
        }

        /**
         * Gets the value of the name property.
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
         * Sets the value of the name property.
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
         * Gets the value of the price property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public Float getPrice() {
            return price;
        }

        /**
         * Sets the value of the price property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setPrice(Float value) {
            this.price = value;
        }

        /**
         * Gets the value of the regiseur property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegiseur() {
            return regiseur;
        }

        /**
         * Sets the value of the regiseur property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegiseur(String value) {
            this.regiseur = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="actor" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
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
            "actor"
        })
        public static class Actors {

            @XmlElement(required = true)
            protected List<Actor> actor;

            /**
             * Gets the value of the actor property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the actor property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getActor().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Actor }
             * 
             * 
             */
            public List<Actor> getActor() {
                if (actor == null) {
                    actor = new ArrayList<Actor>();
                }
                return this.actor;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Actor {

                @XmlAttribute
                protected Integer id;

                /**
                 * Gets the value of the id property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getId() {
                    return id;
                }

                /**
                 * Sets the value of the id property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setId(Integer value) {
                    this.id = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="genre" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
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
            "genre"
        })
        public static class Genres {

            @XmlElement(required = true)
            protected List<Genre> genre;

            /**
             * Gets the value of the genre property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the genre property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getGenre().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Genre }
             * 
             * 
             */
            public List<Genre> getGenre() {
                if (genre == null) {
                    genre = new ArrayList<Genre>();
                }
                return this.genre;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Genre {

                @XmlAttribute
                protected Integer id;

                /**
                 * Gets the value of the id property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getId() {
                    return id;
                }

                /**
                 * Sets the value of the id property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setId(Integer value) {
                    this.id = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="stock" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="format" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                 &lt;attribute name="lent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                 &lt;attribute name="retour" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            "stock"
        })
        public static class Stocks {

            @XmlElement(required = true)
            protected List<Stock> stock;

            /**
             * Gets the value of the stock property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the stock property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getStock().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Stock }
             * 
             * 
             */
            public List<Stock> getStock() {
                if (stock == null) {
                    stock = new ArrayList<Stock>();
                }
                return this.stock;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="format" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
             *       &lt;attribute name="lent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *       &lt;attribute name="retour" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Stock {

                @XmlAttribute
                protected String format;
                @XmlAttribute
                protected Integer id;
                @XmlAttribute
                protected Boolean lent;
                @XmlAttribute
                protected String retour;

                /**
                 * Gets the value of the format property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFormat() {
                    return format;
                }

                /**
                 * Sets the value of the format property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFormat(String value) {
                    this.format = value;
                }

                /**
                 * Gets the value of the id property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getId() {
                    return id;
                }

                /**
                 * Sets the value of the id property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setId(Integer value) {
                    this.id = value;
                }

                /**
                 * Gets the value of the lent property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isLent() {
                    return lent;
                }

                /**
                 * Sets the value of the lent property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setLent(Boolean value) {
                    this.lent = value;
                }

                /**
                 * Gets the value of the retour property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRetour() {
                    return retour;
                }

                /**
                 * Sets the value of the retour property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRetour(String value) {
                    this.retour = value;
                }

            }

        }

    }

}