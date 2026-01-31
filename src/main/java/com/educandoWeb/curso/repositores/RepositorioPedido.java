package com.educandoWeb.curso.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoWeb.curso.entities.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Long> {

}
