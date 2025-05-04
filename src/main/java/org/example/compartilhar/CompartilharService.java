package org.example.compartilhar;

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
public class CompartilharService {
    @Autowired
    private CompartilharRepository compartilharRepository;

    public Compartilhar compartilharPostagem(Usuario usuario, Postagens postagem, String plataforma) {
        Compartilhar compartilhar = new Compartilhar(usuario, postagem, plataforma);
        return compartilharRepository.save(compartilhar);
    }

    public Compartilhar compartilharArtista(Usuario usuario, Artista artista, String plataforma) {
        Compartilhar compartilhar = new Compartilhar(usuario, artista, plataforma);
        return compartilharRepository.save(compartilhar);
    }

    public Page<Compartilhar> listarCompartilhamentos(Pageable pageable) {
        return compartilharRepository.findAll(pageable);
    }

    public Optional<Compartilhar> buscarCompartilhamento(String id) {
        return compartilharRepository.findById(id);
    }

    public void deletarCompartilhamento(String id) {
        compartilharRepository.deleteById(id);
    }

    public List<Compartilhar> buscarPorUsuario(Usuario usuario) {
        return compartilharRepository.findByUsuario(usuario);
    }

    public List<Compartilhar> buscarPorPostagem(Postagens postagem) {
        return compartilharRepository.findByPostagemCompartilhada(postagem);
    }

    public List<Compartilhar> buscarPorArtista(Artista artista) {
        return compartilharRepository.findByArtistaCompartilhado(artista);
    }

    public List<Compartilhar> buscarPorPlataforma(String plataforma) {
        return compartilharRepository.findByPlataforma(plataforma);
    }

    public List<Compartilhar> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return compartilharRepository.findByDataCompartilhamentoBetween(inicio, fim);
    }
}