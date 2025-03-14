package org.example.compartilhar;

import org.example.artista.Artista;
import org.example.postagens.Postagens;
import org.example.usuario.Usuario;

import java.time.LocalDateTime;

public class Compartilhar {
    private Long id;
    private Usuario usuario; // Usuário que compartilhou
    private Artista artistaCompartilhado; // Pode ser nulo se for uma postagem compartilhada
    private Postagens postagemCompartilhada; // Pode ser nulo se for um artista compartilhado
    private String plataforma; // Ex: Facebook, Twitter, WhatsApp
    private LocalDateTime dataCompartilhamento;

    public Compartilhar() {}

    public Compartilhar(Long id, Usuario usuario, Postagens postagem) {
        this.id = id;
        this.usuario = usuario;
        this.postagemCompartilhada = postagem;
        this.dataCompartilhamento = LocalDateTime.now();
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
        return postagemCompartilhada;
    }

    public void setPostagem(Postagens postagem) {
        this.postagemCompartilhada = postagem;
    }

    public LocalDateTime getDataCompartilhamento() {
        return dataCompartilhamento;
    }

    public void setDataCompartilhamento(LocalDateTime now) {
    }
}