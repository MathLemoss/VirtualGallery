package org.example.usuario;

import org.example.postagens.Postagens;
import org.example.curtida.Curtida;
import org.example.compartilhar.Compartilhar;
import org.example.favorito.Favorito;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;
    
    private String nome;
    private String email;
    
    @DBRef
    private List<Postagens> postagens;
    
    @DBRef
    private List<Curtida> curtidas;
    
    @DBRef
    private List<Compartilhar> compartilhamentos;
    
    @DBRef
    private List<Favorito> favoritos;

    public Usuario() {}

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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