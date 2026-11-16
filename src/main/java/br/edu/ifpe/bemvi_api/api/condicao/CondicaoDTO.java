package br.edu.ifpe.bemvi_api.api.condicao;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CondicaoDTO {

    private Long id;

    @NotBlank(message = "O nome da condição é obrigatório")
    private String nome;

    private String descricao;

    public CondicaoDTO(Condicao condicao) {
        this.id = condicao.getId();
        this.nome = condicao.getNome();
        this.descricao = condicao.getDescricao();
    }
}