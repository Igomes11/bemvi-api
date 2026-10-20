package br.edu.ifpe.bemvi_api.api.profissional;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class ProfissionalService {

    private final ProfissionalRepository repository;

    public ProfissionalService(ProfissionalRepository repository) {
        this.repository = repository;
    }

    public Profissional build(ProfissionalDTO dto) {
        Profissional profissional = null;

        if (dto.getId() == null) {
            profissional = new Profissional();
        } else {
            profissional = repository.findById(dto.getId()).orElseThrow();
        }

        profissional.setNome(dto.getNome());
        profissional.setEspecialidade(dto.getEspecialidade());
        profissional.setCidade(dto.getCidade());
        profissional.setContato(dto.getContato());

        return profissional;
    }

    @Transactional
    public Profissional cadastrar(ProfissionalDTO dto) {
        Profissional profissional = build(dto);
        profissional.setHabilitado(true);
        return repository.save(profissional);
    }

    @Transactional
    public Profissional atualizar(ProfissionalDTO dto) {
        Profissional profissional = build(dto);
        return repository.save(profissional);
    }

    public List<Profissional> listar() {
        return repository.findAll();
    }

    public Profissional buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public void remover(Long id) {
        Profissional profissional = repository.findById(id).orElseThrow();
        profissional.setHabilitado(false);
        repository.save(profissional);
    }
}