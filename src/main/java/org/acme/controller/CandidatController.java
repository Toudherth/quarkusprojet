package org.acme.controller;

import com.oracle.svm.core.annotate.Delete;
import io.agroal.api.AgroalDataSource;
import io.smallrye.common.constraint.NotNull;
import org.acme.entity.Candidat;
import org.acme.repository.CandidatRepository;
import org.acme.service.CandidatService;

import javax.inject.Inject;
import javax.transaction.Transactional;
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


    @Inject
    private CandidatService candidatService;

    @GET
    public List<Candidat> getAll() {


        return (List<Candidat>) candidatService.getAll();
    }

    @GET
    @Path("/{id}")
    public Candidat getCandidat(@PathParam("id") Long id ){
        return candidatService.getById(id);
    }

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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addCandidat(Candidat candidat){
        candidatService.addCandidat(candidat);
        return Response.ok(candidat).status(Response.Status.CREATED).build();
    }

   /* @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response inscrire(Candidat candidatDTO, @Context UriInfo uriInfo) {
        Candidat candidat = candidatService.inscrire(candidatDTO.getNom_candidat(), candidatDTO.getPrenom_candidat(),
                candidatDTO.getNationalite(), candidatDTO.getDatenaissance(), candidatDTO.getNumerotel(),
                candidatDTO.getCv(), candidatDTO.getLettremotivation(),

                candidatDTO.getUtilisateur().getLogin(), candidatDTO.getUtilisateur().getPassword());


        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(candidat.getId_candidat())).build();
        return Response.created(uri).entity(candidat).build();
    }
*/

    @PUT
    @Path("/{id}")
    @Transactional   // la methode doit etre executée dans une trasaction de base de données, elle garantit que si une erreur est arrivé lors
    // de la mise a jour de la bdd, toutes les modifications seront annulées
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
