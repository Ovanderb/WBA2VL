//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.05.07 um 07:22:39 PM CEST 
//


package restserver.schema.movie;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="movie" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="discription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="actors" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="genres" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="stocks">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="stock" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;attribute name="lent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                     &lt;attribute name="return" type="{http://www.w3.org/2001/XMLSchema}date" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="format" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="regiseur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="image" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                 &lt;attribute name="price" type="{http://www.w3.org/2001/XMLSchema}float" />
 *                 &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}date" />
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
    "movie"
})
@XmlRootElement(name = "movies")
public class Movies {

    protected List<Movies.Movie> movie;

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
     * {@link Movies.Movie }
     * 
     * 
     */
    public List<Movies.Movie> getMovie() {
        if (movie == null) {
            movie = new ArrayList<Movies.Movie>();
        }
        return this.movie;
    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="discription" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="actors" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="genres" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="stocks">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="stock" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                           &lt;attribute name="lent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                           &lt;attribute name="return" type="{http://www.w3.org/2001/XMLSchema}date" />
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
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="format" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="regiseur" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="image" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *       &lt;attribute name="price" type="{http://www.w3.org/2001/XMLSchema}float" />
     *       &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}date" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement
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
        protected String actors;
        @XmlElement(required = true)
        protected String genres;
        @XmlElement(required = true)
        protected Movies.Movie.Stocks stocks;
        @XmlAttribute(name = "movieid")
        protected Integer movieid;
        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "length")
        protected Integer length;
        @XmlAttribute(name = "format")
        protected String format;
        @XmlAttribute(name = "regiseur")
        protected String regiseur;
        @XmlAttribute(name = "image")
        @XmlSchemaType(name = "anyURI")
        protected String image;
        @XmlAttribute(name = "price")
        protected Float price;
        @XmlAttribute(name = "date")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar date;

        /**
         * Ruft den Wert der discription-Eigenschaft ab.
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
         * Legt den Wert der discription-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDiscription(String value) {
            this.discription = value;
        }

        
        public Integer getMovieid() {
            return movieid;
        }

        public void setMovieid(Integer movieid) {
            this.movieid = movieid;
        }
        
        /**
         * Ruft den Wert der actors-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActors() {
            return actors;
        }

        /**
         * Legt den Wert der actors-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActors(String value) {
            this.actors = value;
        }

        /**
         * Ruft den Wert der genres-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGenres() {
            return genres;
        }

        /**
         * Legt den Wert der genres-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGenres(String value) {
            this.genres = value;
        }

        /**
         * Ruft den Wert der stocks-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Movies.Movie.Stocks }
         *     
         */
        public Movies.Movie.Stocks getStocks() {
            return stocks;
        }

        /**
         * Legt den Wert der stocks-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Movies.Movie.Stocks }
         *     
         */
        public void setStocks(Movies.Movie.Stocks value) {
            this.stocks = value;
        }

        /**
         * Ruft den Wert der name-Eigenschaft ab.
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
         * Legt den Wert der name-Eigenschaft fest.
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
         * Ruft den Wert der length-Eigenschaft ab.
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
         * Legt den Wert der length-Eigenschaft fest.
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
         * Ruft den Wert der format-Eigenschaft ab.
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
         * Legt den Wert der format-Eigenschaft fest.
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
         * Ruft den Wert der regiseur-Eigenschaft ab.
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
         * Legt den Wert der regiseur-Eigenschaft fest.
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
         * Ruft den Wert der image-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getImage() {
            return image;
        }

        /**
         * Legt den Wert der image-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setImage(String value) {
            this.image = value;
        }

        /**
         * Ruft den Wert der price-Eigenschaft ab.
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
         * Legt den Wert der price-Eigenschaft fest.
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
         * Ruft den Wert der date-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDate() {
            return date;
        }

        /**
         * Legt den Wert der date-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDate(XMLGregorianCalendar value) {
            this.date = value;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
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
         *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                 &lt;attribute name="lent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                 &lt;attribute name="return" type="{http://www.w3.org/2001/XMLSchema}date" />
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

            protected List<Movies.Movie.Stocks.Stock> stock;

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
             * {@link Movies.Movie.Stocks.Stock }
             * 
             * 
             */
            public List<Movies.Movie.Stocks.Stock> getStock() {
                if (stock == null) {
                    stock = new ArrayList<Movies.Movie.Stocks.Stock>();
                }
                return this.stock;
            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
             *       &lt;attribute name="lent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *       &lt;attribute name="return" type="{http://www.w3.org/2001/XMLSchema}date" />
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

                @XmlAttribute(name = "id")
                protected Integer id;
                @XmlAttribute(name = "lent")
                protected Boolean lent;
                @XmlAttribute(name = "return")
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar _return;

                /**
                 * Ruft den Wert der id-Eigenschaft ab.
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
                 * Legt den Wert der id-Eigenschaft fest.
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
                 * Ruft den Wert der lent-Eigenschaft ab.
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
                 * Legt den Wert der lent-Eigenschaft fest.
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
                 * Ruft den Wert der return-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getReturn() {
                    return _return;
                }

                /**
                 * Legt den Wert der return-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setReturn(XMLGregorianCalendar value) {
                    this._return = value;
                }

            }

        }

    }

}
