package br.com.barcard.dao;

import java.util.Collection;

import javax.persistence.Query;

import br.com.barcard.entity.Saida;
import br.com.barcard.generic.dao.AbstDAO;

public class SaidaDAO extends AbstDAO	{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public Collection<Saida> aquiUmaQuerieEspecifica(String propriedade,Object valor){
		try {
			StringBuilder sql = new StringBuilder("from Saida");

			Query q = getEntityManager().createQuery(sql.toString());

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}