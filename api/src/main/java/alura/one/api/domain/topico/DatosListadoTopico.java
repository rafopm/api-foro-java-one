package alura.one.api.domain.topico;

public record DatosListadoTopico(Long idtopico, String titulo, String mensaje, String fechacreacion, Estatus estatus, String usuarionombre, Long idusuario, String cursonombre) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getIdtopico(), topico.getTitulo(), topico.getMensaje(), topico.getFechacreacion(), topico.getEstatus(),
                topico.getUsuario().getNombre(), topico.getUsuario().getIdusuario(), topico.getCurso().getNombre());
    }
}
