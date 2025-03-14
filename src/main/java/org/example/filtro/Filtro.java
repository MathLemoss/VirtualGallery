package org.example.filtro;

import org.example.favorito.Favorito;
import org.example.usuario.Usuario;
import org.example.artista.Artista;
import org.example.postagens.Postagens;
import java.util.List;
import java.util.stream.Collectors;

public class Filtro {
    private Long id;
    private Usuario usuario;
    private Artista artista;
    private Postagens postagem;
    private String estiloArtistico; // Ex: Pixel Art, Pintura, 3D
    private String localizacao; // Localização do artista
    private String tipoConteudo; // Ex: Ilustração, Animação, Design de Personagens

    public Filtro() {}

    public Filtro(Long id, Usuario usuario, Artista artista, Postagens postagem, String estiloArtistico, String localizacao, String tipoConteudo) {
        this.id = id;
        this.usuario = usuario;
        this.artista = artista;
        this.postagem = postagem;
        this.estiloArtistico = estiloArtistico;
        this.localizacao = localizacao;
        this.tipoConteudo = tipoConteudo;
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

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Postagens getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagens postagem) {
        this.postagem = postagem;
    }

    public String getEstiloArtistico() {
        return estiloArtistico;
    }

    public void setEstiloArtistico(String estiloArtistico) {
        this.estiloArtistico = estiloArtistico;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipoConteudo() {
        return tipoConteudo;
    }

    public void setTipoConteudo(String tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }
}