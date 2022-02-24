package br.com.landtec.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Victor
 * @since 2022-02-24
 */
public abstract class EntityManagerBuilder {

	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("landtec");
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	
}
