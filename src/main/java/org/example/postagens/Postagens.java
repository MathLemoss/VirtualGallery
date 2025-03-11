package org.example.postagens;

import org.example.artista.Artista;
import org.example.comentario.Comentario;
import org.example.curtida.Curtida;
import java.time.LocalDateTime;
import java.util.List;

public class Postagens {
    private Long id;
    private Artista artista;
    private String conteudo; // Pode ser um link para uma imagem, vídeo, etc.
    private String descricao;
    private LocalDateTime dataPostagem;
    private List<Curtida> curtidas;
    private List<Comentario> comentarios;

}