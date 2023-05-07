package alura.one.api.domain.topico_categoria;

import alura.one.api.domain.categoria.Categoria;
import alura.one.api.domain.curso.Curso;
import alura.one.api.domain.topico.DatosRegistroTopico;
import alura.one.api.domain.topico.Topico;
import alura.one.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="topicos_categorias")
@Entity(name="TopicoCategoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_topico_categoria")
public class TopicoCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_topico_categoria;

    @ManyToOne
    @JoinColumn(name = "id_topico")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public TopicoCategoria(DatosRegistroTopicoCategoria datosRegistroTopicoCategoria, Topico topico, Categoria categoria){
        this.topico = topico;
        this.categoria = categoria;
    }

    public void actualizarDatos(DatosActualizarTopicoCategoria datosActualizarTopicoCategoria, Topico topico, Categoria categoria){
        if (datosActualizarTopicoCategoria.id_topico() != null) {
            this.topico = topico;
        }
        if (datosActualizarTopicoCategoria.id_categoria() != null) {
            this.categoria = categoria;
        }
    }



}
