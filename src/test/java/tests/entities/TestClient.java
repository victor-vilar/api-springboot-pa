package tests.entities;

import com.victorvilar.projetoempresa.DAO.ClientDao;
import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.util.EntityManagerBuilder;

public class TestClient {
	public static void main(String[] args) {
		
		
		ClientDao dao = new ClientDao(EntityManagerBuilder.getEntityManager());
		Customer cliente = new Customer("Teste de Safadeza");
		cliente.setCpfCnpj("12525299701");
		dao.saveClient(cliente);
		
		
		
		
	}
}
