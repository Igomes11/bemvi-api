package br.edu.ifpe.bemvi_api.api.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PerfilUsuario {

    ROLE_MAE_CUIDADORA("maeCuidadora"),
    ROLE_PROFISSIONAL("profissional"),
    ROLE_ADMIN("admin");

    private final String descricao;
}