package br.edu.ifpe.bemvi_api.util;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntidadeAuditavel extends EntidadeNegocio {
    
    @JsonIgnore
    private Long versao;

    @JsonIgnore
    @Column
    private LocalDate dataCriacao;

    @JsonIgnore
    @Column
    private LocalDate dataUltimaModificacao;

    @JsonIgnore
    @Column
    private Long criadoPor;

    @JsonIgnore
    @Column
    private Long ultimaModificacaoPor;

}
