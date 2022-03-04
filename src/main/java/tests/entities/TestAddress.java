package tests.entities;

import javax.persistence.EntityManager;

import br.com.landtec.entities.Address;
import br.com.landtec.util.EntityManagerBuilder;

public class TestAddress {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerBuilder.getEntityManager();
		
		Address endereco1 = new Address();
		Address endereco2 = new Address();
		
		endereco1.setAddressName("Rua 1");
		endereco1.setAddressNumber("1");
		
		
		em.getTransaction().begin();
		em.persist(endereco1);
		em.persist(endereco2);
		em.getTransaction().commit();
		em.close();

	}

}
