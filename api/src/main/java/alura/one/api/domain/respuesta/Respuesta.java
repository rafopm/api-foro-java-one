package alura.one.api.domain.respuesta;


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
@EqualsAndHashCode(of = "idrespuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrespuesta;
    private String mensaje;
    private String fechacreacion;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idtopico")
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

        if (datosActualizarRespuesta.fechacreacion() != null) {
            this.fechacreacion = datosActualizarRespuesta.fechacreacion();
        }

        if (datosActualizarRespuesta.estatus() != null) {
            this.estatus = datosActualizarRespuesta.estatus();
        }

        if (datosActualizarRespuesta.idusuario() != null) {
            this.usuario = usuario;
        }

        if (datosActualizarRespuesta.idtopico() != null) {
            this.topico = topico;
        }

    }

    @PrePersist
    public void prePersist() {
        fechacreacion = LocalDateTime.now().toString();
    }

    public void cambiarEstado() {
        this.estatus = Estatus.valueOf("ELIMINADA");
    }
}
