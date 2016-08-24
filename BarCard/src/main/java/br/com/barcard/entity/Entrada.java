package br.com.barcard.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcard.entity.generic.ItfEntidade;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="ENTRADA")
public class Entrada implements ItfEntidade{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ENTRADA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PRODUTO")
	private Produto produto;
	
	@NotNull
	@Column(name="VL_CUSTO", nullable=false)
	private BigDecimal vlCusto;
	
	@NotNull
	@Column(name="NR_QUANTIDADE", nullable=false)
	private BigDecimal quantidade;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_ENTRADA", nullable=false)
	private Date dtEntrada;
	
	public Entrada(){
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getVlCusto() {
		return vlCusto;
	}

	public void setVlCusto(BigDecimal vlCusto) {
		this.vlCusto = vlCusto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	
}
