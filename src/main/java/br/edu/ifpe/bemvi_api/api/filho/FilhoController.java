package br.edu.ifpe.bemvi_api.api.filho;

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
@RequestMapping("/api/filho")
public class FilhoController {

    private final FilhoService filhoService;

    public FilhoController(FilhoService service) {
        this.filhoService = service;
    }

    @PostMapping
    public ResponseEntity<Filho> cadastrar(@RequestBody @Valid FilhoDTO dto) {
        Filho filhoCadastrado = filhoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(filhoCadastrado);
    }

    @PutMapping
    public ResponseEntity<Filho> atualizar(@RequestBody @Valid FilhoDTO dto) {
        Filho filhoAtualizado = filhoService.atualizar(dto);
        return ResponseEntity.ok(filhoAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<Filho>> listar() {
        return ResponseEntity.ok(filhoService.listar());
    }

    @GetMapping("/mae/{idMae}")
    public ResponseEntity<List<Filho>> listarPorMae(@PathVariable Long idMae) {
        return ResponseEntity.ok(filhoService.listarPorMae(idMae));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filho> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(filhoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        filhoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}