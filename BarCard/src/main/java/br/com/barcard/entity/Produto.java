package br.com.barcard.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.barcard.entity.generic.ItfEntidade;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="PRODUTO")
public class Produto implements ItfEntidade{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PRODUTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="DS_NOME_PRODUTO", nullable=false, length=60)
	private String nome;
	
	@Column(name="DS_PRODUTO", nullable=true, length=200)
	private String descricao;
	
	@NotNull
	@Column(name="VL_VENDA", nullable=false)
	private BigDecimal vlVenda;
	
	@Fetch(value = FetchMode.SUBSELECT)
	@Cascade(CascadeType.ALL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "produto")
	private List<Entrada> lstEntrada;
	
	@Fetch(value = FetchMode.SUBSELECT)
	@Cascade(CascadeType.ALL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "produto")
	private List<Saida> lstSaida;
	
	public Produto(){
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getVlVenda() {
		return vlVenda;
	}

	public void setVlVenda(BigDecimal vlVenda) {
		this.vlVenda = vlVenda;
	}

	public List<Entrada> getLstEntrada() {
		return lstEntrada;
	}

	public void setLstEntrada(List<Entrada> lstEntrada) {
		this.lstEntrada = lstEntrada;
	}

	public List<Saida> getLstSaida() {
		return lstSaida;
	}

	public void setLstSaida(List<Saida> lstSaida) {
		this.lstSaida = lstSaida;
	}
	
}
