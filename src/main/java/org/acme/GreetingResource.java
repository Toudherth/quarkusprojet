package org.acme;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/helloname/{nom}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloname(@PathParam("nom") String nom) {
        return "Hello from RESTEasy Reactive "+nom;
    }


    @PUT
    @Path("/updateressource/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateRessource(@PathParam("id") Long id, String requestBody) {
        // Code pour mettre à jour la ressource avec l'ID spécifié
        return Response.ok().build();
    }



}