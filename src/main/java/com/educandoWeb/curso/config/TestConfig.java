package com.educandoWeb.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoWeb.curso.entities.Usuario;
import com.educandoWeb.curso.repositores.RepositorioUsuario;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private RepositorioUsuario usarioR;

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "pedro","pedro@gmail.com","111111","1234");
		Usuario u2 = new Usuario(null, "pedro","pedro@gmail.com","111111","1234");
		
		usarioR.saveAll(Arrays.asList(u1,u2));
		
	}

}
