package alura.one.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotBlank
        String contrasena,
        @NotNull
        Boolean activo
) {
}
