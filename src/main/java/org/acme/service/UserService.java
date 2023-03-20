package org.acme.service;


import org.acme.entity.User;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@RegisterRestClient
public interface UserService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    User getId(@PathParam("id") Long id);


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    Response addUser(@Valid User user) ; /*{
        userService.addUtilisateur(user);
        return Response.ok(user).status(Response.Status.CREATED).build();
    }*/

    @GET
    List<User> getAllUsers();// {return (List<User>) userService.getAll();}


}
