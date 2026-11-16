package br.edu.ifpe.bemvi_api.api.condicao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CondicaoRepository extends JpaRepository<Condicao, Long> {

    List<Condicao> findByTipoAndAtivoTrue(TipoCondicao tipo);

    List<Condicao> findByAtivoTrue();

    Optional<Condicao> findByNomeIgnoreCase(String nome);
}