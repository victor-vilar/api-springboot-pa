package br.com.landtec.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class EntityManagerBuilder {

	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("landtec");
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	
}
