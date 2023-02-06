package tests.entities;

import java.time.LocalDate;

import com.victorvilar.projetoempresa.DAO.ClientDao;
import com.victorvilar.projetoempresa.DAO.EquipamentDao;
import com.victorvilar.projetoempresa.DAO.ResidueTypeDao;
import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.Equipament;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.domain.ResidueType;
import com.victorvilar.projetoempresa.util.EntityManagerBuilder;

public class TestContract {

		public static void main(String[] args) {
			
			//declaring variables
			Customer customer;
			Equipament equipament;
			ResidueType residue;
			
			//setting contract
			Contract contract = new Contract();
			contract.setNumber("05/2021 - Teste");
			contract.setEndDate(LocalDate.now());
		
			
			//declaring daos;
			ClientDao clientDao = new ClientDao(EntityManagerBuilder.getEntityManager());
			EquipamentDao equipamentDao = new EquipamentDao(EntityManagerBuilder.getEntityManager());
			ResidueTypeDao residueDao = new ResidueTypeDao(EntityManagerBuilder.getEntityManager());
			
			//set variables
			customer = clientDao.findClient(1l);
			
			//item1
			equipament = equipamentDao.getAllEquipaments().get(0);
			residue = residueDao.getAllResidues().get(0);
			contract.addNewItem(new ItemContract(residue,equipament,200.00,157.00));
			
			//item2
			equipament = equipamentDao.getAllEquipaments().get(1);
			residue = residueDao.getAllResidues().get(1);
			contract.addNewItem(new ItemContract(residue,equipament,100.00,800.00));
			
			
			//add new contract to client
			customer.addNewContract(contract);
			
			
			//updating client
			clientDao.updateClient(customer);
			
			
			
		}
	
	
}
