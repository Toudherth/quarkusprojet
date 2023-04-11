package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "candidats")
public class Candidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_candidat;
    //@Column(nullable = false)
    private String nom_candidat;
    //@Column(nullable = false)
    private String prenom_candidat;
    //@Column(nullable = false)
    private String nationalite;
    //@Column(nullable = false)
    private String datenaissance;
    //@Column(nullable = false)
    private String numerotel;
   // @Column(nullable = false)
    private String cv;
   // @Column(nullable = false)
    private String lettremotivation;

    @OneToOne
    private Compte compte;
/*
    @Column(nullable = false)
    String login;
    @Column(nullable = false)
    String password;
*/
    /*
    @ManyToMany
    @JoinColumn(name = "offre_id")
    @JsonIgnoreProperties("candidats")
    private Offre offres; */

  /*/  @ManyToMany(fetch = FetchType.EAGER)
    private Set<Offre> offres= new HashSet<>();


 /*   @OneToOne(mappedBy = "candidat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Utilisateur utilisateur; */


    public Candidat() {

    }

    public Candidat(Long id_candidat) {
        this.id_candidat = id_candidat;
    }

    public Candidat(String nom_candidat, String prenom_candidat, String nationalite, String datenaissance, String numerotel, String cv,
                    String lettremotivation, Compte compte) {
        this.nom_candidat = nom_candidat;
        this.prenom_candidat = prenom_candidat;
        this.nationalite = nationalite;
        this.datenaissance = datenaissance;
        this.numerotel = numerotel;
        this.cv = cv;
        this.lettremotivation = lettremotivation;
        this.compte = compte;
    }

    public Candidat(Long id_candidat, String nom_candidat, String prenom_candidat, String nationalite,
                    String datenaissance, String numerotel, String cv,
                    String lettremotivation/*, String login, String password, Set<Offre> offres*/) {
        this.id_candidat = id_candidat;
        this.nom_candidat = nom_candidat;
        this.prenom_candidat = prenom_candidat;
        this.nationalite = nationalite;
        this.datenaissance = datenaissance;
        this.numerotel = numerotel;
        this.cv = cv;
        this.lettremotivation = lettremotivation;
     /*   this.login = login;
        this.password = password;*/
       // this.offres = offres;
    }

    public Candidat(String nom_candidat, String prenom_candidat, String nationalite, String datenaissance, String numerotel, String cv,
                    String lettremotivation /*, String login, String password*/) {
        this.nom_candidat = nom_candidat;
        this.prenom_candidat = prenom_candidat;
        this.nationalite = nationalite;
        this.datenaissance = datenaissance;
        this.numerotel = numerotel;
        this.cv = cv;
        this.lettremotivation = lettremotivation;
   /*     this.login = login;
        this.password = password;*/
    }
/*
    public Candidat(String login, String password) {
        this.login = login;
        this.password = password;
    }
*/
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
/*
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/
/*
    public Set<Offre> getOffres() {
        return offres;
    }

    public void setOffre(Set<Offre> offres) {
        this.offres = offres;
    }
*/
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
           /*     ", login='" + login + '\'' +
                ", password='" + password + '\'' +*/
          //      ", offres='" + offres + '\'' +
                '}';
    }




}
