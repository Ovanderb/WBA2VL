//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.04.30 um 11:47:18 PM CEST 
//


package generated;

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
     * Create an instance of {@link Movies.Movie.Generes }
     * 
     */
    public Movies.Movie.Generes createMoviesMovieGeneres() {
        return new Movies.Movie.Generes();
    }

    /**
     * Create an instance of {@link Movies.Movie.Actors }
     * 
     */
    public Movies.Movie.Actors createMoviesMovieActors() {
        return new Movies.Movie.Actors();
    }

    /**
     * Create an instance of {@link Movies.Movie.Date }
     * 
     */
    public Movies.Movie.Date createMoviesMovieDate() {
        return new Movies.Movie.Date();
    }

    /**
     * Create an instance of {@link Movies.Movie.Generes.Genere }
     * 
     */
    public Movies.Movie.Generes.Genere createMoviesMovieGeneresGenere() {
        return new Movies.Movie.Generes.Genere();
    }

    /**
     * Create an instance of {@link Movies.Movie.Actors.Actor }
     * 
     */
    public Movies.Movie.Actors.Actor createMoviesMovieActorsActor() {
        return new Movies.Movie.Actors.Actor();
    }

}
