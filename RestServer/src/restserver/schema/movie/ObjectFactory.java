//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.10 at 05:33:46 PM MESZ 
//


package restserver.schema.movie;

import javax.xml.bind.annotation.XmlRegistry;
import restserver.schema.movie.Movies.Movie;
import restserver.schema.movie.Movies.Movie.Actors;
import restserver.schema.movie.Movies.Movie.Actors.Actor;
import restserver.schema.movie.Movies.Movie.Genres;
import restserver.schema.movie.Movies.Movie.Genres.Genre;
import restserver.schema.movie.Movies.Movie.Stocks;
import restserver.schema.movie.Movies.Movie.Stocks.Stock;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the restserver.schema.movie package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: restserver.schema.movie
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Actor }
     * 
     */
    public Actor createMoviesMovieActorsActor() {
        return new Actor();
    }

    /**
     * Create an instance of {@link Stock }
     * 
     */
    public Stock createMoviesMovieStocksStock() {
        return new Stock();
    }

    /**
     * Create an instance of {@link Genre }
     * 
     */
    public Genre createMoviesMovieGenresGenre() {
        return new Genre();
    }

    /**
     * Create an instance of {@link Stocks }
     * 
     */
    public Stocks createMoviesMovieStocks() {
        return new Stocks();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMoviesMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link Genres }
     * 
     */
    public Genres createMoviesMovieGenres() {
        return new Genres();
    }

    /**
     * Create an instance of {@link Movies }
     * 
     */
    public Movies createMovies() {
        return new Movies();
    }

    /**
     * Create an instance of {@link Actors }
     * 
     */
    public Actors createMoviesMovieActors() {
        return new Actors();
    }

}
