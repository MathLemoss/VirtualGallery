package org.example.comentario;

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
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario criarComentario(Usuario usuario, Postagens postagem, String texto) {
        Comentario comentario = new Comentario(usuario, postagem, texto);
        return comentarioRepository.save(comentario);
    }

    public Page<Comentario> listarComentarios(Pageable pageable) {
        return comentarioRepository.findAll(pageable);
    }

    public Optional<Comentario> buscarComentario(String id) {
        return comentarioRepository.findById(id);
    }

    public boolean deletarComentario(String id) {
        if (comentarioRepository.existsById(id)) {
            comentarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Comentario> buscarPorUsuario(Usuario usuario) {
        return comentarioRepository.findByUsuario(usuario);
    }

    public List<Comentario> buscarPorPostagem(Postagens postagem) {
        return comentarioRepository.findByPostagem(postagem);
    }

    public List<Comentario> buscarPorTexto(String texto) {
        return comentarioRepository.findByTextoContainingIgnoreCase(texto);
    }

    public List<Comentario> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return comentarioRepository.findByDataComentarioBetween(inicio, fim);
    }
}