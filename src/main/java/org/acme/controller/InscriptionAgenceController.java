package org.acme.controller;

import org.acme.entity.InscriptionAgence;
import org.acme.repository.InscriptionAgenceRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/inscriptions/agences")
@Produces(MediaType.TEXT_PLAIN)
public class InscriptionAgenceController {
    @Inject
    InscriptionAgenceRepository inscriptionAgenceRepository;

    /**
     * Consulter les inscriptions des agences
     *
     * @return List<Inscription>
     */
    @GET
    public List<InscriptionAgence> getAllInscriptionsAgences() {
        return inscriptionAgenceRepository.listAll();
    }

    /**
     * Traiter les inscriptions des agences : Valider, refuser, demande de
     * complément d’information, contacter, etc
     *
     * @param inscriptionAgenceId Id of InscriptionAgence
     * @param etat                etat should be either 1 (valider), 2 (refuser) ou ...
     */
    @PUT
    @Path("/{inscriptionAgenceId}")
    @Transactional
    public Response updateInscriptionAgenceEtat(
            @PathParam("inscriptionAgenceId") Long inscriptionAgenceId,
            @QueryParam("etat") int etat) {

        InscriptionAgence inscriptionAgence = inscriptionAgenceRepository.findById(inscriptionAgenceId);
        if (inscriptionAgence == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        inscriptionAgence.setEtat(etat);

        inscriptionAgenceRepository.persist(inscriptionAgence);

        return Response.ok(inscriptionAgence).build();
    }
}