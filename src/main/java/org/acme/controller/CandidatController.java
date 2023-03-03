package org.acme.controller;

import com.oracle.svm.core.annotate.Delete;
import io.agroal.api.AgroalDataSource;
import org.acme.entity.Candidat;
import org.acme.repository.CandidatRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.beans.Transient;
import java.util.List;

@Path("/candidat")
@Produces(MediaType.TEXT_PLAIN)
public class CandidatController {

    // pour la gestion de la database
    AgroalDataSource agroalDataSource;

    @Inject
    private CandidatRepository candidateRepository;
    @GET
    public List<Candidat> getAll() {
        return (List<Candidat>) candidateRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Candidat getCandidat(@PathParam("id") Long id ){

        return candidateRepository.findByIdOptional(id)
                .orElseThrow(()-> new NotFoundException("Candidat with Id"+id+"not found"));
    }


    @POST
    @Transactional
    public Response addCandidat(Candidat candidat){
        candidateRepository.persist(candidat);
        return Response.ok(candidat).status(Response.Status.CREATED).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional   // la methode doit etre executée dans une trasaction de base de données, elle garantit que si une erreur est arrivé lors
    // de la mise a jour de la bdd, toutes les modifications seront annulées
    public Response UpdateCandidat(@PathParam("id") Long id, Candidat candidat){
        Candidat entity= candidateRepository.findById(id);
        if(entity == null){
            return Response.status(Response.Status.NOT_FOUND).build(); // build(): construire la réponse HTTP sans aucun contenu.
        }

        if(candidat.getNom_candidat() != null){
            entity.setPrenom_candidat(candidat.getPrenom_candidat());
        }
        if(candidat.getPrenom_candidat() != null) {
            entity.setPrenom_candidat(candidat.getPrenom_candidat());
        }
        if(candidat.getDatenaissance() != null) {
            entity.setDatenaissance(candidat.getDatenaissance());
        }
        if(candidat.getNationalite() != null) {
            entity.setNationalite(candidat.getNationalite());
        }
        if(candidat.getNumerotel() != null) {
            entity.setNumerotel(candidat.getNumerotel());
        }
        if(candidat.getCv() != null) {
                entity.setCv(candidat.getCv());
        }
        if(candidat.getLettremotivation() != null) {
            entity.setLettremotivation(candidat.getLettremotivation());
        }
        if(candidat.getUtilisateur() != null) {
            entity.setUtilisateur(candidat.getUtilisateur());
        }


        candidateRepository.persist(entity);
        return Response.ok(entity).build();
    }


    @Delete
    @Path("/{id}")
    @Transactional
    public Response deleteCandidat(@PathParam("id") Long id){
        Candidat entity= candidateRepository.findById(id);
        if(entity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        candidateRepository.delete(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    


}
