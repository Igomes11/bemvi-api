package br.edu.ifpe.bemvi_api.api.auth;

import br.edu.ifpe.bemvi_api.api.usuario.PerfilUsuario;

public record LoginResponseDTO(String token, Long usuarioId, PerfilUsuario perfil) {
}