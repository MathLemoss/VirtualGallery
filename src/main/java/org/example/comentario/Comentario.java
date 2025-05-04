package org.example.comentario;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "comentarios")
public class Comentario {
    @Id
    private String id;
    
    @DBRef
    private Usuario usuario;
    
    @DBRef
    private Postagens postagem;
    
    private String texto;
    private LocalDateTime dataComentario;

    public Comentario() {}

    public Comentario(Usuario usuario, Postagens postagem, String texto) {
        this.usuario = usuario;
        this.postagem = postagem;
        this.texto = texto;
        this.dataComentario = LocalDateTime.now();
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(LocalDateTime dataComentario) {
        this.dataComentario = dataComentario;
    }
}