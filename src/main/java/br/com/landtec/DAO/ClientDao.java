package br.com.landtec.DAO;

import br.com.landtec.entities.Client;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

	public void updateClient(Client cliente) {
		this.em.getTransaction().begin();
		this.em.merge(cliente);
		this.em.getTransaction().commit();
		
	}
    
   





}
