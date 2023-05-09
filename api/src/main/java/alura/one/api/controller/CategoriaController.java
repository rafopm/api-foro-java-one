package alura.one.api.controller;

import alura.one.api.domain.categoria.DatosRegistroCategoria;
import alura.one.api.domain.categoria.Categoria;
import alura.one.api.domain.categoria.DatosRegistroCategoria;
import alura.one.api.domain.categoria.*;
import alura.one.api.domain.topico_categoria.DatosDetallarTopicoCategoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public void registrarCategoria(@RequestBody @Valid DatosRegistroCategoria datosRegistroCategoria) {
        Categoria categoria = new Categoria(datosRegistroCategoria);
        categoriaRepository.save(categoria);
    }

    @GetMapping
    public Page<DatosListadoCategoria> listadoCategoria(@PageableDefault(size = 10) Pageable paginacion) {
        return categoriaRepository.findAll(paginacion).map(DatosListadoCategoria::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarCategoria(@PathVariable Long id) {
        var categoria = categoriaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetallarCategoria(categoria));
    }

    @PutMapping
    @Transactional
    public void actualizarCategoria(@RequestBody @Valid DatosActualizarCategoria datosActualizarCategoria) {
        Categoria categoria = categoriaRepository.getReferenceById(datosActualizarCategoria.id_categoria());
        categoria.actualizarDatos(datosActualizarCategoria);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarCategoria(@PathVariable Long id) {
        Categoria categoria = categoriaRepository.getReferenceById(id);
        categoria.desactivarCategoria();
    }


}
