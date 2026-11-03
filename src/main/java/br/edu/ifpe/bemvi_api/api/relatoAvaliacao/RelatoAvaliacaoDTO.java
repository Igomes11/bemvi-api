package br.edu.ifpe.bemvi_api.api.relatoAvaliacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatoAvaliacaoDTO {

    private Long id;

    @NotNull(message = "O ID da Mãe é de preenchimento obrigatório")
    private Long idMae;

    @NotNull(message = "O ID do Profissional é de preenchimento obrigatório")
    private Long idProfissional;

    @NotNull(message = "A nota é de preenchimento obrigatório")
    private Integer nota;

    @NotBlank(message = "O texto do relato é de preenchimento obrigatório")
    private String textoRelato;
}