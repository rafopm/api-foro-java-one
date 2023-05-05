package alura.one.api.topico;

public record DatosRegistroTopico(String titulo, String mensaje, String fecha_creacion, Estatus estatus, Long id_usuario, Long id_curso) {
}
