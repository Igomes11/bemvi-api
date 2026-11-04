package br.edu.ifpe.bemvi_api.api.profissional;

import br.edu.ifpe.bemvi_api.api.categoria.Categoria;
import br.edu.ifpe.bemvi_api.api.categoria.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;
    private final CategoriaRepository categoriaRepository;

    public ProfissionalService(ProfissionalRepository profissionalRepository,
                               CategoriaRepository categoriaRepository) {
        this.profissionalRepository = profissionalRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProfissionalDTO cadastrar(ProfissionalDTO dto) {
        Profissional profissional = Profissional.builder()
                .nome(dto.getNome())
                .registroProfissional(dto.getRegistroProfissional())
                .build();

        if (dto.getEspecialidadeId() != null) {
            Categoria especialidade = categoriaRepository.findById(dto.getEspecialidadeId())
                    .orElseThrow(() -> new RuntimeException("Categoria de especialidade não encontrada"));
            profissional.setEspecialidade(especialidade);
        }

        Profissional salvo = profissionalRepository.save(profissional);
        return ProfissionalDTO.toDTO(salvo);
    }

    public ProfissionalDTO atualizar(Long id, ProfissionalDTO dto) {
        Profissional profissional = profissionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        profissional.setNome(dto.getNome());
        profissional.setRegistroProfissional(dto.getRegistroProfissional());

        if (dto.getEspecialidadeId() != null) {
            Categoria especialidade = categoriaRepository.findById(dto.getEspecialidadeId())
                    .orElseThrow(() -> new RuntimeException("Categoria de especialidade não encontrada"));
            profissional.setEspecialidade(especialidade);
        } else {
            profissional.setEspecialidade(null);
        }

        Profissional atualizado = profissionalRepository.save(profissional);
        return ProfissionalDTO.toDTO(atualizado);
    }

    public List<ProfissionalDTO> listar() {
        return profissionalRepository.findAll().stream()
                .map(ProfissionalDTO::toDTO)
                .toList();
    }

    public ProfissionalDTO buscarPorId(Long id) {
        Profissional profissional = profissionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
        return ProfissionalDTO.toDTO(profissional);
    }

    public void remover(Long id) {
        profissionalRepository.deleteById(id);
    }
}