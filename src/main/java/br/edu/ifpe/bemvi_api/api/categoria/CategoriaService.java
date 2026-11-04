package br.edu.ifpe.bemvi_api.api.categoria;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public CategoriaDTO salvar(CategoriaDTO dto) {
        Categoria entity = new Categoria();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setTipo(dto.getTipo());
        entity.setAtivo(dto.getAtivo() == null || dto.getAtivo());

        Categoria salva = repository.save(entity);
        return CategoriaDTO.toDTO(salva);
    }

    public List<CategoriaDTO> listarPorTipo(TipoCategoria tipo) {
        List<Categoria> lista = (tipo != null)
                ? repository.findByTipoAndAtivoTrue(tipo)
                : repository.findByAtivoTrue();

        return lista.stream()
                .map(CategoriaDTO::toDTO)
                .toList();
    }

    public CategoriaDTO buscarPorId(Long id) {
        Categoria entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return CategoriaDTO.toDTO(entity);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}