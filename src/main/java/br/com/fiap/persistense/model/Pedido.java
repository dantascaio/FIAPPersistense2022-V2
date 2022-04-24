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
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer codigo;

	@ManyToMany
	@JoinTable(
		name = "pedido_produto", 
		joinColumns = @JoinColumn(name = "codigo_pedido"), 
		inverseJoinColumns = @JoinColumn(name = "codigo_produto"))
	private Set<Produto> produtos = new LinkedHashSet<Produto>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@Column(name = "quantidade_produtos")
	private int quatidadeProdutos;

}