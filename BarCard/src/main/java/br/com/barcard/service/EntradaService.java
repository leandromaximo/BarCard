package br.com.barcard.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.barcard.dao.EntradaDAO;
import br.com.barcard.entity.Entrada;
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
	
	public void excluir(Entrada e) {
		try {
			entradaDAO.excluir(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void alterar(Entrada e) {
		try {
			entradaDAO.saveOrUpdate(e);
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
	
}
