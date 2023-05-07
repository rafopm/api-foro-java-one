package alura.one.api.domain.categoria;

import alura.one.api.domain.topico_categoria.TopicoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findById(Long id);
}