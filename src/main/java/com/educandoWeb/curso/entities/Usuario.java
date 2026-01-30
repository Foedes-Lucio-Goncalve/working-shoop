package com.educandoWeb.curso.entities;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long Id;
	private String Nome;
	private String Email;
	private String Telefone;
	private String Password;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nome, String email, String telefone, String password) {
		super();
		Id = id;
		Nome = nome;
		Email = email;
		Telefone = telefone;
		Password = password;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(Id, other.Id);
	}

	@Override
	public String toString() {
		return "Usuario [Id=" + Id + ", Nome=" + Nome + ", Email=" + Email + ", Telefone=" + Telefone + ", Password="
				+ Password + "]";
	}

	
	
	
	

}
