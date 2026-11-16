package br.edu.ifpe.bemvi_api.api.profissional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    List<Profissional> findByCondicoesId(Long condicaoId);

    @Query("""
        SELECT DISTINCT p
        FROM Profissional p
        JOIN p.condicoes c
        WHERE c.id IN (
            SELECT fc.id FROM Filho f JOIN f.condicoes fc WHERE f.id = :filhoId
        )
    """)
    List<Profissional> findProfissionaisCompativeisComFilho(@Param("filhoId") Long filhoId);
}