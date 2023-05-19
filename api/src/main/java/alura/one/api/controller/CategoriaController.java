package alura.one.api.controller;

import alura.one.api.domain.categoria.DatosRegistroCategoria;
import alura.one.api.domain.categoria.Categoria;
import alura.one.api.domain.categoria.*;
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
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaCategoria> registrarCategoria(@RequestBody @Valid DatosRegistroCategoria datosRegistroCategoria,
                                             UriComponentsBuilder uriComponentsBuilder) {
        Categoria categoria = categoriaRepository.save(new Categoria(datosRegistroCategoria));
        DatosRespuestaCategoria datosRespuestaCategoria = new DatosRespuestaCategoria(categoria.getIdcategoria(),
                categoria.getNombre());

        URI url = uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoria.getIdcategoria()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCategoria);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoCategoria>> listadoCategoria(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(categoriaRepository.findAll(paginacion).map(DatosListadoCategoria::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaCategoria> detallarCategoria(@PathVariable Long id) {
        Categoria categoria = categoriaRepository.getReferenceById(id);
        var datosMedico = new DatosRespuestaCategoria(categoria.getIdcategoria(),
                categoria.getNombre());
        return ResponseEntity.ok(datosMedico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarCategoria(@RequestBody @Valid DatosActualizarCategoria datosActualizarCategoria) {
        Categoria categoria = categoriaRepository.getReferenceById(datosActualizarCategoria.idcategoria());
        categoria.actualizarDatos(datosActualizarCategoria);
        return ResponseEntity.ok(new DatosRespuestaCategoria(categoria.getIdcategoria(), categoria.getNombre()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCategoria(@PathVariable Long id) {
        Categoria categoria = categoriaRepository.getReferenceById(id);
        categoria.desactivarCategoria();
        return ResponseEntity.noContent().build();
    }


}
