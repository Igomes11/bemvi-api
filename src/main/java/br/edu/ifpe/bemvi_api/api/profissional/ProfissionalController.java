package br.edu.ifpe.bemvi_api.api.profissional;

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
@RequestMapping("/api/profissional")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService service) {
        this.profissionalService = service;
    }

    @PostMapping
    public ResponseEntity<Profissional> cadastrar(@RequestBody @Valid ProfissionalDTO dto) {
        Profissional profissionalCadastrado = profissionalService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(profissionalCadastrado);
    }

    @PutMapping
    public ResponseEntity<Profissional> atualizar(@RequestBody @Valid ProfissionalDTO dto) {
        Profissional profissionalAtualizado = profissionalService.atualizar(dto);
        return ResponseEntity.ok(profissionalAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<Profissional>> listar() {
        return ResponseEntity.ok(profissionalService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(profissionalService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        profissionalService.remover(id);
        return ResponseEntity.noContent().build();
    }
}