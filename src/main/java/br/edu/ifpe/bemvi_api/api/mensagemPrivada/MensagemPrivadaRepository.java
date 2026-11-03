package br.edu.ifpe.bemvi_api.api.mensagemPrivada;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MensagemPrivadaRepository extends JpaRepository<MensagemPrivada, Long> {

    @Query("SELECT m FROM MensagemPrivada m WHERE (m.remetente.id = :idUsuario OR m.destinatario.id = :idUsuario) AND m.dataHoraEnvio > :ultimaSincronizacao")
    List<MensagemPrivada> buscarMensagensNovasParaSincronizar(
        @Param("idUsuario") Long idUsuario, 
        @Param("ultimaSincronizacao") LocalDateTime ultimaSincronizacao
    );
}