package br.edu.ifpe.bemvi_api.api.profissional;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalDTO {

    private Long id;

    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    private String nome;

    @NotBlank(message = "A Especialidade é de preenchimento obrigatório")
    private String especialidade;

    @NotBlank(message = "A Cidade é de preenchimento obrigatório")
    private String cidade;

    private String contato;
}