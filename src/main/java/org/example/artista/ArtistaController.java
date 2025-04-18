package org.example.artista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public Page<Artista> listarArtistas(@PageableDefault(size = 10) Pageable pageable) {
        return artistaService.listarArtistas(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> buscarArtista(@PathVariable String id) {
        return artistaService.buscarArtista(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Artista> criarArtista(@RequestBody Artista artista) {
        Artista artistaSalvo = artistaService.criarArtista(artista);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(artistaSalvo.getId())
                .toUri();
                
        return ResponseEntity.created(location).body(artistaSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artista> atualizarArtista(@PathVariable String id, @RequestBody Artista artista) {
        return artistaService.atualizarArtista(id, artista)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarArtista(@PathVariable String id) {
        if (artistaService.deletarArtista(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/filtro/estilo")
    public Page<Artista> filtrarPorEstilo(
            @RequestParam String estilo,
            @PageableDefault(size = 10) Pageable pageable) {
        return artistaService.filtrarPorEstilo(estilo, pageable);
    }

    @GetMapping("/filtro/nome")
    public Page<Artista> filtrarPorNome(
            @RequestParam String nome,
            @PageableDefault(size = 10) Pageable pageable) {
        return artistaService.filtrarPorNome(nome, pageable);
    }
}