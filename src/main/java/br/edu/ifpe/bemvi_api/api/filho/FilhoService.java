package br.edu.ifpe.bemvi_api.api.filho;

import br.edu.ifpe.bemvi_api.api.categoria.Categoria;
import br.edu.ifpe.bemvi_api.api.categoria.CategoriaRepository;
import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadora;
import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilhoService {

    private final FilhoRepository filhoRepository;
    private final CategoriaRepository categoriaRepository;
    private final MaeCuidadoraRepository maeCuidadoraRepository;

    public FilhoService(FilhoRepository filhoRepository, 
                       CategoriaRepository categoriaRepository,
                       MaeCuidadoraRepository maeCuidadoraRepository) {
        this.filhoRepository = filhoRepository;
        this.categoriaRepository = categoriaRepository;
        this.maeCuidadoraRepository = maeCuidadoraRepository;
    }

    public FilhoDTO cadastrar(FilhoDTO dto) {
        Filho filho = Filho.builder()
                .nome(dto.getNome())
                .idade(dto.getIdade())
                .build();

        if (dto.getDiagnosticoId() != null) {
            Categoria diagnostico = categoriaRepository.findById(dto.getDiagnosticoId())
                    .orElseThrow(() -> new RuntimeException("Categoria de diagnóstico não encontrada"));
            filho.setDiagnostico(diagnostico);
        }

        if (dto.getMaeId() != null) {
            MaeCuidadora mae = maeCuidadoraRepository.findById(dto.getMaeId())
                    .orElseThrow(() -> new RuntimeException("Mãe não encontrada"));
            filho.setMae(mae);
        }

        Filho salvo = filhoRepository.save(filho);
        return FilhoDTO.toDTO(salvo);
    }

    public FilhoDTO atualizar(Long id, FilhoDTO dto) {
        Filho filho = filhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filho não encontrado"));

        filho.setNome(dto.getNome());
        filho.setIdade(dto.getIdade());

        if (dto.getDiagnosticoId() != null) {
            Categoria diagnostico = categoriaRepository.findById(dto.getDiagnosticoId())
                    .orElseThrow(() -> new RuntimeException("Categoria de diagnóstico não encontrada"));
            filho.setDiagnostico(diagnostico);
        } else {
            filho.setDiagnostico(null);
        }

        Filho atualizado = filhoRepository.save(filho);
        return FilhoDTO.toDTO(atualizado);
    }

    public List<FilhoDTO> listar() {
        return filhoRepository.findAll().stream()
                .map(FilhoDTO::toDTO)
                .toList();
    }

    public List<FilhoDTO> listarPorMae(Long maeId) {
        return filhoRepository.findByMaeId(maeId).stream()
                .map(FilhoDTO::toDTO)
                .toList();
    }

    public FilhoDTO buscarPorId(Long id) {
        Filho filho = filhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filho não encontrado"));
        return FilhoDTO.toDTO(filho);
    }

    public void remover(Long id) {
        filhoRepository.deleteById(id);
    }
}