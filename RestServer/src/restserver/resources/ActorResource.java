/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restserver.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import restserver.MyMarshal;
import restserver.schema.actors.*;

@Path("actors")
public class ActorResource {
    private FileOutputStream f;
    private MyMarshal m;

    public ActorResource() throws JAXBException {
        this.m = new MyMarshal();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response Get() throws JAXBException, FileNotFoundException {
        return Response.status(Response.Status.OK).entity(this.m.uact()).build();
    }

    @PUT
    @Consumes( MediaType.APPLICATION_XML )
    @Produces(MediaType.APPLICATION_XML)
    public Response Put(String s) throws JAXBException, FileNotFoundException {
        Actors existingActors = this.m.uact();
        Actors newAccounts = this.m.uact(s);
        existingActors.getActor().add(newAccounts.getActor().get(0));
        this.m.mact(existingActors);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uGet(@PathParam("id") String id) throws JAXBException, FileNotFoundException {
        Actors a = this.m.uact();
        for (Actors.Actor o: a.getActor()){
            if(o.getName().equals(id)){
                return Response.status(Response.Status.OK).entity(o).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uPost(
            @PathParam("actname") String id,
            @QueryParam("newname") String name) throws JAXBException, FileNotFoundException, ParseException, DatatypeConfigurationException {
        Actors a = this.m.uact();
        for (Actors.Actor accs : a.getActor()) {
            if (accs.getName().equals(id)) {
                if (name != null) {
                    accs.setName(name);
                }
                this.m.mact(a);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uDelete(@PathParam("id") String id) throws JAXBException, FileNotFoundException {
        Actors a = this.m.uact();
        int i = 0;
        for (Actors.Actor accs: a.getActor()){
            if(accs.getName().equals(id)){
                a.getActor().remove(i);
                this.m.mact(a);
                return Response.status(Response.Status.OK).build();
            }
            i++;
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
