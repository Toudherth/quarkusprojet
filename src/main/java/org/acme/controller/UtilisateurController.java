package org.acme.controller;

import org.acme.entity.Candidat;
import org.acme.entity.Utilisateur;
import org.acme.repository.UtilisateurRepository;
import org.acme.service.UtilisateurService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/utilisateur")
@Produces(MediaType.TEXT_PLAIN)
public class UtilisateurController {
    @Inject
    private UtilisateurService utilisateurService;

    @GET
    public List<Utilisateur> getAllUtilisateurs() {
        return (List<Utilisateur>) utilisateurService.getAll();
    }

    @GET
    @Path("/{id}")
    public Utilisateur getUtilisateurById(@PathParam("id") Long id) {
        //String nom = utilisateurRepository.getNom();
        return utilisateurService.getById(id);
    }


    @POST
    @Transactional
    public Response createUtilisateur(Utilisateur utilisateur) {
        utilisateurService.addUtilisateur(utilisateur);
        return Response.status(Response.Status.CREATED).entity(utilisateur).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUtilisateur(@PathParam("id") Long id, Utilisateur utilisateur) {
        utilisateurService.UpdateUtilisateur(id, utilisateur);
        return Response.ok().build();
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteUtilisateur(@PathParam("id") Long id) {
        utilisateurService.deleteUtilisateur(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


    

}
