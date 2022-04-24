package br.com.fiap.persistense.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PedidoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "codigo_pedido")
	private int codigoPedido;

	@Column(name = "codigo_produto")
	private int produto;

	public PedidoPK() {
	}

	public PedidoPK(int codigoPedido, int produto) {
		this.codigoPedido = codigoPedido;
		this.produto = produto;
	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

}