package br.com.barcard.generic.dao;

import java.io.Serializable;

public interface ItfCrudDAO extends Serializable{

	public void incluir(Object entidade) throws Exception;
	
	public void alterar(Object entidade) throws Exception;
//	
//	
//	public <E> E find(Class<E> entityClass, Object pk);
//	
//	public T find(Object id);
//	
//	public void excluir(Object entidade);
//	
//	public Collection<T> findAll();
//	
//	public <E> Collection<E> findAll(Class<E> entityClass);
//	
//	public <E> Collection<E> findAllByProperty(Class<E> entityClass, String propriedade,Object valor);
//	
//	public <E> Collection<E> findAllByProperty(Class<E> entityClass, String propriedade,Object valor,Order orderBy);
//	
//	public void flush();
//	
//	public <E> Collection<E> findAll(Class<E> entityClass,Order orderBy);
//	
//	public Collection<T> findAll(Order orderBy);
//	
//	public Collection<T> findAllByProperty(String propriedade,Object valor,Order orderBy);
//	
//	public <E> E findByProperty(Class<E> entityClass,String propriedade,Object valor);
//	
//	public T findByProperty(String propriedade,Object valor);
//	
//	public void refresh(Object obj);
//	
//	public void removeAll(Class<?> class1, String param,
//			Object paramValue);
//	
//	public void clear();
}
