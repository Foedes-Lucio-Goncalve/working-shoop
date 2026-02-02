package com.educandoWeb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoWeb.curso.entities.Categoria;
import com.educandoWeb.curso.entities.Pedido;
import com.educandoWeb.curso.entities.Usuario;
import com.educandoWeb.curso.entities.enuns.PedidoStatus;
import com.educandoWeb.curso.repositores.RepositorioCategoria;
import com.educandoWeb.curso.repositores.RepositorioPedido;
import com.educandoWeb.curso.repositores.RepositorioUsuario;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private RepositorioUsuario usarioR;
	
	@Autowired
	private RepositorioPedido pedidoR;
	
	@Autowired
	private RepositorioCategoria categoriar;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria (null,"eletronicos");
		Categoria cat2 = new Categoria (null,"livros");
		Categoria cat3 = new Categoria (null,"computadores");
		
		Usuario u1 = new Usuario(null, "pedro","pedro@gmail.com","111111","1234");
		Usuario u2 = new Usuario(null, "pedro","pedro@gmail.com","111111","1234");
		
		Pedido p1 = new Pedido(null, Instant.parse("2026-01-01T15:47:07Z"), PedidoStatus.Pagamento, u1); 
		Pedido p2 = new Pedido(null, Instant.parse("2026-01-31T17:18:07Z"),PedidoStatus.Esperando_pagamento,u2);
		Pedido p3 = new Pedido(null, Instant.parse("2026-01-11T16:48:07Z"),PedidoStatus.Enviado,u1);
		
		usarioR.saveAll(Arrays.asList(u1,u2));
		pedidoR.saveAll(Arrays.asList(p1,p2,p3));
		categoriar.saveAll(Arrays.asList(cat1,cat2,cat3));
		
	}

}
