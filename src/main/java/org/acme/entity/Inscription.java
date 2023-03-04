package org.acme.entity;

import javax.persistence.*;

@Entity
public class Inscription {
    @Id
    @Column(name = "inscription_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inscriptionId;

    @Column(name = "emp_ou_agen")
    private String employeurOuAgence;

    @Column(name = "id_inscrit")
    private String mdpGestionnaire;

    @Column(name = "etat")
    private int etat;

    public Long getInscriptionId() {
        return inscriptionId;
    }

    public void setInscriptionId(Long inscriptionId) {
        this.inscriptionId = inscriptionId;
    }

    public String getEmployeurOuAgence() {
        return employeurOuAgence;
    }

    public void setEmployeurOuAgence(String employeurOuAgence) {
        this.employeurOuAgence = employeurOuAgence;
    }

    public String getMdpGestionnaire() {
        return mdpGestionnaire;
    }

    public void setMdpGestionnaire(String mdpGestionnaire) {
        this.mdpGestionnaire = mdpGestionnaire;
    }

    public int isEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "inscriptionId=" + inscriptionId +
                ", employeurOuAgence='" + employeurOuAgence + '\'' +
                ", mdpGestionnaire='" + mdpGestionnaire + '\'' +
                ", etat=" + etat +
                '}';
    }
}
