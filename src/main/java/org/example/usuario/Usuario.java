package org.example.usuario;

import org.example.postagens.Postagens;
import org.example.curtida.Curtida;
import org.example.compartilhar.Compartilhar;
import org.example.favorito.Favorito;
import java.util.List;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private List<Postagens> postagens;
    private List<Curtida> curtidas;
    private List<Compartilhar> compartilhamentos;
    private List<Favorito> favoritos;

    public Usuario() {}

    public Usuario(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Postagens> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagens> postagens) {
        this.postagens = postagens;
    }

    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Compartilhar> getCompartilhamentos() {
        return compartilhamentos;
    }

    public void setCompartilhamentos(List<Compartilhar> compartilhamentos) {
        this.compartilhamentos = compartilhamentos;
    }

    public List<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Favorito> favoritos) {
        this.favoritos = favoritos;
    }
}