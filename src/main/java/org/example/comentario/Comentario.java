package org.example.comentario;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;

import java.time.LocalDateTime;

public class Comentario {
    private Long id;
    private Usuario usuario;
    private Postagens postagem;
    private String texto;
    private LocalDateTime dataComentario;

    public Comentario() {}

    public Comentario(Long id, Usuario usuario, Postagens postagem, String texto) {
        this.id = id;
        this.usuario = usuario;
        this.postagem = postagem;
        this.texto = texto;
        this.dataComentario = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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