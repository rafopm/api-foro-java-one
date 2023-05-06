package alura.one.api.controller;

import alura.one.api.curso.Curso;
import alura.one.api.curso.CursoRepository;
import alura.one.api.topico.*;
import alura.one.api.usuario.Usuario;
import alura.one.api.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        Usuario usuario = usuarioRepository.findById(datosRegistroTopico.id_usuario()).orElseThrow();
        Curso curso = cursoRepository.findById(datosRegistroTopico.id_curso()).orElseThrow();
        Topico topico = new Topico(datosRegistroTopico, usuario, curso);
        topicoRepository.save(topico);
    }

    @GetMapping
    public Page<DatosListadoTopico> listadoTopico(@PageableDefault(size = 10) Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Usuario usuario = usuarioRepository.findById(datosActualizarTopico.id_usuario()).orElseThrow();
        Curso curso = cursoRepository.findById(datosActualizarTopico.id_curso()).orElseThrow();
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id_topico());
        topico.actualizarDatos(datosActualizarTopico, usuario, curso);
    }
}
