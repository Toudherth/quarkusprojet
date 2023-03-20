package org.acme.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Compte {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_User;
        // @Username
        public String email;
        // @Password
        public String password;
        //@Roles
        public String role;
        @OneToOne
        private Candidat candidat;

        public Compte() {}

        public Compte(Long id_User) {
            this.id_User = id_User;
        }

    public Compte(String email, String password) {
        this.email = email;
        this.password = password;
    }

        public Compte(Long id_User, String email, String password, String role) {
            this.id_User = id_User;
            this.email = email;
            this.password = password;
            this.role = role;
        }

    public Compte(Long id_User, String email, String password, Candidat candidat) {
        this.id_User = id_User;
        this.email = email;
        this.password = password;
        this.candidat = candidat;
    }

    public Long getId_User() {
            return id_User;
        }

        public void setId_User(Long id_User) {
            this.id_User = id_User;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    @Override
        public String toString() {
            return "User{" +
                    "id_User=" + id_User +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }
}
