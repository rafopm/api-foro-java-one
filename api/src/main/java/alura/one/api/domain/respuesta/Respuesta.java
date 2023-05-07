package alura.one.api.domain.respuesta;


import alura.one.api.domain.topico.Topico;
import alura.one.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="respuestas")
@Entity(name="Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_respuesta")
public class Respuesta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
