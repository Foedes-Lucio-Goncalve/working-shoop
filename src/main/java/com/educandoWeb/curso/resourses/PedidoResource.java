package com.educandoWeb.curso.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoWeb.curso.entities.Pedido;
import com.educandoWeb.curso.services.ServicoPedido;

@RestController
@RequestMapping(value = "/Pedido")
public class PedidoResource {
	
	@Autowired   // para o springer fazer a injecao de depencia
	private ServicoPedido service;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> finAll()
	{
		List<Pedido> pedido = service.findAll();
		
		return ResponseEntity.ok().body(pedido);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> finById(@PathVariable  Long id)
	{
		Pedido pedido = service.findById(id);
		
		return ResponseEntity.ok().body(pedido);
	}

}
