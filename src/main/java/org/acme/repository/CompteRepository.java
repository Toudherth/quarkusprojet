package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Compte;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InscriptionRepository implements PanacheRepository<Compte> {

    public Compte findByEmail(String email) {
        return find("email", email).firstResult();
    }
}
