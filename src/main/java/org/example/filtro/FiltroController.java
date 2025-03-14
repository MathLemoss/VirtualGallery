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
    public List<Favorito> filtrarPorUsuario(@RequestBody List<Favorito> favoritos, @RequestParam Usuario usuario) {
        return filtroService.filtrarPorUsuario(favoritos, usuario);
    }

    @PostMapping("/artista")
    public List<Favorito> filtrarPorArtista(@RequestBody List<Favorito> favoritos, @RequestParam Artista artista) {
        return filtroService.filtrarPorArtista(favoritos, artista);
    }

    @PostMapping("/postagem")
    public List<Favorito> filtrarPorPostagem(@RequestBody List<Favorito> favoritos, @RequestParam Postagens postagem) {
        return filtroService.filtrarPorPostagem(favoritos, postagem);
    }
}
