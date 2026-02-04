package com.educandoWeb.curso.resourses;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoWeb.curso.entities.Usuario;
import com.educandoWeb.curso.services.ServicoUsuario;

@RestController
@RequestMapping(value = "/Usuario")
public class UsuarioResource {
	
	@Autowired   // para o springer fazer a injecao de depencia
	private ServicoUsuario service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> finAll()
	{
		List<Usuario> user = service.findAll();
		
		return ResponseEntity.ok().body(user);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> finById(@PathVariable  Long id)
	{
		Usuario user = service.findById(id);
		
		return ResponseEntity.ok().body(user);
	}
    @PostMapping
    public ResponseEntity<Usuario> insert( @RequestBody  Usuario obj)
    {
    	obj = service.insert(obj);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    	return ResponseEntity.created(uri).body(obj);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable  Long id){
    	service.delete(id);
    	return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update (@PathVariable  Long id, @RequestBody  Usuario obj)
    {
    	obj = service.update(id, obj);
    	return ResponseEntity.ok().body(obj);
    }
    
} 
