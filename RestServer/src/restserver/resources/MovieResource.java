/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restserver.resources;

import restserver.schema.movie.Movies;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import restserver.MyMarshal;

@Path("movies")
public class MovieResource {
    private MyMarshal marshal;
    private String link;    

    public MovieResource() throws JAXBException, FileNotFoundException {
        this.marshal = new MyMarshal();
        this.link = "http://127.0.0.1:20000/accounts/";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Movies Get() throws JAXBException, FileNotFoundException {
        return this.marshal.toMovies();
    }

    @PUT
    @Consumes( MediaType.APPLICATION_XML )
    @Produces(MediaType.APPLICATION_XML)
    public Response Put(String s) throws FileNotFoundException, JAXBException {
        Movies existingobj = this.marshal.toMovies();
        Movies newobj = this.marshal.toMovies(s);
        existingobj.getMovie().add(newobj.getMovie().get(0));
        this.marshal.doMovies(existingobj);
        return Response.status(201).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uGet(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        Movies a = this.marshal.toMovies();
        for (Movies.Movie o: a.getMovie()){
            if(o.getMovieid().equals(id)){
                return Response.status(Response.Status.OK).entity(o).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uPost(
            @PathParam("id") Integer mid,
            @QueryParam("description") String desc,
            @QueryParam("actors") String actors,
            @QueryParam("genres") String genres,
            @QueryParam("name") String name,
            @QueryParam("length") Integer length,
            @QueryParam("format") String format,
            @QueryParam("regiseur") String regie,
            @QueryParam("image") String img,
            @QueryParam("price") Float price,
            @QueryParam("date") String date,
            @QueryParam("stockid") Integer stockid,
            @QueryParam("lent") Boolean lent,
            @QueryParam("retour") String retour) throws JAXBException, FileNotFoundException, ParseException, DatatypeConfigurationException {
        Movies a = this.marshal.toMovies();
        for (Movies.Movie accs : a.getMovie()) {
            if (accs.getMovieid().equals(mid)) {
                if (desc != null) {
                    accs.setDiscription(desc);
                }
                if (date != null) {
                    accs.setDate(this.marshal.toDate(date));
                }
                if (name != null) {
                    accs.setName(name);
                }
                if (actors != null) {
                    accs.setActors(actors);
                }
                if (genres != null) {
                    accs.setGenres(genres);
                }
                if (length != null) {
                    accs.setLength(length);
                }
                if (format != null) {
                    accs.setFormat(format);
                }
                if (regie != null) {
                    accs.setRegiseur(regie);
                }
                if (img != null) {
                    accs.setImage(img);
                }
                if (price != null) {
                    accs.setPrice(price);
                }
                for(Movies.Movie.Stocks.Stock st: accs.getStocks().getStock()){
                    if(st.getId().equals(stockid)){
                        if (lent != null) {
                            st.setLent(lent);
                        }
                        if (retour != null) {
                            st.setReturn(this.marshal.toDate(retour));
                        }
                    }
                }
                this.marshal.doMovies(a);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uDelete(@PathParam("id") String id) throws FileNotFoundException, JAXBException {
        Movies a = this.marshal.toMovies();
        int i = 0;
        for (Movies.Movie accs: a.getMovie()){
            if(accs.getName().equals(id)){
                a.getMovie().remove(i);
                this.marshal.doMovies(a);
                return Response.status(200).build();
            }
            i++;
        }
        return Response.status(404).build();
    }
}
