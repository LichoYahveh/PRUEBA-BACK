package com.prueba.root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.root.models.OrdenesDetalle;

public interface OrdenDetalleRepository extends JpaRepository<OrdenesDetalle, Long>{

	@Query("SELECT d FROM OrdenesDetalle d INNER JOIN d.ordenes o WHERE o.id = ?1")
	public List<OrdenesDetalle> findDetalleByIdCabecera(Long id);
}
