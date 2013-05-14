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
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import restserver.schema.accounts.Accounts;
import restserver.schema.actors.Actors;
import restserver.schema.bills.Bills;
import restserver.schema.genres.Genres;
import restserver.schema.messages.Message;
import restserver.schema.movies.Movies;
/**
 * Klasse um die generellen Marshalling und Unmarshalling Funktionalitäten
 * der einzelnen JAXB Klassen respektive der einzelnen Resourcen zur Verfügung
 * zu stellen.
 * 
 * @author Olli
 */
public class MyMarshal {

    JAXBContext acc;
    JAXBContext act;
    JAXBContext bil;
    JAXBContext gen;
    JAXBContext mes;
    JAXBContext mov;
    String Pfad;

    public MyMarshal() throws JAXBException {
        this.Pfad = System.getProperty("user.dir") + "/XML/";
        this.acc = JAXBContext.newInstance(Accounts.class);
        this.act = JAXBContext.newInstance(Actors.class);
        this.bil = JAXBContext.newInstance(Bills.class);
        this.gen = JAXBContext.newInstance(Genres.class);
        this.mes = JAXBContext.newInstance(Message.class);
        this.mov = JAXBContext.newInstance(Movies.class);
    }

    /**
     * unmarshal Account XML out of saved File
     *
     * @return
     * @throws JAXBException
     */
    public Accounts uacc() throws JAXBException, FileNotFoundException {
        Unmarshaller m = acc.createUnmarshaller();
        Accounts a = (Accounts) m.unmarshal(new FileInputStream(Pfad + "accounts.xml"));
        return a;
    }

    /**
     * unmarshal 
     *
     * @return
     * @throws JAXBException
     */
    public Accounts uacc(String s) throws JAXBException {
        Unmarshaller m = acc.createUnmarshaller();
        StringReader reader = new StringReader(s);
        Accounts a = (Accounts) m.unmarshal(reader);
        return a;
    }

    /**
     * marshal
     *
     * @return
     * @throws JAXBException
     */
    public void macc(Accounts a) throws JAXBException, FileNotFoundException {
        Marshaller m = acc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        FileOutputStream f = new FileOutputStream(Pfad + "accounts.xml");
        m.marshal(a, f);
    }

    /**
     * unmarshal Actor XML out of saved File
     *
     * @return
     * @throws JAXBException
     */
    public Actors uact() throws JAXBException, FileNotFoundException {
        Unmarshaller m = act.createUnmarshaller();
        Actors a = (Actors) m.unmarshal(new FileInputStream(Pfad + "actors.xml"));
        return a;
    }

    /**
     * unmarshal
     *
     * @return
     * @throws JAXBException
     */
    public Actors uact(String s) throws JAXBException {
        Unmarshaller m = act.createUnmarshaller();
        StringReader reader = new StringReader(s);
        Actors a = (Actors) m.unmarshal(reader);
        return a;
    }

    /**
     * marshal
     *
     * @return
     * @throws JAXBException
     */
    public void mact(Actors a) throws JAXBException, FileNotFoundException {
        Marshaller m = act.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        FileOutputStream f = new FileOutputStream(Pfad + "actors.xml");
        m.marshal(a, f);
    }

    /**
     * unmarshal Bills XML out of saved File
     *
     * @return
     * @throws JAXBException
     */
    public Bills ubil() throws JAXBException, FileNotFoundException {
        Unmarshaller m = bil.createUnmarshaller();
        Bills a = (Bills) m.unmarshal(new FileInputStream(Pfad + "bills.xml"));
        return a;
    }

    /**
     * unmarshal
     *
     * @return
     * @throws JAXBException
     */
    public Bills ubil(String s) throws JAXBException {
        Unmarshaller m = bil.createUnmarshaller();
        StringReader reader = new StringReader(s);
        Bills a = (Bills) m.unmarshal(reader);
        return a;
    }

    /**
     * marshal
     *
     * @return
     * @throws JAXBException
     */
    public void mbil(Bills a) throws JAXBException, FileNotFoundException {
        Marshaller m = bil.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        FileOutputStream f = new FileOutputStream(Pfad + "bills.xml");
        m.marshal(a, f);
    }

    /**
     * unmarshal Genres XML out of saved File
     *
     * @return
     * @throws JAXBException
     */
    public Genres ugen() throws JAXBException, FileNotFoundException {
        Unmarshaller m = gen.createUnmarshaller();
        Genres a = (Genres) m.unmarshal(new FileInputStream(Pfad + "genres.xml"));
        return a;
    }

    /**
     * unmarshal
     *
     * @return
     * @throws JAXBException
     */
    public Genres ugen(String s) throws JAXBException {
        Unmarshaller m = gen.createUnmarshaller();
        StringReader reader = new StringReader(s);
        Genres a = (Genres) m.unmarshal(reader);
        return a;
    }

    /**
     * marshal
     *
     * @return
     * @throws JAXBException
     */
    public void mgen(Genres a) throws JAXBException, FileNotFoundException {
        Marshaller m = gen.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        FileOutputStream f = new FileOutputStream(Pfad + "genres.xml");
        m.marshal(a, f);
    }

    /**
     * unmarshal Messages XML out of saved File
     *
     * @return
     * @throws JAXBException
     */
    public Message umes() throws JAXBException, FileNotFoundException {
        Unmarshaller m = mes.createUnmarshaller();
        Message a = (Message) m.unmarshal(new FileInputStream(Pfad + "message.xml"));
        return a;
    }

    /**
     * unmarshal
     *
     * @return
     * @throws JAXBException
     */
    public Message umes(String s) throws JAXBException {
        Unmarshaller m = mes.createUnmarshaller();
        StringReader reader = new StringReader(s);
        Message a = (Message) m.unmarshal(reader);
        return a;
    }

    /**
     * marshal
     *
     * @return
     * @throws JAXBException
     */
    public void mmes(Message a) throws JAXBException, FileNotFoundException {
        Marshaller m = mes.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        FileOutputStream f = new FileOutputStream(Pfad + "message.xml");
        m.marshal(a, f);
    }

    /**
     * unmarshal Movies XML out of saved File
     *
     * @return
     * @throws JAXBException
     */
    public Movies umov() throws JAXBException, FileNotFoundException {
        Unmarshaller m = mov.createUnmarshaller();
        Movies a = (Movies) m.unmarshal(new FileInputStream(Pfad + "movies.xml"));
        return a;
    }

    /**
     * unmarshal
     *
     * @return
     * @throws JAXBException
     */
    public Movies umov(String s) throws JAXBException {
        Unmarshaller m = mov.createUnmarshaller();
        StringReader reader = new StringReader(s);
        Movies a = (Movies) m.unmarshal(reader);
        return a;
    }

    /**
     * marshal
     *
     * @return
     * @throws JAXBException
     */
    public void mmov(Movies a) throws JAXBException, FileNotFoundException {
        Marshaller m = mov.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        FileOutputStream f = new FileOutputStream(Pfad + "movies.xml");
        m.marshal(a, f);
    }

    public XMLGregorianCalendar strToXmlGreg(String s) throws ParseException, DatatypeConfigurationException {
        XMLGregorianCalendar result;
        Date normaldate;
        SimpleDateFormat simpleDateFormat;
        GregorianCalendar gregorianCalendar;
        
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        normaldate = simpleDateFormat.parse(s);
        gregorianCalendar =
                (GregorianCalendar) GregorianCalendar.getInstance();
        gregorianCalendar.setTime(normaldate);
        result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        return result;
    }
}
