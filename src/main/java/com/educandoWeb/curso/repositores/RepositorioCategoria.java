package com.educandoWeb.curso.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoWeb.curso.entities.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

}
