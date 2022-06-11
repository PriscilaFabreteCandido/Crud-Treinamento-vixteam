package priscila.api.priscila.models;

import javax.persistence.*;

@Entity
@Table(name = "treinamento")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "senha", length = 100)
    private String senha;
    @Column(name = "nome", length = 200)
    private String nome;
    @Column(name = "email", length = 200)
    private String email;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente(Long id, String senha, String nome, String email) {
        this.id = id;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }

    public Cliente(String senha, String nome, String email) {
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }
}

