package alura.one.api.domain.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosDetallarCategoria(@NotNull
                                     Long id_categoria,
                                     @NotBlank
                                     String nombre,
                                     @NotNull
                                     Boolean activo) {
    public DatosDetallarCategoria(Categoria categoria){
        this(categoria.getId_categoria(), categoria.getNombre(), categoria.getActivo());
    }
}
