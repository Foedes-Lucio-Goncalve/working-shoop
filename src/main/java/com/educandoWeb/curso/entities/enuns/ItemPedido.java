package com.educandoWeb.curso.entities.enuns;

import java.io.Serializable;
import java.util.Objects;

import com.educandoWeb.curso.entities.Pedido;
import com.educandoWeb.curso.entities.Produto;
import com.educandoWeb.curso.entities.pk.ItemPedidosPk;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemPedidosPk id;
	private Integer quantidade;
	private Double preco;

	public ItemPedido() {

	}

	public ItemPedido(Pedido ped, Produto prod, Integer quantidade, Double preco) {
		id.setPed(ped);
		id.setProd(prod);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Pedido getPedido() {
		return getPedido();
	}
	
	public void setPedido(Pedido ped) {
		id.setPed(ped);
	}
	public Produto getProduto() {
		return getProduto();
	}
	
	public void setProduto(Produto prod) {
		id.setProd(prod);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getpreco() {
		return preco;
	}

	public void setpreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", quantidade=" + quantidade + ", Preco=" + preco + "]";
	}

}
