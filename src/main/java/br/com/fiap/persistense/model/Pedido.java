package br.com.fiap.persistense.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoPK pedidoPK;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_cli")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nr_seql_end")
	private Endereco endereco;

	@JoinColumn(name = "qtde_prd_pedidos")
	private int quatidade;

	public PedidoPK getPedidoPK() {
		return pedidoPK;
	}

	public void setPedidoPK(PedidoPK pedidoPK) {
		this.pedidoPK = pedidoPK;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getQuatidade() {
		return quatidade;
	}

	public void setQuatidade(int quatidade) {
		this.quatidade = quatidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}