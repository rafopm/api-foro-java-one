package alura.one.api.domain.respuesta;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        String estatus,
        @NotNull
        Long idusuario,
        @NotNull
        Long idtopico
) {
}


