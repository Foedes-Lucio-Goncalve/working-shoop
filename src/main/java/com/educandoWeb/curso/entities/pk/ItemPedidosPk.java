package com.educandoWeb.curso.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.educandoWeb.curso.entities.Pedido;
import com.educandoWeb.curso.entities.Produto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable   // chave primaria dupla
public class ItemPedidosPk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "pedido_Id")
	private Pedido ped;
	
	@ManyToOne
	@JoinColumn(name = "produto_Id")
	private Produto prod;
	
	public Pedido getPed() {
		return ped;
	}
	public void setPed(Pedido ped) {
		this.ped = ped;
	}
	public Produto getProd() {
		return prod;
	}
	public void setProd(Produto prod) {
		this.prod = prod;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ped, prod);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidosPk other = (ItemPedidosPk) obj;
		return Objects.equals(ped, other.ped) && Objects.equals(prod, other.prod);
	}
	@Override
	public String toString() {
		return "ItemPedidosPk [ped=" + ped + ", prod=" + prod + "]";
	}
	
	
	
	

}
