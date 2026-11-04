package br.edu.ifpe.bemvi_api.api.filho;

import br.edu.ifpe.bemvi_api.api.categoria.CategoriaDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilhoDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    private Integer idade;
    private Long diagnosticoId;
    private CategoriaDTO diagnostico;
    private Long maeId;

    public static FilhoDTO toDTO(Filho entity) {
        if (entity == null) {
            return null;
        }
        FilhoDTO dto = new FilhoDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setIdade(entity.getIdade());
        dto.setDiagnosticoId(entity.getDiagnostico() != null ? entity.getDiagnostico().getId() : null);
        dto.setDiagnostico(CategoriaDTO.toDTO(entity.getDiagnostico()));
        dto.setMaeId(entity.getMae() != null ? entity.getMae().getId() : null);
        return dto;
    }
}