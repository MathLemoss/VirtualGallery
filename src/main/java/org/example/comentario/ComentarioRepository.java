package org.example.comentario;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface ComentarioRepository extends MongoRepository<Comentario, String> {
    List<Comentario> findByUsuario(Usuario usuario);
    List<Comentario> findByPostagem(Postagens postagem);
    List<Comentario> findByTextoContainingIgnoreCase(String texto);
    List<Comentario> findByDataComentarioBetween(LocalDateTime inicio, LocalDateTime fim);
}