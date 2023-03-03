package org.acme.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Candidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_candidat;
    @Column(nullable = false)
    private String nom_candidat;
    @Column(nullable = false)
    private String prenom_candidat;
    @Column(nullable = false)
    private String nationalite;
    @Column(nullable = false)
    private String datenaissance;
    @Column(nullable = false)
    private String numerotel;
    @Column(nullable = false)
    private String cv;
    @Column(nullable = false)
    private String lettremotivation;

    @OneToOne(mappedBy = "candidat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Utilisateur utilisateur;

    @ManyToMany
    @JoinTable( /*name = "candidat_offre",*/
            joinColumns = @JoinColumn( /*name = "candidat_id"*/),
            inverseJoinColumns = @JoinColumn(/*name = "offre_id"*/))
    private List<Offre> offres;

    public Candidat() {

    }

    public Candidat(Long id_candidat) {
        this.id_candidat = id_candidat;
    }

    public Candidat(Long id_candidat, String nom_candidat, String prenom_candidat, String nationalite, String datenaissance, String numerotel, String cv,
                    String lettremotivation, Utilisateur utilisateur, List<Offre> offres) {
        this.id_candidat = id_candidat;
        this.nom_candidat = nom_candidat;
        this.prenom_candidat = prenom_candidat;
        this.nationalite = nationalite;
        this.datenaissance = datenaissance;
        this.numerotel = numerotel;
        this.cv = cv;
        this.lettremotivation = lettremotivation;
        this.utilisateur = utilisateur;
        this.offres = offres;
    }

    public Candidat(Long id_candidat, String nom_candidat, String prenom_candidat, String nationalite, String datenaissance, String numerotel, String cv,
                    String lettremotivation) {
        this.id_candidat = id_candidat;
        this.nom_candidat = nom_candidat;
        this.prenom_candidat = prenom_candidat;
        this.nationalite = nationalite;
        this.datenaissance = datenaissance;
        this.numerotel = numerotel;
        this.cv = cv;
        this.lettremotivation = lettremotivation;
    }

    public Long getId_candidat() {
        return id_candidat;
    }

    public void setId_candidat(Long id_candidat) {
        this.id_candidat = id_candidat;
    }

    public String getNom_candidat() {
        return nom_candidat;
    }

    public void setNom_candidat(String nom_candidat) {
        this.nom_candidat = nom_candidat;
    }

    public String getPrenom_candidat() {
        return prenom_candidat;
    }

    public void setPrenom_candidat(String prenom_candidat) {
        this.prenom_candidat = prenom_candidat;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getNumerotel() {
        return numerotel;
    }

    public void setNumerotel(String numerotel) {
        this.numerotel = numerotel;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLettremotivation() {
        return lettremotivation;
    }

    public void setLettremotivation(String lettremotivation) {
        this.lettremotivation = lettremotivation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Offre> getOffres() {
        return offres;
    }

    public void setOffres(List<Offre> offres) {
        this.offres = offres;
    }

    @Override
    public String toString() {
        return "Candidat{" +
                "id_candidat=" + id_candidat +
                ", nom_candidat='" + nom_candidat + '\'' +
                ", prenom_candidat='" + prenom_candidat + '\'' +
                ", nationalite='" + nationalite + '\'' +
                ", datenaissance='" + datenaissance + '\'' +
                ", numerotel='" + numerotel + '\'' +
                ", cv='" + cv + '\'' +
                ", lettremotivation='" + lettremotivation + '\'' +
                ", utilisateur=" + utilisateur +
                ", offres=" + offres +
                '}';
    }
}
