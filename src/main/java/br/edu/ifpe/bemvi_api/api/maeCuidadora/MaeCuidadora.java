package br.edu.ifpe.bemvi_api.api.maeCuidadora;

import java.util.List;
import org.hibernate.annotations.SQLRestriction;
import br.edu.ifpe.bemvi_api.api.filho.Filho;
import br.edu.ifpe.bemvi_api.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "mae")
    private List<Filho> filhos;

    @Column
    private Boolean modoAnonimo;

    
}
