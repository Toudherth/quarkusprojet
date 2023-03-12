package org.acme.controller;

import org.acme.entity.InscriptionEmployeur;
import org.acme.repository.InscriptionEmployeurRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/inscriptions/employeurs")
@Produces(MediaType.TEXT_PLAIN)
public class InscriptionEmployeurController {
    @Inject
    InscriptionEmployeurRepository inscriptionEmployeurRepository;

    /**
     * Consulter les inscriptions des employeurs
     *
     * @return List<Inscription>
     */
    @GET
    public List<InscriptionEmployeur> getAllInscriptionsEmployeurs() {
        return inscriptionEmployeurRepository.listAll();
    }

    /**
     * Traiter les inscriptions des employeurs : Valider, refuser, demande de
     * complément d’information, contacter, etc
     *
     * @param inscriptionEmployeurId Id of InscriptionEmployeur
     * @param etat                   etat should be either 1 (valider), 2 (refuser) ou ...
     */
    @PUT
    @Path("/{inscriptionEmployeurId}")
    @Transactional
    public Response updateInscriptionEmployeurEtat(
            @PathParam("inscriptionEmployeurId") Long inscriptionEmployeurId,
            @QueryParam("etat") int etat) {

        InscriptionEmployeur inscriptionEmployeur = inscriptionEmployeurRepository.findById(inscriptionEmployeurId);
        if (inscriptionEmployeur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        inscriptionEmployeur.setEtat(etat);

        inscriptionEmployeurRepository.persist(inscriptionEmployeur);

        return Response.ok(inscriptionEmployeur).build();
    }
}
