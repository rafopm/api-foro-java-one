package alura.one.api.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(
        @NotNull
        Long id_respuesta,
        @NotBlank
        String mensaje,
        @NotNull
        String fecha_creacion,
        @NotNull
        Estatus estatus,
        @NotNull
        Long id_usuario,
        @NotNull
        Long id_topico
) {
}
