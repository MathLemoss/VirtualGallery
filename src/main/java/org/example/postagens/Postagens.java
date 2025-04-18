package org.example.postagens;

import org.example.usuario.Usuario;
import org.example.curtida.Curtida;
import org.example.compartilhar.Compartilhar;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "postagens")
public class Postagens {
    @Id
    private String id; 
    
    @DBRef
    private Usuario usuario;
    
    private String conteudo;
    private LocalDateTime dataPostagem;
    
    @DBRef
    private List<Curtida> curtidas;
    
    @DBRef
    private List<Compartilhar> compartilhamentos;

    public Postagens() {}

    public Postagens(Usuario usuario, String conteudo) {
        this.usuario = usuario;
        this.conteudo = conteudo;
        this.dataPostagem = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setDataPostagem(LocalDateTime dataPostagem) {
        this.dataPostagem = dataPostagem;
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
}