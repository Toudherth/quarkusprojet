package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.InscriptionEmployeur;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InscriptionEmployeurRepository implements
        PanacheRepository<InscriptionEmployeur> {
}
