package br.edu.ifpe.bemvi_api.api.filho;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilhoRepository extends JpaRepository<Filho, Long> {

    List<Filho> findByMaeId(Long maeId);

    List<Filho> findByCondicoesId(Long condicaoId);
}