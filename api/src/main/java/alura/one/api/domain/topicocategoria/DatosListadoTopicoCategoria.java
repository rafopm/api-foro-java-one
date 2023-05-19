package alura.one.api.domain.topicocategoria;

public record DatosListadoTopicoCategoria(Long idtopico_categoria, String topicotitulo, String categorianombre) {
    public DatosListadoTopicoCategoria(TopicoCategoria topicoCategoria){
        this(topicoCategoria.getIdtopicocategoria(), topicoCategoria.getTopico().getTitulo(), topicoCategoria.getCategoria().getNombre());
    }
}