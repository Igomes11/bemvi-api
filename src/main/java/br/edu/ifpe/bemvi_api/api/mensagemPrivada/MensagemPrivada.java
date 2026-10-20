package br.edu.ifpe.bemvi_api.api.mensagemPrivada;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadora;
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
@Table(name = "MensagemPrivada")
@SQLRestriction("habilitado = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MensagemPrivada extends EntidadeAuditavel {

    @ManyToOne
    private MaeCuidadora remetente;

    @ManyToOne
    private MaeCuidadora destinatario;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String textoMensagem;
}