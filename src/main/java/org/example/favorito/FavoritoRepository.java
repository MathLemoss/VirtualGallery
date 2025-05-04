package org.example.favorito;

import org.example.artista.Artista;
import org.example.usuario.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.example.postagens.Postagens;
import java.time.LocalDateTime;

import java.util.List;

@Repository
public interface FavoritoRepository extends MongoRepository<Favorito, String> {
    List<Favorito> findByUsuario(Usuario usuario);
    List<Favorito> findByArtistaFavoritado(Artista artista);
    List<Favorito> findByPostagem(Postagens postagem);
    List<Favorito> findByDataFavoritoBetween(LocalDateTime inicio, LocalDateTime fim);
}