package org.acme.entity;

import javax.persistence.*;

@Entity
@Table(name = "inscription_employeur")
public class InscriptionEmployeur {
    @Id
    @Column(name = "inscription_employeur_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inscriptionEmployeurId;

    @Column(name = "nom_employeur")
    private Long nomEmployeur;

    @Column(name = "prenom_employeur")
    private Long prenomEmployeur;

    @Column(name = "etat")
    private int etat;

    public Long getInscriptionEmployeurId() {
        return inscriptionEmployeurId;
    }

    public void setInscriptionEmployeurId(Long inscriptionEmployeurId) {
        this.inscriptionEmployeurId = inscriptionEmployeurId;
    }

    public Long getNomEmployeur() {
        return nomEmployeur;
    }


    public void setNomEmployeur(Long nomEmployeur) {
        this.nomEmployeur = nomEmployeur;
    }

    public Long getPrenomEmployeur() {
        return prenomEmployeur;
    }

    public void setPrenomEmployeur(Long prenomEmployeur) {
        this.prenomEmployeur = prenomEmployeur;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "InscriptionEmployeur{" +
                "inscriptionEmployeurId=" + inscriptionEmployeurId +
                ", nomEmployeur=" + nomEmployeur +
                ", prenomEmployeur=" + prenomEmployeur +
                ", etat=" + etat +
                '}';
    }

}
