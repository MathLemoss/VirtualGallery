package org.example.postagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/postagens")
public class PostagensController {

    @Autowired
    private PostagensService postagensService;

    @GetMapping
    public List<Postagens> listarPostagens() {
        return postagensService.listarPostagens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagens> buscarPostagem(@PathVariable Long id) {
        return ResponseEntity.of(postagensService.buscarPostagem(id));
    }

    @PostMapping
    public Postagens criarPostagem(@RequestBody Postagens postagem) {
        return postagensService.criarPostagem(postagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPostagem(@PathVariable Long id) {
        if (postagensService.deletarPostagem(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

