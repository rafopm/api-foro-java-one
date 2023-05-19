package alura.one.api.domain.topico;

public record DatosListadoTopico(Long idtopico, String titulo, String mensaje, String fechacreacion, Estatus estatus, String usuarionombre, String cursonombre) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getIdtopico(), topico.getTitulo(), topico.getMensaje(), topico.getFechacreacion(), topico.getEstatus(),
                topico.getUsuario().getNombre(), topico.getCurso().getNombre());
    }
}
