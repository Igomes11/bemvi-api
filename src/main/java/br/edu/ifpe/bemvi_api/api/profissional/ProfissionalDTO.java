package br.edu.ifpe.bemvi_api.api.profissional;

import br.edu.ifpe.bemvi_api.api.categoria.CategoriaDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    private String registroProfissional;
    private Long especialidadeId;
    private CategoriaDTO especialidade;

    public static ProfissionalDTO toDTO(Profissional entity) {
        if (entity == null) {
            return null;
        }
        ProfissionalDTO dto = new ProfissionalDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setRegistroProfissional(entity.getRegistroProfissional());
        dto.setEspecialidadeId(entity.getEspecialidade() != null ? entity.getEspecialidade().getId() : null);
        dto.setEspecialidade(CategoriaDTO.toDTO(entity.getEspecialidade()));
        return dto;
    }
}