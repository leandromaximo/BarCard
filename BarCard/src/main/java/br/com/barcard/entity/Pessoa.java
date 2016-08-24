package br.com.barcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.com.barcard.entity.generic.ItfEntidade;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="PESSOA")
public class Pessoa implements ItfEntidade{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PESSOA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="NR_TELEFONE", nullable=true, length=14)
	private String telefone;
	
	@JoinColumn(name = "ID_PESSOA_FISICA", nullable=false)
	@Cascade(CascadeType.ALL)
	@OneToOne(fetch=FetchType.LAZY)
	private PessoaFisica pessoaFisica = new PessoaFisica();
	
	@JoinColumn(name = "ID_CARTAO", nullable=true)
	@Cascade(CascadeType.ALL)
	@OneToOne(fetch=FetchType.EAGER)
	private Cartao cartao = new Cartao();

	public Pessoa(){
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
}
