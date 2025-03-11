package org.example.artista;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import java.util.List;

public class Artista {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String estiloArtistico;
    private String portfolioLink;
    private List<Postagens> postagens;
    private List<Usuario> seguidores;

}