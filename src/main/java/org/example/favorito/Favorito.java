package org.example.favorito;

import org.example.artista.Artista;
import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import java.time.LocalDateTime;

public class Favorito {
    private Long id;
    private Usuario usuario;
    private Artista artistaFavoritado;
    private Postagens postagemFavoritada;
    private LocalDateTime dataFavoritacao;

}