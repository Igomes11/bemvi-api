package br.edu.ifpe.bemvi_api.api.condicao;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class CondicaoService {

    private final CondicaoRepository repository;

    public CondicaoService(CondicaoRepository repository) {
        this.repository = repository;
    }

    public List<Condicao> listarTodos() {
        return repository.findAll();
    }

    public Condicao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Condição não encontrada com id: " + id));
    }

    public Condicao buscarPorNome(String nome) {
        return repository.findByNomeIgnoreCase(nome)
                .orElseThrow(() -> new EntityNotFoundException("Condição não encontrada: " + nome));
    }

    @Transactional
    public Condicao salvar(CondicaoDTO dto) {
        Condicao condicao = new Condicao();
        condicao.setNome(dto.getNome());
        condicao.setDescricao(dto.getDescricao());
        return repository.save(condicao);
    }

    @Transactional
    public Condicao atualizar(Long id, CondicaoDTO dto) {
        Condicao condicao = buscarPorId(id);
        condicao.setNome(dto.getNome());
        condicao.setDescricao(dto.getDescricao());
        return repository.save(condicao);
    }

    @Transactional
    public void deletar(Long id) {
        Condicao condicao = buscarPorId(id);
        repository.delete(condicao);
    }
}