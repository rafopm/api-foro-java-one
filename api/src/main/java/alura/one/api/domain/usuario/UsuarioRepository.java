package alura.one.api.domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Page<Usuario> findByActivoTrue(Pageable paginacion);

    Optional<Usuario> findById(Long id);

    UserDetails findByEmail(String username);

    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario findByEmailCustom(@Param("email") String email);
}
