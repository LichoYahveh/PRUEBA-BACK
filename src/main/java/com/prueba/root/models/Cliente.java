package com.prueba.root.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre", nullable = false)
	private String nombre;
	
	@Column(name="apellido", nullable = false)
	private String apellido;

	@JsonBackReference
	@JsonIgnoreProperties({"cliente"})
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<OrdenesCabecera> ordenesCabecera;
	
	public Cliente() {
		this.ordenesCabecera = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<OrdenesCabecera> getOrdenesCabecera() {
		return ordenesCabecera;
	}

	public void setOrdenesCabecera(List<OrdenesCabecera> ordenesCabecera) {
		this.ordenesCabecera = ordenesCabecera;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
}
