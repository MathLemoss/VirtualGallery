package org.example.filtro;

import org.example.favorito.Favorito;
import org.example.usuario.Usuario;
import org.example.artista.Artista;
import org.example.postagens.Postagens;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiltroService {

    public List<Favorito> filtrarPorUsuario(List<Favorito> favoritos, Usuario usuario) {
        return favoritos.stream()
                .filter(f -> f.getUsuario().equals(usuario))
                .collect(Collectors.toList());
    }

    public List<Favorito> filtrarPorArtista(List<Favorito> favoritos, Artista artista) {
        return favoritos.stream()
                .filter(f -> f.getArtistaFavoritado().equals(artista))
                .collect(Collectors.toList());
    }

    public List<Favorito> filtrarPorPostagem(List<Favorito> favoritos, Postagens postagem) {
        return favoritos.stream()
                .filter(f -> f.getPostagem().equals(postagem))
                .collect(Collectors.toList());
    }
}