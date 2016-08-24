package br.com.barcard.dao;

import java.util.Collection;
import java.util.List;

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
	
	public List<Saida> buscarPorCodigoCartao(String codigo){
		try {
			StringBuilder sql = new StringBuilder("from Saida ");
			sql.append(" where pessoa.cartao.cdCartao = :codigo");
			sql.append(" and stAtivo = :stAtivo");

			Query q = getEntityManager().createQuery(sql.toString());
			
			q.setParameter("codigo", codigo);
			q.setParameter("stAtivo", true);
			
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}