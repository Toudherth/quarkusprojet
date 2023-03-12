package org.acme.service;

import org.acme.entity.Utilisateur;
import org.acme.repository.UtilisateurRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class UtilisateurService {

    @Inject
    UtilisateurRepository utilisateurRepository;

    public UtilisateurService (UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository= utilisateurRepository;
    }

    // Recuperation de la liste des utilisateurs

    public List<Utilisateur> getAll(){
        return (List<Utilisateur>) utilisateurRepository.findAll().list();
    }

    public Utilisateur getById(Long id) {
        return utilisateurRepository.findByIdOptional(id).orElseThrow(()-> new NotFoundException("Utilisateur with Id"+id+"not found"));
    }

    public void addUtilisateur(Utilisateur candidat){
        utilisateurRepository.persist(candidat);
    }


    public Response UpdateUtilisateur(Long id, Utilisateur utilisateur){
        Utilisateur entity= utilisateurRepository.findById(id);
        if(entity == null){
            return Response.status(Response.Status.NOT_FOUND).build(); // build(): construire la réponse HTTP sans aucun contenu.
        }
        entity.setLogin(utilisateur.getLogin());
        entity.setPassword(utilisateur.getPassword());
        utilisateurRepository.persist(entity);
        return Response.ok(entity).build();

    }


    public void deleteUtilisateur(Long id) {
        Utilisateur entity = utilisateurRepository.findById(id);
        if (entity == null) {
             Response.status(Response.Status.NOT_FOUND).build();
        }
        utilisateurRepository.delete(entity);
    }
    





}
