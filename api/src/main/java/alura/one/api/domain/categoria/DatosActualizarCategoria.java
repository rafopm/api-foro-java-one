package alura.one.api.domain.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarCategoria(
        @NotNull
        Long id_categoria,
        @NotBlank
        String nombre,
        @NotNull
        Boolean activo
) {
}
