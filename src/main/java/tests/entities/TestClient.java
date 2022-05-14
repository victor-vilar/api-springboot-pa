package tests.entities;

import br.com.empresa.DAO.ClientDao;
import br.com.empresa.entities.Client;
import br.com.empresa.entities.Contract;
import br.com.empresa.entities.ItemContract;
import br.com.empresa.util.EntityManagerBuilder;

public class TestClient {
	public static void main(String[] args) {
		
		
		ClientDao dao = new ClientDao(EntityManagerBuilder.getEntityManager());
		Client cliente = new Client("Teste de Safadeza");
		cliente.setCpfCnpj("12525299701");
		dao.saveClient(cliente);
		
		
		
		
	}
}
