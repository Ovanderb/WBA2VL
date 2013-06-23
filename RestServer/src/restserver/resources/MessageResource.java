package restserver.resources;

import com.sun.research.ws.wadl.Resource;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.StringWriter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.Marshaller;
import org.jivesoftware.smack.XMPPException;

import restserver.RestServer;
import restserver.MyMarshal;
import restserver.XMPPPub;
import restserver.schema.message.*;
import restserver.schema.message.Messages.Message;
import restserver.schema.message.Messages.Message.Movie;

@Path("messages")
public class MessageResource extends Resource {
    private MyMarshal marshal;
    private Messages data, messages;
    private Message message;
    private String link;
    private int index;

    public MessageResource() throws JAXBException, FileNotFoundException {
        this.marshal = new MyMarshal();
        this.data = this.marshal.toMessages();
        this.link = "/message";
    }
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response get() {
        return Response.status(Response.Status.OK).entity(this.messages).build();
    }
    
    @GET
    @Path("{date}")
    @Produces(MediaType.APPLICATION_XML)
    public Response get(@PathParam("date") String date) {
        if((this.message = this.getMessage(date)) != null) { this.messages = new Messages(); this.messages.getMessage().add(this.message); return Response.status(Response.Status.OK).entity(this.messages).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response put(String xml) throws JAXBException, FileNotFoundException {
        if((this.messages = this.marshal.toMessages(xml)) != null) {
            for(Messages.Message m : this.messages.getMessage()) {
                if((this.message = this.getMessage(m.getDate())) != null) { for(Movie x : m.getMovie()) { x.setLink(RestServer.HOST + "movies/" + x.getId()); this.message.getMovie().add(x); } }
                else { for(Movie x : m.getMovie()) { x.setLink(RestServer.HOST + "movies/" + x.getId()); } this.data.getMessage().add(m); }
            }
            
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.CREATED).build();
        } return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
    
    
    
    @DELETE
    @Path("{date}")
    @Produces(MediaType.APPLICATION_XML)
    public Response delete(@PathParam("date") String date) throws JAXBException, FileNotFoundException {
        if((this.index = this.getIndex(date)) > -1) { if(this.data.getMessage().remove(this.index) != null) { this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @GET
    @Path("{date}/send")
    @Produces(MediaType.APPLICATION_XML)
    public Response sendmsg(@PathParam("date") String date) throws JAXBException, XMPPException {
        if((this.message = this.getMessage(date)) != null) { 
            this.messages = new Messages(); 
            this.messages.getMessage().add(this.message);
            StringWriter sw = new StringWriter();
            Marshaller marsh = this.marshal.getMessageMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            /*
             * Wichtig hierbei ist es, dass der XML String keinen XML Deklaration
             * hat. Sonst funktioniert der XMPP publish nicht richtig.
             */
            marsh.setProperty("jaxb.fragment", Boolean.TRUE);
            marsh.marshal(this.messages, sw);
            /*
             * Hier wird eine Instanz der Publishing Klasse des XMPP erzeugt.
             * Dadurch kann das Publishen der Message mittels der Resource /send
             * durchgeführt werden.
             */
            XMPPPub xmp = new XMPPPub("testsub","testsub");
            xmp.publishItem(sw.toString());
            return Response.status(Response.Status.OK).build(); 
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    private int getIndex(String date) {
        for(int i = 0; i < this.data.getMessage().size(); i++) { Message m = this.data.getMessage().get(i); if(m.getDate().equals(date)) { return i; } }
        return -1;
    }
    
    private Message getMessage(String date) {
        for(Message m : this.data.getMessage()) { if(m.getDate().equals(date)) { return m; } }
        return null;
    }
}
