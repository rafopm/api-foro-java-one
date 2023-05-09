package alura.one.api.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosDetallarCurso(
        @NotNull
        Long id_curso,
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion,
        @NotNull
        boolean activo
) {
        public DatosDetallarCurso(Curso curso){
                this(curso.getId_curso(), curso.getNombre(), curso.getDescripcion(), curso.getActivo());
        }
}
