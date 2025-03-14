package org.example.favorito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @GetMapping
    public List<Favorito> listarFavoritos() {
        return favoritoService.listarFavoritos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorito> buscarFavorito(@PathVariable Long id) {
        return ResponseEntity.of(favoritoService.buscarFavorito(id));
    }

    @PostMapping
    public Favorito criarFavorito(@RequestBody Favorito favorito) {
        return favoritoService.criarFavorito(favorito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFavorito(@PathVariable Long id) {
        if (favoritoService.deletarFavorito(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
