package alura.one.api.domain.respuesta;

public record DatosListadoRespuesta(
        Long id_respuesta,
        String mensaje,
        String fecha_creacion,
        Estatus estatus,
        String usuario_nombre,
        String topico_nombre
) {
    public DatosListadoRespuesta(Respuesta respuesta) {
        this(respuesta.getId_respuesta(), respuesta.getMensaje(), respuesta.getFecha_creacion(), respuesta.getEstatus(),
                respuesta.getUsuario().getNombre(), respuesta.getTopico().getTitulo());
    }
}
