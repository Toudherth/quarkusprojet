package org.acme.controller;

import com.oracle.svm.core.annotate.Delete;
import io.agroal.api.AgroalDataSource;
import io.smallrye.common.constraint.NotNull;
import org.acme.entity.Candidat;
import org.acme.entity.User;
import org.acme.repository.CandidatRepository;
import org.acme.service.CandidatService;
import org.acme.service.UserService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.beans.Transient;
import java.net.URI;
import java.util.List;

@Path("/candidat")
@Produces(MediaType.TEXT_PLAIN)
public class CandidatController {

    // important
    @Inject
    private CandidatService candidatService;


    /* ============================================================================  */
    @GET
    public List<Candidat> getAll() {
        return (List<Candidat>) candidatService.getAll();
    }

    @GET
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addCandidat(@Valid  Candidat candidat){
        candidatService.addCandidat(candidat);
        return Response.ok(candidat).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response UpdateCandidat(@PathParam("id") Long id, Candidat candidat){
        candidatService.UpdateCandidat(id, candidat);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCandidat(@PathParam("id") Long id){
        candidatService.deleteCandidat(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
