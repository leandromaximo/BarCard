package br.com.barcard.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.barcard.dao.SaidaDAO;
import br.com.barcard.entity.Produto;
import br.com.barcard.entity.Saida;
import br.com.barcard.generic.service.AbstService;

public class SaidaService extends AbstService{

	private static final long serialVersionUID = 1L;
	
	@Inject
	SaidaDAO saidaDAO;
	
	public void regraDeNegocioAqui(Saida e) {
		//regraDeNegocioAqui
		try {
			saidaDAO.incluir(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void salvar(Saida e) {
		try {
			saidaDAO.incluir(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public Collection<Saida> regraDeNegocioBuscar(Saida e) {
		//regraDeNegocioAqui
		try {
			return saidaDAO.findAll(Saida.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Collection<Saida> outraRegraDeNegocioEspecificaBuscar(Saida e) {
		//regraDeNegocioAqui
		return saidaDAO.aquiUmaQuerieEspecifica("",null);
	}
	
}
