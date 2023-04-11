package org.acme.service;

import org.acme.entity.Candidat;
import org.acme.entity.Compte;
import org.acme.repository.CandidatRepository;
import org.acme.repository.CompteRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class InscriptionService {

    @Inject
    CompteRepository compteRepository;

    @Inject    
    CandidatRepository candidatRepository;

    // ajouter compte et candidat



    // get all users
    public List<Compte> getAll(){
        return (List<Compte>) compteRepository.findAll().list();
    }

    public Compte getById(Long id) {
        return compteRepository.findByIdOptional(id).orElseThrow(()-> new NotFoundException("Utilisateur with Id"+id+"not found"));
    }

    public void addUtilisateur(Compte candidat){
        compteRepository.persist(candidat);
    }



    // recherche de email et passe word si il existe

    public boolean Recherche(String email, String password) {
        Compte user = compteRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // delete

    public void deleteUtilisateur(Long id) {
        Compte entity = compteRepository.findById(id);
        if (entity == null) {
             Response.status(Response.Status.NOT_FOUND).build();
        }
        compteRepository.delete(entity);
    }


}
