package br.edu.ifpe.bemvi_api.api.filho;

import java.util.List;
import org.springframework.stereotype.Service;
import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadoraService;
import jakarta.transaction.Transactional;

@Service
public class FilhoService {

    private final FilhoRepository repository;
    private final MaeCuidadoraService maeCuidadoraService;

    public FilhoService(FilhoRepository repository, MaeCuidadoraService maeCuidadoraService) {
        this.repository = repository;
        this.maeCuidadoraService = maeCuidadoraService;
    }

    public Filho build(FilhoDTO dto) {
        Filho filho = (dto.getId() == null) 
                ? new Filho() 
                : repository.findById(dto.getId()).orElseThrow();

        filho.setNome(dto.getNome());
        filho.setIdade(dto.getIdade());
        filho.setDiagnostico(dto.getDiagnostico());
        filho.setMae(maeCuidadoraService.buscarPorId(dto.getIdMae()));

        return filho;
    }

    @Transactional
    public Filho cadastrar(FilhoDTO dto) {
        Filho filho = build(dto);
        filho.setHabilitado(true);
        return repository.save(filho);
    }

    @Transactional
    public Filho atualizar(FilhoDTO dto) {
        Filho filho = build(dto);
        return repository.save(filho);
    }

    public List<Filho> listar() {
        return repository.findAll();
    }

    public List<Filho> listarPorMae(Long idMae) {
        return repository.findByMaeId(idMae);
    }

    public Filho buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public void remover(Long id) {
        Filho filho = repository.findById(id).orElseThrow();
        filho.setHabilitado(false);
        repository.save(filho);
    }
}