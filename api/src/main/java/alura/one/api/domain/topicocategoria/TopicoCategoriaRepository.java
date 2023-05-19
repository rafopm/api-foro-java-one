package alura.one.api.domain.topicocategoria;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicoCategoriaRepository extends JpaRepository<TopicoCategoria, Long> {
    Optional<TopicoCategoria> findById(Long id);

    List<TopicoCategoria> findByTopicoIdtopico(Long id);
}

