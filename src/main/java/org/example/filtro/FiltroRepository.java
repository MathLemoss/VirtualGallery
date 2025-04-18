package org.example.filtro;

import org.example.artista.Artista;
import org.example.usuario.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiltroRepository extends MongoRepository<Filtro, String> {
    List<Filtro> findByUsuario(Usuario usuario);
    List<Filtro> findByArtista(Artista artista);
    List<Filtro> findByEstiloArtistico(String estiloArtistico);
    List<Filtro> findByLocalizacao(String localizacao);
    List<Filtro> findByTipoConteudo(String tipoConteudo);
}