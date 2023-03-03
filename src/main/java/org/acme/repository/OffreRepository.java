package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Offre;

public interface OffreRepository  extends PanacheRepository<Offre> {
}
