package alura.one.api.domain.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRespuestaCategoria(
        @NotNull
        Long id_categoria,
        @NotBlank
        String nombre) {

}
