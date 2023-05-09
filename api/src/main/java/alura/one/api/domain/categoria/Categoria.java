package alura.one.api.domain.categoria;

import alura.one.api.domain.curso.DatosRegistroCurso;
import alura.one.api.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="categorias")
@Entity(name="Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_categoria")
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    private String nombre;
    private Boolean activo;

    @ManyToMany(mappedBy = "categorias")
    private List<Topico> topicos;

    public Categoria(DatosRegistroCategoria datosRegistroCategoria) {
        this.nombre = datosRegistroCategoria.nombre();
        this.activo = true;
    }

    public void actualizarDatos(DatosActualizarCategoria datosActualizarCategoria) {
        if (datosActualizarCategoria.nombre() != null) {
            this.nombre = datosActualizarCategoria.nombre() ;
        }
        if (datosActualizarCategoria.activo() != null) {
            this.activo = datosActualizarCategoria.activo() ;
        }
    }

    public void desactivarCategoria()   {
        this.activo = false;
    }
}
