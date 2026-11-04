package br.edu.ifpe.bemvi_api.api.relatoAvaliacao;

import br.edu.ifpe.bemvi_api.api.profissional.ProfissionalDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatoAvaliacaoDTO {

    private Long id;

    @NotBlank(message = "O comentário é obrigatório")
    private String comentario;

    private Integer nota;

    private Long profissionalId;
    private ProfissionalDTO profissional;

    private Long maeId;

    public static RelatoAvaliacaoDTO toDTO(RelatoAvaliacao entity) {
        if (entity == null) {
            return null;
        }
        RelatoAvaliacaoDTO dto = new RelatoAvaliacaoDTO();
        dto.setId(entity.getId());
        dto.setComentario(entity.getComentario());
        dto.setNota(entity.getNota());
        dto.setProfissionalId(entity.getProfissional() != null ? entity.getProfissional().getId() : null);
        dto.setProfissional(ProfissionalDTO.toDTO(entity.getProfissional()));
        dto.setMaeId(entity.getMae() != null ? entity.getMae().getId() : null);
        return dto;
    }
}