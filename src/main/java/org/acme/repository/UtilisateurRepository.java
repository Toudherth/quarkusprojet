package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Utilisateur;

public interface UtilisateurRepository extends PanacheRepository<Utilisateur> {

}
