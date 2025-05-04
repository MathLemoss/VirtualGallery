package org.example.curtida;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/curtidas")
public class CurtidaController {
    @Autowired
    private CurtidaService curtidaService;

    @PostMapping
    public ResponseEntity<Curtida> curtirPostagem(
            @RequestParam String usuarioId,
            @RequestParam String postagemId) {
        
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        
        Postagens postagem = new Postagens();
        postagem.setId(postagemId);
        
        try {
            Curtida curtida = curtidaService.criarCurtida(usuario, postagem);
            return ResponseEntity.ok(curtida);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCurtida(@PathVariable String id) {
        curtidaService.removerCurtida(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Curtida>> buscarPorUsuario(@PathVariable String usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return ResponseEntity.ok(curtidaService.buscarCurtidasPorUsuario(usuario));
    }

    @GetMapping("/postagem/{postagemId}")
    public ResponseEntity<List<Curtida>> buscarPorPostagem(@PathVariable String postagemId) {
        Postagens postagem = new Postagens();
        postagem.setId(postagemId);
        return ResponseEntity.ok(curtidaService.buscarCurtidasPorPostagem(postagem));
    }

    @GetMapping("/postagem/{postagemId}/contagem")
    public ResponseEntity<Integer> contarCurtidas(@PathVariable String postagemId) {
        Postagens postagem = new Postagens();
        postagem.setId(postagemId);
        return ResponseEntity.ok(curtidaService.contarCurtidasDaPostagem(postagem));
    }
}