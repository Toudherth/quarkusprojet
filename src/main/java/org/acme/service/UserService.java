package org.acme.controller;


import org.acme.entity.User;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
@RegisterRestClient
public interface UserController {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    User getId(@PathParam("id") Long id);

}
