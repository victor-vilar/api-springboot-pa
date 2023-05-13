package tests.entities;

import com.victorvilar.projetoempresa.DAO.ClientDao;
import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.util.EntityManagerBuilder;

public class TestClient {
	public static void main(String[] args) {
		
		
	Customer customer = new Customer.CustomerBuilder()
			.cpfCnpj("12525299701")
			.nameCompanyName("Victor")
			.build();
		
	System.out.println(customer);
		
		
	}
}
