package br.edu.ifpe.bemvi_api.api.usuario;

import br.edu.ifpe.bemvi_api.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends EntidadeAuditavel implements UserDetails {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PerfilUsuario perfil;

    @Column(nullable = false)
    private boolean ativo = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.perfil == PerfilUsuario.ROLE_ADMIN) {
            return List.of(
                new SimpleGrantedAuthority(PerfilUsuario.ROLE_ADMIN.name()),
                new SimpleGrantedAuthority(PerfilUsuario.ROLE_MAE_CUIDADORA.name()),
                new SimpleGrantedAuthority(PerfilUsuario.ROLE_PROFISSIONAL.name())
            );
        }
        return List.of(new SimpleGrantedAuthority(this.perfil.name()));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.ativo;
    }
}