package org.example.postagens;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostagensService {
    private List<Postagens> postagens = new ArrayList<>();
    private Long proximoId = 1L;

    public List<Postagens> listarPostagens() {
        return postagens;
    }

    public Optional<Postagens> buscarPostagem(Long id) {
        return postagens.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Postagens criarPostagem(Postagens postagem) {
        postagem.setId(proximoId++);
        postagem.setDataPostagem(LocalDateTime.now());
        postagens.add(postagem);
        return postagem;
    }

    public boolean deletarPostagem(Long id) {
        return postagens.removeIf(postagem -> postagem.getId().equals(id));
    }
}
