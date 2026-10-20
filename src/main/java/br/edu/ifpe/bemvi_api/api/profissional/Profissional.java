package br.edu.ifpe.bemvi_api.api.profissional;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.bemvi_api.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Profissional")
@SQLRestriction("habilitado = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profissional extends EntidadeAuditavel {

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 100)
    private String especialidade;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(length = 150)
    private String contato;
}