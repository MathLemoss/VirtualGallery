package org.example.curtida;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CurtidaService {
    @Autowired
    private CurtidaRepository curtidaRepository;

    public Curtida criarCurtida(Usuario usuario, Postagens postagem) {
        if (curtidaRepository.existsByUsuarioAndPostagem(usuario, postagem)) {
            throw new IllegalStateException("Usuário já curtiu esta postagem");
        }
        
        Curtida curtida = new Curtida(usuario, postagem);
        return curtidaRepository.save(curtida);
    }

    public void removerCurtida(String id) {
        curtidaRepository.deleteById(id);
    }

    public List<Curtida> buscarCurtidasPorUsuario(Usuario usuario) {
        return curtidaRepository.findByUsuario(usuario);
    }

    public List<Curtida> buscarCurtidasPorPostagem(Postagens postagem) {
        return curtidaRepository.findByPostagem(postagem);
    }

    public int contarCurtidasDaPostagem(Postagens postagem) {
        return curtidaRepository.countByPostagem(postagem);
    }
}