package com.educandoWeb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoWeb.curso.entities.Categoria;
import com.educandoWeb.curso.repositores.RepositorioCategoria;

// @Repository registra repositorio
//@Component  // registra a classe como servico do spring e pode ser injetada automaticamente com autowrid
@Service  // registra o servico
public class ServicoCategoria {

	@Autowired
	private RepositorioCategoria repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> categ = repository.findById(id);
		return categ.get();
	}
}
