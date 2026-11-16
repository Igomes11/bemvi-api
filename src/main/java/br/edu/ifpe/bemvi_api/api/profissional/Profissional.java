package br.edu.ifpe.bemvi_api.api.profissional;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.bemvi_api.api.condicao.Condicao;
import br.edu.ifpe.bemvi_api.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profissional")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profissional extends EntidadeAuditavel {

    @Column(nullable = false)
    private String nome;

    @Column(name = "registro_profissional", nullable = false, unique = true)
    private String registroProfissional;

    @ManyToMany
    @JoinTable(
        name = "prof_especialidade",
        joinColumns = @JoinColumn(name = "profissional_id"),
        inverseJoinColumns = @JoinColumn(name = "condicao_id")
    )
    private List<Condicao> condicoes = new ArrayList<>();
}