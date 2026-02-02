package com.educandoWeb.curso.entities.enuns;

public enum PedidoStatus {
	Esperando_pagamento(1),
	Pagamento(2),
	Enviado(3),
	Entregue(4),
	Cancelado(5);
	
	private int codigo;

	private PedidoStatus(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public static PedidoStatus valueOf(int codigo) {
		
		for(PedidoStatus value : PedidoStatus.values())
		{
			if( value.getCodigo() == codigo)
          {
        	  return value;
	      }
		}
		throw new IllegalArgumentException("codigo invalido");
		}
	}
	



