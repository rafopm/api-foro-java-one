package alura.one.api.domain.topicocategoria;

public record DatosDetallarTopicoCategoriaByTopico(Long idtopicocategoria, Long idtopico, Long idcategoria, String topicotitulo, String categorianombre) {
    public DatosDetallarTopicoCategoriaByTopico(TopicoCategoria topicoCategoria){
        this(topicoCategoria.getIdtopicocategoria(), topicoCategoria.getTopico().getIdtopico(), topicoCategoria.getCategoria().getIdcategoria(), topicoCategoria.getTopico().getTitulo(), topicoCategoria.getCategoria().getNombre());
    }
}
