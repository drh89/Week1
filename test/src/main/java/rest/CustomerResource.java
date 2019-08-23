/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import dto.CustomerDTO;
import entity.Customer;
import facade.CustomerFacade;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Dennis
 */
@Path("customer")
public class CustomerResource {

    private CustomerFacade cf;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {
        cf = new CustomerFacade();
    }

    /**
     * Retrieves representation of an instance of rest.CustomerResource
     *
     * @return an instance of java.lang.String
     */
 

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCustomers() {

        List<Customer> customers = cf.getAllCustomers();
        return new Gson().toJson(customers);
    }

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public String randomCustomer() {
        Random rand = new Random();

        Customer cus = cf.getAllCustomers().get(rand.nextInt(cf.getCustomerListSize(cf.getAllCustomers())));
        return new Gson().toJson(cus);
    }

    @GET
    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id") int id){
        List<Customer> customers = cf.getAllCustomers();
        Customer cus = cf.getCustomerById(id - 1);
        CustomerDTO cusDto = new CustomerDTO(cus);
        return Response.ok().entity(new Gson().toJson(cusDto)).build();
    }


}
