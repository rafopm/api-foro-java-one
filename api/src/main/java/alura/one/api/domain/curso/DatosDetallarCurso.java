package alura.one.api.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosDetallarCurso(
        @NotNull
        Long idcurso,
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion,
        @NotNull
        boolean activo
) {
        public DatosDetallarCurso(Curso curso){
                this(curso.getIdcurso(), curso.getNombre(), curso.getDescripcion(), curso.getActivo());
        }
}
