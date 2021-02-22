package com.prueba.root.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.root.models.Cliente;
import com.prueba.root.repository.ClienteImplement;

@CrossOrigin(origins = {"http://localhost:4200"} )
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteImplement clienteImplement; 
	
	@GetMapping(value = "/index")
	public List<Cliente> index(){
		return clienteImplement.findAll();
	}
	
}
