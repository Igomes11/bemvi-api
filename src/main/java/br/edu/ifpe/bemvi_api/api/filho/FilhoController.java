package br.edu.ifpe.bemvi_api.api.filho;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/filhos")
public class FilhoController {

    private final FilhoService service;

    public FilhoController(FilhoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Filho>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filho> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/mae/{maeId}")
    public ResponseEntity<List<Filho>> buscarPorMae(@PathVariable Long maeId) {
        return ResponseEntity.ok(service.buscarPorMae(maeId));
    }

    @GetMapping("/condicao/{condicaoId}")
    public ResponseEntity<List<Filho>> buscarPorCondicao(@PathVariable Long condicaoId) {
        return ResponseEntity.ok(service.buscarPorCondicao(condicaoId));
    }

    @PostMapping
    public ResponseEntity<Filho> criar(@RequestBody @Valid FilhoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filho> atualizar(@PathVariable Long id, @RequestBody @Valid FilhoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}