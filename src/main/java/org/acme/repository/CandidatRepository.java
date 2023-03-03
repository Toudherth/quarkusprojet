package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Candidat;

public interface CondidatRepository extends PanacheRepository<Candidat> {
}
