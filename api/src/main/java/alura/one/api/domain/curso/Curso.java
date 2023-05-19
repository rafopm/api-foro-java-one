package alura.one.api.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="cursos")
@Entity(name="Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="idcurso")
public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcurso;
    private String nombre;
    private String descripcion;
    private Boolean activo;

    public Curso(DatosRegistroCurso datosRegistroCurso) {
        this.nombre = datosRegistroCurso.nombre();
        this.descripcion = datosRegistroCurso.descripcion();
        this.activo = true;
    }

    public void actualizarDatos(DatosActualizarCurso datosActualizarCurso) {
        if (datosActualizarCurso.nombre() != null) {
            this.nombre = datosActualizarCurso.nombre() ;
        }
        if (datosActualizarCurso.descripcion() != null) {
            this.descripcion = datosActualizarCurso.descripcion() ;
        }
    }

    public void desactivarCurso()  {
        this.activo = false;
    }
}
