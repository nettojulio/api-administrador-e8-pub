package e8ilab2.apiadministrador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
    @Table(name = "administrador")
    public class Administrador {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Integer id;

        @Column(name = "name", nullable = false, length = 50)
        private String name;

        @Column(name = "email", nullable = false, length = 50, unique = true)
        private String email;

        @Column(name = "senha", nullable = false, columnDefinition = "TEXT")
        private String senha;

        public Administrador(String nome, String email, String senha) {
            super();
            this.id = id;
            this.name = nome;
            this.email = email;
            this.senha = senha;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNome() {
            return name;
        }

        public void setNome(String nome) {
            this.name = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }
    }
