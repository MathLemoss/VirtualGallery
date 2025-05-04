package org.example.favorito;

import org.example.artista.Artista;
import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FavoritoService {
    @Autowired
    private FavoritoRepository favoritoRepository;

    public List<Favorito> listarFavoritos() {
        return favoritoRepository.findAll();
    }

    public Page<Favorito> listarFavoritos(Pageable pageable) {
        return favoritoRepository.findAll(pageable);
    }

    public Optional<Favorito> buscarFavorito(String id) {
        return favoritoRepository.findById(id);
    }

    public Favorito criarFavorito(Favorito favorito) {
        favorito.setDataFavorito(LocalDateTime.now());
        return favoritoRepository.save(favorito);
    }

    public boolean deletarFavorito(String id) {
        if (favoritoRepository.existsById(id)) {
            favoritoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Métodos adicionais
    public List<Favorito> buscarPorUsuario(Usuario usuario) {
        return favoritoRepository.findByUsuario(usuario);
    }

    public List<Favorito> buscarPorArtista(Artista artista) {
        return favoritoRepository.findByArtistaFavoritado(artista);
    }

    public List<Favorito> buscarPorPostagem(Postagens postagem) {
        return favoritoRepository.findByPostagem(postagem);
    }

    public List<Favorito> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return favoritoRepository.findByDataFavoritoBetween(inicio, fim);
    }
}