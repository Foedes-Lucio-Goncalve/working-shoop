package com.educandoWeb.curso.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
// @Table(name = "tb-Usuario) // se o nome da tabela der conflito com palavras reservadas use esse commando
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Nome;
	private String Email;
	private String Telefone;
	private String Password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> Pedido = new ArrayList<>();
	
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
	public List<Pedido> getPedido() {
		return Pedido;
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
