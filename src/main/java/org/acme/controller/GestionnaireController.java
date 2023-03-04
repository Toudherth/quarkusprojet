package org.acme.controller;

import org.acme.entity.Inscription;
import org.acme.repository.InscriptionRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gestionnaire")
@Produces(MediaType.TEXT_PLAIN)
public class GestionnaireController {
    @Inject
    InscriptionRepository inscriptionRepository;

    /**
     * Consulter les inscriptions des employeurs et des agences
     *
     * @return List<Inscription>
     */
    @GET
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.listAll();
    }

    @PUT
    @Path("/{inscriptionId}")
    @Transactional
    public Response updateInscriptionEtat(
            @PathParam("inscriptionId") Long inscriptionId,
            @QueryParam("etat") int etat) {

        Inscription inscription = inscriptionRepository.findById(inscriptionId);
        if (inscription == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        inscription.setEtat(etat);

        inscriptionRepository.persist(inscription);

        return Response.ok(inscription).build();
    }
}
