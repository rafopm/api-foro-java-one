package alura.one.api.domain.respuesta;

public record DatosListadoRespuesta(
        Long idrespuesta,
        String mensaje,
        String fechacreacion,
        Estatus estatus,
        String usuarionombre,
        String topiconombre
) {
    public DatosListadoRespuesta(Respuesta respuesta) {
        this(respuesta.getIdrespuesta(), respuesta.getMensaje(), respuesta.getFechacreacion(), respuesta.getEstatus(),
                respuesta.getUsuario().getNombre(), respuesta.getTopico().getTitulo());
    }
}
