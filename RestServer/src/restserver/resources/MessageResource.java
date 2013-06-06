package restserver.resources;

import restserver.schema.message.Message;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.text.ParseException;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import restserver.MyMarshal;
import restserver.PublishSub;
import restserver.XConnection;

@Path("message")
public class MessageResource {

    private MyMarshal marshal;
    private String username = "testuser";
    private String password = "password";
    private String jid = "testuser@olli-pc";
    
    public MessageResource() throws JAXBException {
        this.marshal = new MyMarshal();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Message Get() throws JAXBException, FileNotFoundException {
        return this.marshal.toMessage();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response Put(String s) throws FileNotFoundException, JAXBException {
        Message existingobj = this.marshal.toMessage();
        Message newobj = this.marshal.toMessage(s);
        existingobj.getMovie().add(newobj.getMovie().get(0));
        this.marshal.doMessage(existingobj);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response messageGet(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        Message a = this.marshal.toMessage();
        for (Message.Movie o : a.getMovie()) {
            if (o.getId().equals(id)) {
                return Response.status(Response.Status.OK).entity(o).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response messagePost(
            @PathParam("id") Integer id,
            @QueryParam("name") String name,
            @QueryParam("date") String date,
            @QueryParam("img") String img,
            @QueryParam("link") String link,
            @QueryParam("desc") String description) throws JAXBException, FileNotFoundException, ParseException, DatatypeConfigurationException {
        Message a = this.marshal.toMessage();
        for (Message.Movie accs : a.getMovie()) {
            if (accs.getId().equals(id)) {
                if (name != null) {
                    accs.setName(name);
                }
                if (date != null) {
                    accs.setDate(this.marshal.toDate(date));
                }
                if (img != null) {
                    accs.setImage(img);
                }
                if (link != null) {
                    accs.setLink(link);
                }
                if (description != null) {
                    accs.setDiscription(description);
                }
                this.marshal.doMessage(a);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{message}")
    @Produces(MediaType.APPLICATION_XML)
    public Response messageDelete(@PathParam("id") String id) throws JAXBException, FileNotFoundException {
        Message a = this.marshal.toMessage();
        int i = 0;
        for (Message.Movie accs : a.getMovie()) {
            if (accs.getName().equals(id)) {
                a.getMovie().remove(i);
                this.marshal.doMessage(a);
                return Response.status(200).build();
            }
            i++;
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("{id}/send")
    @Produces(MediaType.APPLICATION_XML)
    public Response messageSend(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException, XMPPException{
        Message msg = this.marshal.toMessage();
        for (Message.Movie o : msg.getMovie()){
            if (o.getId().equals(id)) {
                XConnection c = new XConnection(this.username, this.password);
                PublishSub pubsub = new PublishSub(c.getConnection());
                LeafNode movienews = pubsub.getManager().getNode("movienews");
                //SimplePayload payload = new SimplePayload("book",null,this.marshal.doMessage(o));
                //PayloadItem paylitm = new PayloadItem("check",payload);
                //movienews.publish(paylitm);
                //System.out.println(paylitm.toXML());
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}