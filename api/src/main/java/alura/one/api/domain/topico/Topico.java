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
@EqualsAndHashCode(of="idtopico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtopico")
    private Long idtopico;
    private String titulo;
    private String mensaje;
    private String fechacreacion;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Curso curso;

    @ManyToMany
    @JoinTable(name = "topicoscategorias",
            joinColumns = @JoinColumn(name = "idtopico"),
            inverseJoinColumns = @JoinColumn(name = "idcategoria"))
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
        if (datosActualizarTopico.fechacreacion() != null) {
            this.fechacreacion = datosActualizarTopico.fechacreacion();
        }

        if (datosActualizarTopico.estatus() != null) {
            this.estatus = datosActualizarTopico.estatus();
        }

        if (datosActualizarTopico.idusuario() != null) {
            this.usuario = usuario;
        }

        if (datosActualizarTopico.idcurso() != null) {
            this.curso = curso;
        }

    }


    @PrePersist
    public void prePersist() {
        fechacreacion = LocalDateTime.now().toString();
    }

    public void cambiarEstado() {
        this.estatus = Estatus.valueOf("ELIMINADO");
    }
}
