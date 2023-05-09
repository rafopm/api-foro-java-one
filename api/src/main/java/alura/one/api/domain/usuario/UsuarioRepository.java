package alura.one.api.domain.usuario;

import alura.one.api.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Page<Usuario> findByActivoTrue(Pageable paginacion);

    Optional<Usuario> findById(Long id);
}
