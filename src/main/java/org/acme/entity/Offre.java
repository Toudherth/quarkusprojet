package org.acme.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_offre;
    @Column(nullable = false)
    private String nom_offre;
    @Column(nullable = false)
    private String metier_offre;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String periode;
    @Column(nullable = false)
    private String renumeration;

    @ManyToMany(mappedBy = "offres")
    private List<Candidat>  candidats;

    public Offre() {
    }
    public Offre(Long id_offre) {
        this.id_offre = id_offre;
    }

    public Offre(Long id_offre, String nom_offre, String metier_offre, String description,
                 String periode, String renumeration, List<Candidat> candidats) {
        this.id_offre = id_offre;
        this.nom_offre = nom_offre;
        this.metier_offre = metier_offre;
        this.description = description;
        this.periode = periode;
        this.renumeration = renumeration;
        this.candidats = candidats;
    }

    public Long getId_offre() {
        return id_offre;
    }

    public void setId_offre(Long id_offre) {
        this.id_offre = id_offre;
    }

    public String getNom_offre() {
        return nom_offre;
    }

    public void setNom_offre(String nom_offre) {
        this.nom_offre = nom_offre;
    }

    public String getMetier_offre() {
        return metier_offre;
    }

    public void setMetier_offre(String metier_offre) {
        this.metier_offre = metier_offre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getRenumeration() {
        return renumeration;
    }

    public void setRenumeration(String renumeration) {
        this.renumeration = renumeration;
    }

    public List<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(List<Candidat> candidats) {
        this.candidats = candidats;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id_offre=" + id_offre +
                ", nom_offre='" + nom_offre + '\'' +
                ", metier_offre='" + metier_offre + '\'' +
                ", description='" + description + '\'' +
                ", periode='" + periode + '\'' +
                ", renumeration='" + renumeration + '\'' +
                ", candidats=" + candidats +
                '}';
    }
}
