package alura.one.api.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="usuarios")
@Entity(name="Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nombre;
    private String correo_electronico;
    private String contrasena;
    private Boolean activo;

    public Usuario(DatosRegistroUsuario datosRegistroUsuario) {
        this.activo = true;
        this.nombre = datosRegistroUsuario.nombre();
        this.correo_electronico = datosRegistroUsuario.correo_electronico();
        this.contrasena = datosRegistroUsuario.contrasena();
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario) {
        if (datosActualizarUsuario.nombre() != null) {
            this.nombre = datosActualizarUsuario.nombre();
        }
        if (datosActualizarUsuario.correo_electronico() != null) {
            this.correo_electronico = datosActualizarUsuario.correo_electronico();
        }
        if (datosActualizarUsuario.contrasena() != null) {
            this.contrasena = datosActualizarUsuario.contrasena();
        }
        if (datosActualizarUsuario.activo() != null) {
            this.activo = datosActualizarUsuario.activo();
        }
    }

    public void desactivarUsuario() {
        this.activo = false;
    }

}
