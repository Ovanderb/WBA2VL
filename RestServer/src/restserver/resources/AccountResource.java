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
import restserver.schema.accounts.*;
import restserver.MyMarshal;

@Path("accounts")
public class AccountResource {

    private MyMarshal m;

    public AccountResource() throws JAXBException {
        this.m = new MyMarshal();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Accounts Get() throws JAXBException, FileNotFoundException {
        return this.m.uacc();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response Put(String s) throws JAXBException, FileNotFoundException {
        Accounts existingAccounts = this.m.uacc();
        Accounts newAccounts = this.m.uacc(s);
        existingAccounts.getAccount().add(newAccounts.getAccount().get(0));
        this.m.macc(existingAccounts);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uGet(@PathParam("id") String id) throws JAXBException, FileNotFoundException {
        Accounts a = this.m.uacc();
        for (Accounts.Account accs : a.getAccount()) {
            if (accs.getName().equals(id)) {
                return Response.status(Response.Status.OK).entity(accs).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uPost(
            @PathParam("id") String id,
            @QueryParam("age") String age,
            @QueryParam("date") String date,
            @QueryParam("name") String name,
            @QueryParam("mail") String mail,
            @QueryParam("password") String pass,
            @QueryParam("genres") int genre,
            @QueryParam("wishes") int wishes) throws JAXBException, FileNotFoundException, ParseException, DatatypeConfigurationException {
        Accounts a = this.m.uacc();
        for (Accounts.Account accs : a.getAccount()) {
            if (accs.getName().equals(id)) {
                if (age != null) {
                    accs.setAge(this.m.strToXmlGreg(age));
                }
                if (date != null) {
                    accs.setDate(this.m.strToXmlGreg(date));
                }
                if (mail != null) {
                    accs.setMail(mail);
                }
                if (name != null) {
                    accs.setName(name);
                }
                if (pass != null) {
                    accs.setPassword(pass);
                }
                this.m.macc(a);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uDel(@PathParam("id") String id) throws JAXBException, FileNotFoundException {
        Accounts a = this.m.uacc();
        int i = 0;
        for (Accounts.Account accs : a.getAccount()) {
            if (accs.getName().equals(id)) {
                a.getAccount().remove(i);
                this.m.macc(a);
                return Response.status(Response.Status.OK).build();
            }
            i++;
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}