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
import restserver.schema.genres.*;

@Path("genres")
public class GenreResource {
    private FileOutputStream f;
    private MyMarshal m;

    public GenreResource() throws JAXBException {
        this.m = new MyMarshal();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Genres Get() throws JAXBException, FileNotFoundException {
        return this.m.ugen();
    }

    @PUT
    @Consumes( MediaType.APPLICATION_XML )
    @Produces(MediaType.APPLICATION_XML)
    public Response Put(String s) throws FileNotFoundException, JAXBException {
        Genres existingobj = this.m.ugen();
        Genres newobj = this.m.ugen(s);
        existingobj.getGenre().add(newobj.getGenre().get(0));
        this.m.mgen(existingobj);
        return Response.status(201).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Genres.Genre uGet(@PathParam("id") String id) throws JAXBException, FileNotFoundException {
        Genres a = this.m.ugen();
        for (Genres.Genre o: a.getGenre()){
            if(o.getName().equals(id)){
                return o;
            }
        }
        return null;
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uPost(
            @PathParam("genrename") String id,
            @QueryParam("newname") String name
            ) throws JAXBException, FileNotFoundException, ParseException, DatatypeConfigurationException {
        Genres a = this.m.ugen();
        for (Genres.Genre accs : a.getGenre()) {
            if (accs.getName().equals(id)) {
                if (name != null) {
                    accs.setName(name);
                }
                this.m.mgen(a);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uDelete(@PathParam("id") String id) throws JAXBException, FileNotFoundException {
        Genres a = this.m.ugen();
        int i = 0;
        for (Genres.Genre accs: a.getGenre()){
            if(accs.getName().equals(id)){
                a.getGenre().remove(i);
                this.m.mgen(a);
                return Response.status(200).build();
            }
            i++;
        }
        return Response.status(404).build();
    }
}
