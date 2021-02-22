package com.prueba.root.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.root.models.OrdenesCabecera;

@Repository
public class OrdenImplement {
	
	@Autowired
	private OrdenRepository ordenRepository;
	
	@Transactional
	public OrdenesCabecera save (OrdenesCabecera cabecera) {
		return ordenRepository.save(cabecera);
	}
	
	@Transactional(readOnly = true)
	public List<OrdenesCabecera> findAll(){
		return ordenRepository.findAll();
	}

}
