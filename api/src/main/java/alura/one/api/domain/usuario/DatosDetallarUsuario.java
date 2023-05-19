package alura.one.api.domain.usuario;

public record DatosDetallarUsuario(
        Long idusuario,
        String nombre,
        String email,
        //String contrasena,
        Boolean activo
) {
    public DatosDetallarUsuario(Usuario usuario) {
        this(usuario.getIdusuario(), usuario.getNombre(), usuario.getEmail(),
                 usuario.getActivo());

    }
}
