package br.com.barcard.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.barcard.dao.CartaoDAO;
import br.com.barcard.entity.Cartao;
import br.com.barcard.entity.Pessoa;
import br.com.barcard.generic.service.AbstService;

public class CartaoService extends AbstService{

	private static final long serialVersionUID = 1L;
	
	@Inject
	CartaoDAO cartaoDAO;
	
	public void regraDeNegocioAqui(Cartao c) {
		//regraDeNegocioAqui
		try {
			cartaoDAO.incluir(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Cartao c) {
		try {
			cartaoDAO.incluir(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Cartao c) {
		try {
			cartaoDAO.excluir(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Cartao c) {
		try {
			cartaoDAO.saveOrUpdate(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Collection<Cartao> regraDeNegocioBuscar(Cartao c) {
		//regraDeNegocioAqui
		try {
			return cartaoDAO.findAll(Cartao.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<Cartao> outraRegraDeNegocioEspecificaBuscar(Cartao c) {
		//regraDeNegocioAqui
		return cartaoDAO.aquiUmaQuerieEspecifica("",null);
	}
	
	public Cartao buscarPorPessoa(Pessoa p){
		return cartaoDAO.buscarPorPessoa(p);
	}
	
	public Cartao buscarPorCodigo(String codigo){
		return cartaoDAO.buscarPorCodigo(codigo);
	}

}
