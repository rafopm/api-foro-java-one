package alura.one.api.controller;

import alura.one.api.domain.curso.Curso;
import alura.one.api.domain.curso.CursoRepository;
import alura.one.api.domain.respuesta.DatosDetallarRespuesta;
import alura.one.api.domain.topico.*;
import alura.one.api.domain.usuario.Usuario;
import alura.one.api.domain.usuario.UsuarioRepository;
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
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosDetallarTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                               UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = usuarioRepository.findById(datosRegistroTopico.id_usuario()).orElseThrow();
        Curso curso = cursoRepository.findById(datosRegistroTopico.id_curso()).orElseThrow();
        Topico topico = new Topico(datosRegistroTopico, usuario, curso);
        topicoRepository.save(topico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId_topico()).toUri();
        return ResponseEntity.created(url).body(new DatosDetallarTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopico(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetallarTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosDetallarTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Usuario usuario = usuarioRepository.findById(datosActualizarTopico.id_usuario()).orElseThrow();
        Curso curso = cursoRepository.findById(datosActualizarTopico.id_curso()).orElseThrow();
        Topico topico = topicoRepository.findById(datosActualizarTopico.id_topico()).orElseThrow();

        topico.actualizarDatos(datosActualizarTopico, usuario, curso);
        Topico topicoActualizado = topicoRepository.save(topico);

        DatosDetallarTopico datosDetallarTopico = new DatosDetallarTopico(topicoActualizado);
        return ResponseEntity.ok(datosDetallarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.cambiarEstado();
        return ResponseEntity.noContent().build();
    }
}
