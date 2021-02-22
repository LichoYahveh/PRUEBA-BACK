package com.prueba.root.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ordenes_detalle")
public class OrdenesDetalle implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_articulo")
	private Articulo articulo;

	//@JsonManagedReference
	@OneToOne
	@JoinColumn(name="fk_orden")
	private OrdenesCabecera ordenes;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public OrdenesCabecera getOrdenesCabecera() {
		return ordenes;
	}

	public void setOrdenesCabecera(OrdenesCabecera ordenesCabecera) {
		this.ordenes = ordenesCabecera;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
