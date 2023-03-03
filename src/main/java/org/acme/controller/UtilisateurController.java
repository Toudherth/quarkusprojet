package org.acme.controller;

import org.acme.entity.Utilisateur;
import org.acme.repository.UtilisateurRepository;

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
    private UtilisateurRepository utilisateurRepository;

    @GET
    public List<Utilisateur> getAllUtilisateurs() {
        return (List<Utilisateur>) utilisateurRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Utilisateur getUtilisateurById(@PathParam("id") Long id) {
        return utilisateurRepository.findById(id);
    }


    @POST
    @Transactional
    public Response createUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.persist(utilisateur);
        return Response.status(Response.Status.CREATED).entity(utilisateur).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUtilisateur(@PathParam("id") Long id, Utilisateur utilisateur) {
        Utilisateur entity = utilisateurRepository.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setLogin(utilisateur.getLogin());
        entity.setPassword(utilisateur.getPassword());
        utilisateurRepository.persist(entity);
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteUtilisateur(@PathParam("id") Long id) {
        Utilisateur entity = utilisateurRepository.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        utilisateurRepository.delete(entity);
        return Response.noContent().build();
    }


    

}
