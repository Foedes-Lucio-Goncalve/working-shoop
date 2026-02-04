package com.educandoWeb.curso.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.educandoWeb.curso.entities.Usuario;
import com.educandoWeb.curso.repositores.RepositorioUsuario;

// @Repository registra repositorio
//@Component  // registra a classe como servico do spring e pode ser injetada automaticamente com autowrid
@Service  // registra o servico
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> user = repository.findById(id);
		return user.get();
	}
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id)
	{
		  repository.deleteById(id);
	}
	public Usuario update (Long id,Usuario obj) {
		Usuario entity = repository.getReferenceById(id);
		updateData(entity ,obj);		
		return repository.save(entity);
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		
	}
}
