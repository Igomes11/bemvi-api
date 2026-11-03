package br.edu.ifpe.bemvi_api.api.mensagemPrivada;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/mensagemprivada")
public class MensagemPrivadaController {

    private final MensagemPrivadaService mensagemPrivadaService;

    public MensagemPrivadaController(MensagemPrivadaService service) {
        this.mensagemPrivadaService = service;
    }

    @PostMapping
    public ResponseEntity<MensagemPrivada> cadastrar(@RequestBody @Valid MensagemPrivadaDTO dto) {
        MensagemPrivada mensagemCadastrada = mensagemPrivadaService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagemCadastrada);
    }

    @PutMapping
    public ResponseEntity<MensagemPrivada> atualizar(@RequestBody @Valid MensagemPrivadaDTO dto) {
        MensagemPrivada mensagemAtualizada = mensagemPrivadaService.atualizar(dto);
        return ResponseEntity.ok(mensagemAtualizada);
    }

    @GetMapping
    public ResponseEntity<List<MensagemPrivada>> listar() {
        return ResponseEntity.ok(mensagemPrivadaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensagemPrivada> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mensagemPrivadaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        mensagemPrivadaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sincronizar/{idUsuario}")
    public ResponseEntity<List<MensagemPrivada>> sincronizar(
            @PathVariable Long idUsuario,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde) {

        List<MensagemPrivada> mensagensNovas = mensagemPrivadaService.sincronizarMensagens(idUsuario, desde);
        return ResponseEntity.ok(mensagensNovas);
    }
}