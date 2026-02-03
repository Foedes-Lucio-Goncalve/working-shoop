package com.educandoWeb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.educandoWeb.curso.entities.Produto;
import com.educandoWeb.curso.repositores.RepositorioProduto;

// @Repository registra repositorio
//@Component  // registra a classe como servico do spring e pode ser injetada automaticamente com autowrid
@Service  // registra o servico
public class ServicoProduto {

	@Autowired
	private RepositorioProduto repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> prod = repository.findById(id);
		return prod.get();
	}
}
