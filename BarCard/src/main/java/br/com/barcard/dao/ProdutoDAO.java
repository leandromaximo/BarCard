package br.com.barcard.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import br.com.barcard.entity.Produto;
import br.com.barcard.generic.dao.AbstDAO;

public class ProdutoDAO extends AbstDAO<Produto>	{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public Collection<Produto> aquiUmaQuerieEspecifica(String propriedade,Object valor){
		try {
			StringBuilder sql = new StringBuilder("from Produto order by nome");

			Query q = getEntityManager().createQuery(sql.toString());

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<Produto> buscarPorNome(String nome){
		try {
			StringBuilder sql = new StringBuilder("from Produto ");
			sql.append(" where nome like '%");
			sql.append(nome);
			sql.append("%'");
			sql.append("order by nome");

			Query q = getEntityManager().createQuery(sql.toString());
			
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}