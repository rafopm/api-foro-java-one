package alura.one.api.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
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
