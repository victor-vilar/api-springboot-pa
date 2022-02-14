package br.com.landtec.DAO;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientDao {
    EntityManager em;

    public ClientDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("landtec");
        this.em = emf.createEntityManager();

    }

    


}
