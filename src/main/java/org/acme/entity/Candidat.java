package org.acme.entity;

import javax.persistence.*;

@Entity
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_candidat;
    @Column(nullable = false)
    private String nom_candidat;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private int dateNaissance;
    @Column(nullable = false)
    private String nationalite;
    @Column(nullable = false)
    private String cv;
    @Column(nullable = false)
    private String lettreMotivation;


}
