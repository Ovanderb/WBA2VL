package restserver.resources;

import com.sun.research.ws.wadl.Resource;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restserver.MyMarshal;
import restserver.schema.genre.*;
import restserver.schema.genre.Genres.Genre;

@Path("genres")
public class GenreResource extends Resource {
    private MyMarshal marshal;
    private Genres data, genres;
    private Genre genre;
    private String link;
    private int index;

    public GenreResource() throws JAXBException, FileNotFoundException {
        this.marshal = new MyMarshal();
        this.data = this.marshal.toGenres();
        this.link = "/genres";
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
        if((this.genre = this.getGenre(id)) != null) { this.genres = new Genres(); this.genres.getGenre().add(this.genre); return Response.status(Response.Status.OK).entity(this.genres).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response put(String xml) throws JAXBException, FileNotFoundException {
        if((this.genres = this.marshal.toGenres(xml)) != null) {
            for(Genres.Genre g : this.genres.getGenre()) {
                g.setEdit(this.link + "/" + g.getId());
                g.setDelete(this.link + "/" + g.getId());
                this.data.getGenre().add(g);
            }
            
            this.data.setId(this.genres.getId());
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.CREATED).build();
        } return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response post(String xml) throws JAXBException, FileNotFoundException {
        if((this.genres = this.marshal.toGenres(xml)) != null) { int i; for(Genre g : this.genres.getGenre()) { if((i = this.getIndex(g.getId())) > -1) { this.data.getGenre().set(i, g); } else { return Response.status(Response.Status.NOT_FOUND).build(); } } this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response post(
            @PathParam("id") Integer id,
            @QueryParam("name") String name) throws JAXBException, FileNotFoundException {
        
        if((this.genre = this.getGenre(id)) != null) {
            if (name != null) { this.genre.setName(name); }
            
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.OK).build();
        } return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response delete(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.index = this.getIndex(id)) > -1) { if(this.data.getGenre().remove(this.index) != null) { this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    private int getIndex(Integer id) {
        for(int i = 0; i < this.data.getGenre().size(); i++) { Genre g = this.data.getGenre().get(i); if(g.getId().equals(id)) { return i; } }
        return -1;
    }
    
    private Genre getGenre(Integer id) {
        for(Genre g : this.data.getGenre()) { if(g.getId().equals(id)) { return g; } }
        return null;
    }
}