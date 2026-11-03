package br.edu.ifpe.bemvi_api.api.filho;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilhoDTO {

    private Long id;

    @NotBlank(message = "O Nome do filho é de preenchimento obrigatório")
    private String nome;

    @NotNull(message = "A Idade do filho é de preenchimento obrigatório")
    private Integer idade;

    private String diagnostico;

    @NotNull(message = "O ID da Mãe é de preenchimento obrigatório")
    private Long idMae;
}
