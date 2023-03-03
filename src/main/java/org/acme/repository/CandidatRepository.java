package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Candidat;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;

public interface CandidatRepository extends PanacheRepository<Candidat> {

}
