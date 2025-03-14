package org.example.postagens;

import org.example.usuario.Usuario;
import org.example.curtida.Curtida;
import org.example.compartilhar.Compartilhar;
import java.time.LocalDateTime;
import java.util.List;

public class Postagens {
    private Long id;
    private Usuario usuario;
    private String conteudo;
    private LocalDateTime dataPostagem;
    private List<Curtida> curtidas;
    private List<Compartilhar> compartilhamentos;

    public Postagens() {}

    public Postagens(Long id, Usuario usuario, String conteudo) {
        this.id = id;
        this.usuario = usuario;
        this.conteudo = conteudo;
        this.dataPostagem = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataPostagem() {
        return dataPostagem;
    }

    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Compartilhar> getCompartilhamentos() {
        return compartilhamentos;
    }

    public void setCompartilhamentos(List<Compartilhar> compartilhamentos) {
        this.compartilhamentos = compartilhamentos;
    }

    public LocalDateTime setDataPostagem(LocalDateTime now) {
        return dataPostagem;
    }
}