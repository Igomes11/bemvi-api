package br.edu.ifpe.bemvi_api.api.profissional;

import br.edu.ifpe.bemvi_api.api.categoria.Categoria;
import br.edu.ifpe.bemvi_api.util.EntidadeNegocio;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Profissional")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Profissional extends EntidadeNegocio {

    @Column(nullable = false)
    private String nome;

    private String registroProfissional;

    @ManyToOne
    @JoinColumn(name = "categoria_especialidade_id")
    private Categoria especialidade;
}