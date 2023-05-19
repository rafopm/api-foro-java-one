package alura.one.api.controller;

import alura.one.api.domain.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<DatosDetallarUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario,
                                                                 UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = new Usuario(datosRegistroUsuario);
        usuarioRepository.save(usuario);

        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getIdusuario()).toUri();
        return ResponseEntity.created(url).body(new DatosDetallarUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuario>> listadoUsuario(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(usuarioRepository.findByActivoTrue(paginacion).map(DatosListadoUsuario::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetallarUsuario> detallarUsuario(@PathVariable Long id) {
        var usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetallarUsuario(usuario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.idusuario());
        usuario.actualizarDatos(datosActualizarUsuario);
        usuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(new DatosDetallarUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.desactivarUsuario();
        return ResponseEntity.noContent().build();
    }
}
