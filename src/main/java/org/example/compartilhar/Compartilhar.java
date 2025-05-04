package org.example.compartilhar;

import org.example.artista.Artista;
import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "compartilhamentos")
public class Compartilhar {
    @Id
    private String id;
    
    @DBRef
    private Usuario usuario;
    
    @DBRef
    private Artista artistaCompartilhado;
    
    @DBRef
    private Postagens postagemCompartilhada;
    
    private String plataforma;
    private LocalDateTime dataCompartilhamento;

    public Compartilhar() {}

    public Compartilhar(Usuario usuario, Postagens postagem, String plataforma) {
        this.usuario = usuario;
        this.postagemCompartilhada = postagem;
        this.plataforma = plataforma;
        this.dataCompartilhamento = LocalDateTime.now();
    }

    public Compartilhar(Usuario usuario, Artista artista, String plataforma) {
        this.usuario = usuario;
        this.artistaCompartilhado = artista;
        this.plataforma = plataforma;
        this.dataCompartilhamento = LocalDateTime.now();
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

    public Artista getArtistaCompartilhado() {
        return artistaCompartilhado;
    }

    public void setArtistaCompartilhado(Artista artistaCompartilhado) {
        this.artistaCompartilhado = artistaCompartilhado;
    }

    public Postagens getPostagemCompartilhada() {
        return postagemCompartilhada;
    }

    public void setPostagemCompartilhada(Postagens postagemCompartilhada) {
        this.postagemCompartilhada = postagemCompartilhada;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public LocalDateTime getDataCompartilhamento() {
        return dataCompartilhamento;
    }

    public void setDataCompartilhamento(LocalDateTime dataCompartilhamento) {
        this.dataCompartilhamento = dataCompartilhamento;
    }
}