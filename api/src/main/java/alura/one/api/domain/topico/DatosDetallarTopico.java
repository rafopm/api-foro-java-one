package alura.one.api.domain.topico;

public record DatosDetallarTopico(Long idtopico, String titulo, String mensaje, String fechacreacion, Estatus estatus, String usuarionombre, String cursonombre) {

    public DatosDetallarTopico(Topico topico) {
        this(topico.getIdtopico(), topico.getTitulo(), topico.getMensaje(), topico.getFechacreacion(), topico.getEstatus(),
                topico.getUsuario().getNombre(), topico.getCurso().getNombre());
    }

}
