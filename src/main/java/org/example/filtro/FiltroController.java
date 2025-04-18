package org.example.filtro;

import org.example.artista.Artista;
import org.example.favorito.Favorito;
import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filtros")
public class FiltroController {
    @Autowired
    private FiltroService filtroService;

    @PostMapping
    public ResponseEntity<Filtro> criarFiltro(@RequestBody Filtro filtro) {
        return ResponseEntity.ok(filtroService.criarFiltro(filtro));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Favorito>> filtrarPorUsuario(@PathVariable String usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return ResponseEntity.ok(filtroService.filtrarPorUsuario(usuario));
    }

    @GetMapping("/artista/{artistaId}")
    public ResponseEntity<List<Favorito>> filtrarPorArtista(@PathVariable String artistaId) {
        Artista artista = new Artista();
        artista.setId(artistaId);
        return ResponseEntity.ok(filtroService.filtrarPorArtista(artista));
    }

    @GetMapping("/postagem/{postagemId}")
    public ResponseEntity<List<Favorito>> filtrarPorPostagem(@PathVariable String postagemId) {
        Postagens postagem = new Postagens();
        postagem.setId(postagemId);
        return ResponseEntity.ok(filtroService.filtrarPorPostagem(postagem));
    }
    
    @GetMapping("/estilo/{estilo}")
    public ResponseEntity<List<Filtro>> filtrarPorEstilo(@PathVariable String estilo) {
        return ResponseEntity.ok(filtroService.filtrarPorEstiloArtistico(estilo));
    }
    
    @GetMapping("/localizacao/{localizacao}")
    public ResponseEntity<List<Filtro>> filtrarPorLocalizacao(@PathVariable String localizacao) {
        return ResponseEntity.ok(filtroService.filtrarPorLocalizacao(localizacao));
    }
    
    @GetMapping("/tipo-conteudo/{tipo}")
    public ResponseEntity<List<Filtro>> filtrarPorTipoConteudo(@PathVariable String tipo) {
        return ResponseEntity.ok(filtroService.filtrarPorTipoConteudo(tipo));
    }
}