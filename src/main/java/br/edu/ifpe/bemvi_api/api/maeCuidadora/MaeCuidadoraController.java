package br.edu.ifpe.bemvi_api.api.maeCuidadora;

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
@RequestMapping("/api/maecuidadora")
public class MaeCuidadoraController {

    private final MaeCuidadoraService maeCuidadoraService;

    public MaeCuidadoraController(MaeCuidadoraService service) {
        this.maeCuidadoraService = service;
    }

    @PostMapping
    public ResponseEntity<MaeCuidadora> cadastrar(@RequestBody @Valid MaeCuidadoraDTO dto) {
        MaeCuidadora maeCadastrada = maeCuidadoraService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(maeCadastrada);
    }

    @PutMapping
    public ResponseEntity<MaeCuidadora> atualizar(@RequestBody @Valid MaeCuidadoraDTO dto) {
        MaeCuidadora maeAtualizada = maeCuidadoraService.atualizar(dto);
        return ResponseEntity.ok(maeAtualizada);
    }

    @GetMapping
    public ResponseEntity<List<MaeCuidadora>> listar() {
        return ResponseEntity.ok(maeCuidadoraService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaeCuidadora> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(maeCuidadoraService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        maeCuidadoraService.remover(id);
        return ResponseEntity.noContent().build();
    }
}