package br.edu.ifpe.bemvi_api.api.filho;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.edu.ifpe.bemvi_api.api.categoria.Categoria;
import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadora;
import br.edu.ifpe.bemvi_api.util.EntidadeNegocio;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Filho")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Filho extends EntidadeNegocio {

    @Column(nullable = false)
    private String nome;

    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "categoria_diagnostico_id")
    private Categoria diagnostico;

    @ManyToOne
    @JoinColumn(name = "mae_id")
    @JsonBackReference
    private MaeCuidadora mae;
}