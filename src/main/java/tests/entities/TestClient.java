package tests.entities;

import br.com.landtec.DAO.ClientDao;
import br.com.landtec.entities.Client;
import br.com.landtec.entities.Contract;
import br.com.landtec.entities.ItemContract;
import br.com.landtec.util.EntityManagerBuilder;

public class TestClient {
	public static void main(String[] args) {
		
		
		ClientDao dao = new ClientDao(EntityManagerBuilder.getEntityManager());
		Client cliente = dao.findClient(1l);

		
		
		
		
	}
}