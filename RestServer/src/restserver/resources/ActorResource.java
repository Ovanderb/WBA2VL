package restserver.resources;

import com.sun.research.ws.wadl.Resource;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restserver.MyMarshal;
import restserver.schema.actor.*;
import restserver.schema.actor.Actors.Actor;

@Path("actors")
public class ActorResource extends Resource {
    private MyMarshal marshal;
    private Actors data, actors;
    private Actor actor;
    private String link;
    private int index;

    public ActorResource() throws JAXBException, FileNotFoundException {
        this.marshal = new MyMarshal();
        this.data = this.marshal.toActors();
        this.link = "/actors";
    }
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response get() {
        return Response.status(Response.Status.OK).entity(this.data).build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response get(@PathParam("id") Integer id) {
        if((this.actor = this.getActor(id)) != null) { this.actors = new Actors(); this.actors.getActor().add(this.actor); return Response.status(Response.Status.OK).entity(this.actors).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response put(String xml) throws JAXBException, FileNotFoundException {
        if((this.actors = this.marshal.toActors(xml)) != null) {
            for(Actors.Actor a : this.actors.getActor()) {
                a.setEdit(this.link + "/" + a.getId());
                a.setDelete(this.link + "/" + a.getId());
                this.data.getActor().add(a);
            }
            
            this.data.setId(this.actors.getId());
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.CREATED).build();
        } return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response post(String xml) throws JAXBException, FileNotFoundException {
        if((this.actors = this.marshal.toActors(xml)) != null) { int i; for(Actor a : this.actors.getActor()) { if((i = this.getIndex(a.getId())) > -1) { this.data.getActor().set(i, a); } else { return Response.status(Response.Status.NOT_FOUND).build(); } } this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response post(
            @PathParam("id") Integer id,
            @QueryParam("name") String name) throws JAXBException, FileNotFoundException {
        
        if((this.actor = this.getActor(id)) != null) {
            if (name != null) { this.actor.setName(name); }
            
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.OK).build();
        } return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response delete(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.index = this.getIndex(id)) > -1) { if(this.data.getActor().remove(this.index) != null) { this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    private int getIndex(Integer id) {
        for(int i = 0; i < this.data.getActor().size(); i++) { Actor a = this.data.getActor().get(i); if(a.getId().equals(id)) { return i; } }
        return -1;
    }
    
    private Actor getActor(Integer id) {
        for(Actor a : this.data.getActor()) { if(a.getId().equals(id)) { return a; } }
        return null;
    }
}
