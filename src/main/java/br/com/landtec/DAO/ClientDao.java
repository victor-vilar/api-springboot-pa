package br.com.landtec.DAO;

import br.com.landtec.entities.Client;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class to manager Client in database
 * @since 2022-02-14
 * @author Victor Vilar
 */

public class ClientDao {
    EntityManager em;

    public ClientDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("landtec");
        this.em = emf.createEntityManager();

    }

    public void saveClient(Client client){
        this.em.getTransaction().begin();
        this.em.persist(client);
        this.em.getTransaction().commit();
        this.em.close();
    }





}
