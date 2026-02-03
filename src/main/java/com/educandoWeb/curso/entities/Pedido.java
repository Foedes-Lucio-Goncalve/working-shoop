package com.educandoWeb.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.educandoWeb.curso.entities.enuns.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
// @Table(name = "tb-pedido") // se o nome da tabela der conflito com palavras reservadas use esse commando
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM´dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento; // instant e a data M

	private Integer status;

	@ManyToOne // para criar a chave estrangeira no pedido
	@JoinColumn(name = "cliente-id")
	private Usuario cliente;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> items = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido",cascade = CascadeType.ALL)
		private Pagamento pagamento;

	public Pedido() {

	}

	public Pedido(Long id, Instant momento, PedidoStatus status, Usuario cliente) {
		this.id = id;
		this.momento = momento;
		setPedidoStatus(status);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	

	public PedidoStatus getStatus() {
		return PedidoStatus.valueOf(status);
	}

	public void setPedidoStatus(PedidoStatus status) {
		if (status != null) {
			this.status = status.getCodigo();
		}
	}
	
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItemPedido> getItems()
	{
		return items;
	}
	
	public Double getTotal() {
		double soma = 0.0;
		for(ItemPedido x : items) {
			soma += x.getSubTotal();
		}
		return soma;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", momento=" + momento + ", Cliente=" + cliente + "]";
	}

}
