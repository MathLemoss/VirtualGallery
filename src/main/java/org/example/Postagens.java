public class Postagem {
    private Long id;
    private Artista artista;
    private String conteudo; // Pode ser um link para uma imagem, vídeo, etc.
    private String descricao;
    private LocalDateTime dataPostagem;
    private List<Curtida> curtidas;
    private List<Comentario> comentarios;

}