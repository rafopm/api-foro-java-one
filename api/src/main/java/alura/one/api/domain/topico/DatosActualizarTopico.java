package alura.one.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long idtopico,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        String fechacreacion,
        @NotNull
        Estatus estatus,
        @NotNull
        Long idusuario,
        @NotNull
        Long idcurso) {

}
