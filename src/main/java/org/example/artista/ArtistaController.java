package org.example.artista;

import org.example.artista.Artista;
import org.example.artista.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public List<Artista> listarArtistas() {
        return artistaService.listarArtistas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> buscarArtista(@PathVariable Long id) {
        return ResponseEntity.of(artistaService.buscarArtista(id));
    }

    @PostMapping
    public Artista criarArtista(@RequestBody Artista artista) {
        return artistaService.criarArtista(artista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artista> atualizarArtista(@PathVariable Long id, @RequestBody Artista artista) {
        return ResponseEntity.of(artistaService.atualizarArtista(id, artista));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarArtista(@PathVariable Long id) {
        if (artistaService.deletarArtista(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
