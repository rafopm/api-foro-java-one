package alura.one.api.domain.topico_categoria;

public record DatosListadoTopicoCategoria(Long id_topico_categoria, String topico_titulo, String categoria_nombre) {
    public DatosListadoTopicoCategoria(TopicoCategoria topicoCategoria){
        this(topicoCategoria.getId_topico_categoria(), topicoCategoria.getTopico().getTitulo(), topicoCategoria.getCategoria().getNombre());
    }
}