package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Offre;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OffreRepository implements PanacheRepository<Offre> {
}
