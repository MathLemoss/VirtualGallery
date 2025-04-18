package org.example.artista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    public Page<Artista> listarArtistas(Pageable pageable) {
        return artistaRepository.findAll(pageable);
    }

    public Optional<Artista> buscarArtista(String id) {
        return artistaRepository.findById(id);
    }

    public Artista criarArtista(Artista artista) {
        return artistaRepository.save(artista);
    }

    public Optional<Artista> atualizarArtista(String id, Artista artistaAtualizado) {
        return artistaRepository.findById(id)
                .map(artista -> {
                    artista.setNome(artistaAtualizado.getNome());
                    artista.setEmail(artistaAtualizado.getEmail());
                    artista.setSenha(artistaAtualizado.getSenha());
                    artista.setEstilo(artistaAtualizado.getEstilo());
                    artista.setPortfolioLink(artistaAtualizado.getPortfolioLink());
                    return artistaRepository.save(artista);
                });
    }

    public boolean deletarArtista(String id) {
        if (artistaRepository.existsById(id)) {
            artistaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<Artista> filtrarPorEstilo(String estilo, Pageable pageable) {
        return artistaRepository.findByEstiloContainingIgnoreCase(estilo, pageable);
    }

    public Page<Artista> filtrarPorNome(String nome, Pageable pageable) {
        return artistaRepository.findByNomeContainingIgnoreCase(nome, pageable);
    }
}