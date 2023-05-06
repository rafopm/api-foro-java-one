package alura.one.api.controller;

import alura.one.api.curso.Curso;
import alura.one.api.curso.CursoRepository;
import alura.one.api.topico.*;
import alura.one.api.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        Usuario usuario = new Usuario(datosRegistroUsuario);
        usuarioRepository.save(usuario);
    }

    @GetMapping
    public Page<DatosListadoUsuario> listadoUsuario(@PageableDefault(size = 10) Pageable paginacion) {
        return usuarioRepository.findByActivoTrue(paginacion).map(DatosListadoUsuario::new);
    }

    @PutMapping
    @Transactional
    public void actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id_usuario());
        usuario.actualizarDatos(datosActualizarUsuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.desactivarUsuario();
    }
}
