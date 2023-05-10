package alura.one.api.controller;

import alura.one.api.domain.curso.*;
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
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosDetallarCurso> registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = new Curso(datosRegistroCurso);
        curso = cursoRepository.save(curso);
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId_curso()).toUri();
        return ResponseEntity.created(url).body(new DatosDetallarCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoCurso>> listadoCurso(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(cursoRepository.findAll(paginacion).map(DatosListadoCurso::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetallarCurso> detallarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetallarCurso(curso));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso) {
        Curso curso= cursoRepository.getReferenceById(datosActualizarCurso.id_curso());
        curso.actualizarDatos(datosActualizarCurso);
        curso = cursoRepository.save(curso);
        return ResponseEntity.ok(new DatosDetallarCurso(curso));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCurso(@PathVariable Long id) {
        Curso curso= cursoRepository.getReferenceById(id);
        curso.desactivarCurso();
        return ResponseEntity.noContent().build();
    }
}
