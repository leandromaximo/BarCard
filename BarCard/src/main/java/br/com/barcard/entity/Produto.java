package br.com.barcard.entity;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	@Column(name="CAMINHO_IMAGEM", nullable=true, length=200)
	private String caminhoImagem;
	
	@Fetch(value = FetchMode.SUBSELECT)
	@Cascade(CascadeType.ALL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "produto")
	private Collection<Entrada> lstEntrada;
	
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "produto")
	private Collection<Saida> lstSaida;
	
	@Transient
	private BigDecimal qntEstoque;
	
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

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public Collection<Entrada> getLstEntrada() {
		return lstEntrada;
	}

	public void setLstEntrada(Collection<Entrada> lstEntrada) {
		this.lstEntrada = lstEntrada;
	}

	public Collection<Saida> getLstSaida() {
		return lstSaida;
	}

	public void setLstSaida(Collection<Saida> lstSaida) {
		this.lstSaida = lstSaida;
	}

	public BigDecimal getQntEstoque() {
		BigDecimal vlTot = BigDecimal.ZERO;
		BigDecimal vlEntrada = BigDecimal.ZERO;
		BigDecimal vlSaida = BigDecimal.ZERO;
		for (Entrada entrada : lstEntrada) {
			vlEntrada = entrada.getQuantidade().add(vlEntrada);
		}
		for (Saida saida : lstSaida) {
			vlSaida = saida.getQntSaida().add(vlSaida);
		}
		vlTot = vlEntrada.subtract(vlSaida);
		return vlTot;
	}

}
