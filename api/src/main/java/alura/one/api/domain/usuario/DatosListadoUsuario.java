package alura.one.api.domain.usuario;

public record DatosListadoUsuario(
        Long idusuario,
        String nombre,
        String email,
        //String contrasena,
        Boolean activo
) {
    public DatosListadoUsuario(Usuario usuario) {
        this(usuario.getIdusuario(), usuario.getNombre(), usuario.getEmail(),
                 usuario.getActivo());

    }
}
