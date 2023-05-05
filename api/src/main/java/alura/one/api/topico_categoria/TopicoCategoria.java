package alura.one.api.topico_categoria;

import alura.one.api.categoria.Categoria;
import alura.one.api.topico.Topico;
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
}
