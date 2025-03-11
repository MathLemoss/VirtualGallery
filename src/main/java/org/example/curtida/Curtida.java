package org.example.curtida;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;
import java.time.LocalDateTime;

public class Curtida {
    private Long id;
    private Usuario usuario;
    private Postagens postagem;
    private LocalDateTime dataCurtida;

}