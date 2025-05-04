package org.example.curtida;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "curtidas")
public class Curtida {
    @Id
    private String id;
    
    @DBRef
    private Usuario usuario;
    
    @DBRef
    private Postagens postagem;
    
    private LocalDateTime dataCurtida;

    public Curtida() {}

    public Curtida(Usuario usuario, Postagens postagem) {
        this.usuario = usuario;
        this.postagem = postagem;
        this.dataCurtida = LocalDateTime.now();
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Postagens getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagens postagem) {
        this.postagem = postagem;
    }

    public LocalDateTime getDataCurtida() {
        return dataCurtida;
    }

    public void setDataCurtida(LocalDateTime dataCurtida) {
        this.dataCurtida = dataCurtida;
    }
}