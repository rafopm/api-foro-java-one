package alura.one.api.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(
        @NotNull
        Long idrespuesta,
        @NotBlank
        String mensaje,
        @NotNull
        String fechacreacion,
        @NotNull
        Estatus estatus,
        @NotNull
        Long idusuario,
        @NotNull
        Long idtopico
) {
}
