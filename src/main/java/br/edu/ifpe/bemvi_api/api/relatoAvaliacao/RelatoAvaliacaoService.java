package br.edu.ifpe.bemvi_api.api.relatoAvaliacao;

import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadora;
import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadoraRepository;
import br.edu.ifpe.bemvi_api.api.profissional.Profissional;
import br.edu.ifpe.bemvi_api.api.profissional.ProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatoAvaliacaoService {

    private final RelatoAvaliacaoRepository relatoAvaliacaoRepository;
    private final ProfissionalRepository profissionalRepository;
    private final MaeCuidadoraRepository maeCuidadoraRepository;

    public RelatoAvaliacaoService(RelatoAvaliacaoRepository relatoAvaliacaoRepository,
                                 ProfissionalRepository profissionalRepository,
                                 MaeCuidadoraRepository maeCuidadoraRepository) {
        this.relatoAvaliacaoRepository = relatoAvaliacaoRepository;
        this.profissionalRepository = profissionalRepository;
        this.maeCuidadoraRepository = maeCuidadoraRepository;
    }

    public RelatoAvaliacaoDTO cadastrar(RelatoAvaliacaoDTO dto) {
        RelatoAvaliacao relato = new RelatoAvaliacao();
        relato.setComentario(dto.getComentario());
        relato.setNota(dto.getNota());

        if (dto.getProfissionalId() != null) {
            Profissional profissional = profissionalRepository.findById(dto.getProfissionalId())
                    .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
            relato.setProfissional(profissional);
        }

        if (dto.getMaeId() != null) {
            MaeCuidadora mae = maeCuidadoraRepository.findById(dto.getMaeId())
                    .orElseThrow(() -> new RuntimeException("Mãe não encontrada"));
            relato.setMae(mae);
        }

        RelatoAvaliacao salvo = relatoAvaliacaoRepository.save(relato);
        return RelatoAvaliacaoDTO.toDTO(salvo);
    }

    public RelatoAvaliacaoDTO atualizar(Long id, RelatoAvaliacaoDTO dto) {
        RelatoAvaliacao relato = relatoAvaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relato não encontrado"));

        relato.setComentario(dto.getComentario());
        relato.setNota(dto.getNota());

        if (dto.getProfissionalId() != null) {
            Profissional profissional = profissionalRepository.findById(dto.getProfissionalId())
                    .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
            relato.setProfissional(profissional);
        } else {
            relato.setProfissional(null);
        }

        RelatoAvaliacao atualizado = relatoAvaliacaoRepository.save(relato);
        return RelatoAvaliacaoDTO.toDTO(atualizado);
    }

    public List<RelatoAvaliacaoDTO> listar() {
        return relatoAvaliacaoRepository.findAll().stream()
                .map(RelatoAvaliacaoDTO::toDTO)
                .toList();
    }

    public RelatoAvaliacaoDTO buscarPorId(Long id) {
        RelatoAvaliacao relato = relatoAvaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relato não encontrado"));
        return RelatoAvaliacaoDTO.toDTO(relato);
    }

    public void remover(Long id) {
        relatoAvaliacaoRepository.deleteById(id);
    }
}