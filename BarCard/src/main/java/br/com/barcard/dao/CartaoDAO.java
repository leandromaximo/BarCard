package br.com.barcard.dao;

import java.util.Collection;

import javax.persistence.Query;

import br.com.barcard.entity.Cartao;
import br.com.barcard.entity.Pessoa;
import br.com.barcard.generic.dao.AbstDAO;

public class CartaoDAO extends AbstDAO	{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public Collection<Cartao> aquiUmaQuerieEspecifica(String propriedade,Object valor){
		try {
			StringBuilder sql = new StringBuilder("from Cartao");

			Query q = getEntityManager().createQuery(sql.toString());

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Cartao buscarPorPessoa(Pessoa p){
		try {
			StringBuilder sql = new StringBuilder("from Cartao ");
			sql.append(" where pessoa = :pessoa");

			Query q = getEntityManager().createQuery(sql.toString());
			
			q.setParameter("pessoa", p);
			
			return (Cartao) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}