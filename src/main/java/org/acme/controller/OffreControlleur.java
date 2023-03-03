package org.acme.controller;

import org.acme.entity.Offre;
import org.acme.entity.Utilisateur;
import org.acme.repository.OffreRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/offre")
@Produces(MediaType.TEXT_PLAIN)
public class OffreControlleur {

    @Inject
    private OffreRepository offreRepository;

    @GET
    public List<Offre> getAllOffre(){
        return (List<Offre>) offreRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Offre geOffreById(@PathParam("id") Long id) {
        return offreRepository.findById(id);
    }


    @POST
    @Transactional
    public Response createOffre(Offre offre) {
        offreRepository.persist(offre);
        return Response.status(Response.Status.CREATED).entity(offre).build();
    }

    @Path("/{id}")
    @PUT
    @Transactional
    public Response updateOffre(@PathParam("id") Long id, Offre offre) {
        Offre entity = offreRepository.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setNom_offre(offre.getNom_offre());
        entity.setMetier_offre(offre.getMetier_offre());
        entity.setDescription(offre.getDescription());
        entity.setPeriode(offre.getPeriode());
        entity.setRenumeration(offre.getRenumeration());
        entity.setCandidats(offre.getCandidats());
        offreRepository.persist(entity);
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteUtilisateur(@PathParam("id") Long id) {
        Offre entity = offreRepository.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        offreRepository.delete(entity);
        return Response.noContent().build();
    }
}