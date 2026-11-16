package br.edu.ifpe.bemvi_api.api.filho;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.edu.ifpe.bemvi_api.api.condicao.Condicao;
import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadora;
import br.edu.ifpe.bemvi_api.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "filho")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Filho extends EntidadeAuditavel {

    @Column(nullable = false)
    private Integer idade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mae_id", nullable = false)
    @JsonIgnoreProperties({"filhos", "hibernateLazyInitializer", "handler"})
    private MaeCuidadora mae;

    @ManyToMany
    @JoinTable(
        name = "filho_condicao",
        joinColumns = @JoinColumn(name = "filho_id"),
        inverseJoinColumns = @JoinColumn(name = "condicao_id")
    )
    private List<Condicao> condicoes = new ArrayList<>();
}