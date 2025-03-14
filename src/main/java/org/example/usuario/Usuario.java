package org.example.usuario;

import org.example.artista.Artista;
import org.example.postagens.Postagens;
import java.util.List;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<Artista> artistasFavoritos;
    private List<Postagens> postagensCurtidas;

    public void setNome(String nome) {
    }

    public void setEmail(String email) {
    }

    public void setSenha(String nome) {
    }
}