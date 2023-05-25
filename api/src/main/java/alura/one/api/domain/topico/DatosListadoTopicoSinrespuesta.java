package alura.one.api.domain.topico;

public record DatosListadoTopicoSinrespuesta(Long idtopico, String titulo, String mensaje, String fechacreacion, Estatus estatus, String usuarionombre, Long idusuario, String cursonombre, boolean tieneRespuesta) {
    public DatosListadoTopicoSinrespuesta(Topico topico, boolean tieneRespuesta) {
        this(topico.getIdtopico(), topico.getTitulo(), topico.getMensaje(), topico.getFechacreacion(), topico.getEstatus(),
                topico.getUsuario().getNombre(), topico.getUsuario().getIdusuario(), topico.getCurso().getNombre(), tieneRespuesta);
    }
}
