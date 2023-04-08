package org.acme.securite;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.resource.spi.work.SecurityContext;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jwt")
@ApplicationScoped
public class AuthentificationJWTRessources {

    @Inject
    AuthentificationJwtService authentificationJwtService;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getJWT() {
        String jwt = authentificationJwtService.generateJwt();
        return (Response) Response.ok(jwt).build();
    }
    
}
