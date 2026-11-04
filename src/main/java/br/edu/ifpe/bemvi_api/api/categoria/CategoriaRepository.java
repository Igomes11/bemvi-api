package br.edu.ifpe.bemvi_api.api.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByTipoAndAtivoTrue(TipoCategoria tipo);

    List<Categoria> findByAtivoTrue();
}