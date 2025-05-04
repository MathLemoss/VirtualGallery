package org.example.favorito;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.example.artista.Artista;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "favoritos")
public class Favorito {
    @Id
    private String id;
    
    @DBRef
    private Usuario usuario;
    
    @DBRef
    private Postagens postagem;
    
    @DBRef
    private Artista artistaFavoritado;
    
    private LocalDateTime dataFavorito;

    public Favorito() {}

    public Favorito(Usuario usuario, Postagens postagem, Artista artistaFavoritado) {
        this.usuario = usuario;
        this.postagem = postagem;
        this.artistaFavoritado = artistaFavoritado;
        this.dataFavorito = LocalDateTime.now();
    }

    
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

    public Artista getArtistaFavoritado() {
        return artistaFavoritado;
    }

    public void setArtistaFavoritado(Artista artistaFavoritado) {
        this.artistaFavoritado = artistaFavoritado;
    }

    public LocalDateTime getDataFavorito() {
        return dataFavorito;
    }

    public void setDataFavorito(LocalDateTime dataFavorito) {
        this.dataFavorito = dataFavorito;
    }
}