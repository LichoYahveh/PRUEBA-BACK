package com.prueba.root.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.root.models.OrdenesDetalle;

@Repository
public class OrdenDetalleImplement {

	@Autowired
	private OrdenDetalleRepository ordenDetalleRepository;
	
	@Transactional
	public void save(OrdenesDetalle ordenesDetalle) {
		ordenDetalleRepository.save(ordenesDetalle);
	}
	
	@Transactional(readOnly = true)
	public List<OrdenesDetalle> ordenesDetalleList(Long id){
		return ordenDetalleRepository.findDetalleByIdCabecera(id);
	}
}
