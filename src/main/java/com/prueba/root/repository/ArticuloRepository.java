package com.prueba.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.root.models.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Long>{

	@Query("select a from Articulo a where a.codigo = ?1")
	public Articulo findByCodigo(String codigo);
}
