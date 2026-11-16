package br.edu.ifpe.bemvi_api.api.profissional;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpe.bemvi_api.api.condicao.Condicao;
import br.edu.ifpe.bemvi_api.api.condicao.CondicaoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private CondicaoRepository condicaoRepository;

    @Transactional
    public ProfissionalDTO cadastrar(ProfissionalDTO dto) {
        List<Condicao> condicoes = condicaoRepository.findAllById(dto.getCondicoesIds());

        Profissional profissional = new Profissional();
        profissional.setNome(dto.getNome());
        profissional.setRegistroProfissional(dto.getRegistroProfissional());
        profissional.setCondicoes(condicoes);

        profissional = profissionalRepository.save(profissional);
        return new ProfissionalDTO(profissional);
    }

    public List<ProfissionalDTO> listar() {
        return profissionalRepository.findAll().stream()
                .map(ProfissionalDTO::new)
                .collect(Collectors.toList());
    }

    public ProfissionalDTO buscarPorId(Long id) {
        Profissional profissional = profissionalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado com id: " + id));
        return new ProfissionalDTO(profissional);
    }

    public List<ProfissionalDTO> buscarPorCondicao(Long condicaoId) {
        return profissionalRepository.findByCondicoesId(condicaoId).stream()
                .map(ProfissionalDTO::new)
                .collect(Collectors.toList());
    }

    public List<ProfissionalDTO> buscarCompativeisComFilho(Long filhoId) {
        return profissionalRepository.findProfissionaisCompativeisComFilho(filhoId).stream()
                .map(ProfissionalDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProfissionalDTO atualizar(Long id, ProfissionalDTO dto) {
        Profissional profissional = profissionalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado com id: " + id));

        List<Condicao> condicoes = condicaoRepository.findAllById(dto.getCondicoesIds());

        profissional.setNome(dto.getNome());
        profissional.setRegistroProfissional(dto.getRegistroProfissional());
        profissional.setCondicoes(condicoes);

        profissional = profissionalRepository.save(profissional);
        return new ProfissionalDTO(profissional);
    }

    @Transactional
    public void remover(Long id) {
        Profissional profissional = profissionalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado com id: " + id));
        profissionalRepository.delete(profissional);
    }
}