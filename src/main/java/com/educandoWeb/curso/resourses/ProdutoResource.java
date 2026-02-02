package com.educandoWeb.curso.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoWeb.curso.entities.Categoria;
import com.educandoWeb.curso.entities.Produto;
import com.educandoWeb.curso.services.ServicoProduto;

@RestController
@RequestMapping(value = "/Produto")
public class ProdutoResource {

	@Autowired // para o springer fazer a injecao de depencia
	private ServicoProduto service;

	@GetMapping
	public ResponseEntity<List<Produto>> finAll() {
		List<Produto> prod = service.findAll();

		return ResponseEntity.ok().body(prod);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> finById(@PathVariable Long id) {
		Produto prod = service.findById(id);

		return ResponseEntity.ok().body(prod);
	}

}
