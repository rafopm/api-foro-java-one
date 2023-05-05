package alura.one.api.controller;

import alura.one.api.curso.Curso;
import alura.one.api.curso.CursoRepository;
import alura.one.api.topico.DatosRegistroTopico;
import alura.one.api.topico.Topico;
import alura.one.api.topico.TopicoRepository;
import alura.one.api.usuario.Usuario;
import alura.one.api.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        Usuario usuario = usuarioRepository.findById(datosRegistroTopico.id_usuario()).orElseThrow();
        Curso curso = cursoRepository.findById(datosRegistroTopico.id_curso()).orElseThrow();
        Topico topico = new Topico(datosRegistroTopico, usuario, curso);
        topicoRepository.save(topico);
    }

    @GetMapping
    public List<Topico> listadoTopico(){
        return topicoRepository.findAll();
    }
}
