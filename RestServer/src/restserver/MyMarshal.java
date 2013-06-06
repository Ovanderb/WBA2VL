/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restserver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import restserver.schema.account.list.Accountlist;
import restserver.schema.account.Accounts;
import restserver.schema.actor.Actors;
import restserver.schema.bill.Bills;
import restserver.schema.genre.Genres;
import restserver.schema.message.Message;
import restserver.schema.movie.Movies;
import restserver.schema.movie.list.Movielist;

/**
 * Klasse um die generellen Marshalling und Unmarshalling Funktionalitäten
 * der einzelnen JAXB Klassen respektive der einzelnen Resourcen zur Verfügung
 * zu stellen.
 * 
 * @author Olli
 * @author Nico
 */
public class MyMarshal {
    JAXBContext accountlist;
    JAXBContext accounts;
    JAXBContext actors;
    JAXBContext bills;
    JAXBContext genres;
    JAXBContext message;
    JAXBContext movies;
    JAXBContext movielist;
    String path;
    
    public MyMarshal() throws JAXBException {
        this.accountlist = JAXBContext.newInstance(Accountlist.class);
        this.accounts = JAXBContext.newInstance(Accounts.class);
        this.actors = JAXBContext.newInstance(Actors.class);
        this.bills = JAXBContext.newInstance(Bills.class);
        this.genres = JAXBContext.newInstance(Genres.class);
        this.message = JAXBContext.newInstance(Message.class);
        this.movies = JAXBContext.newInstance(Movies.class);
        this.movielist = JAXBContext.newInstance(Movielist.class);
        this.path = System.getProperty("user.dir") + "/XML/";
    }

    /**
     * unmarshal Accounts out of Savefile
     *
     * @return Accounts
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public Accounts toAccounts() throws JAXBException, FileNotFoundException {
        return (Accounts) this.accounts.createUnmarshaller().unmarshal(new FileInputStream(this.path + "accounts.xml"));
    }

    /**
     * unmarshal Accounts out of String
     *
     * @return Accounts
     * @throws JAXBException
     */
    public Accounts toAccounts(String xml) throws JAXBException {
        return (Accounts) this.accounts.createUnmarshaller().unmarshal(new StringReader(xml));
    }

    /**
     * marshal Accounts into Savefile
     *
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public void doAccounts(Accounts accounts) throws JAXBException, FileNotFoundException {
        this.accounts.createMarshaller().marshal(accounts, new FileOutputStream(this.path + "accounts.xml"));
    }
    
    /**
     * unmarshal Actors out of Savefile
     *
     * @return Actors
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public Actors toActors() throws JAXBException, FileNotFoundException {
        return (Actors) this.actors.createUnmarshaller().unmarshal(new FileInputStream(this.path + "actors.xml"));
    }

    /**
     * unmarshal Actors out of String
     *
     * @return Actors
     * @throws JAXBException
     */
    public Actors toActors(String xml) throws JAXBException {
        return (Actors) this.actors.createUnmarshaller().unmarshal(new StringReader(xml));
    }

    /**
     * marshal Actors into Savefile
     *
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public void doActors(Actors actors) throws JAXBException, FileNotFoundException {
        this.actors.createMarshaller().marshal(actors, new FileOutputStream(this.path + "actors.xml"));
    }
    
    /**
     * unmarshal Bills out of Savefile
     *
     * @return Bills
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public Bills toBills() throws JAXBException, FileNotFoundException {
        return (Bills) this.bills.createUnmarshaller().unmarshal(new FileInputStream(this.path + "bills.xml"));
    }

    /**
     * unmarshal Bills out of String
     *
     * @return Bills
     * @throws JAXBException
     */
    public Bills toBills(String xml) throws JAXBException {
        return (Bills) this.bills.createUnmarshaller().unmarshal(new StringReader(xml));
    }

    /**
     * marshal Bills into Savefile
     *
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public void doBills(Bills bills) throws JAXBException, FileNotFoundException {
        this.bills.createMarshaller().marshal(bills, new FileOutputStream(this.path + "bills.xml"));
    }
    
    /**
     * unmarshal Genres out of Savefile
     *
     * @return Genres
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public Genres toGenres() throws JAXBException, FileNotFoundException {
        return (Genres) this.genres.createUnmarshaller().unmarshal(new FileInputStream(this.path + "genres.xml"));
    }

    /**
     * unmarshal Genres out of String
     *
     * @return Genres
     * @throws JAXBException
     */
    public Genres toGenres(String xml) throws JAXBException {
        return (Genres) this.genres.createUnmarshaller().unmarshal(new StringReader(xml));
    }

    /**
     * marshal Genres into Savefile
     *
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public void doGenres(Genres genres) throws JAXBException, FileNotFoundException {
        this.genres.createMarshaller().marshal(genres, new FileOutputStream(this.path + "genres.xml"));
    }
    
    /**
     * unmarshal Message out of Savefile
     *
     * @return Movies
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public Message toMessage() throws JAXBException, FileNotFoundException {
        return (Message) this.message.createUnmarshaller().unmarshal(new FileInputStream(this.path + "message.xml"));
    }

    /**
     * unmarshal Message out of String
     *
     * @return Movies
     * @throws JAXBException
     */
    public Message toMessage(String xml) throws JAXBException {
        return (Message) this.message.createUnmarshaller().unmarshal(new StringReader(xml));
    }

    /**
     * marshal Message into Savefile
     *
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public void doMessage(Message message) throws JAXBException, FileNotFoundException {
        this.message.createMarshaller().marshal(message, new FileOutputStream(this.path + "message.xml"));
    }
    
    /**
     * unmarshal Movies out of Savefile
     *
     * @return Movies
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public Movies toMovies() throws JAXBException, FileNotFoundException {
        return (Movies) this.movies.createUnmarshaller().unmarshal(new FileInputStream(this.path + "movies.xml"));
    }

    /**
     * unmarshal Movies out of String
     *
     * @return Movies
     * @throws JAXBException
     */
    public Movies toMovies(String xml) throws JAXBException {
        return (Movies) this.movies.createUnmarshaller().unmarshal(new StringReader(xml));
    }

    /**
     * marshal Movies into Savefile
     *
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public void doMovies(Movies movies) throws JAXBException, FileNotFoundException {
        this.movies.createMarshaller().marshal(movies, new FileOutputStream(this.path + "movies.xml"));
    }
    
    /**
     * unmarshal Accountlist out of String
     *
     * @return Accountlist
     * @throws JAXBException
     */
    public Accountlist toAccountlist(String xml) throws JAXBException {
        return (Accountlist) this.accountlist.createUnmarshaller().unmarshal(new StringReader(xml));
    }
    
    /**
     * unmarshal Movielist out of String
     *
     * @return Movielist
     * @throws JAXBException
     */
    public Movielist toMovielist(String xml) throws JAXBException {
        return (Movielist) this.movielist.createUnmarshaller().unmarshal(new StringReader(xml));
    }
    
    /**
     * 
     * @param s
     * @return
     * @throws ParseException
     * @throws DatatypeConfigurationException 
     */
    public XMLGregorianCalendar toDate(String x) throws ParseException, DatatypeConfigurationException {
        GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
        gc.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(x));
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
    }
}
