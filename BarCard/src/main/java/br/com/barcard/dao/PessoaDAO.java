package br.com.barcard.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import br.com.barcard.entity.Pessoa;
import br.com.barcard.generic.dao.AbstDAO;

public class PessoaDAO extends AbstDAO	{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public Collection<Pessoa> aquiUmaQuerieEspecifica(String propriedade,Object valor){
		try {
			StringBuilder sql = new StringBuilder("from Pessoa order by pessoaFisica.nome");

			Query q = getEntityManager().createQuery(sql.toString());

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Pessoa buscarPorCodigoCartao(String codigo){
		try {
			StringBuilder sql = new StringBuilder("from Pessoa ");
			sql.append(" where cartao.cdCartao = :codigo");

			Query q = getEntityManager().createQuery(sql.toString());
			
			q.setParameter("codigo", codigo);
			
			return (Pessoa) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<Pessoa> buscarPorNome(String nome){
		try {
			StringBuilder sql = new StringBuilder("from Pessoa ");
			sql.append(" where pessoaFisica.nome like '%");
			sql.append(nome);
			sql.append("%'");
			sql.append(" order by pessoaFisica.nome");

			Query q = getEntityManager().createQuery(sql.toString());
			
			
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<Pessoa> buscarPorVendaAtivaInativa(Boolean stFechamento){
		Collection<Pessoa> lst = new ArrayList<Pessoa>();
		try {
			StringBuilder sql = new StringBuilder("Select distinct p from Pessoa p ");
			sql.append(" inner join p.lstSaida s ");
			sql.append(" where s.stFechamento = :stFechamento");

			Query q = getEntityManager().createQuery(sql.toString());
			
			q.setParameter("stFechamento", stFechamento);
			
			lst = q.getResultList();
			
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}