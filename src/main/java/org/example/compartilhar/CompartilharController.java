package org.example.compartilhar;

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

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/compartilhamentos")
public class CompartilharController {
    @Autowired
    private CompartilharService compartilharService;

    @PostMapping("/postagem")
    public ResponseEntity<Compartilhar> compartilharPostagem(
            @RequestParam String usuarioId,
            @RequestParam String postagemId,
            @RequestParam String plataforma) {
        
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        
        Postagens postagem = new Postagens();
        postagem.setId(postagemId);
        
        Compartilhar compartilhamento = compartilharService.compartilharPostagem(usuario, postagem, plataforma);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(compartilhamento.getId())
                .toUri();
                
        return ResponseEntity.created(location).body(compartilhamento);
    }

    @PostMapping("/artista")
    public ResponseEntity<Compartilhar> compartilharArtista(
            @RequestParam String usuarioId,
            @RequestParam String artistaId,
            @RequestParam String plataforma) {
        
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        
        Artista artista = new Artista();
        artista.setId(artistaId);
        
        Compartilhar compartilhamento = compartilharService.compartilharArtista(usuario, artista, plataforma);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(compartilhamento.getId())
                .toUri();
                
        return ResponseEntity.created(location).body(compartilhamento);
    }

    @GetMapping
    public Page<Compartilhar> listarCompartilhamentos(@PageableDefault(size = 10) Pageable pageable) {
        return compartilharService.listarCompartilhamentos(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compartilhar> buscarCompartilhamento(@PathVariable String id) {
        return compartilharService.buscarCompartilhamento(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCompartilhamento(@PathVariable String id) {
        compartilharService.deletarCompartilhamento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Compartilhar> buscarPorUsuario(@PathVariable String usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return compartilharService.buscarPorUsuario(usuario);
    }

    @GetMapping("/postagem/{postagemId}")
    public List<Compartilhar> buscarPorPostagem(@PathVariable String postagemId) {
        Postagens postagem = new Postagens();
        postagem.setId(postagemId);
        return compartilharService.buscarPorPostagem(postagem);
    }

    @GetMapping("/artista/{artistaId}")
    public List<Compartilhar> buscarPorArtista(@PathVariable String artistaId) {
        Artista artista = new Artista();
        artista.setId(artistaId);
        return compartilharService.buscarPorArtista(artista);
    }

    @GetMapping("/plataforma/{plataforma}")
    public List<Compartilhar> buscarPorPlataforma(@PathVariable String plataforma) {
        return compartilharService.buscarPorPlataforma(plataforma);
    }

    @GetMapping("/periodo")
    public List<Compartilhar> buscarPorPeriodo(
            @RequestParam String inicio,
            @RequestParam String fim) {
        LocalDateTime dataInicio = LocalDateTime.parse(inicio);
        LocalDateTime dataFim = LocalDateTime.parse(fim);
        return compartilharService.buscarPorPeriodo(dataInicio, dataFim);
    }
}