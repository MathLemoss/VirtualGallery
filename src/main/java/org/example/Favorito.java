package org.example;

import java.time.LocalDateTime;

public class Favorito {
    private Long id;
    private Usuario usuario;
    private Artista artistaFavoritado; // Pode ser nulo se for uma postagem favoritada
    private Postagem postagemFavoritada; // Pode ser nulo se for um artista favoritado
    private LocalDateTime dataFavoritacao;
}
