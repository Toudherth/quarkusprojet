package org.acme.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id_utilisateur;
    @Column(nullable = false)
     String login;
   // @Column(nullable = false)
     String password;

    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn()//
    @JoinColumn(name = "candidat_id")
     Candidat candidat;

    public Utilisateur() { }
    public Utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    public Utilisateur(Long id_utilisateur, String login, String password, Candidat candidat) {
        this.id_utilisateur = id_utilisateur;
        this.login = login;
        this.password = password;
        this.candidat = candidat;
    }
    public Utilisateur(String login, String password, Candidat candidat) {
        this.login = login;
        this.password = password;
        this.candidat = candidat;
    }

    public Utilisateur(Long id_utilisateur, String login, String password) {
        this.id_utilisateur = id_utilisateur;
        this.login = login;
        this.password = password;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

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
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id_utilisateur=" + id_utilisateur +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", candidat=" + candidat.getNom_candidat() +
                '}';
    }
}
