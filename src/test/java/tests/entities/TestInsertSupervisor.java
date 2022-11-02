package tests.entities;

import com.victorvilar.projetoempresa.DAO.ClientDao;
import com.victorvilar.projetoempresa.model.Client;
import com.victorvilar.projetoempresa.model.Supervisor;
import com.victorvilar.projetoempresa.util.EntityManagerBuilder;

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
