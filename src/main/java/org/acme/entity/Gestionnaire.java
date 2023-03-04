package org.acme.entity;

import javax.persistence.*;

@Entity
public class Gestionnaire {
    @Id
    @Column(name = "gestionnaire_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gestionnaireId;

    @Column(name = "nom_gestionnaire")
    private String nomGestionnaire;

    @Column(name = "mdp_gestionnaire")
    private String mdpGestionnaire;

    @Column(name = "email_gestionnaire")
    private String emailGestionnaire;

    public Long getGestionnaireId() {
        return gestionnaireId;
    }

    public void setGestionnaireId(Long gestionnaireId) {
        this.gestionnaireId = gestionnaireId;
    }

    public String getNomGestionnaire() {
        return nomGestionnaire;
    }

    public void setNomGestionnaire(String nomGestionnaire) {
        this.nomGestionnaire = nomGestionnaire;
    }

    public String getMdpGestionnaire() {
        return mdpGestionnaire;
    }

    public void setMdpGestionnaire(String mdpGestionnaire) {
        this.mdpGestionnaire = mdpGestionnaire;
    }

    public String getEmailGestionnaire() {
        return emailGestionnaire;
    }

    public void setEmailGestionnaire(String emailGestionnaire) {
        this.emailGestionnaire = emailGestionnaire;
    }

    @Override
    public String toString() {
        return "Gestionnaire{" +
                "gestionnaireId=" + gestionnaireId +
                ", nomGestionnaire='" + nomGestionnaire + '\'' +
                ", mdpGestionnaire='" + mdpGestionnaire + '\'' +
                ", emailGestionnaire='" + emailGestionnaire + '\'' +
                '}';
    }
}