//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.05.07 um 07:22:39 PM CEST 
//


package adminclient.schema.movies;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Movies }
     * 
     */
    public Movies createMovies() {
        return new Movies();
    }

    /**
     * Create an instance of {@link Movies.Movie }
     * 
     */
    public Movies.Movie createMoviesMovie() {
        return new Movies.Movie();
    }

    /**
     * Create an instance of {@link Movies.Movie.Stocks }
     * 
     */
    public Movies.Movie.Stocks createMoviesMovieStocks() {
        return new Movies.Movie.Stocks();
    }

    /**
     * Create an instance of {@link Movies.Movie.Stocks.Stock }
     * 
     */
    public Movies.Movie.Stocks.Stock createMoviesMovieStocksStock() {
        return new Movies.Movie.Stocks.Stock();
    }

}
