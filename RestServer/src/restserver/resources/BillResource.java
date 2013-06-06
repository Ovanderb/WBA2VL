/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restserver.resources;
import restserver.schema.bill.Bills;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import restserver.MyMarshal;

@Path("bills")
public class  BillResource {
    private FileOutputStream f;
    private MyMarshal marshal;

    public BillResource() throws JAXBException {
        this.marshal = new MyMarshal();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Bills Get() throws JAXBException, FileNotFoundException {
        return this.marshal.toBills();
    }
    
    @PUT
    public Response Put(String s) throws FileNotFoundException, JAXBException {
        Bills existingobj = this.marshal.toBills();
        Bills newobj = this.marshal.toBills(s);
        existingobj.getBill().add(newobj.getBill().get(0));
        this.marshal.doBills(existingobj);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uGet(@PathParam("id") String id) throws JAXBException, FileNotFoundException {
        Bills a = this.marshal.toBills();
        for (Bills.Bill o: a.getBill()){
            if(o.getId()== Integer.parseInt(id)){
                return Response.status(Response.Status.OK).entity(o).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uPost(
            @PathParam("id") int id,
            @QueryParam("cash") Boolean cash,
            @QueryParam("bank") Boolean bank,
            @QueryParam("account") Integer account,
            @QueryParam("code") String code,
            @QueryParam("owner") String owner,
            @QueryParam("movieid") String mid,
            @QueryParam("mname") String mname,
            @QueryParam("mprice") Float mprice) throws JAXBException, FileNotFoundException, ParseException, DatatypeConfigurationException {
        Bills a = this.marshal.toBills();
        for (Bills.Bill accs : a.getBill()) {
            if (accs.getId().equals(id)) {
                if (bank != null) {
                    accs.setBank(bank);
                }
                if (cash != null) {
                    accs.setCash(cash);
                }
                if (account != null) {
                    accs.setAccount(account);
                }
                if (code != null) {
                    accs.setCode(code);
                }
                if (owner != null) {
                    accs.setOwner(owner);
                }
                for (Bills.Bill.Movie movie: accs.getMovie()){
                    if(movie.getName().equals(mid)){
                        if (mname != null) {
                            movie.setName(mname);
                        }
                        if (mprice != null) {
                            movie.setPrice(mprice);
                        }
                    }
                }
                this.marshal.doBills(a);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response uDelete(@PathParam("id") String id) throws FileNotFoundException, JAXBException {
        Bills a = this.marshal.toBills();
        int i = 0;
        for (Bills.Bill accs: a.getBill()){
            if(accs.getId()== Integer.parseInt(id)){
                a.getBill().remove(i);
                this.marshal.doBills(a);
                return Response.status(Response.Status.OK).build();
            }
            i++;
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
