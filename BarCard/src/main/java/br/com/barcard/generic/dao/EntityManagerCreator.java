package br.com.barcard.generic.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.barcard.util.Constantes;

public class EntityManagerCreator {
	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT);

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return em;
	}
	
	public void closeEntityManager(@Disposes EntityManager entityManager) {
		try {
			entityManager.getTransaction().commit();			
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
