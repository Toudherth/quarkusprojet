package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Gestionnaire;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GestionnaireRepository implements PanacheRepository<Gestionnaire> {
}
