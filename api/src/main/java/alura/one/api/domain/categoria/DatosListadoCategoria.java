package alura.one.api.domain.categoria;

import alura.one.api.domain.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.swing.text.StyledEditorKit;

public record DatosListadoCategoria(
        @NotNull
        Long id_categoria,
        @NotBlank
        String nombre,
        @NotNull
        Boolean activo
) {
        public DatosListadoCategoria(Categoria categoria){
                this(categoria.getId_categoria(), categoria.getNombre(), categoria.getActivo());
        }
}
