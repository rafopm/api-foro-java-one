package alura.one.api.controller;

import alura.one.api.domain.curso.Curso;
import alura.one.api.domain.curso.CursoRepository;
import alura.one.api.domain.respuesta.*;
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

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping
    public void registrarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta) {
        Usuario usuario = usuarioRepository.findById(datosRegistroRespuesta.id_usuario()).orElseThrow();
        Topico topico = topicoRepository.findById(datosRegistroRespuesta.id_topico()).orElseThrow();
        Respuesta respuesta = new Respuesta(datosRegistroRespuesta, usuario, topico);
        respuestaRepository.save(respuesta);
    }

    @GetMapping
    public Page<DatosListadoRespuesta> listadoRespuesta(@PageableDefault(size = 10) Pageable paginacion) {
        return respuestaRepository.findAll(paginacion).map(DatosListadoRespuesta::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarRespuesta(@PathVariable Long id) {
        var respuesta = respuestaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetallarRespuesta(respuesta));
    }

    /*
    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Usuario usuario = usuarioRepository.findById(datosActualizarTopico.id_usuario()).orElseThrow();
        Curso curso = cursoRepository.findById(datosActualizarTopico.id_curso()).orElseThrow();
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id_topico());
        topico.actualizarDatos(datosActualizarTopico, usuario, curso);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.cambiarEstado();
    }

     */
}
