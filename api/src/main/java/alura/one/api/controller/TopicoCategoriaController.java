package alura.one.api.controller;

import alura.one.api.domain.categoria.Categoria;
import alura.one.api.domain.categoria.CategoriaRepository;
import alura.one.api.domain.topico.*;
import alura.one.api.domain.topico_categoria.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicocategoria")
public class TopicoCategoriaController {

    @Autowired
    private TopicoCategoriaRepository topicoCategoriaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public void registrarTopicoCategoria(@RequestBody @Valid DatosRegistroTopicoCategoria datosRegistroTopicoCategoria ) {
        Topico topico = topicoRepository.findById(datosRegistroTopicoCategoria.id_topico()).orElseThrow();
        Categoria categoria = categoriaRepository.findById(datosRegistroTopicoCategoria.id_categoria()).orElseThrow();
        TopicoCategoria topicoCategoria = new TopicoCategoria(datosRegistroTopicoCategoria, topico, categoria);
        topicoCategoriaRepository.save(topicoCategoria);
    }

    @GetMapping
    public Page<DatosListadoTopicoCategoria> listadoTopicoCategoria(@PageableDefault(size = 10) Pageable paginacion) {
        return topicoCategoriaRepository.findAll(paginacion).map(DatosListadoTopicoCategoria::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarTopicoCategoria(@PathVariable Long id) {
        var topicoCategoria = topicoCategoriaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetallarTopicoCategoria(topicoCategoria));
    }

    @PutMapping
    @Transactional
    public void actualizarTopicoCategoria(@RequestBody @Valid DatosActualizarTopicoCategoria datosActualizarTopicoCategoria) {
        Topico topico = topicoRepository.findById(datosActualizarTopicoCategoria.id_topico()).orElseThrow();
        Categoria categoria = categoriaRepository.findById(datosActualizarTopicoCategoria.id_categoria()).orElseThrow();
        TopicoCategoria topicoCategoria= topicoCategoriaRepository.getReferenceById(datosActualizarTopicoCategoria.id_topico_categoria());
        topicoCategoria.actualizarDatos(datosActualizarTopicoCategoria, topico, categoria);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopicoCategoria(@PathVariable Long id) {
        TopicoCategoria topicoCategoria = topicoCategoriaRepository.getReferenceById(id);
        topicoCategoriaRepository.delete(topicoCategoria);
    }
}
