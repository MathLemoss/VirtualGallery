package org.example.compartilhar;

import org.example.artista.Artista;
import org.example.postagens.Postagens;
import org.example.usuario.Usuario;

import java.time.LocalDateTime;

public class Compartilhar {
    private Long id;
    private Usuario usuario; // Usuário que compartilhou
    private Artista artistaCompartilhado; // Pode ser nulo se for uma postagem compartilhada
    private Postagens postagemCompartilhada; // Pode ser nulo se for um artista compartilhado
    private String plataforma; // Ex: Facebook, Twitter, WhatsApp
    private LocalDateTime dataCompartilhamento;

}