package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.InscriptionAgence;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InscriptionAgenceRepository implements
        PanacheRepository<InscriptionAgence> {
}
