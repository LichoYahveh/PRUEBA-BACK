package com.prueba.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.root.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
