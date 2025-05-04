package org.example.favorito;

import org.example.artista.Artista;
import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {
    @Autowired
    private FavoritoService favoritoService;

    @GetMapping
    public Page<Favorito> listarFavoritos(@PageableDefault(size = 10) Pageable pageable) {
        return favoritoService.listarFavoritos(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorito> buscarFavorito(@PathVariable String id) {
        return favoritoService.buscarFavorito(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Favorito> criarFavorito(@RequestBody Favorito favorito) {
        Favorito favoritoSalvo = favoritoService.criarFavorito(favorito);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(favoritoSalvo.getId())
                .toUri();
                
        return ResponseEntity.created(location).body(favoritoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFavorito(@PathVariable String id) {
        if (favoritoService.deletarFavorito(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Novos endpoints
    @GetMapping("/usuario/{usuarioId}")
    public List<Favorito> buscarPorUsuario(@PathVariable String usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return favoritoService.buscarPorUsuario(usuario);
    }

    @GetMapping("/artista/{artistaId}")
    public List<Favorito> buscarPorArtista(@PathVariable String artistaId) {
        Artista artista = new Artista();
        artista.setId(artistaId);
        return favoritoService.buscarPorArtista(artista);
    }

    @GetMapping("/postagem/{postagemId}")
    public List<Favorito> buscarPorPostagem(@PathVariable String postagemId) {
        Postagens postagem = new Postagens();
        postagem.setId(postagemId);
        return favoritoService.buscarPorPostagem(postagem);
    }

    @GetMapping("/periodo")
    public List<Favorito> buscarPorPeriodo(
            @RequestParam String inicio,
            @RequestParam String fim) {
        LocalDateTime dataInicio = LocalDateTime.parse(inicio);
        LocalDateTime dataFim = LocalDateTime.parse(fim);
        return favoritoService.buscarPorPeriodo(dataInicio, dataFim);
    }
}