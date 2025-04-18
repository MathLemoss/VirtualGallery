package org.example.filtro;

import org.example.favorito.Favorito;
import org.example.usuario.Usuario;
import org.example.artista.Artista;
import org.example.postagens.Postagens;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "filtros")
public class Filtro {
    @Id
    private String id;
    
    @DBRef
    private Usuario usuario;
    
    @DBRef
    private Artista artista;
    
    @DBRef
    private Postagens postagem;
    
    @Field("estilo_artistico")
    private String estiloArtistico;
    
    private String localizacao;
    
    @Field("tipo_conteudo")
    private String tipoConteudo;

    public Filtro() {}

    public Filtro(Usuario usuario, Artista artista, Postagens postagem, 
                 String estiloArtistico, String localizacao, String tipoConteudo) {
        this.usuario = usuario;
        this.artista = artista;
        this.postagem = postagem;
        this.estiloArtistico = estiloArtistico;
        this.localizacao = localizacao;
        this.tipoConteudo = tipoConteudo;
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