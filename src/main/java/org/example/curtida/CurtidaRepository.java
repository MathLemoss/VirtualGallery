package org.example.curtida;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurtidaRepository extends MongoRepository<Curtida, String> {
    List<Curtida> findByUsuario(Usuario usuario);
    List<Curtida> findByPostagem(Postagens postagem);
    boolean existsByUsuarioAndPostagem(Usuario usuario, Postagens postagem);
    int countByPostagem(Postagens postagem);
}