package org.example.postagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostagensService {
    @Autowired
    private PostagensRepository postagensRepository;

    public List<Postagens> listarPostagens() {
        return postagensRepository.findAll();
    }

    public Optional<Postagens> buscarPostagem(String id) {
        return postagensRepository.findById(id);
    }

    public Postagens criarPostagem(Postagens postagem) {
        postagem.setDataPostagem(LocalDateTime.now());
        return postagensRepository.save(postagem);
    }

    public boolean deletarPostagem(String id) {
        if (postagensRepository.existsById(id)) {
            postagensRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Métodos adicionais
    public List<Postagens> buscarPorUsuario(String usuarioId) {
        return postagensRepository.findByUsuarioId(usuarioId);
    }

    public List<Postagens> buscarPorConteudo(String termo) {
        return postagensRepository.findByConteudoContainingIgnoreCase(termo);
    }
}