package br.edu.ifpe.bemvi_api.api.relatoAvaliacao;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relato-avaliacao")
public class RelatoAvaliacaoController {

    private final RelatoAvaliacaoService relatoAvaliacaoService;

    public RelatoAvaliacaoController(RelatoAvaliacaoService relatoAvaliacaoService) {
        this.relatoAvaliacaoService = relatoAvaliacaoService;
    }

    @PostMapping
    public ResponseEntity<RelatoAvaliacaoDTO> cadastrar(@RequestBody @Valid RelatoAvaliacaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(relatoAvaliacaoService.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelatoAvaliacaoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid RelatoAvaliacaoDTO dto) {
        return ResponseEntity.ok(relatoAvaliacaoService.atualizar(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<RelatoAvaliacaoDTO>> listar() {
        return ResponseEntity.ok(relatoAvaliacaoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelatoAvaliacaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(relatoAvaliacaoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        relatoAvaliacaoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}