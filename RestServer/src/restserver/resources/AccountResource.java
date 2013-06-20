package restserver.resources;

import com.sun.research.ws.wadl.Resource;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restserver.MyMarshal;
import restserver.schema.account.*;
import restserver.schema.account.Accounts.Account;
import restserver.schema.account.Accounts.Account.Genres;
import restserver.schema.account.Accounts.Account.Genres.Genre;
import restserver.schema.account.Accounts.Account.Wishes;
import restserver.schema.account.Accounts.Account.Wishes.Movie;

@Path("accounts")
public class AccountResource extends Resource {
    private MyMarshal marshal;
    private Accounts data, accounts;
    private Account account;
    private String link;
    private int index;
    
    public AccountResource() throws JAXBException, FileNotFoundException {
        this.marshal = new MyMarshal();
        this.data = marshal.toAccounts();
        this.link = "/accounts";
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
        if((this.account = this.getAccount(id)) != null) { this.accounts = new Accounts(); this.accounts.getAccount().add(this.account); return Response.status(Response.Status.OK).entity(this.accounts).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response put(String xml) throws JAXBException, FileNotFoundException {
        if((this.accounts = this.marshal.toAccounts(xml)) != null) {
            for(Accounts.Account a : this.accounts.getAccount()) {
                a.setEdit(this.link + "/" + a.getId());
                a.setDelete(this.link + "/" + a.getId());
                this.data.getAccount().add(a);
            }
            
            this.data.setId(this.accounts.getId());
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.CREATED).build();
        } return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
    
    @PUT
    @Path("{id}/genres/{genre}")
    @Produces(MediaType.APPLICATION_XML)
    public Response putGenre(
            @PathParam("id") Integer id,
            @PathParam("genre") Integer genre) throws JAXBException, FileNotFoundException {
        
        if((this.index = this.getIndex(id)) > -1) {
            if(genre != null) { Genre g = new Genre(); g.setId(genre); this.data.getAccount().get(this.index).getGenres().getGenre().add(g); }
            
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.CREATED).build();
        } return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @PUT
    @Path("{id}/movies/{movie}")
    @Produces(MediaType.APPLICATION_XML)
    public Response putMovie(
            @PathParam("id") Integer id,
            @PathParam("movie") Integer movie) throws JAXBException, FileNotFoundException {
        
        if((this.index = this.getIndex(id)) > -1) {
            if(movie != null) { Movie m = new Movie(); m.setId(movie); this.data.getAccount().get(this.index).getWishes().getMovie().add(m); }
            
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.CREATED).build();
        } return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response post(String xml) throws JAXBException, FileNotFoundException {
        if((this.accounts = this.marshal.toAccounts(xml)) != null) { int i; for(Account a : this.accounts.getAccount()) { if((i = this.getIndex(a.getId())) > -1) { this.data.getAccount().set(i, a); } else { return Response.status(Response.Status.NOT_FOUND).build(); } } this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response post(
            @PathParam("id") Integer id,
            @QueryParam("name") String name,
            @QueryParam("bank") String bank,
            @QueryParam("code") String code,
            @QueryParam("account") String account,
            @QueryParam("address") String address,
            @QueryParam("mail") String mail,
            @QueryParam("password") String password) throws JAXBException, FileNotFoundException {
        
        if((this.account = this.getAccount(id)) != null) {
            if (name != null) { this.account.setName(name); }
                if (bank != null) { this.account.setBank(bank); }
                if (code != null) { this.account.setCode(code); }
                if (account != null) { this.account.setAccount(account); }
                if (address != null) { this.account.setAddress(address); }
                if (mail != null) { this.account.setMail(mail); }
                if (password != null) { this.account.setPassword(password); }
            
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.OK).build();
        } return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response delete(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.index = this.getIndex(id)) > -1) { if(this.data.getAccount().remove(this.index) != null) { this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{id}/genres")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteGenres(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.account = this.getAccount(id)) != null) { this.account.getGenres().getGenre().clear(); this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{id}/genres/{genre}")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteGenres(@PathParam("id") Integer id, @PathParam("genre") Integer genre) throws JAXBException, FileNotFoundException {
        if((this.account = this.getAccount(id)) != null) { if((this.index = this.getIndex(this.account.getGenres(), genre)) > -1) { if(this.account.getGenres().getGenre().remove(this.index) != null) { this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); } } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{id}/wishes")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteWishes(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.account = this.getAccount(id)) != null) { this.account.getWishes().getMovie().clear(); this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{id}/wishes/{movie}")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteWishes(@PathParam("id") Integer id, @PathParam("movie") Integer movie) throws JAXBException, FileNotFoundException {
        if((this.account = this.getAccount(id)) != null) { if((this.index = this.getIndex(this.account.getWishes(), movie)) > -1) { if(this.account.getWishes().getMovie().remove(this.index) != null) { this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); } } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    private int getIndex(Integer id) {
        for(int i = 0; i < this.data.getAccount().size(); i++) { Account a = this.data.getAccount().get(i); if(a.getId().equals(id)) { return i; } }
        return -1;
    }
    
    private int getIndex(Genres genres, Integer id) {
        for(int i = 0; i < genres.getGenre().size(); i++) { Genre g = genres.getGenre().get(i); if(g.getId().equals(id)) { return i; } }
        return -1;
    }
    
    private int getIndex(Wishes wishes, Integer id) {
        for(int i = 0; i < wishes.getMovie().size(); i++) { Movie m = wishes.getMovie().get(i); if(m.getId().equals(id)) { return i; } }
        return -1;
    }
    
    private Account getAccount(Integer id) {
        for(Account a : this.data.getAccount()) { if(a.getId().equals(id)) { return a; } }
        return null;
    }
    
    private Genre getGenre(Genres genres, Integer id) {
        if(genres != null) { for(Genre g : genres.getGenre()) { if(g.getId().equals(id)) { return g; } } }
        return null;
    }
    
    private Movie getMovie(Wishes wishes, Integer id) {
        if(wishes != null) { for(Movie m : wishes.getMovie()) { if(m.getId().equals(id)) { return m; } } }
        return null;
    }
}