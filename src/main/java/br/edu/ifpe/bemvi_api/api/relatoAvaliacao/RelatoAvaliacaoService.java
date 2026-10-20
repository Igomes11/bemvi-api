package br.edu.ifpe.bemvi_api.api.relatoAvaliacao;

import java.util.List;
import org.springframework.stereotype.Service;
import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadoraService;
import br.edu.ifpe.bemvi_api.api.profissional.ProfissionalService;
import jakarta.transaction.Transactional;

@Service
public class RelatoAvaliacaoService {

    private final RelatoAvaliacaoRepository repository;
    private final MaeCuidadoraService maeCuidadoraService;
    private final ProfissionalService profissionalService;

    public RelatoAvaliacaoService(RelatoAvaliacaoRepository repository, 
                                  MaeCuidadoraService maeCuidadoraService, 
                                  ProfissionalService profissionalService) {
        this.repository = repository;
        this.maeCuidadoraService = maeCuidadoraService;
        this.profissionalService = profissionalService;
    }

    public RelatoAvaliacao build(RelatoAvaliacaoDTO dto) {
        RelatoAvaliacao relato = null;

        if (dto.getId() == null) {
            relato = new RelatoAvaliacao();
        } else {
            relato = repository.findById(dto.getId()).orElseThrow();
        }

        relato.setNota(dto.getNota());
        relato.setTextoRelato(dto.getTextoRelato());
        relato.setMae(maeCuidadoraService.buscarPorId(dto.getIdMae()));
        relato.setProfissional(profissionalService.buscarPorId(dto.getIdProfissional()));

        return relato;
    }

    @Transactional
    public RelatoAvaliacao cadastrar(RelatoAvaliacaoDTO dto) {
        RelatoAvaliacao relato = build(dto);
        relato.setHabilitado(true);
        return repository.save(relato);
    }

    @Transactional
    public RelatoAvaliacao atualizar(RelatoAvaliacaoDTO dto) {
        RelatoAvaliacao relato = build(dto);
        return repository.save(relato);
    }

    public List<RelatoAvaliacao> listar() {
        return repository.findAll();
    }

    public RelatoAvaliacao buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public void remover(Long id) {
        RelatoAvaliacao relato = repository.findById(id).orElseThrow();
        relato.setHabilitado(false);
        repository.save(relato);
    }
}