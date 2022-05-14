package tests.entities;

import java.util.List;

import br.com.empresa.DAO.ClientDao;
import br.com.empresa.DAO.ContractDao;
import br.com.empresa.entities.Client;
import br.com.empresa.entities.Contract;
import br.com.empresa.entities.ItemContract;
import br.com.empresa.util.EntityManagerBuilder;

public class TestContract2 {

	
	/**
	 * Test the new method of contract dao findContractWithClient
	 * @param args
	 */
		public static void main(String[] args) {
			
			//declaring variables
			Client client;
			Contract contract;
			
			//declaring daos;
			ClientDao clientDao = new ClientDao(EntityManagerBuilder.getEntityManager());
			ContractDao contractDao = new ContractDao(EntityManagerBuilder.getEntityManager());
			
			contract = contractDao.findContract(1l);
			
			//List<Contract> contracts = contractDao.getAllContracts();
			//System.out.println(contract.getNumber());
			//System.out.println(contract.getCliente().getNameCompanyName());
			
			contract.getItens().forEach(e -> System.out.println(e));
			 
		}
	
	
}
