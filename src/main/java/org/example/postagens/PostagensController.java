package org.example.postagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Postagens> buscarPostagem(@PathVariable String id) {
        return postagensService.buscarPostagem(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Postagens> criarPostagem(@RequestBody Postagens postagem) {
        Postagens postagemSalva = postagensService.criarPostagem(postagem);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postagemSalva.getId())
                .toUri();
                
        return ResponseEntity.created(location).body(postagemSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPostagem(@PathVariable String id) {
        if (postagensService.deletarPostagem(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Novos endpoints
    @GetMapping("/usuario/{usuarioId}")
    public List<Postagens> buscarPorUsuario(@PathVariable String usuarioId) {
        return postagensService.buscarPorUsuario(usuarioId);
    }

    @GetMapping("/buscar")
    public List<Postagens> buscarPorConteudo(@RequestParam String termo) {
        return postagensService.buscarPorConteudo(termo);
    }
}