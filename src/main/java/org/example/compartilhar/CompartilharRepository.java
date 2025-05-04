package org.example.compartilhar;

import org.example.artista.Artista;
import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

import java.util.List;

@Repository
public interface CompartilharRepository extends MongoRepository<Compartilhar, String> {
    List<Compartilhar> findByUsuario(Usuario usuario);
    List<Compartilhar> findByPostagemCompartilhada(Postagens postagem);
    List<Compartilhar> findByArtistaCompartilhado(Artista artista);
    List<Compartilhar> findByPlataforma(String plataforma);
    List<Compartilhar> findByDataCompartilhamentoBetween(LocalDateTime inicio, LocalDateTime fim);
}