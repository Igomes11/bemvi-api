package br.edu.ifpe.bemvi_api.api.profissional;

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
@RequestMapping("/api/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;

    @PostMapping
    public ResponseEntity<ProfissionalDTO> cadastrar(@RequestBody @Valid ProfissionalDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/condicao/{condicaoId}")
    public ResponseEntity<List<ProfissionalDTO>> buscarPorCondicao(@PathVariable Long condicaoId) {
        return ResponseEntity.ok(service.buscarPorCondicao(condicaoId));
    }

    @GetMapping("/compativeis-filho/{filhoId}")
    public ResponseEntity<List<ProfissionalDTO>> buscarCompativeisComFilho(@PathVariable Long filhoId) {
        return ResponseEntity.ok(service.buscarCompativeisComFilho(filhoId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProfissionalDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}