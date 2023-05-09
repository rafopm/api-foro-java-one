package alura.one.api.controller;

import alura.one.api.domain.curso.*;
import alura.one.api.domain.respuesta.DatosListadoRespuesta;
import alura.one.api.domain.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public void registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso) {
        Curso curso = new Curso(datosRegistroCurso);
        cursoRepository.save(curso);
    }

    @GetMapping
    public Page<DatosListadoCurso> listadoCurso(@PageableDefault(size = 10) Pageable paginacion) {
        return cursoRepository.findAll(paginacion).map(DatosListadoCurso::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarCurso(@PathVariable Long id) {
        var curso = cursoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetallarCurso(curso));
    }

    @PutMapping
    @Transactional
    public void actualizarCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso) {
        Curso curso= cursoRepository.getReferenceById(datosActualizarCurso.id_curso());
        curso.actualizarDatos(datosActualizarCurso);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarCurso(@PathVariable Long id) {
        Curso curso= cursoRepository.getReferenceById(id);
        curso.desactivarCurso();
    }


}
