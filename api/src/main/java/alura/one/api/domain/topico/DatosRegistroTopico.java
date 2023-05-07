package alura.one.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,

        //String fecha_creacion,
        @NotNull
        Estatus estatus,
        @NotNull
        Long id_usuario,
        @NotNull
        Long id_curso) {

}
