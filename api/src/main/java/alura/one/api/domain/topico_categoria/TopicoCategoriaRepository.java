package alura.one.api.domain.topico_categoria;

import alura.one.api.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoCategoriaRepository extends JpaRepository<TopicoCategoria, Long>{
    Optional<TopicoCategoria> findById(Long id);
}