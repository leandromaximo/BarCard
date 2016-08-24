package br.com.barcard.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import br.com.barcard.entity.Entrada;
import br.com.barcard.generic.dao.AbstDAO;

public class EntradaDAO extends AbstDAO	{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public Collection<Entrada> aquiUmaQuerieEspecifica(String propriedade,Object valor){
		try {
			StringBuilder sql = new StringBuilder("from Entrada");

			Query q = getEntityManager().createQuery(sql.toString());

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Entrada> buscarPorNome(String nome){
		try {
			StringBuilder sql = new StringBuilder("from Entrada ");
			sql.append(" where produto.nome like '%");
			sql.append(nome);
			sql.append("%'");
			sql.append("order by produto.nome");

			Query q = getEntityManager().createQuery(sql.toString());
			
			
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}