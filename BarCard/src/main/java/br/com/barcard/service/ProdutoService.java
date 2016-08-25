package br.com.barcard.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.barcard.dao.ProdutoDAO;
import br.com.barcard.entity.Produto;
import br.com.barcard.generic.service.AbstService;

public class ProdutoService extends AbstService{

	private static final long serialVersionUID = 1L;
	
	@Inject
	ProdutoDAO produtoDAO;
	
	public void regraDeNegocioAqui(Produto p) {
		//regraDeNegocioAqui
		try {
			produtoDAO.incluir(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Produto p) {
		try {
			produtoDAO.incluir(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Produto p) {
		try {
			produtoDAO.alterar(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Produto p) {
		try {
			produtoDAO.excluir(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refresh(Produto p){
		produtoDAO.refresh(p);
	}
	
	
	public Collection<Produto> regraDeNegocioBuscar(Produto p) {
		//regraDeNegocioAqui
		try {
			return produtoDAO.findAll(Produto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<Produto> outraRegraDeNegocioEspecificaBuscar(Produto p) {
		//regraDeNegocioAqui
		return produtoDAO.aquiUmaQuerieEspecifica("",null);
	}
	
	public Collection<Produto> buscarPorNome(String nome){
		return produtoDAO.buscarPorNome(nome);
	}
}
