package br.com.barcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

import br.com.barcard.entity.generic.ItfEntidade;

@Entity
@Table(name="PESSOA_FISICA")
public class PessoaFisica implements ItfEntidade{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PESSOA_FISICA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="DS_NOME", nullable=true, length=60)
	private String nome;
	
	@NotNull
	@Column(name="NR_CPF", nullable=true, length=14)
	private String cpf;
	
	public PessoaFisica(){
		
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
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
