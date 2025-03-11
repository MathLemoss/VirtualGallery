package org.example.comentario;

import org.example.postagens.Postagens;
import org.example.usuario.Usuario;

import java.time.LocalDateTime;

public class Comentario {
    private Long id;
    private Usuario usuario;
    private Postagens postagem;
    private String texto;
    private LocalDateTime dataComentario;

}