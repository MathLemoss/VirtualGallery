package org.example.comentario;

import org.example.artista.Artista;
import org.example.artista.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public List<Comentario> listarComentarios() {
        return comentarioService.listarComentarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> buscarComentario(@PathVariable Long id) {
        return ResponseEntity.of(comentarioService.buscarComentario(id));
    }

    @PostMapping
    public Comentario criarComentario(@RequestBody Comentario comentario) {
        return comentarioService.criarComentario(comentario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable Long id) {
        if (comentarioService.deletarComentario(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}