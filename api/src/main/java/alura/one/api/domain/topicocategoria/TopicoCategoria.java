package alura.one.api.domain.topicocategoria;

import alura.one.api.domain.categoria.Categoria;
import alura.one.api.domain.topico.Topico;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Table(name="topicoscategorias")
@Entity(name="TopicoCategoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_topicocategoria")
public class TopicoCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtopicocategoria;

    @ManyToOne
    @JoinColumn(name = "idtopico", referencedColumnName = "idtopico")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    private Categoria categoria;

    public TopicoCategoria(DatosRegistroTopicoCategoria datosRegistroTopicoCategoria, Topico topico, Categoria categoria){
        this.topico = topico;
        this.categoria = categoria;
    }

    public void actualizarDatos(DatosActualizarTopicoCategoria datosActualizarTopicoCategoria, Topico topico, Categoria categoria){
        if (datosActualizarTopicoCategoria.idtopico() != null) {
            this.topico = topico;
        }
        if (datosActualizarTopicoCategoria.idcategoria() != null) {
            this.categoria = categoria;
        }
    }



}
