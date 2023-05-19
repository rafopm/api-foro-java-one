package alura.one.api.domain.respuesta;

public record DatosDetallarRespuesta(
        Long idrespuesta,
        String mensaje,
        String fechacreacion,
        Estatus estatus,
        String usuarionombre,
        String topiconombre
) {
    public DatosDetallarRespuesta(Respuesta respuesta) {
        this(respuesta.getIdrespuesta(), respuesta.getMensaje(), respuesta.getFechacreacion(), respuesta.getEstatus(),
                respuesta.getUsuario().getNombre(), respuesta.getTopico().getTitulo());
    }
}
