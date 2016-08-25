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
@Table(name="SAIDA")
public class Saida implements ItfEntidade{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_SAIDA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="VL_SAIDA", nullable=false)
	private BigDecimal vlVenda;
	
	@NotNull
	@Column(name="NR_QUANTIDADE", nullable=false)
	private BigDecimal qntSaida;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_SAIDA", nullable=false)
	private Date dtSaida;
	
	@NotNull
	@Column(name = "ST_ATIVO", nullable=false, columnDefinition="boolean default true")
	private Boolean stAtivo;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PRODUTO", nullable=false)
	private Produto produto;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PESSOA", nullable=false)
	private Pessoa pessoa;
	
	public Saida(){
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getVlVenda() {
		return vlVenda;
	}

	public void setVlVenda(BigDecimal vlVenda) {
		this.vlVenda = vlVenda;
	}

	public BigDecimal getQntSaida() {
		return qntSaida;
	}

	public void setQntSaida(BigDecimal qntSaida) {
		this.qntSaida = qntSaida;
	}

	public Date getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public Boolean getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(Boolean stAtivo) {
		this.stAtivo = stAtivo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
