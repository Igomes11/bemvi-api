package br.edu.ifpe.bemvi_api.api.filho;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filho")
public class FilhoController {

    private final FilhoService filhoService;

    public FilhoController(FilhoService filhoService) {
        this.filhoService = filhoService;
    }

    @PostMapping
    public ResponseEntity<FilhoDTO> cadastrar(@RequestBody @Valid FilhoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filhoService.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilhoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid FilhoDTO dto) {
        return ResponseEntity.ok(filhoService.atualizar(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<FilhoDTO>> listar() {
        return ResponseEntity.ok(filhoService.listar());
    }

    @GetMapping("/mae/{maeId}")
    public ResponseEntity<List<FilhoDTO>> listarPorMae(@PathVariable Long maeId) {
        return ResponseEntity.ok(filhoService.listarPorMae(maeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilhoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(filhoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        filhoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}