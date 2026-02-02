package com.educandoWeb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoWeb.curso.entities.Categoria;
import com.educandoWeb.curso.entities.Pedido;
import com.educandoWeb.curso.entities.Produto;
import com.educandoWeb.curso.entities.Usuario;
import com.educandoWeb.curso.entities.enuns.PedidoStatus;
import com.educandoWeb.curso.repositores.RepositorioCategoria;
import com.educandoWeb.curso.repositores.RepositorioPedido;
import com.educandoWeb.curso.repositores.RepositorioProduto;
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
	
	@Autowired
	private RepositorioProduto produtor;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria (null,"eletronicos");
		Categoria cat2 = new Categoria (null,"livros");
		Categoria cat3 = new Categoria (null,"computadores");
		
		Produto pd1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Produto pd2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Produto pd3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Produto pd4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Produto pd5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		Usuario u1 = new Usuario(null, "pedro","pedro@gmail.com","111111","1234");
		Usuario u2 = new Usuario(null, "pedro","pedro@gmail.com","111111","1234");
		
		Pedido p1 = new Pedido(null, Instant.parse("2026-01-01T15:47:07Z"), PedidoStatus.Pagamento, u1); 
		Pedido p2 = new Pedido(null, Instant.parse("2026-01-31T17:18:07Z"),PedidoStatus.Esperando_pagamento,u2);
		Pedido p3 = new Pedido(null, Instant.parse("2026-01-11T16:48:07Z"),PedidoStatus.Enviado,u1);
		
		usarioR.saveAll(Arrays.asList(u1,u2));
		pedidoR.saveAll(Arrays.asList(p1,p2,p3));
		categoriar.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtor.saveAll(Arrays.asList(pd1,pd2,pd3,pd4,pd5));
		
	}

}
