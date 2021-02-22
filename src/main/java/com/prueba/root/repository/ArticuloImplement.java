package com.prueba.root.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.root.models.Articulo;

@Repository
public class ArticuloImplement {

	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Transactional(readOnly = true)
	public List<Articulo> findAll(){
		return articuloRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Articulo findById(Long id) {
		return articuloRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public Articulo save(Articulo articulo) {
		return articuloRepository.save(articulo);
	}
	
	@Transactional
	public void delete(String codigo) {
		Articulo articulo = articuloRepository.findByCodigo(codigo);
		articuloRepository.deleteById(articulo.getId());
	}
	
	@Transactional
	public Articulo findByCodigo(String codigo) {
		return articuloRepository.findByCodigo(codigo);
	}
	
}
