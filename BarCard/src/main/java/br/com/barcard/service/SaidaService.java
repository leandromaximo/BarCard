package br.com.barcard.service;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.criterion.Order;

import br.com.barcard.dao.SaidaDAO;
import br.com.barcard.entity.Saida;
import br.com.barcard.generic.service.AbstService;

public class SaidaService extends AbstService{

	private static final long serialVersionUID = 1L;
	
	@Inject
	SaidaDAO saidaDAO;
	
	public void regraDeNegocioAqui(Saida s) {
		//regraDeNegocioAqui
		try {
			saidaDAO.incluir(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Saida s) {
		try {
			saidaDAO.incluir(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Saida s) {
		try {
			saidaDAO.excluir(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Saida s) {
		try {
			saidaDAO.saveOrUpdate(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refresh(Saida s){
		saidaDAO.refresh(s);
	}
	
	
	public Collection<Saida> regraDeNegocioBuscar(Saida s) {
		//regraDeNegocioAqui
		try {
			return saidaDAO.findAll(Saida.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<Saida> outraRegraDeNegocioEspecificaBuscar(Saida s) {
		//regraDeNegocioAqui
		return saidaDAO.aquiUmaQuerieEspecifica("",null);
	}
	
	public Collection<Saida> buscarPorCodigoCartao(String codigo){
		return saidaDAO.buscarPorCodigoCartao(codigo);
	}
	
	public Collection<Saida> findAllByProperty() throws Exception{
		return saidaDAO.findAllByProperty(Saida.class,"stAtivo",true,Order.desc("id"));
	}
	
}
