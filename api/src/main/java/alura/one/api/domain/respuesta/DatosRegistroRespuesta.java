package alura.one.api.domain.respuesta;

import alura.one.api.domain.topico.Topico;
import alura.one.api.domain.usuario.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        Long id_usuario,
        @NotNull
        Long id_topico
) {
}


