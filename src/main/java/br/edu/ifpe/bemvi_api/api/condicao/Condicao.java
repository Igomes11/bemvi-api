package br.edu.ifpe.bemvi_api.api.condicao;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ifpe.bemvi_api.api.filho.Filho;
import br.edu.ifpe.bemvi_api.api.profissional.Profissional;
import br.edu.ifpe.bemvi_api.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "condicao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Condicao extends EntidadeAuditavel {

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @JsonIgnore
    @ManyToMany(mappedBy = "condicoes")
    private List<Filho> filhos = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "condicoes")
    private List<Profissional> profissionais = new ArrayList<>();
}