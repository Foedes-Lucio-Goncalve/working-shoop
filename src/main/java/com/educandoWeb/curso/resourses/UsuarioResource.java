package com.educandoWeb.curso.resourses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoWeb.curso.entities.Usuario;

@RestController
@RequestMapping(value = "/Usuario")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity<Usuario> finAll()
	{
		Usuario user = new Usuario(1L, "lucio","lucio@gmail.com", "11111", "1234567");
		return ResponseEntity.ok().body(user);
	}

}
