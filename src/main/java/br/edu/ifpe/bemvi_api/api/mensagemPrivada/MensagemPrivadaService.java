package br.edu.ifpe.bemvi_api.api.mensagemPrivada;

import java.util.List;
import org.springframework.stereotype.Service;
import br.edu.ifpe.bemvi_api.api.maeCuidadora.MaeCuidadoraService;
import jakarta.transaction.Transactional;

@Service
public class MensagemPrivadaService {

    private final MensagemPrivadaRepository repository;
    private final MaeCuidadoraService maeCuidadoraService;

    public MensagemPrivadaService(MensagemPrivadaRepository repository, 
                                  MaeCuidadoraService maeCuidadoraService) {
        this.repository = repository;
        this.maeCuidadoraService = maeCuidadoraService;
    }

    public MensagemPrivada build(MensagemPrivadaDTO dto) {
        MensagemPrivada mensagem = null;

        if (dto.getId() == null) {
            mensagem = new MensagemPrivada();
        } else {
            mensagem = repository.findById(dto.getId()).orElseThrow();
        }

        mensagem.setTextoMensagem(dto.getTextoMensagem());
        mensagem.setRemetente(maeCuidadoraService.buscarPorId(dto.getIdRemetente()));
        mensagem.setDestinatario(maeCuidadoraService.buscarPorId(dto.getIdDestinatario()));

        return mensagem;
    }

    @Transactional
    public MensagemPrivada cadastrar(MensagemPrivadaDTO dto) {
        MensagemPrivada mensagem = build(dto);
        mensagem.setHabilitado(true);
        return repository.save(mensagem);
    }

    @Transactional
    public MensagemPrivada atualizar(MensagemPrivadaDTO dto) {
        MensagemPrivada mensagem = build(dto);
        return repository.save(mensagem);
    }

    public List<MensagemPrivada> listar() {
        return repository.findAll();
    }

    public MensagemPrivada buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public void remover(Long id) {
        MensagemPrivada mensagem = repository.findById(id).orElseThrow();
        mensagem.setHabilitado(false);
        repository.save(mensagem);
    }
}