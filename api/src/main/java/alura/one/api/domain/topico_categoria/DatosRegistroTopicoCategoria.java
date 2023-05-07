package alura.one.api.domain.topico_categoria;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopicoCategoria(
        @NotNull
        Long id_topico,
        @NotNull
        Long id_categoria
) {

}
