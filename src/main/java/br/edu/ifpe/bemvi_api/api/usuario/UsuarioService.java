package br.edu.ifpe.bemvi_api.api.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario criarUsuario(UsuarioDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado no sistema.");
        }

        String senhaCriptografada = passwordEncoder.encode(dto.getSenha());

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(senhaCriptografada);
        usuario.setPerfil(dto.getPerfil());
        usuario.setAtivo(true);

        return repository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }
}