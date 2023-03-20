package org.acme.controller;

import org.acme.entity.Candidat;
import org.acme.entity.Compte;
import org.acme.repository.CompteRepository;
import org.acme.service.CandidatService;
import org.acme.service.InscriptionService;
import org.jboss.resteasy.annotations.Form;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/inscrire")
@Produces(MediaType.TEXT_PLAIN)
public class InsriptionController {

    // inscription pour chaque utilisateur
    @Inject
    InscriptionService inscriptionService;

    @Inject
    CandidatService candidatService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response incrireUser(@Valid Compte inscription){
        inscriptionService.addUtilisateur(inscription);
        return Response.ok(inscription).status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/inscription")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String inscription( @FormParam("nom_candidat") String nom, @FormParam("prenom_candidat") String prenom,@FormParam("nationalite")  String nationalite, @FormParam("numerotel")  String tel,
                               @FormParam("datenaissance")  String datenai,@FormParam("cv")  String cv,@FormParam("lettremotivation")  String lettremotive,@FormParam("email")  String email,@FormParam("password")  String password) {
        // Ajouter le candidat à la base de données
        System.out.println("je suis dans inscriptin ------------");
        Candidat candidat= new Candidat(nom, prenom, nationalite, datenai, tel, cv,lettremotive);
        candidatService.addCandidat(candidat);
        System.out.println("jai ajouter le candidat-------------------- "+candidat.getNom_candidat());
        Compte compte= new Compte(email, password);
     //   System.out.println("compte est afficher --------------------- "+compte.getEmail());
        compte.setCandidat(candidat);
        // Ajouter le compte à la base de données
        System.out.println("Ajouter candidat a compte ------------------");
        inscriptionService.addUtilisateur(compte);
        return Response.ok(candidat).status(Response.Status.CREATED).build().toString();
    }


}