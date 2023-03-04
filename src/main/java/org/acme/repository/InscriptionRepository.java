package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Inscription;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InscriptionRepository implements PanacheRepository<Inscription> {
}
