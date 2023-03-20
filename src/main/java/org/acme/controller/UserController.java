package org.acme.controller;

import org.acme.entity.Candidat;
import org.acme.entity.User;
import org.acme.service.CandidatService;
import org.acme.service.UserService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/authentifier")
@Produces(MediaType.TEXT_PLAIN)
public class UserController {

    @Inject
    private CandidatService candidatService;

    @Inject
    @RestClient
    private UserService userService;


    //// SERVICE USER AUTHENTIFICATION : on appel le service user

    @GET
    public List<User> getAllUsers() {return (List<User>) userService.getAllUsers();}

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getId(@PathParam("id") Long id){
        User user= userService.getId(id);
        if( user != null){
            return Response.ok(user).build();
        }else {
            return Response.noContent().build();
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addUser(@Valid User user){
        userService.addUser(user);

        if( user != null){
            return Response.ok(user).status(Response.Status.CREATED).build();
        }else {
            return Response.noContent().build();
        }
    }

    /////  ici pour l'inscription
    @POST
    @Path("/inscription")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String inscription( Candidat candidat,User user) {
        // Ajouter le candidat à la base de données
        System.out.println("je suis dans inscriptin ------------");
        candidatService.addCandidat(candidat);
        System.out.println("jai ajouter le candidat-------------------- "+candidat.getNom_candidat());
        // User users= new User(email, password);
        //   System.out.println("compte est afficher --------------------- "+compte.getEmail());
        //user.setCandidat(candidat);
        // Ajouter le compte à la base de données
        System.out.println("Ajouter candidat a compte ------------------");
        // inscriptionService.addUtilisateur(compte);
        return Response.ok(candidat).status(Response.Status.CREATED).build().toString();
    }



}
