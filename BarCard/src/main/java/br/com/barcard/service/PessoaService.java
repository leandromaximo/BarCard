package br.com.barcard.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.barcard.dao.PessoaDAO;
import br.com.barcard.entity.Pessoa;
import br.com.barcard.generic.service.AbstService;

public class PessoaService extends AbstService{

	private static final long serialVersionUID = 1L;
	
	@Inject
	PessoaDAO pessoaDAO;
	
	public void regraDeNegocioAqui(Pessoa p) {
		//regraDeNegocioAqui
		try {
			pessoaDAO.incluir(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Pessoa p) {
		try {
			pessoaDAO.incluir(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Pessoa p) {
		try {
			pessoaDAO.excluir(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Pessoa p) {
		try {
			pessoaDAO.saveOrUpdate(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Collection<Pessoa> regraDeNegocioBuscar(Pessoa p) {
		//regraDeNegocioAqui
		try {
			return pessoaDAO.findAll(Pessoa.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<Pessoa> outraRegraDeNegocioEspecificaBuscar(Pessoa p) {
		//regraDeNegocioAqui
		return pessoaDAO.aquiUmaQuerieEspecifica("",null);
	}
	
	public Pessoa buscarPorCodigoCartao(String codigo){
		return pessoaDAO.buscarPorCodigoCartao(codigo);
	}
	
	public Collection<Pessoa> buscarPorNome(String nome){
		return pessoaDAO.buscarPorNome(nome);
	}
	
}
