package alura.one.api.domain.topicocategoria;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopicoCategoria(
        @NotNull
        Long idtopico,
        @NotNull
        Long idcategoria
) {

}
