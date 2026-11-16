package br.edu.ifpe.bemvi_api.api.auth;

import br.edu.ifpe.bemvi_api.api.usuario.Usuario;
import br.edu.ifpe.bemvi_api.api.usuario.UsuarioDTO;
import br.edu.ifpe.bemvi_api.api.usuario.UsuarioService;
import br.edu.ifpe.bemvi_api.config.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid UsuarioDTO dto) {
        usuarioService.criarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}