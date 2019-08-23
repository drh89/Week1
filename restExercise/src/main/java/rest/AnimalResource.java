/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Animal;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.json.Json;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dennis
 */
@Path("animal")
public class AnimalResource {
    
    private List<Animal> animals = new ArrayList();
    
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
        animals.add(new Animal("Dog", "Bark", 2019));
        animals.add(new Animal("Cat", "Meow", 1909));
        animals.add(new Animal("Wolf", "Howl", 1747));
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     *
     * @return an instance of java.lang.String
     */
    @GET
//    @Produces(MediaType.APPLICATION_JSON)
    public String getString() {
        //TODO return proper representation object
        return "hello again";
    }

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)

//    @Produces(MediaType.APPLICATION_JSON)
    public String getRandom() {
        
        Random random = new Random();
        Animal animal = animals.get(random.nextInt(3));
        
        return new Gson().toJson(animal);
        
        //TODO return proper representation object
        
    }

}
