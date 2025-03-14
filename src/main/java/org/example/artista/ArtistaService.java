package org.example.artista;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    private List<Artista> artistas = new ArrayList<>();
    private Long proximoId = 1L;

    public List<Artista> listarArtistas() {
        return artistas;
    }

    public Optional<Artista> buscarArtista(Long id) {
        return artistas.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public Artista criarArtista(Artista artista) {
        artista.setId(proximoId++);
        artistas.add(artista);
        return artista;
    }

    public Optional<Artista> atualizarArtista(Long id, Artista artistaAtualizado) {
        Optional<Artista> artistaExistente = buscarArtista(id);
        artistaExistente.ifPresent(artista -> {
            artista.setNomeArtista(artistaAtualizado.getNome());
            artista.setEstilo(artistaAtualizado.getEstilo());
        });
        return artistaExistente;
    }

    public boolean deletarArtista(Long id) {
        return artistas.removeIf(artista -> artista.getId().equals(id));
    }
}