package br.edu.ifpe.bemvi_api.api.maeCuidadora;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class MaeCuidadoraService {

    private final MaeCuidadoraRepository repository;

    public MaeCuidadoraService(MaeCuidadoraRepository repository) {
        this.repository = repository;
    }

    public MaeCuidadora build(MaeCuidadoraDTO dto) {
        MaeCuidadora mae = null;

        if (dto.getId() == null) {
            mae = new MaeCuidadora();
        } else {
            mae = repository.findById(dto.getId()).orElseThrow();
        }

        mae.setNome(dto.getNome());
        mae.setEmail(dto.getEmail());
        mae.setSenha(dto.getSenha());
        mae.setNomeFilho(dto.getNomeFilho());
        mae.setIdadeFilho(dto.getIdadeFilho());
        mae.setModoAnonimo(dto.getModoAnonimo() != null ? dto.getModoAnonimo() : Boolean.FALSE);

        return mae;
    }

    @Transactional
    public MaeCuidadora cadastrar(MaeCuidadoraDTO dto) {
        MaeCuidadora mae = build(dto);
        mae.setHabilitado(true);
        return repository.save(mae);
    }

    @Transactional
    public MaeCuidadora atualizar(MaeCuidadoraDTO dto) {
        MaeCuidadora mae = build(dto);
        return repository.save(mae);
    }

    public List<MaeCuidadora> listar() {
        return repository.findAll();
    }

    public MaeCuidadora buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public void remover(Long id) {
        MaeCuidadora mae = repository.findById(id).orElseThrow();
        mae.setHabilitado(false);
        repository.save(mae);
    }
}