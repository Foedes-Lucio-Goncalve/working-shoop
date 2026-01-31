package com.educandoWeb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoWeb.curso.entities.Pedido;
import com.educandoWeb.curso.repositores.RepositorioPedido;

// @Repository registra repositorio
//@Component  // registra a classe como servico do spring e pode ser injetada automaticamente com autowrid
@Service  // registra o servico
public class ServicoPedido {

	@Autowired
	private RepositorioPedido repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.get();
	}
}
