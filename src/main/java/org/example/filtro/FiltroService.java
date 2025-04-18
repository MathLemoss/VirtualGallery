package org.example.filtro;

import org.example.artista.Artista;
import org.example.favorito.Favorito;
import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiltroService {
    @Autowired
    private FiltroRepository filtroRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public Filtro criarFiltro(Filtro filtro) {
        return filtroRepository.save(filtro);
    }
    
    public List<Favorito> filtrarPorUsuario(Usuario usuario) {
        // Implementação alternativa usando MongoTemplate para consultas mais complexas
        Query query = new Query(Criteria.where("usuario.$id").is(usuario.getId()));
        return mongoTemplate.find(query, Favorito.class);
    }

    public List<Favorito> filtrarPorArtista(Artista artista) {
        Query query = new Query(Criteria.where("artista.$id").is(artista.getId()));
        return mongoTemplate.find(query, Favorito.class);
    }

    public List<Favorito> filtrarPorPostagem(Postagens postagem) {
        Query query = new Query(Criteria.where("postagem.$id").is(postagem.getId()));
        return mongoTemplate.find(query, Favorito.class);
    }
    
    public List<Filtro> filtrarPorEstiloArtistico(String estilo) {
        return filtroRepository.findByEstiloArtistico(estilo);
    }
    
    public List<Filtro> filtrarPorLocalizacao(String localizacao) {
        return filtroRepository.findByLocalizacao(localizacao);
    }
    
    public List<Filtro> filtrarPorTipoConteudo(String tipoConteudo) {
        return filtroRepository.findByTipoConteudo(tipoConteudo);
    }
}