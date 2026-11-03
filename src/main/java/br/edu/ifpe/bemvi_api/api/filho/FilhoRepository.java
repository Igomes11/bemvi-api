package br.edu.ifpe.bemvi_api.api.filho;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilhoRepository extends JpaRepository<Filho, Long> {
    
    // Consulta os filhos ativos pertencentes a uma mãe específica
    List<Filho> findByMaeId(Long idMae);
}