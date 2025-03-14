package org.example.artista;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import java.util.List;

public class Artista {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String estilo;
    private String portfolioLink;
    private List<Postagens> postagens;
    private List<Usuario> seguidores;


    public Artista() {}

    public Artista(Long id, String nome, String estilo) {
        this.id = id;
        this.nome = nome;
        this.estilo = estilo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNomeArtista(String nome) {
        this.nome = nome;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}