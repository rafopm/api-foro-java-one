package alura.one.api.domain.topicocategoria;

public record DatosDetallarTopicoCategoria(Long idtopicocategoria, String topicotitulo, String categorianombre) {
    public DatosDetallarTopicoCategoria(TopicoCategoria topicoCategoria){
        this(topicoCategoria.getIdtopicocategoria(), topicoCategoria.getTopico().getTitulo(), topicoCategoria.getCategoria().getNombre());
    }
}