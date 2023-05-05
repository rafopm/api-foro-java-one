package alura.one.api.topico;

import alura.one.api.categoria.Categoria;
import alura.one.api.curso.Curso;
import alura.one.api.usuario.Usuario;
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

    @PrePersist
    public void prePersist() {
        fecha_creacion = LocalDateTime.now().toString();
    }
}
