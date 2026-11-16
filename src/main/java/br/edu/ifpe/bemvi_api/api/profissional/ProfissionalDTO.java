package br.edu.ifpe.bemvi_api.api.profissional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifpe.bemvi_api.api.condicao.CondicaoDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O registro profissional é obrigatório")
    private String registroProfissional;

    @NotEmpty(message = "Informe ao menos uma condição atendida")
    private List<Long> condicoesIds = new ArrayList<>();

    private List<CondicaoDTO> condicoes = new ArrayList<>();

    public ProfissionalDTO(Profissional profissional) {
        this.id = profissional.getId();
        this.nome = profissional.getNome();
        this.registroProfissional = profissional.getRegistroProfissional();
        if (profissional.getCondicoes() != null) {
            this.condicoes = profissional.getCondicoes().stream()
                    .map(CondicaoDTO::new)
                    .collect(Collectors.toList());
            this.condicoesIds = profissional.getCondicoes().stream()
                    .map(c -> c.getId())
                    .collect(Collectors.toList());
        }
    }

    public static ProfissionalDTO toDTO(Profissional profissional) {
        if (profissional == null) {
            return null;
        }
        return new ProfissionalDTO(profissional);
    }
}