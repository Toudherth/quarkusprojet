package org.acme.controller;


import org.acme.entity.Candidat;
import org.acme.securite.AuthentificationJwtService;
import org.acme.service.CandidatService;
import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.request.AuthenticationRequest;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.resource.spi.work.SecurityContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/candidat")
@Produces(MediaType.TEXT_PLAIN)
public class CandidatController {


    @Inject
    private CandidatService candidatService;

    @Inject
    JsonWebToken token;

    @Inject
    AuthentificationJwtService authentificationJwtService;


    /* ============================================================================  */
    @GET
    @RolesAllowed("admin")
    //@PermitAll
    public List<Candidat> getAll() {
        return (List<Candidat>) candidatService.getAll();
    }

    @GET
    @Authenticated
    @RolesAllowed({"admin", "employeur", "agence"})
    @Path("/cadidatid/{idclient}")
    public Candidat getCandidat(@PathParam("idclient") Long idclient ){
        return candidatService.getById(idclient);
    }

    
/*
    @GET
    @Path("/{login}")
    public Response getUserByName(@PathParam("login") String login, @QueryParam("password") String password) {
        Candidat candidat = candidatService.getCandidatByLogin(login, password);
        if (candidat == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(candidat).build();
        }
    }
*/
    @POST
    @RolesAllowed("candidat")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addCandidat(@Valid  Candidat candidat){
        candidatService.addCandidat(candidat);
        return Response.ok(candidat).status(Response.Status.CREATED).build();
    }

    @PUT
    @Authenticated
    @RolesAllowed("candidat")
    @Path("/{id}")
    @Transactional
    public Response UpdateCandidat(@PathParam("id") Long id, Candidat candidat){
        candidatService.UpdateCandidat(id, candidat);
        return Response.ok().build();
    }

    @DELETE
    @Authenticated
    @RolesAllowed({"admin", "candidat"})
    @Path("/{id}")
    @Transactional
    public Response deleteCandidat(@PathParam("id") Long id){
        candidatService.deleteCandidat(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
