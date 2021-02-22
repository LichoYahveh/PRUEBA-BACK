package com.prueba.root.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.root.models.Articulo;
import com.prueba.root.repository.ArticuloImplement;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/articulo")
public class ArticuloController {
	
	@Autowired
	private ArticuloImplement articuloImplement;
	
	@GetMapping(value = "/index")
	public List<Articulo> index(){
		return articuloImplement.findAll();
	}
	
	@GetMapping(value = "/show/{id}")
	public Articulo show(@PathVariable Long id) {
		return articuloImplement.findById(id);
	}
	
	@PostMapping(value = "/create")
	public Articulo create(@RequestBody Articulo articulo) {
		//SI EL CODIGO NO EXISTE SE PROCEDE A CREAR EL  NUEVO ARTICULO
		Articulo existe = articuloImplement.findByCodigo(articulo.getCodigo());
		if(existe==null) {
			return articuloImplement.save(articulo);
		}else {
			return null;
		}
	}
	
	@PutMapping(value = "/update")
	public Articulo update(@RequestBody Articulo articulo) {
		//SI EL CODIGO EXISTE EN OTRO ARTICULO NO SE PROCEDE A ACTUALIZAR
		Articulo existe = articuloImplement.findByCodigo(articulo.getCodigo());
		if(existe==null) {
			return articuloImplement.save(articulo);
		}else if (existe.getId()==articulo.getId()) {
			return articuloImplement.save(articulo);
		}
		return null;
	}
	
	@DeleteMapping(value = "/delete/{codigo}")
	public void delete(@PathVariable String codigo) {
		articuloImplement.delete(codigo);
	}

}
