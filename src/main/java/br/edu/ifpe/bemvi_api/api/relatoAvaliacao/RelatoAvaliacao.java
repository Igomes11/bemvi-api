package br.edu.ifpe.bemvi_api.api.relatoAvaliacao;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadora;
import br.edu.ifpe.bemvi_api.api.profissional.Profissional;
import br.edu.ifpe.bemvi_api.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RelatoAvaliacao")
@SQLRestriction("habilitado = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatoAvaliacao extends EntidadeAuditavel {

    @ManyToOne
    private MaeCuidadora mae;

    @ManyToOne
    private Profissional profissional;

    @Column
    private Integer nota;

    @Column(columnDefinition = "TEXT")
    private String textoRelato;
}
