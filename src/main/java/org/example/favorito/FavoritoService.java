package org.example.favorito;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavoritoService {
    private List<Favorito> favoritos = new ArrayList<>();
    private Long proximoId = 1L;

    public List<Favorito> listarFavoritos() {
        return favoritos;
    }

    public Optional<Favorito> buscarFavorito(Long id) {
        return favoritos.stream().filter(f -> f.getId().equals(id)).findFirst();
    }

    public Favorito criarFavorito(Favorito favorito) {
        favorito.setId(proximoId++);
        favorito.setDataFavorito(LocalDateTime.now());
        favoritos.add(favorito);
        return favorito;
    }

    public boolean deletarFavorito(Long id) {
        return favoritos.removeIf(favorito -> favorito.getId().equals(id));
    }
}