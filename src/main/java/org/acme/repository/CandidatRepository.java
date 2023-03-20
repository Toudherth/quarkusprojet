package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Candidat;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class CandidatRepository implements PanacheRepository<Candidat> {
/*
    @PersistenceContext
    EntityManager entityManager;

    public Candidat findByLoginAndPassword(String login, String password){
        return entityManager.createQuery("SELECT c  from Candidat c where c.login =: login AND c.password =: password", Candidat.class).setParameter("login", login)
                .setParameter("password", password)
                .getSingleResult();
    }*/
}
