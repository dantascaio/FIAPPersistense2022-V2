package br.com.fiap.persistense.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@SequenceGenerator(name = "SEQ_PEDIDO", sequenceName = "S_PEDIDO", allocationSize = 1)
@Table(name = "pedido")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // APAGAR?
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PEDIDO")
	@Column(name = "codigo")
	private Integer codigo;

	@ManyToMany
	@JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "codigo_pedido"), inverseJoinColumns = @JoinColumn(name = "codigo_produto"))
	private Set<Produto> produtos = new LinkedHashSet<Produto>();

	// @JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@Column(name = "quantidade_produtos")
	private int quatidadeProdutos;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
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

	public int getQuatidadeProdutos() {
		return quatidadeProdutos;
	}

	public void setQuatidadeProdutos(int quatidadeProdutos) {
		this.quatidadeProdutos = quatidadeProdutos;
	}

	@Override
	public String toString() {
		return "Pedido [cliente=" + cliente + ", codigo=" + codigo + ", endereco=" + endereco + ", produtos=" + produtos
				+ ", quatidadeProdutos=" + quatidadeProdutos + "]";
	}

}