package org.example.comentario;

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
@RequestMapping("/api/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<Comentario> criarComentario(
            @RequestParam String usuarioId,
            @RequestParam String postagemId,
            @RequestParam String texto) {
        
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        
        Postagens postagem = new Postagens();
        postagem.setId(postagemId);
        
        Comentario comentario = comentarioService.criarComentario(usuario, postagem, texto);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(comentario.getId())
                .toUri();
                
        return ResponseEntity.created(location).body(comentario);
    }

    @GetMapping
    public Page<Comentario> listarComentarios(@PageableDefault(size = 10) Pageable pageable) {
        return comentarioService.listarComentarios(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> buscarComentario(@PathVariable String id) {
        return comentarioService.buscarComentario(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable String id) {
        if (comentarioService.deletarComentario(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Comentario> buscarPorUsuario(@PathVariable String usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return comentarioService.buscarPorUsuario(usuario);
    }

    @GetMapping("/postagem/{postagemId}")
    public List<Comentario> buscarPorPostagem(@PathVariable String postagemId) {
        Postagens postagem = new Postagens();
        postagem.setId(postagemId);
        return comentarioService.buscarPorPostagem(postagem);
    }

    @GetMapping("/buscar")
    public List<Comentario> buscarPorTexto(@RequestParam String texto) {
        return comentarioService.buscarPorTexto(texto);
    }

    @GetMapping("/periodo")
    public List<Comentario> buscarPorPeriodo(
            @RequestParam String inicio,
            @RequestParam String fim) {
        LocalDateTime dataInicio = LocalDateTime.parse(inicio);
        LocalDateTime dataFim = LocalDateTime.parse(fim);
        return comentarioService.buscarPorPeriodo(dataInicio, dataFim);
    }
}