package br.edu.ifpe.bemvi_api.api.profissional;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profissional")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @PostMapping
    public ResponseEntity<ProfissionalDTO> cadastrar(@RequestBody @Valid ProfissionalDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(profissionalService.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProfissionalDTO dto) {
        return ResponseEntity.ok(profissionalService.atualizar(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalDTO>> listar() {
        return ResponseEntity.ok(profissionalService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(profissionalService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        profissionalService.remover(id);
        return ResponseEntity.noContent().build();
    }
}