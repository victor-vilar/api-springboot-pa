package tests.entities;

import br.com.landtec.DAO.ClientDao;
import br.com.landtec.entities.Client;
import br.com.landtec.entities.Supervisor;
import br.com.landtec.util.EntityManagerBuilder;

public class TestInsertSupervisor {

	public static void main(String[] args) {
		
		Supervisor supervisor = new Supervisor();
		ClientDao clientDao = new ClientDao(EntityManagerBuilder.getEntityManager());
		Client client = clientDao.findClient(1l);
		
		
		//setting supervisor
		supervisor.setName("Ana Paula Mondaine");
		supervisor.setEmail("ana.mon@gov.br");
		supervisor.setRole("Tenente");
		supervisor.setPhoneNumber("2165954121");
		
		client.addNewSupervisor(supervisor);
		
		clientDao.updateClient(client);
		
		
		
		
		
	}
	
	
}
