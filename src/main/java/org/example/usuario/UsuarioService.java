package org.example.usuario;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();
    private Long proximoId = 1L;

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public Optional<Usuario> buscarUsuario(Long id) {
        return usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setId(proximoId++);
        usuarios.add(usuario);
        return usuario;
    }

    public boolean deletarUsuario(Long id) {
        return usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }
}
