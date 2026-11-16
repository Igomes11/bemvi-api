package br.edu.ifpe.bemvi_api.api.filho;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpe.bemvi_api.api.condicao.Condicao;
import br.edu.ifpe.bemvi_api.api.condicao.CondicaoRepository;
import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadora;
import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadoraRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class FilhoService {

    @Autowired
    private FilhoRepository filhoRepository;

    @Autowired
    private MaeCuidadoraRepository maeRepository;

    @Autowired
    private CondicaoRepository condicaoRepository;

    public List<Filho> listarTodos() {
        return filhoRepository.findAll();
    }

    public Filho buscarPorId(Long id) {
        return filhoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filho não encontrado com id: " + id));
    }

    public List<Filho> buscarPorMae(Long maeId) {
        return filhoRepository.findByMaeId(maeId);
    }

    public List<Filho> buscarPorCondicao(Long condicaoId) {
        return filhoRepository.findByCondicoesId(condicaoId);
    }

    @Transactional
    public Filho salvar(FilhoDTO dto) {
        MaeCuidadora mae = maeRepository.findById(dto.getMaeId())
                .orElseThrow(() -> new EntityNotFoundException("Mãe cuidadora não encontrada"));

        List<Condicao> condicoes = condicaoRepository.findAllById(dto.getCondicoesIds());

        Filho filho = new Filho();
        filho.setIdade(dto.getIdade());
        filho.setMae(mae);
        filho.setCondicoes(condicoes);

        return filhoRepository.save(filho);
    }

    @Transactional
    public Filho atualizar(Long id, FilhoDTO dto) {
        Filho filho = buscarPorId(id);

        MaeCuidadora mae = maeRepository.findById(dto.getMaeId())
                .orElseThrow(() -> new EntityNotFoundException("Mãe cuidadora não encontrada"));

        List<Condicao> condicoes = condicaoRepository.findAllById(dto.getCondicoesIds());

        filho.setIdade(dto.getIdade());
        filho.setMae(mae);
        filho.setCondicoes(condicoes);

        return filhoRepository.save(filho);
    }

    @Transactional
    public void deletar(Long id) {
        Filho filho = buscarPorId(id);
        filhoRepository.delete(filho);
    }
}