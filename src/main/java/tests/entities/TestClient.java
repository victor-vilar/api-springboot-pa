package tests.entities;

import br.com.landtec.DAO.ClientDao;
import br.com.landtec.entities.Client;
import br.com.landtec.util.EntityManagerBuilder;

public class TestClient {
	public static void main(String[] args) {
		
		
		Client cliente = new Client("INSTITUTO MILITAR DE ENGENHARIA");
		cliente.setCpfCnpj("08454836000178");
		
		ClientDao dao = new ClientDao(EntityManagerBuilder.getEntityManager());
		dao.saveClient(cliente);
		
		
		
	}
}
