package tests.entities;

import com.victorvilar.projetoempresa.DAO.ClientDao;
import com.victorvilar.projetoempresa.DAO.ContractDao;
import com.victorvilar.projetoempresa.domain.Client;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.util.EntityManagerBuilder;

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
