package alura.one.api.domain.respuesta;


import alura.one.api.domain.curso.Curso;
import alura.one.api.domain.topico.DatosActualizarTopico;
import alura.one.api.domain.topico.Topico;
import alura.one.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_respuesta;
    private String mensaje;
    private String fecha_creacion;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_topico")
    private Topico topico;

    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta, Usuario usuario, Topico topico) {
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.estatus = Estatus.valueOf("PENDIENTE");
        this.usuario = usuario;
        this.topico = topico;
    }

    public void actualizarDatos(DatosActualizarRespuesta datosActualizarRespuesta, Usuario usuario, Topico topico) {
        System.out.println("IDDDD"+datosActualizarRespuesta+" "+usuario+" "+topico);
        if (datosActualizarRespuesta.mensaje() != null) {
            this.mensaje = datosActualizarRespuesta.mensaje();
        }

        if (datosActualizarRespuesta.fecha_creacion() != null) {
            this.fecha_creacion = datosActualizarRespuesta.fecha_creacion();
        }

        if (datosActualizarRespuesta.estatus() != null) {
            this.estatus = datosActualizarRespuesta.estatus();
        }

        if (datosActualizarRespuesta.id_usuario() != null) {
            this.usuario = usuario;
        }

        if (datosActualizarRespuesta.id_topico() != null) {
            this.topico = topico;
        }

    }

    @PrePersist
    public void prePersist() {
        fecha_creacion = LocalDateTime.now().toString();
    }

    public void cambiarEstado() {
        this.estatus = Estatus.valueOf("ELIMINADA");
    }
}
