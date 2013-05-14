package restserver.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.text.ParseException;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import restserver.MyMarshal;
import restserver.schema.messages.*;

@Path("message")
public class MessageResource {
    private MyMarshal m;

    public MessageResource() throws JAXBException {
        this.m = new MyMarshal();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Message Get() throws JAXBException, FileNotFoundException {
        return this.m.umes();
    }

    @PUT
    @Consumes( MediaType.APPLICATION_XML )
    @Produces(MediaType.APPLICATION_XML)
    public Response Put(String s) throws FileNotFoundException, JAXBException {
        Message existingobj = this.m.umes();
        Message newobj = this.m.umes(s);
        existingobj.getMovie().add(newobj.getMovie().get(0));
        this.m.mmes(existingobj);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response messageGet(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        Message a = this.m.umes();
        for (Message.Movie o: a.getMovie()){
            if(o.getId().equals(id)){
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
            @QueryParam("desc") String description
            ) throws JAXBException, FileNotFoundException, ParseException, DatatypeConfigurationException {
        Message a = this.m.umes();
        for (Message.Movie accs : a.getMovie()) {
            if (accs.getId().equals(id)) {
                if (name != null) {
                    accs.setName(name);
                }
                if (date != null) {
                    accs.setDate(this.m.strToXmlGreg(date));
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
                this.m.mmes(a);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{message}")
    @Produces(MediaType.APPLICATION_XML)
    public Response messageDelete(@PathParam("id") String id) throws JAXBException, FileNotFoundException {
        Message a = this.m.umes();
        int i = 0;
        for (Message.Movie accs: a.getMovie()){
            if(accs.getName().equals(id)){
                a.getMovie().remove(i);
                this.m.mmes(a);
                return Response.status(200).build();
            }
            i++;
        }
        return Response.status(404).build();
    }
}