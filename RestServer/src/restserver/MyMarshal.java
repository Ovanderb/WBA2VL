package restserver;

import java.io.StringReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.text.ParseException;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import restserver.schema.account.Accounts;
import restserver.schema.actor.Actors;
import restserver.schema.bill.Bills;
import restserver.schema.genre.Genres;
import restserver.schema.message.Messages;
import restserver.schema.movie.Movies;

public class MyMarshal {
    JAXBContext accounts;
    JAXBContext actors;
    JAXBContext bills;
    JAXBContext genres;
    JAXBContext messages;
    JAXBContext movies;
    String path;
    
    public MyMarshal() throws JAXBException {
        this.accounts = JAXBContext.newInstance(Accounts.class);
        this.actors = JAXBContext.newInstance(Actors.class);
        this.bills = JAXBContext.newInstance(Bills.class);
        this.genres = JAXBContext.newInstance(Genres.class);
        this.messages = JAXBContext.newInstance(Messages.class);
        this.movies = JAXBContext.newInstance(Movies.class);
        this.path = System.getProperty("user.dir") + "/xml";
    }
    
    public Accounts toAccounts() throws JAXBException, FileNotFoundException {
        return (Accounts) this.accounts.createUnmarshaller().unmarshal(new FileInputStream(this.path + "/accounts.xml"));
    }
    
    public Actors toActors() throws JAXBException, FileNotFoundException {
        return (Actors) this.actors.createUnmarshaller().unmarshal(new FileInputStream(this.path + "/actors.xml"));
    }
    
    public Bills toBills() throws JAXBException, FileNotFoundException {
        return (Bills) this.bills.createUnmarshaller().unmarshal(new FileInputStream(this.path + "/bills.xml"));
    }
    
    public Genres toGenres() throws JAXBException, FileNotFoundException {
        return (Genres) this.genres.createUnmarshaller().unmarshal(new FileInputStream(this.path + "/genres.xml"));
    }
    
    public Messages toMessages() throws JAXBException, FileNotFoundException {
        return (Messages) this.messages.createUnmarshaller().unmarshal(new FileInputStream(this.path + "/messages.xml"));
    }
    
    public Movies toMovies() throws JAXBException, FileNotFoundException {
        return (Movies) this.movies.createUnmarshaller().unmarshal(new FileInputStream(this.path + "/movies.xml"));
    }
    
    
    
    public Accounts toAccounts(String xml) throws JAXBException {
        return (Accounts) this.accounts.createUnmarshaller().unmarshal(new StringReader(xml));
    }
    
    public Actors toActors(String xml) throws JAXBException {
        return (Actors) this.actors.createUnmarshaller().unmarshal(new StringReader(xml));
    }
    
    public Bills toBills(String xml) throws JAXBException {
        return (Bills) this.bills.createUnmarshaller().unmarshal(new StringReader(xml));
    }
    
    public Genres toGenres(String xml) throws JAXBException {
        return (Genres) this.genres.createUnmarshaller().unmarshal(new StringReader(xml));
    }
    
    public Messages toMessages(String xml) throws JAXBException {
        return (Messages) this.messages.createUnmarshaller().unmarshal(new StringReader(xml));
    }
    
    public Marshaller getMessageMarshaller() throws JAXBException{
        return this.messages.createMarshaller();
    }
    
    public Movies toMovies(String xml) throws JAXBException {
        return (Movies) this.movies.createUnmarshaller().unmarshal(new StringReader(xml));
    }
    
    
    
    public void doSave(Accounts accounts) throws JAXBException, FileNotFoundException {
        this.accounts.createMarshaller().marshal(accounts, new FileOutputStream(this.path + "/accounts.xml"));
    }
    
    public void doSave(Actors actors) throws JAXBException, FileNotFoundException {
        this.actors.createMarshaller().marshal(actors, new FileOutputStream(this.path + "/actors.xml"));
    }
    
    public void doSave(Bills bills) throws JAXBException, FileNotFoundException {
        this.bills.createMarshaller().marshal(bills, new FileOutputStream(this.path + "/bills.xml"));
    }
    
    public void doSave(Genres genres) throws JAXBException, FileNotFoundException {
        this.genres.createMarshaller().marshal(genres, new FileOutputStream(this.path + "/genres.xml"));
    }
    
    public void doSave(Messages messages) throws JAXBException, FileNotFoundException {
        this.messages.createMarshaller().marshal(messages, new FileOutputStream(this.path + "/messages.xml"));
    }
    
    public void doSave(Movies movies) throws JAXBException, FileNotFoundException {
        this.movies.createMarshaller().marshal(movies, new FileOutputStream(this.path + "/movies.xml"));
    }
    
    
    public String toDate(Date d) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(d);
    }
    
    public String toDate(String d) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat tf = new SimpleDateFormat("dd.MM.yyyy");
        try { return tf.format(sf.parse(d)); } catch(ParseException e1) {
            try { return sf.format(tf.parse(d)); } catch(ParseException e2) {}
        } return this.toDate(this.toDate(new Date()));
    }
}
