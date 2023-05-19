package alura.one.api.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(
        @NotNull
        Long idcurso,
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion
) {
}
