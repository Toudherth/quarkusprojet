package org.acme.entity;

import javax.persistence.*;

@Entity
@Table(name = "inscription_agence")
public class InscriptionAgence {

    @Id
    @Column(name = "inscription_agence_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inscriptionAgenceId;

    @Column(name = "nom_agence")
    private Long nomAgence;

    @Column(name = "etat")
    private int etat;

    public Long getInscriptionAgenceId() {
        return inscriptionAgenceId;
    }

    public void setInscriptionAgenceId(Long inscriptionAgenceId) {
        this.inscriptionAgenceId = inscriptionAgenceId;
    }

    public Long getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(Long nomAgence) {
        this.nomAgence = nomAgence;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "InscriptionAgence{" +
                "inscriptionAgenceId=" + inscriptionAgenceId +
                ", nomAgence=" + nomAgence +
                ", etat=" + etat +
                '}';
    }

}
