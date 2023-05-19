package alura.one.api.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosListadoCurso(
        @NotNull
        Long idcurso,
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion
) {
        public DatosListadoCurso(Curso curso){
                this(curso.getIdcurso(), curso.getNombre(), curso.getDescripcion());
        }
}
