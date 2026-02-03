package com.educandoWeb.curso.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoWeb.curso.entities.ItemPedido;

public interface RepositorioItemPedido extends JpaRepository<ItemPedido, Long> {

}
