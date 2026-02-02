package com.educandoWeb.curso.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoWeb.curso.entities.Categoria;
import com.educandoWeb.curso.entities.Usuario;
import com.educandoWeb.curso.services.ServicoCategoria;

@RestController
@RequestMapping(value = "/Categoria")
public class CategoriaResource {
	
	@Autowired   // para o springer fazer a injecao de depencia
	private ServicoCategoria service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> finAll()
	{
		List<Categoria> categ = service.findAll();
		
		return ResponseEntity.ok().body(categ);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> finById(@PathVariable  Long id)
	{
		Categoria categ = service.findById(id);
		
		return ResponseEntity.ok().body(categ);
	}

}
