package alura.one.api.domain.topicocategoria;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopicoCategoria(
        @NotNull
        Long idtopicocategoria,
        @NotNull
        Long idtopico,
        @NotNull
        Long idcategoria
) {
}
