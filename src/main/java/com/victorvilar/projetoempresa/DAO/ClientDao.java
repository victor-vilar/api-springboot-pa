package com.victorvilar.projetoempresa.DAO;

import com.victorvilar.projetoempresa.domain.Client;

import javax.persistence.EntityManager;

import java.util.List;

/**
 * Class to manager Client in database
 * @since 2022-02-14
 * @author Victor Vilar
 */
@Deprecated
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
