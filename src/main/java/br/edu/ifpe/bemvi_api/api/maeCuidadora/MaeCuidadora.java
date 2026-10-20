package br.edu.ifpe.bemvi_api.api.maeCuidadora;

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
@Table(name = "MaeCuidadora")
@SQLRestriction("habilitado = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaeCuidadora extends EntidadeAuditavel {

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column
    private String nomeFilho;

    @Column
    private Integer idadeFilho;

    @Column
    private Boolean modoAnonimo;

    
}
