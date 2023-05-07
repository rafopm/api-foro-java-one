package alura.one.api.domain.topico;

import alura.one.api.domain.categoria.Categoria;
import alura.one.api.domain.curso.Curso;
import alura.one.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


//@Table(name = "topicos", uniqueConstraints = @UniqueConstraint(columnNames = {"titulo", "mensaje"}))
@Table(name = "topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_topico;
    private String titulo;
    private String mensaje;
    private String fecha_creacion;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToMany
    @JoinTable(name = "topicos_categorias",
            joinColumns = @JoinColumn(name = "id_topico"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<Categoria> categorias;

    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario usuario, Curso curso) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.estatus = datosRegistroTopico.estatus();
        this.usuario = usuario;
        this.curso = curso;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico, Usuario usuario, Curso curso) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.fecha_creacion() != null) {
            this.fecha_creacion = datosActualizarTopico.fecha_creacion();
        }

        if (datosActualizarTopico.estatus() != null) {
            this.estatus = datosActualizarTopico.estatus();
        }

        if (datosActualizarTopico.id_usuario() != null) {
            this.usuario = usuario;
        }

        if (datosActualizarTopico.id_curso() != null) {
            this.curso = curso;
        }

    }


    @PrePersist
    public void prePersist() {
        fecha_creacion = LocalDateTime.now().toString();
    }

    public void cambiarEstado() {
        this.estatus = Estatus.valueOf("ELIMINADO");
    }
}
