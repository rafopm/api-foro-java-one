package alura.one.api.domain.topico;

public record DatosListadoTopico(Long id_topico, String titulo, String mensaje, String fecha_creacion, Estatus estatus, String usuario_nombre, String curso_nombre) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId_topico(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getEstatus(),
                topico.getUsuario().getNombre(), topico.getCurso().getNombre());
    }
}
