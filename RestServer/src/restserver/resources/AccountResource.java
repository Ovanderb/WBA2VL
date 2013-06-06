/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restserver.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.text.ParseException;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import restserver.schema.account.list.*;
import restserver.schema.account.*;
import restserver.MyMarshal;

@Path("accounts")
public class AccountResource {
    private MyMarshal marshal;
    private Accounts accounts;
    private String link;
    
    public AccountResource() throws JAXBException, FileNotFoundException {
        this.marshal = new MyMarshal();
        this.accounts = marshal.toAccounts();
        this.link = "http://127.0.0.1:20000/accounts/";
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response Get() {
        Accountlist response = new Accountlist();
        
        for(Accounts.Account account : this.accounts.getAccount()) {
            Accountlist.Account entry = new Accountlist.Account();
            entry.setId(account.getId());
            
            entry.setName(account.getName());
            entry.setLink(this.link + account.getId());
            response.getAccount().add(entry);
        }
        
        return Response.status(Response.Status.OK).entity(response).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response Put(String xml) throws JAXBException, FileNotFoundException {
        Accounts income = this.marshal.toAccounts(xml);
        for(Accounts.Account account : income.getAccount()) { this.accounts.getAccount().add(account); }
        this.marshal.doAccounts(this.accounts);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uGet(@PathParam("id") Integer id) {
        for (Accounts.Account account : this.accounts.getAccount()) { if (account.getId().equals(id)) { return Response.status(Response.Status.OK).entity(account).build(); } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uPost(
            @PathParam("id") Integer id,
            @QueryParam("age") String age,
            @QueryParam("date") String date,
            @QueryParam("name") String name,
            @QueryParam("mail") String mail,
            @QueryParam("password") String password) throws JAXBException, FileNotFoundException, ParseException, DatatypeConfigurationException {
        
        for (Accounts.Account account : this.accounts.getAccount()) {
            if (account.getId().equals(id)) {
                if (age != null) { account.setAge(this.marshal.toDate(age)); }
                if (date != null) { account.setDate(this.marshal.toDate(date)); }
                if (mail != null) { account.setMail(mail); }
                if (name != null) { account.setName(name); }
                if (password != null) { account.setPassword(password); }
                this.marshal.doAccounts(this.accounts);
                return Response.status(Response.Status.OK).build();
            }
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uDel(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        int i = 0;
        
        for (Accounts.Account account : this.accounts.getAccount()) {
            if (account.getId().equals(id)) {
                this.accounts.getAccount().remove(i);
                this.marshal.doAccounts(this.accounts);
                return Response.status(Response.Status.OK).build();
            } i++;
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}