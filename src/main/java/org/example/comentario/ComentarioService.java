package org.example.comentario;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class ComentarioService {
    private List<Comentario> comentarios = new ArrayList<>();
    private Long proximoId = 1L;

    public List<Comentario> listarComentarios() {
        return comentarios;
    }

    public Optional<Comentario> buscarComentario(Long id) {
        return comentarios.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Comentario criarComentario(Comentario comentario) {
        comentario.setId(proximoId++);
        comentario.setDataComentario(LocalDateTime.now());
        comentarios.add(comentario);
        return comentario;
    }

    public boolean deletarComentario(Long id) {
        return comentarios.removeIf(comentario -> comentario.getId().equals(id));
    }
}
