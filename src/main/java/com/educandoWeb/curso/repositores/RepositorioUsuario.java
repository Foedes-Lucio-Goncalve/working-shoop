package com.educandoWeb.curso.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoWeb.curso.entities.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
