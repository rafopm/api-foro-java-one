package alura.one.api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findById(Long id);

    @Query("SELECT t FROM Topico t WHERE t.idtopico NOT IN (SELECT r.topico.idtopico FROM Respuesta r)")
    Page<Topico> findTopicosSinRespuesta(org.springframework.data.domain.Pageable paginacion);

    Page<Topico> findByEstatus(Estatus estatus, Pageable pageable);

    Page<Topico> findByCategoriasNombre(String nombre, Pageable pageable);
}
