package br.com.barcard.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.barcard.dao.EntradaDAO;
import br.com.barcard.entity.Entrada;
import br.com.barcard.entity.Produto;
import br.com.barcard.generic.service.AbstService;

public class EntradaService extends AbstService{

	private static final long serialVersionUID = 1L;
	
	@Inject
	EntradaDAO entradaDAO;
	
	public void regraDeNegocioAqui(Entrada e) {
		//regraDeNegocioAqui
		try {
			entradaDAO.incluir(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void salvar(Entrada e) {
		try {
			entradaDAO.incluir(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public Collection<Entrada> regraDeNegocioBuscar(Entrada e) {
		//regraDeNegocioAqui
		try {
			return entradaDAO.findAll(Entrada.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Collection<Entrada> outraRegraDeNegocioEspecificaBuscar(Entrada e) {
		//regraDeNegocioAqui
		return entradaDAO.aquiUmaQuerieEspecifica("",null);
	}
	
	public Collection<Produto> buscarProduto(Produto e) {
		return entradaDAO.buscarProduto("",null);
	}
	
}
