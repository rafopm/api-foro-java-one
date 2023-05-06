package alura.one.api.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id_topico,
    @NotBlank
    String titulo,
    @NotBlank
    String mensaje,

    String fecha_creacion,
    @NotNull
    Estatus estatus,
    @NotNull
    Long id_usuario,
    @NotNull
    Long id_curso) {

    }
