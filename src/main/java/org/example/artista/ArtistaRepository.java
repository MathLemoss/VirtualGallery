package org.example.artista;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistaRepository extends MongoRepository<Artista, String> {
    List<Artista> findByEstiloContainingIgnoreCase(String estilo);
    Page<Artista> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Page<Artista> findByEstiloContainingIgnoreCase(String estilo, Pageable pageable);
}