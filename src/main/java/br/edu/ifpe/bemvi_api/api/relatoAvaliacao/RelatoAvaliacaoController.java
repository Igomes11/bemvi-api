package br.edu.ifpe.bemvi_api.api.relatoAvaliacao;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/relatoavaliacao")
public class RelatoAvaliacaoController {

    private final RelatoAvaliacaoService relatoAvaliacaoService;

    public RelatoAvaliacaoController(RelatoAvaliacaoService service) {
        this.relatoAvaliacaoService = service;
    }

    @PostMapping
    public ResponseEntity<RelatoAvaliacao> cadastrar(@RequestBody @Valid RelatoAvaliacaoDTO dto) {
        RelatoAvaliacao relatoCadastrado = relatoAvaliacaoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(relatoCadastrado);
    }

    @PutMapping
    public ResponseEntity<RelatoAvaliacao> atualizar(@RequestBody @Valid RelatoAvaliacaoDTO dto) {
        RelatoAvaliacao relatoAtualizado = relatoAvaliacaoService.atualizar(dto);
        return ResponseEntity.ok(relatoAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<RelatoAvaliacao>> listar() {
        return ResponseEntity.ok(relatoAvaliacaoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelatoAvaliacao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(relatoAvaliacaoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        relatoAvaliacaoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}