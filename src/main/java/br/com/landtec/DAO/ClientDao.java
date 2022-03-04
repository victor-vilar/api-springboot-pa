package br.com.landtec.DAO;

import br.com.landtec.entities.Client;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.List;

/**
 * Class to manager Client in database
 * @since 2022-02-14
 * @author Victor Vilar
 */

public class ClientDao {
    EntityManager em;

    public ClientDao(EntityManager em){
        this.em = em;

    }

    public void saveClient(Client client){
        this.em.getTransaction().begin();
        this.em.persist(client);
        this.em.getTransaction().commit();
    }

    public List<Client> getAllClients(){
        String sql = "SELECT c From Client c";
        List<Client> clients = this.em.createQuery(sql,Client.class).getResultList();
        return clients;
    }

	public Client findClient(long l) {
		return this.em.find(Client.class, l);
	}
	
	/**
	 * using criteria
	 * @param name
	 * @param id
	 * @return
	 */
	public Client searchClientbyName(String name) {
		String jpql = "SELECT c FROM Client c where c.nameCompanyName = :name";
		return this.em.createQuery(jpql, Client.class ).setParameter("name", name).getSingleResult();
	}

	public void updateClient(Client cliente) {
		this.em.getTransaction().begin();
		this.em.merge(cliente);
		this.em.getTransaction().commit();
		
	}
    
   





}
