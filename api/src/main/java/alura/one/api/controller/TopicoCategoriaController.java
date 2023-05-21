package alura.one.api.controller;

import alura.one.api.domain.categoria.Categoria;
import alura.one.api.domain.categoria.CategoriaRepository;
import alura.one.api.domain.topico.*;
import alura.one.api.domain.topicocategoria.*;
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
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<DatosDetallarTopicoCategoria> registrarTopicoCategoria(@RequestBody @Valid
                                                                                 DatosRegistroTopicoCategoria datosRegistroTopicoCategoria,
                                                                                 UriComponentsBuilder uriComponentsBuilder
    ) {
        Topico topico = topicoRepository.findById(datosRegistroTopicoCategoria.idtopico()).orElseThrow();
        Categoria categoria = categoriaRepository.findById(datosRegistroTopicoCategoria.idcategoria()).orElseThrow();
        TopicoCategoria topicoCategoria = new TopicoCategoria(datosRegistroTopicoCategoria, topico, categoria);
        topicoCategoriaRepository.save(topicoCategoria);

        URI url = uriComponentsBuilder.path("/topicocategoria/{id}").buildAndExpand(topicoCategoria.getIdtopicocategoria()).toUri();
        return ResponseEntity.created(url).body(new DatosDetallarTopicoCategoria(topicoCategoria));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicoCategoria>> listadoTopicoCategoria(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(topicoCategoriaRepository.findAll(paginacion).map(DatosListadoTopicoCategoria::new));
    }


    @GetMapping("/{id}")
    public ResponseEntity detallarTopicoCategoria(@PathVariable Long id) {
        var topicoCategoria = topicoCategoriaRepository.getReferenceById(id);
        System.out.println("DATO" + topicoCategoria.getTopico().getIdtopico());
        return ResponseEntity.ok(new DatosDetallarTopicoCategoria(topicoCategoria));
    }

    //Obtener topicocategoria por id de topico

    @GetMapping("/topico/{id}")
    public ResponseEntity<List<DatosDetallarTopicoCategoriaByTopico>> detallarTopicoCategoriaPorTopico(@PathVariable Long id) {
        List<TopicoCategoria> topicoCategorias = topicoCategoriaRepository.findByTopicoIdtopico(id);

        if (!topicoCategorias.isEmpty()) {
            List<DatosDetallarTopicoCategoriaByTopico> response = topicoCategorias.stream()
                    .map(DatosDetallarTopicoCategoriaByTopico::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopicoCategoria(@RequestBody @Valid DatosActualizarTopicoCategoria datosActualizarTopicoCategoria) {
        Topico topico = topicoRepository.findById(datosActualizarTopicoCategoria.idtopico()).orElseThrow();
        Categoria categoria = categoriaRepository.findById(datosActualizarTopicoCategoria.idcategoria()).orElseThrow();
        TopicoCategoria topicoCategoria = topicoCategoriaRepository.getReferenceById(datosActualizarTopicoCategoria.idtopicocategoria());
        topicoCategoria.actualizarDatos(datosActualizarTopicoCategoria, topico, categoria);

        DatosDetallarTopicoCategoria datosDetallarTopicoCategoria = new DatosDetallarTopicoCategoria(topicoCategoria);
        return ResponseEntity.ok(datosDetallarTopicoCategoria);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopicoCategoria(@PathVariable Long id) {
        TopicoCategoria topicoCategoria = topicoCategoriaRepository.getReferenceById(id);
        topicoCategoriaRepository.delete(topicoCategoria);
        return ResponseEntity.noContent().build();
    }
}
