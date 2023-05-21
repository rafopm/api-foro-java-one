package alura.one.api.domain.respuesta;

public record DatosListadoRespuestaByTopico(
        Long idrespuesta,
        String mensaje,
        String fechacreacion,
        Estatus estatus,
        String usuarionombre,
        String topiconombre,

        Long idtopico
) {
    public DatosListadoRespuestaByTopico(Respuesta respuesta) {
        this(respuesta.getIdrespuesta(), respuesta.getMensaje(), respuesta.getFechacreacion(), respuesta.getEstatus(),
                respuesta.getUsuario().getNombre(), respuesta.getTopico().getTitulo(), respuesta.getTopico().getIdtopico());
    }
}
