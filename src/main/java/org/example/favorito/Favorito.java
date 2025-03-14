package org.example.favorito;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.example.artista.Artista;
import java.time.LocalDateTime;

public class Favorito {
    private Long id;
    private Usuario usuario;
    private Postagens postagem;
    private Artista artistaFavoritado;
    private LocalDateTime dataFavorito;

    public Favorito() {}

    public Favorito(Long id, Usuario usuario, Postagens postagem, Artista artistaFavoritado) {
        this.id = id;
        this.usuario = usuario;
        this.postagem = postagem;
        this.artistaFavoritado = artistaFavoritado;
        this.dataFavorito = LocalDateTime.now();
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

    public Artista getArtistaFavoritado() {
        return artistaFavoritado;
    }

    public void setArtistaFavoritado(Artista artistaFavoritado) {
        this.artistaFavoritado = artistaFavoritado;
    }

    public LocalDateTime getDataFavorito() {
        return dataFavorito;
    }

    public void setDataFavorito(LocalDateTime now) {
    }
}