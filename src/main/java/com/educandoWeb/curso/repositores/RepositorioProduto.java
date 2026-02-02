package com.educandoWeb.curso.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoWeb.curso.entities.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long> {

}
