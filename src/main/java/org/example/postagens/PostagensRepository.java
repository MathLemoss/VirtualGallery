package org.example.postagens;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagensRepository extends MongoRepository<Postagens, String> {
    List<Postagens> findByUsuarioId(String usuarioId);
    List<Postagens> findByConteudoContainingIgnoreCase(String conteudo);
}