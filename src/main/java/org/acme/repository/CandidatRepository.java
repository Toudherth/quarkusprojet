package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Candidat;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class CandidatRepository implements PanacheRepository<Candidat> {

    public Candidat findByNomCandidat(String nom_candidat) {
        return find("nom_candidat", nom_candidat).firstResult();
    }
/*
    @PersistenceContext
    EntityManager entityManager;

    public Candidat findByLoginAndPassword(String login, String password){
        return entityManager.createQuery("SELECT c  from Candidat c where c.login =: login AND c.password =: password", Candidat.class).setParameter("login", login)
                .setParameter("password", password)
                .getSingleResult();
    }*/
}
