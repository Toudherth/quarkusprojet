package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Candidat;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CandidatRepository implements PanacheRepository<Candidat> {

}
