package alura.one.api.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull
        Long id_usuario,
        @NotBlank
        String nombre,
        @NotBlank
        String correo_electronico,
        @NotBlank
        String contrasena,
        @NotBlank
        Boolean activo
) {
}
