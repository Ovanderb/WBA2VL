package restserver.resources;

import com.sun.research.ws.wadl.Resource;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restserver.MyMarshal;
import restserver.schema.bill.*;
import restserver.schema.bill.Bills.Bill;
import restserver.schema.bill.Bills.Bill.Movies.Movie;

@Path("bills")
public class  BillResource extends Resource {
    private MyMarshal marshal;
    private Bills data, bills;
    private Bill bill;
    private String link;
    private int index;

    public BillResource() throws JAXBException, FileNotFoundException {
        this.marshal = new MyMarshal();
        this.data = this.marshal.toBills();
        this.link = "/bills";
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
        if((this.bill = this.getBill(id)) != null) { this.bills = new Bills(); this.bills.getBill().add(this.bill); return Response.status(Response.Status.OK).entity(this.bills).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response put(String xml) throws JAXBException, FileNotFoundException {
        if((this.bills = this.marshal.toBills(xml)) != null) {
            for(Bills.Bill b : this.bills.getBill()) {
                b.setEdit(this.link + "/" + b.getId());
                b.setDelete(this.link + "/" + b.getId());
                this.data.getBill().add(b);
            }
            
            this.data.setId(this.bills.getId());
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.CREATED).build();
        } return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
    
    @PUT
    @Path("{id}/movies")
    @Produces(MediaType.APPLICATION_XML)
    public Response putMovie(
            @PathParam("id") Integer id,
            @QueryParam("name") String name,
            @QueryParam("price") Float price) throws JAXBException, FileNotFoundException {
        
        if((this.bill = this.getBill(id)) != null) {
            if(name != null && price != null) { Movie m = new Movie(); m.setName(name); m.setPrice(price); this.bill.getMovies().getMovie().add(m); }
            
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.CREATED).build();
        } return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response post(String xml) throws JAXBException, FileNotFoundException {
        if((this.bills = this.marshal.toBills(xml)) != null) { int i; for(Bill b : this.bills.getBill()) { if((i = this.getIndex(b.getId())) > -1) { this.data.getBill().set(i, b); } else { return Response.status(Response.Status.NOT_FOUND).build(); } } this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response post(
            @PathParam("id") Integer id,
            @QueryParam("owner") String owner,
            @QueryParam("bank") String bank,
            @QueryParam("code") String code,
            @QueryParam("account") String account,
            @QueryParam("address") String address,
            @QueryParam("date") String date) throws JAXBException, FileNotFoundException {
        
        if((this.bill = this.getBill(id)) != null) {
            if (owner != null) { this.bill.setOwner(owner); }
            if (bank != null) { this.bill.setBank(bank); }
            if (code != null) { this.bill.setCode(code); }
            if (account != null) { this.bill.setAccount(account); }
            if (address != null) { this.bill.setAddress(address); }
            if (date != null) { this.bill.setDate(date); }
            
            this.marshal.doSave(this.data);
            return Response.status(Response.Status.OK).build();
        } return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response delete(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.index = this.getIndex(id)) > -1) { if(this.data.getBill().remove(this.index) != null) { this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); } }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{id}/movies")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteMovies(@PathParam("id") Integer id) throws JAXBException, FileNotFoundException {
        if((this.bill = this.getBill(id)) != null) { this.bill.getMovies().getMovie().clear(); this.marshal.doSave(this.data); return Response.status(Response.Status.OK).build(); }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    private int getIndex(Integer id) {
        for(int i = 0; i < this.data.getBill().size(); i++) { Bill b = this.data.getBill().get(i); if(b.getId().equals(id)) { return i; } }
        return -1;
    }
    
    private Bill getBill(Integer id) {
        for(Bill b : this.data.getBill()) { if(b.getId().equals(id)) { return b; } }
        return null;
    }
}
