package restserver.resources;

import com.sun.research.ws.wadl.Resource;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restserver.MyMarshal;
import restserver.schema.movie.*;
import restserver.schema.movie.Movies.Movie;
import restserver.schema.movie.Movies.Movie.Stocks;
import restserver.schema.movie.Movies.Movie.Genres;
import restserver.schema.movie.Movies.Movie.Actors;
import restserver.schema.movie.Movies.Movie.Stocks.Stock;
import restserver.schema.movie.Movies.Movie.Genres.Genre;
import restserver.schema.movie.Movies.Movie.Actors.Actor;

@Path("movies")
public class MovieResource extends Resource {
    private MyMarshal marshal;
    private Movies data, movies;
    private Movie movie;
    private Stock stock;
    private String link;
    private int index;

    public MovieResource() throws JAXBException, FileNotFoundException {
        this.marshal = new MyMarshal();
        this.data = this.marshal.toMovies();
        this.link = "/movies";
    }
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response get() {
        return Response.status(Response.Status.OK).entity(this.data).build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response get(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.movie = this.getMovie(id)) != null) { this.movies = new Movies(); this.movies.getMovie().add(this.movie); return Response.status(Response.Status.OK).entity(this.movies).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response put(String xml) throws JAXBException, FileNotFoundException {
        if((this.movies = this.marshal.toMovies(xml)) != null) {
            for(Movies.Movie m : this.movies.getMovie()) {
                m.setEdit(this.link + "/" + m.getId());
                m.setDelete(this.link + "/" + m.getId());
                this.data.getMovie().add(m);
            }
            
            this.data.setId(this.movies.getId());
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.CREATED).build();
        } return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
    
    @PUT
    @Path("{id}/genres/{genre}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response putGenre(
            @PathParam("id") Integer id,
            @QueryParam("genre") Integer genre) throws JAXBException, FileNotFoundException {
        
        if((this.index = this.getIndex(id)) > -1) {
            if(genre != null) { Genre g = new Genre(); g.setId(genre); this.data.getMovie().get(this.index).getGenres().getGenre().add(g); }
            
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.OK).build();
        } return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @PUT
    @Path("{id}/actors/{actor}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response putActor(
            @PathParam("id") Integer id,
            @QueryParam("actor") Integer actor) throws JAXBException, FileNotFoundException {
        
        if((this.index = this.getIndex(id)) > -1) {
            if(actor != null) { Actor a = new Actor(); a.setId(actor); this.data.getMovie().get(this.index).getActors().getActor().add(a); }
            
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.OK).build();
        } return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response post(String xml) throws JAXBException, FileNotFoundException {
        if((this.movies = this.marshal.toMovies(xml)) != null) { int i; for(Movie m : this.movies.getMovie()) { if((i = this.getIndex(m.getId())) > -1) { this.data.getMovie().set(i, m); } else { return Response.status(Response.Status.NOT_FOUND).build(); } } this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response post(
            @PathParam("id") Integer id,
            @QueryParam("name") String name,
            @QueryParam("date") String date,
            @QueryParam("length") Integer length,
            @QueryParam("price") Float price,
            @QueryParam("discription") String discription,
            @QueryParam("regiseur") String regiseur) throws JAXBException, FileNotFoundException {
        
        if((this.movie = this.getMovie(id)) != null) {
            if (name != null) { this.movie.setName(name); }
            if (date != null) { this.movie.setDate(this.marshal.toDate(date)); }
            if (length != null) { this.movie.setLength(length); }
            if (price != null) { this.movie.setPrice(price); }
            if (discription != null) { this.movie.setDiscription(discription); }
            if (regiseur != null) { this.movie.setRegiseur(regiseur); }
            
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.OK).build();
        } return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Path("{id}/stocks/{stock}")
    @Produces(MediaType.APPLICATION_XML)
    public Response post(
            @PathParam("id") Integer id,
            @QueryParam("stock") Integer stock,
            @QueryParam("format") String format,
            @QueryParam("lent") Boolean lent,
            @QueryParam("retour") String retour) throws JAXBException, FileNotFoundException {
        
        if((this.movie = this.getMovie(id)) != null) {
            if((this.stock = this.getStock(this.movie.getStocks(), stock)) != null) {
                if (format != null) { this.stock.setFormat(format); }
                if (lent != null) { this.stock.setLent(lent); }
                if (retour != null) { this.stock.setRetour(retour); }
                
                this.marshal.doSave(this.data);
                return Response.status(Response.Status.OK).build();
            } return Response.status(Response.Status.NOT_FOUND).build();
        } return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response delete(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.index = this.getIndex(id)) > -1) { if(this.data.getMovie().remove(this.index) != null) { this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{id}/stocks")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteStocks(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.movie = this.getMovie(id)) != null) { this.movie.getStocks().getStock().clear(); this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{id}/stocks/{stock}")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteStocks(@PathParam("id") Integer id, @PathParam("stock") Integer stock) throws JAXBException, FileNotFoundException {
        if((this.movie = this.getMovie(id)) != null) { if((this.index = this.getIndex(this.movie.getStocks(), stock)) > -1) { if(this.movie.getStocks().getStock().remove(this.index) != null) { this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); } } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{id}/genres")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteGenres(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.movie = this.getMovie(id)) != null) { this.movie.getGenres().getGenre().clear(); this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{id}/genres/{genre}")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteGenres(@PathParam("id") Integer id, @PathParam("genre") Integer genre) throws JAXBException, FileNotFoundException {
        if((this.movie = this.getMovie(id)) != null) { if((this.index = this.getIndex(this.movie.getGenres(), genre)) > -1) { if(this.movie.getGenres().getGenre().remove(this.index) != null) { this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); } } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{id}/actors")
    @Produces(MediaType.APPLICATION_XML)
    public Response genreDelete(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.movie = this.getMovie(id)) != null) { this.movie.getActors().getActor().clear(); this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{id}/actors/{actor}")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteActors(@PathParam("id") Integer id, @PathParam("actor") Integer actor) throws JAXBException, FileNotFoundException {
        if((this.movie = this.getMovie(id)) != null) { if((this.index = this.getIndex(this.movie.getActors(), actor)) > -1) { if(this.movie.getActors().getActor().remove(this.index) != null) { this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); } } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    private int getIndex(Integer id) {
        for(int i = 0; i < this.data.getMovie().size(); i++) { Movie m = this.data.getMovie().get(i); if(m.getId().equals(id)) { return i; } }
        return -1;
    }
    
    private int getIndex(Stocks stocks, Integer id) {
        for(int i = 0; i < stocks.getStock().size(); i++) { Stock s = stocks.getStock().get(i); if(s.getId().equals(id)) { return i; } }
        return -1;
    }
    
    private int getIndex(Genres genres, Integer id) {
        for(int i = 0; i < genres.getGenre().size(); i++) { Genre g = genres.getGenre().get(i); if(g.getId().equals(id)) { return i; } }
        return -1;
    }
    
    private int getIndex(Actors actors, Integer id) {
        for(int i = 0; i < actors.getActor().size(); i++) { Actor a = actors.getActor().get(i); if(a.getId().equals(id)) { return i; } }
        return -1;
    }
    
    private Movie getMovie(Integer id) {
        for(Movie m : this.data.getMovie()) { if(m.getId().equals(id)) { return m; } }
        return null;
    }
    
    private Stock getStock(Stocks stocks, Integer id) {
        if(stocks != null) { for(Stock s : stocks.getStock()) { if(s.getId().equals(id)) { return s; } } }
        return null;
    }
    
    private Genre getGenre(Genres genres, Integer id) {
        if(genres != null) { for(Genre g : genres.getGenre()) { if(g.getId().equals(id)) { return g; } } }
        return null;
    }
    
    private Actor getActor(Actors actors, Integer id) {
        if(actors != null) { for(Actor a : actors.getActor()) { if(a.getId().equals(id)) { return a; } } }
        return null;
    }
}
