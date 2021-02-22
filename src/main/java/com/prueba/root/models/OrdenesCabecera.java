package com.prueba.root.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ordenes_cabecera")
public class OrdenesCabecera implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date fecha;

	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_cliente")
	private Cliente cliente;

	@JsonBackReference
	//@JsonIgnoreProperties({"ordenes"})
	@OneToMany(mappedBy = "ordenes", fetch = FetchType.LAZY)
	//@JoinColumn(name="fk_orden")
	private List<OrdenesDetalle> ordenesDetalles;
	
	public OrdenesCabecera() {
		this.ordenesDetalles = new ArrayList<>();
	}

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	

	public List<OrdenesDetalle> getOrdenesDetalles() {
		return ordenesDetalles;
	}

	public void setOrdenesDetalles(List<OrdenesDetalle> ordenesDetalles) {
		this.ordenesDetalles = ordenesDetalles;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
