package org.example.filtro;

import org.example.favorito.Favorito;
import org.example.usuario.Usuario;
import org.example.artista.Artista;
import org.example.postagens.Postagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/filtros")
public class FiltroController {

    @Autowired
    private FiltroService filtroService;

    @PostMapping("/usuario")
    public ResponseEntity<List<Favorito>> filtrarPorUsuario(@RequestBody List<Favorito> favoritos, @RequestParam Usuario usuario) {
        List<Favorito> resultado = filtroService.filtrarPorUsuario(favoritos, usuario);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/artista")
    public ResponseEntity<List<Favorito>> filtrarPorArtista(@RequestBody List<Favorito> favoritos, @RequestParam Artista artista) {
        List<Favorito> resultado = filtroService.filtrarPorArtista(favoritos, artista);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/postagem")
    public ResponseEntity<List<Favorito>> filtrarPorPostagem(@RequestBody List<Favorito> favoritos, @RequestParam Postagens postagem) {
        List<Favorito> resultado = filtroService.filtrarPorPostagem(favoritos, postagem);
        return ResponseEntity.ok(resultado);
    }
}
