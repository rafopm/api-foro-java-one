package alura.one.api.domain.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosListadoCategoria(
        @NotNull
        Long idcategoria,
        @NotBlank
        String nombre,
        @NotNull
        Boolean activo
) {
        public DatosListadoCategoria(Categoria categoria){
                this(categoria.getIdcategoria(), categoria.getNombre(), categoria.getActivo());
        }
}
