package br.edu.ifpe.bemvi_api.api.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    private String descricao;

    @NotNull(message = "O tipo da categoria é obrigatório")
    private TipoCategoria tipo;

    private Boolean ativo;

    public static CategoriaDTO toDTO(Categoria entity) {
        if (entity == null) {
            return null;
        }
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setTipo(entity.getTipo());
        dto.setAtivo(entity.getAtivo());
        return dto;
    }
}